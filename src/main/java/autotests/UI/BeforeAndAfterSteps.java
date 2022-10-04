package autotests.UI;

import autotests.UI.commonWrappers.DriverActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static autotests.UI.BaseActions.screenshot;
import static autotests.UI.commonWrappers.DriverActions.getWebDriverWait;

/**
 * Базовые действия перед и после каждого теста*/
public class BeforeAndAfterSteps {

    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    public static WebDriver webDriver;
    public static WebDriverWait wait;

    /**
     * Шаги до:
     * 1)инициализация драйвера в ThreadLocal
     * 2) Присваивание webDriver
     * 3) инициализация wait */

    @Before
    public static void setUp() throws Exception {
        threadLocalDriver.set(new DriverActions().getDriver());
        webDriver = threadLocalDriver.get();
        wait = getWebDriverWait();
    }

    /**
     * Шаги после:
     * 1) Скриншот
     * 2) Закрытие ресурсов*/
    @After(order = 3)
    public static void tearDown(){
        screenshot();
        threadLocalDriver.get().quit();
    }

}
