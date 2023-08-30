package automation.pageObjects;

import automation.utilities.ActionEngine;
import org.openqa.selenium.By;

public class CustomerSearchPage extends ActionEngine {

    public By header = By.xpath("//div/h2");
    public By header2 = By.xpath("(//div/h2)[2]");

    public String getHeaderText(){
           return  getText_custom(header);

    }
    public String getHeader2Text(){
        return  getText_custom(header2);

    }
}
