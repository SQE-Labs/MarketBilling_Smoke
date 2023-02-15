import com.beust.jcommander.internal.Lists;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import java.util.List;

public class MainClass {

        public static void main(String[] args) {
            TestListenerAdapter tla = new TestListenerAdapter();
            TestNG testng = new TestNG();
            List<String> suites = Lists.newArrayList();
            suites.add(System.getProperty("user.dir")+"/testng.xml");//path to xml..
            testng.setTestSuites(suites);
            testng.run();
        }

    }
