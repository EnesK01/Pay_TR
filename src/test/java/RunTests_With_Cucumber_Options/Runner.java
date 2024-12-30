package RunTests_With_Cucumber_Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json",
                "junit:target/cucumber-reports.xml",
                "pretty"
        },
        features = "src/test/resources/Paytr_Prod_Features",
        glue = "StepDefinitions",
        tags = "@ApplyPageTests",
        dryRun = false
)
public class Runner extends AbstractTestNGCucumberTests {

}
