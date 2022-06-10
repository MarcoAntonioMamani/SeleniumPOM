package Support;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = "Definitions",  //el nombre de las clases implementadas de los features
        plugin = {"json:target/cucumber-reporte/cucumber.json","html:target/cucumber-report/cucumber-report.html"},
        tags = "@Pruebita"
)
public class runTest {




}
