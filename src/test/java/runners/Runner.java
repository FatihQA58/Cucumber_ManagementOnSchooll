package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/reports/HTMLReport.html",
                "json:target/reports/JSONReport.json",
                "junit:target/reports/XMLReport.xml"
        },

        features="src/test/resources",
        glue= {"stepdefinitions","hooks"},
        tags= "@e2e",
        dryRun= false
)

public class Runner {
}