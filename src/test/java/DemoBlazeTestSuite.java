import org.testng.Assert;
import org.testng.annotations.*;

import static commons.FileIO.getData;
import static commons.Utilities.generateRandomInt;

public class DemoBlazeTestSuite extends TestSetup{

    @Test(priority = 1, description = "Register and login")
    public void REGISTER_AND_LOGIN() throws Exception {

        String username = "qpros+" + generateRandomInt(1, 99999) + "@test.com";
        String password = getData("PASSWORD");

        homePage.goToHomePage(homePageURL);
        homePage.clickSignUpLink();
        homePage.signUp(username, password);
        Assert.assertEquals(homePage.getSignUpSuccessMessage(), getData("SIGNUP_SUCCESS_MESSAGE"));
        homePage.clickLoginLink();
        homePage.login(username, password);
        Assert.assertEquals(homePage.getLoginWelcomeMessage(), "Welcome " + username);
    }

    @Test(priority = 2, description = "Validate the category list has items")
    public void CHECK_CATEGORY_LIST_HAS_ITEMS() {
        homePage.goToHomePage(homePageURL);
        Assert.assertTrue(homePage.verifyCategoryList());
    }

    @Test(priority = 3, description = "Add random item to cart")
    public void ADD_RANDOM_ITEM_TO_CART() throws Exception {

        homePage.goToHomePage(homePageURL);
        homePage.selectRandomItem();
        itemPage.addToCart();
        Assert.assertEquals(itemPage.getSuccessAddToCartMessage(), getData("SUCCESS_ADD_TO_CART_MESSAGE"));
    }

    @Test(priority = 4, description = "Remove item from cart")
    public void REMOVE_ITEM_FROM_CART() throws Exception {

        homePage.goToHomePage(homePageURL);
        ADD_RANDOM_ITEM_TO_CART();
        itemPage.goToCart();
        cartPage.removeItem();
        Assert.assertTrue(cartPage.validateItemRemovedFromCart());
    }

    @Test(priority = 5, description = "Complete successful checkout with random item")
    public void COMPLETE_CHECKOUT() throws Exception {

        homePage.goToHomePage(homePageURL);
        ADD_RANDOM_ITEM_TO_CART();
        itemPage.goToCart();
        itemPage.clickPlaceOrderButton();
        itemPage.fillOrderForm();
        Assert.assertTrue(itemPage.getSuccessPurchaseButton());
    }
}
