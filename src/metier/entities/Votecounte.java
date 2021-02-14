package metier.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.entities.IVoteDao;
import beans.Product;
import beans.VoteProduct;

public class Votecounte implements IVoteDao{

	@Override
	public VoteProduct getProductVote(int id) {
		Connection connection = DAO.entities.Connection.getConnection();
		VoteProduct Vproduct = new  VoteProduct();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT  produit_id,count(*) as num FROM public.vote where  produit_id = ? group by produit_id");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vproduct.setId_product(rs.getInt("produit_id"));
				Vproduct.setNum_vote(rs.getInt("num"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Vproduct;
	}

	@Override
	public void setProductVote(int id_user,int id_product) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = DAO.entities.Connection.getConnection();
		PreparedStatement ps = connection.prepareStatement("INSERT INTO public.vote(user_id, produit_id) VALUES (?, ?)");
		ps.setInt(1,id_user);
		ps.setInt(2,id_product);
		ps.executeUpdate();
		ps.close();
	}
	
	
	
	


	
	
	

}
