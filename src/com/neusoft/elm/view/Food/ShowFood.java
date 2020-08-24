package com.neusoft.elm.view.Food;

import com.neusoft.elm.po.Bussiness;
import com.neusoft.elm.po.Food;
import com.neusoft.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowFood {
    public void show(Bussiness bussiness) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            ps=conn.prepareStatement("SELECT *\n" +
                    "from food \n" +
                    "WHERE businessid=?;");
            ps.setInt(1,bussiness.getBusinessId());
            rs= ps.executeQuery();
            while (rs.next())
            {
                System.out.println("****************************************************");
                System.out.println("foodId:  "+rs.getInt("foodId"));
                System.out.println("foodName:"+rs.getString("foodName"));
                System.out.println("foodPrice"+rs.getInt("foodPrice"));
                System.out.println("****************************************************");
            }
        }catch (SQLException e)
        {
            System.out.println("mysql语句出错了.......");
        }
        return;
    }
}
