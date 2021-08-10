package MyShoppingSystem_0_2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 李宗
 * @date 2021/7/19
 */
public class Goods {
    public String goodsName;
    public String Producer;
    public int    goodsID;
    public String goods_Date;
    public String goods_size;
    public String goods_number;
    public int goods_count;
    public int goods_s_count;
    page page = new page();
    Menu m = new Menu();
    public Goods() {
        goodsName     = new String();
        Producer      = new String();
        goods_Date 	  = new String();
        goods_size    = new String();
        goods_number  = new String();
    }
    public void goods_modify(Data data){
        System.out.println("请输入您要修改的商品编号：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = false;
        for (int i = 0; i < data.goods.size(); i++) {
            if(data.goods.get(i).goodsID==n){
                flag = true;
            }
        }
        if (flag){
            page.show_Goods_change();
            System.out.println("请输入您要修改的数据编号：");
            int l = sc.nextInt();

        }
    }
    public void goods_add(Data data){
        Scanner sc = new Scanner(System.in);

    }
}
