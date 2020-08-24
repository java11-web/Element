package com.neusoft.elm.view.Admin;

import com.neusoft.elm.dao.AdminDaoImpl;
import com.neusoft.elm.dao.IAdminDao;
import com.neusoft.elm.po.Admin;

import java.util.Scanner;

public class AdminLoginMenu {

    public void show() {
        System.out.println("请输入用户名");
        Scanner sc=new Scanner(System.in);
        String username = sc.next();
        System.out.println("请输入密码：");
        String password=sc.next();

        IAdminDao dao=new AdminDaoImpl();
        Admin admin = dao.findByName(username);

        if (admin==null)
        {
            System.out.println("用户名错误!返回首页重新登录");
            return;
        }else
            {
                if (password.equals(admin.getPassword()))
                {
                    System.out.println("登录成功！");
                    System.out.println("欢迎管理员"+admin.getAdminName()+"进入...");
                    AdminMgrMenu amm=new AdminMgrMenu();
                    amm.show();
                }else {
                    System.out.println("密码错误，重新登录");
                    return;
                }

            }

    }
}
