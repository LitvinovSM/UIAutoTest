package autotests.UI.elementsType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class ElementDecorator extends DefaultFieldDecorator {

    private WebDriver webDriver;
    public ElementDecorator(ElementLocatorFactory factory, WebDriver webDriver) {
        super(factory);
        this.webDriver =webDriver;
    }

    @Override
    public Object decorate(ClassLoader loader, Field field){
        if (isCustomElement(field)){
            ElementLocator locator = factory.createLocator(field);
            return createElement(loader,locator,field.getType());
        }
        return super.decorate(loader, field);
    }

    public boolean isCustomElement(Field field){
        return CustomElement.class.isAssignableFrom(field.getType());
    }


    protected <T> T createElement(ClassLoader loader, ElementLocator locator, Class<T> clazz){
        WebElement proxy = proxyForLocator(loader,locator);
        try {
            return clazz.getConstructor(WebElement.class, WebDriver.class).newInstance(proxy, webDriver);
        } catch (Exception e){
            throw new AssertionError("Web element can't be represented as a class : "+ clazz);
        }
    }
}
