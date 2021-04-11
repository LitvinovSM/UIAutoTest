package Tests.UI.Pages.Telegram;

import cucumber.api.java.ru.И;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelegramWebActions extends TelegramWebElements {



    @И("^открывает телеграмм веб$")
    public void открываетТелеграммВеб() throws InterruptedException {

        DRIVER.get(TELEGRAM_WEB_URL);
        LocalStorage localStorage =  ((ChromeDriver) DRIVER).getLocalStorage();
        localStorage.clear();

        localStorage.setItem("dc2_auth_key","\"3a4c27074c612698fb113e0c55129478a28b833c74a36eb621d51373518749a691e88bdd5a294c5d3a563a418b0e1dae8bdcfc3b870817b16e336adfe450a731e1e7c80361ab8ee72d575839db3599164d9abbd3f03ed162d91755136c930cea9ab3fa126da9d14cce64d7b63b09d4b97a754c9a45dbc5746884bfb8ac316e024f01eb53139454aa2684ae37d42078f9766a056ff9efd409a61afb97f9fe820968cf8710325688a935e53e72625835c0c0da3e87910c982461304606094f32bc65a53b06e5ac721997279d7a47bc4b75358426ebcca39304f5423833d065a259bae4ffaff9c10095433c51501ba26db64cac6895c64f4a8bcde6f6ead0f1810c\"");
        localStorage.setItem("user_auth","{\"dcID\":2,\"id\":330431315}");
        DRIVER.get(TELEGRAM_WEB_URL);
        ((JavascriptExecutor)DRIVER).executeScript("window.open()");
        Actions action = new Actions(DRIVER);
        action.sendKeys(Keys.CONTROL +"t").build().perform();

        ArrayList<String> tabs = new ArrayList<String> (DRIVER.getWindowHandles());
        DRIVER.switchTo().window(tabs.get(1)); //switches to new tab
        DRIVER.get(TELEGRAM_WEB_URL);

        DRIVER.switchTo().window(tabs.get(0)); // switch back to main screen
        DRIVER.get(TELEGRAM_WEB_URL);
        Thread.sleep(10000);
    }

}
