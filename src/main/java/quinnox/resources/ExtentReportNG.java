package quinnox.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	
	
public static ExtentReports getReportobject() {
	
	String path = System.getProperty("user.dir") + "//reports//index.html";

	ExtentSparkReporter reporter = new ExtentSparkReporter(path);

	reporter.config().setReportName("Web Automation file");
	reporter.config().setDocumentTitle("testA Results");

	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);

	extent.setSystemInfo("Tester", "Ajeet kumar");

return extent;
	
	
}
}