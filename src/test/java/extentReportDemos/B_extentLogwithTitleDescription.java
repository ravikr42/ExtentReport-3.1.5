package extentReportDemos;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class B_extentLogwithTitleDescription {

	public static void main(String[] args) {

		System.out.println("Start");

		// Report will generate in Project Directory only.
		// After execution, refresh project directory.
		ExtentHtmlReporter htmlreport = new ExtentHtmlReporter(".\\Report\\extentLog with Title Description.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(htmlreport);

		// This is the object of extentTest class, by which log is generate.
		ExtentTest testlog;

		// Customize Report property
		htmlreport.config().setReportName("Test Report");
		reports.setSystemInfo("Host Name", "Test Host");
		reports.setSystemInfo("Environment", "Automation Testing");
		reports.setSystemInfo("User Name", "QA Automation");
		htmlreport.config().setDocumentTitle("Automation Report");
		htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);

		// Two default theme of report
		htmlreport.config().setTheme(Theme.STANDARD);
		// htmlreport.config().setTheme(Theme.DARK);

		testlog = reports.createTest("Test Log Method-1");
		testlog.info("This is Info log");
		testlog.pass("This is Pass log");
		testlog.fail("This is Fail log");
		testlog.error("This is Error log");

		testlog = reports.createTest("Test Log Method-2", "<br/>"
				+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry." + "<br/><br/>"
				+ "<b>Where can I get some?</b>" + "<br/>"
				+ "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.");
		testlog.log(Status.INFO, "This is Info log");
		testlog.log(Status.PASS, "This is Pass log");
		testlog.log(Status.FAIL, "This is Fail log");

		testlog = reports.createTest("Test log with Extent Color");
		testlog.log(Status.INFO, MarkupHelper.createLabel("This is Info log", ExtentColor.ORANGE));
		testlog.log(Status.PASS, MarkupHelper.createLabel("This is pass log", ExtentColor.CYAN));

		// If flush method did not call, Report will not generate.
		reports.flush();
		System.out.println("End");
	}
}
