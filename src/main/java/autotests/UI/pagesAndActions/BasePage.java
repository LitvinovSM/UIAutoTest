package autotests.UI.pagesAndActions;

import autotests.UI.customElements.decoration.ElementDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Базовая страница, от которой наследуются оставшиеся страницы с элементами и экшенами*/
public class BasePage {

    /**
     * Конструктор который:
     * реализаует фабрику ElementLocatorFactory
     * реализует кастомный декторатор ElementDecorator
     * инициализирует PageFactory с кастомным декоратором*/
    public BasePage(){
        ElementLocatorFactory factory = new DefaultElementLocatorFactory(webDriver);
        ElementDecorator decorator = new ElementDecorator(factory, webDriver);
        PageFactory.initElements(decorator, this);
    }
    private WebDriver webDriver = BeforeAndAfterActions.webDriver;
    public WebDriverWait wait = BeforeAndAfterActions.wait;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

}
