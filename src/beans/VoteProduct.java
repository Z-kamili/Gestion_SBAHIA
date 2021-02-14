package beans;

public class VoteProduct {
private int id_product;
private int num_vote;
public int getId_product() {
	return id_product;
}
public void setId_product(int id_product) {
	this.id_product = id_product;
}
public int getNum_vote() {
	return num_vote;
}
public void setNum_vote(int num_vote) {
	this.num_vote = num_vote;
}
public VoteProduct(int id_product, int num_vote) {
	super();
	this.id_product = id_product;
	this.num_vote = num_vote;
}
public VoteProduct() {
	super();
	// TODO Auto-generated constructor stub
}




}
