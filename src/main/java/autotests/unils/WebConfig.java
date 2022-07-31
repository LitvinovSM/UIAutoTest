package autotests.unils;

import autotests.UI.commonWrappers.DriverActions;
import lombok.Data;
/**
 * Вебконфиг в формате DTO с геттерами и сеттерами через ломбук*/
@Data
public class WebConfig {
    private String BaseURL;
    private DriverActions.BrowserType browserType;
    private String launchType;
    private int implicitlyWaitValue;
    private int explicitlyWaitValue;
    private int pageLoadTimeout;

}
