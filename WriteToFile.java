package MyShoppingSystem_0_2;
import java.io.*;
/**
 * @author 李宗
 * @date 2021/8/10
 */
public class WriteToFile {
    public static void main(String[] args) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("D:/db/outfilename.txt"));
            out.write("This a String write to file.\n");
            out.close();
            System.out.println("File created and write successfully");
        } catch (IOException e) {
            System.out.println("文件读取错误!");
        }
    }
}