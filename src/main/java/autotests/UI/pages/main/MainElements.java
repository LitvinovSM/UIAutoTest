package autotests.UI.pages.main;

import autotests.UI.BaseActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainElements extends BaseActions {

    String BASE_URL = "https://www.rambler.ru/";

    @FindBy(xpath = "//div[@id='app']")
    WebElement app;

}
