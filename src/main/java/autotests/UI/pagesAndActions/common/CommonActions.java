package autotests.UI.pagesAndActions.common;

import cucumber.api.java.ru.И;

public class CommonActions extends CommonElements{

    @И("'универсальные действия' очищает поле поиска")
    public void основнаяСтраницаОчищаетПолеПоиска() throws InterruptedException {
        getClearInputButton(inputBlock).click();
        Thread.sleep(1000);
    }

    @И("'универсальные действия' вводит {string} в поле поиска")
    public void вводитТекстВПолеПоиска(String inputText) throws InterruptedException {
        getInputField(inputBlock).sendKeys(inputText);
        Thread.sleep(1000);

    }

    @И("'универсальные действия' в тулбаре нажимает на ссылку {string}")
    public void универсальныеДействияВТулбареНажимаетНаКнопку(String linkText) throws InterruptedException {
        getLinkByTextInElement(toolbarBlock,linkText).click();
        Thread.sleep(1000);
    }
}
