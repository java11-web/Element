package com.neusoft.elm.dao;

import com.neusoft.elm.po.Admin;
import com.neusoft.elm.po.Bussiness;
import com.neusoft.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BussinessDaoImpl implements IBussinessDAO
{
    @Override
    public int add(Bussiness bussiness) {
        Connection conn=null;
        PreparedStatement ps=null;
        int result=0;
        try {
            conn= DBUtil.getConnection();
            ps=conn.prepareStatement("insert into business values(null,?,?,null,null,null,null);");
            ps.setString(1, bussiness.getBusinessName());
            ps.setString(2, bussiness.getPassword());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DBUtil.closeConnection(null,ps,conn);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Bussiness findByName(String name) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Bussiness bussiness=null;
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement("select * from business where busineName=?");
            ps.setString(1,name);
            rs=ps.executeQuery();
            if (rs.next())
            {
               bussiness=new Bussiness();
               bussiness.setBusinessId(rs.getInt("businessid"));
               bussiness.setPassword(rs.getString("password"));
               bussiness.setBusinessName(rs.getString("busineName"));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DBUtil.closeConnection(rs,ps,conn);
            }catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return bussiness;
    }
}
