package com.urise.webapp;

public class MainString {
    public static void main(String[] args) {
        String[] strArray = new String[]{"1", "2", "3", "4", "5" };
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strArray) {
            stringBuilder.append(str).append(", ");
        }
        System.out.println(stringBuilder.toString());

        String str1 = "abc";
        String str3 = "c";
        String str2 = "abc" + str3;
        System.out.println(str1 = str2);
    }
}
