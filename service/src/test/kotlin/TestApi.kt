import com.pqixing.api.GtApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class TestApi {
    val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testApi() {
        GtApi.init("3a811a87d010222d1d8df4d79d297b7f", "test", "pqixing", "pqixing")
        MainScope().launch {
            val content = GtApi.queryContent("asessts/apks/helper-test.apk")
            println("---------$content")
            delay(300)
        }
    }
}