package Tests.UI.Pages.Telegram;

import Tests.UI.actions.DriverActions;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.ru.И;
import org.openqa.selenium.WebDriver;

public class TelegramWebActions extends TelegramWebElements {
   static WebDriver DRIVER = new DriverActions().getDriver();

   @BeforeAll
   public static void bef(){

   }

    @И("^открывает телеграмм веб")
    public void any() throws InterruptedException {
        WebDriver DRIVER = new DriverActions().getDriver();
        DRIVER.get("https://hub.docker.com/r/selenium/hub");
        Thread.sleep(100);
    }

    @AfterAll
    public static void after(){
        DRIVER.quit();
    }
}
