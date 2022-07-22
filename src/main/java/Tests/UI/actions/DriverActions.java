package Tests.UI.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverActions {

    /**
     * Any following expected driver type should be installed local before
     */
    private final String CHROME = "chrome";
    private final String SAFARI = "safari";
    private final String FIREFOX = "firefox";
    private final String EDGE = "edge";
    String driverType = "firefox";

    /**
     * экземпляр вебдрайвера который будет использован в дальнейшем
     */
    private WebDriver driver = getDriverByType(driverType);
    /**
     * экземпляр удаленного вебдрайвера который будет использован в дальнейшем при тестах в контейнере
     */
    private RemoteWebDriver remoteWebDriver;

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

    private RemoteWebDriver getRemoteWebDriver() {
        RemoteWebDriver remoteWebDriver;
        remoteWebDriver = new RemoteWebDriver(setCapabilities(driverType));
        return remoteWebDriver;
    }

    private Capabilities setCapabilities(String driverType) {
        Capabilities capabilities;
        switch (driverType) {
            case CHROME:
                capabilities = new ChromeOptions();
                break;
            case SAFARI:
                capabilities = new SafariOptions();
                break;
            case FIREFOX:
                capabilities = new FirefoxOptions();
                break;
            case EDGE:
                capabilities = new EdgeOptions();
                break;
            default:
                capabilities=null;
        }
        return capabilities;
    }
}
