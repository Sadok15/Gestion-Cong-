package com.octest.dao;

import java.util.List;

import com.octest.beans.Demande;
import com.octest.beans.Users;

public interface DemandeDao {
	int create( Demande demande, int id_user );
	List<Demande> get( int id_user, String role );
	void update_status(int id_demande, String status);
}
