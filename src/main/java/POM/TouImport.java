package POM;

import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static BrowsersBase.BrowsersInvoked.driver;


public  class TouImport {
    public static String RandomName1;
    public static JavascriptExecutor jse = (JavascriptExecutor) driver;
    public static Select select;
    public static By AdminIcon = By.xpath("//a[@title='Administration']/i");
    public static By TOUDefinitionsIcon = By.xpath("//p[text()='TOU Definitions']");
    public static By BrowseFileIcon = By.xpath("//button[@id='btnbrowseFile']");
    public static By DescriptionField = By.xpath("//input[@id='attDesc']");
    public static By UploadFileButton = By.xpath("//span[text()='Upload File']");
    public static By ImportDataIcon = By.xpath("//a[@title='Import data']");
    public static By OKBtnConfirmationPopup = By.xpath("//div[@class='bootstrap-dialog-footer-buttons']/button[1]");
    public static By ImportSuccessMessage = By.xpath("//div[@class='alert alert-success']/strong");


    public static void TOUImportFile() throws InterruptedException {
        WebDriverWaits.ClickOn(AdminIcon);
        Thread.sleep(2000);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(TOUDefinitionsIcon);
        Thread.sleep(2000);
        WebElement BrowseFile = driver.findElement(By.xpath("//input[@id='attFile']"));
        BrowseFile.sendKeys(System.getProperty("user.dir") + "/TestData/TOU Definition Import Template.csv");
        Thread.sleep(2000);
        WebDriverWaits.SendKeys(DescriptionField, "TOU Definition");
        WebDriverWaits.ClickOn(UploadFileButton);
        jse.executeScript("window.scrollBy(0,400)", "");
        WebDriverWaits.ClickOn(ImportDataIcon);
        WebDriverWaits.ClickOn(OKBtnConfirmationPopup);
        jse.executeScript("window.scrollBy(0,300)", "");
        String SuccessMsg = WebDriverWaits.GetText(ImportSuccessMessage);
        //Assert.assertEquals(SuccessMsg, "Import Successful!");
    }
}
