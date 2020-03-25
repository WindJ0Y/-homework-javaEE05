<%@ page import="bean.Student" %>
<%@ page import="jdbc.MainBo" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Homework" %><%--
  Created by IntelliJ IDEA.
  User: WindJ0Y
  Date: 2020/3/13
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生页</title>
    <link type="text/css" rel="styleSheet"  href="./css.css" />
    <script type="text/javascript" src="./js.js"></script>
</head>
<body>

<div>
    <a>选择学生：</a>
    <select id="studentSelect">
        <%{
            List<Student> list = MainBo.getStudents();
            for(Student student:list){%>
                <option value="<%=student.getSid() %>">
                    <%=student.getName() %>
                </option>
            <%}
        }%>
    </select>
</div>

<div>
    <a>选择作业：</a>
    <select id="homeworkSelect">
        <%{
            List<Homework> list = MainBo.getHomeworks();
            for(Homework homework:list){%>
                <option value="<%=homework.getHid() %>">
                    <%=homework.getName() %>
                </option>
            <%}
        }%>
    </select>
</div>

<div>
    <a>作业内容：</a>
    <input id="homeworkContent" type="text"/>
    <button type="button" onclick="submitHomework();">提交</button>
</div>


</body>
</html>
