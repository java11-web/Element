package com.neusoft.elm.view.Food;

import com.neusoft.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteFood {

    public void show() {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要删除的商品ID");
        int i = sc.nextInt();

        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement("DELETE from food\n" +
                    "WHERE foodid=?;");
            ps.setInt(1,i);
            int j=ps.executeUpdate();
            if (j>0)
            {
                System.out.println("删除成功....");
            }else System.out.println("删除失败了...");

        }catch (SQLException e)
        {

            System.out.println("Mysql语句不对...");
        }

    }
}
