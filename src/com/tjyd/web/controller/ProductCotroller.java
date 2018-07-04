package com.tjyd.web.controller;


import com.tjyd.web.model.Product;
import com.tjyd.web.service.ProductService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import static java.lang.System.out;
@Component(value = "controller")
@RequestMapping("/product")
public class ProductCotroller {
    @Resource
    HttpSession session;
    @Resource
    HttpServletRequest request;

    @Resource(name = "productService")
    private ProductService productService;
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        System.out.println(product);
        return "redirect:/query.jsp";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        productService.delete(id);
        String keyword= (String) session.getAttribute("keyword");
        ArrayList<Product> list=productService.queryByName(keyword);
        request.setAttribute("list",list);
        return "forward:/query.jsp";
    }
    @RequestMapping("/query")
    public String queryByName(String keyword){
        ArrayList<Product> list=productService.queryByName(keyword);
        request.setAttribute("list",list);
        session.setAttribute("keyword",keyword);
        return "forward:/query.jsp";
    }
    @RequestMapping("/getbyid")
    public String getById(Integer id) {
        // ����ҵ���߼�
        Product product = productService.getById(id);
        request.setAttribute("product", product);
        // ��ת��update.jsp(��ҳ��Ӧ����Ĭ��ֵ)
        return "forward:/update.jsp";
    }
    @RequestMapping("/update")
    public String update(Product product){
        productService.update(product);
        String keyword= (String) session.getAttribute("keyword");
        ArrayList<Product> list=productService.queryByName(keyword);
        request.setAttribute("list",list);
        return "forward:/query.jsp";
    }
}
