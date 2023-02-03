package POM;

import CommonMethods.WebDriverWaits;
import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class ManageServiceNumber extends BasePage {

    public static By transactionTab = By.xpath("//*[@class=\"icon-money\"]");

   public static void  clickTxnTab(){
       WebDriverWaits.ClickOn(transactionTab);
   }
}
