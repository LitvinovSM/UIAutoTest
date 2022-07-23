package autotests.UI.Pages;

import autotests.UI.actions.BaseActions;
import autotests.UI.commonWrappers.DriverActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static autotests.UI.actions.BaseActions.DRIVER;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(DRIVER, this);

    }
    public static WebDriver DRIVER = BaseActions.DRIVER;
}
