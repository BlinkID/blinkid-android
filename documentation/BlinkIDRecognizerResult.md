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

<tr> <td>Address</td> <td>Sometimes</td><tr>

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


<th colspan=2>ALBANIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>ALBANIA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>ALGERIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>ALGERIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>ALGERIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>ALGERIA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>ARGENTINA Alien ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>ARGENTINA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>ARGENTINA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>ARGENTINA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>ARMENIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRALIA NEW SOUTH WALES Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRALIA NEW SOUTH WALES ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRALIA NORTHERN TERRITORY Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Sometimes</td><tr>
<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRALIA NORTHERN TERRITORY DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA QUEENSLAND Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Document additional number</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA SOUTH AUSTRALIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRALIA SOUTH AUSTRALIA Proof Of Age Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA TASMANIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA VICTORIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>Last name</td> <td>Sometimes</td><tr>


<th colspan=2>AUSTRALIA WESTERN AUSTRALIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>


<th colspan=2>AUSTRIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>AUSTRIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>AUSTRIA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>AZERBAIJAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>AZERBAIJAN Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>BAHRAIN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BANGLADESH Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>BANGLADESH ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>BANGLADESH ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>BANGLADESH Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>First name</td> <td>Sometimes</td><tr>

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


<th colspan=2>BELARUS Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>BELGIUM ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>BELGIUM Minors ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>BELGIUM Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>BELGIUM RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>BELGIUM Resident ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Residential status</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>BELGIUM RESIDENT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


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

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>BOLIVIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>BOLIVIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>BOLIVIA Minors ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>BOLIVIA MINORS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>BOSNIA AND HERZEGOVINA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>BOSNIA AND HERZEGOVINA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>BOTSWANA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>BRAZIL Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>BRAZIL Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>BRUNEI ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>BRUNEI Military ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>BRUNEI MILITARY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>


<th colspan=2>BRUNEI Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>BRUNEI Temporary Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>BULGARIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>


<th colspan=2>BULGARIA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>BURKINA FASO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Conditions</td> <td>Sometimes</td><tr>

<th colspan=2>CAMBODIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>CAMBODIA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CANADA Citizenship Certificate - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA CITIZENSHIP CERTIFICATE - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>CANADA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>CANADA Tribal ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Conditions</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA ALBERTA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA ALBERTA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA ALBERTA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA DL PUBLIC SERVICES CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>CANADA BRITISH COLUMBIA Public Services Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA BRITISH COLUMBIA PUBLIC SERVICES CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA MANITOBA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA MANITOBA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CANADA NEW BRUNSWICK DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CANADA NEWFOUNDLAND AND LABRADOR DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>CANADA NOVA SCOTIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA NOVA SCOTIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>CANADA ONTARIO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>CANADA ONTARIO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>

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

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA SASKATCHEWAN DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>CANADA SASKATCHEWAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA YUKON DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

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


<th colspan=2>CHILE ALIEN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<th colspan=2>CHILE ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Sometimes</td><tr>


<th colspan=2>CHILE Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CHINA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>


<th colspan=2>CHINA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>COLOMBIA Alien ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>COLOMBIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>COLOMBIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>COLOMBIA Minors ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>COLOMBIA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>COSTA RICA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>COSTA RICA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>


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


<th colspan=2>CROATIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>CROATIA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CROATIA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CYPRUS Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Address</td> <td>Sometimes</td><tr>

<th colspan=2>CZECHIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CZECHIA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>CZECHIA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>DEMOCRATIC REPUBLIC OF THE CONGO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>DENMARK RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>DENMARK Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>DOMINICAN REPUBLIC DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>DOMINICAN REPUBLIC ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


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


<th colspan=2>EGYPT Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>EGYPT DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>EGYPT ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>EGYPT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>


<th colspan=2>EGYPT Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Profession</td> <td>Sometimes</td><tr>

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


<th colspan=2>EL SALVADOR DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>EL SALVADOR ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<th colspan=2>ESTONIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>ESTONIA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>ESTONIA RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>ESWATINI Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>FINLAND ALIEN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>FINLAND ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>FINLAND Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>FINLAND RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>FINLAND Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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
<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>FRANCE ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>FRANCE Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>FRANCE RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


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


