package com.jgybzx.servlet;

import com.jgybzx.entity.People;
import com.jgybzx.service.PeoService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author: guojy
 * @date: 2019/12/4 11:39
 * @Description: ${TODO}
 * @version:
 */
//http://localhost:8080/
@WebServlet("/UpdateServlet")
//WebServlet(name = "UpdateServlet",urlPatterns="/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static PeoService peoService = new PeoService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        Map<String, String[]> parameterMap = request.getParameterMap();
        People people = new People();
        try {
            BeanUtils.populate(people,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        peoService.update(people);
        response.sendRedirect(request.getContextPath()+"/ShowServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
