package web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

import DAO.entities.IProductDao;
import beans.Product;
import metier.entities.ProductDaoImplementation;

/**
 * Servlet implementation class ControllerProduct
 */
@WebServlet("/ControllerProduct")
@MultipartConfig(maxFileSize = 16177215)
public class ControllerProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int id;
	IProductDao Prd;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerProduct() {
        super();
        Prd = new ProductDaoImplementation();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
	  if(path.equals("/Add_product.test")){
		  
		  request.getRequestDispatcher("Add_product.jsp").forward(request,response);
		  
	  }else if(path.equals("/Delete.test")){
			System.out.println("hello");
			int id =  Integer.parseInt(request.getParameter("id"));
			try {
				Prd.deleteProduct(id);
				response.sendRedirect("search.test?motCle=");
			}catch(SQLException e) {
				request.getRequestDispatcher("Adminpanel.jsp").forward(request,response);
			}

		}else if(path.equals("/search.test")){
			String motCle = request.getParameter("motCle");
			try {
				List<Product> product = Prd.PriductParMC("%" +motCle+ "%");
				List<String> imagelist = new ArrayList<String>();
				for (Product p : product) {
					byte[] imageBytes = p.getImage();
					System.out.println(imageBytes);
					imagelist.add(Base64.getEncoder().encodeToString(imageBytes));
				}
				request.setAttribute("images",imagelist);
				request.setAttribute("product",product);
				request.getRequestDispatcher("Adminpanel.jsp").forward(request,response);
			}catch(SQLException e) {
				System.out.println(e.getMessage());
				request.getRequestDispatcher("Adminpanel.jsp").forward(request,response);	
			}
		}else if(path.equals("/Edit.test")){			
			ControllerProduct.id =  Integer.parseInt(request.getParameter("id"));
			Product p = Prd.getProduct(id);
			request.setAttribute("product",p);
			request.getRequestDispatcher("update_product.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
        if(path.equals("/Add_product.test")){
			String title = request.getParameter("title");
			float price = Float.parseFloat(request.getParameter("price"));
			InputStream inputStream = null;
	        Part filePart = request.getPart("image");
	        if (filePart != null) {
	            inputStream = filePart.getInputStream();
	        } 
	        byte[] image = IOUtils.toByteArray(inputStream);
			try {
				System.out.println("success");
				Product a = Prd.save(new Product(title, price,image));
				response.sendRedirect("search.test?motCle=");
			}catch(SQLException e){
				System.out.println("Erreur");
				request.setAttribute("erreur",e.getMessage());
				request.getRequestDispatcher("Adminpanel.jsp").forward(request,response);
				
			}
		}else if(path.equals("/Update.test")) {
			String title = request.getParameter("title");
			float price = Float.parseFloat(request.getParameter("price"));
			InputStream inputStream = null;
	        Part filePart = request.getPart("image");
	        if (filePart != null) {
	            inputStream = filePart.getInputStream();
	        } 
	        byte[] image = IOUtils.toByteArray(inputStream);
			try {
				System.out.println(title + " " + price + " " + ControllerProduct.id );
				System.out.println("success");
				Product a = Prd.update(new Product(ControllerProduct.id,title, price,image));
				response.sendRedirect("search.test?motCle=");
			}catch(SQLException e){
				System.out.println(e.getMessage());
				request.setAttribute("erreur",e.getMessage());
				request.getRequestDispatcher("update_product.jsp").forward(request,response);
			}
		}

			
       
	}

}