<th colspan=2>GEORGIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>GEORGIA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>
<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<th colspan=2>GERMANY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>


<th colspan=2>GERMANY Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>GERMANY Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>GHANA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>GHANA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>GREECE ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>GREECE Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>GREECE RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


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


<th colspan=2>GUATEMALA CONSULAR ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>GUATEMALA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>GUATEMALA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>GUATEMALA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>GUATEMALA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>HAITI ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>HAITI Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>HONDURAS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>


<th colspan=2>HONDURAS ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>HONDURAS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>HONDURAS Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Additional name information</td> <td>Sometimes</td><tr>

<th colspan=2>HONG KONG Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Additional address information</td> <td>Sometimes</td><tr>

<th colspan=2>HUNGARY ADDRESS CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>HUNGARY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Additional name information</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>HUNGARY Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<th colspan=2>HUNGARY RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


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


<th colspan=2>INDIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<th colspan=2>INDIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>


<th colspan=2>INDIA PAN Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<th colspan=2>INDIA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>INDIA KERALA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>

<th colspan=2>INDIA TAMIL NADU DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>


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

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

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


<th colspan=2>INDONESIA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Document optional additional number</td> <td>Sometimes</td><tr>

<th colspan=2>IRAN Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>IRAQ ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>IRAQ Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>IRELAND PASSPORT CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>IRELAND Public Services Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>IRELAND PUBLIC SERVICES CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>IRELAND Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>ISRAEL ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>ISRAEL Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Address</td> <td>Sometimes</td><tr>

<th colspan=2>ITALY ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>ITALY Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>ITALY RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>IVORY COAST Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>IVORY COAST ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>JAMAICA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>JAPAN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Sometimes</td><tr>

<th colspan=2>JAPAN Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>JORDAN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>JORDAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>JORDAN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>JORDAN Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>KAZAKHSTAN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

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


<th colspan=2>KENYA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>KENYA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Nationality</td> <td>Sometimes</td><tr>

<th colspan=2>KOSOVO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>KOSOVO Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Profession</td> <td>Sometimes</td><tr>

<th colspan=2>KUWAIT DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>KUWAIT ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>KUWAIT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>KUWAIT Resident ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>KYRGYZSTAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>LATVIA Alien ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>LATVIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>


<th colspan=2>LATVIA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>LATVIA RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>LATVIA Polycarbonate Alien Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>LATVIA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>LEBANON ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>


<th colspan=2>LIBYA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>LITHUANIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>LITHUANIA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>First name</td> <td>Sometimes</td><tr>

<th colspan=2>LUXEMBOURG ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>LUXEMBOURG Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>LUXEMBOURG RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


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


<th colspan=2>MALAYSIA Refugee ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MALAYSIA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Employer</td> <td>Sometimes</td><tr>
<tr> <td>Profession</td> <td>Sometimes</td><tr>

<th colspan=2>MALDIVES ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MALDIVES ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MALTA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>MALTA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>MALTA RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>MAURITIUS ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MAURITIUS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO CONSULAR ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO Professional DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MEXICO Voter ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document optional additional number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Fathers name</td> <td>Sometimes</td><tr>
<tr> <td>Mothers name</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO VOTER ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO BAJA CALIFORNIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO BAJA CALIFORNIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MEXICO BAJA CALIFORNIA SUR Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO BAJA CALIFORNIA SUR DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MEXICO CAMPECHE Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>
<tr> <td>Sex</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO CAMPECHE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO CHIAPAS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO CHIHUAHUA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MEXICO COAHUILA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MEXICO COLIMA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO COLIMA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


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

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO GUANAJUATO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO GUERRERO-COCULA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>MEXICO GUERRERO-COCULA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>


<th colspan=2>MEXICO GUERRERO-JUCHITAN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO GUERRERO-JUCHITAN DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MEXICO HIDALGO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>


<th colspan=2>MEXICO JALISCO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MEXICO MEXICO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MEXICO MICHOACAN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MEXICO MORELOS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

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


<th colspan=2>MEXICO NAYARIT DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MEXICO NUEVO LEON Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MEXICO OAXACA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MEXICO PUEBLA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO PUEBLA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Nationality</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO SAN LUIS POTOSI Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

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

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

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


