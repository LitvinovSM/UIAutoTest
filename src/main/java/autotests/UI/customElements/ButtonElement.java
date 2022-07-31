package autotests.UI.customElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.reflect.InvocationTargetException;

/**
 * Кастомный класс кнопки
 */
public class ButtonElement extends CustomElement {

    public ButtonElement(WebDriver webDriver, WebElement webElement) {
        super(webDriver, webElement);
    }

    /**
     * Метод клик, c ожиданием ее кликабельности
     */
    public void click() {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public ButtonElement getButtonInElement(WebElement element) {
        ButtonElement clazz;
        try {
            clazz= this.getClass().getDeclaredConstructor(WebDriver.class, WebElement.class).newInstance(webDriver, element).findElement(By.xpath(".//button"));
            return clazz;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public <T extends CustomElement> ButtonElement getButtonByText(WebElement element, String buttonText) {
        Class<T> clazz = null;
        try {
            return clazz.getDeclaredConstructor(WebDriver.class, WebElement.class).newInstance(webDriver, element).findElement(By.xpath(".//button[contains(text(),'" + buttonText + "']"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
