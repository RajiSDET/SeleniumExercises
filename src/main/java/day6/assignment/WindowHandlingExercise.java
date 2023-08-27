package day6.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Learn More')]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows= new ArrayList<String>(windowHandles);
		
		System.out.println(windows.get(0));
		System.out.println(windows.get(1));
		
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String Child_Window_title = driver.switchTo().window(windows.get(1)).getTitle();
		System.out.println("Child_Window_title is - "+Child_Window_title);
		driver.close();
		
		String Parent_Window_title = driver.switchTo().window(windows.get(0)).getTitle();
		System.out.println("Parent_Window_title is - "+Parent_Window_title);
		driver.close();
			

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
