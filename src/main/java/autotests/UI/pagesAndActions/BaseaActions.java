package autotests.UI.pagesAndActions;

import autotests.UI.customElements.ButtonElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseaActions extends BasePage{

    public void waitUntilVisible(WebElement element) throws InterruptedException {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitUntilInvisible(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public WebElement getClearInputButton(WebElement element){
        return element.findElement(By.xpath(".//button[not(contains(@type,'submit'))]"));
    }

    public WebElement getInputField(WebElement element){
        return element.findElement(By.xpath(".//input[contains(@class,'rui')]"));
    }

    public WebElement getLinkByTextInElement(WebElement element, String linkText){
        return element.findElement(By.xpath(".//a[text()='"+linkText+"']"));
    }
}
