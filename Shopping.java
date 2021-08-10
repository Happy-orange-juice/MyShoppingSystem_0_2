package MyShoppingSystem_0_2;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * @author ����
 */
public class Shopping {
    Menu menu = new Menu();
    public void list(Data data, String s){
        System.out.println("��Ʒ���" + "  ��Ʒ����" +
                "  ������" + "  ��Ʒ�ߴ�" +
                "  ��������" + "  ����" +
                "  �ۼ�" + "  ��Ʒʣ����" + "\n");
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
        System.out.println("������Ҫ�������ƷID:");
        int n = sc.nextInt();
        System.out.println("������Ҫ�������Ʒ����:");
        int m = sc.nextInt();
        for (int i = 0; i < data.goods.size(); i++) {
            if (data.goods.get(i).goodsID==n){
                for (int j = 0; j < data.users.size(); j++) {
                    if (data.users.get(j).userName.equals(s)){
                        if(m<=Integer.parseInt(data.goods.get(i).goods_number)) {
                            data.users.get(j).user_bill += data.goods.get(i).goods_s_count*m;
                            data.goods.get(i).goods_number = String.valueOf(parseInt(data.goods.get(i).goods_number)-m);
                        } else if(m>Integer.parseInt(data.goods.get(i).goods_number)){
                            System.out.println("�Բ��𣬿�治��");
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
                    System.out.println("�������Ѷ�Ϊ��"+data.users.get(j).user_bill);
                    flag=pay(data,s);
                    if (flag){
                        System.out.println("�������Ѷ��Ѿ��ﵽ2000Բ�ˣ���ϲ��������Ϊͭ���û�");
                        data.users.get(j).userLever="ͭ���û�";
                    }
                } else if(data.users.get(j).user_bill>5000&&data.users.get(j).user_bill<=10000){
                    System.out.println("�������Ѷ�Ϊ��"+data.users.get(j).user_bill);
                    flag=pay(data,s);
                    if (flag){
                        System.out.println("�������Ѷ��Ѿ��ﵽ5000Բ�ˣ���ϲ��������Ϊ�����û�");
                        data.users.get(j).userLever="�����û�";
                    }
                } else if(data.users.get(j).user_bill>10000){
                    System.out.println("�������Ѷ�Ϊ��"+data.users.get(j).user_bill);
                    flag=pay(data,s);
                    if (flag){
                        System.out.println("�������Ѷ��Ѿ��ﵽ10000Բ�ˣ���ϲ��������Ϊ�����û�");
                        data.users.get(j).userLever="�����û�";
                    }
                }
            }
        }
        menu.showBuy(data,s);
    }
    //�Ժ��������һ�����ı���
    public boolean pay(Data data, String s){
        System.out.println("��ȷ��Ҫ֧����Y/yes");
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        if(s1.equals("y")||s1.equals("Y")||s1.equals("yes")||s1.equals("Yes")){
            System.out.println("��������������");
            String s2 = sc.next();
            for (int i = 0; i < data.users.size(); i++) {
                if (data.users.get(i).userName.equals(s)) {
                    if (data.users.get(i).password.equals(s2)){
                        System.out.println("��ϲ����֧���ɹ�");
                        return true;
                    }else if (!data.users.get(i).password.equals(s2)){
                        System.out.println("֧���������");
                        return false;
                    }
                }
            }
        }
        return false;
    }
}