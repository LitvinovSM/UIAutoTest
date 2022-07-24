package autotests.UI.actions;

import autotests.UI.commonWrappers.DriverActions;
import autotests.unils.TestConfigFactory;
import autotests.unils.WebConfig;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Базовые действия перед и после каждого теста*/
public class BaseActions {

    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    public static WebDriver DRIVER;
    public static WebDriverWait wait;

    @Before
    public static void bef(){
        threadLocalDriver.set(new DriverActions().getDriver());
        DRIVER = threadLocalDriver.get();
        wait = new DriverActions().getWebDriverWait();
    }

    @After
    public static void after(){
        DRIVER.quit();
    }
}
