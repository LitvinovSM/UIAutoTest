package Tests.UI.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverActions {

    String driverType = "chrome";

    private WebDriver driver = getDriverByType(driverType);

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver getDriverByType(String driverType) {
        WebDriver driver;
        switch (driverType) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                driver = null;
        }
        return driver;
    }



}
