package Maven1;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class ActitimeDemo1 {
	static {
		System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
	}
  @Test
  public void Main() throws IOException {
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://demo.actitime.com/login.do");
	  TakesScreenshot ts= (TakesScreenshot)driver;
	 File src = driver.findElement(By.name("username")).getScreenshotAs(OutputType.FILE);
      File dst = new File("./photo/actitimeusername.png");
      FileUtils.copyFile(src, dst);
      System.out.println(driver.getTitle());
      driver.close();
 
  }
}
