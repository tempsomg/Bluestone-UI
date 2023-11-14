package Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverInit;
import Pages.ArticlePage;
import Pages.EnrichPage;
import Pages.PortalPage;
import Pages.ProductPage;
import Utils.Locators;
import Utils.webElements;

public class RegressionSuite_v1 implements webElements {

	static WebDriver driver = null;
	static String workingDir = System.getProperty("user.dir");

	
	/** Verify Product Magnifier functionality
	 * @author tempbasir
	 * Date:2018-07-03
	 */
	public static void PIMDEV_2382(Connection connection, ExtentReports reports, ExtentTest extendtest)
			throws Exception {

		String productID, executeProduct = "";
		int count = 0;

		String product = "Select * from PIMDEV_2382";
		Recordset productRecord = connection.executeQuery(product);

		driver = DriverInit.initiateDriver(reports);
		extendtest = reports.startTest("Verify Magnifier Functionality");

		while (productRecord.next()) {

			productID = productRecord.getField("ProductID").trim();
			executeProduct = productRecord.getField("Execute").trim();

			if (executeProduct.equalsIgnoreCase("Y")) {
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				if (count == 0) {
					PortalPage.clickEnrich();
				} else {
					PortalPage.clickTopHeaderTitle();
				}
				count++;
				EnrichPage.searchProduct(productID);
				PortalPage.openSearchedProduct(driver);
				extendtest.log(LogStatus.INFO, "Product: " + productID + " is found");
				ProductPage.magnifierTab();
				extendtest.log(LogStatus.INFO, "Navigated to Magnifier tab");
				ProductPage.verifyMagnifier(driver, extendtest, productID);
			}

		}
		driver.quit();

	}

	
	/**  Verify workarea folders for error message
	 *  @author tempbasir
	 *  Date: 2018-07-03
	 */

	public static void verifyWorkarea(Connection connection, ExtentReports reports, ExtentTest extendtest) throws Exception {
		driver = DriverInit.initiateDriver(reports);
		extendtest = reports.startTest("Verify Workarea");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		PortalPage.clickEnrich();
		EnrichPage.verifyWorkarea(driver, extendtest);
		driver.quit();
	}

