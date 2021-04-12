<p align="justify">
The tables below represent scanning results for each document in each country supported in BlinkID v5. The fields marked as "Always" present are mandatory on all document versions and will always be a part of the result set. The ones marked as "Sometimes" present will be returned only if they exist on the specific document being scanned. "Pending" stands for those fields for which it's not certain whether or not they're present on all document versions. For US documents, all information concerns both horizontal and vertical supported documents.
<br>
<br>
<h2>MRZ Fields</h2>
Other than documents listed here, BlinkID(Combined)Recognizer also scans the <strong>Machine Readable Zone (MRZ)</strong> on standard (ISO/IEC 7501 compliant) <strong>Machine Readable Travel Documents (MRTD)</strong>. This includes <strong>passports, visas</strong> and other identification documents.
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
<h2>Anonymized Fields</h2>
With the <strong>result anonymization option</strong> enabled, results are not returned for protected fields on documents listed here. The full document image will also have this data blacked out.
<br>
Protected fields are:
<ul>
<li>MRZ (Document number) on Germany Alien Passport</li>
<li>Document number, MRZ (Document number) on Germany ID</li>
<li>MRZ (Document number) on Germany Minors Passport</li>
<li>MRZ (Document number) on Germany Passport</li>
<li>Document number on Hong Kong ID</li>
<li>MRZ (Document number, OPT1 containing the passport or ID number) on Hong Kong passports</li>
<li>Personal ID number (BSN) on Netherlands DL</li>
<li>Personal ID number and MRZ (OPT1 containing the BSN) on Netherlands ID</li>
<li>MRZ (OPT1 containing the BSN) on Netherlands passports</li>
<li>Document number on Singapore DL, ID, Fin Card, Resident ID, S Pass</li>
<li>Personal ID number on Singapore Employment Pass</li>
<li>Document number and personal ID number on Singapore Work Permit</li>
<li>MRZ (Document number, OPT1 containing the NRIC) on Singapore Passport</li>
<li>MRZ on the China Mainland Travel Permit for Hong Kong and Macau residents</li>
<li>MRZ (OPT1 containing the resident registration number) on South Korea Diplomatic Passport </li>
<li>MRZ (OPT1 containing the resident registration number) on South Korea Passport</li>
<li>MRZ (OPT1 containing the resident registration number) on South Korea Residence Passport</li>
<li>MRZ (OPT1 containing the resident registration number) on South Korea Service Passport</li>
<li>MRZ (OPT1 containing the resident registration number) on South Korea Temporary Passport</li>
</ul>
	
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
<table><tr>
<th colspan=2>ALBANIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Address</td> <td>Sometimes</td><tr>

<th colspan=2>ALBANIA DRIVER CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>ALBANIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>ALBANIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>ALBANIA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>ALBANIA PROFESSIONAL DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>ALGERIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>ALGERIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>ALGERIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>ALGERIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>ARGENTINA ALIEN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<th colspan=2>ARGENTINA ALIEN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>ARGENTINA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>ARGENTINA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>MRZ</td> <td>Sometimes</td><tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>ARGENTINA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>


<th colspan=2>ARMENIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>ARMENIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA AUSTRALIAN CAPITAL TERRITORY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRALIA NEW SOUTH WALES DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRALIA NEW SOUTH WALES ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRALIA NORTHERN TERRITORY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Sometimes</td><tr>
<tr> <td>Endorsements</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRALIA NORTHERN TERRITORY DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA QUEENSLAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Sometimes</td><tr>
<tr> <td>Document additional number</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRALIA QUEENSLAND DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA SOUTH AUSTRALIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRALIA SOUTH AUSTRALIA PROOF OF AGE CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA TASMANIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA VICTORIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRALIA VICTORIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>Last name</td> <td>Sometimes</td><tr>


<th colspan=2>AUSTRALIA WESTERN AUSTRALIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA WESTERN AUSTRALIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>


<th colspan=2>AUSTRIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>AUSTRIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>Nationality</td> <td>Sometimes</td><tr>


<th colspan=2>AZERBAIJAN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Document number</td> <td>Sometimes</td><tr>
<tr> <td>MRZ</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>
<tr> <td>Place of birth</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>AZERBAIJAN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Marital status</td> <td>Sometimes</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>


<th colspan=2>BAHAMAS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BAHAMAS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>BAHRAIN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>BAHRAIN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BANGLADESH DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>BANGLADESH DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>


