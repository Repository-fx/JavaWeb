package com.atguigu.json;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fxStart
 * @create 2022-10-26-19:06
 */
public class JsonTest {
    //javaBean和json的转换
    @Test
    public void test1(){
        Person person=new Person(1,"阿汤");
        //创建Gson对象实例
        Gson gson=new Gson();
        //toJson方法可以把java对象装换成json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);
    }

    //List和json的互转
    @Test
    public void test2(){
        List<Person> personList=new ArrayList<>();

        personList.add(new Person(1,"阿汤"));
        personList.add(new Person(2,"布克"));

        Gson gson=new Gson();
        //把List集合转成json字符串
        String personListJsonString = gson.toJson(personList);
        System.out.println(personListJsonString);
        //把json字符串转化成list集合
        List<Person> list = gson.fromJson(personListJsonString,new PersonListType().getType());
        System.out.println(list);

        Person person = list.get(0);
        System.out.println(person);
    }

    //map和json互换
    @Test
    public void test3(){
        Map<Integer,Person> personMap=new HashMap<>();

        personMap.put(1,new Person(1,"阿汤"));
        personMap.put(2,new Person(2,"布克"));

        Gson gson=new Gson();
        //把map集合转换成json字符串
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);
        //把json字符串转化成Map
        //自己写类
//        Map<Integer,Person>  personMap2 = gson.fromJson(personMapJsonString,new PersonMapType().getType());
        //匿名内部类
        Map<Integer,Person>  personMap2 = gson.fromJson(personMapJsonString,new TypeToken<HashMap<Integer,Person>>(){}.getType());
        System.out.println(personMap2);
    }
}
