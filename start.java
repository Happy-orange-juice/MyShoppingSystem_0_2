package MyShoppingSystem_0_2;

import jxl.read.biff.BiffException;

import java.io.IOException;

/**
 * @author Àî×Ú
 */
public class start {
    public start() {}
    public static void main(String[] args) throws BiffException, IOException {
        Menu menu = new Menu();
        Data data = new Data();
        data.initial_people();
        data.initial_goods();
        menu.showPage(data);
    }
}
