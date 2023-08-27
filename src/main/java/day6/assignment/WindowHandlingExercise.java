package day6.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

}

/*
1. Launch Salesforce application https://login.salesforce.com/
2. Login with username as "hari.radhakrishnan@qeagle.com" 
    and password as "Leaf$1234"
3. Click on Learn More link in Mobile Publisher
4. Click on Confirm button
5. Get child window Title  
6. close the child window 
7. Get parent window Title 
8. close the parent window


 * 
 * */
