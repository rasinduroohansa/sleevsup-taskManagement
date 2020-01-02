package com.biz.sleevsup.enums;

public enum TaskStatus {
    COMPLETED(0),
    PENDING(1);

    public int status;

    TaskStatus(int status) {
        this.status = status;
    }
}
