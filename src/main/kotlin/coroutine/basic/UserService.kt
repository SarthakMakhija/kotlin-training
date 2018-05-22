package coroutine.basic

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import java.util.concurrent.TimeUnit

class UserService {

    fun findAll(): Deferred<List<User>> {
        return async(CommonPool) {
            delay(5, TimeUnit.SECONDS)
            listOf(User("John"), User("Martin"))
        }
    }
}