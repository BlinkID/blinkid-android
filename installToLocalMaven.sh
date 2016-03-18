#!/bin/bash

mvn install:install-file -Dfile=LibRecognizer.aar -DpomFile=pom.xml -DcreateChecksum=true -Djavadoc=LibRecognizer-javadoc.jar