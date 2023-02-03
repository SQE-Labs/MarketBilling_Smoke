package org.automation.pageObjects.admin.userManager;

import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class UserDetails extends ActionEngine {


    By adminTab = By.xpath("(//*[@class='icon-lock'])[2]");
    By usersDetailsBtn = By.xpath("//p[contains(text(),'User Details')]");
    By firstNameField = By.id("firstName");
    By lastNameField = By.id("lastName");
    By saveBtn = By.xpath("//*[@id='btnDetailsSave']");
    By okBtn = By.xpath("//*[@class='btn btn-primary']");

    public void clickAdmin() {
        clickBtn_custom(adminTab);
    }

    public void clickUsersDetails() {
        clickBtn_custom(usersDetailsBtn);

    }

    public void enterFirstName(String userNameText) {
        WebdriverWaits.waitForElementVisible(firstNameField, 10);
        sendKeys_withClear(firstNameField, userNameText);
    }

    public void enterLastName(String userNameText) {
        sendKeys_withClear(lastNameField, userNameText);
    }

    public void clickSaveBtn() {
        clickBtn_custom(saveBtn, "SaveBtn");
    }

    public void clickOkBtn() {
        clickBtn_custom(okBtn, "OkBtn Popup");
    }
}
