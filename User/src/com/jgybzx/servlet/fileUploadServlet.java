package com.jgybzx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @author: guojy
 * @date: 2019/12/4 11:54
 * @Description: ${TODO}
 * @version:
 */
//http://localhost:8080/
@WebServlet("/fileUploadServlet")
@MultipartConfig
//WebServlet(name = "fileUploadServlet",urlPatterns="/fileUploadServlet")
public class fileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题

        //接收文件字节数据
        Part myFile = request.getPart("myFile");

        /* 本段代码用于取出 上传的文件的名字
        //取出请求体中的   文件头信息
        //Content-Disposition: form-data; name="myFile"; filename="touxiang.png"
        String header = request.getHeader("Content-Disposition");
        //获取文件名字
        String filename = header.split(";")[1].split("=")[1].replace("=", "");*/
        //获取用户id,将id作为上传的头像的名字,与其绑定
        String id = request.getParameter("id");
        System.out.println("id = " + id);
        String filename = id+".png";
        //将文件写入到服务器 磁盘中

        myFile.write(this.getServletContext().getRealPath("")+filename);
        //System.out.println(this.getServletContext().getRealPath(""));
        response.getWriter().write("上传成功");
        response.setHeader("refresh","1;url="+request.getContextPath()+"/ShowServlet");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
