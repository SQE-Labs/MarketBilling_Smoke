package POM;

import TestCases.TestLogin;
import org.openqa.selenium.By;

public class Admin  extends TestLogin {
    public static By MeterNumbersIcon = By.xpath("//p[text()='Meter Numbers']");
    public static By AdminIcon = By.xpath("//a[@title='Administration']/i");
    public static By btnbrowseFile = By.id("btnbrowseFile");
    public static By attDesc = By.id("attDesc");

}
