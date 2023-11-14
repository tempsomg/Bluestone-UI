package Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Driver.DriverInit;
import Pages.EnrichPage;
import Pages.PortalPage;
import Utils.ExtentManager;

public class VerifyCampaign {
	
	ExtentReports reports;
	ExtentManager extentManager;
	ExtentTest extendtest;
	
	WebDriver driver = null;
	
	public void startTest() throws Exception {
		
		String loginID, password, executeSettings = "";
		String code, execute = "";				
		Fillo fillo = new Fillo();
		Connection connection = fillo
				.getConnection("C:\\Users\\tempbasir\\Testing docs\\Automation\\Data.xlsx");

		String settings = "Select * from Settings";
		String campaign = "Select * from Campaign";
		
		Recordset recordset1 = connection.executeQuery(settings);
		Recordset recordset2 = connection.executeQuery(campaign);
		
		System.out.println("before while..");
		while (recordset1.next()) {
		
			System.out.println("inside while..");
			loginID = recordset1.getField("Login Id");
			password = recordset1.getField("Password");
			executeSettings = recordset1.getField("Execute");
			
			if(executeSettings.equalsIgnoreCase("Y")) {
				System.out.println("inside if..");
				while (recordset2.next()) {
					code = recordset2.getField("Campaign code");
					execute = recordset2.getField("Execute");
				
					if(execute.equalsIgnoreCase("Y")) {
						 reports = ExtentManager.getReporter("VerifyCampaign");
						 driver = DriverInit.initiateDriver(reports);			
						 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						 extendtest = reports.startTest("Verify display name and display description");			
						 PortalPage.clickEnrich();
						 EnrichPage.searchProduct(code);
						 EnrichPage.openCampaign(driver, code);
						 
					}
				}
			}
			
			
		}
		
	}
	
	@AfterClass(alwaysRun = true)
	protected void tearDown() {
		reports.endTest(extendtest);
		reports.flush();
	    driver.quit();
	    driver = null;
	}
	
}
