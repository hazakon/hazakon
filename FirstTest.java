package test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;



public class FirstTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();


		try {
			// Navigate to Url
			driver.get("https://zengo.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			//Maximize screen
			driver.manage().window().maximize();

			// Store elements
			WebElement btn = driver.findElement(By.id("menu-item-12609"));
			WebElement eth = driver.findElement(By.id("menu-item-13963"));


			// Actions performed 
			Actions actionProvider = new Actions(driver);
			actionProvider.moveToElement(btn).perform();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			actionProvider.moveToElement(eth).perform();
			actionProvider.click(eth).perform();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			// Find the Url
			String actualUrl = driver.getCurrentUrl();

			
			// Verify Url
			if (actualUrl.contains("zengo.com/assets/ethereum-wallet")) {
				System.out.println("Url verified");
			}
			
			// Verify logo is displaying
			if (driver.findElement(By.className("no-lazy-load")).isDisplayed()) {
				System.out.println("logo verified");
			}	
		} 
		finally {
			driver.quit();
			
		}
	}
}
