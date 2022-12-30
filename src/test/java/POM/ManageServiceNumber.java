package POM;

import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import org.openqa.selenium.By;

public class ManageServiceNumber extends TestLogin {

    public static By transactionTab = By.xpath("//*[@class=\"icon-money\"]");

   public static void  clickTxnTab(){
       WebDriverWaits.ClickOn(transactionTab);
   }
}
