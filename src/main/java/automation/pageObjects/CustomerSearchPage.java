package automation.pageObjects;

import automation.utilities.ActionEngine;
import org.openqa.selenium.By;

public class CustomerSearchPage extends ActionEngine {

    public By header = By.xpath("//div/h2");

    public String getHeaderText(){
           return  getText_custom(header);

    }

}
