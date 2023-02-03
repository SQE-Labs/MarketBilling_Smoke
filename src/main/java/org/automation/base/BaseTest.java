package org.automation.base;


import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.automation.listeners.TestReporter;
import org.automation.listeners.TestRunListener;
import org.automation.logger.Log;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.PropertiesUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.*;

import static java.io.File.separator;
import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;
import static java.util.stream.Collectors.toList;


@Listeners({TestRunListener.class, TestReporter.class})
public class BaseTest {

        public static ExtentReports extent;
        public static ExtentTest test;

        public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

        public static WebDriver getDriver() {
            return driver.get();
        }

        public static void closeDriver() {
            getDriver().close();
            //driver.remove();
        }
    public static void reportLog(String message) {
       // message = BREAK_LINE + message;
        Log.info("Message: " + message);
        Reporter.log(message);
    }
        @BeforeClass(alwaysRun = true)
        public void beforeClass() throws MalformedURLException {
            String browser = PropertiesUtil.getPropertyValue("browser");
            String url = PropertiesUtil.getPropertyValue("baseUrl");
            //	driver.set(new WebDriver(new URL("http://localhost:4444/wd/hub")));
            //driver = (ThreadLocal<WebDriver>) BrowserFactory.getDriver();

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    // driver = new ThreadLocal<WebDriver>();
                    driver.set(new ChromeDriver());
                    break;

                case "fireFox":
                    // WebDriverManager.firefoxdriver().setup();
                    //driver = new FirefoxDriver(BrowserOptions.getFirefoxOptions());
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + browser);
            }
            // driver.set(Objects.requireNonNull(driver));

            getDriver().manage().window().maximize();
            getDriver().navigate().to(url);
            //login();
        }
        public void login() {
            try {

                LoginPage loginPage = new LoginPage();
                System.out.println(getDriver().getTitle());
                loginPage.login(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }



        @AfterClass(alwaysRun = true)
        public void afterMethod() {
            //clearCookies();
            closeDriver();
        }

        @BeforeMethod
        public void LaunchApplication() throws Exception {

        }






        /**
         * Data Provider method to get data from Excel file.
         *
         * @param method test method executed
         * @return excel data
         */
        @DataProvider(name = "ExcelDataProvider")
        public Iterator<Object[]> provideData(Method method) {
            List<Object[]> excelData = new ArrayList<Object[]>();
            String pathName = "src" + separator + "test" + separator + "resources" + separator + "ExcelData.xlsx";
            Connection con = null;
            Recordset record = null;
            try {
                Fillo fillo = new Fillo();
                con = fillo.getConnection(pathName);
                record = con.executeQuery("Select * from TestData where TestCase = '"
                        + method.getDeclaringClass().getSimpleName() + "." + method.getName() + "'");
                while (record.next()) {
                    Map<String, String> data = new HashMap<String, String>();
                    for (String field : record.getFieldNames()) {
                        if (!record.getField(field).isEmpty()) {
                            data.put(field, record.getField(field));
                        }
                    }
                    excelData.add(new Object[]{data});
                }
            } catch (FilloException e) {
                Log.error("Unable to get data from Excel", e);
                throw new RuntimeException("Could not read " + pathName + " file.\n" + e.getStackTrace().toString());
            } finally {
                con.close();
                record.close();
            }
            return excelData.iterator();
        }

        /**
         * Data Provider method to get data from CSV file.
         *
         * @param method test method executed
         * @return CSV data
         */
        @DataProvider(name = "CsvDataProvider")
        public Iterator<Object[]> getCsvData(Method method) {
            List<Object[]> csvData = new ArrayList<Object[]>();
            String csvRegex = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
            String pathName = "src" + separator + "test" + separator + "resources" + separator + "CsvData.csv";
            try {
                String[] keys = lines(get(pathName)).findFirst().orElseThrow(IOException::new).split(csvRegex);
                List<String[]> dataLines = lines(get(pathName)).filter(
                                line -> line.startsWith(method.getDeclaringClass().getSimpleName() + "." + method.getName()))
                        .map(line -> line.split(csvRegex)).collect(toList());
                for (String[] values : dataLines) {
                    Map<String, String> data = new HashMap<String, String>();
                    for (int i = 1; i < keys.length; i++) {
                        if (!values[i].isEmpty()) {
                            data.put(keys[i], values[i]);
                        }
                    }
                    csvData.add(new Object[]{data});
                }
            } catch (IOException e) {
                Log.error("Unable to get data from Csv", e);
                throw new RuntimeException("Could not read " + pathName + " file.\n" + e.getStackTrace().toString());
            }
            return csvData.iterator();
        }

        public static String getScreenshot(WebDriver driver, String screenshotName) {
            Long l = Calendar.getInstance().getTimeInMillis();
            String screenshotId = l.toString();
            String Path = System.getProperty("user.dir") + "/Screenshots/";
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String imgPath = Path + screenshotName+screenshotId + ".png";
            File dest = new File(imgPath);
            try {
                FileUtils.copyFile(screenshot, dest);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String ImagePath = "../ScreenShots/" +screenshotName+screenshotId + ".png";
            return ImagePath;
        }

}
