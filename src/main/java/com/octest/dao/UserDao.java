package com.octest.dao;

import java.util.List;

import com.octest.beans.Users;

public interface UserDao {
	int create( Users user );
	List<Users> get( String mail, String mdp );
	Users get_user(int id_user);
}
