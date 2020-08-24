package com.neusoft.elm.view.Bussiness;

import com.neusoft.elm.po.Bussiness;
import com.neusoft.elm.view.Food.AddFood;
import com.neusoft.elm.view.Food.DeleteFood;
import com.neusoft.elm.view.Food.ShowFood;
import com.neusoft.elm.view.Food.UpdataFood;

import java.util.Scanner;

public class BussinessMgrMenu {
    public void show(Bussiness bussiness) {

        System.out.println("请问您要做什么？");
        System.out.println("1.增加商品");
        System.out.println("2.修改商品价格");
        System.out.println("3.查看商品");
        System.out.println("4.删除商品");

        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        switch (i)
        {
            case 1:
                AddFood af=new AddFood();
                af.show(bussiness);
                break;
            case 2:
                UpdataFood uf=new UpdataFood();
                uf.show();
                break;
            case 3:
                ShowFood sf=new ShowFood();
                sf.show(bussiness);
                break;
            case 4:
                DeleteFood df=new DeleteFood();
                df.show();
                break;
        }


    }
}
