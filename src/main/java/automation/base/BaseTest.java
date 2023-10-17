package automation.base;


import automation.logger.Log;
import automation.utilities.PropertiesUtil;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

import static java.io.File.separator;
import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;
import static java.util.stream.Collectors.toList;


public class BaseTest {

    public static WebDriver driver;
    public String browser = PropertiesUtil.getPropertyValue("browser");
    public String FinalBrowser = browser.toUpperCase();

    public static WebDriver getDriver() {
        return driver;
    }


    @BeforeClass
    public void SetProp() {
        switch (FinalBrowser) {
            case "CHROME": {
                ChromeOptions chromeOptions = new ChromeOptions();
               // WebDriverManager.chromedriver().setup();
                chromeOptions.addArguments("--remote-allow-origins=*");

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

        }

        driver.manage().window().maximize();
        driver.get(PropertiesUtil.getPropertyValue("baseUrl"));

    }

    @AfterSuite
    public void toClose() {

       //driver.quit();
    }
    @AfterClass
    public void afterClass() {

       // driver.close();
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
}
