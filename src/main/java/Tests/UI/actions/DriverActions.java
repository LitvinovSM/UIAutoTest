package Tests.UI.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverActions {

    /**
     * Any following expected driver type should be installed local before
     */
    private final String CHROME = "chrome";
    private final String SAFARI = "safari";
    private final String FIREFOX = "firefox";
    private final String EDGE = "edge";
    String driverType = "firefox";
    private WebDriver driver = getDriverByType(driverType);
    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver getDriverByType(String driverType) {
        WebDriver driver;
        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                driver = null;
        }
        return driver;
    }


}
