package stepdefs;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchStepDef {

	WebDriver driver;

	@Given("I launch google page")
	public void i_launch_google_page() {
		// Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();

	}

	@When("I search Java tutorial")
	public void i_search_java_tutorial() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("q")).sendKeys("Java tutorial");
		driver.findElement(By.name("q")).submit();
		// if webelement type=submit is present then we can use submit() else use
		// click()

	}

	@Then("Should display Java result page")
	public void should_display_java_result_page() {
		// Write code here that turns the phrase above into concrete actions
		String pageTitle = driver.getTitle();
		Assert.assertEquals("Java tutorial - Google Search", pageTitle);

	}

	@When("I search Selenium tutorial")
	public void i_search_selenium_tutorial() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("q")).sendKeys("Selenium tutorial");
		driver.findElement(By.name("q")).submit();
	}

	@Then("Should display Selenium result page")
	public void should_display_selenium_result_page() {
		// Write code here that turns the phrase above into concrete actions
		String pageTitle = driver.getTitle();
		Assert.assertEquals("Selenium tutorial - Google Search", pageTitle);
	}

	//Only stepdefs for missing steps i.e., search and result page are generated though the feature file is different.
	//Reused Launch page and close browser definitions
	
	@When("I search Cypress tutorial")
	public void i_search_cypress_tutorial() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("q")).sendKeys("Cypress tutorial");
		driver.findElement(By.name("q")).submit();
	}

	@Then("Should display Cypress result page")
	public void should_display_cypress_result_page() {
		// Write code here that turns the phrase above into concrete actions
		String pageTitle = driver.getTitle();
		//Assert.assertEquals("Cypress tutorial - Google Search", pageTitle);
		
		//failing the scenario to attach SS
		Assert.assertEquals("Cypress tutorial - Google Search", pageTitle);
	}

	@Then("Close the browser")
	public void close_the_browser() {
		// Write code here that turns the phrase above into concrete actions
		driver.close();
	}

	@After
	public void teardown(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			TakesScreenshot screen=(TakesScreenshot) driver;
			File screenshot=screen.getScreenshotAs(OutputType.FILE);
			byte[] fileContent=FileUtils.readFileToByteArray(screenshot);
			scenario.attach(fileContent, "image/png", "image1");
			}
	}
}
