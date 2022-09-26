package autotests.UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

/**
 * Базовая страница, от которой наследуются оставшиеся страницы с элементами и экшенами*/
public class BasePage {

    /**
     * Конструктор который:
     * инициализирует PageFactory с кастомным декоратором*/
    public BasePage(){
        PageFactory.initElements(webDriver, this);
    }
    public WebDriver webDriver = BeforeAndAfterSteps.webDriver;
    public WebDriverWait wait = BeforeAndAfterSteps.wait;

    public HashMap<String, WebElement> webElementMap;
}
