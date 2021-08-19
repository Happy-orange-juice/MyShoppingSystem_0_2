package MyShoppingSystem_0_2;

import java.util.Scanner;

/**
 * @author ����
 */
public class Menu {
    page page = new page();
    public void showPage(Data data){
        page.show_LoginMenu();
        verify ver = new verify();
        boolean flag;
        do {
            Menu menu = new Menu();
            Scanner scanner = new Scanner(System.in);
            String i = scanner.next();
            try{
                // �����û���һ���˵���ѡ��������ͬ����Ӧ��ע��������Ǿ����switch-case���÷�
                switch (i) {
                    case "1": // �û�ѡ��"��¼ϵͳ"
                        int j = 5;
                        System.out.print("�����������û�����");
                        String s1 = scanner.next();
                        // �����¼ϵͳ������
                        boolean flag1 = false;
                        for (int k = 0; k < data.users.size(); k++) {
                            if (data.users.get(k).userName.equals(s1)){
                                flag1=true;
                                break;
                            }
                        }
                        if (flag1){
                            for (int k = 0; k < j+1; k++) {
                                if (k<4){
                                    if(ver.User_verify(data)){
                                        menu.showUser(data,s1);
                                    }else {
                                        System.out.println("���Ѿ����"+(k+1)+"������,����"+(j-k-1)+"�λ���");
                                    }
                                } else if (k==5){
                                    System.out.println("�Բ�����û��Ȩ�޽���ϵͳ��лл!���˻��Ѿ�������");
                                    showPage(data);
                                }
                            }
                        }else {
                            System.out.println("�Բ��𣬴��û������ڣ������������û�����");
                            showPage(data);
                        }
                        break;

                    case "2": // ����Աѡ��"��¼ϵͳ"
                        int k = 5;
                        System.out.print("�����������û�����");
                        String s2 = scanner.next();
                        if (!data.master.M_username.equals(s2)){
                            System.out.println("�Բ��𣬴��û������ڣ������������û�����");
                            showPage(data);
                        }
                        else {
                            for (int l = 0; l<=k+1; l++) {
                                if (l<=4){
                                    if(ver.Master_verify(data)){
                                        menu.showMasterMenu(data);
                                        break;
                                    }else {
                                        System.out.println("���Ѿ����"+(l+1)+"������,����"+(k-l-1)+"�λ���");
                                    }
                                } else if (l==5){
                                    System.out.println("�Բ�����û��Ȩ�޽���ϵͳ��лл!���˻��Ѿ�������");
                                    showPage(data);
                                }
                            }
                        }
                        break;
                    case "3"://�û���ע��һ���˺�
                        System.out.println("��ӭע�����ǵ��˻�");
                        System.out.println("��ʾ1���û����������5λ");
                        System.out.println("��ʾ2���û�����������8λ�ұ��������֡���Сд��ĸ�Լ�������");
                        User user = new User();
                        user.user_register(data);
                        break;
                    case "4": // �û�ѡ��"�˳�"
                        System.out.println("лл����ʹ�ã�");
                        System.exit(0);
                        break;
                    default: // һ���˵����������Ҫ����ѡ��
                        System.out.print("\n��������������ѡ��");
                        menu.showPage(data);
                        break;
                }
            }
            catch (NumberFormatException numberFormatException){
                System.out.println("������һ�����֣�");
                menu.showPage(data);
            }
            flag=false;
        } while (flag);
    }
    public void showMasterMenu(Data data) {
        boolean flag;
        label:
        do {
            page.show_master();
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            switch (s) {
                case "1":
                    for (int i = 0; i < data.users.size(); i++) {
                        System.out.println(data.users.get(i).userID + " " + data.users.get(i).userName
                                + " " + data.users.get(i).user_phoneNumber + " " + data.users.get(i).user_email
                                + " "+ data.users.get(i).user_rg_time);
                    }
                    break;
                case "2": {
                    System.out.println("������Ҫ��ѯ���û�ID:");
                    int n = scanner.nextInt();
                    for (int j = 0; j < data.users.size(); j++) {
                        if (data.users.get(j).userID == n) {
                            System.out.println(data.users.get(j).userID + " " + data.users.get(j).userName
                                    + " " + data.users.get(j).user_phoneNumber + " " + data.users.get(j).user_email
                                    + " "+ data.users.get(j).user_rg_time);
                            break;
                        }
                    }
                    break;
                }
                //ɾ���û���Ϣ
                case "3": {
                    System.out.println("������Ҫɾ�����û�ID:");
                    int n = scanner.nextInt();
                    System.out.println("ȷ��Ҫɾ������û���ɾ���Ժ��޷��ָ�:Y/n");
                    String s2 = scanner.next();
                    if (s2.equals("y") || s2.equals("Y") || s2.equals("yes") || s2.equals("Yes")) {
                        for (int j = 0; j < data.users.size(); j++) {
                            if (data.users.get(j).userID == n) {
                                data.users.remove(j);
                                break;
                            }
                        }
                    } else {
                        break label;
                    }
                }
                //�����û�����
                case "4": {
                    System.out.println("������Ҫ���Ƶ��û�ID:");
                    int n = scanner.nextInt();
                    for (int j = 0; j < data.users.size(); j++) {
                        if (data.users.get(j).userID == n) {
                            data.users.get(j).password = "123123123";
                            System.out.println("�����Ѿ�����Ϊ123123123");
                            break;
                        }
                    }
                    break;
                }
                //������Ʒ�������
                case "5":
                    showGoods_information(data);
                    break;
                case "6":
                    System.out.println("�������޸ĺ�����룺");
                    data.master.M_password=scanner.next();
                    System.out.println("�����Ѿ��޸ĳɹ����´ε�½��ʹ��������");
                    showPage(data);
                    break ;
                // �ͻ�ѡ��"������һ���˵�"
                case "n":
                    showPage(data);
                    break label;
                default:
                    System.out.println("�������, �������������֣�");
                    break;
            }
            flag = false;
        } while (!flag);
    }
    public void showGoods_information(Data data){
        boolean flag;
        label:
        do {
            page.show_goods();
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            flag = false;
            switch (s) {
                case "1" -> {
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
                }
                case "2" -> {
                    System.out.println("������Ҫ��ѯ����ƷID:");
                    int n = scanner.nextInt();
                    for (int i = 0; i < data.goods.size(); i++) {
                        if (data.goods.get(i).goodsID == n) {
                            System.out.println(data.goods.get(i).goodsID + "  " +
                                    data.goods.get(i).goodsName + "  " + data.goods.get(i).Producer + "  " +
                                    data.goods.get(i).goods_size + "  " + data.goods.get(i).goods_Date + "  " +
                                    data.goods.get(i).goods_count + "  " + data.goods.get(i).goods_s_count + "  " +
                                    data.goods.get(i).goods_number + "\n");
                            break;
                        }
                    }
                }
                case "3" -> {
                    System.out.println("������Ҫɾ������ƷID:");
                    int n = scanner.nextInt();
                    System.out.println("ȷ��Ҫɾ�������Ʒ��ɾ���Ժ��޷��ָ�:Y/n");
                    String s2 = scanner.next();
                    if (s2.equals("y") || s2.equals("Y") || s2.equals("yes") || s2.equals("Yes")) {
                        for (int j = 0; j < data.goods.size(); j++) {
                            if (data.goods.get(j).goodsID == n) {
                                data.goods.remove(j);
                                break;
                            }
                        }
                    } else {
                        break label;
                    }
                }
                case "4" ->{
                    Goods goods = new Goods();
                    goods.goods_modify(data);
                    break ;
                }
                case "5" ->{
                    Goods goods = new Goods();
                    goods.goods_add(data);
                    break ;
                }
                case "n" -> showMasterMenu(data);
            }
        } while (!flag);
    }
    public void showUser(Data data, String s){
        page.show_MainMenu();
        boolean flag= false;
        do {
            Scanner scanner = new Scanner(System.in);
            String ss = scanner.next();
            switch (ss) {
                case "1" -> {
                    showBuy(data,s);
                }
                case "2" -> {
                    User u = new User();
                    u.user_password_modify(data,s);
                }
                case "3" -> {
                    System.out.println("ȷ�ϵǳ�");
                    if (scanner.next().equals("y")||scanner.next().equals("Y")||scanner.next().equals("yes")||scanner.next().equals("Yes")){
                        showPage(data);
                    }
                }
                case "n" -> showPage(data);
            }
        } while (!flag);
    }
    public void showBuy(Data data, String s){
        page.show_buy();
        boolean flag= false;
        Shopping shopping = new Shopping();
        do {
            Scanner scanner = new Scanner(System.in);
            String ss = scanner.next();
            switch (ss) {
                case "1" -> {
                    shopping.list(data,s);
                }
                case "2" -> {
                    shopping.buy(data,s);
                }
                case "3" -> {
                    shopping.count(data,s);
                }
                case "n" -> showUser(data,s);
            }
        } while (!flag);
    }
}
