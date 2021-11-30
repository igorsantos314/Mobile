package com.example.listapersonalizada;

public class Person {
    String firstName;
    String lastName;
    int age;
    String status;

    public Person(String firstName, String lastName, int age, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.status = status;
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

    public int getAge() {
        return age;
    }

    public String getStatus() {
        return status;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName;
    }
}
