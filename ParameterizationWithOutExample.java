//package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ParameterizationWithOutExample {
    // Change done to test
	WebDriver driver;
	@Given("^User Navigates to LogIn Page$")
	public void user_Navigates_to_LogIn_Page() throws Throwable {
		System.out.println(System.getProperty("user.dir"));
		String workingDirectory=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", workingDirectory+"\\Config\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		Thread.sleep(5000);
	}

	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_and(String userName, String passWord) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("txtUsername")).sendKeys(userName);
	    driver.findElement(By.id("txtPassword")).sendKeys(passWord);
	}

	@Then("^User should be able to login$")
	public void user_should_be_able_to_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
		System.out.println("URL of landing page :" +driver.getCurrentUrl());
		driver.quit();
	}

	
}
