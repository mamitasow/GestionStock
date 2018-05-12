package com.entite;

public class Stock {
	protected int id;
	protected String ref;
	protected String lib;
	protected double qtStock;
	public Stock() {
	
	}
	public Stock(int id,String ref, String lib, double qtStock) {
		super();
		this.id = id;
		this.ref = ref;
		this.lib = lib;
		this.qtStock = qtStock;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getLib() {
		return lib;
	}
	public void setLib(String lib) {
		this.lib = lib;
	}
	public double getQtStock() {
		return qtStock;
	}
	public void setQtStock(double qtStock) {
		this.qtStock = qtStock;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return lib;
	}
	

}
