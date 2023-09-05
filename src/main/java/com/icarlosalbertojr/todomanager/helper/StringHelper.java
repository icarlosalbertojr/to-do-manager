package com.icarlosalbertojr.todomanager.helper;

import static org.springframework.util.StringUtils.hasText;

public class StringHelper {

    public static String updateIfChanged(String current, String toChange) {
        return hasText(toChange) && !toChange.equals(current) ? toChange : current;
    }

}
