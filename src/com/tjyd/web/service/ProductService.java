package com.tjyd.web.service;

import com.tjyd.web.dao.ProductDao;
import com.tjyd.web.model.Product;

import java.util.ArrayList;

public class ProductService {
    private ProductDao productDao=new ProductDao();
    public void save(Product product){
        productDao.save(product);
    }

    public ArrayList<Product> queryByName(String keyword){
        return productDao.queryByName(keyword);
    }

    public void delete(Integer id){
        productDao.delete(id);
    }
}
