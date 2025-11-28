package Dao;

import Model.Report;

public class Report_Logic {
	public boolean execute(Report report) {
		submit_report report_sub = new submit_report();
		boolean isSubmit = report_sub.Submit_Report(report);
		
	return isSubmit;
	}
}
