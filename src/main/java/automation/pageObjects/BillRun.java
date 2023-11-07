package automation.pageObjects;

import automation.utilities.ActionEngine;
import automation.utilities.PropertiesUtil;
import automation.utilities.WebDriverWaits;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;

public class BillRun extends ActionEngine {

    public By billRunSearch = By.xpath("(//*[@class='btn btn-primary'])[1]");
    public By statementDetails = By.xpath("(//i[@class='icon-th-large'])[1]");
    public By statementCheckbox = By.id("chkDelete_0");
    public By downloadPDF = By.xpath("(//button[@class='btn btn-large dropdown-toggle btn-primary'])[1]");
    public By selectCustomer = By.id("downloadSelected");
    public By selectInvoiceTemplate = By.id("downloadGroupSettigs");
    public By invoiceGroupTemplateSelection = By.xpath("//div[@class='btn-group bootstrap-select show-tick']");
    public By invoiceGroupTemplateSelectionDropdown = By.xpath("(//small[@class='muted text-muted'])[1]");
    public By download = By.id("submitSelected");
    public By downloadInBackgroundButton=By.xpath("//button[text()='Download in Background']");
    public By statementNumber = By.xpath("(//tbody/tr[1]//td[1])[1]");
    public By customerNumber = By.xpath("//tbody/tr[1]//td[2]");
    public By SelectCustomerZip = By.xpath("//*[@id='downloadIndividual']");
    public By invoiceTemplateCustomer = By.id("forCustomerSettings");
    public By CustomerCheckbox = By.xpath("//input[@id='chkDelete_0']");
    public By processDataFrom = By.id("dateFrom");
    public By billRunStatus = By.id("billrunStatus");
    public By commit = By.xpath("//option[text()='Committed']");
    public By reload = By.xpath("//span[contains(text(),'Reload')]");
    public By billRunSearchBtn = By.xpath("//i[@class='icon-search']");
    public By noResultFound = By.xpath("//tbody/tr/td[@class='dataTables_empty']");
    public By billRunDate = By.id("dateFrom");
    public By adminIcon=By.xpath("//span[text()='Admin']");

    public By jobHistoryIcon=By.xpath("//p[text()='Job History']");
    public By downloadIcon=By.xpath("(//a[@class='btn btn-primary fileDownload'])[1]");
    public By DownloadIcon=By.xpath("//a[@class='btn btn-success']");
    public void clickDownloadPDF() {
        click_custom(downloadPDF);
    }
    public void downloadInBackground() throws InterruptedException {
        click_custom(adminIcon);
        click_custom(jobHistoryIcon);
        Thread.sleep(5000);
        WebDriverWaits.waitForElementVisible(downloadIcon, Duration.ofSeconds(15));
        click_custom(downloadIcon);
    }
    public void clickOnDownloadIcon(){
       click_custom(DownloadIcon);
    }

    public void CustomerCheckbox() throws InterruptedException {
        switchToWindow(browser);
        selectCheckBox(CustomerCheckbox);
        Thread.sleep(2000);

    }
    public void billRunFilter() throws InterruptedException {
        if (PropertiesUtil.getPropertyValue("billRun").contains("old")) {
            click_custom(billRunSearchBtn);

        } else {
            if (!(PropertiesUtil.getPropertyValue("billrunfilterDate").isEmpty())) {
                Thread.sleep(4000);
                click_custom(billRunDate);
                sendKeys_withClear(billRunDate, PropertiesUtil.getPropertyValue("billrunfilterDate"));
            }
            Thread.sleep(4000);
            selectDropDownByVisibleText_custom(billRunStatus, "Committed");
            Thread.sleep(1000);

            click_custom(reload);

            if (isElementPresent_custom(noResultFound, "No Result Found")) {
                Thread.sleep(1000);
                selectDropDownByVisibleText_custom(billRunStatus, "Statement Generated");
                click_custom(reload);
                Thread.sleep(2000);
            } else {
                click_custom(billRunStatus);
                selectDropDownByVisibleText_custom(billRunStatus, "Statement Generated");
                click_custom(reload);
                Thread.sleep(2000);
            }
          }
        }

    public void clickInvoiceTemplate() {
        click_custom(invoiceTemplateCustomer);
    }


    public void clickBillRunSearch() {
        click_custom(billRunSearch);
    }

    public void clickStatementDetails() {
        click_custom(statementDetails);
    }

    public void select_StatementCheckbox() {
        click_custom(statementCheckbox);

    }

    public void click_SelectCustomer() throws InterruptedException {
        click_custom(selectCustomer);
        Thread.sleep(2000);
    }

    public void selectInvoiceTemplate() throws InterruptedException {
        click_custom(selectInvoiceTemplate);
        Thread.sleep(2000);
    }

    public void clickDownload() {
        click_custom(download);
    }

    public void invoiceGroupTemplateSelection() throws InterruptedException {
        click_custom(invoiceGroupTemplateSelection);
    }


    public void invoiceGroupTemplateSelectionDD() throws InterruptedException {
        selectDropDownByIndex_custom(invoiceGroupTemplateSelectionDropdown, 2);
    }

    public String getcustomerNumber() {
        String custNumber = getText_custom(customerNumber);
        System.out.println(custNumber);
        return custNumber;
    }

