package Model;

public class Member {
	private String member_id;
	private String member_name;
	private String member_month;
	private String member_password;
	private String member_teacher_id;
	private String member_subteacher_id;

	public Member() {
	}

	public Member(String member_id, String member_password) {
		this.member_id = member_id;
		this.member_password = member_password;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_month() {
		return member_month;
	}

	public void setMember_month(String member_month) {
		this.member_month = member_month;
	}

	public String getMember_password() {
		return member_password;
	}

	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}
	public String getMember_teacher_id() {
		return member_teacher_id;
	}

	public void setMember_teacher_id(String member_teacher_id) {
		this.member_teacher_id = member_teacher_id;
	}

	public String getMember_subteacher_id() {
		return member_subteacher_id;
	}

	public void setMember_subteacher_id(String member_subteacher_id) {
		this.member_subteacher_id = member_subteacher_id;
	}
}
