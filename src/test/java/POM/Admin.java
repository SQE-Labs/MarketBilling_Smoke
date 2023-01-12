package POM;

import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import org.openqa.selenium.By;

public class Admin  extends TestLogin {
    public static By MeterNumbersIcon = By.xpath("//p[text()='Meter Numbers']");
    public static By AdminIcon = By.xpath("//a[@title='Administration']/i");
    public static By btnbrowseFile = By.id("btnbrowseFile");
    public static By attDesc = By.id("attDesc");

    public static By invoiceSetupBtn = By.xpath("//p[text()='Invoice Set-up']");
    public static By groupEditBtn = By.xpath("//p[text()='Edit Group']");
    public static By billRun = By.xpath("//span[text()='Bill Run']");
    public static By plans = By.xpath("//span[text()='Plans']");

    public static void navigateToInvoiceSetup(){
        WebDriverWaits.ClickOn(AdminIcon);
        WebDriverWaits.ClickOn(invoiceSetupBtn);

    }
    public static void navigateToGroupEdit(){
        WebDriverWaits.ClickOn(AdminIcon);
        WebDriverWaits.ClickOn(groupEditBtn);

    }
    public static void navigateToBillRun(){
        WebDriverWaits.ClickOn(AdminIcon);
        WebDriverWaits.ClickOn(billRun);

    }
    public static void navigateToPlans(){
        WebDriverWaits.ClickOn(AdminIcon);
        WebDriverWaits.ClickOn(plans);

    }
}
