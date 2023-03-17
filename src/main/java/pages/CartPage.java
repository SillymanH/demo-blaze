package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import static pageObjects.CartPageObjects.*;


public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CartPage(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;
    }

    public void removeItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CART_ITEMS_TABLE));
        driver.findElement(REMOVE_ITEM_LINK).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(REMOVE_ITEM_LINK));
    }

    public boolean validateItemRemovedFromCart() {

        List<WebElement> rows = driver.findElements(CART_ITEMS_TABLE);
        for (WebElement row: rows) {
            if (row.getAttribute("class").equals("success"))
                return false;
        }

        //This means there are no items in cart to be deleted
        return true;
    }
}
