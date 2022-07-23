package autotests.UI.actions;

import autotests.UI.commonWrappers.DriverActions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class BaseActions {
    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    public static WebDriver DRIVER;

    @Before
    public static void bef(){
        threadLocalDriver.set(new DriverActions().getDriver());
        DRIVER = threadLocalDriver.get();
    }

    @After
    public static void after(){
        DRIVER.quit();
    }
}
