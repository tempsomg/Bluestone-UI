package Scripts;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import Driver.DriverInit;
import Pages.PortalPage;

public class PIM001_Enrich_product {
	
	ExtentReports reports;

	public void startTest() throws Exception {
		
		reports = new ExtentReports(
				"C:\\Users\\tempbasir\\PIM_AutomationWorkspace\\PIMAutomation\\Reports\\PIM001_Enrich_product.html");
		WebDriver driver = DriverInit.initiateDriver(reports);
		PortalPage.clickEnrich();
		driver.close();
	}

}
