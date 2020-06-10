package com.dubbo.demo.protocol.dubbo;//package com.dubbo.demo.protocol.http;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class DispatcherServlet extends HttpServlet {
//
//    private static final long serialVersionUID = 1L;
//
//    public void init() {
//        System.out.println("执行了init方法");
//    }
//
//
//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        new HttpServletHandler().doHandler(req, res);
//    }
//}
