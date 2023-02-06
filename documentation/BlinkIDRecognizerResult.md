
# BlinkID Single Side and Multi Side Recognizer Result


## Table of contents

* [MRZ Fields](#mrz-fields)
* [Anonymised Fields](#anonymised-fields)
* [AAMVA Barcode Fields](#aamva-barcode-fields)
* [All Fields](#all-fields)
<br><br><br>


<h2>MRZ Fields</h2>
Other than documents listed here, BlinkID Recognizer, both Single Side and Multi Side, also scans the <strong>Machine Readable Zone (MRZ)</strong> on standard (ISO/IEC 7501 compliant)
<strong>Machine Readable Travel Documents (MRTD)</strong>. This includes <strong>passports, visas</strong> and other identification documents.
<br>
<br>
The MRZ is parsed to produce a structure with fields:
<ul>
<li>Raw MRZ string</li>
<li>Document code</li>
<li>Document type</li>
<li>Issuer country</li>
<li>Document number</li>
<li>OPT1 field (document dependent)</li>
<li>OPT2 field (document dependent)</li>
<li>Gender</li>
<li>Nationality</li>
<li>Primary ID (last name)</li>
<li>Secondary ID (first name)</li>
<li>Date of birth</li>
<li>Date of expiry</li>
<li>Alien number (if applicable)</li>
<li>Application receipt number (if applicable)</li>
<li>Immigrant case number (if applicable)</li>
<li>Verified flag (check digits are verified)</li>
</ul>
<br>

<h2>Anonymised Fields</h2>
With the <strong>result anonymization option</strong> enabled, results are not returned for protected fields on documents listed here.
The full document image will also have this data blacked out.
<br>
Protected fields are:
<br><br>
<table><tr>
<th colspan=1>Country and document type</th><th>Anonymised fields</th> </tr>
 <tr> <td>GERMANY ID Card</td> <td>Anonymized line, Document additional number, Document number, MRZ (Document number)</td><tr>
 <tr> <td>GERMANY Minors Passport</td> <td>Document number, MRZ (Document number)</td><tr>
 <tr> <td>GERMANY Paper Passport</td> <td>Document number, MRZ (Document number)</td><tr>
 <tr> <td>GERMANY Polycarbonate Passport</td> <td>Document number, MRZ (Document number)</td><tr>
 <tr> <td>HONG KONG ID Card</td> <td>Anonymized line, Document number</td><tr>
 <tr> <td>HONG KONG Polycarbonate Passport</td> <td>Anonymized line, Anonymized vertical line, Document number, MRZ (Document number, Opt1)</td><tr>
 <tr> <td>MALAYSIA MyKAS</td> <td>Religion</td><tr>
 <tr> <td>MALAYSIA MyKad</td> <td>Religion</td><tr>
 <tr> <td>MALAYSIA MyKid</td> <td>Religion</td><tr>
 <tr> <td>MALAYSIA MyPR</td> <td>Religion</td><tr>
 <tr> <td>MALAYSIA MyTentera</td> <td>Religion</td><tr>
 <tr> <td>NETHERLANDS Driving Licence</td> <td>Personal ID number</td><tr>
 <tr> <td>NETHERLANDS ID Card</td> <td>MRZ (Opt1), Personal ID number</td><tr>
 <tr> <td>NETHERLANDS Polycarbonate Passport</td> <td>MRZ (Opt1)</td><tr>
 <tr> <td>SINGAPORE Driving Licence</td> <td>Anonymized line, Document number</td><tr>
 <tr> <td>SINGAPORE Employment Pass</td> <td>Anonymized line, Personal ID number</td><tr>
 <tr> <td>SINGAPORE Fin Card</td> <td>Anonymized line, Document number</td><tr>
 <tr> <td>SINGAPORE ID Card</td> <td>Anonymized line, Document number</td><tr>
 <tr> <td>SINGAPORE Resident ID</td> <td>Anonymized line, Document number</td><tr>
 <tr> <td>SINGAPORE Polycarbonate Passport</td> <td>Anonymized line, Document number, MRZ (Document number, Opt1), Personal ID number</td><tr>
 <tr> <td>SINGAPORE S Pass</td> <td>Anonymized line, Document number, Personal ID number</td><tr>
 <tr> <td>SINGAPORE Work Permit</td> <td>Anonymized line, Document number, Personal ID number</td><tr>
 <tr> <td>SOUTH KOREA Driving Licence</td> <td>Personal ID number</td><tr>
 <tr> <td>SOUTH KOREA ID Card</td> <td>Document number</td><tr>
 <tr> <td>SOUTH KOREA Paper Passport</td> <td>MRZ (Opt1), Personal ID number</td><tr>
</table>
<br><br>

<h2>AAMVA Barcode Fields</h2>
<p>AAMVA standard compliant barcodes (US, Canada documents) contain these fields:</p>
<ul>
<li>Address</li>
<li>Date of birth</li>
<li>Date of expiry</li>
<li>Date of issue</li>
<li>Document number</li>
<li>Endorsements</li>
<li>Restrictions</li>
<li>Vehicle class</li>
<li>First name</li>
<li>Full name</li>
<li>Last name</li>
<li>Sex
</ul>

<br>
<h2>All Fields</h2>

<p align="justify">
The tables below represent scanning results for each document in each country supported in BlinkID v6. The fields marked as "Always" are mandatory on all document versions and 
will always be a part of the result set. The ones marked as "Always if present" will be returned only if they exist on the specific document being scanned. 
"Pending" stands for those fields for which it's not certain whether or not they're present on all document versions. For US documents, all information concerns both horizontal 
and vertical supported documents.

Currently, in BlinkID v6 we support the extraction of fields in Latin, Cyrillic, and Arabic scipts. Information about supported scripts for each document is listed
in the tables in [documents.md](BlinkIDRecognizer.md) file in this repository.
<br>
<br>

<table><tr>
<th colspan=2>AFGHANISTAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Empty document side</td> <td></td><tr>


<th colspan=2>AFGHANISTAN ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>AFGHANISTAN Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>ALBANIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<th colspan=2>ALBANIA Driver Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>ALBANIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>ALBANIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>ALBANIA Professional DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>ALBANIA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>ALGERIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>ALGERIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>ALGERIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>ALGERIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>ALGERIA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>ANTIGUA AND BARBUDA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>ARGENTINA Alien ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>ARGENTINA Alien ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>ARGENTINA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>ARGENTINA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>MRZ</td> <td>Always if present</td><tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>ARGENTINA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>

<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>ARGENTINA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>ARMENIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>ARMENIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA AUSTRALIAN CAPITAL TERRITORY Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Always if present</td><tr>

<th colspan=2>AUSTRALIA NEW SOUTH WALES Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Always if present</td><tr>

<th colspan=2>AUSTRALIA NEW SOUTH WALES ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>AUSTRALIA NORTHERN TERRITORY Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Always if present</td><tr>
<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>

<th colspan=2>AUSTRALIA NORTHERN TERRITORY Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>


<th colspan=2>AUSTRALIA NORTHERN TERRITORY Proof Of Age Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA NORTHERN TERRITORY Proof Of Age Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA QUEENSLAND Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Class effective date</td> <td>Always</td><tr>

<tr> <td>Class expiry date</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Licence type</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>AUSTRALIA QUEENSLAND Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Additional class effective date</td> <td>Always if present</td><tr>

<tr> <td>Additional conditions</td> <td>Always if present</td><tr>

<tr> <td>Additional licence type</td> <td>Always if present</td><tr>


<th colspan=2>AUSTRALIA SOUTH AUSTRALIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Always if present</td><tr>

<th colspan=2>AUSTRALIA SOUTH AUSTRALIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>


<th colspan=2>AUSTRALIA SOUTH AUSTRALIA Proof Of Age Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA TASMANIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Class expiry date</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Licence type</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA TASMANIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA VICTORIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>

<th colspan=2>AUSTRALIA VICTORIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>

<tr> <td>Last name</td> <td>Always if present</td><tr>


<th colspan=2>AUSTRALIA VICTORIA Proof Of Age Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>AUSTRALIA WESTERN AUSTRALIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>

<th colspan=2>AUSTRALIA WESTERN AUSTRALIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>


<th colspan=2>AUSTRIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<th colspan=2>AUSTRIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>

<th colspan=2>AUSTRIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>


<th colspan=2>AUSTRIA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>AUSTRIA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>AUSTRIA Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>AZERBAIJAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>MRZ</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Place of birth</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>AZERBAIJAN ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>

<tr> <td>Marital status</td> <td>Always if present</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>AZERBAIJAN Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BAHAMAS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BAHAMAS ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>BAHRAIN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>BAHRAIN ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>


<th colspan=2>BANGLADESH Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>BANGLADESH Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always if present</td><tr>


<th colspan=2>BANGLADESH ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>BANGLADESH ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>BANGLADESH Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>

<th colspan=2>BARBADOS ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<th colspan=2>BARBADOS ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>

<tr> <td>Full name</td> <td>Always if present</td><tr>

<tr> <td>Last name</td> <td>Always if present</td><tr>


<th colspan=2>BELARUS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>BELARUS Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BELGIUM Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Place of birth</td> <td>Always if present</td><tr>

<th colspan=2>BELGIUM ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Place of birth</td> <td>Always if present</td><tr>

<th colspan=2>BELGIUM ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>BELGIUM Minors ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Place of birth</td> <td>Always if present</td><tr>

<th colspan=2>BELGIUM Minors ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>BELGIUM Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BELGIUM Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>BELGIUM Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>BELGIUM Resident ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Residential status</td> <td>Always if present</td><tr>

<th colspan=2>BELGIUM Resident ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>


<th colspan=2>BELGIUM Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BERMUDA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>BOLIVIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>BOLIVIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<th colspan=2>BOLIVIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>


<th colspan=2>BOLIVIA Minors ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>BOLIVIA Minors ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>BOSNIA AND HERZEGOVINA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>BOSNIA AND HERZEGOVINA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>

<th colspan=2>BOSNIA AND HERZEGOVINA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>


<th colspan=2>BOSNIA AND HERZEGOVINA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BOTSWANA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>BOTSWANA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BRAZIL Consular Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BRAZIL Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>BRAZIL Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>


<th colspan=2>BRAZIL ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Empty document side</td> <td></td><tr>


<th colspan=2>BRAZIL ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>BRAZIL Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BRAZIL RIO DE JANEIRO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>BRAZIL RIO DE JANEIRO ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>BRAZIL RIO GRANDE DO SUL ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>BRAZIL RIO GRANDE DO SUL ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>BRAZIL SAO PAOLO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>BRAZIL SAO PAOLO ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>BRUNEI ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BRUNEI ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Race</td> <td>Always</td><tr>


<th colspan=2>BRUNEI Military ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>BRUNEI Military ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>


<th colspan=2>BRUNEI Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BRUNEI Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Race</td> <td>Always</td><tr>


<th colspan=2>BRUNEI Temporary Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BRUNEI Temporary Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Employer</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>


<th colspan=2>BULGARIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>BULGARIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BULGARIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Last name</td> <td>Always if present</td><tr>


<th colspan=2>BULGARIA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BURKINA FASO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BURKINA FASO ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>


<th colspan=2>CAMBODIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>Conditions</td> <td>Always if present</td><tr>

<th colspan=2>CAMBODIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>CAMBODIA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CAMEROON ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>

<th colspan=2>CAMEROON ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>CANADA Citizenship Certificate - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA Citizenship Certificate - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>CANADA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>CANADA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>CANADA Social Security Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>CANADA Tribal ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA Tribal ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>


<th colspan=2>CANADA Weapon Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA ALBERTA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Always if present</td><tr>

<th colspan=2>CANADA ALBERTA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA ALBERTA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA ALBERTA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA Driver License/Public Services Card (Combined) - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA Driver License/Public Services Card (Combined) - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA Minors Public Services Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA Minors Public Services Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA Public Services Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA BRITISH COLUMBIA Public Services Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA MANITOBA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>CANADA MANITOBA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA MANITOBA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>CANADA MANITOBA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA NEW BRUNSWICK Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>CANADA NEW BRUNSWICK Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA NEWFOUNDLAND AND LABRADOR Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>CANADA NEWFOUNDLAND AND LABRADOR Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA NOVA SCOTIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>CANADA NOVA SCOTIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA NOVA SCOTIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>CANADA NOVA SCOTIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA ONTARIO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>CANADA ONTARIO Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA ONTARIO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA ONTARIO ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA QUEBEC Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>

<th colspan=2>CANADA QUEBEC Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA SASKATCHEWAN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>CANADA SASKATCHEWAN Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA SASKATCHEWAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>CANADA SASKATCHEWAN ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA YUKON Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>CANADA YUKON Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CAYMAN ISLANDS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Licence type</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>CHILE Alien ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CHILE Alien ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>


<th colspan=2>CHILE Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>CHILE ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>

<th colspan=2>CHILE ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<tr> <td>Profession</td> <td>Always if present</td><tr>


<th colspan=2>CHILE Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CHINA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>CHINA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>


<th colspan=2>CHINA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>

<th colspan=2>COLOMBIA Alien ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>COLOMBIA Alien ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>COLOMBIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>COLOMBIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<tr> <td>Vehicle class</td> <td>Always if present</td><tr>


<th colspan=2>COLOMBIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Place of birth</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>COLOMBIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>COLOMBIA Minors ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>COLOMBIA Minors ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>COLOMBIA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>COSTA RICA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>COSTA RICA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>COSTA RICA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>CROATIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>CROATIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<th colspan=2>CROATIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Additional personal id number</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>CROATIA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>CROATIA Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>CROATIA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CUBA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CUBA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>CUBA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>CYPRUS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>CYPRUS ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Place of birth</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>CYPRUS ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>CYPRUS Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CYPRUS Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>

<th colspan=2>CYPRUS Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>


<th colspan=2>CZECHIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<th colspan=2>CZECHIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>MRZ</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Place of birth</td> <td>Always if present</td><tr>

<th colspan=2>CZECHIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>

<tr> <td>Marital status</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>


<th colspan=2>CZECHIA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>CZECHIA Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>CZECHIA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>DEMOCRATIC REPUBLIC OF THE CONGO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>DEMOCRATIC REPUBLIC OF THE CONGO Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>DENMARK Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>DENMARK Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>DENMARK Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>DENMARK Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>DOMINICAN REPUBLIC Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>DOMINICAN REPUBLIC Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>DOMINICAN REPUBLIC ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>DOMINICAN REPUBLIC ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>DOMINICAN REPUBLIC Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>ECUADOR Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>ECUADOR ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Document number</td> <td>Always if present</td><tr>
<tr> <td>Marital status</td> <td>Always if present</td><tr>

<th colspan=2>ECUADOR ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Additional personal id number</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>

<tr> <td>Marital status</td> <td>Always if present</td><tr>

<tr> <td>Profession</td> <td>Always if present</td><tr>


<th colspan=2>EGYPT Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>EGYPT Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>EGYPT ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>EGYPT ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Additional name information</td> <td>Always if present</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>Marital status</td> <td>Always if present</td><tr>

<tr> <td>Profession</td> <td>Always if present</td><tr>


<th colspan=2>EGYPT Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always if present</td><tr>

<th colspan=2>EL SALVADOR Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>EL SALVADOR Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>EL SALVADOR ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>EL SALVADOR ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>


<th colspan=2>ESTONIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>ESTONIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<th colspan=2>ESTONIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>


<th colspan=2>ESTONIA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>ESTONIA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>ESTONIA Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>ESWATINI Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>FINLAND Alien ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>FINLAND Alien ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>FINLAND Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>FINLAND ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>FINLAND ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>FINLAND Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>FINLAND Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>FINLAND Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>FRANCE Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>FRANCE ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>MRZ</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>

<th colspan=2>FRANCE ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>


<th colspan=2>FRANCE Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>FRANCE Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Document optional additional number</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>FRANCE Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>GEORGIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>GEORGIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>GEORGIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>GEORGIA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>GERMANY Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>GERMANY ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>MRZ</td> <td>Always if present</td><tr>

<th colspan=2>GERMANY ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>


<th colspan=2>GERMANY Minors Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>GERMANY Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>GERMANY Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>GERMANY Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>GERMANY Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>GHANA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>GHANA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>GHANA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>GHANA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>GREECE Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>GREECE ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>GREECE ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>GREECE Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>GREECE Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>GREECE Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>GUATEMALA Consular ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>GUATEMALA Consular ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>GUATEMALA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<th colspan=2>GUATEMALA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>


<th colspan=2>GUATEMALA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>

<th colspan=2>GUATEMALA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>


<th colspan=2>GUATEMALA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>HAITI Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>HAITI ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>HAITI ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>HAITI Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>HONDURAS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>HONDURAS Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>


<th colspan=2>HONDURAS ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Place of birth</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>HONDURAS ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Full name</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>HONDURAS Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>HONG KONG ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Residential status</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Additional name information</td> <td>Always if present</td><tr>

<th colspan=2>HONG KONG Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>HUNGARY Address Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Additional name information</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Additional address information</td> <td>Always if present</td><tr>

<th colspan=2>HUNGARY Address Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>HUNGARY Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>HUNGARY ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>HUNGARY ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Additional name information</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>


<th colspan=2>HUNGARY Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>HUNGARY Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>HUNGARY Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>ICELAND Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>ICELAND Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>INDIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<th colspan=2>INDIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>


<th colspan=2>INDIA PAN Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<th colspan=2>INDIA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>INDIA Voter ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>INDIA GUJARAT Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>INDIA KARNATAKA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>INDIA KERALA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>INDIA KERALA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>INDIA MADHYA PRADESH Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>INDIA MAHARASHTRA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>INDIA PUNJAB Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>INDIA TAMIL NADU Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>

<th colspan=2>INDIA TAMIL NADU Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>


<th colspan=2>INDONESIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<th colspan=2>INDONESIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Additional address information</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Religion</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>INDONESIA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document optional additional number</td> <td>Always if present</td><tr>

<th colspan=2>IRAN Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>IRAQ ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>IRAQ ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>IRAQ Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>IRELAND Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>IRELAND Passport Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>IRELAND Passport Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>IRELAND Public Services Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>IRELAND Public Services Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>IRELAND Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>IRELAND Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>IRELAND Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>ISRAEL Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>ISRAEL ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>ISRAEL ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>ISRAEL Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>ITALY Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<th colspan=2>ITALY ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>MRZ</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>

<th colspan=2>ITALY ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>


<th colspan=2>ITALY Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>ITALY Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>ITALY Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>IVORY COAST Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>IVORY COAST ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>

<th colspan=2>IVORY COAST ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>JAMAICA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>JAMAICA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>JAPAN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always if present</td><tr>

<th colspan=2>JAPAN My Number Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>

<th colspan=2>JAPAN Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>JAPAN Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Jap nationality</td> <td>Always</td><tr>

<tr> <td>Jap sex or gender</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>JORDAN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>JORDAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>JORDAN ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>JORDAN Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>KAZAKHSTAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>KAZAKHSTAN ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>KENYA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>KENYA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>KENYA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>KOSOVO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>KOSOVO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<th colspan=2>KOSOVO ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>


<th colspan=2>KOSOVO Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>KUWAIT Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Profession</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>KUWAIT Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Profession</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>KUWAIT ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>KUWAIT ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>KUWAIT Resident ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document optional additional number</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>

<th colspan=2>KUWAIT Resident ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>KYRGYZSTAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>KYRGYZSTAN ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>LATVIA Alien ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>LATVIA Alien ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>LATVIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>LATVIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>LATVIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>LATVIA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>LATVIA Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>LATVIA Polycarbonate Alien Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<th colspan=2>LATVIA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>LEBANON ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>LEBANON ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>


<th colspan=2>LIBYA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>LIECHTENSTEIN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>LIECHTENSTEIN ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>LITHUANIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>LITHUANIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<th colspan=2>LITHUANIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>LITHUANIA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>LITHUANIA Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>LITHUANIA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>LUXEMBOURG Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>

<th colspan=2>LUXEMBOURG ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>

<th colspan=2>LUXEMBOURG ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>LUXEMBOURG Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>LUXEMBOURG Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>LUXEMBOURG Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MALAYSIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MALAYSIA MyKAS - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Religion</td> <td>Always if present</td><tr>

<th colspan=2>MALAYSIA MyKAS - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document optional additional number</td> <td>Always</td><tr>


<th colspan=2>MALAYSIA MyKad - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Religion</td> <td>Always if present</td><tr>

<th colspan=2>MALAYSIA MyKad - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document optional additional number</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>


<th colspan=2>MALAYSIA MyKid - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Place of birth</td> <td>Always if present</td><tr>
<tr> <td>Religion</td> <td>Always if present</td><tr>

<th colspan=2>MALAYSIA MyKid - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>

<tr> <td>Document optional additional number</td> <td>Always if present</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>


<th colspan=2>MALAYSIA MyPR - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Religion</td> <td>Always if present</td><tr>

<th colspan=2>MALAYSIA MyPR - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document optional additional number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>


<th colspan=2>MALAYSIA MyPolis - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>MALAYSIA MyPolis - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>


<th colspan=2>MALAYSIA MyTentera - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Religion</td> <td>Always if present</td><tr>

<th colspan=2>MALAYSIA MyTentera - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document optional additional number</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>


<th colspan=2>MALAYSIA Refugee ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MALAYSIA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MALAYSIA i-Kad - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Employer</td> <td>Always if present</td><tr>
<tr> <td>Profession</td> <td>Always if present</td><tr>

<th colspan=2>MALDIVES ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MALDIVES ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>


<th colspan=2>MALTA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MALTA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>MALTA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MALTA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>MALTA Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>MAURITIUS ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MAURITIUS ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>MEXICO Consular ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO Consular ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO Professional DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO Professional ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Profession</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO Professional ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>

<tr> <td>Full name</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>MEXICO Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO Voter ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document optional additional number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Fathers name</td> <td>Always if present</td><tr>
<tr> <td>Mothers name</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO Voter ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO AGUASCALIENTES Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO AGUASCALIENTES Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>


<th colspan=2>MEXICO BAJA CALIFORNIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO BAJA CALIFORNIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO BAJA CALIFORNIA SUR Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO BAJA CALIFORNIA SUR Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MEXICO CAMPECHE Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO CAMPECHE Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO CHIAPAS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO CHIAPAS Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MEXICO CHIHUAHUA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO CHIHUAHUA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO CIUDAD DE MEXICO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO COAHUILA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO COAHUILA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO COLIMA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO COLIMA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO DURANGO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO GUANAJUATO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO GUANAJUATO Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO GUERRERO-COCULA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Empty document side</td> <td></td><tr>


<th colspan=2>MEXICO GUERRERO-COCULA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>

<th colspan=2>MEXICO GUERRERO-JUCHITAN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO GUERRERO-JUCHITAN Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>


<th colspan=2>MEXICO HIDALGO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO HIDALGO Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO JALISCO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO MEXICO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO MEXICO Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO MICHOACAN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO MICHOACAN Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO MORELOS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO NAYARIT Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO NAYARIT Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO NUEVO LEON Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO NUEVO LEON Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO OAXACA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO OAXACA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO PUEBLA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO PUEBLA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO QUINTANA ROO-COZUMEL Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO QUINTANA ROO-COZUMEL Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MEXICO QUINTANA ROO-SOLIDARIDAD Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO QUINTANA ROO-SOLIDARIDAD Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO SAN LUIS POTOSI Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO SINALOA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO SONORA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>MEXICO SONORA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MEXICO TABASCO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MEXICO TABASCO Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>


<th colspan=2>MEXICO TAMAULIPAS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO TAMAULIPAS Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO TLAXCALA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO TLAXCALA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>


<th colspan=2>MEXICO VERACRUZ Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO VERACRUZ Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Vehicle class</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO YUCATAN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>MEXICO YUCATAN Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>


<th colspan=2>MEXICO ZACATECAS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>MEXICO ZACATECAS Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>MOLDOVA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MOLDOVA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>


<th colspan=2>MOLDOVA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MONTENEGRO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MONTENEGRO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MONTENEGRO ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>MONTENEGRO Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MOROCCO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<th colspan=2>MOROCCO Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>


<th colspan=2>MOROCCO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>MOROCCO ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>


<th colspan=2>MOROCCO Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<th colspan=2>MOZAMBIQUE Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MOZAMBIQUE ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>MOZAMBIQUE ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>


<th colspan=2>MYANMAR Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>MYANMAR Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>NEPAL Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>NETHERLANDS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>MRZ</td> <td>Always if present</td><tr>

<th colspan=2>NETHERLANDS Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>


<th colspan=2>NETHERLANDS ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<th colspan=2>NETHERLANDS ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>NETHERLANDS Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>NETHERLANDS Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>NETHERLANDS Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>NEW ZEALAND Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>NEW ZEALAND Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>NICARAGUA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>NICARAGUA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>NIGERIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>NIGERIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>NIGERIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document number</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Profession</td> <td>Always if present</td><tr>

<th colspan=2>NIGERIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>NIGERIA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>NIGERIA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>NIGERIA Voter ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>NIGERIA Voter ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>NORTH MACEDONIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>NORTH MACEDONIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>NORTH MACEDONIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>NORTH MACEDONIA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>NORWAY Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>

<th colspan=2>NORWAY ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>NORWAY ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>NORWAY Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>NORWAY Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>NORWAY Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>OMAN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>OMAN Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>


<th colspan=2>OMAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>OMAN ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>OMAN Resident ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>OMAN Resident ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>PAKISTAN Consular ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Additional address information 2</td> <td>Always</td><tr>

<tr> <td>Additional name information</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document number</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>PAKISTAN Consular ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>PAKISTAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Additional address information 2</td> <td>Always if present</td><tr>
<tr> <td>Additional name information</td> <td>Always if present</td><tr>
<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>PAKISTAN ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>


<th colspan=2>PAKISTAN Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>PAKISTAN PUNJAB Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>PANAMA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>PANAMA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PANAMA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PANAMA Temporary Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>PANAMA Temporary Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>


<th colspan=2>PARAGUAY Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>PARAGUAY Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>


<th colspan=2>PARAGUAY ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PARAGUAY ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>PERU Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>PERU Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>


<th colspan=2>PERU ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Document number</td> <td>Always if present</td><tr>
<tr> <td>Document optional additional number</td> <td>Always if present</td><tr>
<tr> <td>MRZ</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Place of birth</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>PERU ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>


<th colspan=2>PERU Minors ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PERU Minors ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>


<th colspan=2>PERU Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>PHILIPPINES Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Always if present</td><tr>

<th colspan=2>PHILIPPINES ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>PHILIPPINES ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PHILIPPINES Multipurpose ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PHILIPPINES Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PHILIPPINES Professional ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<th colspan=2>PHILIPPINES Social Security Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<th colspan=2>PHILIPPINES Tax ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>PHILIPPINES Voter ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>POLAND Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<th colspan=2>POLAND ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Document number</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>

<th colspan=2>POLAND ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>POLAND Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>POLAND Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>POLAND Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>POLAND Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PORTUGAL Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<th colspan=2>PORTUGAL ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PORTUGAL ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>PORTUGAL Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PORTUGAL Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>PORTUGAL Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document optional additional number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>PUERTO RICO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>PUERTO RICO Voter ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>QATAR Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>QATAR ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>QATAR Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>QATAR Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>QATAR Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>

<th colspan=2>ROMANIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>ROMANIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Fathers name</td> <td>Always if present</td><tr>
<tr> <td>Mothers name</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>

<th colspan=2>ROMANIA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>RUSSIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>RUSSIA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>RWANDA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SAINT LUCIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SAINT LUCIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>SAUDI ARABIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<th colspan=2>SAUDI ARABIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>

<th colspan=2>SAUDI ARABIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>SAUDI ARABIA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SAUDI ARABIA Resident ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>SENEGAL ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<th colspan=2>SENEGAL ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>SERBIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>SERBIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>SERBIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>


<th colspan=2>SERBIA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<th colspan=2>SINGAPORE Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE Employment Pass - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Employer</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Profession</td> <td>Always if present</td><tr>

<th colspan=2>SINGAPORE Fin Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Race</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE Resident ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Race</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE Resident ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE S Pass - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Employer</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE S Pass - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE Work Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Employer</td> <td>Always if present</td><tr>

<th colspan=2>SINGAPORE Work Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SLOVAKIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>MRZ</td> <td>Always if present</td><tr>

<th colspan=2>SLOVAKIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SLOVAKIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>SLOVAKIA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>SLOVAKIA Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>SLOVAKIA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SLOVENIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>SLOVENIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document number</td> <td>Always if present</td><tr>
<tr> <td>Personal ID number</td> <td>Always if present</td><tr>
<tr> <td>Place of birth</td> <td>Always if present</td><tr>

<th colspan=2>SLOVENIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>SLOVENIA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<th colspan=2>SLOVENIA Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>


<th colspan=2>SLOVENIA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SOUTH AFRICA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>SOUTH AFRICA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>SOUTH AFRICA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>SOUTH AFRICA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SOUTH KOREA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>

<th colspan=2>SOUTH KOREA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>SOUTH KOREA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SPAIN Alien ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SPAIN Alien ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>SPAIN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>SPAIN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<th colspan=2>SPAIN ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>SPAIN Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<th colspan=2>SPAIN Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>
<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document optional additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>SPAIN Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>SRI LANKA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>SRI LANKA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>SRI LANKA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>


<th colspan=2>SRI LANKA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always if present</td><tr>

<th colspan=2>SUDAN Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SWEDEN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>SWEDEN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<th colspan=2>SWEDEN ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>


<th colspan=2>SWEDEN Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>SWEDEN Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>SWEDEN Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<th colspan=2>SWEDEN Social Security Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<th colspan=2>SWITZERLAND Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>SWITZERLAND ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>SWITZERLAND ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SWITZERLAND Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SWITZERLAND Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Document additional number</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Issuing authority</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>SWITZERLAND Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Document optional additional number</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Nationality</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>SYRIA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>TAIWAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>TAIWAN Temporary Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>TAJIKISTAN Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>TANZANIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>TANZANIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>TANZANIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>TANZANIA Voter ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>THAILAND Alien ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>THAILAND Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>THAILAND Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>


<th colspan=2>THAILAND ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>THAILAND ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>


<th colspan=2>THAILAND Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>TOGO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>TOGO ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>TRINIDAD AND TOBAGO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>TRINIDAD AND TOBAGO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>TRINIDAD AND TOBAGO ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<tr> <td>Document optional additional number</td> <td>Always if present</td><tr>


<th colspan=2>TUNISIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>

<th colspan=2>TUNISIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>TUNISIA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>TURKEY Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>TURKEY ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>TURKEY ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>TURKEY Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>TURKEY Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<th colspan=2>TURKEY Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>


<th colspan=2>TURKEY Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>UAE Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>UAE Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>


<th colspan=2>UAE ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>UAE ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>UAE Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>UAE Resident ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>UAE Resident ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Additional name information</td> <td>Always if present</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>Employer</td> <td>Always if present</td><tr>

<tr> <td>Issuing authority</td> <td>Always if present</td><tr>

<tr> <td>Profession</td> <td>Always if present</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>


<th colspan=2>UGANDA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>UGANDA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>UGANDA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>UK Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>UK Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>UK Proof Of Age Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>UK Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>UK Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>UK Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>UKRAINE Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<th colspan=2>UKRAINE ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>UKRAINE ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>


<th colspan=2>UKRAINE Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>UKRAINE Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>UKRAINE Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>UKRAINE Temporary Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>UKRAINE Temporary Residence Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>URUGUAY ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always if present</td><tr>
<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Nationality</td> <td>Always if present</td><tr>
<tr> <td>Place of birth</td> <td>Always if present</td><tr>

<th colspan=2>URUGUAY ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always if present</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<tr> <td>Document additional number</td> <td>Always if present</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>

<tr> <td>Place of birth</td> <td>Always if present</td><tr>


<th colspan=2>USA Border Crossing Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA Border Crossing Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Pending</td><tr>

<th colspan=2>USA Global Entry Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA Global Entry Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>USA Green Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA Green Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>USA Military ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Employer</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Additional name information</td> <td>Always if present</td><tr>

<th colspan=2>USA Military ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document optional additional number</td> <td>Always if present</td><tr>


<th colspan=2>USA Nexus Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA Nexus Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>USA Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA Passport Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA Passport Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>USA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA Social Security Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>

<th colspan=2>USA Veteran ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always if present</td><tr>

<th colspan=2>USA Work Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA Work Permit - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>USA ALABAMA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA ALABAMA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ALABAMA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA ALABAMA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ALASKA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA ALASKA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ALASKA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>USA ALASKA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ARIZONA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA ARIZONA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ARIZONA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>USA ARIZONA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ARKANSAS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>USA ARKANSAS Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ARKANSAS ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA ARKANSAS ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA CALIFORNIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>

<th colspan=2>USA CALIFORNIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA CALIFORNIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA CALIFORNIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA COLORADO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA COLORADO Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA COLORADO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA COLORADO ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA CONNECTICUT Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA CONNECTICUT Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA CONNECTICUT ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA CONNECTICUT ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA DELAWARE Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA DELAWARE Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA DISTRICT OF COLUMBIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA DISTRICT OF COLUMBIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA DISTRICT OF COLUMBIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA DISTRICT OF COLUMBIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA FLORIDA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA FLORIDA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA FLORIDA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA FLORIDA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA GEORGIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA GEORGIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA GEORGIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>USA GEORGIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA HAWAII Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA HAWAII Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA HAWAII ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA HAWAII ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA IDAHO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>USA IDAHO Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA IDAHO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA IDAHO ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ILLINOIS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA ILLINOIS Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ILLINOIS ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>USA ILLINOIS ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA INDIANA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>USA INDIANA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA INDIANA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>USA INDIANA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA IOWA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA IOWA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA IOWA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA IOWA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA KANSAS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA KANSAS Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA KANSAS ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA KANSAS ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA KENTUCKY Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA KENTUCKY Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA KENTUCKY ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA KENTUCKY ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA LOUISIANA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA LOUISIANA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MAINE Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA MAINE Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MAINE ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA MAINE ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MARYLAND Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA MARYLAND Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MARYLAND ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA MARYLAND ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MASSACHUSETTS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA MASSACHUSETTS Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MASSACHUSETTS ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA MASSACHUSETTS ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MICHIGAN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA MICHIGAN Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MICHIGAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA MICHIGAN ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MINNESOTA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>USA MINNESOTA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MINNESOTA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>USA MINNESOTA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MISSISSIPPI Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA MISSISSIPPI Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MISSISSIPPI ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>USA MISSISSIPPI ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MISSOURI Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Race</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>USA MISSOURI Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MISSOURI ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA MISSOURI ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MONTANA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA MONTANA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MONTANA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA MONTANA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEBRASKA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>USA NEBRASKA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEBRASKA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NEBRASKA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEVADA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA NEVADA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEVADA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NEVADA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW HAMPSHIRE Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always if present</td><tr>
<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>USA NEW HAMPSHIRE Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW HAMPSHIRE ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NEW HAMPSHIRE ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW JERSEY Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA NEW JERSEY Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW JERSEY ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA NEW JERSEY ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW MEXICO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA NEW MEXICO Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW MEXICO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA NEW MEXICO ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW YORK Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA NEW YORK Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW YORK ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA NEW YORK ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW YORK CITY ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>USA NEW YORK CITY ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NORTH CAROLINA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>USA NORTH CAROLINA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NORTH CAROLINA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>USA NORTH CAROLINA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NORTH DAKOTA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA NORTH DAKOTA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NORTH DAKOTA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NORTH DAKOTA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA OHIO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>

<th colspan=2>USA OHIO Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA OHIO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA OHIO ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA OKLAHOMA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA OKLAHOMA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA OKLAHOMA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA OKLAHOMA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA OREGON Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>USA OREGON Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA OREGON ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>USA OREGON ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA PENNSYLVANIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA PENNSYLVANIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA PENNSYLVANIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>USA PENNSYLVANIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA RHODE ISLAND Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>
<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>USA RHODE ISLAND Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA RHODE ISLAND ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA RHODE ISLAND ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA SOUTH CAROLINA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>
<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>USA SOUTH CAROLINA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA SOUTH CAROLINA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Full name</td> <td>Always if present</td><tr>
<tr> <td>Last name</td> <td>Always if present</td><tr>

<th colspan=2>USA SOUTH CAROLINA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA SOUTH DAKOTA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA SOUTH DAKOTA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA SOUTH DAKOTA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA SOUTH DAKOTA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA TENNESSEE Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA TENNESSEE Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA TENNESSEE ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA TENNESSEE ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA TEXAS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA TEXAS Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA TEXAS ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA TEXAS ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA TEXAS Weapon Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA UTAH Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always if present</td><tr>

<th colspan=2>USA UTAH Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA UTAH ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA UTAH ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA VERMONT Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA VERMONT Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA VIRGINIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA VIRGINIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA VIRGINIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA VIRGINIA ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA WASHINGTON Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always if present</td><tr>
<tr> <td>Vehicle class</td> <td>Always if present</td><tr>

<th colspan=2>USA WASHINGTON Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA WASHINGTON ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA WASHINGTON ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA WEST VIRGINIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA WEST VIRGINIA Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA WISCONSIN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA WISCONSIN Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA WISCONSIN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA WISCONSIN ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA WYOMING Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA WYOMING Driving Licence - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA WYOMING ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA WYOMING ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>UZBEKISTAN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>UZBEKISTAN Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>VENEZUELA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always if present</td><tr>

<th colspan=2>VENEZUELA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>


<th colspan=2>VENEZUELA Polycarbonate Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always if present</td><tr>

<th colspan=2>VIETNAM Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>VIETNAM ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>VIETNAM ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always if present</td><tr>


<th colspan=2>ZIMBABWE ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>ZIMBABWE ID Card - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>ZIMBABWE Paper Passport - Bio-data page </th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always if present</td><tr>

<th colspan=2>AUSTRALIA Health Insurance Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>CANADA ONTARIO Health Insurance Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always if present</td><tr>

<th colspan=2>CANADA QUEBEC Health Insurance Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CROATIA Health Insurance Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Additional personal id number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>



