package autotests.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class BaseActions extends BasePage {

    public void initWebElementMap(){
        webElementMap = new HashMap<>();
    }
    /**
     * Return link with target text as a web element
     * @param text expected full text of link
     * @return link as a web element*/
    public WebElement getLinkByText(String text) {
        return webDriver.findElement(By.xpath(String.format("//a[text()='%s']", text)));
    }

    /**
     * Return list of links with target text as a web elements
     * @param text expected full text of link
     * @return list of links as a web elements*/
    public List<WebElement> getLinksByText(String text) {
        return webDriver.findElements(By.xpath(String.format("//a[text()='%s']", text)));
    }

    /**
     * Return link contains part of the text as a web element
     * @param partOfText expected part of the text of link
     * @return link as a web element*/
    public WebElement getLinkContainsText(String partOfText) {
        return webDriver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", partOfText)));
    }

    /**
     * Return link in some element with target text as a web element
     * @param text expected full text of link
     * @param targetElement the element where search is made
     * @return link as a web element*/
    public WebElement getLinkByTextInElement(WebElement targetElement, String text) {
        return targetElement.findElement(By.xpath(String.format(".//a[text()='%s']", text)));
    }

    public boolean isRealDisplayed(WebElement element){
        try{
            element.findElement(By.xpath("."));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
