package MyShoppingSystem_0_2;

import jxl.read.biff.BiffException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * @author 李宗
 * 本类用于存放购物系统的初始化数据的数据类。
 */


public class Data {
    /*====================定义该类所拥有的变量====================*/
    public Master master	;	// 管理员类
    public List<User> users = new ArrayList<User>();
    public List<Goods> goods = new ArrayList<Goods>();
    public String name;
    public Data() {
        users   = new ArrayList<>();
        master  = new Master();
    }
    public void initial_people() throws BiffException, IOException {
        String filePath = "D:/db/data1.txt";
        readTxt_user(filePath);
        master.M_username="admin";
        master.M_password="ynuinfo#777";
    }
    public void readTxt_user(String filePath){
        try {
            File file = new File(filePath);
            if(file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                int count = 0;
                User u = new User();
                while ((lineTxt = br.readLine()) != null) {
                    if (count==0){
                        u.userID = parseInt(lineTxt);
                    } else if(count==1){
                        u.userName = lineTxt;
                    } else if(count==2){
                        u.userLever  = lineTxt;
                    } else if(count==3){
                        u.password  = lineTxt;
                    } else if(count==4){
                        u.user_email = lineTxt;
                    } else if(count==5){
                        u.user_phoneNumber = lineTxt;
                    } else if(count==6){
                        u.user_rg_time = lineTxt;
                    } else if (count==7){
                        u.user_bill = parseInt(lineTxt);
                        users.add(u);
                        count=0;
                        u=new User();
                        continue;
                    }
                    count++;
                }
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }
    }
    public void update_people(){

    }
    public void initial_goods() throws BiffException, IOException {
        String filePath = "D:/db/data.txt";
        readTxt_good(filePath);
    }
    public void update_goods(){
    }
    public void readTxt_good(String filePath) {
        try {
            File file = new File(filePath);
            if(file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                int count = 0;
                Goods g = new Goods();
                while ((lineTxt = br.readLine()) != null) {
                    if (count==0){
                        g.goodsID = parseInt(lineTxt);
                    } else if(count==1){
                        g.goodsName = lineTxt;
                    } else if(count==2){
                        g.Producer  = lineTxt;
                    } else if(count==3){
                        g.goods_Date  = lineTxt;
                    } else if(count==4){
                        g.goods_size = lineTxt;
                    } else if(count==5){
                        g.goods_number = lineTxt;
                    } else if(count==6){
                        g.goods_count = parseInt(lineTxt);
                    } else if (count==7){
                        g.goods_s_count = parseInt(lineTxt);
                        goods.add(g);
                        g=new Goods();
                        count=0;
                        continue;
                    }
                    count++;
                }
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }
    }
}