<th colspan=2>BANGLADESH ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>BANGLADESH ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>BELARUS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>BELGIUM DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>BELGIUM ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>
<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>BELGIUM ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>BELGIUM MINORS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BELGIUM MINORS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>BELGIUM RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>BELGIUM RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>BELGIUM RESIDENT ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BELGIUM RESIDENT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>BERMUDA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>BOLIVIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>BOLIVIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>BOLIVIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>


<th colspan=2>BOLIVIA MINORS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>BOLIVIA MINORS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>BOSNIA AND HERZEGOVINA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>BOSNIA AND HERZEGOVINA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>BOSNIA AND HERZEGOVINA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>BOSNIA AND HERZEGOVINA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>BRAZIL DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>BRAZIL DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>BRUNEI ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BRUNEI ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Race</td> <td>Always</td><tr>


<th colspan=2>BRUNEI MILITARY ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>BRUNEI MILITARY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>


<th colspan=2>BRUNEI RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BRUNEI RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Race</td> <td>Always</td><tr>


<th colspan=2>BRUNEI TEMPORARY RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BRUNEI TEMPORARY RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Employer</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>


<th colspan=2>BULGARIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>BULGARIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BULGARIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>


<th colspan=2>BURKINA FASO ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CAMBODIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Conditions</td> <td>Sometimes</td><tr>

<th colspan=2>CAMBODIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>CAMBODIA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CAMEROON ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>

<th colspan=2>CAMEROON ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>CANADA RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>CANADA TRIBAL ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA TRIBAL ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>


<th colspan=2>CANADA ALBERTA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA ALBERTA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA ALBERTA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA ALBERTA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA DL PUBLIC SERVICES CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA DL PUBLIC SERVICES CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA PUBLIC SERVICES CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA BRITISH COLUMBIA PUBLIC SERVICES CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA MANITOBA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA MANITOBA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA MANITOBA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA MANITOBA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA NEW BRUNSWICK DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CANADA NEW BRUNSWICK DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA NEWFOUNDLAND AND LABRADOR DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CANADA NEWFOUNDLAND AND LABRADOR DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA NOVA SCOTIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CANADA NOVA SCOTIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA NOVA SCOTIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA NOVA SCOTIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA ONTARIO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA ONTARIO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA ONTARIO HEALTH INSURANCE CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA ONTARIO ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA ONTARIO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA QUEBEC DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA SASKATCHEWAN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA SASKATCHEWAN DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA SASKATCHEWAN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA SASKATCHEWAN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA YUKON DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA YUKON DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CHILE ALIEN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CHILE ALIEN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>


<th colspan=2>CHILE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>CHILE ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>CHILE ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Sometimes</td><tr>


<th colspan=2>CHILE PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CHINA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>CHINA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>


<th colspan=2>COLOMBIA ALIEN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>COLOMBIA ALIEN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>COLOMBIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>COLOMBIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>


<th colspan=2>COLOMBIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>COLOMBIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>COLOMBIA MINORS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>COLOMBIA MINORS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>COLOMBIA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>COSTA RICA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>COSTA RICA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>COSTA RICA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>


<th colspan=2>CROATIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CROATIA HEALTH INSURANCE CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Additional personal id number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>CROATIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CROATIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>CROATIA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CROATIA RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>CROATIA RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>CYPRUS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>CYPRUS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>CYPRUS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>CYPRUS RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>

<th colspan=2>CYPRUS RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>CZECHIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Address</td> <td>Sometimes</td><tr>

<th colspan=2>CZECHIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Document number</td> <td>Sometimes</td><tr>
<tr> <td>MRZ</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>
<tr> <td>Place of birth</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>CZECHIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Marital status</td> <td>Sometimes</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>CZECHIA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CZECHIA RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>CZECHIA RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>DEMOCRATIC REPUBLIC OF THE CONGO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>DENMARK DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>DENMARK PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>DENMARK RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>DENMARK RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>DOMINICAN REPUBLIC DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>DOMINICAN REPUBLIC DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>DOMINICAN REPUBLIC ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>DOMINICAN REPUBLIC ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>ECUADOR DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>ECUADOR ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>ECUADOR ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>


<th colspan=2>EGYPT DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>EGYPT DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>EGYPT ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>EGYPT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>


<th colspan=2>EL SALVADOR DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>EL SALVADOR DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>EL SALVADOR ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>EL SALVADOR ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>


