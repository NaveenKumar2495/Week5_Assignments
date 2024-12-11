package week5.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestcaseTwo extends ProjectSpecificMethod {
	
	@Test
	public void verifyErroMsg() {
		//Clicking on the Drop down icon in Legal entities tab
		driver.findElement(By.xpath("//a[@title='Legal Entities']/following-sibling::one-app-nav-bar-item-dropdown/div")).click() ;
		//System.out.println("Dropdown clicked");
				
		//Clicking on New Legal Entity
		WebElement entity = driver.findElement(By.xpath("//a[@role='menuitem']")) ;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", entity) ;
		//Got Javascript error: Cannot read properties of undefined - So have used the Javascript Executor for clicking the element
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
		
	}
	

}
