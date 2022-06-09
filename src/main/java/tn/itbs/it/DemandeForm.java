package tn.itbs.it;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octest.beans.Demande;
import com.octest.dao.DaoFactory;
import com.octest.dao.DemandeDao;

/**
 * Servlet implementation class Demande
 */
@WebServlet("/DemandeForm")
public class DemandeForm extends HttpServlet {
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("titre");
		String date_deb = request.getParameter("date_deb");
		String duree = request.getParameter("duree");
		String description = request.getParameter("description");
		
		Demande demande = new Demande();
		
		demande.setDate_debut(date_deb);
		demande.setDescription(description);
		demande.setDuree(Integer.parseInt(duree));
		demande.setTitre(titre);
		
		
		// get details form session
		HttpSession session = request.getSession();
		Map<String, String> dictionary = new HashMap<String, String>();
		int id_user =  (int) session.getAttribute("id_user");
		
		
		int result = demandeDao.create(demande, id_user);
		
		if (result >= 1) {
			System.out.println("operation bien traité");
			request.getRequestDispatcher("./List_demande.jsp").forward(request,response);
		}
		
		doGet(request, response);
	}

}
