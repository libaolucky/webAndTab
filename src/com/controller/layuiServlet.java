package com.controller;

import com.alibaba.fastjson.JSON;
import com.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "layuiServlet",urlPatterns = "/layuiServlet")
public class layuiServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("utf-8");

        //去自已 创建一个layui 后台的json格式
        List<Student> students=new ArrayList<>();
        //创建三个学生
        Student s1=new Student();
        s1.setId(1);
        s1.setName("唐僧");
        s1.setAge(30);
        students.add(s1);

        Student s2=new Student();
        s2.setName("猪老二");
        s2.setAge(34);
        s2.setId(2);
        students.add(s2);

        Student s3=new Student();
        s3.setName("沙和尚");
        s3.setAge(72);
        s3.setId(3);
        students.add(s3);

        Map map=new HashMap<>();
             map.put("code",0);
             map.put("msg","野人好吃");
             map.put("count",3);
             map.put("data",students);


      String s= JSON.toJSONString(map); //使用fastjson 的转换


       PrintWriter writer=resp.getWriter();
       writer.println(s);
       writer.close();
    }
}
