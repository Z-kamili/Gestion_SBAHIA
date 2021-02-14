package DAO.entities;

import java.sql.SQLException;

import beans.Product;
import beans.VoteProduct;

public interface IVoteDao {

	public VoteProduct getProductVote(int id);
	public void setProductVote(int id_user,int id_prd) throws SQLException;
	
	
}
