
# BlinkID Result Fields


## Table of contents

* [MRZ Fields](#mrz-fields)
* [Anonymised Fields](#anonymised-fields)
* [AAMVA Barcode Fields](#aamva-barcode-fields)
* [All Fields](#all-fields)
<br><br><br>


<h2>MRZ Fields</h2>
Other than documents listed here, BlinkID also scans the <strong>Machine Readable Zone (MRZ)</strong> on standard (ISO/IEC 7501 compliant) 
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
<li>Nationality name</li>
<li>Primary ID (last name)</li>
<li>Secondary ID (first name)</li>
<li>Date of birth</li>
<li>Date of expiry</li>
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
<th colspan=1>Country and document type</th><th>Anonymised fields</th></tr>
<tr><td>GERMANY Identity Card</td><td>Anonymized line, Document additional number, Document number, MRZ (Document number)</td></tr>
<tr><td>GERMANY Minors Passport</td><td>Document number, MRZ (Document number)</td></tr>
<tr><td>GERMANY Paper Passport</td><td>Document number, MRZ (Document number)</td></tr>
<tr><td>GERMANY Polycarbonate Passport</td><td>Document number, MRZ (Document number)</td></tr>
<tr><td>HONG KONG Identity Card</td><td>Anonymized line, Document number</td></tr>
<tr><td>HONG KONG Polycarbonate Passport</td><td>Anonymized line, Anonymized vertical line, Document number, MRZ (Document number, Opt1)</td></tr>
<tr><td>MALAYSIA MyKad</td><td>Religion</td></tr>
<tr><td>MALAYSIA MyKAS</td><td>Religion</td></tr>
<tr><td>MALAYSIA MyKid</td><td>Religion</td></tr>
<tr><td>MALAYSIA MyPR</td><td>Religion</td></tr>
<tr><td>MALAYSIA MyTentera</td><td>Religion</td></tr>
<tr><td>NETHERLANDS Driver's License</td><td>Personal ID number</td></tr>
<tr><td>NETHERLANDS Identity Card</td><td>MRZ (Opt1), Personal ID number</td></tr>
<tr><td>NETHERLANDS Polycarbonate Passport</td><td>MRZ (Opt1)</td></tr>
<tr><td>SINGAPORE Driver's License</td><td>Anonymized line, Document number</td></tr>
<tr><td>SINGAPORE Employment Pass</td><td>Anonymized line, Personal ID number</td></tr>
<tr><td>SINGAPORE Fin Card</td><td>Anonymized line, Document number</td></tr>
<tr><td>SINGAPORE Identity Card</td><td>Anonymized line, Document number</td></tr>
<tr><td>SINGAPORE Resident ID</td><td>Anonymized line, Document number</td></tr>
<tr><td>SINGAPORE Polycarbonate Passport</td><td>Anonymized line, Document number, MRZ (Document number, Opt1), Personal ID number</td></tr>
<tr><td>SINGAPORE S Pass</td><td>Anonymized line, Document number, Personal ID number</td></tr>
<tr><td>SINGAPORE Work Permit</td><td>Anonymized line, Document number, Personal ID number</td></tr>
<tr><td>SOUTH KOREA Driver's License</td><td>Personal ID number</td></tr>
<tr><td>SOUTH KOREA Identity Card</td><td>Document number</td></tr>
<tr><td>SOUTH KOREA Paper Passport</td><td>MRZ (Opt1), Personal ID number</td></tr>
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
The tables below represent scanning results for each document in each country supported in BlinkID v6. The fields marked as "Mandatory" are mandatory on all document versions and 
will always be a part of the result set. The ones marked as "Optional" will be returned only if they exist on the specific document being scanned. 
For US documents, all information concerns both horizontal and vertical supported documents.

Currently, in BlinkID v6 we support the extraction of fields in Latin, Cyrillic, and Arabic scipts. Information about supported scripts for each document is listed 
in the tables in [SupportedDocuments.md](SupportedDocuments.md) file in this repository.
<br>
<br>

<table>
<tr><th colspan=2>UAE Esaad Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>

<tr><th colspan=2>UAE Esaad Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>

<tr><th colspan=2>AFGHANISTAN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Empty document side</td><td></td></tr>


<tr><th colspan=2>AFGHANISTAN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>AFGHANISTAN Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>ALBANIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>

<tr><th colspan=2>ALBANIA Driver Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>

<tr><th colspan=2>ALBANIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>ALBANIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>ALBANIA Professional DL - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>ALBANIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>ALGERIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>ALGERIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>ALGERIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>ALGERIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>ALGERIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>ANDORRA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>ANDORRA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>ANTIGUA AND BARBUDA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>ARGENTINA Alien ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document optional additional number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>

<tr><th colspan=2>ARGENTINA Alien ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>ARGENTINA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>ARGENTINA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Document optional additional number</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>ARGENTINA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Document optional additional number</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>ARGENTINA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>ARMENIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>ARMENIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>ARMENIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>ARMENIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA Asic Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>

<tr><th colspan=2>AUSTRALIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>AUSTRALIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>AUSTRALIA AUSTRALIAN CAPITAL TERRITORY Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Conditions</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA AUSTRALIAN CAPITAL TERRITORY Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA NEW SOUTH WALES Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Conditions</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA NEW SOUTH WALES Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA NORTHERN TERRITORY Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Conditions</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA NORTHERN TERRITORY Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA NORTHERN TERRITORY Proof Of Age Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>

<tr><th colspan=2>AUSTRALIA NORTHERN TERRITORY Proof Of Age Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA QUEENSLAND Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Class effective date</td><td>Mandatory</td></tr>
<tr><td>Class expiry date</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Licence type</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Conditions</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA QUEENSLAND Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Additional class effective date</td><td>Optional</td></tr>
<tr><td>Additional conditions</td><td>Optional</td></tr>
<tr><td>Additional licence type</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA QUEENSLAND Proof Of Age Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA QUEENSLAND Proof Of Age Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA SOUTH AUSTRALIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Conditions</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA SOUTH AUSTRALIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA SOUTH AUSTRALIA Proof Of Age Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>

<tr><th colspan=2>AUSTRALIA TASMANIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Class expiry date</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Licence type</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>AUSTRALIA TASMANIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>

<tr><th colspan=2>AUSTRALIA TASMANIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>

<tr><th colspan=2>AUSTRALIA TASMANIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>

<tr><th colspan=2>AUSTRALIA VICTORIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Conditions</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA VICTORIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA VICTORIA Proof Of Age Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA WESTERN AUSTRALIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA WESTERN AUSTRALIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA WESTERN AUSTRALIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA WESTERN AUSTRALIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRIA Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRIA Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>AZERBAIJAN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>AZERBAIJAN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>AZERBAIJAN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Marital status</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>AZERBAIJAN Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BAHAMAS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BAHAMAS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>

<tr><th colspan=2>BAHAMAS Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BAHAMAS Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BAHAMAS Temporary Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BAHAMAS Temporary Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>BAHAMAS Work Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BAHAMAS Work Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Employer</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>

<tr><th colspan=2>BAHRAIN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BAHRAIN Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>

<tr><th colspan=2>BAHRAIN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>

<tr><th colspan=2>BAHRAIN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>

<tr><th colspan=2>BAHRAIN Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BANGLADESH Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>

<tr><th colspan=2>BANGLADESH Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>BANGLADESH Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>

<tr><th colspan=2>BANGLADESH Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BANGLADESH Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>

<tr><th colspan=2>BANGLADESH Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>

<tr><th colspan=2>BARBADOS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>

<tr><th colspan=2>BARBADOS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>BARBADOS Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>BELARUS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>BELARUS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BELARUS Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BELARUS Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BELARUS Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BELARUS Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BELARUS Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BELGIUM Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>BELGIUM Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>BELGIUM Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>BELGIUM Minors ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>BELGIUM Minors ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>BELGIUM Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BELGIUM Provisional DL - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>BELGIUM Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>BELGIUM Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>BELGIUM Resident ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Residential status</td><td>Optional</td></tr>

<tr><th colspan=2>BELGIUM Resident ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>BELGIUM Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BELGIUM Special ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BENIN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>BENIN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>BERMUDA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>BOLIVIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>

<tr><th colspan=2>BOLIVIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>BOLIVIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>

<tr><th colspan=2>BOLIVIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Marital status</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>BOLIVIA Minors ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>

<tr><th colspan=2>BOLIVIA Minors ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Marital status</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>BOLIVIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BOSNIA AND HERZEGOVINA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>BOSNIA AND HERZEGOVINA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>BOSNIA AND HERZEGOVINA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>BOSNIA AND HERZEGOVINA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BOTSWANA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BOTSWANA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL Alien ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL Alien ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL Consular Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL ALAGOAS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL ALAGOAS Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL CEARA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL CEARA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL DISTRITO FEDERAL Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL DISTRITO FEDERAL Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL GOIAS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL GOIAS Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL MARANHAO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL MARANHAO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL MATO GROSSO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL MATO GROSSO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL MINAS GERAIS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL MINAS GERAIS Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL PARA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL PARA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL PARANA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL PARANA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL PERNAMBUCO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL PERNAMBUCO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL RIO DE JANEIRO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL RIO DE JANEIRO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL RIO GRANDE DO SUL Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL RIO GRANDE DO SUL Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL SANTA CATARINA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL SANTA CATARINA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL SAO PAOLO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL SAO PAOLO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>BRAZIL SERGIPE Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRAZIL SERGIPE Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRUNEI Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRUNEI Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Race</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRUNEI Military ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRUNEI Military ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>BRUNEI Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRUNEI Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Race</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRUNEI Temporary Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BRUNEI Temporary Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Employer</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>

<tr><th colspan=2>BULGARIA Alien ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BULGARIA Alien ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>BULGARIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>

<tr><th colspan=2>BULGARIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>BULGARIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>

<tr><th colspan=2>BULGARIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BULGARIA Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>

<tr><th colspan=2>BULGARIA Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BURKINA FASO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>BURKINA FASO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>

<tr><th colspan=2>CAMBODIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Conditions</td><td>Optional</td></tr>

<tr><th colspan=2>CAMBODIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>CAMBODIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CAMEROON Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>

<tr><th colspan=2>CAMEROON Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>CAMEROON Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>CAMEROON Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA Citizenship Certificate - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CANADA Citizenship Certificate - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>

<tr><th colspan=2>CANADA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CANADA Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>CANADA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA Social Security Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>

<tr><th colspan=2>CANADA Tribal ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CANADA Tribal ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA Weapon Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CANADA ALBERTA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Conditions</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA ALBERTA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA ALBERTA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CANADA ALBERTA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA BRITISH COLUMBIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA BRITISH COLUMBIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA BRITISH COLUMBIA Driver's License/Public Services Card (Combined) - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA BRITISH COLUMBIA Driver's License/Public Services Card (Combined) - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA BRITISH COLUMBIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA BRITISH COLUMBIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA BRITISH COLUMBIA Minors Public Services Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA BRITISH COLUMBIA Minors Public Services Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA BRITISH COLUMBIA Public Services Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA BRITISH COLUMBIA Public Services Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA MANITOBA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA MANITOBA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA MANITOBA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA MANITOBA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA NEW BRUNSWICK Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>CANADA NEW BRUNSWICK Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA NEW BRUNSWICK Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CANADA NEW BRUNSWICK Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA NEWFOUNDLAND AND LABRADOR Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>CANADA NEWFOUNDLAND AND LABRADOR Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA NOVA SCOTIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA NOVA SCOTIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA NOVA SCOTIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA NOVA SCOTIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA ONTARIO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA ONTARIO Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA ONTARIO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CANADA ONTARIO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA PRINCE EDWARD ISLAND Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA PRINCE EDWARD ISLAND Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA QUEBEC Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Conditions</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA QUEBEC Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA SASKATCHEWAN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA SASKATCHEWAN Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA SASKATCHEWAN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA SASKATCHEWAN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA YUKON Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA YUKON Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>CAYMAN ISLANDS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Licence type</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>CAYMAN ISLANDS Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CAYMAN ISLANDS Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CAYMAN ISLANDS Voter ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CHILE Alien ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CHILE Alien ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>

<tr><th colspan=2>CHILE Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>CHILE Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>

<tr><th colspan=2>CHILE Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>CHILE Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CHINA Exit Entry Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>CHINA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>

<tr><th colspan=2>CHINA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>

<tr><th colspan=2>CHINA Mainland Travel Permit Taiwan - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>CHINA Mainland Travel Permit Taiwan - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>CHINA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>COLOMBIA Alien ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>COLOMBIA Alien ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>COLOMBIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>COLOMBIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>COLOMBIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>COLOMBIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>COLOMBIA Minors ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>

<tr><th colspan=2>COLOMBIA Minors ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>COLOMBIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>COLOMBIA Temporary Protection Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>COLOMBIA Temporary Protection Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>COMOROS Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>COSTA RICA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>COSTA RICA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>

<tr><th colspan=2>COSTA RICA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>COSTA RICA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>COSTA RICA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CROATIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>CROATIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>CROATIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Additional personal id number</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>CROATIA Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>CROATIA Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>CROATIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CUBA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CUBA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>CUBA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>CYPRUS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>CYPRUS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>CYPRUS Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>CYPRUS Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CYPRUS Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>CYPRUS Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>CZECHIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>

<tr><th colspan=2>CZECHIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>CZECHIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Marital status</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>CZECHIA Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>CZECHIA Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>CZECHIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>DEMOCRATIC REPUBLIC OF THE CONGO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>DEMOCRATIC REPUBLIC OF THE CONGO Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>

<tr><th colspan=2>DEMOCRATIC REPUBLIC OF THE CONGO Voter ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>

<tr><th colspan=2>DENMARK Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>DENMARK Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>DENMARK Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>DENMARK Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>DOMINICAN REPUBLIC Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>DOMINICAN REPUBLIC Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>DOMINICAN REPUBLIC Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>DOMINICAN REPUBLIC Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>DOMINICAN REPUBLIC Non Voter ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>DOMINICAN REPUBLIC Non Voter ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>DOMINICAN REPUBLIC Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>ECUADOR Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>ECUADOR Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>ECUADOR Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Marital status</td><td>Optional</td></tr>

<tr><th colspan=2>ECUADOR Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Additional personal id number</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Marital status</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>ECUADOR Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>EGYPT Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>EGYPT Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>

<tr><th colspan=2>EGYPT Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>EGYPT Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Religion</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Additional name information</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Marital status</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>EGYPT Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>EL SALVADOR Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>

<tr><th colspan=2>EL SALVADOR Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>

<tr><th colspan=2>EL SALVADOR Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>EL SALVADOR Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Marital status</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>

<tr><th colspan=2>ESTONIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>ESTONIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>

<tr><th colspan=2>ESTONIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>ESTONIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>ESTONIA Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>ESTONIA Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>ESTONIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>ESWATINI Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>FINLAND Alien ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>FINLAND Alien ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>FINLAND Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>FINLAND Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>FINLAND Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>

<tr><th colspan=2>FINLAND Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>FINLAND Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>FINLAND Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>FRANCE Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>FRANCE Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>FRANCE Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>FRANCE Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>FRANCE Professional ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Employer</td><td>Optional</td></tr>

<tr><th colspan=2>FRANCE Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Residence permit type</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Document optional additional number</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Remarks</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>FRANCE Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Remarks</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>GAMBIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GAMBIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>

<tr><th colspan=2>GEORGIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>GEORGIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GEORGIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>GEORGIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GERMANY Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>GERMANY Driver Qualification Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>GERMANY eID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>

<tr><th colspan=2>GERMANY eID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>GERMANY Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>GERMANY Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>GERMANY Minors Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GERMANY Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GERMANY Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>GERMANY Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>GERMANY Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GHANA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>GHANA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GHANA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>GHANA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GIBRALTAR Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>GIBRALTAR Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GIBRALTAR Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>GIBRALTAR Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GIBRALTAR Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GREECE Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>GREECE Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>GREECE Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>GREECE Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GREECE Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>GREECE Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>GREECE Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GRENADA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>

<tr><th colspan=2>GUATEMALA Alien ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>GUATEMALA Alien ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Marital status</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>GUATEMALA Consular ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GUATEMALA Consular ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>GUATEMALA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>

<tr><th colspan=2>GUATEMALA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>

<tr><th colspan=2>GUATEMALA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>GUATEMALA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Marital status</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>GUATEMALA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GUINEA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GUINEA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>GUYANA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>GUYANA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>GUYANA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>

<tr><th colspan=2>GUYANA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>HAITI Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>HAITI Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>HAITI Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>HAITI Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>

<tr><th colspan=2>HONDURAS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>HONDURAS Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>HONDURAS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>HONDURAS Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>HONDURAS Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>HONDURAS Resident ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>HONDURAS Resident ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>

<tr><th colspan=2>HONG KONG Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Residential status</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Additional name information</td><td>Optional</td></tr>

<tr><th colspan=2>HONG KONG Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>

<tr><th colspan=2>HUNGARY Address Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Additional name information</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Additional address information</td><td>Optional</td></tr>

<tr><th colspan=2>HUNGARY Address Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>HUNGARY Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>HUNGARY Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>HUNGARY Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Additional name information</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>

<tr><th colspan=2>HUNGARY Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>HUNGARY Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>HUNGARY Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>ICELAND Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>ICELAND Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>INDIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>

<tr><th colspan=2>INDIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>

<tr><th colspan=2>INDIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>INDIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>

<tr><th colspan=2>INDIA PAN Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>

<tr><th colspan=2>INDIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>

<tr><th colspan=2>INDIA Paper Passport - Second data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Fathers name</td><td>Mandatory</td></tr>
<tr><td>Mothers name</td><td>Mandatory</td></tr>

<tr><th colspan=2>INDIA Voter ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>

<tr><th colspan=2>INDIA ANDHRA PRADESH Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>

<tr><th colspan=2>INDIA ANDHRA PRADESH Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>INDIA GUJARAT Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>INDIA GUJARAT Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>INDIA HARYANA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>INDIA KARNATAKA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>INDIA KERALA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>

<tr><th colspan=2>INDIA KERALA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>INDIA MADHYA PRADESH Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>INDIA MAHARASHTRA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>INDIA PUNJAB Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>INDIA TAMIL NADU Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>INDIA TAMIL NADU Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>

<tr><th colspan=2>INDONESIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>

<tr><th colspan=2>INDONESIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Additional address information</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Blood type</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Marital status</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Religion</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>INDONESIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document optional additional number</td><td>Optional</td></tr>

<tr><th colspan=2>INDONESIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>IRAN Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>IRAQ Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>IRAQ Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>IRAQ Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>

<tr><th colspan=2>IRAQ Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>IRELAND Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>IRELAND Passport Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>IRELAND Passport Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>IRELAND Public Services Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>

<tr><th colspan=2>IRELAND Public Services Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>

<tr><th colspan=2>IRELAND Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>IRELAND Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>IRELAND Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>IRELAND Polycarbonate Passport - Second data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>ISRAEL Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>ISRAEL Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>ISRAEL Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>

<tr><th colspan=2>ISRAEL Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>ITALY Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>ITALY Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document optional additional number</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>ITALY Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>ITALY Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>ITALY Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>ITALY Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>IVORY COAST Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>IVORY COAST Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>IVORY COAST Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>JAMAICA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>JAMAICA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>

<tr><th colspan=2>JAMAICA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>JAMAICA Voter ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>JAMAICA Voter ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>JAPAN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>

<tr><th colspan=2>JAPAN My Number Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>

<tr><th colspan=2>JAPAN Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>JAPAN Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Jap nationality</td><td>Mandatory</td></tr>
<tr><td>Jap sex or gender</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>JORDAN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>JORDAN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>JORDAN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Additional address information</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>JORDAN Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>KAZAKHSTAN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>KAZAKHSTAN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>KAZAKHSTAN Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>KENYA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>KENYA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>

<tr><th colspan=2>KENYA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>KOSOVO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>KOSOVO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>KOSOVO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>KOSOVO Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>KUWAIT Bidoon Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>KUWAIT Bidoon Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>

<tr><th colspan=2>KUWAIT Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>KUWAIT Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>KUWAIT Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>KUWAIT Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Additional address information</td><td>Optional</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>KUWAIT Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>KUWAIT Resident ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document optional additional number</td><td>Optional</td></tr>

<tr><th colspan=2>KUWAIT Resident ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Additional address information</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>KYRGYZSTAN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>KYRGYZSTAN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>KYRGYZSTAN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>KYRGYZSTAN Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>KYRGYZSTAN Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>LATVIA Alien ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>LATVIA Alien ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>LATVIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>LATVIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>LATVIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>LATVIA Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>LATVIA Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>LATVIA Polycarbonate Alien Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>LATVIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>LEBANON Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>LEBANON Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Fathers name</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Mothers name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>

<tr><th colspan=2>LEBANON Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Marital status</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>LEBANON Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>LIBYA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>LIECHTENSTEIN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>LIECHTENSTEIN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>

<tr><th colspan=2>LIECHTENSTEIN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>LITHUANIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>LITHUANIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>LITHUANIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>LITHUANIA Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>LITHUANIA Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>LITHUANIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>LUXEMBOURG Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>

<tr><th colspan=2>LUXEMBOURG Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>LUXEMBOURG Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>LUXEMBOURG Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>LUXEMBOURG Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>LUXEMBOURG Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>MALAYSIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>MALAYSIA i-Kad - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Employer</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>MALAYSIA MyKad - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Religion</td><td>Optional</td></tr>

<tr><th colspan=2>MALAYSIA MyKad - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document optional additional number</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>MALAYSIA MyKAS - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Religion</td><td>Optional</td></tr>

<tr><th colspan=2>MALAYSIA MyKAS - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document optional additional number</td><td>Mandatory</td></tr>

<tr><th colspan=2>MALAYSIA MyKid - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Religion</td><td>Optional</td></tr>

<tr><th colspan=2>MALAYSIA MyKid - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Document optional additional number</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>MALAYSIA MyPolis - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>MALAYSIA MyPolis - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>

<tr><th colspan=2>MALAYSIA MyPR - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Religion</td><td>Optional</td></tr>

<tr><th colspan=2>MALAYSIA MyPR - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document optional additional number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>MALAYSIA MyTentera - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Religion</td><td>Optional</td></tr>

<tr><th colspan=2>MALAYSIA MyTentera - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document optional additional number</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>MALAYSIA Refugee ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>MALAYSIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>MALDIVES Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>MALDIVES Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>

<tr><th colspan=2>MALTA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>MALTA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>MALTA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>MALTA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>MALTA Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>MALTA Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>MALTA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>MAURITIUS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>MAURITIUS Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO Consular ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO Consular ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO Consular Voter ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document optional additional number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Fathers name</td><td>Optional</td></tr>
<tr><td>Mothers name</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO Consular Voter ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO Professional DL - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO Professional ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO Professional ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO Tax ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO Voter ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document optional additional number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Fathers name</td><td>Optional</td></tr>
<tr><td>Mothers name</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO Voter ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO AGUASCALIENTES Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO AGUASCALIENTES Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO BAJA CALIFORNIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO BAJA CALIFORNIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO BAJA CALIFORNIA SUR Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO BAJA CALIFORNIA SUR Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO CAMPECHE Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO CAMPECHE Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO CHIAPAS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO CHIAPAS Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO CHIHUAHUA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO CHIHUAHUA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO CIUDAD DE MEXICO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO COAHUILA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO COAHUILA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO COLIMA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO COLIMA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO DURANGO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO GUANAJUATO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO GUANAJUATO Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO GUERRERO-JUCHITAN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO GUERRERO-JUCHITAN Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO HIDALGO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO HIDALGO Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO JALISCO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO MEXICO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO MEXICO Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO MICHOACAN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO MICHOACAN Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO MORELOS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO NAYARIT Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO NAYARIT Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO NUEVO LEON Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO NUEVO LEON Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO OAXACA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO OAXACA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO PUEBLA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO PUEBLA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO QUINTANA ROO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO QUINTANA ROO Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO QUINTANA ROO-BENITO JUAREZ Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO QUINTANA ROO-BENITO JUAREZ Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO QUINTANA ROO-COZUMEL Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO QUINTANA ROO-COZUMEL Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO QUINTANA ROO-SOLIDARIDAD Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO QUINTANA ROO-SOLIDARIDAD Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO SAN LUIS POTOSI Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO SINALOA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO SONORA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO SONORA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO TABASCO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO TABASCO Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO TAMAULIPAS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO TAMAULIPAS Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO TLAXCALA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO TLAXCALA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO VERACRUZ Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO VERACRUZ Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO YUCATAN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>

<tr><th colspan=2>MEXICO YUCATAN Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO ZACATECAS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>MEXICO ZACATECAS Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>MOLDOVA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>MOLDOVA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>MOLDOVA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>

<tr><th colspan=2>MOLDOVA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>MOLDOVA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>MONACO Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>MONTENEGRO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>MONTENEGRO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>

<tr><th colspan=2>MONTENEGRO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>MONTENEGRO Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>MOROCCO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>

<tr><th colspan=2>MOROCCO Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>

<tr><th colspan=2>MOROCCO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>MOROCCO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>MOROCCO Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>MOZAMBIQUE Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>MOZAMBIQUE Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Marital status</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>MOZAMBIQUE Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Marital status</td><td>Optional</td></tr>

<tr><th colspan=2>MYANMAR Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>MYANMAR Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>MYANMAR Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>NAMIBIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>

<tr><th colspan=2>NAMIBIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>NEPAL Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>NEPAL Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>NETHERLANDS Alien ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>NETHERLANDS Alien ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>NETHERLANDS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>NETHERLANDS Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>

<tr><th colspan=2>NETHERLANDS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>NETHERLANDS Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>NETHERLANDS Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>NETHERLANDS Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>NETHERLANDS Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>NEW ZEALAND Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>NEW ZEALAND Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Class effective date</td><td>Optional</td></tr>
<tr><td>Class expiry date</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>NEW ZEALAND Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>NEW ZEALAND Polycarbonate Passport - Second data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>NICARAGUA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>NICARAGUA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>NICARAGUA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Additional personal id number</td><td>Optional</td></tr>

<tr><th colspan=2>NIGERIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>NIGERIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>NIGERIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>NIGERIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>NIGERIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>NIGERIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>NIGERIA Voter ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>NIGERIA Voter ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>NORTH MACEDONIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>NORTH MACEDONIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>NORTH MACEDONIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>NORTH MACEDONIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>NORWAY Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>NORWAY Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>NORWAY Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>NORWAY Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>NORWAY Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>NORWAY Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>OMAN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>

<tr><th colspan=2>OMAN Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>OMAN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>OMAN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>

<tr><th colspan=2>OMAN Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>

<tr><th colspan=2>OMAN Resident ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>OMAN Resident ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>

<tr><th colspan=2>PAKISTAN Afghan Citizen Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Additional address information</td><td>Mandatory</td></tr>
<tr><td>Additional name information</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>PAKISTAN Consular ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Additional address information 2</td><td>Mandatory</td></tr>
<tr><td>Additional name information</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>PAKISTAN Consular ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>PAKISTAN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Additional address information 2</td><td>Optional</td></tr>
<tr><td>Additional name information</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>PAKISTAN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Additional address information</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>

<tr><th colspan=2>PAKISTAN Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>

<tr><th colspan=2>PAKISTAN Proof Of Registration - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Additional address information</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Fathers name</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>PAKISTAN Proof Of Registration - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Dependent date of birth</td><td>Optional</td></tr>
<tr><td>Dependent document number</td><td>Optional</td></tr>
<tr><td>Dependent full name</td><td>Optional</td></tr>
<tr><td>Dependent sex or gender</td><td>Optional</td></tr>

<tr><th colspan=2>PAKISTAN Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Religion</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>PAKISTAN PUNJAB Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>PALESTINE Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Mothers name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>PANAMA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>PANAMA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>PANAMA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>PANAMA Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>PANAMA Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>PANAMA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>PANAMA Temporary Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>

<tr><th colspan=2>PANAMA Temporary Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>

<tr><th colspan=2>PARAGUAY Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>

<tr><th colspan=2>PARAGUAY Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>PARAGUAY Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>PARAGUAY Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Marital status</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>PARAGUAY Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>

<tr><th colspan=2>PERU Alien ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>PERU Alien ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>PERU Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>PERU Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>

<tr><th colspan=2>PERU Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Marital status</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Document optional additional number</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>PERU Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>PERU Minors ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Document optional additional number</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>PERU Minors ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>PERU Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>PHILIPPINES Alien ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Marital status</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>PHILIPPINES Alien ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document optional additional number</td><td>Mandatory</td></tr>
<tr><td>Visa type</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>

<tr><th colspan=2>PHILIPPINES Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Conditions</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>PHILIPPINES Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>PHILIPPINES Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>

<tr><th colspan=2>PHILIPPINES Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Marital status</td><td>Optional</td></tr>

<tr><th colspan=2>PHILIPPINES Multipurpose ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>PHILIPPINES Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>PHILIPPINES Postal ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>

<tr><th colspan=2>PHILIPPINES Professional ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>

<tr><th colspan=2>PHILIPPINES Social Security Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>

<tr><th colspan=2>PHILIPPINES Tax ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>

<tr><th colspan=2>PHILIPPINES Voter ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Marital status</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>

<tr><th colspan=2>PHILIPPINES Work Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Employer</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>

<tr><th colspan=2>PHILIPPINES BANGSAMORO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Conditions</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>PHILIPPINES BANGSAMORO Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>

<tr><th colspan=2>POLAND Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>

<tr><th colspan=2>POLAND Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>POLAND Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>POLAND Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>POLAND Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>POLAND Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>POLAND Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>PORTUGAL Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>

<tr><th colspan=2>PORTUGAL Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>PORTUGAL Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>PORTUGAL Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>PORTUGAL Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>PORTUGAL Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Document optional additional number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>PUERTO RICO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>PUERTO RICO Voter ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>QATAR Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>

<tr><th colspan=2>QATAR Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>

<tr><th colspan=2>QATAR Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>QATAR Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>QATAR Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document optional additional number</td><td>Mandatory</td></tr>
<tr><td>Sponsor</td><td>Mandatory</td></tr>

<tr><th colspan=2>ROMANIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>ROMANIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Fathers name</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Mothers name</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>ROMANIA Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>ROMANIA Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>ROMANIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>RUSSIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>RUSSIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>RUSSIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>RWANDA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SAINT KITTS AND NEVIS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>SAINT KITTS AND NEVIS Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>SAINT LUCIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SAINT LUCIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SAINT LUCIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>SAINT LUCIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SAN MARINO Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SAUDI ARABIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>

<tr><th colspan=2>SAUDI ARABIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>

<tr><th colspan=2>SAUDI ARABIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>SAUDI ARABIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SAUDI ARABIA Resident ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>

<tr><th colspan=2>SAUDI ARABIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SENEGAL Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>

<tr><th colspan=2>SENEGAL Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>SENEGAL Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SERBIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>SERBIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>

<tr><th colspan=2>SERBIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>

<tr><th colspan=2>SERBIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SINGAPORE Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>

<tr><th colspan=2>SINGAPORE Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>SINGAPORE Employment Pass - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Employer</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>SINGAPORE Fin Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SINGAPORE Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Race</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SINGAPORE Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>SINGAPORE Resident ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Race</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SINGAPORE Resident ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>

<tr><th colspan=2>SINGAPORE Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SINGAPORE S Pass - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Employer</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>

<tr><th colspan=2>SINGAPORE S Pass - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SINGAPORE Work Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Employer</td><td>Optional</td></tr>

<tr><th colspan=2>SINGAPORE Work Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SLOVAKIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>SLOVAKIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>SLOVAKIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>SLOVAKIA Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>SLOVAKIA Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>SLOVAKIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SLOVENIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>SLOVENIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>SLOVENIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>SLOVENIA Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>SLOVENIA Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>SLOVENIA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SLOVENIA Polycarbonate Passport - Second data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>

<tr><th colspan=2>SOUTH AFRICA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>SOUTH AFRICA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>SOUTH AFRICA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Barcode data</td><td>Optional</td></tr>

<tr><th colspan=2>SOUTH AFRICA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SOUTH KOREA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Conditions</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>

<tr><th colspan=2>SOUTH KOREA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>

<tr><th colspan=2>SOUTH KOREA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>SPAIN Alien ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SPAIN Alien ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>SPAIN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>SPAIN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>SPAIN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>SPAIN Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>SPAIN Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document optional additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>SPAIN Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>SRI LANKA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>SRI LANKA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>SRI LANKA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>SRI LANKA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>SUDAN Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SURINAME Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SURINAME Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>SWEDEN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>SWEDEN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>

<tr><th colspan=2>SWEDEN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>

<tr><th colspan=2>SWEDEN Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>SWEDEN Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>SWEDEN Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>SWEDEN Polycarbonate Refugee Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SWEDEN Sis ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>SWEDEN Social Security Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>

<tr><th colspan=2>SWEDEN Social Security Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>

<tr><th colspan=2>SWITZERLAND Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>SWITZERLAND Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>SWITZERLAND Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>SWITZERLAND Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SWITZERLAND Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>SWITZERLAND Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document optional additional number</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>SWITZERLAND Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SYRIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Fathers name</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Mothers name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>SYRIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>SYRIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Fathers name</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Mothers name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>TAIWAN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>

<tr><th colspan=2>TAIWAN Temporary Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>TAJIKISTAN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>TAJIKISTAN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Marital status</td><td>Mandatory</td></tr>

<tr><th colspan=2>TAJIKISTAN Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>TANZANIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>TANZANIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>TANZANIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>

<tr><th colspan=2>TANZANIA Voter ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>THAILAND Alien ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>

<tr><th colspan=2>THAILAND Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>THAILAND Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>

<tr><th colspan=2>THAILAND Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>

<tr><th colspan=2>THAILAND Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>

<tr><th colspan=2>THAILAND Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>TOGO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>TOGO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>TRINIDAD AND TOBAGO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>TRINIDAD AND TOBAGO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>

<tr><th colspan=2>TRINIDAD AND TOBAGO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>Document optional additional number</td><td>Optional</td></tr>

<tr><th colspan=2>TRINIDAD AND TOBAGO Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>TUNISIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>TUNISIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>

<tr><th colspan=2>TUNISIA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>TURKEY Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>TURKEY Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>TURKEY Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Marital status</td><td>Optional</td></tr>
<tr><td>Religion</td><td>Optional</td></tr>

<tr><th colspan=2>TURKEY Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>TURKEY Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>

<tr><th colspan=2>TURKEY Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>

<tr><th colspan=2>TURKEY Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>TURKMENISTAN Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>TURKS AND CAICOS ISLANDS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>TURKS AND CAICOS ISLANDS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>TURKS AND CAICOS ISLANDS Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>UAE Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>

<tr><th colspan=2>UAE Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>UAE Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>UAE Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>UAE Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>UAE Resident ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>UAE Resident ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Additional name information</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Employer</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>UAE Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>UGANDA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>

<tr><th colspan=2>UGANDA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>UGANDA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>UK Asylum Request - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>

<tr><th colspan=2>UK Asylum Request - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>UK Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Signature</td><td>Optional</td></tr>

<tr><th colspan=2>UK Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>

<tr><th colspan=2>UK Proof Of Age Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>

<tr><th colspan=2>UK Proof Of Age Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>

<tr><th colspan=2>UK Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>

<tr><th colspan=2>UK Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>UK Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>UKRAINE Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>UKRAINE Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>UKRAINE Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>

<tr><th colspan=2>UKRAINE Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>

<tr><th colspan=2>UKRAINE Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>UKRAINE Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>UKRAINE Temporary Residence Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>

<tr><th colspan=2>UKRAINE Temporary Residence Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>URUGUAY Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Nationality</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>URUGUAY Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>
<tr><td>Document additional number</td><td>Optional</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>
<tr><td>Place of birth</td><td>Optional</td></tr>

<tr><th colspan=2>URUGUAY Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Border Crossing Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Border Crossing Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>USA Global Entry Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Global Entry Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Green Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Eligibility category</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Green Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Military ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Employer</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Additional name information</td><td>Optional</td></tr>

<tr><th colspan=2>USA Military ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document optional additional number</td><td>Optional</td></tr>

<tr><th colspan=2>USA Nexus Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Nexus Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Passport Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Passport Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Social Security Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Optional</td></tr>

<tr><th colspan=2>USA Twic Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Twic Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Uniformed Services ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Employer</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Mandatory</td></tr>
<tr><td>Additional name information</td><td>Optional</td></tr>

<tr><th colspan=2>USA Uniformed Services ID - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document optional additional number</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Veteran ID - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Optional</td></tr>

<tr><th colspan=2>USA Work Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Eligibility category</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA Work Permit - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA ALABAMA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA ALABAMA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA ALABAMA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA ALABAMA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA ALASKA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA ALASKA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA ALASKA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA ALASKA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA ARIZONA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA ARIZONA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA ARIZONA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>USA ARIZONA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA ARKANSAS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>USA ARKANSAS Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA ARKANSAS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA ARKANSAS Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA CALIFORNIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA CALIFORNIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA CALIFORNIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA CALIFORNIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA COLORADO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA COLORADO Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA COLORADO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA COLORADO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA CONNECTICUT Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA CONNECTICUT Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA CONNECTICUT Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA CONNECTICUT Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA DELAWARE Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA DELAWARE Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA DELAWARE Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA DELAWARE Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA DISTRICT OF COLUMBIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA DISTRICT OF COLUMBIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA DISTRICT OF COLUMBIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA DISTRICT OF COLUMBIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA FLORIDA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA FLORIDA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA FLORIDA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA FLORIDA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA GEORGIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA GEORGIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA GEORGIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>USA GEORGIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA HAWAII Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA HAWAII Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA HAWAII Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA HAWAII Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA IDAHO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>USA IDAHO Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA IDAHO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA IDAHO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA ILLINOIS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA ILLINOIS Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA ILLINOIS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>USA ILLINOIS Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA INDIANA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>USA INDIANA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA INDIANA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>USA INDIANA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA IOWA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA IOWA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA IOWA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA IOWA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA KANSAS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA KANSAS Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA KANSAS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA KANSAS Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA KENTUCKY Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA KENTUCKY Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA KENTUCKY Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA KENTUCKY Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA LOUISIANA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA LOUISIANA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA LOUISIANA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA LOUISIANA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA MAINE Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA MAINE Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA MAINE Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA MAINE Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA MARYLAND Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA MARYLAND Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA MARYLAND Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA MARYLAND Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA MASSACHUSETTS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA MASSACHUSETTS Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA MASSACHUSETTS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA MASSACHUSETTS Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA MICHIGAN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA MICHIGAN Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>USA MICHIGAN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA MICHIGAN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>USA MINNESOTA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>USA MINNESOTA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>USA MINNESOTA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>USA MINNESOTA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>USA MISSISSIPPI Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA MISSISSIPPI Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA MISSISSIPPI Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA MISSISSIPPI Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA MISSOURI Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Race</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>USA MISSOURI Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA MISSOURI Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA MISSOURI Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA MONTANA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA MONTANA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA MONTANA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA MONTANA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA NEBRASKA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NEBRASKA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA NEBRASKA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NEBRASKA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA NEVADA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NEVADA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA NEVADA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NEVADA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA NEW HAMPSHIRE Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NEW HAMPSHIRE Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA NEW HAMPSHIRE Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NEW HAMPSHIRE Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA NEW JERSEY Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NEW JERSEY Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA NEW JERSEY Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NEW JERSEY Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA NEW MEXICO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NEW MEXICO Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA NEW MEXICO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NEW MEXICO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA NEW YORK Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NEW YORK Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>USA NEW YORK Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NEW YORK Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>USA NEW YORK CITY Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NEW YORK CITY Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA NORTH CAROLINA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NORTH CAROLINA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA NORTH CAROLINA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NORTH CAROLINA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA NORTH DAKOTA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NORTH DAKOTA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA NORTH DAKOTA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA NORTH DAKOTA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA OHIO Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA OHIO Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA OHIO Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA OHIO Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA OKLAHOMA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA OKLAHOMA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA OKLAHOMA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA OKLAHOMA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA OREGON Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>USA OREGON Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA OREGON Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>USA OREGON Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA PENNSYLVANIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA PENNSYLVANIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA PENNSYLVANIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA PENNSYLVANIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA RHODE ISLAND Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA RHODE ISLAND Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA RHODE ISLAND Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA RHODE ISLAND Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA SOUTH CAROLINA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA SOUTH CAROLINA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA SOUTH CAROLINA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Full name</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA SOUTH CAROLINA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA SOUTH DAKOTA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA SOUTH DAKOTA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA SOUTH DAKOTA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA SOUTH DAKOTA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA TENNESSEE Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA TENNESSEE Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA TENNESSEE Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA TENNESSEE Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA TEXAS Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA TEXAS Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA TEXAS Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA TEXAS Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA TEXAS Weapon Permit - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA UTAH Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA UTAH Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA UTAH Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA UTAH Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA VERMONT Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA VERMONT Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>USA VERMONT Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA VERMONT Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA VIRGINIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA VIRGINIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA VIRGINIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA VIRGINIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA WASHINGTON Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>
<tr><td>Vehicle class</td><td>Optional</td></tr>

<tr><th colspan=2>USA WASHINGTON Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>USA WASHINGTON Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA WASHINGTON Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>USA WEST VIRGINIA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA WEST VIRGINIA Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA WEST VIRGINIA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA WEST VIRGINIA Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA WISCONSIN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA WISCONSIN Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA WISCONSIN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA WISCONSIN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA WYOMING Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>Endorsements</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA WYOMING Driver's License - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>USA WYOMING Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Document subtype</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Specific document validity</td><td>Optional</td></tr>

<tr><th colspan=2>USA WYOMING Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Barcode data</td><td>Mandatory</td></tr>

<tr><th colspan=2>UZBEKISTAN Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>UZBEKISTAN Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>UZBEKISTAN Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>UZBEKISTAN Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>VENEZUELA Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>
<tr><td>Restrictions</td><td>Optional</td></tr>

<tr><th colspan=2>VENEZUELA Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Marital status</td><td>Mandatory</td></tr>

<tr><th colspan=2>VENEZUELA Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>VIETNAM Driver's License - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Vehicle class</td><td>Mandatory</td></tr>

<tr><th colspan=2>VIETNAM Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>VIETNAM Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Optional</td></tr>

<tr><th colspan=2>ZIMBABWE Identity Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>

<tr><th colspan=2>ZIMBABWE Identity Card - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>

<tr><th colspan=2>ZIMBABWE Paper Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>ZIMBABWE Polycarbonate Passport - Bio-data page</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Address</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>First name</td><td>Mandatory</td></tr>
<tr><td>Issuing authority</td><td>Mandatory</td></tr>
<tr><td>Last name</td><td>Mandatory</td></tr>
<tr><td>MRZ</td><td>Mandatory</td></tr>
<tr><td>Nationality</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>
<tr><td>Place of birth</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>
<tr><td>Profession</td><td>Optional</td></tr>

<tr><th colspan=2>AUSTRALIA Health Insurance Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>

<tr><th colspan=2>AUSTRALIA Interim Health Insurance Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>

<tr><th colspan=2>AUSTRALIA Reciprocal Health Insurance Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>

<tr><th colspan=2>CANADA ONTARIO Health Insurance Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Date of issue</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>CANADA QUEBEC Health Insurance Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Date of expiry</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Sex</td><td>Mandatory</td></tr>

<tr><th colspan=2>CROATIA Health Insurance Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Additional personal id number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Personal ID number</td><td>Mandatory</td></tr>

<tr><th colspan=2>EUROPEAN UNION Health Insurance Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Date of expiry</td><td>Optional</td></tr>
<tr><td>First name</td><td>Optional</td></tr>
<tr><td>Issuing authority</td><td>Optional</td></tr>
<tr><td>Last name</td><td>Optional</td></tr>
<tr><td>Personal ID number</td><td>Optional</td></tr>

<tr><th colspan=2>PHILIPPINES Health Insurance Card - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Full name</td><td>Mandatory</td></tr>
<tr><td>Address</td><td>Optional</td></tr>
<tr><td>Date of birth</td><td>Optional</td></tr>
<tr><td>Sex</td><td>Optional</td></tr>

<tr><th colspan=2>UAE Vehicle Registration - Front</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Document additional number</td><td>Mandatory</td></tr>
<tr><td>Document number</td><td>Mandatory</td></tr>
<tr><td>Vehicle owner</td><td>Mandatory</td></tr>

<tr><th colspan=2>UAE Vehicle Registration - Back</th></tr>
<tr><th>Field</th><th>Presence</th></tr>
<tr><td>Manufacturing year</td><td>Mandatory</td></tr>
<tr><td>Vehicle type</td><td>Mandatory</td></tr>


</table>