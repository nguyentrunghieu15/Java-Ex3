package Model;

import org.json.simple.JSONObject;

@XMLName(value = "company")
public class Company {

	private String name;
	private String catchPhrase;
	private String bs;

	public Company(JSONObject company) {
		super();
		this.name = company.get("name").toString();
		this.catchPhrase = company.get("catchPhrase").toString();
		this.bs = company.get("bs").toString();
	}

	public Company(String name, String catchPhrase, String bs) {
		super();
		this.name = name;
		this.catchPhrase = catchPhrase;
		this.bs = bs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

}
