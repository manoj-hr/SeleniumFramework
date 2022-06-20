package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
    static ExtentReports reporter;

    public static ExtentReports getExtentReport() {
        String path=System.getProperty("user.dir")+"\\ExtentReports\\index.html";
        ExtentSparkReporter reports=new ExtentSparkReporter(path);
        reports.config().setDocumentTitle("Test Results");
        reports.config().setReportName("Framework Results");

        reporter=new ExtentReports();
        reporter.attachReporter(reports);
        reporter.setSystemInfo("Tester", "Manoj");
        return reporter;
    }
}
