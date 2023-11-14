package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.Locators;
import Utils.webElements;

public class EnrichPage implements webElements {

	// Enter search text in the search box and search for the item
	public static void searchProduct(String search) throws Exception {
		Locators.getClassName(TopHeaderTitle ).click();
		Thread.sleep(5000);
		Locators.getClassName(SearchBar).sendKeys(search);
		Thread.sleep(4000);
		Locators.getClassName(SearchBarSubmit).submit();		
		Thread.sleep(7000);
		

	}

	public static void openCampaign(WebDriver driver, String code) throws Exception {
		driver.findElement(By.xpath("//div[@title='" + code + "']")).click();
		Thread.sleep(3000);
	}

	/**
	 * @author tempbasir
	 * @param driver
	 * @param extendtest
	 * @throws Exception
	 */
	public static void verifyWorkarea(WebDriver driver, ExtentTest extendtest) throws Exception {

		java.util.List<WebElement> parentWorkareaList = null;
		WebElement parentWorkarea = null;
		java.util.List<WebElement> childWorkareaList = null;
		WebElement childWorkarea = null;
		WebElement arrow = null;
		String parentWorkareaName, childWorkareName = "";
		parentWorkareaList = Locators.getXpathList(ParentWorkareaNodes);

		for (int i = 1; i < parentWorkareaList.size() + 1; i++) {

			int yArrowCoord;
			String className = driver.findElement(By.xpath("//*[@id='s_00000000-0000-0000-0000-000000000000']/"
					+ "ul[@class='jstree-children']/li[@role='treeitem'][" + i + "]")).getAttribute("class");

			if (className.equalsIgnoreCase("jstree-node  jstree-closed")
					|| className.equalsIgnoreCase("jstree-node  jstree-closed jstree-last")) {
				arrow = driver.findElement(By.xpath("//*[@id='s_00000000-0000-0000-0000-000000000000']/"
						+ "ul[@class='jstree-children']/li[@role='treeitem'][" + i
						+ "]/i[@class='jstree-icon jstree-ocl']"));

				parentWorkareaName = driver.findElement(By.xpath("//*[@id='s_00000000-0000-0000-0000-000000000000']/"
						+ "ul[@class='jstree-children']/li[@role='treeitem'][" + i + "]/a[@class='jstree-anchor']"))
						.getText();

				yArrowCoord = arrow.getLocation().y;
				Thread.sleep(2000);
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + (yArrowCoord - 150) + ")");
				Thread.sleep(3000);
				arrow.click();
				Thread.sleep(2000);

				childWorkareaList = driver.findElements(By.xpath("//*[@id='s_00000000-0000-0000-0000-000000000000']/"
						+ "ul[@class='jstree-children']/li[@role='treeitem'][" + i
						+ "]/ul[@role='group']/li[@role='treeitem']"));

				for (int j = 1; j < childWorkareaList.size() + 1; j++) {

					int childCoord;
					childWorkarea = driver.findElement(By.xpath("//*[@id='s_00000000-0000-0000-0000-000000000000']/"
							+ "ul[@class='jstree-children']/li[@role='treeitem'][" + i
							+ "]/ul[@role='group']/li[@role='treeitem'][" + j + "]"));

					childWorkareName = driver.findElement(By.xpath("//*[@id='s_00000000-0000-0000-0000-000000000000']/"
							+ "ul[@class='jstree-children']/li[@role='treeitem'][" + i
							+ "]/ul[@role='group']/li[@role='treeitem'][" + j + "]/" + "a[@class='jstree-anchor']"))
							.getText();

					childCoord = childWorkarea.getLocation().y;

					Thread.sleep(2000);
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + (childCoord - 150) + ")");
					Thread.sleep(3000);

					childWorkarea.click();
					Thread.sleep(8000);

					if (driver.findElements(By.className("card-section-container")).size() > 0) {
						Thread.sleep(1000);
						driver.navigate().back();
						extendtest.log(LogStatus.PASS,
								"No error message displayed in the workarea: " + childWorkareName);
						Thread.sleep(2000);
					} else if (!Locators.getXPath(LoadingData_Msg).isDisplayed()) {
						Thread.sleep(2000);
						String screenShotPath1 = PortalPage.addScreenshot(driver);
						extendtest.log(LogStatus.INFO, "Snapshot of the workarea with no products/articles"
								+ extendtest.addScreenCapture(screenShotPath1));
						driver.navigate().back();
						Thread.sleep(2000);
					} else {
						Thread.sleep(40000);
						try {
							if (driver.findElements(By.className("card-section-container")).size() > 0) {
								Thread.sleep(2000);
								driver.navigate().back();
								extendtest.log(LogStatus.PASS,
										"No error message displayed in the workarea: " + childWorkareName);
								Thread.sleep(2000);
							} else {
								Thread.sleep(2000);
								String screenShotPath2 = PortalPage.addScreenshot(driver);
								extendtest.log(LogStatus.FAIL, "Error message is displayed in the workarea: "
										+ childWorkareName + " " + extendtest.addScreenCapture(screenShotPath2));
								driver.navigate().back();
								Thread.sleep(2000);
								driver.navigate().refresh();
								Thread.sleep(8000);
							}
						} catch (TimeoutException e) {
							String screenShotPath3 = PortalPage.addScreenshot(driver);
							extendtest.log(LogStatus.FAIL, "Page unresponsive pop up displayed for workarea: "
									+ childWorkareName + " " + extendtest.addScreenCapture(screenShotPath3));
						}
					}

					Thread.sleep(2000);

					if (j < childWorkareaList.size()) {
						driver.navigate().refresh();
						arrow = driver.findElement(By.xpath("//*[@id='s_00000000-0000-0000-0000-000000000000']/"
								+ "ul[@class='jstree-children']/li[@role='treeitem'][" + i
								+ "]/i[@class='jstree-icon jstree-ocl']"));
						yArrowCoord = arrow.getLocation().y;
						Thread.sleep(2000);
						((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + (yArrowCoord - 150) + ")");
						Thread.sleep(2000);
						arrow.click();
					}
					Thread.sleep(1000);
				}
				Thread.sleep(2000);
			}

			else {
				int parentCoord;
				parentWorkarea = driver.findElement(By.xpath("//*[@id='s_00000000-0000-0000-0000-000000000000']/"
						+ "ul[@class='jstree-children']/li[@role='treeitem'][" + i + "]"));

				Thread.sleep(4000);

				parentWorkareaName = driver.findElement(By.xpath("//*[@id='s_00000000-0000-0000-0000-000000000000']/"
						+ "ul[@class='jstree-children']/li[@role='treeitem'][" + i + "]/a[@class='jstree-anchor']"))
						.getText();

				if (parentWorkarea.isDisplayed() && parentWorkarea.isEnabled()) {
					parentCoord = parentWorkarea.getLocation().y;
					Thread.sleep(2000);
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + (parentCoord - 150) + ")");
					Thread.sleep(3000);
					parentWorkarea.click();
				} else {
					parentCoord = parentWorkarea.getLocation().y;
					Thread.sleep(2000);
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + (parentCoord - 150) + ")");
					Thread.sleep(3000);
					parentWorkarea.click();
				}
				Thread.sleep(8000);

