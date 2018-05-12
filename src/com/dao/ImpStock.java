package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entite.Stock;

public class ImpStock implements IStock {
	private DB db;
    private int ok;
    private ResultSet rs;
     public ImpStock() {
		
		 db= new DB();
    }

	@Override
	public int add(Stock stock) {
		String sql= "INSERT INTO stock VALUES(null,?,?,?)";
        try {
            db.initPrepare(sql);
            db.getPstm().setString(1, stock.getRef());
            db.getPstm().setString(2, stock.getLib());
            db.getPstm().setDouble(3, stock.getQtStock());

            ok= db.executeMAJ();
            //recup de id auto_incremt
            rs=db.getPstm().getGeneratedKeys();
            while(rs.next())
            {
                ok=rs.getInt(1);
            }
            rs.close();
            db.closeConnexion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
	}

	public int delete(int ref) {
		 String sql="DELETE FROM stock WHERE idS=?";
	        try {
	            db.initPrepare(sql);
	            db.getPstm().setInt(1, ref);
	            ok= db.executeMAJ();

	            db.closeConnexion();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return ok;
	}

	@Override
	public int update(Stock stock) {
		 String sql="UPDATE stock SET refS = ?,libS = ?,qteStock = ? WHERE idS=?";
	        try {
	            db.initPrepare(sql);
	            db.getPstm().setString(1, stock.getRef());
	            db.getPstm().setString(2, stock.getLib());
	            db.getPstm().setDouble(3, stock.getQtStock());
	            db.getPstm().setInt(4, stock.getId());

	            ok= db.executeMAJ();

	            db.closeConnexion();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return ok;
	}

	@Override
	public Stock get(int id) {
		 String sql ="SELECT * FROM stock WHERE idS=?";
	        Stock s =new Stock();
	        try {
	            db.initPrepare(sql);
	            db.getPstm().setInt(1, id);
	            rs=db.executeSELECT();

	            while(rs.next()){

	                s.setId(rs.getInt(1));
	                s.setRef(rs.getString(2));
	                s.setLib(rs.getString(3));
	                s.setQtStock(rs.getDouble(4));


	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }


	        return s;
	}

	@Override
	public List<Stock> liste() {
		 List<Stock> ls = new ArrayList<Stock>();
	        String sql ="SELECT * FROM  stock";
	        try {
	            db.initPrepare(sql);
	            rs=db.executeSELECT();
	            while(rs.next()){
	            	 Stock s =new Stock();
	                s.setId(rs.getInt(1));
	                s.setRef(rs.getString(2));
	                s.setLib(rs.getString(3));
	                s.setQtStock(rs.getDouble(4));
	                ls.add(s);
	            }
	            rs.close();
	            db.closeConnexion();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return ls;
	}

	

}
