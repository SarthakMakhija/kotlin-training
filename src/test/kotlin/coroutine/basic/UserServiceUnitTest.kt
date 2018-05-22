package coroutine.basic

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import kotlinx.coroutines.experimental.runBlocking

class UserServiceUnitTest : FunSpec() {

    init {
        test("should return all users") {
            val userService   = UserService()
            val deferredUsers = userService.findAll()

            runBlocking {
                val users = deferredUsers.await()
                users shouldBe listOf(User("John"), User("Martin"))
            }
        }
    }
}