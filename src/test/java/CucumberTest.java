import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features", // путь к фичам
        glue = "Tests", // пакет с шагами
        tags = "@1", // тэги запуска
        //dryRun = true,// признак проверки имплементации шагом перед прохождением теста
        snippets = CucumberOptions.SnippetType.CAMELCASE // в каком формате предлагать нереализованные шаги
//      name = "^Успешное|Успешная.*" // фильтрация запускаемых тестов, у которых название удовлетворяет регулярному выражению
)
public class CucumberTest {

}
