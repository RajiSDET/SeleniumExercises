package day4.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 Day_4 
 Assignment 

Credentials:
hari.radhakrishnan@qeagle.com
Leaf$1234



		ChromeOptions options = new ChromeOptions();	options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);



1. Launch https://login.salesforce.com/ 
2. Login to Salesforce with your username and password
3. Click on the App Launcher (dots)
4. Click View All
5. Type Content on the Search box
6. Click the Content Link
7. Click on Chatter Tab
8. Verify the Chatter title on the page
9. Click the Question tab
10. Type Question 
11. Type Details 
12. Click Ask
13. Confirm the question appears
14. Close the browser
 
 
 
 
 */

public class SalesForceDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$1234");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
		driver.findElement(By.xpath("//input[@id='input-105']")).click();
		driver.findElement(By.xpath("//input[@id='input-105']")).sendKeys("Content");
		driver.findElement(By.xpath("//a[@class=\"slds-text-heading_small\"]")).click();
		Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Chatter')]"));
	      JavascriptExecutor executor = (JavascriptExecutor)driver;
	      executor.executeScript("arguments[0].click();", element);
	      
	      String expected_title = "Chatter Home | Salesforce";
	      String actual_title = driver.getTitle();
	      
	      Assert.assertEquals(actual_title, expected_title);
	      driver.findElement(By.xpath("//a[@title='Question']")).click();
	      //driver.findElement(By.xpath("//button[@title='What would you like to know?']")).click();
	      driver.findElement(By.xpath("//textarea[@placeholder='What would you like to know?']")).sendKeys("What would you like to know");
	      driver.findElement(By.xpath(" //div[@data-placeholder='If you have more to say, add details here...']")).sendKeys("Details");
	      driver.findElement(By.xpath("//button[contains(text(),'Ask')]")).click();
	      String actual_text = driver.findElement(By.xpath("//article[@data-type=\"QuestionPost\"]/div[2]/span")).getText();
	      String expected_text = "What would you like to know";
	      Assert.assertEquals(actual_text, expected_text);
	      driver.close();
	     
	      
	}

}


