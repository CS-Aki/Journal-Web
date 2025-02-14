package com.sirvic.journal.journal.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity(name = "Users")
@Table(
        name= "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "username_unique", columnNames = "username")
        }
)
public class Users {
    // Can use lombok to reduce the boilerplate codes
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize =  1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    @Column(
            name="id",
            updatable = false
    )
    private Long id;
    @Column(
            name="username",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String username;
    @Column(
            name="password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;
    @Column(
            name="first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name="last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Column(
            name="gender",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String gender;
    @Transient
    @Column(
            name="age",
            nullable = false
    )
    private Integer age;
    @Column(
            name="birth_date",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private LocalDate birthdate;

    public Users(){

    }

    public Users(Long id,
                 String username,
                 String password,
                 String firstName,
                 String lastName,
                 String gender,
                 LocalDate birthdate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public Users(String username,
                 String password,
                 String firstName,
                 String lastName,
                 String gender,
                 LocalDate birthdate) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return Period.between(this.birthdate, LocalDate.now()).getYears();
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
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", birthdate=" + birthdate +
                '}';
    }
}
