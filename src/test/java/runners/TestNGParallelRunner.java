package runners;
import org.testng.annotations.DataProvider;

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
				"html:target/reports/htmlReports.html"
		}
				)

public class TestNGParallelRunner extends AbstractTestNGCucumberTests{
	
	@DataProvider(parallel=true) //By default Data provided return list of scenarios. All the scenarios are running in parallel
	public Object[][] scenarios(){
		return super.scenarios(); //returning array of scenarios and features - 2 dimensional array.
		//scenarios() is a default method from super class	
		
	}

}
