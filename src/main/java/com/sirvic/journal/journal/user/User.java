package com.sirvic.journal.journal.user;

import java.time.LocalDate;

public class User {
    // Can use lombok to reduce the boilerplate codes
    private Long id;
    private String username;
    private String password;
    private String name;
    private String gender;
    private Integer age;
    private LocalDate birthdate;

    public User(){

    }

    public User(Long id,
                String username,
                String password,
                String name,
                String gender,
                Integer age,
                LocalDate birthdate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthdate = birthdate;
    }

    public User(String username,
                String password,
                String name,
                String gender,
                Integer age,
                LocalDate birthdate) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthdate = birthdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", birthdate=" + birthdate +
                '}';
    }
}
