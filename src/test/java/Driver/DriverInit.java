package Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.ArticlePage;
import Pages.EnrichPage;
import Pages.PortalPage;
import Pages.ProductPage;
import Pages.RelatedArticlePage;
import Pages.Select;
import Scripts.RegressionSuite_v1;
import Utils.ExtentManager;
import Utils.Locators;
import Utils.commons;
import Utils.webElements;

public class DriverInit implements webElements {
	static String workingDir = System.getProperty("user.dir");
	static ExtentReports reports;
	static ExtentTest extendtest;
	static ExtentManager extentManager;
	static WebDriver driver ;
	Fillo fillo = new Fillo();
	static Connection connection;
	static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	static String Filename = "RegressionSuite_" + timeStamp + ".html";

	@BeforeTest
	public void initiateReport() throws Exception {
		reports = ExtentManager.getReporter("RegressionSuite_" + timeStamp);
		connection = fillo.getConnection(workingDir + "\\src\\test\\resources\\DataExcel\\Data.xlsx");	
	}

	// Read Modules sheet from input data xml and execute only the user stories which are marked as 'Y'
	@Test
	public static void startSuite() throws Exception {
		String Modules, Execute;
		String strQuery = "Select * from Modules";
		Recordset recordset = connection.executeQuery(strQuery);
		driver = DriverInit.initiateDriver(reports); 		

		while (recordset.next()) {
			Modules = recordset.getField("Modules");
			Execute = recordset.getField("Execute");

			if (Execute.equalsIgnoreCase("Y")) {
				if (Modules.equalsIgnoreCase("PIMDEV_2382")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_2382(driver);
					Thread.sleep(5000);
				} else	if (Modules.equalsIgnoreCase("PIMDEV_2382_NBO")) {
						System.out.println(
								"=================================================Module Execution starts for " + Modules);
						PIMDEV_2382_NBO(driver);
						Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("VerifyWorkArea")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					RegressionSuite_v1.verifyWorkarea(connection, reports, extendtest);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_2378")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_2378(driver);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_Comp")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_Comp(driver);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_2376")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_2376(driver);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_RCTE")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_RCTE(driver);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_2440")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_2440(driver);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_2377")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_2377(driver);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_2381")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_2381(driver);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_2380")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_2380(driver);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_CBS")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_CBS(driver);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_Flower")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_Flower(driver);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_Color")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_Colorshades(driver);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_Sust")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_Sust(driver);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_2375")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_2375(driver);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_2961")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_2961(driver);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_2374")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_2374(driver);
					Thread.sleep(5000);
					continue;
				} else if (Modules.equalsIgnoreCase("PIMDEV_2357")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_2357(driver);
					Thread.sleep(5000);
					continue;			
				} else if (Modules.equalsIgnoreCase("PIMDEV_2358")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_2358(driver);
					Thread.sleep(5000);
					continue;			
				} else if (Modules.equalsIgnoreCase("PIMDEV_2383")) {
					System.out.println(
							"=================================================Module Execution starts for " + Modules);
					PIMDEV_2383(driver);
					Thread.sleep(5000);
					continue;			
				} else if (Modules.equalsIgnoreCase("RegressionSuite")) {
					System.out.println(
							"=================================================Regression Suite Execution starts");
					PIMDEV_2382(driver);
					Thread.sleep(5000);
					PIMDEV_2382_NBO(driver);
					Thread.sleep(5000);
					PIMDEV_2378(driver);
					Thread.sleep(5000);
					PIMDEV_2376(driver);
					Thread.sleep(5000);
					PIMDEV_RCTE(driver);
					Thread.sleep(5000);
					PIMDEV_2440(driver);
					Thread.sleep(5000);
					PIMDEV_2377(driver);
					Thread.sleep(5000);
					PIMDEV_2381(driver);
					Thread.sleep(5000);
					PIMDEV_2380(driver);
					Thread.sleep(5000);
					PIMDEV_2375(driver);
					Thread.sleep(5000);
					PIMDEV_2961(driver);
					Thread.sleep(5000);
					PIMDEV_2374(driver);
					Thread.sleep(5000);
					PIMDEV_2357(driver);
					Thread.sleep(5000);
					PIMDEV_2358(driver);
					Thread.sleep(5000);
					PIMDEV_2383(driver);
				//	verifyWorkarea(driver);
				//	Thread.sleep(5000);
					
					continue;
				}

			} else {
				System.out.println(Modules + " Not required");
			}
			
		}

		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

	
	public static WebDriver initiateDriver(ExtentReports reports) throws Exception {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream(workingDir + "\\config.xml");
		prop.loadFromXML(input);
//		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		WebDriver driver = new ChromeDriver(options);
		//driver.get(prop.getProperty("PIMTEST1URL"));
		driver.get(prop.getProperty("BLUESTONE"));
		driver.manage().window().maximize();
		login(driver, prop, reports);
		return driver;
	}

	// Login to inRiver portal with username and password from config.xml
	//Somnath //
	@SuppressWarnings("unused")
	public static void login(WebDriver driver, Properties prop, ExtentReports reports) throws Exception {
		//ExtentTest extendtest;
		String username = prop.getProperty("Username");
		String pwd = prop.getProperty("Password");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Locators loc = new Locators(driver);
		Locators.getName(Username).sendKeys(username);
		Locators.getName(next).click();
		Locators.getName(Password).sendKeys(pwd);
		Locators.getCSS(Submit).click();
		Thread.sleep(5000);
		Locators.getXPath(Auth).sendKeys(username);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);

	//	extendtest.log(LogStatus.PASS, "Login was successful");
	//	reports.endTest(extendtest);
		// reports.flush();
		// driver.close();

	}

	@AfterTest(alwaysRun = true)
	protected void tearDown() throws IOException, InterruptedException {
		reports.endTest(extendtest);
		System.out.println("Insode teardown....");
		reports.flush();	
		Thread.sleep(5000);	
	//	commons.sendMail(Filename); // Trigger mail with attached report after running the automation
		driver = null;
		driver.quit();
	}
	
	
	/** Verify Product Magnifier functionality
	 * @author tempbasir
	 * Date:2018-07-03
	 */
	public static void PIMDEV_2382(WebDriver driver) throws Exception {

		String productID, executeProduct = "";
		String screenShotPath="";
		String screenShotPath1="";
		int count = 0;
		String product = "Select * from PIMDEV_2382";
		Recordset productRecord = connection.executeQuery(product);
		extendtest = reports.startTest("Verify Image Functionality");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try{	
			while (productRecord.next()) {
				productID = productRecord.getField("ProductID").trim();
				executeProduct = productRecord.getField("Execute").trim();	
				if (executeProduct.equalsIgnoreCase("Y")) {
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//					if (count == 0) {
//						PortalPage.clickEnrich();
//						Thread.sleep(5000);
//					} else {
//						PortalPage.clickTopHeaderTitle();
//						Thread.sleep(2000);
//					}
					count++;
					driver.findElement(By.xpath("//*[@class='_3Efai _3yT8z _1RbeD']")).click();
					Thread.sleep(4000);
					driver.findElement(By.xpath("(//*[@class='buc_FyYZI'])[1]")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//*[@class='buc_L03xs'])[1]")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//*[@class='_1cg7s'])[1]")).click();
//					EnrichPage.searchProduct(productID);
//					PortalPage.openSearchedProduct(driver);
					extendtest.log(LogStatus.INFO, "Asset Article is Present ");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@class='quZi3']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@class='buc_Loldq']")).click();
					Thread.sleep(3000);
					extendtest.log(LogStatus.INFO, "Click On Asset");
					Thread.sleep(3000);	
					screenShotPath1 = PortalPage.addScreenshot(driver);
					extendtest.log(LogStatus.PASS,
							"Article with Asset " + extendtest.addScreenCapture(screenShotPath1));
					driver.findElement(By.xpath("//*[@class='buc_PJCz2 buc_V2CvC OREP_']")).click();
					Thread.sleep(3000);
					screenShotPath = PortalPage.addScreenshot(driver);
					extendtest.log(LogStatus.PASS,
							"Snapshot of zoomed picture: " + extendtest.addScreenCapture(screenShotPath));
					driver.findElement(By.xpath("//*[@id ='PRODUCTS']")).click();
					Thread.sleep(3000);
					//ProductPage.magnifierTab();
					//extendtest.log(LogStatus.INFO, "Navigated to Magnifier tab");
				//	ProductPage.verifyMagnifier(driver, extendtest, productID);
				}	
				continue;
			}
			ProductPage.returnPortal();
		}
		
		catch(Exception e){
			e.printStackTrace();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}
	}
	
	
	//SOMNATH
	
	
	public static void PIMDEV_2382_NBO(WebDriver driver) throws Exception {

		String productID, executeProduct = "";
		int count = 0;
		String product = "Select * from PIMDEV_2382_NBO";
		Recordset productRecord = connection.executeQuery(product);
		extendtest = reports.startTest("Verify Magnifier Functionality For NBO");
		
		try{	
			while (productRecord.next()) {
				productID = productRecord.getField("ProductID").trim();
				executeProduct = productRecord.getField("Execute").trim();	
				if (executeProduct.equalsIgnoreCase("Y")) {
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
				continue;
			}
			ProductPage.returnPortal();
		}
		
		catch(Exception e){
			e.printStackTrace();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}
	}
	
	
	
	/**  Verify workarea folders for error message
	 *  @author tempbasir
	 *  Date: 2018-07-03
	 */
	public static void verifyWorkarea(WebDriver driver) throws Exception {
		extendtest = reports.startTest("Verify Workarea");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try{
			PortalPage.clickEnrich();
			EnrichPage.verifyWorkarea(driver, extendtest);
			ProductPage.returnPortal();
		}
		catch(Exception e){
			e.printStackTrace();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}
	}

	/** Verify Composition for the products
	 * Created by: Thangavel V
	 */
	public static void PIMDEV_2378(WebDriver driver) throws Exception {
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
		extendtest = reports.startTest("Verify Composition and Material Functionality");
		
		try{
			
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
					Thread.sleep(3000);
	
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
	
				continue;
				
			}
			ProductPage.returnPortal();
		}
		
		catch(Exception e){
			e.printStackTrace();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}
	}

	
	/** Update long product name, short product name and long product decsription
	 * Update QC for print and verify locales sent for print is updated
	 * Update enrichment status to quality checked and verify locales sent for e-com
	 * Verify information level
	 * @author tempbasir
	 * Date: 2018-12-12
	 */
	public static void PIMDEV_2376(WebDriver driver) throws Exception {
		
		String infoLevel, execute, name, values = "";
		String longProductName, shortProductName, longProductDesc, dueDatePrint = "";
		int count = 0;
		String resultset1 = "Select * from PIMDEV_2376";
		String resultset2 = "Select * from CVL";
		Recordset recordset1 = connection.executeQuery(resultset1);
		Recordset recordset2 = connection.executeQuery(resultset2);
		
		extendtest = reports.startTest("Verify Product Details page functionality - PART1");
		
		try{
			
			while (recordset1.next()) {
				infoLevel = recordset1.getField("Info level").trim();
				longProductName = recordset1.getField("Long Product Name").trim();
				shortProductName = recordset1.getField("Short Product Name").trim();
				longProductDesc = recordset1.getField("Long Product Desciption").trim();
				dueDatePrint = recordset1.getField("Due Date Print").trim();
				execute = recordset1.getField("Execute").trim();			
	
				if (execute.equalsIgnoreCase("Y")) {
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					if (count == 0) {
						PortalPage.clickEnrich();
						Thread.sleep(3000);
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
								ProductPage.verifyFieldset(driver, extendtest, values); }						
						}			
					} 
					
					if(infoLevel.equalsIgnoreCase("Level zero")){
						extendtest.log(LogStatus.INFO, "<h6><b>Scenario 2: Verify Locales sent for print and Information level is updated after setting QC for print</b></h6>");
					}else if(infoLevel.equalsIgnoreCase("Level A")){
						extendtest.log(LogStatus.INFO, "<h6><b>Scenario 3: Verify Locales sent for e-com and Information level is updated after setting QC for e-com</b></h6>");					
					}else{
						extendtest.log(LogStatus.FAIL, "Invalid infolevel in the data sheet, "
								+ "please provide either: 'Level zero' or 'Level A'");
					}
					
					ProductPage.updateLongProductName(driver, extendtest, longProductName);
					//ProductPage.updateShortProductName(driver, extendtest, shortProductName);
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
				
				continue;
			}
			ProductPage.returnPortal();
		}
			catch(Exception e){
			e.toString();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}
	}
			
		//SomnathRICHTEXTEDITOR	
		
		public static void PIMDEV_RCTE(WebDriver driver) throws Exception {
			
			String infoLevel, execute, name, values = "";
			String longProductName, longProductDesc= "";
			int count = 0;
			String resultset1 = "Select * from PIMDEV_RCTE";
			String resultset2 = "Select * from CVL";
			Recordset recordset1 = connection.executeQuery(resultset1);
			Recordset recordset2 = connection.executeQuery(resultset2);
			
			extendtest = reports.startTest("Verify Product RichTextEditor page functionality");
			
			try{
				
				while (recordset1.next()) {
					infoLevel = recordset1.getField("Info level").trim();
					longProductName = recordset1.getField("Long Product Name1").trim();
					//shortProductName = recordset1.getField("Short Product Name").trim();
					longProductDesc = recordset1.getField("Long Product Desciption1").trim();
					//dueDatePrint = recordset1.getField("Due Date Print").trim();
					execute = recordset1.getField("Execute").trim();			
		
					if (execute.equalsIgnoreCase("Y")) {
						driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
						
						if (count == 0) {
							PortalPage.clickEnrich();
						} else {
							PortalPage.clickTopHeaderTitle();
						}
					
						Thread.sleep(3000);
						PortalPage.openSearchQuery1();
						PortalPage.productLevelQuery1(infoLevel, driver, extendtest);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						Thread.sleep(5000);
						String productID = PortalPage.openSearchedProduct1(driver);
						extendtest.log(LogStatus.INFO, "Product: " + productID + " is selected");
						ProductPage.detailsTab();
						extendtest.log(LogStatus.INFO, "Navigated to Details tab");
						
						if(count==0){
							while (recordset2.next()) {
								name = recordset2.getField("Name").trim();
								values = recordset2.getField("Values").trim();											
								if (name.equalsIgnoreCase("Fieldset")) {
									ProductPage.verifyFieldset(driver, extendtest, values); }						
							}			
						} 
						
						if(infoLevel.equalsIgnoreCase("Level zero")){
							extendtest.log(LogStatus.INFO, "<h6><b>Scenario 2: Verify Locales sent for print and Information level is updated after setting QC for print</b></h6>");
						}else if(infoLevel.equalsIgnoreCase("Level A")){
							extendtest.log(LogStatus.INFO, "<h6><b>Scenario 3: Verify Locales sent for e-com and Information level is updated after setting QC for e-com</b></h6>");					
						}else{
							extendtest.log(LogStatus.FAIL, "Invalid infolevel in the data sheet, "
									+ "please provide either: 'Level zero' or 'Level A'");
						}
						
						ProductPage.updateLongProductName1(driver, extendtest, longProductName);
						//ProductPage.updateShortProductName(driver, extendtest, shortProductName);
						ProductPage.updateLongProductDesc1(driver, extendtest, longProductDesc);
						//Locators.getID(DetailTab).click();
						//Locators.getXPath(DetailTabRCTE).click();
						Thread.sleep(3000);
						if(infoLevel.equalsIgnoreCase("Level zero")){
							//ProductPage.udpateLocalesSentForPrint(driver, extendtest);
						//ProductPage.updateQCForPrint(driver, extendtest, dueDatePrint);
						} else if(infoLevel.equalsIgnoreCase("Level A")){
							//ProductPage.udpateLocalesSentForECom(driver, extendtest);
							//ProductPage.updateQCForECom(driver, extendtest);
						} else{
							//extendtest.log(LogStatus.FAIL, "Invalid infolevel in the data sheet, "
									//+ "please provide either: 'Level zero' or 'Level A'");
						}
						//ProductPage.verifyLongProductName2(driver, extendtest, longProductName);
						//ProductPage.verifyShortProductName(driver, extendtest, shortProductName);
						//ProductPage.verifyLongProductDesc(driver, extendtest, longProductDesc);
						if(infoLevel.equalsIgnoreCase("Level zero")){
							//ProductPage.verifyLocalesSentForPrint(driver, extendtest);
						} else if(infoLevel.equalsIgnoreCase("Level A")){
							//ProductPage.verifyLocalesSentForEcom(driver, extendtest);
						}			
						//ProductPage.verifyInfoLevel(driver, extendtest, infoLevel);
						
						count++;
					}
					
					continue;
				}
				ProductPage.returnPortal();
			}
				catch(Exception e){
				//e.toString();
				//extendtest.log(LogStatus.FAIL, e.getMessage());
				ProductPage.returnPortal();
			}
		}
						

					

	/** Verify Translation major change for products in Level A and Level B
	 * @author tempbasir
	 */
	public static void PIMDEV_2440(WebDriver driver) throws Exception {		
		try{
			extendtest = reports.startTest("Verify Product Details page functionality - PART2");	
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			PortalPage.clickEnrich();	
			PortalPage.openSearchQuery();
		/**	
		 * Commented for level A because print related fields is moved out and hided in pim
		 * 	PortalPage.productQueryTransReceivedNotEmpty("Level A", driver, extendtest);
			String productID1 = PortalPage.openSearchedProduct(driver);
			extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Verify Translation major change for a product having QC for print</b></h6>");
			extendtest.log(LogStatus.INFO, "Product: " + productID1 + " having QC for print is selected");
			ProductPage.detailsTab();
			extendtest.log(LogStatus.INFO, "Navigated to Details tab");	
			ProductPage.unCheckLocalesSent(driver, extendtest, "Print");
			ProductPage.selectTransMajorChange(driver, extendtest);		
			ProductPage.verifyTransMajorChange(driver, extendtest);	
			ProductPage.verifyLocales(driver, extendtest, "Print");
			PortalPage.clickTopHeaderTitle(); 		
			PortalPage.openSearchQuery(); **/ 
			PortalPage.productQueryTransReceivedNotEmpty("Level B", driver, extendtest);
			//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			String productID2 = PortalPage.openSearchedProduct(driver);
			extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Verify Translation major change for a product having QC for ecom</b></h6>");
			extendtest.log(LogStatus.INFO, "Product: " + productID2 + " having QC for ecom is selected");
			ProductPage.detailsTab();
			Thread.sleep(8000);
			extendtest.log(LogStatus.INFO, "Navigated to Details tab");
			//ProductPage.unCheckLocalesSent(driver, extendtest, "Ecom");
			ProductPage.selectTransMajorChange(driver, extendtest);		
			ProductPage.verifyTransMajorChange(driver, extendtest);	
			//ProductPage.verifyLocales(driver, extendtest, "Ecom");		
			
			ProductPage.returnPortal();
		}
		catch(Exception e){
			e.toString();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}
	}

	/** Product page -RGB functionality 
	 * Verify Sort by values
	 * Verify swatch color and preview color is updated after clicking on color picker image
	 * @author tempbasir
	 */
	public static void PIMDEV_2377(WebDriver driver) throws Exception {
		String productID, executeProduct, name, values = "";
		int count = 0;
		String product = "Select * from PIMDEV_2377";
		String resultset2 = "Select * from CVL";		
		Recordset productRecord = connection.executeQuery(product);
		Recordset recordset2 = connection.executeQuery(resultset2);

		extendtest = reports.startTest("Verify RGB Page");
		
		try{			
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
				continue;
			}	
			ProductPage.returnPortal();
		}
		
		catch(Exception e){
			e.printStackTrace();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}
	}

	/**Set measurement values and verify if the values are updated
	 * Verify when 'Clear all fields' option is selected then measurement values are removed
	 * Verify when 'No measurements to enrich' field is  checked/unchecked, then in Details tab the field 'No measurement' is accordingly set to True/False
	 * @author tempbasir 
	 */
	public static void PIMDEV_2381(WebDriver driver) throws Exception {
		String area, position,override, execute = "";
		String screenShotPath2;
		int count = 1;

		String product = "Select * from PIMDEV_2381";		
		Recordset recordset = connection.executeQuery(product);
		extendtest = reports.startTest("Verify Measurement Page");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		try{
			
			PortalPage.clickEnrich();
			PortalPage.openSearchQuery();
			PortalPage.productsWithMeasurementQuery();
			String productID1 = PortalPage.openSearchedProduct(driver);
			extendtest.log(LogStatus.INFO, "Product: " + productID1 + " is selected");
			ProductPage.measurementTab();
			driver.navigate().refresh();
			Thread.sleep(12000);
			extendtest.log(LogStatus.INFO, "Navigated to Measurement tab");	
			driver.switchTo().frame("context-editor-iframe");		
			Thread.sleep(2000);
			extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Update the measurement values and verify if it is updated</b></h6>");		
			Thread.sleep(2000);		
			//ProductPage.selectSelectedSize(driver, extendtest);
			
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
			
			extendtest.log(LogStatus.INFO, "Updating Measurement and Saving the product");			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(-0, 350)");
			Locators.getXPath(SaveButton).click();
			Thread.sleep(4000);
			driver.navigate().refresh();
			Thread.sleep(12000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0, 350)");
			screenShotPath2 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS, "Measurement updated successfully. Screenshot below: " + extendtest.addScreenCapture(screenShotPath2));
			Thread.sleep(8000);		
			ProductPage.detailsTab();
			Thread.sleep(8000);
			ProductPage.verifyMeasurementInCm(driver, extendtest);	
			Thread.sleep(8000);
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
			ProductPage.returnPortal();
		}
		
		catch(Exception e){
			e.printStackTrace();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}	
	}

	/** Verify Hazmat values for the product is the aggregation from all of its linked articles and with no duplicates
	 *  Verify 'Add warning type' function 
	 *  Verifying product warning type is updated to Safety information attribute in all linked articles
	 * @author tempbasir
	 */
	public static void PIMDEV_2380(WebDriver driver) throws Exception {
		String productID,addWarningType, executeProduct, warningJSON = "";
		int count = 0;
		String product = "Select * from PIMDEV_2380";		
		Recordset productRecord = connection.executeQuery(product);

		extendtest = reports.startTest("Verify Warning Page"); 
		
		try{
			
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
					Thread.sleep(5000);
					ProductPage.includesTab();
					Thread.sleep(5000);
					extendtest.log(LogStatus.INFO, "Navigating to Includes page");
					ArticlePage.verifyHazmatValues(driver, extendtest);
					Thread.sleep(5000);
					ProductPage.verifyAddWarmningType(driver, extendtest, addWarningType);
					driver.switchTo().defaultContent();
					ProductPage.detailsTab();
					extendtest.log(LogStatus.INFO, "<h6><b>Scenario 3: Verify 'Warning' attribute in Details page is updated</b></h6>");
					extendtest.log(LogStatus.INFO, "Navigating to Details page");
					Thread.sleep(5000);
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
				
				continue;
			}
			ProductPage.returnPortal();
		}
		
		catch(Exception e){
			e.toString();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}		
	}
