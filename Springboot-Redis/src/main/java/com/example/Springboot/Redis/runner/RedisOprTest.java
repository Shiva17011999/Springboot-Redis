package com.example.Springboot.Redis.runner;

import com.example.Springboot.Redis.dao.IStudentDao;
import com.example.Springboot.Redis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class RedisOprTest implements CommandLineRunner {

    @Autowired
    private IStudentDao dao;

    @Override
    public void run(String... args) throws Exception {
        dao.addStudent(new Student(100,"SHIVA",100.00));
        dao.addStudent(new Student(101,"AKHIL",101.01));
        dao.addStudent(new Student(102,"KTR",102.02));

        System.out.println("All Records");
        dao.getAllStudent().forEach((k,v)->System.out.println(k+"---"+v));



        dao.removeStudent(101);
        dao.modifyStudent(new Student(103,"RAM",95.5));
        System.out.println("After Modification");
        dao.getAllStudent().forEach((k,v)->System.out.println(k+"---"+v));

    }
}
