package autotests.UI.pages.main;

import autotests.UI.BaseActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainElements extends BaseActions {

    String siteNavigationName = "СТРОКА НАВИГАЦИИ ПО САЙТУ";
    @FindBy(xpath = "//div[contains(@itemtype,'SiteNavigationElement')]")
    WebElement siteNavigation;

    @FindBy(xpath = "//div[@id='app']")
    WebElement app;

    @FindBy(xpath = "//a[text()='Почта']")
    WebElement postLink;

    @FindBy(xpath = "//a[text()='Новости']")
    WebElement newsLink;

    @FindBy(xpath = "//a[text()='Кино']")
    WebElement filmsLink;

    @FindBy(xpath = "//a[text()='Спорт']")
    WebElement sportLink;

    @FindBy(xpath = "//a[text()='Авто']")
    WebElement autoLink;

    @FindBy(xpath = "//a[text()='Шоу-бизнес']")
    WebElement showAndBusinessLink;

    @FindBy(xpath = "//a[text()='Гороскопы']")
    WebElement starPlansLink;

    @FindBy(xpath = "//a[text()='Финансы']")
    WebElement financeLink;

    @FindBy(xpath = "//a[text()='Работы']")
    WebElement jobsLink;

    @FindBy(xpath = "//a[text()='Еще']")
    WebElement moreLink;

    @Override
    public void initWebElementMap() {
        super.initWebElementMap();
        webElementMap.put(siteNavigationName,siteNavigation);
    }
}
