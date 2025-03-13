#!/bin/bash

source config.sh

for i in "${!LIB_NAMES[@]}"; do
    libName=${LIB_NAMES[$i]}
    libVersion=${LIB_VERSIONS[$i]}
    mvn install:install-file -Dfile="$libName-$libVersion.aar" -DpomFile=pom-$libName.xml -DcreateChecksum=true
done