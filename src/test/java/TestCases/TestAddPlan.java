package TestCases;

import CommonMethods.BaseTest;
import POM.Plans;
import POM.TouImport;
import org.testng.annotations.Test;

public class TestAddPlan extends BaseTest {
    String planId;

    @Test(priority = 0,enabled = false)
    public  void TouImport() throws InterruptedException {
        extentTest = extent.startTest(" TouImport ");
        extentTest.setDescription(" Verify that User is able to do TouImport");
        TouImport.TOUImportFile();

    }

    @Test(priority = 1,enabled = false)
    public  void AddPlanwithoutTOUDefinition() throws InterruptedException {
        extentTest = extent.startTest(" AddPlanwithoutTOUDefinition ");
        extentTest.setDescription(" Verify that User is able to add simple plan. ");
        Plans.AddPlanwithoutTOUDefinition();
    }

    @Test(priority = 2,enabled = false)
    public  void PlanwithTOUDefinition_Network_and_Retail_Trf() throws InterruptedException {
        extentTest = extent.startTest(" PlanwithTOUDefinition_Network_and_Retail_Trf ");
        extentTest.setDescription(" Verify that User is able to add plan with TOU definition. ");
        Plans.PlanwithTOUDefinition_Network_and_Retail_Trf();
    }

    @Test(priority = 3,enabled = false)
    public  void PlanwithDemandTOUdefinition_Network_and_Retail_Trf() throws InterruptedException {
        extentTest = extent.startTest(" PlanwithDemandTOUdefinition_Network_and_Retail_Trf ");
        extentTest.setDescription(" Verify that User is able to add plan with Demand TOU definition ");

        planId= Plans.PlanwithDemandTOUdefinition_Network_and_Retail_Trf();
    }



    @Test(priority = 4,enabled=true)
    public  void Add_ProRated_Rates() throws InterruptedException {
        extentTest = extent.startTest(" Add_ProRated_Rates ");
        extentTest.setDescription(" Verify that User is able to add ProRated Rates ");
      //  Login.ValidLogin();
       // planId="MktPlan_NetworkRatebtFs";
        Plans.search_Plan(planId);
        Plans.Add_ProRated_Rates();
    }
    //bug raised
    @Test(priority = 5,enabled = true)
    public  void OtherPlan() throws InterruptedException {
        extentTest = extent.startTest(" OtherPlan [Bug raised]");
        extentTest.setDescription(" Verify that User is able to add other plan ");
        Plans.OtherPlan();
    }
}
