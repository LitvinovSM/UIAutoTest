package autotests.UI.pagesAndActions.rambler.mainPage;

import autotests.UI.customElements.ButtonElement;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageActions extends MainPageElements {

    @Дано("'основная страница' успешно загружена")
    public void mainPageIsLoadedSuccessful() throws InterruptedException {
        getWebDriver().get(BASE_URL);
        Thread.sleep(1000);
        waitUntilVisible(pageTitle);
        assertEquals(titleText,pageTitle.getAttribute("textContent"));
    }

    @И("'основная страница' проверяет наличие кнопок с текстом в тулбаре")
    public void checkTextsInToolbar(DataTable buttonTextTable) {
        List<Map<String,String>> table = buttonTextTable.asMaps(String.class,String.class);
        for (Map<String, String> map : table){
            String elementText = map.get("ТЕКСТ КНОПКИ");
            ButtonElement buttonElement = new ButtonElement(getWebDriver(),toolbarSection).getButtonByText(toolbarSection,elementText);
            assertTrue(buttonElement.returnAsWebElement().isDisplayed());
        }
    }


}
