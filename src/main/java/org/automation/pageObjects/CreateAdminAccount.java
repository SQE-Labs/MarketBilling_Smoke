package org.automation.pageObjects;


import org.automation.utilities.ActionEngine;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;


public class CreateAdminAccount extends ActionEngine {

    By adminTab = By.xpath("(//*[@class='icon-lock'])[2]");
    By users = By.xpath("(//*[@class='quick-button-small'])[6]");
    By createNewUser = By.xpath("(//*[@class='btn btn-primary'])[2]");
    By group = By.xpath("//*[@class='filter-option pull-left']");
    By group2 = By.xpath("//*[@id='content']/div[2]/div[2]/div[3]/div/div[2]/form/div[1]/div/div/div/ul/li/a");
    By username = By.id("uid");
    By Password = By.id("predigpass");
    By saveUser = By.xpath("(//*[@class='btn btn-primary'])[2]");


    public void clickAdmin() {
        clickBtn_custom(adminTab);
        WebdriverWaits.waitForElementVisible(users, 3);
    }

    public void clickUsers() {
        clickBtn_custom(users);
        WebdriverWaits.waitForElementVisible(createNewUser, 2);
    }

    public void clickCreateNewUser() {
        clickBtn_custom(createNewUser);
        //	WebdriverWaits.waitForElementVisible(Users, 2);
    }

    public void selectGroup(String groupText) {
        clickBtn_custom(group);
        WebdriverWaits.waitForElementVisible(group, 3);
        clickBtn_custom(group2);
    }

    public void enterUsername(String userNameText) {
        sendKeys_withClear(username, userNameText);
    }

    public void enterPassword(String userNameText) {
        sendKeys_withClear(Password, userNameText);
    }

    public void clickSaveUser() {
        clickBtn_custom(saveUser);
    }

}
