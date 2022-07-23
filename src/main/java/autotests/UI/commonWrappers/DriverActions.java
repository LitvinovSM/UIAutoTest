package autotests.UI.commonWrappers;

import autotests.unils.TestConfigFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static org.openqa.selenium.remote.BrowserType.*;

public class DriverActions {
    private static TestConfigFactory config = TestConfigFactory.getInstance();
     private final String REMOTE_LAUNCH = "remote";
    private final String LOCAL_LAUNCH = "local";
    BrowserType driverType = config.getWebConfig().getBrowserType();
    String launchType = config.getWebConfig().getLaunchType();

    public WebDriver getDriver(){
        WebDriver driver;
        switch (launchType){
            case REMOTE_LAUNCH:
                driver = getRemoteWebDriver(driverType);
            break;
            case LOCAL_LAUNCH:
                driver= getWebDriverByType(driverType);
                break;
            default:
                driver=null;
        }
        return driver;
    }

    public WebDriver getWebDriverByType(BrowserType driverType) {
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

    private RemoteWebDriver getRemoteWebDriver(BrowserType driverType) {
        RemoteWebDriver remoteWebDriver;
        remoteWebDriver = new RemoteWebDriver(setCapabilities(driverType.BrowserType));
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
    public enum BrowserType{
        CHROME("chrome"),
        FIREFOX("firefox"),
        SAFARI("safari"),
        EDGE("edge");
        final String BrowserType;
        BrowserType(String browserType){
            this.BrowserType= browserType;
        }
    }
}

