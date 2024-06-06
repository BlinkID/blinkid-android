<p align="center" >
  <img src="https://raw.githubusercontent.com/wiki/blinkid/blinkid-android/images/logo-microblink.png" alt="Microblink" title="Microblink">
</p>

# _BlinkID_ SDK for Android

The BlinkID Android SDK lets you build a fantastic onboarding experience in your Android app.

With one quick scan, your users will be able to extract information from their identity cards, passports, driver licenses and virtually any other government-issued ID there is.

BlinkID is:

- **Fast**. Real-time data extraction in less than 400ms. Way better than minutes-long form-filling.
- **Secure**. Privacy first, always. Scanning works even if the user’s phone is in airplane mode, meaning personal information never touches a third-party server.
- **Intelligent**. Machine learning models, optimized to read and parse identity documents from more than 180 countries worldwide, automatically, no need to preselect any of them.
- **Lightweight**. Designed to increase your app’s usability, not weight.
- **What you make of it**. Customize and rebrand the default UI or leave it as it is. It’s up to you.
- **More than just a powerful ID scanner**. Powerful data extraction, coupled with powerful perks. Get a cropped document image back, spot printed documents or data match both sides of the ID for parity. 

<p align="center" >
  <img src="https://raw.githubusercontent.com/wiki/blinkid/blinkid-android/images/blinkid-v5.gif" alt="BlinkID SDK">
</p>

To see all of these features at work download our free demo app:

