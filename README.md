# ACMS MarketBilling
Framework created by **SQE LABS.**

Pre-requisites : Maven,Jdk

  STEPS to run Test Suite
1. Run below cmd in terminal/cmdline for downloading  using git 
        "git clone https://github.com/SQE-Labs/MarketBilling_Smoke"
   OR Download ZIP directly after clicking on **Code** Dropdown at https://github.com/SQE-Labs/MarketBilling_Smoke
2. Run "mvn clean install"  to dowload all dependencies required. 
3. right click on "testng.xml" and run as TESTNG project 
4. View Report in **test-report/ExtentReportResult.html** by opening in browser


This framework is based on Testng , Selenium and Java for Automating Front End Use Cases of Market Billing testcases
* Extent Report is generated in test-report folder as html file.
* Screenshots for Tabs are in test-report/Screenshots folder.
* Smoke testcases are available in SmokeTest Class.
* Configurable data like build url , login  ,passowrd   details are present in config/config.properties file.
