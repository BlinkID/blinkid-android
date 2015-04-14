## Keys for obtaining US Driver's license data

Standard for US Driver's Licenses defines 9 different barcode standards (AAMVA versions) with over 80 different fields encoded inside a barcode. Some fields exist on all barcode standards, other exist only on some. To standardize the API, we have structured the fields in the following sections:

1. [Determining AAMVA version](#020601)
2. [Keys existing on all barcode versions](#020602)
	- [Mandatory values](#0206021)
		- [Personal data](#02060211)
		- [License data](#02060212)
	- [Optional values](#0206022)
		- [Personal data](#02060221)
		- [License data](#02060222)
3. [Keys existing on some barcode versions](#020603)
	- [Mandatory values](#0206031)
		- [Personal data](#02060311)
		- [License data](#02060312)
	- [Optional values](#0206032)
		- [Personal data](#02060321)
		- [License data](#02060322)
4. [Keys for accessing raw barcode results](#020604)

### <a name="020601"></a> Determining AAMVA version

 - `USDLScanResult.kAamvaVersionNumber` - Mandatory on all AAMVA driver's license versions. Specifies the version level of the PDF417 bar code format. Possible values are "0", "1", "2", "3", "4", "5", "6", "7", "8", and "Compact". 

### <a name="020602"></a> Keys existing on all standard barcode versions

#### <a name="0206021"></a> Mandatory values

#### <a name="02060211"></a> Personal data

 - `USDLScanResult.kCustomerFamilyName` - Family name of the cardholder. 
 	- Mandatory on all barcode versions, including compact encoding.
 - `USDLScanResult.kCustomerFirstName` - First name of the cardholder. 
 	- Mandatory on all barcode versions, including compact encoding.
 - `USDLScanResult.kDateOfBirth` - Date on which the cardholder was born. (MMDDCCYY format). 
 	- Mandatory on all barcode versions, including compact encoding.
 - `USDLScanResult.kSex` - Gender of the cardholder. 
 	- Mandatory on all barcode versions, including compact encoding.
 	- 1 = male, 
 	- 2 = female.
 - `USDLScanResult.kEyeColor` - Color of cardholder's eyes. 
 	- Mandatory on all barcode versions, including compact encoding. (ANSI D-20 codes)
 	- BLK = Black
 	- BLU = Blue
 	- BRO = Brown
 	- GRY = Gray
 	- GRN = Green
 	- HAZ = Hazel
 	- MAR = Maroon 
 	- PNK = Pink
 	- DIC = Dichromatic 
 	- UNK = Unknown
 - `USDLScanResult.kHeight` - Height of cardholder. Possible values are either in inches or in centimeters.
	- Mandatory on AAMVA 02, 03, 04, 05, 06, 07, 08 and Compact encoding. Optional on 01.
	- See also `USDLScanResult.kHeightIn`, `USDLScanResult.kHeightCm`
	- Inches (in): number of inches followed by " in" or " IN". Example. 6'1'' = "073 in"
	- Centimeters (cm): number of centimeters followed by " cm" or " CM". Example. 181 centimeters = "181 cm"
 - `USDLScanResult.kAddressStreet` - Street portion of the cardholder address. The place where the registered driver of a vehicle (individual or corporation) may be contacted such as a house number, street address etc. 
 	- Mandatory on all standard barcode versions. Not defined on Compact encoding, where you must use `USDLScanResult.kFullAddress`.
 - `USDLScanResult.kAddressCity` - City portion of the cardholder address. 
 	- Mandatory on all standard barcode versions. Not defined on Compact encoding, where you must use `USDLScanResult.kFullAddress`.
 - `USDLScanResult.kAddressJurisdictionCode` - State portion of the cardholder address. 
 	- Mandatory on all standard barcode versions. Not defined on Compact encoding, where you must use `USDLScanResult.kFullAddress`.
 - `USDLScanResult.kAddressPostalCode` - Postal code portion of the cardholder address in the U.S. and Canada. If the trailing portion of the postal code in the U.S. is not known, zeros will be used to fill the trailing set of numbers up to nine (9) digits. 
 	- Mandatory on all standard barcode versions. Not defined on Compact encoding, where you must use `USDLScanResult.kFullAddress`.

#### <a name="02060212"></a> License data

- `USDLScanResult.kDocumentIssueDate` - Date on which the document was issued. (MMDDCCYY format). 
 	- Mandatory on all barcode versions, including compact encoding.
- `USDLScanResult.kDocumentExpirationDate` - Date on which the driving and identification privileges granted by the document are
 no longer valid. (MMDDCCYY format). 
 	- Mandatory on all barcode versions, including compact encoding.
- `USDLScanResult.kDocumentExpirationMonth` - Date on which the driving and identification privileges granted by the document are
     no longer valid. (MMYY format)
     - Optional on AAMVA Magnetic Stripe Encoding
- `USDLScanResult.kDocumentNonexpiring` - Field that indicates that the driving and identification privileges granted by the
     document are nonexpiring = "1".
     - Optional on AAMVA Magnetic Stripe Encoding
- `USDLScanResult.kIssuerIdentificationNumber` - This number uniquely identifies the issuing jurisdiction and can
 be obtained by contacting the ISO Issuing Authority (AAMVA). 
 	- Mandatory on all standard barcode formats, optional on compact encoding.
- `USDLScanResult.kJurisdictionVersionNumber` - Jurisdiction Version Number: This is a number value between "0" and "99" that
 specifies the jurisdiction version level of the PDF417 bar code format. 
 	- Mandatory on all barcode versions, including compact encoding.
- `USDLScanResult.kJurisdictionVehicleClass` - Jurisdiction-specific vehicle class / group code, designating the type
 of vehicle the cardholder has privilege to drive. 
 	- Mandatory on all standard barcode versions. Not defined on Compact encoding, which has no compatible field.
- `USDLScanResult.kJurisdictionRestrictionCodes` - Jurisdiction-specific codes that represent restrictions to driving
 privileges (such as airbrakes, automatic transmission, daylight only, etc.). 
 	- Mandatory on all standard barcode versions. Not defined on Compact encoding, which has no compatible field.
- `USDLScanResult.kJurisdictionEndorsementCodes` - Jurisdiction-specific codes that represent additional privileges
 granted to the cardholder beyond the vehicle class (such as transportation of
 passengers, hazardous materials, operation of motorcycles, etc.). 
 	- Mandatory on all standard barcode versions. Not defined on Compact encoding, which has no compatible field.
- `USDLScanResult.kCustomerIdNumber` - The number assigned or calculated by the issuing authority. 
	- Mandatory on all barcode versions, including compact encoding.

#### <a name="0206022"></a> Optional values

#### <a name="02060221"></a> Personal data

- `USDLScanResult.kHairColor` - Bald, black, blonde, brown, gray, red/auburn, sandy, white, unknown. If the issuing
 jurisdiction wishes to abbreviate colors, the three-character codes provided in ANSI D20 must be
 used. 
 	- Optional on all barcode versions, including compact encoding.
	- BAL = Bald
	- BLK = Black
	- BLN = Blond
	- BRO = Brown
	- GRY = Grey
	- RED = Red/Auburn 
	- SDY = Sandy
	- WHI = White 
	- UNK = Unknown
 
- `USDLScanResult.kNameSuffix` - Name Suffix (If jurisdiction participates in systems requiring name suffix (PDPS, CDLIS, etc.), the suffix must be collected and displayed on the DL/ID). 
	- Optional on all barcode versions, including compact encoding.
 	- JR (Junior)
 	- SR (Senior)
 	- 1ST or I (First)
 	- 2ND or II (Second)
 	- 3RD or III (Third)
 	- 4TH or IV (Fourth)
 	- 5TH or V (Fifth)
 	- 6TH or VI (Sixth)
 	- 7TH or VII (Seventh)
 	- 8TH or VIII (Eighth)
 	- 9TH or IX (Ninth). 
- `USDLScanResult.kAddressStreet2` - Second line of street portion of the cardholder address. 
	- Optional on all standard barcode versions. Not defined on Compact encoding, where you must use `USDLScanResult.kFullAddress`.


#### <a name="02060222"></a> License data

- `USDLScanResult.kIssuingJurisdiction` - Jurisdictions may define a subfile to contain jurisdiction-specific information.
 These subfiles are designated with the first character of “Z” and the second
 character is the first letter of the jurisdiction's name. For example, "ZC" would
 be the designator for a California or Colorado jurisdiction-defined subfile; "ZQ"
 would be the designator for a Quebec jurisdiction-defined subfile. In the case of
 a jurisdiction-defined subfile that has a first letter that could be more than
 one jurisdiction (e.g. California, Colorado, Connecticut) then other data, like
 the `USDLScanResult.kIssuerIdentificationNumber`, `USDLScanResult.kAddressJurisdictionCode` or `USDLScanResult.kFullAddress` must be examined to determine the jurisdiction. 
 	- Optional on all barcode versions, mandatory on Compact Encoding
 
- `USDLScanResult.kStandardVehicleClassification` -  Standard vehicle classification code(s) for cardholder. This data element is a
 placeholder for future efforts to standardize vehicle classifications.
 	- Optional on all barcode versions, including compact encoding.
- `USDLScanResult.kStandardEndorsementCode` - Standard endorsement code(s) for cardholder. This data element is a placeholder for future efforts to standardize endorsement codes.
	- Optional on all barcode versions, including compact encoding.
 	- H = Hazardous Material - This endorsement is required for the operation of any vehicle
 transporting hazardous materials requiring placarding, as defined by U.S.
 Department of Transportation regulations.
 	- L = Motorcycles – Including Mopeds/Motorized Bicycles.
 	- N = Tank - This endorsement is required for the operation of any vehicle transporting,
 as its primary cargo, any liquid or gaseous material within a tank attached to the vehicle.
 	- O = Other Jurisdiction Specific Endorsement(s) - This code indicates one or more
 additional jurisdiction assigned endorsements.
	- P = Passenger - This endorsement is required for the operation of any vehicle used for
 transportation of sixteen or more occupants, including the driver.
 	- S = School Bus - This endorsement is required for the operation of a school bus. School bus means a
 CMV used to transport pre-primary, primary, or secondary school students from home to school,
 from school to home, or to and from school sponsored events. School bus does not include a
 bus used as common carrier (49 CRF 383.5).
 	- T = Doubles/Triples - This endorsement is required for the operation of any vehicle that would be
 referred to as a double or triple.
	- X = Combined Tank/HAZ-MAT - This endorsement may be issued to any driver who qualifies for
 both the N and H endorsements.
- `USDLScanResult.kStandardRestrictionCode` - Standard restriction code(s) for cardholder. This data element is a placeholder
 for future efforts to standardize restriction codes.
 	- Optional on all standard barcode versions. Not defined on Compact encoding, which has no compatible field.
 	- B = Corrective Lenses
 	- C = Mechanical Devices (Special Brakes, Hand Controls, or Other Adaptive Devices)
 	- D = Prosthetic Aid
 	- E = Automatic Transmission
 	- F = Outside Mirror
 	- G = Limit to Daylight Only
 	- H = Limit to Employment
 	- I = Limited Other
 	- J = Other
 	- K = CDL Intrastate Only
 	- L = Vehicles without air brakes
 	- M = Except Class A bus
 	- N = Except Class A and Class B bus
 	- O = Except Tractor-Trailer
	- V = Medical Variance Documentation Required
 	- W = Farm Waiver
	
### <a name="020603"></a> Keys existing on some barcode versions

#### <a name="0206031"></a> Mandatory values

#### <a name="02060311"></a> Personal data

- `USDLScanResult.kCustomerMiddleName` - Middle name(s) of the cardholder. In the case of multiple middle names they
 shall be separated by a comma ",".-
 	- Mandatory on AAMVA version 04, 05, 06, 07, 08, optional on 01. On other standards middle 
 name is included into value of USDLScanResult.kFirstName.
- `USDLScanResult.kHeightIn` - Height of cardholder. (FT/IN)
 	- FEET (1st char); Inches (2nd and 3rd char). Example: 509 = 5 ft., 9 in.
 	- Optional on 01.
 	- See also USDLScanResult.kHeight, USDLScanResult.kHeightCm
- `USDLScanResult.kHeightCm` - Height of cardholder in centimeters. 
	- Optional on 01.
	- See also USDLScanResult.kHeight, USDLScanResult.kHeightIn
- `USDLScanResult.kCustomerFullName` - Full name of the individual holding the Driver License or ID as defined in
 ANSI D20 Data Dictionary. (Lastname,Firstname,MI,suffix if any). This field contains four portions, separated with the "," delimiter: 
 	- Last Name (required)
 	- , (required)
 	- First Name (required)
 	- , (required if other name portions follow, otherwise optional)
 	- Middle Name(s) (optional)
 	- , (required if other name portions follow, otherwise optional)
 	- Suffix Code (optional)
 	- , (optional)
- `USDLScanResult.kFullAddress` - Cardholder address.
	- Mandatory on compact encoding.
- `USDLScanResult.kFamilyNameTruncation` - A code that indicates whether a field has been truncated (T), has not been
 truncated (N), or – unknown whether truncated (U).
 	- Mandatory on AAMVA 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kFirstNameTruncation` - A code that indicates whether a field has been truncated (T), has not been
 truncated (N), or – unknown whether truncated (U).
 	- Mandatory on AAMVA 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kMiddleNameTruncation` - A code that indicates whether a field has been truncated (T), has not been
 truncated (N), or – unknown whether truncated (U).
 	- Mandatory on AAMVA 04, 05, 06, 07, 08

#### <a name="02060312"></a> License data

- `USDLScanResult.kCountryIdentification` - Country in which DL/ID is issued. U.S. = USA, Canada = CAN.
	- Mandatory on AAMVA 02, 03, 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kDocumentDiscriminator` - Number must uniquely identify a particular document issued to that customer from others that may have been issued in the past. This number may serve multiple purposes of document discrimination, audit information number, and/or inventory control.
	- Mandatory on AAMVA 02, 03, 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kFederalCommercialVehicleCodes` - Federally established codes for vehicle categories, endorsements, and restrictions that are generally applicable to commercial motor vehicles. If the vehicle is not a commercial vehicle, "NONE" is to be entered.
	- Mandatory on AAMVA versions 02 and 03.
- `USDLScanResult.kSecurityVersion` - Security version beeing used.
	-  Mandatory on AMMVA Magnetic Stripe Encoding

#### <a name="0206032"></a> Optional values

#### <a name="02060321"></a> Personal data

- `USDLScanResult.kRaceEthnicity` - Codes for race or ethnicity of the cardholder, as defined in ANSI D20.
	- Optional on AAMVA 02, 03, 04, 05, 06, 07, 08 and Compact Encoding
	- **Race**
 	- AI = Alaskan or American Indian (Having Origins in Any of The Original Peoples of North America, and Maintaining Cultural Identification Through Tribal Affiliation of Community Recognition)
	- AP = Asian or Pacific Islander (Having Origins in Any of the Original Peoples of the Far East, Southeast Asia, or Pacific Islands. This Includes China, India, Japan, Korea, the Philippines Islands, and Samoa)
	- BK = Black (Having Origins in Any of the Black Racial Groups of Africa)
	- W = White (Having Origins in Any of The Original Peoples of Europe, North Africa,
 or the Middle East)
 	- **Ethnicity**
	- H = Hispanic Origin (A Person of Mexican, Puerto Rican, Cuban, Central or South American or Other Spanish Culture or Origin, Regardless of Race)
	- O = Not of Hispanic Origin (Any Person Other Than Hispanic) 
	- U = Unknown
- `USDLScanResult.kPlaceOfBirth` - Country and municipality and/or state/province
	- Optional on AAMVA 02, 03, 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kWeightRange` - Indicates the approximate weight range of the cardholder:
	- Optional on AAMVA 02, 03, 04, 05, 06, 07, 08
	- 0 = up to 31 kg (up to 70 lbs)
	- 1 = 32 – 45 kg (71 – 100 lbs)
	- 2 = 46 - 59 kg (101 – 130 lbs)
	- 3 = 60 - 70 kg (131 – 160 lbs)
	- 4 = 71 - 86 kg (161 – 190 lbs)
	- 5 = 87 - 100 kg (191 – 220 lbs)
	- 6 = 101 - 113 kg (221 – 250 lbs)
	- 7 = 114 - 127 kg (251 – 280 lbs)
	- 8 = 128 – 145 kg (281 – 320 lbs)
	- 9 = 146+ kg (321+ lbs)
- `USDLScanResult.kWeightPounds` - Cardholder weight in pounds Ex. 185 lb = "185"
	- Optional on AAMVA 01, 04, 05, 06, 07, 08
- `USDLScanResult.kWeightKilograms` - Cardholder weight in kilograms Ex. 84 kg = "084"
	- Optional on AAMVA 01, 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kNamePrefix` - PREFIX to Driver Name. Freeform as defined by issuing jurisdiction.
	- Optional on AAMVA 01
- `USDLScanResult.kResidenceStreetAddress` - Driver Residence Street Address.
	- Optional on AAMVA version 01.
- `USDLScanResult.kResidenceStreetAddress2` - Driver Residence Street Address 2.
	- Optional on AAMVA version 01.
- `USDLScanResult.kResidenceCity` - Driver Residence City
	- Optional on AAMVA version 01.
- `USDLScanResult.kResidenceJurisdictionCode` - Driver Residence Jurisdiction Code.
	- Optional on AAMVA version 01.
- `USDLScanResult.kResidencePostalCode` - Driver Residence Postal Code.
	- Optional on AAMVA version 01.
- `USDLScanResult.kUnder18` - Date on which the cardholder turns 18 years old. (MMDDCCYY format)
	- Optional on AAMVA 05, 06, 07, 08
- `USDLScanResult.kUnder19` - Date on which the cardholder turns 19 years old. (MMDDCCYY format)
	- Optional on AAMVA 05, 06, 07, 08
- `USDLScanResult.kUnder21` - Date on which the cardholder turns 21 years old. (MMDDCCYY format)
	- Optional on AAMVA 05, 06, 07, 08
- `USDLScanResult.kSocialSecurityNumber` - The number assigned to an individual by the Social Security Administration.
	- Optional on AAMVA version 01.
- `USDLScanResult.kAKASocialSecurityNumber` - Driver "AKA" Social Security Number. FORMAT SAME AS DRIVER SOC SEC NUM. ALTERNATIVE NUMBERS(S) used as SS NUM.
	- Optional on AAMVA version 01.
- `USDLScanResult.kAKAFullName` - Other name by which cardholder is known. ALTERNATIVE NAME(S) of the individual holding
 the Driver License or ID. FORMAT same as defined in ANSI D20 Data Dictionary. (Lastname,Firstname,MI, suffix if any.) This field contains four portions, separated with the "," delimiter: Last Name (required)
	- , (required)
	- First Name (required)
	- , (required if other name portions follow, otherwise optional)
	- Middle Name(s) (optional)
	- , (required if other name portions follow, otherwise optional)
	- Suffix Code (optional)
	- , (optional)
- `USDLScanResult.kAKAFamilyName` - Other family name by which cardholder is known.
	- Optional on AAMVA 01, 03, 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kAKAMiddleName` - ALTERNATIVE MIDDLE NAME(s) or INITIALS of the individual holding the Driver License or ID. Hyphenated names acceptable, spaces between names acceptable, but no other use of special symbols
	- Optional on AAMVA 01
- `USDLScanResult.kAKAGivenName` - Other given name by which cardholder is known
	- Optional on AAMVA 01, 03, 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kAKAPrefixName` - ALTERNATIVE PREFIX to Driver Name. Freeform as defined by issuing jurisdiction.
	- Optional on AAMVA 01
- `USDLScanResult.kAKASuffixName` - Other suffix by which cardholder is known. The Suffix Code Portion, if submitted, can contain only the Suffix Codes shown in the following table (e.g., Andrew Johnson, III = JOHNSON,ANDREW,,3RD):
	- JR = Junior
	- SR = Senior or Esquire 1ST First
	- 2ND = Second
	- 3RD = Third
	- 4TH = Fourth
	- 5TH = Fifth
	- 6TH = Sixth
	- 7TH = Seventh
	- 8TH = Eighth
	- 9TH = Ninth
- `USDLScanResult.kOrganDonor` - Field that indicates that the cardholder is an organ donor = "1".
	- Optional on AAMVA 06, 07, 08
- `USDLScanResult.kVeteran` - Field that indicates that the cardholder is a veteran = "1"
	- Optional on AAMVA 07, 08
- `USDLScanResult.kAKADateOfBirth` - ALTERNATIVE DATES(S) given as date of birth. (MMDDCCYY format)
	- Optional on AAMVA 01
- `USDLScanResult.kImageTimestamp` - Portrait image timestamp
	- Optional on compact encoding.
- `USDLScanResult.kImageType` - Type of image
	- Optional on compact encoding.
- `USDLScanResult.kPortraitImage` - Portrait image
	- Optional on compact encoding.
- `USDLScanResult.kBDBFormatOwner` - BDB format owner
	- Optional on compact encoding.
- `USDLScanResult.kBDBFormatType` - BDB format type
	- Optional on compact encoding.
- `USDLScanResult.kBiometricData` - Biometric data block
	- Optional on compact encoding.

#### <a name="02060322"></a> License data

- `USDLScanResult.kJurisdictionVehicleClassificationDescription` - Text that explains the jurisdiction-specific code(s) for classifications of vehicles cardholder is authorized to drive.
	- Optional on AAMVA 02, 03, 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kJurisdictionEndorsmentCodeDescription` - Text that explains the jurisdiction-specific code(s) that indicates additional driving privileges granted to the cardholder beyond the vehicle class.
	- Optional on AAMVA 02, 03, 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kJurisdictionRestrictionCodeDescription` - Text describing the jurisdiction-specific restriction code(s) that curtail driving privileges.
	- Optional on AAMVA 02, 03, 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kInventoryControlNumber` - A string of letters and/or numbers that is affixed to the raw materials (card stock,
 laminate, etc.) used in producing driver licenses and ID cards. (DHS recommended field)
	- Optional on AAMVA 02, 03, 04, 05, 06, 07, 08
- `USDLScanResult.kCardRevisionDate` - DHS required field that indicates date of the most recent version change or
 modification to the visible format of the DL/ID (MMDDCCYY format)
	- Optional on AAMVA 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kLimitedDurationDocument` - DHS required field that indicates that the cardholder has temporary lawful status = "1".
	- Optional on AAMVA 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kIssueTimestamp` - Issue Timestamp. A string used by some jurisdictions to validate the document against their data base.
	- Optional on AAMVA version 01.
- `USDLScanResult.kPermitExpirationDate` - Driver Permit Expiration Date. MMDDCCYY format. Date permit expires.
	- Optional on AAMVA version 01.
- `USDLScanResult.kPermitIdentifier` - Type of permit.
	- Optional on AAMVA version 01.
- `USDLScanResult.kPermitIssueDate` - Driver Permit Issue Date. MMDDCCYY format. Date permit was issued.
	- Optional on AAMVA version 01.
- `USDLScanResult.kNumberOfDuplicates` - Number of duplicate cards issued for a license or ID if any.
	- Optional on AAMVA version 01.
- `USDLScanResult.kAuditInformation` - A string of letters and/or numbers that identifies when, where, and by whom a driver license/ID card was made. If audit information is not used on the card or the MRT, it must be included in the driver record.
	- Optional on AAMVA 02, 03, 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kComplianceType` - DHS required field that indicates compliance: "M" = materially compliant; "F" = fully compliant; and, "N" = non-compliant.
	- Optional on AAMVA 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kHAZMATExpirationDate` - Date on which the hazardous material endorsement granted by the document is no longer valid. (MMDDCCYY format)
	- Optional on AAMVA 04, 05, 06, 07, 08 and Compact Encoding
- `USDLScanResult.kMedicalIndicator` - Medical Indicator/Codes. STATE SPECIFIC. Freeform; Standard "TBD"
	- Optional on AAMVA version 01.
- `USDLScanResult.kNonResident` - Non-Resident Indicator. "Y". Used by some jurisdictions to indicate holder of the document is a non-resident.
	- Optional on AAMVA version 01.
- `USDLScanResult.kUniqueCustomerId` - A number or alphanumeric string used by some jurisdictions to identify a "customer" across multiple data bases.
	- Optional on AAMVA version 01.
- `USDLScanResult.kDataDiscriminator` - Document discriminator.
	- Optional on compact encoding.

### <a name="020604"></a> Keys for accessing raw barcode results

- `USDLScanResult.kPdf417` - Raw pdf417 result
	- Mandatory for all USDL data
- `USDLScanResult.kCode128` - Raw code128 result
	- Optional, on US driver's licenses which have Code128 barcode printed
- `USDLScanResult.kCode39` - Raw code39 result
	- Optional, on US driver's licenses which have Code39 barcode printed
