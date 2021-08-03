package com.bean;

public class TaStudent {
    private int id;
    private String name;
    private int age;
    private String clazz;

    @Override
    public String toString() {
        return "TaStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", clazz='" + clazz + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
