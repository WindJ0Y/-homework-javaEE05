package com.windj0y.hw004.service;

import com.windj0y.hw004.pojo.*;

import java.util.List;

public interface MainService {

    public boolean addStudent(String name);

    public boolean addHomework(String name);

    public boolean submitHomework(int sid, int hid, String content);

    public List<Student> getStudents();

    public List<Homework> getHomeworks();

    public List<Submit> getSubmits();

}
