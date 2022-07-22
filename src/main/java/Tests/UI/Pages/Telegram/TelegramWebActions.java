package Tests.UI.Pages.Telegram;

import Tests.UI.actions.DriverActions;
import io.cucumber.java.ru.И;
import org.openqa.selenium.WebDriver;

public class TelegramWebActions extends TelegramWebElements {

    @И("^открывает телеграмм веб$")
    public void открываетТелеграммВеб() throws InterruptedException {
        WebDriver DRIVER = new DriverActions().getDriver();
        DRIVER.get(TELEGRAM_WEB_URL);
        Thread.sleep(10000000);

    }

}
