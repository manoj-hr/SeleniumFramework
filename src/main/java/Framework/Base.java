package Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;


public class Base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver invokingBrowser() throws IOException {
		
	
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop=new Properties();
		prop.load(fis);
//		String browserName=System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless")){
				options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\selenium-java-3.141.59\\geckodriver-v0.30.0-win32\\geckodriver.exe");
	        driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("MS edge")) {
			 System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\msedgedriver.exe");
		     driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public String getScreenshot(String testName,WebDriver driver) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destPath=System.getProperty("user.dir")+"\\reports\\"+testName+".png";
		FileHandler.copy(src,new File(destPath));
		return destPath;
	}

}
