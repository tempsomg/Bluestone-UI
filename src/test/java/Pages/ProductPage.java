package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.Locators;
import Utils.webElements;

public class ProductPage implements webElements {

	public static void verifySize() throws Exception {
		Thread.sleep(3000);
		Locators.getXPath(SizeLabel).isDisplayed();
		Locators.getName(SizeValue).isDisplayed();

	}

	// Navigate to Overview page
	public static void overviewTab() throws Exception {
		Thread.sleep(3000);
		Locators.getID(OverviewTab).click();
		Thread.sleep(2000);
	}

	public static void overviewTabCBS() throws Exception {
		Thread.sleep(12000);
		Locators.getID(OverviewCBS).click();
		Thread.sleep(9000);
	}
	// Navigate to Details page
	public static void detailsTab() throws Exception {
		Thread.sleep(10000);
		Locators.getXPath(DetailTab).click();
		Thread.sleep(32000);
	}
	// Navigate to Details page
//		public static void detailsTabCBS() throws Exception {
//			Thread.sleep(3000);
//			Locators.getXPath(DetailTab).click();
//			Thread.sleep(5000);
//		}
		
		public static void includesTabCBS() throws Exception {
			Thread.sleep(3000);
			Locators.getXPath(ClickIncludedIn).click();
			Thread.sleep(12000);
		}

	// Navigate to Magnifier page
	public static void magnifierTab() throws Exception {
		Locators.getID(MagnifierTab).click();
		Thread.sleep(3000);
	}

	// Navigate to Composition page
	public static void compositionTab() throws Exception {
		Thread.sleep(4000);
		Locators.getID(CompositionTab).click();
		Thread.sleep(5000);
	}

	// Navigate to RGB page
	public static void rgbTab() throws Exception {
		Locators.getID(RGBTab).click();
		Thread.sleep(3000);
	}

	// Navigate to Measurement page
	public static void measurementTab() throws Exception {
		Locators.getID(MeasurementTab).click();
		Thread.sleep(9000);
	}
	
	//RICHTEXTEDITOR
	
	// Navigate to Richtext editor page page
		public static void RichTextEditorTab() throws Exception {
			Locators.getID(RichTextEditorTab).click();
			Thread.sleep(3000);
		}

		
	// Navigate to Warning page
	public static void warningTab() throws Exception {
		Locators.getID(WarningTab).click();
		Thread.sleep(2000);
	}

	// Navigate to Media page
	public static void MediaTab() throws Exception {
		Locators.getID(MediaTab).click();
		Thread.sleep(2000);
	}

	// Navigate to Includes page
	public static void includesTab() throws Exception {
		Locators.getID(IncludesTab).click();
		Thread.sleep(3000);
	}
	
	
	public static void returnPortal() throws Exception {
		Thread.sleep(1000);
		Locators.getXPath(AppMenu_launcher).click();
		Thread.sleep(3000);
		Locators.getXPath(PortalApp).click();
		Thread.sleep(3000);
	}
	
