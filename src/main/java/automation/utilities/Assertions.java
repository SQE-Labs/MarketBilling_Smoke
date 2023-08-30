package automation.utilities;

import automation.logger.Log;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class Assertions {


    public void assertStrings(String actual, String expected) {
        SoftAssert softAssert = new SoftAssert();
        Log.debug("Actual data is " + actual + "  and expected Data is " + expected);
        softAssert.assertEquals(actual, expected);

    }

    public void assertTrue(boolean value) {
        Assertion softAssert = new SoftAssert();
        softAssert.assertTrue(value, "Assert boolean failed");

    }


}
