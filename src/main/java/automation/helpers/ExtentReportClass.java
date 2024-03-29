package automation.helpers;

import automation.base.BaseTest;
import automation.logger.Log;
import automation.utilities.PropertiesUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Calendar;

public class ExtentReportClass extends BaseTest {

    public static ExtentReports extent;
    public static ExtentTest extentTest;

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        Long l = Calendar.getInstance().getTimeInMillis();
        String screenshotId = screenshotName;
        String Path = System.getProperty("user.dir") + "/test-report/screenshots/";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String imgPath = Path + screenshotId + ".png";
        File dest = new File(imgPath);
        try {
            FileUtils.copyFile(screenshot, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imgPath;
    }

    @BeforeSuite
    public void setExtent() throws InterruptedException, IOException {
        String filePath = System.getProperty("user.dir") + "/test-report/ExtentReportResult.html";
        extent = new ExtentReports(filePath, true);
        extent.addSystemInfo("URL: ", PropertiesUtil.getPropertyValue("baseUrl"));
        extent.addSystemInfo("Environment", "QA");
        extent.assignProject(PropertiesUtil.getPropertyValue("baseUrl"));
        extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
           }


    @AfterSuite
    public void endReport() throws IOException {
        extent.flush();
        extent.close();

    }


    @BeforeMethod
    public void beforeMethod(Method method) {
        Test test = method.getAnnotation(Test.class);
        extentTest = extent.startTest(method.getName());

        extentTest.setDescription(test.description() + "<b> <i> <u><br />" + "URL : " + getDriver().getCurrentUrl() + "</u></i></b>");

        Log.info("******** Execution started for " + method.getName() + " ********");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            // extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName());
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED : " + result.getThrowable());
            Log.info("Test execution " + result.getMethod().getMethodName() + " failed...");

            String screenshotPath = ExtentReportClass.getScreenshot(driver, result.getName());
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
            Log.info("Test " + result.getMethod().getMethodName() + " skipped...");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            String screenshotPath = ExtentReportClass.getScreenshot(driver, result.getName());
            extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath));
            extentTest.log(LogStatus.PASS, "*** Test Case PASSED ***");
            Log.info("Executed " + result.getMethod().getMethodName() + " test successfully...");
        }
        extent.endTest(extentTest);
        extent.flush();
    }
}
