package com.meng.user.common.enums;

public enum PermissionTypeEnum {

    DIRECTORY(0, "目录"),
    MENU(1, "菜单"),
    BUTTON(2, "按钮"),

    ;

    private int type;
    private String desc;


    PermissionTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