    public String getStatementNumber() {

        String stateNumber = getText_custom(statementNumber);
        System.out.println(stateNumber);
        return stateNumber;
    }

    public void selectCustomerZip() {
        click_custom(SelectCustomerZip);
    }


    public String downloadPdf() throws InterruptedException {
        //clickBillRunSearch();
        Thread.sleep(1000);
        String statement = getStatementNumber();
        clickStatementDetails();
        String customerNumber = getcustomerNumber();
        if (PropertiesUtil.getPropertyValue("billRun").contains("old")) {
            select_StatementCheckbox();
        } else {
            CustomerCheckbox();
        }
          clickDownloadPDF();
          click_SelectCustomer();
        if (isElementPresent_custom(downloadInBackgroundButton,"downloadBackgroundButton is present")){
            clickDownload();
            Thread.sleep(6000);
            downloadInBackground();
            Thread.sleep(15000);
        }
        else{
            clickDownload();
        }
            //  clickDownloadPDF();
    //    click_SelectCustomer();
     //   Thread.sleep(2000);
        // //By default Selecting invoice templete for customer settings.
        //  selectInvoiceTemplate();
        //  clickInvoiceTemplate();
        // invoiceGroupTemplateSelection();
        //  invoiceGroupTemplateSelectionDD();
      // clickDownload();
        Thread.sleep(6000);
      //  clickOnDownloadIcon();
        return statement;
    }

    public String downloadZip() throws InterruptedException {
        //clickBillRunSearch();

        String statement = getStatementNumber();
        clickStatementDetails();
        String customerNumber = getcustomerNumber();
        if (PropertiesUtil.getPropertyValue("billRun").contains("old")) {
            select_StatementCheckbox();
        } else {
            switchToWindow(browser);
            select_StatementCheckbox();
        }
        //By default Selecting invoice templete for customer settings.
        //  invoiceGroupTemplateSelection();
        //  invoiceGroupTemplateSelectionDD();
        clickDownloadPDF();
        selectCustomerZip();
        Thread.sleep(2000);

        if (isElementPresent_custom( downloadInBackgroundButton,"downloadBackgroundButton is present")){
            clickDownload();
            Thread.sleep(6000);
            downloadInBackground();
            Thread.sleep(15000);
        }
        else{
            clickDownload();
        }
//        clickDownload();
//        Thread.sleep(10000);
//        downloadInBackground();
//        Thread.sleep(15000);
        return statement;
    }

    public boolean isFileDownloaded(String fileName) throws InterruptedException {
        Thread.sleep(10000);
        String home = System.getProperty("user.home");
        String file_with_location = home + "/Downloads/" + fileName;
        File file = new File(file_with_location.trim());
        String fileTest = file.getName();
        if (file.exists() && file.length() != 0) {
            System.out.println(file_with_location + " is present with size greater than 0 ");
            extentTest.log(PASS, file_with_location + " is present  with size greater than 0");
            return true;
        } else {
            System.out.println(file_with_location + " is not present");
            extentTest.log(FAIL, file_with_location + " is not  present ");

            return false;
        }
    }

    public String unzip(String directory, String fileName) {
        final StringBuilder sb = new StringBuilder();
        final File fDirectory = new File(directory);
        final File input7z = new File(fDirectory, fileName);
        try (final SevenZFile sevenZFile = new SevenZFile(input7z)) {
            SevenZArchiveEntry entry = sevenZFile.getNextEntry();
            while (entry != null) {
                try (final FileOutputStream out = new FileOutputStream(new File(fDirectory, entry.getName()))) {
                    byte[] content = new byte[(int) entry.getSize()];
                    sevenZFile.read(content, 0, content.length);
                    out.write(content);
                } catch (final IOException ioe) {
                    final String error = "Error when writing entry " + entry.getName();
                    sb.append(error).append("\n");
                }
                entry = sevenZFile.getNextEntry();
            }
        } catch (final IOException ioe) {
            final String error = "Error when reading entry " + fileName;
            sb.append(error).append("\n");
        }
        return sb.length() == 0 ? null : sb.toString();
    }

    public String validateDownloadedFile() {
        driver.navigate().to("chrome://downloads/");
        ChromeDownloads download = new ChromeDownloads();
        //Thread.sleep(6000);

        String downloadedFile = download.getFileName();
        System.out.println(downloadedFile);
        return downloadedFile;
    }





    public String getContent(final String directory, final String fileName, final String subFileName) throws IOException {
        String out = null;
        final File fDirectory = new File(directory);
        final File input7z = new File(fDirectory, fileName);
        try (final SevenZFile sevenZFile = new SevenZFile(input7z)) {
            SevenZArchiveEntry entry = sevenZFile.getNextEntry();
            while (entry != null) {
                if (subFileName.equals(entry.getName())) {
                    byte[] content = new byte[(int) entry.getSize()];
                    sevenZFile.read(content, 0, content.length);
                    out = new String(content);
                }
                entry = sevenZFile.getNextEntry();
            }
        } catch (final IOException ioe) {
            final String error = "Error when reading entry " + fileName;
            throw ioe;
        }
        return out;
    }
}
