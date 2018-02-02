package com.microblink.util;

import com.microblink.detectors.DecodingInfo;

import java.util.List;

/**
 * Utilities commonly used in templating API.
 */
public class TemplatingUtils {
    public static DecodingInfo[] listToArray(List<DecodingInfo> list) {
        DecodingInfo[] arr = new DecodingInfo[list.size()];
        list.toArray(arr);
        return arr;
    }
}
