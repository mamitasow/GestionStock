package com.dao;

import java.util.List;

import com.entite.Entree;

public interface IEntree {
	public int add(Entree entree);
	public int delete(int ide);
	public int update(Entree entree);
	public Entree get(int ide);
	public List<Entree> liste();
}
