package automation.pageObjects;

import automation.utilities.ActionEngine;
import automation.utilities.WebDriverWaits;
import org.openqa.selenium.By;

import java.time.Duration;

public class Reports extends ActionEngine {


    public By reportIcon = By.xpath("//i[@class='icon-file-text-alt']");
    public By financialIcon = By.xpath("//i[@class='fa fa-line-chart reportButtonFontSize']");
    public By ediReportType2 = By.xpath("//*[@id='utbListDiv']/table/tbody/tr[10]/td[1]/a");
    public By statement = By.id("stmt_no");
    public By displayBtn = By.xpath("//a[@class='btn btn-primary']");
    public By downloadBtn = By.xpath("//button[@class='btn btn-success']");
    public By okBtn = By.xpath("(//button[@class='btn btn-default'])[2]");
    public By notificationIcon = By.xpath("//i[@class='icon-bell-alt']");
    public By latestReport_Download = By.xpath("//li[@class='dropdown-item'][1]");


    public void click_DisplayBtn() {
        click_custom(displayBtn);
    }

    public void navigateToReports() {
        WebDriverWaits.sleep(5000);
        click_custom(reportIcon);
    }

    public void click_FinancalIcon() {
        click_custom(financialIcon);
    }

    public void click_EdiReportType_2() {
        scrollIntoView(ediReportType2);
        click_custom(ediReportType2);
    }

    public void goTo_EdiReport_Type_2() {
        click_FinancalIcon();
        click_EdiReportType_2();
    }

    public void select_Latest_StatementNumber() {
        selectDropDownByIndex_custom(statement, 1);
       ;

    }

    public void downloadReport() throws InterruptedException {
        click_DisplayBtn();
        click_custom(downloadBtn);
        click_custom(okBtn);
        WebDriverWaits.sleep(10000);
        refreshPage();


    }
    public void goToNotification() throws InterruptedException {

        click_custom(notificationIcon);
        WebDriverWaits.sleep(10000);
        click_custom(latestReport_Download);
        WebDriverWaits.sleep(15000);

    }
}
