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
import java.util.List;

//   这个@WebServlet 注解 就和 web.xml是一个意思                      ------------  注意 有  /
@WebServlet(name = "GetJsonServlet" , urlPatterns = "/GetJsonServlet")
public class GetJsonServlet extends HttpServlet {
    // service 是都可以 接受  get /post 请求
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
            // web 层 , controller 层是 提供json 数据的 , 那么 我们需要一个 处理json 的lib 包
        // 这个lib 包 叫做  fastjson ,阿里巴巴出品, 很厉害的.
        // 学习 json 和  fastJson

        // 使用 fastjson 把  对象 转换成 json数据
        List<Student> students = new ArrayList<>();

        Student s1=new Student();
                s1.setId(001);
                s1.setAge(21);
                s1.setName("啦啦啦");
        students.add(s1);

        Student s2=new Student();
                s2.setId(002);
                s2.setAge(11);
                s2.setName("猴子");
        students.add(s2);
        Student s3=new Student();
        s3.setId(003);
        s3.setAge(1455);
        s3.setName("和尚");
        students.add(s3);

        String s = JSON.toJSONString(students);
        System.out.println("s = " + s); // 把对象转换成了 json格式的字符串

        // 输出到前端
        // 1.解决乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        // 2. 开始输出
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();

    }
}
