package drivers;

import drivers.web.ChromeDriverFactory;
import drivers.web.FireFoxDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//We are going to use the factory design pattern to instantiate drivers
public abstract class DriverFactory {

    protected static WebDriver driver;

    protected abstract WebDriver createDriver();

    public static WebDriver getDriver(String browser) {

        switch (browser) {

            //For the sake of the test
            //we are only going to use the chrome driver
            case "firefox":
                if (driver == null) {
                    FireFoxDriverFactory fireFoxDriverFactory = new FireFoxDriverFactory();
                    driver = fireFoxDriverFactory.createDriver();
                }
                break;

            //Please note that we are using chrome driver version 111.0.5563.64 on MAC M1
            case "chrome":
                if (driver == null) {
                    String executablePath = System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver";
                    System.setProperty("webdriver.chrome.driver", executablePath);
                    ChromeDriverFactory chromeDriverFactory = new ChromeDriverFactory();
                    driver = chromeDriverFactory.createDriver();
                }
                break;
        }
        return driver;
    }

    public static WebDriverWait getWebDriverWait() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public static void quit() {
        driver.close();
        driver.quit();
        driver = null;
    }
}