[![Vision App](https://raw.githubusercontent.com/wiki/blinkid/blinkid-android/images/playstore.png)](https://showcase.page.link/githubAndroid) [![Vision App](https://raw.githubusercontent.com/wiki/blinkid/blinkid-android/images/appgallery.png)](https://appgallery7.huawei.com/#/app/C101961459)

Feeling ready to crack on with the integration? First make sure we support your document type ➡️ [full list](https://microblink.com/full-list-of-supported-identity-documents/). And then follow the guidelines below.

# Table of contents

* [Quick Start](#quick-start)
    * [Quick start with the sample app](#quick-demo)
    * [SDK integration](#android-studio-integration)
* [Device requirements](#support-check)
* [_BlinkID_ SDK integration levels](#ui-customizations)
    * [Built-in activities (`UISettings`)](#run-builtin-activity)
    * [Built-in fragment (`RecognizerRunnerFragment`)](#recognizer-runner-fragment)
    * [Custom UX with `RecognizerRunnerView`](#recognizer-runner-view)
    * [Direct API](#direct-api)
        * [Using Direct API for recognition of Android Bitmaps and custom camera frames](#direct-api-images)
        * [Using Direct API for `String` recognition (parsing)](#direct-api-strings)
        * [Understanding DirectAPI's state machine](#direct-api-state-machine)
        * [Using Direct API while RecognizerRunnerView is active](#direct-api-with-recognizer)
        * [Using Direct API with combined recognizers ](#direct-api-combined-recognizers)
* [Available built-in activities and overlays](#built-in-ui-components)
    * [`BlinkIdUISettings` and `BlinkIdOverlayController`](#blinkid-ui-component)
    * [`DocumentUISettings`](#document-ui-component)
    * [`LegacyDocumentVerificationUISettings`](#legacy-document-verify-ui-component)
    * [Translation and localization](#translation)
* [Handling processing events with `RecognizerRunner` and `RecognizerRunnerView`](#processing-events)
* [`Recognizer` concept and `RecognizerBundle`](#available-recognizers)
    * [The `Recognizer` concept](#recognizer-concept)
    * [`RecognizerBundle`](#recognizer-bundle)
        * [Passing `Recognizer` objects between activities](#intent-optimization)
* [List of available recognizers](#recognizer-list)
    * [Frame Grabber Recognizer](#frame-grabber-recognizer)
    * [Success Frame Grabber Recognizer](#success-frame-grabber-recognizer)
    * [BlinkID recognizers](#blinkid-recognizers)
        * [BlinkID single side recognizer](#blinkid-single-side-recognizer)
        * [BlinkID multi side recognizer](#blinkidMultiSideRecognizer)
        * [Machine Readable Travel Document recognizer](#mrtd-recognizer)
        * [Machine Readable Travel Document combined recognizer](#mrtd-combined-recognizer)
        * [Passport recognizer](#passport-recognizer)
        * [Visa recognizer](#visa-recognizer)
        * [ID barcode recognizer](#id-barcode-recognizer)
        * [Document face recognizer](#document-face-recognizer)
* [Embedding _BlinkID_ inside another SDK](#embed-aar)
* [Processor architecture considerations](#arch-consider)
    * [Reducing the final size of your app](#reduce-size)
        * [Consequences of removing processor architecture](#arch-consequences)
    * [Combining _BlinkID_ with other native libraries](#combineNativeLibraries)
        * [Resolving conflict on `libc++_shared.so`](#dynamicCppRuntime)
* [Troubleshooting](#troubleshoot)
* [FAQ and known issues](#faq)
* [Additional info](#info)
    * [BlinkID SDK size](#size-report)
    * [API reference](#api-reference)
    * [Contact](#contact)

# <a name="quick-start"></a> Quick Start

## <a name="quick-demo"></a> Quick start with the sample app

1. Open Android Studio.
2. In Quick Start dialog choose _Import project (Eclipse ADT, Gradle, etc.)_.
3. In File dialog select _BlinkIDSample_ folder.
4. Wait for the project to load. If Android studio asks you to reload project on startup, select `Yes`.

#### Included sample apps

- _BlinkID-aMinimalSample_ demonstrates quick and simple integration of _BlinkID_ library
- _BlinkID-ComposeMinimalSample_ demonstrates simple integration of _BlinkID_ library while using Compose
- _BlinkID-MinimalSampleAdvanced_ demonstrates simple integration of _BlinkID_ library where both recognizer and UI settings can be customized
- _BlinkID-AllRecognizersSample_ demonstrates integration of almost all available features. This sample application is best for performing a quick test of supported features
- _BlinkID-CustomCombinedSample_ demonstrates advanced custom UI integration and usage of the combined recognizers within a custom scan activity
- _BlinkID-ComposeFragmentSample_ demonstrates advanced custom UI integration and usage of the combined recognizers within a fragment while using Compose
- _BlinkID-CustomUISample_ demonstrates advanced integration within custom scan activity
- _BlinkID-DirectApiSample_ demonstrates how to perform scanning of Android Bitmaps
- _BlinkID-ImagesSample_ demonstrates how to obtain document images
- _BlinkID-OverlaySample_ demonstrates how to use `RecognizerRunnerFragment` and built in camera overlay controller within your activity

## <a name="android-studio-integration"></a> SDK integration
#### Adding _BlinkID_ dependency

In your `build.gradle`, add _BlinkID_ maven repository to repositories list

```
repositories {
    maven { url 'https://maven.microblink.com' }
}
```

Add _BlinkID_ as a dependency and make sure `transitive` is set to true

```
dependencies {
    implementation('com.microblink:blinkid:6.8.0@aar') {
        transitive = true
    }
}
```

#### Importing Javadoc

Android studio should automatically import javadoc from maven dependency. If that doesn't happen, you can do that manually by following these steps:

1. In Android Studio project sidebar, ensure [project view is enabled](https://developer.android.com/studio/projects#ProjectView)
2. Expand `External Libraries` entry (usually this is the last entry in project view)
3. Locate `blinkid-6.8.0` entry, right click on it and select `Library Properties...`
4. A `Library Properties` pop-up window will appear
5. Click the second `+` button in bottom left corner of the window (the one that contains `+` with little globe)
6. Window for defining documentation URL will appear
7. Enter following address: `https://blinkid.github.io/blinkid-android/`
8. Click `OK`


#### <a name="first-scan"></a> Performing your first scan
1. A valid license key is required to initialize scanning. You can request a free trial license key, after you register, at [Microblink Developer Hub](https://account.microblink.com/signin). License is bound to [package name](https://developer.android.com/studio/build/configure-app-module#set-application-id) of your app, so please make sure you enter the correct package name when asked.

   Download your licence file and put it in your application's _assets_ folder. Make sure to set the license key before using any other classes from the SDK, otherwise you will get a runtime exception.

   We recommend that you extend [Android Application class](https://developer.android.com/reference/android/app/Application.html) and set the license in [onCreate callback](https://developer.android.com/reference/android/app/Application.html#onCreate()) like this:

   ##### Java

   ```java
   public class MyApplication extends Application {
       @Override
       public void onCreate() {
           MicroblinkSDK.setLicenseFile("path/to/license/file/within/assets/dir", this);
       }
   }
   ```

   ##### Kotlin
   ```kotlin
   public class MyApplication : Application() {
       override fun onCreate() {
           MicroblinkSDK.setLicenseFile("path/to/license/file/within/assets/dir", this)
       }	
   }
   ```

2. In your main activity, define and create `ActivityResultLauncher` object by overriding the `onActivityResult` method. Both `OneSideDocumentScan` and `TwoSideDocumentScan` can be used interchangably with no difference in implementation. The only functional difference is that `OneSideDocumentScan` is scanning only one side of the document and that `TwoSideDocumentScan` scans more than one side of the document.
   ##### Java
   ```java
   ActivityResultLauncher<Void> resultLauncher = registerForActivityResult(
            new TwoSideDocumentScan(),
            twoSideScanResult -> {
                ResultStatus resultScanStatus = twoSideScanResult.getResultStatus();
                if (resultScanStatus == ResultStatus.FINISHED) {
                    // code after a successful scan
                    // use result.getResult() for fetching results, for example:
                    String firstName = twoSideScanResult.getResult().getFirstName().value();
                } else if (resultScanStatus == ResultStatus.CANCELLED) {
                    // code after a cancelled scan
                } else if (resultScanStatus == ResultStatus.EXCEPTION) {
                    // code after a failed scan
                }
            }
    );
   ```
   ##### Kotlin

   ```kotlin
   private val resultLauncher =
        registerForActivityResult(TwoSideDocumentScan()) { twoSideScanResult: TwoSideScanResult ->
            when (twoSideScanResult.resultStatus) {
                ResultStatus.FINISHED -> {
                    // code after a successful scan
                    // use twoSideScanResult.result for fetching results, for example:
                    val firstName = twoSideScanResult.result?.firstName?.value()
                }
                ResultStatus.CANCELLED -> {
                    // code after a cancelled scan
                }
                ResultStatus.EXCEPTION -> {
                    // code after a failed scan
                }
                else -> {}
            }
        }
   ```
   
   ##### Kotlin Compose
   ```kotlin
   @Composable
   fun createLauncher(): ActivityResultLauncher<Void?> {
        return rememberLauncherForActivityResult(TwoSideDocumentScan()) { twoSideScanResult: TwoSideScanResult -> 
            when (twoSideScanResult.resultStatus) {
                ResultStatus.FINISHED -> {
                    // code after a successful scan
                    // use twoSideScanResult.result for fetching results, for example:
                    val firstName = twoSideScanResult.result?.firstName?.value()
                }
                ResultStatus.CANCELLED -> {
                    // code after a cancelled scan
                }
                ResultStatus.EXCEPTION -> {
                    // code after a failed scan
                }
                else -> {}
            }
        }
   }
   ```

   After a scan, the `result`, which is either a `OneSideScanResult` or `TwoSideScanResult` object instance, is going to be updated. You can define what happens with the data in the override of the `onActivityResult` function (Kotlin code also overrides this function but it is implicit). Results are accessible in the `twoSideScanResult.getResult()` method (`twoSideScanResult.result` in Kotlin).

3. Start scanning process by calling `ActivityResultObject` and calling [`ActivityResultLauncher.launch`](https://developer.android.com/reference/androidx/activity/result/ActivityResultLauncher#launch(kotlin.Any,androidx.core.app.ActivityOptionsCompat)):
   ##### Java

   ```java
   // method within MyActivity from previous step
   public void startScanning() {
       // Start scanning
       resultLauncher.launch(null);
   }
   ```

   ##### Kotlin
    ```kotlin
    // method within MyActivity from previous step
    public fun startScanning() {
        // Start scanning
        resultLauncher.launch()
    }
    ```

   ##### Kotlin Compose
    ```kotlin
   // within @Composable function or setContent block
   val resultLauncher = createLauncher()
   resultLauncher.launch()
    ```


   The results are going to be available in a callbacks, which are defined in the `ActivityResultObject` which was defined in the previous step.
# <a name="support-check"></a> Device requirements

### Android Version

_BlinkID_ requires Android API level **21** or newer.

### Camera

Camera video preview resolution also matters. In order to perform successful scans, camera preview resolution must be at least 720p. Note that camera preview resolution is not the same as video recording resolution.

### Processor architecture

_BlinkID_ is distributed with **ARMv7** and **ARM64** native library binaries.

_BlinkID_ is a native library, written in C++ and available for multiple platforms. Because of this, _BlinkID_ cannot work on devices with obscure hardware architectures. We have compiled _BlinkID_ native code only for the most popular Android [ABIs](https://en.wikipedia.org/wiki/Application_binary_interface).

Even before setting the license key, you should check if the _BlinkID_ is supported on the current device (see next section: *Compatibility check*). Attempting to call any method from the SDK that relies on native code, such as license check, on a device with unsupported CPU architecture will crash your app.

If you are combining _BlinkID_ library with other libraries that contain native code into your application, make sure you match the architectures of all native libraries.

For more information, see [Processor architecture considerations](#arch-consider) section.

### Compatibility check

Here's how you can check whether the _BlinkID_ is supported on the device:

##### Java
```java
// check if BlinkID is supported on the device,
RecognizerCompatibilityStatus status = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
if (status == RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
    Toast.makeText(this, "BlinkID is supported!", Toast.LENGTH_LONG).show();
} else if (status == RecognizerCompatibilityStatus.NO_CAMERA) {
    Toast.makeText(this, "BlinkID is supported only via Direct API!", Toast.LENGTH_LONG).show();
} else if (status == RecognizerCompatibilityStatus.PROCESSOR_ARCHITECTURE_NOT_SUPPORTED) {
    Toast.makeText(this, "BlinkID is not supported on current processor architecture!", Toast.LENGTH_LONG).show();
} else {
    Toast.makeText(this, "BlinkID is not supported! Reason: " + status.name(), Toast.LENGTH_LONG).show();
}
```

##### Kotlin
```kotlin
// check if _BlinkID_ is supported on the device,
when (val status = RecognizerCompatibility.getRecognizerCompatibilityStatus(this)) {
    RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED -> {
        Toast.makeText(this, "BlinkID is supported!", Toast.LENGTH_LONG).show()
    }
    RecognizerCompatibilityStatus.NO_CAMERA -> {
        Toast.makeText(this, "BlinkID is supported only via Direct API!", Toast.LENGTH_LONG).show()
    }
    RecognizerCompatibilityStatus.PROCESSOR_ARCHITECTURE_NOT_SUPPORTED -> {
        Toast.makeText(this, "BlinkID is not supported on current processor architecture!", Toast.LENGTH_LONG).show()
    }
    else -> {
        Toast.makeText(this, "BlinkID is not supported! Reason: " + status.name, Toast.LENGTH_LONG).show()
    }
}
```
Some recognizers require camera with autofocus. If you try using them on a device that doesn't support autofocus, you will get an error. To prevent that, you can check whether a recognizer requires autofocus by calling its [requiresAutofocus](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/Recognizer.html#requiresAutofocus()) method.

If you already have an array of recognizers, you can easily filter out recognizers that require autofocus from array using the following code snippet:

##### Java

```java
Recognizer[] recArray = ...;
if(!RecognizerCompatibility.cameraHasAutofocus(CameraType.CAMERA_BACKFACE, this)) {
    recArray = RecognizerUtils.filterOutRecognizersThatRequireAutofocus(recArray);
}
```

##### Kotlin
```kotlin
var recArray: Array<Recognizer> = ...
if(!RecognizerCompatibility.cameraHasAutofocus(CameraType.CAMERA_BACKFACE, this)) {
    recArray = RecognizerUtils.filterOutRecognizersThatRequireAutofocus(recArray)
}
```

# <a name="ui-customizations"></a> _BlinkID_ SDK integration levels

You can integrate _BlinkID_ into your app in five different ways, depending on your use case and customisation needs:

1. One line document scanning (`OneSideDocumentScan` and `TwoSideDocumentScan`) - SDK handles everything and you just need to start our built-in activity and handle result, no customisation options
2. Built-in activities (`UISettings`) - SDK handles most of the work, you just need to define a recognizer, settings, start our built-in activity and handle result, customisation options are limited
3. Built-in fragment (`RecognizerRunnerFragment`) - reuse scanning UX from our built-in activities in your own activity
4. Custom UX (`RecognizerRunnerView`) - SDK handles camera management while you have to implement completely custom scanning UX
5. Direct Api (`RecognizerRunner`) - SKD only handles recognition while you have to provide it with the images, either from camera or from a file

## One line document scanning (`OneSideDocumentScan` and `TwoSideDocumentScan`)

`OneSideDocumentScan` and `TwoSideDocumentScan` are classes that contain all of the necessary setting definitions in order to quickly start SDK's built-in scan activities. It allows the user to skip all of the setup steps like `UISettings` and `RecognizerBundle` and go directly to scanning.

As shown in the [Performing your first scan](#first-scan) requires just the definition of a result listener, to define what is going to happen with the scan results, and calling the actual scanning function.

## <a name="run-builtin-activity"></a> Built-in activities (`UISettings`)

`UISettings` is a class that contains all the necessary settings for SDK's built-in scan activities. It configures scanning activity behaviour, strings, icons and other UI elements.
You should use [`ActivityRunner`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/uisettings/ActivityRunner.html) to start the scan activity configured by `UISettings`, shown in the example below.

We provide multiple `UISettings` classes specialised for different scanning scenarios. Each `UISettings` object has properties which can be changed via appropriate setter methods. For example, you can customise camera settings with `setCameraSettings` metod.

All available `UISettings` classes are listed [here](#built-in-ui-components).

1. In your main activity, create recognizer objects that will perform image recognition, configure them and put them into [RecognizerBundle object](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/RecognizerBundle.html). You can see more information about available recognizers and `RecognizerBundle` [here](#available-recognizers).

   For example, to scan supported document, configure your recognizer like this:

   ##### Java
    ```java
    public class MyActivity extends Activity {
        private BlinkIdMultiSideRecognizer mRecognizer;
        private RecognizerBundle mRecognizerBundle;
        
        @Override
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            
            // setup views, as you would normally do in onCreate callback
            
            // create BlinkIdMultiSideRecognizer
            mRecognizer = new BlinkIdMultiSideRecognizer();
            
            // bundle recognizers into RecognizerBundle
            mRecognizerBundle = new RecognizerBundle(mRecognizer);
        }
    }
    ```

   ##### Kotlin
   ```kotlin
   public class MyActivity : Activity() {
       private lateinit var mRecognizer: BlinkIdMultiSideRecognizer
       private lateinit var mRecognizerBundle: RecognizerBundle

       override fun onCreate(bundle: Bundle) {
           
           // setup views, as you would normally do in onCreate callback  
           
           // create BlinkIdMultiSideRecognizer
           mRecognizer = BlinkIdMultiSideRecognizer()
           
           // build recognizers into RecognizerBundle
           mRecognizerBundle = RecognizerBundle(mRecognizer)
       } 
   }
   ```

2. Start recognition process by creating `BlinkIdUISettings` and calling [`ActivityRunner.startActivityForResult`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/uisettings/ActivityRunner.html#startActivityForResult(android.app.Activity,int,com.microblink.blinkid.uisettings.UISettings)):

   ##### Java
    ```java
    // method within MyActivity from previous step
    public void startScanning() {
        // Settings for BlinkIdActivity
        BlinkIdUISettings settings = new BlinkIdUISettings(mRecognizerBundle);
        
        // tweak settings as you wish
        
        // Start activity
        ActivityRunner.startActivityForResult(this, MY_REQUEST_CODE, settings);
    }
    ```

   ##### Kotlin
    ```kotlin
    // method within MyActivity from previous step
    public fun startScanning() {
        // Settings for BlinkIdActivity
        val settings = BlinkIdUISettings(mRecognizerBundle)
        
        // tweak settings as you wish
        
        // Start activity
        ActivityRunner.startActivityForResult(this, MY_REQUEST_CODE, settings)
    }
    ```

3. `onActivityResult` will be called in your activity after scanning is finished, here you can get the scanning results.

   ##### Java
    ```java
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                // load the data into all recognizers bundled within your RecognizerBundle
                mRecognizerBundle.loadFromIntent(data);
                
                // now every recognizer object that was bundled within RecognizerBundle
                // has been updated with results obtained during scanning session
                
                // you can get the result by invoking getResult on recognizer
                BlinkIdMultiSideRecognizer.Result result = mRecognizer.getResult();
                if (result.getResultState() == Recognizer.Result.State.Valid) {
                    // result is valid, you can use it however you wish
                }
            }
        }
    }
    ```

   ##### Kotlin
    ```kotlin
    override protected fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data);
        
        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                // load the data into all recognizers bundled within your RecognizerBundle
                mRecognizerBundle.loadFromIntent(data)
                
                // now every recognizer object that was bundled within RecognizerBundle
                // has been updated with results obtained during scanning session
                
                // you can get the result by invoking getResult on recognizer
                val result = mRecognizer.result
                if (result.resultState == Recognizer.Result.State.Valid) {
                    // result is valid, you can use it however you wish
                }
            }
        }
    }
    ```

   For more information about available recognizers and `RecognizerBundle`, see [RecognizerBundle and available recognizers](#available-recognizers).
## <a name="recognizer-runner-fragment"></a> Built-in fragment (`RecognizerRunnerFragment`)

If you want to reuse our built-in activity UX inside your own activity, use [`RecognizerRunnerFragment`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/fragment/RecognizerRunnerFragment.html). Activity that will host `RecognizerRunnerFragment` must implement [`ScanningOverlayBinder`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/fragment/RecognizerRunnerFragment.ScanningOverlayBinder.html) interface. Attempting to add `RecognizerRunnerFragment` to activity that does not implement that interface will result in `ClassCastException`.

The `ScanningOverlayBinder` is responsible for returning `non-null` implementation of [`ScanningOverlay`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/fragment/overlay/ScanningOverlay.html) - class that will manage UI on top of `RecognizerRunnerFragment`. It is not recommended to create your own `ScanningOverlay` implementation, use one of our implementations listed [here](#built-in-ui-components) instead.

Here is the minimum example for activity that hosts the `RecognizerRunnerFragment`:

##### Java

```java
public class MyActivity extends AppCompatActivity implements RecognizerRunnerFragment.ScanningOverlayBinder {
    private BlinkIdMultiSideRecognizer mRecognizer;
    private RecognizerBundle mRecognizerBundle;
    private BlinkIdOverlayController mScanOverlay;
    private RecognizerRunnerFragment mRecognizerRunnerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate();
        setContentView(R.layout.activity_my_activity);
        mScanOverlay = createOverlay();
        if (null == savedInstanceState) {
            // create fragment transaction to replace R.id.recognizer_runner_view_container with RecognizerRunnerFragment
            mRecognizerRunnerFragment = new RecognizerRunnerFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.recognizer_runner_view_container, mRecognizerRunnerFragment);
            fragmentTransaction.commit();
        } else {
            // obtain reference to fragment restored by Android within super.onCreate() call
            mRecognizerRunnerFragment = (RecognizerRunnerFragment) getSupportFragmentManager().findFragmentById(R.id.recognizer_runner_view_container);
        }
    }

    @Override
    @NonNull
    public ScanningOverlay getScanningOverlay() {
        return mScanOverlay;
    }

    private BlinkIdOverlayController createOverlay() {
        // create BlinkIdMultiSideRecognizer
        mRecognizer = new BlinkIdMultiSideRecognizer();

        // bundle recognizers into RecognizerBundle
        mRecognizerBundle = new RecognizerBundle(mRecognizer);

        BlinkIdUISettings settings = new BlinkIdUISettings(mRecognizerBundle);

        return settings.createOverlayController(this, mScanResultListener);
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
        @Override
        public void onUnrecoverableError(@NonNull Throwable throwable) {
        }
    };
    
}
```

##### Kotlin Compose

```kotlin
package com.microblink.blinkid

class MainActivity : AppCompatActivity(), RecognizerRunnerFragment.ScanningOverlayBinder {
    private lateinit var mRecognizer: BlinkIdMultiSideRecognizer
    private lateinit var mRecognizerRunnerFragment: RecognizerRunnerFragment
    private lateinit var mRecognizerBundle: RecognizerBundle
    private lateinit var mScanOverlay: BlinkIdOverlayController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!::mScanOverlay.isInitialized) {
            mScanOverlay = createOverlayController()
        }
        setContent {
            this.run {
                // viewBinding has to be set to 'true' in buildFeatures block of the build.gradle file
                AndroidViewBinding(RecognizerRunnerLayoutBinding::inflate) {
                    mRecognizerRunnerFragment =
                        fragmentContainerView.getFragment<RecognizerRunnerFragment>()
                }
            }
        }
    }

    override fun getScanningOverlay(): ScanningOverlay {
        return mScanOverlay
    }

    private fun createOverlay(): BlinkIdOverlayController {
        // create BlinkIdMultiSideRecognizer
        val mRecognizer = BlinkIdMultiSideRecognizer()

        // bundle recognizers into RecognizerBundle
        mRecognizerBundle = RecognizerBundle(mRecognizer)

        val settings = BlinkIdUISettings(mRecognizerBundle)

        return settings.createOverlayController(this, mScanResultListener)
    }

    private val mScanResultListener: ScanResultListener = object : ScanResultListener {
        override fun onScanningDone(p0: RecognitionSuccessType) {
            // pause scanning to prevent new results while fragment is being removed
            mRecognizerRunnerFragment!!.recognizerRunnerView!!.pauseScanning()

            // now you can remove the RecognizerRunnerFragment with new fragment transaction
            // and use result within mRecognizer safely without the need for making a copy of it

            // if not paused, as soon as this method ends, RecognizerRunnerFragments continues
            // scanning. Note that this can happen even if you created fragment transaction for
            // removal of RecognizerRunnerFragment - in the time between end of this method
            // and beginning of execution of the transaction. So to ensure result within mRecognizer
            // does not get mutated, ensure calling pauseScanning() as shown above.
        }
        override fun onUnrecoverableError(p0: Throwable) {
        }
    }
    
}
```
Please refer to sample apps provided with the SDK for more detailed example and make sure your host activity's orientation is set to `nosensor` or has configuration changing enabled (i.e. is not restarted when configuration change happens). For more information, check [scan orientation section](#scan-orientation).

## <a name="recognizer-runner-view"></a> Custom UX with `RecognizerRunnerView`
This section discusses how to embed [RecognizerRunnerView](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/view/recognition/RecognizerRunnerView.html) into your scan activity and perform scan.

1. First make sure that `RecognizerRunnerView` is a member field in your activity. This is required because you will need to pass all activity's lifecycle events to `RecognizerRunnerView`.
2. It is recommended to keep your scan activity in one orientation, such as `portrait` or `landscape`. Setting `sensor` as scan activity's orientation will trigger full restart of activity whenever device orientation changes. This will provide very poor user experience because both camera and _BlinkID_ native library will have to be restarted every time. There are measures against this behaviour that are discussed [later](#scan-orientation).
3. In your activity's `onCreate` method, create a new `RecognizerRunnerView`, set [RecognizerBundle](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/RecognizerBundle.html) containing recognizers that will be used by the view, define [CameraEventsListener](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/view/CameraEventsListener.html) that will handle mandatory camera events, define [ScanResultListener](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/view/recognition/ScanResultListener.html) that will receive call when recognition has been completed and then call its `create` method. After that, add your views that should be layouted on top of camera view.
4. Pass in your activity's lifecycle using `setLifecycle` method to enable automatic handling of lifeceycle events.
 
Here is the minimum example of integration of `RecognizerRunnerView` as the only view in your activity:

```java
public class MyScanActivity extends AppCompatActivity {
    private static final int PERMISSION_CAMERA_REQUEST_CODE = 42;
    private RecognizerRunnerView mRecognizerRunnerView;
    private BlinkIdMultiSideRecognizer mRecognizer;
    private RecognizerBundle mRecognizerBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create BlinkIdMultiSideRecognizer
        mRecognizer = new BlinkIdMultiSideRecognizer();

        // bundle recognizers into RecognizerBundle
        mRecognizerBundle = new RecognizerBundle(mRecognizer);
        // create RecognizerRunnerView
        mRecognizerRunnerView = new RecognizerRunnerView(this);
        
        // set lifecycle to automatically call recognizer runner view lifecycle methods
        mRecognizerRunnerView.setLifecycle(getLifecycle());

        // associate RecognizerBundle with RecognizerRunnerView
        mRecognizerRunnerView.setRecognizerBundle(mRecognizerBundle);

        // scan result listener will be notified when scanning is complete
        mRecognizerRunnerView.setScanResultListener(mScanResultListener);
        // camera events listener will be notified about camera lifecycle and errors
        mRecognizerRunnerView.setCameraEventsListener(mCameraEventsListener);

        setContentView(mRecognizerRunnerView);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // changeConfiguration is not handled by lifecycle events so call it manually
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

            BlinkIdMultiSideRecognizer.Result result = mRecognizer.getResult();
            if (result.getResultState() == Recognizer.Result.State.Valid) {
                // result is valid, you can use it however you wish
            }

            // Note that mRecognizer is stateful object and that as soon as
            // scanning either resumes or its state is reset
            // the result object within mRecognizer will be changed. If you
            // need to create a immutable copy of the result, you can do that
            // by calling clone() on it, for example:

            BlinkIdMultiSideRecognizer.Result immutableCopy = result.clone();

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
#### <a name="scan-orientation"></a> Scan activity's orientation

If activity's `screenOrientation` property in `AndroidManifest.xml` is set to `sensor`, `fullSensor` or similar, activity will be restarted every time device changes orientation from portrait to landscape and vice versa. While restarting activity, its `onPause`, `onStop` and `onDestroy` methods will be called and then new activity will be created anew. This is a potential problem for scan activity because in its lifecycle it controls both camera and native library - restarting the activity will trigger both restart of the camera and native library. This is a problem because changing orientation from landscape to portrait and vice versa will be very slow, thus degrading a user experience. **We do not recommend such setting.**

For that matter, we recommend setting your scan activity to either `portrait` or `landscape` mode and handle device orientation changes manually. To help you with this, `RecognizerRunnerView` supports adding child views to it that will be rotated regardless of activity's `screenOrientation`. You add a view you wish to be rotated (such as view that contains buttons, status messages, etc.) to `RecognizerRunnerView` with [addChildView](#{javadocUrl}(com/microblink/blinkid/view/CameraViewGroup.html#addChildView(android.view.View,boolean))) method. The second parameter of the method is a boolean that defines whether the view you are adding will be rotated with device. To define allowed orientations, implement [OrientationAllowedListener](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/view/OrientationAllowedListener.html) interface and add it to `RecognizerRunnerView` with method `setOrientationAllowedListener`. **This is the recommended way of rotating camera overlay.**

However, if you really want to set `screenOrientation` property to `sensor` or similar and want Android to handle orientation changes of your scan activity, then we recommend to set `configChanges` property of your activity to `orientation|screenSize`. This will tell Android not to restart your activity when device orientation changes. Instead, activity's `onConfigurationChanged` method will be called so that activity can be notified of the configuration change. In your implementation of this method, you should call `changeConfiguration` method of `RecognizerView` so it can adapt its camera surface and child views to new configuration.
## <a name="direct-api"></a> Direct API

This section will describe how to use direct API to recognize android Bitmaps without the need for camera. You can use direct API anywhere from your application, not just from activities.

Image recognition performance highly depends on the quality of the input images. When our camera management is used (scanning from a camera), we do our best to get camera frames with the best possible quality for the used device. On the other hand, when Direct API is used, you need to provide high-quality images without blur and glare for successful recognition.

### <a name="direct-api-images"></a> Using Direct API for recognition of Android Bitmaps and custom camera frames

1. First, you need to obtain reference to [RecognizerRunner singleton](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html) using [getSingletonInstance](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#getSingletonInstance()).
2. Second, you need to [initialize the recognizer runner](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#initialize(android.content.Context,com.microblink.blinkid.entities.recognizers.RecognizerBundle,com.microblink.blinkid.directApi.DirectApiErrorListener)).
3. After initialization, you can use singleton to process:
 - **Still** Android `Bitmaps` obtained, for example, from the gallery. Use [recognizeBitmap](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#recognizeBitmap(android.graphics.Bitmap,com.microblink.blinkid.hardware.orientation.Orientation,com.microblink.blinkid.view.recognition.ScanResultListener)) or [recognizeBitmapWithRecognizers](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#recognizeBitmapWithRecognizers(android.graphics.Bitmap,com.microblink.blinkid.hardware.orientation.Orientation,com.microblink.blinkid.geometry.Rectangle,com.microblink.blinkid.view.recognition.ScanResultListener,com.microblink.blinkid.entities.recognizers.RecognizerBundle)).
 - **Video** `Images` that are [built from custom camera video frames](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/image/ImageBuilder.html), for example, when you use your own or third party camera management. Recognition will be optimized for speed and will rely on time-redundancy between consecutive video frames in order to yield best possible recognition result. Use [recognizeVideoImage](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#recognizeVideoImage(com.microblink.blinkid.image.InputImage,com.microblink.blinkid.view.recognition.ScanResultListener)) or [recognizeVideoImageWithRecognizers](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#recognizeVideoImageWithRecognizers(com.microblink.blinkid.image.InputImage,com.microblink.blinkid.view.recognition.ScanResultListener,com.microblink.blinkid.entities.recognizers.RecognizerBundle)).
 - **Still** `Images` when you need thorough scanning of single or few images which are not part of the video stream and you want to get best possible results from the single `InputImage`. [InputImage](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/image/InputImage.html) type comes from our SDK or it can be created by using [ImageBuilder](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/image/ImageBuilder.html). Use [recognizeStillImage](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#recognizeStillImage(com.microblink.blinkid.image.InputImage,com.microblink.blinkid.view.recognition.ScanResultListener)) or [recognizeStillImageWithRecognizers](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#recognizeStillImageWithRecognizers(com.microblink.blinkid.image.InputImage,com.microblink.blinkid.view.recognition.ScanResultListener,com.microblink.blinkid.entities.recognizers.RecognizerBundle)). 

4. When you want to delete all cached data from multiple recognitions, for example when you want to scan other document and/or restart scanning, you need to [reset the recognition state](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#resetRecognitionState()).
5. Do not forget to [terminate](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#terminate()) the recognizer runner singleton after usage (it is a shared resource).

Here is the minimum example of usage of direct API for recognizing android Bitmap:

```java
public class DirectAPIActivity extends Activity {
    private RecognizerRunner mRecognizerRunner;
    private BlinkIdMultiSideRecognizer mRecognizer;
    private RecognizerBundle mRecognizerBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate();
        // initialize your activity here
        // create BlinkIdMultiSideRecognizer
        mRecognizer = new BlinkIdMultiSideRecognizer();

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

            BlinkIdMultiSideRecognizer.Result result = mRecognizer.getResult();
            if (result.getResultState() == Recognizer.Result.State.Valid) {
                // result is valid, you can use it however you wish
            }
        }
    };

}
```

[ScanResultListener.onScanningDone](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/view/recognition/ScanResultListener.html#onScanningDone(com.microblink.blinkid.recognition.RecognitionSuccessType)) method is called for each input image that you send to the recognition. You can call `RecognizerRunner.recognize*` method multiple times with different images of the same document for better reading accuracy until you get a successful result in the listener's `onScanningDone` method. This is useful when you are using your own or third-party camera management.

### <a name="direct-api-strings"></a> Using Direct API for `String` recognition (parsing)

Some recognizers support recognition from `String`. They can be used through Direct API to parse given `String` and return data just like when they are used on an input image. When recognition is performed on `String`, there is no need for the OCR. Input `String` is used in the same way as the OCR output is used when image is being recognized. 

Recognition from `String` can be performed in the same way as recognition from image, described in the [previous section](#direct-api-images).

The only difference is that one of the [RecognizerRunner singleton](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html) methods for recognition from string should be called:

- [recognizeString](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#recognizeString(java.lang.String,com.microblink.blinkid.view.recognition.ScanResultListener))
- [recognizeStringWithRecognizers](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#recognizeStringWithRecognizers(java.lang.String,com.microblink.blinkid.view.recognition.ScanResultListener,com.microblink.blinkid.entities.recognizers.RecognizerBundle))


### <a name="direct-api-state-machine"></a> Understanding DirectAPI's state machine

Direct API's `RecognizerRunner` singleton is a state machine that can be in one of 3 states: `OFFLINE`, `READY` and `WORKING`.

- When you obtain the reference to `RecognizerRunner` singleton, it will be in `OFFLINE` state. 
- You can initialize `RecognizerRunner` by calling [initialize](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#initialize(android.content.Context,com.microblink.blinkid.entities.recognizers.RecognizerBundle,com.microblink.blinkid.directApi.DirectApiErrorListener)) method. If you call `initialize` method while `RecognizerRunner` is not in `OFFLINE` state, you will get `IllegalStateException`.
- After successful initialization, `RecognizerRunner` will move to `READY` state. Now you can call any of the `recognize*` methods.
- When starting recognition with any of the `recognize*` methods, `RecognizerRunner` will move to `WORKING` state. If you attempt to call these methods while `RecognizerRunner` is not in `READY` state, you will get `IllegalStateException`
- Recognition is performed on background thread so it is safe to call all `RecognizerRunner's` methods from UI thread
- When recognition is finished, `RecognizerRunner` first moves back to `READY` state and then calls the [onScanningDone](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/view/recognition/ScanResultListener.html#onScanningDone(com.microblink.blinkid.recognition.RecognitionSuccessType)) method of the provided [`ScanResultListener`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/view/recognition/ScanResultListener.html). 
- Please note that `ScanResultListener`'s [`onScanningDone`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/view/recognition/ScanResultListener.html#onScanningDone(com.microblink.blinkid.recognition.RecognitionSuccessType)) method will be called on background processing thread, so make sure you do not perform UI operations in this callback. Also note that until the `onScanningDone` method completes, `RecognizerRunner` will not perform recognition of another image or string, even if any of the `recognize*` methods have been called just after transitioning to `READY` state. This is to ensure that results of the recognizers bundled within `RecognizerBundle` associated with `RecognizerRunner` are not modified while possibly being used within `onScanningDone` method.
- By calling [`terminate`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#terminate()) method, `RecognizerRunner` singleton will release all its internal resources. Note that even after calling `terminate` you might receive `onScanningDone` event if there was work in progress when `terminate` was called.
- `terminate` method can be called from any `RecognizerRunner` singleton's state
- You can observe `RecognizerRunner` singleton's state with method [`getCurrentState`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#getCurrentState())

### <a name="direct-api-with-recognizer"></a> Using Direct API while RecognizerRunnerView is active
Both [RecognizerRunnerView](#recognizer-runner-view) and `RecognizerRunner` use the same internal singleton that manages native code. This singleton handles initialization and termination of native library and propagating recognizers to native library. It is possible to use `RecognizerRunnerView` and `RecognizerRunner` together, as internal singleton will make sure correct synchronization and correct recognition settings are used. If you run into problems while using `RecognizerRunner` in combination with `RecognizerRunnerView`, [let us know](http://help.microblink.com)!


### <a name="direct-api-combined-recognizers"></a> Using Direct API with combined recognizers 

When you are using combined recognizer and images of both document sides are required, you need to call `RecognizerRunner.recognize*` multiple times. Call it first with the images of the first side of the document, until it is read, and then with the images of the second side. The combined recognizer automatically switches to second side scanning, after it has successfully read the first side. To be notified when the first side scanning is completed, you have to set the [FirstSideRecognitionCallback](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/metadata/recognition/FirstSideRecognitionCallback.html) through [MetadataCallbacks](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/metadata/MetadataCallbacks.html). If you don't need that information, e.g. when you have only one image for each document side, don't set the `FirstSideRecognitionCallback` and check the [RecognitionSuccessType](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/recognition/RecognitionSuccessType.html) in [ScanResultListener.onScanningDone](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/view/recognition/ScanResultListener.html#onScanningDone(com.microblink.blinkid.recognition.RecognitionSuccessType)), after the second side image has been processed.

# <a name="built-in-ui-components"></a> Available built-in activities and overlays
## <a name="blinkid-ui-component"></a> `BlinkIdUISettings` and `BlinkIdOverlayController`

[`BlinkIdOverlayController`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/fragment/overlay/blinkid/BlinkIdOverlayController.html) implements new UI for scanning identity documents, which is optimally designed to be used with new [`BlinkIdMultiSideRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/blinkid/generic/BlinkIdMultiSideRecognizer.html) and [`BlinkIdSingleSideRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/blinkid/generic/BlinkIdSingleSideRecognizer.html). It implements several new features:

* clear indication for searching phase, when BlinkID is searching for an ID document
* clear progress indication, when BlinkID is busy with OCR and data extraction
* clear message when the document is not supported
* visual indications when the user needs to place the document closer to the camera
* when BlinkIdMultiSideRecognizer is used, visual indication that the data from the front side of the document doesn't match the data on the back side of the document.

The new UI allows the user to scan the document at an any angle, in any orientation. We recommend forcing landscape orientation if you scan barcodes on the back side, because in that orientation success rate will be higher. 

To launch a built-in activity that uses `BlinkIdOverlayController` use [`BlinkIdUISettings`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/uisettings/BlinkIdUISettings.html).

### Scan overlay theming
  <img src="https://raw.githubusercontent.com/wiki/blinkid/blinkid-android/images/reticle_overlay_customisation.png" alt="BlinkID SDK">

To customise overlay, provide your custom style resource via [`BlinkIdUISettings.setOverlayViewStyle()`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/uisettings/BlinkIdUISettings.html#setOverlayViewStyle(int)) method or via [`ReticleOverlayView`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/fragment/overlay/blinkid/reticleui/ReticleOverlayView.html) constructor. You can customise elements labeled on screenshots above by providing the following attributes in your style:

**exit**

* `mb_exitScanDrawable` - icon drawable
* note that you can disable this element by using [`BlinkIdUISettings.setShowCancelButton(false)`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/uisettings/BlinkIdUISettings.html#setShowCancelButton(boolean))

**torch**

* `mb_torchOnDrawable` - icon drawable that is shown when the torch is enabled
* `mb_torchOffDrawable` - icon drawable that is show when the torch is disabled
* note that you can disable this element by using [`BlinkIdUISettings.setShowTorchButton(false)`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/uisettings/BlinkIdUISettings.html#setShowTorchButton(boolean))

**instructions**

* `mb_instructionsTextAppearance` - style that will be used as `android:textAppearance`
* `mb_instructionsBackgroundDrawable` - drawable used for background
* `mb_instructionsBackgroundColor` - color used for background

**flashlight warning**

* `mb_flashlightWarningTextAppearance` - style that will be used as `android:textAppearance`
* `mb_flashlightWarningBackgroundDrawable` - drawable used for background
* note that you can disable this element by using [`BlinkIdUISettings.setShowFlashlightWarning(false)`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/uisettings/BlinkIdUISettings.html#setShowFlashlightWarning(boolean))

**card icon**

* `mb_cardFrontDrawable` - icon drawable shown during card flip animation, representing front side of the card
* `mb_cardBackDrawable` - icon drawable shown during card flip animation, representing back side of the card

**reticle**

* `mb_reticleDefaultDrawable` - drawable shown when reticle is in neutral state
* `mb_reticleSuccessDrawable` - drawable shown when reticle is in success state (scanning was successful)
* `mb_reticleErrorDrawable` - drawable shown when reticle is in error state
* `mb_reticleColor` - color used for rotating reticle element
* `mb_reticleDefaultColor` - color used for reticle in neutral state
* `mb_reticleErrorColor` - color used for reticle in error state
* `mb_successFlashColor` - color used for flash effect on successful scan


### Introduction dialog and onboarding dialog
To customize the visibility and style of these two dialogs, use methods provided in `BlinkIdUISettings`.

<p align="center" >
  <img src="https://raw.githubusercontent.com/wiki/blinkid/blinkid-android/images/introduction_onboarding_overlay.png" alt="BlinkId SDK">
</p>

The method for controlling the visibility of the **introduction dialog** is [`BlinkIdUISettings.setShowIntroductionDialog(boolean showIntroductionDialog)`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/uisettings/BlinkIdUISettings.html#setShowIntroductionDialog(boolean)) and it is set to true by default, meaning the introduction dialog will be shown.

The method for controlling the visibility of the **onboarding dialog** is [`BlinkIdUISettings.setShowOnboardingInfo(boolean showOnboardingInfo)`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/uisettings/BlinkIdUISettings.html#setShowOnboardingInfo(boolean)) and it is set to true by default, meaning the introduction dialog will be shown.

There is also a method for controlling the delay of the **"Show help?" tooltip** that is shown above the help button. The button itself will be shown if the previous method for showing onboarding is true.
The method for setting the delay length of the tooltip is [`BlinkIdUISettings.setShowTooltipTimeIntervalMs(long showTooltipTimeIntervalMs)`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/uisettings/BaseBlinkIdUiSettings.html#setShowTooltipTimeIntervalMs(long)). Time parameter is set in milliseconds.

The default setting of the delay is 12 seconds (12000 milliseconds).

Customizing and theming these introduction and onboarding elements can be done in the same way as explained in the previous chapter, by providing the following attributes:

**help button**
* `mb_helpButtonDrawable` - drawable that is shown when help button is enabled
* `mb_helpButtonBackgroundColor` - color used for help button background
* `mb_helpButtonQuestionmarkColor` - color used for help button foreground
* note that this element is disabled if onboarding screens are disabled

**help tooltip**
* `mb_helpTooltipBackground` - drawable that is shown as a background when help tooltip pops up
* `mb_helpTooltipColor` - color used for help tooltip background
* `mb_helpTooltipTextAppearance` - style that will be used as `android:textAppearance`

**introduction dialog**
* `mb_introductionBackgroundColor` - color used for introduction screen background
* `mb_introductionTitleTextAppearance` - style that will be used as `android:textAppearance`
* `mb_introductionMessageTextAppearance` - style that will be used as `android:textAppearance`
* `mb_introductionButtonTextAppearance` - style that will be used as `android:textAppearance`
* note that you can disable this element by using [`BlinkIdUISettings.setShowIntroductionDialog(false)`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/uisettings/BlinkIdUISettings.html#setShowIntroductionDialog(boolean))

**onboarding dialog**
*  `mb_onboardingBackgroundColor` - color used for onboarding screens background
* `mb_onboardingPageIndicatorColor` - color used for circular page indicators in onboarding screens
* `mb_onboardingTitleTextAppearance` - style that will be used as `android:textAppearance`
* `mb_onboardingMessageTextAppearance` - style that will be used as `android:textAppearance`
* `mb_onboardingButtonTextAppearance` - style that will be used as `android:textAppearance`
* note that you can disable this element by using [`BlinkIdUISettings.setShowOnboardingInfo(false)`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/uisettings/BlinkIdUISettings.html#setShowOnboardingInfo(boolean))

### Alert dialog
<img src="https://raw.githubusercontent.com/wiki/blinkid/blinkid-android/images/alert_dialog_overlay.png" alt="BlinkID SDK Alert dialog">

Alert dialogs called by the SDK have their own set of properties that can be modified in `styles.xml`.

`MB_alert_dialog` is a theme that extends `Theme.AppCompat.Light.Dialog.Alert` theme and uses the application theme's default colors.
In order to change the attributes in these alert dialogs without changing other attributes in user's application, `MB_alert_dialog` theme needs to be overwritten.
```xml
<style name="MB_alert_dialog" parent="Theme.AppCompat.Light.Dialog.Alert">
    <item name="android:textSize">TEXT_SIZE</item>
    <item name="android:background">COLOR</item>
    <item name="android:textColorPrimary">COLOR</item>
    <item name="colorAccent">COLOR</item>
</style>
```

The attributes that are not overwritten are going to use application theme's default colors and sizes.

`colorAccent` attibute is used to change the color of the alert dialog button. If the application theme's `colorAccent` attribute is changed someplace else, this alert dialog button color will also be changed.
However, overwriting `MB_alert_dialog` theme and this attribute within it will assure that only the button color in Microblink SDK's alert dialog is changed.
If the application theme extends a theme from the `MaterialComponents` set (e.g. `Theme.MaterialComponents.Light.NoActionBar`), the aforementioned button color may only be changed by overwriting `colorOnPrimary` attribute instead of `colorAccent` attribute.
## <a name="document-ui-component"></a> `DocumentUISettings`

[`DocumentUISettings`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/uisettings/DocumentUISettings.html) launches activity that uses `BlinkIdOverlayController` with alternative UI. It is best suited for scanning single document side of various card documents and it shouldn't be used with combined recognizers as it provides no user instructions on when to switch to the back side.

## <a name="legacy-document-verify-ui-component"></a> `LegacyDocumentVerificationUISettings`

[`LegacyDocumentVerificationUISettings`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/uisettings/LegacyDocumentVerificationUISettings.html) launches activity that uses `BlinkIdOverlayController` with alternative UI. It is best suited for **combined recognizers** because it manages scanning of multiple document sides in the single camera opening and guides the user through the scanning process. It can also be used for single side scanning of ID cards, passports, driver's licenses, etc.
## <a name="translation"></a> Translation and localization

Strings used within built-in activities and overlays can be localized to any language. If you are using `RecognizerRunnerView` ([see this chapter for more information](#recognizerRunnerView)) in your custom scan activity or fragment, you should handle localization as in any other Android app. `RecognizerRunnerView` does not use strings nor drawables, it only uses assets from `assets/microblink` folder. Those assets must not be touched as they are required for recognition to work correctly.

However, if you use our built-in activities or overlays, they will use resources packed within `LibBlinkID.aar` to display strings and images on top of the camera view. We have already prepared strings for several languages which you can use out of the box. You can also modify those strings, or you can add your own language.

To use a language, you have to enable it from the code:
        
* To use a certain language, on application startup, before opening any UI component from the SDK, you should call method `LanguageUtils.setLanguageAndCountry(language, country, context)`. For example, you can set language to Croatian like this:
    
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

# <a name="processing-events"></a> Handling processing events with `RecognizerRunner` and `RecognizerRunnerView`

Processing events, also known as _Metadata callbacks_ are purely intended for giving processing feedback on UI or to capture some debug information during development of your app using _BlinkID_ SDK. For that reason, built-in activities and fragments handle those events internally. If you need to handle those events yourself, you need to use either [RecognizerRunnerView](#recognizer-runner-view) or [RecognizerRunner](#direct-api).

Callbacks for all events are bundled into the [MetadataCallbacks](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/metadata/MetadataCallbacks.html) object. Both [RecognizerRunner](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html#setMetadataCallbacks(com.microblink.blinkid.metadata.MetadataCallbacks)) and [RecognizerRunnerView](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/view/recognition/RecognizerRunnerView.html#setMetadataCallbacks(com.microblink.blinkid.metadata.MetadataCallbacks)) have methods which allow you to set all your callbacks.

We suggest that you check for more information about available callbacks and events to which you can handle in the [javadoc for MetadataCallbacks class](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/metadata/MetadataCallbacks.html).

Please note that both those methods need to pass information about available callbacks to the native code and for efficiency reasons this is done at the time `setMetadataCallbacks` method is called and **not every time** when change occurs within the `MetadataCallbacks` object. This means that if you, for example, set `QuadDetectionCallback` to `MetadataCallbacks` **after** you already called `setMetadataCallbacks` method, the `QuadDetectionCallback` will not be registered with the native code and you will not receive its events.

Similarly, if you, for example, remove the `QuadDetectionCallback` from `MetadataCallbacks` object **after** you already called `setMetadataCallbacks` method, your app will crash with `NullPointerException` when our processing code attempts to invoke the method on removed callback (which is now set to `null`). We **deliberately** do not perform `null` check here because of two reasons:

- it is inefficient
- having `null` callback, while still being registered to native code is illegal state of your program and it should therefore crash

**Remember**, each time you make some changes to `MetadataCallbacks` object, you need to apply those changes to to your `RecognizerRunner` or `RecognizerRunnerView` by calling its `setMetadataCallbacks` method.

# <a name="available-recognizers"></a> `Recognizer` concept and `RecognizerBundle`

This section will first describe [what is a `Recognizer`](#recognizer-concept) and how it should be used to perform recognition of the images, videos and camera stream. Next, [we will describe how `RecognizerBundle`](#recognizer-bundle) can be used to tweak the recognition procedure and to transfer `Recognizer` objects between activities.

[RecognizerBundle](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/RecognizerBundle.html) is an object which wraps the [Recognizers](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/Recognizer.html) and defines settings about how recognition should be performed. Besides that, `RecognizerBundle` makes it possible to transfer `Recognizer` objects between different activities, which is required when using built-in activities to perform scanning, as described in first scan section, but is also handy when you need to pass `Recognizer` objects between your activities.

List of all available `Recognizer` objects, with a brief description of each `Recognizer`, its purpose and recommendations how it should be used to get best performance and user experience, can be found [here](#recognizer-list) .

## <a name="recognizer-concept"></a> The `Recognizer` concept

The [Recognizer](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/Recognizer.html) is the basic unit of processing within the _BlinkID_ SDK. Its main purpose is to process the image and extract meaningful information from it. As you will see [later](#recognizer-list), the _BlinkID_ SDK has lots of different `Recognizer` objects that have various purposes.

Each `Recognizer` has a `Result` object, which contains the data that was extracted from the image. The `Result` object is a member of corresponding `Recognizer` object and its lifetime is bound to the lifetime of its parent `Recognizer` object. If you need your `Result` object to outlive its parent `Recognizer` object, you must make a copy of it by calling its method [`clone()`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/Entity.Result.html#clone()).

Every `Recognizer` is a stateful object, that can be in two states: _idle state_ and _working state_. While in _idle state_, you can tweak `Recognizer` object's properties via its getters and setters. After you bundle it into a `RecognizerBundle` and use either [RecognizerRunner](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/directApi/RecognizerRunner.html) or [RecognizerRunnerView](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/view/recognition/RecognizerRunnerView.html) to _run_ the processing with all `Recognizer` objects bundled within `RecognizerBundle`, it will change to _working state_ where the `Recognizer` object is being used for processing. While being in _working state_, you cannot tweak `Recognizer` object's properties. If you need to, you have to create a copy of the `Recognizer` object by calling its [`clone()`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/Entity.html#clone()), then tweak that copy, bundle it into a new `RecognizerBundle` and use [`reconfigureRecognizers`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/view/recognition/RecognizerRunnerView.html#reconfigureRecognizers(com.microblink.blinkid.entities.recognizers.RecognizerBundle)) to ensure new bundle gets used on processing thread.

While `Recognizer` object works, it changes its internal state and its result. The `Recognizer` object's `Result` always starts in [Empty state](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/Recognizer.Result.State.html#Empty). When corresponding `Recognizer` object performs the recognition of given image, its `Result` can either stay in `Empty` state (in case `Recognizer` failed to perform recognition), move to [Uncertain state](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/Recognizer.Result.State.html#Uncertain) (in case `Recognizer` performed the recognition, but not all mandatory information was extracted), move to [StageValid state](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/Recognizer.Result.State.html#StageValid) (in case `Recognizer` successfully scanned one part/side of the document and there are more fields to extract) or move to [Valid state](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/Recognizer.Result.State.html#Valid) (in case `Recognizer` performed recognition and all mandatory information was successfully extracted from the image).

As soon as one `Recognizer` object's `Result` within `RecognizerBundle` given to `RecognizerRunner` or `RecognizerRunnerView` changes to `Valid` state, the [`onScanningDone`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/view/recognition/ScanResultListener.html#onScanningDone(com.microblink.blinkid.recognition.RecognitionSuccessType)) callback will be invoked on same thread that performs the background processing and you will have the opportunity to inspect each of your `Recognizer` objects' `Results` to see which one has moved to `Valid` state.

As already stated in [section about `RecognizerRunnerView`](#recognizerRunnerView), as soon as `onScanningDone` method ends, the `RecognizerRunnerView` will continue processing new camera frames with same `Recognizer` objects, unless [paused](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/view/recognition/RecognizerRunnerView.html#pauseScanning()). Continuation of processing or [resetting recognition](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/view/recognition/RecognizerRunnerView.html#resetRecognitionState()) will modify or reset all `Recognizer` objects's `Results`. When using built-in activities, as soon as `onScanningDone` is invoked, built-in activity pauses the `RecognizerRunnerView` and starts finishing the activity, while saving the `RecognizerBundle` with active `Recognizer` objects into `Intent` so they can be transferred back to the calling activities.


## <a name="recognizer-bundle"></a> `RecognizerBundle`

The [RecognizerBundle](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/RecognizerBundle.html) is wrapper around [Recognizers](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/Recognizer.html) objects that can be used to transfer `Recognizer` objects between activities and to give `Recognizer` objects to `RecognizerRunner` or `RecognizerRunnerView` for processing.

The `RecognizerBundle` is always [constructed with array](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/RecognizerBundle.html#RecognizerBundle(com.microblink.blinkid.entities.recognizers.Recognizer...)) of `Recognizer` objects that need to be prepared for recognition (i.e. their properties must be tweaked already). The _varargs_ constructor makes it easier to pass `Recognizer` objects to it, without the need of creating a temporary array.

The `RecognizerBundle` manages a chain of `Recognizer` objects within the recognition process. When a new image arrives, it is processed by the first `Recognizer` in chain, then by the second and so on, iterating until a `Recognizer` object's `Result` changes its state to `Valid` or all of the `Recognizer` objects in chain were invoked (none getting a `Valid` result state). If you want to invoke all `Recognizers` in the chain, regardless of whether some `Recognizer` object's `Result` in chain has changed its state to `Valid` or not, you can [allow returning of multiple results on a single image](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/RecognizerBundle.html#setAllowMultipleScanResultsOnSingleImage(boolean)).

You cannot change the order of the `Recognizer` objects within the chain - no matter the order in which you give `Recognizer` objects to `RecognizerBundle`, they are internally ordered in a way that provides best possible performance and accuracy. Also, in order for _BlinkID_ SDK to be able to order `Recognizer` objects in recognition chain in the best way possible, it is not allowed to have multiple instances of `Recognizer` objects of the same type within the chain. Attempting to do so will crash your application.

### <a name="intent-optimization"></a> Passing `Recognizer` objects between activities

Besides managing the chain of `Recognizer` objects, `RecognizerBundle` also manages transferring bundled `Recognizer` objects between different activities within your app. Although each `Recognizer` object, and each its `Result` object implements [Parcelable interface](https://developer.android.com/reference/android/os/Parcelable.html), it is not so straightforward to put those objects into [Intent](https://developer.android.com/reference/android/content/Intent.html) and pass them around between your activities and services for two main reasons:

- `Result` object is tied to its `Recognizer` object, which manages lifetime of the native `Result` object.
- `Result` object often contains large data blocks, such as images, which cannot be transferred via `Intent` because of [Android's Intent transaction data limit](https://developer.android.com/reference/android/os/TransactionTooLargeException.html).

Although the first problem can be easily worked around by making a [copy](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/Entity.Result.html#clone()) of the `Result` and transfer it independently, the second problem is much tougher to cope with. This is where, `RecognizerBundle's` methods [saveToIntent](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/blinkid/entities/util/IntentTransferableEntity.html#saveToIntent(android.content.Intent)) and [loadFromIntent](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/intent/IntentTransferableBundle.html#loadFromIntent(android.content.Intent)) come to help, as they ensure the safe passing of `Recognizer` objects bundled within `RecognizerBundle` between activities according to policy defined with method [`setIntentDataTransferMode`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/MicroblinkSDK.html#setIntentDataTransferMode(com.microblink.blinkid.intent.IntentDataTransferMode)):

- if set to [`STANDARD`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/intent/IntentDataTransferMode.html#STANDARD), the `Recognizer` objects will be passed via `Intent` using normal _Intent transaction mechanism_, which is limited by [Android's Intent transaction data limit](https://developer.android.com/reference/android/os/TransactionTooLargeException.html). This is same as manually putting `Recognizer` objects into `Intent` and is OK as long as you do not use `Recognizer` objects that produce images or other large objects in their `Results`.
- if set to [`OPTIMISED`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/intent/IntentDataTransferMode.html#OPTIMISED), the `Recognizer` objects will be passed via internal singleton object and no serialization will take place. This means that there is no limit to the size of data that is being passed. This is also the fastest transfer method, but it has a serious drawback - if Android kills your app to save memory for other apps and then later restarts it and redelivers `Intent` that should contain `Recognizer` objects, the internal singleton that should contain saved `Recognizer` objects will be empty and data that was being sent will be lost. You can easily provoke that condition by choosing _No background processes_ under _Limit background processes_ in your device's _Developer options_, and then switch from your app to another app and then back to your app.
- if set to [`PERSISTED_OPTIMISED`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/intent/IntentDataTransferMode.html#PERSISTED_OPTIMISED), the `Recognizer` objects will be passed via internal singleton object (just like in `OPTIMISED` mode) and will additionaly be serialized into a file in your application's private folder. In case Android restarts your app and internal singleton is empty after re-delivery of the `Intent`, the data will be loaded from file and nothing will be lost. The files will be automatically cleaned up when data reading takes place. Just like `OPTIMISED`, this mode does not have limit to the size of data that is being passed and does not have a drawback that `OPTIMISED` mode has, but some users might be concerned about files to which data is being written. 
    - These files **will** contain end-user's private data, such as image of the object that was scanned and the extracted data. Also these files **may** remain saved in your application's private folder until the next successful reading of data from the file. 
    - If your app gets restarted multiple times, only after first restart will reading succeed and will delete the file after reading. If multiple restarts take place, you must implement [`onSaveInstanceState`](https://developer.android.com/reference/android/app/Activity.html#onSaveInstanceState(android.os.Bundle)) and save bundle back to file by calling its [`saveState`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/RecognizerBundle.html#saveState()) method. Also, after saving state, you should ensure that you [clear saved state](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/RecognizerBundle.html#clearSavedState()) in your [`onResume`](https://developer.android.com/reference/android/app/Activity.html#onResume()), as [`onCreate`](https://developer.android.com/reference/android/app/Activity.html#onCreate(android.os.Bundle)) may not be called if activity is not restarted, while `onSaveInstanceState` may be called as soon as your activity goes to background (before `onStop`), even though activity may not be killed at later time. 
    - If saving data to file in private storage is a concern to you, you should use either `OPTIMISED` mode to transfer large data and image between activities or create your own mechanism for data transfer. Note that your application's private folder is only accessible by your application and your application alone, unless the end-user's device is rooted.

# <a name="recognizer-list"></a> List of available recognizers

This section will give a list of all `Recognizer` objects that are available within _BlinkID_ SDK, their purpose and recommendations how they should be used to get best performance and user experience.

## <a name="frame-grabber-recognizer"></a> Frame Grabber Recognizer

The [`FrameGrabberRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/framegrabber/FrameGrabberRecognizer.html) is the simplest recognizer in _BlinkID_ SDK, as it does not perform any processing on the given image, instead it just returns that image back to its [`FrameCallback`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/framegrabber/FrameCallback.html). Its [Result](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/framegrabber/FrameGrabberRecognizer.Result.html) never changes state from [Empty](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/Recognizer.Result.State.html#Empty).

This recognizer is best for easy capturing of camera frames with [`RecognizerRunnerView`](#recognizerRunnerView). Note that [`Image`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/image/Image.html) sent to [`onFrameAvailable`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/framegrabber/FrameCallback.html#onFrameAvailable(com.microblink.blinkid.image.Image,boolean,double)) are temporary and their internal buffers all valid only until the `onFrameAvailable` method is executing - as soon as method ends, all internal buffers of `Image` object are disposed. If you need to store `Image` object for later use, you must create a copy of it by calling [`clone`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/image/Image.html#clone()).

Also note that [`FrameCallback`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/framegrabber/FrameCallback.html) interface extends [Parcelable interface](https://developer.android.com/reference/android/os/Parcelable.html), which means that when implementing `FrameCallback` interface, you must also implement `Parcelable` interface. 

This is especially important if you plan to transfer `FrameGrabberRecognizer` between activities - in that case, keep in mind that the instance of your object may not be the same as the instance on which `onFrameAvailable` method gets called - the instance that receives `onFrameAvailable` calls is the one that is created within activity that is performing the scan.

## <a name="success-frame-grabber-recognizer"></a> Success Frame Grabber Recognizer

The [`SuccessFrameGrabberRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/successframe/SuccessFrameGrabberRecognizer.html) is a special `Recognizer` that wraps some other `Recognizer` and impersonates it while processing the image. However, when the `Recognizer` being impersonated changes its `Result` into `Valid` state, the `SuccessFrameGrabberRecognizer` captures the image and saves it into its own `Result` object.

Since `SuccessFrameGrabberRecognizer` impersonates its slave `Recognizer` object, it is not possible to give both concrete `Recognizer` object and `SuccessFrameGrabberRecognizer` that wraps it to same `RecognizerBundle` - doing so will have the same result as if you have given two instances of same `Recognizer` type to the `RecognizerBundle` - it will crash your application.

This recognizer is best for use cases when you need to capture the exact image that was being processed by some other `Recognizer` object at the time its `Result` became `Valid`. When that happens, `SuccessFrameGrabber's` [`Result`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/successframe/SuccessFrameGrabberRecognizer.Result.html) will also become `Valid` and will contain described image. That image can then be retrieved with [`getSuccessFrame()`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/successframe/SuccessFrameGrabberRecognizer.Result.html#getSuccessFrame()) method.

## <a name="blinkid-recognizers"></a> BlinkID recognizers

Unless stated otherwise for concrete recognizer, **single side BlinkID recognizers** from this list can be used in any context, but they work best with [`BlinkIdUISettings`](#blinkid-ui-component) and [`DocumentScanUISettings`](#document-ui-component), with UIs best suited for document scanning. 

**Combined recognizers** should be used with [`BlinkIdUISettings`](#blinkid-ui-component). They manage scanning of multiple document sides in the single camera opening and guide the user through the scanning process. Some combined recognizers support scanning of multiple document types, but only one document type can be scanned at a time.

### <a name="blinkid-single-side-recognizer"></a> BlinkID single side recognizer
The [`BlinkIdSingleSideRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/blinkid/generic/BlinkIdSingleSideRecognizer.html) scans and extracts data from the single side of the supported document. 
You can find the list of the currently supported documents [here](https://github.com/BlinkID/blinkid-android/blob/master/documentation/BlinkIDRecognizer.md).
We will continue expanding this recognizer by adding support for new document types in the future. Star this repo to stay updated.

The [`BlinkIdSingleSideRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/blinkid/generic/BlinkIdSingleSideRecognizer.html) works best with the [`BlinkIdUISettings` and `BlinkIdOverlayController`](#blinkid-ui-component). 

### <a name="blinkidMultiSideRecognizer"></a> BlinkID multi side recognizer
Use [`BlinkIdMultiSideRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/blinkid/generic/BlinkIdMultiSideRecognizer.html) for scanning both sides of the supported document. First, it scans and extracts data from the front, then scans and extracts data from the back, and finally, combines results from both sides. The [`BlinkIdMultiSideRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/blinkid/generic/BlinkIdMultiSideRecognizer.html) also performs data matching and returns a flag if the extracted data captured from the front side matches the data from the back.
You can find the list of the currently supported documents [here](https://github.com/BlinkID/blinkid-android/blob/master/documentation/BlinkIDRecognizer.md).
We will continue expanding this recognizer by adding support for new document types in the future. Star this repo to stay updated.

The [`BlinkIdMultiSideRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/blinkid/generic/BlinkIdMultiSideRecognizer.html) works best with the [`BlinkIdUISettings` and `BlinkIdOverlayController`](#blinkid-ui-component). 

### <a name="mrtd-recognizer"></a> Machine Readable Travel Document recognizer
The [`MrtdRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/blinkid/mrtd/MrtdRecognizer.html) is used for scanning and data extraction from the Machine Readable Zone (MRZ) of the various Machine Readable Travel Documents (MRTDs) like ID cards and passports. This recognizer is not bound to the specific country, but it can be configured to only return data that match some criteria defined by the [`MrzFilter`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/blinkid/mrtd/MrzFilter.html).




You can find information about usage context at the beginning of [this section](#blinkid-recognizers).

### <a name="mrtd-combined-recognizer"></a> Machine Readable Travel Document combined recognizer
The [`MrtdCombinedRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/blinkid/mrtd/MrtdCombinedRecognizer.html) scans Machine Readable Zone (MRZ) after scanning the full document image and face image (usually MRZ is on the back side and face image is on the front side of the document). Internally, it uses [DocumentFaceRecognizer](#document-face-recognizer) for obtaining full document image and face image as the first step and then [MrtdRecognizer](#mrtd-recognizer) for scanning the MRZ.

You can find information about usage context at the beginning of [this section](#blinkid-recognizers).

### <a name="passport-recognizer"></a> Passport recognizer
The [`PassportRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/blinkid/passport/PassportRecognizer.html) is used for scanning and data extraction from the Machine Readable Zone (MRZ) of the various passport documents. This recognizer also returns face image from the passport.

You can find information about usage context at the beginning of [this section](#blinkid-recognizers).

### <a name="visa-recognizer"></a> Visa recognizer
The [`VisaRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/blinkid/visa/VisaRecognizer.html) is used for scanning and data extraction from the Machine Readable Zone (MRZ) of the various visa documents. This recognizer also returns face image from the visa document.

You can find information about usage context at the beginning of [this section](#blinkid-recognizers).

### <a name="id-barcode-recognizer"></a> ID barcode recognizer
The [`IdBarcodeRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/blinkid/idbarcode/IdBarcodeRecognizer.html) is used for scanning barcodes from various ID cards. Check [this document](https://github.com/BlinkID/blinkid-android/blob/master/documentation/IdBarcodeRecognizer.md) to see the list of supported document types.

You can find information about usage context at the beginning of [this section](#blinkid-recognizers).

### <a name="document-face-recognizer"></a> Document face recognizer
The [`DocumentFaceRecognizer`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/recognizers/blinkid/documentface/DocumentFaceRecognizer.html) is a special type of recognizer that only returns face image and full document image of the scanned document. It does not extract document fields like first name, last name, etc. This generic recognizer can be used to obtain document images in cases when specific support for some document type is not available.

You can find information about usage context at the beginning of [this section](#blinkid-recognizers).
# <a name="embed-aar"></a> Embedding _BlinkID_ inside another SDK
	
You need to ensure that the final app gets all resources required by _BlinkID_. At the time of writing this documentation, [Android does not have support for combining multiple AAR libraries into single fat AAR](https://stackoverflow.com/questions/20700581/android-studio-how-to-package-single-aar-from-multiple-library-projects/20715155#20715155). The problem is that resource merging is done while building application, not while building AAR, so application must be aware of all its dependencies. **There is no official Android way of "hiding" third party AAR within your AAR.**

This problem is usually solved with transitive Maven dependencies, i.e. when publishing your AAR to Maven you specify dependencies of your AAR so they are automatically referenced by app using your AAR. Besides this, there are also several other approaches you can try:

- you can ask your clients to reference _BlinkID_ in their app when integrating your SDK
- since the problem lies in resource merging part you can try avoiding this step by ensuring your library will not use any component from _BlinkID_ that uses resources (i.e. built-in activities, fragments and views, except `RecognizerRunnerView`). You can perform [custom UI integration](#recognizer-runner-view) while taking care that all resources (strings, layouts, images, ...) used are solely from your AAR, not from _BlinkID_. Then, in your AAR you should not reference `LibBlinkID.aar` as gradle dependency, instead you should unzip it and copy its assets to your AAR’s assets folder, its `classes.jar` to your AAR’s lib folder (which should be referenced by gradle as jar dependency) and contents of its jni folder to your AAR’s src/main/jniLibs folder.
- Another approach is to use [3rd party unofficial gradle script](https://github.com/adwiv/android-fat-aar) that aim to combine multiple AARs into single fat AAR. Use this script at your own risk and report issues to [its developers](https://github.com/adwiv/android-fat-aar/issues) - we do not offer support for using that script.
- There is also a [3rd party unofficial gradle plugin](https://github.com/Vigi0303/fat-aar-plugin) which aims to do the same, but is more up to date with latest updates to Android gradle plugin. Use this plugin at your own risk and report all issues with using to [its developers](https://github.com/Vigi0303/fat-aar-plugin/issues) - we do not offer support for using that plugin.

# <a name="arch-consider"></a> Processor architecture considerations

_BlinkID_ is distributed with **ARMv7** and **ARM64** native library binaries.

**ARMv7** architecture gives the ability to take advantage of hardware accelerated floating point operations and SIMD processing with [NEON](http://www.arm.com/products/processors/technologies/neon.php). This gives _BlinkID_ a huge performance boost on devices that have ARMv7 processors. Most new devices (all since 2012.) have ARMv7 processor so it makes little sense not to take advantage of performance boosts that those processors can give. Also note that some devices with ARMv7 processors do not support NEON and VFPv4 instruction sets, most popular being those based on [NVIDIA Tegra 2](https://en.wikipedia.org/wiki/Tegra#Tegra_2), [ARM Cortex A9](https://en.wikipedia.org/wiki/ARM_Cortex-A9) and older. Since these devices are old by today's standard, _BlinkID_ does not support them. For the same reason, _BlinkID_ does not support devices with ARMv5 (`armeabi`) architecture.

**ARM64** is the new processor architecture that most new devices use. ARM64 processors are very powerful and also have the possibility to take advantage of new NEON64 SIMD instruction set to quickly process multiple pixels with a single instruction.

There are some issues to be considered:

- ARMv7 build of the native library cannot be run on devices that do not have ARMv7 compatible processor
- ARMv7 processors do not understand x86 instruction set
- ARM64 processors understand ARMv7 instruction set, but ARMv7 processors do not understand ARM64 instructions. 
    - <a name="64bitNotice"></a> **NOTE:** as of the year 2018, some android devices that ship with ARM64 processors do not have full compatibility with ARMv7. This is mostly due to incorrect configuration of Android's 32-bit subsystem by the vendor, however Google decided that as of August 2019 all apps on PlayStore that contain native code need to have native support for 64-bit processors (this includes ARM64 and x86_64) - this is in anticipation of future Android devices that will support 64-bit code **only**, i.e. that will have ARM64 processors that do not understand ARMv7 instruction set.
- if ARM64 processor executes ARMv7 code, it does not take advantage of modern NEON64 SIMD operations and does not take advantage of 64-bit registers it has - it runs in emulation mode

`LibBlinkID.aar` archive contains ARMv7 and ARM64 builds of the native library. By default, when you integrate _BlinkID_ into your app, your app will contain native builds for all these processor architectures. Thus, _BlinkID_ will work on ARMv7 and ARM64 devices and will use ARMv7 features on ARMv7 devices and ARM64 features on ARM64 devices. However, the size of your application will be rather large.

## <a name="reduce-size"></a> Reducing the final size of your app

We recommend that you distribute your app using [App Bundle](https://developer.android.com/platform/technology/app-bundle). This will defer apk generation to Google Play, allowing it to generate minimal APK for each specific device that downloads your app, including only required processor architecture support.

### Using APK splits

If you are unable to use App Bundle, you can create multiple flavors of your app - one flavor for each architecture. With gradle and Android studio this is very easy - just add the following code to `build.gradle` file of your app:

```
android {
  ...
  splits {
    abi {
      enable true
      reset()
      include 'armeabi-v7a', 'arm64-v8a'
      universalApk true
    }
  }
}
```

With that build instructions, gradle will build two different APK files for your app. Each APK will contain only native library for one processor architecture and one APK will contain all architectures. In order for Google Play to accept multiple APKs of the same app, you need to ensure that each APK has different version code. This can easily be done by defining a version code prefix that is dependent on architecture and adding real version code number to it in following gradle script:

```
// map for the version code
def abiVersionCodes = ['armeabi-v7a':1, 'arm64-v8a':2]

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

### Removing processor architecture support

If you won't be distributing your app via Google Play or for some other reasons want to have single APK of smaller size, you can completely remove support for certain CPU architecture from your APK. **This is not recommended due to [consequences](#arch-consequences)**.

To keep only some CPU architectures, for example `armeabi-v7a` and `arm64-v8a`, add the following statement to your `android` block inside `build.gradle`:

```
android {
    ...
    ndk {
        // Tells Gradle to package the following ABIs into your application
        abiFilters 'armeabi-v7a', 'arm64-v8a'
    }
}
```

This will remove other architecture builds for **all** native libraries used by the application.

To remove support for a certain CPU architecture only for _BlinkID_, add the following statement to your `android` block inside `build.gradle`:

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
- to remove ARM64 support, use `exclude 'lib/arm64-v8a/libBlinkID.so'`
    - **NOTE**: this is **not recommended**. See [this notice](#64bit-notice).

You can also remove multiple processor architectures by specifying `exclude` directive multiple times. Just bear in mind that removing processor architecture will have side effects on performance and stability of your app. Please read [this](#arch-consequences) for more information.

### <a name="arch-consequences"></a> Consequences of removing processor architecture

- Google decided that as of August 2019 all apps on Google Play that contain native code need to have native support for 64-bit processors (this includes ARM64 and x86_64). This means that you cannot upload application to Google Play Console that supports only 32-bit ABI and does not support corresponding 64-bit ABI.

- By removing ARMv7 support, _BlinkID_ will not work on devices that have ARMv7 processors. 
- By removing ARM64 support, _BlinkID_ will not use ARM64 features on ARM64 device
    - also, some future devices may ship with ARM64 processors that will not support ARMv7 instruction set. Please see [this note](#64bit-notice) for more information.

## <a name="combineNativeLibraries"></a> Combining _BlinkID_ with other native libraries

If you are combining _BlinkID_ library with other libraries that contain native code into your application, make sure you match the architectures of all native libraries. For example, if third party library has got only ARMv7 version, you must use exactly ARMv7 version of _BlinkID_ with that library, but not ARM64. Using this architectures will crash your app at initialization step because JVM will try to load all its native dependencies in same preferred architecture and will fail with `UnsatisfiedLinkError`.

### <a name="dynamicCppRuntime"></a> Resolving conflict on `libc++_shared.so`

_BlinkID_ contains native code that depends on the C++ runtime. This runtime is provided by the `libc++_shared.so`, which needs to be available in your app that is using _BlinkID_. However, the same file is also used by various other libraries that contain native components. If you happen to integrate both such library together with _BlinkID_ in your app, your build will fail with an error similar to this one:

```
* What went wrong:
Execution failed for task ':app:mergeDebugNativeLibs'.
> A failure occurred while executing com.android.build.gradle.internal.tasks.MergeJavaResWorkAction
   > 2 files found with path 'lib/arm64-v8a/libc++_shared.so' from inputs:
      - <path>/.gradle/caches/transforms-3/3d428f9141586beb8805ce57f97bedda/transformed/jetified-opencv-4.5.3.0/jni/arm64-v8a/libc++_shared.so
      - <path>/.gradle/caches/transforms-3/609476a082a81bd7af00fd16a991ee43/transformed/jetified-blinkid-6.8.0/jni/arm64-v8a/libc++_shared.so
     If you are using jniLibs and CMake IMPORTED targets, see
     https://developer.android.com/r/tools/jniLibs-vs-imported-targets
```

The error states that multiple different dependencies provide the same file `lib/arm64/libc++_shared.so` (in this case, OpenCV and BlinkID).

You can resolve this issue by making sure that the dependency that uses _newer version of `libc++_shared.so`_ is listed first in your dependency list, and then, simply add the following to your `build.gradle`:

```
android {
    packaging {
        jniLibs {
            pickFirsts.add("lib/armeabi-v7a/libc++_shared.so")
            pickFirsts.add("lib/arm64-v8a/libc++_shared.so")
        }
    }
}
```

**IMPORTANT NOTE**

The code above will always select the first `libc++_shared.so` from your dependency list, so make sure that the dependency that uses the *latest version of `libc++_shared.so`* is listed first. This is because `libc++_shared.so` is backward-compatible, but not forward-compatible. This means that, e.g. `libBlinkID.so` built against `libc++_shared.so` from NDK r24 will work without problems when you package it together with `libc++_shared.so` from NDK r26, but will crash when you package it together with `libc++_shared.so` from NDK r21. This is true for all your native dependencies.

# <a name="troubleshoot"></a> Troubleshooting

### Integration difficulties

In case of problems with SDK integration, first make sure that you have followed [integration instructions](#android-studio-integration). If you're still having problems, please contact us at [help.microblink.com](http://help.microblink.com).

### Licensing issues

If you are getting "invalid license key" error or having other license-related problems (e.g. some feature is not enabled that should be or there is a watermark on top of camera), first check the ADB logcat. All license-related problems are logged to error log so it is easy to determine what went wrong.

When you have to determine what is the license-relate problem or you simply do not understand the log, you should contact us [help.microblink.com](http://help.microblink.com). When contacting us, please make sure you provide following information:

* exact package name of your app (from your `AndroidManifest.xml` and/or your `build.gradle` file)
* license that is causing problems
* please stress out that you are reporting problem related to Android version of _BlinkID_ SDK
* if unsure about the problem, you should also provide excerpt from ADB logcat containing license error

**Keep in mind:** Versions 5.8.0 and above require an internet connection to work under our new License Management Program.

We’re only asking you to do this so we can validate your trial license key. Data extraction still happens offline, on the device itself.
Once the validation is complete, you can continue using the SDK in offline mode (or over a private network) until the next check. 

### Other problems

If you are having problems with scanning certain items, undesired behaviour on specific device(s), crashes inside _BlinkID_ or anything unmentioned, please do as follows:

* enable logging to get the ability to see what is library doing. To enable logging, put this line in your application:

    ```java
    com.microblink.blinkid.util.Log.setLogLevel(com.microblink.blinkid.util.Log.LogLevel.LOG_VERBOSE);
    ```

    After this line, library will display as much information about its work as possible. Please save the entire log of scanning session to a file that you will send to us. It is important to send the entire log, not just the part where crash occurred, because crashes are sometimes caused by unexpected behaviour in the early stage of the library initialization.
    
* Contact us at [help.microblink.com](http://help.microblink.com) describing your problem and provide following information:
    * log file obtained in previous step
    * high resolution scan/photo of the item that you are trying to scan
    * information about device that you are using - we need exact model name of the device. You can obtain that information with any app like [this one](https://play.google.com/store/apps/details?id=ru.andr7e.deviceinfohw)
    * please stress out that you are reporting problem related to Android version of _BlinkID_ SDK


# <a name="faq"></a> FAQ and known issues
#### <a name="feature-not-supported-by-license-key"></a> After switching from trial to production license I get `InvalidLicenseKeyException` when I construct specific `Recognizer` object

Each license key contains information about which features are allowed to use and which are not. This exception indicates that your production license does not allow using of specific `Recognizer` object. You should contact [support](http://help.microblink.com) to check if provided license is OK and that it really contains all features that you have purchased.

#### <a name="invalid-license-key"></a> I get `InvalidLicenseKeyException` with trial license key

Whenever you construct any `Recognizer` object or any other object that derives from [`Entity`](https://blinkid.github.io/blinkid-android/com/microblink/blinkid/entities/Entity.html), a check whether license allows using that object will be performed. If license is not set prior constructing that object, you will get `InvalidLicenseKeyException`. We recommend setting license as early as possible in your app, ideally in `onCreate` callback of your [Application singleton](https://developer.android.com/reference/android/app/Application.html).

#### <a name="missing-resources"></a> When my app starts, I get exception telling me that some resource/class cannot be found or I get `ClassNotFoundException`

This usually happens when you perform integration into Eclipse project and you forget to add resources or native libraries into the project. You must alway take care that same versions of both resources, assets, java library and native libraries are used in combination. Combining different versions of resources, assets, java and native libraries will trigger crash in SDK. This problem can also occur when you have performed improper integration of _BlinkID_ SDK into your SDK. Please read how to [embed _BlinkID_ inside another SDK](#embed-aar).

#### <a name="unsatisfied-link-error"></a> When my app starts, I get `UnsatisfiedLinkError`

This error happens when JVM fails to load some native method from native library If performing integration into Android studio and this error happens, make sure that you have correctly combined _BlinkID_ SDK with [third party SDKs that contain native code](#combineNativeLibraries), especially if you need resolving [conflict over `libc++_shared.so`](#dynamicCppRuntime). If this error also happens in our integration sample apps, then it may indicate a bug in the SDK that is manifested on specific device. Please report that to our [support team](http://help.microblink.com).

#### <a name="libcpp-shared-conflict"></a> During build, I get conflict about duplicate `libc++_shared.so`

Please consult the section about [resolving `libc++_shared.so` conflict](#dynamicCppRuntime).

#### <a name="late-metadata1"></a> I've added my callback to `MetadataCallbacks` object, but it is not being called

Make sure that after adding your callback to `MetadataCallbacks` you have applied changes to `RecognizerRunnerView` or `RecognizerRunner` as described in [this section](#processing-events).

#### <a name="late-metadata2"></a> I've removed my callback to `MetadataCallbacks` object, and now app is crashing with `NullPointerException`

Make sure that after removing your callback from `MetadataCallbacks` you have applied changes to `RecognizerRunnerView` or `RecognizerRunner` as described in [this section](#processing-events).

#### <a name="stateful-recognizer"></a> In my `onScanningDone` callback I have the result inside my `Recognizer`, but when scanning activity finishes, the result is gone

This usually happens when using `RecognizerRunnerView` and forgetting to pause the `RecognizerRunnerView` in your `onScanningDone` callback. Then, as soon as `onScanningDone` happens, the result is mutated or reset by additional processing that `Recognizer` performs in the time between end of your `onScanningDone` callback and actual finishing of the scanning activity. For more information about statefulness of the `Recognizer` objects, check [this section](#recognizer-concept).

#### <a name="transaction-too-large"></a> I am using built-in activity to perform scanning and after scanning finishes, my app crashes with `IllegalStateException` stating `Data cannot be saved to intent because its size exceeds intent limit`.

This usually happens when you use `Recognizer` that produces image or similar large object inside its `Result` and that object exceeds the Android intent transaction limit. You should enable different intent data transfer mode. For more information about this, [check this section](#intent-optimization). Also, instead of using built-in activity, you can use [`RecognizerRunnerFragment` with built-in scanning overlay](#recognizerRunnerFragment).

#### <a name="transaction-too-large2"></a> After scanning finishes, my app freezes

This usually happens when you attempt to transfer standalone `Result` that contains images or similar large objects via Intent and the size of the object exceeds Android intent transaction limit. Depending on the device, you will get either [TransactionTooLargeException](https://developer.android.com/reference/android/os/TransactionTooLargeException.html), a simple message `BINDER TRANSACTION FAILED` in log and your app will freeze or your app will get into restart loop. We recommend that you use `RecognizerBundle` and its API for sending `Recognizer` objects via Intent in a more safe manner ([check this section](#intent-optimization) for more information). However, if you really need to transfer standalone `Result` object (e.g. `Result` object obtained by cloning `Result` object owned by specific `Recognizer` object), you need to do that using global variables or singletons within your application. Sending large objects via Intent is not supported by Android.

#### <a name="direct-api-bad-performance"></a> Scanning with a camera works better than a recognition of images by using the `Direct API`

When automatic scanning of camera frames with our camera management is used (provided camera overlays or direct usage of `RecognizerRunnerView`), we use a stream of video frames and send multiple images to the recognition to boost reading accuracy. Also, we perform frame quality analysis and combine scanning results from multiple camera frames. On the other hand, when you are using the Direct API with a single image per document side, we cannot combine multiple images. We do our best to extract as much information as possible from that image. In some cases, when the quality of the input image is not good enough, for example, when the image is blurred or when glare is present, we are not able to successfully read the document.

#### <a name="network-required-error"></a> I am getting a ‘Network required’ error when I'm on a private network

Online trial licenses require a public network access for validation purposes. See [Licensing issues](#licensing-issues).


#### <a name="ocr-result-forbidden"></a> `onOcrResult()` method in my `OcrCallback` is never invoked and all `Result` objects always return `null` in their OCR result getters

In order to be able to obtain raw OCR result, which contains locations of each character, its value and its alternatives, you need to have a license that allows that. By default, licenses do not allow exposing raw OCR results in public API. If you really need that, please [contact us](https://help.microblink.com) and explain your use case.
# <a name="info"></a> Additional info

## <a name="size-report"></a> BlinkID SDK size
You can find BlinkID SDK size report for all supported ABIs [here](https://github.com/BlinkID/blinkid-android/blob/master/size-report/sdk_size_report.md).

## <a name="api-reference"></a> API reference
Complete API reference can be found in [Javadoc](https://blinkid.github.io/blinkid-android).

## <a name="contact"></a> Contact
For any other questions, feel free to contact us at [help.microblink.com](http://help.microblink.com).

