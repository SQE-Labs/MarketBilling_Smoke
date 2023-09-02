package automation.pageObjects;

import automation.utilities.ActionEngine;
import automation.utilities.PropertiesUtil;
import automation.utilities.WebDriverWaits;
import org.openqa.selenium.By;
import java.io.File;

public class Admin  extends ActionEngine {
    public  By MeterNumbersIcon = By.xpath("//p[text()='Meter Numbers']");
    public  By AdminIcon = By.xpath("//a[@title='Administration']/i");
    public  By btnbrowseFile = By.id("btnbrowseFile");
    public  By attDesc = By.id("attDesc");

    public  By invoiceSetupBtn = By.xpath("//p[text()='Invoice Set-up']");
    public  By groupEditBtn = By.xpath("//p[text()='Edit Group']");
    public  By billRun = By.xpath("//span[text()='Bill Run']");
    public  By plans = By.xpath("//span[text()='Plans']");
    public  By processDataFrom = By.id("dateFrom");
    public  By billRunStatus = By.id("billrunStatus");
    public  By commit = By.xpath("//option[text()='Committed']");
    public  By reload = By.xpath("//a[@class='btn btn-primary reloadButton']");
    public  By billRunSearchBtn = By.xpath("//i[@class='icon-search']");

    public  void navigateToInvoiceSetup(){
        click_custom(AdminIcon);
        click_custom(invoiceSetupBtn);
    }

    public  GroupEdit navigateToGroupEdit(){
        click_custom(AdminIcon);
        click_custom(groupEditBtn);
        return  new GroupEdit();
    }
    public  void navigateToBillRun() throws InterruptedException {
        click_custom(AdminIcon);
        click_custom(billRun);
        if(PropertiesUtil.getPropertyValue("billRun").contains("old")){
          //  if(isElementPresent_custom(billRunSearchBtn,"BillRunSearch")){ //&&
            click_custom(billRunSearchBtn);
        }
        else
        {
            Thread.sleep(4000);
            click_custom(billRunStatus);
            selectDropDownByVisibleText_custom(billRunStatus,"Committed");
            clear_custum(processDataFrom);
            click_custom(reload);
            Thread.sleep(2000);
        }

    }
    public  void navigateToBasePage(){
        getDriver().get(PropertiesUtil.getPropertyValue("baseUrl"));

    }
    public  void navigateToPlans(){
        click_custom(AdminIcon);
        click_custom(plans);
        click_custom(plans);

    }

}
