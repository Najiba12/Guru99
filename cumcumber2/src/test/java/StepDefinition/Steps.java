package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	  WebDriver driver;			
		
	    @Given("^Open the Firefox and launch the application$")					
	    public void open_the_Firefox_and_launch_the_application() 						
	    {		
	       System.setProperty("webdriver.gecko.driver", "C:\\\\\\\\Gecko\\\\\\\\geckodriver-v0.32.0-win64-unzip\\\\\\\\geckodriver.exe");					
	       driver= new FirefoxDriver();					
	       driver.manage().window().maximize();			
	       driver.get("http://demo.guru99.com/v4");		
	     //  String url=driver.getTitle();
	   	Assert.assertEquals("They are same",driver.getTitle(), "Guru99 Bank Home Page");
	   	
	    }		

	    @When("^Enter the Username and Password$")					
	    public void enter_the_Username_and_Password() throws Throwable 							
	    {		
	       driver.findElement(By.name("uid")).sendKeys("username12");							
	       driver.findElement(By.name("password")).sendKeys("password12");		
	       Thread.sleep(3000);
	    }
	  
	    @Then("^Reset the credential$")					
	    public void Reset_the_credential() throws Throwable 							
	    {		
	       driver.findElement(By.name("btnLogin")).click();					
	    }	
	    @And("^accept the alert$")
	    public void accept_the_alert() throws Throwable{
	    	Alert alert = driver.switchTo().alert();
	    	alert.accept();
	    }
        @Then("^quit$")
        public void quit() throws Throwable{
        	Thread.sleep(2000);
        	driver.quit();
        }
	    
}
