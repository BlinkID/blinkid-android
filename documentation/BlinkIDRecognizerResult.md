<p align="justify">
The tables below represent scanning results for each document in each country supported in BlinkID v5. The fields marked as "Always" present are mandatory on all document versions and will always be a part of the result set. The ones marked as "Sometimes" present will be returned only if they exist on the specific document being scanned. For barcode-only document sides, the "Pending" stands for those fields for which it's not certain whether or not they're present on all document versions.
<br>
<br>
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
With the <strong>result anonymization option</strong> enabled, results are not returned for protected fields on documents listed here. The full document image will also have this data blacked out.
<br>
Protected fields are:
<ul>
<li>Document number on Hong Kong ID</li>
<li>MRZ on Hong Kong passports</li>
<li>Personal ID number on Netherlands DL</li>
<li>Personal ID number and MRZ on Netherlands ID</li>
<li>MRZ on Netherlands passports</li>
<li>Document number on Singapore DL, ID, Fin Card, Resident ID</li>
<li>Personal ID number on Singapore Employment Pass</li>
<li>Document number and personal ID number on Singapore Work Permit</li>
<li>MRZ on Singapore passports.</li>
</ul>
<br>
<table><tr>

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

<th colspan=2>ARGENTINA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

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

<th colspan=2>AUSTRALIA AUSTRALIAN CAPITAL TERRITORY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRALIA NEW SOUTH WALES DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

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

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Sometimes</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>


<th colspan=2>AUSTRALIA NORTHERN TERRITORY DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<th colspan=2>AUSTRALIA QUEENSLAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Sometimes</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>


<th colspan=2>AUSTRALIA QUEENSLAND DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<th colspan=2>AUSTRALIA SOUTH AUSTRALIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRALIA TASMANIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<th colspan=2>AUSTRALIA VICTORIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>AUSTRALIA VICTORIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>Last name</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRALIA WESTERN AUSTRALIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>


<th colspan=2>AUSTRALIA WESTERN AUSTRALIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<th colspan=2>AUSTRIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

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

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<th colspan=2>BAHRAIN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>


<th colspan=2>BAHRAIN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<th colspan=2>BANGLADESH ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>


<th colspan=2>BANGLADESH ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<th colspan=2>BELGIUM DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<th colspan=2>BELGIUM ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>BELGIUM ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

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

<th colspan=2>BOSNIA AND HERZEGOVINA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

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

<th colspan=2>BRAZIL DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


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

<tr> <td>Vehicle class</td> <td>Always</td><tr>

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

<th colspan=2>CAMBODIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<th colspan=2>CANADA ALBERTA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Sometimes</td><tr>


<th colspan=2>CANADA ALBERTA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>CANADA ALBERTA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA ALBERTA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>CANADA BRITISH COLUMBIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA DL PUBLIC SERVICES CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>CANADA BRITISH COLUMBIA DL PUBLIC SERVICES CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA BRITISH COLUMBIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>CANADA BRITISH COLUMBIA PUBLIC SERVICES CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA BRITISH COLUMBIA PUBLIC SERVICES CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>CANADA MANITOBA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>CANADA MANITOBA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>CANADA NEW BRUNSWICK DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA NEW BRUNSWICK DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>CANADA NOVA SCOTIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>CANADA NOVA SCOTIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>CANADA ONTARIO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>CANADA ONTARIO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>CANADA QUEBEC DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Conditions</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>


<th colspan=2>CANADA QUEBEC DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>CANADA SASKATCHEWAN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>


<th colspan=2>CANADA SASKATCHEWAN DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>CANADA YUKON DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>CANADA YUKON DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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

<th colspan=2>COLOMBIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>

<tr> <td>Full name</td> <td>Sometimes</td><tr>

<tr> <td>Issuing authority</td> <td>Sometimes</td><tr>

<tr> <td>Last name</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>COLOMBIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

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

<th colspan=2>COSTA RICA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

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
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<th colspan=2>CROATIA HEALTH INSURANCE CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Additional personal ID number</td> <td>Always</td><tr>

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

<th colspan=2>CYPRUS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

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

<th colspan=2>CZECHIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

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

<tr> <td>Marital status</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>DENMARK DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

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

<th colspan=2>ECUADOR ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<th colspan=2>EGYPT ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>


<th colspan=2>EGYPT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

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

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<th colspan=2>ESTONIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

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

<th colspan=2>FINLAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

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

<th colspan=2>FRANCE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

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
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

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

<th colspan=2>GERMANY RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>GERMANY RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<th colspan=2>GHANA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<th colspan=2>GREECE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<th colspan=2>GUATEMALA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>HONG KONG ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Residential status</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Additional name information</td> <td>Sometimes</td><tr>

<th colspan=2>HUNGARY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<th colspan=2>HUNGARY ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>

