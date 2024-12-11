package week5.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day2Static {

	@Parameters({"url","userName","password"})
	@Test
	public void staticParaDay2(String url, String userName, String password) {
		ChromeDriver driver = new ChromeDriver() ;
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
		//Clicking on the Drop down icon in Legal entities tab
		driver.findElement(By.xpath("//a[@title='Legal Entities']/following-sibling::one-app-nav-bar-item-dropdown/div")).click() ;
		//System.out.println("Dropdown clicked");
		WebElement entity = driver.findElement(By.xpath("//a[@role='menuitem']")) ;
		//Clicking on New Legal Entity
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", entity) ;
		
		//Entering the company name, description and marking the status as Active	
		driver.findElement(By.xpath("//input[@name ='CompanyName']")).sendKeys("Test Leaf") ;
		driver.findElement(By.xpath("(//textarea[@class ='slds-textarea'])[2]")).sendKeys("Salesforce") ;
		driver.findElement(By.xpath("//input[@name='country']")).sendKeys("IND") ;
		driver.findElement(By.xpath("//button[@role='combobox']")).click() ;
		driver.findElement(By.xpath("//span[@title='Active']")).click() ;
		driver.findElement(By.xpath("//button[@name ='SaveEdit']")).click() ;
		//Checking Error message
		String errmsg = driver.findElement(By.xpath("//div[@class='container']")).getText() ;
		System.out.println(errmsg);
		driver.close() ;
	}

}
