package autotests.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
        assertDoesNotThrow(() -> {
            webDriver.findElement(By.xpath(String.format("//a[text()='%s']", text)));
        }, String.format("Ссылка c текстом %s не найдена на странице", text));
        return webDriver.findElement(By.xpath(String.format("//a[text()='%s']", text)));
    }

    /**
     * Return list of links with target text as a web elements
     *
     * @param text expected full text of link
     * @return list of links as a web elements
     */
    public List<WebElement> getLinksByText(String text) {
        assertDoesNotThrow(() -> {
            webDriver.findElements(By.xpath(String.format("//a[text()='%s']", text)));
        }, String.format("Ссылки c текстом %s не найдены на странице", text));
        return webDriver.findElements(By.xpath(String.format("//a[text()='%s']", text)));
    }

    /**
     * Return link contains part of the text as a web element
     *
     * @param partOfText expected part of the text of link
     * @return link as a web element
     */
    public WebElement getLinkContainsText(String partOfText) {
        assertDoesNotThrow(() -> {
            webDriver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", partOfText)));
        }, String.format("Ссылка содержащая текст %s не найдена на странице", partOfText));

        return webDriver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", partOfText)));
    }

    /**
     * Return link in some element with target text as a web element
     *
     * @param text          expected full text of link
     * @param targetElement the element where search is made
     * @return link as a web element
     */
    public WebElement getLinkByTextInElement(WebElement targetElement, String text) {
        assertDoesNotThrow(() -> {
            targetElement.findElement(By.xpath(String.format(".//a[text()='%s']", text)));
        }, String.format("Ссылка с текстом %s не найдена в элементе %s", text, targetElement));
        return targetElement.findElement(By.xpath(String.format(".//a[text()='%s']", text)));
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
        assertDoesNotThrow(() -> {
            webDriver.findElement(By.xpath(String.format("//button[descendant-or-self::*[contains(text(),'%s')]]", partOfText)));
        }, String.format("Не удалось найти кнопку с текстом %s", partOfText));
        return webDriver.findElement(By.xpath(String.format("//button[descendant-or-self::*[contains(text(),'%s')]]", partOfText)));
    }

    /**
     * Return button in some element contains target text as a web element
     *
     * @param partOfText expected part text of Button
     * @return button as a web element
     */
    public WebElement getButtonByTextInElement(WebElement targetElement, String partOfText) {
        assertDoesNotThrow(() -> {
            targetElement.findElement(By.xpath(String.format(".//button[descendant-or-self::*[contains(text(),'%s')]]", partOfText)));
        }, String.format("Кнопка с текстом %s не найдена в вебэлементе %s", partOfText, targetElement));
        return targetElement.findElement(By.xpath(String.format(".//button[descendant-or-self::*[contains(text(),'%s')]]", partOfText)));
    }
}
