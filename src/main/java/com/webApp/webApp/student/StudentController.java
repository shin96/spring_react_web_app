package com.webApp.webApp.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping
    List <Student> getAllStudents() {
        return List.of(new Student("kashis","thakur",Student.Gender.MALE, UUID.randomUUID(), "kt@go.co"),
                new Student("Pintu", "Oberoy", Student.Gender.MALE, UUID.randomUUID(), "p@po.co")
        );
    }
}
