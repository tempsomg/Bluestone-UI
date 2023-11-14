package Utils;
 
import com.relevantcodes.extentreports.ExtentReports;
 
//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
 
public class ExtentManager {
 
    private static ExtentReports extent;
 
    public synchronized static ExtentReports getReporter(String filename){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir+"\\Reports\\"+filename+".html");
        }
        return extent;
    }
}