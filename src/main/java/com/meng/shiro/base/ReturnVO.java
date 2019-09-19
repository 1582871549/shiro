package com.meng.shiro.base;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

@Data
public class ReturnVO<T> implements Serializable {

    private static final long serialVersionUID = 3695513906730758767L;

    @JSONField(
            ordinal = 1
    )
    private int code;
    @JSONField(
            ordinal = 2
    )
    private String message;
    @JSONField(
            ordinal = 3
    )
    private T data;
    @JSONField(
            ordinal = 4
    )
    private int total;

    public ReturnVO(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
        this.total = 0;
    }

    public ReturnVO(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = 0;
    }

    public ReturnVO(int code, String message, T data, int total) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = total;
    }
}