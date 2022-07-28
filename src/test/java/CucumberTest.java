
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features", // путь к фичам
        glue = "autotests", // пакет с шагами
        tags = "@all", // тэги запуска
        //dryRun = true,// признак проверки имплементации шагом перед прохождением теста
        snippets = SnippetType.CAMELCASE // в каком формате предлагать нереализованные шаги
//      name = "^Успешное|Успешная.*" // фильтрация запускаемых тестов, у которых название удовлетворяет регулярному выражению
)
public class CucumberTest {

}
