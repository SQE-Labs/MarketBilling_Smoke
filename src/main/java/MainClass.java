import com.beust.jcommander.internal.Lists;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import java.util.List;

public class MainClass {
        //public static void main(String[] args) {
//            InvocationRequest request = new DefaultInvocationRequest();
//            request.setPomFile( new File( "pom.xml" ));
//            request.setGoals( Collections.singletonList( "install" ));
//            Invoker invoker = new DefaultInvoker();
//            System.out.println(System.getenv("PATH"));
//            invoker.setMavenHome(new File("/Users/caelius_consulting/Downloads/apache-maven-3.8.6"));
//            try {
//                invoker.execute( request );
//            } catch (MavenInvocationException e) {
//                e.printStackTrace();
//            }
        public static void main(String[] args) {
            TestListenerAdapter tla = new TestListenerAdapter();
            TestNG testng = new TestNG();
            List<String> suites = Lists.newArrayList();
            suites.add(System.getProperty("user.dir")+"/testng.xml");//path to xml..
            testng.setTestSuites(suites);
            testng.run();
        }

    }
