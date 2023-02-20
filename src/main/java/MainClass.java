import com.beust.jcommander.internal.Lists;
import org.testng.TestNG;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {


    public static void getDuplicates() {


        String str = "Great responsibility";
        char[] ch = str.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : ch) {

            if (map.keySet().contains(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }

        }
        for (Map.Entry entry : map.entrySet()) {

            if( !(entry.getValue().toString().equalsIgnoreCase("1")))
            System.out.println("Duplicate Char " + entry.getKey() + entry.getValue());
        }
    }
        public static void main (String[] args){
            TestNG testng = new TestNG();
            List<String> suites = Lists.newArrayList();
            suites.add(System.getProperty("user.dir")+"/testng.xml");//path to xml..
            testng.setTestSuites(suites);
            testng.run();
        }

    }
