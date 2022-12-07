package BrowsersBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.*;

public class BrowsersInvoked {
	public static WebDriver driver;
	public String browser = DataInterface.browserMain;
	public String FinalBrowser = browser.toUpperCase();

	@BeforeSuite
	public void SetProp() {
		switch (FinalBrowser) {
		case "CHROME": {
			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			break;
		}
		case "FIREFOX": {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxOptions);
			break;
		}
		case "EDGE": {
			EdgeOptions edgeOptions = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(edgeOptions);
			break;
		}
		case "OPERA": {
			OperaOptions operaOptions = new OperaOptions();
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver(operaOptions);
			break;
		}
		case "IEXPLORER": {
			InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver(internetExplorerOptions);
			break;
		}
		}

		driver.manage().window().maximize();
		driver.get(DataInterface.URL);
	}

//	@AfterSuite
//	public void toClose() {
//		driver.quit();
//	}

}
