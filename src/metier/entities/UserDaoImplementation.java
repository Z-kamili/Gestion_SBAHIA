package metier.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import DAO.entities.IProductDao;
import DAO.entities.IUserDao;
import beans.Product;
import beans.User;

public class UserDaoImplementation implements IUserDao{
	User a;
	@Override
	public User save(User user) throws SQLException  {
		
			Connection connection = DAO.entities.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO  \"User\" (role_user, email, password, name) VALUES (?, ?, ?, ?);");
			ps.setString(1,user.getRole());
			ps.setString(2,user.getEmail());
			ps.setString(3,user.getPassword());
			ps.setString(4,user.getName());
			ps.executeUpdate();
			ps.close();
		return user;
	}

	@Override
	public List<User> UserParMC(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(String Email, String password) throws SQLException {
	boolean test = false;
	a = new User();
			Connection connection = DAO.entities.Connection.getConnection();	
			PreparedStatement ps = connection.prepareStatement("SELECT id_user, name, email, role_user, password FROM public.\"User\"");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(Email + " " + rs.getString("email"));
			    if(Email.equals(rs.getString("email")) && password.equals(rs.getString("password"))){
					a.setEmail(rs.getString("email"));
			    	a.setRole(rs.getString("role_user"));
			    	a.setPassword(rs.getString("password"));
			    	test = true;
			    	break;
			    	
			    }
			
			}
			if(test == false){
				a.setEmail("vide");
				a.setRole("vide");
			}

			return a;
	}
	
}






