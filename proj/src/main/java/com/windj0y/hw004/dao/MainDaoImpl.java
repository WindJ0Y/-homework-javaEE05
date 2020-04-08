package com.windj0y.hw004.dao;

import com.windj0y.hw004.pojo.*;
import config.MainConfig;
import jdbc.MysqlAdapter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MainDaoImpl implements MainDao {

    private final MysqlAdapter mysqlAdapter;

    public MainDaoImpl() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        mysqlAdapter = (MysqlAdapter)context.getBean("mysqlAdapter");
    }

    @Override
    public boolean addStudent(String name) {
        if(name == null || name.isEmpty()) return false;

        String sqlString = "insert into student (name) VALUES (?)";
        Connection connection = mysqlAdapter.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(sqlString)){
            statement.setString(1,name);
            boolean result = statement.executeUpdate() == 1;
            connection.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean addHomework(String name) {
        if(name == null || name.isEmpty()) return false;

        String sqlString = "insert into homework (name) VALUES (?)";
        Connection connection = mysqlAdapter.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(sqlString)){
            statement.setString(1,name);
            boolean result = statement.executeUpdate() == 1;
            connection.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean submitHomework(int sid, int hid, String content) {
        if(content == null || content.isEmpty()) return false;

        String sqlString = "insert into submit (sid,hid,content) VALUES (?,?,?)";
        Connection connection = mysqlAdapter.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(sqlString)){
            statement.setInt(1,sid);
            statement.setInt(2,hid);
            statement.setString(3,content);
            boolean result = statement.executeUpdate() == 1;
            connection.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> rtn = new ArrayList<>();

        String sqlString = "select * from student";
        Connection connection = mysqlAdapter.getConnection();

        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sqlString);

            while(resultSet.next()){
                Student tmpStudent = new Student();
                tmpStudent.setSid(resultSet.getInt("sid"));
                tmpStudent.setName(resultSet.getString("name"));
                rtn.add(tmpStudent);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rtn;
    }

    @Override
    public List<Homework> getHomeworks() {
        List<Homework> rtn = new ArrayList<>();

        String sqlString = "select * from homework";
        Connection connection = mysqlAdapter.getConnection();

        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sqlString);

            while(resultSet.next()){
                Homework tmpHomework = new Homework();
                tmpHomework.setHid(resultSet.getInt("hid"));
                tmpHomework.setName(resultSet.getString("name"));
                rtn.add(tmpHomework);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rtn;
    }

    @Override
    public List<Submit> getSubmits() {
        List<Submit> rtn = new ArrayList<>();

        String sqlString = "select * from submit";
        Connection connection = mysqlAdapter.getConnection();

        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sqlString);

            while(resultSet.next()){
                Submit tmpSubmit = new Submit();
                tmpSubmit.setSid(resultSet.getInt("sid"));
                tmpSubmit.setHid(resultSet.getInt("hid"));
                tmpSubmit.setContent(resultSet.getString("content"));
                rtn.add(tmpSubmit);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rtn;
    }
}
