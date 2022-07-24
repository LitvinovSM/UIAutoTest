package autotests.UI.elementsType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomElement {

    protected WebElement webElement;
    protected WebDriver driver;

    public CustomElement(WebElement webElement, WebDriver driver){
        this.webElement=webElement;
        this.driver=driver;
    }
}