<tr> <td>Nationality</td> <td>Sometimes</td><tr>

<tr> <td>Sex</td> <td>Sometimes</td><tr>


<th colspan=2>HUNGARY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

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

<th colspan=2>INDONESIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Profession</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

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

<th colspan=2>IRELAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<th colspan=2>ISRAEL DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<th colspan=2>ITALY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

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

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>MRZ</td> <td>Sometimes</td><tr>

<tr> <td>Nationality</td> <td>Sometimes</td><tr>

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

<tr> <td>Full name</td> <td>Sometimes</td><tr>


<th colspan=2>KUWAIT RESIDENT ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

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

<tr> <td>Sex</td> <td>Always</td><tr>

<th colspan=2>LITHUANIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

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

<th colspan=2>MALAYSIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<th colspan=2>MALAYSIA MyKad - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Religion</td> <td>Sometimes</td><tr>


<th colspan=2>MALAYSIA MyKad - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

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

<th colspan=2>MALAYSIA MyPR - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Religion</td> <td>Sometimes</td><tr>

<th colspan=2>MALAYSIA MyTentera - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Religion</td> <td>Sometimes</td><tr>


<th colspan=2>MALAYSIA MyTentera - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

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

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

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

<th colspan=2>MAURITIUS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

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

<th colspan=2>MEXICO VOTER ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Sometimes</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>


<th colspan=2>MEXICO VOTER ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<th colspan=2>MOROCCO ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>MOROCCO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<th colspan=2>NETHERLANDS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>


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

<th colspan=2>NEW ZEALAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<th colspan=2>NIGERIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

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

<th colspan=2>NORWAY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Sometimes</td><tr>

<th colspan=2>OMAN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>OMAN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

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

<th colspan=2>PANAMA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<th colspan=2>PANAMA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

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

<tr> <td>Marital status</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

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

<th colspan=2>POLAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

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

<th colspan=2>PORTUGAL DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Address</td> <td>Sometimes</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

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

<th colspan=2>ROMANIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<th colspan=2>ROMANIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<th colspan=2>RUSSIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<th colspan=2>SAUDI ARABIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Full name</td> <td>Sometimes</td><tr>


<th colspan=2>SAUDI ARABIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<th colspan=2>SERBIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<th colspan=2>SERBIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>


<th colspan=2>SERBIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<th colspan=2>SINGAPORE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<th colspan=2>SINGAPORE EMPLOYMENT PASS - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Employer</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Document number</td> <td>Sometimes</td><tr>

<tr> <td>Personal ID number</td> <td>Sometimes</td><tr>

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
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>

<tr> <td>Document additional number</td> <td>Sometimes</td><tr>

<th colspan=2>SLOVAKIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Nationality</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>


<th colspan=2>SLOVAKIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<th colspan=2>SLOVENIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

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

<th colspan=2>SOUTH AFRICA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

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

<th colspan=2>SPAIN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

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

<th colspan=2>SRI LANKA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>SRI LANKA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<th colspan=2>SWEDEN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document additional number</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

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
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

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

<th colspan=2>TAIWAN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<th colspan=2>THAILAND ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<th colspan=2>TUNISIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<th colspan=2>TURKEY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Personal ID number</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

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

<tr> <td>MRZ</td> <td>Always</td><tr>

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

<th colspan=2>UK DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<th colspan=2>UK RESIDENCE PERMIT - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Issuing authority</td> <td>Always</td><tr>


<th colspan=2>UK RESIDENCE PERMIT - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>MRZ</td> <td>Always</td><tr>

<tr> <td>Place of birth</td> <td>Always</td><tr>

<th colspan=2>USA ALABAMA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>USA ALABAMA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA ALASKA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA ALASKA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA ALASKA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA ALASKA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA ARIZONA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

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


<th colspan=2>USA ARIZONA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA ARIZONA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<tr> <td>Date of expiry</td> <td>Sometimes</td><tr>


<th colspan=2>USA ARIZONA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA ARKANSAS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>USA ARKANSAS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA CALIFORNIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>


<th colspan=2>USA CALIFORNIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA COLORADO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

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


<th colspan=2>USA COLORADO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA CONNECTICUT DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA CONNECTICUT DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA DELAWARE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA DELAWARE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA DISTRICT OF COLUMBIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA DISTRICT OF COLUMBIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA FLORIDA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

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


<th colspan=2>USA FLORIDA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA GEORGIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA GEORGIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA GEORGIA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA GEORGIA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA HAWAII DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA HAWAII DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA IDAHO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA IDAHO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA ILLINOIS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

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


<th colspan=2>USA ILLINOIS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA ILLINOIS ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>

<tr> <td>Full name</td> <td>Sometimes</td><tr>

<tr> <td>Last name</td> <td>Sometimes</td><tr>


<th colspan=2>USA ILLINOIS ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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


