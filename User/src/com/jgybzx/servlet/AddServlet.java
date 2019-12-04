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
import java.util.UUID;

/**
 * @author: guojy
 * @date: 2019/12/4 11:12
 * @Description: ${TODO}
 * @version:
 */
//http://localhost:8080/
@WebServlet("/AddServlet")
//WebServlet(name = "AddServlet",urlPatterns="/AddServlet")
public class AddServlet extends HttpServlet {
    private static PeoService peoService = new PeoService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        //从页面获取提交的内容,使用BeanUtils的popular方法,封装成对象
        //用户id不应该 由用户填写
        String id = UUID.randomUUID().toString();
//        String userName = request.getParameter("userName");
//        String userPass = request.getParameter("userPass");
//        String userAge = request.getParameter("userAge");
        People people = new People();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(people,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        people.setUserId(id);
        //调用service层方法 添加数据
        peoService.add(people);
        //请求转发到 showServlet
        request.getRequestDispatcher("/ShowServlet").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
