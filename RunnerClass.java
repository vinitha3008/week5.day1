package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src/main/java/features/salesforce.feature",glue="steps")
public class RunnerClass extends AbstractTestNGCucumberTests{

}
