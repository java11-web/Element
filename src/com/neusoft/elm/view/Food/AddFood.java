package com.neusoft.elm.view.Food;

import com.neusoft.elm.po.Bussiness;
import com.neusoft.elm.po.Food;
import com.neusoft.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddFood {

    public void show(Bussiness bussiness)
    {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入商品名...");
        String next = sc.next();
        System.out.println("请输入商品价格....");
        int i = sc.nextInt();

        try {
            conn= DBUtil.getConnection();
            ps=conn.prepareStatement("INSERT into food VALUES(null,?,null ,?,?);");
            ps.setString(1,next);
            ps.setInt(2,i);
            ps.setInt(3,bussiness.getBusinessId());
            int k=ps.executeUpdate();

            if (k>0){
                System.out.println("插入成功..");
            }else {
                System.out.println("插入失败...");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
