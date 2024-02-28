package Base;
 
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import java.util.List;
//import java.util.Properties;
// 
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.testng.ITestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base{
 
	public WebDriver driver ;
public static Logger logger;
public Properties p;
	
//	public static Logger getlogger()
//	{
//		logger=LogManager.getLogger();
////		return logger;
//	}
//   	
   	
	@BeforeClass
	@Parameters({"os","browsers"})
	public  void driverSetup(String os,String br) throws InterruptedException, IOException {
		logger=LogManager.getLogger(this.getClass());
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No matching os.....");
				return;
			}
			
			switch(br.toLowerCase()) {
			case "chrome":cap.setBrowserName("chrome");
						break;
			case "edge":cap.setBrowserName("MicrosoftEdge");
						break;
			default:System.out.println("No matching browser....");
						return;
			
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			
		}
		else if(getProperties().getProperty("execution_env").equals("local")) {
			switch(br)
			{
			case "chrome": driver=new ChromeDriver();
			                break;
			case "edge": driver=new EdgeDriver();
			                 break;
			case "firefox":driver=new FirefoxDriver();
			                 break;
			}
		}
		

				
       		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			driver.get("https://www.urbanladder.com/");
			driver.manage().window().maximize();

		}
	

 
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public static String screenShot(String filename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir") + "\\screenshots\\" + filename + ".png");
		FileUtils.copyFile(src, trg);
		return trg.getAbsolutePath();
	}
	public Properties getProperties() throws IOException {
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		return p;
		
	}
}