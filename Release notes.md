# Release notes

## 5.11.0

### Newly supported identity documents:

We’ve added 98 new documents:

#### Europe
- Albania - Driver Card (front only)
- Albania - Professional Driver License (front only)
- Belarus - Driver License (front only, beta)
- Belgium - Minors ID (beta)
- Czechia - Residence Permit
- Finland - Alien ID
- Finland - Residence Permit (beta)
- Georgia - Driver License (front only)
- Greece - Residence Permit
- Ireland - Passport Card (beta)
- Ireland - Public Services Card (beta)
- Kosovo - Driver License (front only, beta)
- Latvia - Alien ID
- Luxembourg - ID Card
- Moldova - ID Card (beta)
- North Macedonia - Driver License (front only)
- North Macedonia - ID Card
- Poland - Passport (beta)
- Slovenia - Residence Permit (beta)
- Spain - Alien ID
- UK - Passport (beta)

#### Middle East and Africa 
- Algeria - Driver License
- Burkina Faso - ID Card (front only)
- Cameroon - ID Card (beta)
- Democratic Republic Of The Congo - Driver License (front only, beta)
- Egypt - Driver License (beta)
- Ghana - ID Card (beta)
- Iraq - ID Card (beta)
- Ivory Coast - Driver License (front only, beta)
- Ivory Coast - ID Card
- Lebanon - ID Card (beta)
- Morocco - Driver License
- Mozambique - Driver License (front only, beta)
- Oman - Driver License (beta)
- Rwanda - ID Card (front only)
- Senegal - ID Card
- Tanzania - Driver License (front only, beta)
- Tunisia - Driver License (front only)
- Uganda - Driver License (front only, beta)

#### Latin America & the Caribbean
- Argentina - Alien ID (beta)
- Bahamas - ID Card (front only, beta)
- Bolivia - Minors ID (beta)
- Jamaica - Driver License
- Mexico - Residence Permit (beta)
- Mexico - Chiapas - Driver License (front only)
- Mexico - Coahuila - Driver License (beta)
- Mexico - Durango - Driver License(front only, beta)
- Mexico - Guerrero-cocula - Driver License (beta)
- Mexico - Guerrero-juchitan - Driver License (beta)
- Mexico - Guerrero-tepecoacuilco - Driver License (front only, beta)
- Mexico - Guerrero-tlacoapa - Driver License (front only, beta)
- Mexico - Hidalgo - Driver License
- Mexico - Mexico - Driver License (beta)
- Mexico - Morelos - Driver License (front only)
- Mexico - Oaxaca - Driver License
- Mexico - Puebla - Driver License (front only, beta)
- Mexico - San Luis Potosi - Driver License (front only)
- Mexico - Sinaloa - Driver License (front only, beta)
- Mexico - Sonora - Driver License (beta)
- Mexico - Tabasco - Driver License (beta)
- Mexico - Yucatan - Driver License (beta)
- Mexico - Zacatecas - Driver License (beta)
- Panama - Temporary Residence Permit (beta)
- Peru - Minors ID (beta)
- Trinidad And Tobago - Driver License (front only, beta)
- Trinidad And Tobago - ID Card

#### Oceania
- Australia - South Australia - Proof Of Age Card (front only, beta)

#### Asia
- Armenia - ID Card
- Bangladesh - Driver License (beta)
- Cambodia - Driver License (front only, beta)
- India - Gujarat - Driving Licence (front only, beta)
- India - Karnataka - Driving Licence (front only, beta)
- India - Kerala - Driving Licence (beta)
- India - Madhya Pradesh - Driving Licence (front only, beta)
- India - Maharashtra - Driving Licence (front only, beta)
- India - Punjab - Driving Licence (front only, beta)
- India - Tamil Nadu - Driving Licence (beta)
- Kyrgyzstan - ID Card
- Malaysia - Mypolis (beta)
- Malaysia - Refugee ID (front only)
- Myanmar - Driver License (beta)
- Pakistan - Punjab - Driving Licence (front only, beta)
- Sri Lanka - Driving Licence (front only)
- Thailand - Alien ID (front only)
- Thailand - Driver License (beta)
- Uzbekistan - Driver License (front only, beta)

#### Northern America
- Canada - Tribal ID (beta)
- Canada - Nova Scotia - ID Card (beta)
- Canada - Saskatchewan - ID Card (beta)
- USA - Border Crossing Card (front only)
- USA - Global Entry Card (beta)
- USA - Nexus Card (beta)
- USA - Veteran ID (front only)
- USA - Work Permit
- USA - Mississippi - ID Card (beta)
- USA - Montana - ID Card
- USA - New Mexico - ID Card (beta)
- USA - Wisconsin - ID Card (beta)

#### Back side support added:
- Hungary - Residence Permit
- Luxembourg - Residence Permit (no longer beta)
- Mauritius - ID Card
- Colombia - Alien ID (no longer beta)
- Mexico - Baja California - Driver License
- Mexico - Chihuahua - Driver License
- Mexico - Guanajuato - Driver License
- Mexico - Michoacan - Driver License
- Malaysia - MyKid
- Malaysia - MyPR

#### No longer beta:
- Albania - Passport
- Malta - Residence Permit
- Switzerland - Residence Permit
- Bolivia - Driver License
- Chile - Passport
- El Salvador - ID Card
- Peru - ID Card
- Singapore - S Pass (front only)

### Changes to the BlinkId(Combined)Recognizer
- You can now retrieve an image of the document owner along with cropped images of the document itself whenever you’re scanning an AAMVA-compliant ID: 

	- Using `BarcodeId` as a `RecognitionMode` lets you scan US driver licenses and IDs that BlinkID can’t read from the Visual Inspection Zone (VIZ) alone. Use it to extract:
		- A face image from the front side
		- Barcode data from the back side
		- Cropped document images of both sides
	- You can disable this `RecognitionMode` by setting `enableBarcodeId` to `false` in the `RecognitionModeFilter`.
- We've improved data extraction through the MRZ:
	- We now allow standard M/F values for gender on Mexican documents (along with localized H/M values)
- We're now converting dates to the Gregorian calendar for:
	- Taiwan documents with Republic of China (ROC) calendar dates
	- Saudi documents with Islamic calendar dates
- We're now auto-filling all ‘partial’ dates found on identity documents (showing year or month-year only):
	- Date of issue will be converted to the first day of the (first) month
		- E.g. '1999' will be converted to '01.01.1999.'
		- E.g. '03.1999.' will be converted to '01.03.1999.'
	- Date of expiry will be converted to the last day of the (last) month
		- E.g. '1999' will be converted to '31.12.1999.'
		- E.g. '03.1999.' will be converted to '31.03.1999.'


## 5.10.0

### Improvements

- **Newly supported identity documents**

    - Saudi Arabia - DL (front)
    - Saudi Arabia - Resident ID (front)

- We've introduced another variant of `resetRecognitionState` method that lets you reset the scanning process in different recognition stages: 
- If you’re using our Direct API, call `RecognizerRunner.resetRecognitionState(false)` to clear the scanning cache as well as results gathered in a specific recognition step, i.e. after scanning the back side of a document.  
- If you’re using our built-in UI to scan IDs from the camera stream, call `RecognizerRunnerView.resetRecognitionState(false)` to do the same. 

### Changes to the BlinkId(Combined)Recognizer:

- We're now able to extract the additional address on Hungary Address Cards
- We've improved data extraction through the MRZ:
    - We now return the document type through `ClassInfo`, regardless of the `RecognitionMode` you're using (`MrzId`, `MrzPassport` or `MrzVisa`). 
    - This means you can now use `ClassFilter` to filter these documents by their type.
    - We now return the document number on Nigeria IDs complete with its check digit.
    - We now support Italy Residence Permits with a *CR* document code.
