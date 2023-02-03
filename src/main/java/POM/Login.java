package POM;

import BrowsersBase.DataInterface;
import org.automation.pageObjects.IndexPage;
import org.automation.utilities.ActionEngine;
import org.openqa.selenium.By;

public class Login extends ActionEngine {

	public  By UsernameField = By.xpath("//input[@name='j_username']");
	public  By PasswordField = By.xpath("//input[@name='predigpass']");
	public  By LoginButton = By.xpath("//button[@value='Log In']");
	public  By copyright = By.className("copyright-text");

	public  IndexPage validLogin() {
		sendKeys_custom(UsernameField, DataInterface.Username);
		sendKeys_custom(PasswordField, DataInterface.Password);
		clickBtn_custom(LoginButton);
		return new IndexPage();
	}
	public String getBuildVersionText(){
		  return getText_custom(copyright);
	}
}
