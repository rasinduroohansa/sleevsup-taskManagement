package com.biz.sleevsup.utilites;

public class Validation {

    public static Boolean validateTaskName(String taskName) {
        if (taskName == null || taskName.isEmpty() || taskName.length() > 240)
            return false;
        return true;
    }
}
