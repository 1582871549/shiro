package com.meng.user.common.enums;

/**
 * @author 大橙子
 * 定义系统常用状态值
 */
public enum ReturnCodeEnum {

    ERROR(9000, "失败"),
    SUCCESS(9001, "成功"),

    UNKNOWN_REASON(9999, "未知错误");

    private int code;
    private String name;

    ReturnCodeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(int code) {
        for (ReturnCodeEnum enuma : values()) {
            if (code == enuma.getCode()) {
                return enuma.getName();
            }
        }
        return "unknown enum";
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
