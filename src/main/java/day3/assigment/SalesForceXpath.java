package day3.assigment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Day_3 Assignment:
"Test Steps for Create Campaign:
1. Login to https://login.salesforce.com
2. Click on toggle menu button from the left corner
3. Click view All and click Sales from App Launcher
4. Click on Campaigns tab 
5. Click on New button
6. Enter Campaign name as 'Bootcamp'
7. Choose Start date as Tomorrow
8. End date as Tomorrow+1
9. click Save and Verify the newly created Campaign"*/
		
		
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			ChromeDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			

	// Launch URL  //input[@id=""]   //input[@id="password"] //input[@id="Login"]
			driver.get("https://login.salesforce.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
			driver.findElement(By.id("password")).sendKeys("Leaf$1234");
			driver.findElement(By.id("Login")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			driver.findElement(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
			driver.findElement(By.xpath("(//p[contains(text(),'Sales')])[1]")).click();
			
			
			WebElement Campaigns=driver.findElement(By.xpath("//a[@title='Campaigns']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", Campaigns);
			
			driver.findElement(By.xpath("//a[@title=\"New\"]")).click();
			driver.findElement(By.xpath("//input[@class=' input']")).sendKeys("Bootcamp_Raji");
		
			
				
			 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			 Calendar c = Calendar.getInstance();
			 c.setTime(new Date()); // Using today's date
			 c.add(Calendar.DATE, 1); // Adding 1 day
			 String Startdate = sdf.format(c.getTime());
			 System.out.println(Startdate);
			 driver.findElement(By.xpath("(//input[@class=\" input\"])[2]")).sendKeys(Startdate);
			 
					 
			 c.add(Calendar.DATE, 1); // Adding 1more day
			 String Enddate = sdf.format(c.getTime());
			 System.out.println(Enddate);
			 driver.findElement(By.xpath("(//input[@class=\" input\"])[3]")).sendKeys(Enddate);
			 driver.findElement(By.xpath(" (//span[contains(text(),'Save')])[3]")).click();
			 String text = driver.findElement(By.xpath("//div[@title=\"Bootcamp_RajiView Campaign Hierarchy\"]")).getText();
			 System.out.println("Verified that the newly created Campaign is "+text);
			
			
	}

}
