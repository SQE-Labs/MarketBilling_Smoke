package org.automation.utilities;

import org.automation.logger.Log;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class Assertions {


    public void assertStrings(String actual, String expected) {
        SoftAssert softAssert = new SoftAssert();
        Log.info("Actual data is " + actual + "  and expected Data is " + expected);
        softAssert.assertEquals(actual, expected);
//
    }

    public void assertTrue(boolean value) {
        Assertion softAssert = new SoftAssert();
        softAssert.assertTrue(value, "Assert boolean failed");

    }

    //String Asserts
    public void assertEqualsString_custom(String expvalue, String actualValue, String locatorName) throws Throwable {
        try {
            if (actualValue.equals(expvalue)) {
                //ExtentFactory.getInstance().getExtent().log(Status.PASS, "String Assertion is successful on field " + locatorName + " Expected value was: " + expvalue + " actual value is: " + actualValue);
            } else {
                //ExtentFactory.getInstance().getExtent().log(Status.FAIL, "String Assertion FAILED on field " + locatorName + " Expected value was: " + expvalue + " actual value is: " + actualValue);
                Assert.fail();
            }
        } catch (Exception e) {
            Assert.fail(e.toString());
        }
    }
}
