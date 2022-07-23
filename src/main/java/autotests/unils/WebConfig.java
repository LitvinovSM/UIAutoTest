package autotests.unils;

import autotests.UI.commonWrappers.DriverActions;
import lombok.Data;
/**
 * Вебконфиг в формате DTO  с неявными геттерами и сеттерами*/
@Data
public class WebConfig {
    private String BaseURL;
    private DriverActions.BrowserType browserType;
    private String launchType;

}
