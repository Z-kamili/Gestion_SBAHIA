package DAO.entities;

import java.sql.SQLException;
import java.util.List;

import beans.Product;

public interface IProductDao {
	
	public Product save(Product a) throws SQLException ;
	public List<Product> PriductParMC(String mc) throws SQLException;
	public Product update(Product a) throws SQLException;
	public void deleteProduct(int id) throws SQLException;
	public Product getProduct(int id);
	public List<Product> getAllProduct();

}
