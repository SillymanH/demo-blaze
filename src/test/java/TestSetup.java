import drivers.DriverFactory;
import drivers.web.ChromeDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.CartPage;
import pages.HomePage;
import pages.ItemPage;

public class TestSetup {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static HomePage homePage;
    protected static ItemPage itemPage;
    protected static CartPage cartPage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        // TODO: 17/03/2023 Read browser name from data sheet
        driver = DriverFactory.getDriver("chrome");
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
