package com.neo.helloWorld.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class User {
    @NotEmpty
    private String name;

    @Max(value = 100, message = "age shouldn't above 100 years old")
    @Min(value = 18, message = "age should over 18 years old")
    private int age;

    @NotEmpty(message = "password field cannot be empty")
    @Length(min=6, message="the length of password couldn't below 6")
    private String pass;

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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
