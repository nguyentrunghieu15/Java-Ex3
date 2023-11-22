package Model;

import org.json.simple.JSONObject;

public class User {

	private int id;
	private String name;

	@XMLName(value = "username")
	private String userName;

	private String email;
	@XMLObject
	private Address address;
	private String phone;
	private String website;


	@XMLObject
	private Company company;

	public User(JSONObject user) {
		super();
		this.id = Integer.parseInt(user.get("id").toString());
		this.name = user.get("name").toString();
		this.userName = user.get("username").toString();
		this.email = user.get("email").toString();
		this.phone = user.get("phone").toString();
		this.website = user.get("website").toString();
		this.address = new Address((JSONObject) user.get("address"));
		this.company = new Company((JSONObject) user.get("company"));
	}

	public User(int id, String name, String userName, String email, String phone, String website, Address address,
			Company company) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.website = website;
		this.address = address;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
