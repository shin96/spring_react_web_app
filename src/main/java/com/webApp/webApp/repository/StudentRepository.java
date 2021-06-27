package com.webApp.webApp.repository;

import com.webApp.webApp.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Student> selectAllStudents() {

        String sql = "select * from student;";
        return jdbcTemplate.query(sql, mapStudentsFromDb());
    }

    private RowMapper<Student> mapStudentsFromDb() {
        return (resultSet, i) -> {
            String studentIdStr = resultSet.getString("student_id");
            UUID studentId = UUID.fromString(studentIdStr);
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String gender = resultSet.getString("gender").toUpperCase();
            String email = resultSet.getString("student_email");
            return new Student(firstName, lastName, Student.Gender.valueOf(gender), studentId, email);
        };
    }

}
