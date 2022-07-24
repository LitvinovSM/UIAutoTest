package autotests.UI.Pages.Telegram;

import autotests.UI.elementsType.ButtonElement;
import autotests.unils.TestConfigFactory;
import cucumber.api.java.ru.И;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TelegramWebActions extends TelegramWebElements {

    public TelegramWebActions(){
        super();
    }
    @FindBy(xpath = "//*[@id='mainContainer']/div/div/div[2]/div[2]/div/div/a[2]")
    ButtonElement buttonElement;
    private static String BASE_URL = TestConfigFactory.getInstance().getWebConfig().getBaseURL();

    @И("^открывает телеграмм веб$")
    public void any() throws InterruptedException {
        DRIVER.get(BASE_URL);
        Thread.sleep(100);
        buttonElement.click();
        buttonElement.returnAsWebElement().click();
    }


}
