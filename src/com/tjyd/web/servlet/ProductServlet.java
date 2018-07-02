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

    // ����:method="get"
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);

    }



    // ����:method="post"
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1: ��ȡǰ������(java web�пͻ��˷��ص����ݶ�����װ��request����)
        String type=request.getParameter("type");
        if(type.equals("save")){
            Product product = new Product();
            product.setName(request.getParameter("name")); // <input name="name" />
            product.setRemark(request.getParameter("remark"));
            Double price = Double.parseDouble(request.getParameter("price"));
            product.setPrice(price);
            // 2: ����ҵ���߼�
            productService.save(product);
            // 3: ���ؽ��ҳ��
            response.sendRedirect(request.getContextPath()+"/query.jsp");
        }else if(type.equals("query")){
// 1: ��ȡǰ�������ѯ�ؼ���
            String keyword = request.getParameter("keyword");
            // �ѵ�ǰ��ѯ�ؼ��ִ洢��session��,����ֻҪ��������ر�/30�����ڽ���.����ҳ�������ʾ�˹ؼ���
            HttpSession session= request.getSession();
            session.setAttribute("keyword", keyword);
            // 2: ����ҵ���߼�
            ArrayList<Product> list = productService.queryByName(keyword);
            System.out.println(list.size());
            // ������Ҫ����query.jspҳ����ʾ
            request.setAttribute("list", list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
            // ��ת���������ʱ��,�����һ��request response�ύ
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