<th colspan=2>MEXICO SONORA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MEXICO TABASCO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>


<th colspan=2>MEXICO TAMAULIPAS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MEXICO VERACRUZ Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>MEXICO VERACRUZ DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO YUCATAN Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MEXICO ZACATECAS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MOLDOVA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>


<th colspan=2>MOLDOVA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MONTENEGRO Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<th colspan=2>MOROCCO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>


<th colspan=2>MOROCCO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>MOROCCO Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

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


<th colspan=2>MYANMAR Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>MYANMAR DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>NEPAL Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<th colspan=2>NETHERLANDS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>


<th colspan=2>NETHERLANDS ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>NETHERLANDS Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>NETHERLANDS RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>NETHERLANDS Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Address</td> <td>Sometimes</td><tr>
<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>NEW ZEALAND Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>NICARAGUA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>NIGERIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>NIGERIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>NIGERIA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>NIGERIA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>NIGERIA VOTER ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>NORTH MACEDONIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>NORTH MACEDONIA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>NORWAY Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>NORWAY RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>NORWAY Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>OMAN DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>OMAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>OMAN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>OMAN Resident ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>OMAN RESIDENT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>PAKISTAN Consular ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>PAKISTAN ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>PAKISTAN Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>

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


<th colspan=2>PANAMA Temporary Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>PANAMA TEMPORARY RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>


<th colspan=2>PARAGUAY Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>PARAGUAY DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>PARAGUAY ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>PERU Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>PERU ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>PERU Minors ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PERU MINORS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>


<th colspan=2>PHILIPPINES Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Sometimes</td><tr>

<th colspan=2>PHILIPPINES Multipurpose ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PHILIPPINES Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>


<th colspan=2>PHILIPPINES Social Security Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>

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


<th colspan=2>POLAND ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>POLAND Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>POLAND RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>


<th colspan=2>POLAND Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Address</td> <td>Sometimes</td><tr>

<th colspan=2>PORTUGAL ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>PORTUGAL ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>PORTUGAL Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>PORTUGAL RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>PUERTO RICO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>QATAR Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>QATAR RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>

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

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>ROMANIA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>RUSSIA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SAUDI ARABIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<th colspan=2>SAUDI ARABIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>

<th colspan=2>SAUDI ARABIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>SAUDI ARABIA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<th colspan=2>SENEGAL ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


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


<th colspan=2>SERBIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>SERBIA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<th colspan=2>SINGAPORE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE Employment Pass - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Employer</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>Profession</td> <td>Sometimes</td><tr>

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


<th colspan=2>SINGAPORE ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SINGAPORE RESIDENT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SINGAPORE S PASS - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SINGAPORE Work Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>
<tr> <td>MRZ</td> <td>Sometimes</td><tr>

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


<th colspan=2>SLOVAKIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>SLOVAKIA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SLOVAKIA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SLOVENIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>SLOVENIA Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SLOVENIA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SOUTH AFRICA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>SOUTH AFRICA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Conditions</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>

<th colspan=2>SOUTH KOREA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>SOUTH KOREA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>

<th colspan=2>SPAIN Alien ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SPAIN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>SPAIN Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<th colspan=2>SPAIN Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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
<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>SPAIN RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>


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


<th colspan=2>SRI LANKA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Profession</td> <td>Sometimes</td><tr>

<th colspan=2>SUDAN Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SWEDEN Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>SWEDEN RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>SWEDEN Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SWEDEN Social Security Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>SWITZERLAND ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SWITZERLAND Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>SWITZERLAND RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>SYRIA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>TAJIKISTAN Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>TANZANIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>THAILAND DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>


<th colspan=2>THAILAND ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>THAILAND ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>


<th colspan=2>THAILAND Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>TRINIDAD AND TOBAGO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>


<th colspan=2>TUNISIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>TUNISIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>TUNISIA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>TURKEY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>TURKEY Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Address</td> <td>Sometimes</td><tr>

<th colspan=2>TURKEY Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>UAE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>


<th colspan=2>UAE ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>UAE ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>UAE Resident ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>UAE RESIDENT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


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


