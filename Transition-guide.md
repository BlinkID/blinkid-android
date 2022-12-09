# Transition to BlinkID v6.0.0
## Breaking changes
### Repackaging of all classes
- The root package has been renamed from `com.microblink` to `com.microblink.blinkid`. To implement this change, you should simply replace all occurrences of `com.microblink` with `com.microblink.blinkid`. Most of these changes should be on imports of BlinkID SDK Java classes.

### Renaming of recognizers
- One very important change came when it comes to using BlinkID recognizers - they have been renamed to make them more understandable for new developers and users:
	- Basic single-sided recognizer, which used to be named `BlinkIdRecognizer`, is now called __BlinkIdSingleSideRecognizer__, and should be used for scanning one-sided documents or if you wish to capture only the front side of it
	- More advanced recognizer, which used to be named `BlinkIdCombinedRecognizer`, is now called __BlinkIdMultiSideRecognizer__, and should be used for scanning the documents which have information that you want to extract on more than one side

### API changes
#### `StringResult`

- `BlinkIdSingleSideRecognizer` and `BlinkIdMultiSideRecognizer` results now return nullable `StringResult` instead of `String` for the text fields, supporting multiple scripts. If we don't expect the `StringResult` on the document, that result will be `null`. If the text field is expected on the document, but we did't manage to read it, the `StringResult` will contain empty `String`.  

#### `DateResult`
- `BlinkIdSingleSideRecognizer` and `BlinkIdMultiSideRecognizer` results now return nullable `DateResult` instead of `String` for the date fields, supporting multiple scripts. If we don't expect the `DateResult` on the document, that result will be `null`. If the date field is expected on the document, but we did't manage to read it, the `DateResult` will contain empty `String`.

#### Other changes
- We have added `CardOrientation` result that can help you distinguish between `Vertical` and `Horizontal` documents. It is a part of the `ImageAnalysisResult` result.
- We have added new result property of an `AdditionalProcessingInfo` type that provides information about `missingMandatoryFields`, `invalidCharacterFields`, and `extraPresentFields`
- We have unified `DataMatchResult` and `DataMatchDetailedInfo` into a single structure `DataMatchResult` (removed `dataMatchDetailedInfo` result member)

### Minimum supported SDK version
- Minimum supported SDK version has been updated from 16 to 21. This means that the devices that have an Android version lower than Android 5.0 (Lollipop) will no longer support BlinkID SDK - all of the devices with Android 5.0 and above are still supported.

### Removed support for x86 architecture
- Devices that are based on the Intel x86 architecture, rather than ARMv7, are no longer supported. x86 and x86_64 architectures are used on very few devices today with most of them being manufactured before 2015, and only a few after that (e.g. Asus Zenfone 4). According to the Device catalog on Google Play Console, these devices make up about 1% of all Android devices (223 out of 22074 devices that have an API level of 21 and above support this architecture).

## Improvements

### Added one-line scanning
- In *BlinkID v6.0.0* we added support for one-line scanning which will make it easier to test the SDK and to do simple scans without any additional configuration. Two new classes that extend `ActivityResultContract` class have been added and that can be called in a similar way to `MbScan`.

- Classes `OneSideDocumentScan` and `TwoSideDocumentScan` can be instantiated and launched without instantiating additional `Recognizers` and `UISettings`. If you wish to just launch the scanning with default settings, it can be done with only a few lines: define an instance of a class `OneSideScanResult` or `TwoSideScanResult`  by using a function `registerForActivityResult` and passing one of the document scanners as an argument
#####Example for two-sided scan in Kotlin:
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
- It is recommended to check the result status as shown in order to avoid crashes before doing something with the result itself.
Launching the scanning is then done by a simple function call:
- 
```kotlin
twoSideScanResult.launch() 
```

- This will launch a scanning activity which will return the scanning result through callbacks and specific scan results can be obtained through result variable which is an instance of `OneSideScanResult` or `TwoScanSideResult`.


###Added onboarding screens
- New onboarding screens have been added to the SDK, providing the users with a small tutorial on how to scan properly; this will potentially improve the successful scan rate.
- Onboarding consists of two parts:
	- Introduction dialog - appears as soon as the user starts the scanning process in the shape of an overlay dialog with an instruction image and an instruction text, which can be dismissed by a press of a button
	- Onboarding dialog - appears at a press of an onboarding help button, a small FAB located in the bottom right corner, which has an additional tooltip with a "Need help?" text which is shown after a timeout or a tap on the screen
- By default, both the introduction and onboarding dialogs are set to show, and onboarding button tooltip delay is set to 12 seconds. These settings can be manually altered by configuring `BlinkIdUISettings` which are used as a parameter when the scanning function is called.
- Example - setting introduction dialog, onboarding dialog visibility, and tooltip delay time:

```kotlin
val blinkIdUISettings = BlinkIdUISettings(recognizerBundle)
blinkIdUISettings.setShowIntroductionDialog(false)   // set to true by default
blinkIdUISettings.setShowOnboardingInfo(true)        // set to true by default
blinkIdUISettings.setShowTooltipTimeIntervalMs(8000) // set to 12000 by default (in milliseconds)
```
- Onboarding help button will only be shown if the onboarding dialog is set to true
