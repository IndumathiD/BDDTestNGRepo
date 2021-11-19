package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		publish = true,
		features="@target/failed_scenarios.txt",
		glue= {"stepdefs"},
		monochrome=true,
		dryRun=false,
		plugin= {"pretty"}
		)
public class RerunRunner extends AbstractTestNGCucumberTests{

}
