package com.test.team.service;

/**
 * 枚举类：对象仅有这几个,三个单例
 * 表示员工的三种状态
 * BUZY：忙碌
 * FREE：空闲
 * VOCATION：休假
 */
//public class Status {
//    private final String NAME;
//    private Status(String name) {
//        this.NAME=name;
//    }
//    public static final Status FREE=new Status("FREE");
//    public static final Status BUZY=new Status("BUZY");
//    public static final Status VOCATION=new Status("VOCATION");
//
//    public String getNAME() {
//        return NAME;
//    }
//}
public enum Status{
    FREE("FREE"),
    BUZY("BUZY"),
    VOCATION("VOCATION");

    private final String NAME;

    private Status(String name) {
        this.NAME=name;
    }
        public String getNAME() {
        return NAME;
    }
}