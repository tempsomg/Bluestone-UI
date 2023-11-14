package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverInit;
//import Utils.Editor;
import Utils.Locators;
import Utils.webElements;

public class PortalPage implements webElements {

	// Click Enrich app
	public static void clickEnrich() throws Exception {
		Thread.sleep(5000);
		Locators.getXPath(Enrich).click();
		Thread.sleep(5000);

	}

	// Click on the top header title to re-navigate
	public static void clickTopHeaderTitle() throws Exception {
		Thread.sleep(5000);
		Locators.getClassName(TopHeaderTitle).click();
		Thread.sleep(5000);
	}

	public static void clickCreateRelatedArticles() throws Exception {
		Thread.sleep(3000);
		Locators.getClassName(CreateNewEntity_Hamburger).click();
		Thread.sleep(2000);
		Locators.getID(RelatedArticlesEntity).click();
		Thread.sleep(2000);

	}

	public static void clickHamburger() throws Exception {
		Thread.sleep(3000);
		Locators.getClassName(CreateNewEntity_Hamburger).click();
		Thread.sleep(2000);
	}

	// Click on search query button
	public static void openSearchQuery() throws Exception {
		Locators.getXPath(ProductButton).click();
		Thread.sleep(3000);
		Locators.getXPath(Filtertab).click(); 
		Thread.sleep(3000);
		Locators.getXPath(QueryEditorhead).click();
		Thread.sleep(5000);
		
//		Locators.getXPath(Edit_query_button).click();
//		Thread.sleep(5000);
		
	}
	
	public static void openHMprdSearchQuery()  throws Exception {
//		
		Locators.getXPath(Selectaddcondition).click();
		Thread.sleep(5000);
		Locators.getXPath(SelectLabel1).click();
		Thread.sleep(3000);
		Locators.getXPath(Select).click();
		Thread.sleep(4000);
		Locators.getXPath(Selectattribute).click();
		Thread.sleep(3000);
		Locators.getXPath(Select1).click();
		Thread.sleep(3000);
	//	
	}
//	
	public static void corpbrd(String Agegroup)throws Exception {
		
		Locators.getXPath(Selectattribute).sendKeys(Agegroup);
		Thread.sleep(2000);
	}
	
	//String text = driver.findElement(By.id("")).click();
//		Locators.getClassName(out).click();
//		Thread.sleep(3000);
//		
		
//		Locators.getXPath(SelectLabel1sub).click();
//		Thread.sleep(3000);
//		Locators.getCSS(Selectprcbid).click();
//		Thread.sleep(3000);
//		Locators.getXPath(Selectbrand).click();
//		Thread.sleep(3000);
//		
//	}
		
		public static void openSearchQuery1() throws Exception {
			Locators.getXPath(Edit_query_button).click();
			Thread.sleep(2000);
	}
		public static void openSearchQuery2() throws Exception {
			Locators.getXPath(Edit_query_button).click();
			Thread.sleep(2000);
		}
		
