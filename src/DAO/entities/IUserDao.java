package DAO.entities;

import java.sql.SQLException;
import java.util.List;

import beans.Product;
import beans.User;

public interface IUserDao {
	
	public User save(User a) throws SQLException;
	public List<User> UserParMC(String mc);
	public User update(User a);
	public void deleteUser(int id);
	public User getUser(String Email, String password) throws SQLException;

}
