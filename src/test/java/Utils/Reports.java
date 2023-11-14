package Utils;

import com.relevantcodes.extentreports.ExtentReports;

public class Reports {

	public void generateReport(String testscript){
		ExtentReports reports;	
		String path = System.getProperty("user.dir");
		//reports = new ExtentReports("C:\\Users\\tempbasir\\Desktop\\Thangs01\\TAP\\Reports\\PIM_Reports.html");
		reports = new ExtentReports(path+"\\Reports\\"+testscript+".html");
		
		//String path = System.getProperty("user.dir");
	//	System.out.println("dir:"+path);
	}
	public static void main(String arg[]) {
		String path = System.getProperty("user.dir");
		System.out.println("dir:"+path+"\\Reports\\"+"test.html");
	}

	
}
