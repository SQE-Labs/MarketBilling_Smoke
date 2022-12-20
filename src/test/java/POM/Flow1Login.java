package POM;

import org.openqa.selenium.By;
import BrowsersBase.DataInterface;
import CommonMethods.WebDriverWaits;

public class Flow1Login {

	public static By UsernameField = By.xpath("//input[@name='j_username']");
	public static By PasswordField = By.xpath("//input[@name='predigpass']");
	public static By LoginButton = By.xpath("//button[@value='Log In']");

	public static void ValidLogin() {
		WebDriverWaits.SendKeys(UsernameField, DataInterface.Username);
		WebDriverWaits.SendKeys(PasswordField, DataInterface.Password);
		WebDriverWaits.ClickOn(LoginButton);
	}
}
