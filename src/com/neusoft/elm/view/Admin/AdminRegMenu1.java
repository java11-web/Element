package com.neusoft.elm.view.Admin;

import com.neusoft.elm.po.Bussiness;
import com.neusoft.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRegMenu1 {
    public void show() {

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Bussiness bussiness=null;
        try {
            conn= DBUtil.getConnection();
            ps=conn.prepareStatement("select * from business;");
            rs=ps.executeQuery();
            while (rs.next())
            {
                System.out.print("门牌号： "+rs.getInt("businessid"));
                System.out.print("密码： "+rs.getString("password"));
                System.out.print("店铺名： "+rs.getString("busineName"));
                System.out.println( );
            }

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql 异常");
        }finally {
            try {
                DBUtil.closeConnection(rs,ps,conn);
            }catch (SQLException e)
            {
                System.out.println("连接异常");
                e.printStackTrace();
            }
        }

    }
}