	/* Verify Composition for the products
	 * Created by: Thangavel V
	 */
	public static void PIMDEV_2378(Connection connection, ExtentReports reports, ExtentTest extendtest)
			throws Exception {
		String productID, executeProduct, mode, article, composition, material, article1, composition1, material1,
				article2, composition2, material2, article3, composition3, material3, article4, composition4, material4,
				article5, composition5, material5, article6, composition6, material6, article7, composition7, material7,
				article8, composition8, material8, article9, composition9, material9, article10, composition10,
				material10, setFact1, setFact2, setFact3, setFact4, setFact5, setFact6, setFact7, setFact8, setFact9,
				setFact10, copy1, copy2, copy3, copy4, copy5, copy6, copy7, copy8, copy9, copy10, testScenario,
				percentage;
		int count = 0;
		String product = "Select * from PIMDEV_2378";
		Recordset productRecord = connection.executeQuery(product);
		driver = DriverInit.initiateDriver(reports);
		extendtest = reports.startTest("Verify Composition and Material Functionality");

		while (productRecord.next()) {
			productID = productRecord.getField("ProductID").trim();
			mode = productRecord.getField("Mode").trim();
			article = productRecord.getField("Article").trim();
			composition = productRecord.getField("Composition").trim();
			material = productRecord.getField("Material").trim();
			article1 = productRecord.getField("Article1").trim();
			composition1 = productRecord.getField("Composition1").trim();
			material1 = productRecord.getField("Material1").trim();
			article2 = productRecord.getField("Article2").trim();
			composition2 = productRecord.getField("Composition2").trim();
			material2 = productRecord.getField("Material2").trim();
			article3 = productRecord.getField("Article3").trim();
			composition3 = productRecord.getField("Composition3").trim();
			material3 = productRecord.getField("Material3").trim();
			article4 = productRecord.getField("Article4").trim();
			composition4 = productRecord.getField("Composition4").trim();
			material4 = productRecord.getField("Material4").trim();
			article5 = productRecord.getField("Article5").trim();
			composition5 = productRecord.getField("Composition5").trim();
			material5 = productRecord.getField("Material5").trim();
			article6 = productRecord.getField("Article6").trim();
			composition6 = productRecord.getField("Composition6").trim();
			material6 = productRecord.getField("Material6").trim();
			article7 = productRecord.getField("Article7").trim();
			composition7 = productRecord.getField("Composition7").trim();
			material7 = productRecord.getField("Material7").trim();
			article8 = productRecord.getField("Article8").trim();
			composition8 = productRecord.getField("Composition8").trim();
			material8 = productRecord.getField("Material8").trim();
			article9 = productRecord.getField("Article9").trim();
			composition9 = productRecord.getField("Composition9").trim();
			material9 = productRecord.getField("Material9").trim();
			article10 = productRecord.getField("Article10").trim();
			composition10 = productRecord.getField("Composition10").trim();
			material10 = productRecord.getField("Material10").trim();
			executeProduct = productRecord.getField("Execute").trim();

			setFact1 = productRecord.getField("SetFact1").trim();
			setFact2 = productRecord.getField("SetFact2").trim();
			setFact3 = productRecord.getField("SetFact3").trim();
			setFact4 = productRecord.getField("SetFact4").trim();
			setFact5 = productRecord.getField("SetFact5").trim();
			setFact6 = productRecord.getField("SetFact6").trim();
			setFact7 = productRecord.getField("SetFact7").trim();
			setFact8 = productRecord.getField("SetFact8").trim();
			setFact9 = productRecord.getField("SetFact9").trim();
			setFact10 = productRecord.getField("SetFact10").trim();

			copy1 = productRecord.getField("Copy1").trim();
			copy2 = productRecord.getField("Copy2").trim();
			copy3 = productRecord.getField("Copy3").trim();
			copy4 = productRecord.getField("Copy4").trim();
			copy5 = productRecord.getField("Copy5").trim();
			copy6 = productRecord.getField("Copy6").trim();
			copy7 = productRecord.getField("Copy7").trim();
			copy8 = productRecord.getField("Copy8").trim();
			copy9 = productRecord.getField("Copy9").trim();
			copy10 = productRecord.getField("Copy10").trim();
			testScenario = productRecord.getField("TestScenario").trim();
			percentage = productRecord.getField("Percentage").trim();

			if (executeProduct.equalsIgnoreCase("Y")) {
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				if (count == 0) {
					PortalPage.clickEnrich();
				} else {
					PortalPage.clickTopHeaderTitle();
				}
				count++;

				EnrichPage.searchProduct(productID);
				PortalPage.openSearchedProduct(driver);				
				ProductPage.compositionTab();			

				if (testScenario.equalsIgnoreCase("S1")) {
					System.out.println("=================================================Scenario Execution starts for "
							+ testScenario);
					ProductPage.verifySortBy(driver, extendtest, productID, reports);
					Thread.sleep(5000);
					continue;
				} else if (testScenario.equalsIgnoreCase("S2")) {
					System.out.println("=================================================Scenario Execution starts for "
							+ testScenario);
					ProductPage.verifyCompositionAndMaterial(driver, extendtest, productID, reports);
					Thread.sleep(5000);
					continue;
				} else if (testScenario.equalsIgnoreCase("S3")) {
					System.out.println("=================================================Scenario Execution starts for "
							+ testScenario);
					ProductPage.addCompositionAndMaterial(driver, extendtest, productID, mode, article, composition,
							material, article1, composition1, material1, article2, composition2, material2, article3,
							composition3, material3, article4, composition4, material4, article5, composition5,
							material5, article6, composition6, material6, article7, composition7, material7, article8,
							composition8, material8, article9, composition9, material9, article10, composition10,
							material10, percentage, reports);
					Thread.sleep(5000);
					continue;
				} else if (testScenario.equalsIgnoreCase("S4")) {
					System.out.println("=================================================Scenario Execution starts for "
							+ testScenario);
					ProductPage.setFactsDone(driver, extendtest, productID, setFact1, setFact2, setFact3, setFact4,
							setFact5, setFact6, setFact7, setFact8, setFact9, setFact10, reports);
					Thread.sleep(5000);
					continue;
				}
				else if (testScenario.equalsIgnoreCase("S5")) {
					System.out.println("=================================================Scenario Execution starts for "
							+ testScenario);
					ProductPage.copyCompositionAndMaterial(driver, extendtest, productID, copy1, copy2, copy3, copy4,
							copy5, copy6, copy7, copy8, copy9, copy10, article1, composition1, material1, percentage,
							reports);
					Thread.sleep(5000);
					ArticlePage.verifyCompositionListInArticles(driver, extendtest, material1, percentage );
					
					continue;
				}
				else if (testScenario.equalsIgnoreCase("S6")) {
					System.out.println("=================================================Scenario Execution starts for "
							+ testScenario);
					ProductPage.deleteCompositionAndMaterial(driver, extendtest, productID, reports);
					Thread.sleep(5000);
					continue;
				}
				else {
					System.out.println(testScenario + " Not required");
				}
			}
			else {
				System.out.println("This data Row is Not required for "+testScenario+" and Execute Flag is not 'Y'");
			}

		}
		
		driver.quit();
	}

	
	/** Update long product name, short product name and long product decsription
	 * Update QC for print and verify locales sent for print is updated
	 * Update enrichment status to quality checked and verify locales sent for e-com
	 * Verify information level
	 * @author tempbasir
	 * Date: 2018-12-12
	 */
	public static void PIMDEV_2376(Connection connection, ExtentReports reports, ExtentTest extendtest) throws Exception {
		String infoLevel, execute, name, values = "";
		String longProductName, shortProductName, longProductDesc, dueDatePrint = "";
		int count = 0;

		String resultset1 = "Select * from PIMDEV_2376";
		String resultset2 = "Select * from CVL";
		Recordset recordset1 = connection.executeQuery(resultset1);
		Recordset recordset2 = connection.executeQuery(resultset2);

		driver = DriverInit.initiateDriver(reports);
		extendtest = reports.startTest("Verify Product Details page functionality - PART1");

		while (recordset1.next()) {
			infoLevel = recordset1.getField("Info level").trim();
			longProductName = recordset1.getField("Long Product Name").trim();
			shortProductName = recordset1.getField("Short Product Name").trim();
			longProductDesc = recordset1.getField("Long Product Desciption").trim();
			dueDatePrint = recordset1.getField("Due Date Print").trim();
			execute = recordset1.getField("Execute").trim();			

			if (execute.equalsIgnoreCase("Y")) {
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				if (count == 0) {
					PortalPage.clickEnrich();
				} else {
					PortalPage.clickTopHeaderTitle();
				}
			
				Thread.sleep(3000);
				PortalPage.openSearchQuery();
				PortalPage.productLevelQuery(infoLevel, driver, extendtest);
				String productID = PortalPage.openSearchedProduct(driver);
				extendtest.log(LogStatus.INFO, "Product: " + productID + " is selected");
				ProductPage.detailsTab();
				extendtest.log(LogStatus.INFO, "Navigated to Details tab");
				
				if(count==0){
					while (recordset2.next()) {
						name = recordset2.getField("Name").trim();
						values = recordset2.getField("Values").trim();											
						if (name.equalsIgnoreCase("Fieldset")) {
							ProductPage.verifyFieldset(driver, extendtest, values);
						}						
					}
					
					//extendtest.log(LogStatus.INFO, "Verify Locales sent for print and Information level is updated after setting QC for print");					
				} 
				//else{
			//		extendtest.log(LogStatus.INFO, "Verify Locales sent for e-com and Information level is updated after setting QC for e-com");
			//	}
				
				if(infoLevel.equalsIgnoreCase("Level zero")){
					extendtest.log(LogStatus.INFO, "<h6><b>Scenario 2: Verify Locales sent for print and Information level is updated after setting QC for print</b></h6>");
				}else if(infoLevel.equalsIgnoreCase("Level A")){
					extendtest.log(LogStatus.INFO, "<h6><b>Scenario 3: Verify Locales sent for e-com and Information level is updated after setting QC for e-com</b></h6>");
					
				}else{
					extendtest.log(LogStatus.FAIL, "Invalid infolevel in the data sheet, "
							+ "please provide either: 'Level zero' or 'Level A'");
				}
				
				ProductPage.updateLongProductName(driver, extendtest, longProductName);
				ProductPage.updateShortProductName(driver, extendtest, shortProductName);
				ProductPage.updateLongProductDesc(driver, extendtest, longProductDesc);
				if(infoLevel.equalsIgnoreCase("Level zero")){
					ProductPage.udpateLocalesSentForPrint(driver, extendtest);
					ProductPage.updateQCForPrint(driver, extendtest, dueDatePrint);
				} else if(infoLevel.equalsIgnoreCase("Level A")){
					ProductPage.udpateLocalesSentForECom(driver, extendtest);
					ProductPage.updateQCForECom(driver, extendtest);
				} else{
					extendtest.log(LogStatus.FAIL, "Invalid infolevel in the data sheet, "
							+ "please provide either: 'Level zero' or 'Level A'");
				}
				ProductPage.verifyLongProductName(driver, extendtest, longProductName);
				ProductPage.verifyShortProductName(driver, extendtest, shortProductName);
				ProductPage.verifyLongProductDesc(driver, extendtest, longProductDesc);
				if(infoLevel.equalsIgnoreCase("Level zero")){
					ProductPage.verifyLocalesSentForPrint(driver, extendtest);
				} else if(infoLevel.equalsIgnoreCase("Level A")){
					ProductPage.verifyLocalesSentForEcom(driver, extendtest);
				}			
				ProductPage.verifyInfoLevel(driver, extendtest, infoLevel);
				
				count++;
			}

		}
		driver.quit();
		
	}

