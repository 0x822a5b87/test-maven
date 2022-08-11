package com.xxx;


import com.google.common.base.CaseFormat;
import com.google.common.base.Splitter;

import java.util.Map;

/**
 * @author 0x822a5b87
 */
public class ShadeApplication {
    private CaseFormat caseFormat;

    public ShadeApplication() {
        this.caseFormat = CaseFormat.LOWER_UNDERSCORE;
    }

    public Map<String, String> shadeCaseFormat(String message) {
        Splitter.MapSplitter ms  = Splitter.on("&").withKeyValueSeparator("=");
        Map<String, String>  map = ms.split(message);
        return map;
    }
}
