package autotests.UI.elementsType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonElement extends CustomElement{

    public ButtonElement(WebElement webElement, WebDriver driver){
        super(webElement,driver);
    }

    public void click() throws InterruptedException {
        Thread.sleep(1000);
        webElement.click();
    }
}
