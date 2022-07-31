package autotests.UI.pagesAndActions;

import autotests.UI.customElements.ButtonElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseaActions extends BasePage{

    public void waitUntilVisible(WebElement element){
        //wait.until(ExpectedConditions.(element));
    }

    public void waitUntilInvisible(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

}
