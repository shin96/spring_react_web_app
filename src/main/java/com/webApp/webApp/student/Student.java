package com.webApp.webApp.student;

import java.util.UUID;

public class Student {

    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private final UUID studentId;

    private final String student_email;



    public enum Gender {
        MALE, FEMALE;
    }
    public Student(String firstName, String lastName, Gender gender, UUID studentId, String student_email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.studentId = studentId;
        this.student_email = student_email;
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

    public String getStudent_email() {
        return student_email;
    }
}
