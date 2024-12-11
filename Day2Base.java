package week5.Assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Day2Base {
	
	
public RemoteWebDriver driver ;
	
	@Parameters({"url","userName","password"})
	@BeforeMethod
	public void precondition(String url, String userName, String password ) {
		driver = new ChromeDriver() ;
		driver.manage().window().maximize(); 
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8)) ;
		//Entering credentials and logging in 
		driver.findElement(By.id("username")).sendKeys(userName)	;	
		driver.findElement(By.id("password")).sendKeys(password)	;
		driver.findElement(By.id("Login")).click();
		//Clicking on toggle menu button
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click() ;
		//Clicking on View all button on toggle menu
		driver.findElement(By.xpath("//button[text() ='View All']")).click() ;
		//Clicking on All Apps drop down to make Legal entities easily visible
		driver.findElement(By.xpath("//span[text()='All Apps']/preceding-sibling::lightning-primitive-icon")).click() ;	
		//Clicking on Legal entities available on All items panel
		driver.findElement(By.xpath("//p[text() ='Legal Entities']")).click() ;
		
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	

}
