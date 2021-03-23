package UIAutoTest.DefaultSteps;

import static UIAutoTest.unils.PropertiesUtil.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverInit {

    private static WebDriver DRIVER;

    private String DRIVER_TYPE = getProperty("driver.type");
    private String SYS_OS_ARCH_TYPE = getProperty("sys.os.arch_type");


    public static WebDriver getDRIVER() {
        return DRIVER;
    }

    public static void setDRIVER(WebDriver DRIVER) {
        WebDriverInit.DRIVER = DRIVER;
    }

    public static void initDriver(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/webDrivers/chromeDrivers/chromedriver.exe");
        setDRIVER(new ChromeDriver());
    }
}
