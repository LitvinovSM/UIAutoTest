package autotests.UI.Pages.Telegram;

import autotests.UI.elementsType.ButtonElement;
import autotests.UI.elementsType.CustomElement;
import autotests.unils.TestConfigFactory;
import cucumber.api.java.ru.И;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TelegramWebActions extends TelegramWebElements {

    public TelegramWebActions(){
        super();
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]")
    static ButtonElement buttonElement;


    private static String BASE_URL = TestConfigFactory.getInstance().getWebConfig().getBaseURL();

    @И("открывает телеграмм веб")
    public void any() throws InterruptedException {
        DRIVER.get(BASE_URL);
        Thread.sleep(10000);
        ButtonElement but2 = buttonElement.crateElement(ButtonElement.class,DRIVER,By.xpath(".//*[contains(text(),'овстей')]"));
        but2.click();
        Thread.sleep(10000);
    }


}
