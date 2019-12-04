package com.jgybzx.servlet;

import com.jgybzx.service.PeoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: guojy
 * @date: 2019/12/4 11:23
 * @Description: ${TODO}
 * @version:
 */
//http://localhost:8080/
@WebServlet("/DeleteServlet")
//WebServlet(name = "DeleteServlet",urlPatterns="/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static PeoService peoService = new PeoService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题

        //获取删除的id
        String id = request.getParameter("id");
        peoService.delete(id);
        //没有数据传递,响应重定向
        response.sendRedirect(request.getContextPath()+"/ShowServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
