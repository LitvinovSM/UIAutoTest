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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.*;

public class DriverActions {
    /**
     * Конфиги которые берутся из WebTestConfig.conf*/
    private static final TestConfigFactory config = TestConfigFactory.getInstance();
    private final static String REMOTE = "remote";
    private final static String LOCAL = "local";
    private final BrowserType BROWSER_TYPE = config.getWebConfig().getBrowserType();
    private final String LAUNCH_TYPE = config.getWebConfig().getLaunchType();
    private final int IMPLICITLY_WAIT_VALUE = config.getWebConfig().getImplicitlyWaitValue();
    private final int EXPLICITLY_WAIT_VALUE = config.getWebConfig().getExplicitlyWaitValue();
    private final int PAGE_LOAD_TIMEOUT = config.getWebConfig().getPageLoadTimeout();
    private static WebDriverWait webDriverWait;

    /**
     * Получение вебдрайвера по заданным свойствам в WebTestsConfig.conf*/
    public WebDriver getDriver() throws Exception {

        WebDriver driver = switch (LAUNCH_TYPE) {
            case REMOTE -> getRemoteWebDriver(BROWSER_TYPE);
            case LOCAL -> getWebDriverByType(BROWSER_TYPE);
            default -> throw new Exception("Запуск драйвера не смогу завершиться успешно т.к. LAUNCH_TYPE не соответствует ни одному из ожидаемых значений. LAUNCH_TYPE ="+LAUNCH_TYPE);
        };
        manageDriver(driver);
        setExplicitlyWait(driver);
        return driver;
    }

    /**
     * Инициализация вебдрайвера
     * @return экземпляр веб драйвераа*/
    private WebDriver getWebDriverByType(BrowserType driverType) {
        WebDriver driver;
        switch (driverType) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case SAFARI -> {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            default -> driver = null;
        }
        return driver;
    }

    /**
     * Инициализация удаленного вебдрайвера
     * @return экземпляр веб драйвераа*/
    private RemoteWebDriver getRemoteWebDriver(BrowserType driverType) {
        RemoteWebDriver remoteWebDriver;
        remoteWebDriver = new RemoteWebDriver(setCapabilities(driverType.BrowserType));
        return remoteWebDriver;
    }

    /**
     * Получение свойств по типу браузера.
     * @return свойства браузера*/
    //TODO: разобраться с опциями драйвера
    private Capabilities setCapabilities(String driverType) {
        return switch (driverType) {
            case CHROME -> new ChromeOptions();
            case SAFARI -> new SafariOptions();
            case FIREFOX -> new FirefoxOptions();
            case EDGE -> new EdgeOptions();
            default -> null;
        };
    }

    /**
     * Установка таймаутов в одном месте*/
    private void manageDriver(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_VALUE,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
    }
    /**
     * Установка явного ожидания для будущего использования ожиданий элементов*/
    private void setExplicitlyWait(WebDriver driver){
        webDriverWait = new WebDriverWait(driver, EXPLICITLY_WAIT_VALUE);
    }

    /**
     * Получение "ожидателя", который инициализируется при создании драйвера*/
    public static WebDriverWait getWebDriverWait(){
        return webDriverWait;
    }

    /**
     * Енум с типами браузеров.
     * значение конфика WebTestsConfig.conf должно матчится на текущее значение браузера*/
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

