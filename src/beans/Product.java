package beans;

import java.io.InputStream;

public class Product {
	int id;
	String title;
	float prix;
	byte[] image;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Product(String title, float prix, byte[] image) {
		super();
		this.title = title;
		this.prix = prix;
		this.image = image;
	}
	public Product(int id,String title, float prix, byte[] image) {
		super();
		this.id = id;
		this.title = title;
		this.prix = prix;
		this.image = image;
	}
	public Product(){
		super();
	}
	
	
	
	
}
