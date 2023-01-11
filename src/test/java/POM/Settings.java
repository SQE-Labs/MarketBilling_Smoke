package POM;

import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class Settings extends TestLogin {
    public static SoftAssert softAssert = new SoftAssert();

    public static By primary_front_id = By.id("primary_front_id");
    public static By primary_back_id = By.id("primary_back_id");
    public static By secondary_front_id = By.id("secondary_front_id");
    public static By secondary_back_id = By.id("secondary_back_id");

    public static By saveChangesBtn = By.id("saveChangesBtn");
    public static By alertSuccess = By.cssSelector(".alert.alert-success");

    // public static By save = By.className("btn btn-primary");
    public static By saveSettings = By.xpath("//button[text()=' Save settings']");
    public  static  void selectPrimaryInvoiceTemplate(String invoiceName) {
        WebDriverWaits.scrollIntoView(primary_front_id);
        WebDriverWaits.selectByVisibleText(primary_front_id,invoiceName);
        WebDriverWaits.selectByVisibleText(primary_back_id,invoiceName);

    }
    public  static  void selectSecondaryInvoiceTemplate(String invoiceName) {
        WebDriverWaits.scrollIntoView(primary_front_id);
        WebDriverWaits.selectByVisibleText(secondary_front_id,invoiceName);
        WebDriverWaits.selectByVisibleText(secondary_back_id,invoiceName);

    }
    public static void invoiceSettings_Customer(String invoiceName) {

        selectPrimaryInvoiceTemplate(invoiceName);
        selectSecondaryInvoiceTemplate(invoiceName);
    }
    public static void clickSave() {
WebDriverWaits.ClickOn(saveSettings);
    }
}
