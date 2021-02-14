package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;

public class Traitement {
    User a;
    
    
	public Traitement() {
		super();
	}


	public User Auth(String Email, String password) throws SQLException {
	boolean test = false;
	a = new User();
			Connection connection = DAO.entities.Connection.getConnection();	
			PreparedStatement ps = connection.prepareStatement("SELECT id_user, name, email, role_user, password FROM public.\"User\"");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    if(Email.equals(rs.getString("email")) && password.equals(rs.getString("password"))){
			    	a.setId(rs.getInt("id_user"));
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
