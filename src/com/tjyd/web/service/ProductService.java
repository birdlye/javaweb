package com.tjyd.web.service;

import com.tjyd.web.dao.ProductDao;
import com.tjyd.web.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Component(value = "productService")
public class ProductService {
    @Resource(name = "productDao")
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

    public Product getById(Integer id){
        return productDao.getById(id);
    }

    public void update(Product product){
        productDao.update(product);
    }

//    public void setProductDao(ProductDao productDao) {
//        this.productDao = productDao;
//    }
}
