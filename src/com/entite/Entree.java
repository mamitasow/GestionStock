package com.entite;

import java.util.Date;

public class Entree {
	protected int idE;
	protected String dateE;
	protected double qtE;
	protected int puE;
	protected Stock stock;
	public Entree() {
		
	}
	
	public Entree(int idE, String dateE, double qtE, int puE, Stock stock) {
		super();
		this.idE = idE;
		this.dateE = dateE;
		this.qtE = qtE;
		this.puE = puE;
		this.stock = stock;
	}

	public int getIdE() {
		return idE;
	}
	public void setIdE(int idE) {
		this.idE = idE;
	}
	public String getDateE() {
		return dateE;
	}
	public void setDateE(String dateE) {
		this.dateE = dateE;
	}
	public double getQtE() {
		return qtE;
	}
	public void setQtE(double qtE) {
		this.qtE = qtE;
	}
	public int getPuE() {
		return puE;
	}
	public void setPuE(int puE) {
		this.puE = puE;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	
	

}
