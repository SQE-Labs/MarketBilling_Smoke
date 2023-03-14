package automation.utilities;

import automation.base.BasePage;
import automation.elements.*;
import automation.helpers.ExtentReportClass;
import automation.logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;


public class ActionEngine extends BasePage {

    public void sendKeys_custom(By path, String valueToBeSent, String... label) {
        String var = "";
        try {
            var = label.length > 0 ? label[0] : path.toString();
            Element element = new Element(var, path);
            element.getWebElement().sendKeys(valueToBeSent);
            extentTest.log(PASS, "Entered value as: " + valueToBeSent);
        } catch (Exception e) {
            extentTest.log(FAIL, "Unable to enter data  for => " + var);
            throw new RuntimeException(e);

        }
    }


    //custom click method to log evey click action in to extent report
    public void clickBtn_custom(By path, String... label) {
        String var = "";
        try {
            var = label.length > 0 ? label[0] : path.toString();
            WebDriverWaits.waitForElementDisabled(By.className("spinner"),8);
            Button btn = new Button(var, path);
            btn.click();
            Log.info("Clicked on " + var);
            //log success message in exgent report
            extentTest.log(PASS, "Clicked Button Successfully! " + var);
        } catch (Exception e) {
            extentTest.log(FAIL, "==> Unable to click on => " + var+" due to exception "+e);
            throw new RuntimeException(e);

        }
    }

    public void click_custom(By path, String... label) {
        String var = "";
        try {

            var = label.length > 0 ? label[0] : path.toString();
            WebDriverWaits.waitForElementDisabled(By.className("spinner"),6);
            Element btn = new Element(var, path);
            btn.click();
            Log.info("Clicked on " + var);
            //log success message in exgent report
            extentTest.log(PASS, "Clicked element Successfully! " + var);
        } catch (Exception e) {
            extentTest.log(FAIL, "==> Unable to click on => " + var+" due to exception "+e);
            throw new RuntimeException(e);
        }

    }

    public void click_custom(WebElement element, String... label) {
        try {
            element.click();
            extentTest.log(PASS, "Clicked element Successfully! " );
        } catch (Exception e) {
            extentTest.log(FAIL, "==> Unable to click  " + label+" due to exception "+e);
            throw new RuntimeException(e);

        }
    }
    public boolean isDisabled(By  path,String... label) {
        String var = "";
        try {

            var = label.length > 0 ? label[0] : path.toString();

            Element ele = new Element(var, path);
            Log.info("Clicked on " + var);
            //log success message in exgent report
            extentTest.log(PASS, "Clicked element Successfully! " + var);
            return ele.isDisabled();

        } catch (Exception e) {
            extentTest.log(FAIL, "==> Unable to click on => " + var+" due to exception "+e);
            throw new RuntimeException(e);
        }
    }

    //check if element is Present
    public boolean isElementPresent_custom(By path, String fieldName) {
        boolean flag = false;
        try {
            Element element = new Element(fieldName, path);
            flag = element.isVisible();
            //Log.debug(fieldName + " element is present -->" + flag);

           // extentTest.log(PASS, "Presence of element "+fieldName + " is: " + flag);
            return flag;
        } catch (Exception e) {
            extentTest.log(FAIL, "****Checking for presence of element : " + fieldName + " not tested due to exception: " + e);
            return flag;
        }
    }


    //Select dropdown value value by visibleText
    public void selectDropDownByVisibleText_custom(By path, String ddVisibleText, String... fieldName) {

        String var = "";
        try {
            var = fieldName.length > 0 ? fieldName[0] : path.toString();
            DropDown dd = new DropDown(var, path);
            dd.selectByVisibleText(ddVisibleText);
           extentTest.log(PASS, var+"==> Dropdown Value Selected by visible text: "+ ddVisibleText);
        } catch (Exception e) {
          extentTest.log(FAIL, "Dropdown value not selected for field: " +var +"  due to exception: "+e);
            throw new RuntimeException(e);

        }
    }

    //Select dropdown value value by value
    public void selectDropDownByValue_custom(By path, String ddValue, String... fieldName) {
        String var = "";
        try {
            var = fieldName.length > 0 ? fieldName[0] : path.toString();
            DropDown dd = new DropDown(var, path);
            dd.selectByValue(ddValue);
            //   ExtentFactory.getInstance().getExtent().log(Status.PASS, var+"==> Dropdown Value Selected by visible text: "+ ddValue);
        } catch (Exception e) {
            //   ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Dropdown value not selected for field: " +var +"  due to exception: "+e);
        }
    }

    //Select dropdown list by index
    public void selectDropDownByIndex_custom(By path, int ddValue, String... fieldName) {
        String var = "";
        try {
            var = fieldName.length > 0 ? fieldName[0] : path.toString();
            DropDown dd = new DropDown(var, path);
            dd.selectByIndex(ddValue);
            //   ExtentFactory.getInstance().getExtent().log(Status.PASS, var+"==> Dropdown Value Selected by visible text: "+ ddValue);
        } catch (Exception e) {
            //  ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Dropdown value not selected for field: " +var +"  due to exception: "+e);
        }
    }

