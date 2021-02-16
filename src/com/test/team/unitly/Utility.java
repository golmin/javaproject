package com.test.team.unitly;

import java.util.Scanner;

/**
 * Utility工具类：
 * 将不同的功能封装成方法，直接通过调用方法使用她的功能，而无需考虑具体的功能实现细节
 */

/*
用于界面菜单的选择，读取键盘输入值若非1-4则报错
 */
public class Utility {
    private static Scanner scanner=new Scanner(System.in);
    public static char readMenuSelection(){
        char c;
        for ( ; ; ){
            String str=readKeyBoard(1,true);
            c=str.charAt(0);
            if (c!='1'&&c!='2'&&c!='3'&&c!='4'){
                System.out.println("选择错误请重新输入");
            }else break;
        }
        return c;
    }

    /**
     * 提示并等待，直到用户按下回车键继续
     */
    public static void readReturn() {
        System.out.print("按回车键继续...");
        readKeyBoard(100, true);
    }
    /*
    用于收入和支出的金额的输入，从键盘读取一个不超过4位的整数，请将其作为返回值。
     */
    public static int readNumber(){
        int n;
        for ( ; ; ){
            String str=readKeyBoard(4,true);
            try{
                n=Integer.parseInt(str);
                break;
            } catch (NumberFormatException e){
                System.out.println("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(3,true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    /*
    用于收入和支出的说明，从键盘读取长度为8的字符串并将其作为返回值。
     */
    public static String readString(int limit){
        String str=readKeyBoard(limit,true);
        return str;
    }
    public static String readString(int limit,String defaultValue){
        String str=readKeyBoard(limit,true);
        return (str.length()==0)?defaultValue:str;
    }
    /**
     从键盘读取一个字符，并将其作为方法的返回值。
     如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1,true);
        if (str.length()!=0) {
            for (; ; ) {
                // String str=readKeyBoard(1,true);
                char ch = str.charAt(0);
                if (ch == '男' || ch == '女') {
                    break;
                } else {
                    System.out.println("请选择一个大众的性别");
                }
            }
        }
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }
    /*
    用于性别，从键盘读取长度为1的字符并将其作为返回值。
     */
    public static char readChar(){
        char ch;
        for (; ;){
            String str=readKeyBoard(1,true);
            ch=str.charAt(0);
            if (ch=='男'||ch=='女'){
                break;
            }else {
                System.out.println("请选择一个大众的性别");
            }
        }
        return ch;
    }
    /*
    用于确认选择的输入从键盘读取y或者n并将其转化为大写，作为返回值
     */
    public static char readConfirmSelection(){
        char c;
        for (; ; ){
            String str=readKeyBoard(1,true).toUpperCase();
            c=str.charAt(0);
            if (c=='Y'||c=='N'){
                break;
            }else {
                System.out.println("选择错误，请重新输入： ");
            }
        }
        return c;
    }
    /*
    从键盘输入一个不大于limit的字符串并将其作为方法的返回值
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }

}
