package MyShoppingSystem_0_2;

import java.util.Scanner;

/**
 * @author 李宗
 * @date 2021/7/18
 */
public class verify {
    public verify() {
    }
    public boolean Master_verify(Data data) {
        Scanner scanner = new Scanner(System.in);
        // 由用户输入密码
        System.out.print("请输入您的密码：");
        scanner = new Scanner(System.in);
        String s2 = scanner.next();
        // 判断用户输入的信息是否和已有的信息一致
        if(data.master.M_password.equals(s2)){
            return true;
        } else {
            return false;
        }
    }
    public boolean User_verify(Data data) {
        Scanner scanner = new Scanner(System.in);
        // 由用户输入密码
        System.out.print("请输入密码：");
        scanner = new Scanner(System.in);
        String s2 = scanner.next();

        for (int i = 0; i <data.users.size(); i++) {
                if(data.users.get(i).password.equals(s2));
                return true;
        }
        // 判断用户输入的信息是否和已有的信息一致
        return false;
    }
}
