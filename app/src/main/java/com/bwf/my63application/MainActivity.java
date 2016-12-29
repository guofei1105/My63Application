package com.bwf.my63application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bwf.my63application.test.person.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        tv.setText(setTextMsg());
    }
    private String setTextMsg(){
        String result = null;
//        result = getfeild();
//        result = getMethod();
        result = getConstructor();
        return result;
    }


    //构造器的反射
    private String getConstructor(){
        String constructor = null;
        constructor = getConstructor1();

        return constructor;
    }
    private String getConstructor1(){
        StringBuffer msg = new StringBuffer();
        Class cls = Person.class;
        Constructor[] c = cls.getConstructors();
        for (int i = 0; i < c.length; i++) {
            msg.append("Person所有构造方法" + (i+1)+ ":" + c[i].getName() + "\n");
        }
        return msg.toString();
    }



    //method 方法的反射
    private String getMethod() {
        String foun = null;
        try {
//            foun = getMethod1();
//            foun = getMethod2();
//            foun = getMethod3();
//            foun = getMethod4();
//            foun = getMethod5();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return foun;
    }
    private String getMethod1() throws Exception {
        String msg = null;
        Class cls = Class.forName("com.bwf.my63application.test.person.Person");
        Method method = cls.getMethod("getTag",null);
        msg = "Person公共方法getTag："+method.getName();
        return msg;
    }
    private String getMethod2() throws Exception {
        String msg = null;
        Class cls = Class.forName("com.bwf.my63application.test.person.Person");
        Method method = cls.getDeclaredMethod("getAge",null);
        msg = "Person私有方法getAge："+method.getName();
        return msg;
    }
    private String getMethod3() throws Exception {
        StringBuffer msg = new StringBuffer();
        Class cls = Class.forName("com.bwf.my63application.test.person.Person");
        Method[] methods = cls.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            msg.append("Person所有方法" + (i+1)+ ":" + methods[i].getName() + "\n");
        }
        return msg.toString();
    }
    private String getMethod4() throws Exception {
        StringBuffer msg = new StringBuffer();
        Class cls = Class.forName("com.bwf.my63application.test.person.Person");
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; i++) {
            msg.append("Person所有继承的public方法" + (i+1)+ ":" + methods[i].getName() + "\n");
        }
        return msg.toString();
    }
    private String getMethod5() throws Exception {
        String msg = null;
        Class cls = Class.forName("com.bwf.my63application.test.person.Person");
        Person p = new Person();
        Method method = cls.getDeclaredMethod("setTag",String.class);
        method.setAccessible(true);
        method.invoke(p,"样式");
        msg = "Persond 的Tag："+p.getTag();
        return msg;
    }

//field 属性反射
    private String getfeild() {
        String feild = null;

        try {
//            result = getfeild1();
//            result = getfeild2();
//            result = getfeild3();
//            feild = getfeild4();
            feild = getfeild5();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return feild;
    }
    private String getfeild1(){
        StringBuffer msg = new StringBuffer();
        Class cls = Person.class;
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            msg.append("Person属性" +(i+1) + ":" + fields[i].getName() + "\n");
        }
        return msg.toString();
    }
    private String getfeild2(){
        StringBuffer msg = new StringBuffer();
        Class cls = Person.class;
        Field[] fields = cls.getFields();
        for (int i = 0; i < fields.length; i++) {
            msg.append("Person公共属性" +(i+1) + ":" + fields[i].getName() + "\n");
        }
        return msg.toString();
    }
    private String getfeild3() throws NoSuchFieldException {
        String msg = null;
        Class cls = Person.class;
        Field field = cls.getField("tag");
        msg = "Person公共属性tag:" + field.getName();
        return msg;
    }
    private String getfeild4() throws NoSuchFieldException {
        String msg = null;
        Class cls = Person.class;
        Field field = cls.getDeclaredField("name");
        msg = "Person私有属性name:" + field.getName();
        return msg;
    }
    private String getfeild5() throws Exception {
        String msg = null;
        Class cls = Person.class;
        Person p = new Person();
        Field field = cls.getDeclaredField("tag");
        field.setAccessible(true);
        field.set(p,"标签");
        msg = "Person 属性tag:" + p.getTag();
        return msg;
    }
}
