# _BlinkID_ SDK for Android

_BlinkID_ SDK for Android is SDK that enables you to perform scans of various ID cards in your app. You can simply integrate the SDK into your app by following the instructions below and your app will be able to benefit the scanning feature for following ID card standards:

* [Passports and IDs that contain Machine Readable Zone](https://en.wikipedia.org/wiki/Machine-readable_passport)
* [United States' Driver's License barcodes](https://en.wikipedia.org/wiki/Driver%27s_license_in_the_United_States)
* [United Kingdom's Driver's Licence's front side](https://en.wikipedia.org/wiki/Driving_licence_in_the_United_Kingdom)

Using _BlinkID_ in your app requires a valid license key. You can obtain a trial license key by registering to [Microblink dashboard](https://microblink.com/login). After registering, you will be able to generate a license key for your app. License key is bound to [package name](http://tools.android.com/tech-docs/new-build-system/applicationid-vs-packagename) of your app, so please make sure you enter the correct package name when asked.

See below for more information about how to integrate _BlinkID_ SDK into your app.

# Table of contents

* [Android _BlinkID_ integration instructions](#intro)
* [Quick Start](#quickStart)
  * [Quick start with demo app](#quickDemo)
  * [Quick integration of _BlinkID_ into your app](#quickIntegration)
  * [Eclipse integration instructions](#eclipseIntegration)
  * [How to integrate _BlinkID_ into your project using Maven](#mavenIntegration)
  * [_BlinkID's_ dependencies](#dependencies)
  * [Performing your first scan](#quickScan)
* [Advanced _BlinkID_ integration instructions](#advancedIntegration)
  * [Checking if _BlinkID_ is supported](#supportCheck)
  * [Customization of `ScanCard` activity](#scanActivityCustomization)
  * [Embedding `RecognizerView` into custom scan activity](#recognizerView)
  * [`RecognizerView` reference](#recognizerViewReference)
  * [Using direct API for recognition of Android Bitmaps](#directAPI)
* [Recognition settings and results](#recognitionSettingsAndResults)
  * [Generic settings](#genericSettings)
  * [Scanning machine-readable travel documents](#mrtd)
  * [Scanning US Driver's licence barcodes](#usdl)
  * [Scanning United Kingdom's driver's licences](#ukdl)
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

 - BlinkIDDemo module demonstrates quick and simple integration of _BlinkID_ library
 - BlinkIDDemoCustomUI demonstrates advanced integration within custom scan activity
 - BlinkIDDirectApiDemo module demonstrates integration of _BlinkID_ library without camera management
 
_BlinkID_ is supported on Android SDK version 10 (Android 2.3) or later.


The library contains one activity: `ScanCard`. It is responsible for camera control and recognition. If you create your own scanning UI, you will need to embed `RecognizerView` into your activity and pass activity's lifecycle events to it and it will control the camera and recognition process.

# <a name="quickStart"></a> Quick Start

## <a name="quickDemo"></a> Quick start with demo app

1. Open Android Studio.
2. In Quick Start dialog choose _Import project (Eclipse ADT, Gradle, etc.)_.
3. In File dialog select _BlinkIDDemo_ folder.
4. Wait for project to load. If Android studio asks you to reload project on startup, select `Yes`.

## <a name="quickIntegration"></a> Quick integration of _BlinkID_ into your app

1. In Android Studio menu, click _File_, select _New_ and then select _Module_.
2. In new window, select _Import .JAR or .AAR Package_, and click _Next_.
3. In _File name_ field, enter the path to _LibRecognizer.aar_ and click _Finish_.
4. In your app's `build.gradle`, add dependency to `LibRecognizer`:

	```
	dependencies {
   		compile project(':LibRecognizer')
	}
	```
5. If you plan to use ProGuard, add following lines to your `proguard-rules.pro`:
	
	```
	-keep class com.microblink.** { *; }
	-keepclassmembers class com.microblink.** {
		*;
	}
	-dontwarn android.hardware.**
	-dontwarn android.support.v4.**
	```
6. Add _BlinkID's_ dependencies. See [_BlinkID's_ dependencies](#dependencies) section for more information.
	
## <a name="eclipseIntegration"></a> Eclipse integration instructions

We do not provide Eclipse integration demo apps. We encourage you to use Android Studio. We also do not test integrating _BlinkID_ with Eclipse. If you are having problems with _BlinkID_, make sure you have tried integrating it with Android Studio prior contacting us.

However, if you still want to use Eclipse, you will need to convert AAR archive to Eclipse library project format. You can do this by doing the following:

1. In Eclipse, create a new _Android library project_ in your workspace.
2. Clear the `src` and `res` folders.
3. Unzip the `LibRecognizer.aar` file. You can rename it to zip and then unzip it or use any tool.
4. Copy the `classes.jar` to `libs` folder of your Eclipse library project. If `libs` folder does not exist, create it.
5. Copy `android-support-v4.jar` to `libs` folder of your Eclipse library project. You can find `android-support-v4.jar` in `/path/to/your/android/SDK/extras/android/support/v4/android-support-v4.jar`.
6. Copy the contents of `jni` folder to `libs` folder of your Eclipse library project.
7. Replace the `res` folder on library project with the `res` folder of the `LibRecognizer.aar` file.

You’ve already created the project that contains almost everything you need. Now let’s see how to configure your project to reference this library project.

1. In the project you want to use the library (henceforth, "target project") add the library project as a dependency
2. Open the `AndroidManifest.xml` file inside `LibRecognizer.aar` file and make sure to copy all permissions, features and activities to the `AndroidManifest.xml` file of the target project.
3. Clean and Rebuild your target project
4. Add _BlinkID's_ dependencies. See [_BlinkID's_ dependencies](#dependencies) section for more information.

## <a name="mavenIntegration"></a> How to integrate _BlinkID_ into your project using Maven

Maven repository for _BlinkID_ SDK is: [http://maven.microblink.com](http://maven.microblink.com).

### Using gradle
In your build.gradle you first need to add _BlinkID_ maven repository to repositories list:

```
repositories {
	maven { url 'http://maven.microblink.com' }
}
```

After that, you just need to add _BlinkID_ as a dependency to your application:

```
dependencies {
    compile 'com.microblink:blinkid:1.6.0'
}
```

Do not forget to add _BlinkID's_ dependencies to your app's dependencies. To see what are dependencies of _BlinkID_, check section [_BlinkID's_ dependencies](#dependencies).

### Using android-maven-plugin

Open your pom.xml file and add these directives as appropriate:

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
		  <version>1.6.0</version>
  	</dependency>
<dependencies>
```

Maven dependency requires android-maven-plugin version 4.0.0 (AAR support is required).

Do not forget to add _BlinkID's_ dependencies to your app's dependencies. To see what are dependencies of _BlinkID_, check section [_BlinkID's_ dependencies](#dependencies).

## <a name="dependencies"></a> _BlinkID's_ dependencies

_BlinkID_ does not have any additional dependencies.

## <a name="quickScan"></a> Performing your first scan
1. You can start recognition process by starting `ScanCard` activity with Intent initialized in the following way:
	
	```java
	// Intent for ScanCard Activity
	Intent intent = new Intent(this, ScanCard.class);
	
	// set your licence key
	// obtain your licence key at http://microblink.com/login or
	// contact us at http://help.microblink.com
	intent.putExtra(ScanCard.EXTRAS_LICENSE_KEY, "Add your licence key here");

	// setup array of recognition settings (described in chapter "Recognition 
	// settings and results")
	RecognizerSettings[] settArray = setupSettingsArray();
	intent.putExtra(ScanCard.EXTRAS_RECOGNIZER_SETTINGS_ARRAY, settArray);

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
				Parcelable[] resultArray = data.getParcelableArrayExtra(ScanCard.EXTRAS_RECOGNITION_RESULT_LIST);
				
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

# <a name="advancedIntegration"></a> Advanced _BlinkID_ integration instructions
This section will cover more advanced details in _BlinkID_ integration. First part will discuss the methods for checking whether _BlinkID_ is supported on current device. Second part will cover the possible customization of builtin `ScanCard` activity, third part will describe how to embed `RecognizerView` into your activity and fourth part will describe how to use direct API to recognize directly android bitmaps without the need of camera.

## <a name="supportCheck"></a> Checking if _BlinkID_ is supported

### _BlinkID_ requirements
Even before starting the scan activity, you should check if _BlinkID_ is supported on current device. In order to be supported, device needs to have camera. 


OpenGL ES 2.0 can be used to accelerate _BlinkID's_ processing but is not mandatory. However, it should be noted that if OpenGL ES 2.0 is not available processing time will be significantly large, especially on low end devices. 

Android 2.3 is the minimum android version on which _BlinkID_ is supported, but if required we may support even Android 2.2 devices, however additional testing on those devices will be required.

Camera video preview resolution also matters. In order to perform successful scans, camera preview resolution cannot be too low. _BlinkID_ requires minimum 480p camera preview resolution in order to perform scan. It must be noted that camera preview resolution is not the same as the video record resolution, although on most devices those are the same. However, there are some devices that allow recording of HD video (720p resolution), but do not allow high enough camera preview resolution (for example, [Sony Xperia Go](http://www.gsmarena.com/sony_xperia_go-4782.php) supports video record resolution at 720p, but camera preview resolution is only 320p - _BlinkID_ does not work on that device).

_BlinkID_ is native application, written in C++ and available for multiple platforms. Because of this, _BlinkID_ cannot work on devices that have obscure hardware architectures. We have compiled _BlinkID_ native code for `armeabi`, `armeabi-v7a` and `x86` [ABIs](https://en.wikipedia.org/wiki/Application_binary_interface) because those architectures cover almost entire Android device market (actually more than 98% of devices use `armeabi-v7a` ABI). See [Processor architecture considerations](#archConsider) for more information about native libraries in _BlinkID_ and instructions how to disable certain architectures in order to reduce the size of final app.

### Checking for _BlinkID_ support in your app
To check whether the _BlinkID_ is supported on the device, you can do it in the following way:
	
```java
// check if BlinkID is supported on the device
RecognizerCompatibilityStatus supportStatus = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
if(supportStatus == RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
	Toast.makeText(this, "BlinkID is supported!", Toast.LENGTH_LONG).show();
} else {
	Toast.makeText(this, "BlinkID is not supported! Reason: " + supportStatus.name(), Toast.LENGTH_LONG).show();
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
	
* **`ScanCard.EXTRAS_CAMERA_ASPECT_MODE`** - with this extra you can define which [camera aspect mode](javadoc/com/microblink/view/CameraAspectMode.html) will be used. If set to `ASPECT_FIT` (default), then camera preview will be letterboxed inside available view space. If set to `ASPECT_FILL`, camera preview will be zoomed and cropped to use the entire view space. To set the extra to intent, use the following code snippet:

	```java
	intent.putExtra(ScanCard.EXTRAS_CAMERA_ASPECT_MODE, (Parcelable)CameraAspectMode.ASPECT_FIT);
	```
	
* **`ScanCard.EXTRAS_RECOGNIZER_SETTINGS_ARRAY`** - with this extra you must set the array of `RecognizerSettings` objects. Each `RecognizerSettings` object will define settings for specific recognizer object. Each recognizer object then creates its version of `BaseRecognitionResult` object in array returned via `ScanCard.EXTRAS_RECOGNITION_RESULT_LIST` extra. For more information about recognition settings and result, see [Recognition settings and results](#recognitionSettingsAndResults).  After defining recognition settings array, you need to put them into intent extra with following code snippet:
	
	```java
	intent.putExtra(ScanCard.EXTRAS_RECOGNIZER_SETTINGS_ARRAY, settings);
	```
	
* **`ScanCard.EXTRAS_RECOGNITION_RESULT_LIST`** - you can use this extra in `onActivityResult` method of calling activity to obtain array with recognition results. For more information about recognition settings and result, see [Recognition settings and results](#recognitionSettingsAndResults). You can use the following snippet to obtain array of scan results:

	```java
	Parcelable[] resultArray = data.getParcelableArrayExtra(ScanCard.EXTRAS_RECOGNITION_RESULT_LIST);
	```
	
* **`ScanCard.EXTRAS_GENERIC_SETTINGS`** - with this extra you can define additional settings that affect all recognizers or whole recognition process. More information about generic settings can be found in chapter [Generic settings](#genericSettings). To set the extra to intent, use the following code snippet:
	
	```java
	GenericRecognizerSettings genSett = new GenericRecognizerSettings();
	// define additional settings; e.g set timeout to 10 seconds
	genSett.setNumMsBeforeTimeout(10000);
	intent.putExtra(ScanCard.EXTRAS_GENERIC_SETTINGS, genSett);
	```
	
* **`ScanCard.EXTRAS_OPTIMIZE_CAMERA_FOR_NEAR_SCANNING`** - with this extra you can give a hint to _BlinkID_ to optimize camera parameters for near object scanning. When camera parameters are optimized for near object scanning, macro focus mode will be preferred over autofocus mode. Thus, camera will have easier time focusing on to near objects, but might have harder time focusing on far objects. If you expect that most of your scans will be performed by holding the device very near the object, turn on that parameter. By default, this parameter is set to false.
	
* **`ScanCard.EXTRAS_BEEP_RESOURCE`** - with this extra you can set the resource ID of the sound to be played when scan completes. You can use the following snippet to set this extra:

	```java
	intent.putExtra(ScanCard.EXTRAS_BEEP_RESOURCE, R.raw.beep);
    ```
	
* **`ScanCard.EXTRAS_SHOW_FOCUS_RECTANGLE`** - with this extra you can enable showing of rectangle that displays area camera uses to measure focus and brightness when automatically adjusting its parameters. You can enable showing of this rectangle with following code snippet:

	```java
	intent.putExtra(ScanCard.EXTRAS_SHOW_FOCUS_RECTANGLE, true);
	```
	
* **`ScanCard.EXTRAS_ALLOW_PINCH_TO_ZOOM`** - with this extra you can set whether pinch to zoom will be allowed on camera activity. Default is `false`. To enable pinch to zoom gesture on camera activity, use the following code snippet:

	```java
	intent.putExtra(ScanCard.EXTRAS_ALLOW_PINCH_TO_ZOOM, true);
	```
	
* **`ScanCard.EXTRAS_IMAGE_LISTENER`** - with this extra you can set your implementation of [ImageListener interface](javadoc/com/microblink/image/ImageListener.html) that will obtain images that are being processed. Make sure that your [ImageListener](javadoc/com/microblink/image/ImageListener.html) implementation correctly implements [Parcelable](https://developer.android.com/reference/android/os/Parcelable.html) interface with static [CREATOR](https://developer.android.com/reference/android/os/Parcelable.Creator.html) field. Without this, you might encounter a runtime error.

* **`ScanCard.EXTRAS_LICENSE_KEY`** - with this extra you can set the license key for _BlinkID_. You can obtain your licence key from [Microblink website](http://microblink.com/login) or you can contact us at [http://help.microblink.com](http://help.microblink.com). Once you obtain a license key, you can set it with following snippet:

	```java
	// set the license key
	intent.putExtra(ScanCard.EXTRAS_LICENSE_KEY, "Enter_License_Key_Here");
	```
	
	Licence key is bound to package name of your application. For example, if you have licence key that is bound to `com.microblink.blinkid.demo` app package, you cannot use the same key in other applications. However, if you purchase Premium licence, you will get licence key that can be used in multiple applications. This licence key will then not be bound to package name of the app. Instead, it will be bound to the licencee string that needs to be provided to the library together with the licence key. To provide licencee string, use the `EXTRAS_LICENSEE` intent extra like this:

	```java
	// set the license key
	intent.putExtra(ScanCard.EXTRAS_LICENSE_KEY, "Enter_License_Key_Here");
	intent.putExtra(ScanCard.EXTRAS_LICENSEE, "Enter_Licensee_Here");
	```

### Customizing `ScanCard` appearance

Besides possibility to put various intent extras for customizing `ScanCard` behaviour, you can also change strings it displays. The procedure for changing strings in `ScanCard` activity are explained in [Translation and localization](#stringChanging) section.

#### Camera splash screen

While loading camera, `ScanCard` displays a splash screen. The layout of splash screen is defined in `res/layout/camera_splash.xml`. If you are not satisfied with default splash screen design, you can overwrite that file as you wish.

#### Modifying other resources.

Generally, you can also change other resources that `ScanCard` uses, but you are encouraged to create your own custom scan activity instead (see [Embedding `RecognizerView` into custom scan activity](#recognizerView)). Just do not modify the contents of `raw` folder, as it contains files necessary for native part of the library - without those files _BlinkID_ will not work.

## <a name="recognizerView"></a> Embedding `RecognizerView` into custom scan activity
This section will discuss how to embed `RecognizerView` into your scan activity and perform scan.

1. First make sure that `RecognizerView` is a member field in your activity. This is required because you will need to pass all activity's lifecycle events to `RecognizerView`.
2. It is recommended to keep your scan activity in one orientation, such as `portrait` or `landscape`. Setting `sensor` as scan activity's orientation will trigger full restart of activity whenever device orientation changes. This will provide very poor user experience because both camera and _BlinkID_ native library will have to be restarted every time. There are measures for this behaviour and will be discussed [later](#scanOrientation).
3. In your activity's `onCreate` method, create a new `RecognizerView`, define its [settings and listeners](#recognizerViewReference) and then call its `create` method. After that, add your views that should be layouted on top of camera view.
4. Override your activity's `onStart`, `onResume`, `onPause`, `onStop` and `onDestroy` methods and call `RecognizerView's` lifecycle methods `start`, `resume`, `pause`, `stop` and `destroy`. This will ensure correct camera and native resource management. If you plan to manage `RecognizerView's` lifecycle independently of host activity's lifecycle, make sure the order of calls to lifecycle methods is the same as is with activities (i.e. you should not call `resume` method if `create` and `start` were not called first).

Here is the minimum example of integration of `RecognizerView` as the only view in your activity:

```java
public class MyScanActivity extends Activity implements ScanResultListener, CameraEventsListener {
	private RecognizerView mRecognizerView;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// create RecognizerView
		mRecognizerView = new RecognizerView(this);
		   
		// setup array of recognition settings (described in chapter "Recognition 
		// settings and results")
		RecognizerSettings[] settArray = setupSettingsArray();
		if(!RecognizerCompatibility.cameraHasAutofocus(CameraType.CAMERA_BACKFACE, this)) {
			setarr = RecognizerSettingsUtils.filterOutRecognizersThatRequireAutofocus(setarr);
		}
		mRecognizerView.setRecognitionSettings(settings);
		
        try {
            // set license key
            mRecognizerView.setLicenseKey(this, "your license key");
        } catch (InvalidLicenceKeyException exc) {
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
    public void onScanningDone(BaseRecognitionResult[] dataArray, RecognitionType recognitionType) {
    	// this method is from ScanResultListener and will be called when scanning completes
    	// multiple scan results may be returned, depending on generic settings that define
    	// whether all found objects should be returned or only the first one (see subchapter
    	// "Generic settings" in chapter "Recognition settings and results")
    	
    	// When this method gets called, scanning gets paused. To resume scanning after this
    	// method has been called, call resumeScanning method.
    	mRecognizerView.resumeScanning();
    }
    
    @Override
    public void onCameraPreviewStarted() {
        // this method is from CameraEventsListener and will be called when camera preview starts
    }

    @Override
    public void onStartupError(Throwable exc) {
        /** 
         * This method is from CameraEventsListener and will be called when opening of
         * camera resulted in exception. 
         * Known exceptions that can occur are following:
         *      * com.microblink.hardware.camera.CameraResolutionTooSmallException is thrown when largest possible camera preview
         *        resolution is not enough for making a successful scan
         *      * java.lang.UnsatisfiedLinkError is thrown when native library was not successfully loaded thus making scans impossible
         *      * java.lang.Throwable is thrown in all other cases (for example when camera is not ready because it is used by other
         *        apps or some unknown error has occurred)
         */
    }

    @Override
    public void onNotSupported(NotSupportedReason reason) {
        // This method is from CameraEventsListener and will be called when scanning is not supported 
        // on device. Reason for not being supported is given in 'reason' parameter.
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

For that matter, we recommend setting your scan activity to either `portrait` or `landscape` mode and handle device orientation changes manually. To help you with this, `RecognizerView` supports adding child views to it that will be rotated regardless of activity's `screenOrientation`. You add a view you wish to be rotated (such as view that contains buttons, status messages, etc.) to `RecognizerView` with `addChildView` method. The second parameter of the method is a boolean that defines whether the view you are adding will be rotated with device. To define allowed orientations, implement [OrientationAllowedListener](javadoc/com/microblink/view/OrientationAllowedListener.html) interface and add it to `RecognizerView` with method `setOrientationAllowedListener`. **This is the recommended way of rotating camera overlay.**

However, if you really want to set `screenOrientation` property to `sensor` or similar and want Android to handle orientation changes of your scan activity, then we recommend to set `configChanges` property of your activity to `orientation|screenSize`. This will tell Android not to restart your activity when device orientation changes. Instead, activity's `onConfigurationChanged` method will be called so that activity can be notified of the configuration change. In your implementation of this method, you should call `changeConfiguration` method of `RecognizerView` so it can adapt its camera surface and child views to new configuration. Note that on Android versions older than 4.0 changing of configuration will require restart of camera, which can be slow.

__Important__

If you use `sensor` or similar screen orientation for your scan activity there is a catch. No matter if your activity is set to be restarted on configuration change or only notified via `onConfigurationChanged` method, if your activity's orientation is changed from `portrait` to `reversePortrait` or from `landscape` to `reverseLandscape` or vice versa, your activity will not be notified of this change in any way - it will not be neither restarted nor `onConfigurationChanged` will be called - the views in your activity will just be rotated by 180 degrees. This is a problem because it will make your camera preview upside down. In order to fix this, you first need to [find a way how to get notified of this change](https://stackoverflow.com/questions/9909037/how-to-detect-screen-rotation-through-180-degrees-from-landscape-to-landscape-or) and then you should call `changeConfiguration` method of `RecognizerView` so it will correct camera preview orientation.

## <a name="recognizerViewReference"></a> `RecognizerView` reference
The complete reference of `RecognizerView` is available in [Javadoc](javadoc/com/microblink/view/recognition/RecognizerView.html). The usage example is provided in ` - BlinkIDDemoCustomUI demonstrates advanced integration within custom scan activity` demo app provided with SDK. This section just gives a quick overview of `RecognizerView's` most important methods.

##### <a name="recognizerView_create"></a> `create()`
This method should be called in activity's `onCreate` method. It will initialize `RecognizerView's` internal fields and will initialize camera control thread. This method must be called after all other settings are already defined, such as listeners and recognition settings. After calling this method, you can add child views to `RecognizerView` with method `addChildView(View, boolean)`.

##### <a name="recognizerView_start"></a> `start()`
This method should be called in activity's `onStart` method. It will initialize background processing thread and start native library initialization on that thread.

##### <a name="recognizerView_resume"></a> `resume()`
This method should be called in activity's `onResume` method. It will trigger background initialization of camera.

##### <a name="recognizerView_pause"></a> `pause()`
This method should be called in activity's `onPause` method. It will stop the camera, but will keep native library loaded.

##### <a name="recognizerView_stop"></a> `stop()`
This method should be called in activity's `onStop` method. It will deinitialize native library, terminate background processing thread and free all resources that are no longer necessary.

##### <a name="recognizerView_destroy"></a> `destroy()`
This method should be called in activity's `onDestroy` method. It will free all resources allocated in `create()` and will terminate camera control thread.

##### <a name="recognizerView_changeConfiguration"></a> `changeConfiguration(Configuration)`
This method should be called in activity's `onConfigurationChanged` method. It will adapt camera surface to new configuration without the restart of the activity. See [Scan activity's orientation](#scanOrientation) for more information.

##### <a name="recognizerView_setCameraType"></a> `setCameraType(CameraType)`
With this method you can define which camera on device will be used. Default camera used is back facing camera.

##### <a name="recognizerView_setAspectMode"></a> `setAspectMode(CameraAspectMode)`
Define the [aspect mode of camera](javadoc/com/microblink/view/CameraAspectMode.html). If set to `ASPECT_FIT` (default), then camera preview will be letterboxed inside available view space. If set to `ASPECT_FILL`, camera preview will be zoomed and cropped to use the entire view space.

##### <a name="recognizerView_setRecognitionSettings"></a> `setRecognitionSettings(RecognizerSettings[])`
With this method you can set the array of `RecognizerSettings` objects. Those objects will contain information about what will be scanned and how will scan be performed. For more information about recognition settings and results see [Recognition settings and results](#recognitionSettingsAndResults). This method must be called before `create()`.

##### <a name="recognizerView_setGenericRecognizerSettings"></a> `setGenericRecognizerSettings(GenericRecognizerSettings)`
With this method you can set the generic settings that will be affect all enabled recognizers or the whole recognition process. For more information about generic settings, see [Generic settings](#genericSettings). This method must be called before `create()`.

##### <a name="recognizerView_reconfigureRecognizers1"></a> `reconfigureRecognizers(RecognizerSettings[], GenericRecognizerSettings)`
With this method you can reconfigure the recognition process while recognizer is active. Unlike `setRecognitionSettings` and `setGenericRecognizerSettings`, this method can be called while recognizer is active (i.e. after `resume` was called), but paused (either `pauseScanning` was called or `onScanningDone` callback is being handled). For more information about recognition settings see [Recognition settings and results](#recognitionSettingsAndResults).

##### <a name="recognizerView_reconfigureRecognizers2"></a> `reconfigureRecognizers(RecognizerSettings[])`
With this method you can reconfigure the recognition process while recognizer is active. Unlike `setRecognitionSettings`, this method can be called while recognizer is active (i.e. after `resume` was called), but paused (either `pauseScanning` was called or `onScanningDone` callback is being handled). For more information about recognition settings see [Recognition settings and results](#recognitionSettingsAndResults).

##### <a name="recognizerView_setOrientationAllowedListener"></a> `setOrientationAllowedListener(OrientationAllowedListener)`
With this method you can set a [OrientationAllowedListener](javadoc/com/microblink/view/OrientationAllowedListener.html) which will be asked if current orientation is allowed. If orientation is allowed, it will be used to rotate rotatable views to it and it will be passed to native library so that recognizers can be aware of the new orientation.

##### <a name="recognizerView_setRecognizerViewEventListener"></a> `setRecognizerViewEventListener(RecognizerViewEventListener)`
With this method you can set a [RecognizerViewEventListener](javadoc/com/microblink/view/recognition/RecognizerViewEventListener.html) which will be notified when certain recognition events occur, such as when object has been detected.

##### <a name="recognizerView_setScanResultListener"></a> `setScanResultListener(ScanResultListener)`
With this method you can set a [ScanResultListener](javadoc/com/microblink/view/recognition/ScanResultListener.html) which will be notified when recognition completes. After recognition completes, `RecognizerView` will pause its scanning loop and to continue the scanning you will have to call `resumeScanning` method. In this method you can obtain data from scanning results. For more information see [Recognition settings and results](#recognitionSettingsAndResults).

##### <a name="recognizerView_setCameraEventsListener"></a> `setCameraEventsListener(CameraEventsListener)`
With this method you can set a [CameraEventsListener](javadoc/com/microblink/view/CameraEventsListener.html) which will be notified when various camera events occur, such as when camera preview has started, autofocus has failed or there has been an error while starting the camera.

##### <a name="recognizerView_pauseScanning"></a> `pauseScanning()`
This method pauses the scanning loop, but keeps both camera and native library initialized. This method is called internally when scan completes before `onScanningDone` is called.

##### <a name="recognizerView_resumeScanning"></a> `resumeScanning()`
With this method you can resume the paused scanning loop. This method implicitly calls `resetRecognitionState()`.

##### <a name="recognizerView_resumeScanningWithoutStateReset"></a> `resumeScanningWithoutStateReset()`
With this method you can resume the paused scanning loop without resetting recognition state. Be aware that after resuming, old recognition state might be reused for boosting recognition result. This may not be always a desired behaviour.

##### <a name="recognizerView_resetRecognitionState"></a> `resetRecognitionState()`
With this method you can reset internal recognition state. State is usually kept to improve recognition quality over time, but without resetting recognition state sometimes you might get poorer results (for example if you scan one object and then another without resetting state you might end up with result that contains properties from both scanned objects).

##### <a name="recognizerView_addChildView"></a> `addChildView(View, boolean)`
With this method you can add your own view on top of `RecognizerView`. `RecognizerView` will ensure that your view will be layouted exactly above camera preview surface (which can be letterboxed if aspect ratio of camera preview size does not match the aspect ratio of `RecognizerView` and camera aspect mode is set to `ASPECT_FIT`). Boolean parameter defines whether your view should be rotated with device orientation changes. The rotation is independent of host activity's orientation changes and allowed orientations will be determined from [OrientationAllowedListener](javadoc/com/microblink/view/OrientationAllowedListener.html). See also [Scan activity's orientation](#scanOrientation) for more information why you should rotate your views independently of activity.

##### <a name="recognizerView_isCameraFocused"></a> `isCameraFocused()` 
This method returns `true` if camera thinks it has focused on object. Note that camera has to be loaded for this method to work.

##### <a name="recognizerView_focusCamera"></a> `focusCamera()` 
This method requests camera to perform autofocus. If camera does not support autofocus feature, method does nothing. Note that camera has to be loaded for this method to work.

##### <a name="recognizerView_isCameraTorchSupported"></a> `isCameraTorchSupported()` 
This method returns `true` if camera supports torch flash mode. Note that camera has to be loaded for this method to work.

##### <a name="recognizerView_setTorchState"></a> `setTorchState(boolean, SuccessCallback)` 
If torch flash mode is supported on camera, this method can be used to enable/disable torch flash mode. After operation is performed, [SuccessCallback](javadoc/com/microblink/hardware/SuccessCallback.html) will be called with boolean indicating whether operation has succeeded or not. Note that camera has to be loaded for this method to work and that callback might be called on background non-UI thread.

##### <a name="recognizerView_setScanningRegion"></a> `setScanningRegion(Rectangle, boolean)`
You can use this method to define the scanning region and define whether this scanning region will be rotated with device if [OrientationAllowedListener](javadoc/com/microblink/view/OrientationAllowedListener.html) determines that orientation is allowed. This is useful if you have your own camera overlay on top of `RecognizerView` that is set as rotatable view - you can thus synchronize the rotation of the view with the rotation of the scanning region native code will scan.

Scanning region is defined as [Rectangle](javadoc/com/microblink/geometry/Rectangle.html). First parameter of rectangle is x-coordinate represented as percentage of view width, second parameter is y-coordinate represented as percentage of view height, third parameter is region width represented as percentage of view width and fourth parameter is region height represented as percentage of view height.

View width and height are defined in current context, i.e. they depend on screen orientation. If you allow your ROI view to be rotated, then in portrait view width will be smaller than height, whilst in landscape orientation width will be larger than height. This complies with view designer preview. If you choose not to rotate your ROI view, then your ROI view will be laid out either in portrait or landscape, depending on setting for your scan activity in `AndroidManifest.xml`

Note that scanning region only reflects to native code - it does not have any impact on user interface. You are required to create a matching user interface that will visualize the same scanning region you set here.

##### <a name="recognizerView_setImageListener"></a> `setImageListener(ImageListener)`
You can use this method to define [image listener](javadoc/com/microblink/image/ImageListener.html) that will obtain images that are currently being processed by the native library. Please make sure that installing this listener introduces a large performance penalty on scanning process.

##### `setLicenseKey(String licenseKey)`
This method sets the license key that will unlock all features of the native library. You can obtain your license key from [Microblink website](http://microblink.com/login).

##### `setLicenseKey(String licenseKey, String licenseOwner)`
Use this method to set a license key that is bound to a licensee, not the application package name. You will use this method when you obtain a license key that allows you to use _BlinkID_ SDK in multiple applications. You can obtain your license key from [Microblink website](http://microblink.com/login).

## <a name="directAPI"></a> Using direct API for recognition of Android Bitmaps

This section will describe how to use direct API to recognize android Bitmaps without the need for camera. You can use direct API anywhere from your application, not just from activities.

1. First, you need to obtain reference to [Recognizer singleton](javadoc/com/microblink/directApi/Recognizer.html).
2. Second, you need to initialize the recognizer.
3. After initialization, you can use singleton to process images. You cannot process multiple images in parallel.
4. Do not forget to terminate the recognizer after usage (it is a shared resource).

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
	   mRecognizer = Recognizer.getSingletonInstance();
		
	   try {
	       // set license key
	       mRecognizer.setLicenseKey(this, "your license key");
	   } catch (InvalidLicenceKeyException exc) {
	       return;
	   }

		// setupSettingsArray method is described in chapter "Recognition 
		// settings and results")
		mRecognizer.initialize(this, null, setupSettingsArray(), new DirectApiErrorListener() {
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
		mRecognizer.recognize(bitmap, this);
	}

	@Override
	protected void onStop() {
	   super.onStop();
	   mRecognizer.terminate();
	}

    @Override
    public void onScanningDone(BaseRecognitionResult[] dataArray, RecognitionType recognitionType) {
    	// this method is from ScanResultListener and will be called when scanning completes
    	// multiple scan results may be returned, depending on generic settings that define
    	// whether all found objects should be returned or only the first one (see subchapter
    	// "Generic settings" in chapter "Recognition settings and results")
    	
    	finish(); // in this example, just finish the activity
    }
    
}
```

# <a name="recognitionSettingsAndResults"></a> Recognition settings and results

This chapter will discuss various recognition settings used to configure different recognizers and scan results generated by them.

## <a name="genericSettings"></a> Generic settings

Generic settings affect all enabled recognizers and the whole recognition process. The complete reference can be found in [javadoc](javadoc/com/microblink/recognizers/settings/GenericRecognizerSettings.html). Here is the list of methods that are most relevant:

##### `setAllowMultipleScanResultsOnSingleImage(boolean)`
Sets whether or not outputting of multiple scan results from same image is allowed. If that is `true`, it is possible to return multiple recognition results produced by different recognizers from same image. However, single recognizer can still produce only a single result from single image. By default, this option is `false`, i.e. the array of `BaseRecognitionResults` will contain at most 1 element. The upside of setting that option to `false` is the speed - if you enable lots of recognizers, as soon as the first recognizer succeeds in scanning, recognition chain will be terminated and other recognizers will not get a chance to analyze the image. The downside is that you are then unable to obtain multiple results from different recognizers from single image.

##### `setNumMsBeforeTimeout(int)`
Sets the number of miliseconds _BlinkID_ will attempt to perform the scan it exits with timeout error. On timeout returned array of `BaseRecognitionResults` might be null, empty or may contain only elements that are not valid (`isValid` returns `false`) or are empty (`isEmpty` returns `true`).

## <a name="mrtd"></a> Scanning machine-readable travel documents

This section discusses the setting up of machine-readable travel documents(MRTD) recognizer and obtaining results from it.

### Setting up machine-readable travel documents recognizer

To activate MRTD recognizer, you need to create [MRTDRecognizerSettings](javadoc/com/microblink/recognizers/ocr/mrtd/MRTDRecognizerSettings.html) and add it to `RecognizerSettings` array. You can use the following code snippet to perform that:

```java
private RecognizerSettings[] setupSettingsArray() {
	MRTDRecognizerSettings sett = new MRTDRecognizerSettings();
	
	// now add sett to recognizer settings array that is used to configure
	// recognition
	return new RecognizerSettings[] { sett };
}
```

`MRTDRecognizerSettings` has following methods for tweaking the recognition:

##### `setMRZRegion(Rectangle)`
With this method you can define the region on image where Machine Readable Zone (MRZ) is expected. If you do not set the region, default region will be used. For example, to specify that bottom 25% of the image should be used for MRZ scanning, use the following snippet:

```java
sett.setMRZRegion(new Rectangle(0.f, 0.75f, 1.f, 0.25f));
```

##### `setDetectMRZ(boolean)`
With this method you can turn on/off the detection of Machine Readable Zone. When detection is on (default), MRZ location if first detected on image and then OCR is performed. If you turn this off, you must ensure correct positioning of MRZ with your UI. MRZ detection introduces a performance penalty.

### Obtaining results from machine-readable travel documents recognizer

MRTD recognizer produces [MRTDRecognitionResult](javadoc/com/microblink/recognizers/ocr/mrtd/MRTDRecognitionResult.html). You can use `instanceof` operator to check if element in results array is instance of `MRTDRecognitionResult` class. See the following snippet for an example:

```java
@Override
public void onScanningDone(BaseRecognitionResult[] dataArray, RecognitionType recognitionType) {
	for(BaseRecognitionResult baseResult : dataArray) {
		if(baseResult instanceof MRTDRecognitionResult) {
			MRTDRecognitionResult result = (MRTDRecognitionResult) baseResult;
			
	        // you can use getters of MRTDRecognitionResult class to 
	        // obtain scanned information
	        if(result.isValid() && !result.isEmpty()) {
	           String primaryId = result.getPrimaryId();
	           String secondaryId = result.getSecondaryId();
	           String documentNumber = result.getDocumentNumber();          		 
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

## <a name="usdl"></a> Scanning US Driver's licence barcodes

This section discusses the settings for setting up USDL recognizer and explains how to obtain results from it.

### Setting up USDL recognizer
To activate USDL recognizer, you need to create [USDLRecognizerSettings](javadoc/com/microblink/recognizers/barcode/usdl/USDLRecognizerSettings.html) and add it to `RecognizerSettings` array. You can do this using following code snippet:

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
By setting this to `true`, you will allow scanning barcodes which don't have quiet zone surrounding it (e.g. text concatenated with barcode). This option can significantly increase recognition time. Default is `false`.

### Obtaining results from USDL recognizer

USDL recognizer produces [USDLScanResult](javadoc/com/microblink/recognizers/barcode/usdl/USDLScanResult.html). You can use `instanceof` operator to check if element in results array is instance of `USDLScanResult`. See the following snippet for an example:

```java
@Override
public void onScanningDone(BaseRecognitionResult[] dataArray, RecognitionType recognitionType) {
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
This method will return the object that contains information about barcode's binary layout. You can see information about that object in [javadoc](javadoc/com/microblink/results/barcode/BarcodeDetailedData.html). However, if you only need to access byte array containing, you can call method `getAllData` of `BarcodeDetailedData` object.

##### `getField(String)`
This method will return a parsed US Driver's licence element. The method requires a key that defines which element should be returned and returns either a string representation of that element or `null` if that element does not exist in barcode. To see a list of available keys, refer to [Keys for obtaining US Driver's license data](DriversLicenseKeys.md)

## <a name="ukdl"></a> Scanning United Kingdom's driver's licences

This section discusses the setting up of UK Driver's Licence recognizer and obtaining results from it.

### Setting up UK Driver's Licence recognizer

To activate UKDL recognizer, you need to create [UKDLRecognizerSettings](javadoc/com/microblink/recognizers/ocr/ukdl/UKDLRecognizerSettings.html) and add it to `RecognizerSettings` array. You can use the following code snippet to perform that:

```java
private RecognizerSettings[] setupSettingsArray() {
	UKDLRecognizerSettings sett = new UKDLRecognizerSettings();
	
	// now add sett to recognizer settings array that is used to configure
	// recognition
	return new RecognizerSettings[] { sett };
}
```

### Obtaining results from UK Driver's Licence recognizer

UKDL recognizer produces [UKDLRecognitionResult](javadoc/com/microblink/recognizers/ocr/ukdl/UKDLRecognitionResult.html). You can use `instanceof` operator to check if element in results array is instance of `UKDLRecognitionResult` class. See the following snippet for an example:

```java
@Override
public void onScanningDone(BaseRecognitionResult[] dataArray, RecognitionType recognitionType) {
	for(BaseRecognitionResult baseResult : dataArray) {
		if(baseResult instanceof UKDLRecognitionResult) {
			UKDLRecognitionResult result = (UKDLRecognitionResult) baseResult;
			
	        // you can use getters of UKDLRecognitionResult class to 
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
Returns the address of the Driver's Licence owner.

##### `String getDriverNumber()`
Returns the driver number.

##### `Date getDateOfBirth()`
Returns date of birth of the Driver's Licence owner.

##### `Date getDocumentIssueDate()`
Returns the issue date of the Driver's Licence.

##### `Date getDocumentExpiryDate()`
Returns the expiry date of the Driver's Licence.

##### `String getPlaceOfBirth()`
Returns the place of birth of Driver's Licence owner.

# <a name="translation"></a> Translation and localization

`BlinkID` can be localized to any language. If you are using `RecognizerView` in your custom scan activity, you should handle localization as in any other Android app - `RecognizerView` does not use strings nor drawables, it only uses raw resources from `res/raw` folder. Those resources must not be touched as they are required for recognition to work correctly.

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

_BlinkID_ can easily be translated to other languages. The `res` folder in `LibRecognizer.aar` archive has folder `values` which contains `strings.xml` - this file contains english strings. In order to make e.g. croatian translation, create a folder `values-hr` in your project and put the copy od `strings.xml` inside it (you might need to extract `LibRecognizer.aar` archive to get access to those files). Then, open that file and change the english version strings into croatian version. 

### <a name="stringChanging"></a> Changing strings in the existing language
	
To modify an existing string, the best approach would be to:

1. choose a language which you want to modify. For example Croatia ('hr').
2. find strings.xml in `LibRecognizer.aar` archive folder `res/values-hr`
3. choose a string key which you want to change. For example, ```<string name="PhotoPayHelp">Help</string>```
4. in your project create a file `strings.xml` in the folder `res/values-hr`, if it doesn't already exist
5. create an entry in the file with the value for the string which you want. For example ```<string name="PhotoPayHelp">Pomoć</string>```
6. repeat for all the string you wish to change

# <a name="archConsider"></a> Processor architecture considerations

_BlinkID_ is distributed with both ARMv7, ARM64 and x86 native library binaries.

ARMv7 architecture gives the ability to take advantage of hardware accelerated floating point operations and SIMD processing with [NEON](http://www.arm.com/products/processors/technologies/neon.php). This gives _BlinkID_ a huge performance boost on devices that have ARMv7 processors. Most new devices (all since 2012.) have ARMv7 processor so it makes little sense not to take advantage of performance boosts that those processors can give. 

ARM64 is the new processor architecture that some new high end devices use. ARM64 processors are very powerful and also have the possibility to take advantage of new NEON64 SIMD instruction set to quickly process multiple pixels with single instruction.

x86 architecture gives the ability to obtain native speed on x86 android devices, like [Prestigio 5430](http://www.gsmarena.com/prestigio_multiphone_5430_duo-5721.php). Without that, _BlinkID_ will not work on such devices, or it will be run on top of ARM emulator that is shipped with device - this will give a huge performance penalty.

However, there are some issues to be considered:

- ARMv7 build of native library cannot be run on devices that do not have ARMv7 compatible processor (list of those old devices can be found [here](http://www.getawesomeinstantly.com/list-of-armv5-armv6-and-armv5-devices/))
- ARMv7 processors does not understand x86 instruction set
- x86 processors do not understand neither ARM64 nor ARMv7 instruction sets
- however, some x86 android devices ship with the builtin [ARM emulator](http://commonsware.com/blog/2013/11/21/libhoudini-what-it-means-for-developers.html) - such devices are able to run ARM binaries but with performance penalty. There is also a risk that builtin ARM emulator will not understand some specific ARM instruction and will crash.
- ARM64 processors understand ARMv7 instruction set, but ARMv7 processors does not understand ARM64 instructions
- if ARM64 processor executes ARMv7 code, it does not take advantage of modern NEON64 SIMD operations and does not take advantage of 64-bit registers it has - it runs in emulation mode

`LibRecognizer.aar` archive contains ARMv7, ARM64 and x86 builds of native library. By default, when you integrate _BlinkID_ into your app, your app will contain native builds for all processor architectures. Thus, _BlinkID_ will work on ARMv7 and x86 devices and will use ARMv7 features on ARMv7 devices and ARM64 features on ARM64 devices. However, the size of your application will be rather large.

## <a name="reduceSize"></a> Reducing the final size of your app

If your final app is too large because of _BlinkID_, you can decide to create multiple flavors of your app - one flavor for each architecture. With gradle and Android studio this is very easy - just add the following code to `build.gradle` file of your app:

```
android {
  ...
  splits {
    abi {
      enable true
      reset()
      include 'x86', 'armeabi-v7a', 'arm64-v8a'
      universalApk true
    }
  }
}
```

With that build instructions, gradle will build four different APK files for your app. Each APK will contain only native library for one processor architecture and one APK will contain all architectures. In order for Google Play to accept multiple APKs of the same app, you need to ensure that each APK has different version code. This can easily be done by defining a version code prefix that is dependent on architecture and adding real version code number to it in following gradle script:

```
// map for the version code
def abiVersionCodes = ['armeabi-v7a':1, 'x86':2, 'arm64-v8a':3]

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

To remove a support for processor architecture, you should simply delete appropriate folder inside Eclipse library project:

- to remove ARMv7 support, delete folder `libs/armeabi-v7a`
- to remove x86 support, delete folder `libs/x86`
- to remove ARM64 support, delete folder `libs/arm64-v8a`

### Consequences of removing processor architecture

However, removing a processor architecture has some consequences:

- by removing ARMv7 support _BlinkID_ will not work on devices that have ARMv7 processors. 
- by removing ARM64 support, _BlinkID_ will not use ARM64 features on ARM64 device
- by removing x86 support, _BlinkID_ will not work on devices that have x86 processor, except in situations when devices have ARM emulator - in that case, _BlinkID_ will work, but will be slow

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
For any other questions, feel free to contact us at [help.microblink.com](http://help.microblink.com).


