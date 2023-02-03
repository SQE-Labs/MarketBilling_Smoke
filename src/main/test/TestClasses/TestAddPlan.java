package TestClasses;

import POM.Plans;
import POM.TouImport;
import org.automation.base.BaseTest;
import org.testng.annotations.Test;

public class TestAddPlan extends BaseTest {
    String planId;

    @Test(priority = 0,enabled = true)
    public  void TouImport() throws InterruptedException {
        extent.startTest(" TouImport ");
        test.setDescription(" Verify that User is able to do TouImport");
        TouImport.TOUImportFile();

    }

    @Test(priority = 1,enabled = true)
    public  void AddPlanwithoutTOUDefinition() throws InterruptedException {
        extent.startTest(" AddPlanwithoutTOUDefinition ");
        test.setDescription(" Verify that User is able to add simple plan. ");
        Plans.AddPlanwithoutTOUDefinition();
    }

    @Test(priority = 2,enabled = true)
    public  void PlanwithTOUDefinition_Network_and_Retail_Trf() throws InterruptedException {
        extent.startTest(" PlanwithTOUDefinition_Network_and_Retail_Trf ");
        test.setDescription(" Verify that User is able to add plan with TOU definition. ");
        Plans.PlanwithTOUDefinition_Network_and_Retail_Trf();
    }

    @Test(priority = 3,enabled = true)
    public  void PlanwithDemandTOUdefinition_Network_and_Retail_Trf() throws InterruptedException {
        extent.startTest(" PlanwithDemandTOUdefinition_Network_and_Retail_Trf ");
        test.setDescription(" Verify that User is able to add plan with Demand TOU definition ");

        planId= Plans.PlanwithDemandTOUdefinition_Network_and_Retail_Trf();
    }



    @Test(priority = 4,enabled=true)
    public  void Add_ProRated_Rates() throws InterruptedException {
        extent.startTest(" Add_ProRated_Rates ");
        test.setDescription(" Verify that User is able to add ProRated Rates ");
      //  Login.ValidLogin();
       // planId="MktPlan_NetworkRatebtFs";
        Plans.search_Plan(planId);
        Plans.Add_ProRated_Rates();
    }
    //bug raised
    @Test(priority = 5,enabled = true)
    public  void OtherPlan() throws InterruptedException {
        extent.startTest(" OtherPlan [Bug raised]");
        test.setDescription(" Verify that User is able to add other plan ");
        Plans.OtherPlan();
    }
}
