package com.neusoft.elm.view.Admin;

import com.neusoft.elm.po.Bussiness;
import com.neusoft.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminRegMenu2 {
    public void show()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要删除商家的账户businessid...");
        int i = sc.nextInt();

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Bussiness bussiness=null;

        try {
            conn= DBUtil.getConnection();
            ps=conn.prepareStatement("DELETE FROM business WHERE businessid=?;");
            ps.setInt(1,i);
            int k=ps.executeUpdate();
            if (k>0)
            {
                System.out.println("删除成功...");
            }else {
                System.out.println("删除失败...");
            }
        } catch (SQLException e) {
            System.out.println("sql语句异常");
        }

    }
}