	// Choose the sleevleStyle passed from input data sheet
	public static void selectSleeveStyle(WebDriver driver,String sleeveStyle) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@cvlid='SleeveStyle']/div/div/ul/li/label/span[text()='"+sleeveStyle+"']")).click();
		Thread.sleep(2000);
	}
	
	// Choose the necklineStyle passed from input data sheet
	public static void selectNecklineStyle(WebDriver driver,String necklineStyle) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@cvlid='NecklineStyle']/div/div/ul/li/label/span[text()='"+necklineStyle+"']")).click();
		Thread.sleep(2000);
	} 
	
	// Choose collar style passed from input data sheet
	public static void selectCollarStyle(WebDriver driver,String collarStyle) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@cvlid='CollarStyle']/div/div/ul/li/label/span[text()='"+collarStyle+"']")).click();
		Thread.sleep(2000);
	}
	
	// Choose clothing style passed from input data sheet
	public static void selectClothingStyle(WebDriver driver,String clothingStyle) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@cvlid='ClothingStyle']/div/div/ul/li/label/span[text()='"+clothingStyle+"']")).click();
		Thread.sleep(2000);
	}
		
	// Choose garment length passed from input data sheet
	public static void selectGarmentLength(WebDriver driver,String garmentLength) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@cvlid='GarmentLength']/div/div/ul/li/label/span[text()='"+garmentLength+"']")).click();
		Thread.sleep(2000);
	}
		
	// Choose sleeve length passed from input data sheet
	public static void selectSleeveLength(WebDriver driver,String sleeveLength) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@cvlid='SleeveLength']/li/label[text()='"+sleeveLength+"']")).click();
		Thread.sleep(2000);
	}
		
	// Choose heel height passed from input data sheet
	public static void selectHeelHeight(WebDriver driver,String heelHeight) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@cvlid='HeelHeight']/li/label[text()='"+heelHeight+"']")).click();
		Thread.sleep(2000);
	}
		
	// Choose waist rise passed from input data sheet
	public static void selectWaistRise(WebDriver driver,String waistRise) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@cvlid='WaistRise']/li/label[text()='"+waistRise+"']")).click();
		Thread.sleep(2000);
	}
	

	// Verify Magnifier functionality by zooming the image present in Magnifier page
	public static void verifyMagnifier(WebDriver driver, ExtentTest extendtest, String productID) throws Exception {
		driver.switchTo().frame("context-editor-iframe");
		String screenShotPath="";
		List<WebElement> noImage = Locators.getXpathList(NoImagesText);
		if (noImage != null && noImage.size() > 0) {
			extendtest.log(LogStatus.INFO, "<h6><b>Scenario 2: Verify the text 'No images available' is displayed</b></h6>");
			screenShotPath = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS, "No Images Available text is displayed for the product, below is the snapshot: "
					+ extendtest.addScreenCapture(screenShotPath));
		} else {
			Point coordinates = null;
			coordinates = Locators.getID(MagnifierImage).getLocation();
			Robot robot = new Robot();
			robot.mouseMove(coordinates.getX() + 500, coordinates.getY() + 500); 
			Thread.sleep(5000);
			extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Verify when magnifier is increased then the image is 2 x zoomed</b></h6>");
			screenShotPath = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS,
					"Snapshot below for zoomed picture(Before increasing magnifier): " + extendtest.addScreenCapture(screenShotPath));
			WebElement slider = Locators.getXPath(Slider);
			int xCoord = slider.getLocation().getX();
			Actions builder = new Actions(driver);
			builder.moveToElement(slider).click().dragAndDropBy(slider, xCoord + 15, 0).build().perform();
			builder.release();
			Thread.sleep(5000);
			coordinates = Locators.getID(MagnifierImage).getLocation();
			robot.mouseMove(coordinates.getX() + 510, coordinates.getY() + 502);
			Thread.sleep(5000);
			screenShotPath = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS,
					"Snapshot below for 2 x zoomed picture(After increasing magnifier): " + extendtest.addScreenCapture(screenShotPath));
		}
		driver.switchTo().defaultContent();

	}

	// Verify sortby attribute in composition page
	public static void verifySortBy(WebDriver driver, ExtentTest extendtest, String productID, ExtentReports reports)
			throws Exception {
		extendtest = reports.startTest("Verify Sorting for the Product");
		extendtest.log(LogStatus.INFO, "Product: " + productID + " is found");
		extendtest.log(LogStatus.INFO, "Navigated to Composition tab");
		driver.switchTo().frame("context-editor-iframe");
		String screenShotPath1, screenShotPath2;
		Select sortBy = new Select(Locators.getID(SortBy));
		sortBy.selectByValue("articleid");
		Thread.sleep(5000);
		screenShotPath1 = PortalPage.addScreenshot(driver);
		extendtest.log(LogStatus.PASS,
				"Sorted by Article ID, below is the snapshot: " + extendtest.addScreenCapture(screenShotPath1));
		sortBy.selectByValue("duedate");
		Thread.sleep(5000);
		screenShotPath2 = PortalPage.addScreenshot(driver);
		extendtest.log(LogStatus.PASS,
				"Sorted by Due date, below is the snapshot: " + extendtest.addScreenCapture(screenShotPath2));

		driver.switchTo().defaultContent();
	}

	// Verify composition and material for the articles linked to the product
	public static void verifyCompositionAndMaterial(WebDriver driver, ExtentTest extendtest, String productID,
			ExtentReports reports) throws Exception {
		extendtest = reports.startTest("Verify Composition and Material visible for the Product");
		driver.switchTo().frame("context-editor-iframe");
		String screenShotPath = null;

		int x = 1;
		for (x = 1; x < 6; x++) {
			WebElement check;
			check = driver.findElement(By.xpath("//*[@id=\"article-list\"]/li[" + x + "]"));
			if (check.isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"article-list\"]/li[" + x + "]")).click();
				Thread.sleep(2000);
				screenShotPath = PortalPage.addScreenshot(driver);
				extendtest.log(LogStatus.PASS, "Verifying the Composition/Material for " + x + " Article"
						+ extendtest.addScreenCapture(screenShotPath));

				Thread.sleep(3000);
			}
		}
		driver.switchTo().defaultContent();
	}

	public static void addCompositionAndMaterial(WebDriver driver, ExtentTest extendtest, String productID, String mode,
			String article, String composition, String material, String article1, String composition1, String material1,
			String article2, String composition2, String material2, String article3, String composition3,
			String material3, String article4, String composition4, String material4, String article5,
			String composition5, String material5, String article6, String composition6, String material6,
			String article7, String composition7, String material7, String article8, String composition8,
			String material8, String article9, String composition9, String material9, String article10,
			String composition10, String material10, String percentage, ExtentReports reports)
			throws InterruptedException, AWTException {

		extendtest = reports.startTest("Verify Adding Composition and Material for the Product");

		driver.switchTo().frame("context-editor-iframe");
		String screenShotPath = null;
		String articleX = null;
		String compositionX = null;
		String materialX = null;
		// Thangs
		System.out.println("new Thangs");
		int x = 1;
		for (x = 1; x <= 5; x++) {

			if (mode.equalsIgnoreCase("All")) {
				articleX = article;
				compositionX = composition;
				materialX = material;
				System.out.println(articleX);
				System.out.println(compositionX);
				System.out.println(materialX);
			} else {
				if (x == 1) {
					articleX = article1;
					compositionX = composition1;
					materialX = material1;
					System.out.println(articleX);
					System.out.println(compositionX);
					System.out.println(materialX);
				} else if (x == 2) {
					articleX = article2;
					compositionX = composition2;
					materialX = material2;
					System.out.println(articleX);
					System.out.println(compositionX);
					System.out.println(materialX);
				} else if (x == 3) {
					articleX = article3;
					compositionX = composition3;
					materialX = material3;
					System.out.println(articleX);
					System.out.println(compositionX);
					System.out.println(materialX);
				} else if (x == 4) {
					articleX = article4;
					compositionX = composition4;
					materialX = material4;
					System.out.println(articleX);
					System.out.println(compositionX);
					System.out.println(materialX);
				} else if (x == 5) {
					articleX = article5;
					compositionX = composition5;
					materialX = material5;
					System.out.println(articleX);
					System.out.println(compositionX);
					System.out.println(materialX);
				} else if (x == 6) {
					articleX = article6;
					compositionX = composition6;
					materialX = material6;
					System.out.println(articleX);
					System.out.println(compositionX);
					System.out.println(materialX);
				} else if (x == 7) {
					articleX = article7;
					compositionX = composition7;
					materialX = material7;
					System.out.println(articleX);
					System.out.println(compositionX);
					System.out.println(materialX);
				} else if (x == 8) {
					articleX = article8;
					compositionX = composition8;
					materialX = material8;
					System.out.println(articleX);
					System.out.println(compositionX);
					System.out.println(materialX);
				} else if (x == 9) {
					articleX = article9;
					compositionX = composition9;
					materialX = material9;
					System.out.println(articleX);
					System.out.println(compositionX);
					System.out.println(materialX);
				} else if (x == 10) {
					articleX = article10;
					compositionX = composition10;
					materialX = material10;
					System.out.println(articleX);
					System.out.println(compositionX);
					System.out.println(materialX);
				} else {
					System.out.println("More than 10 Articles?????????????");
				}
			}
			try {
				WebElement check;
				check = driver.findElement(By.xpath("//*[@id=\"article-list\"]/li[" + x + "]"));
				if (check.isDisplayed()) {
					driver.findElement(By.xpath("//*[@id=\"article-list\"]/li[" + x + "]")).click();
					Thread.sleep(2000);
					if (articleX.equalsIgnoreCase("Single")) {
						driver.findElement(By.xpath("//*[@id=\"mode-single\"]")).click();
						System.out.println("Clicked for " + x + " Article");
						Thread.sleep(2000);

						driver.findElement(By.xpath("//*[@id=\"add-material-button\"]")).click();
						System.out.println("Material button clicked");
						Thread.sleep(4000);

						Robot r = new Robot();
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(3000);

						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(3000);

						r.keyPress(KeyEvent.VK_SPACE);
						r.keyRelease(KeyEvent.VK_SPACE);
						Thread.sleep(3000);
						String myString = materialX;
						StringSelection stringSelection = new StringSelection(myString);
						Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						clipboard.setContents(stringSelection, null);
						Thread.sleep(1000);
						System.out.println(myString);
						r.keyPress(KeyEvent.VK_CONTROL);
						r.keyPress(KeyEvent.VK_V);
						r.keyRelease(KeyEvent.VK_V);
						r.keyRelease(KeyEvent.VK_CONTROL);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_SPACE);
						r.keyRelease(KeyEvent.VK_SPACE);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_ENTER);
						r.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(2000);

						// Added Thangs 2011
						driver.findElement(By.xpath("//*[@id=\"data-table\"]/tbody/tr/td/div/input")).clear();
						driver.findElement(By.xpath("//*[@id=\"data-table\"]/tbody/tr/td/div/input"))
								.sendKeys(percentage);
						Thread.sleep(2000);

						driver.findElement(By.xpath("//*[@id=\"save-button\"]")).click();
						System.out.println("save clicked");
						screenShotPath = PortalPage.addScreenshot(driver);
						extendtest.log(LogStatus.PASS,
								"Value is added for Single Option" + extendtest.addScreenCapture(screenShotPath));

						Thread.sleep(2000);
					} else if (articleX.equalsIgnoreCase("Multi")) {

						driver.findElement(By.xpath("//*[@id=\"mode-multuple\"]")).click();
						System.out.println("Clicked for " + x + " Article");
						Thread.sleep(2000);

						driver.findElement(By.xpath("//*[@id=\"add-composition-button\"]")).click();
						System.out.println("Compositon clicked");
						Thread.sleep(2000);
						driver.findElement(
								By.xpath("//*[@id=\"add-modal\"]/div/div/div[2]/form/div[1]/div/button/span")).click();
						System.out.println("value dropdown clicked");
						Thread.sleep(2000);
						driver.findElement(
								By.xpath("//*[@id=\"add-modal\"]/div/div/div[2]/form/div[1]/div/div/div/input"))
								.clear();
						driver.findElement(
								By.xpath("//*[@id=\"add-modal\"]/div/div/div[2]/form/div[1]/div/div/div/input"))
								.sendKeys(compositionX);
						System.out.println("value entered");
						Thread.sleep(2000);
						Robot r = new Robot();
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_SPACE);
						r.keyRelease(KeyEvent.VK_SPACE);
						Thread.sleep(2000);

						driver.findElement(By.xpath("//*[@id=\"add-modal\"]/div/div/div[2]/form/div[2]/button[2]"))
								.click();
						System.out.println("Done button clicked");
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id=\"add-material-button\"]")).click();
						System.out.println("Material button clicked");
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						System.out.println("Fisrt TAB");
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						System.out.println("second TAB");
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						System.out.println("Third TAB");
						r.keyPress(KeyEvent.VK_SPACE);
						r.keyRelease(KeyEvent.VK_SPACE);
						System.out.println("SPace");

						String myString = materialX;
						StringSelection stringSelection = new StringSelection(myString);
						Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						clipboard.setContents(stringSelection, null);
						Thread.sleep(1000);
						System.out.println(myString);
						// logger.log(LogStatus.INFO, "Image name is "+image1);

						r.keyPress(KeyEvent.VK_CONTROL);
						r.keyPress(KeyEvent.VK_V);
						r.keyRelease(KeyEvent.VK_V);
						r.keyRelease(KeyEvent.VK_CONTROL);

						Thread.sleep(2500);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_SPACE);
						r.keyRelease(KeyEvent.VK_SPACE);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_ENTER);
						r.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(2000);

						// Added Thangs 2011
						driver.findElement(By.xpath("//*[@id=\"data-table\"]/tbody/tr[1]/td[2]/div/input")).clear();
						driver.findElement(By.xpath("//*[@id=\"data-table\"]/tbody/tr[1]/td[2]/div/input"))
								.sendKeys(percentage);
						Thread.sleep(2000);

						driver.findElement(By.xpath("//*[@id=\"save-button\"]")).click();
						System.out.println("save clicked");

						Thread.sleep(2500);
						screenShotPath = PortalPage.addScreenshot(driver);
						extendtest.log(LogStatus.PASS,
								"Value is added for Multi Option" + extendtest.addScreenCapture(screenShotPath));

						Thread.sleep(3000);
					} else {
						System.out.println("Option is not existing");
					}
				}

			} catch (Exception e) {
				// System.out.println(e);
				System.out.println("\"Element is not existing now\"");
				continue;

			}

		}

		System.out.println("new Thangs");

		driver.switchTo().defaultContent();
	}

	public static void setFactsDone(WebDriver driver, ExtentTest extendtest, String productID, String setFact1,
			String setFact2, String setFact3, String setFact4, String setFact5, String setFact6, String setFact7,
			String setFact8, String setFact9, String setFact10, ExtentReports reports)
			throws InterruptedException, AWTException {
		extendtest = reports.startTest("Verify setFacts Done Functionality for the Product");
		driver.switchTo().frame("context-editor-iframe");
		String screenShotPath = null;
		String setFactX = null;
		System.out.println("new Thangs");
		driver.findElement(By.xpath("//*[@id=\"facts-done-button\"]")).click();
		int x = 1;
		for (x = 1; x <= 5; x++) {
			try {
				if (x == 1) {
					setFactX = setFact1;
					System.out.println(setFactX);
				} else if (x == 2) {
					setFactX = setFact2;
					System.out.println(setFactX);
				} else if (x == 3) {
					setFactX = setFact3;
					System.out.println(setFactX);
				} else if (x == 4) {
					setFactX = setFact4;
					System.out.println(setFactX);
				} else if (x == 5) {
					setFactX = setFact5;
					System.out.println(setFactX);
				} else if (x == 6) {
					setFactX = setFact6;
					System.out.println(setFactX);
				} else if (x == 7) {
					setFactX = setFact7;
					System.out.println(setFactX);
				} else if (x == 8) {
					setFactX = setFact8;
					System.out.println(setFactX);
				} else if (x == 9) {
					setFactX = setFact9;
					System.out.println(setFactX);
				} else if (x == 10) {
					setFactX = setFact10;
					System.out.println(setFactX);
				} else {
					System.out.println("More than expected count of Articles?????????????");
				}
				WebElement check;
				if (setFactX.equalsIgnoreCase("Y")) {
					check = driver.findElement(By.xpath("//*[@id=\"article-list\"]/li[" + x + "]"));
					if (check.isDisplayed()) {
						driver.findElement(By.xpath("//*[@id=\"article-list\"]/li[" + x + "]")).click();
						Thread.sleep(2000);
						screenShotPath = PortalPage.addScreenshot(driver);
						extendtest.log(LogStatus.PASS, " Set Facts done is done and the flag will be changed for " + x
								+ " article " + extendtest.addScreenCapture(screenShotPath));
						Thread.sleep(3000);
						System.out.println("Clicked for " + x + " Article");
					}
				} else {
					System.out.println("Click not needed for " + x + " Article");
				}

			} catch (Exception e) {
				System.out.println("\"Element is not existing now\"");
				screenShotPath = PortalPage.addScreenshot(driver);
				extendtest.log(LogStatus.INFO, "Some issue is observed " + extendtest.addScreenCapture(screenShotPath));

				Thread.sleep(3000);
				continue;
			}
		}

		driver.findElement(By.xpath("//*[@id=\"done-button\"]")).click();
		System.out.println("new Thangs");
		driver.switchTo().defaultContent();
	}

	// Added Thangs 2011
	public static void copyCompositionAndMaterial(WebDriver driver, ExtentTest extendtest, String productID,
			String copy1, String copy2, String copy3, String copy4, String copy5, String copy6, String copy7,
			String copy8, String copy9, String copy10, String article1, String composition1, String material1,
			String percentage, ExtentReports reports) throws InterruptedException, AWTException {
		
		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Add Composition and Material for the Product and copy to articles</b></h6>");
		
		Thread.sleep(3000);
		driver.switchTo().frame("context-editor-iframe");
		String screenShotPath = null;
		String copyFactX = null;
		String articleX = null;
		String compositionX = null;
		String materialX = null;
		int y = 1;

		for (y = 1; y < 2; y++) {
			if (y == 1) {
				articleX = article1;
				compositionX = composition1;
				materialX = material1;
			}
			try {
				WebElement check;
				check = driver.findElement(By.xpath("//*[@id=\"article-list\"]/li[" + y + "]"));
				if (check.isDisplayed()) {
					driver.findElement(By.xpath("//*[@id=\"article-list\"]/li[" + y + "]")).click();
					Thread.sleep(2000);
					if (articleX.equalsIgnoreCase("Single")) {
						Locators.getXPath(SingleMode).click();
						Thread.sleep(2000);
						Locators.getXPath(AddMaterialTypeButton).click();
						Thread.sleep(4000);
						Locators.getXPath(AddMaterial).click();
						Thread.sleep(4000);
						
						Robot r = new Robot();
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(3000);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(3000);
						r.keyPress(KeyEvent.VK_SPACE);
						r.keyRelease(KeyEvent.VK_SPACE);
						Thread.sleep(3000);
						String myString = materialX;
						StringSelection stringSelection = new StringSelection(myString);
						Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						clipboard.setContents(stringSelection, null);
						Thread.sleep(5000);
						
						r.keyPress(KeyEvent.VK_CONTROL);
						r.keyPress(KeyEvent.VK_V);
						r.keyRelease(KeyEvent.VK_V);
						r.keyRelease(KeyEvent.VK_CONTROL);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_SPACE);
						r.keyRelease(KeyEvent.VK_SPACE);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_ENTER);
						r.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(2000);
						driver.switchTo().defaultContent();
						Locators.getXPath(MaterialPercentageValue).clear();
						Locators.getXPath(MaterialPercentageValue).sendKeys(percentage);
						Thread.sleep(2000);
						extendtest.log(LogStatus.PASS,"Adding material: "+material1+" and percentage: "+percentage);
						Locators.getXPath(Save).click();
						screenShotPath = PortalPage.addScreenshot(driver);
						extendtest.log(LogStatus.PASS,
								"Saving the values" + extendtest.addScreenCapture(screenShotPath));

						Thread.sleep(2000);
					} else if (articleX.equalsIgnoreCase("Multi")) {
						Locators.getXPath(MultiMode).click();// Select multi
																// mode
						Thread.sleep(2000);
						// Locators.getXPath(AddCompositionTypeButton).click();
						Locators.getID(AddCompositionTypeButton).click();// Select
																			// composition
						Thread.sleep(2000);
						Locators.getXPath(AddCompositionTypeDropDown).click();// value
																				// dropdown
																				// clicked
						Thread.sleep(2000);
						Locators.getXPath(AddCompositionTypeSearchBar).clear();
						Locators.getXPath(AddCompositionTypeSearchBar).sendKeys(compositionX);
						Thread.sleep(2000);

						Robot r = new Robot();
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_SPACE);
						r.keyRelease(KeyEvent.VK_SPACE);
						Thread.sleep(2000);

						driver.findElement(By.xpath("//button[@type='submit'][text()='Done']")).click();
						// Locators.getClassName(AddCompositionDoneButton).click();
						Thread.sleep(2000);
						Locators.getXPath(AddMaterialTypeButton).click();
						Thread.sleep(4000);

						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(3000);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(3000);
						r.keyPress(KeyEvent.VK_SPACE);
						r.keyRelease(KeyEvent.VK_SPACE);
						Thread.sleep(3000);

						// r.keyPress(KeyEvent.VK_TAB);
						// r.keyRelease(KeyEvent.VK_TAB);
						// Thread.sleep(2000);
						// r.keyPress(KeyEvent.VK_TAB);
						// r.keyRelease(KeyEvent.VK_TAB);
						// Thread.sleep(2000);
						// r.keyPress(KeyEvent.VK_TAB);
						// r.keyRelease(KeyEvent.VK_TAB);
						// Thread.sleep(2000);
						// r.keyPress(KeyEvent.VK_SPACE);
						// r.keyRelease(KeyEvent.VK_SPACE);

						String myString = materialX;
						StringSelection stringSelection = new StringSelection(myString);
						Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						clipboard.setContents(stringSelection, null);
						Thread.sleep(1000);

						r.keyPress(KeyEvent.VK_CONTROL);
						r.keyPress(KeyEvent.VK_V);
						r.keyRelease(KeyEvent.VK_V);
						r.keyRelease(KeyEvent.VK_CONTROL);

						Thread.sleep(2500);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_SPACE);
						r.keyRelease(KeyEvent.VK_SPACE);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_ENTER);
						r.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(2000);

						// System.out.println("Multi mode selected 345...");
						// driver.findElement(By.xpath("//*[@id=\"data-table\"]/tbody/tr[1]/td[2]/div/input")).clear();
						// driver.findElement(By.xpath("//*[@id=\"data-table\"]/tbody/tr[1]/td[2]/div/input"))
						// .sendKeys(percentage);
						// Thread.sleep(2000);
						//
						// driver.findElement(By.xpath("//*[@id=\"save-button\"]")).click();
						// System.out.println("save clicked");
						//
						// Thread.sleep(2500);
						Locators.getXPath(MaterialPercentageValue).clear();
						Locators.getXPath(MaterialPercentageValue).sendKeys(percentage);
						Thread.sleep(2000);
						Locators.getXPath(Save).click();
						screenShotPath = PortalPage.addScreenshot(driver);
						extendtest.log(LogStatus.PASS,
								"Value is added for Multi Option" + extendtest.addScreenCapture(screenShotPath));

						Thread.sleep(3000);
					}
				}

			} catch (Exception e) {
				// System.out.println(e);
				System.out.println("\"Element is not existing now\"");
				continue;

			}

		}

		Locators.getXPath(CopyButton).click();
		extendtest.log(LogStatus.INFO, "Copying to other articles");

		int x = 2;
		for (x = 2; x <= 5; x++) {
			try {
				if (x == 2) {
					copyFactX = copy2;
				} else if (x == 3) {
					copyFactX = copy3;
				} else if (x == 4) {
					copyFactX = copy4;
				} else if (x == 5) {
					copyFactX = copy5;
				} else if (x == 6) {
					copyFactX = copy6;
				} else if (x == 7) {
					copyFactX = copy7;
				} else if (x == 8) {
					copyFactX = copy8;
				} else if (x == 9) {
					copyFactX = copy9;
				} else if (x == 10) {
					copyFactX = copy10;
				}

				WebElement check;
		
				if (copyFactX.equalsIgnoreCase("Y")) {
					check = driver.findElement(By.xpath("//*[@id=\"article-list\"]/li[" + x + "]"));
					if (check.isDisplayed()) {
						driver.findElement(By.xpath("//*[@id=\"article-list\"]/li[" + x + "]")).click();
						Thread.sleep(2000);
					//	screenShotPath = PortalPage.addScreenshot(driver);
					//	extendtest.log(LogStatus.PASS, " Copy of Composition and Article is done for " + x + " article "
					//			+ extendtest.addScreenCapture(screenShotPath));
						Thread.sleep(3000);
					}
				}

			} catch (Exception e) {
				screenShotPath = PortalPage.addScreenshot(driver);
				extendtest.log(LogStatus.INFO, "Some Issue is observed " + extendtest.addScreenCapture(screenShotPath));

				Thread.sleep(3000);
				continue;
			}
		}

		screenShotPath = PortalPage.addScreenshot(driver);
		extendtest.log(LogStatus.PASS, " Copy of Composition and Article is done for " + x + " article "
				+ extendtest.addScreenCapture(screenShotPath));
		
		driver.findElement(By.xpath("//*[@id=\"done-button\"]")).click();
		driver.switchTo().defaultContent();
	}

	// Delete composition and material
	public static void deleteCompositionAndMaterial(WebDriver driver, ExtentTest extendtest, String productID,
			ExtentReports reports) throws InterruptedException {
		extendtest = reports.startTest("Delete Composition and Material visible for the Product");
		driver.switchTo().frame("context-editor-iframe");
		String screenShotPath = null;

		int x = 1;
		for (x = 1; x < 11; x++) {
			try {
				WebElement check, remove;
				check = driver.findElement(By.xpath("//*[@id=\"article-list\"]/li[" + x + "]"));
				if (check.isDisplayed()) {
					System.out.println("Article " + x + " is visible");
					driver.findElement(By.xpath("//*[@id=\"article-list\"]/li[" + x + "]")).click();
					Thread.sleep(2000);
					// delete xpath comes here
					remove = driver.findElement(By.xpath("//*[@id=\"remove-composition-button\"]"));

					if (remove.isDisplayed()) {
						System.out.println("Remove button is visible");
						remove.click();
						Thread.sleep(2000);
						System.out.println("Clicked on Remove Button");
						driver.findElement(By.xpath("//*[@id=\"save-button\"]")).click();
						System.out.println("save clicked");
					} else {
						System.out.println("Remove button is not visible");

						Robot r = new Robot();
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_TAB);
						Thread.sleep(2000);
						r.keyPress(KeyEvent.VK_SPACE);
						r.keyRelease(KeyEvent.VK_SPACE);
						Thread.sleep(2000);
						System.out.println("Clicked on Trash Delete Button");
						driver.findElement(By.xpath("//*[@id=\"save-button\"]")).click();
						System.out.println("save clicked");
					}

					screenShotPath = PortalPage.addScreenshot(driver);
					extendtest.log(LogStatus.PASS, "Deleting the Composition/Material for " + x + " Article"
							+ extendtest.addScreenCapture(screenShotPath));
					Thread.sleep(3000);
				} else {
					System.out.println("Article is not visible or Clcikable");
				}
			} catch (Exception e) {
				System.out.println("\"Element is not existing now\"");
				screenShotPath = PortalPage.addScreenshot(driver);
				extendtest.log(LogStatus.INFO, "Not able to delete the value. Some issue is observed "
						+ extendtest.addScreenCapture(screenShotPath));
				Thread.sleep(3000);
				continue;
			}
		}
		System.out.println("new Thangs");
		driver.switchTo().defaultContent();
	}

	// Verify in Details page, the values for the attribute 'Fieldset' is
	// matching with the values given in input data sheet
	public static void verifyFieldset(WebDriver driver, ExtentTest extendtest, String values) throws Exception {
		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: To verify the values: (not set), Accessories, Beauty, Fashion and Home is present in 'Fieldset' dropdown</b></h6>");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().refresh();
		String[] arrSplit = values.split(",");
		Locators.getName(FieldSet).click();
		WebElement fieldSet = Locators.getName(FieldSet);
		Select select = new Select(fieldSet);
		List<WebElement> allOptions = select.getOptions();
		for (String s : arrSplit) {
			boolean match = false;
			for (int i = 0; i < allOptions.size(); i++) {
				if (s.equalsIgnoreCase(allOptions.get(i).getText())) {
					match = true;
				}
			}
			if (match == true) {
				extendtest.log(LogStatus.PASS, "Fieldset " + s + " is present");
			} else {
				extendtest.log(LogStatus.FAIL, "Fieldset " + s + " is not present");
			}
		}
		Thread.sleep(2000);

	}

	// Method to update the value for attribute 'Long product name'
	public static void updateLongProductName(WebDriver driver, ExtentTest extendtest, String longProductName)
			throws Exception {
		Thread.sleep(2000);
		extendtest.log(LogStatus.INFO, "Updating Long Product Name");
		Locators.getXPath(LongProdNameEditbutton).click();
		Thread.sleep(2000);
		Select select = new Select(Locators.getXPath(LongProdNameEditLang));
		select.selectByValue("sv-SE"); // select edit lang as 'Swedish(Sweden)'
		Thread.sleep(2000);
		Locators.getXPath(LongProdNameText).click();
		Locators.getXPath(LongProdNameText).clear();
		Thread.sleep(1000);
		Locators.getXPath(LongProdNameText).sendKeys(longProductName);
		Thread.sleep(3000);
	}

	//SOMNATH RCTE
	public static void updateLongProductName1(WebDriver driver, ExtentTest extendtest, String longProductName)
			throws Exception {
		Thread.sleep(2000);
		extendtest.log(LogStatus.INFO, "Updating Long Product Name");
		Thread.sleep(5000);
		Locators.getXPath(LongProdNameEditbutton).click();
//		Select select = new Select(Locators.getXPath(LongProdNameEditLang));
//		select.selectByValue("sv-SE"); // select edit lang as 'Swedish(Sweden)'
		Thread.sleep(5000);
		Locators.getXPath(LongProdNameText).click();
		Locators.getXPath(LongProdNameText).clear();
		Thread.sleep(5000);
		Locators.getXPath(LongProdNameText).sendKeys(longProductName);
		Thread.sleep(9000);
		Locators.getXPath(Save_button).click();
		Thread.sleep(12000);
	}
	// Method to update the value for attribute 'Short product name'
	public static void updateShortProductName(WebDriver driver, ExtentTest extendtest, String shortProductName)
			throws Exception {
		Thread.sleep(2000);
		extendtest.log(LogStatus.INFO, "Updating Short Product Name");
		Thread.sleep(2000);
		Locators.getXPath(ShortProdNameEditbutton).click();
		Thread.sleep(2000);
		Select select = new Select(Locators.getXPath(ShortProdNameEditLang));
		select.selectByValue("sv-SE"); // select edit lang as 'Swedish(Sweden)'
		Thread.sleep(5000);
		Locators.getXPath(ShortProdNameText).click();
		Thread.sleep(3000);
		Locators.getXPath(ShortProdNameText).clear();
		Thread.sleep(1000);
		Locators.getXPath(ShortProdNameText).sendKeys(shortProductName);
		Thread.sleep(3000);

	}

	// Method to update the value for attribute 'Long product description'
	public static void updateLongProductDesc(WebDriver driver, ExtentTest extendtest, String longProductDesc)
			throws Exception {
		Thread.sleep(2000);
		extendtest.log(LogStatus.INFO, "Updating Long Product Description");
		Locators.getXPath(LongProdDescEditbutton).click();
		Thread.sleep(9000);
		Select select = new Select(Locators.getXPath(LongProdDescEditLang));
		select.selectByValue("sv-SE"); // select edit lang as 'Swedish(Sweden)'
		Thread.sleep(9000);
		Locators.getXPath(LongProdDescText).click();
		Locators.getXPath(LongProdDescText).clear();
		Thread.sleep(9000);
		Locators.getXPath(LongProdDescText).sendKeys(longProductDesc);
		Thread.sleep(9000);

	}

	//SOMNATHRICHTEXT EDITOR
	public static void updateLongProductDesc1(WebDriver driver, ExtentTest extendtest, String longProductDesc)
			throws Exception {
		Thread.sleep(2000);
		extendtest.log(LogStatus.INFO, "Updating Long Product Description");
		
		ProductPage.RichTextEditorTab();
		Thread.sleep(6000);
		extendtest.log(LogStatus.INFO, "Navigated to Richtexteditor tab");	
		driver.switchTo().frame("context-editor-iframe");		
		Thread.sleep(5000);
		Locators.getXPath(Richtexteditor).click();
		Thread.sleep(2000);
		//Select select = new Select(Locators.getXPath(LongProdDescEditLang));
		//select.selectByValue("sv-SE"); // select edit lang as 'Swedish(Sweden)'
		Thread.sleep(2000);
		//Locators.getXPath(LongProdDescText).click();
		Locators.getXPath(Richtexteditor).clear();
		Thread.sleep(3000);
		Locators.getXPath(Richtexteditor).sendKeys(longProductDesc);
		Thread.sleep(4000);
		Locators.getXPath(SaveRCTE).click();
		Thread.sleep(9000);
		driver.switchTo().defaultContent();
		Thread.sleep(8000);
		Locators.getID(DetailTab).click();
		Thread.sleep(2000);
		Locators.getXPath(LongProdDescRCTE).click();
		String screenShotPath1;	
		screenShotPath1 = PortalPage.addScreenshot(driver);
		extendtest.log(LogStatus.PASS, "LongDescription Updated successfully with HTML Tag. Screenshot below: " + extendtest.addScreenCapture(screenShotPath1));
		Thread.sleep(4000);
		
		//ProductPage.returnPortal();
	}
	// Method to update the value for attribute 'Locales sent for print' as 'Not set'
	public static void udpateLocalesSentForPrint(WebDriver driver, ExtentTest extendtest) throws Exception {
		String localesForPrint = Locators.getXPath(LocalesSentForPrintText).getText();
		Thread.sleep(9000);
		if (localesForPrint.equalsIgnoreCase("(not set)")) {
			extendtest.log(LogStatus.INFO, "Checking Locales sent for print is having value as (not set) inititally");
		} else {
			extendtest.log(LogStatus.INFO, "Updating Locales sent for print to (not set)");
			Locators.getXPath(LocalesSentForPrintText).click();
			Thread.sleep(2000);
			Locators.getClassName(Locales_selectAll).click();
			Thread.sleep(2000);
			Locators.getClassName(Locales_selectAll).click();
			Locators.getXPath(LocalesSentForPrintText).click();
			Thread.sleep(2000);
			Locators.getXPath(Save_button).click();
			Thread.sleep(10000);
			driver.navigate().refresh();
			Thread.sleep(10000);
		}
		Thread.sleep(3000);
	}

	// Method to update the value for attribute 'Locales sent for e-com' as 'Not set'
	public static void udpateLocalesSentForECom(WebDriver driver, ExtentTest extendtest) throws Exception {
		String localesForEcom = Locators.getXPath(LocalesSentForEComText).getText();
		Thread.sleep(8000);
		if (localesForEcom.equalsIgnoreCase("(not set)")) {
			extendtest.log(LogStatus.INFO, "Checking Locales sent for e-com is having value as (not set) initially");
		} else {
			extendtest.log(LogStatus.INFO, "Updating Locales sent for e-com to (not set)");
			Locators.getXPath(LocalesSentForEComText).click();
			Thread.sleep(2000);
			//Locators.getClassName(Locales_selectAll).click();
			Thread.sleep(2000);
			//Locators.getClassName(Locales_selectAll).click();
			//Locators.getXPath(LocalesSentForEComText).click();
			Thread.sleep(2000);
			//Locators.getXPath(Save_button).click();
			Thread.sleep(10000);
		}
		Thread.sleep(3000);
	}

	// Method to set QC for print as True and a Due date print from input data sheet
	public static void updateQCForPrint(WebDriver driver, ExtentTest extendtest, String dueDatePrint) throws Exception {
		extendtest.log(LogStatus.INFO, "Updating QC for Print as True");
		Locators.getXPath(QCForPrint_True).click();
		Thread.sleep(3000);
		extendtest.log(LogStatus.INFO, "Setting Due date print and Saving the product");
		Locators.getName(DueDatePrint).sendKeys(dueDatePrint);
		Thread.sleep(3000);
		Locators.getXPath(Save_button).click();
		Thread.sleep(12000);
		driver.navigate().refresh();
		Thread.sleep(8000);
		driver.navigate().refresh();
		Thread.sleep(10000);
	}

	// Method to set Enrichment status as Quality checked
	public static void updateQCForECom(WebDriver driver, ExtentTest extendtest) throws Exception {
		extendtest.log(LogStatus.INFO, "Updating Enrichment status as Quality checked and Saving the product");
		Thread.sleep(9000);
		Locators.getXPath(EnrichmentStatus_QualityChecked).click();
		Thread.sleep(5000);
		Locators.getXPath(Save_button).click();
		Thread.sleep(12000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(12000);
		driver.navigate().refresh();
		Thread.sleep(12000);
		
	}

	//SOMNATH RCTE
	
	
	
	// Click long product name and take screenshot to verify
	public static void verifyLongProductName(WebDriver driver, ExtentTest extendtest, String longProductName)
			throws Exception {
		Locators.getXPath(LongProdNameEditbutton).click();
		Thread.sleep(2000);
		Select select = new Select(Locators.getXPath(LongProdNameEditLang));
		select.selectByValue("sv-SE");
		Thread.sleep(1000);
		Locators.getXPath(LongProdNameText).click();
		extendtest.log(LogStatus.PASS,"Product updated with Long product name successfully");
		Thread.sleep(2000);
	}

	//SOMNATHRCTE
	public static void verifyLongProductName2(WebDriver driver, ExtentTest extendtest, String longProductName)
			throws Exception {
		Locators.getXPath(LongProdNameEditbutton).click();
		Thread.sleep(2000);
//		Select select = new Select(Locators.getXPath(LongProdNameEditLang));
//		select.selectByValue("sv-SE");
		Thread.sleep(1000);
		Locators.getXPath(LongProdNameText).click();
		extendtest.log(LogStatus.PASS,"Product updated with Long product name successfully");
		Thread.sleep(2000);
	}
	
	
	// Click Short product name and take screenshot to verify
	public static void verifyShortProductName(WebDriver driver, ExtentTest extendtest, String shortProductName)
			throws Exception {
		Thread.sleep(8000);
		Locators.getXPath(ShortProdNameEditbutton).click();
		Thread.sleep(5000);
		Select select = new Select(Locators.getXPath(ShortProdNameEditLang));
		select.selectByValue("sv-SE");
		Thread.sleep(2000);
		Locators.getXPath(ShortProdNameText).click();
		extendtest.log(LogStatus.PASS,"Product updated with Short product name successfully");
		Thread.sleep(2000);

	}

	// Click Long product description and take screenshot to verify
	public static void verifyLongProductDesc(WebDriver driver, ExtentTest extendtest, String longProductDesc)
			throws Exception {
		Locators.getXPath(LongProdDescEditbutton).click();
		Thread.sleep(2000);
		Select select = new Select(Locators.getXPath(LongProdDescEditLang));
		select.selectByValue("sv-SE");
		Thread.sleep(1000);
		Locators.getXPath(LongProdDescText).click();
		extendtest.log(LogStatus.PASS, "Product updated with Long product description successfully");
		Thread.sleep(2000);

	}

	//SOMNATH RCTE

	// Verify Locales sent for print is updated with locales
	public static void verifyLocalesSentForPrint(WebDriver driver, ExtentTest extendtest) throws Exception {
		String screenShotPath="";
		String localesForPrint = Locators.getXPath(LocalesSentForPrintText).getText();
		Locators.getXPath(ProdTransReceivedPrint_Text).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		screenShotPath = PortalPage.addScreenshot(driver);
		if (localesForPrint.equalsIgnoreCase("(not set)")) {
			extendtest.log(LogStatus.FAIL,
					"Locales sent for print is still (not set) " + extendtest.addScreenCapture(screenShotPath));
		} else {
			extendtest.log(LogStatus.PASS,
					"Locales sent for print is updated successfully " + extendtest.addScreenCapture(screenShotPath));
		}
		Thread.sleep(2000);

	}

	// Verify Locales sent for e-com is updated with locales
	public static void verifyLocalesSentForEcom(WebDriver driver, ExtentTest extendtest) throws Exception {
		driver.navigate().refresh();
		Thread.sleep(18000);
		String screenShotPath="";
		String localesForEcom = Locators.getXPath(LocalesSentForEComText).getText();
		//Locators.getXPath(ProdTransSentPrint_Text).click();
		Locators.getXPath(ProdTransReceivedEcom_Text).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(18000);
		driver.navigate().refresh();
		Thread.sleep(18000);
		driver.navigate().refresh();
		Thread.sleep(18000);
		driver.navigate().refresh();
		Thread.sleep(18000);
		screenShotPath = PortalPage.addScreenshot(driver);
		if (localesForEcom.equalsIgnoreCase("(not set)")) {
			extendtest.log(LogStatus.FAIL,
					"Locales sent for e-com is still (not set) " + extendtest.addScreenCapture(screenShotPath));
		} else {
			extendtest.log(LogStatus.PASS,
					"Locales sent for e-com is updated successfully " + extendtest.addScreenCapture(screenShotPath));
		}
		Thread.sleep(8000);

	}
	
	//SOMNATH RCTE
	
	

	// Verify info level is changed to level A from level zero and to level B in case previously it was level A
	public static void verifyInfoLevel(WebDriver driver, ExtentTest extendtest, String infoLevel) throws Exception {
		String screenShotPath;
		Thread.sleep(1000);
		Locators.getXPath(InfoLevelHistoryButton).click();
		Thread.sleep(2000);
		screenShotPath = PortalPage.addScreenshot(driver);
		if (infoLevel.equalsIgnoreCase("Level zero")) {
			Boolean infoLevelA = Locators.getXPath(InfoLevelA).isSelected();
			if (infoLevelA) {
				extendtest.log(LogStatus.PASS, "Information level updated to Level A from Level zero successfully "
						+ extendtest.addScreenCapture(screenShotPath));
			} else {
				extendtest.log(LogStatus.FAIL,
						"Information level NOT updated to Level A from Level zero" + extendtest.addScreenCapture(screenShotPath));
			}
		} else if (infoLevel.equalsIgnoreCase("Level A")) {
			Boolean infoLevelB = Locators.getXPath(InfoLevelB).isSelected();
			if (infoLevelB) {
				extendtest.log(LogStatus.PASS, "Information level updated to Level B successfully "
						+ extendtest.addScreenCapture(screenShotPath));
			} else {
				extendtest.log(LogStatus.FAIL,
						"Information level NOT updated to Level B" + extendtest.addScreenCapture(screenShotPath));
			}
		}
		Thread.sleep(2000);

	}

	/* Uncheck first two locales selected in Locales sent for print or Locales
	 sent for ecom and save the product */
	public static void unCheckLocalesSent(WebDriver driver, ExtentTest extendtest, String printOrEcom)
			throws Exception {
		Thread.sleep(5000);
		if (printOrEcom.equals("Print")) {
			Locators.getXPath(LocalesSentForPrintText).click();
		} else if (printOrEcom.equals("Ecom")) {
			Locators.getXPath(LocalesSentForEComText).click();
		}
		Thread.sleep(2000);		
		Locators.getXPath(SelectedLocale).click(); //uncheck locale selected
		Thread.sleep(2000);
		Locators.getXPath(SelectedLocale).click(); //uncheck locale selected
		Thread.sleep(2000);
		if (printOrEcom.equals("Print")) {
			Locators.getXPath(LocalesSentForPrintText).click();
		} else if (printOrEcom.equals("Ecom")) {
			Locators.getXPath(LocalesSentForEComText).click();
		}
		Thread.sleep(3000);
		Locators.getXPath(Save_button).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	// Set Translation major change as True and save the product
	public static void selectTransMajorChange(WebDriver driver, ExtentTest extendtest) throws Exception {
        String screenShotPath="";
        Thread.sleep(8000);
        Locators.getXPath(TranslationMajor).click();
        Thread.sleep(10000);
        WebElement element1 = Locators.getXPath(TransMajorChange_True);
        Thread.sleep(32000);
        Boolean flag = element1.isSelected();
        if (flag == false) {
            element1.click();
            extendtest.log(LogStatus.INFO, "Set Translation major change as True and Save the product");
        } else {
            screenShotPath = PortalPage.addScreenshot(driver);
            extendtest.log(LogStatus.FAIL, "Unable to set Translation major change as True"+ extendtest.addScreenCapture(screenShotPath));
        }
        Thread.sleep(8000);
        Locators.getXPath(Save_button).click();
        Thread.sleep(8000);
        driver.navigate().refresh();
        Thread.sleep(12000);
        driver.navigate().refresh();
        Thread.sleep(12000);
        driver.navigate().refresh();
        Thread.sleep(12000);
    }
	
	// Verify Translation major change is updated to False automatically
	public static void verifyTransMajorChange(WebDriver driver, ExtentTest extendtest) throws Exception {
		String screenShotPath="";
		driver.navigate().refresh();
		Locators.getXPath(TranslationMajor).click();
		Thread.sleep(18000);
	//	Locators.getXPath(ProductTranslationLanguages_Text).click();
	//	Thread.sleep(2000);
	//	Thread.sleep(2000);
		screenShotPath = PortalPage.addScreenshot(driver);
		//driver.navigate().refresh();
		//Thread.sleep(18000);
		Boolean flag = Locators.getXPath(TransMajorChange_True).isSelected();
		if(flag){
			extendtest.log(LogStatus.PASS, "Translation major change is automatically updated to False"
					+ extendtest.addScreenCapture(screenShotPath));
		}else{
			extendtest.log(LogStatus.PASS, "Translation major change is automatically updated to False"
					+ extendtest.addScreenCapture(screenShotPath));
		}	
	}

	/*
	 * Verify Locales sent for Print and Locales received for Print is updated
	 * if printOrEcom=print Locales sent for Ecom and Locales received for Ecom
	 * is updated if printOrEcom=ecom
	 */
	public static void verifyLocales(WebDriver driver, ExtentTest extendtest, String printOrEcom) throws Exception {
		String localesPrint="";
		String localesEcom=""; 
		String screenShotPath = "";
		Thread.sleep(3000);
		if (printOrEcom.equals("Print")) {
			localesPrint = Locators.getXPath(LocalesSentForPrintText).getText();
		} else if (printOrEcom.equals("Ecom")) {
			localesEcom = Locators.getXPath(LocalesSentForEComText).getText();
		}
		Thread.sleep(2000);
		//Locators.getXPath(ProdTransReceivedPrint).click();
		Locators.getXPath(ProdTransReceivedEcom).click();
		Thread.sleep(2000);
		screenShotPath = PortalPage.addScreenshot(driver);
		if (printOrEcom.equals("Print")) {
			if (localesPrint!=null && !localesPrint.equalsIgnoreCase("(not set)")) {
				extendtest.log(LogStatus.PASS, "Locales sent for Print and Locales received for Print is also updated successfully"
						+ extendtest.addScreenCapture(screenShotPath));
			} else {
				extendtest.log(LogStatus.FAIL,
						"Locales sent for Print is not updated" + extendtest.addScreenCapture(screenShotPath));
			}
		}
		if (printOrEcom.equals("Ecom")) {
			if(localesEcom!=null && !localesEcom.equalsIgnoreCase("(not set)")) {
				extendtest.log(LogStatus.PASS, "Locales sent for Ecom and Locales received for Ecom is also updated successfully"
						+ extendtest.addScreenCapture(screenShotPath));
			} else {
				extendtest.log(LogStatus.FAIL,
						"Locales sent for Ecom is not updated" + extendtest.addScreenCapture(screenShotPath));
			}
		}
	}

	// Verify SortBy values in RGB page
	public static void verifyRGBSortBy(WebDriver driver, ExtentTest extendtest, String values) throws Exception {
		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Verify Sort by list</b></h6>");
		String[] arrSplit = values.split(",");
		driver.switchTo().frame("context-editor-iframe");
		Locators.getID(SortBy).click();
		WebElement sortby = Locators.getID(SortBy);
		Select select = new Select(sortby);
		List<WebElement> allOptions = select.getOptions();
		for (String s : arrSplit) {
			boolean match = false;
			for (int i = 0; i < allOptions.size(); i++) {
				if (s.equalsIgnoreCase(allOptions.get(i).getText())) {
					match = true;
				}
			}
			if (match == true) {
				extendtest.log(LogStatus.PASS, "SortBy " + s + " is found");
			} else {
				extendtest.log(LogStatus.FAIL, "SortBy " + s + " is not found");
			}
		}
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	}

	// Verify swatch color and preview color is updated after clicking on color picker image
	public static void verifyColorPicker(WebDriver driver, ExtentTest extendtest) throws Exception {
		String screenShotPath1;
		String screenShotPath2;
		String screenShotPath3;
		String screenShotPath4;
		String screenShotPath5;
		String externalColorAfter, previewColorAfter, internalColor="";

		driver.switchTo().frame("context-editor-iframe");
		List<WebElement> rgbimage = Locators.getXpathList(ColorPickerImg);
				
		if (rgbimage != null && rgbimage.size() > 0) {
			extendtest.log(LogStatus.INFO, "<h6><b>Scenario 2: Verify swatch color and preview color is changed when clicking on color picker image</b></h6>");
			String previewColorBefore = Locators.getXPath(PreviewColor).getText();
			screenShotPath1 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS, "Before clicking on color picker image, the preview and swatch color is: "+previewColorBefore+" Screenshot below."
					+ extendtest.addScreenCapture(screenShotPath1));
			Thread.sleep(2000);
			WebElement rgbImage = Locators.getID(RGBImage);
			Actions builder = new Actions(driver);
			builder.moveToElement(rgbImage, 10, 25).click().build().perform();
			Thread.sleep(4000);
			previewColorAfter = Locators.getXPath(PreviewColor).getText();
			screenShotPath2 = PortalPage.addScreenshot(driver);
			
			if(previewColorBefore!=previewColorAfter){
				extendtest.log(LogStatus.PASS, 
						"After clicking on color picker image, the preview and swatch color is changed to: "+ previewColorAfter+" Screenshot below."
						+  extendtest.addScreenCapture(screenShotPath2));
			}else{
				extendtest.log(LogStatus.FAIL,
						"After clicking on color picker image, the preview and swatch color is NOT changed. Screenshot below."
						+  extendtest.addScreenCapture(screenShotPath2));
			}
			
			extendtest.log(LogStatus.INFO, "<h6><b>Scenario 3: Save the product to verify if external RGB is updated with preview color</b></h6>");
			Locators.getID(SaveButton).click();
			Thread.sleep(4000);			
			externalColorAfter = Locators.getXPath(ExternalColor).getText();
			screenShotPath3 = PortalPage.addScreenshot(driver);;
			
			if(previewColorAfter.equalsIgnoreCase(externalColorAfter)){
				extendtest.log(LogStatus.PASS, "External RGB is updated with preview color "+externalColorAfter);
			}else{
				extendtest.log(LogStatus.FAIL, "External RGB is NOT updated with preview color. Screenshot below."
						+  extendtest.addScreenCapture(screenShotPath3));
			}
				
			internalColor = Locators.getXPath(InternalColor).getText();
			extendtest.log(LogStatus.INFO, "<h6><b>Scenario 4: Verify if the internal color: "+internalColor+" and updated external color: "+externalColorAfter+" is reflected in article level for the attributes 'Internal RGB' and 'RGB' respectively</b></h6>");
			driver.switchTo().defaultContent();
			
			ProductPage.includesTab();
			Thread.sleep(3000);
				
			for(int i=1; i<=1; i++){
				driver.findElement(By.xpath("//div[@id='ProductArticle']/div[@id='relation-section-container']/div["+i+"]/div/div[@id='contextmenu']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@id='edit-entity'])["+i+"]")).click();
				Thread.sleep(2000); 
				String articleNum = Locators.getName(ArticleNumber).getAttribute("value");
				Locators.getXPath(ArticleSafetyInfo_Text).click();
				Thread.sleep(3000);
				String internalRGB = Locators.getXPath(InternalRGB).getAttribute("value");
				String rgb = Locators.getXPath(RGB).getAttribute("value");
				screenShotPath5 = PortalPage.addScreenshot(driver);
				
				if(internalRGB.equalsIgnoreCase(internalColor) && rgb.equalsIgnoreCase(externalColorAfter) ){
					extendtest.log(LogStatus.PASS,
							"Article "+articleNum+" has Internal RGB: "+internalRGB+ " and RGB: "+rgb+ " .Hence the values are updated in article level. Screenshot below, " + extendtest.addScreenCapture(screenShotPath5));
				} else{
					extendtest.log(LogStatus.FAIL,
							"Article "+articleNum+" has Internal RGB as "+internalRGB+ " and RGB as "+rgb+ " .Hence the values are NOT updated in article level. Screenshot below, " + extendtest.addScreenCapture(screenShotPath5));
				}
			}
			
			Thread.sleep(2000);		
			Locators.getID(EditCancel).click();
			Thread.sleep(3000);	
			
			ProductPage.rgbTab();
			extendtest.log(LogStatus.INFO, "Renavigating to RGB tab");			
			Thread.sleep(2000);
			driver.switchTo().frame("context-editor-iframe");
			
			extendtest.log(LogStatus.INFO, "<h6><b>Scenario 5: Verify if internal color is clicked then External and Preview color is updated with internal color.</b></h6>");
			Locators.getXPath(InternalColor_Area).click();
			Thread.sleep(2000);
			Locators.getID(SaveButton).click();
			Thread.sleep(4000);
			externalColorAfter = Locators.getXPath(ExternalColor).getText();
			previewColorAfter = Locators.getXPath(PreviewColor).getText();
			screenShotPath4 = PortalPage.addScreenshot(driver);
			
			if(internalColor.equalsIgnoreCase(externalColorAfter) && internalColor.equalsIgnoreCase(previewColorAfter)){
				extendtest.log(LogStatus.PASS, "External and Preview color is updated with Internal color successfully. Screenshot below:"
						+  extendtest.addScreenCapture(screenShotPath4));
			}else{
				extendtest.log(LogStatus.FAIL, "External and Preview color is NOT updated with Internal color. Screenshot below:"
						+  extendtest.addScreenCapture(screenShotPath4));
			}		
			
		} else {			
			Thread.sleep(2000);
			internalColor = Locators.getXPath(InternalColor).getText();
			extendtest.log(LogStatus.INFO, "<h6><b>Scenario 6: Verify RGB for a product with no color picker image in RGB page</b></h6>");
			screenShotPath5 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS, "No images displayed to update RGB. The External, Internal and Preview color is shown and the value is: "+ internalColor+" .Below is the snapshot, "
					+ extendtest.addScreenCapture(screenShotPath5));
			Thread.sleep(1000);
		}

		driver.switchTo().defaultContent();

	}

	// Function to update the product measurement values
	public static void updateMeasurements(String area, String position, String override, WebDriver driver,
			ExtentTest extendtest, int count) throws Exception {

//		WebElement sizeElement = driver
//				.findElement(By.xpath("//tr[@data-id=" + count + "]/td/select[@id='measurement-area']"));
//		Select sizeSelect = new Select(sizeElement);
//		sizeSelect.selectByValue(area);
//		Thread.sleep(2000);
//
//		driver.findElement(By.xpath("//tr[@data-id=" + count + "]/td/div[@class='ms-parent ']/button")).click();
//		driver.findElement(
//				By.xpath("//tr[@data-id=" + count + "]/td/div[@class='ms-parent ']/div[@class='ms-drop bottom']"
//						+ "/ul/li/label/input[@value='" + position + "']"))
//				.click();
//		Thread.sleep(2000);

		driver.findElement(By.xpath("(//input[@id='override-value'])[" + count + "]")).clear();
		driver.findElement(By.xpath("(//input[@id='override-value'])[" + count + "]")).sendKeys(override);
		Thread.sleep(12000);

		Boolean selected = driver.findElement(By.xpath("(//input[@id='enabled'])[" + count + "]")).isSelected();
		if (!selected) {
			driver.findElement(By.xpath("(//input[@id='enabled'])[" + count + "]")).click();
		}
		Thread.sleep(2000);

	}

	// Function to click on 'Clear all fields' button in Measurement page
	public static void clearMeasurements(WebDriver driver, ExtentTest extendtest) throws Exception {
		String screenShotPath1;	
		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 3: Verify when 'Clear all fields' option is selected then measurement values are removed</b></h6>");
		extendtest.log(LogStatus.PASS, "Selecting 'Clear all fields' button in Measurement page");
		Locators.getID(ClearMeasurement).click();
		Thread.sleep(3000);
		extendtest.log(LogStatus.PASS, "Saving the Product");
		Locators.getXPath(SaveButton).click();
		Thread.sleep(9000);
		screenShotPath1 = PortalPage.addScreenshot(driver);
		extendtest.log(LogStatus.PASS, "Measurement values are cleared successfully. Screenshot below: " + extendtest.addScreenCapture(screenShotPath1));
		Thread.sleep(8000);
	}

	// Verify No Measurements to enrich is checked or unchecked in Measurements page
	public static boolean verifyNoMeasurementsToEnrich(WebDriver driver, ExtentTest extendtest) {
		WebElement MeasurementsToEnrich = Locators.getID(NoMeasurementsToenrich);		
		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 4: Verify when 'No measurements to enrich' field is checked/unchecked, then in Details tab the field 'No measurement' is set as True/False accordingly</b></h6>");
		if (MeasurementsToEnrich.isSelected()) {
			extendtest.log(LogStatus.INFO, "No measurements to enrich is checked");
			return true;
		} else {
			extendtest.log(LogStatus.INFO, "No measurements to enrich is NOT checked");
			return false;
		}

	}

	/* Verify No measurements in Details page is checked or unchecked based on
	 	the values from No measurements to enrich in Measurements page */
	public static void verifyNoMeasurementsInDetailsPage(WebDriver driver, ExtentTest extendtest, Boolean checked)
			throws Exception {
		Boolean isSelected;
		String screenShotPath1;
		Locators.getXPath(NoOfMCharts_Label).click();
		Thread.sleep(8000);

		if (checked) {
			isSelected = Locators.getXPath(NoMeasurements_True).isSelected();
		} else {
			isSelected = Locators.getXPath(NoMeasurements_False).isSelected();
		}

		if (isSelected && checked) {
			screenShotPath1 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS, "In Details page, 'No measurements' is set as True");
		} else if (isSelected && (!checked)) {
			screenShotPath1 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS, "In Details page, 'No measurements' is set as False");
		} else {
			screenShotPath1 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS,
					"In Details page, 'No measurements' is set Incorrectly, view screenshot below: "
							+ extendtest.addScreenCapture(screenShotPath1));
		}

		Thread.sleep(5000);
	}

	/* Select No Measurements To Enrich if it is unchecked. 
	 * Deselect No Measurements To Enrich if it is checked. */
	public static Boolean setNoMeasurementsToEnrich(WebDriver driver, ExtentTest extendtest, Boolean checked)
			throws Exception {
		String screenShotPath1;
		Boolean flag;		
		Locators.getID(NoMeasurementsToenrich).click();
		Thread.sleep(8000);
		if (checked) {
			screenShotPath1 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS, "Modifying 'No measurements to enrich' as Unchecked and saving the Product "
					+ extendtest.addScreenCapture(screenShotPath1));
			flag = false;
		} else {
			extendtest.log(LogStatus.PASS, "Modifying 'No measurements to enrich' as Checked and saving the Product");
			flag = true;
		}
		Thread.sleep(8000);
		Locators.getXPath(SaveButton).click();
		Thread.sleep(15000);

		return flag;
	}

	// Set value to selected size attribute
	public static void selectSelectedSize(WebDriver driver, ExtentTest extendtest) throws Exception {
		WebElement selectedSize = Locators.getID(SelectedSize);
		Select select = new Select(selectedSize);
		select.selectByValue("3");
		Thread.sleep(2000);

	}

	// Verify JSON values are set to Measurement in cm attribute
	public static void verifyMeasurementInCm(WebDriver driver, ExtentTest extendtest) throws Exception {
		String screenShotPath1;
		Thread.sleep(2000);
		String measurement = Locators.getXPath(MeasurementInCm).getText();
		Locators.getXPath(NoOfMCharts_Label).click();
		Thread.sleep(3000);
		screenShotPath1 = PortalPage.addScreenshot(driver);
		extendtest.log(LogStatus.INFO,"<h6><b>Scenario 2: Verify 'Measurement in cm' attribute in Details page is modified</b></h6>");
		Thread.sleep(1000);
		if (measurement != "" && measurement != null) {
			extendtest.log(LogStatus.PASS, "Measurement in cm is updated with the JSON values successfully. Screenshot below: "+ extendtest.addScreenCapture(screenShotPath1));
		} else {
			extendtest.log(LogStatus.FAIL, "Measurement in cm is NOT updated with the JSON values. Screenshot below: "+ extendtest.addScreenCapture(screenShotPath1));
		}

		Thread.sleep(5000);
	}

	/*
	 * Click Add Warning type button. Select value as given in input data
	 * sheet.Click on Done. Verify warning type updated for the product
	 */
	public static void verifyAddWarmningType(WebDriver driver, ExtentTest extendtest, String addWarningType)
			throws Exception {
		String screenShotPath1 = "";
		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 2: Verify Add Warning type function by selecting a warning type in Product and verify warning type is updated</b></h6>");
		Thread.sleep(2000);
		Locators.getID(AddWarningTypeButton).click();
		
		//Locators.getID(WarningDropDownList).click();
//		List<WebElement> addWarningtypePopUp = Locators.getClassNameList(WarningDropDownList);
//		 //List<WebElement> addWarningtypePopUp = Locators.getXPath(WarningDropDownList);
//		if (addWarningtypePopUp != null && addWarningtypePopUp.size() > 0) {
//			extendtest.log(LogStatus.PASS, "Add Warning Type option is selected. Pop up displayed. Selecting warning type and saving the product.");
//		} else {
//			extendtest.log(LogStatus.FAIL, "Pop up not displayed");
//		}
	//driver.switchTo().frame("context-editor-iframe");
		//WebElement warningType = Locators.getClassName(WarningDropDownList);
//		WebElement warningType = Locators.getXPath(WarningDropDownList);
//		Select select = new Select(warningType);
//		select.selectByVisibleText(addWarningType);
		Thread.sleep(5000);
		Locators.getXPath(WarningDoneButton).click();
		Thread.sleep(3000);
		Locators.getXPath(SaveButton).click();
//		Boolean saveDispalyed = Locators.getID(SaveButton).isDisplayed();
//		if (!saveDispalyed) {
//			extendtest.log(LogStatus.FAIL,
//					"Warning type already present for the product.Please input other one in data sheet");
//		}
//		List<WebElement> saveButton = Locators.getIDList(SaveButton);
//		if (saveButton != null && saveButton.size() > 0) {
//			Locators.getID(SaveButton).click();
//		} else {
//			extendtest.log(LogStatus.FAIL,
//					"Warning type already present for product. Please change the warning in input sheet");
//		}
		Thread.sleep(3000);
		
		List<WebElement> savedWarning = driver.findElements(By.xpath("//tr/td[text()='" + addWarningType + "']"));
		if (savedWarning != null && savedWarning.size() > 0) {
			driver.findElement(By.xpath("//tr/td[text()='" + addWarningType + "']")).click();
			Thread.sleep(2000);
			screenShotPath1 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS, "Warning type updated successfully. See screenshot below: "
					+ extendtest.addScreenCapture(screenShotPath1));
		} else {
			screenShotPath1 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.FAIL, "Warning type NOT uddated successfully. See screenshot below:: "
					+ extendtest.addScreenCapture(screenShotPath1));
		}

		Thread.sleep(4000);
	}

	// Verify Warnings attribute in product details page is updated
	public static String verifyProductWarningRemoved(WebDriver driver, ExtentTest extendtest, String warningJSON) throws Exception {
		Locators.getXPath(ProdWarning).click();
		Thread.sleep(2000);
		String productWarning = Locators.getXPath(ProdWarning).getAttribute("value");
		
		if(!productWarning.toLowerCase().contains(warningJSON)){
			extendtest.log(LogStatus.PASS, "Warning attribute is updated successfully. </br>"
					+ "The attribute holds the JSON values:  "+ productWarning);
		}else{
			extendtest.log(LogStatus.FAIL, "Warning attribute is NOT updated successfully. </br>"
					+ "The attribute holds the JSON values:  "+ productWarning);
		}
		
		Thread.sleep(2000);
		return productWarning.trim();
	}
	
	// Verify Warnings attribute in product details page is updated
		public static String verifyProductWarningUpdated(WebDriver driver, ExtentTest extendtest, String warningJSON) throws Exception {
			Locators.getXPath(ProdWarning).click();
			Thread.sleep(4000);
			String productWarning = Locators.getXPath(ProdWarning).getAttribute("value");
			if(productWarning.toLowerCase().contains(warningJSON)){
				extendtest.log(LogStatus.PASS, "Warning attribute is updated successfully. </br>"
						+ "The attrbiute holds the JSON values:  "+ productWarning);
			}else{
				extendtest.log(LogStatus.FAIL, "Warning attribute is NOT updated successfully. </br>"
						+ "The attrbiute holds the JSON values:  "+ productWarning);
			}
			Thread.sleep(4000);
			return productWarning.trim();
			
		}

	// Removing a product warning type and saving the product
	public static void removeWarningType(WebDriver driver, ExtentTest extendtest, String addWarningType)
			throws Exception {
		Thread.sleep(2000);
		driver.switchTo().frame("context-editor-iframe");
		//WebElement warningType = driver.findElement(By.xpath("//tr/td[text()='" + addWarningType + "']"));
		//driver.findElement(By.xpath("//tr/td[text()='" + addWarningType + "']")).click();
		Thread.sleep(3000);
		Locators.getXPath("//*[@id='remove-warning-button']").click();
		//warningType.findElement(By.xpath("//*[@id='remove-warning-button']")).click();//*[@id="remove-warning-button"]
		//warningType.findElement(By.xpath("../td/button[@id='remove-warning-button']")).click();
		Thread.sleep(2000);
		//Locators.getID(SaveButton).click();
		Locators.getXPath(SaveButton).click();
		Thread.sleep(3000);
		extendtest.log(LogStatus.PASS, "Removing Warning type and saving the product");
	}

	/*
	 * Method to verify if product is having 'Used In' as HM_ICC_channel in
	 * overview page. Iterate through the first three products shown in searched
	 * list
	 */
	public static void verifyProductInICCChannel(WebDriver driver, ExtentTest extendtest, String productID)
			throws Exception {
		String screenShotPath1="";
		int productsCount = 2;
		List<WebElement> usedInChannel = null;
		usedInChannel = Locators.getXpathList(UsedInHnM_ICC_Channel);
		Thread.sleep(2000);
		if (usedInChannel != null && usedInChannel.size() > 0) {
			screenShotPath1 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS,
					"Product: " + productID + " is in QC status and having 'Used In' as HM_ICC_Channel, screenshot below "
							+ extendtest.addScreenCapture(screenShotPath1));
		} else {
			screenShotPath1 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.FAIL,
					"Product: " + productID + " is in QC status but NOT having 'Used In' as HM_ICC_Channel, screenshot below "
							+ extendtest.addScreenCapture(screenShotPath1));
		}

		for (int i = 2; i <= productsCount; i++) {
			driver.findElement(By.xpath("//div[@class='card-section-container']/div[" + i + "]"
					+ "/div/div/div[@class='card-text1']")).getAttribute("title");
			Thread.sleep(3000);
			driver.findElement(By.xpath(
					"//div[@class='card-section-container']/div[" + i + "]/div/div/div[@class='card-picture-area']"))
					.click();
			Thread.sleep(3000);
			usedInChannel = Locators.getXpathList(UsedInHnM_ICC_Channel);
			Thread.sleep(2000);
			if (usedInChannel != null && usedInChannel.size() > 0) {
				screenShotPath1 = PortalPage.addScreenshot(driver);
				extendtest.log(LogStatus.PASS,
						"Product: " + productID + " is in QC status and having 'Used In' as HM_ICC_Channel, screenshot below "
								+ extendtest.addScreenCapture(screenShotPath1));
			} else {
				screenShotPath1 = PortalPage.addScreenshot(driver);
				extendtest.log(LogStatus.FAIL,
						"Product: " + productID + " is in QC status but NOT having 'Used In' as HM_ICC_Channel, screenshot below "
								+ extendtest.addScreenCapture(screenShotPath1));
			}
		}
	}

	// Verifying if Used In attribute is having value as 'Not used in any channels'
	public static void verifyProductNotUsedInChannel(WebDriver driver, ExtentTest extendtest, String productID)
			throws Exception {
		String screenShotPath1;
		List<WebElement> notUsedInChannel = null;
		notUsedInChannel = Locators.getXpathList(NotUsedInChannel);
		Thread.sleep(2000);
		
		if (notUsedInChannel != null && notUsedInChannel.size() > 0) {
			screenShotPath1 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS,
					"Product: " + productID + " is not in QC status and having 'Used In' as 'Not used in any channels', screenshot below "
							+ extendtest.addScreenCapture(screenShotPath1));
		} else {
			screenShotPath1 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS,
					"Product: " + productID
							+ " is not in QC status but NOT having 'Used In' as 'Not used in any channels', screenshot below "
							+ extendtest.addScreenCapture(screenShotPath1));
		}
		Thread.sleep(2000);

	}

	// Verify Used in attribute is updated to HM_ICC_Channel
	public static void verifyChannelUpdated(WebDriver driver, ExtentTest extendtest) throws Exception {
		String screenShotPath1;
		List<WebElement> usedInChannel = null;
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.navigate().refresh();
		usedInChannel = Locators.getXpathList(UsedInHnM_ICC_Channel);
		Thread.sleep(5000);
		
		if (usedInChannel != null && usedInChannel.size() > 0) {
			screenShotPath1 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS, "Used In is modified as HM_ICC_Channel successfully, screenshot below "
					+ extendtest.addScreenCapture(screenShotPath1));
		} else {
			screenShotPath1 = PortalPage.addScreenshot(driver);
			extendtest.log(LogStatus.PASS, "Used In is NOT modified as HM_ICC_Channel, screenshot below "
					+ extendtest.addScreenCapture(screenShotPath1));
		}

		Thread.sleep(2000);
	}

	// Function to set values for split attributes of style and descriptive length
	public static void setStyleAndDescLength_Fashion(WebDriver driver, ExtentTest extendtest, String assortmentType,
			String sleeveStyle, String necklineStyle, String collarStyle, String clothingStyle, String garmentLength,
			String sleeveLength, String heelHeight, String waistRise) throws Exception {
		
		extendtest.log(LogStatus.INFO, "Setting values to new style and descriptive length attributes");
		
		Thread.sleep(2000);	
		Locators.getXPath(AssortmentType_Clothing).click();
		//Change sleeve style to not set and then select the values from input sheet
		Locators.getXPath(SleeveStyle_Dropdown).click();
		Thread.sleep(3000);
		Locators.getXPath(SleeveStyle_SelectAll).click();
		Thread.sleep(2000);
		Locators.getXPath(SleeveStyle_SelectAll).click();
		selectSleeveStyle(driver, sleeveStyle);
		Locators.getXPath(SleeveStyle_Dropdown).click();
		Thread.sleep(2000);
		//Change neckline style to not set and then select the values from input sheet
		Locators.getXPath(NeckLineStyle_Dropdown).click();
		Thread.sleep(3000);
		Locators.getXPath(NeckLineStyle_SelectAll).click();
		Thread.sleep(2000);
		Locators.getXPath(NeckLineStyle_SelectAll).click();
		selectNecklineStyle(driver, necklineStyle);
		Locators.getXPath(NeckLineStyle_Dropdown).click();
		Thread.sleep(2000);
		//Change collar style to not set and then select the values from input sheet
		Locators.getXPath(CollarStyle_Dropdown).click();
		Thread.sleep(3000);
		Locators.getXPath(CollarStyle_SelectAll).click();
		Thread.sleep(2000);
		Locators.getXPath(CollarStyle_SelectAll).click();
		selectCollarStyle(driver, collarStyle);
		Locators.getXPath(CollarStyle_Dropdown).click();
		Thread.sleep(2000);
		//Change clothing style to not set and then select the values from input sheet
		Locators.getXPath(ClothingStyle_Dropdown).click();
		Thread.sleep(3000);
		Locators.getXPath(ClothingStyle_SelectAll).click();
		Thread.sleep(2000);
		Locators.getXPath(ClothingStyle_SelectAll).click();
		selectClothingStyle(driver, clothingStyle);
		Locators.getXPath(ClothingStyle_Dropdown).click();
		Thread.sleep(2000);	 
			
		Locators.getXPath(GarmentLength_Dropdown).click();
		Thread.sleep(3000);
		Locators.getXPath(GarmentLength_SelectAll).click();
		Thread.sleep(2000);
		Locators.getXPath(GarmentLength_SelectAll).click();
		selectGarmentLength(driver, garmentLength);
		Locators.getXPath(GarmentLength_Dropdown).click();
		Thread.sleep(2000);
		
	/*	Locators.getID(GarmentLength_SelectAll).click();
		Thread.sleep(2000);
		Locators.getID(GarmentLength_SelectAll).click();
		selectGarmentLength(driver, garmentLength);
		Thread.sleep(2000); */
		
		Locators.getID(SleeveLength_SelectAll).click();
		Thread.sleep(2000);
		Locators.getID(SleeveLength_SelectAll).click();
		selectSleeveLength(driver, sleeveLength);
		Thread.sleep(2000);
		
		Locators.getID(Heelheight_SelectAll).click();
		Thread.sleep(2000);
		Locators.getID(Heelheight_SelectAll).click();
		selectHeelHeight(driver, heelHeight);
		Thread.sleep(2000);
		
		Locators.getID(WaistRise_SelectAll).click();
		Thread.sleep(2000);
		Locators.getID(WaistRise_SelectAll).click();
		selectWaistRise(driver, waistRise);
		Thread.sleep(2000);
		
		Locators.getXPath(Save_button).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
			
	}

	
	/** Function to verify if original style attribute holds all the values set for its splitted attributes 
	 * @author tempbasir
	 * @param driver
	 * @param extendtest
	 * @param sleeveStyle
	 * @param necklineStyle
	 * @param collarStyle
	 * @param clothingStyle
	 * @throws Exception
	 */

	public static void verifyStyle_Fashion(WebDriver driver, ExtentTest extendtest, String sleeveStyle, 
			String necklineStyle, String collarStyle, String clothingStyle) throws Exception {
		
		Locators.getXPath(Style).click();
		Thread.sleep(3000);
		//List<WebElement> styleList = driver.findElements(By.xpath("//div[@name='Fields_68_Value']/div/div/ul/li[@checked='checked']"));
		List<WebElement> styleList = driver.findElements(By.xpath("//div[@fieldtypeid='ProductStyle']/fieldset/div[2]/div/div/div/div/ul/li[@checked='checked']"));
		Thread.sleep(2000);
		String originalStyle = "";
		String style;
		Boolean flag = true;
		
		for(int i=1;i<styleList.size()+1;i++) {			
			//style = driver.findElement(By.xpath("//div[@name='Fields_68_Value']/div/div/ul/li[@checked='checked']["+i+"]/label/span")).getText();
			style = driver.findElement(By.xpath("//div[@fieldtypeid='ProductStyle']/fieldset/div[2]/div/div/div/div/ul/li[@checked='checked']["+i+"]/label/span")).getText();
				if(i==styleList.size()){
					originalStyle=originalStyle.concat(style);
				} else{
					originalStyle=originalStyle.concat(style+", ");
				}				
		}
		extendtest.log(LogStatus.INFO, "Values set for new Style attributes is: "+sleeveStyle+","+necklineStyle+","+collarStyle+","+clothingStyle);
		extendtest.log(LogStatus.INFO, "Values updated for Original Style attribute is: "+originalStyle);
		
		if(sleeveStyle!=""){
			if(!originalStyle.contains(sleeveStyle)){
				flag = false; }
		} if(necklineStyle!=""){
			if(!originalStyle.contains(necklineStyle)){
				flag = false; }
		} if(collarStyle!=""){
			if(!originalStyle.contains(collarStyle)){
				flag = false; }
		} if(clothingStyle!="") {
			if(!originalStyle.contains(clothingStyle)){
				flag = false; }
		}
		
		if(flag){
			extendtest.log(LogStatus.PASS, "Hence, Original Style attribute updated automatically with same values");
		}
		else{
			extendtest.log(LogStatus.FAIL, "Original Style attribute NOT updated successfully");
		}
		
		Locators.getXPath(Style).click();
		Thread.sleep(2000);
	}

	
	/** Function to verify if original Descriptive length holds all the values set for its splitted desc length attributes
	 * @author tempbasir
	 * @param driver
	 * @param extendtest
	 * @param garmentLength
	 * @param sleeveLength
	 * @param heelHeight
	 * @param waistRise
	 * @throws Exception
	 */
	public static void verifyDescLength_Fashion(WebDriver driver, ExtentTest extendtest, String garmentLength, String sleeveLength, String heelHeight, String waistRise) throws Exception {		
		Locators.getXPath(DescLength).click();
		Thread.sleep(3000);
		List<WebElement> descLengthList = driver.findElements(By.xpath("//div[@fieldtypeid='ProductDescriptiveLength']/fieldset/div[2]/div/div/div/div/ul/li[@checked='checked']"));
		Thread.sleep(2000);
		String originalDescLegth = "";
		String desclength;
		Boolean flag = true;
		
		for(int i=1;i<descLengthList.size()+1;i++) {			
			desclength = driver.findElement(By.xpath("//div[@fieldtypeid='ProductDescriptiveLength']/fieldset/div[2]/div/div/div/div/ul/li[@checked='checked']["+i+"]/label/span")).getText();
				if(i==descLengthList.size()){
					originalDescLegth=originalDescLegth.concat(desclength);
				} else{
					originalDescLegth=originalDescLegth.concat(desclength+", ");
				}			
		}
		extendtest.log(LogStatus.INFO, "Values set for new Descriptive length attributes is: "+garmentLength+","+sleeveLength+","+heelHeight+","+waistRise);
		extendtest.log(LogStatus.INFO, "Values updated for Original Descriptive length attribute is: "+originalDescLegth);
		
		if(garmentLength!=""){
			if(!originalDescLegth.contains(garmentLength)){
				flag = false; }
		} if(sleeveLength!=""){
			if(!originalDescLegth.contains(sleeveLength)){
				flag = false; }
		} if(heelHeight!=""){
			if(!originalDescLegth.contains(heelHeight)){
				flag = false; }
		} if(waistRise!="") {
			if(!originalDescLegth.contains(waistRise)){
				flag = false; }
		}
		
		if(flag){
			extendtest.log(LogStatus.PASS, "Hence, Original Descriptive length attribute updated automatically with same values");
		}
		else{
			extendtest.log(LogStatus.FAIL, "Original Descriptive length attribute NOT updated successfully");
		}
				
	}
	
	// Function to remove all the values set for splitted style and desc length attributes
	public static void removeStyleAndDescLength_Fashion(WebDriver driver, ExtentTest extendtest) throws Exception {
		
		Locators.getXPath(SleeveStyle_Dropdown).click();
		Thread.sleep(3000);
		Locators.getXPath(SleeveStyle_SelectAll).click();
		Thread.sleep(2000);
		Locators.getXPath(SleeveStyle_SelectAll).click();
		Thread.sleep(2000);
		Locators.getXPath(SleeveStyle_Dropdown).click();
		Thread.sleep(2000);
		//Change neckline style to not set and then select the values from input sheet
		Locators.getXPath(NeckLineStyle_Dropdown).click();
		Thread.sleep(3000);
		Locators.getXPath(NeckLineStyle_SelectAll).click();
		Thread.sleep(2000);
		Locators.getXPath(NeckLineStyle_SelectAll).click();
		Thread.sleep(2000);
		Locators.getXPath(NeckLineStyle_Dropdown).click();
		Thread.sleep(2000);
		//Change collar style to not set and then select the values from input sheet
		Locators.getXPath(CollarStyle_Dropdown).click();
		Thread.sleep(3000);
		Locators.getXPath(CollarStyle_SelectAll).click();
		Thread.sleep(2000);
		Locators.getXPath(CollarStyle_SelectAll).click();
		Thread.sleep(2000);
		Locators.getXPath(CollarStyle_Dropdown).click();
		Thread.sleep(2000);
		//Change clothing style to not set and then select the values from input sheet
		Locators.getXPath(ClothingStyle_Dropdown).click();
		Thread.sleep(3000);
		Locators.getXPath(ClothingStyle_SelectAll).click();
		Thread.sleep(2000);
		Locators.getXPath(ClothingStyle_SelectAll).click();
		Thread.sleep(2000);
		Locators.getXPath(ClothingStyle_Dropdown).click();
		Thread.sleep(2000);	 
		
		Locators.getXPath(GarmentLength_Dropdown).click();
		Thread.sleep(3000);
		Locators.getXPath(GarmentLength_SelectAll).click();
		Thread.sleep(2000);
		Locators.getXPath(GarmentLength_SelectAll).click();
		Thread.sleep(2000);
		Locators.getXPath(GarmentLength_Dropdown).click();
		Thread.sleep(2000);
		
		Locators.getID(SleeveLength_SelectAll).click();
		Thread.sleep(2000);
		Locators.getID(SleeveLength_SelectAll).click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		
		Locators.getID(Heelheight_SelectAll).click();
		Thread.sleep(2000);
		Locators.getID(Heelheight_SelectAll).click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		
		Locators.getID(WaistRise_SelectAll).click();
		Thread.sleep(2000);
		Locators.getID(WaistRise_SelectAll).click();
		Thread.sleep(2000);
		
		Locators.getXPath(Save_button).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	// Verify if Original Style and Descriptive length is 'Not set'
	public static void verifyStyleAndDecLength_NOtSet(WebDriver driver, ExtentTest extendtest) throws Exception {
		Locators.getXPath(InfoLevel_Title).click();
		Thread.sleep(3000);
		
		String style = Locators.getXPath(Style_placeholder).getText();
		Thread.sleep(2000);
		String descLength = Locators.getXPath(DescLength_placeholder).getText();
		Thread.sleep(2000);
		if(style.equalsIgnoreCase("(not set)")){
			extendtest.log(LogStatus.PASS, "Original Style attribute updated as (not set) successfully");
		}else{
			extendtest.log(LogStatus.FAIL, "Original Style attribute updated as (not set) successfully");
		}
		
		if(descLength.equalsIgnoreCase("(not set)")){
			extendtest.log(LogStatus.PASS, "Original Descriptive length attribute updated as (not set) successfully");
		}else{
			extendtest.log(LogStatus.FAIL, "Original Descriptive length attribute updated as (not set) successfully");
		}
		
	}
	
	/** Function to increase magnifier and check if media image size is also increased in the Media page
	 * @author tempbasir
	 * @param driver
	 * @param extendtest
	 * @throws Exception
	 */
	public static void verifyMediaImageMaximized(WebDriver driver, ExtentTest extendtest) throws Exception {
		String screenShotPath="";
		int widthBefore,heightBefore,widthAfter,heightAfter = 0;		
		widthBefore = Locators.getXPath(MediaImage).getSize().getWidth();
		heightBefore = Locators.getXPath(MediaImage).getSize().getHeight();		
		Thread.sleep(5000);
		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 1: Verify when magnifier is increased then Media Thumbnail image size is also increased</b></h6>");
		screenShotPath = PortalPage.addScreenshot(driver);
		extendtest.log(LogStatus.INFO,
				"Image size before increasing magnifier is "+widthBefore+" x "+heightBefore  + extendtest.addScreenCapture(screenShotPath));
		WebElement slider = Locators.getXPath(MediaSlider);
		Actions builder = new Actions(driver);		
		Action action = builder.dragAndDropBy(slider, 30, 0).build();
		action.perform();		
		Thread.sleep(5000);
		widthAfter = Locators.getXPath(MediaImage).getSize().getWidth();
		heightAfter = Locators.getXPath(MediaImage).getSize().getHeight();
		screenShotPath = PortalPage.addScreenshot(driver);
		
		if(widthAfter>widthBefore && heightAfter>heightBefore){
			extendtest.log(LogStatus.PASS,
					"Image size after increasing magnifier is "+widthAfter+" x "+heightAfter+ "</br>"
							+ "Hence, Image size is increased. Below is the screenshot, " + extendtest.addScreenCapture(screenShotPath));
		} else{
			extendtest.log(LogStatus.FAIL,
					"Image size after increasing magnifier is "+widthAfter+" x "+heightAfter+ "</br>"
							+ "Hence, Image size is NOT increased. Below is the screenshot, " + extendtest.addScreenCapture(screenShotPath));
		}

	}

	/** Function to verify 'Show all' option in the Media page
	 * @author tempbasir
	 * @param driver
	 * @param extendtest
	 * @throws Exception
	 */
//	public static void verifyShowAll(WebDriver driver, ExtentTest extendtest) throws Exception {
//		String screenShotPath="";
//		extendtest.log(LogStatus.INFO, "<h6><b>Scenario 2: Verify 'Show all' option</b></h6>");
//		Thread.sleep(5000);
//		List<WebElement> mediaImageCount_Bef = Locators.getXpathList(MediaImage);
//		Locators.getID(ShowAll_Checkbox).click();
//		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//		Thread.sleep(14000);
//		List<WebElement> mediaImageCount_Aft = Locators.getXpathList(MediaImage);
//		screenShotPath = PortalPage.addScreenshot(driver);
//		if(mediaImageCount_Aft.size()>mediaImageCount_Bef.size()){
//			extendtest.log(LogStatus.PASS,
//					"Media images from linked articles is displayed when 'Show all' is selected"
//							+ extendtest.addScreenCapture(screenShotPath));
//		} else{
//			extendtest.log(LogStatus.FAIL,
//					"Media images from linked articles is NOT displayed when 'Show all' is not selected"
//							+ extendtest.addScreenCapture(screenShotPath));
//		}
//		Thread.sleep(12000);
//		Locators.getID(ShowAll_Checkbox).click();
//		Thread.sleep(12000);		//	}

}


