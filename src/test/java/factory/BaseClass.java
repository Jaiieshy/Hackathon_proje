package factory;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
 
public class BaseClass
{
	public static WebDriver driver;
	static Properties p;
	static Logger logger;
	
	public static WebDriver initilizeBrowser() throws IOException
	{
		switch(getProperties().getProperty("browser").toLowerCase())
		{
				case "chrome":
			        driver=new ChromeDriver();
			        break;
			    case "edge":
			    	driver=new EdgeDriver();
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
		}
		driver.manage().window().maximize();		  
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}
	public static WebDriver getDriver()
	{
		return driver;
	}
 
    public static Properties getProperties() throws IOException
    {		
         FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
         p=new Properties();
	     p.load(file);
	     return p;
    }
    

	
	public static Logger getlogger1()
	{
		logger=LogManager.getLogger();
		return logger;
	}
  
}