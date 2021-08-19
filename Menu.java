package MyShoppingSystem_0_2;

import java.util.Scanner;

/**
 * @author 李宗
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
                // 根据用户对一级菜单的选择做出不同的响应，注意这里就是经典的switch-case的用法
                switch (i) {
                    case "1": // 用户选择"登录系统"
                        int j = 5;
                        System.out.print("请输入您的用户名：");
                        String s1 = scanner.next();
                        // 处理登录系统的流程
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
                                        System.out.println("您已经输错"+(k+1)+"次密码,还有"+(j-k-1)+"次机会");
                                    }
                                } else if (k==5){
                                    System.out.println("对不起！您没有权限进入系统！谢谢!该账户已经锁死！");
                                    showPage(data);
                                }
                            }
                        }else {
                            System.out.println("对不起，此用户不存在，请重新输入用户名：");
                            showPage(data);
                        }
                        break;

                    case "2": // 管理员选择"登录系统"
                        int k = 5;
                        System.out.print("请输入您的用户名：");
                        String s2 = scanner.next();
                        if (!data.master.M_username.equals(s2)){
                            System.out.println("对不起，此用户不存在，请重新输入用户名：");
                            showPage(data);
                        }
                        else {
                            for (int l = 0; l<=k+1; l++) {
                                if (l<=4){
                                    if(ver.Master_verify(data)){
                                        menu.showMasterMenu(data);
                                        break;
                                    }else {
                                        System.out.println("您已经输错"+(l+1)+"次密码,还有"+(k-l-1)+"次机会");
                                    }
                                } else if (l==5){
                                    System.out.println("对不起！您没有权限进入系统！谢谢!该账户已经锁死！");
                                    showPage(data);
                                }
                            }
                        }
                        break;
                    case "3"://用户新注册一个账号
                        System.out.println("欢迎注册我们的账户");
                        System.out.println("提示1：用户名必须大于5位");
                        System.out.println("提示2：用户密码必须大于8位且必须由数字、大小写字母以及标点组成");
                        User user = new User();
                        user.user_register(data);
                        break;
                    case "4": // 用户选择"退出"
                        System.out.println("谢谢您的使用！");
                        System.exit(0);
                        break;
                    default: // 一级菜单输入错误，需要重新选择
                        System.out.print("\n输入有误！请重新选择");
                        menu.showPage(data);
                        break;
                }
            }
            catch (NumberFormatException numberFormatException){
                System.out.println("请输入一个数字！");
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
                    System.out.println("请输入要查询的用户ID:");
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
                //删除用户信息
                case "3": {
                    System.out.println("请输入要删除的用户ID:");
                    int n = scanner.nextInt();
                    System.out.println("确认要删除这个用户吗？删除以后无法恢复:Y/n");
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
                //重置用户密码
                case "4": {
                    System.out.println("请输入要重制的用户ID:");
                    int n = scanner.nextInt();
                    for (int j = 0; j < data.users.size(); j++) {
                        if (data.users.get(j).userID == n) {
                            data.users.get(j).password = "123123123";
                            System.out.println("密码已经重置为123123123");
                            break;
                        }
                    }
                    break;
                }
                //进入商品管理界面
                case "5":
                    showGoods_information(data);
                    break;
                case "6":
                    System.out.println("请输入修改后的密码：");
                    data.master.M_password=scanner.next();
                    System.out.println("密码已经修改成功，下次登陆将使用新密码");
                    showPage(data);
                    break ;
                // 客户选择"返回上一级菜单"
                case "n":
                    showPage(data);
                    break label;
                default:
                    System.out.println("输入错误, 请重新输入数字：");
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
                }
                case "2" -> {
                    System.out.println("请输入要查询的商品ID:");
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
                    System.out.println("请输入要删除的商品ID:");
                    int n = scanner.nextInt();
                    System.out.println("确认要删除这个商品吗？删除以后无法恢复:Y/n");
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
                    System.out.println("确认登出");
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
