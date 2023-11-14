package Scripts;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Driver.DriverInit;
import Pages.CreateNewRA;
import Pages.PortalPage;

public class PIM002_Create_RelatedArticles {
	private static final String RelationType = null;
	private static final String RelationKeywords = null;
	private static final String ReadyToPublish = null;
	private static final String Baseload = null;
	private static final String Resend = null;
	
	ExtentReports reports;	
	ExtentTest extendtest;

	public void startTest() throws Exception {
		
		reports = new ExtentReports("C:\\Users\\tempbasir\\FromGIT\\pim\\Reports\\PIM002_Create_RelatedArticles.html");
		WebDriver driver = DriverInit.initiateDriver(reports);
		
		extendtest = reports.startTest("Create Related Articles");
		extendtest.log(LogStatus.INFO, "Click enrich");
		PortalPage.clickEnrich();
		extendtest.log(LogStatus.PASS, "Enrich clicked");
		extendtest.log(LogStatus.INFO, "Select create new entity Related Articles");
		PortalPage.clickCreateRelatedArticles();
		extendtest.log(LogStatus.PASS, "Selected create new entity Related Articles");
		extendtest.log(LogStatus.INFO, "Create new Related Articles");
		CreateNewRA.CreateNewRAFlow(RelationType, RelationKeywords, ReadyToPublish, Baseload, Resend);
		extendtest.log(LogStatus.PASS, "New Related Articles is created");

		extendtest.log(LogStatus.INFO, "Verify newly created Related Articles");
		CreateNewRA.VerifyCreatedRelatedArticle();
		extendtest.log(LogStatus.PASS, "Newly created Related Articles is verified");

		reports.flush();
		driver.close();
	}
}
