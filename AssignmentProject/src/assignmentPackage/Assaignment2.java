package assignmentPackage;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assaignment2 {
	WebDriver browser;
	
	@Test(priority= 1)
	public void verifylogin () throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/nusratjahan/Downloads/chromedriver1");
		WebDriver browser = new ChromeDriver();
		
		browser.get("http://demo.itlearn360.com/");
		System.out.println("open the url - http://demo.itlearn360.com/");
		
		browser.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		WebElement login =browser.findElement(By.id("loginlabel"));
		
		login.click();
	   
		WebElement username = browser.findElement(By.name("log"));
		username.sendKeys("Demo12");
		
	    browser.findElement(By.name("pwd")).sendKeys("Test123456$");
		
		browser.findElement(By.id("wp-submit")).submit();
		}
		@Test(priority = 2 ,dependsOnMethods = "verifylogin")

		public void searchcourses() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/nusratjahan/Downloads/chromedriver1");
	    WebDriver browser = new ChromeDriver();
	    browser.get("http://demo.itlearn360.com/");
		
	    browser.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    WebElement searchcourse = browser.findElement(By.name("search_course"));
	
	    searchcourse.sendKeys("learn java");
	
	    WebElement searchicon = browser.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div/nav[1]/form/button"));
	
	    searchicon.click();
		}
		@Test (priority=3,dependsOnMethods = "verifylogin")
		public void dashboard() {
			
		System.setProperty("webdriver.chrome.driver", "/Users/nusratjahan/Downloads/chromedriver1");
		WebDriver browser = new ChromeDriver();
		browser.get("http://demo.itlearn360.com/");

		
	    WebElement dashboard = browser.findElement(By.xpath("//*[@id=\"login-list\"]/li[1]/a"));
	    dashboard.click();
	    System.out.println("dashboard is displayed and it should show text -Welcome Back\n"
	    		+ "Traineer Demmo ");  
		}
		@Test(priority = 4,dependsOnMethods = "dashboard")
		public void offeredacademics() {
			System.setProperty("webdriver.chrome.driver", "/Users/nusratjahan/Downloads/chromedriver1");
			WebDriver browser = new ChromeDriver();
			browser.get("http://demo.itlearn360.com/");
			
			browser.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			WebElement login =browser.findElement(By.id("loginlabel"));

			login.click();

			WebElement username = browser.findElement(By.name("log"));
			username.sendKeys("Demo12");

			browser.findElement(By.name("pwd")).sendKeys("Test123456$");

			browser.findElement(By.id("wp-submit")).submit();	
			WebElement offeredacademic = browser.findElement(By.xpath("//*[@id=\"learn-press-user-profile\"]/ul/li[3]/a"));
			offeredacademic.click();
			
			WebElement subscribenow = browser.findElement(By.xpath("//*[@id=\"tab-academies\"]/div/div/ul/li[1]/form/div/button"));
			subscribenow.click();
		}
			
			@Test(priority = 5, dependsOnMethods = "offeredacademics")
			public void payment() {
				System.setProperty("webdriver.chrome.driver", "/Users/nusratjahan/Downloads/chromedriver1");
				WebDriver browser = new ChromeDriver();
				browser.get("http://demo.itlearn360.com/");
				WebElement rediobutton = browser.findElement(By.xpath("//*[@id=\"learn-press-payment\"]/ul/li"));
			
				rediobutton.click();
				WebElement placeorder = browser.findElement(By.xpath("//*[@id=\"learn-press-checkout-place-order\"]"));
				
				placeorder.click();
				browser.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				WebElement cardbox= browser.findElement(By.xpath("//*[@id=\"root\"]/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input"));
				
				cardbox.sendKeys("123098767");
				
				browser.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				WebElement monthyear = browser.findElement(By.xpath("//*[@id=\"root\"]/form/div/div[2]/span[2]/span[1]/span/span/input"));
				
				monthyear.sendKeys("06,24");
				browser.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				WebElement cvc = browser.findElement(By.xpath("//*[@id=\"root\"]/form/div/div[2]/span[2]/span[2]/span/span/input"));
				cvc.sendKeys("787");
				
				
				WebElement paynow = browser.findElement(By.id("payment-button"));
				
				paynow.click();
				browser.close();
		}
		
}
	
	   
	


