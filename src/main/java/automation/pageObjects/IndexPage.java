package automation.pageObjects;

import automation.utilities.ActionEngine;
import org.openqa.selenium.By;

public class IndexPage extends ActionEngine {
    public By footerVersion = By.cssSelector(".footerLinks div:nth-child(2)");
    public By searchIcon = By.xpath("//*[@class=\"glyphicon glyphicon-search\"]");
    public By dropDown = By.xpath("//button[@class='btn btn-default dropdown-toggle']");

    public By customer = By.xpath("//a[text()='Customer']");
    public By customerAddress = By.xpath("//a[text()='Customer Address']");
    public By marketService = By.xpath("//a[text()='Market Service ID']");
    public By serviceAddress = By.xpath("//a[text()='Service Address']");
    public By meterNumber = By.xpath("//a[text()='Market Service ID']");
    public By all = By.xpath("#");
    public By searchInput=By.xpath("//div[@class='input-group search-panel-holder']//input[@id='search_input']");

    public String getTextVersion() {
        return getText_custom(footerVersion);
    }

    public void searchAllCustomer() {
        click_custom(dropDown);
        click_custom(customer);

        click_custom(searchIcon);

    }
    public void searchAll() {
        click_custom(searchIcon);
    }
    public void searchAll(String searchText) {
        sendKeys_custom(searchInput,searchText);
        click_custom(searchIcon);
    }

    public SrvCustSearchResults searchAllMeterNumber() {
        click_custom(dropDown);
        click_custom(meterNumber);
        click_custom(searchIcon);
        return new  SrvCustSearchResults();
    }
    public void searchAllServiceAddress() {
        click_custom(dropDown);
        click_custom(serviceAddress);
        click_custom(searchIcon);
    }
    public void searchAllCustomerAddress() {
        click_custom(dropDown);
        click_custom(customerAddress);
        click_custom(searchIcon);
    }
    public void searchAllServiceId() {
        click_custom(dropDown);
        click_custom(marketService);
        click_custom(searchIcon);
    }
}
