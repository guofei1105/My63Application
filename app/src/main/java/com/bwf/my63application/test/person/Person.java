package com.bwf.my63application.test.person;

/**
 * Created by Administrator on 2016/12/28.
 */

public class Person {
    private String name;
    private int age;
    private String tag;
    public int num;

    public Person() {
    }
    private Person(String name) {
    }

    private String getName() {
        return name;
    }

    private int getAge() {
        return age;
    }

    public String getTag() {
        return tag;
    }

    private void setTag(String tag){
        this.tag = tag;
    }
}
