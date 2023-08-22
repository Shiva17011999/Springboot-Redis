package com.example.Springboot.Redis.daoImpl;

import com.example.Springboot.Redis.dao.IStudentDao;
import com.example.Springboot.Redis.model.Student;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class StudentDaoImpl implements IStudentDao {
    private final String KEY = "STUDENT";
    //<Hash Reference, Hash key, Hash Value>
    @Resource(name = "redisTemplate")
    //HashOperations should be connected to our Redis Template. DefaultHashOperations need Redis Template
    private HashOperations<String,Integer,Student> opr;

    @Override
    public void addStudent(Student s) {
        //Create new Id in HashMemory if given Record Not Exist
        opr.putIfAbsent(KEY,s.getStdId(),s);
    }

    @Override
    public void modifyStudent(Student s) {
        //Update data with given Id
        opr.put(KEY,s.getStdId(),s);

    }

    @Override
    public Student getOneStudent(Integer id) {
        //Read one Record based on HashRef and Id
        return opr.get(KEY,id);
    }

    @Override
    public Map<Integer, Student> getAllStudent() {
        //HashRef, get all rows as Map
        return opr.entries(KEY);
    }

    @Override
    public void removeStudent(Integer id) {
        //HashRef, key
        opr.delete(KEY,id);

    }
}
