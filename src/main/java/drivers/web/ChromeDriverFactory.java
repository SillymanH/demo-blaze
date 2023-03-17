package drivers.web;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverFactory extends DriverFactory {

    @Override
    public WebDriver createDriver() {

        ChromeOptions options = new ChromeOptions();

        //To avoid having error "Invalid Status code=403 text=Forbidden"
        options.addArguments("--remote-allow-origins=*");

        //To maximize window on chrome
        options.addArguments("--start-maximized");

       return new ChromeDriver(options);
    }
}
