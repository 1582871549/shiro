package com.meng.user.common.enums;

/**
 * 由于配置了4个文件存放不同日志，
 * <p>
 * 平台日志（${project.name}_platform.log）
 * 业务日志（${project.name}_bussiness.log）
 * 错误日志（${project.name}_exception.log）
 * DB 日志（${project.name}_db.log）
 * <p>
 * 文件夹外面为运行日志，不同文件日志级别不一样，
 * 在开发时候需要注意引入不同日志，
 * <p>
 * 也就是说开发出现的日志，可以进行分类，分别调用公共方法即可。
 */
public enum LogEnum {

    /**
     * 业务日志
     */
    BUSSINESS("bussiness"),

    /**
     * 平台日志
     */
    PLATFORM("platform"),

    /**
     * DB 日志
     */
    DB("db"),

    /**
     * 错误日志
     */
    EXCEPTION("exception");


    private String category;


    LogEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
