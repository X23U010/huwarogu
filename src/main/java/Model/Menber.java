package Model;

public class Menber {
	private String menber_id;
	private String menber_name;
	private String menber_month;
	private String menber_password;

	public Menber() {
	}

	public Menber(String menber_id, String menber_password) {
		this.menber_id = menber_id;
	    this.menber_password = menber_password;
	}

	public String getMenber_id() {
		return menber_id;
	}

	public void setMenber_id(String menber_id) {
		this.menber_id = menber_id;
	}

	public String getMenber_name() {
		return menber_name;
	}

	public void setMenber_name(String menber_name) {
		this.menber_name = menber_name;
	}

	public String getMenber_month() {
		return menber_month;
	}

	public void setMenber_month(String menber_month) {
		this.menber_month = menber_month;
	}

	public String getMenber_password() {
		return menber_password;
	}

	public void setMenber_password(String menber_password) {
		this.menber_password = menber_password;
	}

}
