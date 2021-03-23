package UIAutoTest.DefaultSteps;

import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;

import static UIAutoTest.DefaultSteps.WebDriverInit.getDRIVER;


public class AfterSteps {
    public final WebDriver DRIVER = getDRIVER();

    @After(order = 1)
    /**
     * Закрытие браузера и освобождение ресурсов*/
    public void tearDown(){

        this.DRIVER.quit();
    }
}