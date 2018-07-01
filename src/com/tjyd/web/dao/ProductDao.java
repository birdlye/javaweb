package com.tjyd.web.dao;

import com.tjyd.web.model.Product;
import com.tjyd.web.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends BaseDao{

    public void update(Product product){
        String sql="UPDATE product set name=?,price=?,remark=? where id=?";
        super.update(sql,new Object[]{product.getName(),product.getPrice(),product.getRemark(),product.getId()});
    }
    public void delete(Integer id){
        String sql="DELETE from product where id=?";
        super.update(sql,new Object[]{id});
    }
    public void save(Product product){
        String sql="insert into product(name,price,remark) values (?,?,?)";
        super.update(sql,new Object[]{product.getName(),product.getPrice(),product.getRemark()});
    }

    public Product getById(Integer id){
        JdbcUtils jdbcUtils=new JdbcUtils();
        Connection conn=jdbcUtils.getConnection();
        String sql="select * from product where id =?";
        Product p=new Product();
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setInt(1,id);
            ResultSet rs=pre.executeQuery();
            if (rs.next()){

                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getDouble(3));
                p.setRemark(rs.getString(4));
                p.setDate(rs.getDate(5));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    public ArrayList<Product> queryByName(String name){
        JdbcUtils jdbcUtils=new JdbcUtils();
        Connection conn=jdbcUtils.getConnection();
        String sql="select * from product where name  like ?";
        Product p=null;
        ArrayList<Product> pl= new ArrayList<Product>();
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1,"%"+name+"%");
            ResultSet rs=pre.executeQuery();
            while (rs.next()){
                p=new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getDouble(3));
                p.setRemark(rs.getString(4));
                p.setDate(rs.getDate(5));
                pl.add(p);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pl;
    }
}
