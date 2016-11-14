#!/bin/bash

mvn install:install-file -Dfile=LibBlinkID.aar -DpomFile=pom.xml -DcreateChecksum=true -Djavadoc=LibBlinkID-javadoc.jar