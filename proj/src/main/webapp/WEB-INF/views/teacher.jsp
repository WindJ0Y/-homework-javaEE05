<%@ page import="java.util.List" %>
<%@ page import="com.windj0y.hw004.service.MainService" %>
<%@ page import="com.windj0y.hw004.pojo.Student" %>
<%@ page import="com.windj0y.hw004.pojo.Homework" %>
<%@ page import="com.windj0y.hw004.pojo.Submit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师页</title>
    <link type="text/css" rel="styleSheet"  href="css/css.css" />
    <script type="text/javascript" src="js/js.js"></script>
</head>

<body>

<%
    MainService mainService = (MainService)request.getAttribute("mainService");
%>

<div class = "parent">

    <div class = "child" style="background-color: aqua">
        <p class = "word">学生</p>

        <div>
            <a>添加学生</a>
            <input type="text" id="studentName" />
            <button type="button" onclick="addStudent();">提交</button>
        </div>

        <table class = "gridtable">
            <tr>
                <td>sid</td>
                <td>姓名</td>
            </tr>
            <%{
                List<Student> list = mainService.getStudents();
                for(Student student:list){%>
                    <tr>
                        <td><%=student.getSid() %></td>
                        <td><%=student.getName() %></td>
                    </tr>
                <%}
            }%>
        </table>

    </div>

    <div class = "child" style="background-color: fuchsia">
        <p class = "word">作业</p>

        <div>
            <a>添加作业</a>
            <input type="text" id="homeworkName"/>
            <button type="button" onclick="addHomework();">提交</button>
        </div>

        <table class = "gridtable">
            <tr>
                <td>hid</td>
                <td>名称</td>
            </tr>
            <%{
                List<Homework> list = mainService.getHomeworks();
                for(Homework homework:list){%>
                    <tr>
                        <td><%=homework.getHid() %></td>
                        <td><%=homework.getName() %></td>
                    </tr>
                <%}
            }%>
        </table>

    </div>

    <div class = "child" style="background-color: aqua">
        <p class = "word">提交</p>

        <table class = "gridtable">
            <tr>
                <td>sid</td>
                <td>hid</td>
                <td>内容</td>
            </tr>
            <%{
                List<Submit> list = mainService.getSubmits();
                for(Submit submit:list){%>
            <tr>
                <td><%=submit.getSid() %></td>
                <td><%=submit.getHid() %></td>
                <td><%=submit.getContent() %></td>
            </tr>
            <%}
            }%>
        </table>

    </div>

</div>

</body>
</html>
