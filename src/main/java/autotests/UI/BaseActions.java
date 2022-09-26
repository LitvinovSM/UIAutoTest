package autotests.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class BaseActions extends BasePage {

    public void initWebElementMap() {
        webElementMap = new HashMap<>();
    }

    /**
     * Return link with target text as a web element
     *
     * @param text expected full text of link
     * @return link as a web element
     */
    public WebElement getLinkByText(String text) {
        try {
            return webDriver.findElement(By.xpath(String.format("//a[text()='%s']", text)));
        } catch (NoSuchElementException e) {
            fail(String.format("Ссылка c текстом %s не найдена на странице", text));
            return null;
        }
    }

    /**
     * Return list of links with target text as a web elements
     *
     * @param text expected full text of link
     * @return list of links as a web elements
     */
    public List<WebElement> getLinksByText(String text) {
        try {
            return webDriver.findElements(By.xpath(String.format("//a[text()='%s']", text)));
        } catch (NoSuchElementException e) {
            fail(String.format("Ссылки c текстом %s не найдены на странице", text));
            return null;
        }
    }

    /**
     * Return link contains part of the text as a web element
     *
     * @param partOfText expected part of the text of link
     * @return link as a web element
     */
    public WebElement getLinkContainsText(String partOfText) {
        try {
            return webDriver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", partOfText)));
        } catch (NoSuchElementException e) {
            fail(String.format("Ссылка содержащая текст %s не найдена на странице", partOfText));
            return null;
        }
    }

    /**
     * Return link in some element with target text as a web element
     *
     * @param text          expected full text of link
     * @param targetElement the element where search is made
     * @return link as a web element
     */
    public WebElement getLinkByTextInElement(WebElement targetElement, String text) {
        try {
            return targetElement.findElement(By.xpath(String.format(".//a[text()='%s']", text)));
        } catch (NoSuchElementException e) {
            fail(String.format("Ссылка с текстом %s не найдена в вебэлементе %s", text, targetElement));
            return null;
        }
    }

    public boolean isRealDisplayed(WebElement element) {
        try {
            element.findElement(By.xpath("."));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Return button in some element contains target text as a web element
     *
     * @param partOfText expected part text of Button
     * @return button as a web element
     */
    public WebElement getButtonContainsText(String partOfText) {
        try {
            return webDriver.findElement(By.xpath(String.format("//button[descendant-or-self::*[contains(text(),'%s')]]", partOfText)));
        } catch (NoSuchElementException e) {
            fail(String.format("Не удалось найти кнопку с текстом %s", partOfText));
            return null;
        }
    }

    /**
     * Return button in some element contains target text as a web element
     *
     * @param partOfText expected part text of Button
     * @return button as a web element
     */
    public WebElement getButtonByTextInElement(WebElement targetElement, String partOfText) {
        try {
            return targetElement.findElement(By.xpath(String.format(".//button[descendant-or-self::*[contains(text(),'%s')]]", partOfText)));
        } catch (NoSuchElementException e) {
            fail(String.format("Кнопка с текстом %s не найдена в вебэлементе %s", partOfText, targetElement));
            return null;
        }
    }
}
