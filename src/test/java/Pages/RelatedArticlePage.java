package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.Locators;
import Utils.webElements;

public class RelatedArticlePage implements webElements {
	public static void clickIncludesTab() throws Exception {
		Thread.sleep(2000);
		Locators.getID(IncludesTabLink).click();
		Thread.sleep(3000);
	}
	
	public static void verifyCreatedRelatedArticle(WebDriver driver, ExtentTest extendtest, String relationType, 
			String internalRelationName, String relationKeywords, String readyToPublish, String baseload, String bumpresend) throws Exception {
		
		String screenShotPath1,relationName ="";
		Boolean relationTypeFlag;
		Boolean relationKeywordsFlag = false;
		Boolean readyToPublishFlag = false;
		Boolean baseloadFlag = false;
		Boolean bumpResendFlag = false;
		Thread.sleep(2000);
		Locators.getClassName(RelatedArticle).click();	
		Thread.sleep(5000);
		ProductPage.detailsTab();
		screenShotPath1 = PortalPage.addScreenshot(driver);
		extendtest.log(LogStatus.INFO, "Screenshot below for newly created RA: "+extendtest.addScreenCapture(screenShotPath1));
				
		if(relationType.equalsIgnoreCase("Visually matching")){
			relationTypeFlag = Locators.getXPath(RT_VisuallyMatching_RadioButton).isSelected();
		}else{
			relationTypeFlag = Locators.getXPath(RT_Notset_RadioButton).isSelected();
		}
		
		if(relationTypeFlag==true){
			extendtest.log(LogStatus.PASS, "Relation Type is updated successfully");
		}else{
			extendtest.log(LogStatus.FAIL, "Relation Type is NOT updated successfully");
		}
		
		if(relationType.equalsIgnoreCase("Visually matching")){
			relationTypeFlag = Locators.getXPath(RT_VisuallyMatching_RadioButton).isSelected();
		}else{
			relationTypeFlag = Locators.getXPath(RT_Notset_RadioButton).isSelected();
		}
		
		relationName = Locators.getName(InternalRelationName).getAttribute("value");		
		if(relationName.equalsIgnoreCase(internalRelationName)){
			extendtest.log(LogStatus.PASS, "Internal Relation Name is updated successfully");
		}else{
			extendtest.log(LogStatus.FAIL, "Internal Relation Name is NOT updated successfully");
		}
		
		if (relationKeywords.contains(",")) {
				String[] arrSplit = relationKeywords.split(",");
				for (int i = 0; i < arrSplit.length; i++) {
					WebElement element = driver.findElement(By.xpath("//ul[@name='Fields_5_Value']/li/label[text()='"+arrSplit[i].trim()+"']"));
					relationKeywordsFlag = element.findElement(By.xpath("../input")).isSelected();
				//	System.out.println("relationKeywordsFlag::"+relationKeywordsFlag);
					if(relationKeywordsFlag==false){
						extendtest.log(LogStatus.FAIL, "Relation keywords NOT updated successfully");
						break;
					}
				}
		}
		else {
			WebElement element = driver.findElement(By.xpath("//ul[@name='Fields_5_Value']/li/label[text()='"+relationKeywords+"']"));
			relationKeywordsFlag = element.findElement(By.xpath("../input")).isSelected();
			//System.out.println("relationKeywordsFlag::"+relationKeywordsFlag);
			if(relationKeywordsFlag==false){
				extendtest.log(LogStatus.FAIL, "Relation keywords NOT updated successfully");
			}
		}
		
		if(relationKeywordsFlag==true){
			extendtest.log(LogStatus.PASS, "Relation keywords updated successfully");
		} 
				
		readyToPublishFlag = Locators.getXPath(ReadyToPublish_False).isSelected();		
		if(readyToPublish.equalsIgnoreCase("true") && readyToPublishFlag==true){
			extendtest.log(LogStatus.PASS, "RA was created with Ready to publish as TRUE and it automatically updated as False successfully");
		} else if(readyToPublishFlag==true){
			extendtest.log(LogStatus.PASS, "RA was created with Ready to publish as FALSE and it is updated as False successfully");
		} else if(readyToPublishFlag==false){
			extendtest.log(LogStatus.FAIL, "Ready to publish is NOT updated successfully");
		}
		
		baseloadFlag = Locators.getXPath(Baseload_False).isSelected();		
		if(baseload.equalsIgnoreCase("true") && baseloadFlag==true){
			extendtest.log(LogStatus.PASS, "RA was created with Baseload as TRUE and it automatically updated as False successfully");
		} else if(baseloadFlag==true){
			extendtest.log(LogStatus.PASS, "RA was created with Baseload as FALSE and it is updated as False successfully");
		} else if(baseloadFlag==false){
			extendtest.log(LogStatus.FAIL, "Baseload is NOT updated successfully");
		}
		
		bumpResendFlag = Locators.getXPath(Resend_False).isSelected();		
		if(bumpresend.equalsIgnoreCase("true") && bumpResendFlag==true){
			extendtest.log(LogStatus.PASS, "RA was created with Bump/resend to channel as TRUE and it automatically updated as False successfully");
		} else if(bumpResendFlag==true){
			extendtest.log(LogStatus.PASS, "RA was created with Bump/resend to channel as FALSE and it is updated as False successfully");
		} else if(bumpResendFlag==false){
			extendtest.log(LogStatus.FAIL, "Bump/resend to channel is NOT updated successfully");
		}
	}
	
	
	public static void linkArticleTosRelatedArticle(WebDriver driver, String articleNumber, ExtentTest extendtest) throws Exception {
		String screenShotPath1,screenShotPath2,screenShotPath3="";
		Boolean fail = false;
		RelatedArticlePage.clickIncludesTab();		
		if(articleNumber.contains(",")) {
				String[] arrSplit = articleNumber.split(",");
				for (int i = 0; i < arrSplit.length; i++) {
				//	driver.findElement(By.xpath("//ul[@name='Fields_2_Value']/li/label[text()='"+arrSplit[i].trim()+"']")).click();	
					Locators.getID(SearchBox).click();
					Locators.getID(SearchBox).clear();
					Locators.getID(SearchBox).sendKeys(arrSplit[i]);
					Thread.sleep(2000);
					Locators.getID(SearchBoxEnter).click();
					Thread.sleep(4000);
					Actions actions = new Actions(driver);
					WebElement article = driver.findElement(By.xpath("//img[@title='Article']"));
					WebElement relation_section_container = driver.findElement(By.id("relation-section-container"));
					actions.dragAndDrop(article, relation_section_container).build().perform();
					Thread.sleep(4000);
					List<WebElement> accessmsg = Locators.getXpathList(AccessDeniedAlert);
					if(!Locators.getXpathList(AccessDeniedAlert).isEmpty()){
						if(accessmsg.get(0).isDisplayed()){
							screenShotPath1 = PortalPage.addScreenshot(driver);
							extendtest.log(LogStatus.FAIL, "Article "+arrSplit[i]+" is already included in a relation of type Visually matching"+extendtest.addScreenCapture(screenShotPath1));
							Thread.sleep(5000);
							Locators.getID(AlertOK_button).click();
							fail= true;
						}
					}
				}
			}

			else {
				Locators.getID(SearchBox).click();
				Locators.getID(SearchBox).clear();
				Locators.getID(SearchBox).sendKeys(articleNumber);
				Thread.sleep(2000);
				Locators.getID(SearchBoxEnter).click();
				Thread.sleep(4000);
				Actions actions = new Actions(driver);
				WebElement article = driver.findElement(By.xpath("//img[@title='Article']"));
				WebElement relation_section_container = driver.findElement(By.id("relation-section-container"));
				actions.dragAndDrop(article, relation_section_container).build().perform();
				Thread.sleep(4000);
				List<WebElement> accessmsg = Locators.getXpathList(AccessDeniedAlert);
				if(!Locators.getXpathList(AccessDeniedAlert).isEmpty()){
					if(accessmsg.get(0).isDisplayed()){
						screenShotPath2 = PortalPage.addScreenshot(driver);
						extendtest.log(LogStatus.FAIL, "Article "+articleNumber+" is already included in a relation of type Visually matching"+extendtest.addScreenCapture(screenShotPath2));
						Thread.sleep(5000);
						Locators.getID(AlertOK_button).click();
						fail= true;
					}
				}
			}
		
		if(!fail){
			screenShotPath3 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS, "Linked articles successfully. Screenshot below, "+extendtest.addScreenCapture(screenShotPath3));
		}
		
	}
	

	public static void updateReadyToPublish(WebDriver driver, ExtentTest extendtest) throws Exception {
		String screenShotPath1="";
		ProductPage.detailsTab();
		Locators.getXPath(ReadyToPublish_True).click();
		Thread.sleep(2000);
		Locators.getID(Save_button).click();
		Thread.sleep(5000);
		screenShotPath1 = PortalPage.addScreenshot(driver);
		if(!Locators.getXpathList(AccessDeniedAlert).isEmpty()){
			extendtest.log(LogStatus.FAIL, "Must have at least two article links on a published RelatedArticles entity"+extendtest.addScreenCapture(screenShotPath1));
			Thread.sleep(4000);
			Locators.getID(AlertOK_button).click();
		} 
		else{
			extendtest.log(LogStatus.PASS, "Published Related articles successfully"+extendtest.addScreenCapture(screenShotPath1));
		}
		
	}

	public static void deleteRA(WebDriver driver, ExtentTest extendtest) throws Exception {
		Locators.getXPath(DeleteButton).click();
		Thread.sleep(2000);
		Locators.getID(AlertOK_button).click();
		Thread.sleep(2000);
	}	

}