	/** Verify Translation major change for products in Level A and Level B
	 * @author tempbasir
	 */
	public static void PIMDEV_2440(Connection connection, ExtentReports reports, ExtentTest extendtest) throws Exception {
		driver = DriverInit.initiateDriver(reports);
		extendtest = reports.startTest("Verify Product Details page functionality - PART2");	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		PortalPage.clickEnrich();	
		PortalPage.openSearchQuery();
		PortalPage.productQueryTransReceivedNotEmpty("Level A", driver, extendtest);
		String productID1 = PortalPage.openSearchedProduct(driver);
		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Verify Translation major change for a product having QC for print</b></h6>");
		extendtest.log(LogStatus.INFO, "Product: " + productID1 + " having QC for print is selected");
		ProductPage.detailsTab();
		extendtest.log(LogStatus.INFO, "Navigated to Details tab");	
	//	extendtest.log(LogStatus.INFO, "Verify Translation major change for product having QC for print");
		ProductPage.unCheckLocalesSent(driver, extendtest, "Print");
		ProductPage.selectTransMajorChange(driver, extendtest);		
		ProductPage.verifyTransMajorChange(driver, extendtest);	
		ProductPage.verifyLocales(driver, extendtest, "Print");
		PortalPage.clickTopHeaderTitle(); 		
		PortalPage.openSearchQuery(); 
		PortalPage.productQueryTransReceivedNotEmpty("Level B", driver, extendtest);
		String productID2 = PortalPage.openSearchedProduct(driver);
		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 2: Verify Translation major change for a product having QC for ecom</b></h6>");
		extendtest.log(LogStatus.INFO, "Product: " + productID2 + " having QC for ecom is selected");
		ProductPage.detailsTab();
		extendtest.log(LogStatus.INFO, "Navigated to Details tab");
	//	extendtest.log(LogStatus.INFO, "Verify Translation major change for product having QC for ecom");
		ProductPage.unCheckLocalesSent(driver, extendtest, "Ecom");
		ProductPage.selectTransMajorChange(driver, extendtest);		
		ProductPage.verifyTransMajorChange(driver, extendtest);	
		ProductPage.verifyLocales(driver, extendtest, "Ecom");		
		driver.quit();
	}

