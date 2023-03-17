package pageObjects;

import org.openqa.selenium.By;

public class CartPageObjects {

    public static final By REMOVE_ITEM_LINK = By.linkText("Delete");
    public static final By CART_ITEMS_TABLE = By.xpath("//*[@id=\"tbodyid\"]/*");
}
