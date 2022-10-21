package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	public static ExtentReports getReports() {
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("ExtentReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Reported By", "Prasad");
		extent.setSystemInfo("Testing Type", "Regression");
		return extent;
	}

}
