package com.meng.shiro.exception;

import com.meng.shiro.enums.ReturnCodeEnum;

/**
 * 全局异常处理类
 * 处理所有业务异常
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 610381362157914886L;

    private int code;

    public BusinessException() {
    }

    public BusinessException(int code) {
        super(ReturnCodeEnum.getNameByCode(code));
        this.code = code;
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(int code, Throwable cause) {
        super(ReturnCodeEnum.getNameByCode(code), cause);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getCode() {
        return code;
    }
}
