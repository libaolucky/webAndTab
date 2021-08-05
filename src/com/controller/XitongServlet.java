package com.controller;

import com.alibaba.fastjson.JSON;
import com.bean.XiTongBug;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "XitongServlet",urlPatterns = "/XitongServlet")
public class XitongServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        //去自已 创建一个layui 后台的json格式
        List<XiTongBug> xi=new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            XiTongBug xx=new XiTongBug();
            Random random=new Random();
            xx.setId(i);
            xx.setBid("[00"+random.nextInt(9)+"]");
            xx.setName("小短腿鹿鹿");
            xx.setCount(4);
            xx.setJibie("高危");
            xx.setYuname("www.baidu.com");
            xx.setType("用户名遍历Bug，可任意改");
            xx.setTongzhi(true);
            xx.setFankui(false);
            xx.setCtest(true);
            xx.setUpdate(true);
            xi.add(xx);
        }

        Map map=new HashMap<>();
        map.put("code",0);
        map.put("msg","黑魔仙");
        map.put("count",9);
        map.put("data",xi);


        String s= JSON.toJSONString(map); //使用fastjson 的转换

        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
    }
}
