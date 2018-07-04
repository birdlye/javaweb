package com.tjyd.web.controller;


import com.tjyd.web.model.Product;
import com.tjyd.web.service.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static java.lang.System.out;
@Component(value = "controller")
@RequestMapping("/product")
public class ProductCotroller {
    @Resource(name = "productService")
    private ProductService productService;
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        System.out.println(product);
        return "redirect:/query.jsp";
    }
    @RequestMapping("/delete")
    public void delete(Integer id){

    }

    public String query(String keyword){
        productService.queryByName(keyword);
        return null;
    }

}
