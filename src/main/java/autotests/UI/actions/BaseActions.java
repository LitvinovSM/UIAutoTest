package autotests.UI.actions;

import autotests.UI.commonWrappers.DriverActions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static autotests.UI.commonWrappers.DriverActions.getWebDriverWait;

/**
 * Базовые действия перед и после каждого теста*/
public class BaseActions {

    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    public static WebDriver webDriver;
    public static WebDriverWait wait;

    /**
     * Шаги до:
     * 1)инициализация драйвера в ThreadLocal
     * 2) Присваивание webDriver
     * 3) инициализация wait */
    @Before
    public static void bef() throws Exception {
        threadLocalDriver.set(new DriverActions().getDriver());
        webDriver = threadLocalDriver.get();
        wait = getWebDriverWait();
    }

    /**
     * Шаги после:
     * 1) Закрытие инстанса webDriver */
    @After
    public static void after(){
        threadLocalDriver.get().quit();
    }
}
