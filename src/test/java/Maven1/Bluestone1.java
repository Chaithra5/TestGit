package Maven1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Bluestone1 {
	static {
		System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
	}
  @Test
  public void f() throws IOException, InterruptedException {
	  WebDriver driver =new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         driver.get("https://www.bluestone.com");
         driver.findElement(By.xpath("//a[text()='Visit Our Stores']")).click();
         Thread.sleep(5000);
         Thread.sleep(5000);
         TakesScreenshot ts=(TakesScreenshot)driver;
         List<WebElement> maps = driver.findElements(By.xpath("//div[@class='map-image']"));
              int i=1;
         for(WebElement nmap:maps)
                {
                	File src = nmap.getScreenshotAs(OutputType.FILE);
                    File dst = new File("./photo/map"+i+".png");
                    FileUtils.copyFile(src, dst);
                    i++;
                
                }
         driver.close();
    }
}
