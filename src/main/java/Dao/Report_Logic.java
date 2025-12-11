package Dao;

import Model.Report;

public class Report_Logic {
	
	public boolean execute(Report report) {
		
		Report_Dao report_Dao = new Report_Dao();
		boolean isSubmit = report_Dao.Report_Submit(report);
		
	return isSubmit;
	
	}
}