//////////////////////////////////////// Somnath CBS/////////////////////////////////////////////////////////////
	
	public static void PIMDEV_CBS (WebDriver driver) throws Exception {
				//String screenShotPath2= "";
				try
				{
				driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				extendtest = reports.startTest("Verify CBS Funtionality");
					PortalPage.clickEnrich();
					PortalPage.clickTopHeaderTitle();
					Thread.sleep(5000);
					PortalPage.openSearchQuery2();
					PortalPage.productLevelQuery2();
					String ArticleID = PortalPage.openSearchedProduct2(driver);
					extendtest.log(LogStatus.INFO, "Article: " + ArticleID + " is selected");
					ProductPage.detailsTab();
					ArticlePage.MarkCBS(driver, extendtest);				
//					PortalPage.CBSEnrich(driver, extendtest);
//					extendtest.log(LogStatus.INFO, "Article ID is Marked as CBS");
//					Thread.sleep(3000);
//					ProductPage.detailsTab();
//					PortalPage.articlecbsScreen();
//					screenShotPath2 = PortalPage.addScreenshot(driver);
//					extendtest.log(LogStatus.PASS, "Article Screenshot" + extendtest.addScreenCapture(screenShotPath2));
//					driver.navigate().refresh();
//					ProductPage.overviewTab();
//					extendtest.log(LogStatus.INFO, "Article is marked as CBS Navigated to Overview");
					
	
//					Thread.sleep(3000);
//					extendtest.log(LogStatus.INFO, "Navigated to Details tab to check either Marked as CBS");
//					Thread.sleep(3000);
//					ProductPage.detailsTab();
//					Thread.sleep(3000);
//					PortalPage.articlecbsScreen();
//					screenShotPath2 = PortalPage.addScreenshot(driver);
//					extendtest.log(LogStatus.PASS, "Article is marked as CBS " + extendtest.addScreenCapture(screenShotPath2));
//					ProductPage.overviewTabCBS();
//					extendtest.log(LogStatus.INFO, "Navigated to Overview page");
//					Thread.sleep(3000);
					//driver.switchTo().defaultContent();
					

			
			ProductPage.returnPortal();
		}
			catch(Exception e){
			e.toString();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}
	}
		
	
	/////////////////////////SOmnath Flowers n plants ////////////////////////////////////////////////////
	
	public static void PIMDEV_Flower(WebDriver driver) throws Exception {
				//String screenShotPath2= "";
				try
				{
				driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				extendtest = reports.startTest("Verify Flowers and Plants Funtionality");
					PortalPage.clickEnrich();
					PortalPage.clickTopHeaderTitle();
					Thread.sleep(5000);
					PortalPage.openSearchQuery2();
					PortalPage.productLevelQuery3();
					String ArticleID = PortalPage.openSearchedProduct2(driver);
					extendtest.log(LogStatus.INFO, "Article: " + ArticleID + " is selected");
					ProductPage.detailsTab();
					ArticlePage.FlowernPlants(driver, extendtest);				
								Thread.sleep(3000);	
			
			ProductPage.returnPortal();
		}
			catch(Exception e){
			e.toString();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}
	}
	
	
	//////////////////////////Somnath Color n Shades ////////////////////////////////////
	
	
	public static void PIMDEV_Colorshades(WebDriver driver) throws Exception {
		//String screenShotPath2= "";
		try
		{
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		extendtest = reports.startTest("Verify Colors and Shades Funtionality");
			PortalPage.clickEnrich();
			PortalPage.clickTopHeaderTitle();
			Thread.sleep(5000);
			PortalPage.openSearchQuery2();
			Thread.sleep(5000);
			PortalPage.productLevelQuery4();
			Thread.sleep(5000);
			String ArticleID = PortalPage.openSearchedProduct2(driver);
			Thread.sleep(5000);
			extendtest.log(LogStatus.INFO, "Article: " + ArticleID + " is selected");
			ProductPage.detailsTab();
			Thread.sleep(5000);
			Thread.sleep(5000);
			ArticlePage.ClornShades(driver, extendtest);				
		//	PortalPage.CBSEnrich(driver, extendtest);
			//extendtest.log(LogStatus.INFO, "Article Has Flowers and Plants Data");
			Thread.sleep(3000);
			//ProductPage.detailsTab();
			//PortalPage.articlecbsScreen();
//			screenShotPath2 = PortalPage.addScreenshot(driver);
//			extendtest.log(LogStatus.PASS, "Article Screenshot" + extendtest.addScreenCapture(screenShotPath2));
//			driver.navigate().refresh();
//			ProductPage.overviewTab();
//			extendtest.log(LogStatus.INFO, "Article is marked as CBS Navigated to Overview");
			

//			Thread.sleep(3000);
//			extendtest.log(LogStatus.INFO, "Navigated to Details tab to check either Marked as CBS");
//			Thread.sleep(3000);
//			ProductPage.detailsTab();
//			Thread.sleep(3000);
//			PortalPage.articlecbsScreen();
//			screenShotPath2 = PortalPage.addScreenshot(driver);
//			extendtest.log(LogStatus.PASS, "Article is marked as CBS " + extendtest.addScreenCapture(screenShotPath2));
//			ProductPage.overviewTabCBS();
//			extendtest.log(LogStatus.INFO, "Navigated to Overview page");
//			Thread.sleep(3000);
			//driver.switchTo().defaultContent();
			

	
	ProductPage.returnPortal();
}
	catch(Exception e){
	e.toString();
	extendtest.log(LogStatus.FAIL, e.getMessage());
	ProductPage.returnPortal();
}
}
	
	
	
	
	
	
	private static void PIMDEV_Sust(WebDriver driver) throws Exception {		
		String searchKey, searchValue = "";
		int count=0;
		String inputData = "Select * from PIMDEV_Sust";		
		Recordset productRecord = connection.executeQuery(inputData);
		
		extendtest = reports.startTest("Verify Sustainablity");
		try{
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
		while (productRecord.next()) {
				searchKey = productRecord.getField("Search Key").trim();
				searchValue = productRecord.getField("Search Value").trim();
			if (count == 0) {
					PortalPage.clickEnrich();
					EnrichPage.quickSearch(searchKey,searchValue,driver, extendtest);
					//ArticlePage.Screen(driver, extendtest);
					
				} else{
					EnrichPage.quickSearch(searchKey,searchValue,driver, extendtest);
				}
				count++;
			}
			ProductPage.returnPortal();
		}
		
		catch(Exception e){
			e.printStackTrace();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}
	}
	///////////////////////////////////////////Somnath Composition ////////////////////////////////////////////////////////
	
	private static void PIMDEV_Comp(WebDriver driver) throws Exception {		
		String searchKey1, searchValue1,Value = "";
		int count=0;
		String inputData = "Select * from PIMDEV_Comp";		
		Recordset productRecord1 = connection.executeQuery(inputData);
		
		extendtest = reports.startTest("Verify Composition");
		try{
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
		while (productRecord1.next()) {
				searchKey1 = productRecord1.getField("Search Key").trim();
				searchValue1 = productRecord1.getField("Search Value").trim();
			if (count == 0) {
					PortalPage.clickEnrich();
					EnrichPage.quickSearch1(searchKey1,searchValue1,driver,Value , extendtest);
					//ArticlePage.Screen(driver, extendtest);
					
				} else{
					EnrichPage.quickSearch(searchKey1,searchValue1,driver, extendtest);
				}
				count++;
			}
			ProductPage.returnPortal();
		}
		
		catch(Exception e){
			e.printStackTrace();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**Verify Used In is having value as 'HM_ICC_Channel' if product is in QC status
	 * Verify Used In is having value as 'Not used in any channel' if product is NOT in QC status
	 * Verify the media image displayed under Media heading is same as in Media tab
	 * @author tempbasir
	 */
	public static void PIMDEV_2375(WebDriver driver) throws Exception {
		String productID, executeProduct = "";
		String screenShotPath1,screenShotPath2 ="";	
		String product = "Select * from PIMDEV_2375";		
		Recordset productRecord = connection.executeQuery(product);
		
		extendtest = reports.startTest("Verify Overview Page");
		
		try{
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			PortalPage.clickEnrich();
			PortalPage.openSearchQuery();
			PortalPage.qualityCheckedProductsQuery(driver, extendtest);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Select products which is in QC status and Verify whether 'Used In' attribute is set as 'HM_ICC_Channel'</b></h6>");
			productID = PortalPage.openSearchedProduct(driver);
			ProductPage.verifyProductInICCChannel(driver, extendtest, productID);
			PortalPage.clickTopHeaderTitle();
			PortalPage.openSearchQuery();
			extendtest.log(LogStatus.INFO, "<h6><b>Scenario 2: Select products which is NOT in QC status and Verify whether 'Used In' attribute is set as 'Not used in any channel'</b></h6>");
			PortalPage.notQCProductsQuery(driver, extendtest);
			productID = PortalPage.openSearchedProduct(driver);
			ProductPage.verifyProductNotUsedInChannel(driver, extendtest, productID);
			ProductPage.detailsTab();
			ProductPage.updateQCForECom(driver, extendtest);
			ProductPage.overviewTab();
			driver.navigate().refresh();
			driver.navigate().refresh();
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
				
				continue;
			}	
			ProductPage.returnPortal();
		}
		
		catch(Exception e){
			e.printStackTrace();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}
	}
	
	/**
	 * Verify when new Style and Descriptive length attributes are set then Original Style and Descriptive length is automatically updated with same values
	 * Verify when removing all the values from new style and descriptive length attributes, then Original Style and Descriptive length is updated as (not set)
	 * @author tempbasir
	 * @param driver
	 * @throws Exception
	 */
	
	public static void PIMDEV_2961(WebDriver driver) throws Exception {
		String productID,executeProduct,assortmentType,sleeveStyle,necklineStyle,collarStyle,clothingStyle,garmentLength,sleeveLength,heelHeight,waistRise   = "";
		int count=0;		
		String inputData = "Select * from PIMDEV_2961";		
		Recordset productRecord = connection.executeQuery(inputData);
		
		extendtest = reports.startTest("Verify Product Details page - PART3");
	
		try{	
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			while (productRecord.next()) {
				productID = productRecord.getField("ProductID").trim();
				executeProduct = productRecord.getField("Execute").trim(); 
				assortmentType = productRecord.getField("Assortment type").trim(); 
				sleeveStyle = productRecord.getField("Sleeve style").trim(); 
				necklineStyle = productRecord.getField("Neckline style").trim(); 
				collarStyle = productRecord.getField("Collar style").trim(); 			
				clothingStyle = productRecord.getField("Clothing style").trim(); 
				garmentLength = productRecord.getField("Garment length").trim(); 
				sleeveLength = productRecord.getField("Sleeve length").trim(); 
				heelHeight = productRecord.getField("Heel height").trim(); 
				waistRise = productRecord.getField("Waist rise").trim(); 
				
				if (executeProduct.equalsIgnoreCase("Y")) {
					if (count == 0) {
						PortalPage.clickEnrich();
					} else {
						PortalPage.clickTopHeaderTitle();
					}
								
					EnrichPage.searchProduct(productID);
					PortalPage.openSearchedProduct(driver);
					extendtest.log(LogStatus.INFO, "Product: " + productID + " is found");			
					Thread.sleep(2000);
					ProductPage.detailsTab();
					extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Verify when new Style and Descriptive length attributes are set then Original Style and Descriptive length is automatically updated with same values.</b></h6>");					
					ProductPage.setStyleAndDescLength_Fashion(driver,extendtest,assortmentType,sleeveStyle,necklineStyle,collarStyle,clothingStyle,garmentLength,sleeveLength,heelHeight,waistRise);
				    ProductPage.verifyStyle_Fashion(driver, extendtest,sleeveStyle,necklineStyle,collarStyle,clothingStyle);
				    ProductPage.verifyDescLength_Fashion(driver, extendtest,garmentLength,sleeveLength,heelHeight,waistRise);
				    extendtest.log(LogStatus.INFO, "<h6><b>Scenario 2: Verify when removing all the values from new style and descriptive length attributes, then Original Style and Descriptive length is updated as (not set)</b></h6>");
				    ProductPage.removeStyleAndDescLength_Fashion(driver, extendtest);
				    ProductPage.verifyStyleAndDecLength_NOtSet(driver, extendtest);
				    
				    count++;
				}
			
				continue;
			}
			ProductPage.returnPortal();
		}
		
		catch(Exception e){
			e.printStackTrace();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}		
	}

	/** Function to create new Related article and verify the saved values
	 * @author tempbasir
	 * @param driver
	 * @throws Exception
	 */
	private static void PIMDEV_2374(WebDriver driver) throws Exception {		
		String relationType, internalRelationName, relationKeywords, readyToPublish, baseload, bumpresend, execute = "";
		String articleNumber = "";
		int count=0;
		String inputData = "Select * from PIMDEV_2374";		
		Recordset productRecord = connection.executeQuery(inputData);
		
		extendtest = reports.startTest("Verify Create New Entity - Related Articles");
		try{
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			while (productRecord.next()) {
				relationType = productRecord.getField("Relation Type").trim();
				internalRelationName = productRecord.getField("Internal Relation Name").trim();
				relationKeywords = productRecord.getField("Relation Keywords").trim();
				readyToPublish = productRecord.getField("Ready To Publish").trim();
				baseload = productRecord.getField("Baseload").trim();
				bumpresend = productRecord.getField("Bump/resend").trim();
				articleNumber = productRecord.getField("Articles to link").trim();
				execute = productRecord.getField("Execute").trim(); 
	
				if (execute.equalsIgnoreCase("Y")) {
					if (count == 0) {
						PortalPage.clickEnrich();
						extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Verify Create new Entity is displayed when clicking on the hamburger</b></h6>");
						PortalPage.clickHamburger();
						PortalPage.verifyCreateNewEntityPopUp(driver, extendtest);
					} else {
						PortalPage.clickTopHeaderTitle();
						PortalPage.clickHamburger();
					}
					extendtest.log(LogStatus.INFO, "<h6><b>Scenario 2: Create new Related Article and Verify the saved values</b></h6>");					
					PortalPage.createNewRelatedArticle(driver, extendtest,relationType,internalRelationName,relationKeywords,readyToPublish,baseload,bumpresend);
					extendtest.log(LogStatus.PASS, "Related article created sucessfully.");	
					RelatedArticlePage.verifyCreatedRelatedArticle(driver, extendtest,relationType,internalRelationName,relationKeywords,readyToPublish,baseload,bumpresend);					
					if(articleNumber!=null && articleNumber!=""){
						extendtest.log(LogStatus.INFO, "<h6><b>Scenario 3: Link articles to Related articles</b></h6>");
						RelatedArticlePage.linkArticleTosRelatedArticle(driver,articleNumber,extendtest);
					}					
					extendtest.log(LogStatus.INFO, "<h6><b>Scenario 4: Update Ready to Publish as True</b></h6>");
					RelatedArticlePage.updateReadyToPublish(driver,extendtest);
				//	RelatedArticlePage.deleteRA(driver,extendtest);
				}
				
				count++;
				continue;
			}
			
			ProductPage.returnPortal();
		}
		catch(Exception e){
			e.printStackTrace();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}
		
	}
	
	/** Verify Quick search functionality
	 * @author tempbasir
	 * @param driver
	 * @throws Exception
	 */
	private static void PIMDEV_2357(WebDriver driver) throws Exception {		
		String searchKey, searchValue = "";
		int count=0;
		String inputData = "Select * from PIMDEV_2357";		
		Recordset productRecord = connection.executeQuery(inputData);
		
		extendtest = reports.startTest("Verify Quick Search");
		try{
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			while (productRecord.next()) {
				searchKey = productRecord.getField("Search Key").trim();
				searchValue = productRecord.getField("Search Value").trim();
				if (count == 0) {
					PortalPage.clickEnrich();
					EnrichPage.quickSearch2(searchKey,searchValue,driver, extendtest);
				} else{
					EnrichPage.quickSearch2(searchKey,searchValue,driver, extendtest);
				}
				count++;
			}
			ProductPage.returnPortal();
		}
		
		catch(Exception e){
			e.printStackTrace();
			extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}
	}
	

	/**
	 * Verify Query Editor functionality
	 * @author somnath
	 * @param driver
	 * @throws Exception
	 */
	private static void PIMDEV_2358(WebDriver driver) 
			throws Exception {
		
		//String qury = prop.getProperty("QQuery");
		String query, condition, Agegroup, locale  = "";
		String screenShotPath1, screenShotPath2 = "";
		String inputData = "Select * from PIMDEV_2358";		
		Recordset recordSet = connection.executeQuery(inputData);
		
		extendtest = reports.startTest("Verify Query Editor");
		Thread.sleep(5000);
		PortalPage.clickEnrich();
		Thread.sleep(3000);
		PortalPage.openSearchQuery();
		Thread.sleep(3000);
		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Searching a 'H&M' Product Query</b></h6>");
		Thread.sleep(5000);
		PortalPage.openHMprdSearchQuery();
		Thread.sleep(2000);
		PortalPage.corpbrd();
		Thread.sleep(2000);
//		JavascriptExecutor js2 = (JavascriptExecutor) driver;
//		js2.executeScript("window.scrollBy(-0, 350)");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@class ='buc_ksxnl buc_kygMK']")).click();
//		Thread.sleep(2000);
	//	Locators.getName(QQuery).sendKeys(qury);
	//	Thread.sleep(2000);
//		Locators.getName(next).click();
//		String text = driver.findElement(By.id("")).click();
//		driver.findElement(By.xpath("//*[@class ='buc_ksxnl buc_kygMK']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@Class='buc_1qT6J buc_1fjJp']")).click();
//		Thread.sleep(3000);
		
		
		try{
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//PortalPage.clickEnrich();
			Thread.sleep(3000);
		//	PortalPage.openSearchQuery();
			Thread.sleep(3000);
			//extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Searching a 'H&M' Product Query</b></h6>");
			Thread.sleep(3000);
		}
			
			catch(Exception e){
				//e.printStackTrace();
				//extendtest.log(LogStatus.FAIL, e.getMessage());
				ProductPage.returnPortal();
			}
			}
			
	
			
			
//			while (recordSet.next()) {
//				query = recordSet.getField("Query").trim();
//				condition = recordSet.getField("Condition").trim();
//				value = recordSet.getField("Value").trim();
//				locale = recordSet.getField("Locale").trim();
//				
//				PortalPage.openSearchQuery();
//				if(query.equalsIgnoreCase("Query1")){
//					extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Searching a 'H&M' Product Query</b></h6>");
//					Thread.sleep(3000);
//					PortalPage.ProductSearchQuery(condition,value,driver);
//					screenShotPath1 = PortalPage.addScreenshot(driver);
//					List<WebElement> searchResult = Locators.getXpathList(NoSearchResult);
//					if (searchResult != null && searchResult.size() > 0) {
//						extendtest.log(LogStatus.FAIL, "No Search result found for " +condition+ " Contains Any " +value);
//					} else {
//						extendtest.log(LogStatus.PASS, "Search result found for " +condition+ " Contains Any " +value
//								+ extendtest.addScreenCapture(screenShotPath1));
//					}
//				} 
//				
//				else if(query.equalsIgnoreCase("Query2")){
//					extendtest.log(LogStatus.INFO, "<h6><b>Scenario 2: Verify searching for a word in a specific locale using 'Contains' works fine</b></h6>");
//					PortalPage.searchInLocaleStringQuery(condition,value,locale,driver);
//					screenShotPath2 = PortalPage.addScreenshot(driver);
//					List<WebElement> searchResult = Locators.getXpathList(NoSearchResult);
//					if (searchResult != null && searchResult.size() > 0) {
//						extendtest.log(LogStatus.FAIL, "No Search result found for " +condition+ " Contains " +value+ " in "+locale);
//					} else {
//						extendtest.log(LogStatus.PASS, "Search result found for " +condition+ " Contains " +value+ " in "+locale
//								+ extendtest.addScreenCapture(screenShotPath2));
//					}
//					Locators.getXPath(CloseIcon).click();
//					
//					
//				
//				//} else if(query.equalsIgnoreCase("Query3")){
////					extendtest.log(LogStatus.INFO, "<h6><b>Scenario 3: Verify CVL Keys configuration in Query editor</b></h6>");
////					PortalPage.cvlKeyConfigQuery(condition,value,driver,extendtest);
//				}
//				ProductPage.returnPortal();
//			}
//			
//		}
//		catch(Exception e){
//			//e.printStackTrace();
//			//extendtest.log(LogStatus.FAIL, e.getMessage());
//			ProductPage.returnPortal();
//		}
//		
//	}
//	
	/**
	 * Verify the media images are zoomed when magnifier slider is increased
	 * @author tempbasir
	 * @param driver2
	 * @throws Exception
	 */
	private static void PIMDEV_2383(WebDriver driver2) throws Exception {
		String productID = "";
		String product = "Select * from PIMDEV_2383";		
		Recordset productRecord = connection.executeQuery(product);

		extendtest = reports.startTest("Verify Media Page"); 
		
		try{	
			PortalPage.clickEnrich();
			while (productRecord.next()) {
				productID = productRecord.getField("ProductID").trim();	
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				PortalPage.clickTopHeaderTitle();
				EnrichPage.searchProduct(productID);
				PortalPage.openSearchedProduct1(driver);
				extendtest.log(LogStatus.INFO, "Product: " + productID + " is found");			
				Thread.sleep(5000);
				ProductPage.MediaTab();
				extendtest.log(LogStatus.INFO, "Navigating to Media Tab");
				ProductPage.verifyMediaImageMaximized(driver,extendtest);
			//	ProductPage.verifyShowAll(driver,extendtest);
				}
			ProductPage.returnPortal();
		}
		
		catch(Exception  e){
			//e.printStackTrace();
			//extendtest.log(LogStatus.FAIL, e.getMessage());
			ProductPage.returnPortal();
		}
		
	}
	
}