<th colspan=2>USA INDIANA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA IOWA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA IOWA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA KANSAS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA KANSAS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA KENTUCKY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA KENTUCKY DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA LOUISIANA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

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


<th colspan=2>USA LOUISIANA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA MAINE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>USA MAINE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA MARYLAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

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


<th colspan=2>USA MARYLAND DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA MASSACHUSETTS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA MASSACHUSETTS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA MICHIGAN ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA MICHIGAN ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA MINNESOTA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>

<tr> <td>Full name</td> <td>Sometimes</td><tr>

<tr> <td>Last name</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>USA MINNESOTA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA MISSISSIPPI DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

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


<th colspan=2>USA MISSISSIPPI DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA MISSOURI DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA MISSOURI DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA MONTANA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA MONTANA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA NEBRASKA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NEBRASKA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA NEVADA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NEVADA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA NEW HAMPSHIRE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>

<tr> <td>Full name</td> <td>Sometimes</td><tr>

<tr> <td>Last name</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>USA NEW HAMPSHIRE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA NEW JERSEY DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

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


<th colspan=2>USA NEW JERSEY DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA NEW JERSEY ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>USA NEW JERSEY ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA NEW MEXICO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NEW MEXICO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA NEW YORK DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NEW YORK DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA NEW YORK ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NEW YORK ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA NORTH CAROLINA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>

<tr> <td>Full name</td> <td>Sometimes</td><tr>

<tr> <td>Last name</td> <td>Sometimes</td><tr>


<th colspan=2>USA NORTH CAROLINA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA NORTH CAROLINA ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NORTH CAROLINA ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA NORTH DAKOTA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA NORTH DAKOTA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA OHIO DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>


<th colspan=2>USA OHIO DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA OHIO ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>USA OHIO ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA OKLAHOMA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA OKLAHOMA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA OREGON DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Sometimes</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>USA OREGON DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA OREGON ID - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Sometimes</td><tr>


<th colspan=2>USA OREGON ID - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA PENNSYLVANIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

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


<th colspan=2>USA PENNSYLVANIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA RHODE ISLAND DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

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


<th colspan=2>USA RHODE ISLAND DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA SOUTH CAROLINA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>

<tr> <td>First name</td> <td>Sometimes</td><tr>

<tr> <td>Full name</td> <td>Sometimes</td><tr>

<tr> <td>Last name</td> <td>Sometimes</td><tr>


<th colspan=2>USA SOUTH CAROLINA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA SOUTH DAKOTA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA SOUTH DAKOTA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA TENNESSEE DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA TENNESSEE DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA TEXAS DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA TEXAS DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA UTAH DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Sometimes</td><tr>


<th colspan=2>USA UTAH DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA VERMONT DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA VERMONT DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA VIRGINIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA VIRGINIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

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
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA WEST VIRGINIA DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA WEST VIRGINIA DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA WISCONSIN DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA WISCONSIN DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA WYOMING DL - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>


<th colspan=2>USA WYOMING DL - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Pending</td><tr>

<tr> <td>Date of birth</td> <td>Pending</td><tr>

<tr> <td>Date of expiry</td> <td>Pending</td><tr>

<tr> <td>Date of issue</td> <td>Pending</td><tr>

<tr> <td>Document number</td> <td>Pending</td><tr>

<tr> <td>Endorsements</td> <td>Pending</td><tr>

<tr> <td>Restrictions</td> <td>Pending</td><tr>

<tr> <td>Vehicle class</td> <td>Pending</td><tr>

<tr> <td>First name</td> <td>Pending</td><tr>

<tr> <td>Full name</td> <td>Pending</td><tr>

<tr> <td>Last name</td> <td>Pending</td><tr>

<tr> <td>Sex</td> <td>Pending</td><tr>

<th colspan=2>USA SOCIAL SECURITY CARD - Front</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Sometimes</td><tr>


<th colspan=2>USA SOCIAL SECURITY CARD - Back</th> </tr> <tr><th>Field</th><th>Presence</th> </tr>
<tr> <td>Address</td> <td>Always</td><tr>

<tr> <td>Date of birth</td> <td>Always</td><tr>

<tr> <td>Date of expiry</td> <td>Always</td><tr>

<tr> <td>Date of issue</td> <td>Always</td><tr>

<tr> <td>Document number</td> <td>Always</td><tr>

<tr> <td>Endorsements</td> <td>Always</td><tr>

<tr> <td>Restrictions</td> <td>Always</td><tr>

<tr> <td>Vehicle class</td> <td>Always</td><tr>

<tr> <td>First name</td> <td>Always</td><tr>

<tr> <td>Full name</td> <td>Always</td><tr>

<tr> <td>Last name</td> <td>Always</td><tr>

<tr> <td>Sex</td> <td>Always</td><tr>

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

