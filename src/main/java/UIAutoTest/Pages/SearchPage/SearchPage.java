package UIAutoTest.Pages.SearchPage;



import UIAutoTest.Pages.BasePageActions;
import cucumber.api.java.ru.И;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.*;

public class SearchPage extends BasePageActions {

    @FindBy(xpath = "//button[contains(@aria-label,'Поиск в Google')]")
    private WebElement searchButton;

    @FindBy(xpath = "//input[contains(@title,'Поиск')]")
    private WebElement inputField;

    @FindBy (xpath = "//div[@class='g']")
    private List<WebElement> searchResults;

    @И( "^Банкомат должен$")
    public void банкоматДолжен() {
        DRIVER.get("https://www.google.com/search?q=123&rlz=1C1SQJL_ruRU838RU838&oq=123&aqs=chrome.0.69i59j0l5j46j69i60.1422j0j8&sourceid=chrome&ie=UTF-8");
        inputField.sendKeys("1234567");
        searchButton.click();
        System.out.println(searchResults.toArray().length+ "ЭТО КОЛИЧЕСТВО РЕЗУЛЬТАТОВ ПОИСКА");
        assertTrue(searchResults.toArray().length==8);
    }



}
