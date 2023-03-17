import org.testng.Assert;
import org.testng.annotations.*;

import static commons.Utilities.generateRandomInt;

public class DemoBlazeTestSuite extends TestSetup{

    @Test(priority = 1, description = "Register and login")
    public void REGISTER_AND_LOGIN() {

        String username = "qpros+" + generateRandomInt(1, 99999) + "@test.com";
        String password = "Password@123";

        // TODO: 17/03/2023 Read from data sheet
        homePage.goToHomePage();
        homePage.clickSignUpLink();
        homePage.signUp(username, password);
        Assert.assertEquals(homePage.getSignUpSuccessMessage(), "Sign up successful.");
        homePage.clickLoginLink();
        homePage.login(username, password);
        Assert.assertEquals(homePage.getLoginWelcomeMessage(), "Welcome " + username);
    }

    @Test(priority = 2, description = "Validate the category list has items")
    public void CHECK_CATEGORY_LIST_HAS_ITEMS() {
        homePage.goToHomePage();
        Assert.assertTrue(homePage.verifyCategoryList());
    }

    @Test(priority = 3, description = "Add random item to cart")
    public void ADD_RANDOM_ITEM_TO_CART() {

        homePage.goToHomePage();
        homePage.selectRandomItem();
        itemPage.addToCart();
        Assert.assertEquals(itemPage.getSuccessAddToCartMessage(), "Product added");
    }

    @Test(priority = 4, description = "Remove item from cart")
    public void REMOVE_ITEM_FROM_CART() {

        homePage.goToHomePage();
        ADD_RANDOM_ITEM_TO_CART();
        itemPage.goToCart();
        cartPage.removeItem();
        Assert.assertTrue(cartPage.validateItemRemovedFromCart());
    }

    @Test(priority = 5, description = "Complete successful checkout with random item")
    public void COMPLETE_CHECKOUT() {

        homePage.goToHomePage();
        ADD_RANDOM_ITEM_TO_CART();
        itemPage.goToCart();
        itemPage.clickPlaceOrderButton();
        itemPage.fillOrderForm();
        Assert.assertTrue(itemPage.getSuccessPurchaseButton());
    }
}
