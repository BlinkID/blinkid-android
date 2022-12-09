#!/bin/bash

if [[ $# < 4 ]]
then
  echo "Usage: $(basename "$0") <sdk_name> <path_to_project> <application_module_name> <output_markdown_file_path>"
  exit 1
fi

pushd `dirname $0` > /dev/null
SCRIPTPATH=`pwd -P`
popd > /dev/null

APKANALYZER=apkanalyzer
command -v $APKANALYZER > /dev/null || { APKANALYZER="${ANDROID_SDK_ROOT}/tools/bin/apkanalyzer"; }
command -v $APKANALYZER > /dev/null || { echo >&2 "Please set ANDROID_SDK_ROOT environment variable or add apkanalyzer (https://developer.android.com/studio/command-line/apkanalyzer) to PATH."; exit 1; }

SDK_NAME=$1
PROJECT_PATH=$2
APP_NAME=$3
OUTPUT_MARKDOWN_FILE=$4

echo "Project path: $PROJECT_PATH"
echo "App name: $APP_NAME"
echo "Output file: $OUTPUT_MARKDOWN_FILE"

ABIS=(armeabi-v7a arm64-v8a x86 x86_64)

pushd $PROJECT_PATH > /dev/null
./gradlew clean :$APP_NAME:assembleRelease || exit 1
pushd $APP_NAME/build/outputs/apk/release > /dev/null

OUTPUT="## $SDK_NAME"$' SDK size report
\nThis SDK size report is for all supported ABIs. We use the Android official [**apkanalyzer**](https://developer.android.com/studio/command-line/apkanalyzer) command line tool to calculate the sizes.
\n**NOTE**: Presented APK sizes are sums of the `base APK size` + `size of our SDK`. Roughly, the `base APK size` is about `1 MB`, which means that the APK size increase caused by our SDK in your application will be approximately `1 MB` less than presented.
\n| ABI | APK file size | APK download size |\n| --- |:-------------:| :----------------:|\n'

for abi in "${ABIS[@]}"; do
    F_SIZE=`$APKANALYZER -h apk file-size $APP_NAME-$abi-release.apk` || exit 1
    D_SIZE=`$APKANALYZER -h apk download-size $APP_NAME-$abi-release.apk` || exit 1
    echo "$abi APK File size is: $F_SIZE"
    echo "$abi APK Download size is: $D_SIZE"
    OUTPUT+=$"| $abi | $F_SIZE | $D_SIZE |"$'\n'
done

popd > /dev/null
popd > /dev/null

echo "$OUTPUT" > $OUTPUT_MARKDOWN_FILE