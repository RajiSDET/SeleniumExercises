package day8.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				ChromeDriver driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				

		// Launch URL  //input[@id=""]   //input[@id="password"] //input[@id="Login"]
				driver.get("https://www.leafground.com/window.xhtml");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.findElement(By.xpath("//span[contains(text(),'Open with delay')]")).click();
				
                WebDriverWait wait = new WebDriverWait(driver,30);
               	Set<String> windowHandles = driver.getWindowHandles();
				List<String> windows= new ArrayList<String>(windowHandles);
				driver.switchTo().window(windows.get(1));
				String Child_Window_title = driver.switchTo().window(windows.get(1)).getTitle();
				System.out.println("Child_Window_title is - "+Child_Window_title);
				driver.close();
	}

}

/*
 
Day_9:

Step:1  Launch the browser and Load url
https://www.leafground.com/window.xhtml

Step:2 Click on the button Open with delay
      apply explicitWait->numberofWindowsTobe
Step:3 Get the title of second window

Step:4 Quit browser
 */
