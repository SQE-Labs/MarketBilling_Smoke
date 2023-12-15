package automation.utilities;
/**
 * @author: Prakash Narkhede
 * @Youtube: https://www.youtube.com/automationtalks
 * @LinkedIn: https://www.linkedin.com/in/panarkhede89/
 */

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {


    static Properties prop = new Properties();

    public static String getPropertyValue(String key) {
        String value="";
        //1. load data from properties file
        String propFilePath = System.getProperty("user.dir") + "/src/main/config/config1.properties";
        FileInputStream fis;
        try {
            fis = new FileInputStream(propFilePath);
            prop.load(fis);

        //2. read data
         value = prop.get(key).toString();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return value;
    }
}
