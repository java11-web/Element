package com.neusoft.elm.view.Bussiness;

import com.neusoft.elm.dao.BussinessDaoImpl;
import com.neusoft.elm.dao.IBussinessDAO;
import com.neusoft.elm.po.Bussiness;

import java.util.Scanner;

public class BussinessLoginMenu {

    public void show() {
        System.out.println("请输入用户名");
        Scanner sc=new Scanner(System.in);
        String username = sc.next();
        System.out.println("请输入密码：");
        String password=sc.next();

        IBussinessDAO dao=new BussinessDaoImpl();
        Bussiness bussiness=dao.findByName(username);

        if (bussiness==null)
        {
            System.out.println("用户名错误！返回重新登录...");
            return;
        }else
            {
                if (password.equals(bussiness.getPassword()))
                {
                    System.out.println("登录成功.........");
                    System.out.println("欢迎您!"+bussiness.getBusinessName());

                    BussinessMgrMenu bmm=new BussinessMgrMenu();

                    bmm.show(bussiness);
                }
            }




    }
}

