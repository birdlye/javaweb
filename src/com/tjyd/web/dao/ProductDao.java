package com.tjyd.web.dao;

import com.tjyd.web.model.Product;
import com.tjyd.web.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDao {
    public static void main(String[] args) {
        Product product=new Product();
        product.setName("xiaomi");
        product.setPrice(1800d);
        product.setRemark("hhhh");
        product.setId(2);

        ProductDao p=new ProductDao();
//        p.save(product);
//        p.update(product);
        p.delete(2);
    }
    public void update(Product product){
        String sql="UPDATE product set name=?,price=?,remark=? where id=?";
        JdbcUtils jdbcUtils=new JdbcUtils();
        Connection conn=jdbcUtils.getConnection();
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1,product.getName());
            pre.setDouble(2,product.getPrice());
            pre.setString(3,product.getRemark());
            pre.setInt(4,product.getId());
            pre.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(Integer id){
        String sql="DELETE from product where id=?";
        JdbcUtils jdbcUtils=new JdbcUtils();
        Connection conn=jdbcUtils.getConnection();
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setInt(1,id);
            pre.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void save(Product product){
        String sql="insert into product(name,price,remark) values (?,?,?)";
        JdbcUtils jdbcUtils=new JdbcUtils();
        Connection conn=jdbcUtils.getConnection();
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1,product.getName());
            pre.setDouble(2,product.getPrice());
            pre.setString(3,product.getRemark());
            pre.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
