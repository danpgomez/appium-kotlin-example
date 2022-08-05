# Scout
> _Discover, investigate, and alert mobile bugs with ease and confidence._

A tool that runs automated end-to-end UI tests on mobile apps using Appium.

### Setup for Android

You'll want to make sure you have the following items installed prior to working with Appium:

1. [Node.js and NPM](https://nodejs.org/en/) if you don’t have it already
2. Install the Appium Server using `$ npm install -g appium`
3. [Java JDK](https://www.oracle.com/java/technologies/downloads/#java8-mac)
4. [Android Studio](https://developer.android.com/studio)
5. [Create an Android Virtual Device (AVD) and run it](https://developer.android.com/studio/run/managing-avds#createavd)
6. Set `ANDROID_HOME` environment variable by running the following command in the terminal:
   ```bash
	set ANDROID_HOME=/Users/<your_user>/Library/Android/sdk
   ```
   And ensure it is properly set by running
   ```bash
	echo ANDROID_HOME
   ```
   **Note:** Be sure to replace `<your_user>` with the user of your computer. This path should be the path to your Android SDK file, so if the SDK was installed in a different location by Android Studio you'll want to use the path to that file instead.

   More about debugging environment variables [here](https://github.com/appium/java-client/blob/master/docs/environment.md).

1. (Bonus) Install [Appium Inspector](https://github.com/appium/appium-inspector) to help easily identify selectors for elements

### Setup for iOS
1. Install Node and NPM as above and XCode from the Squarespace Self Service tool if you don't already have it.
2. Install XCode Select. This is a set of command-line scripts needed to run tests.
   ```bash
   xcode-select --install
   ```

### Usage
1. Clone the repository
1. Request an `.apk` file (or `.app` for iOS) of the app you want to test from your product team.
2. Add the path to your app's APK file to the `src/main/kotlin/util/App.kt` file.
3. Launch the Android Virtual Device if testing Android (iOS emulator will launch automatically)
5. Start the Appium server using the terminal command `appium` and keep it running
6. In a separate terminal window, run your tests using the below command (or if using IntelliJ click the green play ▶️ button):
```bash
./gradlew :test
```
