package metier.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.entities.IProductDao;
import beans.Product;

public class ProductDaoImplementation implements IProductDao{

	
	
	
	public ProductDaoImplementation() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public Product save(Product a) throws SQLException {
		// TODO Auto-generated method stub
        PreparedStatement ps = null;

        Connection connection = DAO.entities.Connection.getConnection();
        	ps = connection.prepareStatement("INSERT INTO public.produit(title,image,prix) VALUES (?, ?, ?)");
        	ps.setString(1, a.getTitle());
        	ps.setBytes(2, a.getImage());
        	ps.setFloat(3, a.getPrix());
            ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("SELECT Max(id) FROM public.produit");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()){
				a.setId(rs.getInt("max"));
			}
		ps.close();
		return a;
	}
	

	@Override
	public List<Product> PriductParMC(String mc) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = DAO.entities.Connection.getConnection();
		List<Product> product = new ArrayList<Product>();
			PreparedStatement ps = connection.prepareStatement("SELECT id, title, image, prix FROM public.produit where title Like ?");
			ps.setString(1, "%"+ mc + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Product a = new Product();
				a.setId(rs.getInt("id"));
				a.setTitle(rs.getString("title"));
				a.setPrix(rs.getFloat("prix"));
				a.setImage(rs.getBytes("image"));
				product.add(a);
			}
			
	

		return product;
	}

	@Override
	public Product update(Product a) throws SQLException {
		// TODO Auto-generated method stub
			Connection connection = DAO.entities.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE public.produit SET title=?, image=?, prix=? WHERE id = ?");
			ps.setString(1,a.getTitle());
			ps.setFloat(3,a.getPrix());
			ps.setBytes(2, a.getImage());
			ps.setInt(4,a.getId());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("Select Max(id) as MAXID from public.produit where id = ?");
			ps2.setInt(1,a.getId());
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				a.setId(rs.getInt("MAXID"));
			}
			ps.close();
		
		return  a;
	}

	@Override
	public void deleteProduct(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = DAO.entities.Connection.getConnection();
		PreparedStatement ps = connection.prepareStatement("DELETE FROM produit WHERE id=?");
		ps.setInt(1,id);
		ps.executeUpdate();
	}

	@Override
	public Product getProduct(int id){
		// TODO Auto-generated method stub
		Connection connection = DAO.entities.Connection.getConnection();
		Product product = new Product();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT id, title, image, prix FROM public.produit where id = ?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Product a = new Product();
				a.setId(rs.getInt("id"));
				a.setTitle(rs.getString("title"));
				a.setPrix(rs.getFloat("prix"));
				a.setImage(rs.getBytes("image"));
				product = a;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return product;
		
	}

	@Override
	public List<Product> getAllProduct(){
		// TODO Auto-generated method stub
		Connection connection = DAO.entities.Connection.getConnection();
		List<Product> product = new ArrayList<Product>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM public.produit ORDER BY id ASC ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product a = new Product();
				a.setId(rs.getInt("id"));
				a.setTitle(rs.getString("title"));
				a.setPrix(rs.getFloat("prix"));
				a.setImage(rs.getBytes("image"));
				product.add(a);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

			
	

		return product;
	}
	
	

}
