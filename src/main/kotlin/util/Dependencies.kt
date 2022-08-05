package util

import framework.driver.AndroidAutomateDriver
import framework.driver.AutomateDriver
import framework.driver.IOSAutomateDriver
import org.koin.core.module.Module
import org.koin.dsl.module

fun getModule(platform: Platform): Module {
    return if (platform == Platform.Android) AndroidDependencies else IOSDependencies
}

val AndroidDependencies = module {
    single<AutomateDriver> { AndroidAutomateDriver() }
}

val IOSDependencies = module {
    single<AutomateDriver> { IOSAutomateDriver() }
}
