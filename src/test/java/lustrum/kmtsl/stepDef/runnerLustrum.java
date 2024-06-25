package lustrum.kmtsl.stepDef;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "lustrum.kmtsl.stepDef", plugin = {"pretty", "html:target/cucumber-reports"})

public class runnerLustrum {
}