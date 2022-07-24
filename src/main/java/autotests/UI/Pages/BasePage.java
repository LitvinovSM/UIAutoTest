package autotests.UI.Pages;

import autotests.UI.actions.BaseActions;
import autotests.UI.commonWrappers.DriverActions;
import autotests.UI.elementsType.ElementDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import static autotests.UI.actions.BaseActions.DRIVER;

public class BasePage {

    public BasePage(){
        ElementLocatorFactory factory = new DefaultElementLocatorFactory(DRIVER);
        ElementDecorator decorator = new ElementDecorator(factory,DRIVER);
        PageFactory.initElements(decorator, this);
    }
    public static WebDriver DRIVER = BaseActions.DRIVER;



}
