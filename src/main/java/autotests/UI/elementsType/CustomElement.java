package autotests.UI.elementsType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Класс родитель кастомного элемента.
 * Агрегирует в себе основные функции всех элементов*/
public class CustomElement {
    /**
     * Веб элемент над которым происходит вся работа в будущем*/
    protected WebElement webElement;
    /**
     * Драйвер, на случай, если придется работать с экшенами*/
   protected WebDriver driver;
    public CustomElement(WebElement webElement, WebDriver driver){
        this.webElement=webElement;
        this.driver=driver;
    }

    /**
     * Возвращает кастомный элемент как веб элемент
     * @return кастомный элемент как тип WebElement*/
    public WebElement returnAsWebElement(){
        return webElement;
    }
}
