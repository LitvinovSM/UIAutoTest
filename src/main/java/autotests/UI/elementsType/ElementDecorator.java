package autotests.UI.elementsType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class ElementDecorator extends DefaultFieldDecorator {

    private WebDriver webDriver;
    /**
     * Дефолтный конструктор декоратора, который будет использоваться для пейдж фэктори
     * @param factory - фабрика элемент локатора
     * @param webDriver - инстанс драйвера*/
    public ElementDecorator(ElementLocatorFactory factory, WebDriver webDriver) {
        super(factory);
        this.webDriver =webDriver;
    }

    /**
     * Метод который будет помогать аннотации FindBy распознавать кастомные элементы, через проверку их класса*/
    @Override
    public Object decorate(ClassLoader loader, Field field){
        if (isCustomElement(field)){
            ElementLocator locator = factory.createLocator(field);
            return createElement(loader,locator,field.getType());
        }
        return super.decorate(loader, field);
    }
    /**
     * Проверка что поле является наследником от класса CustomElement*/
    public boolean isCustomElement(Field field){
        return CustomElement.class.isAssignableFrom(field.getType());
    }

    /**
     * Метод создания кастомного веб элемента.
     * Используется в декораторе
     * @return новый инстанс кастомного элемента*/
    protected <T> T createElement(ClassLoader loader, ElementLocator locator, Class<T> clazz){
        WebElement proxy = proxyForLocator(loader,locator);
        try {
            return clazz.getConstructor(WebElement.class, WebDriver.class).newInstance(proxy, webDriver);
        } catch (Exception e){
            throw new AssertionError("Web element can't be represented as a class : "+ clazz);
        }
    }
}
