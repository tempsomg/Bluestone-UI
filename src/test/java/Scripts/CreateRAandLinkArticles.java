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
import Pages.CreateNewRA;
import Pages.PortalPage;
import Pages.RelatedArticlePage;
import Utils.ExtentManager;


public class CreateRAandLinkArticles {

	
	ExtentReports reports;	
	ExtentTest extendtest;
	RelatedArticlePage relatedArticlePage;
	ExtentManager extentManager;
	
	public void startTest() throws Exception {	
		
		relatedArticlePage = new RelatedArticlePage();
		String relationType ="";
		String relationKeywords ="";
		String readyToPublish ="";
		String baseload ="";
		String resend ="";	
		String execute ="";
		String relatedArticleID ="";
		String raID ="";
		String articleNumber ="";
		
		reports = extentManager.getReporter("PIM001_CreateRAandLinkArticles");
		
		WebDriver driver = DriverInit.initiateDriver(reports);
		
		Fillo fillo = new Fillo();
		Connection connection = fillo
				.getConnection("C:\\Users\\tempbasir\\Testing docs\\Automation\\Data.xlsx");
		String addRA = "Select * from AddRelatedArticles";
		String addArticles = "Select * from AddArticleToRA";
		Recordset recordset1 = connection.executeQuery(addRA);
		Recordset recordset2 = null;
		
		extendtest = reports.startTest("Create Related Articles");
		
		Boolean firstRA =true;
		int count =0;
		while (recordset1.next()) {
			relationType = recordset1.getField("RelationType");
			relationKeywords = recordset1.getField("RelationKeywords");
			readyToPublish = recordset1.getField("ReadyToPublish"); 
			baseload = recordset1.getField("Baseload");
			resend = recordset1.getField("Bump/Resend");
			execute = recordset1.getField("Execute");
			relatedArticleID = recordset1.getField("RelatedArticleID");
			
			recordset2 = connection.executeQuery(addArticles);
		
			if(execute.equalsIgnoreCase("Y"))
			{
				if(count==0) {
					PortalPage.clickEnrich();	
				}
				else {
					PortalPage.clickTopHeaderTitle();
				}
				count ++;					
				extendtest.log(LogStatus.INFO, "Select create new entity Related Articles");
				PortalPage.clickCreateRelatedArticles();
				extendtest.log(LogStatus.PASS, "Selected create new entity Related Articles");
				
				extendtest.log(LogStatus.INFO, "Create new Related Articles");
				CreateNewRA.CreateNewRAFlow(relationType, relationKeywords, readyToPublish, baseload, resend);
				extendtest.log(LogStatus.PASS, "New Related Articles is created");
						
				CreateNewRA.VerifyCreatedRelatedArticle();				
				extendtest.log(LogStatus.INFO, "Start linking articles to created related article");
				
				relatedArticlePage.clickIncludesTab();
				while (recordset2.next()) {
					raID = recordset2.getField("RelatedArticleID");
					articleNumber = recordset2.getField("ArticleNumber");
				
					if(raID.equals(relatedArticleID)) {		
						relatedArticlePage.linkArticleTosRelatedArticle(driver, articleNumber, extendtest);
					}
						
				}
				extendtest.log(LogStatus.PASS, "Finished linking articles to created related article");
			}
		
		
	}
		reports.flush();
		driver.close();
		
	}
	
}
