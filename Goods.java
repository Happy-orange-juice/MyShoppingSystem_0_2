package MyShoppingSystem_0_2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author ����
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
        System.out.println("��������Ҫ�޸ĵ���Ʒ��ţ�");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < data.goods.size(); i++) {
            if(data.goods.get(i).goodsID==n){
                page.show_Goods_change();
                System.out.println("��������Ҫ�޸ĵ����ݱ�ţ�");
                String l = sc.next();
                switch (l){
                    case "1"->{
                        System.out.println("������Ҫ�޸ĺ����Ʒ���ƣ�");
                        String s = sc.next();
                        data.goods.get(i).goodsName = s;
                    }
                    case "2"->{
                        System.out.println("������Ҫ�޸ĺ����������:");
                        String s = sc.next();
                        data.goods.get(i).Producer = s;
                    }
                    case "3"->{
                        System.out.println("������Ҫ�޸ĺ����������:");
                        String s = sc.next();
                        data.goods.get(i).goods_Date = s;
                    }
                    case "4"->{
                        System.out.println("������Ҫ�޸ĺ�Ĳ�Ʒ�ͺ�:");
                        String s = sc.next();
                        data.goods.get(i).goods_size = s;
                    }
                    case "5"->{
                        System.out.println("������Ҫ�޸ĺ�Ĳ�Ʒ����:");
                        String s = sc.next();
                        data.goods.get(i).goods_number = s;
                    }
                    case "6"->{
                        System.out.println("������Ҫ�޸ĺ�Ĳ�Ʒ����:");
                        int s = sc.nextInt();
                        data.goods.get(i).goods_count = s;
                    }
                    case "7"->{
                        System.out.println("������Ҫ�޸ĺ�Ĳ�Ʒ�ۼ�:");
                        int s = sc.nextInt();
                        data.goods.get(i).goods_s_count = s;
                    }
                }
            }
        }
    }
    public void goods_add(Data data){
        Scanner sc = new Scanner(System.in);

    }
}
