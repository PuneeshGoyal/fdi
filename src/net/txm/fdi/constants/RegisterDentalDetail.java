package net.txm.fdi.constants;

public class RegisterDentalDetail
{
	String name;
	String email;
	String profession;
	String country;
	String webDentist;
	String dentalPractice;
	int id;


	
	public RegisterDentalDetail()
	{
		
	}
	
	public RegisterDentalDetail(String name, String email, String profession,
                                String country,
                                  String webDentist,
                                String dentalPractice)
	{
		this.name=name;
		this.email=email;
		this.profession=profession;
		this.country=country;
		this.webDentist=webDentist;
		this.dentalPractice=dentalPractice;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getWebDentist() {
		return webDentist;
	}
	public void setWebDentist(String webDentist) {
		this.webDentist = webDentist;
	}
	public String getDentalPractice() {
		return dentalPractice;
	}
	public void setDentalPractice(String dentalPractice) {
		this.dentalPractice = dentalPractice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