<th colspan=2>ESTONIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>ESTONIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<th colspan=2>ESTONIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>ESTONIA RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>ESTONIA RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>FINLAND ALIEN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>FINLAND ALIEN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>FINLAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>FINLAND ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>FINLAND ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>FINLAND PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>FINLAND RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>FINLAND RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>FRANCE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>FRANCE ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>FRANCE ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>FRANCE RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>FRANCE RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>GEORGIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>GEORGIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>GEORGIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>GERMANY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>GERMANY ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>
<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<th colspan=2>GERMANY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>


<th colspan=2>GERMANY PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<th colspan=2>GERMANY RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>GERMANY RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Nationality</td> <td>Sometimes</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>


<th colspan=2>GHANA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>GHANA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>GHANA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>GREECE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>GREECE ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>GREECE RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>GREECE RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>GUATEMALA CONSULAR ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>GUATEMALA CONSULAR ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>GUATEMALA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<th colspan=2>GUATEMALA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>


<th colspan=2>GUATEMALA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>GUATEMALA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>


<th colspan=2>HAITI DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>HAITI ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>HAITI ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>HONDURAS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>HONDURAS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>


<th colspan=2>HONDURAS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>HONDURAS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>HONG KONG ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Residential status</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Additional name information</td> <td>Sometimes</td><tr>

<th colspan=2>HONG KONG PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>HUNGARY ADDRESS CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Additional name information</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Additional address information</td> <td>Sometimes</td><tr>

<th colspan=2>HUNGARY ADDRESS CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>HUNGARY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>HUNGARY ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>HUNGARY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Additional name information</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>HUNGARY RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<th colspan=2>HUNGARY RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>ICELAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>INDIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<th colspan=2>INDIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>


<th colspan=2>INDIA PAN CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<th colspan=2>INDIA GUJARAT DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>INDIA KARNATAKA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>INDIA KERALA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>INDIA KERALA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>INDIA MADHYA PRADESH DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>INDIA MAHARASHTRA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>INDIA PUNJAB DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>INDIA TAMIL NADU DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>

<th colspan=2>INDIA TAMIL NADU DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>


<th colspan=2>INDONESIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<th colspan=2>INDONESIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>IRAQ ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>IRAQ ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>IRELAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>IRELAND PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<th colspan=2>IRELAND PASSPORT CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>IRELAND PUBLIC SERVICES CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>IRELAND PUBLIC SERVICES CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>ISRAEL DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>ISRAEL ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>ISRAEL ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>ITALY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<th colspan=2>ITALY ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Document number</td> <td>Sometimes</td><tr>
<tr> <td>MRZ</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>ITALY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Nationality</td> <td>Sometimes</td><tr>


<th colspan=2>ITALY RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>ITALY RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>IVORY COAST DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>IVORY COAST ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>IVORY COAST ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>


<th colspan=2>JAMAICA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>JAMAICA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>JAPAN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Sometimes</td><tr>

<th colspan=2>JORDAN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>JORDAN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>JORDAN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>KAZAKHSTAN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>KAZAKHSTAN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>KENYA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>KENYA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>KOSOVO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>KOSOVO ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Sometimes</td><tr>

<th colspan=2>KOSOVO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>KUWAIT DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Sometimes</td><tr>

<th colspan=2>KUWAIT DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>KUWAIT ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>KUWAIT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>KUWAIT RESIDENT ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document optional additional number</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>

<th colspan=2>KUWAIT RESIDENT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>KYRGYZSTAN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>KYRGYZSTAN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>LATVIA ALIEN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>LATVIA ALIEN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>LATVIA ALIEN PASSPORT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Nationality</td> <td>Sometimes</td><tr>

<th colspan=2>LATVIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>LATVIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>LATVIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>


<th colspan=2>LATVIA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>LATVIA RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>LATVIA RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>LEBANON ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>LEBANON ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>


<th colspan=2>LITHUANIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>LITHUANIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>LITHUANIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>LITHUANIA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>LUXEMBOURG DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>

<th colspan=2>LUXEMBOURG ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>

<th colspan=2>LUXEMBOURG ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>LUXEMBOURG RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>LUXEMBOURG RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>MALAYSIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Religion</td> <td>Sometimes</td><tr>

<th colspan=2>MALAYSIA MyKAS - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document optional additional number</td> <td>Always</td><tr>


<th colspan=2>MALAYSIA MyKad - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Religion</td> <td>Sometimes</td><tr>

