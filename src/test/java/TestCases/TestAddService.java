package TestCases;

import POM.AddSitePlans;
import POM.Flow6_7AddingServiceAndMeter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestAddService extends TestLogin {

	@AfterMethod
	public  void pageRefresh()
	{
		driver.navigate().refresh();
	}
	@Test(priority = 1)
	public  void Service() throws InterruptedException {
		extentTest = extent.startTest(" First Service ");
		extentTest.setDescription(" Verify that User is able to add Service. ");
		Flow6_7AddingServiceAndMeter.X_AddService.M_AddService();
	}
	
	@Test(priority = 2)
	public  void EditService() throws InterruptedException {
		extentTest = extent.startTest(" Edit First Service ");
		extentTest.setDescription(" Verify that User is able to edit Service. ");
		Flow6_7AddingServiceAndMeter.X_AddService.EditService();
	}

	@Test(priority = 3)
	public  void AddMeter_MeterRegisterR() throws InterruptedException {
		extentTest = extent.startTest(" AddMeter&MeterRegisterR for first service ");
		extentTest.setDescription(" Verify that User is able to add Service. ");
		Flow6_7AddingServiceAndMeter.Metering.AddMeter();
	}
	
	@Test(priority = 4)
	public  void SecondService() throws InterruptedException {
		extentTest = extent.startTest(" AddSecondService ");
		extentTest.setDescription(" Verify that User is able to add SecondService. ");
		Flow6_7AddingServiceAndMeter.X_AddService.AddSecondService();
	}
	
	@Test(priority = 5)
	public  void EditSecondService() throws InterruptedException {
		extentTest = extent.startTest(" EditSecondService ");
		extentTest.setDescription(" Verify that User is able to edit SecondService. ");
		Flow6_7AddingServiceAndMeter.X_AddService.EditSecondService();
	}
	
	@Test(priority = 6)
	public  void BAddMeter_MeterRegister() throws InterruptedException {
		extentTest = extent.startTest(" AddMeter&MeterRegisterB  for second ");
		extentTest.setDescription(" Verify that User is able to add meter for SecondService. ");
		Flow6_7AddingServiceAndMeter.Metering.AddMeter();

	}

	
	@Test(priority = 7)
	public  void AddThirdService() throws InterruptedException {
		extentTest = extent.startTest(" AddThirdService ");
		extentTest.setDescription(" Verify that User is able to add ThirdService ");
		Flow6_7AddingServiceAndMeter.X_AddService.AddThirdService();
	}

	@Test(priority = 8)
	public  void EditThirdService() throws InterruptedException {
		extentTest = extent.startTest(" EditThirdService ");
		extentTest.setDescription(" Verify that User is able to Edit ThirdService ");
		Flow6_7AddingServiceAndMeter.X_AddService.EditThirdService();
	}

	@Test(priority = 9,enabled = true)
	public  void AddMeter_MeterRegisterC() throws InterruptedException {
		extentTest = extent.startTest(" AddMeter&MeterRegisterC for third customer ");
		extentTest.setDescription(" Verify that User is able to add  meter for ThirdService ");
		Flow6_7AddingServiceAndMeter.Metering.AddMeter();
	}
	@Test(priority = 10)
	public  void addSitePlans() throws InterruptedException {
		extentTest = extent.startTest(" AddMeter&MeterRegisterC for third customer ");
		extentTest.setDescription(" Verify that User is able to add  meter for ThirdService ");
		AddSitePlans.addSitePlan();

	}
	@Test(priority = 11)
	public  void addSiteParameters() throws InterruptedException {
		extentTest = extent.startTest(" AddMeter&MeterRegisterC for third customer ");
		extentTest.setDescription(" Verify that User is able to add  meter for ThirdService ");
		AddSitePlans.addSiteParameters();

	}

}
 