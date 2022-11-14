package com.atguigu.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author fxStart
 * @create 2022-09-29-17:32
 */
public class Person {
    private String name;
    private String[] phone;
    private List<String> city;
    private Map<String,Object> map;

    public Person() {
    }

    public Person(String name, String[] phone, List<String> city, Map<String, Object> map) {
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhone() {
        return phone;
    }

    public void setPhone(String[] phone) {
        this.phone = phone;
    }

    public List<String> getCity() {
        return city;
    }

    public void setCity(List<String> city) {
        this.city = city;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone=" + Arrays.toString(phone) +
                ", city=" + city +
                ", map=" + map +
                '}';
    }
}
