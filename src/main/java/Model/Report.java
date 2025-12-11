package Model;

public class Report {
	private String report_id;
	private String student_id;
	private String application_date;
	private String company_name;
	private String location;
	private String activity_date;
	private String start_time;
	private String end_time;
	private String reason;
	private String report_details;
	private boolean review_status;
	private String submission_status;

	public String getReport_id() {
		return report_id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getApplication_date() {
		return application_date;
	}

	public void setApplication_date(String application_date) {
		this.application_date = application_date;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getActivity_date() {
		return activity_date;
	}

	public void setActivity_date(String activity_date) {
		this.activity_date = activity_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReport_details() {
		return report_details;
	}

	public void setReport_details(String report_details) {
		this.report_details = report_details;
	}

	public boolean getReview_status() {
		return review_status;
	}

	public void setReview_status(boolean review_status) {
		this.review_status = review_status;
	}

	public String getSubmission_status() {
		return submission_status;
	}

	public void setSubmission_status(String submission_status) {
		this.submission_status = submission_status;
	}

	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}

}
