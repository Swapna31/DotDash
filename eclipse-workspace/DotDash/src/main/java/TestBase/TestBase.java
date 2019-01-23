package TestBase;

import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//This class will have reusable methods
public class TestBase {
	
	public static WebDriver driver;
	String homepage="http://localhost:8081/";
	String url="";
		
	public void SetUp()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Swapna Tirumala\\eclipse-workspace\\DotDash\\resources\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8081/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	public void TearDown()
	{
		driver.quit();
	}
	
}
