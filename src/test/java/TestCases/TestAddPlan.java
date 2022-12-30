package TestCases;

import CommonMethods.BaseTest;
import POM.Plans;
import POM.TouImport;
import org.testng.annotations.Test;

public class TestAddPlan extends BaseTest {


    @Test(priority = 0)
    public static void TouImport() throws InterruptedException {
        extentTest = extent.startTest(" TouImport ");
        extentTest.setDescription(" Verify that User is able to do TouImport");
        TouImport.TOUImportFile();

    }

    @Test(priority = 1)
    public static void AddPlanwithoutTOUDefinition() throws InterruptedException {
        extentTest = extent.startTest(" AddPlanwithoutTOUDefinition ");
        extentTest.setDescription(" Verify that User is able to add simple plan. ");
        Plans.AddPlanwithoutTOUDefinition();
    }

    @Test(priority = 2)
    public static void PlanwithTOUDefinition_Network_and_Retail_Trf() throws InterruptedException {
        extentTest = extent.startTest(" PlanwithTOUDefinition_Network_and_Retail_Trf ");
        extentTest.setDescription(" Verify that User is able to add plan with TOU definition. ");
        Plans.PlanwithTOUDefinition_Network_and_Retail_Trf();
    }

    @Test(priority = 3)
    public static void PlanwithDemandTOUdefinition_Network_and_Retail_Trf() throws InterruptedException {
        extentTest = extent.startTest(" PlanwithDemandTOUdefinition_Network_and_Retail_Trf ");
        extentTest.setDescription(" Verify that User is able to add plan with Demand TOU definition ");
        Plans.PlanwithDemandTOUdefinition_Network_and_Retail_Trf();
    }

    //Issue opened
    @Test(priority = 5)
    public static void OtherPlan() throws InterruptedException {
        extentTest = extent.startTest(" OtherPlan ");
        extentTest.setDescription(" Verify that User is able to add other plan ");
        Plans.OtherPlan();
    }

    @Test(priority = 4,enabled=false)
    public static void Add_ProRated_Rates() throws InterruptedException {
        extentTest = extent.startTest(" Add_ProRated_Rates ");
        extentTest.setDescription(" Verify that User is able to add ProRated Rates ");
        Plans.Add_ProRated_Rates();
    }
}
