package com.biz.sleevsup.utilites;

public enum ResponseCodes {
    SUCCESSFUL(200),
    FAIL(406),
    SERVERERROR(500);
    public final int code;

    ResponseCodes(int code){this.code=code;}
}
