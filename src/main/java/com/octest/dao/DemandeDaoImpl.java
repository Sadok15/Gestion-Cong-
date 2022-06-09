package com.octest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Demande;
import com.octest.beans.Users;


public class DemandeDaoImpl implements DemandeDao{
	private DaoFactory daoFactory;
	
	DemandeDaoImpl( DaoFactory daoFactory){
		this.daoFactory = daoFactory;
	}
	
	@Override
	public int create(Demande demande, int id_emp) {
		
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		int result= 0;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(
					"INSERT INTO demande(duree, description, status, date_debut, titre) VALUES(?, ?, ?, ?, ?);"
					);

			preparedStatement.setInt(1, demande.getDuree());
			preparedStatement.setString(2, demande.getDescription());
			preparedStatement.setString(3, "En Cours");
			preparedStatement.setString(4, demande.getDate_debut());
			preparedStatement.setString(5, demande.getTitre());
			result = preparedStatement.executeUpdate();
			
			if (result >= 1) {
				preparedStatement = connexion.prepareStatement(
				"SELECT MAX(id_demande) as 'id_demande' FROM `demande`"
						);
				ResultSet rs_demande = preparedStatement.executeQuery();
	
				int id_demande = 0;
				while(rs_demande.next()) {
					 id_demande = rs_demande.getInt("id_demande");
				}
				preparedStatement = connexion.prepareStatement(
						"INSERT INTO demande_emp(id_demande, id_emp) VALUES(?, ?);"
						);
				
				preparedStatement.setInt(1, id_demande);
				preparedStatement.setInt(2, id_emp);
				preparedStatement.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public List<Demande> get(int id_user, String role) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		List<Demande> ListDemande = new ArrayList<Demande>();
		
		 try{
			 connexion = daoFactory.getConnection();
			 char character = role.charAt(0);
			 int ascii = (int) character;
			 if (ascii == 65) {
				 preparedStatement = connexion.prepareStatement("SELECT * FROM demande");
				 System.out.println("ezljhfklzjehfkzje");
			 }
			 else {
			 	preparedStatement = connexion.prepareStatement(
			 			"SELECT d.* FROM demande d  "
			 			+ "LEFT JOIN demande_emp de On d.id_demande = de.id_demande "
			 			+ "WHERE de.id_emp = ? "
			 			);
			 	preparedStatement.setInt(1, id_user);
		        
			 }
			 System.out.println("herererere");
			 ResultSet rs = preparedStatement.executeQuery();
		        while(rs.next()) {
		        	
		        	Demande demande = new Demande();
		        	demande.setId_demande(rs.getInt("id_demande"));
		        	demande.setDate_debut(rs.getString("date_debut"));
		        	demande.setDescription(rs.getString("description"));
		        	demande.setDuree(rs.getInt("duree"));
		        	demande.setStatus(rs.getString("status"));
		        	demande.setTitre(rs.getString("titre"));
		        	
		        	ListDemande.add(demande);
		        }
		    }catch(Exception e){
		       System.out.print(e);
		   }
		 return ListDemande;
		
	}

	
	public void update_status(int id_demande, String status) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(
					"Update demande SET status = ? WHERE id_demande = ? ;"
					);

			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, id_demande);
			preparedStatement.executeUpdate();
	
	} catch (SQLException e) {
		e.printStackTrace();
	}


}
}