<th colspan=2>MALAYSIA MyKad - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document optional additional number</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>


<th colspan=2>MALAYSIA MyKid - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Document additional number</td> <td>Sometimes</td><tr>
<tr> <td>Place of birth</td> <td>Sometimes</td><tr>
<tr> <td>Religion</td> <td>Sometimes</td><tr>

<th colspan=2>MALAYSIA MyKid - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>Document optional additional number</td> <td>Sometimes</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>MALAYSIA MyPR - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Religion</td> <td>Sometimes</td><tr>

<th colspan=2>MALAYSIA MyPR - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document optional additional number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>


<th colspan=2>MALAYSIA MyPolis - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>MALAYSIA MyPolis - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>


<th colspan=2>MALAYSIA MyTentera - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Religion</td> <td>Sometimes</td><tr>

<th colspan=2>MALAYSIA MyTentera - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document optional additional number</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>


<th colspan=2>MALAYSIA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MALAYSIA REFUGEE ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MALAYSIA iKAD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Employer</td> <td>Sometimes</td><tr>
<tr> <td>Profession</td> <td>Sometimes</td><tr>

<th colspan=2>MALDIVES ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MALDIVES ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>


<th colspan=2>MALTA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MALTA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>MALTA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>MALTA RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>MALTA RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>MAURITIUS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MAURITIUS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>MEXICO CONSULAR ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO CONSULAR ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO PROFESSIONAL DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>MEXICO VOTER ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document optional additional number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO VOTER ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO BAJA CALIFORNIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO BAJA CALIFORNIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO CHIAPAS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO CHIHUAHUA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO CHIHUAHUA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO COAHUILA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO COAHUILA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MEXICO DURANGO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO GUANAJUATO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO GUANAJUATO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO GUERRERO-COCULA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO GUERRERO-COCULA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>


<th colspan=2>MEXICO GUERRERO-JUCHITAN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO GUERRERO-JUCHITAN DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>


<th colspan=2>MEXICO GUERRERO-TEPECOACUILCO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO GUERRERO-TLACOAPA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO HIDALGO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO HIDALGO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO JALISCO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MEXICO MEXICO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO MEXICO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO MICHOACAN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO MICHOACAN DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Sometimes</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO MORELOS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO NUEVO LEON DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO NUEVO LEON DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO OAXACA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO OAXACA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO PUEBLA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO SAN LUIS POTOSI DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO SINALOA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO SONORA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>MEXICO SONORA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MEXICO TABASCO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MEXICO TABASCO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>


<th colspan=2>MEXICO TAMAULIPAS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO TAMAULIPAS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Sometimes</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO VERACRUZ DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO YUCATAN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>MEXICO YUCATAN DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO ZACATECAS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO ZACATECAS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>


<th colspan=2>MOLDOVA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MOLDOVA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>


<th colspan=2>MONTENEGRO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MONTENEGRO ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>

<th colspan=2>MONTENEGRO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>MONTENEGRO PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MOROCCO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<th colspan=2>MOROCCO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>


<th colspan=2>MOROCCO ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>MOROCCO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>


<th colspan=2>MOZAMBIQUE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MYANMAR DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>MYANMAR DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>NETHERLANDS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<th colspan=2>NETHERLANDS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>


<th colspan=2>NETHERLANDS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>NETHERLANDS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>NETHERLANDS PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>NETHERLANDS RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>NETHERLANDS RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>NEW ZEALAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>NEW ZEALAND PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>NICARAGUA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>NICARAGUA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>NIGERIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>NIGERIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>NIGERIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Document number</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>
<tr> <td>Profession</td> <td>Sometimes</td><tr>

<th colspan=2>NIGERIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>NIGERIA VOTER ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>NIGERIA VOTER ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>NORTH MACEDONIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>NORTH MACEDONIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>NORTH MACEDONIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>NORWAY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>NORWAY PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>NORWAY RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>NORWAY RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>OMAN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>OMAN DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>OMAN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>OMAN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>OMAN RESIDENT ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>OMAN RESIDENT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>PAKISTAN CONSULAR ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Document number</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>PAKISTAN CONSULAR ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>PAKISTAN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>PAKISTAN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>


<th colspan=2>PAKISTAN PUNJAB DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>PANAMA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>PANAMA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PANAMA TEMPORARY RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>PANAMA TEMPORARY RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>


<th colspan=2>PARAGUAY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>PARAGUAY DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>PARAGUAY ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PARAGUAY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>