	public static void enrichedAssetQuery(String assetID) throws Exception {
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValue_Resource).click();
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink_Origin).click();
		Thread.sleep(2000);
		Locators.getID(SystemLink_ResourceAssetId).click();
		Thread.sleep(2000);
		Locators.getLinkText(EnterValueLink).click();
		Thread.sleep(3000);
		Locators.getXPath(ValueInputBox).click();
		Locators.getXPath(ValueInputBox).sendKeys(assetID);
		Thread.sleep(2000);
		Locators.getID(SearchButton).click();
		Thread.sleep(4000);
	}

		public static void openResource(ExtentTest extendtest, WebDriver driver) throws Exception {
		if (Locators.getXPath(ResourceImage).isDisplayed()) {
			extendtest.log(LogStatus.PASS, "Asset is present in PIM");
			String screenShotPath = capture(driver, "EnrichedAssetFound");
			extendtest.log(LogStatus.PASS, "Snapshot below: " + extendtest.addScreenCapture(screenShotPath));
		} else {
			extendtest.log(LogStatus.FAIL, "Asset is not present in PIM");
		}
		Locators.getXPath(ResourceImage).click();
		Thread.sleep(3000);
	}

	public static void verifyLinkedArticles(String articleNumbers, ExtentTest extendtest) {
		if (articleNumbers.contains(", ")) {
			String[] arrSplit = articleNumbers.split(", ");
			for (int i = 0; i < arrSplit.length; i++) {
				System.out.println(arrSplit[i]);
				final String includedInArticles = "//div[@title='" + arrSplit[i] + "']";
				Boolean articleDisplayed = Locators.getXPath(includedInArticles).isDisplayed();

				if (articleDisplayed) {
					extendtest.log(LogStatus.PASS, "Resource is linked to " + arrSplit[i]);
				} else {
					extendtest.log(LogStatus.FAIL, "Resource is not linked to " + arrSplit[i]);
				}
			}

		} else {
			final String includedInArticles = "//div[@title='0" + articleNumbers + "']";
			Boolean articleDisplayed = Locators.getXPath(includedInArticles).isDisplayed();

			if (articleDisplayed) {
				extendtest.log(LogStatus.PASS, "Resource is linked to" + articleNumbers);
			} else {
				extendtest.log(LogStatus.FAIL, "Resource is not linked to" + articleNumbers);
			}
		}

	}

	public static void openIncludedIn() throws Exception {
		Locators.getXPath(IncludeInTab).click();
		Thread.sleep(2000);

	}

	public static void checkResource(ExtentTest extendtest) throws Exception {
		if (Locators.getXPath(NoResouce).isDisplayed()) {
			extendtest.log(LogStatus.PASS, "Quarantined Asset is not present in PIM");
		} else {
			extendtest.log(LogStatus.FAIL, "Quarantined Asset is present in PIM");
		}

		Thread.sleep(3000);

	}

	public static String capture(WebDriver driver, String screenShotName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\Reports\\" + screenShotName + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		Thread.sleep(2000);
		return dest;
	}

	public static String addScreenshot(WebDriver driver) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader = new FileInputStream(scrFile);
			byte[] bytes = new byte[(int) scrFile.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "data:image/png;base64," + encodedBase64;
	}

	// Open the first product from the search list and return its product id
	public static String openSearchedProduct(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		Locators.getXPath(ProductImage).click();
		Thread.sleep(5000);
		String productid = Locators.getXPath(Card_text1).getAttribute("title");
		return productid;
	}
	
	public static String openSearchedProduct1(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		Locators.getXPath(ProductImage1).click();
		Thread.sleep(4000);
		String productid = Locators.getXPath(Card_text1).getAttribute("title");
		return productid;
		
	}
	//////////////////////////////////////////////SOMNATH CBS/////////////////////////////////
	public static String openSearchedProduct2(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		Locators.getXPath(ArticleImage).click();
		Thread.sleep(4000);
		String productid = Locators.getXPath(ArticleCard_text1).getAttribute("title");
		return productid;
		
	}
	
	
	//Search for products with level zero/level A depending on the input given in data sheet
	public static void productLevelQuery(String infoLevel, WebDriver driver, ExtentTest extendtest) throws Exception {
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValue_product).click();
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink2).click();
		Thread.sleep(2000);
		Locators.getID(ProductInfoLevel).click();
		Thread.sleep(2000);
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(4000);
		if (infoLevel.equalsIgnoreCase("Level zero")) {
			Locators.getXPath(InfoLevel_zero).click();
		} else if (infoLevel.equalsIgnoreCase("Level A")) {
		//	Locators.getXPath(InfoLevel_A).click(); 
			Locators.getXPath(InfoLevel_zero).click(); //no products in pimtest1 with level A hence using levelzero
		} else {
			extendtest.log(LogStatus.FAIL, "Invalid info level in the data sheet");
		}
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink3).click();
		Thread.sleep(2000);
		Locators.getXPath(AssortmentType).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValueLink3).click();
		Thread.sleep(2000);
		Locators.getXPath(ClothingAssortmentType).click();
		Thread.sleep(2000);
		Locators.getID(SearchButton).click();
		Thread.sleep(5000);
	}

	
	
	//SOMNATHRICHTEXTEDITOR
	
	//Search for products with level zero/level A depending on the input given in data sheet
	public static void productLevelQuery1(String infoLevel, WebDriver driver, ExtentTest extendtest) throws Exception {
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValue_product).click();
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink2).click();
		Thread.sleep(2000);
		Locators.getID(ProductInfoLevel).click();
		Thread.sleep(2000);
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(3000);
		if (infoLevel.equalsIgnoreCase("Level zero")) {
			Locators.getXPath(InfoLevel_zero).click();
		} else if (infoLevel.equalsIgnoreCase("Level A")) {
		//	Locators.getXPath(InfoLevel_A).click(); 
			Locators.getXPath(InfoLevel_zero).click(); //no products in pimtest1 with level A hence using levelzero
		} else {
			extendtest.log(LogStatus.FAIL, "Invalid info level in the data sheet");
		}
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink3).click();
		Thread.sleep(2000);
		Locators.getXPath(CorporateBrandID).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValueLink3).click();
		Thread.sleep(2000);
		Locators.getXPath(CosID).click();
		Thread.sleep(2000);
		Locators.getID(SearchButton).click();
		Thread.sleep(9000);
		Thread.sleep(9000);
	}
	
	
	/////////////////////////////////////////////////SOmnath CBS Query//////////////////////////////////////////////////
	
	public static void productLevelQuery2() throws Exception {
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValue_item).click();
		Thread.sleep(2000);
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink2).click();
		Thread.sleep(2000);
		Locators.getXPath(ArticleCorporateID).click();
		Thread.sleep(2000);
		Locators.getXPath(EnterValueLink1).click();
		Thread.sleep(2000);
		Locators.getXPath(Containsany).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValueLink2).click(); 
		Thread.sleep(3000);
		Locators.getXPath(selectcoscheckbox).click();
		Thread.sleep(2000);
		Locators.getXPath(ArticleLink).click();
		Thread.sleep(3000);
		Locators.getXPath(SystemLink3).click();
		Thread.sleep(3000);
		Locators.getXPath(Businessmodel).click();
		Thread.sleep(3000);
		Locators.getXPath(OperatorLink3).click();
		Thread.sleep(3000);
		Locators.getXPath(Notcontainsany).click();
		Thread.sleep(3000);
		Locators.getXPath(SelectValueLink3).click(); 
		Thread.sleep(3000);
		Locators.getXPath(CBSmodel).click(); 
		Thread.sleep(3000);
		Locators.getID(SearchButton).click();
		Thread.sleep(9000);
		
	}
		
