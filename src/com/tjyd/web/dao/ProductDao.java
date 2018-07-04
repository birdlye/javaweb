package com.tjyd.web.dao;

import com.tjyd.web.model.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Component(value = "productDao")
public class ProductDao {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    public void update(Product product){
        String sql="UPDATE product set name=?,price=?,remark=? where id=?";
        jdbcTemplate.update(sql,new Object[]{product.getName(),product.getPrice(),product.getRemark(),product.getId()});
    }
    public void delete(Integer id){
        String sql="DELETE from product where id=?";
        jdbcTemplate.update(sql,new Object[]{id});
    }
    public void save(Product product){
        String sql="insert into product(name,price,remark) values (?,?,?)";
        jdbcTemplate.update(sql,new Object[]{product.getName(),product.getPrice(),product.getRemark()});
    }

    public Product getById(Integer id){
        String sql="select * from product where id=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<Product>(Product.class));
    }

    public ArrayList<Product> queryByName(String name){
        String sql="select * from product where name like ?";

        return (ArrayList<Product>) jdbcTemplate.query(sql,new Object[]{"%"+name+"%"},new BeanPropertyRowMapper<Product>(Product.class));
    }
}
