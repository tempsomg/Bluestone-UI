package Scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverInit;
import Pages.PortalPage;
import Utils.ExtentManager;

public class VerifyDAMAssetInPIM {	
	ExtentReports reports;
	ExtentManager extentManager;
	ExtentTest extendtest;

public void startTest() throws Exception {
		String assetID = "";
		String articleNumbers = "";
		String assetState = "";
		reports =ExtentManager.getReporter("PIM002_VerifyDAMAssetInPIM");
		
		WebDriver driver = DriverInit.initiateDriver(reports);
		
		Fillo fillo = new Fillo();
		Connection connection = fillo
				.getConnection("C:\\Users\\tempbasir\\Testing docs\\Automation\\Data.xlsx");
		
		String asset = "Select * from DAMAsset";
		Recordset recordset1 = connection.executeQuery(asset);
		
		extendtest = reports.startTest("Verify DAM asset in PIM");
		
		int i=0;
		while (recordset1.next()) {
			assetID = recordset1.getField("AssetID");
			articleNumbers = recordset1.getField("ArticleNumbers");
			assetState = recordset1.getField("AssetState");
			
			if(assetState.trim().equalsIgnoreCase("Enriched")) {
				
				if(i==0) {
					PortalPage.clickEnrich();	
				}
				else {
					PortalPage.clickTopHeaderTitle();
				}	
				
				extendtest.log(LogStatus.INFO, "Open search query box and enter search query");
				PortalPage.openSearchQuery();
				PortalPage.enrichedAssetQuery(assetID);
				extendtest.log(LogStatus.PASS, "Search completed");
				
				extendtest.log(LogStatus.INFO, "Verify the asset is present in PIM");
				PortalPage.openResource(extendtest, driver);
				
				extendtest.log(LogStatus.INFO, "Verify the asset is linked to the articles");
				PortalPage.openIncludedIn();
				PortalPage.verifyLinkedArticles(articleNumbers, extendtest);
				extendtest.log(LogStatus.PASS, "Verification completed, the asset is linked to the articles correctly");
				
				i++;
			}else if(assetState.trim().equalsIgnoreCase("Quarantine")) {
				
				if(i==0) {
					PortalPage.clickEnrich();	
				}
				else {
					PortalPage.clickTopHeaderTitle();
				}	
				
				extendtest.log(LogStatus.INFO, "Open search query box and enter search query");
				PortalPage.openSearchQuery();
				PortalPage.enrichedAssetQuery(assetID);
				extendtest.log(LogStatus.PASS, "Search completed");
				
				extendtest.log(LogStatus.INFO, "Verify the quarantined asset is not present in PIM");
				PortalPage.checkResource(extendtest);
				String screenShotPath = PortalPage.capture(driver, "QuarantineAssetNotFound");
				extendtest.log(LogStatus.PASS, "Snapshot below: " + extendtest.addScreenCapture(screenShotPath));
			}
			
		}
		
		reports.flush();
		driver.close();
}
}
