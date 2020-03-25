package jdbc;

import bean.Homework;
import bean.Student;
import bean.Submit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainBo {

    public static boolean addStudent(String name){
        if(name == null || name.isEmpty()) return false;

        String sqlString = "insert into student (name) VALUES (?)";
        Connection connection = MysqlAdapter.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(sqlString)){
            statement.setString(1,name);
            return statement.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean addHomework(String name){
        if(name == null || name.isEmpty()) return false;

        String sqlString = "insert into homework (name) VALUES (?)";
        Connection connection = MysqlAdapter.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(sqlString)){
            statement.setString(1,name);
            return statement.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean submitHomework(String sid, String hid, String content){
        if(content == null || content.isEmpty()) return false;

        String sqlString = "insert into submit (sid,hid,content) VALUES (?,?,?)";
        Connection connection = MysqlAdapter.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(sqlString)){
            statement.setString(1,sid);
            statement.setString(2,hid);
            statement.setString(3,content);
            return statement.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static List<Student> getStudents(){
        List<Student> rtn = new ArrayList<>();

        String sqlString = "select * from student";
        Connection connection = MysqlAdapter.getConnection();

        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sqlString);

            while(resultSet.next()){
                Student tmpStudent = new Student();
                tmpStudent.setSid(resultSet.getInt("sid"));
                tmpStudent.setName(resultSet.getString("name"));
                rtn.add(tmpStudent);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rtn;
    }

    public static List<Homework> getHomeworks(){
        List<Homework> rtn = new ArrayList<>();

        String sqlString = "select * from homework";
        Connection connection = MysqlAdapter.getConnection();

        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sqlString);

            while(resultSet.next()){
                Homework tmpHomework = new Homework();
                tmpHomework.setHid(resultSet.getInt("hid"));
                tmpHomework.setName(resultSet.getString("name"));
                rtn.add(tmpHomework);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rtn;
    }

    public static List<Submit> getSubmits(){
        List<Submit> rtn = new ArrayList<>();

        String sqlString = "select * from submit";
        Connection connection = MysqlAdapter.getConnection();

        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sqlString);

            while(resultSet.next()){
                Submit tmpSubmit = new Submit();
                tmpSubmit.setSid(resultSet.getInt("sid"));
                tmpSubmit.setHid(resultSet.getInt("hid"));
                tmpSubmit.setContent(resultSet.getString("content"));
                rtn.add(tmpSubmit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rtn;
    }

}
