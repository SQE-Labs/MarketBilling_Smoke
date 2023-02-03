package org.automation.pageObjects.outbox;

import org.automation.utilities.ActionEngine;
import org.openqa.selenium.By;

public class OutBoxPage extends ActionEngine {
    private By generateRemindersBtn = By.id("generate");
    private By downloadBtn = By.xpath("//button[contains(text(),'Download')][@class='btn btn-large dropdown-toggle btn-primary']");
    private By sendBtn = By.id("sendToCustomMail");
    private By searchBox = By.xpath("//input[@type='search']");
    private By viewVoiceBtn = By.xpath("//a[@title='View Invoice']");
    private By deleteRemBtn = By.xpath("//a[@title='Delete Reminder']");

    public void clickGenerateReminderBtn(){
        clickBtn_custom(generateRemindersBtn ,"Generate Reminders");

    }
    public void clickViewVoiceBtn(){
        clickBtn_custom(viewVoiceBtn ,"View Voice");

    }
    public void enter_in_SearchBox(String searchText){
        sendKeys_custom( searchBox,searchText,"Search");

    }

}
