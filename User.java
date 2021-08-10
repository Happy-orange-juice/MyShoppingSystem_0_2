package MyShoppingSystem_0_2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 李宗
 * @date 2021/7/18
 */
public class User {
    /*====================定义该类所拥有的变量====================*/
    public String userName;		// 用户名
    public String password;		// 密码
    public int    userID;	// 顾客的ID
    public String userLever;	// 用户级别
    public String user_phoneNumber;
    public String user_email;
    public String user_rg_time;
    public int user_bill;
    Menu m = new Menu();
    public User() {
        userName         = new String();
        password         = new String();
        userLever 	     = new String();
        user_email       = new String();
        user_phoneNumber = new String();
        user_rg_time     = new String();
    }
    public void user_register(Data data){
        User user = new User();
        Scanner sc = new Scanner(System.in);
        int n = data.users.size();
        System.out.println("您的编号已经自动生成为："+(n+1));
        user.userID=n+1;
        System.out.println("请输入您的用户名：");
        String s = sc.next();
        if (s.length()<5){
            System.out.println("用户名必须大于5位");
            m.showPage(data);
        } else {
            for (int i = 0; i < data.users.size(); i++) {
                if (s.equals(data.users.get(i).userName)){
                    System.out.println("此用户名已经存在！！！");
                    m.showPage(data);
                }
            }
            System.out.println("此用户名是合法的");
            user.userName=s;
        }
        System.out.println("请输入您的密码");
        String s1 = sc.next();
        if (user_password_judge(s1)){
            System.out.println("请再次确认密码：");
            String s2 = sc.next();
            if (s1.equals(s2)){
                System.out.println("恭喜您，注册成功");
                user.password=s2;
            } else {
                System.out.println("两次输入的密码不一样！");
                m.showPage(data);
            }
        } else {
            System.out.println("密码必须包括数字、大小写字母和标点符号！");
            m.showPage(data);
        }
        Date dateTime=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime=df.format(dateTime);
        user.user_rg_time=currentTime;
        System.out.println("请输入您的电话号码：");
        String s2 = sc.next();
        user.user_phoneNumber=s2;
        System.out.println("请输入您的邮箱地址：");
        String s3 = sc.next();
        user.user_email=s3;
        data.users.add(user);
        m.showPage(data);
    }

    public void user_password_modify(Data data, String s){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < data.users.size(); i++) {
            if (data.users.get(i).userName.equals(s)){
                System.out.println("请输入您修改后的密码");
                String s1 = sc.next();
                if (user_password_judge(s1)){
                    System.out.println("请再次确认修改后的密码：");
                    String s2 = sc.next();
                    if (s1.equals(s2)){
                        System.out.println("恭喜您，密码修改成功");
                        data.users.get(i).password=s1;
                        m.showPage(data);
                    } else {
                        System.out.println("两次输入的密码不一样！");
                        m.showUser(data,s);
                    }
                } else {
                    System.out.println("密码必须包括数字、大小写字母和标点符号！");
                    m.showUser(data,s);
                }
            }
        }
    }
    public boolean user_password_judge(String s){
        if (s.length()>8){
            if (isPswComplex(s)){
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
    public boolean isPswComplex(String password){
        //数字
        final String REG_NUMBER = ".*\\d+.*";
        //大写字母
        final String REG_UPPERCASE = ".*[A-Z]+.*";
        //小写字母
        final String REG_LOWERCASE = ".*[a-z]+.*";

        if (password == null || password.length() <8 ) return false;
        int i = 0;
        if (password.matches(REG_NUMBER)) i++;
        if (password.matches(REG_LOWERCASE))i++;
        if (password.matches(REG_UPPERCASE)) i++;

        if(i<2)  return false;

        return true;
    }
}
