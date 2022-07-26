package autotests.UI.elementsType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Кастомный класс кнопки*/
public class ButtonElement extends CustomElement{

    public ButtonElement(WebDriver webDriver, WebElement webElement){
        super(webDriver,webElement);
    }

    /**
     * Метод клик, c ожиданием ее кликабельности*/
    public void click(){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public WebElement getButtonInElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.findElement(By.xpath(".//button"));
    }
}
