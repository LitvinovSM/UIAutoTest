package Tests.UI.Pages.Telegram;

import Tests.UI.actions.DriverActions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.И;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TelegramWebActions extends TelegramWebElements {
   static WebDriver DRIVER;

    static {
        try {
            DRIVER = new DriverActions().getDriver();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Before
   public static void bef(){
   }

    @И("^открывает телеграмм веб$")
    public void any() throws InterruptedException {
        WebDriver DRIVER = new DriverActions().getDriver();
        DRIVER.get("https://hub.docker.com/r/selenium/hub");
        Thread.sleep(100);
    }

    @After
    public static void after(){
        RemoteWebDriver remoteWebDriver = (RemoteWebDriver) DRIVER;
        remoteWebDriver.close();
        //DRIVER.quit();

    }
}