- We've extended the `ClassInfo` structure with helper methods so you can filter documents by country more easily:
    - Use `countryName`, `isoNumericCountryCode`, `isoAlpha2CountryCode` and `isoAlpha3CountryCode` to get the full country names or their representative codes defined by [ISO](https://en.wikipedia.org/wiki/List_of_ISO_3166_country_codes).
- We've extended the `BarcodeResult` structure with `extendedElements` 
    - You can find all data from AAMVA-compliant barcodes under their respective `BarcodeElementKey` in the `BarcodeElements` structure
    - For a full list of keys please see `BarcodeElementKey` enum
- We've added another `ProcessingStatus` called `AwaitingOtherSide`
    - This status is triggered once BlinkID has finished with the first side of a document and expects the other side, too.
- We're now able to extract the date of birth from the CURP field on Mexico Voter IDs
- Direct API:
	- We've added a new recognition mode for recognizing still images of documents that have already been cropped:
		- Set the `scanCroppedDocumentImage` to true when you're feeding BlinkID images of documents that have already been cropped and don't require detection.
		- Keep in mind that this setting won't work on document images that haven't been properly cropped.


### Changes to the IdBarcodeRecognizer:

- We've extended the results with `extendedElements` 
    - You can find all data from AAMVA-compliant barcodes under their respective `BarcodeElementKey` in the `BarcodeElements` structure
    - For a full list of keys please see `BarcodeElementKey` enum

### Deprecated recognizers:

-  We've deprecated `UsdlRecognizer`. Please use `IdBarcodeRecognizer` instead.

### Minor API changes

- We've replaced `Using time-limited license!` warning with `Using trial license!` warning. The warning message is displayed when using a trial license key.
- We’ve renamed `MrtdDocumentType.MRTD_TYPE_IDENITY_CARD` enum member to `MrtdDocumentType.MRTD_TYPE_IDENTITY_CARD`.

### Fixes:

- We've fixed the front-facing camera error on `Oukitel WP8 Pro`.
- We've fixed a rare crash in `BlinkIdOverlayController`, which happened as a result of rapidly launching the scanning process multiple times in a row. 

## 5.9.0

### New features:
- We’ve updated SDK's Android **target API level to 30**.
- We’ve translated the complete SDK to the **Serbian** language.
- We’ve  made the SDK safe from **tapjacking**, a form of attack where a user is tricked into tapping something he or she didn’t intend to tap. We did this by adding a new security option that prompts the SDK to discard touches when the activity's window is obscured by another visible window. To activate it, use `UISettings.setFilterTouchesWhenObscured(true)`.
- We’ve added a new feedback message to users, reminding them to keep a document fully visible in case they accidentally cover a part of it with their finger or an object. 
    - It appears while scanning the document by using `BlinkIdUISettings` and `BlinkIdOverlayController`:
    - It will display an error message "Keep the document fully visible".
    - This message is displayed only when using `BlinkIdRecognizer` or `BlinkIdCombinedRecognizer` for scanning.
- We’ve introduced a new `FrameRecognitionCallback` callback for the `RecognizerRunnerView`, which is invoked each time a camera frame from a video stream is recognized. Use `RecognizerRunnerView.setFrameRecognitionCallback` method to set the callback.

### Newly supported identity documents

- 53 documents added:
	- ALBANIA - DL (front)
	- BELGIUM - RESIDENCE PERMIT (front, back)
	- BOLIVIA - ID (front, back)
	- BOSNIA AND HERZEGOVINA - PASSPORT
	- CAMBODIA - PASSPORT
	- CANADA - RESIDENCE PERMIT (front, back)
	- CANADA - MANITOBA - ID (front)
	- CANADA - ONTARIO - HEALTH INSURANCE CARD (front)
	- CHILE - ALIEN ID (front, back)
	- CHINA - ID (front, back)
	- COLOMBIA - MINORS ID (front, back)
	- CYPRUS - RESIDENCE PERMIT (front, back)
	- CZECHIA - PASSPORT
	- GREECE - ID (front)
	- HAITI - ID (front, back)
	- ITALY - RESIDENCE PERMIT (front, back)
	- LATVIA - DL (front)
	- LATVIA - PASSPORT
	- LITHUANIA - PASSPORT
	- LUXEMBOURG - DL (front)
	- MONTENEGRO - DL (front)
	- MONTENEGRO - ID (front, back)
	- MONTENEGRO - PASSPORT
	- NETHERLANDS - RESIDENCE PERMIT (front, back)
	- NICARAGUA - ID (front, back)
	- NIGERIA - ID (front, back)
	- NORWAY - RESIDENCE PERMIT (front, back)
	- OMAN - RESIDENT ID (front, back)
	- PARAGUAY - DL (front, back)
	- PERU - DL (front, back)
	- PHILIPPINES - SOCIAL SECURITY CARD (front)
	- ROMANIA - PASSPORT
	- RUSSIA - PASSPORT
	- SERBIA - PASSPORT
	- SLOVAKIA - PASSPORT
	- SLOVENIA - PASSPORT
	- SOUTH KOREA - DL (front)
	- SPAIN - RESIDENCE PERMIT (front, back)
	- SWEDEN - RESIDENCE PERMIT (front, back)
	- THAILAND - PASSPORT
	- UKRAINE - DL (front)
	- UKRAINE - PASSPORT
	- USA - ARKANSAS - ID (front, back)
	- USA - CONNECTICUT - ID (front, back)
	- USA - GREEN CARD (front, back)
	- USA - MARYLAND - ID (front, back)
	- USA - MINNESOTA - ID (front, back)
	- USA - NEVADA - ID (front, back)
	- USA - NEW YORK CITY - ID (front, back)
	- USA - TEXAS - WEAPON PERMIT (front)
	- USA - VIRGINIA - ID (front, back)
	- VENEZUELA - DL (front)
	- VENEZUELA - PASSPORT

- Beta support added for 46 documents:
	- ALBANIA - PASSPORT
	- BAHAMAS - DL (front)
	- BERMUDA - DL (front)
	- BOLIVIA - DL (front)
	- CHILE - DL (front)
	- COLOMBIA - ALIEN ID (front)
	- DENMARK - RESIDENCE PERMIT (front, back)
	- DOMINICAN REPUBLIC - DL (front, back)
	- ECUADOR - DL (front)
	- EL SALVADOR - DL (front, back)
	- ESTONIA - RESIDENCE PERMIT (front, back)
	- GUATEMALA - DL (front, back)
	- HAITI - DL (front)
	- HONDURAS - DL (front, back)
	- HONDURAS - ID (front, back)
	- HUNGARY - ADDRESS CARD (front, back)
	- HUNGARY - RESIDENCE PERMIT (front)
	- ICELAND - DL (front)
	- ISRAEL - ID (front, back)
	- JAPAN - DL (front)
	- JORDAN - DL (front)
	- LATVIA - ALIEN PASSPORT
	- LATVIA - RESIDENCE PERMIT (front, back)
	- LUXEMBOURG - RESIDENCE PERMIT (front)
	- MALTA - RESIDENCE PERMIT (front, back)
	- MEXICO - BAJA CALIFORNIA - DL (front)
	- MEXICO - CHIHUAHUA - DL (front)
	- MEXICO - CIUDAD DE MEXICO - DL (front)
	- MEXICO - PROFESSIONAL DL (front)
	- MEXICO - GUANAJUATO - DL (front)
	- MEXICO - MICHOACAN - DL (front)
	- MEXICO - TAMAULIPAS - DL (front, back)
	- MEXICO - VERACRUZ - DL (front, back)
	- PHILIPPINES - TAX ID (front)
	- PHILIPPINES - VOTER ID (front)
	- POLAND - RESIDENCE PERMIT (front, back)
	- PORTUGAL - RESIDENCE PERMIT (front, back)
	- PUERTO RICO - VOTER ID (front)
	- SLOVAKIA - RESIDENCE PERMIT (front, back)
	- SOUTH KOREA - ID (front)
	- SWITZERLAND - RESIDENCE PERMIT (front, back)
	- TAIWAN - TEMPORARY RESIDENCE PERMIT (front)
	- TURKEY - RESIDENCE PERMIT (front)
	- USA - KANSAS - ID (front, back)
	- VENEZUELA - ID (front)
	- VIETNAM - DL (front)

- Added back side support for 7 documents:
	- ARGENTINA - ID
	- ECUADOR - ID
	- FINLAND - ID
	- NIGERIA - DL
	- QATAR - RESIDENCE PERMIT
	- URUGUAY - ID
	- USA - NEW YORK - DL

- 9 documents are no longer beta:
	- BRAZIL - DL
	- CANADA - ALBERTA - ID
	- MALAYSIA - MyKAS
	- MEXICO - NUEVO LEON - DL
	- PANAMA - DL
	- PORTUGAL - DL
	- SAUDI ARABIA - ID
	- SRI LANKA - ID
	- USA - IDAHO - ID


### New features and updates to the `BlinkIdRecognizer` and `BlinkIdCombinedRecognizer`

- We’re now able to read partial MRZ formats (2.5 lines), like the ones found on Switzerland and Liechtenstein DLs.
- We’ve added `documentOptionalAdditionalNumber` to the main part of the result, as well as front and back side VIZ results.
- We’ve expanded the set of possible recognizer states with `StageValid`. This state fixes `BlinkIDCombinedRecognizer` timeout issues, and enables better control of the Combined scanning pipeline. It activates when the first side of a document has been successfully scanned and scanning of the second side is required.

### Fixes

- We’ve fixed an uncommon bug where you’d get incomplete results upon scanning of the MRZ with the `allowUnparsed` setting enabled. 
- SDK does not require permission `android.permission.ACCESS_NETWORK_STATE` to unlock itself anymore, in cases when the license key needs online activation.


## 5.8.0

### New features:

* We added user feedback when turning ON the flashlight on `BlinkIdOverlayController`:
	* It warns the user to watch out for flashlight glare.
	* It can be disabled by using `BlinkIdUISettings.setShowFlashlightWarning(false)` option.

### New additions to our supported documents list

#### Plastic page passports

We added support for scanning the visual inspection zone - VIZ includes everything except MRZ or barcode. Keep in mind that BlinkID scans and extracts data only from the VIZ that is on the first **plastic page** found in the passport list below:

* **Chile** Passport (BETA)
* **Colombia** Passport
* **Croatia** Passport
* **Denmark** Passport
* **Finland** Passport (BETA)
* **Germany** Passport
* **Hong Kong** Passport (BETA)
* **Ireland** Passport (BETA)
* **Malaysia** Passport
* **Netherlands** Passport
* **New Zealand** Passport
* **Norway** Passport
* **Singapore** Passport
* **South Africa** Passport
* **Sweden** Passport
* **Turkey** Passport (BETA)

If you need to scan the MRZ only, you can always set the "MRZ Passport" [recognition mode](https://blinkid.github.io/blinkid-android/com/microblink/entities/recognizers/blinkid/generic/RecognitionModeFilter.html#enableMrzPassport).
​
#### Vertical US documents

* **California** ID
* **Illinois** ID
* **New York** ID
* **North Carolina** ID
* **Texas** ID

#### Other documents

* **Canada** Newfoundland and Labrador DL
* **Croatia** Residence Permit (BETA)
* **Guatemala** Consular ID
* **Malaysia** MyKAS (BETA)
* **Mexico** Jalisco DL / front side only
* **Mexico** Nuevo Leon DL (BETA)
* **Peru** ID (BETA)
* **Singapore** S Pass (BETA)
* **Uruguay** ID / front side only
* **USA** Missouri ID
* **USA** Texas ID

#### European DLs with a single line MRZ

BlinkID extracts data from driver’s licenses that contain single line MRZ:

* **Croatia** DL
* **Estonia** DL
* **France** DL
* **Ireland** DL
* **Netherlands** DL
* **Slovakia** DL

#### Back side supported on:
* **Azerbaijan** ID
* **Singapore** DL
* **Singapore** Employment Pass

#### No longer BETA
* **Slovakia** DL

### New features and updates in BlinkId(Combined)Recognizer

* We added `signatureImage` to the result. Extract signature image from the documents below:
	* Australia Victoria DL
	* Austria ID
	* Austria DL
	* Brunei Military ID
	* Colombia ID
	* Croatia ID (on 2013 and 2015 versions)
	* Cyprus ID
	* Czechia ID (on the 2012 version)
	* Germany ID (2010 version)
	* Germany DL (2013 version)
	* Indonesia ID
	* Ireland DL
	* Italy DL
	* Mexico Voter ID
	* New Zealand DL
	* Slovenia ID
	* Spain DL
	* Sweden DL
	* Switzerland ID
	* UAE ID
	* UAE Resident ID

* We enabled extraction of the **date of birth** from the **NRIC** from Malaysian documents:
	* MyKad
	* MyKas
	* MyKid
	* MyPR
	* MyTentera

* We added anonymization support for:
	* MRZ (OPT2 containing the ID number) on China Mainland Travel Permit Hong Kong
	* MRZ (Document number) on Germany Alien Passport
	* Document number, MRZ (Document number) on Germany ID
	* MRZ (Document number) on Germany Minors Passport
	* MRZ (Document number) on Germany Passport
	* Document number on Hong Kong ID
	* MRZ (Document number, OPT1 containing the passport or ID number) on Hong Kong Passport
	* Personal ID number on Netherlands DL
	* Personal ID number, MRZ (OPT1 containing the BSN) on Netherlands ID
	* MRZ (OPT1 containing the BSN) on Netherlands Passport
	* Document number on Singapore DL
	* Personal ID number on Singapore Employment Pass
	* Document number on Singapore FIN Card
	* Document number on Singapore ID
	* MRZ (Document number, OPT1 containing the NRIC) on Singapore Passport
	* Document number on Singapore Resident ID
	* Document number on Singapore S Pass
	* Personal ID number on Singapore Work Permit
	* MRZ (OPT1 containing the resident registration number) on South Korea Diplomatic Passport 
	* MRZ (OPT1 containing the resident registration number) on South Korea Passport
	* MRZ (OPT1 containing the resident registration number) on South Korea Residence Passport
	* MRZ (OPT1 containing the resident registration number) on South Korea Service Passport
	* MRZ (OPT1 containing the resident registration number) on South Korea Temporary Passport
* We improved MRZ data extraction on:
	* **Russia Passport**

### Other features and updates

* We added the field `middleName` to `BlinkId(Combined)Recognizer`, `IdBarcodeRecognizer` and `Usdl(Combined)Recognizer` results. This field is extracted from AAMVA standard compliant barcodes, whenever available.

### Deprecated recognizers

We have deprecated the following recognizers:

- `PassportRecognizer`, `VisaRecognizer` - **use `BlinkIdCombinedRecognizer` or `BlinkIdRecognizer` instead**

- `DocumentFaceRecognizer`, `MrtdRecognizer` - **use `BlinkIdRecognizer` instead**

- `MrtdCombinedRecognizer` - **use `BlinkIdCombinedRecognizer` instead**

- `UsdlRecognizer` - **use `IdBarcodeRecognizer` instead**

### Major API change

`ScanResultListener` interface now has an additional method called when the scanning cannot continue because of an unrecoverable error. You have to implement `onUnrecoverableError` method.
If you’re using built-in activities, when `onActivityResult` is called with `RESULT_CANCELED` result code, the exception will be available via `ActivityRunner.EXTRA_SCAN_EXCEPTION` intent extra. If the user canceled the scan, the exception would be `null`.

### Fixes

* We improved the data match logic for **Guatemala Consular ID** in BlinkId(Combined)Recognizer.
* We fixed race conditions in camera management, which in some cases caused that the camera was unable to resume after it has been paused.

## 5.7.0

## New features
- We translated complete SDK to the following additional languages: **Malay**, **Dutch**, **Hungarian**, **Slovenian**, **Indonesian**, **Arabic(UAE)**, **Romanian**, **Chinese traditional**, **Chinese simplified**, **Thai**, **Hebrew**, **Vietnamese**, **Filipino**.

## Improvements to existing features:

- We have improved parsing of **MRZ** formats deviating from the ISO/IEC 7501 standard:
	- Document discriminator was in place of the document number on driver licenses and IDs from:
		- **New York** 
		- **Michigan** 
		- **Canada**
	- Different check digit calculation for **Mexico** (Consular) ID
	- Recognition of the unofficial `XCT` country code for Northern **Cyprus** ID
	- Recognition of different country codes and check digit calculation on **China** Mainland Travel Permit for Hong Kong and Macao Residents
- We added **anonymization** support for:
	- MRZ on the Mainland Travel Permit for Hong Kong and Macao Residents
- We have made some changes to the **BlinkID(Combined)Recognizer**
	- You can now see `ProcessingStatus` in the results to inspect potential processing errors, such as when barcode detection fails, a mandatory field is missing, etc. 
	- You can now also see a more detailed `ImageAnalysisResult` showing you when: 
		- Face image is detected
		- MRZ is detected
		- Barcode is detected
	- We added a `RecognitionModeFilter` settings group. You can toggle flags on this object to control the recognition mode of the recognizer:
		- `enableMrzId` lets you scan MRZ on all identity documents except visas and passports.
		- `enableMrzVisa` lets you scan MRZ on visa documents.
		- `enableMrzPassport` lets you scan MRZ on passports.
		- `enablePhotoId` lets you scan photo IDs. Use it to enable or disable document and face image extraction on unsupported documents.
		- `enableFullRecognition` lets you scan all data from our [supported](https://github.com/BlinkID/blinkid-android/blob/master/documentation/BlinkIDRecognizer.md) documents.
		- Your license key still controls which of the above recognition modes are allowed.
	- We have added a `RecognitionMode` result member describing which recognition mode was used to produce the results.
	-  We are now retrieving sex and nationality fields from the MRZ in cases where those two fields cannot be found in the document’s VIZ. Previously, we only used to do this for dates, name fields and document numbers. 
	- We are now preserving the original string (raw data) of the dates we couldn’t parse.
- We have improved the thresholds for card detection feedback messages ("move closer" and "move farther"). This will improve the UX when scanning in landscape mode as the document can now be closer to the camera.

## Minor API Changes
- We have made some changes to the `BlinkIDRecognizer` and `BlinkIDCombinedRecognizer`:
	- We renamed `DocumentImageMoireStatus` to `ImageAnalysisDetectionStatus`
	- We grouped the `conditions` member from the results with the `DriverLicenseDetailedInfo` structure
- We renamed `RecogitionMode` to `RecognitionDebugMode` in `RecognizerBundle`.

## Bug fixes:
- We fixed an issue in default UI that was causing reticle to reappear while card flip animation was showing.
- We fixed [Issue #220](https://github.com/BlinkID/blinkid-android/issues/220)  - methods marked with `@NonNull` no longer return `null`.

## 5.6.0

### New features:

- In `BlinkIdCombinedRecognizer` and `BlinkIdRecognizer` we added:
    - Support for US documents with **vertical** orientations:
        - Alabama DL
        - Arizona DL
        - California DL
        - Colorado DL
        - Connecticut DL
        - Georgia DL
        - Illinois DL
        - Iowa DL
        - Kansas DL
        - Kentucky DL
        - Maryland DL
        - Massachusetts DL
        - Minnesota DL
        - Missouri DL
        - New Jersey DL
        - Ohio DL
        - Pennsylvania DL
        - South Carolina DL
        - Tennessee DL
        - Texas DL
        - Utah DL
        - Washington DL
        - Wisconsin DL
    - Support for **new document types**:
        - Croatia Health Insurance Card / front side / BETA
        - Ecuador ID / front side
        - El Salvador ID / BETA
        - Sri Lanka ID / BETA
    - No longer BETA:
        - Canada Nova Scotia DL
        - Canada Yukon DL
        - Norway DL
    - Back side support:
        - Kenya ID
    - **Result anonymization** - with this option enabled, results are not returned for protected fields on documents listed here. The full document image will also have this data blacked out.
        - Protected fields are:
             - Document number on Hong Kong ID
             - MRZ on Hong Kong passports
             - Personal ID number on Netherlands DL
             - Personal ID number and MRZ on Netherlands ID
             - MRZ on Netherlands passports
             - Document number on Singapore DL, ID, Fin Card, Resident ID
             - Personal ID number on Singapore Employment Pass
             - Document number and personal ID number on Singapore Work Permit
             - MRZ on Singapore passports.
        - By using `setAnonymizationMode` method, you can choose the `AnonymizationMode` : `ImageOnly`, `ResultFieldsOnly`, `FullResult` or `None`.
        - `FullResult` anonymization (both images and data) is set by default.

- We added support for new **MRZ** formats:
    - Guatemala ID
    - Kenya ID

### Improvements to existing features:

- We updated `UsdlRecognizer.Result` and `IdBarcodeRecognizer.Result` with additional address fields:
    - `street`, `postalCode`, `city` and `jurisdiction` 
- We added `isExpired()` method to `BlinkIdRecognizer.Result`, `BlinkIdCombinedRecognizer.Result` and `IdBarcodeRecognizer.Result`.
    - It compares the current time on the device with the date of expiry and checks whether the document has expired or not. 
- We made changes to the result structure of `BlinkIdCombinedRecognizer` and `BlinkIdRecognizer`:
    - Barcode data is now encapsulated in its own result structure: `BarcodeResult`.
    - Data from all OCR-ed fields, without MRZ data, is now encapsulated in a `VizResult` structure, representing the "Visual Inspection Zone" data. In `BlinkIdCombinedRecognizer`, front side data is available in its own structure (`frontVizResult`), back side data in its own (`backVizResult`), so you can now **access data from each side separately**.
    - The main part of the result, outside these structures, is filled according to these rules:
        - Document number is filled with data from the MRZ, if present.
        - Remaining data is then filled with barcode data.
        - Remaining data is filled from the back side's visual inspection zone (OCR data outside of MRZ).
        - Remaining data is filled from the front side's visual inspection zone.
        - Remaining data is filled with data from the MRZ.

### Minor API changes:

- We moved `BlinkIdRecognizer.Result` members `colorStatus` and `moireStatus` to the result's `imageAnalysisResult` (`frontImageAnalysisResult` and `backImageAnalysisResult` in `BlinkIDCombinedRecognizer.Result`).
- We changed default `IntentDataTransferMode` to `IntentDataTransferMode.PERSISTED_OPTIMISED`. It can be configured by using `MicroblinkSDK.setIntentDataTransferMode`.

### Bug fixes:

- We fixed US driver's license address extraction (Oregon, Mississippi, Rhode Island).
- We fixed a bug which caused that, in some cases, camera has not been resumed after the device screen was turned OFF and back ON.


## 5.5.0

### New features:

- In `BlinkIdCombinedRecognizer` and `BlinkIdRecognizer` we added:
	- Support for obtaining full document image for IDs with barcodes. Now you can capture document image and extract barcode data with a single scan.
	- Scanning & data extraction for  travel visas and passports.
	- Field validation - we validate if the results from certain fields match predefined character sets.
			- If validation fails, the recognizer's state is `Recognizer.Result.State.Uncertain`.
			- Use `setValidateResultCharacters()`to enable or disable validation.
	- Field anonymization for sensitive data.
			- Enable or disable whether certain sensitive data should be anonymized in full document image result.
			- Use `setAnonymizeImage()` to enable or disable image anonymization.
	- Support for new document types:
		- Australia New South Wales - ID Card / Front only / BETA
		- Brazil - Driver License / BETA
		- Brunei - Military ID / BETA
		- Brunei - Residence Permit / BETA
		- Brunei - Temporary Residence Permit / BETA
		- Ghana - Driver License / Front only
		- Latvia - ID Card
		- Norway - Driving Licence / Front only / BETA
		- Oman - ID Card
		- Saudi Arabia - ID Card / BETA
		- Sweden - Social Security Card / Front only
		- USA - Social Security Card / BETA
		- Back side supported:
			- Malaysia - MyTentera
	
	
	- No longer BETA:
		- Australia Tasmania - Driving Licence
		- Canada British Columbia - ID Card
		- Germany - Residence Permit
		- Morocco - ID Card
		- Nigeria - Voter ID
		- Singapore - Work Permit
		- USA Alaska - ID Card
		- USA District Of Columbia - Driver License
		- USA Indiana - ID Card
		- USA Kentucky - ID Card
	
	- Barcode scanning on the following documents:
		- Argentina ID
		- Colombia ID
		- Nigeria Voter ID
		- South Africa ID

### Improvements for existing features:

- Improvements in `BlinkIdCombinedRecognizer` and `BlinkIdRecognizer`:
	- Documents discarded with the class filter are now reported as not supported
		-  `ClassifierCallback.onDocumentSupportStatus(false)` will be called if a documents is filtered out by the `ClassFilter`
	- For Malaysian MyKad we are now returning if a Moire pattern is present on the scanned document (detected or not detected).
		- use `getDocumentImageMoireStatus()` in `BlinkIdRecognizer`.
		- use `getDocumentFrontImageMoireStatus()` and `getDocumentBackImageMoireStatus()` in `BlinkIdCombinedRecognizer `.
- We added digital signature support to `PassportRecognizer`. 
- We updated `IdBarcodeRecognizer.Result` with specific driving license info.
	- Use `getRestrictions()`, `getEndorsements()` and `getVehicleClass()`.
- We enabled usage of combined recognizers through the Direct API:
    - Recognition state is not automatically reset with every image that comes to the recognition through the Direct API. If reset is required, you should call `RecognizerRunner.resetRecognitionState()`

### Bug fixes:

- We fixed bug in `BlinkIdCombinedRecognizer` and `BlinkIdRecognizer` which caused that dates on Belgian ID cards are not parsed correctly in cases when month is July.


## 5.4.0

### Breaking change:

Based on the feedback, we have restored support for **x86_64** processor architecture. Due to the architecture specifics, there is no guarantee that the scanning process will work equally well as it does on the ARM architectures. The main reason for restoring support is to ease the compliance issue for developers.
We distribute SDK with **ARMv7**, **ARM64**, **x86**, and **x86_64** native library binaries.

### New features:

- We added age verification feature:
    - Now you can more easily obtain the age of the document owner in years and check whether it is above some age limit.
    - Use `age` and `ageLimitStatus` helper methods in `MrzResult`, `BlinkIdRecognizer.Result`, `BlinkIdCombinedRecognizer.Result`, `UsdlRecognizer.Result`, `UsdlCombinedRecognizer.Result`, and `IdBarcodeRecognizer.Result`.

### Improvements:

- We have translated complete SDK to following languages: **Croatian**, **Czech**, **English**, **French**, **German**, **Italian**, **Portuguese**, **Slovak**, and **Spanish**.

- We added support for new document types in `BlinkIdCombinedRecognizer` and `BlinkIdRecognizer`:

    - Australia - Australian Capital Territory - Driving licence / front only
    - Australia - Northern Territory - Driving licence / BETA
    - Australia - Tasmania - Driving licence / front only / BETA
    - Canada - Alberta - ID card / BETA
    - Canada - British Columbia - Driver license / Public services card (Combined) 
    - Canada - British Columbia - ID card / BETA
    - Canada - British Columbia - Public services card
    - Canada - New Brunswick - Driving license
    - Canada - Nova Scotia - Driving license / BETA
    - Canada - Yukon - Driving license / BETA
    - Panama - Driving license / front only / BETA
    - Panama - ID card / front only
    - Singapore - Work permit / BETA
    - Taiwan - ID card / front only / BETA
    - USA - Alabama - ID card
    - USA - Alaska - ID card / BETA
    - USA - District Of Columbia - Driver license / BETA
    - USA - Idaho - ID card / BETA
    - USA - Indiana - ID card / BETA
    - USA - Kentucky - ID card / BETA
    - USA - Massachusetts - ID card
    - USA - Oregon - ID card
    - USA - Washington - ID card
    - We added support for back side to:
        - Australia - Western Australia - Driving licence
        - Mexico - Voter ID
        - Netherlands - Driving licence
- Additional improvements in `BlinkIdCombinedRecognizer` and `BlinkIdRecognizer`:
    - When the back side of the document is not fully supported by the `BlinkIdCombinedRecognizer`, we will capture and return the back side image without performing data extraction. You can disable this behaviour by using `BlinkIdCombinedRecognizer.setSkipUnsupportedBack(true)`.
    - We are now returning color status for the scanned document (black and white or color) in the following result fields:
        - `documentImageColorStatus` in `BlinkIdRecognizer.Result`.
        - `documentFrontImageColorStatus` and `documentBackImageColorStatus` in `BlinkIdCombinedRecognizer.Result`.
    - We are now returning `ClassInfo` which holds the following information about the scanned document: `Country`, `Region`, and `Type` of the document. Use  `BlinkIdRecognizer.Result.getClassInfo()` and `BlinkIdCombinedRecognizer.Result.getClassInfo()`.
    - We introduced `ClassFilter` which determines whether a document should be processed or is filtered out, based on its `ClassInfo`. Use  `BlinkIdRecognizer.setClassFilter` and `BlinkIdCombinedRecognizer.setClassFilter` to enable it.
    - To improve the scanning performance, we added additional feedback for users that ensures a detected document is entirely inside the frame. When a document is too close to the edge of the camera frame, we will display an appropriate message to the user in `BlinkIdOverlayController`. You can configure the minimum distance from the edge of the frame by using the `paddingEdge` settings method.

- Improvements in `BlinkIdOverlayController`:
    - When a document is too close to the edge of the camera frame, we display *`Move the document from the edge`* message.
    - We added better user instructions when barcodes are being scanned in `UsdlCombinedRecognizer`. We display *`Scan the barcode`* message.
- We are now delivering the complete list of open source dependencies used in the SDK. Please check the `open-source-software-used` directory.

### Minor API changes:

- We removed `RecognizerRunnerView` custom attributes: `mb_initialOrientation` and `mb_aspectMode`. Use `RecognizerRunnerView.setInitialOrientation` and `RecognizerRunnerView.setAspectMode` to configure the attributes in the code.

### Bug fixes:

- We fixed bug in `BlinkIdOverlayController` which caused that `MrtdRecognizer.Result` is cleared after scanning is done and empty result is returned.

## 5.3.0

### Breaking change:

We decided to remove support for **x86_64** processor architecture.
 **x86** and **x86_64** architectures are used on very few devices today; most of them are manufactured before 2015 and they take about 1% of all Android devices, according to the device catalog on Google Play Console.
We distribute SDK with **ARMv7**, **ARM64**, and **x86** native library binaries. Native library x86 in SDK is kept mainly for emulator support.

### New features:

- We added a new recognizer specialized for scanning and parsing barcodes on various identity cards - `IdBarcodeRecognizer`.  Supported document types are:
    - AAMVA compliant (US DL, Canada DL, etc.)
    - Argentina ID
    - Panama ID
    - Colombia ID
    - South Africa ID
    - Nigeria Voter ID and driver license

- We added the option to disable Microblink logs in the console output. Use `LoggingSettings.disableMicroblinkLogging()`. Be careful with this option. We need full log outputs from the application for support purposes. In case of having problems with scanning certain items, undesired behavior on the specific device(s), crashes inside SDK or anything unmentioned, we will need a full log from your side. If you disable Microblink logging, you won't be able to provide us this information. Hence support might be limited.

### Improvements for existing features:

- We added new result fields in `MrzResult`, returned by all recognizers which scan MRZ (Machine Readable Zone):
    - `issuerName`
    - `nationalityName`
- Improvements in `BlinkIdCombinedRecognizer` and `BlinkIdRecognizer`:
    - new recognizer options: `allowUnparsedMrzResults` and `allowUnverifiedMrzResults`
    - new result field: `dateOfExpiryPermanent`
    - support for 14 new document types: `South Australia DL`, `Bosnia and Herzegovina DL`, `Canada Ontario ID`, `Costa Rica DL`, `Denmark DL`, `Estonia DL`, `Finland DL`, `Kenya ID`, `Lithuania DL`, `Malaysia MyPR`, `Malta DL`, `Mexico Consular ID`, `Nigeria Voter ID`, `Philippines Professional ID`
    - improved support for: `USA Hawaii DL`, `Colombia DL`, `Costa Rica ID`, `France ID`, `India ID`, `Kazakhstan ID`, `Kuwait Resident ID`, `Israel DL`, `Kuwait DL`, `Thailand ID`

### Minor API changes:

- `CameraPermissionManager` constructor accepts object of type `CameraPermissionManager.ResourceIds` as a second parameter which can be used to customise "ask permission" layout - for previously used layout, use default implementation `com.microblink.hardware.camera.CameraPermissionManagerResources`
- `RecognizerRunnerFragment` extends `androidx.fragment.app.Fragment`, instead of deprecated `android.app.Fragment`
- All provided scan activities extend `AppCompatActivity`

### Bug fixes:

- We fixed crash when using Direct API on high resolution `com.microblink.image.Image` from `HighResImageWrapper`


## 5.2.0

### Improvements:

- **overall size impact on application reduced for almost 30%** when BlinkID SDK v5.2 is used, relative to size impact of the previous v5.1
- enabled setting `MrzFilter` on `MrtdCombinedRecognizer`:
    - determines whether document should be processed or it is filtered out, based on its MRZ (Machine Readable Zone)
    - this feature is also available for `MrtdRecognizer` 
-  added Canada Alberta DL support for `BlinkIdRecognizer` and `BlinkIdCombinedRecognizer`
- enabled scanning back sides of 6 documents with `BlinkIdCombinedRecognizer`:
    - Czechia ID
    - Egypt ID
    - Germany ID
    - Italy ID
    - Pakistan Consular ID
    - Pakistan ID
- added property `localizedName` to `BlinkIdRecognizer.Result` and `BlinkIdCombinedRecognizer.Result` (CCC to Chinese alphabet conversion for Hong Kong ID)
- enabled digital signing of `BlinkIdCombinedRecognizer.Result`
- improved camera performance on some Samsung devices

### Minor API changes:

- `MrzFilter` now accepts `MrzResult` for filtering, previously filtering has been performed based on the given `MrtdRecognizer` result.
- `RecognizerRunner.getSingletonInstance()` does not throw `FeatureNotSupportedException` anymore

### Bug fixes:

- `BlinkIdCombinedRecognizer` - fixed issue when the front side of a document was returned as a back side

## 5.1.0

### New features:

- added 38 new documents for `BlinkIdRecognizer` and `BlinkIdCombinedRecognizer`: Algeria ID, Argentina DL, Australia Victoria DL, Australia Queensland DL, Australia Western Australia DL, Belgium Resident ID, Canada British Columbia DL, Canada Ontario DL, Canada Quebec DL, Cyprus ID, Czechia DL, Czechia ID, Egypt ID, Greece DL, India ID, India Pan Card, Israel DL, Malaysia MyKid, Malaysia MyTentera, Maldives ID, Morocco ID, Nigeria DL, Paraguay ID, Portugal DL, Puerto Rico DL, Qatar DL, Russia DL, Singapore Fin Card, Singapore Resident ID, Slovakia DL, Slovenia DL, South Africa DL, South Africa ID, Thailand ID, Tunisia ID, UAE DL, Uganda ID and Vietnam ID.
Details on each new document and the complete list of the supported documents is [here](https://github.com/BlinkID/blinkid-android/blob/cf93a77081a1f92806255ca44292c28f2989c472/documentation/BlinkIDRecognizer.md).

### Improvements:

- **overall size impact on application reduced for almost 50%** when BlinkID SDK v5.1 is used, relative to size impact of the previous v5.0
- added new fields in `MrzResult`:
    - `sanitizedDocumentCode`
    - `sanitizedDocumentNumber`
- improved `BlinkIdRecognizer` and `BlinkIdCombinedRecognizer`:
    - introduced blur filter that discards blurred frames and prevents reading data from them. This option is enabled by default, it can be disabled by using `BlinkIdRecognizer.setAllowBlurFilter(false)` and `BlinkIdCombinedRecognizer.setAllowBlurFilter(false)` 

## 5.0.1

### New features:

- new options in `BlinkIdUISettings`, `DocumentUISettings`, `DocumentVerificationUISettings` and `BlinkIdOverlaySettings`:
    - option to disable displaying of "Document Not Supported" dialog when `BlinkIdRecognizer` or `BlinkIdCombinedRecognizer` is used in combination with other recognizers - use method `setShowNotSupportedDialog`
    - option to configure back side scanning timeout - use `setBackSideScanningTimeoutMs`
- it is possible to set theme that will be used by activity launched from the UISettings - use UISettings.setActivityTheme

### Minor API changes:
- all scan activity classes are final now

### Bug fixes:
- fixed problems with aspect ratio of camera preview on Huawei Mate 10

## 5.0.0

### **BlinkID v5 Release Announcement**

We are very proud to announce BlinkID v5, the latest upgrade of our most popular product. BlinkID v5 is our first product powered entirely by machine learning.

#### Highlights in the BlinkID v5 Release

BlinkID v5 introduces improvements in the speed and accuracy of scanning and data extraction, and you will find:

- Best-in-class card detection.
- Automatic classification of different document types (no need to preselect the country or document type). 
- Innovative and seamless UX with real-time instructions for the users.
- Data matching – we match the expiry date, DOB, date of issue, and document number captured from the front side with the data from the barcode or MRZ on the back.

Besides the new features listed above, we have worked on the improved performance of several other document components:

- Scanning of all documents with MRZ (IDs, passports, travel visas), or PDF417 barcodes.
- Scanning and data extraction of the front side of US driver’s licenses and IDs (horizontal).
- Capturing cropped face image supported even on vertical documents, passports and travel visas.
- Capturing document image.

#### Integration improvements

One of the main benefits that BlinkID v5 will bring is scalability and faster support for new document types.

- The integration of the mobile SDK will be significantly easier and faster.
- Mobile SDK build size will be much smaller.

#### How to get started and plan your upgrade?

BlinkID v5 mobile SDK release is currently available for native platforms.

- It’s advisable to get familiar with the range of supported document types. We will keep adding support for new documents and regularly update [the list on Github](https://github.com/BlinkID/blinkid-android/blob/master/documentation/BlinkIDRecognizer.md).
- If currently supported document types are not yet supported in BlinkID v5 please follow future releases.
- To upgrade to BlinkID v5, you will need to obtain a new license key specifically for the document types that you require.
- Already licensed production keys will continue to work as usual, until you decide to upgrade.
- What if you require document types supported in the previous version (and not yet added in BlinkID v5) and another document type supported in BlinkID v5? That’s manageable, and in that case, we will create a custom build for you.

We strongly recommend checking the [list of supported document types](https://github.com/BlinkID/blinkid-android/blob/master/documentation/BlinkIDRecognizer.md) regularly. Please star and watch this repository, and take the time to test BlinkID v5 as much as possible.

Your opinion, especially on the performance and redesigned UX is very important for future developments. We would appreciate your feedback at blinkid@microblink.com.

### Major API changes:

- removed all country specific recognizers - use `BlinkIdRecognizer` and `BlinkIdCombinedRecognizer` which classify and extract data from all countries that have been supported by country specific recognizers available in 4.x.x versions of the SDK
- available recognizers are:
    - `BlinkIdRecognizer` and `BlinkIdCombinedRecognizer`
    - `MrtdRecognizer` and `MrtdCombinedRecognizer`
    - `UsdlRecognizer` and `UsdlCombinedRecognizer`
    - `DocumentFaceRecognizer`
    - `PassportRecognizer`
    - `VisaRecognizer`
- detectors, parsers and barcode recognizers are removed from this version onward
- `Templating API` is no longer supported
- `field by field` scanning feature is no longer supported
- SDK has been migrated to **AndroidX** dependencies - previous SDK dependency com.android.support:appcompat-v7 has been replaced with  **androidx.appcompat:appcompat**

### New features:

- `BlinkIdRecognizer` and `BlinkIdCombinedRecognizer` now support new document types from different countries, all supported document types are listed [here](https://github.com/BlinkID/blinkid-android/blob/c76754bf6dcd1f6c9d39bb1fefe613273dd701f2/documentation/BlinkIDRecognizer.md)

### Minor API changes:
- in combined recognizers results, `documentDataMatch` value is now returned as `DataMatchResult` enum with three possible values: `NotPerformed`,  `Failed` and `Success`
- new API for configuring camera options on `UISettings` -  use `UISettings.setCameraSettings`, which accepts object of `CameraSettings` type

## 4.11.1

### Bug fixes:

- fixed crash on some devices that use armeabi-v7a ABI - SDK was unable to reserve address space due to memory fragmentation
- fixed camera busy error in camera management that was happening during the quick closing and opening of the camera
- fixed rare crash on Samsung J5 Prime which has been caused by race condition during the initialization of native camera frame

## 4.11.0

### New features:

- added support for reading front and back side of Belgium ID - use `BelgiumIdFrontRecognizer`, `BelgiumIdBackRecognizer` and `BelgiumCombinedRecognizer`
- added support for reading all visa documents containing Machine Readable Zone - use `VisaRecognizer`

### Improvements for existing features:

- improved `MrtdRecognizer`: 
    - added support for documents with non-binary gender specification (symbol X)
- improved `DocumentFaceRecognizer`:
    - improved scanning time (faster scan)
    - added support for vertical IDs
    - removed the `tryBothOrientations` option (improved scan in all directions is enabled by default)
- improved scanning time (faster scan) for `PassportRecognizer`

### Minor API changes:

- FieldByFieldOverlay is now configured by using FieldByFieldOverlaySettings instead of FieldByFieldUISettings
- DocumentVerificationUISettings and DocumentUISettings now support BlinkID recognizer
- BlinkIdUISettings now allow customisation of strings, colors and icons
- moved some classes to new packages

### Bug fixes:

- fix for document not supported never reported if using BlinkIdRecognizer wrapped in SuccessFrameGrabberRecognizer

## 4.10.0

### New features:
- added `BlinkIdRecognizer` for scanning front side of ID cards and `BlinkIdCombinedRecognizer` for combined scanning of front and back side of ID cards
    - for now, these recognizers classify and extract data from **87** different classes of **United States driver's licenses and IDs** (front and back side)
    - list of all supported document types can be found [here](https://github.com/BlinkID/blinkid-android/blob/d2112fa823377ec932e0c3f123dfc1a8fbdb4e3c/documentation/BlinkIDRecognizer.md)
    - in the upcoming releases, we are planning to add support for more document types from different countries
- completely new UX for scanning ID cards with new scan activity and overlay: `BlinkIdActivity` and `BlinkIdOverlayController`:
    -  best suited for scanning with `BlinkIdRecognizer` and `BlinkIdCombinedRecognizer`
    - other single side and combined document recognizers are also supported
- added support for reading back side of Nigerian Voter ID card - use `NigeriaVoterIdBackRecognizer`

### Improvements for existing features:
- improved `RomaniaIdFrontRecognizer`
    - now extracts `CNP` number
- improved `SloveniaIdFrontRecognizer` and `SloveniaCombinedRecognizer`:
    - return boolean flag which indicates whether **date of expiry** is permanent - use `SloveniaIdFrontRecognizer.Result.isDateOfExpiryPermanent()` and `SloveniaCombinedRecognizer.Result.isDateOfExpiryPermanent()`
- improved `GermanyPassportRecognizer`:
    - better passport classification
- improved `ColombiaIdFrontRecognizer`:
    - support for document number in format 1-3-3
- improved `SlovakiaIdFrontRecognizer`:
    - support for German letters
- Malaysia:
    - `MalaysiaMyTenteraFrontRecognizer` supports 6-digit army number
    - `MalaysiaIkadFrontRecognizer` - better extraction of the following fields (**DeepOCR** support): date of birth, sector, employer, address and date of expiry
- United Arab Emirates:
    - glare detection is disabled by default for `UnitedArabEmiratesIdFrontRecognizer` and `UnitedArabEmiratesIdBackRecognizer` 
    - `UnitedArabEmiratesIdBackRecognizer` - optimized detection for black backgrounds

### Minor API changes:
- overlay controllers are no longer using UI settings, they're now using Overlay settings, you can convert UI settings to Overlay settings like this: `uiSettings.toOverlaySettings()` 
- `Recognizer` now only has one type parameter
- `Recognizer.Result` no longer has any type parameters
- `DocumentOverlayController` and `BarcodeOverlayController` are replaced with single overlay controller - `BasicOverlayController`

### Removed features:
- `BarcodeScanActivity` no longer supports results dialog
- verification activities no longer support action bar built in obsolete activity themes

### Bug fixes:
- all default scan activities correctly set volume to media instead of ring
- all default scan activities now apply secure flag if enabled in ui settings
- fixed scanning bug for devices with problematic camera resolution, which caused that SDK was unable to scan data, known affected devices were: `OnePlus 6T`, `OnePlus 7 Pro` and `Vivo V15`

## 4.9.1

### Bug fixes:

- fixed bug in `DocumentFaceRecognizer` which caused that DPI settings has not been applied to dewarped images
- fixed bug in `DocumentVerificationOverlayController`/`DocumentVerificationActivity` - alert dialog has not been shown in cases when front and back side of the scanned document don't match
- `ColombiaIdBackRecognizer` - fixed result strings encoding problem

## 4.9.0

### New features:

- added support for reading all passports with MRZ - use `PassportRecognizer`

### Improvements for existing features:

- added `tryBothOrientations` option to `DocumentFaceRecognizer` which defines whether document will be scanned in both orientations (normal and upside down)
- `GermanyCombinedRecognizer.Result`:
    - added getter for the full MRZ string: `getRawMrzString`
- added support for reading commercial code in two rows for `HongKongIdFrontRecognizer`
- added support for `HongKongIdFrontRecognizer` 2018 version
- improved reading accuracy for the following recognizers (**DeepOCR** support):
`MalaysiaIKadFrontRecognizer`
- improved scanning time of all Malaysian ID front recognizers: `MalaysiaMyKadFrontRecognizer`, `MalaysiaMyKasFrontRecognizer`, `MalaysiaMyPrFrontRecognizer`, `MalaysiaMyTenteraFrontRecognizer`

### Minor API changes:

- Scanning timeout that can be configured by using `RecognizerBundle.setNumMsBeforeTimeout` is by default set to `RecognizerBundle.TIMEOUT_INFINITY`, which means that timeout is disabled by default. Previous default timeout value was 10 seconds.

### Bug fixes:

- DPI options on images are now correctly applied to dewarped image results in `DocumentFaceRecognizer.Result`
- fixed a validation issue for the gender field in `SloveniaCombinedRecognizer`

## 4.8.0

**Important notice on MRTD recognizer in the latest BlinkID SDK release (v4.8.0)**

Please note that we have significantly improved accuracy for MRZ/MRTD scanning because now we switched to the newest OCR technology based on machine learning.
To be more precise, we measured and compared existing vs. new MRTD scanning. The new OCR system based on machine learning achieves 99.9% accuracy on the character level, which results with a 50% reduction in the error rate in MRZ extraction.

In order to use new *MrtdRecognizer* or *MrtdCombinedRecognizer* or to continue using any additional *Recognizer for scanning any ID with the MRZ (machine readable zone)* within the latest BlinkID SDK update, you *must* have a new license key. Before updating to the SDK version 4.8.0, please contact your account manager or send an email to support@microblink.com to obtain the *new production license key*.

**Important notes**:

- The MRTD scanning with the older BlinkID SDK versions (v4.7.0 and below) will continue to work without any problems - until you decide to update.
- If you upgrade to the SDK version 4.8.0 without a new license key scanning of MRTD/MRZ documents will not work.
- Contact us at support@microblink.com to obtain a new license key if you plan to update your app with the latest release.

For any questions, you might have, we stand at your service.

### New features:

- added support for reading front and back side of Brunei Military ID - use `BruneiMilitaryIdFrontRecognizer` and `BruneiMilitaryIdBackRecognizer`

### Improvements for existing features:

- improved reading accuracy for all MRZ recognizers
- added option to force overlay orientation for `DocumentOverlayController` (`DocumentScanActivity`) and `BarcodeOverlayController` (`BarcodeScanActivity`) - use `DocumentUISettings.setForcedOrientation(OverlayOrientation)` and `BarcodeUISettings.setForcedOrientation(OverlayOrientation)`

### Minor API changes:

- removed `SerbiaIdFrontRecognizer`, `SerbiaIdBackRecognizer` and `SerbiaCombinedRecognizer`
- fields that are **not** deprecated anymore:
    - Sweden DL - reference number
    - Ireland DL - driver number
    - Malaysia iKad - passport number
    - Hong Kong ID - commercial code
- deprecated the following methods in `UsdlRecognizer.Result` and `UsdlCombinedRecognizer.Result`: (they have been replaced with new getters):
    - getField(UsdlKeys)
    - getOptionalElements
- added new getters to following results:
    - `UsdlRecognizer.Result` and `UsdlCombinedRecognizer.Result`:
        - `firstName`
        - `lastName`
        - `fullName`
        - `address`
        - `documentNumber`
        - `sex`
        - `restrictions`
        - `endorsements`
        - `vehicleClass`
        - `dateOfBirth`
        - `dateOfIssue`
        - `dateOfExpiry`
    - `MrzResult`:
       - `sanitizedOpt1`
       - `sanitizedOpt2`
       - `sanitizedNationality`
       - `sanitizedIssuer`
- moved `SwedenDlFrontRecognizer` from package `com.microblink.entities.recognizers.blinkid.sweden.dl` to `com.microblink.entities.recognizers.blinkid.sweden`
- renamed methods in the following recognizers and its results:
    - `CzechiaCombinedRecognizer`:
        - `lastName` to `surname`
        - `firstName` to `givenNames`
        - `identityCardNumber` to `documentNumber`
        - `address` to `permanentStay`
        - `issuingAuthority` to `authority`
        - `personalIdentificationNumber` to `personalNumber`
    - `GermanyCombinedRecognizer`:
        - `lastName` to `surname`
        - `firstName` to `givenNames`
        - `identityCardNumber` to `documentNumber`
        - `issuingAuthority` to `authority`
        - `eyeColor` to `colourOfEyes`
    - `JordanCombinedRecognizer`:
        - `issuer` to `issuedBy`
    - `PolandCombinedRecognizer`:
        - `issuer` to `issuedBy`
    - `RomaniaIdFrontRecognizer`:
       - `lastName` to `surname`
       - `cardNumber` to `documentNumber` from `MrzResult`
       - `parentNames` to `parentName`
       - `nonMRZNationality` to `nationality`
       - `nonMRZSex` to `sex`
       - `validFrom` to `dateOfIssue`
       - `validUntil` to `dateOfExpiry`
       - removed field `idSeries`
       - removed field `cnp`
       - MRZ fields are available through `MrzResult` which can be obtained by using getter `RomaniaIdFrontRecognizer.Result.getMrzResult()`
    - `SlovakiaCombinedRecognizer`:
       - `issuingAuthority` to `issuedBy`
       - `personalIdentificationNumber` to `personalNumber`
    - `SloveniaIdFrontRecognizer`:
       - `lastName` to `surname`
       - `firstName` to `givenNames`
    - `SloveniaIdBackRecognizer`:
       - `authority` to `administrativeUnit`
       - MRZ fields are available through `MrzResult` which can be obtained by using getter `SloveniaIdBackRecognizer.Result.getMrzResult()`
    - `SloveniaCombinedRecognizer`:
       - `lastName` to `surname`
       - `firstName` to `givenNames`
       - `identityCardNumber` to `documentNumber`
       - `citizenship` to `nationality`
       - `issuingAuthority` to `administrativeUnit`
       - `personalIdentificationNumber` to `pin`

### Bug fixes:

- fixed crashes on Nexus 6

## 4.7.0

### New features:

- added support for reading front and back side of Brunei Temporary Residence Permit - use `BruneiTemporaryResidencePermitFrontRecognizer` and `BruneiTemporaryResidencePermitBackRecognizer`
- added new scan activity and overlay: `BlinkCardActivity` and `BlinkCardOverlayController` which are best suited for scanning payment cards with `BlinkCardRecognizer`

### Improvements for existing features:

- enabled reading year-only dates of birth on **Kuwait IDs**
- improved `SingaporeIdBackRecognizer`:
    - better reading of documents with sticker
- improved `MrtdRecognizer`:
    - added `allowSpecialCharacters` option which is required for parsing Malaysian Passport IMM13P MRZ type
- all recognizers now reset their results on shake, except Combined recognizers
- `BlinkCardRecognizer` returns card issuer

### Minor API changes:

- `MrtdRecognizer` and `MrtdCombinedRecognizer` do not return MRZ image any more
- `MrtdComginedRecognizer` does not have glare detection options (it does not detect glare any more)
- replaced `PaymentCardFrontRecognizer`, `PaymentCardBackRecognizer` and `PaymentCardCombinedRecognizer` with single recognizer - `BlinkCardRecognizer`
- replaced `ElitePaymentCardFrontRecognizer`, `ElitePaymentCardBackRecognizer` and `ElitePaymentCardCombinedRecognizer` with single recognizer - `BlinkCardEliteRecognizer`
- `PolandIdBackRecognizer.Result` does not extend `MRTDResult` any more, it has getter `getMrzResult` for obtaining MRZ results

### Bug fixes:

- removed incorrect autofocus check that was performed before concrete camera type is chosen
- `MrtdRecognizer`:  result state is now properly invalidated after detection fails
- various other bug fixes and improvements

## 4.6.0

### New features:

- added support for reading front side of German Driver's License - use `GermanyDlFrontRecognizer`
- added support for reading back side of Brunei ID - use `BruneiIdBackRecognizer`
- added support for reading front side of Brunei Residence Permit - use `BruneiResidencePermitFrontRecognizer`
- added support for reading back side of Brunei Residence Permit - use `BruneiResidencePermitBackRecognizer`
- updated default UI icons

### Improvements for existing features:

- improved reading accuracy for the following recognizers (**DeepOCR** support):
	- `MalaysiaMyKadBackRecognizer`

### Minor API changes:
- if using high res frame capture in custom UI, you now have to explicitly enable it using new `RecognizerRunnerView` method  `setHighResFrameCaptureEnabled`
- renamed `GermanyOldIdRecognizer` to `GermanyIdOldRecognizer`
- removed `sex` and `signatureImage` from `MalaysiaMyKadBackRecognizer `
- renamed methods in `CroatiaCombinedRecognizer` and its result:
    - `identityCardNumber` to `documentNumber`
    - `address` to `residence`
    - `issuingAuthority` to `issuedBy`
    - `personalIdentificationNumber` to `oib`
    - `nonResident` to `documentForNonResident`
- removed `mrzImage` from `MrtdCombinedRecognizer` and its result
- renamed methods in `AustraliaDlFrontRecognizer.Result`:
    - `name` to `fullName`
    - `dateOfExpiry` to `licenceExpiry`
- renamed `eyeColour` to `colourOfEyes` in `GermanyIdBackRecognizer.Result`
- deprecated the following recognizers:
    - `SerbiaIdBackRecognizer`
    - `SerbiaIdFrontRecognizer`
    - `SerbiaCombinedRecognizer`
- deprecated the following result fields:
    - `HongKongIdFrontRecognizer.Result`:
        - `commercialCode`
    - `IndonesiaIdFrontRecognizer.Result`:
        - `bloodType`
        - `district`
        - `kelDesa`
        - `rt`
        - `rw`
    - `NewZealandDlFrontRecognizer.Result`:
        - `donorIndicator`
        - `cardVersion`
    - `MalaysiaMyKadBackRecognizer.Result`:
        - `extendedNric`
    - `MexicoVoterIdFrontRecognizer.Result`:
        - `electorKey`
    - `IrelandDlFrontRecognizer.Result`:
        - `driverNumber`
    - `SwedenDlFrontRecognizer.Result`:
        - `referenceNumber`
    - `MalaysiaIkadFrontRecognizer.Result`:
        - `passportNumber`    
    - `AustriaIdBackRecognizer.Result`:
        - `principalResidence`
        - `height`
        - `eyeColour`
    - `AustriaPassportRecognizer.Result`:
        - `height`
     - `GermanyIdBackRecognizer.Result`:
        - `colourOfEyes`
        - `height`
    - `SwitzerlandIdBackRecognizer.Result`:
        - `height`
    - `SwitzerlandPassportRecognizer.Result`:
        - `height`
     - `SingaporeIdBackRecognizer.Result`:
        - `bloodGroup`
    - `ColombiaIdBackRecognizer.Result`:
        - `bloodGroup`
    - `SwitzerlandPassportRecognizer.Result`:
        - `height`
    - `PolandIdFrontRecognizer.Result`:
        - `familyName`
        - `parentsGivenNames`
    - `MoroccoIdBackRecognizer.Result`:
        - `fathersName`
        - `mothersName`
    - `RomaniaIdFrontRecognizer.Result`:
        - `parentNames`
        
### Bug fixes:

- fixed crash on some devices when using `VIDEO_RESOLUTION_MAX_AVAILABLE`

## 4.5.0

### New features:

- added support for reading front side of Brunei ID - use `BruneiIdFrontRecognizer`
- added support for reading front and back side of Cyprus ID, issued after 2015.  - use `CyprusIdFrontRecognizer` and `CyprusIdBackRecognizer`
- added support for reading front side of Malaysian MyKAS - use `MalaysiaMyKasFrontRecognizer`
- added support for reading front side of Malaysian MyPR - use `MalaysiaMyPrFrontRecognizer`
- enabled capturing high resolution camera frames:
    - When custom UI integration is performed, use `RecognizerRunnerView.captureHighResImage`
    - When using provided scan activities, high resolution full camera frames taken at the moment of successful scan are returned if this option is enabled through `UISettings`. Concrete `UISettings` which implement interface `HighResSuccessFrameCaptureUIOptions` support this feature.

### Improvements for existing features:
- improved reading accuracy for the following recognizers (**DeepOCR** support):
    - `HongKongIdFrontRecognizer`
    - `MalaysiaMyKadFrontRecognizer`
    - `MalaysiaMyKadBackRecognizer`
    - `MalaysiaMyTenteraFrontRecognizer`
    - `MalaysiaDlFrontRecognizer`
    - `NewZealandDlFrontRecognizer`
- improved `PaymentCard` recognizers:
    - better OCR and data extraction
    - added support for reading payment card numbers in 4x6x4 and 4x6x5 format
- improveed UAE recognizers:
    - glare detection is enabled for all images returned from `UnitedArabEmiratesDlFrontRecognizer`, `UnitedArabEmiratesIdBackRecognizer` and `UnitedArabEmiratesIdFrontRecognizer` recognizers
- improved `MrtdRecognizer`:
    - added option to set extension factors for full document image: use method `setFullDocumentImageExtensionFactors`
    - added option to encode `fullDocumentImage` and `mrzImage` to JPEG and save them to `MrtdRecognizer.Result`: use `setEncodeMrzImage` and `setEncodeFullDocumentImage` to enable encoding
- `RecognizerRunnerView` is lifecycle-aware now, it implements `android.arch.lifecycle.LifecycleObserver` interface

### Minor API changes:

- renamed `IkadRecognizer` to `MalaysiaIkadFrontRecognizer` and  methods in recognizer and its `Result`:
    - `expiryDate` to `dateOfExpiry `
    - `sex ` to `gender`
- renamed `MyKadFrontRecogniezer ` to `MalaysiaMyKadFrontRecognizer ` and  methods in recognizer and its `Result`:
    - `ownerFullName ` to `fullName `
    - `ownerAddress ` to `fullAddress `
    - `addressStreet ` to `street `
    - `ownerAddressZipCode ` to `zipcode `
    - `ownerAddressCity ` to `city `
    - `ownerAddressState ` to `ownerState `
    - `ownerBirthDate ` to `birthDate `
    - `ownerSex ` to `sex `
    - `ownerReligion ` to `religion `
    - `nricNumber ` to `nric `
- `MalaysiaMyKadFrontRecognizer` does not extract `armyNumber` anymore, use `MalaysiaMyTenteraFrontRecognizer` for scanning `MyTentera`
- `MrtdRecognizer`: 
    - method `setSaveImageDPI` which has been used to set DPI for full document and MRZ image is replaced with methods `setFullDocumentImageDpi` and `setMrzImageDpi`

- renamed methods in `SwitzerlandIdBackRecognizer` and its `Result`: 
    - `nonMrzDateOfExpiry` to `dateOfExpiry`
    - `nonMrzSex` to `sex`
- renamed methods in `SwitzerlandPassportRecognizer` and its `Result`:
    - `placeOfBirth` to `placeOfOrigin`
    - `nonMrzDateOfBirth` to `dateOfBirth`
    - `nonMrzDateOfExpiry` to `dateOfExpiry`
    - `nonMrzSex` to `sex`

### Bug fixes:
- fixed problems in camera management:
    - default camera surface is `TextureVeiw` for devices that use Camera1 API, otherwise `SurfaceView` is used
- `DocumentFaceRecognizer` now correctly applies DPI settings to returned face and full document images
- various other bug fixes and improvements

## 4.4.0

### New features:

- added support for reading back side of Germany Driver's License (reading of single B10 field - date of issue for B category)  - use `GermanyDlBackRecognizer`

- added support for reading front side of Mexico Voter ID  - use `MexicoVoterIdFrontRecognizer`

### Improvements for existing features:

- added support for hiding sensitive parts of images returned by payment card recognizers:
    - `PaymentCardFrontRecognizer`: setAnonymizeOwner, setAnonymizeCardNumber
    - `PaymentCardBackRecognizer`: setAnonymizeCvv
    - `PaymentCardCombinedRecognizer`:  setAnonymizeOwner, setAnonymizeCardNumber, setAnonymizeCvv
    - `ElitePaymentCardFrontRecognizer`: setAnonymizeOwner
    - `ElitePaymentCardBackRecognizer`: setAnonymizeCardNumber, setAnonymizeCvv
    - `ElitePaymentCardBackRecognizer`: setAnonymizeOwner,  setAnonymizeCardNumber, setAnonymizeCvv
- `CyprusIdBackRecognizer`: added support for reading date of expiry, use `getExpiresOn` on its result
- `SlovakiaIdFrontRecognizer`: improved reading of `personalNumber` field
- improved reading accuracy for the following recognizers:
    - `MalaysiaMyTenteraFrontRecognizer`
    - `SingaporeDlFrontRecognizer`
    - `CroatiaIdFrontRecognizer`
    - `IndonesiaIdFrontRecognizer`
- improved image return processor:
    - the processor now estimates detected (dewarped) document image quality and returns the best quality dewarped image from the best quality detection
- `DocumentVerificationActivity` does not extend `AppCompatActivity` any more

### Minor API changes:
- renamed methods in `GermanyIdFrontRecognizer` and its `Result`:
    - `lastName` to `surname`
    - `firstName` to `givenNames`
- renamed `MyTenteraRecognizer` to `MalaysiaMyTenteraFrontRecognizer` and  methods in recognizer and its `Result`:
    - `ownerFullName` -> `fullName`
    - `ownerAddress` -> `fullAddress`
    - `ownerAddressStreet` -> `street`
    - `ownerAddressZipCode` -> `zipcode`
    - `ownerAddressCity` -> `city`
    - `ownerAddressState` -> `ownerState`
    - `ownerBirthDate` -> `birthDate`
    - `ownerSex` -> `sex`
    - `ownerReligion` -> `religion`
    - `nricNumber` -> `nric`
- renamded enum `com.microblink.uisettings.options.ShowOcrResultMode` to `com.microblink.uisettings.options.OcrResultDisplayMode`
- for all `UISettings` classes which support setting of OCR result display mode, renamed method `setShowOcrResultMode` to `setOcrResultDisplayMode`

### Bug fixes:
- fixed camera autofocus problems on Samsung S9/S9+ when optimisation for near scanning is enabled
- fixed autofocus problems in `Field by field` scanning on Huawei P20 pro, Huawei P20 and Huawei P20 lite 

## 4.3.0

### New features:

- added support for reading front side of Ireland Driver's License  - use `IrelandDlFrontRecognizer`
- added support for reading front side of Colombia Driver's License - use `ColombiaDlFrontRecognizer`
- added support for reading front side of Italy Driver's License - use `ItalyDlFrontRecognizer`
- added standalone recognizer for reading front side of Austria Driver's License - use `AustriaDlFrontRecognizer`
- added support for reading front and back side of elite Payment / Debit cards - use `ElitePaymentCardFrontRecognizer`, `ElitePaymentCardBackRecognizer` and `ElitePaymentCardCombinedRecognizer`

### Improvements for existing features:
- improved `MrtdCombinedRecognizer`:
    - added option to allow unparsed and unverified MRZ results - use `MrtdCombinedRecognizer.setAllowUnparsedResults` and `MrtdCombinedRecognizer.setAllowUnverifiedResults`
- improved `MalaysiaDlFrontRecognizer`:
    - added support for reading Malaysia Dl for foreigners 
- improved `UsdlRecogniezr`:
    - added support for reading dates on Nigerian Driver's licenses
- added support for setting full document image extension factors for almost all ID document recognizers, they implement interface `FullDocumentImageExtensionOptions`
- added support for setting the number of stable detections threshold on `DocumentFaceRecognizer` and recognizers which use it internally: `MrtdCombinedRecognizer` and `UsdlCombinedRecognizer` - use `setNumStableDetectionsThreshold(int)`. This can help to avoid returning of blurry images.
- improved `EudlRecognizer`:
    - better reading accuracy for UK Driver's license
- moved these recognizers to DeepOCR engine (improved reading accuracy): `SingaporeIdFrontRecognizer`, `SingaporeIdBackRecognizer`, `CroatiaIdFrontRecognizer`,  `CroatiaIdBackRecognizer`
- improved DeepOCR accuracy

### Minor API changes:
- renamed methods in `MalaysiaDlFrontRecognizer` and its `Result`:
    - `state` to `ownerState`
    - `zipCode` to `zipcode`
- renamed methods in `IndonesiaIdFrontRecognizer` and its `Result`:
    - `validUntil` to `dateOfExpiry`
    - `validUntilPermanent` to `dateOfExpiryPermanent`
- renamed methods in `SingaporeIdFrontRecognizer` and its `Result`:
    - `bloodType` to `bloodGroup`
- renamed methods in `SingaporeCombinedRecognizer` and its `Result`:
    - `bloodType` to `bloodGroup`

### Bug fixes:
- enabled wrapping of combined recogniezrs with `SuccessFrameGrabberRecognizer`
- fixed bug in `EudlRecognizer` which caused that sometimes face image is not returned, even if the recognition was successful
- various other bug fixes and improvements

## 4.2.0

### New features:

- added support for reading front side of United Arab Emirates Driver's License - use `UnitedArabEmiratesDlFrontRecognizer`
- added support for reading front side of Spain Driver's License - use `SpainDlFrontRecognizer`
- added support for reading front and back side of Cyprus ID - use `CyprusIdFrontRecognizer` and `CyprusIdBackRecognizer`
- added support for reading front and back side of Kuwait ID - use `KuwaitIdFrontRecognizer` and `KuwaitIdBackRecognizer`
- added support for reading front and back side of Payment / Debit cards - use `PaymentCardFrontRecognizer`, `PaymentCardBackRecognizer` and `PaymentCardCombinedRecognizer`

### Improvements for existing features:

- improved `SingaporeCombinedRecognizer`:
    - added support for reading sticker with new address from the back side
- `BarcodeScanActivity` by default does not show result dialog after scan

### Minor API changes:
- renamed methods in `CroatiaIdBackRecognizer` and its `Result`:
    - `address` to `residence`
    - `documentForNonResident` to `isDocumentForNonResident`
    - `issuingAuthority` to `issuedBy`
    - `getDateOfExpiryPermanent` to `isDateOfExpiryPermanent`
    - MRZ fields are available through `MrzResult` which can be obtained by using getter `CroatiaIdBackRecognizer.Result.getMrzResult()`
- renamed method in `SingaporeIdFrontRecognizer` and its `Result`:
    - `cardNumber` to `identityCardNumber`
- renamed method in `SingaporeCombinedRecognizer` and its `Result`:
    - `cardNumber` to `identityCardNumber`
    - `bloodGroup` to `bloodType`

### Bug fixes:

- fixed bug which caused that results from the previous scan are cleared when the scan activity is run again and entities which have produced results are not used in the new scan
- various other bug fixes and improvements

## 4.1.0

### New features:

- added support for reading partial dates on all MRTD documents:
    - affects all recognizers which extract data from Machine Readable Zone
- added support for reading front side of Swiss Driver's License - use `SwitzerlandDlFrontRecognizer`
- added support for reading front side of Singapore Driver's License - use `SingaporeDlFrontRecognizer`
- added support for reading front side of Singapore Changi employee ID - use `SingaporeChangiEmployeeIdRecognizer`
- added support for reading front and back side of Morocco ID - use `MoroccoIdFrontRecognizer` and `MoroccoIdBackRecognizer`

### Improvements for existing features:

- improved `HongKongIdFrontRecognizer`:
    - added support for reading residential status field
- improved `UnitedArabEmiratesIdFrontRecognizer`:
    - better name and nationality extraction
- improved `SingaporeIdBackRecognizer`:
    - added support for reading sticker with new address
- improved `MyKadBackRecognizer`:
    - added support for reading old NRIC field
- improved `NewZealandDlFrontRecognizer`:
    - better reading of all fields

### Minor API changes:
- in `CroatiaIdFrontRecognizer` `identityCardNumber` is renamed to `documentNumber`
- `BarcodeRecognizer` does not support Manatee library any more:
    - removed setter `setManateeLicenseKey`
- in `GermanyIdBackRecognizer.Result`, `AustriaPassportRecognizer.Result`, `AustriaIdBackRecognizer.Result` and `AustriaCombinedRecognizer.Result` getter `getHeight` returns height as `String` (instead of `int`)
- `HongKongIdFrontRecognizer.Result.getDateOfBirth()` returns `com.microblink.results.date.DateResult` instead of `com.microblink.results.date.Date`
- in `ColombiaIdBackRecognizer.Result` getter `getDateOfBirth()` is renamed to `getBirthDate()`
- in `SingaporeIdBackRecognizer.Result` getter `getBloodGroup()` is renamed to `getBloodType()`
- renamed getters in `NewZealandDlFrontRecognizer.Result` renamed getters:
    - `getIssueDate()` to `getDateOfIssue()`
    - `getExpiryDate()` to `getDateOfExpiry()`
    - `getDonorIndicator()` to `isDonorIndicator()`

### Bug fixes:
- various bug fixes and improvements

## 4.0.0
- new API, which is not backward compatible. Please check [README](README.md) and updated demo applications for more information, but the gist of it is:
    - `RecognizerView` has been renamed to `RecognizerRunnerView` and `Recognizer` singleton to `RecognizerRunner`
    - `SegmentScanActivity` has been renamed to `FieldByFieldScanActivity`
    - `RandomScanActivity` does not exist anymore
    - previously internal `Recognizer` objects are not internal anymore - instead of having opaque `RecognizerSettings` and `RecognizerResult` objects, you now have stateful `Recognizer` object that contains its `Result` within and mutates it while performing recognition. 
        - similarly we now have stateful `Parser` and `Detector` objects
        - introduced new `Processor` object type
        - For more information, see [README](README.md) and updated demo applications
    - added `RecognizerRunnerFragment` with support for various scanning overlays in a manner similar to iOS API. This now allows you to use built-in UI, which was previously strictly available for built-in activities, in form of fragment anywhere within your activity. Full details are given in [README](README.md) and in updated demo applications.
- new licence format, which is not backward compatible. Full details are given in [README](README.md) and in updated applications, but the gist of it is:
    - licence can now be provided with either file, byte array or base64-encoded bytes

## 3.18.0

### Improvements for existing features:

- `com.microblink.image.Image` class now has getter `getImageQuality()`:
    - can be used to choose the best image from the same scan
    - it only makes sense to relatively compare image qualities from consecutive camera frames from the same scan on a certain device

### Bug fixes:

- fixed `UnitedArabEmiratesIDBackRecognizer`:
    - enabled reading of UAE back side where MRZ starts with `IR`

## 3.17.0

### New features:

- added support for reading front side of Sweden Driver's License - use `SwedenDLFrontRecognizerSettings` 

### Improvements for existing features:

- improved `CroatianIDBackSideRecognizer`:
    - better reading of address field
- improved `GermanIDFrontSideRecognizer`:
    - added support for reading CAN number
- improved `USDLRecognizer`:
    - better parsing of the USDL data fields
- improved `HongKongIDFrontRecognizer`:
    - better reading of document number (check digit validation)
- improved `IKadRecognizer`:
    - added support for iKad IMM_55 document type (foreign students card)
- added option to extend full document image for German recognizers:
`GermanIDFrontSideRecognizer`, `GermanOldIDRecognizer`, `GermanIDBackSideRecognizer`, `GermanIDCombinedRecognizer` and `GermanPassportRecognizer` - use method `setFullDocumentImageExtensionFactors(ImageExtensionFactors)` from the corresponding recognizer settings
- when `DocumentFaceRecognizer` is activated at the same time with another more specific recognizer(s) (e.g. EUDLRecognizer), preference is given to the more specific recognizer which means that it will get a chance to extract additional data from the concrete document type

### Bug fixes:

- fixed reading of non-standard PDF417 barcodes


## 3.16.0

### New features:

- added support for reading front side of Egypt ID - use `EgyptIDFrontRecognizerSettings` 
- added support for reading front and back side of Jordan ID - use `JordanIDFrontRecognizerSettings`,  `JordanIDBackRecognizerSettings` and `JordanIDCombinedRecognizerSettings`
- added support for reading front side of Malaysian drivers license - use `MalaysianDLFrontRecognizerSettings`

### Improvements for existing features:

- improved `USDLRecognizer`:
    - better parsing of the USDL barcode content
    - fixed extraction of expiry date from magnetic stripe USDL subtype
- improved `VinParser`:
    - better extraction of specific VIN numbers
- improved `MRTDRecognizer`:
    - added support for parsing Malaysian Passport IMM13P MRZ type, reading of special characters must be enabled by using `MRTDRecognizerSettings.setAllowSpecialCharacters`
    - enabled reading of MRZ with '-' characters (non-default setting), to enable this use method `MRTDRecognizerSettings.setAllowSpecialCharacters`

### Bug fixes:

- fixed rare crash in `MRTDRecognizer`

## 3.15.1

### Bug fixes:

- fixed returning of face image when using `UnitedArabEmiratesIDFrontRecognizer`: 
    - fixed face image position

## 3.15.0

### New features:

- added support for reading front side of Hong Kong ID - use `HongKongIDFrontRecognizerSettings` 
- added support for reading front and back side of Colombian ID - use `ColombiaIDFrontRecognizerSettings` and `ColombiaIDBackRecognizerSettings`
- added support for reading front and back side of United Arab Emirates ID - use `UnitedArabEmiratesIDFrontRecognizerSettings` and `UnitedArabEmiratesIDBackRecognizerSettings` 
- added support for reading front side of New Zealand drivers license - use `NewZealandDLFrontRecognizerSettings`

### Improvements for existing features:

- improved `MRTDRecognizer`:
    - improved reading of Belgium ID MRZ OPT2 field
    - added support for reading Belgium MRZ with partial date of birth - `MRTDRecognizerSettings.setAllowUnverifiedResults()` must be set to `true` 
    - added support for reading Kenya MRZ - `MRTDRecognizerSettings.setAllowUnverifiedResults()` must be set to `true` 
- improved `MyKadFrontSideRecognizer` and `MyTenteraRecognizer`:
    - better reading of name field
    - better reading of address field
- when setting DPI for full document image in concrete recognizer settings that has method `setFullDocumentImageDPI`, exception is thrown if DPI value is not in the expected range `[100, 400]`

### Bug fixes:

- fixed `NullPointerException` in `RecognizerView` caused by race condition that happens when quickly restarting camera manager
-  fixed a crash in Templating API caused by using a `MultiDetector` with `DetectorRecognizer`

## 3.14.0

### New features:

- added support for reading back side of Malaysian MyKad - use `MyKadBackSideRecognizerSettings` 
- added support for reading Malaysian MyTentera documents - use `MyTenteraRecognizerSettings`
- added support for reading Malaysian MyTentera documents with MyKad recognizer - use `MyKadFrontSideRecognizerSettings` and enable reading of army number 
- added support for setting DPI for full document images returned by `MyKadFrontSideRecognizer`, `MyKadBackSideRecognizer`, `MyTenteraRecognizer` and `IKadRecognizer`:
    - use `setFullDocumentImageDPI` on the corresponding recognizer settings
  
### Minor API changes:

- renamed `MyKadRecognizerSettings` and `MyKadRecognitionResult` to `MyKadFrontSideRecognizerSettings` and `MyKadFrontSideRecognitionResult` and moved them to `com.microblink.recognizers.blinkid.malaysia.mykad.front` package
- moved `IKadRecognizerSettings` and `IKadRecognitionResult` to `com.microblink.recognizers.blinkid.malaysia.ikad` package

### Improvements for existing features:

- improved `AustralianDLFrontSideRecognizer`:
    - improved reading of names and addresses
    - added support for reading first names with more words
- improved `SingaporeIDFrontRecognizer`:
    - tuned ID card data extraction positions
- improved Malaysian `IKadRecognizer`:
    - better reading of date of expiry and employer fields

### Bug fixes:

- fixed crash in `DocumentFaceRecognizer`

## 3.13.0

### New features:

- added support for reading back side of new Australian Driver's licence for state Victoria - use `AustralianDLBackSideRecognizerSettings`
- added support for reading front side of Indonesian ID - use `IndonesianIDFrontRecognizerSettings`
- added support for Malaysian visa with document code TS - use `MRTDRecognizerSettings`
- introduced `MRTDSpecification` and method `setMRTDSpecifications` on `MRTDRecognizerSettings` and `MRTDDetectorSettings`:
    - detection is limited only to document type specified with `MRTDSpecification`
    - when `MRTDSpecifications` are set, results will be returned only for specified MRTD documents
    - `MRTDSpecification` can be created by using `MRTDSpecification.createFromPreset`, available presets are: `MRTD_SPECIFICATION_TD1`, `MRTD_SPECIFICATION_TD2` and `MRTD_SPECIFICATION_TD3`
- added support for setting DPI for full document images returned by `MRTDRecognizer`, `AustralianDLFrontSideRecognizer`, `AustralianDLBackSideRecognizer` and `EUDLRecognizer`:
    - use `setFullDocumentImageDPI` on the corresponding recognizer settings
  
### Improvements for existing features:

- improved reading of Malaysian MyKad address

## 3.12.0

### New features:

- added support for scanning front and back side of Polish ID - use `PolishIDFrontSideRecognizerSettings`, `PolishIDBackSideRecognizerSettings` and `PolishIDCombinedRecognizerSettings`
- new document specification presets in `DocumentSpecificationPreset` enum:  `DOCUMENT_SPECIFICATION_PRESET_ID1_VERTICAL_CARD` and  `DOCUMENT_SPECIFICATION_PRESET_ID2_VERTICAL_CARD` - use `DocumentSpecification.createFromPreset` method to create document specification for detector
- `EUDLRecognizer` can return face image from the driver's license
- warning for time limited license keys when using provided activities, custom UI integration or Direct API:
    - the goal is to prevent unintentional publishing of application to production with the demo license key that will expire
    - warning toast can be disabled by using `EXTRAS_SHOW_TIME_LIMITED_LICENSE_KEY_WARNING` intent extra, `RecognizerView.setLicenseKeyTimeLimitedWarningEnabled` method when custom UI integration is used and `Recognizer.setLicenseKeyTimeLimitedWarningEnabled` method when Direct API is used
  
### Minor API changes:

- `DocumentSpecification` does not have method `setPhysicalSizeInInches` any more
- `DocumentDetectorResult` does not contain information about screen orientation any more
- `QuadDetectorWithSizeResult` is renamed to `QuadWithSizeDetectorResult`

### Improvements for existing features:

- improved face detection in `DocumentFaceRecognizer`: stable detection is required to prevent returning of blurred images
- improved reading of Malaysian `MyKad` documents:
    - improved reading and parsing of address fields: previously recognizer was unable to read some documents because of the expected address format
- improved reading of Malaysian visas and work permits
- better reading of dates on Australian Driver's Licence

### Bug fixes:

- fixed crash in `GermanIDBackSideRecognitionResult` caused by ProGuard obfuscation, when it is not declared in ProGuard rules to keep the result constructor
- fixed crash in `MRTDCombinedRecognizer`: recognizer does not support glare detection

## 3.11.0

### New features:

- added support for scanning front and back side of Swiss ID - use `SwissIDFrontSideRecognizerSettings` and `SwissIDBackSideRecognizerSettings` ​
- added support for reading front side of new Australian Driver's licence for state Victoria - use `AustralianDLFrontSideRecognizerSettings`
- introduced `MRZFilter`:
    - use  `MRTDRecognizerSettings` to enable it on  `MRTDRecognizer`
    - determines whether document should be processed or it is filtered out, based on its MRZ (Machine Readable Zone)
 - added `QuadDetectorWithSizeResult` which inherits existing `QuadDetectorResult`:
    - it's subclasses are `DocumentDetectorResult` and `MRTDDetectorResult`
    - returns information about physical size (height) in inches of the detected location when physical size is known
- introduced `GlareDetector` which is by default used in all recognizers whose settings implement `GlareDetectorOptions`:
    - when glare is detected, OCR will not be performed on the affected document position to prevent errors in the extracted data
    - if the glare detector is used and obtaining of glare metadata is enabled in `MetadataSettings`, glare status will be reported to `MetadataListener`
    - glare detector can be disabled by using `setDetectGlare(boolean)` method on the recognizer settings
  
### Minor API changes:

- `BlinkOCRRecognizerSettings` is now deprecated and will be removed in `v4.0.0`
	- use `DetectorRecognizerSettings` to perform scanning of templated documents 
	- use `BlinkInputRecognizerSettings` for segment scan or for full-screen OCR 
	- until `v4.0.0`, `BlinkOCRRecognizerSettings` will behave as before, however you are encouraged to update your code not to use it anymore
- `DocumentClassifier` interface is moved from `com.microblink.recognizers.blinkocr` to `com.microblink.recognizers.detector` package and `DocumentClassifier.classifyDocument()` now accepts `DetectorRecognitionResult` as parameter for document classification
- `USDLRecognizerSettings`:
    - removed option to scan 1D Code39 and Code128 barcodes on driver's licenses that contain those barcodes alongside PDF417 barcode

### Improvements for existing features

- improved date parsing:
	- affects date parser and all recognizers which perform date parsing
- added support for reading mirrored QR codes:
	- affects all recognizers that perform QR code scanning
- improved `CroatianIDBackSideRecognizer`:
    - better extraction of fields on back side of the Croatian ID card
- improved `USDLRecognizer`:
    - added support for new USDL standard

### Bug fixes:
- fixed crash in QR code reading
- fixed returning valid data for MRZ based recognizers when not all fields outside of the MRZ have been scanned

## 3.10.1

### Bug fixes:

- fixed pareclization of `BlinkOCREngineOptions`:
	- when defining character whitelist chosen character font has been incorrectly passed to native code
	- affects code where character whitelist is defined through `BlinkOCREngineOptions` for used parsers (e.g. `Templating API`)

## 3.10.0

### New features:

- added support for scanning Austrian passports - use `AustrianPassportRecognizerSettings`
- added support for scanning Swiss passports -  use `SwissPassportRecognizerSettings`
- added support for scanning Mexican Voting Cards - use `MRTDRecognizerSettings`

### Minor API changes:

- `RegexParserSettings` and `RawParserSettings` now work with `AbstractOCREngineOptions`, which is a base class of `BlinkOCREngineOptions`
	- default engine options returned by method `getOcrEngineOptions` for both parser settings return instance of `BlinkOCREngineOptions`

### Improvements for existing features

- improved address parsing on Malaysian iKad documents
	- affects only iKad recognizer (represented by `IKadRecognizerSettings`)
- added support for scanning non-expiring Croatian ID documents
	- affects:
		- Croatian ID front recognizer (represented by `CroatianIDFrontSideRecognizerSettings`) - date of expiry is keyword **TRAJNO**
		- Croatian ID back recognizer (represented by `CroatianIDBackSideRecognizerSettings`) - date of expiry inside MRZ is `991231`
		- Croatian ID combined recognizer (represented by `CroatianIDCombinedRecognizerSettings`)

### Bug fixes:

- fixed occassional crash in MRTD detection algorithm
	- this affects both _MRTD Recognizer_ (represented by `MRTDRecognizerSettings`) and _MRTD Detector_ (represented by `MRTDDetectorSettings`)
 

## 3.9.0

- bugfix in Croatian ID scanning:
    - ensured that OIB number is not returned for old ID cards, where it does not exist
- added Czech and Slovak translations
- Date fields in recognition results are returned as `com.microblink.results.date.Date` class which represents immutable dates that are consisted of day, month and year
- improved `IbanParser`:
    - improved extraction of IBANs without prefix and introduced `setAlwaysReturnPrefix` option to always return prefix (country code)
    - added support for french IBANs
- enabled reading of Pdf417 barcodes having width/height bar aspect ratio less than 2:1
- Added `VinRecognizer` for scanning VIN (*Vehicle Identification Number*) barcodes
- Added unified `BarcodeRecognizer` for scanning various tipes of barcodes
    - `ZXingRecognizer`, `BarDecoderRecognizer` and `AztecRecognizer` are **deprecated**, `BarcodeRecognizer` should be used for all barcode types that are supported by these recognizers
- `OcrLine.getChars()` method returns `CharWithVariants` array. OCR char is defined by all its parameters (value, font, position, quality, etc.) and for each resulting char it is possible to have multiple variants. For example it is possible to have same char value with different font.
- Fixed bug in SegmentScanActivity:
    - scan results are no longer hidden on shake event
- improved `IKadRecognizer`:
    - added support for long addresses and employer names
    - fixed returning of full document images as metadata
- improved `Singapore ID Recognizers`:
    - tuned reading positions
    - more accurate reading of name and blood type fields
- improved `Slovak ID Recognizers`:
    - tuned reading positions of ID elements
    - improved reading precision of address, place of birth, last name and issuing authority
    - added options to disable/enable extraction of certain fields in recognizer settings
    - result getters `getPersonalIdentificationNumber()` and `getIssuingAuthority()` are renamed to `getPersonalNumber()` and `getIssuedBy()`
- Renamed `RomanianIDFrontSideRecognitionResult` element getters for Sex and Nationality outside of the MRZ to `getNonMRZNationality()` and `getNonMRZSex()`
- For `Austrian ID Recognizers` added options to disable/enable extraction of certain fields in recognizer settings

## 3.8.1

- improved `CombinedRecognizers`:
    - better handling of names containing dashes and extra long names
- improved `TopUpParser`:
    - added option to return USSD code without prefix
- by default `MRTDRecognizer` does not return results with incorrect check digits

## 3.8.0

- introduced ability to create minimum-size AAR
	- a separate static library distribution now exists which contains a script that you can configure with features you need and it creates a AAR file which only contains features you need - this includes minimum-size native binary and only required assets. The rest (resources and java classes) can be thrown-away by ProGuard.
- `LibBlinkID` is now fully ProGuard-compatible, i.e. you no longer need to exclude `com.microblink.**` classes in your ProGuard configuration
- removed support for Android 2.3 and Android 4.0 - minimum required Android version is now Android 4.1 (API level 16)
	- devices with Android 4.0 and earlier take [less than 2% of market share](https://developer.android.com/about/dashboards/index.html#Platform) and is very costly to support them
- removed `isItalic` and `isBold` getters from `OcrChar` class
    - they always returned `false`, since OCR engine cannot accurately detect that
- removed `setLineGroupingEnabled` and `isLineGroupingEnabled` from `BlinkOCREngineOptions` because disabling line grouping completely destroyed the OCR accuracy
- added `GermanIDCombinedRecognizer`: scans front and back side of the German ID

## 3.7.1

- prefixed custom attributes to avoid name collisions with attributes from other libraries:
    - `CameraViewGroup`: renamed animateRotation to `mb_animateRotation`, animationDuration to `mb_animationDuration`, rotatable to `mb_rotatable`
    - `BaseCameraView`:  renamed initialOrientation to `mb_initialOrientation`, aspectMode to `mb_aspectMode`
- improved `MRTDRecognizer`:
    - WSA (World Goverment of World Citizens) added as valid country code when parsing MRZ
- added `USDLCombinedRecognizer`: scans face image and USDL barcode

## 3.7.0

- updated German ID recognizers:
    - instead of `GermanIDMRZSideRecognizer`, which was used for scanning front side of the older ID cards and back side of the new ID cards, there are two specialised recognizers:  `GermanIDBackSideRecognizer`  and `GermanOldIDRecognizer`
    - improved scanning accuracy of the `GermanIDFrontSideRecognizer` (name and surname)
    - splitting address from back side of the new German ID (GermanIDBackSideRecognizer) to ZIP code, city, street and house number

- better support for German passports: `GermanPassportRecognizer` reads passport data from MRZ and fields outside of the MRZ 

- splitting address in `MyKadRecognizer` to street, ZIP code, city and state

- improved Croatian ID recognizers:
    - multiple scans are used for better confidence

- `TopUpParser` improvements

- `DateParser` can parse dates with month names in English (either full or abbreviated), if this option is enabled

- added support for polish IBAN without PL prefix to `IBANParser`

- fixed returning of images inside TemplatingAPI for frames when document was not correctly detected

- introduced combined recognizers:
    - `AustrianIDCombinedRecognizer`: scans front and back side of the Austrian ID
    - `CroatianIDCombinedRecognizer`: scans front and back side of the Croatian ID
    - `CzechIDCombinedRecognizer`: scans front and back side of the Czech ID
    - `MRTDCombinedRecognizer`: scans face image from any type of the document and Machine Readable Zone
    - `SerbianIDCombinedRecognizer`: scans front and back side of the Serbian ID
    - `SingaporeIDCombinedRecognizer`: scans front and back side of the Singapore ID
    - `SlovakIDCombinedRecognizer`: scans front and back side of the Slovak ID
    - `SlovenianIDCombinedRecognizer`: scans front and back side of the Slovenian ID

    Combined recognizers can be used for scanning multiple parts/sides of the document in predefined order. They combine results from individual scans to boost accuracy and merge them into the final result.

- added `VerificationFlowActivity` which is designed for scanning multiple parts/sides of the document by using provided combined recognizers

- optimised native binary size
    - 15% size reduction for `arm64-v8a` ABI
    - 14% size reduction for `x86` ABI
    - 13% size reduction for `armeabi-v7a` and `x86_64 ABIs

## 3.6.0

- added `AztecRecognizer` for scanning Aztec barcodes
- improved `TopUpParser`:
    - added suport for 14 digits long sim numbers in addition to existing lengths (12, 19, 20)

## 3.5.0

- `MobileCouponsParser` is renamed to `TopUpParser`
- improved `TopUpParser`:
    - added option to enable all prefixes at the same time (generic prefix)
- fixed layouting of provided `SegmentScanActivity` and `RandomScanActivity` in multi-window mode
- added `SimNumberRecognizer` which scans SIM numbers from barcodes
- improved `MRTDRecognizer`:
    - better support for arab MRZ
- updated `CroatianIDFrontSideRecognizer`:
    - returning sex as written on front side of a document
- added support for scanning front side of Romanian ID cards

## 3.4.1

- improved multi-window camera support
- fix layouting of default activities in multi-window mode
- fixed problem with front side Singapore recognizer

## 3.4.0

- improved quality of german ID address recognition
- added support for extracting place of birth on old German IDs
- added support for scanning IBAN from Georgia in Segment Scan
- added support for cancelling ongoing DirectAPI recognition call
- added option to allow unverified results for `MRTDRecognizer`:
    - by using method `setAllowUnverifiedResults` in `MRTDRecognizerSettings`,  it is possible to allow obtaining of results with incorrect check digits
- Singapore ID recognizer is split in two recognizers - one for front and one for back side
- added Belgian account number check to IBAN parser
- added support for Android 7 multi-window mode
- fixed autofocus bug on Huawei Honor 8
- fixed black camera on Motorola Moto Z
- made camera focusing more stable on some devices
    - _stable_ means less "jumpy" when searching for focused image
- added support for receiving of `GlareMetadata` which informs user that there is too much glare for performing recognition of ID document

## 3.3.0

- removed `RecognizerView` method `setInitialScanningPaused`. For achieving the same functionality, method `pauseScanning` should be used.
- added support for scanning IBANs that contain spaces and dashes
- improved `MRTDRecognizer`: when obtaining of full document images is enabled with `setShowFullDocument` method, recognizer returns result only after the document image has been returned.

## 3.2.0

- fixed camera management on LG X Cam
- improved IBAN parser
- _LibRecognizer.aar_ renamed to _LibBlinkID.aar_
- added support for scanning Slovenian IDs
- fixed crash on ARMv7 devices when using `ImageListener`
- added support for drawing MRZ detection result

## 3.1.0
- US Driver's Licence:
    - fixed parsing of Virgin Islands DL
    - added support for Arkansas DL
    - added support for new South Carolina DL
- Malaysian ID:
    - added support for returning face image
    - fixed wrong parsing of birth date
- fixed rare NPE in SegmentScanActivity
- workaround for camera bug on some samsung devices

## 3.0.0
- added `MobileCouponsParser` for reading prepaid codes from mobile phone coupons
- `DateParser` returns result as java `Date` object and as original date `String`
- added method `getSpecificParsedResult` to `TemplatingRecognitionResult` (`BlinkOCRRecognitionResult`) which returns specific parser results, e.g. java `Date` for `DateParser`
- added support for scanning front and back side of Serbian ID cards
- added support for scanning Malaysian iKad documents
- migrated to libc++ native runtime and used clang from NDKr12b for building the native code
    - this enabled c++14 features which will help us yield much better performance in the future

## 2.9.0
- added support for scanning front and back side of Slovak ID cards
- added support for scanning front and back side of German ID cards
- added support for Austrian DL
- improved support for scanning Croatian ID cards
- fixed crashes on Nexus 6 (Android 7.0)

## 2.8.0
- enabled reading of longer ITF barcodes
- added support for Malaysian visa
- added support for Malaysian work permits

## 2.7.1
- added support for Alberta (Canada) DL

## 2.7.0
- added support for scanning front and back side of Austrian ID cards
- added support for scanning front and back side of Czech ID cards
- improved support for scanning Croatian ID cards
- Singapore ID scanning now works even when scanning ID which is positioned upside down
- in templating API recognition data does not need to be valid anymore in classification step
- added support for scanning MRZ of green cards
- support for parsing Vehicle Identification Numbers (VINs)
- support for parsing vehicle licence plates
- renamed BlinkOCRActivity to SegmentScanActivity
- added RandomScanActivity which is similar to SegmentScanActivity but it does not force the user to scan text segments in the predefined order
- improved autofocus support on SGS6 and SGS7
- fixed memory leak in RecognitionProcessCallback, leak was caused by Recognizer singleton holding reference to both Context and MetadataListener even after termination

## 2.6.0
- added support for templating API
	- templating API gives you possiblity to combine various detectors with parsers and thus create your own recognizer that can recognize any type of document
	- check updated `BlinkID` demo app for example of how templating API could be used to scan both front and rear side of croatian ID cards
- updated `BlinkOCRActivity`:
	- `ScanConfiguration` can now define following new features: 
		- whether this configuration is required or optional
		- size of field displayed
- added support for scanning North Carolina driver license barcodes
- added support for following MRZ codes:
	- austrian ID
	- kuwait ID
	- pakistani ID
- added recognizers specialized for scanning front and back side of Croatian ID cards
	- although this can be achieved using templating API, we also added dedicated recognizers for convenience
- added support for scanning Singapore ID cards

## 2.5.0
- FailedDetectionMetadata, PointsDetectionMetadata and QuadDetectionMetadata have been replaced with DetectionMetadata which now holds a DetectorResult
    - DetectorResult is more flexible as it allows more different detection types to be added in future
- fixed several possible crashes in camera management
- fixed autofocus bug on LG devices when metering areas or non-default zoom level were set
- fixed autofocus bug on LG G4 (not related to bug above)
- fixed bug which caused document number to have zeros and Os misrecognized, even if OCR was 100% correct

## 2.4.0
- fixed ANR on Samsung Galaxy S3 Mini VE
- added RegexParser which can parse almost any regular expression from OCR result

## 2.3.1
- fixed bug in parsing dates from German's Driver's licenses

## 2.3.0
- reconfigureRecognizers method now throws an error if phone does not have autofocus and at least one of new recognizers require it
- raw resources are now packed as assets
- fixed bug with isScanningPaused which sometimes returned bogus value and caused scanning to work even if initial scanning was set to be paused
- support for scanning custom camera frames via DirectAPI
- added support for scanning german driver licences
    - this is achieved by renaming UKDL recognizer to EUDL recognizer which now supports
      both UK driver's licences and german driver's licences
    - this recognizer will be expanded in future with support for other DL's from European contries
- fixed bug on some devices causing it to never start scanning if device was not shaken
- increased OCR engine initialisation speed
- improved Frame Quality Estimation on low-end devices (fixed regression introduced in v1.7.0)
- added new options to BlinkOcrEngineOptions

## 2.2.0
- support detecting on activity flip event
- fix recognition of long names in MyKad ID cards
- fixed crash in RecognizerCompatibility on ARMv7 without NEON
- added RecognizerCompatibility to javadoc
- added Sony Xperia L to OpenGL blacklist
- fixed NPE in BarcodeDetailedData

## 2.1.0
- added Detector Recognizer which gives you ability to use one of provided detectors to obtain location of object in camera frame or in image
- improved performance of conversion of [Image](https://blinkid.github.io/blinkid-android/com/microblink/image/Image.html) object into Bitmap
- added support for obtaining image of scanned MyKad document
- added support for obtaining image of scanned UKDL document
- added support for scanning MyKad document via DirectAPI
- fixed crash that could be caused by quickly restarting camera activity
- fixed bug in camera layout in certain aspect ratios of camera view
- fixed bug in segment scan when put on landscape activity
- added support for scanning MRTD with wrong checkdigit on date field
- fixed bug in handling setMeteringAreas
- setMeteringAreas now receives boolean indicating whether set areas should be rotated with device
- added support for specifying camera aspect mode from XML


## 2.0.0
- new API which is easier to understand, but is not backward compatible. Please check [README](README.md) and updated demo applications for more information.
- removed support for ARMv7 devices which do not support NEON SIMD
	- this enabled us to increase recognition speed at cost of not supporting old devices like those using NVIDIA Tegra 2
	- you can check [this article](https://microblink.zendesk.com/hc/en-us/articles/206113151-Removing-support-for-devices-without-NEON-SIMD-extensions) for more information about NEON and why we use it
- added official support for Android 6.0 and it's runtime camera permissions
	- if using provided activities, the logic behind asking user to give camera permission is handled internally
	- if integrating using custom UI, you are required to ask user to give you permission to use camera. To make this easier, we have provided a _CameraPermissionManager_ class which does all heavylifting code about managing states when asking user for camera permission. Refer to demo apps to see how it is used.
- BlinkID now depends on appcompat-v7 library, instead of full android-support library.
	- even older versions of BlinkID required only features from appcompat-v7 so we now decided to make appcompat-v7 as dependency because it is much smaller than full support library and is also default dependency of all new Android apps.
- added support for scanning front side of Malaysian MyKad documents
- completely rewritten JNI bridge between Java and native code
	- this caused almost 3x increase in recognition performance in our internal tests
- fixed camera orientation bug on Nexus 5X
- DirectAPI no longer recycles Bitmap after performing recognition of it
	- this now gives you the possibility to reuse the Bitmap after it has been recognised
- **IMPORTANT** - `onScanningDone` callback method does not automatically pause scanning loop anymore. As soon as `onScanningDone` method ends, scanning will be automatically resumed without resetting state
	- if you need to reset state, please call `resetRecognitionState` in your implementation of `onScanningDone`
	- if you need to have scanning paused after `onScanningDone` ends, please call `pauseScanning` in your implementation of `onScanningDone`. Do not forget to call `resumeScanning` to resume scanning after it has been paused.
- `pauseScanning` and `resumeScanning` calls are now counted, i.e. if you call `pauseScanning` twice, you will also need to call `resumeScanning` twice to actually resume scanning
	- this is practical if you show multiple onboarding views over camera and you want the scanning paused while each is shown and you do not know in which order they will be dismissed. Now you can simply call `pauseScanning` on showing the onboarding view and `resumeScanning` on dismissing it, regardless of how many onboarding views you have
	- if you want to show onboarding help first time your scan activity starts, you can call `setInitialScanningPaused(true)` which will ensure that first time camera is started, the scanning will not automatically start - you will need to call `resumeScanning` to start scanning after your onboarding view is dismissed
- added support for `x86_64` architecture

## 1.9.0
- fixed autofocus issue on devices that do not support continuous autofocus
- improved performance and quality of United Kingdom's Driver's Licence scanning
- improved OCR quality when scanning documents with machine readable zone
- support for defining camera video resolution preset
	- to define video resolution preset via Intent, use `BlinkOCRActivity.EXTRAS_CAMERA_VIDEO_PRESET`
	- to define video resolution preset on `RecognizerView`, use method `setVideoResolutionPreset`


## 1.8.0
- added support for scanning barcodes with _BlinkID_
- added support for performing raw OCR with _BlinkID_
- improved USDL barcode parsing
	- better handling of FullName, FullAddress, Height and Weight of cardholder
- fixed crash in USDL parser
- fixed race condition causing memory leak or rare crashes
- fixed `NullPointerException` in `BaseCameraView.dispatchTouchEvent`
- fixed bug that caused returning scan result from old video frame
- fixed `NullPointerException` in camera2 management
- fixed rare race condition in gesture recognizer
- fixed segmentation fault on recognizer reconfiguration operation
- fixed freeze when camera was being quickly turned on and off
- ensured `RecognizerView` lifecycle methods are called on UI thread
- ensure `onCameraPreviewStarted` is not called if camera is immediately closed after start before the call should have taken place
- ensure `onScanningDone` is not called after `RecognizerView` has been paused, even if it had result ready just before pausing
- added support for using _BlinkID_ as camera capture API. To do that, implement following:
	- when using `RecognizerView` do not call `setRecognitionSettings` or call it with `null` or empty array
	- implement `ImageListener` interface and set the listener with `setImageListener`
	- as a reminder - you can process video frames obtained that way using DirectAPI method `recognizeImageWithSettings`
- added `BlinkIDDemoCustomSegmentScan ` demo app that demonstrates advanced integration of SegmentScan feature within custom scan activity. It also demonstrates how to perform generic OCR of full camera frame, how to draw OCR results on screen and how to obtain OcrResult object for further processing.
- all demo apps now use Maven integration method because it is much easier than importing AAR manually

## 1.7.1
- fixed NullPointerException when RecognizerSettings array element was `null`
- fixed black rectangle bug on some devices

## 1.7.0
- utilize Camera2 API on devices that support it to achieve much better frame grabbing performance
- new algorithm for determining which video frame is of good enough quality to be processed - it uses much less memory than last one and works in separate thread so it does not impact image recognition thread
	- this results in much better and faster scanning performance
- support for [defining camera metering areas](https://blinkid.github.io/blinkid-android/com/microblink/view/BaseCameraView.html#setMeteringAreas(com.microblink.geometry.Rectangle[])) that will camera use to perform focus, exposure and white balance measurement.
- support for obtaining raw MRZ text even if our internal parser fails to parse it
	- in order to do that, you must [enable returning of unparsed MRTD results](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/ocr/mrtd/MRTDRecognizerSettings.html#setAllowUnparsedResults(boolean))
	- when obtaining [MRTD recognition result](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/ocr/mrtd/MRTDRecognitionResult.html), you should check if [MRZ was parsed](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/ocr/mrtd/MRTDRecognitionResult.html#isMRZParsed())
		- if MRZ was parsed, you can obtain parsed data as ususal
		- if MRZ was not parsed, you can obtain [raw OCR result](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/ocr/mrtd/MRTDRecognitionResult.html#getOcrResult()) and parse it yourself
- added support for Visa MRZ format in internal MRZ parser
- support for obtaining image of [MRZ zone](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/ocr/mrtd/MRTDRecognizerSettings.html#setShowMRZ(boolean)) and [full document image](https://blinkid.github.io/blinkid-android/com/microblink/recognizers/ocr/mrtd/MRTDRecognizerSettings.html#setShowFullDocument(boolean)) via [ImageListener](https://blinkid.github.io/blinkid-android/com/microblink/image/ImageListener.html)
- bitmaps can now be processed while [RecognizerView](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html) is active using method [recognizeBitmap](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#recognizeBitmap(android.graphics.Bitmap, com.microblink.hardware.orientation.Orientation, com.microblink.view.recognition.ScanResultListener))
- removed method `resumeScanningWithoutStateReset` - method [resumeScanning](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html#resumeScanning(boolean)) of [RecognizerView](https://blinkid.github.io/blinkid-android/com/microblink/view/recognition/RecognizerView.html) now receives `boolean` indicating whether internal state should be reset
- by default, null quiet zone is now set to `true` in US Driver's License recognizer

## 1.6.0
- removed support for ARMv5 and ARMv6 processors (armeabi) because of their very poor scanning performance
- optimized MRZ text extraction algorithm - 0-O confusion now does not cause extremely long processing that resulted in freezing the device
- updated documentation with use cases for which BlinkID is applicable
- fixed crash in DirectAPI when recognizer was terminated in the middle of recognition process

## 1.5.0
- support for defining camera aspect mode via intent
- removed autoscale setting from USDL recognizer - autoscale is now always used
- added MRZ detector to MRTD recognizer - Machine Readable Zone location can now be detected almost everywhere on the image

## 1.4.0
- added support for defining region for scanning MRZ
- added support for scanning UK Driver's Licence, check [README](Readme.md) for details
- improved parsing of MRZ (Machine Readable Zones)
- support for defining camera zoom level
- fixed NPE when null SuccessCallback was given

## 1.3.1
- Improved parsing of some problematic US Driver's Licence barcodes

## 1.3.0
- Added support for non-standard issuing authorities

## 1.2.0
- added support for US Driver's Licence barcode scanning
- introduced new licence key format which is now mandatory (generate your free licence key on [https://microblink.com/login](https://microblink.com/login) or contact us at [http://help.microblink.com](http://help.microblink.com)

## 1.1.0
- added support for obtaining complete unparsed MRZ lines
- fixed crash on Motorola Lex755 and Sony Xperia Z

## 1.0.1
- Support for two-letter country codes

## 1.0.0
- Support for MRZ formats in passports and ID cards
- Support for integration via Maven
- Documentation update

## 0.6.0
- Scanning support for MRZ formats
