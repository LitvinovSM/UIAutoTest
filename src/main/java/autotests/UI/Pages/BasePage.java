package autotests.UI.Pages;

import autotests.UI.actions.BaseActions;
import autotests.UI.commonWrappers.DriverActions;
import autotests.UI.elementsType.ElementDecorator;
import org.bouncycastle.jcajce.provider.symmetric.VMPCKSA3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static autotests.UI.actions.BaseActions.DRIVER;

/**
 * Базовая страница, от которой наследуются оставшиеся страницы с элементами и экшенами*/
public class BasePage {

    /**
     * Конструктор который:
     * реализаует фабрику ElementLocatorFactory
     * реализует кастомный декторатор ElementDecorator
     * инициализирует PageFactory с кастомным декоратором*/
    public BasePage(){
        ElementLocatorFactory factory = new DefaultElementLocatorFactory(DRIVER);
        ElementDecorator decorator = new ElementDecorator(factory,DRIVER);
        PageFactory.initElements(decorator, this);
    }
    public static WebDriver DRIVER = BaseActions.DRIVER;
    public static WebDriverWait wait = BaseActions.wait;


}
