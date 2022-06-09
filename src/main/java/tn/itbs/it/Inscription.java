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

import com.octest.beans.Users;
import com.octest.dao.DaoFactory;
import com.octest.dao.UserDao;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	List<Users> ListUser = new ArrayList<Users>();
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.userDao = daoFactory.getUtilisateurDao();
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
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Map<String, String> dictionary = new HashMap<String, String>();
		HttpSession session = request.getSession();
		ListUser = userDao.get(mail, mdp);
		
		Users user = new Users();
    	user.setMail(mail);
    	user.setMdp(mdp);
    	user.setNom(nom);
    	user.setPrenom(prenom);
    	user.setRole("E");
    	
    	int result = userDao.create(user);
    	if (result == 1) {
    		session.setAttribute("nom", nom);
			session.setAttribute("prenom",  prenom);
			session.setAttribute("mail", mail);
			session.setAttribute("mdp", mdp);
			session.setAttribute("role", "E");
			ListUser = userDao.get(mail, mdp);
			
			if(ListUser.size() > 0 ) {
				for (int i = 0; i < ListUser.size(); i++) {
					Users rs = ListUser.get(i);
					session.setAttribute("id_user", rs.getId_user());
				}
			}
			
			request.getRequestDispatcher("./Acceuil.jsp").forward(request,response);

    	}
    	else {
    		session.setAttribute("err", "Error lors de l'inscription");
    	}
		
		
		
		
		doGet(request, response);
	}

}
