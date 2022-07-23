package autotests.UI.Pages.Telegram;

import autotests.unils.TestConfigFactory;
import cucumber.api.java.ru.И;

public class TelegramWebActions extends TelegramWebElements {

    private static String BASE_URL = TestConfigFactory.getInstance().getWebConfig().getBaseURL();

    @И("^открывает телеграмм веб$")
    public void any() throws InterruptedException {
        DRIVER.get(BASE_URL);
        Thread.sleep(100);
    }


}
