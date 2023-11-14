package Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {
	
	static WebDriver driver;
	
		public Locators(WebDriver driver) {
			Locators.driver = driver;
		}
	
	    public static WebElement getID(String abc)
	    {
			return driver.findElement(By.id(abc));
	    }
	    public static WebElement getName(String abc)
	    {
			return driver.findElement(By.name(abc));
	    }
	    public static WebElement getXPath(String abc)
	    {
			return driver.findElement(By.xpath(abc));
	    }
	
	    public static WebElement getCSS(String abc)
	    {
			return driver.findElement(By.cssSelector(abc));
	    }
	
	    public static WebElement getLinkText(String abc)
	    {
			return driver.findElement(By.linkText(abc));
	    }
	    
	    public static WebElement getPartialLinkText(String abc)
	    {
			return driver.findElement(By.partialLinkText(abc));
	    }
	
	    public static WebElement getClassName(String abc)
	    {	        
			return driver.findElement(By.className(abc));
	    }


		public static java.util.List<WebElement> getXpathList(String abc) 
		{
			return driver.findElements(By.xpath(abc));	
		}


		public static List<WebElement> getClassNameList(String abc) 
		{			
			return driver.findElements(By.className(abc));
		}
		
		public static List<WebElement> getIDList(String abc)
	    {	        
			return driver.findElements(By.id(abc));
	    }
	

}
