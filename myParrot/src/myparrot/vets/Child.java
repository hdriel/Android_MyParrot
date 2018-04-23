package myparrot.vets;


public class Child {

    private String city, clinic, hours, note, phone, adress , link;
    private int Image;
    
    
    
	public Child(String city, String clinic, String hours, String note,
			String phone, String adress, String link, int image) {
		this.city = city;
		this.clinic = clinic;
		this.hours = hours;
		this.note = note;
		this.phone = phone;
		this.adress = adress;
		this.link = link;
		Image = image;
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Child() {
		this.city = "";
		this.clinic = "";
		this.hours = "";
		this.note = "";
		this.phone = "";
		this.adress = "";
		Image = 0;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getClinic() {
		return clinic;
	}
	public void setClinic(String clinic) {
		this.clinic = clinic;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getImage() {
		return Image;
	}
	public void setImage(int image) {
		Image = image;
	}

    
}