<th colspan=2>PERU DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>PERU DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>


<th colspan=2>PERU ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Document number</td> <td>Sometimes</td><tr>
<tr> <td>MRZ</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>PERU ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>


<th colspan=2>PERU MINORS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PERU MINORS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>


<th colspan=2>PHILIPPINES DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Sometimes</td><tr>

<th colspan=2>PHILIPPINES MULTIPURPOSE ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PHILIPPINES PROFESSIONAL ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>


<th colspan=2>PHILIPPINES SOCIAL SECURITY CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>

<th colspan=2>PHILIPPINES TAX ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>PHILIPPINES VOTER ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>POLAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>POLAND ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Document additional number</td> <td>Sometimes</td><tr>
<tr> <td>Document number</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>

<th colspan=2>POLAND ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>Nationality</td> <td>Sometimes</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>POLAND PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>POLAND RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>POLAND RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>


<th colspan=2>PORTUGAL DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Address</td> <td>Sometimes</td><tr>

<th colspan=2>PORTUGAL ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PORTUGAL ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>PORTUGAL RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>PORTUGAL RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>PUERTO RICO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>PUERTO RICO VOTER ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>QATAR DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>QATAR RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>QATAR RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>

<th colspan=2>ROMANIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>ROMANIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>ROMANIA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>RUSSIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>RUSSIA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>RWANDA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SAUDI ARABIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<th colspan=2>SAUDI ARABIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>

<th colspan=2>SAUDI ARABIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>SAUDI ARABIA RESIDENT ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>SENEGAL ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<th colspan=2>SENEGAL ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>SERBIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SERBIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>SERBIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>SERBIA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SINGAPORE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<th colspan=2>SINGAPORE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE EMPLOYMENT PASS - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Employer</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Profession</td> <td>Sometimes</td><tr>

<th colspan=2>SINGAPORE FIN CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Race</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE RESIDENT ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Race</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE RESIDENT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE S PASS - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Employer</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE WORK PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Employer</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE WORK PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SLOVAKIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>
<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<th colspan=2>SLOVAKIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SLOVAKIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>SLOVAKIA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SLOVAKIA RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>SLOVAKIA RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>SLOVENIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SLOVENIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SLOVENIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>SLOVENIA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SLOVENIA RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<th colspan=2>SLOVENIA RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>SOUTH AFRICA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SOUTH AFRICA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SOUTH AFRICA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>SOUTH AFRICA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SOUTH KOREA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>

<th colspan=2>SOUTH KOREA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>SPAIN ALIEN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SPAIN ALIEN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>SPAIN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>SPAIN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SPAIN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>SPAIN RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Document optional additional number</td> <td>Sometimes</td><tr>
<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>
<tr> <td>Profession</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>SPAIN RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>


<th colspan=2>SRI LANKA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>SRI LANKA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>SRI LANKA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>SWEDEN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>SWEDEN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SWEDEN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>SWEDEN PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SWEDEN RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>SWEDEN RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>SWEDEN SOCIAL SECURITY CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>
<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<th colspan=2>SWITZERLAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>SWITZERLAND ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>SWITZERLAND ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SWITZERLAND RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>SWITZERLAND RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>TAIWAN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>TAIWAN TEMPORARY RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>TANZANIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>THAILAND ALIEN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>THAILAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>THAILAND DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>


<th colspan=2>THAILAND ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>THAILAND PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>TRINIDAD AND TOBAGO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>TRINIDAD AND TOBAGO ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>TRINIDAD AND TOBAGO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>


<th colspan=2>TUNISIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>TUNISIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>TURKEY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>TURKEY ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>
<tr> <td>Place of birth</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>TURKEY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Marital status</td> <td>Sometimes</td><tr>

<tr> <td>Religion</td> <td>Sometimes</td><tr>


<th colspan=2>TURKEY PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>TURKEY RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<th colspan=2>UAE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>UAE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>


