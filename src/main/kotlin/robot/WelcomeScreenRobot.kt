package robot

import org.openqa.selenium.WebElement

class WelcomeScreenRobot : BaseRobot() {

    private val loginButton: WebElement get() = driver.findElementById("button")

    fun clickLoginOnWelcomeScreen(): WelcomeScreenRobot {
        loginButton.click()
        return this
    }
}