//		if (infoLevel.equalsIgnoreCase("Level zero")) {
//			Locators.getXPath(InfoLevel_zero).click();
//		} else if (infoLevel.equalsIgnoreCase("Level A")) {
//		//	Locators.getXPath(InfoLevel_A).click(); 
//			Locators.getXPath(InfoLevel_zero).click(); //no products in pimtest1 with level A hence using levelzero
//		} else {
//			extendtest.log(LogStatus.FAIL, "Invalid info level in the data sheet");
//		}
//		Locators.getXPath(AddDataConditionLink).click();
//		Thread.sleep(2000);
//		Locators.getXPath(SystemLink3).click();
//		Thread.sleep(2000);
//		Locators.getXPath(SelectValueLink3).click();
//		Thread.sleep(2000);
//		Locators.getXPath(CosID).click();
//		Thread.sleep(2000);
//		Locators.getID(SearchButton).click();
//		Thread.sleep(5000);
	
	
//	public static void CBSEnrich(WebDriver driver,ExtentTest extendtest) throws Exception {
//		Thread.sleep(5000);
//		Locators.getXPath(Businessmodellabel).click();
//		Thread.sleep(5000);
//		Locators.getXPath(CBScheckbox).click();
//		Thread.sleep(9000);
//		Locators.getXPath(Savefind).click();
//		Thread.sleep(20000);
//		Locators.getXPath(Save_button).click();
//		Thread.sleep(20000);
//	}
//		Locators.getXPath(rowcontent).click();
//		Thread.sleep(5000);
//		Locators.getXPath(DetailTab).click();
//		Thread.sleep(9000);
//		Locators.getXPath(Businessmodellabel).click();
//		Thread.sleep(12000);
		


	
	
	//////////////////////////Somnath Flowers n PLants///////////////////////////////////////////////////////
	
	
	
	public static void productLevelQuery3() throws Exception {
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValue_product).click();
		Thread.sleep(2000);
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink2).click();
		Thread.sleep(2000);
		Locators.getXPath(Sourcing_type).click();
		Thread.sleep(2000);
		Locators.getXPath(EnterValueLink1).click();
		Thread.sleep(2000);
		Locators.getXPath(Equals).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValueLink2).click(); 
		Thread.sleep(3000);
		Locators.getXPath(External).click();
		Thread.sleep(2000);
		Locators.getXPath(ArticleLink).click();
		Thread.sleep(5000);
		Locators.getXPath(SystemLink3).click();
		Thread.sleep(5000);
