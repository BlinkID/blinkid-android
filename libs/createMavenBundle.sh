#!/bin/bash

source config.sh

for i in "${!LIB_NAMES[@]}"; do
    libName=${LIB_NAMES[$i]}
    libVersion=${LIB_VERSIONS[$i]}

    tmpDir=./tmp-$libName
    tmpDest=$tmpDir/com/microblink/$libName/$libVersion

    mkdir -p $tmpDest
    cp $libName-$libVersion.aar $tmpDest/$libName-$libVersion.aar
    cp pom-$libName.xml $tmpDest/$libName-$libVersion.pom

    pushd $tmpDest > /dev/null
    md5 -q $libName-$libVersion.pom > $libName-$libVersion.pom.md5
    md5 -q $libName-$libVersion.aar > $libName-$libVersion.aar.md5
    shasum $libName-$libVersion.pom | cut -d ' ' -f 1 > $libName-$libVersion.pom.sha1
    shasum $libName-$libVersion.aar | cut -d ' ' -f 1 > $libName-$libVersion.aar.sha1
    gpg -ab $libName-$libVersion.pom
    gpg -ab $libName-$libVersion.aar
    popd > /dev/null

    (cd $tmpDir && zip -r ../$libName-$libVersion-maven-bundle.zip .)
    rm -r $tmpDir
done