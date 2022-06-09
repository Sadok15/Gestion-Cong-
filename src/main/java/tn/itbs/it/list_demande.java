package tn.itbs.it;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octest.beans.Demande;
import com.octest.beans.Users;
import com.octest.dao.DaoFactory;
import com.octest.dao.DemandeDao;

/**
 * Servlet implementation class list_demande
 */
@WebServlet("/list_demande")
public class list_demande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DemandeDao demandeDao;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.demandeDao = (DemandeDao) daoFactory.getDemandeDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id_user =  (int) session.getAttribute("id_user");
		String role =  (String) session.getAttribute("role");
		List<Demande> ListDemandes = new ArrayList<Demande>();
		 
		ListDemandes = demandeDao.get(id_user, role);
		request.setAttribute("ListDemandes", ListDemandes);
		request.getRequestDispatcher("./List_demande.jsp").forward(request,response);
		
		
		for (int i = 0; i < ListDemandes.size(); i++) {
			Demande demande = new Demande();
			demande = ListDemandes.get(i);
			System.out.println( demande.getDuree());
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		String id_demande = request.getParameter("id_demande");
		demandeDao.update_status(Integer.parseInt(id_demande), status);
		
		
		doGet(request, response);
	}


}
