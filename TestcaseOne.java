package week5.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestcaseOne extends ProjectSpecificMethod {

	
	@Test
	public void createNewEntity() {
		//Clicking on the Drop down icon in Legal entities tab
		driver.findElement(By.xpath("//a[@title='Legal Entities']/following-sibling::one-app-nav-bar-item-dropdown/div")).click() ;
		//System.out.println("Dropdown clicked");
		
		//Clicking on New Legal Entity
		WebElement entity = driver.findElement(By.xpath("//a[@role='menuitem']")) ;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", entity) ;
		//Got Javascript error: Cannot read properties of undefined - So have used the Javascript Executor for clicking the element
		//Entering the Legal entity name and saving the entity
		driver.findElement(By.xpath("//input[@name ='Name']")).sendKeys("Salesforce Automation by Naveen Kumar") ;
		driver.findElement(By.xpath("//button[@name ='SaveEdit']")).click() ;
		//Verifying the created Legal entity name  
		String Title = driver.findElement(By.xpath("//slot[@name='outputField']/lightning-formatted-text")).getText() ;
		System.out.println(Title);
		if(Title.contains("Salesforce Automation by Naveen Kumar")) {
			System.out.println("Legal Entity got created successfully");
		}
		else {
			System.out.println("Legal Entity not created");
		}
		
		
	}


}
