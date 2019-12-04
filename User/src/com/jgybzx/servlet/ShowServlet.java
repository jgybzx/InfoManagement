package com.jgybzx.servlet;

import com.jgybzx.entity.People;
import com.jgybzx.service.PeoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: guojy
 * @date: 2019/12/4 10:56
 * @Description: ${TODO}
 * @version:
 */
//http://localhost:8080/User/ShowServlet
@WebServlet("/ShowServlet")
//WebServlet(name = "ShowServlet",urlPatterns="/ShowServlet")
public class ShowServlet extends HttpServlet {
    private static PeoService peoService = new PeoService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题

        List<People> list = peoService.select();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/user/show.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
