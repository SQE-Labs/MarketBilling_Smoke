package automation.pageObjects;


import automation.utilities.ActionEngine;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class GroupEdit  extends ActionEngine {
    public  SoftAssert softAssert = new SoftAssert();

    public By primary_front_id = By.id("primary_front_id");
    public  By primary_back_id = By.id("primary_back_id");
    public  By secondary_front_id = By.id("secondary_front_id");
    public  By secondary_back_id = By.id("secondary_back_id");

    public  By saveChangesBtn = By.id("saveChangesBtn");
    public  By alertSuccess = By.cssSelector(".alert.alert-success");
     public By groupname=By.name("groupname");
    // public  By save = By.className("btn btn-primary");
    public  By save = By.xpath("//button[text()='Save']");

    public    void selectPrimaryInvoiceTemplate(String invoiceName) {
        scrollIntoView(primary_front_id);
        selectDropDownByVisibleText_custom(primary_front_id,invoiceName);
        selectDropDownByVisibleText_custom(primary_back_id,invoiceName);

    }
    public    void selectSecondaryInvoiceTemplate(String invoiceName) {
        scrollIntoView(primary_front_id);
        selectDropDownByVisibleText_custom(secondary_front_id,invoiceName);
        selectDropDownByVisibleText_custom(secondary_back_id,invoiceName);

    }
    public    void clickSave() {
        scrollIntoView(saveChangesBtn);
        click_custom(saveChangesBtn);
        click_custom(save);

    }
    public    void validateSuccessTxt() {
        scrollIntoView(alertSuccess);
        String actual =getText_custom(alertSuccess);

        softAssert.assertEquals(actual,"Success! Changes have been updated successfully.\n");


    }
    public    String getGroupNameText() {
        String groupName =getAttributevalue(groupname,"value");

return  groupName;

    }
}
