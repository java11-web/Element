package com.neusoft.elm.view.Admin;

import java.util.Scanner;

public class AdminMgrMenu {
//管理员管理界面

    public void show() {
        System.out.println("请问您要做什么？");
        System.out.println("1.显示商家所有信息......");
        System.out.println("2.根据门牌号删除商家.....");

        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();

        switch (i)
        {
            case 1:
                AdminRegMenu1 arm1=new AdminRegMenu1();
                arm1.show();
                break;

            case 2:
                AdminRegMenu2 arm2=new AdminRegMenu2();
                arm2.show();
                break;

            default:
                System.out.println("输入错误,不要乱输.....");
        }

    }

    }

