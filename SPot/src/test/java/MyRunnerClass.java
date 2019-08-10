
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-html-report",
                "pretty"},
                features = {"src/test/Resources"},
                glue = {"src/test/java/Step"}
)


public class MyRunnerClass {

}