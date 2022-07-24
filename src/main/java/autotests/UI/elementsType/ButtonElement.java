package autotests.UI.elementsType;

import org.openqa.selenium.WebElement;

public class ButtonElement extends CustomElement{

    public ButtonElement(WebElement webElement){
        super(webElement);
    }

    public void click() throws InterruptedException {
        Thread.sleep(1000);
        webElement.click();
    }
}
