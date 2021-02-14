package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.entities.IProductDao;
import DAO.entities.IVoteDao;
import beans.Product;
import beans.User;
import beans.VoteProduct;
import metier.entities.ProductDaoImplementation;
import metier.entities.Votecounte;

/**
 * Servlet implementation class ControllerGestionProduct
 */
@WebServlet("/ControllerGestionProduct")
public class ControllerGestionProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IProductDao Prd; 
	IVoteDao vr;
	VoteProduct Pv;
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerGestionProduct() {
        super();
        // TODO Auto-generated constructor stub
        Prd = new ProductDaoImplementation();
        vr = new Votecounte();
        Pv = new VoteProduct();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		  if(path.equals("/Add_Fav.test_2")){
			  int id_produit = Integer.parseInt(request.getParameter("id"));
			  User user_2 = (User)session.getAttribute(ATT_SESSION_USER);
			  try {
				   vr.setProductVote(user_2.getId(),id_produit);
				   response.sendRedirect("/Prj/Show.test_2");
			  }catch(SQLException e) {
				  response.sendRedirect("/Prj/Show.test_2");
			  }			 
		  }else if(path.equals("/Show.test_2")) {
				List<Product> P = Prd.getAllProduct();
				List<String> imagelist = new ArrayList<String>();
				List<Integer> num_vote = new ArrayList<Integer>();
				for (Product p : P){	
				Pv = vr.getProductVote(p.getId());
				System.out.println(p.getId());
				num_vote.add(Pv.getNum_vote());
				System.out.println(num_vote.get(0));
				byte[] imageBytes = p.getImage();
				imagelist.add(Base64.getEncoder().encodeToString(imageBytes));
				}
				request.setAttribute("images",imagelist);
				request.setAttribute("product",P);
				request.setAttribute("num_vote",num_vote);
				for(int i=0;i<P.size();i++) {
					
					System.out.println(P.get(i).getPrix());
					
				}
				request.getRequestDispatcher("Product.jsp").forward(request,response);
			  
		  }
		

		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
