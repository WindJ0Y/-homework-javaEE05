package com.windj0y.hw004.service;

import com.windj0y.hw004.dao.MainDao;
import com.windj0y.hw004.pojo.Homework;
import com.windj0y.hw004.pojo.Student;
import com.windj0y.hw004.pojo.Submit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {

    private final MainDao mainDao;

    public MainServiceImpl(MainDao mainDao) {
        this.mainDao = mainDao;
    }

    @Override
    public boolean addStudent(String name) {
        return mainDao.addStudent(name);
    }

    @Override
    public boolean addHomework(String name) {
        return mainDao.addHomework(name);
    }

    @Override
    public boolean submitHomework(int sid, int hid, String content) {
        return mainDao.submitHomework(sid,hid,content);
    }

    @Override
    public List<Student> getStudents() {
        return mainDao.getStudents();
    }

    @Override
    public List<Homework> getHomeworks() {
        return mainDao.getHomeworks();
    }

    @Override
    public List<Submit> getSubmits() {
        return mainDao.getSubmits();
    }
}