	/** Product page -RGB functionality 
	 * Verify Sort by values
	 * Verify swatch color and preview color is updated after clicking on color picker image
	 * @author tempbasir
	 */
	public static void PIMDEV_2377(Connection connection, ExtentReports reports, ExtentTest extendtest) throws Exception {
		String productID, executeProduct, name, values = "";
		int count = 0;

		String product = "Select * from PIMDEV_2377";
		String resultset2 = "Select * from CVL";
		
		Recordset productRecord = connection.executeQuery(product);
		Recordset recordset2 = connection.executeQuery(resultset2);

		driver = DriverInit.initiateDriver(reports);
		extendtest = reports.startTest("Verify RGB Page");

		while (productRecord.next()) {

			productID = productRecord.getField("ProductID").trim();
			executeProduct = productRecord.getField("Execute").trim();

			if (executeProduct.equalsIgnoreCase("Y")) {
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				if (count == 0) {
					PortalPage.clickEnrich();
				} else {
					PortalPage.clickTopHeaderTitle();
				}
							
				EnrichPage.searchProduct(productID);
				PortalPage.openSearchedProduct(driver);
				extendtest.log(LogStatus.INFO, "Product: " + productID + " is found");
				ProductPage.rgbTab();
				extendtest.log(LogStatus.INFO, "Navigated to RGB tab");
				
				if(count==0){
					while (recordset2.next()) {
						name = recordset2.getField("Name").trim();
						values = recordset2.getField("Values").trim();											
						if (name.equalsIgnoreCase("RGB_SortBy")) {
							ProductPage.verifyRGBSortBy(driver, extendtest, values);
						}						
					}
				}
				ProductPage.verifyColorPicker(driver, extendtest);
				
				count++;
			}

		}
		driver.quit();	
		
	}

