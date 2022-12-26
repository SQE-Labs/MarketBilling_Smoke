package TestCases;

import POM.Flow6_7AddingServiceAndMeter;
import org.testng.annotations.Test;

public class TestAddService extends TestLogin {

	@Test(priority = 1)
	public static void Service() throws InterruptedException {
		extentTest = extent.startTest(" First Service ");
		extentTest.setDescription(" Verify that User is able to add Service. ");
		Flow6_7AddingServiceAndMeter.X_AddService.Service_MeterR();
	}
	
//	@Test(priority = 2)
//	public static void EditService() throws InterruptedException {
//		extentTest = extent.startTest(" Edit First Service ");
//		extentTest.setDescription(" Verify that User is able to add Service. ");
//		Flow6_7AddingServiceAndMeter.X_AddService.EditService();
//	}
//	
//	@Test(priority = 3)
//	public static void AddMeter_MeterRegisterR() throws InterruptedException {
//		extentTest = extent.startTest(" AddMeter&MeterRegisterR ");
//		extentTest.setDescription(" Verify that User is able to add Service. ");
//		Flow6_7AddingServiceAndMeter.X_AddService.AddMeter_MeterRegisterR();
//	}
	
	@Test(priority = 2)
	public static void SecondService() throws InterruptedException {
		extentTest = extent.startTest(" AddSecondService ");
		extentTest.setDescription(" Verify that User is able to add SecondService. ");
		Flow6_7AddingServiceAndMeter.X_AddService.Service_MeterB();
	}
	
//	@Test(priority = 5)
//	public static void EditSecondService() throws InterruptedException {
//		extentTest = extent.startTest(" EditSecondService ");
//		extentTest.setDescription(" Verify that User is able to add SecondService. ");
//		Flow6_7AddingServiceAndMeter.X_AddService.EditSecondService();
//	}
	
//	@Test(priority = 6)
//	public static void BAddMeter_MeterRegister() throws InterruptedException {
//		extentTest = extent.startTest(" AddMeter&MeterRegisterB ");
//		extentTest.setDescription(" Verify that User is able to add SecondService. ");
//		Flow6_7AddingServiceAndMeter.X_AddService.BAddMeter_MeterRegister();
//	}
//	
	
	@Test(priority = 3)
	public static void AddThirdService() throws InterruptedException {
		extentTest = extent.startTest(" AddThirdService ");
		extentTest.setDescription(" Verify that User is able to add ThirdService ");
		Flow6_7AddingServiceAndMeter.X_AddService.Service_MeterC();
	}
	
//	@Test(priority = 7)
//	public static void EditThirdService() throws InterruptedException {
//		extentTest = extent.startTest(" EditThirdService ");
//		extentTest.setDescription(" Verify that User is able to add ThirdService ");
//		Flow6_7AddingServiceAndMeter.X_AddService.EditThirdService();
//	}
//	
//	@Test(priority = 7)
//	public static void AddMeter_MeterRegisterC() throws InterruptedException {
//		extentTest = extent.startTest(" AddMeter&MeterRegisterC ");
//		extentTest.setDescription(" Verify that User is able to add ThirdService ");
//		Flow6_7AddingServiceAndMeter.X_AddService.AddMeter_MeterRegisterC();
//	}
	
}
 