    //Get text from webelement
    public String getText_custom(By path) {
        String text = "";
        try {

            Element element = new Element("", path);
            text = element.getText();
            Log.info("Text for " + path + " is " + text);
             extentTest.log(PASS, "Text retrieved is: "+ text);
            return text;
        } catch (Exception e) {
            extentTest.log(FAIL, "Text not retrieved due to exception: "+ e);

        }
        return text;
    }

    public String getText_custom(WebElement element) {
        String text = "";
        try {

            text = element.getText();
          //  Log.debug("Text for " + element + " is " + text);
            extentTest.log(PASS, "==> Text retrieved is: "+ text);
            return text;
        } catch (Exception e) {
            extentTest.log(FAIL, "==> Text not retried due to exception: "+ e);

        }
        return text;
    }

    public void selectCheckBox(By path, String... fieldName) {
        String var = fieldName.length > 0 ? fieldName[0] : path.toString();
        CheckBox checkBox = new CheckBox(var, path);
        checkBox.check();
    }

    public void uncheckCheckBox(By path, String... fieldName) {
        String var = fieldName.length > 0 ? fieldName[0] : path.toString();
        CheckBox checkBox = new CheckBox(var, path);
        checkBox.uncheck();
    }

    public boolean getCheckBoxValue(By path, String... fieldName) {
        String var = fieldName.length > 0 ? fieldName[0] : path.toString();
        CheckBox checkBox = new CheckBox(var, path);
        return checkBox.isChecked();
    }
    public String getAttributevalue(By path ,String attribute) {
        String value ;
        try {
            Element element = new Element("fieldName", path);
            value = element.getAttributeValue(attribute);
        //    Log.debug( " element attribute value  is present -->" + value);

            extentTest.log(PASS, " Element attribute value is " + value);
            return value;
        } catch (Exception e) {
            extentTest.log(FAIL, "****Checking for presence of element : " + " not tested due to exception: " + e);
            return "";
        }
    }
    public boolean isElementInVisible(By path) {
        boolean flag = false;
        try {
            Element element = new Element("fieldName", path);
            flag = element.isInvisible();
         //   Log.debug( " element is present -->" + flag);

            extentTest.log(PASS, "==> Presence of element " + " is: " + flag);
            return flag;
        } catch (Exception e) {
            extentTest.log(FAIL, "****Checking for presence of element : " + " not tested due to exception: " + e);
            return flag;
        }
    }
    public List<WebElement> getWebElements(By path, String... label) {
        String fieldName = "";
        try {
            fieldName = label.length > 0 ? label[0] : path.toString();

            Elements elem = new Elements(fieldName, path);
            Log.info("Clicked on " + fieldName);

            //log success message in exgent report
          extentTest.log(PASS, fieldName + "==> Clicked Successfully! ");
            return elem.getWebElements();

        } catch (Exception e) {
            //log failure in extent
            extentTest.log(FAIL, "Unable to click on field: " +fieldName +" due to exception: "+e);
            return null;
        }
    }
    public WebElement getWebElement(By path, String... label) {
        String fieldName = "";
        try {
            fieldName = label.length > 0 ? label[0] : path.toString();

            Element elem = new Element(fieldName, path);
            Log.info("Clicked on " + fieldName);
            return elem.getWebElement();

            //log success message in exgent report
        } catch (Exception e) {
            //log failure in extent
            extentTest.log(FAIL, "Unable to find element : " +fieldName +" due to exception: "+e);
            return null;
        }
    }
    public boolean  isExceptionOrErrorPresent() {
        boolean flag = false;
       By exception= By.xpath("//*[contains( text(),'exception')]");
     //   By error= By.xpath("//text()[contains(translate(., 'Error', 'error'), 'error')]");

        try {
            Element exceptionEle = new Element("fieldName", exception);
          //  Element errorEle = new Element("fieldName", error);
            flag= exceptionEle.isVisible() ;
           // Log.debug( " Exception or Error  is present -->" + flag);

            return flag;
        } catch (Exception e) {
            extentTest.log(FAIL, " Exception text Presence" + " : " + flag);
            return flag;
        }
    }
    public boolean isExceptionOrErrorPresent(int exceptionTextCount) {
        boolean flag = false;
        By exception= By.xpath("(//*[contains( text(),'Exception')])["+exceptionTextCount+"]");
        By error= By.xpath("//text()[contains(translate(., 'Error', 'error'), 'error')]");

        try {
            Element exceptionEle = new Element("fieldName", exception);
            Element errorEle = new Element("fieldName", error);
            flag= exceptionEle.isVisible() || errorEle.isVisible();
            // Log.debug( " Exception or Error  is present -->" + flag);

            return flag;
        } catch (Exception e) {
            extentTest.log(FAIL, "Error or Exception Presence" + " : " + flag);
            return flag;
        }
    }
    public void attachScreenShot(String screenshotName) {
        WebDriverWaits.waitForElementDisabled(By.className("spinner"),6);
        try {

            String screenshotPath = ExtentReportClass.getScreenshot(driver, screenshotName);
            extentTest.log(PASS, extentTest.addScreenCapture(screenshotPath));
        } catch (Exception e) {
            extentTest.log(FAIL, "Screenshot Failure "+e);

        }
    }

}
