package automation.pageObjects;

import automation.utilities.ActionEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserList extends ActionEngine {

    public By userList = By.xpath("(//a[@class='quick-button-small'])[6]");
    public By headerList = By.xpath("//*[@id=\"DataTables_Table_0\"]//thead//th");

    public void navigateToUserList() {
        click_custom(userList);

    }




        public Set<String> getHeaderstext () {
            List<WebElement> list = getWebElements(headerList, "Headers");
            Set <String > textheaderSet= new HashSet();
            for (WebElement headerEle : list) {
                String headerText=getText_custom(headerEle);
                textheaderSet.add(headerText);
            }
           return textheaderSet;
        }

    }


