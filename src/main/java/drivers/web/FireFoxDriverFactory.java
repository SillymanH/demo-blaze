package drivers.web;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverFactory extends DriverFactory {

    //For the sake of this test we are not going to implement FireFoxDriverManager.java since we are only going
    // to use chrome

    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver();
    }
}
