package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.entities.IUserDao;
import beans.User;
import metier.entities.UserDaoImplementation;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserDao metier;
	String pwd;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    @Override
 public void init() throws ServletException {
 	// TODO Auto-generated method stub
 	metier = new UserDaoImplementation();
 }
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }
    


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Inscription.jsp").forward(request,response);

		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			System.out.println("error");
			String name = request.getParameter("name");
			String email = request.getParameter("Email");
			String password = request.getParameter("password");
			String Role = "client";
			User user = metier.save(new User(name,email,password,Role));
			request.getRequestDispatcher("Login.jsp").forward(request,response);
		}catch(SQLException e) {
			request.setAttribute("error",e.getMessage());
			request.getRequestDispatcher("Inscription.jsp").forward(request,response);
		}
		
	}

}
