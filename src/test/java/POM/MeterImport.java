package POM;

import CommonMethods.BaseTest;
import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class MeterImport extends BaseTest {
    public static By MeterNumbersIcon = By.xpath("//p[text()='Meter Numbers']");
    public static By MeterRegisterIcon = By.xpath("//p[text()='Meter Registers']");
    public static By meterReadings = By.xpath("//p[text()='Meter Readings']");
    public static By AdminIcon = By.xpath("//a[@title='Administration']/i");
    public static By browseFile = By.xpath("//input[@id='attFile']");
    public static By attDesc = By.id("attDesc");
    public static By upload = By.xpath("//*[contains(text(),'Upload File')]");
    public static By executelink = By.xpath("//i[@class='fa fa-play ']");
    public static By alertOk = By.xpath("//button[contains(text(),'OK')]");
    public static By textMsg = By.xpath("//*[contains(text(),'Import Successful!')]");

    public static void meterNumberImport(String path) throws InterruptedException, IOException {
        LandingPage.navigateToHomePage();
        WebDriverWaits.ClickOn(AdminIcon);
        WebDriverWaits.scrollIntoView(MeterNumbersIcon);
        WebDriverWaits.ClickOn(MeterNumbersIcon);
        importFile(path);
    }
    public static void meterRegisterImport(String path) throws InterruptedException, IOException {
        LandingPage.navigateToHomePage();
        WebDriverWaits.ClickOn(AdminIcon);
        WebDriverWaits.scrollIntoView(MeterRegisterIcon);
        WebDriverWaits.ClickOn(MeterRegisterIcon);
        importFile(path);

    }
    public static void meterReadsImport(String path) throws InterruptedException, IOException {
        LandingPage.navigateToHomePage();
        WebDriverWaits.ClickOn(AdminIcon);
        WebDriverWaits.scrollIntoView(meterReadings);
        WebDriverWaits.ClickOn(meterReadings);
        importFile(path);
    }
    public static void importFile(String path) throws InterruptedException, IOException {
        WebElement BrowseFile = driver.findElement(By.xpath("//input[@id='attFile']"));
        BrowseFile.sendKeys(path);
        Thread.sleep(2000);
        WebDriverWaits.SendKeys(attDesc, "Meter Number");
        WebDriverWaits.ClickOn(upload);
        Thread.sleep(2000);
        WebDriverWaits.scrollIntoView(executelink);
        WebDriverWaits.ClickOn(executelink);
        Thread.sleep(5000);
        WebDriverWaits.ClickOn(alertOk);
        Thread.sleep(5000);
        String Actualtext = WebDriverWaits.GetText(textMsg);
        Assert.assertEquals(Actualtext, "Import Successful!");
    }
    }
