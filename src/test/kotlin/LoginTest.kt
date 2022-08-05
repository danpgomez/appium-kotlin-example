import org.testng.annotations.Test
import robot.WelcomeScreenRobot

class LoginTest : BaseTest() {

    private val welcomeRobot = WelcomeScreenRobot()

    @Test(description = "User can log in with valid email and password")
    fun logInUsingValidEmailAndPassword() {
        welcomeRobot.clickLoginOnWelcomeScreen()
    }
}
