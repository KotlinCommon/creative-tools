package engine.tools

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.produce
import kotlin.coroutines.EmptyCoroutineContext

@OptIn(ExperimentalCoroutinesApi::class)
fun runBlockingTest(test: suspend CoroutineScope.() -> Unit) =
    CoroutineScope(EmptyCoroutineContext).produce<Unit>(block = test)