package Model;

public class Absence {
	public String absence_id;
	public String student_id;
	public String application_date;
	public String absence_date;
	public String absence_reason;
	public String review_status;

	public String getAbsence_id() {
		return absence_id;
	}

	public void setAbsence_id(String absence_id) {
		this.absence_id = absence_id;
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

	public String getAbsence_date() {
		return absence_date;
	}

	public void setAbsence_date(String absence_date) {
		this.absence_date = absence_date;
	}

	public String getAbsence_reason() {
		return absence_reason;
	}

	public void setAbsence_reason(String absence_reason) {
		this.absence_reason = absence_reason;
	}

	public String getReview_status() {
		return review_status;
	}

	public void setReview_status(String review_status) {
		this.review_status = review_status;
	}

}
