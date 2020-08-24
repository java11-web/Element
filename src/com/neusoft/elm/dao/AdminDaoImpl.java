package com.neusoft.elm.dao;

import com.neusoft.elm.po.Admin;
import com.neusoft.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements IAdminDao
{
    @Override
    public int add(Admin admin) {
        Connection conn= null;
        PreparedStatement ps=null;
        int result=0;
        try {
            conn = DBUtil.getConnection();
            ps=conn.prepareStatement("INSERT INTO admin\n" +
                    "VALUES (null,?,?)");
            ps.setString(1,admin.getAdminName());
            ps.setString(2,admin.getPassword());
             result = ps.executeUpdate();
        } catch (SQLException e)
        {
        } finally {

            try {
                DBUtil.closeConnection(null,ps,conn);
            }catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    @Override
    public Admin findByName(String name) {
        Connection conn= null;  //连接对象
        PreparedStatement ps=null; //环境
        ResultSet rs=null;//结果集
        Admin admin=null;
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement("select * from admin where adminName=?");
            ps.setString(1,name);
            rs= ps.executeQuery();
            if (rs.next())
            {
                 admin= new Admin();
                 admin.setAdminId(rs.getInt("adminId"));
                 admin.setAdminName(rs.getString("adminName"));
                 admin.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DBUtil.closeConnection(rs, ps, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return admin;
    }
}
