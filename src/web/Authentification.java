package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.entities.IProductDao;
import DAO.entities.IUserDao;
import Service.Traitement;
import beans.Product;
import beans.User;
import metier.entities.ProductDaoImplementation;
import metier.entities.UserDaoImplementation;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserDao metier;
	private Traitement auth; 
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	    /**
     * @see HttpServlet#HttpServlet()
     */
    @Override
 public void init() throws ServletException {
 	// TODO Auto-generated method stub
 	metier = new UserDaoImplementation();
 	auth = new Traitement();
 }

    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public  boolean validate_email(String email) {
		Pattern regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = regex.matcher(email);
		return matcher.find();
	}
	
	public boolean validate_password(String password) {
		boolean test = true;
		if(password.length() < 8){
			
			test = false;
			
		}
		
		return test;
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Login.jsp").forward(request,response);

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email = request.getParameter("Email");
		String password = request.getParameter("password");
		User a = new User(null,email,password,null);
		if(!validate_email(email) && !validate_password(password)) {
			request.setAttribute("error","email or password incorect");
			request.getRequestDispatcher("Login.jsp").forward(request,response);
		}else {
			try {
				User user = auth.Auth(a.getEmail(),a.getPassword());
				if(user.getRole().equals("client")){
					session.setAttribute( ATT_SESSION_USER,user);
					User user_2 = (User) session.getAttribute(ATT_SESSION_USER);
					System.out.println("email" + user_2.getId());
					response.sendRedirect("/Prj/Show.test_2");
				}else if(user.getRole().equals("Admin")){
					session.setAttribute( ATT_SESSION_USER,user);
					request.getRequestDispatcher("Adminpanel.jsp").forward(request,response);
				}else {
					session.setAttribute( ATT_SESSION_USER,null);
					request.setAttribute("error","email or password incorect");
					request.getRequestDispatcher("Login.jsp").forward(request,response);
				}
			}catch(SQLException e) {
				request.setAttribute("error",e.getMessage());
				request.getRequestDispatcher("Login.jsp").forward(request,response);
			}
		}


	}

}