				if (driver.findElements(By.className("card-section-container")).size() > 0) {
					Thread.sleep(2000);
					driver.navigate().back();
					extendtest.log(LogStatus.PASS, "No error message displayed in the workarea: " + parentWorkareaName);
					Thread.sleep(2000);
				} else if (!Locators.getXPath(LoadingData_Msg).isDisplayed()) {
					Thread.sleep(2000);
					String screenShotPath3 = PortalPage.addScreenshot(driver);
					extendtest.log(LogStatus.INFO, "Snapshot of the workarea with no products/articles"
							+ extendtest.addScreenCapture(screenShotPath3));
					driver.navigate().back();
					Thread.sleep(2000);
				} else {
					Thread.sleep(25000);
					if (driver.findElements(By.className("card-section-container")).size() > 0) {
						driver.navigate().back();
						extendtest.log(LogStatus.PASS,
								"No error message displayed in the workarea: " + parentWorkareaName);
						Thread.sleep(2000);
					} else {
						Thread.sleep(2000);
						String screenShotPath4 = PortalPage.addScreenshot(driver);
						extendtest.log(LogStatus.FAIL, "Error message is displayed in the workarea: " + childWorkareName
								+ " " + extendtest.addScreenCapture(screenShotPath4));
						driver.navigate().back();
						Thread.sleep(2000);
						driver.navigate().refresh();
						Thread.sleep(8000);
					}

				}
			}
		}
		Thread.sleep(2000);
	}

	public static void quickSearch2(String searchKey, String searchValue, WebDriver driver, ExtentTest extendtest)
			throws Exception {
		String screenShotPath1;
		EnrichPage.searchProduct(searchValue);
		Thread.sleep(2000);
		screenShotPath1 = PortalPage.addScreenshot(driver);
		List<WebElement> searchResult = Locators.getXpathList(NoSearchResult);
		if (searchResult != null && searchResult.size() > 0) {
			extendtest.log(LogStatus.FAIL, "No Search result found for " + searchKey + "='" + searchValue + "' ");
		} else {
			extendtest.log(LogStatus.INFO, "Search result found for " + searchKey + "='" + searchValue + "' "
					+ extendtest.addScreenCapture(screenShotPath1));
		}

	}
	
	
	public static void quickSearch(String searchKey, String searchValue, WebDriver driver, ExtentTest extendtest)
			throws Exception {
		String screenShotPath1;
		EnrichPage.searchProduct(searchValue);
		Thread.sleep(5000);
		screenShotPath1 = PortalPage.addScreenshot(driver);
	    extendtest.log(LogStatus.PASS, "Article is found " + extendtest.addScreenCapture(screenShotPath1));
//		screenShotPath1 = PortalPage.addScreenshot(driver);
//		List<WebElement> searchResult = Locators.getXpathList(NoSearchResult);
//		if (searchResult != null && searchResult.size() > 0) {
//			extendtest.log(LogStatus.FAIL, "No Search result found for " + searchKey + "='" + searchValue + "' ");
//		} else {
//			extendtest.log(LogStatus.INFO, "Search result found for " + searchKey + "='" + searchValue + "' "
//					+ extendtest.addScreenCapture(screenShotPath1));
//		}
	    driver.findElement(By.xpath("//*[@id='card-555630']")).click();
	    Thread.sleep(3000);
		Thread.sleep(4000);
		ProductPage.detailsTab();
		Thread.sleep(3000);
		screenShotPath1 = PortalPage.addScreenshot(driver);
	    extendtest.log(LogStatus.PASS, "Article selected to check the sustainablity details" + extendtest.addScreenCapture(screenShotPath1));
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("(//*[@id='category-field-container']/div[6]/fieldset/div[1]/div/div)[2]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//*[@id='category-field-container']/div[4]/fieldset/div[1]/div/div)[2]")).click();
	    Thread.sleep(3000);	
	    driver.findElement(By.xpath("(//*[@id='view-history-button'])[12]")).click();
	    Thread.sleep(3000);
	    screenShotPath1 = PortalPage.addScreenshot(driver);
	    extendtest.log(LogStatus.PASS, "Article sustainablity details" + extendtest.addScreenCapture(screenShotPath1));
	    Thread.sleep(3000);
	    ProductPage.compositionTab();
	    Thread.sleep(5000);
	    driver.switchTo().frame("context-editor-iframe");
	    driver.findElement(By.xpath("//*[@id='data-table']")).click();
	    Thread.sleep(5000);
	    screenShotPath1 = PortalPage.addScreenshot(driver);
	    extendtest.log(LogStatus.PASS, "Article sustainablity details in composition Page" + extendtest.addScreenCapture(screenShotPath1));
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
	}

