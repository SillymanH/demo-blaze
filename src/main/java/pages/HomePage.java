package pages;

import commons.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static pageObjects.HomePageObjects.*;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final String homePageURL = "https://www.demoblaze.com/";

    public HomePage(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;
    }

    public void goToHomePage() {
        driver.get(homePageURL);
    }

    public void clickSignUpLink() {
        driver.findElement(SIGNUP_LINK).click();
    }
    public void clickLoginLink() {
        driver.findElement(LOGIN_LINK).click();
    }

    public void signUp(String username, String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(SIGNUP_FORM));
        driver.findElement(SIGNUP_USERNAME_FIELD).sendKeys(username);
        driver.findElement(SIGNUP_PASSWORD_FIELD).sendKeys(password);
        driver.findElement(SIGNUP_BUTTON).click();
    }

    public void login(String username, String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_FORM));
        driver.findElement(LOGIN_USERNAME_FIELD).sendKeys(username);
        driver.findElement(LOGIN_PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getLoginWelcomeMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_WELCOME_MESSAGE_LABEL));
        return driver.findElement(LOGIN_WELCOME_MESSAGE_LABEL).getText();
    }

    public String getSignUpSuccessMessage() {
        wait.until(ExpectedConditions.alertIsPresent());
        String successMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return successMessage;
    }

    public boolean verifyCategoryList() {

        List<WebElement> categoryGroup = driver.findElements(CATEGORY_LIST_GROUP);
        for (WebElement category : categoryGroup) {

            //Skip CATEGORIES index because it's just the title and not an actual category
            if (!category.getText().equals("CATEGORIES") && !category.getText().equals(""))
                return true;
        }
        return false;
    }

    public void selectRandomItem() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(ITEMS_TABLE));
        List<WebElement> items = driver.findElements(ITEMS_TABLE);

        //Selecting a random item
        int min = 0;
        int max = items.size() - 1;
        int selectedItemIndex = Utilities.generateRandomInt(min, max);

        //We cannot click the item unless we go deeper and click the link
        WebElement selectedItem = items.get(selectedItemIndex);
        List<WebElement> selectedItemLinks = selectedItem.findElements(By.tagName("a"));
        for (WebElement link : selectedItemLinks) {
            if (link.getAttribute("href").contains("prod.html")) {
                link.click();
                break;
            }
        }
    }
}
