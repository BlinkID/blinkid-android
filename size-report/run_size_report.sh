#!/bin/bash

pushd `dirname $0` > /dev/null
SCRIPTPATH=`pwd -P`
popd > /dev/null

$SCRIPTPATH/script/size_report.sh "BlinkID" $SCRIPTPATH/../BlinkIDSample BlinkID-aMinimalSample $SCRIPTPATH/sdk_size_report.md
