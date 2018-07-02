package com.tjyd.web.dao;

import com.tjyd.web.model.Product;
import com.tjyd.web.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDao {



    public void update(String sql,Object[] param) {
        JdbcUtils jdbcUtils = new JdbcUtils();
        Connection conn = jdbcUtils.getConnection();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            for(int i=0;i<param.length;i++){
                pre.setObject(i+1,param[i]);
            }
            pre.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
