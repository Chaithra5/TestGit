package Maven1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Brokenlinks_testyantra {
	static {
		System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
	}
  @Test
  public void main() throws IOException {
	  WebDriver driver =new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       driver.get("http://www.testyantra.com/");
	 List<WebElement> links = driver.findElements(By.tagName("a"));
	 try {
	 for(WebElement nlink:links)
	  {
		 
		  URL u = new URL(nlink.getAttribute("href"));
		  HttpURLConnection connection = (HttpURLConnection)u.openConnection();
	         int i = connection.getResponseCode();
		  
	 if(i==200)
	 {
		 System.out.println("Link is not broken :"+i);
		 System.out.println(connection.getResponseMessage());
	 }else
	 {
		 System.out.println("Link is broken :"+i);
		 System.out.println(connection.getResponseMessage());
	 }
	  }
	 }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
		  
	  driver.close();
  }
}
