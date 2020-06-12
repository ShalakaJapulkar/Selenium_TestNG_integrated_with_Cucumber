package Resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;

	public static ExtentReports getReportObject() {
		// TODO Auto-generated method stub
		String timestamp = new SimpleDateFormat("dd.MMM.yyyy_hh.mm.ss").format(new Date());
		
		String path = System.getProperty("user.dir")+"\\ExtentReport\\Report_"+timestamp+".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("E2E Project");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", System.getProperty("user.name"));
		return extent;
	}
	
	
}
