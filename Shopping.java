package MyShoppingSystem_0_2;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * @author 李宗
 */
public class Shopping {
    Menu menu = new Menu();
    public void list(Data data, String s){
        System.out.println("商品编号" + "  商品名称" +
                "  生产商" + "  商品尺寸" +
                "  生产日期" + "  进价" +
                "  售价" + "  商品剩余量" + "\n");
        for (int i = 0; i < data.goods.size(); i++) {
            System.out.println(data.goods.get(i).goodsID + "  " +
                    data.goods.get(i).goodsName + "  " + data.goods.get(i).Producer + "  " +
                    data.goods.get(i).goods_size + "  " + data.goods.get(i).goods_Date + "  " +
                    data.goods.get(i).goods_count + "  " + data.goods.get(i).goods_s_count + "  " +
                    data.goods.get(i).goods_number + "\n");
        }
        menu.showBuy(data,s);
    }
    public void buy(Data data, String s){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要购买的商品ID:");
        int n = sc.nextInt();
        System.out.println("请输入要购买的商品数量:");
        int m = sc.nextInt();
        for (int i = 0; i < data.goods.size(); i++) {
            if (data.goods.get(i).goodsID==n){
                for (int j = 0; j < data.users.size(); j++) {
                    if (data.users.get(j).userName.equals(s)){
                        if(m<=Integer.parseInt(data.goods.get(i).goods_number)) {
                            data.users.get(j).user_bill += data.goods.get(i).goods_s_count*m;
                            data.goods.get(i).goods_number = String.valueOf(parseInt(data.goods.get(i).goods_number)-m);
                        } else if(m>Integer.parseInt(data.goods.get(i).goods_number)){
                            System.out.println("对不起，库存不足");
                        }
                    }
                }
            }
        }
        menu.showBuy(data,s);
    }
    public void count(Data data, String s){
        for (int j = 0; j < data.users.size(); j++) {
            if (data.users.get(j).userName.equals(s)){
                boolean flag;
                if (data.users.get(j).user_bill>=2000&&data.users.get(j).user_bill<=5000){
                    System.out.println("您的消费额为："+data.users.get(j).user_bill);
                    flag=pay(data,s);
                    if (flag){
                        System.out.println("您的消费额已经达到2000圆了！恭喜您，升级为铜牌用户");
                        data.users.get(j).userLever="铜牌用户";
                    }
                } else if(data.users.get(j).user_bill>5000&&data.users.get(j).user_bill<=10000){
                    System.out.println("您的消费额为："+data.users.get(j).user_bill);
                    flag=pay(data,s);
                    if (flag){
                        System.out.println("您的消费额已经达到5000圆了！恭喜您，升级为银牌用户");
                        data.users.get(j).userLever="银牌用户";
                    }
                } else if(data.users.get(j).user_bill>10000){
                    System.out.println("您的消费额为："+data.users.get(j).user_bill);
                    flag=pay(data,s);
                    if (flag){
                        System.out.println("您的消费额已经达到10000圆了！恭喜您，升级为金牌用户");
                        data.users.get(j).userLever="金牌用户";
                    }
                }
            }
        }
        menu.showBuy(data,s);
    }
    //以后可以增加一个余额的变量
    public boolean pay(Data data, String s){
        System.out.println("您确认要支付吗？Y/yes");
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        if(s1.equals("y")||s1.equals("Y")||s1.equals("yes")||s1.equals("Yes")){
            System.out.println("请输入您的密码");
            String s2 = sc.next();
            for (int i = 0; i < data.users.size(); i++) {
                if (data.users.get(i).userName.equals(s)) {
                    if (data.users.get(i).password.equals(s2)){
                        System.out.println("恭喜您，支付成功");
                        return true;
                    }else if (!data.users.get(i).password.equals(s2)){
                        System.out.println("支付密码错误！");
                        return false;
                    }
                }
            }
        }
        return false;
    }
}