	/**Set measurement values and verify if the values are updated
	 * Verify when 'Clear all fields' option is selected then measurement values are removed
	 * Verify when 'No measurements to enrich' field is  checked/unchecked, then in Details tab the field 'No measurement' is accordingly set to True/False
	 * @author tempbasir 
	 */
	public static void PIMDEV_2381(Connection connection, ExtentReports reports, ExtentTest extendtest) throws Exception {
		String area, position,override, execute = "";
		String screenShotPath1, screenShotPath2;
		int count = 1;

		String product = "Select * from PIMDEV_2381";		
		Recordset recordset = connection.executeQuery(product);

		driver = DriverInit.initiateDriver(reports);
		extendtest = reports.startTest("Verify Measurement Page");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		PortalPage.clickEnrich();
		PortalPage.openSearchQuery();
		PortalPage.productsWithMeasurementQuery();
		String productID1 = PortalPage.openSearchedProduct(driver);
		extendtest.log(LogStatus.INFO, "Product: " + productID1 + " is selected");
		ProductPage.measurementTab();
		extendtest.log(LogStatus.INFO, "Navigated to Measurement tab");	
		driver.switchTo().frame("context-editor-iframe");		
		Thread.sleep(1000);
		screenShotPath1 = PortalPage.addScreenshot(driver);
		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Update the measurement values and verify if it is updated</b></h6>");		
		extendtest.log(LogStatus.INFO,
				"Screenshot before updating the measurements: " + extendtest.addScreenCapture(screenShotPath1));
		Thread.sleep(1000);		
		ProductPage.selectSelectedSize(driver, extendtest);
		
		while (recordset.next()) {
			area = recordset.getField("Measurement area").trim();
			position = recordset.getField("Selected position").trim();
			override = recordset.getField("Override cm").trim();
			execute = recordset.getField("Execute").trim();
			if (execute.equalsIgnoreCase("Y")) {
				ProductPage.updateMeasurements(area.toLowerCase(),position.toLowerCase(),override, driver, extendtest, count);
				
				count++;
			}
		}
		
		extendtest.log(LogStatus.INFO, "Update Measurement and Saving the product");
		Locators.getID(SaveButton).click();
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(8000);
		screenShotPath2 = PortalPage.addScreenshot(driver);
		extendtest.log(LogStatus.PASS, "Measurement updated successfully. Screenshot below: " + extendtest.addScreenCapture(screenShotPath2));
		Thread.sleep(1000);		
		ProductPage.detailsTab();
		ProductPage.verifyMeasurementInCm(driver, extendtest);		
		ProductPage.measurementTab();
		driver.switchTo().frame("context-editor-iframe");	
		ProductPage.clearMeasurements(driver, extendtest);
		Boolean checked = ProductPage.verifyNoMeasurementsToEnrich(driver, extendtest);	
		driver.switchTo().defaultContent();
		ProductPage.detailsTab();
		ProductPage.verifyNoMeasurementsInDetailsPage(driver, extendtest, checked);		
		ProductPage.measurementTab();
		driver.switchTo().frame("context-editor-iframe");	
		Boolean flag = ProductPage.setNoMeasurementsToEnrich(driver, extendtest,checked);
		driver.switchTo().defaultContent();
		ProductPage.detailsTab();
		ProductPage.verifyNoMeasurementsInDetailsPage(driver, extendtest, flag);
		
		driver.quit();	
		
	}