//////////////////////////////////////////////////////////////SOmnathComp//////////////////////////////////////////////////////////
public static void quickSearch1(String searchKey1, String searchValue1, WebDriver driver,String Value , ExtentTest extendtest)
		throws Exception {
	String screenShotPath1;
	EnrichPage.searchProduct(searchValue1);
	Thread.sleep(5000);
	screenShotPath1 = PortalPage.addScreenshot(driver);
    extendtest.log(LogStatus.PASS, "Article is found " + extendtest.addScreenCapture(screenShotPath1));
//	screenShotPath1 = PortalPage.addScreenshot(driver);
//	List<WebElement> searchResult = Locators.getXpathList(NoSearchResult);
//	if (searchResult != null && searchResult.size() > 0) {
//		extendtest.log(LogStatus.FAIL, "No Search result found for " + searchKey + "='" + searchValue + "' ");
//	} else {
//		extendtest.log(LogStatus.INFO, "Search result found for " + searchKey + "='" + searchValue + "' "
//				+ extendtest.addScreenCapture(screenShotPath1));
//	}
    driver.findElement(By.xpath("//*[@id='card-554609']")).click();
    Thread.sleep(3000);
	Thread.sleep(4000);
	ProductPage.detailsTab();
	Thread.sleep(3000);
	screenShotPath1 = PortalPage.addScreenshot(driver);
    extendtest.log(LogStatus.PASS, "Article selected to check the Composition details" + extendtest.addScreenCapture(screenShotPath1));
    Thread.sleep(3000);
    ProductPage.compositionTab();
    Thread.sleep(5000);
    driver.switchTo().frame("context-editor-iframe");
    driver.findElement(By.xpath("//*[@id='data-table']")).click();
    Thread.sleep(5000);
//    driver.switchTo().defaultContent();
//	Thread.sleep(4000);
    screenShotPath1 = PortalPage.addScreenshot(driver);
    extendtest.log(LogStatus.PASS, "Article is updated with single composition type	" + extendtest.addScreenCapture(screenShotPath1));
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@id='article-list']/li[4]/div[2]")).click();
    Thread.sleep(3000);
