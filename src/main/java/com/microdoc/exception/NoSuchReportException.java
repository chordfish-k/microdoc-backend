package com.microdoc.exception;

/**
 * 账号被锁定异常
 */
public class NoSuchReportException extends BaseException {

    public NoSuchReportException() {
    }

    public NoSuchReportException(String msg) {
        super(msg);
    }

}
