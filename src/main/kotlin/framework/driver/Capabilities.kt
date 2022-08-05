package framework.driver

import io.appium.java_client.remote.IOSMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import util.App
import util.EnvironmentManager.isRealIosDevice

object Capabilities {

    fun Android(): DesiredCapabilities {
        val capabilities = createCommonCapabilities()

        capabilities.setCapability("appium:newCommandTimeout", 300)
        capabilities.setCapability("appium:noSign", true)
        capabilities.setCapability("appium:platformName", "Android")
        capabilities.setCapability("appium:deviceName", "Android")
        capabilities.setCapability("appium:automationName", "UIAutomator2")
        capabilities.setCapability("appium:autoGrantPermissions", true)
        capabilities.setCapability("appium:enforceAppInstall", true)
        capabilities.setCapability("appium:appActivity", "com.squarespace.android.squarespaceapp.ui.activities.StartupActivity")
        capabilities.setCapability("appium:appWaitActivity", "com.squarespace.android.onboarding.views.WelcomeActivity")

        return capabilities
    }

    fun iOS() : DesiredCapabilities {
        val capabilities = createCommonCapabilities()

        capabilities.setCapability("appium:newCommandTimeout", 120)
        capabilities.setCapability("appium:platformName", "iOS")
        capabilities.setCapability("appium:deviceName", "iPhone 11")
        capabilities.setCapability("appium:automationName", "XCUITest")
        capabilities.setCapability("appium:noReset", false)
        capabilities.setCapability("appium:connectHardwareKeyboard", "false")
        capabilities.setCapability("appium:useNewWDA", "true")
        capabilities.setCapability("appium:waitForQuiescence", "false")
        capabilities.setCapability("appium:maxTypingFrequency", 10)

        if (isRealIosDevice) {
            capabilities.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, "<ID>")
            capabilities.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, "<SIGN ID>")
            capabilities.setCapability(MobileCapabilityType.UDID, "<PHONE UDID>")
        }
        return capabilities
    }

    private fun createCommonCapabilities(): DesiredCapabilities {
        val capabilities = DesiredCapabilities()
        capabilities.setCapability("appium:app", App.Path)
        return capabilities
    }
}
