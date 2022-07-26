package autotests.UI.elementsType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;

import static autotests.UI.commonWrappers.DriverActions.getWebDriverWait;

/**
 * @Authored Литвинов С.М
 * Класс родитель кастомного элемента.
 * Агрегирует в себе основные функции всех элементов*/
public class CustomElement{
    /**
     * Веб элемент над которым происходит вся работа в будущем*/
    protected WebElement webElement;
    /**
     * Драйвер, на случай, если придется работать с экшенами*/
   protected WebDriver webDriver;
    /**
     * Вейтер для работы с ожиданиями*/
   protected static WebDriverWait wait = getWebDriverWait();
    public CustomElement(WebDriver webDriver, WebElement webElement){
        this.webElement=webElement;
        this.webDriver =webDriver;
    }

    public CustomElement(WebDriver webDriver, By by){
        webElement = webDriver.findElement(by);
    }
    /**
     * Возвращает кастомный элемент как веб элемент
     * @return кастомный элемент как тип WebElement*/
    public WebElement returnAsWebElement(){
        return webElement;
    }

    public <T extends CustomElement> T crateElement(Class<T> clazz, WebDriver webDriver, By by) {
        T targetClazz;
        try {
            targetClazz = clazz.getDeclaredConstructor(WebDriver.class,WebElement.class).newInstance(webDriver,webDriver.findElement(by));
            return targetClazz;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
