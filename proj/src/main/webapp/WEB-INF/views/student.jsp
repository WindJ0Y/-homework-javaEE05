<%@ page import="java.util.List" %>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page import="com.windj0y.hw004.pojo.Student" %>
<%@ page import="com.windj0y.hw004.pojo.Homework" %>
<%@ page import="com.windj0y.hw004.service.MainService" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生页</title>
    <link type="text/css" rel="styleSheet"  href="css/css.css" />
    <script type="text/javascript" src="js/js.js"></script>
</head>
<body>

<%
    MainService mainService = (MainService)request.getAttribute("mainService");
%>

<div>
    <a>选择学生：</a>
    <select id="studentSelect">
        <%{
            List<Student> list = mainService.getStudents();
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
            List<Homework> list = mainService.getHomeworks();
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
