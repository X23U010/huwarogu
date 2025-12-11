package Model;

public class Member {
	private String member_id;
	private String member_name;
	private String member_month;
	private String member_password;

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

}
