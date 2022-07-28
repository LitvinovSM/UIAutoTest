package autotests.UI.elementsType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

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


    /**
     * Реализация привычного метода findElement для кастомных элементов
     *@param by - локатор дочернего элемента
     *@return элемент типа <T>, то есть дочерний элемент CustomElement*/

    @SuppressWarnings("unchecked")
    public <T extends CustomElement> T findElement(By by) {
        T targetClazz;
        WebElement webElement = this.webElement;
        WebDriver webDriver = this.webDriver;
        try {
            targetClazz = (T) this.getClass().getDeclaredConstructor(WebDriver.class,WebElement.class).newInstance(webDriver,webElement.findElement(by));
            return targetClazz;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Реализация привычного метода findElement для кастомных элементов для возможности поиска в элементе иных типов элементов
     * т.е. в TableElement может лежать RowElement и чтобы его найти надо вызвать
     * findElement(<локатор>,RowElement.class)
     *@param by - локатор дочернего элемента
     *@param clazz - тип ожидаемого класса
     *@return элемент типа <T>, то есть дочерний элемент CustomElement*/
    public <T extends CustomElement> T findElement(By by,Class<T> clazz) {
        T targetClazz;
        WebElement webElement = this.webElement;
        WebDriver webDriver = this.webDriver;
        try {
            targetClazz = clazz.getDeclaredConstructor(WebDriver.class,WebElement.class).newInstance(webDriver,webElement.findElement(by));
            return targetClazz;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Реализация привычного метода findElements для кастомных элементов
     *@param by - локатор дочернего элемента
     *@return список типа List<T>, то есть список дочерних элементов CustomElement*/
    @SuppressWarnings("unchecked")
    public <T extends CustomElement> List<T> findElements(By by) {
        T targetClazz;
        List<T> targetList = new ArrayList<>();
        WebDriver webDriver = this.webDriver;
        try {
            List<WebElement> list= webDriver.findElements(by);
            for (WebElement elem : list){
                targetClazz = (T) this.getClass().getDeclaredConstructor(WebDriver.class,WebElement.class).newInstance(webDriver,elem);
                targetList.add(targetClazz);
            }
            return targetList;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Реализация привычного метода findElements для кастомных элементов для возможности поиска в элементе иных типов элементов
     * т.е. в TableElement может лежать список RowElement и чтобы его найти надо вызвать
     * findElements(<локатор>,RowElement.class)
     *@param by - локатор дочерних элементов
     *@param clazz - тип ожидаемых элементов
     *@return список типа List<T>, то есть список дочерних элементов с ожидаемым типом*/
    public <T extends CustomElement> List<T> findElements(By by,Class<T> clazz) {
        T targetClazz;
        List<T> targetList = new ArrayList<>();
        WebDriver webDriver = this.webDriver;
        try {
            List<WebElement> list= webDriver.findElements(by);
            for (WebElement elem : list){
                targetClazz = clazz.getDeclaredConstructor(WebDriver.class,WebElement.class).newInstance(webDriver,elem);
                targetList.add(targetClazz);
            }
            return targetList;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
