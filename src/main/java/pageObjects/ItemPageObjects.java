package pageObjects;

import org.openqa.selenium.By;

public class ItemPageObjects {

    public static final By ADD_TO_CART_BUTTON = By.partialLinkText("Add to cart");
    public static final By CART_LINK = By.id("cartur");
    public static final By PLACE_ORDER_BUTTON = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    public static final By PLACE_ORDER_FORM = By.xpath("//*[@id=\"orderModal\"]/div/div/div[2]/form//*");
    public static final By NAME_FIELD = By.id("name");
    public static final By COUNTRY_FIELD = By.id("country");
    public static final By CITY_FIELD = By.id("city");
    public static final By CREDIT_CARD = By.id("card");
    public static final By MONTH_FIELD = By.id("month");
    public static final By YEAR_FIELD = By.id("year");
    public static final By PURCHASE_BUTTON = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    public static final By SUCCESS_PURCHASE_POPUP = By.cssSelector("body > div.sweet-alert.showSweetAlert.visible");
    public static final By HEADER_ELEMENTS = By.tagName("h2");
}