//		Locators.getXPath(Content).click();
//		Thread.sleep(5000);
//		Locators.getXPath(List).click();
//		Thread.sleep(5000);
		Locators.getXPath(FlowersnPlants).click();
		Thread.sleep(3000);
		Locators.getXPath(OperatorLink3).click();
		Thread.sleep(3000);
		Locators.getXPath(Noemp).click();
		Thread.sleep(3000);
//		Locators.getXPath(SelectValueLink3).click(); 
//		Thread.sleep(3000);
//		Locators.getXPath(CBSmodel).click(); 
//		Thread.sleep(3000);
		Locators.getID(SearchButton).click();
		Thread.sleep(9000);
		
	}
	
//////////////////////////Somnath Color n Shades ////////////////////////////////////
	
	
	public static void productLevelQuery4() throws Exception {
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValue_item).click();
		Thread.sleep(2000);
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink2).click();
		Thread.sleep(3000);
		Locators.getXPath(Colorshades).click();
		Thread.sleep(3000);
		Locators.getXPath(EnterValueLink1).click();
		Thread.sleep(4000);
		Locators.getXPath(NotEmpty2).click();
		Thread.sleep(5000);
//		Locators.getXPath(SelectValueLink2).click();
		Thread.sleep(5000);
		Locators.getID(SearchButton).click();
		Thread.sleep(9000);
		
	}
	
	
	
	
	
		
	public static void articlecbsScreen() throws Exception {
		Thread.sleep(9000);
		Locators.getXPath(Cbsscreen).click();
		Thread.sleep(9000);
	}	
	
	
	public static void checkcbsproduct() throws Exception {
		Locators.getXPath(Productininclude).click();
		Thread.sleep(5000);
		Locators.getXPath(includelink).click();
		Thread.sleep(2000);
		Locators.getXPath(includeEdit).click();
		Thread.sleep(2000);
		Locators.getXPath(ProductFieldCBS).click();
		Thread.sleep(5000);
		
	}
	
	
	
	/*
	 * Search for the products with info level as level A and Translation
	 * received for print is Not Empty Search for the products with info level
	 * as B and Translation received for print is Not Empty and filter by
	 * division
	 */
	public static void productQueryTransReceivedNotEmpty(String infoLevel, WebDriver driver, ExtentTest extendtest)
			throws Exception {
		Thread.sleep(4000);
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValue_product).click();
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink2).click();
		Thread.sleep(2000);
		Locators.getID(ProductInfoLevel).click();
		Thread.sleep(2000);
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(3000);
		if (infoLevel.equalsIgnoreCase("Level A")) {
			Locators.getXPath(InfoLevel_A).click();
			Thread.sleep(2000);
			Locators.getID(QueryEditor).click();
			Thread.sleep(2000);
			Locators.getXPath(AddDataConditionLink).click();
			Thread.sleep(2000);
			Locators.getXPath(SystemLink3).click();
			Thread.sleep(2000);
			Locators.getXPath(QueryLocalesReceivedForPrint).click();
			Thread.sleep(2000);
			Locators.getXPath(OperatorLink3).click();
			Thread.sleep(3000);
			Locators.getXPath(NotEmpty2).click();
		} else if (infoLevel.equalsIgnoreCase("Level B")) {
			Locators.getXPath(InfoLevel_B).click();
			Thread.sleep(2000);
			Locators.getID(QueryEditor).click();
			Thread.sleep(2000);
			Locators.getXPath(AddDataConditionLink).click();
			Thread.sleep(2000);
			Locators.getXPath(SystemLink3).click();
			Thread.sleep(2000);
			Locators.getXPath(DivisionName_querycondition).click(); //Since too many products are fetched using division to filter furthur
			Thread.sleep(2000);
			Locators.getLinkText(SelectValueLink1).click();
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//div[@class='item'][contains(text(), '(03)')]")).click();
			driver.findElement(By.xpath("//div[@class='item'][contains(text(), '(00003)')]")).click();
			Thread.sleep(8000);
			//Locators.getID(QueryEditor).click();
			Thread.sleep(5000);
			Locators.getXPath(AddDataConditionLink).click();
			Thread.sleep(5000);
			Locators.getXPath(SystemLink4).click();
			Thread.sleep(2000);
			Locators.getXPath(QueryLocalesReceivedForEcom).click();
			Thread.sleep(2000);
			Locators.getXPath(OperatorLink4).click();
			Thread.sleep(3000);
			Locators.getXPath(NotEmpty3).click();
		} else {
			extendtest.log(LogStatus.FAIL, "Invalid info level in the data sheet");
		}

		Thread.sleep(2000);
		Locators.getID(SearchButton).click();
		Thread.sleep(5000);
	}

	/*
	 * Search query to retrieve products having measurements. To avoid
	 * ElmentNotvisible ex have added Thread.sleep Query: Measurements in cm Not
	 * Empty and Measurement Internal Not Empty
	 */
	public static void productsWithMeasurementQuery() throws Exception {
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValue_product).click();
		Thread.sleep(2000);
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink2).click();
		Thread.sleep(2000);
		Locators.getID(ProductMeasurements).click();
		Locators.getXPath(OperatorLink2).click();
		Thread.sleep(2000);
		Locators.getID(NotEmpty).click();
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink3).click();
		Thread.sleep(4000);
		Locators.getXPath(ProductMeasurementsInternal2).click();
		Thread.sleep(2000);
		Locators.getXPath(OperatorLink3).click();
		Thread.sleep(2000);
		Locators.getXPath(Noemp).click();
		Thread.sleep(2000);
