import framework.driver.AutomateDriver
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeSuite
import util.EnvironmentManager.platform
import util.getModule

open class BaseTest : KoinComponent {

    protected val automateDriver by inject<AutomateDriver>()

    @BeforeSuite
    fun initModule() {
        startKoin {
            modules(getModule(platform))
        }
    }

    @BeforeMethod
    fun initDriver() {
        automateDriver.initDriver()
    }

    @AfterMethod(description = "Screenshot | Video", alwaysRun = true)
    fun afterTest(result: ITestResult) {
        automateDriver.driver.quit()
    }
}
