# _BlinkID_ SDK for Android

[![Build Status](https://travis-ci.org/BlinkID/blinkid-android.png)](https://travis-ci.org/BlinkID/blinkid-android)

_BlinkID_ SDK for Android is SDK that enables you to perform scans of various ID cards in your app. You can simply integrate the SDK into your app by following the instructions below and your app will be able to benefit the scanning feature for following ID card standards:

* [Passports and IDs that contain Machine Readable Zone](https://en.wikipedia.org/wiki/Machine-readable_passport)
* [United States' Driver's License barcodes](https://en.wikipedia.org/wiki/Driver%27s_license_in_the_United_States)
* [United Kingdom's Driver's Licence's front side](https://en.wikipedia.org/wiki/Driving_licence_in_the_United_Kingdom)
* [Malaysian identity card's front side](https://en.wikipedia.org/wiki/Malaysian_identity_card)

As of version `1.8.0` you can also scan barcodes and perform OCR of structurized or free-form text. Supported barcodes are the same as in sister product [PDF417.mobi](https://github.com/PDF417/pdf417-android).

Using _BlinkID_ in your app requires a valid license key. You can obtain a trial license key by registering to [Microblink dashboard](https://microblink.com/login). After registering, you will be able to generate a license key for your app. License key is bound to [package name](http://tools.android.com/tech-docs/new-build-system/applicationid-vs-packagename) of your app, so please make sure you enter the correct package name when asked.

See below for more information about how to integrate _BlinkID_ SDK into your app and also check latest [Release notes](Release notes.md).

# Table of contents

* [Android _BlinkID_ integration instructions](#intro)
* [Quick Start](#quickStart)
  * [Quick start with demo app](#quickDemo)
  * [Integrating _BlinkID_ into your project using Maven](#mavenIntegration)
  * [Android studio integration instructions](#quickIntegration)
  * [Eclipse integration instructions](#eclipseIntegration)
  * [Performing your first scan](#quickScan)
  * [Performing your first segment scan](#quickScan)
* [Advanced _BlinkID_ integration instructions](#advancedIntegration)
  * [Checking if _BlinkID_ is supported](#supportCheck)
  * [Customization of `ScanCard` activity](#scanActivityCustomization)
  * [Customization of `BlinkOCRActivity` activity](#segmentScanActivityCustomization)
  * [Embedding `RecognizerView` into custom scan activity](#recognizerView)
  * [`RecognizerView` reference](#recognizerViewReference)
* [Using direct API for recognition of Android Bitmaps](#directAPI)
  * [Understanding DirectAPI's state machine](#directAPIStateMachine)
  * [Using DirectAPI while RecognizerView is active](#directAPIWithRecognizer)
  * [Using ImageListener to obtain images that are being processed](#imageListener)
* [Recognition settings and results](#recognitionSettingsAndResults)
  * [[Recognition settings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/settings/RecognitionSettings.html)](#recognitionSettings)
  * [Scanning machine-readable travel documents](#mrtd)
  * [Scanning US Driver's licence barcodes](#usdl)
  * [Scanning EU driver's licences](#eudl)
  * [Scanning Malaysian MyKad ID documents](#myKad)
  * [Scanning PDF417 barcodes](#pdf417Recognizer)
  * [Scanning one dimensional barcodes with _BlinkID_'s implementation](#custom1DBarDecoder)
  * [Scanning barcodes with ZXing implementation](#zxing)
  * [Scanning segments with BlinkOCR recognizer](#blinkOCR)
  * [Performing detection of various documents](#detectorRecognizer)
* [Detection settings and results](#detectionSettingsAndResults)
  * [Detection of documents with Machine Readable Zone](#mrtdDetector)
  * [Detection of documents with Document Detector](#documentDetector)
  * [Combining detectors with MultiDetector](#multiDetector)
* [Translation and localization](#translation)
* [Processor architecture considerations](#archConsider)
  * [Reducing the final size of your app](#reduceSize)
  * [Combining _BlinkID_ with other native libraries](#combineNativeLibraries)
* [Troubleshooting](#troubleshoot)
  * [Integration problems](#integrationTroubleshoot)
  * [SDK problems](#sdkTroubleshoot)
* [Additional info](#info)

# <a name="intro"></a> Android _BlinkID_ integration instructions

The package contains Android Archive (AAR) that contains everything you need to use _BlinkID_ library. Besides AAR, package also contains a demo project that contains following modules:

- _BlinkIDDemo_ module demonstrates quick and simple integration of _BlinkID_ library
- _BlinkIDDemoCustomUI_ demonstrates advanced integration within custom scan activity
- _BlinkIDDemoCustomSegmentScan_ demonstrates advanced integration of SegmentScan feature within custom scan activity. It also demonstrates how to perform generic OCR of full camera frame, how to draw OCR results on screen and how to obtain [OcrResult](https://blinkocr.github.io/blinkocr-android/com/microblink/results/ocr/OcrResult.html) object for further processing.
- _BlinkIDDirectApiDemo_ demonstrates how to perform scanning of [Android Bitmaps](https://developer.android.com/reference/android/graphics/Bitmap.html)
 
_BlinkID_ is supported on Android SDK version 10 (Android 2.3.3) or later.

The library contains several activities that are responsible for camera control and recognition:

- `ScanCard` is designed for scanning ID documents, passports and driver licenses (both UK and US)
- `Pdf417ScanActivity` is designed for scanning barcodes
- `BlinkOCRActivity` is specifically designed for segment scanning. Unlike other activities, `BlinkOCRActivity` does not extend `BaseScanActivity`, so it requires a bit different initialization parameters. Please see _BlinkIDDemo_ app for example and read [section about customizing `BlinkOCRActivity`](#segmentScanActivityCustomization).

You can also create your own scanning UI - you just need to embed `RecognizerView` into your activity and pass activity's lifecycle events to it and it will control the camera and recognition process. For more information, see [Embedding `RecognizerView` into custom scan activity](#recognizerView).

# <a name="quickStart"></a> Quick Start

## <a name="quickDemo"></a> Quick start with demo app

1. Open Android Studio.
2. In Quick Start dialog choose _Import project (Eclipse ADT, Gradle, etc.)_.
3. In File dialog select _BlinkIDDemo_ folder.
4. Wait for project to load. If Android studio asks you to reload project on startup, select `Yes`.

## <a name="mavenIntegration"></a> Integrating _BlinkID_ into your project using Maven

Maven repository for _BlinkID_ SDK is: [http://maven.microblink.com](http://maven.microblink.com). If you do not want to perform integration via Maven, simply skip to [Android Studio integration instructions](#quickIntegration) or [Eclipse integration instructions](#eclipseIntegration).

### Using gradle or Android Studio

In your `build.gradle` you first need to add _BlinkID_ maven repository to repositories list:

```
repositories {
	maven { url 'http://maven.microblink.com' }
}
```

After that, you just need to add _BlinkID_ and appCompat-v7 as a dependencies to your application:

```
dependencies {
    compile 'com.microblink:blinkid:2.3.1'
    compile "com.android.support:appcompat-v7:23.1.1"
}
```

If you plan to use ProGuard, add following lines to your `proguard-rules.pro`:
	
```
-keep class com.microblink.** { *; }
-keepclassmembers class com.microblink.** { *; }
-dontwarn android.hardware.**
-dontwarn android.support.v4.**
```

### Using android-maven-plugin

[Android Maven Plugin](https://simpligility.github.io/android-maven-plugin/) v4.0.0 or newer is required.

Open your `pom.xml` file and add these directives as appropriate:

```xml
<repositories>
   	<repository>
       	<id>MicroblinkRepo</id>
       	<url>http://maven.microblink.com</url>
   	</repository>
</repositories>

<dependencies>
	<dependency>
		  <groupId>com.microblink</groupId>
		  <artifactId>blinkid</artifactId>
		  <version>2.3.1</version>
		  <type>aar</type>
  	</dependency>
</dependencies>
```

After that, make sure you add appcompat-v7 dependency to your app. You need at least appcompat-v7 version `23.1.1`.

## <a name="quickIntegration"></a> Android studio integration instructions

1. In Android Studio menu, click _File_, select _New_ and then select _Module_.
2. In new window, select _Import .JAR or .AAR Package_, and click _Next_.
3. In _File name_ field, enter the path to _LibRecognizer.aar_ and click _Finish_.
4. In your app's `build.gradle`, add dependency to `LibRecognizer` and appcompat-v7:

	```
	dependencies {
   		compile project(':LibRecognizer')
 		compile "com.android.support:appcompat-v7:23.1.1"
	}
	```
5. If you plan to use ProGuard, add following lines to your `proguard-rules.pro`:
	
	```
	-keep class com.microblink.** { *; }
	-keepclassmembers class com.microblink.** { *; }
	-dontwarn android.hardware.**
	-dontwarn android.support.v4.**
	```
	
## <a name="eclipseIntegration"></a> Eclipse integration instructions

We do not provide Eclipse integration demo apps. We encourage you to use Android Studio. We also do not test integrating _BlinkID_ with Eclipse. If you are having problems with _BlinkID_, make sure you have tried integrating it with Android Studio prior contacting us.

However, if you still want to use Eclipse, you will need to convert AAR archive to Eclipse library project format. You can do this by doing the following:

1. In Eclipse, create a new _Android library project_ in your workspace.
2. Clear the `src` and `res` folders.
3. Unzip the `LibRecognizer.aar` file. You can rename it to zip and then unzip it using any tool.
4. Copy the `classes.jar` to `libs` folder of your Eclipse library project. If `libs` folder does not exist, create it.
5. Copy the contents of `jni` folder to `libs` folder of your Eclipse library project.
6. Replace the `res` folder on library project with the `res` folder of the `LibRecognizer.aar` file.

You’ve already created the project that contains almost everything you need. Now let’s see how to configure your project to reference this library project.

1. In the project you want to use the library (henceforth, "target project") add the library project as a dependency
2. Open the `AndroidManifest.xml` file inside `LibRecognizer.aar` file and make sure to copy all permissions, features and activities to the `AndroidManifest.xml` file of the target project.
3. Copy the contents of `assets` folder from `LibRecognizer.aar` into `assets` folder of target project. If `assets` folder in target project does not exist, create it.
4. Clean and Rebuild your target project
5. If you plan to use ProGuard, add same statements as in [Android studio guide](#quickIntegration) to your ProGuard configuration file.
6. Add appcompat-v7 library to your workspace and reference it by target project (modern ADT plugin for Eclipse does this automatically for all new android projects).

## <a name="quickScan"></a> Performing your first scan
1. You can start recognition process by starting `ScanCard` activity with Intent initialized in the following way:
	
	```java
	// Intent for ScanCard Activity
	Intent intent = new Intent(this, ScanCard.class);
	
	// set your licence key
	// obtain your licence key at http://microblink.com/login or
	// contact us at http://help.microblink.com
	intent.putExtra(ScanCard.EXTRAS_LICENSE_KEY, "Add your licence key here");

	RecognitionSettings settings = new RecognitionSettings();
	// setup array of recognition settings (described in chapter "Recognition 
	// settings and results")
	settings.setRecognizerSettingsArray(setupSettingsArray());
	intent.putExtra(ScanCard.EXTRAS_RECOGNITION_SETTINGS, settings);

	// Starting Activity
	startActivityForResult(intent, MY_REQUEST_CODE);
	```
2. After `ScanCard` activity finishes the scan, it will return to the calling activity and will call method `onActivityResult`. You can obtain the scanning results in that method.

	```java
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == MY_REQUEST_CODE) {
			if (resultCode == ScanCard.RESULT_OK && data != null) {
				// perform processing of the data here
				
				// for example, obtain parcelable recognition result
				Bundle extras = data.getExtras();
				RecognitionResults result = data.getParcelableExtra(ScanCard.EXTRAS_RECOGNITION_RESULTS);

				// get array of recognition results
				BaseRecognitionResult[] resultArray = result.getRecognitionResults();				
				// Each element in resultArray inherits BaseRecognitionResult class and
				// represents the scan result of one of activated recognizers that have
				// been set up. More information about this can be found in 
				// "Recognition settings and results" chapter
						
				// Or, you can pass the intent to another activity
				data.setComponent(new ComponentName(this, ResultActivity.class));
				startActivity(data);
			}
		}
	}
	```
	
	For more information about defining recognition settings and obtaining scan results see [Recognition settings and results](#recognitionSettingsAndResults).

## <a name="quickScan"></a> Performing your first segment scan
1. You can start recognition process by starting `BlinkOCRActivity` activity with Intent initialized in the following way:
	
	```java
	// Intent for BlinkOCRActivity Activity
	Intent intent = new Intent(this, BlinkOCRActivity.class);
	
	// set your licence key
	// obtain your licence key at http://microblink.com/login or
	// contact us at http://help.microblink.com
	intent.putExtra(BlinkOCRActivity.EXTRAS_LICENSE_KEY, "Add your licence key here");

	// setup array of scan configurations. Each scan configuration
	// contains 4 elements: resource ID for title displayed
	// in BlinkOCRActivity activity, resource ID for text
	// displayed in activity, name of the scan element (used
	// for obtaining results) and parser setting defining
	// how the data will be extracted.
	// For more information about parser setting, check the
	// chapter "Scanning segments with BlinkOCR recognizer"
	ScanConfiguration[] confArray = new ScanConfiguration[] {
                new ScanConfiguration(R.string.amount_title, R.string.amount_msg, "Amount", new AmountParserSettings()),
                new ScanConfiguration(R.string.email_title, R.string.email_msg, "EMail", new EMailParserSettings()),
                new ScanConfiguration(R.string.raw_title, R.string.raw_msg, "Raw", new RawParserSettings())
        };
	intent.putExtra(BlinkOCRActivity.EXTRAS_SCAN_CONFIGURATION, confArray);

	// Starting Activity
	startActivityForResult(intent, MY_REQUEST_CODE);
	```
2. After `BlinkOCRActivity` activity finishes the scan, it will return to the calling activity and will call method `onActivityResult`. You can obtain the scanning results in that method.

	```java
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == MY_REQUEST_CODE) {
			if (resultCode == BlinkOCRActivity.RESULT_OK && data != null) {
				// perform processing of the data here
				
				// for example, obtain parcelable recognition result
				Bundle extras = data.getExtras();
				Bundle results = extras.getBundle(BlinkOCRActivity.EXTRAS_SCAN_RESULTS);
				
				// results bundle contains result strings in keys defined
				// by scan configuration name
				// for example, if set up as in step 1, then you can obtain
				// e-mail address with following line
				String email = results.getString("EMail");
			}
		}
	}
	```

# <a name="advancedIntegration"></a> Advanced _BlinkID_ integration instructions
This section will cover more advanced details in _BlinkID_ integration. First part will discuss the methods for checking whether _BlinkID_ is supported on current device. Second part will cover the possible customization of builtin `ScanCard` activity, third part will describe how to embed `RecognizerView` into your activity and fourth part will describe how to use direct API to recognize directly android bitmaps without the need of camera.

## <a name="supportCheck"></a> Checking if _BlinkID_ is supported

### _BlinkID_ requirements
Even before starting the scan activity, you should check if _BlinkID_ is supported on current device. In order to be supported, device needs to have camera. 


OpenGL ES 2.0 can be used to accelerate _BlinkID's_ processing but is not mandatory. However, it should be noted that if OpenGL ES 2.0 is not available processing time will be significantly large, especially on low end devices. 

Android 2.3 is the minimum android version on which _BlinkID_ is supported.

Camera video preview resolution also matters. In order to perform successful scans, camera preview resolution cannot be too low. _BlinkID_ requires minimum 480p camera preview resolution in order to perform scan. It must be noted that camera preview resolution is not the same as the video record resolution, although on most devices those are the same. However, there are some devices that allow recording of HD video (720p resolution), but do not allow high enough camera preview resolution (for example, [Sony Xperia Go](http://www.gsmarena.com/sony_xperia_go-4782.php) supports video record resolution at 720p, but camera preview resolution is only 320p - _BlinkID_ does not work on that device).

_BlinkID_ is native application, written in C++ and available for multiple platforms. Because of this, _BlinkID_ cannot work on devices that have obscure hardware architectures. We have compiled _BlinkID_ native code only for most popular Android [ABIs](https://en.wikipedia.org/wiki/Application_binary_interface). See [Processor architecture considerations](#archConsider) for more information about native libraries in _BlinkID_ and instructions how to disable certain architectures in order to reduce the size of final app.

### Checking for _BlinkID_ support in your app
To check whether the _BlinkID_ is supported on the device, you can do it in the following way:
	
```java
// check if BlinkID is supported on the device
RecognizerCompatibilityStatus status = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
if(status == RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
	Toast.makeText(this, "BlinkID is supported!", Toast.LENGTH_LONG).show();
} else {
	Toast.makeText(this, "BlinkID is not supported! Reason: " + status.name(), Toast.LENGTH_LONG).show();
}
```

However, some recognizers require camera with autofocus. If you try to start recognition with those recognizers on a device that does not have camera with autofocus, you will get an error. To prevent that, when you prepare the array with recognition settings (see [Recognition settings and results](#recognitionSettingsAndResults) for settings reference), you can easily filter out all settings that require autofocus from array using the following code snippet:

```java
// setup array of recognition settings (described in chapter "Recognition 
// settings and results")
RecognizerSettings[] settArray = setupSettingsArray();
if(!RecognizerCompatibility.cameraHasAutofocus(CameraType.CAMERA_BACKFACE, this)) {
	setarr = RecognizerSettingsUtils.filterOutRecognizersThatRequireAutofocus(setarr);
}
```

## <a name="scanActivityCustomization"></a> Customization of `ScanCard` activity

### `ScanCard` intent extras

This section will discuss possible parameters that can be sent over `Intent` for `ScanCard` activity that can customize default behaviour. There are several intent extras that can be sent to `ScanCard` actitivy:

* **`ScanCard.EXTRAS_CAMERA_TYPE`** - with this extra you can define which camera on device will be used. To set the extra to intent, use the following code snippet:
	
	```java
	intent.putExtra(ScanCard.EXTRAS_CAMERA_TYPE, (Parcelable)CameraType.CAMERA_FRONTFACE);
	```
	
* **`ScanCard.EXTRAS_CAMERA_ASPECT_MODE`** - with this extra you can define which [camera aspect mode](https://blinkid.github.io/blinkid-android/com/microblink/view/CameraAspectMode.html) will be used. If set to `ASPECT_FIT` (default), then camera preview will be letterboxed inside available view space. If set to `ASPECT_FILL`, camera preview will be zoomed and cropped to use the entire view space. To set the extra to intent, use the following code snippet:

	```java
	intent.putExtra(ScanCard.EXTRAS_CAMERA_ASPECT_MODE, (Parcelable)CameraAspectMode.ASPECT_FIT);
	```
	
* **`ScanCard.EXTRAS_RECOGNITION_SETTINGS`** - with this extra you can define settings that affect whole recognition process. This includes both array of recognizer settings and global recognition settings. More information about recognition settings can be found in chapter [Recognition settings and results](#recognitionSettingsAndResults). To set the extra to intent, use the following code snippet:
	
	```java
	RecognitionSettings recognitionSettings = new RecognitionSettings();
	// define additional settings; e.g set timeout to 10 seconds
	recognitionSettings.setNumMsBeforeTimeout(10000);
	// setup recognizer settings array
	recognitionSettings.setRecognizerSettingsArray(setupSettingsArray());
	intent.putExtra(ScanCard.EXTRAS_RECOGNITION_SETTINGS, recognitionSettings);
	```
		
* **`ScanCard.EXTRAS_RECOGNITION_RESULTS`** - you can use this extra in `onActivityResult` method of calling activity to obtain recognition results. For more information about recognition settings and result, see [Recognition settings and results](#recognitionSettingsAndResults). You can use the following snippet to obtain scan results:

	```java
	RecognitionResults results = data.getParcelableExtra(ScanCard.EXTRAS_RECOGNITION_RESULTS);
	```
	
* **`ScanCard.EXTRAS_OPTIMIZE_CAMERA_FOR_NEAR_SCANNING`** - with this extra you can give a hint to _BlinkID_ to optimize camera parameters for near object scanning. When camera parameters are optimized for near object scanning, macro focus mode will be preferred over autofocus mode. Thus, camera will have easier time focusing on to near objects, but might have harder time focusing on far objects. If you expect that most of your scans will be performed by holding the device very near the object, turn on that parameter. By default, this parameter is set to false.
	
* **`ScanCard.EXTRAS_BEEP_RESOURCE`** - with this extra you can set the resource ID of the sound to be played when scan completes. You can use following snippet to set this extra:

	```java
	intent.putExtra(ScanCard.EXTRAS_BEEP_RESOURCE, R.raw.beep);
    ```
* **`ScanCard.EXTRAS_SPLASH_SCREEN_LAYOUT_RESOURCE`** - with this extra you can set the resource ID of the layout that will be used as camera splash screen while camera is being initialized. You can use following snippet to set this extra:

	```java
	intent.putExtra(ScanCard. EXTRAS_SPLASH_SCREEN_LAYOUT_RESOURCE, R.layout.camera_splash);
    ```
	
* **`ScanCard.EXTRAS_SHOW_FOCUS_RECTANGLE`** - with this extra you can enable showing of rectangle that displays area camera uses to measure focus and brightness when automatically adjusting its parameters. You can enable showing of this rectangle with following code snippet:

	```java
	intent.putExtra(ScanCard.EXTRAS_SHOW_FOCUS_RECTANGLE, true);
	```
	
* **`ScanCard.EXTRAS_ALLOW_PINCH_TO_ZOOM`** - with this extra you can set whether pinch to zoom will be allowed on camera activity. Default is `false`. To enable pinch to zoom gesture on camera activity, use the following code snippet:

	```java
	intent.putExtra(ScanCard.EXTRAS_ALLOW_PINCH_TO_ZOOM, true);
	```
* **`ScanCard.EXTRAS_CAMERA_VIDEO_PRESET`** - with this extra you can set the video resolution preset that will be used when choosing camera resolution for scanning. For more information, see [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/hardware/camera/VideoResolutionPreset.html). For example, to use 720p video resolution preset, use the following code snippet:

	```java
	intent.putExtra(ScanCard.EXTRAS_CAMERA_VIDEO_PRESET, (Parcelable)VideoResolutionPreset.VIDEO_RESOLUTION_720p);
	```

* **`ScanCard.EXTRAS_LICENSE_KEY`** - with this extra you can set the license key for _BlinkID_. You can obtain your licence key from [Microblink website](http://microblink.com/login) or you can contact us at [http://help.microblink.com](http://help.microblink.com). Once you obtain a license key, you can set it with following snippet:

	```java
	// set the license key
	intent.putExtra(ScanCard.EXTRAS_LICENSE_KEY, "Enter_License_Key_Here");
	```
	
	Licence key is bound to package name of your application. For example, if you have licence key that is bound to `com.microblink.blinkid` app package, you cannot use the same key in other applications. However, if you purchase Premium licence, you will get licence key that can be used in multiple applications. This licence key will then not be bound to package name of the app. Instead, it will be bound to the licencee string that needs to be provided to the library together with the licence key. To provide licencee string, use the `EXTRAS_LICENSEE` intent extra like this:

	```java
	// set the license key
	intent.putExtra(ScanCard.EXTRAS_LICENSE_KEY, "Enter_License_Key_Here");
	intent.putExtra(ScanCard.EXTRAS_LICENSEE, "Enter_Licensee_Here");
	```

* **`ScanCard.EXTRAS_SHOW_OCR_RESULT`** - with this extra you can define whether OCR result should be drawn on camera preview as it arrives. This is enabled by default, to disable it, use the following snippet:

	```java
	// enable showing of OCR result
	intent.putExtra(ScanCard.EXTRAS_SHOW_OCR_RESULT, false);
	```

* **`ScanCard.EXTRAS_SHOW_OCR_RESULT_MODE`** - if OCR result should be drawn on camera preview, this extra defines how it will be drawn. Here you need to pass instance of [ShowOcrResultMode](https://blinkid.github.io/blinkid-android/com/microblink/activity/ShowOcrResultMode.html). By default, `ShowOcrResultMode.ANIMATED_DOTS` is used. You can also enable `ShowOcrResultMode.STATIC_CHARS` to draw recognized chars instead of dots. To set this extra, use the following snippet:

	```java
	// display colored static chars instead of animated dots
	intent.putExtra(ScanCard.EXTRAS_SHOW_OCR_RESULT_MODE, (Parcelable) ShowOcrResultMode.STATIC_CHARS);
	```

* **`ScanCard.EXTRAS_IMAGE_LISTENER`** - with this extra you can set your implementation of [ImageListener interface](https://blinkid.github.io/blinkid-android/com/microblink/image/ImageListener.html) that will obtain images that are being processed. Make sure that your [ImageListener](https://blinkid.github.io/blinkid-android/com/microblink/image/ImageListener.html) implementation correctly implements [Parcelable](https://developer.android.com/reference/android/os/Parcelable.html) interface with static [CREATOR](https://developer.android.com/reference/android/os/Parcelable.Creator.html) field. Without this, you might encounter a runtime error. For more information and example, see [Using ImageListener to obtain images that are being processed](#imageListener).

### Customizing `ScanCard` appearance

Besides possibility to put various intent extras for customizing `ScanCard` behaviour, you can also change strings it displays. The procedure for changing strings in `ScanCard` activity are explained in [Translation and localization](#stringChanging) section.

#### Modifying other resources.

Generally, you can also change other resources that `ScanCard` uses, but you are encouraged to create your own custom scan activity instead (see [Embedding `RecognizerView` into custom scan activity](#recognizerView)).

## <a name="segmentScanActivityCustomization"></a> Customization of `BlinkOCRActivity` activity

### `BlinkOCRActivity` intent extras

This section will discuss possible parameters that can be sent over `Intent` for `BlinkOCRActivity` activity that can customize default behaviour. There are several intent extras that can be sent to `BlinkOCRActivity` actitivy:
	
* **`BlinkOCRActivity.EXTRAS_SCAN_CONFIGURATION`** - with this extra you must set the array of [ScanConfiguration](https://blinkid.github.io/blinkid-android/com/microblink/ocr/ScanConfiguration.html) objects. Each `ScanConfiguration` object will define specific scan configuration that will be performed. `ScanConfiguration` defines two string resource ID's - title of the scanned item and text that will be displayed above field where scan is performed. Besides that it defines the name of scanned item and object defining the OCR parser settings. More information about parser settings can be found in chapter [Scanning segments with BlinkOCR recognizer](#blinkOCR). Here is only important that each scan configuration represents a single parser group and BlinkOCRActivity ensures that only one parser group is active at a time. After defining scan configuration array, you need to put it into intent extra with following code snippet:
	
	```java
	intent.putExtra(BlinkOCRActivity.EXTRAS_SCAN_CONFIGURATION, confArray);
	```
	
* **`BlinkOCRActivity.EXTRAS_SCAN_RESULTS`** - you can use this extra in `onActivityResult` method of calling activity to obtain bundle with recognition results. Bundle will contain only strings representing scanned data under keys defined with each scan configuration. If you also need to obtain OCR result structure, then you need to perform [advanced integration](#recognizerView). You can use the following snippet to obtain scan results:

	```java
	Bundle results = data.getBundle(BlinkOCRActivity.EXTRAS_SCAN_RESULTS);
	```
	
* **`BlinkOCRActivity.EXTRAS_HELP_INTENT`** - with this extra you can set fully initialized intent that will be sent when user clicks the help button. You can put any extras you want to your intent - all will be delivered to your activity when user clicks the help button. If you do not set help intent, help button will not be shown in camera interface. To set the intent for help activity, use the following code snippet:
	
	```java
	/** Set the intent which will be sent when user taps help button. 
	 *  If you don't set the intent, help button will not be shown.
	 *  Note that this applies only to default PhotoPay camera UI.
	 * */
	intent.putExtra(BlinkOCRActivity.EXTRAS_HELP_INTENT, new Intent(this, HelpActivity.class));
	```
* **`BlinkOCRActivity.EXTRAS_CAMERA_VIDEO_PRESET`** - with this extra you can set the video resolution preset that will be used when choosing camera resolution for scanning. For more information, see [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/hardware/camera/VideoResolutionPreset.html). For example, to use 720p video resolution preset, use the following code snippet:

	```java
	intent.putExtra(BlinkOCRActivity.EXTRAS_CAMERA_VIDEO_PRESET, (Parcelable)VideoResolutionPreset.VIDEO_RESOLUTION_720p);
	```

* **`ScanCard.EXTRAS_LICENSE_KEY`** - with this extra you can set the license key for _BlinkID_. You can obtain your licence key from [Microblink website](http://microblink.com/login) or you can contact us at [http://help.microblink.com](http://help.microblink.com). Once you obtain a license key, you can set it with following snippet:

	```java
	// set the license key
	intent.putExtra(ScanCard.EXTRAS_LICENSE_KEY, "Enter_License_Key_Here");
	```
	
	Licence key is bound to package name of your application. For example, if you have licence key that is bound to `com.microblink.blinkid` app package, you cannot use the same key in other applications. However, if you purchase Premium licence, you will get licence key that can be used in multiple applications. This licence key will then not be bound to package name of the app. Instead, it will be bound to the licencee string that needs to be provided to the library together with the licence key. To provide licencee string, use the `EXTRAS_LICENSEE` intent extra like this:

	```java
	// set the license key
	intent.putExtra(ScanCard.EXTRAS_LICENSE_KEY, "Enter_License_Key_Here");
	intent.putExtra(ScanCard.EXTRAS_LICENSEE, "Enter_Licensee_Here");
	```

* **`ScanCard.EXTRAS_SHOW_OCR_RESULT`** - with this extra you can define whether OCR result should be drawn on camera preview as it arrives. This is enabled by default, to disable it, use the following snippet:

	```java
	// enable showing of OCR result
	intent.putExtra(ScanCard.EXTRAS_SHOW_OCR_RESULT, false);
	```

* **`ScanCard.EXTRAS_SHOW_OCR_RESULT_MODE`** - if OCR result should be drawn on camera preview, this extra defines how it will be drawn. Here you need to pass instance of [ShowOcrResultMode](https://blinkid.github.io/blinkid-android/com/microblink/activity/ShowOcrResultMode.html). By default, `ShowOcrResultMode.ANIMATED_DOTS` is used. You can also enable `ShowOcrResultMode.STATIC_CHARS` to draw recognized chars instead of dots. To set this extra, use the following snippet:

	```java
	// display colored static chars instead of animated dots
	intent.putExtra(ScanCard.EXTRAS_SHOW_OCR_RESULT_MODE, (Parcelable) ShowOcrResultMode.STATIC_CHARS);
	```

* **`ScanCard.EXTRAS_IMAGE_LISTENER`** - with this extra you can set your implementation of [ImageListener interface](https://blinkid.github.io/blinkid-android/com/microblink/image/ImageListener.html) that will obtain images that are being processed. Make sure that your [ImageListener](https://blinkid.github.io/blinkid-android/com/microblink/image/ImageListener.html) implementation correctly implements [Parcelable](https://developer.android.com/reference/android/os/Parcelable.html) interface with static [CREATOR](https://developer.android.com/reference/android/os/Parcelable.Creator.html) field. Without this, you might encounter a runtime error. For more information and example, see [Using ImageListener to obtain images that are being processed](#imageListener).

## <a name="recognizerView"></a> Embedding `RecognizerView` into custom scan activity
This section will discuss how to embed `RecognizerView` into your scan activity and perform scan.

1. First make sure that `RecognizerView` is a member field in your activity. This is required because you will need to pass all activity's lifecycle events to `RecognizerView`.
2. It is recommended to keep your scan activity in one orientation, such as `portrait` or `landscape`. Setting `sensor` as scan activity's orientation will trigger full restart of activity whenever device orientation changes. This will provide very poor user experience because both camera and _BlinkID_ native library will have to be restarted every time. There are measures for this behaviour and will be discussed [later](#scanOrientation).
3. In your activity's `onCreate` method, create a new `RecognizerView`, define its [settings and listeners](#recognizerViewReference) and then call its `create` method. After that, add your views that should be layouted on top of camera view.
4. Override your activity's `onStart`, `onResume`, `onPause`, `onStop` and `onDestroy` methods and call `RecognizerView's` lifecycle methods `start`, `resume`, `pause`, `stop` and `destroy`. This will ensure correct camera and native resource management. If you plan to manage `RecognizerView's` lifecycle independently of host activity's lifecycle, make sure the order of calls to lifecycle methods is the same as is with activities (i.e. you should not call `resume` method if `create` and `start` were not called first).

Here is the minimum example of integration of `RecognizerView` as the only view in your activity:

```java
public class MyScanActivity extends Activity implements ScanResultListener, CameraEventsListener {
	private static final int PERMISSION_CAMERA_REQUEST_CODE = 69;
	private RecognizerView mRecognizerView;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {				
		// create RecognizerView
		mRecognizerView = new RecognizerView(this);
		   
		RecognitionSettings settings = new RecognitionSettings();
		// setup array of recognition settings (described in chapter "Recognition 
		// settings and results")
		RecognizerSettings[] settArray = setupSettingsArray();
		if(!RecognizerCompatibility.cameraHasAutofocus(CameraType.CAMERA_BACKFACE, this)) {
			settArray = RecognizerSettingsUtils.filterOutRecognizersThatRequireAutofocus(settArray);
		}
		settings.setRecognizerSettingsArray(settArray);
		mRecognizerView.setRecognitionSettings(settings);
		
		try {
		    // set license key
		    mRecognizerView.setLicenseKey(this, "your license key");
		} catch (InvalidLicenceKeyException exc) {
		    finish();
		    return;
		}
		
		// scan result listener will be notified when scan result gets available
		mRecognizerView.setScanResultListener(this);
		// camera events listener will be notified about camera lifecycle and errors
		mRecognizerView.setCameraEventsListener(this);
		
		// set camera aspect mode
		// ASPECT_FIT will fit the camera preview inside the view
		// ASPECT_FILL will zoom and crop the camera preview, but will use the
		// entire view surface
		mRecognizerView.setAspectMode(CameraAspectMode.ASPECT_FILL);
		   
		mRecognizerView.create();
		
		setContentView(mRecognizerView);
	}
	
	@Override
	protected void onStart() {
	   super.onStart();
	   // you need to pass all activity's lifecycle methods to RecognizerView
	   mRecognizerView.start();
	}
	
	@Override
	protected void onResume() {
	   	super.onResume();
	   	// you need to pass all activity's lifecycle methods to RecognizerView
       mRecognizerView.resume();
	}

	@Override
	protected void onPause() {
	   	super.onPause();
	   	// you need to pass all activity's lifecycle methods to RecognizerView
		mRecognizerView.pause();
	}

	@Override
	protected void onStop() {
	   super.onStop();
	   // you need to pass all activity's lifecycle methods to RecognizerView
	   mRecognizerView.stop();
	}
	
	@Override
	protected void onDestroy() {
	   super.onDestroy();
	   // you need to pass all activity's lifecycle methods to RecognizerView
	   mRecognizerView.destroy();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	   super.onConfigurationChanged(newConfig);
	   // you need to pass all activity's lifecycle methods to RecognizerView
	   mRecognizerView.changeConfiguration(newConfig);
	}
		
    @Override
    public void onScanningDone(RecognitionResults results) {
    	// this method is from ScanResultListener and will be called when scanning completes
    	// RecognitionResults may contain multiple results in array returned
    	// by method getRecognitionResults().
    	// This depends on settings in RecognitionSettings object that was
    	// given to RecognizerView.
    	// For more information, see chapter "Recognition settings and results")
    	
    	// After this method ends, scanning will be resumed and recognition
    	// state will be retained. If you want to prevent that, then
    	// you should call:
    	// mRecognizerView.resetRecognitionState();

		// If you want to pause scanning to prevent receiving recognition
		// results, you should call:
		// mRecognizerView.pauseScanning();
		// After scanning is paused, you will have to resume it with:
		// mRecognizerView.resumeScanning(true);
		// boolean in resumeScanning method indicates whether recognition
		// state should be automatically reset when resuming scanning
    }
    
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
    	 * Called on Android 6.0 and newer if camera permission is not given
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
}
```

### <a name="scanOrientation"></a> Scan activity's orientation

If activity's `screenOrientation` property in `AndroidManifest.xml` is set to `sensor`, `fullSensor` or similar, activity will be restarted every time device changes orientation from portrait to landscape and vice versa. While restarting activity, its `onPause`, `onStop` and `onDestroy` methods will be called and then new activity will be created anew. This is a potential problem for scan activity because in its lifecycle it controls both camera and native library - restarting the activity will trigger both restart of the camera and native library. This is a problem because changing orientation from landscape to portrait and vice versa will be very slow, thus degrading a user experience. **We do not recommend such setting.**

For that matter, we recommend setting your scan activity to either `portrait` or `landscape` mode and handle device orientation changes manually. To help you with this, `RecognizerView` supports adding child views to it that will be rotated regardless of activity's `screenOrientation`. You add a view you wish to be rotated (such as view that contains buttons, status messages, etc.) to `RecognizerView` with `addChildView` method. The second parameter of the method is a boolean that defines whether the view you are adding will be rotated with device. To define allowed orientations, implement [OrientationAllowedListener](https://blinkid.github.io/blinkid-android/com/microblink/view/OrientationAllowedListener.html) interface and add it to `RecognizerView` with method `setOrientationAllowedListener`. **This is the recommended way of rotating camera overlay.**

However, if you really want to set `screenOrientation` property to `sensor` or similar and want Android to handle orientation changes of your scan activity, then we recommend to set `configChanges` property of your activity to `orientation|screenSize`. This will tell Android not to restart your activity when device orientation changes. Instead, activity's `onConfigurationChanged` method will be called so that activity can be notified of the configuration change. In your implementation of this method, you should call `changeConfiguration` method of `RecognizerView` so it can adapt its camera surface and child views to new configuration. Note that on Android versions older than 4.0 changing of configuration will require restart of camera, which can be slow.

## <a name="recognizerViewReference"></a> `RecognizerView` reference
The complete reference of `RecognizerView` is available in [Javadoc](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html). The usage example is provided in `BlinkIDDemoCustomUI` demo app provided with SDK. This section just gives a quick overview of `RecognizerView's` most important methods.

##### <a name="recognizerView_create"></a> [`create()`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#create--)
This method should be called in activity's `onCreate` method. It will initialize `RecognizerView's` internal fields and will initialize camera control thread. This method must be called after all other settings are already defined, such as listeners and recognition settings. After calling this method, you can add child views to `RecognizerView` with method `addChildView(View, boolean)`.

##### <a name="recognizerView_start"></a> [`start()`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#start--)
This method should be called in activity's `onStart` method. It will initialize background processing thread and start native library initialization on that thread.

##### <a name="recognizerView_resume"></a> [`resume()`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#resume--)
This method should be called in activity's `onResume` method. It will trigger background initialization of camera. After camera is loaded, it will start camera frame recognition, except if scanning loop is paused.

##### <a name="recognizerView_pause"></a> [`pause()`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#pause--)
This method should be called in activity's `onPause` method. It will stop the camera, but will keep native library loaded.

##### <a name="recognizerView_stop"></a> [`stop()`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#stop--)
This method should be called in activity's `onStop` method. It will deinitialize native library, terminate background processing thread and free all resources that are no longer necessary.

##### <a name="recognizerView_destroy"></a> [`destroy()`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#destroy--)
This method should be called in activity's `onDestroy` method. It will free all resources allocated in `create()` and will terminate camera control thread.

##### <a name="recognizerView_changeConfiguration"></a> [`changeConfiguration(Configuration)`](https://blinkid.github.io/blinkid-android/com/microblink/view/BaseCameraView.html#changeConfiguration-android.content.res.Configuration-)
This method should be called in activity's `onConfigurationChanged` method. It will adapt camera surface to new configuration without the restart of the activity. See [Scan activity's orientation](#scanOrientation) for more information.

##### <a name="recognizerView_setCameraType"></a> [`setCameraType(CameraType)`](https://blinkid.github.io/blinkid-android/com/microblink/view/BaseCameraView.html#setCameraType-com.microblink.hardware.camera.CameraType-)
With this method you can define which camera on device will be used. Default camera used is back facing camera.

##### <a name="recognizerView_setAspectMode"></a> [`setAspectMode(CameraAspectMode)`](https://blinkid.github.io/blinkid-android/com/microblink/view/BaseCameraView.html#setAspectMode-com.microblink.view.CameraAspectMode-)
Define the [aspect mode of camera](https://blinkid.github.io/blinkid-android/com/microblink/view/CameraAspectMode.html). If set to `ASPECT_FIT` (default), then camera preview will be letterboxed inside available view space. If set to `ASPECT_FILL`, camera preview will be zoomed and cropped to use the entire view space.

##### <a name="recognizerView_setVideoResolutionPreset"></a> [`setVideoResolutionPreset(VideoResolutionPreset)`](https://blinkid.github.io/blinkid-android/com/microblink/view/BaseCameraView.html#setVideoResolutionPreset-com.microblink.hardware.camera.VideoResolutionPreset-)
Define the [video resolution preset](https://blinkid.github.io/blinkid-android/com/microblink/hardware/camera/VideoResolutionPreset.html) that will be used when choosing camera resolution for scanning.

##### <a name="recognizerView_setRecognitionSettings"></a> [`setRecognitionSettings(RecognitionSettings)`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#setRecognitionSettings-com.microblink.recognizers.settings.RecognitionSettings-)
With this method you can set recognition settings that contains information what will be scanned and how will scan be performed. For more information about recognition settings and results see [Recognition settings and results](#recognitionSettingsAndResults). This method must be called before `create()`.

##### <a name="recognizerView_reconfigureRecognizers1"></a> [`reconfigureRecognizers(RecognitionSettings)`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#reconfigureRecognizers-com.microblink.recognizers.settings.RecognitionSettings-)
With this method you can reconfigure the recognition process while recognizer is active. Unlike `setRecognitionSettings`, this method must be called while recognizer is active (i.e. after `resume` was called). For more information about recognition settings see [Recognition settings and results](#recognitionSettingsAndResults).

##### <a name="recognizerView_setOrientationAllowedListener"></a> [`setOrientationAllowedListener(OrientationAllowedListener)`](https://blinkid.github.io/blinkid-android/com/microblink/view/BaseCameraView.html#setOrientationAllowedListener-com.microblink.view.OrientationAllowedListener-)
With this method you can set a [OrientationAllowedListener](https://blinkid.github.io/blinkid-android/com/microblink/view/OrientationAllowedListener.html) which will be asked if current orientation is allowed. If orientation is allowed, it will be used to rotate rotatable views to it and it will be passed to native library so that recognizers can be aware of the new orientation. If you do not set this listener, recognition will be performed only in orientation defined by current activity's orientation.

##### <a name="recognizerView_setScanResultListener"></a> [`setScanResultListener(ScanResultListener)`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#setScanResultListener-com.microblink.view.recognition.ScanResultListener-)
With this method you can set a [ScanResultListener](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/ScanResultListener.html) which will be notified when recognition completes. After recognition completes, `RecognizerView` will pause its scanning loop and to continue the scanning you will have to call `resumeScanning` method. In this method you can obtain data from scanning results. For more information see [Recognition settings and results](#recognitionSettingsAndResults).

##### <a name="recognizerView_setCameraEventsListener"></a> [`setCameraEventsListener(CameraEventsListener)`](https://blinkid.github.io/blinkid-android/com/microblink/view/BaseCameraView.html#setCameraEventsListener-com.microblink.view.CameraEventsListener-)
With this method you can set a [CameraEventsListener](https://blinkid.github.io/blinkid-android/com/microblink/view/CameraEventsListener.html) which will be notified when various camera events occur, such as when camera preview has started, autofocus has failed or there has been an error while using the camera or performing the recognition.

##### <a name="recognizerView_pauseScanning"></a> [`pauseScanning()`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#pauseScanning--)
This method pauses the scanning loop, but keeps both camera and native library initialized. Pause and resume scanning methods count the number of calls, so if you called `pauseScanning()` twice, you will have to call `resumeScanning` twice to actually resume scanning.

##### <a name="recognizerView_resumeScanning"></a> [`resumeScanning(boolean)`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#resumeScanning-boolean-)
With this method you can resume the paused scanning loop. If called with `true` parameter, implicitly calls `resetRecognitionState()`. If called with `false`, old recognition state will not be reset, so it could be reused for boosting recognition result. This may not be always a desired behaviour.  Pause and resume scanning methods count the number of calls, so if you called `pauseScanning()` twice, you will have to call `resumeScanning` twice to actually resume scanning loop.


##### <a name="recognizerView_setInitialScanningPaused"></a> [`setInitialScanningPaused()`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#setInitialScanningPaused-boolean-)
This method lets you set up RecognizerView to not automatically resume scanning first time [resume](#recognizerView_resume) is called. An example use case of when you might want this is if you want to display onboarding help when opening camera first time and want to prevent scanning in background while onboarding is displayed over camera preview.

##### <a name="recognizerView_resetRecognitionState"></a> [`resetRecognitionState()`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#resetRecognitionState--)
With this method you can reset internal recognition state. State is usually kept to improve recognition quality over time, but without resetting recognition state sometimes you might get poorer results (for example if you scan one object and then another without resetting state you might end up with result that contains properties from both scanned objects).

##### <a name="recognizerView_addChildView"></a> [`addChildView(View, boolean)`](https://blinkid.github.io/blinkid-android/com/microblink/view/BaseCameraView.html#addChildView-android.view.View-boolean-)
With this method you can add your own view on top of `RecognizerView`. `RecognizerView` will ensure that your view will be layouted exactly above camera preview surface (which can be letterboxed if aspect ratio of camera preview size does not match the aspect ratio of `RecognizerView` and camera aspect mode is set to `ASPECT_FIT`). Boolean parameter defines whether your view should be rotated with device orientation changes. The rotation is independent of host activity's orientation changes and allowed orientations will be determined from [OrientationAllowedListener](https://blinkid.github.io/blinkid-android/com/microblink/view/OrientationAllowedListener.html). See also [Scan activity's orientation](#scanOrientation) for more information why you should rotate your views independently of activity.

##### <a name="recognizerView_isCameraFocused"></a> [`isCameraFocused()`](https://blinkid.github.io/blinkid-android/com/microblink/view/BaseCameraView.html#isCameraFocused--) 
This method returns `true` if camera thinks it has focused on object. Note that camera has to be active for this method to work. If camera is not active, returns `false`.

##### <a name="recognizerView_focusCamera"></a> [`focusCamera()`](https://blinkid.github.io/blinkid-android/com/microblink/view/BaseCameraView.html#focusCamera--) 
This method requests camera to perform autofocus. If camera does not support autofocus feature, method does nothing. Note that camera has to be active for this method to work.

##### <a name="recognizerView_isCameraTorchSupported"></a> [`isCameraTorchSupported()`](https://blinkid.github.io/blinkid-android/com/microblink/view/BaseCameraView.html#isCameraTorchSupported--)
This method returns `true` if camera supports torch flash mode. Note that camera has to be active for this method to work. If camera is not active, returns `false`.

##### <a name="recognizerView_setTorchState"></a> [`setTorchState(boolean, SuccessCallback)`](https://blinkid.github.io/blinkid-android/com/microblink/view/BaseCameraView.html#setTorchState-boolean-com.microblink.hardware.SuccessCallback-) 
If torch flash mode is supported on camera, this method can be used to enable/disable torch flash mode. After operation is performed, [SuccessCallback](https://blinkid.github.io/blinkid-android/com/microblink/hardware/SuccessCallback.html) will be called with boolean indicating whether operation has succeeded or not. Note that camera has to be active for this method to work and that callback might be called on background non-UI thread.

##### <a name="recognizerView_setScanningRegion"></a> [`setScanningRegion(Rectangle, boolean)`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#setScanningRegion-com.microblink.geometry.Rectangle-boolean-)
You can use this method to define the scanning region and define whether this scanning region will be rotated with device if [OrientationAllowedListener](https://blinkid.github.io/blinkid-android/com/microblink/view/OrientationAllowedListener.html) determines that orientation is allowed. This is useful if you have your own camera overlay on top of `RecognizerView` that is set as rotatable view - you can thus synchronize the rotation of the view with the rotation of the scanning region native code will scan.

Scanning region is defined as [Rectangle](https://blinkid.github.io/blinkid-android/com/microblink/geometry/Rectangle.html). First parameter of rectangle is x-coordinate represented as percentage of view width, second parameter is y-coordinate represented as percentage of view height, third parameter is region width represented as percentage of view width and fourth parameter is region height represented as percentage of view height.

View width and height are defined in current context, i.e. they depend on screen orientation. If you allow your ROI view to be rotated, then in portrait view width will be smaller than height, whilst in landscape orientation width will be larger than height. This complies with view designer preview. If you choose not to rotate your ROI view, then your ROI view will be laid out either in portrait or landscape, depending on setting for your scan activity in `AndroidManifest.xml`

Note that scanning region only reflects to native code - it does not have any impact on user interface. You are required to create a matching user interface that will visualize the same scanning region you set here.

##### <a name="recognizerView_setMeteringAreas"/></a> [`setMeteringAreas(Rectangle[],boolean)`](https://blinkid.github.io/blinkid-android/com/microblink/view/BaseCameraView.html#setMeteringAreas-com.microblink.geometry.Rectangle:A-boolean-)
This method can only be called when camera is active. You can use this method to define regions which camera will use to perform meterings for focus, white balance and exposure corrections. On devices that do not support metering areas, this will be ignored. Some devices support multiple metering areas and some support only one. If device supports only one metering area, only the first rectangle from array will be used.

Each region is defined as [Rectangle](https://blinkid.github.io/blinkid-android/com/microblink/geometry/Rectangle.html). First parameter of rectangle is x-coordinate represented as percentage of view width, second parameter is y-coordinate represented as percentage of view height, third parameter is region width represented as percentage of view width and fourth parameter is region height represented as percentage of view height.

View width and height are defined in current context, i.e. they depend on current device orientation. If you have custom [OrientationAllowedListener](https://blinkid.github.io/blinkid-android/com/microblink/view/OrientationAllowedListener.html), then device orientation will be the last orientation that you have allowed in your listener. If you don't have it set, orientation will be the orientation of activity as defined in `AndroidManifest.xml`. In portrait orientation view width will be smaller than height, whilst in landscape orientation width will be larger than height. This complies with view designer preview.

Second boolean parameter indicates whether or not metering areas should be automatically updated when device orientation changes.

##### <a name="recognizerView_setMetadataListener"></a> [`setMetadadaListener(MetadataListener, MetadataSettings)`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#setMetadataListener-com.microblink.metadata.MetadataListener-com.microblink.metadata.MetadataSettings-)
You can use this method to define [metadata listener](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataListener.html) that will obtain various metadata
from the current recognition process. Which metadata will be available depends on [metadata settings](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataSettings.html). For more information and examples, check demo applications.

##### <a name="recognizerView_setLicenseKey1"></a> [`setLicenseKey(String licenseKey)`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#setLicenseKey-java.lang.String-)
This method sets the license key that will unlock all features of the native library. You can obtain your license key from [Microblink website](http://microblink.com/login).

##### <a name="recognizerView_setLicenseKey2"></a> [`setLicenseKey(String licenseKey, String licenseOwner)`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#setLicenseKey-java.lang.String-java.lang.String-)
Use this method to set a license key that is bound to a licensee, not the application package name. You will use this method when you obtain a license key that allows you to use _BlinkID_ SDK in multiple applications. You can obtain your license key from [Microblink website](http://microblink.com/login).

# <a name="directAPI"></a> Using direct API for recognition of Android Bitmaps

This section will describe how to use direct API to recognize android Bitmaps without the need for camera. You can use direct API anywhere from your application, not just from activities.

1. First, you need to obtain reference to [Recognizer singleton](https://blinkid.github.io/blinkid-android/com/microblink/directApi/Recognizer.html) using [getSingletonInstance](https://blinkid.github.io/blinkid-android/com/microblink/directApi/Recognizer.html#getSingletonInstance--).
2. Second, you need to [initialize the recognizer](https://blinkid.github.io/blinkid-android/com/microblink/directApi/Recognizer.html#initialize-android.content.Context-com.microblink.recognizers.settings.RecognitionSettings-com.microblink.directApi.DirectApiErrorListener-).
3. After initialization, you can use singleton to [process images](https://blinkid.github.io/blinkid-android/com/microblink/directApi/Recognizer.html#recognizeBitmap-android.graphics.Bitmap-com.microblink.hardware.orientation.Orientation-com.microblink.view.recognition.ScanResultListener-). You cannot process multiple images in parallel.
4. Do not forget to [terminate](https://blinkid.github.io/blinkid-android/com/microblink/directApi/Recognizer.html#terminate--) the recognizer after usage (it is a shared resource).

Here is the minimum example of usage of direct API for recognizing android Bitmap:

```java
public class DirectAPIActivity extends Activity implements ScanResultListener {
	private Recognizer mRecognizer;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// initialize your activity here
	}
	
	@Override
	protected void onStart() {
	   super.onStart();
	   try {
		   mRecognizer = Recognizer.getSingletonInstance();
		} catch (FeatureNotSupportedException e) {
			Toast.makeText(this, "Feature not supported! Reason: " + e.getReason().getDescription(), Toast.LENGTH_LONG).show();
			finish();
			return;
		}
	   try {
	       // set license key
	       mRecognizer.setLicenseKey(this, "your license key");
	   } catch (InvalidLicenceKeyException exc) {
	       finish();
	       return;
	   }
		RecognitionSettings settings = new RecognitionSettings();
		// setupSettingsArray method is described in chapter "Recognition 
		// settings and results")
		settings.setRecognizerSettingsArray(setupSettingsArray());
		mRecognizer.initialize(this, settings, new DirectApiErrorListener() {
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
		mRecognizer.recognize(bitmap, Orientation.ORIENTATION_LANDSCAPE_RIGHT, this);
	}

	@Override
	protected void onStop() {
	   super.onStop();
	   mRecognizer.terminate();
	}

    @Override
    public void onScanningDone(RecognitionResults results) {
    	// this method is from ScanResultListener and will be called 
    	// when scanning completes
    	// RecognitionResults may contain multiple results in array returned
    	// by method getRecognitionResults().
    	// This depends on settings in RecognitionSettings object that was
    	// given to RecognizerView.
    	// For more information, see chapter "Recognition settings and results")
    	    	
    	finish(); // in this example, just finish the activity
    }
    
}
```

## <a name="directAPIStateMachine"></a> Understanding DirectAPI's state machine

DirectAPI's Recognizer singleton is actually a state machine which can be in one of 4 states: `OFFLINE`, `UNLOCKED`, `READY` and `WORKING`. 

- When you obtain the reference to Recognizer singleton, it will be in `OFFLINE` state. 
- First you need to unlock the Recognizer by providing a valid licence key using [`setLicenseKey`](https://blinkid.github.io/blinkid-android/com/microblink/directApi/Recognizer.html#setLicenseKey-android.content.Context-java.lang.String-) method. If you attempt to call `setLicenseKey` while Recognizer is not in `OFFLINE` state, you will get `IllegalStateException`.
- After successful unlocking, Recognizer singleton will move to `UNLOCKED` state.
- Once in `UNLOCKED` state, you can initialize Recognizer by calling [`initialize`](https://blinkid.github.io/blinkid-android/com/microblink/directApi/Recognizer.html#initialize-android.content.Context-com.microblink.recognizers.settings.RecognitionSettings-com.microblink.directApi.DirectApiErrorListener-) method. If you call `initialize` method while Recognizer is not in `UNLOCKED` state, you will get `IllegalStateException`.
- After successful initialization, Recognizer will move to `READY` state. Now you can call any of the `recognize*` methods.
- When starting recognition with any of the `recognize*` methods, Recognizer will move to `WORKING` state. If you attempt to call these methods while Recognizer is not in `READY` state, you will get `IllegalStateException`
- Recognition is performed on background thread so it is safe to call all Recognizer's method from UI thread
- When recognition is finished, Recognizer first moves back to `READY` state and then returns the result via provided [`ScanResultListener`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/ScanResultListener.html). 
- Please note that `ScanResultListener`'s [`onScanningDone`](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/ScanResultListener.html#onScanningDone-com.microblink.recognizers.RecognitionResults-) method will be called on background processing thread, so make sure you do not perform UI operations in this calback.
- By calling [`terminate`](https://blinkid.github.io/blinkid-android/com/microblink/directApi/Recognizer.html#terminate--) method, Recognizer singleton will release all its internal resources and will request processing thread to terminate. Note that even after calling `terminate` you might receive `onScanningDone` event if there was work in progress when `terminate` was called.
- `terminate` method can be called from any Recognizer singleton's state
- You can observe Recognizer singleton's state with method [`getCurrentState`](https://blinkid.github.io/blinkid-android/com/microblink/directApi/Recognizer.html#getCurrentState--)

## <a name="directAPIWithRecognizer"></a> Using DirectAPI while RecognizerView is active
Both [RecognizerView](#recognizerView) and DirectAPI recognizer use the same internal singleton that manages native code. This singleton handles initialization and termination of native library and propagating recognition settings to native library. It is possible to use RecognizerView and DirectAPI together, as internal singleton will make sure correct synchronization and correct recognition settings are used. If you run into problems while using DirectAPI in combination with RecognizerView, [let us know](http://help.microblink.com)!

## <a name="imageListener"></a> Using ImageListener to obtain images that are being processed

This section will give an example how to implement [ImageListener interface](https://blinkid.github.io/blinkid-android/com/microblink/image/ImageListener.html) that will obtain images that are being processed. `ImageListener` has only one method that needs to be implemented: `onImageAvailable(Image)`. This method is called whenever library has available image for current processing step. [Image](https://blinkid.github.io/blinkid-android/com/microblink/image/Image.html) is class that contains all information about available image, including buffer with image pixels. Image can be in several format and of several types. [ImageFormat](https://blinkid.github.io/blinkid-android/com/microblink/image/ImageFormat.html) defines the pixel format of the image, while [ImageType](https://blinkid.github.io/blinkid-android/com/microblink/image/ImageType.html) defines the type of the image. `ImageListener` interface extends android's [Parcelable interface](https://developer.android.com/reference/android/os/Parcelable.html) so it is possible to send implementations via [intents](https://developer.android.com/reference/android/content/Intent.html).

Here is the example implementation of [ImageListener interface](https://blinkid.github.io/blinkid-android/com/microblink/image/ImageListener.html). This implementation will save all images into folder `myImages` on device's external storage:

```java
public class MyImageListener implements ImageListener {

   /**
    * Called when library has image available.
    */
    @Override
    public void onImageAvailable(Image image) {
        // we will save images to 'myImages' folder on external storage
        // image filenames will be 'imageType - currentTimestamp.jpg'
        String output = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myImages";
        File f = new File(output);
        if(!f.exists()) {
            f.mkdirs();
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String dateString = dateFormat.format(new Date());
        String filename = null;
        switch(image.getImageFormat()) {
            case ALPHA_8: {
                filename = output + "/alpha_8 - " + image.getImageName() + " - " + dateString + ".jpg";
                break;
            }
            case BGRA_8888: {
                filename = output + "/bgra - " + image.getImageName() + " - " + dateString + ".jpg";
                break;
            }
            case YUV_NV21: {
                filename = output + "/yuv - " + image.getImageName()+ " - " + dateString + ".jpg";
                break;
            }
        }
        Bitmap b = image.convertToBitmap();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            boolean success = b.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            if(!success) {
                Log.e(this, "Failed to compress bitmap!");
                if(fos != null) {
                    try {
                        fos.close();
                    } catch (IOException ignored) {
                    } finally {
                        fos = null;
                    }
                    new File(filename).delete();
                }
            }
        } catch (FileNotFoundException e) {
            Log.e(this, e, "Failed to save image");
        } finally {
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    /**
     * ImageListener interface extends Parcelable interface, so we also need to implement
     * that interface. The implementation of Parcelable interface is below this line.
     */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static final Creator<MyImageListener> CREATOR = new Creator<MyImageListener>() {
        @Override
        public MyImageListener createFromParcel(Parcel source) {
            return new MyImageListener();
        }

        @Override
        public MyImageListener[] newArray(int size) {
            return new MyImageListener[size];
        }
    };
}
```

Note that [ImageListener](https://blinkid.github.io/blinkid-android/com/microblink/image/ImageListener.html) can only be given to _ScanCard_ via Intent, while to [RecognizerView](#recognizerView), you need to give [Metadata listener](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataListener.html) and [Metadata settings](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataSettings.html) that defines which metadata should be obtained. When you give _ImageListener_ to _ScanCard_ via Intent, it internally registers a _MetadataListener_ that enables obtaining of all available image types and invokes _ImageListener_ given via Intent with the result. For more information and examples how to use _MetadataListener_ for obtaining images, refer to demo applications.

# <a name="recognitionSettingsAndResults"></a> Recognition settings and results

This chapter will discuss various recognition settings used to configure different recognizers and scan results generated by them.

## <a name="recognitionSettings"></a> [Recognition settings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/settings/RecognitionSettings.html)

Recognition settings define what will be scanned and how will the recognition process be performed. Here is the list of methods that are most relevant:

##### [`setAllowMultipleScanResultsOnSingleImage(boolean)`](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/settings/RecognitionSettings.html#setAllowMultipleScanResultsOnSingleImage-boolean-)
Sets whether or not outputting of multiple scan results from same image is allowed. If that is `true`, it is possible to return multiple recognition results produced by different recognizers from same image. However, single recognizer can still produce only a single result from single image. By default, this option is `false`, i.e. the array of `BaseRecognitionResults` will contain at most 1 element. The upside of setting that option to `false` is the speed - if you enable lots of recognizers, as soon as the first recognizer succeeds in scanning, recognition chain will be terminated and other recognizers will not get a chance to analyze the image. The downside is that you are then unable to obtain multiple results from different recognizers from single image.

##### [`setNumMsBeforeTimeout(int)`](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/settings/RecognitionSettings.html#setNumMsBeforeTimeout-int-)
Sets the number of miliseconds _BlinkID_ will attempt to perform the scan it exits with timeout error. On timeout returned array of `BaseRecognitionResults` inside [RecognitionResults](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/RecognitionResults.html) might be null, empty or may contain only elements that are not valid ([`isValid`](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/BaseRecognitionResult.html#isValid--) returns `false`) or are empty ([`isEmpty`](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/BaseRecognitionResult.html#isEmpty--) returns `true`).

##### [`setFrameQualityEstimationMode(FrameQualityEstimationMode)`](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/settings/RecognitionSettings.html#setFrameQualityEstimationMode-com.microblink.recognizers.settings.RecognitionSettings.FrameQualityEstimationMode-)
Sets the mode of the frame quality estimation. Frame quality estimation is the process of estimating the quality of video frame so only best quality frames can be chosen for processing so no time is wasted on processing frames that are of too poor quality to contain any meaningful information. It is **not** used when performing recognition of [Android bitmaps](https://developer.android.com/reference/android/graphics/Bitmap.html) using [Direct API](#directAPI). You can choose 3 different frame quality estimation modes: automatic, always on and always off.

- In **automatic** mode (default), frame quality estimation will be used if device contains multiple processor cores or if on single core device at least one active recognizer requires frame quality estimation.
- In **always on** mode, frame quality estimation will be used always, regardless of device or active recognizers.
- In **always off** mode, frame quality estimation will be always disabled, regardless of device or active recognizers. This is not recommended setting because it can significantly decrease quality of the scanning process.

##### [`setRecognizerSettingsArray(RecognizerSettings[])`](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/settings/RecognitionSettings.html#setRecognizerSettingsArray-com.microblink.recognizers.settings.RecognizerSettings:A-)
Sets the array of [RecognizerSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/settings/RecognizerSettings.html) that will define which recognizers should be activated and how should the be set up. The list of available _RecognizerSettings_ and their specifics are given below.

## <a name="mrtd"></a> Scanning machine-readable travel documents

This section discusses the setting up of machine-readable travel documents(MRTD) recognizer and obtaining results from it.

### Setting up machine-readable travel documents recognizer

To activate MRTD recognizer, you need to create [MRTDRecognizerSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkid/mrtd/MRTDRecognizerSettings.html) and add it to `RecognizerSettings` array. You can use the following code snippet to perform that:

```java
private RecognizerSettings[] setupSettingsArray() {
	MRTDRecognizerSettings sett = new MRTDRecognizerSettings();
	
	// now add sett to recognizer settings array that is used to configure
	// recognition
	return new RecognizerSettings[] { sett };
}
```

`MRTDRecognizerSettings` has following methods for tweaking the recognition:

##### `setAllowUnparsedResults(boolean)`
Set this to `true` to allow obtaining results that have not been parsed by SDK. By default this is off. The reason for this is that we want to ensure best possible data quality when returning results. For that matter we internally parse the MRZ and extract all data, taking all possible OCR mistakes into account. However, if you happen to have a document with MRZ that has format our internal parser still does not support, you need to allow returning of unparsed results. Unparsed results will not contain parsed data, but will contain OCR result received from OCR engine, so you can parse data yourself.

##### `setShowMRZ(boolean)`
Set this to `true` if you use [MetadataListener](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataListener.html) and you want to obtain image containing only Machine Readable Zone. The reported ImageType will be [DEWARPED](https://blinkid.github.io/blinkid-android/com/microblink/image/ImageType.html#DEWARPED) and image name will be `"MRZ"`. You will also need to enable [obtaining of dewarped images](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataSettings.ImageMetadataSettings.html#setDewarpedImageEnabled-boolean-) in [MetadataSettings](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataSettings.html). By default, this is turned off.

##### `setShowFullDocument(boolean)`
Set this to `true` if you use [MetadataListener](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataListener.html) and you want to obtain image containing full document containing Machine Readable Zone. The document image's orientation will be corrected. The reported ImageType will be [DEWARPED](https://blinkid.github.io/blinkid-android/com/microblink/image/ImageType.html#DEWARPED) and image name will be `"MRTD"`.  You will also need to enable [obtaining of dewarped images](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataSettings.ImageMetadataSettings.html#setDewarpedImageEnabled-boolean-) in [MetadataSettings](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataSettings.html). By default, this is turned off.

### Obtaining results from machine-readable travel documents recognizer

MRTD recognizer produces [MRTDRecognitionResult](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkid/mrtd/MRTDRecognitionResult.html). You can use `instanceof` operator to check if element in results array is instance of `MRTDRecognitionResult` class. See the following snippet for an example:

```java
@Override
public void onScanningDone(RecognitionResults results) {
	BaseRecognitionResult[] dataArray = results.getRecognitionResults();
	for(BaseRecognitionResult baseResult : dataArray) {
		if(baseResult instanceof MRTDRecognitionResult) {
			MRTDRecognitionResult result = (MRTDRecognitionResult) baseResult;
			
	        // you can use getters of MRTDRecognitionResult class to 
	        // obtain scanned information
	        if(result.isValid() && !result.isEmpty()) {
				if(result.isMRZParsed()) {
					String primaryId = result.getPrimaryId();
					String secondaryId = result.getSecondaryId();
					String documentNumber = result.getDocumentNumber();
				} else {
					OcrResult rawOcr = result.getOcrResult();
					// attempt to parse OCR result by yourself
					// or ask user to try again
				}		 
	        } else {
	        	// not all relevant data was scanned, ask user
	        	// to try again
	        }
		}
	}
}
```

Available getters are:

##### `boolean isValid()`
Returns `true` if scan result is valid, i.e. if all required elements were scanned with good confidence and can be used. If `false` is returned that indicates that some crucial data fields are missing. You should ask user to try scanning again. If you keep getting `false` (i.e. invalid data) for certain document, please report that as a bug to [help.microblink.com](http://help.microblink.com). Please include high resolution photographs of problematic documents.

##### `boolean isEmpty()`
Returns `true` if scan result is empty, i.e. nothing was scanned. All getters should return `null` for empty result.

##### `String getPrimaryId()`
Returns the primary indentifier. If there is more than one component, they are separated with space.

##### `String getSecondaryId()`
Returns the secondary identifier. If there is more than one component, they are separated with space.

##### `String getIssuer()`
Returns three-letter or two-letter code which indicate the issuing State. Three-letter codes are based on `Aplha-3` codes for entities specified in `ISO 3166-1`, with extensions for certain States. Two-letter codes are based on `Aplha-2` codes for entities specified in `ISO 3166-1`, with extensions for certain States.

##### `String getDateOfBirth()`
Returns holder's date of birth in format `YYMMDD`.

##### `String getDocumentNumber()`
Returns document number. Document number contains up to 9 characters.

##### `String getNationality()`
Returns nationality of the holder represented by a three-letter or two-letter code. Three-letter codes are based on `Alpha-3` codes for entities specified in `ISO 3166-1`, with extensions for certain States. Two-letter codes are based on `Aplha-2` codes for entities specified in `ISO 3166-1`, with extensions for certain States.

##### `String getSex()`
Returns sex of the card holder. Sex is specified by use of the single initial, capital letter `F` for female, `M` for male or `<` for unspecified.

##### `String getDocumentCode()`
Returns document code. Document code contains two characters. For `MRTD` the first character shall be `A`, `C` or `I`. The second character shall be discretion of the issuing State or organization except that V shall not be used, and `C` shall not be used after `A` except in the crew member certificate. On machine-readable passports `(MRP)` first character shall be `P` to designate an `MRP`. One additional letter may be used, at the discretion of the issuing State or organization, to designate a particular `MRP`. If the second character position is not used for this purpose, it shall be filled by the filter character `<`.

##### `String getDateOfExpiry()`
Returns date of expiry of the document in format `YYMMDD`.

##### `String getOpt1()`
Returns first optional data. Returns `null` or empty string if not available.

##### `String getOpt2()`
Returns second optional data. Returns `null` or empty string if not available.

##### `String getMRZText()`
Returns the entire Machine Readable Zone text from ID. This text is usually used for parsing other elements.

##### `boolean isMRZParsed()`
Returns `true` if Machine Readable Zone has been parsed, `false` otherwise. `false` can only be returned if in settings object you called `setAllowUnparsedResults(true)`. If Machine Readable Zone has not been parsed, you can still obtain OCR result with `getOcrResult()` and attempt to parse it yourself.

##### `OcrResult getOcrResult()`
Returns the raw [OCR result](https://blinkid.github.io/blinkid-android/com/microblink/results/ocr/OcrResult.html) that was used for parsing data. If `isMRZParsed()` returns `false`, you can use OCR result to parse data by yourself.

## <a name="usdl"></a> Scanning US Driver's licence barcodes

This section discusses the settings for setting up USDL recognizer and explains how to obtain results from it.

### Setting up USDL recognizer
To activate USDL recognizer, you need to create [USDLRecognizerSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkbarcode/usdl/USDLRecognizerSettings.html) and add it to `RecognizerSettings` array. You can do this using following code snippet:

```java
private RecognizerSettings[] setupSettingsArray() {
	USDLRecognizerSettings sett = new USDLRecognizerSettings();
	// disallow scanning of barcodes that have invalid checksum
	sett.setUncertainScanning(false);
	// disable scanning of barcodes that do not have quiet zone
	// as defined by the standard
	sett.setNullQuietZoneAllowed(false);
       
	// now add sett to recognizer settings array that is used to configure
	// recognition
	return new RecognizerSettings[] { sett };
}
```

As can be seen from example, you can tweak USDL recognition parameters with methods of `USDLRecognizerSettings`.

##### `setUncertainScanning(boolean)`
By setting this to `true`, you will enable scanning of non-standard elements, but there is no guarantee that all data will be read. This option is used when multiple rows are missing (e.g. not whole barcode is printed). Default is `false`.

##### `setNullQuietZoneAllowed(boolean)`
By setting this to `true`, you will allow scanning barcodes which don't have quiet zone surrounding it (e.g. text concatenated with barcode). This option can significantly increase recognition time. Default is `true`.

##### `setScan1DBarcodes(boolean)`
Some driver's licenses contain 1D Code39 and Code128 barcodes alongside PDF417 barcode. These barcodes usually contain only reduntant information and are therefore not read by default. However, if you feel that some information is missing, you can enable scanning of those barcodes by setting this to `true`.

### Obtaining results from USDL recognizer

USDL recognizer produces [USDLScanResult](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkbarcode/usdl/USDLScanResult.html). You can use `instanceof` operator to check if element in results array is instance of `USDLScanResult`. See the following snippet for an example:

```java
@Override
public void onScanningDone(RecognitionResults results) {
	BaseRecognitionResult[] dataArray = results.getRecognitionResults();
	for(BaseRecognitionResult baseResult : dataArray) {
		if(baseResult instanceof USDLScanResult) {
			USDLScanResult result = (USDLScanResult) baseResult;
			
	        // getStringData getter will return the string version of barcode contents (not parsed)
			String barcodeData = result.getStringData();
			// isUncertain getter will tell you if scanned barcode is uncertain
			boolean uncertainData = result.isUncertain();
			// getRawData getter will return the raw data information object of barcode contents
			BarcodeDetailedData rawData = result.getRawData();
			// BarcodeDetailedData contains information about barcode's binary layout, if you
			// are only interested in raw bytes, you can obtain them with getAllData getter
			byte[] rawDataBuffer = rawData.getAllData();
			
			// if you need specific parsed driver's licence element, you can
			// use getField method
			// for example, to obtain AAMVA version, you should use:
			String aamvaVersion = result.getField(USDLScanResult.kAamvaVersionNumber);
		}
	}
}
```

##### `String getStringData()`
This method will return the string representation of barcode contents (not parsed). Note that PDF417 barcode can contain binary data so sometimes it makes little sense to obtain only string representation of barcode data.

##### `boolean isUncertain()`
This method will return the boolean indicating if scanned barcode is uncertain. This can return `true` only if scanning of uncertain barcodes is allowed, as explained earlier.

##### `BarcodeDetailedData getRawData()`
This method will return the object that contains information about barcode's binary layout. You can see information about that object in [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/results/barcode/BarcodeDetailedData.html). However, if you only need to access byte array containing, you can call method `getAllData` of `BarcodeDetailedData` object.

##### `getField(String)`
This method will return a parsed US Driver's licence element. The method requires a key that defines which element should be returned and returns either a string representation of that element or `null` if that element does not exist in barcode. To see a list of available keys, refer to [Keys for obtaining US Driver's license data](DriversLicenseKeys.md)

## <a name="eudl"></a> Scanning EU driver's licences

This section discusses the setting up of EU Driver's Licence recognizer and obtaining results from it. United Kingdom's and German's driver's licenses are supported.

### Setting up EU Driver's Licence recognizer

To activate EUDL recognizer, you need to create [EUDLRecognizerSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkid/eudl/EUDLRecognizerSettings.html) and add it to `RecognizerSettings` array. You can use the following code snippet to perform that:

```java
private RecognizerSettings[] setupSettingsArray() {
	// pass country to EUDLRecognizerSettings constructor, supported countries are:
	// - UK (EUDLCountry.EUDL_COUNTRY_UK)
	// - Germany (EUDLCountry.EUDL_COUNTRY_GERMANY)
	EUDLRecognizerSettings sett = new EUDLRecognizerSettings(EUDLCountry.EUDL_COUNTRY_UK)
	
	// now add sett to recognizer settings array that is used to configure
	// recognition
	return new RecognizerSettings[] { sett };
}
```

You can also tweak EUDL recognition parameters with methods of [EUDLRecognizerSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkid/eudl/EUDLRecognizerSettings.html).

##### `setCountry(EUDLCountry country)`
Method activates scanning settings for given country. United Kingdom's and German's driver's licenses are supported.

##### `setExtractIssueDate(boolean)`
Defines if issue date should be extracted. Default is `true`.

##### `setExtractExpiryDate(boolean)`
Defines if expiry date should be extracted. Default is `true`.

##### `setExtractAddress(boolean)`
Defines if address should be extracted. Default is `true`.

##### `setShowFullDocument(boolean)`
Set this to `true` if you use [MetadataListener](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataListener.html) and you want to obtain image containing scanned document. The document image's orientation will be corrected. The reported ImageType will be [DEWARPED](https://blinkid.github.io/blinkid-android/com/microblink/image/ImageType.html#DEWARPED) and image name will be `"EUDL"`.  You will also need to enable [obtaining of dewarped images](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataSettings.ImageMetadataSettings.html#setDewarpedImageEnabled-boolean-) in [MetadataSettings](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataSettings.html). By default, this is turned off.

### Obtaining results from EU Driver's Licence recognizer

EUDL recognizer produces [EUDLRecognitionResult](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkid/eudl/EUDLRecognitionResult.html). You can use `instanceof` operator to check if element in results array is instance of `EUDLRecognitionResult` class. See the following snippet for an example:

```java
@Override
public void onScanningDone(RecognitionResults results) {
	BaseRecognitionResult[] dataArray = results.getRecognitionResults();
	for(BaseRecognitionResult baseResult : dataArray) {
		if(baseResult instanceof EUDLRecognitionResult) {
			EUDLRecognitionResult result = (EUDLRecognitionResult) baseResult;
			
	        // you can use getters of EUDLRecognitionResult class to 
	        // obtain scanned information
	        if(result.isValid() && !result.isEmpty()) {
	           String firstName = result.getFirstName();
	           String secondName = result.getSecondName();
	           String driverNumber = result.getDriverNumber();          		 
	        } else {
	        	// not all relevant data was scanned, ask user
	        	// to try again
	        }
		}
	}
}
```

Available getters are:

##### `boolean isValid()`
Returns `true` if scan result is valid, i.e. if all required elements were scanned with good confidence and can be used. If `false` is returned that indicates that some crucial data fields are missing. You should ask user to try scanning again. If you keep getting `false` (i.e. invalid data) for certain document, please report that as a bug to [help.microblink.com](http://help.microblink.com). Please include high resolution photographs of problematic documents.

##### `boolean isEmpty()`
Returns `true` if scan result is empty, i.e. nothing was scanned. All getters should return `null` for empty result.

##### `String getFirstName()`
Returns the first name of the Driver's Licence owner.

##### `String getLastName()`
Returns the last name of the Driver's Licence owner.

##### `String getDriverNumber()`
Returns the driver number.

##### `String getAddress()`
Returns the address of the Driver's Licence owner, if it exists.

##### `Date getDateOfBirth()`
Returns date of birth of the Driver's Licence owner.

##### `Date getDocumentIssueDate()`
Returns the issue date of the Driver's Licence.

##### `Date getDocumentExpiryDate()`
Returns the expiry date of the Driver's Licence.

##### `String getPlaceOfBirth()`
Returns the place of birth of Driver's Licence owner.

##### `String getDocumentIssuingAuthority()`
Returns document issuing authority.

##### `String getCountry()`
Returns the country where the Driver's License has been issued or null if country is unknown.

## <a name="myKad"></a> Scanning Malaysian MyKad ID documents

This section will discuss the setting up of Malaysian ID documents (MyKad) recognizer and obtaining results from it.

### Setting up MyKad recognizer

To activate MyKad recognizer, you need to create [MyKadRecognizerSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkid/malaysia/MyKadRecognizerSettings.html) and add it to `RecognizerSettings` array. You can use the following code snippet to perform that:

```java
private RecognizerSettings[] setupSettingsArray() {
	MyKadRecognizerSettings sett = new MyKadRecognizerSettings();
	
	// now add sett to recognizer settings array that is used to configure
	// recognition
	return new RecognizerSettings[] { sett };
}
```

You can also tweak MyKad recognition parameters with methods of [MyKadRecognizerSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkid/malaysia/MyKadRecognizerSettings.html).

##### `setShowFullDocument(boolean)`
Set this to `true` if you use [MetadataListener](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataListener.html) and you want to obtain image containing scanned document. The document image's orientation will be corrected. The reported ImageType will be [DEWARPED](https://blinkid.github.io/blinkid-android/com/microblink/image/ImageType.html#DEWARPED) and image name will be `"MyKad"`.  You will also need to enable [obtaining of dewarped images](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataSettings.ImageMetadataSettings.html#setDewarpedImageEnabled-boolean-) in [MetadataSettings](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataSettings.html). By default, this is turned off.

### Obtaining results from MyKad recognizer

MyKad recognizer produces [MyKadRecognitionResult](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkid/malaysia/MyKadRecognitionResult.html). You can use `instanceof` operator to check if element in results array is instance of `MyKadRecognitionResult ` class. See the following snippet for an example:

```java
@Override
public void onScanningDone(RecognitionResults results) {
	BaseRecognitionResult[] dataArray = results.getRecognitionResults();
	for(BaseRecognitionResult baseResult : dataArray) {
		if(baseResult instanceof MyKadRecognitionResult) {
			MyKadRecognitionResult result = (MyKadRecognitionResult) baseResult;
			
	        // you can use getters of MyKadRecognitionResult class to 
	        // obtain scanned information
	        if(result.isValid() && !result.isEmpty()) {
				String ownerFullName = result.getOwnerFullName();
				String nricNumber = result.getNRICNumber();
	        } else {
	        	// not all relevant data was scanned, ask user
	        	// to try again
	        }
		}
	}
}
```

Available getters are:

##### `boolean isValid()`
Returns `true` if scan result is valid, i.e. if all required elements were scanned with good confidence and can be used. If `false` is returned that indicates that some crucial data fields are missing. You should ask user to try scanning again. If you keep getting `false` (i.e. invalid data) for certain document, please report that as a bug to [help.microblink.com](http://help.microblink.com). Please include high resolution photographs of problematic documents.

##### `boolean isEmpty()`
Returns `true` if scan result is empty, i.e. nothing was scanned. All getters should return `null` for empty result.

##### `String getNRICNumber()`
Returns the National Registration Identity Card Number.

##### `String getOwnerSex()`
Returns the sex of the card holder. Possible values are:

- `M` for male holder
- `F` for female holder

##### `String getOwnerBirthDate()`
Returns the date of birth of card holder. The date format is `YYMMDD`.

##### `String getOwnerFullName()`
Returns the full name of the card holder.

##### `String getOwnerAddress()`
Returns the address of the card holder.

##### `String getOwnerReligion()`
Returns the religion of the card holder. Possible values are `ISLAM` and `null`.

## <a name="pdf417Recognizer"></a> Scanning PDF417 barcodes

This section discusses the settings for setting up PDF417 recognizer and explains how to obtain results from PDF417 recognizer.

### Setting up PDF417 recognizer

To activate PDF417 recognizer, you need to create a [Pdf417RecognizerSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkbarcode/pdf417/Pdf417RecognizerSettings.html) and add it to `RecognizerSettings` array. You can do this using following code snippet:

```java
private RecognizerSettings[] setupSettingsArray() {
	Pdf417RecognizerSettings sett = new Pdf417RecognizerSettings();
	// disable scanning of white barcodes on black background
	sett.setInverseScanning(false);
	// allow scanning of barcodes that have invalid checksum
	sett.setUncertainScanning(true);
	// disable scanning of barcodes that do not have quiet zone
	// as defined by the standard
	sett.setNullQuietZoneAllowed(false);

	// now add sett to recognizer settings array that is used to configure
	// recognition
	return new RecognizerSettings[] { sett };
}
```

As can be seen from example, you can tweak PDF417 recognition parameters with methods of `Pdf417RecognizerSettings`.

##### `setUncertainScanning(boolean)`
By setting this to `true`, you will enable scanning of non-standard elements, but there is no guarantee that all data will be read. This option is used when multiple rows are missing (e.g. not whole barcode is printed). Default is `false`.

##### `setNullQuietZoneAllowed(boolean)`
By setting this to `true`, you will allow scanning barcodes which don't have quiet zone surrounding it (e.g. text concatenated with barcode). This option can significantly increase recognition time. Default is `false`.

##### `setInverseScanning(boolean)`
By setting this to `true`, you will enable scanning of barcodes with inverse intensity values (i.e. white barcodes on dark background). This option can significantly increase recognition time. Default is `false`.

### Obtaining results from PDF417 recognizer
PDF417 recognizer produces [Pdf417ScanResult](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkbarcode/pdf417/Pdf417ScanResult.html). You can use `instanceof` operator to check if element in results array is instance of `Pdf417ScanResult` class. See the following snippet for an example:

```java
@Override
public void onScanningDone(RecognitionResults results) {
	BaseRecognitionResult[] dataArray = results.getRecognitionResults();
	for(BaseRecognitionResult baseResult : dataArray) {
		if(baseResult instanceof Pdf417ScanResult) {
			Pdf417ScanResult result = (Pdf417ScanResult) baseResult;
			
	        // getStringData getter will return the string version of barcode contents
			String barcodeData = result.getStringData();
			// isUncertain getter will tell you if scanned barcode is uncertain
			boolean uncertainData = result.isUncertain();
			// getRawData getter will return the raw data information object of barcode contents
			BarcodeDetailedData rawData = result.getRawData();
			// BarcodeDetailedData contains information about barcode's binary layout, if you
			// are only interested in raw bytes, you can obtain them with getAllData getter
			byte[] rawDataBuffer = rawData.getAllData();
		}
	}
}
```

As you can see from the example, obtaining data is rather simple. You just need to call several methods of the `Pdf417ScanResult` object:

##### `String getStringData()`
This method will return the string representation of barcode contents. Note that PDF417 barcode can contain binary data so sometimes it makes little sense to obtain only string representation of barcode data.

##### `boolean isUncertain()`
This method will return the boolean indicating if scanned barcode is uncertain. This can return `true` only if scanning of uncertain barcodes is allowed, as explained earlier.

##### `BarcodeDetailedData getRawData()`
This method will return the object that contains information about barcode's binary layout. You can see information about that object in [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/results/barcode/BarcodeDetailedData.html). However, if you only need to access byte array containing, you can call method `getAllData` of `BarcodeDetailedData` object.

##### `Quadrilateral getPositionOnImage()`
Returns the position of barcode on image. Note that returned coordinates are in image's coordinate system which is not related to view coordinate system used for UI.

## <a name="custom1DBarDecoder"></a> Scanning one dimensional barcodes with _BlinkID_'s implementation

This section discusses the settings for setting up 1D barcode recognizer that uses _BlinkID_'s implementation of scanning algorithms and explains how to obtain results from that recognizer. Henceforth, the 1D barcode recognizer that uses _BlinkID_'s implementation of scanning algorithms will be refered as "Bardecoder recognizer".

### Setting up Bardecoder recognizer

To activate Bardecoder recognizer, you need to create a [BarDecoderRecognizerSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkbarcode/bardecoder/BarDecoderRecognizerSettings.html) and add it to `RecognizerSettings` array. You can do this using following code snippet:

```java
private RecognizerSettings[] setupSettingsArray() {
	BarDecoderRecognizerSettings sett = new BarDecoderRecognizerSettings();
	// activate scanning of Code39 barcodes
	sett.setScanCode39(true);
	// activate scanning of Code128 barcodes
	sett.setScanCode128(true);
	// disable scanning of white barcodes on black background
	sett.setInverseScanning(false);
	// disable slower algorithm for low resolution barcodes
	sett.setTryHarder(false);

	// now add sett to recognizer settings array that is used to configure
	// recognition
	return new RecognizerSettings[] { sett };
}
```

As can be seen from example, you can tweak Bardecoder recognition parameters with methods of `BarDecoderRecognizerSettings`.

##### `setScanCode128(boolean)`
Method activates or deactivates the scanning of Code128 1D barcodes. Default (initial) value is `false`.

##### `setScanCode39(boolean)`
Method activates or deactivates the scanning of Code39 1D barcodes. Default (initial) value is `false`.

##### `setInverseScanning(boolean)`
By setting this to `true`, you will enable scanning of barcodes with inverse intensity values (i.e. white barcodes on dark background). This option can significantly increase recognition time. Default is `false`.

##### `setTryHarder(boolean)`
By setting this to `true`, you will enabled scanning of lower resolution barcodes at cost of additional processing time. This option can significantly increase recognition time. Default is `false`.

### Obtaining results from Bardecoder recognizer

Bardecoder recognizer produces [BarDecoderScanResult](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/barcode/blinkbardecoder/BarDecoderScanResult.html). You can use `instanceof` operator to check if element in results array is instance of `BarDecoderScanResult` class. See the following snippet for example:

```java
@Override
public void onScanningDone(RecognitionResults results) {
	BaseRecognitionResult[] dataArray = results.getRecognitionResults();
	for(BaseRecognitionResult baseResult : dataArray) {
		if(baseResult instanceof BarDecoderScanResult) {
			BarDecoderScanResult result = (BarDecoderScanResult) baseResult;
			
			// getBarcodeType getter will return a BarcodeType enum that will define
			// the type of the barcode scanned
			BarcodeType barType = result.getBarcodeType();
	        // getStringData getter will return the string version of barcode contents
			String barcodeData = result.getStringData();
			// getRawData getter will return the raw data information object of barcode contents
			BarcodeDetailedData rawData = result.getRawData();
			// BarcodeDetailedData contains information about barcode's binary layout, if you
			// are only interested in raw bytes, you can obtain them with getAllData getter
			byte[] rawDataBuffer = rawData.getAllData();
		}
	}
}
```

As you can see from the example, obtaining data is rather simple. You just need to call several methods of the `BarDecoderScanResult` object:

##### `String getStringData()`
This method will return the string representation of barcode contents. 

##### `BarcodeDetailedData getRawData()`
This method will return the object that contains information about barcode's binary layout. You can see information about that object in [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/results/barcode/BarcodeDetailedData.html). However, if you only need to access byte array containing, you can call method `getAllData` of `BarcodeDetailedData` object.

##### `String getExtendedStringData()`
This method will return the string representation of extended barcode contents. This is available only if barcode that supports extended encoding mode was scanned (e.g. code39).

##### `BarcodeDetailedData getExtendedRawData()`
This method will return the object that contains information about barcode's binary layout when decoded in extended mode. You can see information about that object in [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/results/barcode/BarcodeDetailedData.html). However, if you only need to access byte array containing, you can call method `getAllData` of `BarcodeDetailedData` object. This is available only if barcode that supports extended encoding mode was scanned (e.g. code39).

##### `getBarcodeType()`
This method will return a [BarcodeType](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkbarcode/BarcodeType.html) enum that defines the type of barcode scanned.

## <a name="zxing"></a> Scanning barcodes with ZXing implementation

This section discusses the settings for setting up barcode recognizer that use ZXing's implementation of scanning algorithms and explains how to obtain results from it. _BlinkID_ uses ZXing's [c++ port](https://github.com/zxing/zxing/tree/00f634024ceeee591f54e6984ea7dd666fab22ae/cpp) to support barcodes for which we still do not have our own scanning algorithms. Also, since ZXing's c++ port is not maintained anymore, we also provide updates and bugfixes to it inside our codebase.

### Setting up ZXing recognizer

To activate ZXing recognizer, you need to create [ZXingRecognizerSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkbarcode/zxing/ZXingRecognizerSettings.html) and add it to `RecognizerSettings` array. You can do this using the following code snippet:

```java
private RecognizerSettings[] setupSettingsArray() {
	ZXingRecognizerSettings sett=  new ZXingRecognizerSettings();
	// disable scanning of white barcodes on black background
	sett.setInverseScanning(false);
	// activate scanning of QR codes
	sett.setScanQRCode(true);

	// now add sett to recognizer settings array that is used to configure
	// recognition
	return new RecognizerSettings[] { sett };
}
```

As can be seen from example, you can tweak ZXing recognition parameters with methods of `ZXingRecognizerSettings`. Note that some barcodes, such as Code 39 are available for scanning with [_BlinkID_'s implementation](#custom1DBarDecoder). You can choose to use only one implementation or both (just put both settings objects into `RecognizerSettings` array). Using both implementations increases the chance of correct barcode recognition, but requires more processing time. Of course, we recommend using the _BlinkID_'s implementation for supported barcodes.

##### `setScanAztecCode(boolean)`
Method activates or deactivates the scanning of Aztec 2D barcodes. Default (initial) value is `false`.

##### `setScanCode128(boolean)`
Method activates or deactivates the scanning of Code128 1D barcodes. Default (initial) value is `false`.

##### `setScanCode39(boolean)`
Method activates or deactivates the scanning of Code39 1D barcodes. Default (initial) value is `false`.

##### `setScanDataMatrixCode(boolean)`
Method activates or deactivates the scanning of Data Matrix 2D barcodes. Default (initial) value is `false`.

##### `setScanEAN13Code(boolean)`
Method activates or deactivates the scanning of EAN 13 1D barcodes. Default (initial) value is `false`.

##### `setScanEAN8Code(boolean)`
Method activates or deactivates the scanning of EAN 8 1D barcodes. Default (initial) value is `false`.

##### `shouldScanITFCode(boolean)`
Method activates or deactivates the scanning of ITF 1D barcodes. Default (initial) value is `false`.

##### `setScanQRCode(boolean)`
Method activates or deactivates the scanning of QR 2D barcodes. Default (initial) value is `false`.

##### `setScanUPCACode(boolean)`
Method activates or deactivates the scanning of UPC A 1D barcodes. Default (initial) value is `false`.

##### `setScanUPCECode(boolean)`
Method activates or deactivates the scanning of UPC E 1D barcodes. Default (initial) value is `false`.

##### `setInverseScanning(boolean)`
By setting this to `true`, you will enable scanning of barcodes with inverse intensity values (i.e. white barcodes on dark background). This option can significantly increase recognition time. Default is `false`.

##### `setSlowThoroughScan(boolean)`
Use this method to enable slower, but more thorough scan procedure when scanning barcodes. By default, this option is turned on.

### Obtaining results from ZXing recognizer

ZXing recognizer produces [ZXingScanResult](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkbarcode/zxing/ZXingScanResult.html). You can use `instanceof` operator to check if element in results array is instance of `ZXingScanResult` class. See the following snippet for example:

```java
@Override
public void onScanningDone(RecognitionResults results) {
	BaseRecognitionResult[] dataArray = results.getRecognitionResults();
	for(BaseRecognitionResult baseResult : dataArray) {
		if(baseResult instanceof ZXingScanResult) {
			ZXingScanResult result = (ZXingScanResult) baseResult;
			
			// getBarcodeType getter will return a BarcodeType enum that will define
			// the type of the barcode scanned
			BarcodeType barType = result.getBarcodeType();
	        // getStringData getter will return the string version of barcode contents
			String barcodeData = result.getStringData();
		}
	}
}
```

As you can see from the example, obtaining data is rather simple. You just need to call several methods of the `ZXingScanResult` object:

##### `String getStringData()`
This method will return the string representation of barcode contents. 

##### `getBarcodeType()`
This method will return a [BarcodeType](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkbarcode/BarcodeType.html) enum that defines the type of barcode scanned.

## <a name="blinkOCR"></a> Scanning segments with BlinkOCR recognizer

This section discusses the setting up of BlinkOCR recognizer and obtaining results from it. You should also check the demo for example.

### Setting up BlinkOCR recognizer

BlinkOCR recognizer is consisted of one or more parsers that are grouped in parser groups. Each parser knows how to extract certain element from OCR result and also knows what are the best OCR engine options required to perform OCR on image. Parsers can be grouped in parser groups. Parser groups contain one or more parsers and are responsible for merging required OCR engine options of each parser in group and performing OCR only once and then letting each parser in group parse the data. Thus, you can make for own best tradeoff between speed and accuracy - putting each parser into its own group will give best accuracy, but will perform OCR of image for each parser which can consume a lot of processing time. On the other hand, putting all parsers into same group will perform only one OCR but with settings that are combined for all parsers in group, thus possibly reducing parsing quality.

Let's see this on example: assume we have two parsers at our disposal: `AmountParser` and `EMailParser`. `AmountParser` knows how to extract amount's from OCR result and requires from OCR only to recognise digits, periods and commas and ignore letters. On the other hand, `EMailParser` knows how to extract e-mails from OCR result and requires from OCR to recognise letters, digits, '@' characters and periods, but not commas. 

If we put both `AmountParser` and `EMailParser` into same parser group, the merged OCR engine settings will require recognition of all letters, all digits, '@' character, both period and comma. Such OCR result will contain all characters for `EMailParser` to properly parse e-mail, but might confuse `AmountParser` if OCR misclassifies some characters into digits.

If we put `AmountParser` in one parser group and `EMailParser` in another parser group, OCR will be performed for each parser group independently, thus preventing the `AmountParser` confusion, but two OCR passes of image will be performed, which can have a performance impact.

So to sum it up, BlinkOCR recognizer performs OCR of image for each available parser group and then runs all parsers in that group on obtained OCR result and saves parsed data. 

By definition, each parser results with string that represents a parsed data. The parsed string is stored under parser's name which has to be unique within parser group. So, when defining settings for BlinkOCR recognizer, when adding parsers, you need to provide a name for the parser (you will use that name for obtaining result later) and optionally provide a name for the parser group in which parser will be put into.

To activate BlinkOCR recognizer, you need to create [BlinkOCRRecognizerSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkocr/BlinkOCRRecognizerSettings.html), add some parsers to it and add it to `RecognizerSettings` array. You can use the following code snippet to perform that:

```java
private RecognizerSettings[] setupSettingsArray() {
	BlinkOCRRecognizerSettings sett = new BlinkOCRRecognizerSettings();
	
	// add amount parser to default parser group
	sett.addParser("myAmountParser", new AmountParserSettings());
	
	// now add sett to recognizer settings array that is used to configure
	// recognition
	return new RecognizerSettings[] { sett };
}
```

The following is a list of available parsers:


- Amount parser - represented by [AmountParserSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkocr/parser/generic/AmountParserSettings.html)
	- used for parsing amounts from OCR result
- IBAN parser - represented by [IbanParserSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkocr/parser/generic/IbanParserSettings.html)
	- used for parsing International Bank Account Numbers (IBANs) from OCR result
- E-mail parser - represented by [EMailParserSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkocr/parser/generic/EMailParserSettings.html)
	- used for parsing e-mail addresses
- Date parser - represented by [DateParserSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkocr/parser/generic/DateParserSettings.html)
	- used for parsing dates in various formats
- Raw parser - represented by [RawParserSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkocr/parser/generic/RawParserSettings.html)
	- used for obtaining raw OCR result

### Obtaining results from BlinkOCR recognizer

BlinkOCR recognizer produces [BlinkOCRRecognitionResult](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/blinkocr/BlinkOCRRecognitionResult.html). You can use `instanceof` operator to check if element in results array is instance of `BlinkOCRRecognitionResult` class. See the following snippet for an example:

```java
@Override
public void onScanningDone(RecognitionResults results) {
	BaseRecognitionResult[] dataArray = results.getRecognitionResults();
	for(BaseRecognitionResult baseResult : dataArray) {
		if(baseResult instanceof BlinkOCRRecognitionResult) {
			BlinkOCRRecognitionResult result = (BlinkOCRRecognitionResult) baseResult;
			
	        // you can use getters of BlinkOCRRecognitionResult class to 
	        // obtain scanned information
	        if(result.isValid() && !result.isEmpty()) {
	        	 // use the parser name provided to BlinkOCRRecognizerSettings to
	        	 // obtain parsed result provided by given parser
	        	 // obtain result of "myAmountParser" in default parsing group
		        String parsedAmount = result.getParsedResult("myAmountParser");
		        // note that parsed result can be null or empty even if result
		        // is marked as non-empty and valid
		        if(parsedAmount != null && !parsedAmount.isEmpty()) {
		        	// do whatever you want with parsed result
		        }
		        // obtain OCR result for default parsing group
		        // OCR result exists if result is valid and non-empty
		        OcrResult ocrResult = result.getOcrResult();
	        } else {
	        	// not all relevant data was scanned, ask user
	        	// to try again
	        }
		}
	}
}
```

Available getters are:

##### `boolean isValid()`
Returns `true` if scan result contains at least one OCR result in one parsing group.

##### `boolean isEmpty()`
Returns `true` if scan result is empty, i.e. nothing was scanned. All getters should return `null` for empty result.

##### `String getParsedResult(String parserName)`
Returns the parsed result provided by parser with name `parserName` added to default parser group. If parser with name `parserName` does not exists in default parser group, returns `null`. If parser exists, but has failed to parse any data, returns empty string.

##### `String getParsedResult(String parserGroupName, String parserName)`
Returns the parsed result provided by parser with name `parserName` added to parser group named `parserGroupName`. If parser with name `parserName` does not exists in parser group with name `parserGroupName` or if parser group does not exists, returns `null`. If parser exists, but has failed to parse any data, returns empty string.

##### `OcrResult getOcrResult()`
Returns the [OCR result](https://blinkid.github.io/blinkid-android/com/microblink/results/ocr/OcrResult.html) structure for default parser group.

##### `OcrResult getOcrResult(String parserGroupName)`
Returns the [OCR result](https://blinkid.github.io/blinkid-android/com/microblink/results/ocr/OcrResult.html) structure for parser group named `parserGroupName`.

## <a name="detectorRecognizer"></a> Performing detection of various documents

This section will discuss how to set up a special kind of recognizer called `DetectorRecognizer` whose only purpose is to perform a detection of a document and return position of the detected document on the image or video frame.

### Setting up Detector Recognizer

To activate Detector Recognizer, you need to create [DetectorRecognizerSettings](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/detector/DetectorRecognizerSettings.html) and add it to `RecognizerSettings` array. When creating `DetectorRecognizerSettings`, you need to initialize it with already prepared [DetectorSettings](https://blinkid.github.io/blinkid-android/com/microblink/detectors/DetectorSettings.html). Check [this chapter](#detectionSettingsAndResults) for more information about available detectors and how to configure them.

You can use the following code snippet to create `DetectorRecognizerSettings` and add it to `RecognizerSettings` array:

```java
private RecognizerSettings[] setupSettingsArray() {
	DetectorRecognizerSettings sett = new DetectorRecognizerSettings(setupDetector());
	
	// now add sett to recognizer settings array that is used to configure
	// recognition
	return new RecognizerSettings[] { sett };
}
```

Please note that snippet above assumes existance of method `setupDetector()` which returns a fully configured `DetectorSettings` as explained in chapter [Detection settings and results](#detectionSettingsAndResults).

### Obtaining results from Detector Recognizer

Detector Recognizer produces [DetectorRecognitionResult](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/detector/DetectorRecognitionResult.html). You can use `instanceof` operator to check if element in results array is instance of `DetectorRecognitionResult` class. See the following snippet for an example:

```java
@Override
public void onScanningDone(RecognitionResults results) {
	BaseRecognitionResult[] dataArray = results.getRecognitionResults();
	for(BaseRecognitionResult baseResult : dataArray) {
		if(baseResult instanceof DetectorRecognitionResult) {
			DetectorRecognitionResult result = (DetectorRecognitionResult) baseResult;
			
	        // you can use getters of DetectorRecognitionResult class to 
	        // obtain detection result
	        if(result.isValid() && !result.isEmpty()) {
				DetectorResult detection = result.getDetectorResult();
				// the type of DetectorResults depends on type of configured
				// detector when setting up the DetectorRecognizer
	        } else {
	        	// not all relevant data was scanned, ask user
	        	// to try again
	        }
		}
	}
}
```

Available getters are:

##### `boolean isValid()`
Returns `true` if detection result is valid, i.e. if all required elements were detected with good confidence and can be used. If `false` is returned that indicates that some crucial data is missing. You should ask user to try scanning again. If you keep getting `false` (i.e. invalid data) for certain document, please report that as a bug to [help.microblink.com](http://help.microblink.com). Please include high resolution photographs of problematic documents.

##### `boolean isEmpty()`
Returns `true` if scan result is empty, i.e. nothing was scanned. All getters should return `null` for empty result.

##### `DetectorResult getDetectorResult()`
Returns the [DetectorResult](https://blinkid.github.io/blinkid-android/com/microblink/detectors/DetectorResult.html) generated by detector that was used to configure Detector Recognizer.

# <a name="detectionSettingsAndResults"></a> Detection settings and results

This chapter will discuss various detection settings used to configure different detectors that some recognizers can use to perform object detection prior performing further recognition of detected object's contents.

Each detector has its own version of `DetectorSettings` which derives [DetectorSettings](https://blinkid.github.io/blinkid-android/com/microblink/detectors/DetectorSettings.html) class. Besides that, each detector also produces its own version of `DetectorResult` which derives [DetectorResult](https://blinkid.github.io/blinkid-android/com/microblink/detectors/DetectorResult.html) class. Appropriate recognizers, such as [Detector Recognizer](#detectorRecognizer), require `DetectorSettings` for their initialization and provide `DetectorResult` in their recognition result.

#### [DetectorSettings](https://blinkid.github.io/blinkid-android/com/microblink/detectors/DetectorSettings.html)

Abstract `DetectorSettings` contains following setters that are inherited by all derived settings objects:

##### `setDisplayDetectedLocation(boolean)`

Defines whether detection location will be delivered as detection metadata to [MetadataListener](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataListener.html). In order for this to work, you need to set `MetadataListener` to [RecognizerView](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html}) and you need to allow receiving of detection metadata in [MetadataSettings](https://blinkid.github.io/blinkid-android/com/microblink/metadata/MetadataSettings.html#setDetectionMetadataAllowed(boolean)).

#### [DetectorResult](https://blinkid.github.io/blinkid-android/com/microblink/detectors/DetectorResult.html)

Abstract `DetectorResult` contains following getters that are inherited by all derived result objects:

##### `DetectionCode getDetectionCode()`

Returns the [Detection code](https://blinkid.github.io/blinkid-android/com/microblink/detectors/DetectorResult.DetectionCode.html) which indicates the status of detection (failed, fallback or success).

## <a name="mrtdDetector"></a> Detection of documents with Machine Readable Zone

This section discusses how to use MRTD detector to perform detection of Machine Readable Zones used in various Machine Readable Travel Documents (MRTDs - ID cards and passports). This detector is used internally in [Machine Readable Travel Documents recognizer](#mrtd) to perform detection of Machine Readable Zone (MRZ) prior performing OCR and data extraction.

### Setting up MRTD detector

To use MRTD detector, you need to create [MRTDDetectorSettings](https://blinkid.github.io/blinkid-android/com/microblink/detectors/quad/mrtd/MRTDDetectorSettings.html) and give it to appropriate recognizer. You can use following snippet to perform that:

```java
private DetectorSettings setupDetector() {
	MRTDDetectorSettings settings = new MRTDDetectorSettings();

	// with following setter you can control whether you want to detect
	// machine readable zone only or full travel document
	settings.setDetectFullDocument(false);
	
	return settings;
}
```

As you can see from the snippet, `MRTDDetectorSettings` can be tweaked with following methods:

##### `setDetectFullDocument(boolean)`

This method allows you to enable detection of full Machine Readable Travel Documents. The position of the document is calculated from location of detected Machine Readable Zone. If this is set to `false` (default), then only location of Machine Readable Zone will be returned.

### Obtaining MRTD detection result

MRTD detector produces [MRTDDetectorResult](https://blinkid.github.io/blinkid-android/com/microblink/detectors/quad/mrtd/MRTDDetectorResult.html). You can use `instanceof` operator to check if obtained `DetectorSettings` is instance of `MRTDDetectorResult` class. See the following snippet for an example:

```java
public void handleDetectorResult(DetectorResult detResult) {
	if (detResult instanceof MRTDDetectorResult) {
		MRTDDetectorResult result = (MRTDDetectorResult) detResult;
		Quadrilateral pos = result.getDetectionLocation();
	}
}
```

The available getters of `MRTDDetectorResults` are as follows:

##### `Quadrilateral getDetectionLocation()`

Returns the [Quadrilateral](https://blinkid.github.io/blinkid-android/com/microblink/geometry/Quadrilateral.html) containing the position of detection. If position is empty, all four Quadrilateral points will have coordinates `(0,0)`.

##### `int[] getElementsCountPerLine()`

Returns the array of integers defining the number of char-like elements per each line of detected machine readable zone.

##### `MRTDDetectionCode getMRTDDetectionCode()`

Returns the [MRTDDetectionCode enum](https://blinkid.github.io/blinkid-android/com/microblink/detectors/quad/mrtd/MRTDDetectorResult.MRTDDetectionCode.html) defining the type of detection or `null` if nothing was detected.

## <a name="documentDetector"></a> Detection of documents with Document Detector

This section discusses how to use Document detector to perform detection of documents of certain aspect ratios. This detector can be used to detect cards, cheques, A4-sized documents, receipts and much more.

### Setting up of Document Detector

To use Document Detector, you need to create [DocumentDetectorSettings](https://blinkid.github.io/blinkid-android/com/microblink/detectors/document/DocumentDetectorSettings.html). When creating `DocumentDetectorSettings` you need to specify at least one [DocumentSpecification](https://blinkid.github.io/blinkid-android/com/microblink/detectors/document/DocumentSpecification.html) which defines how specific document should be detected. `DocumentSpecification` can be created directly or from [preset](https://blinkid.github.io/blinkid-android/com/microblink/detectors/document/DocumentSpecification.html#createFromPreset(com.microblink.detectors.document.DocumentSpecificationPreset)) (recommended). Please refer to [javadoc](https://blinkid.github.io/blinkid-android/com/microblink/detectors/document/DocumentSpecification.html) for more information on document specification.

In the following snippet, we will show how to setup `DocumentDetectorSettings` to perform detection of credit cards:

```java
private DetectorSettings setupDetector() {
	DocumentSpecification cardDoc = DocumentSpecification.createFromPreset(DocumentSpecificationPreset.DOCUMENT_SPECIFICATION_PRESET_ID1_CARD);

	DocumentDetectorSettings settings = new DocumentDetectorSettings(new DocumentSpecification[] {cardDoc});

	// require at least 3 subsequent close detections (in 3 subsequent 
	// video frames) to treat detection as 'stable'
	settings.setNumStableDetectionsThreshold(3)
	
	return settings;
}
```

As you can see from the snippet, `DocumentDetectorSettings` can be tweaked with following methods:

##### `setNumStableDetectionsThreshold(int)`

Sets the number of subsequent close detections must occur before treating document detection as stable. Default is 1. Larger number guarantees more robust document detection at price of slower performance.

##### `setDocumentSpecifications(DocumentSpecification[])`

Sets the array of document specifications that define documents that can be detected. See javadoc for [DocumentSpecification](https://blinkid.github.io/blinkid-android/com/microblink/detectors/document/DocumentSpecification.html) for more information about document specifications.

### Obtaining document detection result

Document detector produces [DocumentDetectorResult](https://blinkid.github.io/blinkid-android/com/microblink/detectors/document/DocumentDetectorResult.html). You can use `instanceof` operator to check if obtained `DetectorSettings` is instance of `DocumentDetectorResult` class. See the following snippet for an example:

```java
public void handleDetectorResult(DetectorResult detResult) {
	if (detResult instanceof DocumentDetectorResult) {
		DocumentDetectorResult result = (DocumentDetectorResult) detResult;
		Quadrilateral pos = result.getDetectionLocation();
	}
}
```

Available getters of `DocumentDetectorResult` are as follows:

##### `Quadrilateral getDetectionLocation()`

Returns the [Quadrilateral](https://blinkid.github.io/blinkid-android/com/microblink/geometry/Quadrilateral.html) containing the position of detection. If position is empty, all four Quadrilateral points will have coordinates `(0,0)`.

##### `double getAspectRatio()`

Returns the aspect ratio of detected document. This will be equal to aspect ratio of one of `DocumentSpecification` objects given to `DocumentDetectorSettings`.

##### `ScreenOrientation getScreenOrientation()`

Returns the orientation of the screen that was active at the moment document was detected.

## <a name="multiDetector"></a> Combining detectors with MultiDetector

This section discusses how to use Multi detector to combine multiple different detectors.

### Setting up Multi Detector

To use Multi Detector, you need to create [MultiDetectorSettings](https://blinkid.github.io/blinkid-android/com/microblink/detectors/multi/MultiDetectorSettings.html). When creating `MultiDetectorSettings` you need to specify at least one other `DetectorSettings` that will be wrapped with Multi Detector. In the following snippet, we demonstrate how to create a Multi detector that wraps both [MRTDDetector](#mrtdDetector) and [Document Detector](#documentDetector) and has ability to detect either Machine Readable Zone or card document:

```java
private DetectorSettings setupDetector() {
	DocumentSpecification cardDoc = DocumentSpecification.createFromPreset(DocumentSpecificationPreset.DOCUMENT_SPECIFICATION_PRESET_ID1_CARD);
	DocumentDetectorSettings dds = new DocumentDetectorSettings(new DocumentSpecification[] {cardDoc});

	MRTDDetectorSettings mrtds = new MRTDDetectorSettings(100);

    MultiDetectorSettings mds = new MultiDetectorSettings(new DetectorSettings[] {dds, mrtds});
	
	return mds;
}
```

### Obtaining results from Multi Detector

Multi detector produces [MultiDetectorResult](https://blinkid.github.io/blinkid-android/com/microblink/detectors/multi/MultiDetectorResult.html). You can use `instanceof` operator to check if obtained `DetectorSettings` is instance of `MultiDetectorResult` class. See the following snippet for an example:

```java
public void handleDetectorResult(DetectorResult detResult) {
	if (detResult instanceof MultiDetectorResult) {
		MultiDetectorResult result = (MultiDetectorResult) detResult;
		DetectorResults[] results = result.getDetectionResults();
	}
}
```

As you can see from the snippet, `MultiDetectorResult` contains one getter:

##### `getDetectionResults()`

Returns the array of detection results contained within. You can iterate over the array to inspect each detection result's contents.

# <a name="translation"></a> Translation and localization

`BlinkID` can be localized to any language. If you are using `RecognizerView` in your custom scan activity, you should handle localization as in any other Android app - `RecognizerView` does not use strings nor drawables, it only uses assets from `assets/microblink` folder. Those assets must not be touched as they are required for recognition to work correctly.

However, if you use our builtin `ScanCard` activity, it will use resources packed with library project to display strings and images on top of camera view. We have already prepared string in several languages which you can use out of the box. You can also [modify those strings](#stringChanging), or you can [add your own language](#addLanguage).

To use a language, you have to enable it from the code:

* To enable usage of predefined language you should call method `LanguageUtils.setLanguage(language, context)`. For example, you can set language like this:

	```java
	// define BlinkID language
	LanguageUtils.setLanguage(Language.Croatian, this);
	```
		
* To enable usage of language that is not available in predefined language enum (for example, if you added your own language), you should call method `LanguageUtils.setLanguageAndCountry(language, country, context)`. For example, you can set language like this:
	
	```java
	// define BlinkID language
	LanguageUtils.setLanguageAndCountry("hr", "", this);
	```

### <a name="addLanguage"></a> Adding new language

_BlinkID_ can easily be translated to other languages. The `res` folder in `LibRecognizer.aar` archive has folder `values` which contains `strings.xml` - this file contains english strings. In order to make e.g. croatian translation, create a folder `values-hr` in your project and put the copy of `strings.xml` inside it (you might need to extract `LibRecognizer.aar` archive to get access to those files). Then, open that file and change the english version strings into croatian version. 

### <a name="stringChanging"></a> Changing strings in the existing language
	
To modify an existing string, the best approach would be to:

1. choose a language which you want to modify. For example Croatia ('hr').
2. find strings.xml in `LibRecognizer.aar` archive folder `res/values-hr`
3. choose a string key which you want to change. For example, ```<string name="PhotoPayHelp">Help</string>```
4. in your project create a file `strings.xml` in the folder `res/values-hr`, if it doesn't already exist
5. create an entry in the file with the value for the string which you want. For example ```<string name="PhotoPayHelp">Pomoć</string>```
6. repeat for all the string you wish to change

# <a name="archConsider"></a> Processor architecture considerations

_BlinkID_ is distributed with both ARMv7, ARM64, x86 and x86_64 native library binaries.

ARMv7 architecture gives the ability to take advantage of hardware accelerated floating point operations and SIMD processing with [NEON](http://www.arm.com/products/processors/technologies/neon.php). This gives _BlinkID_ a huge performance boost on devices that have ARMv7 processors. Most new devices (all since 2012.) have ARMv7 processor so it makes little sense not to take advantage of performance boosts that those processors can give. Also note that some devices with ARMv7 processors do not support NEON instruction sets. Most popular are those based on [NVIDIA Tegra 2](https://en.wikipedia.org/wiki/Tegra#Tegra_2) fall into this category. Since these devices are old by today's standard, _BlinkID_ does not support them.

ARM64 is the new processor architecture that some new high end devices use. ARM64 processors are very powerful and also have the possibility to take advantage of new NEON64 SIMD instruction set to quickly process multiple pixels with single instruction.

x86 architecture gives the ability to obtain native speed on x86 android devices, like [Prestigio 5430](http://www.gsmarena.com/prestigio_multiphone_5430_duo-5721.php). Without that, _BlinkID_ will not work on such devices, or it will be run on top of ARM emulator that is shipped with device - this will give a huge performance penalty.

x86_64 architecture gives better performance than x86 on devices that use 64-bit Intel Atom processor.

However, there are some issues to be considered:

- ARMv7 build of native library cannot be run on devices that do not have ARMv7 compatible processor (list of those old devices can be found [here](http://www.getawesomeinstantly.com/list-of-armv5-armv6-and-armv5-devices/))
- ARMv7 processors does not understand x86 instruction set
- x86 processors do not understand neither ARM64 nor ARMv7 instruction sets
- however, some x86 android devices ship with the builtin [ARM emulator](http://commonsware.com/blog/2013/11/21/libhoudini-what-it-means-for-developers.html) - such devices are able to run ARM binaries but with performance penalty. There is also a risk that builtin ARM emulator will not understand some specific ARM instruction and will crash.
- ARM64 processors understand ARMv7 instruction set, but ARMv7 processors does not understand ARM64 instructions
- if ARM64 processor executes ARMv7 code, it does not take advantage of modern NEON64 SIMD operations and does not take advantage of 64-bit registers it has - it runs in emulation mode
- x86_64 processors understand x86 instruction set, but x86 processors do not understand x86_64 instruction set
- if x86_64 processor executes x86 code, it does not take advantage of 64-bit registers and use two instructions instead of one for 64-bit operations

`LibRecognizer.aar` archive contains ARMv7, ARM64, x86 and x86_64 builds of native library. By default, when you integrate _BlinkID_ into your app, your app will contain native builds for all processor architectures. Thus, _BlinkID_ will work on ARMv7, ARM64, x86 and x86_64 devices and will use ARMv7 features on ARMv7 devices and ARM64 features on ARM64 devices. However, the size of your application will be rather large.

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

For more information about creating APK splits with gradle, check [this article from Google](https://sites.google.com/a/android.com/tools/tech-docs/new-build-system/user-guide/apk-splits#TOC-ABIs-Splits).

After generating multiple APK's, you need to upload them to Google Play. For tutorial and rules about uploading multiple APK's to Google Play, please read the [official Google article about multiple APKs](https://developer.android.com/google/play/publishing/multiple-apks.html).

However, if you are using Eclipse, things get really complicated. Eclipse does not support build flavors and you will either need to remove support for some processors or create three different library projects from `LibRecognizer.aar` - each one for specific processor architecture. In the next section, we will discuss how to remove processor architecture support from Eclipse library project.

### Removing processor architecture support in Eclipse

This section assumes that you have set up and prepared your Eclipse project from `LibRecognizer.aar` as described in chapter [Eclipse integration instructions](#eclipseIntegration).

Native libraryies in eclipse library project are located in subfolder `libs`:

- `libs/armeabi-v7a` contains native libraries for ARMv7 processor arhitecture
- `libs/x86` contains native libraries for x86 processor architecture
- `libs/arm64-v8a` contains native libraries for ARM64 processor architecture
- `libs/x86_64` contains native libraries for x86_64 processor architecture

To remove a support for processor architecture, you should simply delete appropriate folder inside Eclipse library project:

- to remove ARMv7 support, delete folder `libs/armeabi-v7a`
- to remove x86 support, delete folder `libs/x86`
- to remove ARM64 support, delete folder `libs/arm64-v8a`
- to remove x86_64 support, delete folder `libs/x86_64`

### Consequences of removing processor architecture

However, removing a processor architecture has some consequences:

- by removing ARMv7 support _BlinkID_ will not work on devices that have ARMv7 processors. 
- by removing ARM64 support, _BlinkID_ will not use ARM64 features on ARM64 device
- by removing x86 support, _BlinkID_ will not work on devices that have x86 processor, except in situations when devices have ARM emulator - in that case, _BlinkID_ will work, but will be slow
- by removing x86_64 support, _BlinkID_ will not use 64-bit optimizations on x86_64 processor, but if x86 support is not removed, _BlinkID_ should work

Our recommendation is to include all architectures into your app - it will work on all devices and will provide best user experience. However, if you really need to reduce the size of your app, we recommend releasing separate version of your app for each processor architecture.

## <a name="combineNativeLibraries"></a> Combining _BlinkID_ with other native libraries

If you are combining _BlinkID_ library with some other libraries that contain native code into your application, make sure you match the architectures of all native libraries. For example, if third party library has got only ARMv7 and x86 versions, you must use exactly ARMv7 and x86 versions of _BlinkID_ with that library, but not ARM64. Using these architectures will crash your app in initialization step because JVM will try to load all its native dependencies in same preferred architecture and will fail with `UnsatisfiedLinkError`.

# <a name="troubleshoot"></a> Troubleshooting

## <a name="integrationTroubleshoot"></a> Integration problems

In case of problems with integration of the SDK, first make sure that you have tried integrating it into Android Studio by following [integration instructions](#quickIntegration). Althought we do provide [Eclipse ADT integration](#eclipseIntegration) integration instructions, we officialy do not support Eclipse ADT anymore. Also, for any other IDEs unfortunately you are on your own.

If you have followed [Android Studio integration instructions](#quickIntegration) and are still having integration problems, please contact us at [help.microblink.com](http://help.microblink.com).

## <a name="sdkTroubleshoot"></a> SDK problems

In case of problems with using the SDK, you should do as follows:

### Licencing problems

If you are getting "invalid licence key" error or having other licence-related problems (e.g. some feature is not enabled that should be or there is a watermark on top of camera), first check the ADB logcat. All licence-related problems are logged to error log so it is easy to determine what went wrong.

When you have determine what is the licence-relate problem or you simply do not understand the log, you should contact us [help.microblink.com](http://help.microblink.com). When contacting us, please make sure you provide following information:

* exact package name of your app (from your `AndroidManifest.xml` and/or your `build.gradle` file)
* licence key that is causing problems
* please stress out that you are reporting problem related to Android version of _BlinkID_ SDK
* if unsure about the problem, you should also provide excerpt from ADB logcat containing licence error

### Other problems

If you are having problems with scanning certain items, undesired behaviour on specific device(s), crashes inside _BlinkID_ or anything unmentioned, please do as follows:

* enable logging to get the ability to see what is library doing. To enable logging, put this line in your application:

	```java
	com.microblink.util.Log.setLogLevel(com.microblink.util.Log.LogLevel.LOG_VERBOSE);
	```

	After this line, library will display as much information about its work as possible. Please save the entire log of scanning session to a file that you will send to us. It is important to send the entire log, not just the part where crash occured, because crashes are sometimes caused by unexpected behaviour in the early stage of the library initialization.
	
* Contact us at [help.microblink.com](http://help.microblink.com) describing your problem and provide following information:
	* log file obtained in previous step
	* high resolution scan/photo of the item that you are trying to scan
	* information about device that you are using - we need exact model name of the device. You can obtain that information with [this app](https://play.google.com/store/apps/details?id=com.jphilli85.deviceinfo&hl=en)
	* please stress out that you are reporting problem related to Android version of _BlinkID_ SDK


# <a name="info"></a> Additional info
Complete API reference can be found in [Javadoc](https://blinkid.github.io/blinkid-android/index.html). 

For any other questions, feel free to contact us at [help.microblink.com](http://help.microblink.com).


