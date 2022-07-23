package autotests.UI.Pages.Telegram;

import cucumber.api.java.ru.И;

public class TelegramWebActions extends TelegramWebElements {


    @И("^открывает телеграмм веб$")
    public void any() throws InterruptedException {
        DRIVER.get("https://hub.docker.com/r/selenium/hub");
        Thread.sleep(100);
    }


}
