package com.tjyd.web.service;

import com.tjyd.web.dao.ProductDao;
import com.tjyd.web.model.Product;

import java.util.ArrayList;

public class ProductService {
    private ProductDao productDao;
    public void save(Product product){
        productDao.save(product);
//       Integer.parseInt("sef");
    }

    public ArrayList<Product> queryByName(String keyword){
        return productDao.queryByName(keyword);
    }

    public void delete(Integer id){
        productDao.delete(id);
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
