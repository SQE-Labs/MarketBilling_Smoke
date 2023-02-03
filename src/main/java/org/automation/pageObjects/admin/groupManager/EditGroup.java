package org.automation.pageObjects.admin.groupManager;

import org.automation.utilities.ActionEngine;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class EditGroup extends ActionEngine {

    By adminTab = By.xpath("(//*[@class='icon-lock'])[2]");
    By editGroup = By.xpath("(//*[@class='icon-group'])[1]");
    By companyName = By.xpath("//*[@name='name']");

    By ownerName_1 = By.xpath("//*[@name='owner1Name']");
    By ownerName_2 = By.xpath("//*[@name='owner2Name']");
    By financeName = By.xpath("//*[@name='financeName']");
    By contactName = By.xpath("//*[@name='operationName']");
    By salesName = By.xpath("//*[@name='salesName']");
    By collectionsName = By.xpath("//*[@name ='collectionName']");

    By ownerEmail_1 = By.xpath("//*[@name='owner1Email']");
    By ownerEmail_2 = By.xpath("//*[@name='owner2Email']");
    By financeEmail = By.xpath("//*[@name='financeEmail']");
    By contactEmail = By.xpath("//*[@name='operationEmail']");
    By salesEmail = By.xpath("//*[@name='salesEmail']");
    By collectionsEmail = By.xpath("//*[@name ='collectionEmail']");

    By owner1Phone1 = By.xpath("//*[@name='owner1Phone1']");
    By owner2Phone1 = By.xpath("//*[@name='owner1Phone2']");
    By financePhone1 = By.xpath("//*[@name='financePhone1']");
    By contactPhone1 = By.xpath("//*[@name='operationPhone1']");
    By salesPhone1 = By.xpath("//*[@name='salesPhone1']");
    By collectionsPhone1 = By.xpath("//*[@name ='collectionPhone1']");

    By owner1Phone2 = By.xpath("//*[@name='owner1Phone2']");
    By owner2Phone2 = By.xpath("//*[@name='owner2Phone2']");
    By financePhone2 = By.xpath("//*[@name='financePhone2']");
    By contactPhone2 = By.xpath("//*[@name='operationPhone2']");
    By salesPhone2 = By.xpath("//*[@name='salesPhone2']");
    By collectionsPhone2 = By.xpath("//*[@name ='collectionPhone2']");

    By owner1Fax = By.xpath(("//*[@name='owner1Fax']"));
    By owner2Fax = By.xpath(("//*[@name='owner2Fax']"));
    By operationFax = By.xpath(("//*[@name='operationFax']"));
    By financeFax = By.xpath(("//*[@name='financeFax']"));
    By salesFax = By.xpath(("//*[@name='salesFax']"));
    By collectionsFax = By.xpath(("//*[@name='collectionFax']"));

    By bankName = By.xpath(("//*[@name='bankName']"));
    By accountName = By.xpath(("//*[@name='bankAccount']"));
    By accountNumber = By.xpath(("//*[@name='bankAccountNumber']"));
    By creditCardHolder = By.xpath(("//*[@name='creditcardHolder']"));
    By creditCardType = By.xpath(("//*[@name='typeOfCreditcard']"));
    By creditCardNumber = By.xpath(("//*[@name='creditCardNumber']"));
    By creditCardExpiry = By.xpath(("//*[@name='dateExpired']"));

    By postAddress = By.xpath(("//*[@name='postAddress']"));
    By postSub = By.xpath(("//*[@name='postSub']"));
    By postState = By.xpath(("//*[@name='postState']"));
    By postCode = By.xpath(("//*[@name='postCode']"));
    By billingAddress = By.xpath(("//*[@name='billingAddress']"));
    By billingSub = By.xpath(("//*[@name='billingSub']"));
    By billingState = By.xpath(("//*[@id='hState']|.//*[@name='billingState']"));
    By billingCode = By.xpath(("//*[@name='billingCode']"));

    By primaryFrontInvoice = By.id("primary_front_id");
    By primaryBackInvoice = By.id("primary_back_id");
    By secondaryFrontInvoice = By.id("secondary_front_id");
    By secondaryBackInvoice = By.id("secondary_back_id");

    By enableAllocationOptions = By.xpath("(//*[@class='switch-handle'])[13]");
    By enableCustomerAttachments = By.xpath("(//*[@class='switch-handle'])[18]");

    By tiabNotes = By.xpath(("//*[@name='tiabNotes']"));
    By franchiseeNotes = By.xpath(("//*[@name='franchiseeNotes']"));
    By saveChanges = By.xpath(("//*[text()=' Save changes']"));
    By okButton = By.xpath("//*[@class='btn btn-primary']");
    By successMessage = By.xpath("//*[@class='alert alert-success']");

    String SUCCESS_MESG = "Success! Changes have been updated successfully.";


    public void clickAdmin() {
        clickBtn_custom(adminTab);
        WebdriverWaits.waitForElementVisible(editGroup, 2);
    }

    public void clickEditGroup() {
        clickBtn_custom(editGroup);
    }

    public void enterCompanyName(String userNameText) {
        sendKeys_withClear(companyName, userNameText);
    }

    public void entergroupOwner_1(String userNameText) {
        sendKeys_withClear(ownerName_1, userNameText);
    }

    public void entergroupOwner_2(String userNameText) {
        sendKeys_withClear(ownerName_2, userNameText);
    }

    public void enterOperationContact(String userNameText) {
        sendKeys_withClear(contactName, userNameText);
    }

    public void enterFinanceName(String userNameText) {
        sendKeys_withClear(financeName, userNameText);
    }

    public void enterSalesName(String userNameText) {
        sendKeys_withClear(salesName, userNameText);
    }

    public void enterCollectionName(String userNameText) {
        sendKeys_withClear(collectionsName, userNameText);
    }

    public void enterOwnerEmail_1(String userNameText) {
        sendKeys_withClear(ownerEmail_1, userNameText);
    }

    public void enterOwnerEmail_2(String userNameText) {
        sendKeys_withClear(ownerEmail_2, userNameText);
    }

    public void enterFinanceEmail(String userNameText) {
        sendKeys_withClear(financeEmail, userNameText);
    }

    public void enterContactEmail(String userNameText) {
        sendKeys_withClear(contactEmail, userNameText);
    }

    public void enterSalesEmail(String userNameText) {
        sendKeys_withClear(salesEmail, userNameText);
    }

    public void enterCollectionsEmail(String userNameText) {
        sendKeys_withClear(collectionsEmail, userNameText);
    }

    public void enterOwner1Phone1(String userNameText) {
        sendKeys_withClear(owner1Phone1, userNameText);
    }

    public void enterOwner2Phone1(String userNameText) {
        sendKeys_withClear(owner1Phone1, userNameText);
    }

    public void enterFinancePhone1(String userNameText) {
        sendKeys_withClear(financePhone1, userNameText);
    }

    public void enterContactPhone1(String userNameText) {
        sendKeys_withClear(contactPhone1, userNameText);
    }

    public void enterSalesPhone1(String userNameText) {
        sendKeys_withClear(salesPhone1, userNameText);
    }

    public void enterCollectionsPhone1(String userNameText) {
        sendKeys_withClear(collectionsPhone1, userNameText);
    }

    public void enterOwner1Phone2(String userNameText) {
        sendKeys_withClear(owner1Phone2, userNameText);
    }

    public void enterOwner2Phone2(String userNameText) {
        sendKeys_withClear(owner1Phone2, userNameText);
    }

    public void enterFinancePhone2(String userNameText) {
        sendKeys_withClear(financePhone2, userNameText);
    }

    public void enterContactPhone2(String userNameText) {
        sendKeys_withClear(contactPhone2, userNameText);
    }

    public void enterSalesPhone2(String userNameText) {
        sendKeys_withClear(salesPhone2, userNameText);
    }

    public void enterCollectionsPhone2(String userNameText) {
        sendKeys_withClear(collectionsPhone2, userNameText);
    }


    public void enterOwner1Fax(String userNameText) {
        sendKeys_withClear(owner1Fax, userNameText);
    }

    public void enterOwner2Fax(String userNameText) {
        sendKeys_withClear(owner2Fax, userNameText);
    }

    public void enterFinanceFax(String userNameText) {
        sendKeys_withClear(financeFax, userNameText);
    }

    public void enterContactFax(String userNameText) {
        sendKeys_withClear(operationFax, userNameText);
    }

    public void enterSalesFax(String userNameText) {
        sendKeys_withClear(salesFax, userNameText);
    }

    public void enterCollectionsFax(String userNameText) {
        sendKeys_withClear(collectionsFax, userNameText);
    }


    public void enterBankName(String userNameText) {
        sendKeys_withClear(bankName, userNameText);
    }

    public void enterAccountName(String userNameText) {
        sendKeys_withClear(accountName, userNameText);
    }

    public void enterAccountNumber(String userNameText) {
        sendKeys_withClear(accountNumber, userNameText);
    }

    public void enterCreditCardHolder(String userNameText) {
        sendKeys_withClear(creditCardHolder, userNameText);
    }

    public void selectDropDownByVisibleText_custom(String creditCardText) {
        WebdriverWaits.waitForElementVisible(creditCardType, 1);
        selectDropDownByVisibleText_custom(creditCardType, creditCardText, "Type of Credit card");
    }

    public void enterCreditCardNumber(String userNameText) {
        sendKeys_withClear(creditCardNumber, userNameText);
    }

    public void enterCreditCardExpiry(String userNameText) {
        sendKeys_withClear(creditCardExpiry, userNameText);
    }

    public void enterPostAddress(String userNameText) {
        sendKeys_withClear(postAddress, userNameText);
    }

    public void enterPostSub(String userNameText) {
        sendKeys_withClear(postSub, userNameText);
    }

    public void enterPostState(String userNameText) {
        sendKeys_withClear(postState, userNameText);
    }

    public void enterPostCode(String userNameText) {
        sendKeys_withClear(postCode, userNameText);
    }

    public void enterBillingAddress(String userNameText) {
        sendKeys_withClear(billingAddress, userNameText);
    }

    public void enterBillingSub(String userNameText) {
        sendKeys_withClear(billingSub, userNameText);
    }

    public void enterBillingState(String userNameText) {
        sendKeys_withClear(billingState, userNameText);
    }

    public void enterBillingCode(String userNameText) {
        sendKeys_withClear(billingCode, userNameText);
    }

    public void selectPrimaryFrontInvoice(String PFrontInvoice) {
        WebdriverWaits.waitForElementVisible(primaryFrontInvoice, 1);
        selectDropDownByVisibleText_custom(primaryFrontInvoice, PFrontInvoice, "selectPrimaryFrontInvoice");
    }

    public void selectPrimaryBackInvoice(String PBackInvoice) {
        WebdriverWaits.waitForElementVisible(primaryBackInvoice, 1);
        selectDropDownByVisibleText_custom(primaryBackInvoice, PBackInvoice, "selectPrimaryBackInvoice");
    }

    public void selectSecondaryFrontInvoice(String SFrontInvoice) {
        WebdriverWaits.waitForElementVisible(primaryFrontInvoice, 1);
        selectDropDownByVisibleText_custom(secondaryFrontInvoice, SFrontInvoice, "selectPrimaryFrontInvoice");
    }

    public void selectSecondaryBackInvoice(String SBackInvoice) {
        WebdriverWaits.waitForElementVisible(primaryFrontInvoice, 1);
        selectDropDownByVisibleText_custom(secondaryBackInvoice, SBackInvoice, "selectPrimaryBackInvoice");
        scrollIntoView(enableAllocationOptions);
        scrollIntoView(tiabNotes);
    }

    public void enableAllocationBucketOption() {
        WebdriverWaits.waitForElementVisible(enableAllocationOptions, 1);

        clickBtn_custom(enableAllocationOptions);
        scrollIntoView(enableCustomerAttachments);
    }

    public void enableAttachmentsCustomer() {
        WebdriverWaits.waitForElementVisible(enableCustomerAttachments, 1);
        clickBtn_custom(enableCustomerAttachments);
        scrollIntoView(tiabNotes);
    }

    public void enterTiabNotes(String userNameText) {
        sendKeys_withClear(tiabNotes, userNameText);
    }

    public void enterFranchiseeNotes(String userNameText) {
        sendKeys_withClear(franchiseeNotes, userNameText);
        scrollIntoView(saveChanges);
    }

    public void clickSaveChanges() {
        clickBtn_custom(saveChanges);

    }

    public void clickOkButton() {
        clickBtn_custom(okButton);
    }

    public void assertSuccessMessage() {
        WebdriverWaits.sleep(2);
        Assertions ass = new Assertions();
        ass.assertStrings(SUCCESS_MESG, getText_custom(successMessage));

    }
}
