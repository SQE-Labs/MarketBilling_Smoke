package automation.pageObjects;

import automation.utilities.ActionEngine;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static automation.utilities.WebDriverWaits.SwitchToNewTab;
import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;

public class BillRun extends ActionEngine {

    public By billRunSearch = By.xpath("(//*[@class='btn btn-primary'])[4]");
    public By statementDetails = By.xpath("(//i[@class='icon-th-large'])[1]");
    public By statementCheckbox = By.xpath("//input[@id='chkDelete_0']");
    public By downloadPDF = By.xpath("(//button[@class='btn btn-large dropdown-toggle btn-primary'])[1]");
    public By selectCustomer = By.id("downloadSelected");
    public By selectInvoiceTemplate = By.id("downloadGroupSettigs");
    public By invoiceGroupTemplateSelection = By.xpath("//div[@class='btn-group bootstrap-select show-tick']");
    public By invoiceGroupTemplateSelectionDropdown = By.xpath("(//small[@class='muted text-muted'])[1]");
    public By download = By.id("submitSelected");
    public By statementNumber = By.xpath("(//tbody/tr[1]//td[1])[1]");
    public By customerNumber = By.xpath("//tbody/tr[1]//td[2]");
    public By SelectCustomerZip = By.xpath("//*[@id='downloadIndividual']");
    public By invoiceTemplateCustomer = By.id("forCustomerSettings");
    public By viewDetails = By.xpath("(//a[@class='btn btn-primary'])[1]");

    public void clickDownloadPDF() {
        click_custom(downloadPDF);
    }

    public void clickInvoiceTemplate() {
        click_custom(invoiceTemplateCustomer);
    }


    public void clickBillRunSearch() throws InterruptedException {
        Thread.sleep(2000);
        click_custom(billRunSearch);
    }

    public void clickStatementDetails() {
        click_custom(statementDetails);
    }

    public void select_StatementCheckbox() throws InterruptedException {
        Thread.sleep(2000);
       // selectCheckBox(statementCheckbox);
        SwitchToNewTab();
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

    public void clickOnViewDetails() {
        click_custom(viewDetails);
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
        //  clickBillRunSearch();
         String statement = getStatementNumber();
        clickStatementDetails();
        //  getcustomerNumber();
        select_StatementCheckbox();
        Thread.sleep(2000);
        clickDownloadPDF();
        click_SelectCustomer();
        Thread.sleep(2000);
        // //By default Selecting invoice templete for customer settings.
        //  selectInvoiceTemplate();
        //  clickInvoiceTemplate();
        // invoiceGroupTemplateSelection();
        //  invoiceGroupTemplateSelectionDD();
        clickDownload();
        Thread.sleep(6000);

        return statement;
    }

    public String downloadZip() throws InterruptedException {
         //clickBillRunSearch();
        //  String statement = getStatementNumber();
          clickStatementDetails();
        //  getcustomerNumber();
        Thread.sleep(2000);
       // clickOnViewDetails();
        select_StatementCheckbox();
        clickDownloadPDF();
        selectCustomerZip();
        Thread.sleep(2000);
        //By default Selecting invoice templete for customer settings.
        //  invoiceGroupTemplateSelection();
        //  invoiceGroupTemplateSelectionDD();
        clickDownload();
        Thread.sleep(10000);
        //  return statement;

        return null;
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
