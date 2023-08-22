package com.example.Springboot.Redis.dao;

import com.example.Springboot.Redis.model.Student;

import java.util.Map;

public interface IStudentDao {
    void addStudent(Student s);
    void modifyStudent(Student s);
    Student getOneStudent(Integer id);
    Map<Integer,Student> getAllStudent();
    void removeStudent(Integer id);

}
