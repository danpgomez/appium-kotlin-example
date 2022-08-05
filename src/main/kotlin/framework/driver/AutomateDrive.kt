package framework.driver

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import framework.SeleniumGridManager
import io.appium.java_client.AppiumBy
import org.openqa.selenium.By
import java.net.URL
import java.time.Duration

interface AutomateDriver {
    var driver: AppiumDriver
    fun initDriver()

    fun findElementById(id: String): WebElement

    fun findElementsById(id: String): List<WebElement>

    fun findElementAccessibilityById(id: String): WebElement

    fun findElementsAccessibilityById(id: String): List<WebElement>

    fun findElementByXpath(xPath: String): WebElement

    fun findElementsByXpath(xPath: String): List<WebElement>

    fun findElementByText(text: String): WebElement

    fun findElementByPartialText(text: String): WebElement
}

abstract class BaseAutomateDriver: AutomateDriver {
    override var driver: AppiumDriver by ThreadLocalDelegate.lateinit()

    protected fun setImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20))
    }

    override fun findElementAccessibilityById(id: String): WebElement {
        return driver.findElement(AppiumBy.ByAccessibilityId(id))
    }

    override fun findElementsAccessibilityById(id: String): List<WebElement> {
        return driver.findElements(AppiumBy.ByAccessibilityId(id))
    }

    override fun findElementByXpath(xPath: String): WebElement {
        return driver.findElement(By.xpath(xPath))
    }

    override fun findElementsByXpath(xPath: String): List<WebElement> {
        return driver.findElements(By.xpath(xPath))
    }

    override fun findElementByText(text: String): WebElement {
        return driver.findElement(By.linkText(text))
    }

    override fun findElementByPartialText(text: String): WebElement {
        return driver.findElement(By.partialLinkText(text))
    }
}

class AndroidAutomateDriver: BaseAutomateDriver() {

    override fun initDriver() {
        driver = AndroidDriver(URL(SeleniumGridManager.serverAddress), Capabilities.Android())
        setImplicitWait()
    }

    override fun findElementById(id: String): WebElement {
        return driver.findElement(By.id(id))
    }

    override fun findElementsById(id: String): List<WebElement> {
        return driver.findElements(By.id(id))
    }

}

class IOSAutomateDriver: BaseAutomateDriver() {
    override fun initDriver() {
        driver = IOSDriver(URL(SeleniumGridManager.serverAddress), Capabilities.iOS())
        setImplicitWait()
    }

    override fun findElementById(id: String): WebElement {
        return driver.findElement(By.id(id))
    }

    override fun findElementsById(id: String): List<WebElement> {
        return driver.findElements(By.id(id))
    }
}