	/** Verify Hazmat values for the product is the aggregation from all of its linked articles and with no duplicates
	 *  Verify 'Add warning type' function 
	 *  Verifying product warning type is updated to Safety information attribute in all linked articles
	 * @author tempbasir
	 */
	public static void PIMDEV_2380(Connection connection, ExtentReports reports, ExtentTest extendtest) throws Exception {
		String productID,addWarningType, executeProduct, warningJSON = "";
		int count = 0;

		String product = "Select * from PIMDEV_2380";		
		Recordset productRecord = connection.executeQuery(product);

		driver = DriverInit.initiateDriver(reports);
		extendtest = reports.startTest("Verify Warning Page"); 

		while (productRecord.next()) {
			productID = productRecord.getField("ProductID").trim();
			addWarningType = productRecord.getField("Add warning type").trim();
			warningJSON = productRecord.getField("Warning JSON to verify").trim();
			executeProduct = productRecord.getField("Execute").trim(); 

			if (executeProduct.equalsIgnoreCase("Y")) {
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				if (count == 0) {
					PortalPage.clickEnrich();
				} else {
					PortalPage.clickTopHeaderTitle();
				}
							
				EnrichPage.searchProduct(productID);
				PortalPage.openSearchedProduct(driver);
				extendtest.log(LogStatus.INFO, "Product: " + productID + " is found");			
				Thread.sleep(2000);
				ProductPage.includesTab();
				extendtest.log(LogStatus.INFO, "Navigating to Includes page");
				ArticlePage.verifyHazmatValues(driver, extendtest);
				Thread.sleep(2000);
				ProductPage.verifyAddWarmningType(driver, extendtest, addWarningType);
				driver.switchTo().defaultContent();
				ProductPage.detailsTab();
				extendtest.log(LogStatus.INFO, "<h6><b>Scenario 3: Verify 'Warning' attribute in Details page is updated</b></h6>");
				extendtest.log(LogStatus.INFO, "Navigating to Details page");
				Thread.sleep(2000);
				String productWarning = ProductPage.verifyProductWarningUpdated(driver, extendtest, warningJSON);
				ProductPage.includesTab();
				extendtest.log(LogStatus.INFO, "<h6><b>Scenario 4: Verify product warnings is reflected back on all linked articles in Safety information attribute</b></h6>");
				extendtest.log(LogStatus.INFO, "Navigating to Includes page");
				ArticlePage.verifySafetyInfo(driver, extendtest, productWarning);				
				ProductPage.warningTab();	
				extendtest.log(LogStatus.INFO, "<h6><b>Scenario 5: Remove Warning type from product and verify 'Warning' attribute in Details page is updated</b></h6>");
				extendtest.log(LogStatus.INFO, "Navigating to Warning page");
				ProductPage.removeWarningType(driver, extendtest,addWarningType);
				driver.switchTo().defaultContent();
				ProductPage.detailsTab();
				extendtest.log(LogStatus.INFO, "Navigating to Details page to verify warning attribute updated");
				Thread.sleep(2000);
				ProductPage.verifyProductWarningRemoved(driver, extendtest, warningJSON);
				
				count++;
			}
		}
		
		driver.quit();
		
	}

