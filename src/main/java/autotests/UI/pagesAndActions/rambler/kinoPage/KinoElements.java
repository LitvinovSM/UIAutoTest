package autotests.UI.pagesAndActions.rambler.kinoPage;

import autotests.UI.pagesAndActions.BaseaActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KinoElements extends BaseaActions {
    //элементы про кино
    protected String BASE_URL = "https://kino.rambler.ru/movies/";
    protected String titleText = "Кино — афиша московских кинотеатров, рецензии на новые фильмы, трейлеры и отзывы - Рамблер/кино";

    @FindBy(xpath = "//title[contains(text(),'Кино')]")
    protected WebElement pageTitle;
}
