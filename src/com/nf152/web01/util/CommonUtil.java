package com.nf152.web01.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
    public static String fmtTime (Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
}
