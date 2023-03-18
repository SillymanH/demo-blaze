import commons.FileIO;
import drivers.DriverFactory;
import drivers.web.ChromeDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.CartPage;
import pages.HomePage;
import pages.ItemPage;

import static commons.FileIO.getData;

public class TestSetup {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static HomePage homePage;
    protected static ItemPage itemPage;
    protected static CartPage cartPage;
    protected static String homePageURL;
    protected static String browserName;

    @BeforeSuite(alwaysRun = true)
    public void init() throws Exception {
        homePageURL = getData("HOME_PAGE_URL");
        browserName = getData("BROWSER");
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        driver = DriverFactory.getDriver(browserName);
        wait = ChromeDriverFactory.getWebDriverWait();
        homePage = new HomePage(driver, wait);
        itemPage = new ItemPage(driver, wait);
        cartPage = new CartPage(driver, wait);
    }

    @AfterMethod(alwaysRun = true)
    public void testCaseTearDown() {
        DriverFactory.quit();
    }
}
