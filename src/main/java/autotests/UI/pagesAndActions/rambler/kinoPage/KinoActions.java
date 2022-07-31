package autotests.UI.pagesAndActions.rambler.kinoPage;

import cucumber.api.java.ru.Дано;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KinoActions extends KinoElements{

    @Дано("'страница кино' успешно загружена")
    public void страницаКиноУспешноЗагружена() throws InterruptedException {
        getWebDriver().get(BASE_URL);
        Thread.sleep(1000);
        waitUntilVisible(pageTitle);
        assertEquals(titleText,pageTitle.getAttribute("textContent"));
    }

}
