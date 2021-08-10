package MyShoppingSystem_0_2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author ����
 * @date 2021/7/18
 */
public class User {
    /*====================���������ӵ�еı���====================*/
    public String userName;		// �û���
    public String password;		// ����
    public int    userID;	// �˿͵�ID
    public String userLever;	// �û�����
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
        System.out.println("���ı���Ѿ��Զ�����Ϊ��"+(n+1));
        user.userID=n+1;
        System.out.println("�����������û�����");
        String s = sc.next();
        if (s.length()<5){
            System.out.println("�û����������5λ");
            m.showPage(data);
        } else {
            for (int i = 0; i < data.users.size(); i++) {
                if (s.equals(data.users.get(i).userName)){
                    System.out.println("���û����Ѿ����ڣ�����");
                    m.showPage(data);
                }
            }
            System.out.println("���û����ǺϷ���");
            user.userName=s;
        }
        System.out.println("��������������");
        String s1 = sc.next();
        if (user_password_judge(s1)){
            System.out.println("���ٴ�ȷ�����룺");
            String s2 = sc.next();
            if (s1.equals(s2)){
                System.out.println("��ϲ����ע��ɹ�");
                user.password=s2;
            } else {
                System.out.println("������������벻һ����");
                m.showPage(data);
            }
        } else {
            System.out.println("�������������֡���Сд��ĸ�ͱ����ţ�");
            m.showPage(data);
        }
        Date dateTime=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime=df.format(dateTime);
        user.user_rg_time=currentTime;
        System.out.println("���������ĵ绰���룺");
        String s2 = sc.next();
        user.user_phoneNumber=s2;
        System.out.println("���������������ַ��");
        String s3 = sc.next();
        user.user_email=s3;
        data.users.add(user);
        m.showPage(data);
    }

    public void user_password_modify(Data data, String s){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < data.users.size(); i++) {
            if (data.users.get(i).userName.equals(s)){
                System.out.println("���������޸ĺ������");
                String s1 = sc.next();
                if (user_password_judge(s1)){
                    System.out.println("���ٴ�ȷ���޸ĺ�����룺");
                    String s2 = sc.next();
                    if (s1.equals(s2)){
                        System.out.println("��ϲ���������޸ĳɹ�");
                        data.users.get(i).password=s1;
                        m.showPage(data);
                    } else {
                        System.out.println("������������벻һ����");
                        m.showUser(data,s);
                    }
                } else {
                    System.out.println("�������������֡���Сд��ĸ�ͱ����ţ�");
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
        //����
        final String REG_NUMBER = ".*\\d+.*";
        //��д��ĸ
        final String REG_UPPERCASE = ".*[A-Z]+.*";
        //Сд��ĸ
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
