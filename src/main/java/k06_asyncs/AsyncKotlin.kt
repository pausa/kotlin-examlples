package k06_asyncs

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import kotlin.random.Random

class AsyncKotlin {
    private val log = KotlinLogging.logger { }

    fun runnable(): Unit =
        if (Random.Default.nextBoolean())
            log.info { "you are lucky!" }
        else
            throw IllegalArgumentException("you are unlucky!")

    fun expensive(): Int = Random.Default.nextInt()

    fun next(i: Int): Int = i * i

    fun example() = runBlocking {
        try {
            val runnable = launch { runnable() }
            log.info { "started runnable" }
            runnable.join()

            val expensive = async {
                expensive().let(::next)
                log.info { "Done processing" }
            }
            log.info { "started expensive" }
            val result = expensive.await()
            log.info { "result $result" }

        } catch (e: CancellationException) {
            log.error { "Thread was interrupted" }
        } catch (e: IllegalArgumentException) {
            log.error { e.message }
        } catch (e: Error) {
            log.error(e) { "Anything could've happen" }
        }
    }


}