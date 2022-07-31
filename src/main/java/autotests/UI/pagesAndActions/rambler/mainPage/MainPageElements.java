package autotests.UI.pagesAndActions.rambler.mainPage;

import autotests.UI.pagesAndActions.BasePage;
import autotests.UI.pagesAndActions.BaseaActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageElements extends BaseaActions {

    protected String BASE_URL = "https://www.rambler.ru/";

    protected String titleText = "Рамблер/новости, почта и поиск — медийный портал: новости России и мира, электронная почта, погода, развлекательные и коммуникационные сервисы. Новости сегодня и сейчас";
    @FindBy(xpath = "//title[contains(text(),'Рамблер/новости, почта и поиск')]")
    protected WebElement pageTitle;

    @FindBy(xpath = "//div[contains(@class,'mdmk')]")
    WebElement toolbarSection;

}
