package autotests.UI.elementsType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Кастомный класс кнопки*/
public class ButtonElement extends CustomElement{

    public ButtonElement(WebElement webElement, WebDriver driver){
        super(webElement,driver);
    }

    /**
     * Метод клик, специфичный для кнопки*/
    public void click() throws InterruptedException {
        Thread.sleep(1000); // разумеется перепишу - просто тренировал подход
        webElement.click();
    }
}
