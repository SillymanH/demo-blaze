package pageObjects;

import org.openqa.selenium.By;

public class HomePageObjects {

    public static final By SIGNUP_LINK = By.id("signin2");
    public static final By SIGNUP_FORM = By.xpath("//*[@id=\"signInModal\"]/div/div/div[2]/form//*");
    public static final By SIGNUP_USERNAME_FIELD = By.id("sign-username");
    public static final By SIGNUP_PASSWORD_FIELD = By.id("sign-password");
    public static final By LOGIN_LINK = By.id("login2");
    public static final By LOGIN_FORM = By.xpath("//*[@id=\"logInModal\"]/div/div/div[2]/form//*");
    public static final By LOGIN_USERNAME_FIELD = By.id("loginusername");
    public static final By LOGIN_PASSWORD_FIELD = By.id("loginpassword");
    public static final By SIGNUP_BUTTON = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
    public static final By LOGIN_BUTTON = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    public static final By LOGIN_WELCOME_MESSAGE_LABEL = By.id("nameofuser");
    public static final By CATEGORY_LIST_GROUP = By.className("list-group-item");
    public static final By ITEMS_TABLE = By.xpath("//*[@id=\"tbodyid\"]/*");
}
