# _BlinkID_ SDK for Android

[![Build Status](https://travis-ci.org/BlinkID/blinkid-android.svg?branch=master)](https://travis-ci.org/BlinkID/blinkid-android)

_BlinkID_ SDK for Android is SDK that enables you to perform scans of various ID cards in your app. You can simply integrate the SDK into your app by following the instructions below and your app will be able to benefit the scanning feature for various documents.

As of version `1.8.0` you can also scan barcodes and perform OCR of structured or free-form text. Supported barcodes are the same as in sister product [PDF417.mobi](https://github.com/PDF417/pdf417-android).

Using _BlinkID_ in your app requires a valid license. You can obtain a trial license by registering to [Microblink dashboard](https://microblink.com/login). After registering, you will be able to generate a license for your app. License is bound to [package name](http://tools.android.com/tech-docs/new-build-system/applicationid-vs-packagename) of your app, so please make sure you enter the correct package name when asked.

See below for more information about how to integrate _BlinkID_ SDK into your app and also check latest [Release notes](Release%20notes.md).

To see _BlinkID_ in action, check our [demo app](https://play.google.com/store/apps/details?id=com.microblink.blinkidapp). If you want the same user experience in your application, or just want to reuse some functionalities from this demo, there is an open-source library [blinkid-ui-android](https://github.com/BlinkID/blinkid-ui-android) that can help you.

# Table of contents

* [Android _BlinkID_ integration instructions](#intro)
* [Quick Start](#quickStart)
    * [Quick start with the sample app](#quickDemo)
    * [Android Studio integration](#androidStudioIntegration)
    * [Eclipse integration](#eclipseIntegration)
    * [Maven Plugin integration](#mavenIntegration)
    * [Performing your first scan](#quickScan)
    * [Performing your first `field by field` scan](#quickScan)
* [Advanced _BlinkID_ integration instructions](#advancedIntegration)
    * [Checking if _BlinkID_ is supported](#supportCheck)
    * [UI customizations of built-in activities and fragments](#uiCustomizations)
        * [Using built-in scan activity for performing the scan](#runBuiltinActivity)
        * [Using `RecognizerRunnerFragment` within your activity](#recognizerRunnerFragment)
        * [Built-in activities and overlays](#builtInUIComponents)
        * [Changing the appearance of built-in activities and scanning overlays](#changeBuiltInUIComponents)
        * [Translation and localization](#translation)
    * [Embedding `RecognizerRunnerView` into custom scan activity](#recognizerRunnerView)
        * [Scan activity's orientation](#scanOrientation)
    * [Direct API](#directAPI)
        * [Using Direct API for recognition of Android Bitmaps and custom camera frames](#directAPI_images)
        * [Using Direct API for `String` recognition (parsing)](#directAPI_strings)
        * [Understanding DirectAPI's state machine](#directAPIStateMachine)
        * [Using DirectAPI while RecognizerRunnerView is active](#directAPIWithRecognizer)
    * [Handling processing events with `RecognizerRunner` and `RecognizerRunnerView`](#processingEvents)
        * [Note about the `setMetadataCallbacks` method](#processingEventsImportantNote)
* [`Recognizer` concept and `RecognizerBundle`](#availableRecognizers)
    * [The `Recognizer` concept](#recognizerConcept)
    * [`RecognizerBundle`](#recognizerBundle)
        * [Passing `Recognizer` objects between activities](#intentOptimization)
* [List of available recognizers](#recognizerList)
    * [Frame Grabber Recognizer](#frameGrabberRecognizer)
    * [Success Frame Grabber Recognizer](#successFrameGrabberRecognizer)
    * [PDF417 recognizer](#pdf417Recognizer)
    * [Barcode recognizer](#barcodeRecognizer)
    * [BlinkInput recognizer](#blinkInputRecognizer)
    * [Detector recognizer](#detectorRecognizer)
    * [BlinkCard recognizers](#blinkcard_recognizers)
        * [BlinkCard recognizer](#blink_card_combined)
        * [BlinkCardElite recognizer](#elite_blink_card_combined)
    * [SIM number recognizer](#simNumberRecognizer)
    * [BlinkID recognizers](#blinkid_recognizers)
        * [Machine Readable Travel Document recognizer](#mrtdRecognizer)
        * [Machine Readable Travel Document combined recognizer](#mrtd_combined_recognizer)
        * [US / Canada driver's license barcode recognizer](#us_dl_recognizer)
        * [US / Canada driver's license combined recognizer](#us_dl_combined_recognizer)
        * [EU Driver's License recognizer](#eudlRecognizer)
        * [Document face recognizer](#documentFaceRecognizer)
    * [Country-specific BlinkID recognizers](#blinkid_recognizers_countries)
        * [Australia](#blinkid_recognizers_australia)
        * [Austria](#blinkid_recognizers_austria)
        * [Brunei](#blinkid_recognizers_brunei)
        * [Colombia](#blinkid_recognizers_colombia)
        * [Croatia](#blinkid_recognizers_croatia)
        * [Cyprus](#blinkid_recognizers_cyprus)
        * [Czechia](#blinkid_recognizers_czechia)
        * [Egypt](#blinkid_recognizers_egypt)
        * [Germany](#blinkid_recognizers_germany)
        * [HongKong](#blinkid_recognizers_hongkong)
        * [Indonesia](#blinkid_recognizers_indonesia)
        * [Ireland](#blinkid_recognizers_ireland)
        * [Italy](#blinkid_recognizers_italy)
        * [Jordan](#blinkid_recognizers_jordan)
        * [Kuwait](#blinkid_recognizers_kuwait)
        * [Malaysia](#blinkid_recognizers_malaysia)
        * [Mexico](#blinkid_recognizers_mexico)
        * [Morocco](#blinkid_recognizers_morocco)
        * [New Zealand](#blinkid_recognizers_newzealand)
        * [Nigeria](#blinkid_recognizers_nigeria)
        * [Poland](#blinkid_recognizers_poland)
        * [Romania](#blinkid_recognizers_romania)
        * [Singapore](#blinkid_recognizers_singapore)
        * [Slovakia](#blinkid_recognizers_slovakia)
        * [Slovenia](#blinkid_recognizers_slovenia)
        * [Spain](#blinkid_recognizers_spain)
        * [Sweden](#blinkid_recognizers_sweden)
        * [Switzerland](#blinkid_recognizers_switzerland)
        * [United Arab Emirates](#blinkid_recognizers_uae)
        * [United Kingdom](#blinkid_recognizers_uk)
        * [US / Canada](#blinkid_recognizers_us_canada)
* [`Field by field` scanning feature](#fieldByFieldFeature)
* [`Processor` and `Parser`](#processorsAndParsers)
    * [The `Processor` concept](#processorConcept)
    * [List of available processors](#processorList)
        * [Image Return Processor](#imageReturnProcessor)
        * [Parser Group Processor](#parserGroupProcessor)
    * [The `Parser` concept](#parserConcept)
    * [List of available parsers](#parserList)
        * [Amount Parser](#amountParser)
        * [Date Parser](#dateParser)
        * [EMail Parser](#emailParser)
        * [IBAN Parser](#ibanParser)
        * [License Plates Parser](#licensePlatesParser)
        * [Raw Parser](#rawParser)
        * [Regex Parser](#regexParser)
        * [TopUp Parser](#topUpParser)
        * [VIN (*Vehicle Identification Number*) Parser](#vinParser)
* [Scanning generic documents with Templating API](#detectorTemplating)
    * [Defining how document should be detected](#detectorTemplating_detection)
    * [Defining how fields of interest should be extracted](#detectorTemplating_extraction)
        * [The `ProcessorGroup` component](#processorGroup)
        * [List of available dewarp policies](#dewarpPolicyList)
        * [The `TemplatingClass` component](#templatingClass)
        * [Implementing the `TemplatingClassifier`](#implementingTemplatingClassifier)
    * [Obtaining recognition results](#detectorTemplating_results)
* [Extracting additional fields of interest from machine-readable travel documents by using Templating API](#mrtdTemplating)
* [The `Detector` concept](#detectorConcept)
    * [List of available detectors](#detectorList)
        * [Document Detector](#documentDetector)
        * [MRTD Detector](#mrtdDetector)
* [Embedding _BlinkID_ inside another SDK](#embedAAR)
    * [_BlinkID_ licensing model](#licensingModel)
        * [Application licenses](#appLicence)
    * [Ensuring the final app gets all resources required by _BlinkID_](#sdkIntegrationIntoApp)
* [Processor architecture considerations](#archConsider)
    * [Reducing the final size of your app](#reduceSize)
        * [Consequences of removing processor architecture](#archConsequences)
    * [Creating customized build of _BlinkID_](#staticDistrib)
    * [Combining _BlinkID_ with other native libraries](#combineNativeLibraries)
* [Troubleshooting](#troubleshoot)
    * [Integration problems](#integrationTroubleshoot)
    * [SDK problems](#sdkTroubleshoot)
    * [Frequently asked questions and known problems](#faq)
* [Additional info](#info)

# <a name="intro"></a> Android _BlinkID_ integration instructions

The package contains Android Archive (AAR) that contains everything you need to use _BlinkID_ library. Besides AAR, package also contains a sample project that contains following modules:

- _BlinkID-aMinimalSample_ demonstrates quick and simple integration of _BlinkID_ library
- _BlinkID-AllRecognizersSample_ demonstrates integration of almost all available features. This sample application is best for performing a quick test of supported features.
- _BlinkID-CustomCombinedSample_ demonstrates advanced custom UI integration and usage of the combined recognizers within a custom scan activity.
- _BlinkID-CustomFieldByFieldScanSample_ demonstrates advanced integration of Field by Field feature within custom scan activity. It shows how to create a custom scan activity for scanning little text fields.
- _BlinkID-CustomUISample_ demonstrates advanced integration within custom scan activity.
- _BlinkID-DetectorSample_ demonstrates how to perform document detection and obtain dewarped image of the detected document.
- _BlinkID-DirectApiSample_ demonstrates how to perform scanning of [Android Bitmaps](https://developer.android.com/reference/android/graphics/Bitmap.html)
- _BlinkID-ImagesSample_ demonstrates how to obtain document images.
- _BlinkID-TemplatingSample_ shows how to use Templating API to implement support for scanning generic documents.
 
The source code of all sample apps is given to you to show you how to perform integration of _BlinkID_ SDK into your app. You can use this source code and all resources as you wish. You can use sample apps as a basis for creating your own app, or you can copy/paste the code and/or resources from sample apps into your app and use them as you wish without even asking us for permission.
 
_BlinkID_ is supported on Android SDK version 16 (Android 4.1) or later.

The list of all provided scan activities can be found in the [Built-in activities and overlays](#builtInUIComponents) section.

You can also create your own scanning UI - you just need to embed `RecognizerRunnerView` into your activity and pass activity's lifecycle events to it and it will control the camera and recognition process. For more information, see [Embedding `RecognizerRunnerView` into custom scan activity](#recognizerRunnerView).

# <a name="quickStart"></a> Quick Start

## <a name="quickDemo"></a> Quick start with the sample app

1. Open Android Studio.
2. In Quick Start dialog choose _Import project (Eclipse ADT, Gradle, etc.)_.
3. In File dialog select _BlinkIDSample_ folder.
4. Wait for the project to load. If Android studio asks you to reload project on startup, select `Yes`.

## <a name="androidStudioIntegration"></a> Android Studio integration


### Using Maven repository

In your `build.gradle` you first need to add _BlinkID_ maven repository to repositories list:

```
repositories {
    maven { url 'https://maven.microblink.com' }
}
```

After that, you just need to add _BlinkID_ as a dependency to your application (make sure, `transitive` is set to true):

```
dependencies {
    implementation('com.microblink:blinkid:4.8.0@aar') {
        transitive = true
    }
}
```

#### Importing Javadoc

Android studio 3.0 should automatically import javadoc from maven dependency. If that doesn't happen, you can do that manually by following these steps:

1. In Android Studio project sidebar, ensure [project view is enabled](https://developer.android.com/sdk/installing/studio-androidview.html)
2. Expand `External Libraries` entry (usually this is the last entry in project view)
3. Locate `blinkid-4.8.0` entry, right click on it and select `Library Properties...`
4. A `Library Properties` pop-up window will appear
5. Click the second `+` button in bottom left corner of the window (the one that contains `+` with little globe)
6. Window for defining documentation URL will appear
7. Enter following address: `https://blinkid.github.io/blinkid-android/`
8. Click `OK`


### Using AAR

1. In Android Studio menu, click _File_, select _New_ and then select _Module_.
2. In new window, select _Import .JAR or .AAR Package_, and click _Next_.
3. In _File name_ field, enter the path to _LibBlinkID.aar_ and click _Finish_.
4. In your app's `build.gradle`, add dependency to `LibBlinkID` and appcompat-v7:

    ```
    dependencies {
        implementation project(':LibBlinkID')
        implementation "com.android.support:appcompat-v7:28.0.0"
    }
    ```
    
#### Importing Javadoc

1. In Android Studio project sidebar, ensure [project view is enabled](https://developer.android.com/sdk/installing/studio-androidview.html)
2. Expand `External Libraries` entry (usually this is the last entry in project view)
3. Locate `LibBlinkID-unspecified` entry, right click on it and select `Library Properties...`
4. A `Library Properties` pop-up window will appear
5. Click the `+` button in bottom left corner of the window
6. Window for choosing JAR file will appear
7. Find and select `LibBlinkID-javadoc.jar` file which is located in root folder of the SDK distribution
8. Click `OK`

## <a name="eclipseIntegration"></a> Eclipse integration

We do not provide Eclipse integration demo apps. We encourage you to use Android Studio. We also do not test integrating _BlinkID_ with Eclipse. If you are having problems with _BlinkID_, make sure you have tried integrating it with Android Studio prior to contacting us.

However, if you still want to use Eclipse, you will need to convert AAR archive to Eclipse library project format. You can do this by doing the following:

1. In Eclipse, create a new _Android library project_ in your workspace.
2. Clear the `src` and `res` folders.
3. Unzip the `LibBlinkID.aar` file. You can rename it to zip and then unzip it using any tool.
4. Copy the `classes.jar` to `libs` folder of your Eclipse library project. If `libs` folder does not exist, create it.
5. Copy the contents of `jni` folder to `libs` folder of your Eclipse library project.
6. Replace the `res` folder on library project with the `res` folder of the `LibBlinkID.aar` file.

You?ve already created the project that contains almost everything you need. Now let?s see how to configure your project to reference this library project.

1. In the project you want to use the library (henceforth, "target project") add the library project as a dependency
2. Open the `AndroidManifest.xml` file inside `LibBlinkID.aar` file and make sure to copy all permissions, features and activities to the `AndroidManifest.xml` file of the target project.
3. Copy the contents of `assets` folder from `LibBlinkID.aar` into `assets` folder of target project. If `assets` folder in target project does not exist, create it.
4. Clean and Rebuild your target project
5. Add appcompat-v7 library to your workspace and reference it by target project (modern ADT plugin for Eclipse does this automatically for all new android projects).

## <a name="mavenIntegration"></a> Maven Plugin integration

[Android Maven Plugin](https://simpligility.github.io/android-maven-plugin/) v4.0.0 or newer is required.

Open your `pom.xml` file and add these directives as appropriate:

```xml
<repositories>
    <repository>
        <id>MicroblinkRepo</id>
        <url>https://maven.microblink.com</url>
   	</repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.microblink</groupId>
        <artifactId>blinkid</artifactId>
        <version>4.8.0</version>
        <type>aar</type>
    </dependency>
</dependencies>
```
## <a name="quickScan"></a> Performing your first scan
1. First you'll need to create an account at [Microblink dashboard](https://microblink.com/login) where you can generate a demo license for your app. License is bound to [package name](http://tools.android.com/tech-docs/new-build-system/applicationid-vs-packagename) of your app, so please make sure you enter the correct package name when asked. 

    Download your licence file and put it in your application's _assets_ folder. Make sure to set the license key before using any other classes from the SDK, otherwise you will get a runtime exception. 
    
    We recommend that you extend [Android Application class](https://developer.android.com/reference/android/app/Application.html) and set the license in [onCreate callback](https://developer.android.com/reference/android/app/Application.html#onCreate()) like this:

    ```java
    public class MyApplication extends Application {
        @Override
        public void onCreate() {
            MicroblinkSDK.setLicenseFile("path/to/license/file/within/assets/dir", this);
        }
    }
    ```

2. In your main activity, create recognizer objects that will perform image recognition, configure them and put them into [RecognizerBundle object](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/RecognizerBundle.html). You can see more information about available recognizers and `RecognizerBundle` [here](#availableRecognizers). 

	For example, to scan Machine Readable Travel Document (MRTD), configure your recognizer like this:

    ```java
    public class MyActivity extends Activity {
        private MrtdRecognizer mRecognizer;
        private RecognizerBundle mRecognizerBundle;
        
        @Override
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            
            // setup views, as you would normally do in onCreate callback
            
            // create MrtdRecognizer
            mRecognizer = new MrtdRecognizer();
            
            // bundle recognizers into RecognizerBundle
            mRecognizerBundle = new RecognizerBundle(mRecognizer);
        }
    }
    ```

3. Start recognition process by creating `DocumentUISettings` and calling [`ActivityRunner.startActivityForResult`](https://blinkid.github.io/blinkid-android/com/microblink/uisettings/ActivityRunner.html#startActivityForResult-android.app.Activity-int-com.microblink.uisettings.UISettings-):
	
	```java
	// method within MyActivity from previous step
	public void startScanning() {
        // Settings for DocumentScanActivity Activity
        DocumentUISettings settings = new DocumentUISettings(mRecognizerBundle);
        
        // tweak settings as you wish
        
        // Start activity
        ActivityRunner.startActivityForResult(this, MY_REQUEST_CODE, settings);
	}
	```
	
4. `onActivityResult` will be called in your activity after scanning is finished, here you can get the scanning results.

	```java
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode == DocumentScanActivity.RESULT_OK && data != null) {
                // load the data into all recognizers bundled within your RecognizerBundle
                mRecognizerBundle.loadFromIntent(data);
                
                // now every recognizer object that was bundled within RecognizerBundle
                // has been updated with results obtained during scanning session
                
                // you can get the result by invoking getResult on recognizer
                MrtdRecognizer.Result result = mRecognizer.getResult();
                if (result.getResultState() == Recognizer.Result.State.Valid) {
                    // result is valid, you can use it however you wish
                }
            }
        }
    }
	```
	
	For more information about available recognizers and `RecognizerBundle`, see [RecognizerBundle and available recognizers](#availableRecognizers).

## <a name="quickScan"></a> Performing your first `field by field` scan

1. Before starting a recognition process, you need to obtain a license from [Microblink dashboard](https://microblink.com/login). After registering, you will be able to generate a trial license for your app. License is bound to [package name](http://tools.android.com/tech-docs/new-build-system/applicationid-vs-packagename) of your app, so please make sure you enter the correct package name when asked. 

    After creating a license, you will have the option to download the license as a file that you must place within your application's _assets_ folder. You must ensure that license key is set before instantiating any other classes from the SDK, otherwise you will get an exception at runtime. Therefore, we recommend that you extend [Android Application class](https://developer.android.com/reference/android/app/Application.html) and set the license in its [onCreate callback](https://developer.android.com/reference/android/app/Application.html#onCreate()) in the following way:

    ```java
    public class MyApplication extends Application {
        @Override
        public void onCreate() {
            MicroblinkSDK.setLicenseFile("path/to/license/file/within/assets/dir", this);
        }
    }
    ```

2. In your main activity create parser objects that will be used during recognition, configure them if needed, define scan elements and store them in [`FieldByFieldBundle`](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/config/fieldbyfield/FieldByFieldBundle.html) object. For example, to scan three fields: amount, e-mail address and raw text, you can configure your recognizer object in the following way:

   ```java
    public class MyActivity extends Activity {
        // parsers are member variables because it will be used for obtaining results
        private AmountParser mAmountParser;
        private EMailParser mEMailParser;
        private RawParser mRawParser;

        /** Reference to bundle is kept, it is used later for loading results from intent */
        private FieldByFieldBundle mFieldByFieldBundle;
        
        @Override
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            
            // setup views, as you would normally do in onCreate callback
            
            mAmountParser = new AmountParser();
            mEMailParser = new EMailParser();
            mRawParser = new RawParser();
            
            // prepare scan elements and put them in FieldByFieldBundle
            // we need to scan 3 items, so we will create bundle with 3 elements
            mFieldByFieldBundle = new FieldByFieldBundle(
                // each scan element contains two string resource IDs: string shown in title bar
                // and string shown in text field above scan box. Besides that, it contains parser
                // that will extract data from the OCR result.
                new FieldByFieldElement(R.string.amount_title, R.string.amount_msg, mAmountParser),
                new FieldByFieldElement(R.string.email_title, R.string.email_msg, mEMailParser),
                new FieldByFieldElement(R.string.raw_title, R.string.raw_msg, mRawParser)
            );
        }
    }
    ```
    
3. You can start recognition process by starting [`FieldByFieldScanActivity`](https://blinkid.github.io/blinkid-android/com/microblink/activity/FieldByFieldScanActivity.html). You need to do that by creating [`FieldByFieldUISettings`](https://blinkid.github.io/blinkid-android/com/microblink/uisettings/FieldByFieldUISettings.html) and calling [`ActivityRunner.startActivityForResult`](https://blinkid.github.io/blinkid-android/com/microblink/uisettings/ActivityRunner.html#startActivityForResult-android.app.Activity-int-com.microblink.uisettings.UISettings-) method:

   ```java
    // method within MyActivity from previous step
    public void startFieldByFieldScanning() {
        // we use FieldByFieldUISettings - settings for FieldByFieldScanActivity
        FieldByFieldUISettings scanActivitySettings = new FieldByFieldUISettings(mFieldByFieldBundle);
        
        // tweak settings as you wish
        
        // Start activity
        ActivityRunner.startActivityForResult(this, MY_REQUEST_CODE, scanActivitySettings);
    }
    ```

4. After `FieldByFieldScanActivity` finishes the scan, it will return to the calling activity or fragment and will call its method `onActivityResult`. You can obtain the scanning results in that method.

    ```java
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode == FieldByFieldScanActivity.RESULT_OK && data != null) {
                // load the data into all parsers bundled within your FieldByFieldBundle
                mFieldByFieldBundle.loadFromIntent(data);
                
                // now every parser object that was bundled within FieldByFieldBundle
                // has been updated with results obtained during scanning session
                
                // you can get the results by invoking getResult on each parser, and then
                // invoke specific getter for each concrete parser result type
                String amount = mAmountParser.getResult().getAmount();
                String email = mEMailParser.getResult().getEmail();
                String rawText = mRawParser.getResult().getRawText();

                if (!amount.isEmpty()) {
                    // amount has been successfully parsed, you can use it however you wish
                }
                if (!email.isEmpty()) {
                    // email has been successfully parsed, you can use it however you wish
                }
                if (!rawText.isEmpty()) {
                    // raw text has been successfully returned, you can use it however you wish
                }
            }
        }
    }
    ```	
    
# <a name="advancedIntegration"></a> Advanced _BlinkID_ integration instructions
This section covers more advanced details of _BlinkID_ integration.

1. [First part](#supportCheck) will discuss the methods for checking whether _BlinkID_ is supported on current device. 
2. [Second part](#uiCustomizations) will cover the possible customizations when using UI provided by the SDK.
3. [Third part](#recognizerRunnerView) will describe how to embed `RecognizerRunnerView` into your activity with the goal of creating a custom UI for scanning, while still using camera management capabilities of the SDK.
4. [Fourth part](#directAPI) will describe how to use the `RecognizerRunner` singleton (Direct API) for recognition directly from android bitmaps without the need of camera or to recognize camera frames that are obtained by custom camera management.
5. [Fifth part](#processingEvents) will describe how to subscribe to and handle processing events when using either `RecognizerRunnerView` or `RecognizerRunner`.


## <a name="supportCheck"></a> Checking if _BlinkID_ is supported

### _BlinkID_ requirements
Even before settings the license key, you should check if _BlinkID_ is supported on current device. This is required because the _BlinkID_ is a native library that needs to be loaded by the JVM and it is possible that it doesn't support CPU architecture of the current device. Attempt of calling any methods from the SDK that rely on native code, such as license check, on a device with unsupported CPU architecture will cause a crash of your app.

_BlinkID_ requires Android 4.1 as the minimum android version. For best performance and compatibility, we recommend Android 5.0 or newer.


OpenGL ES 2.0 can be used to accelerate _BlinkID's_ processing but is not mandatory. However, it should be noted that if OpenGL ES 2.0 is not available processing time will be significantly large, especially on low end devices.

Since we use OpenGL ES 2.0 for image processing on background thread, we entirely use off-screen rendering to achieve our goals. Unfortunately, some devices have bugs in their OpenGL drivers that cause a crash of the application when it attempts to perform off-screen OpenGL ES context initialization. We do our best to maintain a list of such devices and ensure that no OpenGL is used on those devices. Unfortunately again, the nature of that bug is such that it cannot be detected and worked around at runtime, so a blacklist is required. Fortunately however, most of the affected devices run Android 4.1 or Android 4.2, while most of devices running newer versions of Android are not affected. Also note that most of the devices out there that still run Android 4.1/4.2 are not affected by this bug. If you happen to find a crash of your app which may lead to the described problem, please [let us know](http://help.microblink.com) so we can blacklist the problematic device.

Camera video preview resolution also matters. In order to perform successful scans, camera preview resolution cannot be too low. Minimum camera preview resolution in order to perform a scan is 480p. It must be noted that camera preview resolution is not the same as the video record resolution, although on most devices those are the same. However, there are some devices that allow recording of HD video (720p resolution), but do not allow high enough camera preview resolution (for example, [Sony Xperia Go](http://www.gsmarena.com/sony_xperia_go-4782.php) supports video record resolution at 720p, but camera preview resolution is only 320p - _BlinkID_ does not work on that device).

_BlinkID_ is native application, written in C++ and available for multiple platforms. Because of this, _BlinkID_ cannot work on devices that have obscure hardware architectures. We have compiled _BlinkID_ native code only for most popular Android [ABIs](https://en.wikipedia.org/wiki/Application_binary_interface). See [Processor architecture considerations](#archConsider) for more information about native libraries in _BlinkID_ and instructions how to disable certain architectures in order to reduce the size of final app.

### Checking for _BlinkID_ support in your app
To check whether the _BlinkID_ is supported on the device, you can do it in the following way:
	
```java
// check if BlinkID is supported on the device
RecognizerCompatibilityStatus status = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
if (status == RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
    Toast.makeText(this, "BlinkID is supported!", Toast.LENGTH_LONG).show();
} else if (status == RecognizerCompatibilityStatus.NO_CAMERA) {
    Toast.makeText(this, "BlinkID is supported only via Direct API!", Toast.LENGTH_LONG).show();
} else {
	Toast.makeText(this, "BlinkID is not supported! Reason: " + status.name(), Toast.LENGTH_LONG).show();
}
```

However, some recognizers require camera with autofocus. If you try to start recognition with those recognizers on a device that does not have a camera with autofocus, you will get an error. To prevent that, you can check whether certain recognizer requires autofocus by calling its [requiresAutofocus](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/Recognizer.html#requiresAutofocus--) method.

If you already have an array of recognizers, you can easily filter out all recognizers that require autofocus from array using the following code snippet:

```java
Recognizer[] recArray = ...;
if(!RecognizerCompatibility.cameraHasAutofocus(CameraType.CAMERA_BACKFACE, this)) {
	recArray = RecognizerUtils.filterOutRecognizersThatRequireAutofocus(recArray);
}
```

This utility method basically iterates over the given array of recognizers and throws out each recognizer that returns `true` from its [requiresAutofocus](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/Recognizer.html#requiresAutofocus--) method.
## <a name="uiCustomizations"></a> UI customizations of built-in activities and fragments

This section will discuss supported appearance and behaviour customizations of built-in activities and will show how to use [`RecognizerRunnerFragment`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/RecognizerRunnerFragment.html) with provided built-in [scanning overlays](https://blinkid.github.io/blinkid-android/com/microblink/fragment/overlay/ScanningOverlay.html) to get the built-in UI experience within any part of your app.

### <a name="runBuiltinActivity"></a> Using built-in scan activity for performing the scan

As shown in [first scan example](#quickScan), you need to create a settings object that is associated with the activity you wish to use. Attempt to start built-in activity directly via custom-crafted `Intent` will result with either crashing the app or with undefined behaviour of the scanning procedure.

List of available built-in scan activities in _BlinkID_ are listed in section [Built-in activities and fragments](#builtInUIComponents).

### <a name="recognizerRunnerFragment"></a> Using `RecognizerRunnerFragment` within your activity

If you want to integrate UI provided by our built-in activity somewhere within your activity, you can do so by using [`RecognizerRunnerFragment`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/RecognizerRunnerFragment.html). Any activity that will host the `RecognizerRunnerFragment` must implement [`ScanningOverlayBinder`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/RecognizerRunnerFragment.ScanningOverlayBinder.html) interface. Attempt of adding `RecognizerRunnerFragment` to activity that does not implement the aforementioned interface will result in a `ClassCastException`. This design is in accordance with the [recommendation for communication between fragments](https://developer.android.com/training/basics/fragments/communicating.html).

The `ScanningOverlayBinder` is responsible for returning `non-null` implementation of [`ScanningOverlay`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/overlay/ScanningOverlay.html) - class that will manage UI on top of `RecognizerRunnerFragment`. It is not recommended to create your own implementation of `ScanningOverlay` as effort to do so might be equal or even greater to creating your custom UI implementation [in the recommended way](#recognizerRunnerView). 

Here is the minimum example for activity that hosts the `RecognizerRunnerFragment`:

```java
public class MyActivity extends Activity implements RecognizerRunnerFragment.ScanningOverlayBinder {
    private MrtdRecognizer mRecognizer;
    private RecognizerBundle mRecognizerBundle;
    private DocumentOverlayController mScanOverlay = createOverlay();
    private RecognizerRunnerFragment mRecognizerRunnerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate();
        setContentView(R.layout.activity_my_activity);

        if (null == savedInstanceState) {
            // create fragment transaction to replace R.id.recognizer_runner_view_container with RecognizerRunnerFragment
            mRecognizerRunnerFragment = new RecognizerRunnerFragment();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.recognizer_runner_view_container, mRecognizerRunnerFragment);
            fragmentTransaction.commit();
        } else {
            // obtain reference to fragment restored by Android within super.onCreate() call
            mRecognizerRunnerFragment = (RecognizerRunnerFragment) getFragmentManager().findFragmentById(R.id.recognizer_runner_view_container);
        }
    }

    @Override
    @NonNull
    public ScanningOverlay getScanningOverlay() {
        return mScanningOverlay;
    }

    private DocumentOverlayController createOverlay() {
        // create MrtdRecognizer
        mRecognizer = new MrtdRecognizer();

        // bundle recognizers into RecognizerBundle
        mRecognizerBundle = new RecognizerBundle(mRecognizer);

        // Settings for DocumentOverlayController overlay
        DocumentUISettings settings = new DocumentUISettings(mRecognizerBundle);

        return new DocumentOverlayController(settings, mScanResultListener);
    }

    private final ScanResultListener mScanResultListener = new ScanResultListener() {
        @Override
        public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
            // pause scanning to prevent new results while fragment is being removed
            mRecognizerRunnerFragment.getRecognizerRunnerView().pauseScanning();

            // now you can remove the RecognizerRunnerFragment with new fragment transaction
            // and use result within mRecognizer safely without the need for making a copy of it

            // if not paused, as soon as this method ends, RecognizerRunnerFragments continues
            // scanning. Note that this can happen even if you created fragment transaction for
            // removal of RecognizerRunnerFragment - in the time between end of this method
            // and beginning of execution of the transaction. So to ensure result within mRecognizer
            // does not get mutated, ensure calling pauseScanning() as shown above.
        }
    };
    
}
```

Also please refer to demo apps provided with the SDK for more detailed example and make sure your host activity's orientation is set to `nosensor` or has configuration changing enabled (i.e. is not restarted when configuration change happens). For more information, check [this section](#scanOrientation).

### <a name="builtInUIComponents"></a> Built-in activities and overlays

Within _BlinkID_ SDK there are several built-in activities and scanning overlays that you can use to perform scanning.
#### <a name="documentUiComponent"></a> `DocumentScanActivity` and `DocumentOverlayController`

[`DocumentOverlayController`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/overlay/DocumentOverlayController.html) is overlay for [`RecognizerRunnerFragment`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/RecognizerRunnerFragment.html) best suited for scanning of various card documents like ID cards, passports, driver's licenses, etc.

[`DocumentScanActivity`](https://blinkid.github.io/blinkid-android/com/microblink/activity/DocumentScanActivity.html) contains `RecognizerRunnerFragment` with [`DocumentOverlayController`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/overlay/DocumentOverlayController.html), which can be used out of the box to perform scanning using the default UI.

#### <a name="documentVerifyUiComponent"></a> `DocumentVerificationActivity` and `DocumentVerificationOverlayController`

[`DocumentVerificationOverlayController `](https://blinkid.github.io/blinkid-android/com/microblink/fragment/overlay/verification/DocumentVerificationOverlayController.html) is overlay for [`RecognizerRunnerFragment`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/RecognizerRunnerFragment.html) best suited for **combined recognizers** because it manages scanning of multiple document sides in the single camera opening and guides the user through the scanning process. It can also be used for single side scanning of ID cards, passports, driver's licenses, etc.

[`DocumentVerificationActivity`](https://blinkid.github.io/blinkid-android/com/microblink/activity/DocumentVerificationActivity.html) contains `RecognizerRunnerFragment` with [`DocumentVerificationOverlayController `](https://blinkid.github.io/blinkid-android/com/microblink/fragment/overlay/verification/DocumentVerificationOverlayController.html), which can be used out of the box to perform scanning using the default UI.

#### <a name="blinkcardUiComponent"></a> `BlinkCardActivity` and `BlinkCardOverlayController`

[`BlinkCardOverlayController`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/overlay/blinkcard/BlinkCardOverlayController.html) is overlay for [`RecognizerRunnerFragment`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/RecognizerRunnerFragment.html) best suited for scanning payment cards. It can be used for other card documents like ID cards, passports, driver's licenses, etc. This overlay also supports **combined recognizers**, because it manages scanning of multiple document sides in the single camera opening and guides the user through the scanning process.

[`BlinkCardActivity`](https://blinkid.github.io/blinkid-android/com/microblink/activity/BlinkCardActivity.html) contains `RecognizerRunnerFragment` with [`BlinkCardOverlayController`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/overlay/blinkcard/BlinkCardOverlayController.html), which can be used out of the box to perform scanning, using the default UI.
#### <a name="fieldByFieldUiComponent"></a> `FieldByFieldScanActivity` and `FieldByFieldOverlayController`

[`FieldByFieldOverlayController`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/overlay/FieldByFieldOverlayController.html) is overlay for [`RecognizerRunnerFragment`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/RecognizerRunnerFragment.html) best suited for performing scanning of small text fields, which are scanned in the predefined order, one by one. 

[`FieldByFieldScanActivity`](https://blinkid.github.io/blinkid-android/com/microblink/activity/FieldByFieldScanActivity.html) is the activity containing `RecognizerRunnerFragment` with [`FieldByFieldOverlayController`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/overlay/FieldByFieldOverlayController.html), which can be used out of the box to simply perform the scanning using the default UI.
#### `BarcodeScanActivity` and `BarcodeOverlayController`

[`BarcodeOverlayController`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/overlay/BarcodeOverlayController.html) is overlay for [`RecognizerRunnerFragment`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/RecognizerRunnerFragment.html) best suited for performing scanning of various barcodes.

[`BarcodeScanActivity`](https://blinkid.github.io/blinkid-android/com/microblink/activity/BarcodeScanActivity.html) contains `RecognizerRunnerFragment` with [`BarcodeOverlayController`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/overlay/BarcodeOverlayController.html), which can be used out of the box to perform scanning using the default UI.
### <a name="changeBuiltInUIComponents"></a> Changing the appearance of built-in activities and scanning overlays

Built-in activities and overlays use resources from the `res` folder within `LibBlinkID.aar` to display its contents. If you need a fully customised UI, we recommend creating completely custom scanning procedure (either activity or fragment), as described [here](#recognizerRunnerView). However, if you just want to slightly change the appearance of built-in activity or overlay, you can do that by overriding appropriate resource values, however this is **strictly not recommended**, as it can have unknown effects on the appearance of the UI component. If you think that some part of our built-in UI component should be configurable in a way that it currently is not, please [let us know](https://help.microblink.com) and we will consider adding that configurability into appropriate settings object.

### <a name="translation"></a> Translation and localization

Strings used within built-in activities and overlays can be localized to any language. If you are using `RecognizerRunnerView` ([see this chapter for more information](#recognizerRunnerView)) in your custom scan activity or fragment, you should handle localization as in any other Android app. `RecognizerRunnerView` does not use strings nor drawables, it only uses assets from `assets/microblink` folder. Those assets must not be touched as they are required for recognition to work correctly.

However, if you use our built-in activities or overlays, they will use resources packed within `LibBlinkID.aar` to display strings and images on top of the camera view. We have already prepared strings for several languages which you can use out of the box. You can also [modify those strings](#stringChanging), or you can [add your own language](#addLanguage).

To use a language, you have to enable it from the code:
		
* To use a certain language, you should call method `LanguageUtils.setLanguageAndCountry(language, country, context)`. For example, you can set language to Croatian like this:
	
	```java
	// define BlinkID language
	LanguageUtils.setLanguageAndCountry("hr", "", this);
	```

#### <a name="addLanguage"></a> Adding new language

_BlinkID_ can easily be translated to other languages. The `res` folder in `LibBlinkID.aar` archive has folder `values` which contains `strings.xml` - this file contains english strings. In order to make e.g. croatian translation, create a folder `values-hr` in your project and put the copy of `strings.xml` inside it (you might need to extract `LibBlinkID.aar` archive to access those files). Then, open that file and translate the strings from English into Croatian.

#### <a name="stringChanging"></a> Changing strings in the existing language
	
To modify an existing string, the best approach would be to:

1. Choose a language you want to modify. For example Croatian ('hr').
2. Find `strings.xml` in folder `res/values-hr` of the `LibBlinkID.aar` archive
3. Choose a string key which you want to change. For example: ```<string name="MBBack">Back</string>```
4. In your project create a file `strings.xml` in the folder `res/values-hr`, if it doesn't already exist
5. Create an entry in the file with the value for the string which you want. For example: ```<string name="MBBack">Natrag</string>```
6. Repeat for all the string you wish to change

## <a name="recognizerRunnerView"></a> Embedding `RecognizerRunnerView` into custom scan activity
This section discusses how to embed [RecognizerRunnerView](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerRunnerView.html) into your scan activity and perform scan.

1. First make sure that `RecognizerRunnerView` is a member field in your activity. This is required because you will need to pass all activity's lifecycle events to `RecognizerRunnerView`.
2. It is recommended to keep your scan activity in one orientation, such as `portrait` or `landscape`. Setting `sensor` as scan activity's orientation will trigger full restart of activity whenever device orientation changes. This will provide very poor user experience because both camera and _BlinkID_ native library will have to be restarted every time. There are measures against this behaviour that are discussed [later](#scanOrientation).
3. In your activity's `onCreate` method, create a new `RecognizerRunnerView`, set [RecognizerBundle](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/RecognizerBundle.html) containing recognizers that will be used by the view, define [CameraEventsListener](https://blinkid.github.io/blinkid-android/com/microblink/view/CameraEventsListener.html) that will handle mandatory camera events, define [ScanResultListener](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/ScanResultListener.html) that will receive call when recognition has been completed and then call its `create` method. After that, add your views that should be layouted on top of camera view.
4. Override your activity's `onStart`, `onResume`, `onPause`, `onStop` and `onDestroy` methods and call `RecognizerRunnerView's` lifecycle methods `start`, `resume`, `pause`, `stop` and `destroy`. This will ensure correct camera and native resource management. If you plan to manage `RecognizerRunnerView's` lifecycle independently of host's lifecycle, make sure the order of calls to lifecycle methods is the same as is with activities (i.e. you should not call `resume` method if `create` and `start` were not called first).

Here is the minimum example of integration of `RecognizerRunnerView` as the only view in your activity:

```java
public class MyScanActivity extends Activity {
    private static final int PERMISSION_CAMERA_REQUEST_CODE = 69;
    private RecognizerRunnerView mRecognizerRunnerView;
    private MrtdRecognizer mRecognizer;
    private RecognizerBundle mRecognizerBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // create MrtdRecognizer
        mRecognizer = new MrtdRecognizer();

        // bundle recognizers into RecognizerBundle
        mRecognizerBundle = new RecognizerBundle(mRecognizer);
        // create RecognizerRunnerView
        mRecognizerRunnerView = new RecognizerRunnerView(this);

        // associate RecognizerBundle with RecognizerRunnerView
        mRecognizerRunnerView.setRecognizerBundle(mRecognizerBundle);

        // scan result listener will be notified when scanning is complete
        mRecognizerRunnerView.setScanResultListener(mScanResultListener);
        // camera events listener will be notified about camera lifecycle and errors
        mRecognizerRunnerView.setCameraEventsListener(mCameraEventsListener);

        mRecognizerRunnerView.create();
        setContentView(mRecognizerRunnerView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // you need to pass all activity's lifecycle methods to RecognizerRunnerView
        mRecognizerRunnerView.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // you need to pass all activity's lifecycle methods to RecognizerRunnerView
        mRecognizerRunnerView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // you need to pass all activity's lifecycle methods to RecognizerRunnerView
        mRecognizerRunnerView.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // you need to pass all activity's lifecycle methods to RecognizerRunnerView
        mRecognizerRunnerView.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // you need to pass all activity's lifecycle methods to RecognizerRunnerView
        mRecognizerRunnerView.destroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // you need to pass all activity's lifecycle methods to RecognizerRunnerView
        mRecognizerRunnerView.changeConfiguration(newConfig);
    }
    

    private final CameraEventsListener mCameraEventsListener = new CameraEventsListener() {
        @Override
        public void onCameraPreviewStarted() {
            // this method is from CameraEventsListener and will be called when camera preview starts
        }

        @Override
        public void onCameraPreviewStopped() {
            // this method is from CameraEventsListener and will be called when camera preview stops
        }

        @Override
        public void onError(Throwable exc) {
            /**
             * This method is from CameraEventsListener and will be called when
             * opening of camera resulted in exception or recognition process
             * encountered an error. The error details will be given in exc
             * parameter.
             */
        }

        @Override
        @TargetApi(23)
        public void onCameraPermissionDenied() {
            /**
             * Called in Android 6.0 and newer if camera permission is not given
             * by user. You should request permission from user to access camera.
             */
            requestPermissions(new String[]{Manifest.permission.CAMERA}, PERMISSION_CAMERA_REQUEST_CODE);
            /**
             * Please note that user might have not given permission to use
             * camera. In that case, you have to explain to user that without
             * camera permissions scanning will not work.
             * For more information about requesting permissions at runtime, check
             * this article:
             * https://developer.android.com/training/permissions/requesting.html
             */
        }

        @Override
        public void onAutofocusFailed() {
            /**
             * This method is from CameraEventsListener will be called when camera focusing has failed.
             * Camera manager usually tries different focusing strategies and this method is called when all
             * those strategies fail to indicate that either object on which camera is being focused is too
             * close or ambient light conditions are poor.
             */
        }

        @Override
        public void onAutofocusStarted(Rect[] areas) {
            /**
             * This method is from CameraEventsListener and will be called when camera focusing has started.
             * You can utilize this method to draw focusing animation on UI.
             * Areas parameter is array of rectangles where focus is being measured.
             * It can be null on devices that do not support fine-grained camera control.
             */
        }

        @Override
        public void onAutofocusStopped(Rect[] areas) {
            /**
             * This method is from CameraEventsListener and will be called when camera focusing has stopped.
             * You can utilize this method to remove focusing animation on UI.
             * Areas parameter is array of rectangles where focus is being measured.
             * It can be null on devices that do not support fine-grained camera control.
             */
        }
    };
    
    private final ScanResultListener mScanResultListener = new ScanResultListener() {
        @Override
        public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
            // this method is from ScanResultListener and will be called when scanning completes
            // you can obtain scanning result by calling getResult on each
            // recognizer that you bundled into RecognizerBundle.
            // for example:

            MrtdRecognizer.Result result = mRecognizer.getResult();
            if (result.getResultState() == Recognizer.Result.State.Valid) {
                // result is valid, you can use it however you wish
            }

            // Note that mRecognizer is stateful object and that as soon as
            // scanning either resumes or its state is reset
            // the result object within mRecognizer will be changed. If you
            // need to create a immutable copy of the result, you can do that
            // by calling clone() on it, for example:

            MrtdRecognizer.Result immutableCopy = result.clone();

            // After this method ends, scanning will be resumed and recognition
            // state will be retained. If you want to prevent that, then
            // you should call:
            mRecognizerRunnerView.resetRecognitionState();
            // Note that reseting recognition state will clear internal result
            // objects of all recognizers that are bundled in RecognizerBundle
            // associated with RecognizerRunnerView.

            // If you want to pause scanning to prevent receiving recognition
            // results or mutating result, you should call:
            mRecognizerRunnerView.pauseScanning();
            // if scanning is paused at the end of this method, it is guaranteed
            // that result within mRecognizer will not be mutated, therefore you
            // can avoid creating a copy as described above

            // After scanning is paused, you will have to resume it with:
            mRecognizerRunnerView.resumeScanning(true);
            // boolean in resumeScanning method indicates whether recognition
            // state should be automatically reset when resuming scanning - this
            // includes clearing result of mRecognizer
        }
    };  
    
}
```

### <a name="scanOrientation"></a> Scan activity's orientation

If activity's `screenOrientation` property in `AndroidManifest.xml` is set to `sensor`, `fullSensor` or similar, activity will be restarted every time device changes orientation from portrait to landscape and vice versa. While restarting activity, its `onPause`, `onStop` and `onDestroy` methods will be called and then new activity will be created anew. This is a potential problem for scan activity because in its lifecycle it controls both camera and native library - restarting the activity will trigger both restart of the camera and native library. This is a problem because changing orientation from landscape to portrait and vice versa will be very slow, thus degrading a user experience. **We do not recommend such setting.**

For that matter, we recommend setting your scan activity to either `portrait` or `landscape` mode and handle device orientation changes manually. To help you with this, `RecognizerRunnerView` supports adding child views to it that will be rotated regardless of activity's `screenOrientation`. You add a view you wish to be rotated (such as view that contains buttons, status messages, etc.) to `RecognizerRunnerView` with [addChildView](#{javadocUrl}(com/microblink/view/CameraViewGroup.html#addChildView-android.view.View-boolean-)) method. The second parameter of the method is a boolean that defines whether the view you are adding will be rotated with device. To define allowed orientations, implement [OrientationAllowedListener](https://blinkid.github.io/blinkid-android/com/microblink/view/OrientationAllowedListener.html) interface and add it to `RecognizerRunnerView` with method `setOrientationAllowedListener`. **This is the recommended way of rotating camera overlay.**

However, if you really want to set `screenOrientation` property to `sensor` or similar and want Android to handle orientation changes of your scan activity, then we recommend to set `configChanges` property of your activity to `orientation|screenSize`. This will tell Android not to restart your activity when device orientation changes. Instead, activity's `onConfigurationChanged` method will be called so that activity can be notified of the configuration change. In your implementation of this method, you should call `changeConfiguration` method of `RecognizerView` so it can adapt its camera surface and child views to new configuration.
## <a name="directAPI"></a> Direct API

This section will describe how to use direct API to recognize android Bitmaps and java `Strings` without the need for camera. You can use direct API anywhere from your application, not just from activities.

### <a name="directAPI_images"></a> Using Direct API for recognition of Android Bitmaps and custom camera frames

1. First, you need to obtain reference to [RecognizerRunner singleton](https://blinkid.github.io/blinkid-android/com/microblink/directApi/RecognizerRunner.html) using [getSingletonInstance](https://blinkid.github.io/blinkid-android/com/microblink/directApi/RecognizerRunner.html#getSingletonInstance--).
2. Second, you need to [initialize the recognizer runner](https://blinkid.github.io/blinkid-android/com/microblink/directApi/RecognizerRunner.html#initialize-android.content.Context-com.microblink.entities.recognizers.RecognizerBundle-com.microblink.directApi.DirectApiErrorListener-).
3. After initialization, you can use singleton to [process Android bitmaps](https://blinkid.github.io/blinkid-android/com/microblink/directApi/RecognizerRunner.html#recognizeBitmap-android.graphics.Bitmap-com.microblink.hardware.orientation.Orientation-com.microblink.geometry.Rectangle-com.microblink.view.recognition.ScanResultListener-) or [images](https://blinkid.github.io/blinkid-android/com/microblink/directApi/RecognizerRunner.html#recognizeImage-com.microblink.image.Image-com.microblink.view.recognition.ScanResultListener-) that are [built from custom camera frames](https://blinkid.github.io/blinkid-android/com/microblink/image/ImageBuilder.html#buildImageFromCamera1NV21Frame-byte:A-int-int-com.microblink.hardware.orientation.Orientation-com.microblink.geometry.Rectangle-). Currently, it is not possible to process multiple images in parallel.
4. Do not forget to [terminate](https://blinkid.github.io/blinkid-android/com/microblink/directApi/RecognizerRunner.html#terminate--) the recognizer runner singleton after usage (it is a shared resource).

Here is the minimum example of usage of direct API for recognizing android Bitmap:

```java
public class DirectAPIActivity extends Activity {
    private RecognizerRunner mRecognizerRunner;
    private MrtdRecognizer mRecognizer;
    private RecognizerBundle mRecognizerBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate();
        // initialize your activity here
        // create MrtdRecognizer
        mRecognizer = new MrtdRecognizer();

        // bundle recognizers into RecognizerBundle
        mRecognizerBundle = new RecognizerBundle(mRecognizer);

        try {
            mRecognizerRunner = RecognizerRunner.getSingletonInstance();
        } catch (FeatureNotSupportedException e) {
            Toast.makeText(this, "Feature not supported! Reason: " + e.getReason().getDescription(), Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        mRecognizerRunner.initialize(this, mRecognizerBundle, new DirectApiErrorListener() {
            @Override
            public void onRecognizerError(Throwable t) {
                Toast.makeText(DirectAPIActivity.this, "There was an error in initialization of Recognizer: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // start recognition
        Bitmap bitmap = BitmapFactory.decodeFile("/path/to/some/file.jpg");
        mRecognizerRunner.recognizeBitmap(bitmap, Orientation.ORIENTATION_LANDSCAPE_RIGHT, mScanResultListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRecognizerRunner.terminate();
    }

    private final ScanResultListener mScanResultListener = new ScanResultListener() {
        @Override
        public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
            // this method is from ScanResultListener and will be called
            // when scanning completes
            // you can obtain scanning result by calling getResult on each
            // recognizer that you bundled into RecognizerBundle.
            // for example:

            MrtdRecognizer.Result result = mRecognizer.getResult();
            if (result.getResultState() == Recognizer.Result.State.Valid) {
                // result is valid, you can use it however you wish
            }
        }
    };

}
```

### <a name="directAPI_strings"></a> Using Direct API for `String` recognition (parsing)

Some recognizers support recognition from `String`. They can be used through Direct API to parse given `String` and return data just like when they are used on an input image. When recognition is performed on `String`, there is no need for the OCR. Input `String` is used in the same way as the OCR output is used when image is being recognized. 

Recognition from `String` can be performed in the same way as recognition from image, described in the [previous section](#directAPI_images). 

The only difference is that one of the [RecognizerRunner singleton](https://blinkid.github.io/blinkid-android/com/microblink/directApi/RecognizerRunner.html) methods for recognition from string should be called:

- [recognizeString](https://blinkid.github.io/blinkid-android/com/microblink/directApi/RecognizerRunner.html#recognizeString-java.lang.String-com.microblink.view.recognition.ScanResultListener-)
- [recognizeStringWithRecognizers](https://blinkid.github.io/blinkid-android/com/microblink/directApi/RecognizerRunner.html#recognizeStringWithRecognizers-java.lang.String-com.microblink.view.recognition.ScanResultListener-com.microblink.entities.recognizers.RecognizerBundle-)


### <a name="directAPIStateMachine"></a> Understanding DirectAPI's state machine

DirectAPI's `RecognizerRunner` singleton is actually a state machine which can be in one of 3 states: `OFFLINE`, `READY` and `WORKING`. 

- When you obtain the reference to `RecognizerRunner` singleton, it will be in `OFFLINE` state. 
- You can initialize `RecognizerRunner` by calling [initialize](https://blinkid.github.io/blinkid-android/com/microblink/directApi/RecognizerRunner.html#initialize-android.content.Context-com.microblink.entities.recognizers.RecognizerBundle-com.microblink.directApi.DirectApiErrorListener-) method. If you call `initialize` method while `RecognizerRunner` is not in `OFFLINE` state, you will get `IllegalStateException`.
- After successful initialization, `RecognizerRunner` will move to `READY` state. Now you can call any of the `recognize*` methods.
- When starting recognition with any of the `recognize*` methods, `RecognizerRunner` will move to `WORKING` state. If you attempt to call these methods while `RecognizerRunner` is not in `READY` state, you will get `IllegalStateException`
- Recognition is performed on background thread so it is safe to call all `RecognizerRunner's` methods from UI thread
- When recognition is finished, `RecognizerRunner` first moves back to `READY` state and then calls the [onScanningDone](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/ScanResultListener.html#onScanningDone-RecognitionSuccessType-) method of the provided [`ScanResultListener`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/ScanResultListener.html). 
- Please note that `ScanResultListener`'s [`onScanningDone`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/ScanResultListener.html#onScanningDone-RecognitionSuccessType-) method will be called on background processing thread, so make sure you do not perform UI operations in this callback. Also note that until the `onScanningDone` method completes, `RecognizerRunner` will not perform recognition of another image or string, even if any of the `recognize*` methods have been called just after transitioning to `READY` state. This is to ensure that results of the recognizers bundled within `RecognizerBundle` associated with `RecognizerRunner` are not modified while possibly being used within `onScanningDone` method.
- By calling [`terminate`](https://blinkid.github.io/blinkid-android/com/microblink/directApi/RecognizerRunner.html#terminate--) method, `RecognizerRunner` singleton will release all its internal resources. Note that even after calling `terminate` you might receive `onScanningDone` event if there was work in progress when `terminate` was called.
- `terminate` method can be called from any `RecognizerRunner` singleton's state
- You can observe `RecognizerRunner` singleton's state with method [`getCurrentState`](https://blinkid.github.io/blinkid-android/com/microblink/directApi/RecognizerRunner.html#getCurrentState--)

### <a name="directAPIWithRecognizer"></a> Using DirectAPI while RecognizerRunnerView is active
Both [RecognizerRunnerView](#recognizerRunnerView) and `RecognizerRunner` use the same internal singleton that manages native code. This singleton handles initialization and termination of native library and propagating recognizers to native library. It is possible to use `RecognizerRunnerView` and `RecognizerRunner` together, as internal singleton will make sure correct synchronization and correct recognition settings are used. If you run into problems while using `RecognizerRunner` in combination with `RecognizerRunnerView`, [let us know](http://help.microblink.com)!


## <a name="processingEvents"></a> Handling processing events with `RecognizerRunner` and `RecognizerRunnerView`

This section will describe how you can subscribe to and handle processing events when using [RecognizerRunner](https://blinkid.github.io/blinkid-android/com/microblink/directApi/RecognizerRunner.html) or [RecognizerRunnerView](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerRunnerView.html). Processing events, also known as _Metadata callbacks_ are purely intended for giving processing feedback on UI or to capture some debug information during development of your app using _BlinkID_ SDK. For that reason, built-in activities and fragments do not support subscribing and handling of those events from third parties - they handle those events internally. If you need to handle those events by yourself, you need to use either [RecognizerRunnerView](#recognizerRunnerView) or [RecognizerRunner](#directAPI).

Callbacks for all events are bundled together into the [MetadataCallbacks](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataCallbacks.html) object. Both [RecognizerRunner](https://blinkid.github.io/blinkid-android/com/microblink/directApi/RecognizerRunner.html#setMetadataCallbacks-com.microblink.metadata.MetadataCallbacks-) and [RecognizerRunnerView](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerRunnerView.html#setMetadataCallbacks-com.microblink.metadata.MetadataCallbacks-) have methods which allow you to set all your callbacks.

We suggest that you check for more information about available callbacks and events to which you can handle in the [javadoc for MetadataCallbacks class](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataCallbacks.html).

### <a name="processingEventsImportantNote"></a> Note about the `setMetadataCallbacks` method

Please note that both those methods need to pass information about available callbacks to the native code and for efficiency reasons this is done at the time `setMetadataCallbacks` method is called and **not every time** when change occurs within the `MetadataCallbacks` object. This means that if you, for example, set `QuadDetectionCallback` to `MetadataCallbacks` **after** you already called `setMetadataCallbacks` method, the `QuadDetectionCallback` will not be registered with the native code and you will not receive its events.

Similarly, if you, for example, remove the `QuadDetectionCallback` from `MetadataCallbacks` object **after** you already called `setMetadataCallbacks` method, your app will crash with `NullPointerException` when our processing code attempts to invoke the method on removed callback (which is now set to `null`). We **deliberately** do not perform `null` check here because of two reasons:

- it is inefficient
- having `null` callback, while still being registered to native code is illegal state of your program and it should therefore crash

**Remember**, each time you make some changes to `MetadataCallbacks` object, you need to apply those changes to to your `RecognizerRunner` or `RecognizerRunnerView` by calling its `setMetadataCallbacks` method.

# <a name="availableRecognizers"></a> `Recognizer` concept and `RecognizerBundle`

This section will first describe [what is a `Recognizer`](#recognizerConcept) and how it should be used to perform recognition of the images, videos and camera stream. Next, [we will describe how `RecognizerBundle`](#recognizerBundle) can be used to tweak the recognition procedure and to transfer `Recognizer` objects between activities.

[RecognizerBundle](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/RecognizerBundle.html) is an object which wraps the [Recognizers](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/Recognizer.html) and defines settings about how recognition should be performed. Besides that, `RecognizerBundle` makes it possible to transfer `Recognizer` objects between different activities, which is required when using built-in activities to perform scanning, as described in [first scan section](#quickScan), but is also handy when you need to pass `Recognizer` objects between your activities.

List of all available `Recognizer` objects, with a brief description of each `Recognizer`, its purpose and recommendations how it should be used to get best performance and user experience, can be found [here](#recognizerList) .

## <a name="recognizerConcept"></a> The `Recognizer` concept

The [Recognizer](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/Recognizer.html) is the basic unit of processing within the _BlinkID_ SDK. Its main purpose is to process the image and extract meaningful information from it. As you will see [later](#recognizerList), the _BlinkID_ SDK has lots of different `Recognizer` objects that have various purposes.

Each `Recognizer` has a `Result` object, which contains the data that was extracted from the image. The `Result` object is a member of corresponding `Recognizer` object its lifetime is bound to the lifetime of its parent `Recognizer` object. If you need your `Result` object to outlive its parent `Recognizer` object, you must make a copy of it by calling its method [`clone()`](https://blinkid.github.io/blinkid-android/com/microblink/entities/Entity.Result.html#clone--).

Every `Recognizer` is a stateful object, that can be in two states: _idle state_ and _working state_. While in _idle state_, you can tweak `Recognizer` object's properties via its getters and setters. After you bundle it into a `RecognizerBundle` and use either [RecognizerRunner](https://blinkid.github.io/blinkid-android/com/microblink/directApi/RecognizerRunner.html) or [RecognizerRunnerView](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerRunnerView.html) to _run_ the processing with all `Recognizer` objects bundled within `RecognizerBundle`, it will change to _working state_ where the `Recognizer` object is being used for processing. While being in _working state_, you cannot tweak `Recognizer` object's properties. If you need to, you have to create a copy of the `Recognizer` object by calling its [`clone()`](https://blinkid.github.io/blinkid-android/com/microblink/entities/Entity.html#clone--), then tweak that copy, bundle it into a new `RecognizerBundle` and use [`reconfigureRecognizers`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerRunnerView.html#reconfigureRecognizers-com.microblink.entities.recognizers.RecognizerBundle-) to ensure new bundle gets used on processing thread.

While `Recognizer` object works, it changes its internal state and its result. The `Recognizer` object's `Result` always starts in [Empty state](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/Recognizer.Result.State.html#Empty). When corresponding `Recognizer` object performs the recognition of given image, its `Result` can either stay in `Empty` state (in case `Recognizer` failed to perform recognition), move to [Uncertain state](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/Recognizer.Result.State.html#Uncertain) (in case `Recognizer` performed the recognition, but not all mandatory information was extracted) or move to [Valid state](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/Recognizer.Result.State.html#Valid) (in case `Recognizer` performed recognition and all mandatory information was successfully extracted from the image).

As soon as one `Recognizer` object's `Result` within `RecognizerBundle` given to `RecognizerRunner` or `RecognizerRunnerView` changes to `Valid` state, the [`onScanningDone`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/ScanResultListener.html#onScanningDone-RecognitionSuccessType-) callback will be invoked on same thread that performs the background processing and you will have the opportunity to inspect each of your `Recognizer` objects' `Results` to see which one has moved to `Valid` state.

As already stated in [section about `RecognizerRunnerView`](#recognizerRunnerView), as soon as `onScanningDone` method ends, the `RecognizerRunnerView` will continue processing new camera frames with same `Recognizer` objects, unless [paused](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerRunnerView.html#pauseScanning--). Continuation of processing or [resetting recognition](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerRunnerView.html#resetRecognitionState--) will modify or reset all `Recognizer` objects's `Results`. When using built-in activities, as soon as `onScanningDone` is invoked, built-in activity pauses the `RecognizerRunnerView` and starts finishing the activity, while saving the `RecognizerBundle` with active `Recognizer` objects into `Intent` so they can be transferred back to the calling activities.


## <a name="recognizerBundle"></a> `RecognizerBundle`

The [RecognizerBundle](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/RecognizerBundle.html) is wrapper around [Recognizers](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/Recognizer.html) objects that can be used to transfer `Recognizer` objects between activities and to give `Recognizer` objects to `RecognizerRunner` or `RecognizerRunnerView` for processing.

The `RecognizerBundle` is always [constructed with array](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/RecognizerBundle.html#RecognizerBundle-com.microblink.entities.recognizers.Recognizer:A-) of `Recognizer` objects that need to be prepared for recognition (i.e. their properties must be tweaked already). The _varargs_ constructor makes it easier to pass `Recognizer` objects to it, without the need of creating a temporary array.

The `RecognizerBundle` manages a chain of `Recognizer` objects within the recognition process. When a new image arrives, it is processed by the first `Recognizer` in chain, then by the second and so on, iterating until a `Recognizer` object's `Result` changes its state to `Valid` or all of the `Recognizer` objects in chain were invoked (none getting a `Valid` result state). If you want to invoke all `Recognizers` in the chain, regardless of whether some `Recognizer` object's `Result` in chain has changed its state to `Valid` or not, you can [allow returning of multiple results on a single image](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/RecognizerBundle.html#setAllowMultipleScanResultsOnSingleImage-boolean-).

You cannot change the order of the `Recognizer` objects within the chain - no matter the order in which you give `Recognizer` objects to `RecognizerBundle`, they are internally ordered in a way that provides best possible performance and accuracy. Also, in order for _BlinkID_ SDK to be able to order `Recognizer` objects in recognition chain in the best way possible, it is not allowed to have multiple instances of `Recognizer` objects of the same type within the chain. Attempting to do so will crash your application.

### <a name="intentOptimization"></a> Passing `Recognizer` objects between activities

Besides managing the chain of `Recognizer` objects, `RecognizerBundle` also manages transferring bundled `Recognizer` objects between different activities within your app. Although each `Recognizer` object, and each its `Result` object implements [Parcelable interface](https://developer.android.com/reference/android/os/Parcelable.html), it is not so straightforward to put those objects into [Intent](https://developer.android.com/reference/android/content/Intent.html) and pass them around between your activities and services for two main reasons:

- `Result` object is tied to its `Recognizer` object, which manages lifetime of the native `Result` object.
- `Result` object often contains large data blocks, such as images, which cannot be transferred via `Intent` because of [Android's Intent transaction data limit](https://developer.android.com/reference/android/os/TransactionTooLargeException.html).

Although the first problem can be easily worked around by making a [copy](https://blinkid.github.io/blinkid-android/com/microblink/entities/Entity.Result.html#clone--) of the `Result` and transfer it independently, the second problem is much tougher to cope with. This is where, `RecognizerBundle's` methods [saveToIntent](https://blinkid.github.io/blinkid-android/com/microblink/intent/IntentTransferableBundle.html#saveToIntent-android.content.Intent-) and [loadFromIntent](https://blinkid.github.io/blinkid-android/com/microblink/intent/IntentTransferableBundle.html#loadFromIntent-android.content.Intent-) come to help, as they ensure the safe passing of `Recognizer` objects bundled within `RecognizerBundle` between activities according to policy defined with method [`setIntentDataTransferMode`](https://blinkid.github.io/blinkid-android/com/microblink/MicroblinkSDK.html#setIntentDataTransferMode-com.microblink.intent.IntentDataTransferMode-):

- if set to [`STANDARD`](https://blinkid.github.io/blinkid-android/com/microblink/intent/IntentDataTransferMode.html#STANDARD), the `Recognizer` objects will be passed via `Intent` using normal _Intent transaction mechanism_, which is limited by [Android's Intent transaction data limit](https://developer.android.com/reference/android/os/TransactionTooLargeException.html). This is same as manually putting `Recognizer` objects into `Intent` and is OK as long as you do not use `Recognizer` objects that produce images or other large objects in their `Results`.
- if set to [`OPTIMISED`](https://blinkid.github.io/blinkid-android/com/microblink/intent/IntentDataTransferMode.html#OPTIMISED), the `Recognizer` objects will be passed via internal singleton object and no serialization will take place. This means that there is no limit to the size of data that is being passed. This is also the fastest transfer method, but it has a serious drawback - if Android kills your app to save memory for other apps and then later restarts it and redelivers `Intent` that should contain `Recognizer` objects, the internal singleton that should contain saved `Recognizer` objects will be empty and data that was being sent will be lost. You can easily provoke that condition by choosing _No background processes_ under _Limit background processes_ in your device's _Developer options_, and then switch from your app to another app and then back to your app.
- if set to [`PERSISTED_OPTIMISED`](https://blinkid.github.io/blinkid-android/com/microblink/intent/IntentDataTransferMode.html#PERSISTED_OPTIMISED), the `Recognizer` objects will be passed via internal singleton object (just like in `OPTIMISED` mode) and will additionaly be serialized into a file in your application's private folder. In case Android restarts your app and internal singleton is empty after re-delivery of the `Intent`, the data will be loaded from file and nothing will be lost. The files will be automatically cleaned up when data reading takes place. Just like `OPTIMISED`, this mode does not have limit to the size of data that is being passed and does not have a drawback that `OPTIMISED` mode has, but some users might be concerned about files to which data is being written. 
    - These files **will** contain end-user's private data, such as image of the object that was scanned and the extracted data. Also these files **may** remain saved in your application's private folder until the next successful reading of data from the file. 
    - If your app gets restarted multiple times, only after first restart will reading succeed and will delete the file after reading. If multiple restarts take place, you must implement [`onSaveInstanceState`](https://developer.android.com/reference/android/app/Activity.html#onSaveInstanceState(android.os.Bundle)) and save bundle back to file by calling its [`saveState`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/RecognizerBundle.html#saveState--) method. Also, after saving state, you should ensure that you [clear saved state](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/RecognizerBundle.html#clearSavedState--) in your [`onResume`](https://developer.android.com/reference/android/app/Activity.html#onResume()), as [`onCreate`](https://developer.android.com/reference/android/app/Activity.html#onCreate(android.os.Bundle)) may not be called if activity is not restarted, while `onSaveInstanceState` may be called as soon as your activity goes to background (before `onStop`), even though activity may not be killed at later time. 
    - If saving data to file in private storage is a concern to you, you should use either `OPTIMISED` mode to transfer large data and image between activities or create your own mechanism for data transfer. Note that your application's private folder is only accessible by your application and your application alone, unless the end-user's device is rooted.

# <a name="recognizerList"></a> List of available recognizers

This section will give a list of all `Recognizer` objects that are available within _BlinkID_ SDK, their purpose and recommendations how they should be used to get best performance and user experience.

## <a name="frameGrabberRecognizer"></a> Frame Grabber Recognizer

The [`FrameGrabberRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/framegrabber/FrameGrabberRecognizer.html) is the simplest recognizer in _BlinkID_ SDK, as it does not perform any processing on the given image, instead it just returns that image back to its [`FrameCallback`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/framegrabber/FrameCallback.html). Its [Result](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/framegrabber/FrameGrabberRecognizer.Result.html) never changes state from [Empty](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/Recognizer.Result.State.html#Empty).

This recognizer is best for easy capturing of camera frames with [`RecognizerRunnerView`](#recognizerRunnerView). Note that [`Image`](https://blinkid.github.io/blinkid-android/com/microblink/image/Image.html) sent to [`onFrameAvailable`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/framegrabber/FrameCallback.html#onFrameAvailable-com.microblink.image.Image-boolean-double-) are temporary and their internal buffers all valid only until the `onFrameAvailable` method is executing - as soon as method ends, all internal buffers of `Image` object are disposed. If you need to store `Image` object for later use, you must create a copy of it by calling [`clone`](https://blinkid.github.io/blinkid-android/com/microblink/image/Image.html#clone--).

Also note that [`FrameCallback`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/framegrabber/FrameCallback.html) interface extends [Parcelable interface](https://developer.android.com/reference/android/os/Parcelable.html), which means that when implementing `FrameCallback` interface, you must also implement `Parcelable` interface. 

This is especially important if you plan to transfer `FrameGrabberRecognizer` between activities - in that case, keep in mind that the instance of your object may not be the same as the instance on which `onFrameAvailable` method gets called - the instance that receives `onFrameAvailable` calls is the one that is created within activity that is performing the scan.

## <a name="successFrameGrabberRecognizer"></a> Success Frame Grabber Recognizer

The [`SuccessFrameGrabberRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/successframe/SuccessFrameGrabberRecognizer.html) is a special `Recognizer` that wraps some other `Recognizer` and impersonates it while processing the image. However, when the `Recognizer` being impersonated changes its `Result` into `Valid` state, the `SuccessFrameGrabberRecognizer` captures the image and saves it into its own `Result` object.

Since `SuccessFrameGrabberRecognizer` impersonates its slave `Recognizer` object, it is not possible to give both concrete `Recognizer` object and `SuccessFrameGrabberRecognizer` that wraps it to same `RecognizerBundle` - doing so will have the same result as if you have given two instances of same `Recognizer` type to the `RecognizerBundle` - it will crash your application.

This recognizer is best for use cases when you need to capture the exact image that was being processed by some other `Recognizer` object at the time its `Result` became `Valid`. When that happens, `SuccessFrameGrabber's` [`Result`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/successframe/SuccessFrameGrabberRecognizer.Result.html) will also become `Valid` and will contain described image. That image can then be retrieved with [`getSuccessFrame()`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/successframe/SuccessFrameGrabberRecognizer.Result.html#getSuccessFrame--) method.

## <a name="pdf417Recognizer"></a> PDF417 recognizer

The [`Pdf417Recognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkbarcode/pdf417/Pdf417Recognizer.html) is recognizer specialised for scanning [PDF417 2D barcodes](https://en.wikipedia.org/wiki/PDF417). This recognizer can recognize only PDF417 2D barcodes - for recognition of other barcodes, please refer to [BarcodeRecognizer](#barcodeRecognizer).

This recognizer can be used in any context, but it works best with the [`BarcodeScanActivity`](https://blinkid.github.io/blinkid-android/com/microblink/activity/BarcodeScanActivity.html), which has UI best suited for barcode scanning.

## <a name="barcodeRecognizer"></a> Barcode recognizer

The [`BarcodeRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkbarcode/barcode/BarcodeRecognizer.html) is recognizer specialised for scanning various types of barcodes. This recognizer should be your first choice when scanning barcodes as it supports lots of barcode symbologies, including the [PDF417 2D barcodes](https://en.wikipedia.org/wiki/PDF417), thus making [PDF417 recognizer](#pdf417Recognizer) possibly redundant, which was kept only for its simplicity.

As you can see from [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkbarcode/barcode/BarcodeRecognizer.html), you can enable multiple barcode symbologies within this recognizer, however keep in mind that enabling more barcode symbologies affects scanning performance - the more barcode symbologies are enabled, the slower the overall recognition performance. Also, keep in mind that some simple barcode symbologies that lack proper redundancy, such as [Code 39](https://en.wikipedia.org/wiki/Code_39), can be recognized within more complex barcodes, especially 2D barcodes, like [PDF417](https://en.wikipedia.org/wiki/PDF417).

This recognizer can be used in any context, but it works best with the [`BarcodeScanActivity`](https://blinkid.github.io/blinkid-android/com/microblink/activity/BarcodeScanActivity.html), which has UI best suited for barcode scanning.
## <a name="blinkInputRecognizer"></a> BlinkInput recognizer

The [`BlinkInputRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkinput/BlinkInputRecognizer.html) is generic OCR recognizer used for scanning segments which enables specifying `Processors` that will be used for scanning. Most commonly used `Processor` within this recognizer is [`ParserGroupProcessor`](https://blinkid.github.io/blinkid-android/com/microblink/entities/processors/parserGroup/ParserGroupProcessor.html) that activates all `Parsers` in the group to extract data of interest from the OCR result.

This recognizer can be used in any context. It is used internally in the implementation of the provided [`FieldByFieldOverlayController`](https://blinkid.github.io/blinkid-android/com/microblink/fragment/overlay/FieldByFieldOverlayController.html).

`Processors` are explained in [The Processor concept](#processorConcept) section and you can find more about `Parsers` in [The Parser concept](#parserConcept) section.


## <a name="detectorRecognizer"></a> Detector recognizer

The [`DetectorRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/detector/DetectorRecognizer.html) is recognizer for scanning generic documents using custom `Detector`. You can find more about `Detector` in [The Detector concept](#detectorConcept) section. `DetectorRecognizer` can be used simply for document detection and obtaining its image. The more interesting use case is data extraction from the custom document type. `DetectorRecognizer` performs document detection and can be configured to extract fields of interest from the scanned document by using **Templating API**. You can find more about Templating API in [this](#detectorTemplating) section.  

This recognizer can be used in any context, but it works best with the activity which has UI suited for document scanning.
## <a name="blinkcard_recognizers"></a> BlinkCard recognizers

BlinkCard recognizers work best with the [`BlinkCardActivity`](#blinkcardUiComponent), which has UI best suited for payment / debit card scanning. 

### <a name="blink_card_combined"></a> BlinkCard recognizer
The [`BlinkCardRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkcard/BlinkCardRecognizer.html) scans back side of Payment / Debit card after scanning the front side and combines data from both sides. 

### <a name="elite_blink_card_combined"></a> BlinkCardElite recognizer
The [`BlinkCardEliteRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkcard/BlinkCardEliteRecognizer.html) scans back side of elite Payment / Debit card after scanning the front side and combines data from both sides.
## <a name="simNumberRecognizer"></a> SIM number recognizer

The [`SimNumberRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkbarcode/simnumber/SimNumberRecognizer.html) is a special type of barcode recognizer specifically tailored for performing recognition of barcodes on packagings of [SIM cards](https://en.wikipedia.org/wiki/Subscriber_identity_module). This recognizer is useful in combination with some ID recognizers in use cases when application requires quick scanning of SIM number on the packaging of new mobile network subscriber after scanning the new subscriber's identity document.

This recognizer can be used in any context. However, we recommend its usage in combination with any ID document recognizer within custom UI.

## <a name="blinkid_recognizers"></a> BlinkID recognizers

Unless stated otherwise for concrete recognizer, **single side BlinkID recognizes** from this list can be used in any context, but they work best with the [`DocumentScanActivity`](#documentUiComponent), which has UI best suited for document scanning. 

**Combined recognizers** should be used with [`DocumentVerificationActivity`](#documentVerifyUiComponent) which manages scanning of multiple document sides in the single camera opening and guides the user through the scanning process. Some combined recognizers support scanning of multiple document types, but only one document type can be scanned at a time.

### <a name="mrtdRecognizer"></a> Machine Readable Travel Document recognizer
The [`MrtdRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/mrtd/MrtdRecognizer.html) is used for scanning and data extraction from the Machine Readable Zone (MRZ) of the various Machine Readable Travel Documents (MRTDs) like ID cards and passports. This recognizer is not bound to the specific country, but it can be configured to only return data that match some criteria defined by the [`MrzFilter`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/mrtd/MrzFilter.html).

The `MrtdRecognizer` can also be configured to extract additional fields of interest from the scanned document, which are not part of the Machine Readable Zone, by using **Templating API**. You can find more about Templating API in [this](#mrtdTemplating) section.

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).

### <a name="mrtd_combined_recognizer"></a> Machine Readable Travel Document combined recognizer
The [`MrtdCombinedRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/mrtd/MrtdCombinedRecognizer.html) scans Machine Readable Zone (MRZ) after scanning the full document image and face image (usually MRZ is on the back side and face image is on the front side of the document). Internally, it uses [DocumentFaceRecognizer](#documentFaceRecognizer) for obtaining full document image and face image as the first step and then [MrtdRecognizer](#mrtdRecognizer) for scanning the MRZ.

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).

### <a name="us_dl_recognizer"></a> US / Canada driver's license barcode recognizer
The [`UsdlRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkbarcode/usdl/UsdlRecognizer.html) is used for scanning PDF417 barcode from the US / Canada driver's license.

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).

### <a name="us_dl_combined_recognizer"></a> US / Canada driver's license combined recognizer
The [`UsdlCombinedRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/usdl/UsdlCombinedRecognizer.html) scans PDF417 barcode from the back side of US / Canada driver's license after scanning the full document image and face image from the front side. Internally, it uses [DocumentFaceRecognizer](#documentFaceRecognizer) for obtaining full document image and face image as the first step and then [UsdlRecognizer](#us_dl_recognizer) for scanning the PDF417 barcode.

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).

### <a name="eudlRecognizer"></a> EU Driver's License recognizer
The [`EudlRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/eudl/EudlRecognizer.html) is used for scanning front side of European Union driver's licenses. Currently, driver's licenses from these countries are supported:

- Austria
- Germany
- United Kingdom

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).

### <a name="documentFaceRecognizer"></a> Document face recognizer
The [`DocumentFaceRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/documentface/DocumentFaceRecognizer.html) is a special type of recognizer that only returns face image and full document image of the scanned document. It does not extract document fields like first name, last name, etc. This generic recognizer can be used to obtain document images in cases when specific support for some document type is not available.

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).

## <a name="blinkid_recognizers_countries"></a> Country-specific BlinkID recognizers

### <a name="blinkid_recognizers_australia"></a> Australia

#### <a name="australia_dl"></a> Ausralia driver's license front and back side recognizers
The [`AustraliaDlFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/australia/AustraliaDlFrontRecognizer.html) and [`AustraliaDlBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/australia/AustraliaDlBackRecognizer.html) are used for scanning [Australian driver's license front and back side](https://en.wikipedia.org/wiki/Driving_licence_in_Australia).

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).


### <a name="blinkid_recognizers_austria"></a> Austria

For all recognizers, you can find information about usage context at the beginning of [this section](#blinkid_recognizers).

#### <a name="austria_id"></a> Austria ID front and back side recognizers
The [`AustriaIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/austria/AustriaIdFrontRecognizer.html) and [`AustriaIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/austria/AustriaIdBackRecognizer.html) are used for scanning the [front and back side of Austrian identity card](https://en.wikipedia.org/wiki/Austrian_identity_card).

#### <a name="austria_passport"></a> Austria passport recognizer
The [`AustriaPassportRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/austria/AustriaPassportRecognizer.html) is used for scanning the data page of [Austrian passport](https://en.wikipedia.org/wiki/Austrian_passport).

#### <a name="austria_combined"></a> Austria combined recognizer
The [`AustriaCombinedRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/austria/AustriaCombinedRecognizer.html) scans one of the following document types:

- back side of Austrian ID after scanning the front side and combines data from both sides
- Austrian passport

#### <a name="austria_dl"></a> Austria driver's license recognizer
The [`AustriaDlFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/austria/AustriaDlFrontRecognizer.html) is used for scanning [the front side of Austrian driver's license](https://en.wikipedia.org/wiki/Driving_licence_in_Austria).


### <a name="blinkid_recognizers_brunei"></a> Brunei

#### <a name="brunei_id"></a> Brunei ID front and back side recognizer
The [`BruneiIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/brunei/BruneiIdFrontRecognizer.html) and [`BruneiIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/brunei/BruneiIdBackRecognizer.html) are used for scanning the front and back side of Bruneian identity card.

#### <a name="brunei_military_id"></a> Brunei Military ID front and back side recognizer
The [`BruneiMilitaryIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/brunei/BruneiMilitaryIdFrontRecognizer.html) and [`BruneiMilitaryIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/brunei/BruneiMilitaryIdBackRecognizer.html) are used for scanning the front and back side of Bruneian military identity card.

#### <a name="brunei_residence_permit"></a> Brunei residence permit front and back side recognizer
The [`BruneiResidencePermitFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/brunei/BruneiResidencePermitFrontRecognizer.html) and [`BruneiResidencePermitBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/brunei/BruneiResidencePermitBackRecognizer.html)  are used for scanning the front and back side of Bruneian residence permit.

#### <a name="brunei_temp_residence_permit"></a> Brunei temporary residence permit front and back side recognizer
The [`BruneiTemporaryResidencePermitFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/brunei/BruneiTemporaryResidencePermitFrontRecognizer.html) and [`BruneiTemporaryResidencePermitBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/brunei/BruneiTemporaryResidencePermitBackRecognizer.html) are used for scanning the front and back side of Bruneian residence permit.

### <a name="blinkid_recognizers_colombia"></a> Colombia

#### <a name="colombia_id"></a> Colombia ID front and back side recognizers
The [`ColombiaIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/colombia/ColombiaIdFrontRecognizer.html) and [`ColombiaIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/colombia/ColombiaIdBackRecognizer.html) are used for scanning the front and back side of Colombian identity card.

#### <a name="colombia_dl"></a> Colombia driver's license front side recognizer
The [`ColombiaDlFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/colombia/ColombiaDlFrontRecognizer.html) is used for scanning the front side of Colombian driver's license.


### <a name="blinkid_recognizers_croatia"></a> Croatia

For all recognizers, you can find information about usage context at the beginning of [this section](#blinkid_recognizers).

#### <a name="croatia_id"></a> Croatia ID front and back side recognizers
The [`CroatiaIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/croatia/CroatiaIdFrontRecognizer.html) and [`CroatiaIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/croatia/CroatiaIdBackRecognizer.html) are used for scanning the [front and back side of Croatian identity card](https://en.wikipedia.org/wiki/Croatian_identity_card).

#### <a name="croatia_combined"></a> Croatia combined recognizer
The [`CroatiaCombinedRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/croatia/CroatiaCombinedRecognizer.html) scans back side of Croatian ID after scanning the front side and combines data from both sides.


### <a name="blinkid_recognizers_cyprus"></a> Cyprus

#### <a name="cyprus_id"></a> Cyprus ID front and back side recognizers
The [`CyprusIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/cyprus/CyprusIdFrontRecognizer.html) and [`CyprusIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/cyprus/CyprusIdBackRecognizer.html) are used for scanning the [front and back side of Cyprus identity card, issued in 2015. or later](https://en.wikipedia.org/wiki/Cypriot_identity_card).

#### <a name="cyprus_idOld"></a> Cyprus Old ID front and back side recognizers
The [`CyprusOldIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/cyprus/CyprusOldIdFrontRecognizer.html) and [`CyprusOldIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/cyprus/CyprusOldIdBackRecognizer.html) are used for scanning the [front and back side of Cyprus Old identity card, issued before 2015] (https://en.wikipedia.org/wiki/Cypriot_identity_card).

### <a name="blinkid_recognizers_czechia"></a> Czechia

For all recognizers, you can find information about usage context at the beginning of [this section](#blinkid_recognizers).

#### <a name="czechia_id"></a> Czechia ID front and back side recognizers
The [`CzechiaIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/czechia/CzechiaIdFrontRecognizer.html) and [`CzechiaIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/czechia/CzechiaIdBackRecognizer.html) are used for scanning the [front and back side of Czech identity card](https://en.wikipedia.org/wiki/Czech_national_identity_card).

#### <a name="czechia_combined"></a> Czechia combined recognizer
The [`CzechiaCombinedRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/czechia/CzechiaCombinedRecognizer.html) scans back side of Czech ID after scanning the front side and combines data from both sides.


### <a name="blinkid_recognizers_egypt"></a> Egypt

#### <a name="egypt_id_front"></a> Egypt ID front side recognizer
The [`EgyptIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/egypt/EgyptIdFrontRecognizer.html) is used for scanning [front side of Egyptian identity card](http://www.identity-cards.net/record/egypt).

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).


### <a name="blinkid_recognizers_germany"></a> Germany

For all recognizers, you can find information about usage context at the beginning of [this section](#blinkid_recognizers).

#### <a name="germany_id"></a> Germany ID front and back side recognizers
The [`GermanyIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/germany/GermanyIdFrontRecognizer.html) and [`GermanyIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/germany/GermanyIdBackRecognizer.html) are used for scanning the [front and back side of German identity card](https://en.wikipedia.org/wiki/German_identity_card) issued after 1 November 2010.

#### <a name="germany_idOld"></a> Old Germany ID front side recognizer
The [`GermanyIdOldRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/germany/GermanyIdOldRecognizer.html) is used for scanning [front side of German identity card](https://en.wikipedia.org/wiki/German_identity_card) issued between 1 April 1987 and 31 October 2010.

#### <a name="germany_passport"></a> Germany passport recognizer
The [`GermanyPassportRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/germany/GermanyPassportRecognizer.html) is used for scanning the data page of [German passport](https://en.wikipedia.org/wiki/German_passport).

#### <a name="germany_combined"></a> Germany combined recognizer
The [`GermanyCombinedRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/germany/GermanyCombinedRecognizer.html) scans one of the following document types:

- back side of new German ID after scanning the front side and combines data from both sides
- front side of old German ID
- German passport

#### <a name="germany_dl"></a> Scanning German driver's license
For scanning [the front side of German driver's license](https://en.wikipedia.org/wiki/Driving_licence_in_Germany), [`GermanyDlFrontRecognizer `](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/germany/GermanyDlFrontRecognizer.html) is used. For the back side, use [`GermanyDlBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/germany/GermanyDlBackRecognizer.html).


### <a name="blinkid_recognizers_hongkong"></a> HongKong

#### <a name="hongkong_id"></a> Hong Kong ID front side recognizer
The [`HongKongIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/hongkong/HongKongIdFrontRecognizer.html) is used for scanning [front side of Hong Kong identity card](https://en.wikipedia.org/wiki/Hong_Kong_Identity_Card).

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).


### <a name="blinkid_recognizers_indonesia"></a> Indonesia

#### <a name="indonesia_id"></a> Indonesia ID front side recognizer
The [`IndonesiaIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/indonesia/IndonesiaIdFrontRecognizer.html) is used for scanning [front side of Indonesian identity card](https://en.wikipedia.org/wiki/Indonesian_identity_card).

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).


### <a name="blinkid_recognizers_ireland"></a> Ireland

#### <a name="ireland_dl"></a> Ireland driver's license front side recognizer
The [`IrelandDlFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/ireland/IrelandDlFrontRecognizer.html) is used for scanning [front side of Irish driver's license](https://en.wikipedia.org/wiki/Driving_licence_in_the_Republic_of_Ireland).

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).

### <a name="blinkid_recognizers_italy"></a> Italy

#### <a name="italy_dl"></a> Italy driver's license front side recognizer
The [`ItalyDlFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/italy/ItalyDlFrontRecognizer.html) is used for scanning [front side of Italian driver's license](https://en.wikipedia.org/wiki/Driving_licence_in_Italy).

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).


### <a name="blinkid_recognizers_jordan"></a> Jordan

For all recognizers, you can find information about usage context at the beginning of [this section](#blinkid_recognizers).

#### <a name="jordan_id"></a> Jordan ID front and back side recognizers
The [`JordanIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/jordan/JordanIdFrontRecognizer.html) and [`JordanIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/jordan/JordanIdBackRecognizer.html) are used for scanning the front and back side of Jordanian identity card.

#### <a name="jordan_combined"></a> Jordan combined recognizer
The [`JordanCombinedRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/jordan/JordanCombinedRecognizer.html) scans back side of Jordanian ID after scanning the front side and combines data from both sides.


### <a name="blinkid_recognizers_kuwait"></a> Kuwait

#### <a name="kuwait_id"></a> Kuwait ID front and back side recognizers
The [`KuwaitIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/kuwait/KuwaitIdFrontRecognizer.html) and [`KuwaitIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/kuwait/KuwaitIdBackRecognizer.html) are used for scanning the front and back side of [Kuwaiti identity card](https://en.wikipedia.org/wiki/Kuwaiti_identity_card).


### <a name="blinkid_recognizers_malaysia"></a> Malaysia

For all recognizers, you can find information about usage context at the beginning of [this section](#blinkid_recognizers).

#### <a name="malaysia_mykad"></a> Malaysian MyKad front and back side recognizers
The [`MalaysiaMyKadFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/malaysia/MalaysiaMyKadFrontRecognizer.html) and [`MalaysiaMyKadBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/malaysia/MalaysiaMyKadBackRecognizer.html) are used for scanning the [front and back side of Malaysian MyKad card](https://en.wikipedia.org/wiki/Malaysian_identity_card).

#### <a name="malaysia_ikad"></a> Malaysian iKad front side recognizer
The [`MalaysiaIkadFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/malaysia/MalaysiaIkadFrontRecognizer.html) is used for scanning front side of Malaysian iKad (immigrator) card.

#### <a name="malaysia_mykas"></a> Malaysian MyKAS front side recognizer
The [`MalaysiaMyKasFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/malaysia/MalaysiaMyKasFrontRecognizer.html) is used for scanning [front side of Malaysian MyKAS card](https://en.wikipedia.org/wiki/Malaysian_identity_card).

#### <a name="malaysia_mypr"></a> Malaysian MyPR front side recognizer
The [`MalaysiaMyPrFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/malaysia/MalaysiaMyPrFrontRecognizer.html) is used for scanning [front side of Malaysian MyPR card](https://en.wikipedia.org/wiki/Malaysian_identity_card).

#### <a name="malaysia_mytentera"></a> Malaysian MyTentera front side recognizer
The [`MalaysiaMyTenteraFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/malaysia/MalaysiaMyTenteraFrontRecognizer.html) is used for scanning [front side of Malaysian MyTentera card](https://en.wikipedia.org/wiki/Malaysian_identity_card).

#### <a name="malaysia_dl"></a> Malaysian driver's license front side recognizer
The [`MalaysiaDlFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/malaysia/MalaysiaDlFrontRecognizer.html) is used for scanning [front side of Malaysian driver's license](https://en.wikipedia.org/wiki/Driving_licence_in_Malaysia).


### <a name="blinkid_recognizers_mexico"></a> Mexico

#### <a name="mexico_voter_id"></a> Mexico Voter ID front side recognizer
The [`MexicoVoterIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/mexico/MexicoVoterIdFrontRecognizer.html) is used for scanning front side of the Mexico voter identity card.

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).


### <a name="blinkid_recognizers_morocco"></a> Morocco

#### <a name="morocco_id"></a> Morocco ID front and back side recognizers
The [`MoroccoIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/morocco/MoroccoIdFrontRecognizer.html) and [`MoroccoIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/morocco/MoroccoIdBackRecognizer.html) are used for scanning front and back side of the Morocco identity card.

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).


### <a name="blinkid_recognizers_newzealand"></a> New Zealand

#### <a name="newzealand_dl"></a> New Zealand driver's license front side recognizer
The [`NewZealandDlFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/newzealand/NewZealandDlFrontRecognizer.html) is used for scanning front side of New Zealand driver's license.

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).


### <a name="blinkid_recognizers_nigeria"></a> Nigeria

#### <a name="nigeria_dl"></a> Scanning Nigerian driver's license
For scanning the PDF417 barcode from the Nigerian driver's license, [`UsdlRecognizer`](#us_dl_recognizer) is used.

The [`UsdlCombinedRecognizer`](#us_dl_combined_recognizer) can also be used for scanning the PDF417 barcode from the back side of Nigerian driver's license after scanning the full document image and face image from the front side.


### <a name="blinkid_recognizers_poland"></a> Poland

For all recognizers, you can find information about usage context at the beginning of [this section](#blinkid_recognizers).

#### <a name="poland_id"></a> Poland ID front and back side recognizers
The [`PolandIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/poland/PolandIdFrontRecognizer.html) and [`PolandIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/poland/PolandIdBackRecognizer.html) are used for scanning the [front and back side of Polish identity card](https://en.wikipedia.org/wiki/Polish_identity_card).

#### <a name="poland_combined"></a> Poland combined recognizer
The [`PolandCombinedRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/poland/PolandCombinedRecognizer.html) scans back side of Polish ID after scanning the front side and combines data from both sides.


### <a name="blinkid_recognizers_romania"></a> Romania

#### <a name="romania_id"></a> Romania ID front side recognizer
The [`RomaniaIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/romania/RomaniaIdFrontRecognizer.html) is used for scanning [front side of Romanian identity card](https://en.wikipedia.org/wiki/Romanian_identity_card).

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).


### <a name="blinkid_recognizers_singapore"></a> Singapore

For all recognizers, you can find information about usage context at the beginning of [this section](#blinkid_recognizers).

#### <a name="singapore_id"></a> Singapore ID front and back side recognizers
The [`SingaporeIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/singapore/SingaporeIdFrontRecognizer.html) and [`SingaporeIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/singapore/SingaporeIdBackRecognizer.html) are used for scanning the [front and back side of Singapore identity card](https://en.wikipedia.org/wiki/National_Registration_Identity_Card).

#### <a name="singapore_combined"></a> Singapore combined recognizer
The [`SingaporeCombinedRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/singapore/SingaporeCombinedRecognizer.html) scans back side of Singapore ID after scanning the front side and combines data from both sides.

#### <a name="singapore_dl"></a> Singapore driver's license front side recognizer
The [`SingaporeDlFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/singapore/SingaporeDlFrontRecognizer.html) is used for scanning the front side of [driving license in Singapore](https://en.wikipedia.org/wiki/Driving_licence_in_Singapore).

#### <a name="singapore_changi_emplyee"></a> Singapore Changi employee ID recognizer
The [`SingaporeChangiEmployeeIdRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/singapore/SingaporeChangiEmployeeIdRecognizer.html) is used for scanning the ID card of the Singapore Changi airport employee.


### <a name="blinkid_recognizers_slovakia"></a> Slovakia

For all recognizers, you can find information about usage context at the beginning of [this section](#blinkid_recognizers).

#### <a name="slovakia_id"></a> Slovakia ID front and back side recognizers
The [`SlovakiaIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/slovakia/SlovakiaIdFrontRecognizer.html) and [`SlovakiaIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/slovakia/SlovakiaIdBackRecognizer.html) are used for scanning the [front and back side of Slovak identity card](https://en.wikipedia.org/wiki/Slovak_identity_card).

#### <a name="slovakia_combined"></a> Slovakia combined recognizer
The [`SlovakiaCombinedRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/slovakia/SlovakiaCombinedRecognizer.html) scans back side of Slovak ID after scanning the front side and combines data from both sides.


### <a name="blinkid_recognizers_slovenia"></a> Slovenia

For all recognizers, you can find information about usage context at the beginning of [this section](#blinkid_recognizers).

#### <a name="slovenia_id"></a> Slovenia ID front and back side recognizers
The [`SloveniaIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/slovenia/SloveniaIdFrontRecognizer.html) and [`SloveniaIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/slovenia/SloveniaIdBackRecognizer.html) are used for scanning the [front and back side of Slovenian identity card](https://en.wikipedia.org/wiki/Slovenian_identity_card).

#### <a name="slovenia_combined"></a> Slovenia combined recognizer
The [`SloveniaCombinedRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/slovenia/SloveniaCombinedRecognizer.html) scans back side of Slovenian ID after scanning the front side and combines data from both sides.


### <a name="blinkid_recognizers_spain"></a> Spain

#### <a name="spain_dl"></a> Spain driver's license front side recognizer
The [`SpainDlFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/spain/SpainDlFrontRecognizer.html) is used for scanning front side of [Spanish driver's license](https://en.wikipedia.org/wiki/Driving_licence_in_Spain).

### <a name="blinkid_recognizers_sweden"></a> Sweden

#### <a name="sweden_dl"></a> Sweden driver's license front side recognizer
The [`SwedenDlFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/sweden/dl/SwedenDlFrontRecognizer.html) is used for scanning front side of Swedish driver's license.

You can find information about usage context at the beginning of [this section](#blinkid_recognizers).


### <a name="blinkid_recognizers_switzerland"></a> Switzerland

For all recognizers, you can find information about usage context at the beginning of [this section](#blinkid_recognizers).

#### <a name="switzerland_id"></a> Switzerland ID front and back side recognizers
The [`SwitzerlandIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/switzerland/SwitzerlandIdFrontRecognizer.html) and [`SwitzerlandIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/switzerland/SwitzerlandIdBackRecognizer.html) are used for scanning the [front and back side of Swiss identity card](https://en.wikipedia.org/wiki/Swiss_identity_card).

#### <a name="switzerland_passport"></a> Switzerland passport recognizer
The [`SwitzerlandPassportRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/switzerland/SwitzerlandPassportRecognizer.html) is used for scanning the data page of [Swiss passport](https://en.wikipedia.org/wiki/Swiss_passport).

#### <a name="switzerland_dl"></a> Switzerland driver's license front side recognizer
The [`SwitzerlandDlFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/switzerland/SwitzerlandDlFrontRecognizer.html) is used for scanning the front side of the [Swiss driver's license](https://en.wikipedia.org/wiki/Driver%27s_license#Switzerland).


### <a name="blinkid_recognizers_uae"></a> United Arab Emirates

#### <a name="uae_id"></a> United Arab Emirates ID front and back side recognizers
The [`UnitedArabEmiratesIdFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/unitedArabEmirates/UnitedArabEmiratesIdFrontRecognizer.html) and [`UnitedArabEmiratesIdBackRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/unitedArabEmirates/UnitedArabEmiratesIdBackRecognizer.html) are used for scanning the front and back side of United Arab Emirates identity card.

#### <a name="uae_dl"></a> United Arab Emirates driver's license front side recognizer
The [`UnitedArabEmiratesDlFrontRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/unitedArabEmirates/UnitedArabEmiratesDlFrontRecognizer.html) is used for scanning the front side of the United Arab Emirates driver's license.


### <a name="blinkid_recognizers_uk"></a> United Kingdom

#### <a name="germany_dl"></a> Scanning United Kingdom driver's license
For scanning [the front side of UK driver's license](https://en.wikipedia.org/wiki/Driving_licence_in_the_United_Kingdom), [`EudlRecognizer`](#eudlRecognizer) is used.

### <a name="blinkid_recognizers_us_canada"></a> US / Canada

#### <a name="uscanada_dl"></a> Scanning US / Canada driver's license
For scanning the PDF417 barcode from the US / Canada driver's license, [`UsdlRecognizer`](#us_dl_recognizer) is used.

The [`UsdlCombinedRecognizer`](#us_dl_combined_recognizer) can also be used for scanning the PDF417 barcode from the back side of US / Canada driver's license after scanning the full document image and face image from the front side.


# <a name="fieldByFieldFeature"></a> `Field by field` scanning feature

[`Field by field`](#fieldByFieldFeature) scanning feature is designed for scanning small text fields which are called scan elements. Elements are scanned in the predefined order. For each scan element, specific [`Parser`](#parserConcept) that will extract structured data of interest from the OCR result is defined. Focusing on the small text fields which are scanned one by one enables implementing support for the **free-form documents** because field detection is not required. The user is responsible for positioning the field of interest inside the scanning window and the scanning process guides him. When implementing support for the custom document, only fields of interest has to be defined.

`Field by field` scan can be performed by using provided [`FieldByFieldScanActivity` and `FieldByFieldOverlayController`](#fieldByFieldUiComponent).

For preparing the scan configuration, [`FieldByFieldBundle`](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/config/fieldbyfield/FieldByFieldBundle.html) is used. It holds the array of `FieldByFieldElements` passed to its constructor and it is responsible for transferring them from one `Activity` to another, just like the [`RecognizerBundle`](#recognizerBundle) transfers `Recognizers`.
 
[`FieldByFieldElement`](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/config/fieldbyfield/FieldByFieldElement.html) holds a combination of `Parser` used for data extraction, its title and message which are shown in the UI during the scan. For all available configuration options please see the [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/config/fieldbyfield/FieldByFieldElement.html).

When `FieldByFieldBundle` is prepared, it should be used for creating the [`FieldByFieldUISettings`](https://blinkid.github.io/blinkid-android/com/microblink/uisettings/FieldByFieldUISettings.html) which accepts `FieldByFieldBundle` as a constructor argument and can be used to additionally tweak the scanning process and UI. For the list of all available configuration options, please see [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/uisettings/FieldByFieldUISettings.html).
 
For starting the [`FieldByFieldScanActivity`](https://blinkid.github.io/blinkid-android/com/microblink/activity/FieldByFieldScanActivity.html), the [ActivityRunner.startActivityForResult](https://blinkid.github.io/blinkid-android/com/microblink/uisettings/ActivityRunner.html#startActivityForResult-android.app.Activity-int-com.microblink.uisettings.UISettings-) should be called with the prepared `FieldByFieldUISettings`.
 
When the scanning is done and control is returned to the calling activity, in `onActivityResult` method [FieldByFieldBundle.loadFromIntent](https://blinkid.github.io/blinkid-android/com/microblink/intent/IntentTransferableBundle.html#loadFromIntent-android.content.Intent-) should be called. `FieldByFieldBundle` will load the scanning results to the `Parser` instances held by its elements.
# <a name="processorsAndParsers"></a> `Processor` and `Parser`

The `Processors` and `Parsers` are standard processing units within *BlinkID* SDK used for data extraction from the input images. Unlike the [`Recognizer`](#recognizerConcept), `Processor` and `Parser` are not stand-alone processing units. `Processor` is always used within `Recognizer` and `Parser` is used within appropriate `Processor` to extract data from the OCR result.

## <a name="processorConcept"></a> The `Processor` concept

`Processor` is a processing unit used within some `Recognizer` which supports processors. It processes the input image prepared by the enclosing `Recognizer` in the way that is characteristic to the implementation of the concrete `Processor`.

For example, [`BlinkInputRecognizer`](#blinkInputRecognizer) encloses a collection of processors which are run on the input image to extract data. To perform the OCR of the input image, [`ParserGroupProcessor`](#parserGroupProcessor) is used. Also, [`ImageReturnProcessor`](#imageReturnProcessor) can be used to obtain input image. Another example is [`DetectorRecognizer`](#detectorRecognizer) which supports [`Templating API`](#detectorTemplating). It uses processors to extract data from the fields of interest on the scanned document.

`Processor` architecture is similar to `Recognizer` architecture described in [The Recognizer concept](#recognizerConcept) section. Each instance also has associated inner `Result` object whose lifetime is bound to the lifetime of its parent `Processor` object and it is updated while `Processor` works. If you need your `Result` object to outlive its parent `Processor` object, you must make a copy of it by calling its method [`clone()`](https://blinkid.github.io/blinkid-android/com/microblink/entities/Entity.Result.html#clone--).

It also has its internal state and while it is in the *working state* during recognition process, it is not allowed to tweak `Processor` object's properties.

To support common use cases, there are several different `Processor` implementations available. They are listed in the next section.

## <a name="processorList"></a> List of available processors

This section will give a list of `Processor` types that are available within *BlinkID* SDK and their purpose.

### <a name="imageReturnProcessor"></a> Image Return Processor

The [`ImageReturnProcessor`](https://blinkid.github.io/blinkid-android/com/microblink/entities/processors/imageReturn/ImageReturnProcessor.html) is used for obtaining input images. It simply saves the input image and makes it available after the scanning is done.

The appearance of the input image depends on the context in which `ImageReturnProcessor` is used. For example, when it is used within [`BlinkInputRecognizer`](#blinkInputRecognizer), simply the raw image of the scanning region is processed. When it is used within the [`Templating API`](#detectorTemplating), input image is dewarped (cropped and rotated).
 
The image is returned as the raw [Image](https://blinkid.github.io/blinkid-android/com/microblink/image/Image.html) type. Also, processor can be configured to [encode saved image to JPEG](https://blinkid.github.io/blinkid-android/com/microblink/entities/processors/imageReturn/ImageReturnProcessor.html#setEncodeImage-boolean-). 

### <a name="parserGroupProcessor"></a> Parser Group Processor

The [`ParserGroupProcessor`](https://blinkid.github.io/blinkid-android/com/microblink/entities/processors/parserGroup/ParserGroupProcessor.html) is the type of the processor that performs the OCR (*Optical Character Recognition*) on the input image and lets all the parsers within the group to extract data from the OCR result. The concept of `Parser` is described in [the next](#parserConcept) section.

Before performing the OCR, the best possible OCR engine options are calculated by combining engine options needed by each `Parser` from the group. For example, if one parser expects and produces result from uppercase characters and other parser extracts data from digits, both uppercase characters and digits must be added to the list of allowed characters that can appear in the OCR result. This is a simplified explanation because OCR engine options contain many parameters which are combined by the `ParserGroupProcessor`.

Because of that, if multiple parsers and multiple parser group processors are used during the scan, it is very important to group parsers carefully.

Let's see this on an example: assume that we have two parsers at our disposal: `AmountParser` and `EMailParser`. `AmountParser` knows how to extract amount's from OCR result and requires from OCR only to recognize digits, periods and commas and ignore letters. On the other hand, `EMailParser` knows how to extract e-mails from OCR result and requires from OCR to recognize letters, digits, '@' characters and periods, but not commas. 

If we put both `AmountParser` and `EMailParser` into the same `ParserGroupProcessor`, the merged OCR engine settings will require recognition of all letters, all digits, '@' character, both period and comma. Such OCR result will contain all characters for `EMailParser` to properly parse e-mail, but might confuse `AmountParser` if OCR misclassifies some characters into digits.

If we put `AmountParser` in one `ParserGroupProcessor` and `EMailParser` in another `ParserGroupProcessor`, OCR will be performed for each parser group independently, thus preventing the `AmountParser` confusion, but two OCR passes of the image will be performed, which can have a performance impact.

`ParserGroupProcessor` is most commonly used `Processor`. It is used whenever the OCR is needed. After the OCR is performed and all parsers are run, parsed results can be obtained through parser objects that are enclosed in the group. `ParserGroupProcessor` instance also has associated inner `ParserGroupProcessor.Result` whose state is updated during processing and its method [`getOcrResult()`](https://blinkid.github.io/blinkid-android/com/microblink/entities/processors/parserGroup/ParserGroupProcessor.Result.html#getOcrResult--) can be used to obtain the raw [`OCRResult`](https://blinkid.github.io/blinkid-android/com/microblink/results/ocr/OcrResult.html) that was used for parsing data.

Take note that `OCRResult` is available only if it is allowed by the *BlinkID* SDK license key. `OCRResult` structure contains information about all recognized characters and their positions on the image. To prevent someone to abuse that, obtaining of the `OCRResult` structure is allowed only by the premium license keys.

## <a name="parserConcept"></a> The `Parser` concept

`Parser` is a class of objects that are used to extract structured data from the raw OCR result. It must be used within `ParserGroupProcessor` which is responsible for performing the OCR, so `Parser` is not stand-alone processing unit.

Like [`Recognizer`](#recognizerConcept) and all other processing units, each `Parser` instance has associated inner `Result` object whose lifetime is bound to the lifetime of its parent `Parser` object and it is updated while `Parser` works. When parsing is done `Result` can be used for obtaining extracted data. If you need your `Result` object to outlive its parent `Parser` object, you must make a copy of it by calling its method [`clone()`](https://blinkid.github.io/blinkid-android/com/microblink/entities/Entity.Result.html#clone--).

It also has its internal state and while it is in the *working state* during recognition process, it is not allowed to tweak `Parser` object's properties.

There are a lot of different `Parsers` for extracting most common fields which appear on various documents. Also, most of them can be adjusted for specific use cases. For all other custom data fields, there is `RegexParser` available which can be configured with the arbitrary regular expression.

## <a name="parserList"></a> List of available parsers

### <a name="amountParser"></a> Amount Parser

[`AmountParser`](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/amount/AmountParser.html) is used for extracting amounts from the OCR result. For available configuration options and result getters please check [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/amount/AmountParser.html).

### <a name="dateParser"></a> Date Parser

[`DateParser`](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/date/DateParser.html) is used for extracting dates in various formats from the OCR result. For available configuration options and result getters please check [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/date/DateParser.html).

### <a name="emailParser"></a> EMail Parser

[`EMailParser`](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/email/EMailParser.html) is used for extracting e-mail addresses from the OCR result. For available result getters please check [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/email/EMailParser.html).

### <a name="ibanParser"></a> IBAN Parser

[`IbanParser`](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/iban/IbanParser.html) is used for extracting IBAN (*International Bank Account Number*) from the OCR result. For available configuration options and result getters please check [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/iban/IbanParser.html).

### <a name="licensePlatesParser"></a> License Plates Parser

[`LicensePlatesParser`](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/licenseplates/LicensePlatesParser.html) is used for extracting license plate content from the OCR result. For available  result getters please check [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/licenseplates/LicensePlatesParser.html).

### <a name="rawParser"></a> Raw Parser

[`RawParser`](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/raw/RawParser.html) is used for obtaining string version of raw OCR result, without performing any smart parsing operations. For available result getters please check [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/raw/RawParser.html).

### <a name="regexParser"></a> Regex Parser

[`RegexParser`](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/regex/RegexParser.html) is used for extracting OCR result content which is in accordance with the given regular expression. Regular expression parsing is not performed with java's regex engine. Instead, it is performed with custom regular expression engine. Due to differences between parsing normal strings and OCR results, this parser does not support some regex features found in Java's regex engine, like backreferences. See [setRegex(String)](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/regex/RegexParser.html#setRegex-java.lang.String-) method javadoc for more information about what is supported.

For available configuration options and result getters please check [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/regex/RegexParser.html).

### <a name="topUpParser"></a> TopUp Parser

[`TopUpParser`](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/topup/TopUpParser.html) is used for extracting TopUp (mobile phone coupon) codes from the OCR result. There exists [`TopUpPreset`](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/topup/TopUpPreset.html) enum with presets for most common vendors. Method [setTopUpPreset(TopUpPreset)](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/topup/TopUpParser.html#setTopUpPreset-TopUpPreset-) can be used to configure parser to only return codes with the appropriate format defined by the used preset. 

For the list of all available configuration options and result getters please check [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/topup/TopUpParser.html).

### <a name="vinParser"></a> VIN (*Vehicle Identification Number*) Parser

[`VinParser`](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/vin/VinParser.html) is used for extracting VIN (*Vehicle Identification Number*) from the OCR result. For available configuration options and result getters please check [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/entities/parsers/vin/VinParser.html).





# <a name="detectorTemplating"></a> Scanning generic documents with Templating API

This section discusses the setting up of `DetectorRecognizer` for scanning templated documents. Please check [Templating API whitepaper](https://github.com/BlinkID/blinkid-android/blob/master/templatingAPI/templatingAPI.md) and `BlinkID-TemplatingSample` sample app for source code examples.

Templated document is any document which is defined by its template. Template contains the information about how the document should be detected, i.e. found on the camera scene and information about which part of the document contains which useful information.

## <a name="detectorTemplating_detection"></a> Defining how document should be detected

Before performing OCR of the document, _BlinkID_ first needs to find its location on a camera scene. In order to perform detection, you need to define [Detector](#detectorConcept). 

You have to set concrete `Detector` when instantiating the `DetectorRecognizer` as a parameter to its constructor. 

You can find out more information about detectors that can be used in section [List of available detectors](#detectorList). The most commonly used detector is [`DocumentDetector`](#documentDetector).

## <a name="detectorTemplating_extraction"></a> Defining how fields of interest should be extracted

`Detector` produces its result which contains document location. After the document has been detected, all further processing is done on the detected part of the input image.

There may be one or more variants of the same document type, for example for some document there may be old and new version and both of them must be supported. Because of that, for implementing support for each document, one or multiple templating classes are used. `TemplatingClass` is described in [The Templating Class component](#templatingClass) section.

`TemplatingClass` holds all needed information and components for processing its class of documents. Templating classes are processed in chain, one by one. On first class for which the data is successfully extracted, the chain is terminated and recognition results are returned. For each input image processing is done in the following way:

1. Classification `ProcessorGroups` are run on the defined locations to extract data. `ProcessorGroup` is used to define the location of interest on the detected document and `Processors` that will extract data from that location. You can find more about `ProcessorGroup` in the [next section](#processorGroup).

2. `TemplatingClassifier` is run, after the classification processor groups are executed (if they exist), to decide whether the currently scanned document belongs to the current class or not. Its [classify](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/TemplatingClassifier.html#classify-TemplatingClass-) method  simply returns `true` or `false`. If the classifier returns `false`, recognition is moved to the next class in the chain, if it exists. You can find more about `TemplatingClassifier` in [this](#implementingTemplatingClassifier) section.

3. If the `TemplatingClassifier` has decided that currently scanned document belongs to the current class, non-classification `ProcessorGroups` are run to extract other fields of interest.

### <a name="processorGroup"></a> The `ProcessorGroup` component

In templating API [`ProcessorGroup`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/ProcessorGroup) is used to define the location of the field of interest on the detected document and how that location should be processed by setting following parameters in its constructor:

1. Location coordinates relative to document detection which are passed as [`Rectangle`](https://blinkid.github.io/blinkid-android/com/microblink/geometry/Rectangle.html) object.

2. `DewarpPolicy` which determines how the perspective will be corrected for the current location (i.e. how image dewarp will be performed). You can find a description of each `DewarpPolicy`, its purpose and recommendations when it should be used to get the best results in [List of available dewarp policies](#dewarpPolicyList) section.

3. Collection of processors that will be executed on the prepared chunk of the image for current document location. You can find more information about processors in [The Processor concept](#processorConcept) section.

### <a name="dewarpPolicyList"></a> List of available dewarp policies

Concrete `DewarpPolicy` determines how the perspective will be corrected for the specific location of interest (i.e. how image dewarp will be performed). Here is the list of available dewarp policies with linked javadoc for more information:

- [`FixedDewarpPolicy`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/dewarpPolicies/FixedDewarpPolicy.html)
    - defines the exact height of the dewarped image in pixels
    - **usually the best policy for processor groups that use a legacy OCR engine**

- [`DPIBasedDewarpPolicy`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/dewarpPolicies/DPIBasedDewarpPolicy.html):
    - defines the desired DPI (*Dots Per Inch*)
    - the height of the dewarped image will be calculated based on the actual physical size of the document provided by the used detector and chosen DPI
    - **usually the best policy for processor groups that prepare location's raw image for output**
 
- [`NoUpScalingDewarpPolicy`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/dewarpPolicies/NoUpScalingDewarpPolicy): 
    - defines the maximum allowed height of the dewarped image in pixels
    - the height of the dewarped image will be calculated in a way that no part of the image will be up-scaled
    - if the height of the resulting image is larger than maximum allowed, then the maximum allowed height will be used as actual height, which effectively scales down the image
    - **usually the best policy for processors that use neural networks, for example,  DEEP OCR, hologram detection or NN-based classification**

### <a name="templatingClass"></a> The `TemplatingClass` component

[`TemplatingClass`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/TemplatingClass.html) enables implementing support for a specific class of documents that should be scanned with templating API. Final implementation of the templating recognizer consists of one or more templating classes, one class for each version of the document.

`TemplatingClass` contains two collections of `ProcessorGroups` and a `TemplatingClassifier`.

The two collections of processor groups within `TemplatingClass` are:

1. The classification processor groups which are set by using the [setClassificationProcessorGroups](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/TemplatingClass.html#setClassificationProcessorGroups-ProcessorGroup:A-) method. `ProcessorGroups` from this collection will be executed before classification, which means that they are always executed when processing comes to this class.

2. The non-classification processor groups which are set by using the [setNonClassificationProcessorGroups](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/TemplatingClass.html#setNonClassificationProcessorGroups-ProcessorGroup:A-) method. `ProcessorGroups` from this collection will be executed after classification if the classification has been positive.

A component which decides whether the scanned document belongs to the current class is [`TemplatingClassifier`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/TemplatingClassifier.html). It can be set by using the [setTemplatingClassifier](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/TemplatingClass.html#setTemplatingClassifier-TemplatingClassifier-) method. If it is not set, non-classification processor groups will not be executed. Instructions for implementing the `TemplatingClassifier` are given in the [next section](#implementingTemplatingClassifier).

### <a name="implementingTemplatingClassifier"></a> Implementing the `TemplatingClassifier`

Each concrete templating classifier implements the [`TemplatingClassifier`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/TemplatingClassifier.html) interface, which requires to implement its [`classify`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/TemplatingClassifier.html#classify-TemplatingClass-) method that is invoked while evaluating associated `TemplatingClass`.

Classification decision should be made based on the processing result which is returned by one or more processing units contained in the collection of the classification processor groups. As described in [The ProcessorGroup component](#processorGroup) section, each processor group contains one or more `Processors`. [There are different `Processors`](#processorList) which may enclose smaller processing units, for example, [`ParserGroupProcessor`](#parserGroupProcessor) maintains the group of [`Parsers`](#parserConcept). Result from each of the processing units in that hierarchy can be used for classification. In most cases `Parser` result is used to determine whether some data in the expected format exists on the specified location.

To be able to retrieve results from the various processing units that are needed for classification, their instances must be available when [`classify`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/TemplatingClassifier.html#classify-TemplatingClass-) method is called.

`TemplatingRecognizer` can be parcelized and run on the different activity from the one within it is created, so it also implements [`Parcelable`](https://developer.android.com/reference/android/os/Parcelable.html) interface (`TemplatingClassifier` interface extends `Parcelable`). Here comes the tricky part of the templating classifier implementation. 

In cases when `TemplatingRecognizer` is serialized and deserialized via [`Parcel`](https://developer.android.com/reference/android/os/Parcel.html), all processing component instances are **different** than originally created ones that were used during recognizer definition. So it is important to take care of this while implementing classification in cases when deparcelized processing units are used in `classify` method.

When `classify` method is called, processing units that are needed for classification can be obtained from the given `TemplatingClass`, passed as the method argument. For that purpose there are following helper classes available:

- [`ProcessorParcelization`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/parcelization/ProcessorParcelization.html) is utility class which helps to obtain the reference to the captured `Processor` from the `TemplatingClass` instance, after the parcelization. For more information see [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/parcelization/ProcessorParcelization.html).

- [`ParserParcelization`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/parcelization/ParserParcelization.html) is utility class which helps to obtain the reference to the captured `Parser` from the `TemplatingClass` instance, after the parcelization. For more information see [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/templating/parcelization/ParserParcelization.html).

For the complete source code sample, please check [Templating API whitepaper](https://github.com/BlinkID/blinkid-android/blob/master/templatingAPI/templatingAPI.md) and `BlinkID-TemplatingSample`.

## <a name="detectorTemplating_results"></a> Obtaining recognition results

When recognition is done, results can be obtained through processing units instances, such as: `Processors`, `Parsers`, etc. which are used for configuring the `TemplatingRecognizer` and later for processing the input image.

In cases when `TemplatingRecognizer` needs to be serialized and deserialized when it is passed to scan activity, `TemplatingRecognizer` knows how to serialize and deserialize all contained components. When control is returned from the scan activity and [`RecognizerBundle.loadFromIntent`](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/RecognizerBundle.html#loadFromIntent-android.content.Intent-) is called, all kept processing unit instances are updated with the scanning results.


# <a name="mrtdTemplating"></a> Extracting additional fields of interest from machine-readable travel documents by using Templating API

`MrtdRecognizer` is **Templating API** recognizer which means that it can be configured to extract additional fields of interest, which are outside of the Machine Readable Zone, from the scanned Machine Readable Travel Document. Please check [Templating API whitepaper](https://github.com/BlinkID/blinkid-android/blob/master/templatingAPI/templatingAPI.md) and `BlinkID-TemplatingSample` sample app for source code examples.

All stated in the [Scanning generic documents with Templating API](#detectorTemplating) section which explains Templating API for the `DetectorRecognizer` is also valid here. The only difference is document detection part which does not need to be configured. `MrtdRecognizer` internally uses [`MrtdDetector`](#mrtdDetector) which first detects Machine Readable Zone and then extends detection to the full document.




# <a name="detectorConcept"></a> The `Detector` concept

[`Detector`](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/Detector.html) is a processing unit used within some `Recognizer` which supports detectors, such as [`DetectorRecognizer`](#detectorRecognizer). Concrete `Detector` knows how to find the certain object on the input image. `Recognizer` can use it to perform object detection prior to performing further recognition of detected object's contents.

`Detector` architecture is similar to `Recognizer` architecture described in [The Recognizer concept](#recognizerConcept) section. Each instance also has associated inner `Result` object whose lifetime is bound to the lifetime of its parent `Detector` object and it is updated while `Detector` works. If you need your `Result` object to outlive its parent `Detector` object, you must make a copy of it by calling its [`clone()`](https://blinkid.github.io/blinkid-android/com/microblink/entities/Entity.Result.html#clone--) method.

It also has its internal state and while it is in the *working state* during recognition process, it is not allowed to tweak `Detector` object's properties.

When detection is performed on the input image, each `Detector` in its associated `Result` object holds the following information:

- [`DetectionCode`](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/Detector.Result.DetectionCode.html) that indicates the type of the detection (*FAIL*, *FALLBACK* or *SUCCESS*) and can be obtained with the [`getDetectionCode`](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/Detector.Result#getDetectionCode--) method.

- [`DetectionStatus`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/DetectionStatus) that represents the status of the detection which can be obtained with the [`getDetectionStatus`](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/Detector.Result#getDetectionStatus--) method.

- each concrete detector returns additional information specific to the detector type


To support common use cases, there are several different `Detector` implementations available. They are listed in the next section.

## <a name="detectorList"></a> List of available detectors

### <a name="documentDetector"></a> Document Detector

[`DocumentDetector`](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/quad/document/DocumentDetector.html) is used to detect card documents, cheques, A4-sized documents, receipts and much more.

It accepts one or more `DocumentSpecifications`. [`DocumentSpecification`](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/quad/document/DocumentSpecification.html) represents a specification of the document that should be detected by using edge detection algorithm and predefined aspect ratio.

For the most commonly used document formats, there is a helper method  [`DocumentSpecification.createFromPreset(DocumentSpecificationPreset)`](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/quad/document/DocumentSpecification.html#createFromPreset-com.microblink.entities.detectors.quad.document.DocumentSpecificationPreset-) which creates and initializes the document specification based on the given [DocumentSpecificationPreset](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/quad/document/DocumentSpecificationPreset.html). For more information about `DocumentSpecification`, please see [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/quad/document/DocumentSpecification.html).

For the list of all available configuration methods see [`DocumentDetector`](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/quad/document/DocumentDetector.html) javadoc, and for available result content see [`DocumentDetector.Result`](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/quad/document/DocumentDetector.Result.html) javadoc.


### <a name="mrtdDetector"></a> MRTD Detector

[`MRTDDetector`](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/quad/mrtd/MRTDDetector.html) is used to perform detection of *Machine Readable Travel Documents (MRTD)*.

Method [`setSpecifications`](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/quad/mrtd/MRTDDetector.html#setSpecifications-com.microblink.entities.detectors.quad.mrtd.MrtdSpecification:A-) can be used to define which MRTD documents should be detectable. It accepts the array of `MrtdSpecifications`. [`MrtdSpecification`](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/quad/mrtd/MrtdSpecification.html) represents specification of MRTD that should be detected. It can be created from the [`MrtdSpecificationPreset`](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/quad/mrtd/MrtdSpecificationPreset.html) by using [`MrtdSpecification.createFromPreset(MrtdSpecificationPreset)`](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/quad/mrtd/MrtdSpecification.html#createFromPreset-com.microblink.entities.detectors.quad.mrtd.MrtdSpecificationPreset-) method.

If `MrtdSpecifications` are not set, all supported MRTD formats will be detectable.

For the list of all available configuration methods see [`MRTDDetector`](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/quad/mrtd/MRTDDetector.html) javadoc, and for available result content see [MRTDDetector.Result](https://blinkid.github.io/blinkid-android/com/microblink/entities/detectors/quad/mrtd/MRTDDetector.Result.html) javadoc.


# <a name="embedAAR"></a> Embedding _BlinkID_ inside another SDK

When creating your own SDK which depends on _BlinkID_, you should consider following cases:

- [_BlinkID_ licensing model](#licensingModel)
- [ensuring final app gets all classes and resources that are required by _BlinkID_](#sdkIntegrationIntoApp)

## <a name="licensingModel"></a> _BlinkID_ licensing model

### <a name="appLicence"></a> Application licenses

Application licenses are bound to application's [package name](http://tools.android.com/tech-docs/new-build-system/applicationid-vs-packagename). This means that each app must have its own license in order to be able to use _BlinkID_. This model is appropriate when integrating _BlinkID_ directly into app, however if you are creating SDK that depends on _BlinkID_, you would need separate _BlinkID_ license for each of your clients using your SDK. This is not practical, so you should contact us at [help.microblink.com](http://help.microblink.com) and we can provide you a library license.
	
## <a name="sdkIntegrationIntoApp"></a> Ensuring the final app gets all resources required by _BlinkID_

At the time of writing this documentation, [Android does not have support for combining multiple AAR libraries into single fat AAR](https://stackoverflow.com/questions/20700581/android-studio-how-to-package-single-aar-from-multiple-library-projects/20715155#20715155). The problem is that resource merging is done while building application, not while building AAR, so application must be aware of all its dependencies. **There is no official Android way of "hiding" third party AAR within your AAR.**

This problem is usually solved with transitive Maven dependencies, i.e. when publishing your AAR to Maven you specify dependencies of your AAR so they are automatically referenced by app using your AAR. Besides this, there are also several other approaches you can try:

- you can ask your clients to reference _BlinkID_ in their app when integrating your SDK
- since the problem lies in resource merging part you can try avoiding this step by ensuring your library will not use any component from _BlinkID_ that uses resources (i.e. built-in activities, fragments and views, except `RecognizerRunnerView`). You can perform [custom UI integration](#recognizerRunnerView) while taking care that all resources (strings, layouts, images, ...) used are solely from your AAR, not from _BlinkID_. Then, in your AAR you should not reference `LibBlinkID.aar` as gradle dependency, instead you should unzip it and copy its assets to your AAR?s assets folder, its `classes.jar` to your AAR?s lib folder (which should be referenced by gradle as jar dependency) and contents of its jni folder to your AAR?s src/main/jniLibs folder.
- Another approach is to use [3rd party unofficial gradle script](https://github.com/adwiv/android-fat-aar) that aim to combine multiple AARs into single fat AAR. Use this script at your own risk and report issues to [its developers](https://github.com/adwiv/android-fat-aar/issues) - we do not offer support for using that script.
- There is also a [3rd party unofficial gradle plugin](https://github.com/Vigi0303/fat-aar-plugin) which aims to do the same, but is more up to date with latest updates to Android gradle plugin. Use this plugin at your own risk and report all issues with using to [its developers](https://github.com/Vigi0303/fat-aar-plugin/issues) - we do not offer support for using that plugin.

# <a name="archConsider"></a> Processor architecture considerations

_BlinkID_ is distributed with both ARMv7, ARM64, x86 and x86_64 native library binaries.

ARMv7 architecture gives the ability to take advantage of hardware accelerated floating point operations and SIMD processing with [NEON](http://www.arm.com/products/processors/technologies/neon.php). This gives _BlinkID_ a huge performance boost on devices that have ARMv7 processors. Most new devices (all since 2012.) have ARMv7 processor so it makes little sense not to take advantage of performance boosts that those processors can give. Also note that some devices with ARMv7 processors do not support NEON instruction sets, most popular being those based on [NVIDIA Tegra 2](https://en.wikipedia.org/wiki/Tegra#Tegra_2). Since these devices are old by today's standard, _BlinkID_ does not support them. For the same reason, _BlinkID_ does not support devices with ARMv5 (`armeabi`) architecture.

ARM64 is the new processor architecture that most new devices use. ARM64 processors are very powerful and also have the possibility to take advantage of new NEON64 SIMD instruction set to quickly process multiple pixels with a single instruction.

x86 architecture gives the ability to obtain native speed on x86 android devices, like [Asus Zenfone 4](http://www.gsmarena.com/asus_zenfone_4-5951.php). Without that, _BlinkID_ will not work on such devices, or it will be run on top of ARM emulator that is shipped with device - this will give a huge performance penalty.

x86_64 architecture gives better performance than x86 on devices that use 64-bit Intel Atom processor.

However, there are some issues to be considered:

- ARMv7 build of native library cannot be run on devices that do not have ARMv7 compatible processor (list of those old devices can be found [here](http://www.getawesomeinstantly.com/list-of-armv5-armv6-and-armv5-devices/))
- ARMv7 processors do not understand x86 instruction set
- x86 processors understand neither ARM64 nor ARMv7 instruction sets
- however, some x86 android devices ship with the builtin [ARM emulator](http://commonsware.com/blog/2013/11/21/libhoudini-what-it-means-for-developers.html) - such devices are able to run ARM binaries but with performance penalty. There is also a risk that builtin ARM emulator will not understand some specific ARM instruction and will crash.
- ARM64 processors understand ARMv7 instruction set, but ARMv7 processors do not understand ARM64 instructions. 
    - <a name="64bitNotice"></a> **NOTE:** as of year 2018, some android devices that ship with ARM64 processor do not have full compatibility with ARMv7. This is mostly due to incorrect configuration of Android's 32-bit subsystem by the vendor, however Google [has announced](https://android-developers.googleblog.com/2017/12/improving-app-security-and-performance.html) that as of August 2019 all apps on PlayStore that contain native code will need to have native support for 64-bit processors (this includes ARM64 and x86_64) - this is in anticipation of future Android devices that will support 64-bit code **only**, i.e. that will have ARM64 processors that do not understand ARMv7 instruction set.
- if ARM64 processor executes ARMv7 code, it does not take advantage of modern NEON64 SIMD operations and does not take advantage of 64-bit registers it has - it runs in emulation mode
- x86_64 processors understand x86 instruction set, but x86 processors do not understand x86_64 instruction set
- if x86_64 processor executes x86 code, it does not take advantage of 64-bit registers and use two instructions instead of one for 64-bit operations

`LibBlinkID.aar` archive contains ARMv7, ARM64, x86 and x86_64 builds of native library. By default, when you integrate _BlinkID_ into your app, your app will contain native builds for all processor architectures. Thus, _BlinkID_ will work on ARMv7, ARM64, x86 and x86_64 devices and will use ARMv7 features on ARMv7 devices and ARM64 features on ARM64 devices. However, the size of your application will be rather large.

## <a name="reduceSize"></a> Reducing the final size of your app

If your final app is too large because of _BlinkID_, you can decide to create multiple flavors of your app - one flavor for each architecture. With gradle and Android studio this is very easy - just add the following code to `build.gradle` file of your app:

```
android {
  ...
  splits {
    abi {
      enable true
      reset()
      include 'x86', 'armeabi-v7a', 'arm64-v8a', 'x86_64'
      universalApk true
    }
  }
}
```

With that build instructions, gradle will build four different APK files for your app. Each APK will contain only native library for one processor architecture and one APK will contain all architectures. In order for Google Play to accept multiple APKs of the same app, you need to ensure that each APK has different version code. This can easily be done by defining a version code prefix that is dependent on architecture and adding real version code number to it in following gradle script:

```
// map for the version code
def abiVersionCodes = ['armeabi-v7a':1, 'arm64-v8a':2, 'x86':3, 'x86_64':4]

import com.android.build.OutputFile

android.applicationVariants.all { variant ->
    // assign different version code for each output
    variant.outputs.each { output ->
        def filter = output.getFilter(OutputFile.ABI)
        if(filter != null) {
            output.versionCodeOverride = abiVersionCodes.get(output.getFilter(OutputFile.ABI)) * 1000000 + android.defaultConfig.versionCode
        }
    }
}
```

For more information about creating APK splits with gradle, check [this article from Google](https://developer.android.com/studio/build/configure-apk-splits.html#configure-abi-split).

After generating multiple APK's, you need to upload them to Google Play. For tutorial and rules about uploading multiple APK's to Google Play, please read the [official Google article about multiple APKs](https://developer.android.com/google/play/publishing/multiple-apks.html).

### Removing processor architecture support in gradle without using APK splits

If you will not be distributing your app via Google Play or for some other reasons you want to have single APK of smaller size, you can completely remove support for certain CPU architecture from your APK. **This is not recommended due to [consequences](#archConsequences)**.

To remove certain CPU architecture, add following statement to your `android` block inside `build.gradle`:

```
android {
	...
	packagingOptions {
		exclude 'lib/<ABI>/libBlinkID.so'
	}
}
```

where `<ABI>` represents the CPU architecture you want to remove:

- to remove ARMv7 support, use `exclude 'lib/armeabi-v7a/libBlinkID.so'`
- to remove x86 support, use `exclude 'lib/x86/libBlinkID.so'`
- to remove ARM64 support, use `exclude 'lib/arm64-v8a/libBlinkID.so'`
    - **NOTE**: this is **not recommended**. See [this notice](#64bitNotice).
- to remove x86_64 support, use `exclude 'lib/x86_64/libBlinkID.so'`

You can also remove multiple processor architectures by specifying `exclude` directive multiple times. Just bear in mind that removing processor architecture will have side effects on performance and stability of your app. Please read [this](#archConsequences) for more information.

### Removing processor architecture support in Eclipse

This section assumes that you have set up and prepared your Eclipse project from `LibBlinkID.aar` as described in chapter [Eclipse integration instructions](#eclipseIntegration).

If you are using Eclipse, removing processor architecture support gets really complicated. Eclipse does not support APK splits and you will either need to remove support for some processors or create several different library projects from `LibBlinkID.aar` - each one for specific processor architecture. 

Native libraries in eclipse library project are located in subfolder `libs`:

- `libs/armeabi-v7a` contains native libraries for ARMv7 processor architecture
- `libs/x86` contains native libraries for x86 processor architecture
- `libs/arm64-v8a` contains native libraries for ARM64 processor architecture
- `libs/x86_64` contains native libraries for x86_64 processor architecture

To remove a support for processor architecture, you should simply delete appropriate folder inside Eclipse library project:

- to remove ARMv7 support, delete folder `libs/armeabi-v7a`
- to remove x86 support, delete folder `libs/x86`
- to remove ARM64 support, delete folder `libs/arm64-v8a`
    - **NOTE**: this is **not recommended**. See [this notice](#64bitNotice).
- to remove x86_64 support, delete folder `libs/x86_64`

### <a name="archConsequences"></a> Consequences of removing processor architecture

However, removing a processor architecture has some consequences:

- by removing ARMv7 support _BlinkID_ will not work on devices that have ARMv7 processors. 
- by removing ARM64 support, _BlinkID_ will not use ARM64 features on ARM64 device
    - also, some future devices may ship with ARM64 processors that will not support ARMv7 instruction set. Please see [this note](#64bitNotice) for more information.
- by removing x86 support, _BlinkID_ will not work on devices that have x86 processor, except in situations when devices have ARM emulator - in that case, _BlinkID_ will work, but will be slow and possibly unstable
- by removing x86_64 support, _BlinkID_ will not use 64-bit optimizations on x86_64 processor, but if x86 support is not removed, _BlinkID_ should work

Our recommendation is to include all architectures into your app - it will work on all devices and will provide best user experience. However, if you really need to reduce the size of your app, we recommend releasing separate version of your app for each processor architecture. It is easiest to do that with [APK splits](#reduceSize).


## <a name="staticDistrib"></a> Creating customized build of _BlinkID_

If techniques explained in paragraph [Reducing the final size of your app](#reduceSize) did not reduce the size enough for your convenience, you have the ability to create customised build of _BlinkID_ which will contain only features that you plan to use. Using customised build of _BlinkID_ can reduce your app size by more than 60% with respect to app size when using the generic build.

In order to create customised build of _BlinkID_, you first need to download the _static distribution of BlinkID_. A valid production licence is required in order to gain access to the download link of _BlinkID static distribution_. Once you have a valid production licence, please contact our [support team](http://help.microblink.com) and ask them to provide you with the download link. After they give you access to the _static distribution of BlinkID_, you will be able to download it from you account at [Microblink Developer Dashboard](https://www.microblink.com/login).

The _static distribution of BlinkID_ is a large zip file (several hundred megabytes) which contains static libraries of BlinkID's native code, all assets and a script which will create the customised build for you.

### Prerequisites for creating customised build

In order to create customised build of _BlinkID_, you will need following tools:

- [Android development tools and SDK](https://developer.android.com/studio/index.html)
- [Android NDK](https://developer.android.com/ndk/index.html) - best if installed from Android Studio's package manager
- NDK CMake toolchain - you have to install that from Android Studio's package manager
- Java - for running both Android Studio and provided gradle script which will create customised build

#### Important notes:

- you must use the exact same version of NDK that we used to build the static libraries. Using different NDK version will either result with linker errors or will create non-working binary. Our script will check your NDK version and will fail if there is a version mismatch.

### Steps for creating customised build (command line)

1. Obtain the _static distribution of BlinkID_ by [contacting us](http://help.microblink.com)
2. Download the zip from link that you will be provided
3. Unzip the file into an empty folder
4. Edit the file `static-distrib/enabled-features.cmake`
	- you should enable only features that you need to use by setting appropriate variables to `ON`. 
	- the list of all possible feature variables can be found in `static-distrib/features.cmake` 
		- for each `feature_option` command, first parameter defines the feature variable, and the second is the description of the feature, i.e. what it provides. Other parameters are information for script to work correctly.
	- you should not edit any file except `enabled-features.cmake` (except if instructed so by our support team) to ensure creation of customised build works well
5. In folder _LibBlinkID_, create file `local.properties` with following entries:

	```
	sdk.dir=/path/to/your/android-sdk-folder 
	ndk.dir=/path/to/your/android-sdk-folder/ndk-bundle
	```
	
	- importing the project into android studio should do that automatically for you
6. Open terminal and navigate to _LibBlinkID_ folder.
7. Execute command ```./gradlew clean assembleRelease```
8. After several minutes (depedending of CPU speed of your computer), customised build will appear as `LibBlinkID/build/outputs/aar/LibBlinkID-release.aar`. Use that AAR in your app instead of the default one.

### Steps for creating customised build (Android Studio)

1. Follow the steps 1.-4. as in command line version (see above)
2. Import the `static-distrib/LibBlinkID` project into Android Studio
3. Under `cpp` section of imported module, make sure that all required JNI static libraries are correctly referenced
	- if they are not, edit the `enabled-features.cmake` to correct which features need to be included in build and then select `Build -> Refresh Linked C++ Projects` in Android Studio menu
4. Open `Build Variants` pane and make sure `release` is selected for module `LibBlinkID`
5. In Android Studio menu, select `Build -> Build APK`
6. After several minutes (depedending of CPU speed of your computer), customised build will appear as `LibBlinkID/build/outputs/aar/LibBlinkID-release.aar`. Use that AAR in your app instead of the default one.

#### Warning:

Attempt to use feature within your app which was not enabled in customised build will result with your app crashing at the moment it tries to use that feature.

### Troubleshooting:

#### Getting `UnsatisfiedLinkError` when using customised build, while everything works OK with generic build

This happens when your app is trying to use feature which was not enabled in customised build. Please make sure that you enable features that you need and not use unnecessary features within your app.

#### App crashing when scanning starts with log message _Failed to load resource XX. The program will now crash._

This means that a required resource was not packaged into final app. This usually indicates a bug in our gradle script that makes the customised build. Please [contact us](http://help.microblink.com) and send your version of `enabled-features.cmake` and crash log.

#### CMake error while running gradle script.

You probably have a typo in `enabled-features.cmake`. CMake is very sensitive language and will throw an non-understandable error if you have a typo or invoke any of its commands with wrong number of parameters.

## <a name="combineNativeLibraries"></a> Combining _BlinkID_ with other native libraries

If you are combining _BlinkID_ library with some other libraries that contain native code into your application, make sure you match the architectures of all native libraries. For example, if third party library has got only ARMv7 and x86 versions, you must use exactly ARMv7 and x86 versions of _BlinkID_ with that library, but not ARM64. Using these architectures will crash your app in initialization step because JVM will try to load all its native dependencies in same preferred architecture and will fail with `UnsatisfiedLinkError`.
# <a name="troubleshoot"></a> Troubleshooting

## <a name="integrationTroubleshoot"></a> Integration problems

In case of problems with integration of the SDK, first make sure that you have tried integrating it into Android Studio by following [integration instructions](#quickIntegration). Although we do provide [Eclipse ADT integration](#eclipseIntegration) instructions, we officially do not support Eclipse ADT anymore. Also, for any other IDEs unfortunately you are on your own.

If you have followed [Android Studio integration instructions](#quickIntegration) and are still having integration problems, please contact us at [help.microblink.com](http://help.microblink.com).

## <a name="sdkTroubleshoot"></a> SDK problems

In case of problems with using the SDK, you should do as follows:

### Licensing problems

If you are getting "invalid license key" error or having other license-related problems (e.g. some feature is not enabled that should be or there is a watermark on top of camera), first check the ADB logcat. All license-related problems are logged to error log so it is easy to determine what went wrong.

When you have to determine what is the license-relate problem or you simply do not understand the log, you should contact us [help.microblink.com](http://help.microblink.com). When contacting us, please make sure you provide following information:

* exact package name of your app (from your `AndroidManifest.xml` and/or your `build.gradle` file)
* license that is causing problems
* please stress out that you are reporting problem related to Android version of _BlinkID_ SDK
* if unsure about the problem, you should also provide excerpt from ADB logcat containing license error

### Other problems

If you are having problems with scanning certain items, undesired behaviour on specific device(s), crashes inside _BlinkID_ or anything unmentioned, please do as follows:

* enable logging to get the ability to see what is library doing. To enable logging, put this line in your application:

	```java
	com.microblink.util.Log.setLogLevel(com.microblink.util.Log.LogLevel.LOG_VERBOSE);
	```

	After this line, library will display as much information about its work as possible. Please save the entire log of scanning session to a file that you will send to us. It is important to send the entire log, not just the part where crash occurred, because crashes are sometimes caused by unexpected behaviour in the early stage of the library initialization.
	
* Contact us at [help.microblink.com](http://help.microblink.com) describing your problem and provide following information:
	* log file obtained in previous step
	* high resolution scan/photo of the item that you are trying to scan
	* information about device that you are using - we need exact model name of the device. You can obtain that information with any app like [this one](https://play.google.com/store/apps/details?id=ru.andr7e.deviceinfohw)
	* please stress out that you are reporting problem related to Android version of _BlinkID_ SDK


## <a name="faq"></a> Frequently asked questions and known problems
Here is a list of frequently asked questions and solutions for them and also a list of known problems in the SDK and how to work around them.

#### <a name="featureNotSupportedByLicenseKey"></a> In demo everything worked, but after switching to production license I get `InvalidLicenseKeyException` as soon as I construct specific `Recognizer` object

Each license key contains information about which features are allowed to use and which are not. This exception indicates that your production license does not allow using of specific `Recognizer` object. You should contact [support](http://help.microblink.com) to check if provided license is OK and that it really contains all features that you have purchased.

#### <a name="invalidLicenseKey"></a> I get `InvalidLicenseKeyException` with trial license key

Whenever you construct any `Recognizer` object or any other object that derives from [`Entity`](https://blinkid.github.io/blinkid-android/com/microblink/entities/Entity.html), a check whether license allows using that object will be performed. If license is not set prior constructing that object, you will get `InvalidLicenseKeyException`. We recommend setting license as early as possible in your app, ideally in `onCreate` callback of your [Application singleton](https://developer.android.com/reference/android/app/Application.html).

#### <a name="missingResources"></a> When my app starts, I get exception telling me that some resource/class cannot be found or I get `ClassNotFoundException`

This usually happens when you perform integration into [Eclipse project](#eclipseIntegration) and you forget to add resources or native libraries into the project. You must alway take care that same versions of both resources, assets, java library and native libraries are used in combination. Combining different versions of resources, assets, java and native libraries will trigger crash in SDK. This problem can also occur when you have performed improper integration of _BlinkID_ SDK into your SDK. Please read how to [embed _BlinkID_ inside another SDK](#embedAAR).

#### <a name="multipleMicroblinkSDKs"></a> When trying to build app, I get error "Unable to merge dex" and "Multiple dex files define XXX"

This error happens when you try to integrate multiple Microblink SDKs into the same application. Multiple Microblink SDKs cannot be integrated into the same application, and there is no need for that because SDKs are organized in the way that each SDK is feature superset of the smaller SDK, except the `PDF417` SDK which is the smallest SDK. For example `BlinkID` SDK contains all features from the `BlinkInput` SDK. Relations between SDKs are: `PDF417` ? `BlinkInput` ? `BlinkID` ? `PhotoPay`.

#### <a name="unsatisfiedLinkError"></a> When my app starts, I get `UnsatisfiedLinkError`

This error happens when JVM fails to load some native method from native library. If performing integration into [Eclipse project](#eclipseIntegration) make sure you have the same version of all native libraries and java wrapper. If performing integration [into Android studio](quickIntegration) and this error happens, make sure that you have correctly combined _BlinkID_ SDK with [third party SDKs that contain native code](#combineNativeLibraries). If this error also happens in our integration demo apps, then it may indicate a bug in the SDK that is manifested on specific device. Please report that to our [support team](http://help.microblink.com).

#### <a name="lateMetadata1"></a> I've added my callback to `MetadataCallbacks` object, but it is not being called

Make sure that after adding your callback to `MetadataCallbacks` you have applied changes to `RecognizerRunnerView` or `RecognizerRunner` as described in [this section](#processingEventsImportantNote).

#### <a name="lateMetadata2"></a> I've removed my callback to `MetadataCallbacks` object, and now app is crashing with `NullPointerException`

Make sure that after removing your callback from `MetadataCallbacks` you have applied changes to `RecognizerRunnerView` or `RecognizerRunner` as described in [this section](#processingEventsImportantNote).

#### <a name="statefulRecognizer"></a> In my `onScanningDone` callback I have the result inside my `Recognizer`, but when scanning activity finishes, the result is gone

This usually happens when using `RecognizerRunnerView` and forgetting to pause the `RecognizerRunnerView` in your `onScanningDone` callback. Then, as soon as `onScanningDone` happens, the result is mutated or reset by additional processing that `Recognizer` performs in the time between end of your `onScanningDone` callback and actual finishing of the scanning activity. For more information about statefulness of the `Recognizer` objects, check [this section](#recognizerConcept).

#### <a name="transactionTooLarge"></a> I am using built-in activity to perform scanning and after scanning finishes, my app crashes with `IllegalStateException` stating `Data cannot be saved to intent because its size exceeds intent limit`.

This usually happens when you use `Recognizer` that produces image or similar large object inside its `Result` and that object exceeds the Android intent transaction limit. You should enable different intent data transfer mode. For more information about this, [check this section](#intentOptimization). Also, instead of using built-in activity, you can use [`RecognizerRunnerFragment` with built-in scanning overlay](#recognizerRunnerFragment).

#### <a name="transactionTooLarge2"></a> After scanning finishes, my app freezes

This usually happens when you attempt to transfer standalone `Result` that contains images or similar large objects via Intent and the size of the object exceeds Android intent transaction limit. Depending on the device, you will get either [TransactionTooLargeException](https://developer.android.com/reference/android/os/TransactionTooLargeException.html), a simple message `BINDER TRANSACTION FAILED` in log and your app will freeze or your app will get into restart loop. We recommend that you use `RecognizerBundle` and its API for sending `Recognizer` objects via Intent in a more safe manner ([check this section](#intentOptimization) for more information). However, if you really need to transfer standalone `Result` object (e.g. `Result` object obtained by cloning `Result` object owned by specific `Recognizer` object), you need to do that using global variables or singletons within your application. Sending large objects via Intent is not supported by Android.

#### <a name="ocrResultForbidden"></a> `onOcrResult()` method in my `OcrCallback` is never invoked and all `Result` objects always return `null` in their OCR result getters

In order to be able to obtain raw OCR result, which contains locations of each character, its value and its alternatives, you need to have a license that allows that. By default, licenses do not allow exposing raw OCR results in public API. If you really need that, please [contact us](https://help.microblink.com) and explain your use case.
# <a name="info"></a> Additional info
Complete API reference can be found in [Javadoc](https://blinkid.github.io/blinkid-android/index.html). 

For any other questions, feel free to contact us at [help.microblink.com](http://help.microblink.com).


