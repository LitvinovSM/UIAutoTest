package autotests.UI.pagesAndActions;

import autotests.UI.commonWrappers.DriverActions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static autotests.UI.commonWrappers.DriverActions.getWebDriverWait;

/**
 * Базовые действия перед и после каждого теста*/
public class BeforeAndAfterActions {

    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    public static WebDriver webDriver;
    public static WebDriverWait wait;

    /**
     * Шаги до:
     * 1)инициализация драйвера в ThreadLocal
     * 2) Присваивание webDriver
     * 3) инициализация wait */
    @Before(order = 10000)
    public static void bef() throws Exception {
        threadLocalDriver.set(new DriverActions().getDriver());
        webDriver = threadLocalDriver.get();
        wait = getWebDriverWait();
    }

    /**
     * Шаги после:
     * 1) Закрытие инстанса webDriver */
    @After(order = 2)
    public static void after(){
        threadLocalDriver.get().quit();
    }

    @After(order = 1)
    public static void makeScreenshot(){

    }
}
