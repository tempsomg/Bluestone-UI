package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.Locators;
import Utils.webElements;

public class ArticlePage implements webElements {

	/*
	 * Verifying hazmat details from all the linked details. Open each article read hazmat values and store in arraylist.
	 * Using linkedhashset to remove duplicates from arraylist. Iterate the list and store to StringBuilder obj by appending commas.
	 * Display the aggregated list without duplicates in report
	 * Navigating to warning page. Reading product hazmat values and taking screenshot
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void verifyHazmatValues(WebDriver driver, ExtentTest extendtest) throws Exception {
		
		ArrayList hazmatClassList = new ArrayList();
		ArrayList hazmatUNCodeList = new ArrayList();
		ArrayList hazmatDGDescList = new ArrayList();
		StringBuilder aggreHazmatclass = new StringBuilder();
		StringBuilder aggreHazmatUNCode = new StringBuilder();
		StringBuilder aggreHazmatDGDesc = new StringBuilder();
		String screenShotPath1 = "";
		
		List<WebElement> articlesCount = Locators.getXpathList(LinkedArticlesCount);
		int articleCount = articlesCount.size();
		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Verify the Hazmat details in product level is the aggregation of Hazmat by removing duplicates from all linked articles.</b></h6>");
		extendtest.log(LogStatus.INFO, "There are "+articleCount+" articles linked to the product. Reading Hazmat details from linked articles");		
			
		for(int i=1; i<=articleCount; i++){
			driver.findElement(By.xpath("//div[@id='ProductArticle']/div[@id='relation-section-container']/div["+i+"]/div/div[@id='contextmenu']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//span[@id='edit-entity'])["+i+"]")).click();
			Thread.sleep(5000); 
			String articleNum = Locators.getName(ArticleNumber).getAttribute("value");
			Locators.getXPath(ArticleHazmatDGDesc).click();
			Thread.sleep(3000);
			String hazmatClass = Locators.getXPath(ArticleHazmatClass).getAttribute("value");
			String hazmatUNCode = Locators.getXPath(ArticleHazmatUNCode).getAttribute("value");
			String hazmatDGDescption = Locators.getXPath(ArticleHazmatDGDesc).getAttribute("value");
			extendtest.log(LogStatus.PASS, "The article "+articleNum+" contains, HazmatClass: "+hazmatClass+" HazmatUNCode: "+hazmatUNCode+" HazmatDGDescription: "+hazmatDGDescption);
			Thread.sleep(2000);
		
			hazmatClassList.add(hazmatClass);
			hazmatUNCodeList.add(hazmatUNCode);
			hazmatDGDescList.add(hazmatDGDescption);
	
			Locators.getID(EditCancel).click();
			Thread.sleep(3000);		
		}
		
		Set<String> hazClass = new LinkedHashSet<String>(hazmatClassList);
		Iterator itClass = hazClass.iterator();
		while(itClass.hasNext()){
			aggreHazmatclass.append(itClass.next());
			aggreHazmatclass.append(",");
		}
		
		Set<String> hazUnCode = new LinkedHashSet<String>(hazmatUNCodeList);
		Iterator itUNCode = hazUnCode.iterator();
		while(itUNCode.hasNext()){
			aggreHazmatUNCode.append(itUNCode.next());
			aggreHazmatUNCode.append(",");
		}
		
		Set<String> hazDGDescription = new LinkedHashSet<String>(hazmatDGDescList);
		Iterator itDGDesc = hazDGDescription.iterator();
		while(itDGDesc.hasNext()){
			aggreHazmatDGDesc.append(itDGDesc.next());
			aggreHazmatDGDesc.append(",");
		}
		
		extendtest.log(LogStatus.INFO, "Aggregating hazmat values by removing duplicates");
		extendtest.log(LogStatus.INFO, "Expected Hazmat values after aggregation :: <br />" +
				"Hazmat class: "+aggreHazmatclass.substring(0, aggreHazmatclass.length() - 1)+ "<br />" +
				"Hazmat UN code: "+aggreHazmatUNCode.substring(0, aggreHazmatUNCode.length() - 1)+ "<br />" +
				"Hazmat DG description: "+aggreHazmatDGDesc.substring(0, aggreHazmatDGDesc.length() -1));
		
		Thread.sleep(5000);
		ProductPage.warningTab();
		extendtest.log(LogStatus.INFO, "Navigating to Warning page");
		Thread.sleep(2000);
		driver.switchTo().frame("context-editor-iframe");
		String prodHazmatClass = Locators.getID(ProdHazmatClass).getAttribute("value");
		String prodHazmatUnCode = Locators.getXPath(ProdHazmatUNCode).getText();
		Thread.sleep(2000);
		String prodHazmatDGDesc = Locators.getID(ProdHazmatDGDesc).getAttribute("value");
		screenShotPath1 = PortalPage.addScreenshot(driver);
		extendtest.log(LogStatus.INFO, "Actual Hazmat values displayed at product level :: <br />" +
				"Hazmat class: "+prodHazmatClass+ "<br />" +
				"Hazmat UN code: "+prodHazmatUnCode+ "<br />" +
				"Hazmat DG description: "+prodHazmatDGDesc+ extendtest.addScreenCapture(screenShotPath1));
		
		extendtest.log(LogStatus.PASS, "Expected and Actual Hamzat values are matching hence Hazmat details aggregrated correctly");
				
	//	extendtest.log(LogStatus.PASS,
	//			"Screenshot below to verify product hazmat values " + extendtest.addScreenCapture(screenShotPath1));
		
	}
	

	//Verifying product warning type is updated to Safety information attribute in all linked articles
	public static void verifySafetyInfo(WebDriver driver, ExtentTest extendtest, String productWarning) throws Exception {
	//	String screenShotPath1;
		List<WebElement> articlesCount = Locators.getXpathList(LinkedArticlesCount);
		int articleCount = articlesCount.size();
		//extendtest.log(LogStatus.INFO, "Verify product warnings is reflectd back on all linked articles in Safety information attribute");		
			
		for(int i=1; i<=articleCount; i++){
			driver.findElement(By.xpath("//div[@id='ProductArticle']/div[@id='relation-section-container']/div["+i+"]/div/div[@id='contextmenu']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[@id='edit-entity'])["+i+"]")).click();
			Thread.sleep(2000); 
			String articleNum = Locators.getName(ArticleNumber).getAttribute("value");
			Locators.getXPath(ArticleHazmatUNCode).click();
			Thread.sleep(3000);
			String safetyInfo = Locators.getXPath(ArticleSafetyInfo).getAttribute("value");
			//extendtest.log(LogStatus.INFO, "Safety information for article "+articleNum+" holds the value: "+safetyInfo);
		//	screenShotPath1 = PortalPage.addScreenshot(driver);
			
			if(productWarning.equalsIgnoreCase(safetyInfo.trim())){
				extendtest.log(LogStatus.PASS,
						"For Article: "+articleNum+" the product warning is reflected in article safety info. </br>"
								+ "The attribute holds the JSON values: "+safetyInfo);
			} else{
			//	extendtest.log(LogStatus.FAIL,
			//			"Product warning is NOT reflected in article safety info. Screenshot below, " + extendtest.addScreenCapture(screenShotPath1));
				extendtest.log(LogStatus.FAIL,
						"For Article: "+articleNum+" the product warning is NOT reflected in article safety info. </br>"
								+ "The attribute holds the JSON values: "+safetyInfo);
			}
						
			Thread.sleep(2000);		
			Locators.getID(EditCancel).click();
			Thread.sleep(3000);		
		}
	}

	
	/////////////////////////////////////SomnathCBS///////////////////////////////////////////
	
	public static void MarkCBS(WebDriver driver, ExtentTest extendtest) throws Exception {
		String screenShotPath1;
		Locators.getXPath(Businessmodellabel).click();
		Thread.sleep(5000);
		Locators.getXPath(CBScheckbox).click();
		Thread.sleep(9000);
		Locators.getXPath(Savefind).click();
		Thread.sleep(12000);
//		Locators.getXPath(Save_button).click();
//		Thread.sleep(12000);
		driver.navigate().refresh();
		try{
			driver.findElement(By.xpath("//*[@id='category-field-container']/div[22]/fieldset/div[1]/div/div")).click();
		
		Thread.sleep(3000);
		screenShotPath1 = PortalPage.addScreenshot(driver);
	    extendtest.log(LogStatus.PASS, "Article Is Marked as CBS" + extendtest.addScreenCapture(screenShotPath1));
	    driver.navigate().refresh();
	    driver.findElement(By.xpath("(//*[@id='category-field-container']/div[4]/fieldset/div[1]/div/div)[8]")).click();
		Thread.sleep(3000);
		screenShotPath1 = PortalPage.addScreenshot(driver);
	    extendtest.log(LogStatus.PASS, "Locales has been Verified " + extendtest.addScreenCapture(screenShotPath1));
	    Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@id='category-field-container']/div[5]/fieldset/div[1]/div/div)[8]")).click();
		Thread.sleep(3000);
		screenShotPath1 = PortalPage.addScreenshot(driver);
	    extendtest.log(LogStatus.PASS, "Enrichment status has been verified" + extendtest.addScreenCapture(screenShotPath1));
	    ProductPage.overviewTab();
	    extendtest.log(LogStatus.INFO, "Article is marked as CBS Navigated to Overview");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id='inbound-area-content']")).click();
		Thread.sleep(3000);
		extendtest.log(LogStatus.INFO, "Product Check");
		ProductPage.detailsTab();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(9000);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@id='category-field-container']/div[16]/fieldset/div[1]/div/div)[3]")).click();
		Thread.sleep(3000);
		screenShotPath1 = PortalPage.addScreenshot(driver);
	    extendtest.log(LogStatus.PASS, "Product Is Marked as CBS" + extendtest.addScreenCapture(screenShotPath1));
	    Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@id='category-field-container']/div[5]/fieldset/div[1]/div/div)[4]")).click();
		Thread.sleep(3000);
		screenShotPath1 = PortalPage.addScreenshot(driver);
	    extendtest.log(LogStatus.PASS, "Product Locales in CBS" + extendtest.addScreenCapture(screenShotPath1));
	    
	    }
	    catch(Exception e){
			e.toString();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}		
	}
//////////////////////////Somnath Flowers and PLants////////////////////////////////////////////////
	public static void FlowernPlants(WebDriver driver, ExtentTest extendtest) throws Exception {
		String screenShotPath1;
		Locators.getXPath(Flowernplant).click();
		Thread.sleep(32000);
		try{
			driver.findElement(By.xpath("//*[@id=\'category-field-container\']/div[48]/fieldset/div[1]/div/div/b")).click();
		
		Thread.sleep(32000);
		screenShotPath1 = PortalPage.addScreenshot(driver);
	    extendtest.log(LogStatus.PASS, "Article Has Flowers and Plants Data" + extendtest.addScreenCapture(screenShotPath1));
	    driver.navigate().refresh();  
	    }
	    catch(Exception e){
			e.toString();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}		
	}
	
	
	
//////////////////////////Somnath Color n Shades ////////////////////////////////////
	
	
	
	public static void ClornShades(WebDriver driver, ExtentTest extendtest) throws Exception {
		String screenShotPath1;
		Locators.getXPath(Colorshade).click();
		Thread.sleep(32000);

		try{
			driver.findElement(By.xpath("//*[@id=\'category-field-container\']/div[26]/fieldset/div[1]/div")).click();
		
		Thread.sleep(3000);
		screenShotPath1 = PortalPage.addScreenshot(driver);
	    extendtest.log(LogStatus.PASS, "Article Contains ColorShades Data" + extendtest.addScreenCapture(screenShotPath1));
	    driver.navigate().refresh();	
}
catch(Exception e){
	e.toString();
	extendtest.log(LogStatus.FAIL, e.getMessage());
	ProductPage.returnPortal();
}		
}
	
		
	public static void verifyCompositionListInArticles(WebDriver driver, ExtentTest extendtest, String material, String percentage) throws Exception {
		String screenShotPath1;
		ProductPage.includesTab();
		extendtest.log(LogStatus.INFO, "Navigating to Includes page");
		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 2: Verify composition list attribute is updated in linked articles</b></h6>");
		List<WebElement> articlesCount = Locators.getXpathList(LinkedArticlesCount);
		int articleCount = articlesCount.size();	
			
		for(int i=1; i<=articleCount; i++){
			driver.findElement(By.xpath("//div[@id='ProductArticle']/div[@id='relation-section-container']/div["+i+"]/div/div[@id='contextmenu']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[@id='edit-entity'])["+i+"]")).click();
			Thread.sleep(2000); 
			String articleNum = Locators.getName(ArticleNumber).getAttribute("value");
			Locators.getXPath(TransMajorChange_Text).click();
			Thread.sleep(3000);
			String compositionList = Locators.getXPath(CompositionList).getAttribute("value");
		//	extendtest.log(LogStatus.PASS, "CompositionList for Article: "+articleNum+" holds the value: "+compositionList);
			screenShotPath1 = PortalPage.addScreenshot(driver);
			
			if(compositionList.toLowerCase().contains(material.toLowerCase()) && compositionList.contains(percentage) ){
				extendtest.log(LogStatus.PASS,
						"CompositionList is updated successfully to Article: "+articleNum+"</br>"
								+ "The attribute hold the value: "+compositionList+"</br>"
								+ "Screenshot below," + extendtest.addScreenCapture(screenShotPath1));
			} else{
				extendtest.log(LogStatus.FAIL,
						"Composition is NOT copied to Article. Screenshot below, " + extendtest.addScreenCapture(screenShotPath1));
			}
			
			Thread.sleep(2000);		
			Locators.getID(EditCancel).click();
			Thread.sleep(3000);	
		}
		
		
	}



}
