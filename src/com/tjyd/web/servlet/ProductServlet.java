package com.tjyd.web.servlet;

import com.tjyd.web.model.Product;
import com.tjyd.web.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ProductServlet extends HttpServlet {
    // JSP --> Servlet --> Service ---> Dao ---> DB
    private ProductService productService = new ProductService();

    // 处理:method="get"
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);

    }



    // 处理:method="post"
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1: 获取前端数据(java web中客户端返回的数据都被封装到request对象)
        String type=request.getParameter("type");
        if(type.equals("save")){
            Product product = new Product();
            product.setName(request.getParameter("name")); // <input name="name" />
            product.setRemark(request.getParameter("remark"));
            Double price = Double.parseDouble(request.getParameter("price"));
            product.setPrice(price);
            // 2: 调用业务逻辑
            productService.save(product);
            // 3: 返回结果页面
            response.sendRedirect(request.getContextPath()+"/query.jsp");
        }else if(type.equals("query")){
// 1: 获取前端输入查询关键字
            String keyword = request.getParameter("keyword");
            // 把当前查询关键字存储到session中,这样只要浏览器不关闭/30分钟内交互.则在页面可以显示此关键字
            HttpSession session= request.getSession();
            session.setAttribute("keyword", keyword);
            // 2: 调用业务逻辑
            ArrayList<Product> list = productService.queryByName(keyword);
            System.out.println(list.size());
            // 此数据要交给query.jsp页面显示
            request.setAttribute("list", list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
            // 在转发此请求的时候,会把上一次request response提交
            dispatcher.forward(request, response);
        }else if(type.equals("delete")){
            String id=request.getParameter("id");
            productService.delete(Integer.parseInt(id));
            HttpSession session=request.getSession();
            String keyword= (String) session.getAttribute("keyword");
            ArrayList<Product> list=productService.queryByName(keyword);
            request.setAttribute("list",list);
            RequestDispatcher dispatcher=request.getRequestDispatcher("/query.jsp");
            dispatcher.forward(request,response);
        }else if(type.equals("update")){

        }

    }
}
