package MyRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {".\\src\\main\\resources\\Features"},glue = {"StepDefs"}, tags = "@AppiumTest")
public class Runner extends AbstractTestNGCucumberTests{
}
