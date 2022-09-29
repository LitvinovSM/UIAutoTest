package autotests.UI.pages.main;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainActions extends MainElements {
    //@Step("'главная страница' открывает URL {URL}")
    @Дано("'главная страница' открывает URL {string}")
    public void openPageByURL(String URL){
        webDriver.get(URL);
        wait.until(ExpectedConditions.visibilityOf(app));
    }
    //@Step("'главная страница' проверяет наличие ссылки с текстом {linkText}")
    @И("'главная страница' проверяет наличие ссылки с текстом {string}")
    public void checkThatLinkWithTextExists(String linkText) {
        List<WebElement> targetElements = getLinksByText(linkText);
        assertTrue(targetElements.size()!=0, String.format("Ссылка с текстом %s не отображается на форма",linkText));
    }
    //@Step("'главная страница' проверяет наличие ссылки с текстом {linkText} в элементе {elementKey}")
    @И("'главная страница' проверяет наличие ссылки с текстом {string} в элементе {string}")
    public void checkLinksByTextInElement(String linkText, String elementKey) {
        elementKey = elementKey.toUpperCase();
        initWebElementMap();
        WebElement targetElement = webElementMap.get(elementKey);
        WebElement link = getLinkByTextInElement(targetElement,linkText);
    }
    //@Step("'главная страница' проверяет наличие кнопки с текстом {buttonText} в элементе {elementKey}")
    @И("'главная страница' проверяет наличие кнопки с текстом {string} в элементе {string}")
    public void checkButtonsByTextInElement(String buttonText, String elementKey) {
        elementKey = elementKey.toUpperCase();
        initWebElementMap();
        WebElement targetElement = webElementMap.get(elementKey);
        WebElement button = getButtonByTextInElement(targetElement,buttonText);
    }
}