<th colspan=2>UGANDA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>UK Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>UK Residence Permit - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>UK RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>


<th colspan=2>UK Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>
<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>UKRAINE ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>UKRAINE Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<th colspan=2>URUGUAY ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>
<tr> <td>Nationality</td> <td>Sometimes</td><tr>
<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>URUGUAY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Sometimes</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>


<th colspan=2>USA Border Crossing Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA Global Entry Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA Green Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA GREEN CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>


<th colspan=2>USA Military ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Employer</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Additional name information</td> <td>Sometimes</td><tr>

<th colspan=2>USA MILITARY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document optional additional number</td> <td>Sometimes</td><tr>


<th colspan=2>USA Nexus Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<th colspan=2>USA Veteran ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


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


<th colspan=2>USA WORK PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA ALABAMA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA ALABAMA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ALASKA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA ALASKA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA ALASKA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ARIZONA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA ARIZONA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA ARKANSAS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA ARKANSAS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA ARKANSAS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>First name</td> <td>Sometimes</td><tr>

<th colspan=2>USA CALIFORNIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA CALIFORNIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA COLORADO Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA COLORADO ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA CONNECTICUT DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA CONNECTICUT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA DELAWARE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA DISTRICT OF COLUMBIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA FLORIDA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA FLORIDA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA GEORGIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA GEORGIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA HAWAII DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA HAWAII ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA IDAHO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA IDAHO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA ILLINOIS Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA ILLINOIS ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA INDIANA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA INDIANA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA IOWA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA IOWA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA KANSAS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA KANSAS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA KENTUCKY DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA KENTUCKY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA LOUISIANA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA LOUISIANA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA MAINE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MARYLAND Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA MARYLAND DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MARYLAND ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA MASSACHUSETTS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA MASSACHUSETTS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA MICHIGAN DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA MICHIGAN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MINNESOTA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA MINNESOTA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA MISSISSIPPI Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA MISSISSIPPI ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA MISSISSIPPI ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Race</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA MISSOURI DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA MISSOURI ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA MONTANA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA MONTANA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEBRASKA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>Restrictions</td> <td>Sometimes</td><tr>
<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<th colspan=2>USA NEBRASKA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA NEVADA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA NEVADA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW HAMPSHIRE Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA NEW JERSEY Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA NEW JERSEY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA NEW MEXICO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA NEW MEXICO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA NEW YORK DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA NEW YORK ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NEW YORK CITY ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NEW YORK CITY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>USA NORTH CAROLINA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA NORTH CAROLINA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NORTH CAROLINA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA NORTH DAKOTA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>

<th colspan=2>USA OHIO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>USA OHIO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA OKLAHOMA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA OKLAHOMA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA OREGON Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA OREGON ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA PENNSYLVANIA Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA PENNSYLVANIA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA RHODE ISLAND Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA RHODE ISLAND ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA RHODE ISLAND ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>
<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>USA SOUTH CAROLINA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA SOUTH CAROLINA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>
<tr> <td>Full name</td> <td>Sometimes</td><tr>
<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>USA SOUTH CAROLINA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA SOUTH DAKOTA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA TENNESSEE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA TEXAS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA TEXAS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>

<th colspan=2>USA UTAH DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA UTAH ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA VERMONT DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA VIRGINIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA VIRGINIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Barcode data</td> <td>Pending</td><tr>

<th colspan=2>USA WASHINGTON Driving Licence - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<th colspan=2>USA WASHINGTON ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA WEST VIRGINIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA WISCONSIN DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA WISCONSIN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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


<th colspan=2>USA WYOMING DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>


<th colspan=2>UZBEKISTAN Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>VENEZUELA ID Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>


<th colspan=2>VENEZUELA Polycarbonate Passport - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

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

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>VIETNAM ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>


<th colspan=2>ZIMBABWE Paper Passport</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
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

<tr> <td>Profession</td> <td>Sometimes</td><tr>

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

<tr> <td>Sex</td> <td>Sometimes</td><tr>

<th colspan=2>CANADA QUEBEC Health Insurance Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>
<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<th colspan=2>CROATIA Health Insurance Card - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Additional personal id number</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