//		Locators.getXPath(AddDataConditionLink).click();
//		Thread.sleep(2000);
//		Locators.getXPath(SystemLink4).click();
//		Thread.sleep(4000);
//		Locators.getXPath(PresentationProductType).click();
//		Thread.sleep(2000);
//		Locators.getLinkText(SelectValueLink1).click();
//		Thread.sleep(2000);
//		Locators.getXPath(Shoes).click();
//		Thread.sleep(2000);
		Locators.getID(SearchButton).click();
		Thread.sleep(5000);

	}

	// Search product with enrichment status as Quality checked and Assortment
	// type equals Personal care
	public static void qualityCheckedProductsQuery(WebDriver driver, ExtentTest extendtest) throws Exception {
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValue_product).click();
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink2).click();
		Thread.sleep(2000);
		Locators.getXPath(ProdEnrichmentStatus).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValueLink2).click();
		Thread.sleep(2000);
		Locators.getXPath(EnrichStatusQualityChecked).click();
		Thread.sleep(2000);
		Locators.getID(QueryEditor).click();
		Thread.sleep(2000);
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink3).click();
		Thread.sleep(2000);
		Locators.getXPath(AssortmentType).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValueLink3).click();
		Thread.sleep(2000);
		Locators.getXPath(PersonalCareAssortmentType).click();
		Thread.sleep(2000);
		Locators.getID(QueryEditor).click();
		Locators.getID(SearchButton).click();
		Thread.sleep(5000);
	}

	// Search for the products with Enrichment status Not Equals Quality checked
	// and Assortment type Equals Clothing
	public static void notQCProductsQuery(WebDriver driver, ExtentTest extendtest) throws Exception {
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValue_product).click();
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink2).click();
		Thread.sleep(2000);
		Locators.getXPath(ProdEnrichmentStatus).click();
		Thread.sleep(2000);
		Locators.getXPath(OperatorLink2).click();
		Thread.sleep(3000);
		Locators.getXPath(NotEquals2).click();
		Thread.sleep(3000);
		Locators.getXPath(SelectValueLink2).click();
		Thread.sleep(2000);
		Locators.getXPath(EnrichStatusQualityChecked).click();
		Thread.sleep(2000);
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink3).click();
		Thread.sleep(2000);
		Locators.getXPath(QualityCheckedPrint).click();
		Thread.sleep(2000);
		Locators.getXPath(OperatorLink3).click();
		Thread.sleep(2000);
		Locators.getXPath(OperatorList_False).click();
		Thread.sleep(2000);
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(2000);
		Locators.getXPath(SystemLink4).click();
		Thread.sleep(2000);
		Locators.getXPath(AssortmentType3).click();
		Thread.sleep(2000);
		Locators.getXPath(SelectValueLink4).click();
		Thread.sleep(2000);
		Locators.getXPath(ClothingAssortmentType).click();
		Thread.sleep(2000);
		Locators.getID(QueryEditor).click();
		Locators.getID(SearchButton).click();
		Thread.sleep(5000);

	}

	public static void verifyCreateNewEntityPopUp(WebDriver driver, ExtentTest extendtest) throws Exception {
		Boolean isDisplayed;
		String screenShotPath1 = "";
		Thread.sleep(2000);
		isDisplayed = Locators.getID(RelatedArticlesEntity).isDisplayed();
		screenShotPath1 = PortalPage.addScreenshot(driver);
		if (isDisplayed == true) {
			extendtest.log(LogStatus.PASS, "Pop up for Create new Entity is displayed.");
		} else {
			extendtest.log(LogStatus.FAIL, "Pop up for Create new Entity is NOT displayed. Screenshot below:"
					+ extendtest.addScreenCapture(screenShotPath1));
		}
		Thread.sleep(2000);
	}

	public static void createNewRelatedArticle(WebDriver driver, ExtentTest extendtest, String relationType,
			String internalRelationName, String relationKeywords, String readyToPublish, String baseload,
			String bumpresend) throws Exception {

		Locators.getID(RelatedArticlesEntity).click();
		Thread.sleep(4000);
		if (relationType.equalsIgnoreCase("Visually matching")) {
			Locators.getXPath(RelationType_VisuallyMatching).click();
		} else {
			Locators.getXPath(RelationType_notset).click();
		}
		Thread.sleep(2000);
		Locators.getName(InternalRelationName).sendKeys(internalRelationName);
		Thread.sleep(2000);
		if (relationKeywords.contains(",")) {
			String[] arrSplit = relationKeywords.split(",");
			for (int i = 0; i < arrSplit.length; i++) {
				driver.findElement(
						By.xpath("//ul[@name='Fields_5_Value']/li/label[text()='" + arrSplit[i].trim() + "']")).click();
			}
		}

		else {
			driver.findElement(By.xpath("//ul[@name='Fields_5_Value']/li/label[text()='" + relationKeywords + "']"))
					.click();
		}
		Thread.sleep(2000);

		if (readyToPublish.trim().equalsIgnoreCase("true")) {
			Locators.getXPath(ReadyToPublish_True).click();
		} else if (readyToPublish.trim().equalsIgnoreCase("false")) {
			Locators.getXPath(ReadyToPublish_False).click();
		}
		Thread.sleep(1000);

		if (baseload.equalsIgnoreCase("true")) {
			Locators.getXPath(Baseload_True).click();
		} else if (baseload.equalsIgnoreCase("false")) {
			Locators.getXPath(Baseload_False).click();
		}
		Thread.sleep(1000);

		if (bumpresend.equalsIgnoreCase("true")) {
			Locators.getXPath(Resend_True).click();
		} else if (bumpresend.equalsIgnoreCase("false")) {
			Locators.getXPath(Resend_False).click();
		}
		Thread.sleep(2000);
		Locators.getID(SaveButton_RA).click();
		Thread.sleep(4000);

	}

	public static void ProductSearchQuery(String condition, String value, WebDriver driver) throws Exception {
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(5000);
		Locators.getXPath(SelectValue_product).click();
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(5000);
		Locators.getXPath(SystemLink2).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[text()='"+condition+"'])[1]")).click();
		Thread.sleep(5000);
		Locators.getXPath(OperatorLink2).click();
		Thread.sleep(5000);
		Locators.getXPath(ContainsAny1).click();
		Thread.sleep(5000);
		Locators.getXPath(SelectValueLink2).click();
		Thread.sleep(5000);		
		if(value.contains(",")) {
			String[] arrSplit = value.split(",");
			for (int i = 0; i < arrSplit.length; i++) {
				driver.findElement(By.xpath("(//input[@value='"+arrSplit[i]+"'])[1]")).click();
			}
		}
		else{
			driver.findElement(By.xpath("(//input[@value='"+value+"'])[1]")).click();
		}		
		Thread.sleep(3000);
		Locators.getID(SearchButton).click();
		Thread.sleep(5000);
		
	}

	public static void searchInLocaleStringQuery(String condition, String value, String locale, WebDriver driver) throws Exception {
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(5000);
		Locators.getXPath(SelectValue_product).click();
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(5000);
		Locators.getXPath(SystemLink2).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[text()='"+condition+"'])[1]")).click();
		Thread.sleep(5000);
		Locators.getXPath(OperatorLink2).click();
		Thread.sleep(5000);
		Locators.getXPath(Contains1).click();
		Thread.sleep(5000);
		Locators.getXPath(SelectValueLink2).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@id='value-input'])[2]")).sendKeys(value);
		Thread.sleep(5000);
		Locators.getXPath(LanguageLink2).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//li[text()='"+locale+"'])[1]")).click();
		Thread.sleep(5000);
		Locators.getID(SearchButton).click();
		Thread.sleep(5000);
		
	}

	public static void cvlKeyConfigQuery(String condition, String value, WebDriver driver, ExtentTest extendtest) throws Exception {
		String screenShotPath1 = "";
		Locators.getLinkText(SelectValueLink1).click();
		Thread.sleep(3000);
		Locators.getXPath(SelectValue_product).click();
		Locators.getXPath(AddDataConditionLink).click();
		Thread.sleep(3000);
		Locators.getXPath(SystemLink2).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[text()='"+condition+"'])[1]")).click();
		Thread.sleep(3000);
		Locators.getXPath(SelectValueLink2).click();
		Thread.sleep(3000);
		List<WebElement> searchResult = driver.findElements(By.xpath("//div[text()='"+value+"']"));
		screenShotPath1 = PortalPage.addScreenshot(driver);
		if (searchResult != null && searchResult.size() > 0) {
			extendtest.log(LogStatus.PASS, "CVL Key is configured in Query editor" + extendtest.addScreenCapture(screenShotPath1));
		} else {
			extendtest.log(LogStatus.FAIL, "CVL Key is NOT configured in Query editor"
					+ extendtest.addScreenCapture(screenShotPath1));
		}		
		Locators.getXPath(CloseIcon).click();
		Thread.sleep(2000);
	}

}
