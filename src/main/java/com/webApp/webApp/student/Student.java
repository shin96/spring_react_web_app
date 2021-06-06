package com.webApp.webApp.student;

import java.util.UUID;

public class Student {

    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private final UUID studentId;
    private final String email;

    enum Gender {
        MALE, FEMALE
    }

    public Student(String firstName, String lastName, Gender gender, UUID studentId, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.studentId = studentId;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public UUID getStudentId() {
        return studentId;
    }
}
