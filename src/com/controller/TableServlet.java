package com.controller;

import com.alibaba.fastjson.JSON;
import com.bean.TaStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "TableServlet" , urlPatterns = "/TableServlet")
public class TableServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.service(req, resp);

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        //去自已 创建一个layui 后台的json格式
        List<TaStudent> students=new ArrayList<>();

        for (int i = 1; i < 16; i++) {
            TaStudent ta=new TaStudent();
            Random random=new Random();
            ta.setId(i);
            ta.setName("小呦"+random.nextInt(100)+"号");
            ta.setAge(random.nextInt(90));
            ta.setClazz("大数据"+random.nextInt(20)+"班");
            students.add(ta);
        }

        Map map=new HashMap<>();
        map.put("code",0);
        map.put("msg","黑魔仙");
        map.put("count",15);
        map.put("data",students);


        String s= JSON.toJSONString(map); //使用fastjson 的转换

        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
    }
}
