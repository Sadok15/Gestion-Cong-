package com.octest.dao;

import java.util.List;

import com.octest.beans.Demande;
import com.octest.beans.Demande_emp;

public interface DemandeEmpDap {
	Demande_emp get( int id_demande);
}
