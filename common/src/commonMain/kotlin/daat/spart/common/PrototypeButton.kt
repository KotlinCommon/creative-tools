package daat.spart.common

import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Density
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex

@Composable
fun testButton(onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val onClickState = rememberUpdatedState(onClick)
    val pressedInteraction = remember { mutableStateOf<PressInteraction.Press?>(null) }
    val isRootInScrollableContainer = isComposeRootInScrollableContainer()
    val isClickableInScrollableContainer = remember { mutableStateOf(true) }
    val delayPressInteraction = rememberUpdatedState {
        isClickableInScrollableContainer.value || isRootInScrollableContainer()
    }
    val (focusRequester, focusRequesterModifier) = focusRequesterAndModifier()
    Box(Modifier.pointerInput(interactionSource, true) {
        detectTapAndPress(
            onPress = { offset ->
                if (true) {
                    handlePressInteraction(
                        offset,
                        interactionSource,
                        pressedInteraction,
                        delayPressInteraction
                    )
                }
            },
            onTap = {
                if (true) {
                    focusRequester.requestFocus()
                    onClickState.value.invoke()
                }
            }
        )
    })
}

@Composable
internal fun focusRequesterAndModifier(): Pair<FocusRequester, Modifier> {
    val focusRequester = remember { FocusRequester() }
    return focusRequester to Modifier.focusRequester(focusRequester)

}

@Composable
internal fun isComposeRootInScrollableContainer(): () -> Boolean = { false }

/**
 * Shortcut for cases when we only need to get press/click logic, as for cases without long press
 * and double click we don't require channelling or any other complications.
 */
suspend fun PointerInputScope.detectTapAndPress(
    onPress: suspend PressGestureScope.(Offset) -> Unit = NoPressGesture,
    onTap: ((Offset) -> Unit)? = null
) {
    val pressScope = PressGestureScopeImpl(this)
    forEachGesture {
        coroutineScope {
            pressScope.reset()
            awaitPointerEventScope {

                val down = awaitFirstDown().also { it.consume() }

                if (onPress !== NoPressGesture) {
                    launch { pressScope.onPress(down.position) }
                }

                val up = waitForUpOrCancellation()
                if (up == null) {
                    pressScope.cancel() // tap-up was canceled
                } else {
                    up.consume()
                    pressScope.release()
                    onTap?.invoke(up.position)
                }
            }
        }
    }
}

/**
 * [detectTapGestures]'s implementation of [PressGestureScope].
 */
internal class PressGestureScopeImpl(
    density: Density
) : PressGestureScope, Density by density {
    private var isReleased = false
    private var isCanceled = false
    private val mutex = Mutex(locked = false)

    /**
     * Called when a gesture has been canceled.
     */
    fun cancel() {
        isCanceled = true
        mutex.unlock()
    }

    /**
     * Called when all pointers are up.
     */
    fun release() {
        isReleased = true
        mutex.unlock()
    }

    /**
     * Called when a new gesture has started.
     */
    fun reset() {
        mutex.tryLock() // If tryAwaitRelease wasn't called, this will be unlocked.
        isReleased = false
        isCanceled = false
    }

    override suspend fun awaitRelease() {
        if (!tryAwaitRelease()) {
            throw GestureCancellationException("The press gesture was canceled.")
        }
    }

    override suspend fun tryAwaitRelease(): Boolean {
        if (!isReleased && !isCanceled) {
            mutex.lock()
        }
        return isReleased
    }
}

internal val TapIndicationDelay: Long = 0L
internal suspend fun PressGestureScope.handlePressInteraction(
    pressPoint: Offset,
    interactionSource: MutableInteractionSource,
    pressedInteraction: MutableState<PressInteraction.Press?>,
    delayPressInteraction: State<() -> Boolean>
) {
    coroutineScope {
        val delayJob = launch {
            if (delayPressInteraction.value()) {
                delay(TapIndicationDelay)
            }
            val pressInteraction = PressInteraction.Press(pressPoint)
            interactionSource.emit(pressInteraction)
            pressedInteraction.value = pressInteraction
        }
        val success = tryAwaitRelease()
        if (delayJob.isActive) {
            delayJob.cancelAndJoin()
            // The press released successfully, before the timeout duration - emit the press
            // interaction instantly. No else branch - if the press was cancelled before the
            // timeout, we don't want to emit a press interaction.
            if (success) {
                val pressInteraction = PressInteraction.Press(pressPoint)
                val releaseInteraction = PressInteraction.Release(pressInteraction)
                interactionSource.emit(pressInteraction)
                interactionSource.emit(releaseInteraction)
            }
        } else {
            pressedInteraction.value?.let { pressInteraction ->
                val endInteraction = if (success) {
                    PressInteraction.Release(pressInteraction)
                } else {
                    PressInteraction.Cancel(pressInteraction)
                }
                interactionSource.emit(endInteraction)
            }
        }
        pressedInteraction.value = null
    }
}

val NoPressGesture: suspend PressGestureScope.(Offset) -> Unit = { }