package Maven1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RedBus {
	static {
		System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
	}
  @Test
  public void Test() throws InterruptedException {
	  WebDriver driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://www.redbus.in");
	  driver.switchTo().activeElement().sendKeys("banglore");
	  driver.findElement(By.xpath("//li[text()='Bangalore (All Locations)']")).click();
	  WebElement dst = driver.findElement(By.id("dest"));
	       dst.click();
	       dst.sendKeys("UDUPI");
	 driver.findElement(By.xpath("//li[text()='Manoor (Udupi)']")).click();     
	 driver.findElement(By.xpath("//label[text()='Onward Date']")).click();
	 driver.findElement(By.xpath("//div[@class='rb-calendar']//td[@class='current day']")).click();
 driver.findElement(By.xpath("//label[text()='Return Date']")).click();
 driver.findElement(By.xpath("//div[@class='rb-calendar']//button[text()='>']")).click();
 Thread.sleep(1000);
 driver.findElement(By.xpath("//div[@id='rb-calendar_return_cal']//td[text()='4']")).click();
  driver.findElement(By.id("search_btn")).click();
  Thread.sleep(5000);
  //Thread.sleep(5000);
  //driver.findElement(By.xpath("//li[@id='8351998']//div[text()='View Seats']")).click();
  driver.findElement(By.xpath("//div[text()='View Seats']")).click();
  Actions act=new Actions(driver);
WebElement ele = driver.findElement(By.xpath("//canvas[@data-type='upper']"));
  act.moveToElement(ele).moveByOffset(454/7, 211/7).click().perform();
  driver.findElement(By.xpath("//li[@class='db oh']")).click();
  driver.findElement(By.xpath("//button[text()='continue']")).click();
  
  
  
  
  }
}
