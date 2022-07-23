package autotests.unils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;

public class TestConfigFactory {
    private volatile Config config;
    private volatile WebConfig webConfig;

    /**
     * Создание выборки конфигов из системных свойств,
     * системных переменных и файла WebTestsConfig.cof
     */
    private TestConfigFactory() {
        config = ConfigFactory.systemProperties()
                .withFallback(ConfigFactory.systemEnvironment())
                .withFallback(ConfigFactory.parseResources("WebTestsConfig.conf"));

    }

    /**
     * Получение части вебконфига web
     */
    public synchronized WebConfig getWebConfig() {
        if (webConfig == null) {
            webConfig = ConfigBeanFactory.create(config.getConfig("web"), WebConfig.class);
        }
        return webConfig;
    }

    /**
     * Получение экземпляра класса фабрики*/
    public synchronized static TestConfigFactory getInstance() {
        return new TestConfigFactory();
    }
}