<th colspan=2>UAE ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>UAE ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>UAE RESIDENT ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>UAE RESIDENT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>UGANDA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>UGANDA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>UGANDA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>UK DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>UK PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>UK RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>UK RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>UKRAINE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>
<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>UKRAINE ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>UKRAINE ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>UKRAINE PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>URUGUAY ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>URUGUAY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>USA BORDER CROSSING CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA GLOBAL ENTRY CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA GLOBAL ENTRY CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>USA GREEN CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA GREEN CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>USA NEXUS CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NEXUS CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>USA SOCIAL SECURITY CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<th colspan=2>USA VETERAN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>USA WORK PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA WORK PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>USA ALABAMA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA ALABAMA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ALABAMA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA ALABAMA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ALASKA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA ALASKA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ALASKA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA ALASKA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ARIZONA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA ARIZONA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ARIZONA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA ARIZONA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ARKANSAS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA ARKANSAS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ARKANSAS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA ARKANSAS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA CALIFORNIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>First name</td> <td>Sometimes</td><tr>

<th colspan=2>USA CALIFORNIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA CALIFORNIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA CALIFORNIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA COLORADO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA COLORADO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA COLORADO ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA COLORADO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA CONNECTICUT DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA CONNECTICUT DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA CONNECTICUT ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA CONNECTICUT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA DELAWARE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA DELAWARE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA DISTRICT OF COLUMBIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA DISTRICT OF COLUMBIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA FLORIDA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA FLORIDA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA FLORIDA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA FLORIDA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA GEORGIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA GEORGIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA GEORGIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA GEORGIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA HAWAII DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA HAWAII DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA HAWAII ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA HAWAII ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA IDAHO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA IDAHO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA IDAHO ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA IDAHO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ILLINOIS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA ILLINOIS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ILLINOIS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA ILLINOIS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA INDIANA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA INDIANA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA INDIANA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA INDIANA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA IOWA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA IOWA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA KANSAS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA KANSAS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA KANSAS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA KANSAS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA KENTUCKY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA KENTUCKY DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA KENTUCKY ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA KENTUCKY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA LOUISIANA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA LOUISIANA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MAINE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA MAINE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MARYLAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA MARYLAND DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MARYLAND ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA MARYLAND ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MASSACHUSETTS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA MASSACHUSETTS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MASSACHUSETTS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA MASSACHUSETTS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MICHIGAN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA MICHIGAN DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MICHIGAN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA MICHIGAN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MINNESOTA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA MINNESOTA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MINNESOTA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA MINNESOTA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MISSISSIPPI DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA MISSISSIPPI DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MISSISSIPPI ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>USA MISSISSIPPI ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MISSOURI DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Race</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA MISSOURI DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MISSOURI ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA MISSOURI ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MONTANA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA MONTANA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MONTANA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA MONTANA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEBRASKA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>USA NEBRASKA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEVADA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA NEVADA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEVADA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NEVADA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW HAMPSHIRE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA NEW HAMPSHIRE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW JERSEY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA NEW JERSEY DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW JERSEY ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA NEW JERSEY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW MEXICO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA NEW MEXICO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW MEXICO ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA NEW MEXICO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW YORK DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA NEW YORK DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW YORK ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA NEW YORK ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW YORK CITY ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NEW YORK CITY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NORTH CAROLINA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>USA NORTH CAROLINA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NORTH CAROLINA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>USA NORTH CAROLINA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NORTH DAKOTA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA NORTH DAKOTA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA OHIO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>

<th colspan=2>USA OHIO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA OHIO ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA OHIO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA OKLAHOMA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA OKLAHOMA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA OKLAHOMA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA OKLAHOMA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA OREGON DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA OREGON DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA OREGON ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA OREGON ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA PENNSYLVANIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA PENNSYLVANIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA PENNSYLVANIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>USA PENNSYLVANIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA RHODE ISLAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA RHODE ISLAND DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA SOUTH CAROLINA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>USA SOUTH CAROLINA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA SOUTH DAKOTA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA SOUTH DAKOTA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA TENNESSEE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA TENNESSEE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA TEXAS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA TEXAS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA TEXAS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA TEXAS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA TEXAS WEAPON PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Sometimes</td><tr>

<th colspan=2>USA UTAH DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>

<th colspan=2>USA UTAH DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA VERMONT DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA VERMONT DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA VIRGINIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA VIRGINIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA VIRGINIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA VIRGINIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA WASHINGTON DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA WASHINGTON DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA WASHINGTON ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA WASHINGTON ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA WEST VIRGINIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA WEST VIRGINIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA WISCONSIN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA WISCONSIN DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA WISCONSIN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA WISCONSIN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA WYOMING DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA WYOMING DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>UZBEKISTAN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>VENEZUELA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>VENEZUELA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>


<th colspan=2>VENEZUELA PASSPORT</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>VIETNAM DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>VIETNAM ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>VIETNAM ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>


