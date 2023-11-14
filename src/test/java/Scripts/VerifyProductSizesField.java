package Scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverInit;
import Pages.EnrichPage;
import Pages.PortalPage;
import Pages.ProductPage;

@Test
public class VerifyProductSizesField {

	
	ExtentReports reports;
	ExtentTest extendtest;
	
	
public void startTest() throws Exception {
	
		
		reports = new ExtentReports("C:\\Users\\tempbasir\\FromGIT\\pim\\Reports\\PIM004_VerifyProductSizesField.html");
		WebDriver driver = DriverInit.initiateDriver(reports);
		
		extendtest = reports.startTest("Verify Product sizes field");
		
		extendtest.log(LogStatus.INFO, "Click enrich");	
	//	inRiverPortal.clickEnrich();
		extendtest.log(LogStatus.PASS, "Enrich clicked");
		
		extendtest.log(LogStatus.INFO, "Search for a product/article");	
		EnrichPage.searchProduct("12345");
		extendtest.log(LogStatus.PASS, "Searched Product/article is retrieved");
		
		extendtest.log(LogStatus.INFO, "Verify product size");	
		ProductPage.detailsTab();
		ProductPage.verifySize();
		extendtest.log(LogStatus.PASS, "Product size label and value is present");
	
		reports.flush();
		driver.close();
}
}
