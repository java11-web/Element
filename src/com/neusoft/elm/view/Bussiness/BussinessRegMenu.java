package com.neusoft.elm.view.Bussiness;

import com.neusoft.elm.dao.BussinessDaoImpl;
import com.neusoft.elm.po.Bussiness;

import java.util.Scanner;

public class BussinessRegMenu {
    public void show()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名.....");
        String username = sc.next();
        System.out.println("请输入密码.....");
        String password = sc.next();
        System.out.println("请再次输入密码：");
        String repassword=sc.next();

        if (!password.equals(repassword))
        {
            System.out.println("两次密码输入不一致！");
            return;
        }
        Bussiness bussiness=new Bussiness();
        bussiness.setBusinessName(username);
        bussiness.setPassword(password);
        BussinessDaoImpl dao=new BussinessDaoImpl();
        int result=dao.add(bussiness);

        if (result>0)
        {
            System.out.println("商家注册成功，即将返回登录界面");
            return ;
        }

    }
}
