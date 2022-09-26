package autotests.UI.pages.main;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainActions extends MainElements {

    @Дано("'главная страница' открывает URL {string}")
    public void openPageByURL(String URL){
        webDriver.get(URL);
        wait.until(ExpectedConditions.visibilityOf(app));
    }

    @И("открывает телеграмм веб")
    public void открываетТелеграммВеб() {
    }

    @И("'главная страница' проверяет наличие ссылки с текстом {string}")
    public void checkThatLinkWithTextExists(String linkText) {
        List<WebElement> targetElements = getLinksByText(linkText);
        assertTrue(targetElements.size()!=0, String.format("Ссылка с текстом %s не отображается на форма",linkText));
    }

    @И("'главная страница' проверяет наличие ссылки с текстом {string} в элементе {string}")
    public void checkLinksByTextInElement(String linkText, String elementKey) {
        elementKey = elementKey.toUpperCase();
        initWebElementMap();
        WebElement targetElement = webElementMap.get(elementKey);
        WebElement link = getLinkByTextInElement(targetElement,linkText);
        assertTrue(isRealDisplayed(link),String.format("Ссылка с текстом %s не найдена в элементе %s",linkText,elementKey));
    }
}
