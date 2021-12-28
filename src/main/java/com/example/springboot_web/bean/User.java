package com.example.springboot_web.bean;

import sun.management.Agent;

import javax.naming.Name;

public class User {
    private String Name;
    private int Age;
    private Pet pet;

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                ", pet=" + pet +
                '}';
    }

    public User() {
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public User(String name, int age) {
        Name = name;
        Age = age;
    }
}
