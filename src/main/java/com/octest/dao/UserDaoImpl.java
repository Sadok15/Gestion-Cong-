package com.octest.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.octest.beans.Users;

public class UserDaoImpl implements UserDao {
	private DaoFactory daoFactory;
	
	UserDaoImpl( DaoFactory daoFactory){
		this.daoFactory = daoFactory;
	}
	
	@Override
	public int create(Users user) {
		
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		int result= 0;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO	Users(nom, prenom, mail, mdp) VALUES(?, ?, ?, ?);");
	
			preparedStatement.setString(1, user.getNom());
			preparedStatement.setString(2, user.getPrenom());
			preparedStatement.setString(3, user.getMail());
			preparedStatement.setString(4, user.getMdp());
			result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public List<Users> get(String mail, String mdp) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		List<Users> ListUser = new ArrayList<Users>();
		
		 try{
			 connexion = daoFactory.getConnection();
			 	preparedStatement = connexion.prepareStatement("SELECT * FROM Users WHERE mail = ? AND mdp = ?");
			 	preparedStatement.setString(1, mail);
			 	preparedStatement.setString(2, mdp);
		        ResultSet rs = preparedStatement.executeQuery();
		        while(rs.next()) {
		        	Users user = new Users();
		        	user.setId_user(rs.getInt("id_user"));
		        	user.setMail(rs.getString("mail"));
		        	user.setMdp(rs.getString("mdp"));
		        	user.setNom(rs.getString("nom"));
		        	user.setPrenom(rs.getString("prenom"));
		        	user.setRole(rs.getString("role"));
		        	ListUser.add(user);
		        }
	        	ListUser.add((Users) rs);
		    }catch(Exception e){
		       System.out.print(e);
		   }
		 return ListUser;
		
	}
	
	public Users get_user(int id_user) {
		return null;
		}
}
