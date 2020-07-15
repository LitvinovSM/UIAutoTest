package UIAutoTest.unils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesUtil implements AutoCloseable{
    private static final Logger LOGGER = Logger.getLogger(PropertiesUtil.class.getName());
    private static PropertiesUtil instance;
    private static Properties properties;

    /**
     * Конструктор, который всегда инициализирует файл, из которого смотреть свойства
     */
    //TODO : добавить возможность указывать несколько файлов из которых читать
    private PropertiesUtil(){
        initProperties();
    }

    /**
     * Инициализируем свойства и указываем файл, из которого эти свойства мы будем получать
     */
    private static void initProperties() {
        String configFile = System.setProperty("ConfigFile", "config/application.properties");
        properties = new Properties();

        try (InputStream streamFromResource = PropertiesUtil.class.getClassLoader().getResourceAsStream(configFile)){
            try (InputStreamReader reader = new InputStreamReader(streamFromResource, "UTF-8")){
                properties.load(reader);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Не удалось получить доступ к файлу со свойствами" + e.getStackTrace());
        }
    }

    /**
     * Инициализирует объект PropertiesUtil и возвращает ссылку на него
     * @return объект PropertiesUtil
     */

    public static synchronized PropertiesUtil getInstance(){
        if (instance == null){
            instance = new PropertiesUtil();
        }
        return instance;
    }

    /**
     * Находит свойство по названию и возвращает свойство без лишних пробелов
     * @param propertyName - название свойства
     * @return свойство без пробелов
     */
    private String getProp(String propertyName){
        String propertyValue = getProps().getProperty(propertyName,"");
        if(propertyValue.isEmpty()){
            LOGGER.log(Level.INFO,"Свойство {} не было найдено",propertyName);
        }
        return propertyValue.trim();
    }

    /**
     * Инициализирует класс со свойствами и возвращает объект Properties
     * @return инициализированный объект Properties
     */
    public static Properties getProps(){
        initProperties();
        return properties;
    }

    /**
     * Возвращает значение свойства по его названию.
     * @param property - название свойства
     * @return - значение свойства
     */
    public static String get(String property) {
        return getInstance().getProp(property);
    }

    /**
     * Возвращает значение свойства по его названию.
     * Если пустое - присваивает свойству умолчательное значение
     * @param property - название свойства
     * @param defValue - умолчательное значение
     * @return - значение свойства
     */
    public static String get (String property, String defValue) {
        String value = getInstance().getProp(property);
        return value.isEmpty() ? defValue : value;
    }

    @Override
    public void close() throws Exception {
        throw new Exception("Не удалось завершить работу с ресурсом"); // выкидываем это исключение, когда не удалось завершить работу с ресурсами
    }
}
