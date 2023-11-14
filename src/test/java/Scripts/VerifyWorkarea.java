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

public class VerifyWorkarea {
	
	
	static ExtentReports reports;
	static ExtentManager extentManager;
	static ExtentTest extendtest;
	static WebDriver driver = null;
	static String workingDir = System.getProperty("user.dir");
	
	public static void startTest(Connection connection, ExtentReports reports, ExtentTest extendtest) throws Exception {
		
		String loginID, password = "";
		String workarea, execute, workareLimit= "";
				
		Fillo fillo = new Fillo();
		/*Connection connection = fillo
				.getConnection("C:\\Users\\tempbasir\\Testing docs\\Automation\\Data.xlsx");*/

		String settings = "Select * from WorkArea";
		
		Recordset recordset1 = connection.executeQuery(settings);
		
		while (recordset1.next()) {
			
			/*loginID = recordset1.getField("Login Id");
			password = recordset1.getField("Password");*/
			execute = recordset1.getField("Execute");	
							
			if(execute.equalsIgnoreCase("Y")) {
				/*workareLimit = recordset1.getField("WorkareaLimit");
				int limit = Integer.parseInt(workareLimit);*/
				 reports = ExtentManager.getReporter("VerifyWorkarea");
				 driver = DriverInit.initiateDriver(reports);			
				 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				 extendtest = reports.startTest("Verify Workarea");	
				 
				 PortalPage.clickEnrich();
//				 enrichPage.verifyWorkarea(driver, extendtest, limit, inRiverPortal);
				 EnrichPage.verifyWorkarea(driver,extendtest);
			}

		}
		
		reports.endTest(extendtest);
		reports.flush();
		driver.quit();
	}
	
	@AfterClass(alwaysRun = true)
	protected void tearDown() {
		reports.endTest(extendtest);
		reports.flush();
	    driver.quit();
	    driver = null;
	}

}
