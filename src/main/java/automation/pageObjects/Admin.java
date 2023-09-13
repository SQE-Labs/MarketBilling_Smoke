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
