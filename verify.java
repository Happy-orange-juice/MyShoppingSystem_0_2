package MyShoppingSystem_0_2;

import java.util.Scanner;

/**
 * @author ����
 * @date 2021/7/18
 */
public class verify {
    public verify() {
    }
    public boolean Master_verify(Data data) {
        Scanner scanner = new Scanner(System.in);
        // ���û���������
        System.out.print("�������������룺");
        scanner = new Scanner(System.in);
        String s2 = scanner.next();
        // �ж��û��������Ϣ�Ƿ�����е���Ϣһ��
        if(data.master.M_password.equals(s2)){
            return true;
        } else {
            return false;
        }
    }
    public boolean User_verify(Data data) {
        Scanner scanner = new Scanner(System.in);
        // ���û���������
        System.out.print("���������룺");
        scanner = new Scanner(System.in);
        String s2 = scanner.next();

        for (int i = 0; i <data.users.size(); i++) {
                if(data.users.get(i).password.equals(s2));
                return true;
        }
        // �ж��û��������Ϣ�Ƿ�����е���Ϣһ��
        return false;
    }
}
