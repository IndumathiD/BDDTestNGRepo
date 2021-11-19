package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//For TestNG - no need of @RunWith, only CucumberOptions is enough.
//Runner class should extend AbstractTestNGCucmberTests
//THis will run in sequential order
@CucumberOptions(
		publish = true,
		features="src//test//resources//features",
		glue= {"stepdefs"},
		monochrome=true,
		dryRun=false,
		plugin= {"pretty",
				"html:target/reports/htmlReports.html",
				"rerun:target/failed_scenarios.txt"	//rerun plugin to generate failed scenarios txt file
				
		}
				)

public class TestNGSequentialRunner extends AbstractTestNGCucumberTests{

}
