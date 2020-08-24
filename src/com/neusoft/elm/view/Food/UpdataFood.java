package com.neusoft.elm.view.Food;

import com.neusoft.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdataFood {
    public void show() {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入修改事物的ID...");
        int j=sc.nextInt();
        System.out.println("请输入修改后的商品价格....");
        int i = sc.nextInt();

        try {
            connection= DBUtil.getConnection();
            ps=connection.prepareStatement("UPDATE food\n" +
                    "SET foodPrice=?\n" +
                    "WHERE foodid=?;");
            ps.setInt(1,i);
            ps.setInt(2,j);
            int k= ps.executeUpdate();
            if (k>0)
            {
                System.out.println("修改成功...");
            }else {
                System.out.println("修改失败...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
