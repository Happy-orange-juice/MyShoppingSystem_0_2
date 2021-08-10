package MyShoppingSystem_0_2;
import java.io.*;
/**
 * @author ����
 * @date 2021/8/10
 */
public class ReadTxtFile {
    public static void readTxt(String filePath) {
        try {
            File file = new File(filePath);
            if(file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                int count = 0;
                while ((lineTxt = br.readLine()) != null) {
                    System.out.println(lineTxt);
                    if (count==7){
                        count=0;
                        continue;
                    }
                    count++;
                    System.out.println("count:"+count);
                }
                br.close();
            } else {
                System.out.println("�ļ�������!");
            }
        } catch (Exception e) {
            System.out.println("�ļ���ȡ����!");
        }
    }
    public static void main(String[] args) {
        String filePath = "D:\\data.txt";
        readTxt(filePath);
    }
}
