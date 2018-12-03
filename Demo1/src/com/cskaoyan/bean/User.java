package com.cskaoyan.bean;

public class User {
    String username;
    String password;
    String id;
    String email;
    String gender;
    int age;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUsername() {
        System.out.println("get方法");
        return username;
    }

    public void setUsername(String username) {
        System.out.println("set方法");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String username, String password, String id, String email, String gender, int age) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public User() {
    }
}
