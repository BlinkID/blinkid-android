#!/bin/bash

if [[ $# < 4 ]]
then
  echo "Usage: $(basename "$0") <sdk_name> <path_to_project> <application_module_name> <output_markdown_file_path>"
  exit 1
fi

pushd `dirname $0` > /dev/null
SCRIPTPATH=`pwd -P`
popd > /dev/null

hash apkanalyzer 2>/dev/null || { echo >&2 "apkanalyzer must be on path. Aborting. Please install `https://developer.android.com/studio/command-line/apkanalyzer` and add it to path."; exit 1; }

SDK_NAME=$1
PROJECT_PATH=$2
APP_NAME=$3
OUTPUT_MARKDOWN_FILE=$4

echo "Project path: $PROJECT_PATH"
echo "App name: $APP_NAME"
echo "Output file: $OUTPUT_MARKDOWN_FILE"

ABIS=(armeabi-v7a arm64-v8a x86 x86_64)

pushd $PROJECT_PATH > /dev/null
./gradlew clean :$APP_NAME:assembleRelease
pushd $APP_NAME/build/outputs/apk/release > /dev/null

OUTPUT="## $SDK_NAME"$' SDK size report
\nThis is SDK size report for all supported ABIs. Sizes are calculated by using Android official [**apkanalyzer**](https://developer.android.com/studio/command-line/apkanalyzer) command line tool.
\n**NOTE**: Presented APK sizes are sums of `base APK size` + `size of our SDK`. Roughly, `base APK size` is about `1MB`, which means that APK size increase caused by our SDK in your application will be less than presented for approximately `1MB`.
\n| ABI | APK file size | APK download size |\n| --- |:-------------:| :----------------:|\n'

for abi in "${ABIS[@]}"; do
    F_SIZE=`apkanalyzer -h apk file-size $APP_NAME-$abi-release.apk`
    D_SIZE=`apkanalyzer -h apk download-size $APP_NAME-$abi-release.apk`
    echo "$abi APK File size is: $F_SIZE"
    echo "$abi APK Download size is: $D_SIZE"
    OUTPUT+=$"| $abi | $F_SIZE | $D_SIZE |"$'\n'
done

popd > /dev/null
popd > /dev/null



echo "$OUTPUT" > $OUTPUT_MARKDOWN_FILE

