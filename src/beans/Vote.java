package beans;

public class Vote {

	private int id_user;
	private int id_product;
	
	public Vote(int id_user, int id_product) {
		super();
		this.id_user = id_user;
		this.id_product = id_product;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_product() {
		return id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	
	
	
}
