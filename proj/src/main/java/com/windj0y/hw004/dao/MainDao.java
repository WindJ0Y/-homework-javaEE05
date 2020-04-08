package com.windj0y.hw004.dao;

import com.windj0y.hw004.pojo.Homework;
import com.windj0y.hw004.pojo.Student;
import com.windj0y.hw004.pojo.Submit;

import java.util.List;

public interface MainDao {

    public boolean addStudent(String name);

    public boolean addHomework(String name);

    public boolean submitHomework(int sid, int hid, String content);

    public List<Student> getStudents();

    public List<Homework> getHomeworks();

    public List<Submit> getSubmits();

}
