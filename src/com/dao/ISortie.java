package com.dao;

import java.util.List;

import com.entite.Sortie;



public interface ISortie {
	public int add(Sortie sortie);
	public int delete(int ref);
	public int update(Sortie entree);
	public int get(int ref);
	public List<Sortie> liste();

}
