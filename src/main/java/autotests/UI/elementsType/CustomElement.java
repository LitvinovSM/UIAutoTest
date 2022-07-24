package autotests.UI.elementsType;

import org.openqa.selenium.WebElement;

public class CustomElement {

    protected WebElement webElement;

    public CustomElement(WebElement webElement){
        this.webElement=webElement;
    }
}
