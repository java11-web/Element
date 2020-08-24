package com.neusoft.elm.view.Admin;

import java.util.Scanner;

public class AdminMain {
    public static void main(String[] args)
    {
        while (true)
        {
            System.out.println("欢迎进入饿了么管理后台");
            System.out.println("1------管理员注册");
            System.out.println("2------登录");
            System.out.println("3------退出");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("即将进入注册界面..");
                    AdminRegMenu arm = new AdminRegMenu();
                    arm.show();
                    break;

                case 2:
                    System.out.println("即将进入登录界面..");
                    AdminLoginMenu alm=new AdminLoginMenu();
                    alm.show();
                    break;

                case 3:
                    System.out.println("已经退出.....");
                    System.exit(0);

                default:
                    System.out.println("输入错误");
                    break;
            }
        }
    }
}