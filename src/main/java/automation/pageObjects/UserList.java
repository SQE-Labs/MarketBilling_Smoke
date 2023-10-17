package automation.pageObjects;

import automation.utilities.ActionEngine;
import automation.utilities.PropertiesUtil;
import automation.utilities.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class UserList extends ActionEngine {

    public By userList = By.xpath("(//a[@class='quick-button-small'])[6]");
    //public By headerList = By.xpath("//*[@id=\"DataTables_Table_0\"]//thead//th[not(contains(text(),'Username'))] [not(contains(text(),'Status'))]");
    public By headerList = By.xpath("//*[@id=\"DataTables_Table_0\"]/thead/tr/th");

    public void navigateToUserList() {
        click_custom(userList);

    }

    public void verify_UserListHeader() throws InterruptedException {
    }

    public String getHeadersList() {
        List<WebElement> list = getWebElements(headerList, "Headers");
       // List<String> list1 = getWebElement( "List Header");
        for (WebElement headerEle : list) {
            getText_custom(headerEle);
        }
        return getHeadersList();
    }
    }
