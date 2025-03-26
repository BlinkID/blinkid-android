<p align="center" >
  <img src="https://raw.githubusercontent.com/wiki/blinkid/blinkid-android/images/logo-microblink.png" alt="Microblink" title="Microblink">
</p>

# BlinkID SDK for Android

The _BlinkID_ Android SDK is a comprehensive solution for implementing secure document scanning and extraction. It offers powerful capabilities for extracting data from a wide range of identification documents.


# Table of contents
* [Quick Start](#quick-start)
    * [Quick start with the sample app](#quick-sample)
    * [SDK integration](#sdk-integration)
* [Device requirements](#device-requirements)
    * [Android version](#android-version-req)
    * [Camera](#camera-req)
    * [Processor architecture](#processor-arch-req)
* [Pre-bundling the SDK resources in your app](#pre-bundling-resources)
* [Customizing the look and UX](#customizing-the-look)
    * [Simple customizations](#simple-customizations)
    * [Advanced customizations](#advanced-customizations)
* [Changing default strings and localization](#changing-strings-and-localization)
    * [Defining your own string resources for UI elements](#using-own-string-resources)
* [Using SDK through `BlinkIdScanActivity`](#using-scan-activity)
* [Completely custom UX (advanced)](#low-level-api)
    * [The `BlinkIdSdk` and `BlinkIdScanningSession`](#core-api-sdk-and-session)
* [Troubleshooting](#troubleshoot)
* [Additional info](#additional-info)
    * [BlinkID SDK size](#sdk-size)
    * [API documentation](#api-documentation)
    * [Contact](#contact)


# <a name="quick-start"></a> Quick Start

## <a name="quick-sample"></a> Quick start with the sample apps

1. Open Android Studio.
2. In `Quick Start` dialog choose _Open project_.
3. In `File` dialog select _BlinkID_ folder.
4. Wait for the project to load. If Android Studio asks you to reload the project on startup, select `Yes`.

#### Included sample apps:

- **_app_** demonstrates quick and straightforward integration of the BlinkID SDK using the provided UX in Jetpack Compose to scan a document and display the results.


## <a name="sdk-integration"></a> SDK integration

### Adding _BlinkID_ SDK dependency

The `BlinkID` library is available on Maven Central repository.

In your project root, add `mavenCentral()` repository to the repositories list, if not already present:

```
repositories {
    // ... other repositories
    mavenCentral()
}
```

Add _BlinkID_ as a dependency in module level `build.gradle(.kts)`:

```
dependencies {
    implementation("com.microblink:blinkid-ux:7.0.0")
}
```

### Launching the BlinkID scanning session and obtaining the results

1. A valid license key is required to initialize the document capture process. You can request a free trial license key, after you register, at [Microblink Developer Hub](https://developer.microblink.com/).. License is bound to the [application ID](https://developer.android.com/studio/build/configure-app-module#set-application-id) of your app, so please ensure you enter the correct application ID when asked.

2. You first need to initialize the SDK and obtain the `BlinkIdSdk` instance:
```kotlin
val maybeInstance = BlinkIdSdk.initializeSdk(
    BlinkIdSdkSettings(
        licenseKey = <your_license_key>,
    )
)
when {
    maybeInstance.isSuccess -> {
        val sdkInstance = maybeInstance.getOrNull()
        // use the SDK instance
    }

    maybeInstance.isFailure -> {
        val exception = maybeInstance.exceptionOrNull()
        Log.e(TAG, "Initialization failed", exception)
    }
}
```
`BlinkIdSdk.initializeSdk` is a suspend function which should be called from a coroutine.

3. Use `BlinkIdCameraScanningScreen` composable to the scanning UX and obtain results:
```kotlin
BlinkIdCameraScanningScreen(
    sdkInstance,
    uiSettings = UiSettings(),
    sessionSettings = BlinkIdSessionSettings(),
    onScanningSuccess = { scanningResult ->
        // scanningResult is BlinkIdScanningResult
    },
    onScanningCanceled = {
        // user canceled the scanning
    }
)
```

### Scanning session result

After the document scanning session is finished the SDK returns an object of type [BlinkIdScanningResult](https://blinkid.github.io/blinkid-android/blinkid-core/com.microblink.blinkid.core.session/-blink-id-scanning-result/index.html).
The object contains extraction process details, document class info, and extraction results. Results are separated into general results and section results.
General results are a combined set from each entry with the individual data points taken from the most reliable data source (Barcode > MRZ > Visual).

Section results are separated by document side and by data source (Barcode, MRZ, Visual). Each of these individual data sources are available if present on the document (and allowed through scanning settings).

# <a name="device-requirements"></a> Device requirements

## <a name="android-version-req"></a> Android version

_BlinkID_ SDK requires Android API level **24** or newer.

## <a name="camera-req"></a> Camera

To perform successful scans, the camera preview resolution must be at least **1080p**. Note that the camera preview resolution is not the same as the video recording resolution.

## <a name="processor-arch-req"></a> Processor architecture

_BlinkID_ SDK is distributed with **ARMv7** and **ARM64** native library binaries.

_BlinkID is a native library written in C++ and available for multiple platforms. Because of this, _BlinkID_ cannot work on devices with obscure hardware architectures. We have compiled SDK's native code only for the most popular Android [ABIs](https://en.wikipedia.org/wiki/Application_binary_interface).

If you are combining _BlinkID_ library with other libraries that contain native code in your application, make sure to match the architectures of all native libraries. For example, if the third-party library has only ARMv7 version, you must use exactly ARMv7 version of _BlinkID_ with that library, but not ARM64. Using different architectures will crash your app at the initialization step because JVM will try to load all its native dependencies in the same preferred architecture and fail with `UnsatisfiedLinkError`.

To avoid this issue and ensure that only architectures supported by the _BlinkID_ library are packaged in the final application, add the following statement to your `android/defaultConfig` block inside `build.gradle.kts`:

```
android {
    ...
    defaultConfig {
        ...
        ndk {
            // Tells Gradle to package the following ABIs into your application
            abiFilters += listOf("armeabi-v7a", "arm64-v8a")
        }
    }
}
```

# <a name="pre-bundling-resources"></a> Pre-bundling the SDK resources into your app

If you want to reduce the SDK startup time and network traffic, you have option to pre-bundle the SDK resources as assets into your application. All required resources are located in [libs/resources/assets/microblink
/blinkid](https://github.com/BlinkID/blinkid-android/tree/main/libs/resources/assets/microblink/blinki) folder. You can bundle it to your application by including the mentioned folder to application's assets. Copy mentioned `libs/resources/assets/microblink` directory to `src/main/assets` folder of your application module (or appropriate folder for desired app flavor).

Use `BlinkIdSdkSettings` to set the following options when instantiating the SDK:

```kotlin
BlinkIdSdkSettings(
    context = context,
    licenseKey = <your_license_key>,
    // disable resource download
    downloadResources = false,
    // define path if you are not using a default one: "microblink/blinkid"
    // resourceLocalFolder = "path_within_app_assets"
)
```



# <a name="customizing-the-look"></a> Customizing the look and the UX

## <a name="simple-customizations"></a> Simple customizations

You can use basic customization options in our default `BlinkIdCameraScanningScreen` composable:

```kotlin
BlinkIdCameraScanningScreen(
    sdkInstance,
    // ui settings options
    uiSettings = UiSettings(
        typography = yourTypography,
        colorScheme = yourColorScheme,
        uiColors = youReticleColors,
        sdkStrings = yourSdkStrings,
        showOnboardingDialog = true, // or false
        showHelpButton = true // or false
    ),
    sessionSettings = BlinkIdSessionSettings(),
    onScanningSuccess = { scanningResult ->
        // result is BlinkIdScanningResult
    },
    onScanningCanceled = {
        // user canceled the scanning
    }
)
```

For a complete reference on available customization options, see [UiSettings](https://blinkid.github.io/blinkid-android/microblink-ux/com.microblink.ux/-ui-settings/index.html) API docs.

## <a name="advanced-customizations"></a> Advanced customizations

### Implementing scanning Composable

It is possible to use completely custom UI elements by implementing your own Composable.

Create your implementation of scanning ViewModel (which must be a subclass of our `CameraViewModel`) to handle UX events that come from our SDK:

```kotlin
class YourBlinkIdScanningUxViewModel(
    blinkIdSdkInstance: BlinkIdSdk,
    sessionSettings: ScanningSessionSettings
) : CameraViewModel() {

    val imageAnalyzer = BlinkIdAnalyzer(
        blinkIdSdk = blinkIdSdkInstance,
        sessionSettings = sessionSettings,
        scanningDoneHandler = object : BlinkIdScanningDoneHandler {
            override fun onScanningFinished(result: BlinkIdScanningResult) {
                // TODO use scanning result
            }

            override fun onScanningCancelled() {
                // user cancelled the scanning
            }
            
            override fun onError(error: ErrorReason) {
                // handle scanning errors
            }
        },
        uxEventHandler = object : ScanningUxEventHandler {
            override fun onUxEvents(events: List<ScanningUxEvent>) {
                // handle scanning UX events to update UI state
                for (event in events) {
                    when (event) {
                        is ScanningUxEvent.ScanningDone -> {
                            // TODO
                        }

                        is ScanningUxEvent.DocumentNotFound -> {
                            // TODO
                        }

                        is ScanningUxEvent.DocumentNotFullyVisible -> {
                            // TODO
                        }

                        is ScanningUxEvent.DocumentTooClose -> {
                            // TODO
                        }
                        
                        is BlinkIdDocumentLocatedLocation -> {
                            // TODO
                        }
                        
                        is DocumentImageAnalysisResult -> {
                            // TODO
                        }
                        
                        // TODO ... handle other events, when must be exhaustive, omitted for brevity
                    
                    }
                }
            }
        }
    )
    
    override fun analyzeImage(image: ImageProxy) {
        // image has to be closed after processing
        image.use {
            imageAnalyzer?.analyze(it)
        }
    }

     override fun onCleared() {
        super.onCleared()
        // cancel and close image analyzer when view model is cleared
        imageAnalyzer.cancel()
        imageAnalyzer.close()
    }
}

```

Implement your camera scanning screen Composable by using our `CameraScreen` Composable which is responsible for camera management:

```kotlin
@Composable
fun YourCameraScanningScreen(
    viewModel: YourBlinkIdScanningUxViewModel
    //... other required parameters for your UI
) {
    // ...
    CameraScreen(
        cameraViewModel = viewModel,
    ) {
        // TODO your camera overlay Compose content
    }

}
``` 

### Modifying our ux libraries source code

For larger control over the UX, you can use the open-source `blinkid-ux` and `microblink-ux` libraries and perform certain modifications. **Only the source files that specifically allow for modification by the license header** can be modified.

To do so, you can include the source code of our library directly in your application.
They are located in `libs/sources/blinkid-ux` and `libs/sources/microblink-ux` modules.

**Please keep in mind that we will regularly make changes and update the source code with each release.**

# <a name="changing-strings-and-localization"></a> Changing default strings and localization

Strings used within built-in activities and UX can be localized to any language.

We have already prepared strings for several languages which you can use out of the box. You can also modify those strings, or you can add your own language. Languages natively supported by our SDK are the following: `Arabic`, `Chinese simplified`, `Chinese traditional`, `Croatian`, `Czech`, `Dutch`, `Filipino`, `French`, `German`, `Hebrew`, `Hungarian`, `Indonesian`, `Italian`, `Malay`, `Portugese`, `Romanian`, `Serbian`, `Slovak`, `Slovenian`, `Spanish`, `Thai`, and `Vietnamese`.

The language is automatically adapted to the user's OS language settings. Additionally, to force a specific language, you have to enable it from the code.


#### <a name="addLanguage"></a> Adding new language

_BlinkID_ can easily be translated to other languages. The `res` folder in `microblink-ux` has folder `values` which contains `strings_core.xml` - this file contains english strings. In order to make e.g. croatian translation, create a folder `values-hr` in your project and put the copy of `strings_core.xml` inside it. Then, open that file and translate the strings from English into Croatian.

#### <a name="stringChanging"></a> Changing strings in the existing language

To modify an existing string, the best approach would be to:

1. Choose a language you want to modify. For example Croatian ('hr').
2. Find `strings_core.xml` in folder `res/values-hr`
3. Choose a string key which you want to change. For example: ```<string name="mb_close">Close</string>```
4. In your project create a file `strings_core.xml` in the folder `res/values-hr`, if it doesn't already exist
5. Create an entry in the file with the value for the string which you want. For example: ```<string name="mb_back">Zatvori</string>```
6. Repeat for all the string you wish to change

You can modify strings and add another language. For more information on how localization works in Android, check out the [official Android documentation](https://developer.android.com/guide/topics/resources/localization).

## <a name="using-own-string-resources"></a> Defining your own string resources for UI elements

You can define string resources that will be used instead of predefined ones by using the custom [SdkStrings](https://blinkid.github.io/blinkid-android/microblink-ux/com.microblink.ux.theme/-sdk-strings/index.html) while creating the `UiSettings`.

## <a name="using-scan-activity"></a> Using SDK through `BlinkIdScanActivity`

The simplest way of using BlinkID SDK is through our integrated activity.
This eliminates the need for Compose integration and allows for quick and easy access to results. By using this integration method customization is reduced, although many UI elements can still be customized.

Activity is accessed through `rememberLauncherForActivityResult` by using [MbBlinkIdScan](https://blinkid.github.io/blinkid-android/blinkid-ux/com.microblink.blinkid.ux.contract/-mb-blink-id-scan/index.html) contract.
```kotlin
    val blinkIdLauncher = rememberLauncherForActivityResult(
        contract = MbBlinkIdScan(),
        onResult = { activityResult ->
            if (activityResult.status == BlinkIdScanActivityResultStatus.DocumentScanned) {
                // use activityResult.result (BlinkIdScanningResult)
            }
        }
    )
```
When launching the contract, [BlinkIdScanActivitySettings](https://blinkid.github.io/blinkid-android/blinkid-ux/com.microblink.blinkid.ux.contract/-blink-id-scan-activity-settings/index.html) need to be defined. These settings include basic SDK information such as license key and additional settings for customizing the scanning experience.
```kotlin
    blinkIdLauncher.launch(
        BlinkIdScanActivitySettings(
            BlinkIdSdkSettings(
                licenseKey = <your_license_key>
            ),
            BlinkIdSessionSettings(
                scanningSettings = ScanningSettings(
                    // define additional settings here
                )
            )
        )
    )
```
[BlinkIdScanActivitySettings](https://blinkid.github.io/blinkid-android/blinkid-ux/com.microblink.blinkid.ux.contract/-blink-id-scan-activity-settings/index.html) contain the following:
```kotlin
    data class BlinkIdScanActivitySettings(
        val blinkIdSdkSettings: BlinkIdSdkSettings,
        val scanningSessionSettings: BlinkIdSessionSettings = BlinkIdSessionSettings(),
        val uxSettings: BlinkIdUxSettings = BlinkIdUxSettings(),
        val scanActivityUiColors: BlinkIdActivityColors? = null,
        val scanActivityUiStrings: SdkStrings = SdkStrings.Default,
        val showOnboardingDialog: Boolean = DefaultShowOnboardingDialog,
        val showHelpButton: Boolean = DefaultShowHelpButton,
        val enableEdgeToEdge: Boolean = true,
        val deleteCachedAssetsAfterUse: Boolean = false
    )
```
Most customizations regarding the UI are handled in the same way as with the Composable component. The only difference is a limitation in customizing `Typography` and `Colors`.

Currently, `Typography` cannot be customized through an activity.

While `Colors` are fully customizable, the client needs to make sure that `Dark` and `Light` themes follow the current system state. In the Compose implementation, this is handled directly by the SDK.

# <a name="low-level-api"></a> Completely custom UX (advanced)

When using the low-level API, you are responsible for preparing the input image stream (or static images) for analysis as well as building a completely custom UX from scratch based on the image-by-image feedback from the SDK.

Low-level API gives you more flexibility with the cost of a significantly larger integration effort. For example, if you need a camera, you will be responsible for camera management and displaying real-time user guidance.

### Adding _BlinkID_ Core SDK dependency for low-level API

For low-level API integration, only _BlinkID_ SDK core library: **blinkid-core** is needed.
Both `blinkid-ux` and `microblink-ux` are not needed.

In your project root, add `mavenCentral()` repository to the repositories list, if not already present:

```
repositories {
    // ... other repositories
    mavenCentral()
}
```

Add _blinkid-core_ library as a dependency in module level `build.gradle(.kts)`:

```
dependencies {
    implementation("com.microblink:blinkid-core:7.0.0")
}
```

## <a name="core-api-sdk-and-session"></a> The `BlinkIdSdk` and `BlinkIdScanningSession`

[BlinkIdSdk](https://blinkid.github.io/blinkid-android/blinkid-core/com.microblink.blinkid.core/-blink-id-sdk/index.html) is a singleton that is main entry point to the _BlinkID_ SDK. It manages the global state of the SDK. This involves managing the main processing, unlocking the SDK, ensuring that licence check is up-to-date, downloading resources, and performing all necessary synchronization for the processing operations.

Once you obtain an instance of the `BlinkIdSdk` class after the SDK initialization is completed, you can use it to start a document capture session.

[BlinkIdScanningSession](https://blinkid.github.io/blinkid-android/blinkid-core/com.microblink.blinkid.core.session/-blink-id-scanning-session/index.html) is the main object that accepts images and camera frames, processes them and returns frame-by-frame results, and final result when it becomes available.


### <a name="analyzing-image-stream"></a> Analyzing the stream of images

1. First initialize the SDK to obtain `BlinkIdSdk` instance by calling `BlinkIdSdk.initializeSdk` suspend function from a Coroutine:
```kotlin
val maybeInstance = BlinkIdSdk.initializeSdk(
    BlinkIdSdkSettings(
        context = context,
        licenseKey = "your_license_key",
    )
)
when {
    maybeInstance.isSuccess -> {
        val sdkInstance = maybeInstance.getOrNull()
        // use the SDK instance
    }

    maybeInstance.isFailure -> {
        val exception = maybeInstance.exceptionOrNull()
        Log.e(TAG, "Initialization failed", exception)
    }
}
```
2. Create `BlinkIdScanningSession` by calling suspend function `BlinkIdSdk.createScanningSession(BlinkIdSessionSettings)`
```kotlin
val scanningSession = blinkIdSdk.createScanningSession(BlinkIdSessionSettings(
    // use InputImageSource.Video to analyze stream of images, if you have few 
    // images (e.g. from gallery) use InputImageSource.Photo
    inputImageSource = InputImageSource.Video,
    // update other options if required
))
```

3. To process each image (camera frame) that comes to the recognition, call the suspend function `BlinkIdScanningSession.process(InputImage): BlinkIdProcessResult`
```kotlin
val processResult = scanningSesionSession.process(inputImage)
```

There are helper methods for creating [InputImage](https://blinkid.github.io/blinkid-android/blinkid-core/com.microblink.core.image/-input-image/index.html) from `android.media.Image`, `androidx.camera.core.ImageProxy` and standard Android Bitmap.

Processing of the single frame returns [ProcessResult](https://blinkid.github.io/blinkid-android/blinkid-core/com.microblink.blinkid.core.session/-blink-id-process-result/index.html) which contains:

- Detailed analysis of the input image, including various detection statuses and potential issues that should be used for frame-by-frame UX updates.
- Completeness status of the overall process.

You should keep calling the process function until the result completeness indicates that the result is complete, but you could have custom logic for cancellation and timeouts.

### <a name="core-api-obtaining-results"></a> Obtaining scanning results

If after analysis of some image completeness status of `BlinkIdProcessResult` indicates that document capture is complete, only then you should get the final result from the `ScanningSession`:

```kotlin
if (processResult.resultCompleteness.isComplete()) {
    val captureResult = session.getResult()
    // do something with the final result
}
```

You will get [BlinkIdScanningResult](https://blinkid.github.io/blinkid-android/blinkid-core/com.microblink.blinkid.core.session/-blink-id-scanning-result/index.html) with extraction results.

**After scanning is completed, it is important to terminate the scanning session**

To terminate the scanning session, ensure that `BlinkIdScanningSession.close()` is called.

**If you are finished with the SDK processing, terminate the SDK to free up resources** by invoking `BlinkIdSdk.closeAndDeleteCachedAssets()` on the SDK instance. If you just wish to close the SDK but may need to use it and the future, you can eliminate the need for re-downloading the resources by calling `BlinkId.close()`.

# <a name="troubleshoot"></a> Troubleshooting

### Integration difficulties
In case of problems with SDK integration, make sure that you have followed [integration instructions](#sdk-integration) and [device requirements](#device-requirements). If you're still having problems, please contact us at [help.microblink.com](http://help.microblink.com) describing your problem and provide the following information:

* high-resolution scan/photo of the item that you are trying to read
* information about device that you are using - we need the exact model name of the device. You can obtain that information with any app like [this one](https://play.google.com/store/apps/details?id=ru.andr7e.deviceinfohw)
* please stress that you are reporting a problem related to the Android version of _BlinkID_ SDK

# <a name="additional-info"></a> Additional info

## <a name="sdk-size"></a> BlinkID SDK size

We recommend that you distribute your app using [App Bundle](https://developer.android.com/platform/technology/app-bundle). This will defer APK generation to Google Play, allowing it to generate minimal APK for each specific device that downloads your app, including only required processor architecture support.


Here is the SDK size, calculated for supported ABIs:

| ABI | Download size | Install size |
| --- |:-------------:|:------------:|
| armeabi-v7a |    2.72 MB    |   3.89 MB    |
| arm64-v8a |    2.78 MB    |   4.58 MB    |

SDK size is calculated as application size increases when _BlinkID_ SDK is added, with all its dependencies included.

## <a name="api-documentation"></a> API documentation
You can find the BlinkID SDK **KDoc** documentation [here](https://blinkid.github.io/blinkid-android/index.html).

## <a name="contact"></a> Contact
For any other questions, feel free to contact us at [help.microblink.com](http://help.microblink.com).
