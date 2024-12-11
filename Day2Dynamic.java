package week5.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day2Dynamic extends Day2Base {

	@DataProvider(name="getData")
	public String[][] sendData(){
		String[][] data = new String[3][2] ;
		data[0][0] = "Salesforce Automation by Naveen01" ;
		data[0][1] = "Test Leaf" ;
		
		data[1][0] = "Salesforce Automation by Naveen02" ;
		data[1][1] = "CTS" ;
		
		data[2][0] = "Salesforce Automation by Naveen03" ;
		data[2][1] = "WIPRO" ;
			
		return data ;
	}
	
		
	@Test(dataProvider="getData")
public void dynamicParaDay2(String legalEnt, String compName ) {
	//System.out.println("Method started");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8)) ;
	//Clicking on the Drop down icon in Legal entities tab
	driver.findElement(By.xpath("//a[@title='Legal Entities']/following-sibling::one-app-nav-bar-item-dropdown/div")).click() ;
	//System.out.println("Dropdown clicked");
	
	WebElement entity = driver.findElement(By.xpath("//a[@role='menuitem']")) ;
	//Clicking on New Legal Entity
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", entity) ;
	
	// Entering the Legal Entity name and company name through Dynamic parameterization 
	driver.findElement(By.xpath("//input[@name ='Name']")).sendKeys(legalEnt) ;
	driver.findElement(By.xpath("//input[@name ='CompanyName']")).sendKeys(compName) ;
	driver.findElement(By.xpath("//button[@name ='SaveEdit']")).click() ;
	//Verifying the created Legal entity name  
	String Title = driver.findElement(By.xpath("//slot[@name='outputField']/lightning-formatted-text")).getText() ;
	System.out.println(Title);
	if(Title.contains(legalEnt)) {
		System.out.println("Legal Entity got created successfully");
	}
	else {
		System.out.println("Legal Entity not created");
	}
	
}
	

}
