package com.neusoft.elm.view.Bussiness;

import com.neusoft.elm.po.Bussiness;

import java.util.Scanner;

public class BusinessMain extends Thread{
    public static  void main(String[] args)  {


            System.out.println("欢迎进入商家管理平台....");
            System.out.println("1.注册商家...");
            System.out.println("2.登录商家...");
            System.out.println("3.退出程序...");

        Bussiness bussiness=new Bussiness();
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("正在进入注册界面，请根据指示操作......");

                    BussinessRegMenu brm = new BussinessRegMenu();
                    brm.show();
                    break;
                case 2:
                    System.out.println("正在登录商家......");

                    BussinessLoginMenu blm = new BussinessLoginMenu();
                    blm.show();
                    break;
                case 3:
                    System.out.println("程序正在退出...");
                    System.out.println("退出成功....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误，请勿输入其他无关字符...");
            }
        }
    }
