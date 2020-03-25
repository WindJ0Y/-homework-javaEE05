package servlet;

import jdbc.MysqlAdapter;
import jdbc.MainBo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/v1/*")
public class MainServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        MysqlAdapter.Connect();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8;");
        switch (path){
            case "/addStudent":{
                if(MainBo.addStudent(req.getParameter("name"))){
                    resp.getWriter().println("添加成功");
                }else{
                    resp.getWriter().println("添加失败");
                }
                break;
            }
            case "/addHomework":{
                if(MainBo.addHomework(req.getParameter("name"))){
                    resp.getWriter().println("添加成功");
                }else{
                    resp.getWriter().println("添加失败");
                }
                break;
            }
            case "/submitHomework":{
                if(MainBo.submitHomework(req.getParameter("sid"),req.getParameter("hid"),req.getParameter("content"))){
                    resp.getWriter().println("提交成功");
                }else{
                    resp.getWriter().println("提交失败");
                }
                break;
            }
            default:{
                resp.getWriter().println("err");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        MysqlAdapter.Disconnect();
    }
}
