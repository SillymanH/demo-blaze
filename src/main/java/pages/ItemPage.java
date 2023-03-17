package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static pageObjects.ItemPageObjects.*;

public class ItemPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ItemPage(WebDriver driver, WebDriverWait webDriverWait) {

        this.driver = driver;
        this.wait = webDriverWait;
    }

    public void addToCart() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART_BUTTON));
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public String getSuccessAddToCartMessage() {

        wait.until(ExpectedConditions.alertIsPresent());
        String successMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return successMessage;
    }

    public void goToCart() {
        driver.findElement(CART_LINK).click();
    }

    public void clickPlaceOrderButton() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(PLACE_ORDER_BUTTON));
        driver.findElement(PLACE_ORDER_BUTTON).click();
    }

    public void fillOrderForm() {

        // TODO: 18/03/2023 Read data from data sheet
        wait.until(ExpectedConditions.visibilityOfElementLocated(PLACE_ORDER_FORM));
        driver.findElement(NAME_FIELD).sendKeys("Sleiman");
        driver.findElement(COUNTRY_FIELD).sendKeys("Saudi Arabia");
        driver.findElement(CITY_FIELD).sendKeys("Riyadh");
        driver.findElement(CREDIT_CARD).sendKeys("1234123412341234");
        driver.findElement(MONTH_FIELD).sendKeys("01");
        driver.findElement(YEAR_FIELD).sendKeys("2030");
        driver.findElement(PURCHASE_BUTTON).click();
    }

    public boolean getSuccessPurchaseButton() {

        // TODO: 18/03/2023 Read success message from data sheet
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_PURCHASE_POPUP));
        List<WebElement> headers = driver.findElements(HEADER_ELEMENTS);
        for (WebElement header: headers) {
            if (header.getText().equals("Thank you for your purchase!"))
                return true;
        }
        return false;
    }
}
