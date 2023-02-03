package org.automation.pageObjects.admin.groupManager;

import org.automation.utilities.ActionEngine;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class LocaleSetting extends ActionEngine {

    By adminTab = By.xpath("(//*[@class='icon-lock'])[2]");
    By localeSubTab = By.xpath("(//*[@class='fa fa-globe'])[1]");
    By currencySymbol = By.xpath(("//*[@name='currency']"));
    By decimalPoints = By.xpath(("//*[@name='precision']"));
    By thousandsSeparator = By.xpath(("//*[@name='thousand_separator']"));
    By decimalSymbol = By.xpath(("//*[@name='decimal_symbol']"));
    By dateFormat = By.xpath(("//*[@name='date_format']"));
    By timeFormat = By.xpath(("//*[@name='time_format']"));
    By saveChanges = By.xpath("//*[@class='btn btn-large btn-primary']");
    By SuccessMsg = By.xpath("//*[@id=\"notification\"]/center");

    String SUCCESS_MESG = "Successfully saved changes.";


    public void clickAdmin() {
        clickBtn_custom(adminTab);
        //	WebdriverWaits.waitForElementVisible(editGroup, 2);
    }

    public void clickLocalesetting() {
        clickBtn_custom(localeSubTab);
    }

    public void selectCurrencySymbol(String currencySymbolText) {
//		WebdriverWaits.waitForElementVisible(currencySymbol, 1);
        selectDropDownByVisibleText_custom(currencySymbol, currencySymbolText, "Type of Currency");
    }

    public void selectDecimalPoints(String decimalPointsText) {
        WebdriverWaits.waitForElementVisible(decimalPoints, 1);
        selectDropDownByVisibleText_custom(decimalPoints, decimalPointsText, "Type of decimal points");
    }

    public void selectThousandsSeparator(String thousandsSeparatorText) {
        WebdriverWaits.waitForElementVisible(thousandsSeparator, 1);
        selectDropDownByVisibleText_custom(thousandsSeparator, thousandsSeparatorText, "Types of thousandsSeparator");
    }

    public void selectDecimalSymbol(String decimalSymbolText) {
        WebdriverWaits.waitForElementVisible(decimalPoints, 1);
        selectDropDownByVisibleText_custom(decimalPoints, decimalSymbolText, "Type of decimal symbol");
    }

    public void selectDateFormat(String dateFormatText) {
        WebdriverWaits.waitForElementVisible(dateFormat, 1);
        selectDropDownByVisibleText_custom(dateFormat, dateFormatText, "Select Date Format");
    }

    public void selectTimeFormat(String timeFormatText) {
        WebdriverWaits.waitForElementVisible(timeFormat, 1);
        selectDropDownByVisibleText_custom(timeFormat, timeFormatText, "Select time Format");
    }

    public void enterDecimalSymbol(String userNameText) {
        sendKeys_withClear(decimalSymbol, userNameText);
    }

    public void clickSaveChanges() {
        clickBtn_custom(saveChanges);

    }

    public void assertSuccessMessage() {
        WebdriverWaits.sleep(2);
        Assertions ass = new Assertions();
        ass.assertStrings(SUCCESS_MESG, getText_custom(SuccessMsg));

    }
}
