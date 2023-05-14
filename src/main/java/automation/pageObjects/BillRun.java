package automation.pageObjects;

import automation.utilities.ActionEngine;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

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
    public By statementNumber = By.xpath("(//tbody/tr[1]//td[1])[1]");
    public By customerNumber = By.xpath("//tbody/tr[1]//td[2]");
    public By SelectCustomerZip = By.xpath("//*[@id='downloadIndividual']");

    public void clickDownloadPDF() {
        click_custom(downloadPDF);
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


    public void downloadPdf() throws InterruptedException {
        clickBillRunSearch();
        getStatementNumber();
        clickStatementDetails();
        getcustomerNumber();
        select_StatementCheckbox();
        clickDownloadPDF();
        click_SelectCustomer();
        Thread.sleep(2000);
        selectInvoiceTemplate();
        invoiceGroupTemplateSelection();
        invoiceGroupTemplateSelectionDD();
        clickDownload();
    }

    public void downloadZip() throws InterruptedException {
        clickBillRunSearch();
        getStatementNumber();
        clickStatementDetails();
        getcustomerNumber();
        select_StatementCheckbox();
        clickDownloadPDF();
        selectCustomerZip();
        Thread.sleep(2000);
        selectInvoiceTemplate();
        invoiceGroupTemplateSelection();
        invoiceGroupTemplateSelectionDD();
        clickDownload();


    }

    public static boolean isFileDownloaded(String fileName) {
        String home = System.getProperty("user.home");
        String file_name = fileName;
        String file_with_location = home + "\\Downloads\\" + file_name;
        File file = new File(file_with_location.trim());

//        (File tempFile : downloadPath.listFiles()) {
//            if (tempFile.getName().contains(fileName)) {
//                String tempEx = FilenameUtils.getExtension(tempFile.getName());
//                // crdownload - For Chrome, part - For Firefox
//                if (tempEx.equalsIgnoreCase("crdownload") || tempEx.equalsIgnoreCase("part")) {
//                    Thread.sleep(1000);
//                } else {
//                    isFileFound = true;
//                    logger.info("Download To Completed....");
//                    return tempFile;
//                }
//            }
//        }
//            if (file.exists()) {
//                System.out.println(file_with_location + " is present");
//
//                return true;
//            } else {
//                System.out.println(file_with_location + " is not present");
//
//                return false;
//            }
        if (file.exists()) {
            System.out.println(file_with_location + " is present");

            return true;
        } else {
            System.out.println(file_with_location + " is not present");

            return false;
        }
    }

    public static void unSevenZipFile() {
        // Get 7zip file.
        try (SevenZFile sevenZFile = new SevenZFile(new File("C:/Users/Itsqe/Documents/Statement_8597_1683880948900.7z"))) {

            Iterable<SevenZArchiveEntry> iterable = sevenZFile.getEntries();
            for (SevenZArchiveEntry entry : iterable) {

                File file = new File("C:/Users/Itsqe/Documents/" + entry.getName());
                System.out.println("Un seven zipping - " + file);
                // Create directory before streaming files.
                String dir = file.toPath().toString().substring(0, file.toPath().toString().lastIndexOf("\\"));
                Files.createDirectories(new File(dir).toPath());
                // Stream file content
                byte[] content = new byte[(int) entry.getSize()];
                // sevenZFile.read(content);
                //   Files.write(file.toPath(), content);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decompress(String in, File destination) throws IOException {
        SevenZFile sevenZFile = new SevenZFile(new File(in));


        File curfile = new File(destination, "");
        File parent = curfile.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(curfile);
//         //   byte[] content = new byte[(int) sevenZFile.getSize()];
//            sevenZFile.read(content, 0, content.length);
//            out.write(content);
//            out.close();
    }

    public static String getContent(final String directory, final String fileName, final String subFileName) throws IOException {
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


