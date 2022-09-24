package autotests.UI.pages.main;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;

public class MainActions extends MainElements {

    @Дано("'главная страница' страница открыта")
    public void openMainPage() throws InterruptedException {
        webDriver.get(BASE_URL);
        Thread.sleep(5000);
    }

    @И("открывает телеграмм веб")
    public void открываетТелеграммВеб() {
    }
}
