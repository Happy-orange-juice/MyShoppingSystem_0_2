package MyShoppingSystem_0_2;

import java.util.Scanner;

/**
 * @author 李宗
 */
public class page {

    public void show_goods(){
        System.out.println("购物管理系统 > 客户信息管理\n");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        System.out.println("\t\t\t\t 1. 显 示 所 有 商 品 信 息\n");
        System.out.println("\t\t\t\t 2. 查 询 商 品 信 息\n");
        System.out.println("\t\t\t\t 3. 删 除 商 品 信 息\n");
        System.out.println("\t\t\t\t 4. 修 改 商 品 信 息\n");
        System.out.println("\t\t\t\t 5. 增 加 商 品 信 息\n");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        System.out.print("请选择,输入数字或按'n'返回上一级菜单:");
    }
    public void show_master(){
        System.out.println("购物管理系统 > 客户信息管理\n");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        System.out.println("\t\t\t\t 1. 显 示 所 有 客 户 信 息\n");
        System.out.println("\t\t\t\t 2. 查 询 客 户 信 息\n");
        System.out.println("\t\t\t\t 3. 删 除 客 户 信 息\n");
        System.out.println("\t\t\t\t 4. 重 置 客 户 信 息\n");
        System.out.println("\t\t\t\t 5. 商 品 信 息 管 理\n");
        System.out.println("\t\t\t\t 6. 修 改 管 理 员 密 码\n");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        System.out.print("请选择,输入数字或按'n'返回上一级菜单:");
    }
    public void show_LoginMenu() {
        System.out.println("\n\n\t\t\t欢迎使用我的购物管理系统 如果是首次登陆请选择注册页面\n\n");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        System.out.println("\t\t\t\t 1. 用 户 登 录\n\n");
        System.out.println("\t\t\t\t 2. 管 理 员 登 陆\n\n");
        System.out.println("\t\t\t\t 3. 用 户 注 册\n\n");
        System.out.println("\t\t\t\t 4. 退 出\n\n");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        System.out.print("请选择,输入数字:");
    }
    public void show_MainMenu() {
        // 显示二级菜单，即系统的主菜单
        System.out.println("\n\n\t\t\t\t欢迎使用购物管理系统\n");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        System.out.println("\t\t\t\t 1. 购 物 系 统\n");
        System.out.println("\t\t\t\t 2. 修 改 密 码\n");
        System.out.println("\t\t\t\t 3. 用 户 登 出\n");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        // 用户选择服务项目
        System.out.print("请选择,输入数字:");
        Scanner scanner = new Scanner(System.in);
    }
    public void show_buy(){
        System.out.println("购物管理系统 > 购物平台\n");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        System.out.println("\t\t\t\t 1. 显 示 所 有 商 品 信 息\n");
        System.out.println("\t\t\t\t 2. 选 择 要 购 买 的 商 品\n");
        System.out.println("\t\t\t\t 3. 购 物 结 算\n");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        System.out.print("请选择,输入数字或按'n'返回上一级菜单:");
    }

    public void show_Goods_change(){
        System.out.println("购物管理系统 > 商品信息修改\n");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        System.out.println("\t\t\t\t 1. 商 品 名 称\n");
        System.out.println("\t\t\t\t 2. 生 产 产 家\n");
        System.out.println("\t\t\t\t 3. 生 产 日 期\n");
        System.out.println("\t\t\t\t 4. 产 品 型 号\n");
        System.out.println("\t\t\t\t 5. 产 品 数 量\n");
        System.out.println("\t\t\t\t 6. 产 品 进 价\n");
        System.out.println("\t\t\t\t 7. 产 品 售 价\n");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        System.out.print("请选择,输入数字或按'n'返回上一级菜单:");
    }
}