//    driver.switchTo().frame("context-editor-iframe");
//	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='data-table']")).click();
	Thread.sleep(5000);
//	driver.findElement(By.xpath("//*[@id='mode-multuple']")).click();
//    Thread.sleep(3000);
//    driver.findElement(By.xpath("//*[@id='data-table']/thead/tr/th[1]/div/button")).click();
//    Thread.sleep(3000);
//    driver.findElement(By.xpath("//*[@id='data-table']/thead/tr/th[1]/div/div/ul/li[2]")).click();
//    Thread.sleep(3000);
//    driver.findElement(By.xpath("//*[@id='data-table']/thead/tr/th[2]/div/button")).click();
//    Thread.sleep(3000);
//    driver.findElement(By.xpath("//*[@id='data-table']/thead/tr/th[2]/div/div/ul/li[3]/label/input")).click();
//    Thread.sleep(3000);
//    driver.findElement(By.xpath("//*[@id='add-composition-button']")).click();
//    Thread.sleep(3000);
//    driver.findElement(By.xpath("//*[@id='data-table']/tbody/tr/td[2]/div/input")).clear();
//    Thread.sleep(3000);
//    driver.findElement(By.xpath("//*[@id='data-table']/tbody/tr/td[2]/div/span")).click();
//    Thread.sleep(3000);
//    driver.findElement(By.xpath("//*[@id='data-table']/tbody/tr/td[2]/div/input")).sendKeys(Value);
//    Thread.sleep(3000);
//    driver.findElement(By.xpath("//*[@id='save-button']")).click();
//    Thread.sleep(3000);
    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0, 350)");
    screenShotPath1 = PortalPage.addScreenshot(driver);
    extendtest.log(LogStatus.PASS, "Article is updated with Multiple composition type	" + extendtest.addScreenCapture(screenShotPath1));
    driver.switchTo().defaultContent();
	Thread.sleep(3000);
	}
}
