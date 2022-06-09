package tn.itbs.it;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	List<Users> ListUser = new ArrayList<Users>();
	
	public void init() throws ServletException {
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
		HttpSession session = request.getSession();
		Map<String, String> dictionary = new HashMap<String, String>();
		
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		request.setAttribute("actif", true);
		ListUser = userDao.get(mail, mdp);
		
		if(ListUser.size() > 0 ) {
			for (int i = 0; i < ListUser.size(); i++) {
				Users rs = ListUser.get(i);
				
				session.setAttribute("nom", rs.getNom());
				session.setAttribute("prenom",  rs.getPrenom());
				session.setAttribute("mail", rs.getMail());
				session.setAttribute("mdp", rs.getMdp());
				session.setAttribute("role", rs.getRole());
				session.setAttribute("id_user", rs.getId_user());
				
			
			}
			request.getRequestDispatcher("./Acceuil.jsp").forward(request,response);
		}
		else {
			session.setAttribute("msg", "Identification incorrect");
			request.getRequestDispatcher("./login_connexion.jsp").forward(request, response);
		}
		doGet(request, response);
	}

}
