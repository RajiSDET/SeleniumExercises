package day5.assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceAlertFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		
		
		System.out.println("Text alert = "+text);
		
		String Actual_text = driver.findElement(By.xpath("//p[contains(text(),'You pressed OK!')]")).getText();
		String Expected_text = "You pressed OK!";
		Assert.assertEquals(Actual_text , Expected_text);
		
		
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		
		
		Alert alert2 = driver.switchTo().alert();
		String text2 = alert.getText();
		alert.dismiss();
		
		
		System.out.println("Text alert = "+text);
		
		String Actual_text2 = driver.findElement(By.xpath("//p[contains(text(),'You pressed Cancel!')]")).getText();
		String Expected_text2 = "You pressed Cancel!";
		Assert.assertEquals(Actual_text2 , Expected_text2);

	}

}

/*
 Day_6 
 Assignment 

1.Launch the url:
https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm 
2.Click Try It Button
3.Click OK/Cancel in the alert
4.Confirm the action is performed correctly by verifying the text !!

Hint
*Switch to the frame
*Then click Try It with xpath
*Switch to the alert and Enter your name in alert box
*Then perform accept / dismiss
*Get the text using id 
*Verify the text based on the action
*/
