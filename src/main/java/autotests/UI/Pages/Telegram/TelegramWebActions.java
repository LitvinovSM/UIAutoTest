package autotests.UI.Pages.Telegram;

import autotests.UI.elementsType.ButtonElement;
import autotests.unils.TestConfigFactory;
import cucumber.api.java.ru.И;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TelegramWebActions extends TelegramWebElements {

    public TelegramWebActions(){
        super();
    }
    @FindBy(xpath = "//*[@id='app']")
    static ButtonElement buttonElement;


    private static String BASE_URL = TestConfigFactory.getInstance().getWebConfig().getBaseURL();

    @И("открывает телеграмм веб")
    public void any() throws InterruptedException {
        DRIVER.get(BASE_URL);
        Thread.sleep(1000);
        List<ButtonElement> but2 = buttonElement.findElements(By.xpath(".//*[contains(text(),'овости')]"));
        but2.get(0).click();
        Thread.sleep(1000);
    }


}
