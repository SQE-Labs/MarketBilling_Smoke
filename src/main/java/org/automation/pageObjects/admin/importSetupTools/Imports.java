package org.automation.pageObjects.admin.importSetupTools;

import org.automation.utilities.ActionEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Imports extends ActionEngine {
    public  By MeterNumbersIcon = By.xpath("//p[text()='Meter Numbers']");
    public  By MeterRegisterIcon = By.xpath("//p[text()='Meter Registers']");
    public  By meterReadings = By.xpath("//p[text()='Meter Readings']");
    public  By AdminIcon = By.xpath("//a[@title='Administration']/i");
    public  By browseFile = By.xpath("//input[@id='attFile']");
    public  By attDesc = By.id("attDesc");
    public  By upload = By.xpath("//*[contains(text(),'Upload File')]");
    public  By executelink = By.xpath("//i[@class='fa fa-play ']");
    public  By alertOk = By.xpath("//button[contains(text(),'OK')]");
    public  By textMsg = By.xpath("//*[contains(text(),'Import Successful!')]");

    public  void meterNumberImport(String path) throws InterruptedException, IOException {
       // AdminPage.navigateToHomePage();
        clickBtn_custom(AdminIcon);


        scrollIntoView(MeterNumbersIcon);
        clickBtn_custom(MeterNumbersIcon);
        importFile(path);
    }
    public  void meterRegisterImport(String path) throws InterruptedException, IOException {
     //   LandingPage.navigateToHomePage();
        clickBtn_custom(AdminIcon);
        scrollIntoView(MeterRegisterIcon);
        clickBtn_custom(MeterRegisterIcon);
        importFile(path);

    }
    public  void meterReadsImport(String path) throws InterruptedException, IOException {
     //   LandingPage.navigateToHomePage();
        clickBtn_custom(AdminIcon);
        scrollIntoView(meterReadings);
        clickBtn_custom(meterReadings);
        importFile(path);
    }
    public  void importFile(String path) throws InterruptedException, IOException {
        WebElement BrowseFile = getDriver().findElement(By.xpath("//input[@id='attFile']"));
        BrowseFile.sendKeys(path);
        Thread.sleep(2000);
        sendKeys_custom(attDesc, "Meter Number");
        clickBtn_custom(upload);
        Thread.sleep(2000);
        scrollIntoView(executelink);
        clickBtn_custom(executelink);
        Thread.sleep(5000);
        clickBtn_custom(alertOk);
        Thread.sleep(5000);
        //Assert.assertEquals(Actualtext, "Import Successful!");
    }
    }