	/**Verify Used In is having value as 'HM_ICC_Channel' if product is in QC status
	 * Verify Used In is having value as 'Not used in any channel' if product is NOT in QC status
	 * Verify the media image displayed under Media heading is same as in Media tab
	 * @author tempbasir
	 */
	public static void PIMDEV_2375(Connection connection, ExtentReports reports, ExtentTest extendtest) throws Exception {
		String productID, executeProduct = "";
		String screenShotPath1,screenShotPath2 ="";
		
		String product = "Select * from PIMDEV_2375";		
		Recordset productRecord = connection.executeQuery(product);

		driver = DriverInit.initiateDriver(reports);
		extendtest = reports.startTest("Verify Overview Page");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		PortalPage.clickEnrich();
		PortalPage.openSearchQuery();
		PortalPage.qualityCheckedProductsQuery(driver, extendtest);
		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Select products which is in QC status and Verify whether 'Used In' attribute is set as 'HM_ICC_Channel'</b></h6>");
		productID = PortalPage.openSearchedProduct(driver);
		ProductPage.verifyProductInICCChannel(driver, extendtest, productID);
		PortalPage.clickTopHeaderTitle();
		PortalPage.openSearchQuery();
		PortalPage.notQCProductsQuery(driver, extendtest);
		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 2: Select products which is NOT in QC status and Verify whether 'Used In' attribute is set as 'Not used in any channel'</b></h6>");
		productID = PortalPage.openSearchedProduct(driver);
		ProductPage.verifyProductNotUsedInChannel(driver, extendtest, productID);
		ProductPage.detailsTab();
		ProductPage.updateQCForECom(driver, extendtest);
		ProductPage.overviewTab();
		ProductPage.verifyChannelUpdated(driver, extendtest);
		
		while (productRecord.next()) {
			productID = productRecord.getField("ProductID").trim();
			executeProduct = productRecord.getField("Execute").trim(); 

			if (executeProduct.equalsIgnoreCase("Y")) {
				extendtest.log(LogStatus.INFO, "<h6><b>Scenario 4: Verify Media images is same in Overview page and Media page for a product</b></h6>");
				PortalPage.clickTopHeaderTitle();
				EnrichPage.searchProduct(productID);
				PortalPage.openSearchedProduct(driver);		
				Thread.sleep(2000);
				screenShotPath1 = PortalPage.addScreenshot(driver);
				extendtest.log(LogStatus.PASS,
						"Media images in Overview page, screenshot see below " + extendtest.addScreenCapture(screenShotPath1));
				ProductPage.MediaTab();
				screenShotPath2 = PortalPage.addScreenshot(driver);
				extendtest.log(LogStatus.PASS,
						"Media images in Media page , screenshot see below " + extendtest.addScreenCapture(screenShotPath2));
				Thread.sleep(3000);
				
			}

		}
		
		driver.quit();
		
	}



}
