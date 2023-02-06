package org.automation.pageObjects;

import org.automation.utilities.ActionEngine;
import org.automation.utilities.PropertiesUtil;
import org.openqa.selenium.By;

public class Login extends ActionEngine {

    public By UsernameField = By.xpath("//input[@name='j_username']");
    public By PasswordField = By.xpath("//input[@name='predigpass']");
    public By LoginButton = By.xpath("//button[@value='Log In']");
    public By copyright = By.className("copyright-text");
    By userNameField = By.xpath("//input[@name='j_username']");
    By login = By.xpath("//*[@name='submit']");

    public void enterUsername(String userNameText) {
        sendKeys_custom(userNameField, userNameText);
    }

    public void enterPassword(String passNameText) {
        sendKeys_custom(PasswordField, passNameText);
    }

    public void clickLoginBtn() {
        clickBtn_custom(login);
    }

    public IndexPage validLogin() {
        sendKeys_custom(UsernameField, PropertiesUtil.getPropertyValue("userName"));
        sendKeys_custom(PasswordField, PropertiesUtil.getPropertyValue("password"));
        clickBtn_custom(LoginButton);
        return new IndexPage();
    }

    public String getBuildVersionText() {
        return getText_custom(copyright);
    }
}
