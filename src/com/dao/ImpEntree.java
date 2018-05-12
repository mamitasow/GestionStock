package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entite.Entree;

public class ImpEntree implements IEntree{
	private DB db;
    private int ok;
    private ResultSet rs;
     public ImpEntree() {
		
		 db= new DB();
    }


	@Override
	public int add(Entree entree) {
		String sql= "INSERT INTO entree VALUES (null,?,?,?,?)";
        try {
            db.initPrepare(sql);
            db.getPstm().setString(1, entree.getDateE());
            db.getPstm().setDouble(2, entree.getQtE());
            db.getPstm().setInt(3, entree.getPuE());
            db.getPstm().setInt(4, entree.getStock().getId());
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

	@Override
	public int delete(int ref) {
		String sql="DELETE FROM entree WHERE idE=?";
        try {
            //db=new DB();
            db.initPrepare(sql);
            db.getPstm().setInt(1, ref);
            ok=db.executeMAJ();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ok;
	}

	@Override
	public int update(Entree entree) {
		 String sql="UPDATE entree SET dateE = ?,qteE = ?,puE = ? ,idstock = ? WHERE idE=?";
	        try {
	            db.initPrepare(sql);
	            db.getPstm().setString(1, entree.getDateE());
	            db.getPstm().setDouble(2, entree.getQtE());
	            db.getPstm().setInt(3, entree.getPuE());
	            db.getPstm().setInt(3, entree.getStock().getId());
	            db.getPstm().setInt(4, entree.getIdE());

	            ok= db.executeMAJ();

	            db.closeConnexion();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return ok;
	}

	@Override
	public Entree get(int ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entree> liste() {
		 List<Entree> lc =new ArrayList<Entree>();
	        String sql="SELECT * FROM entree";

	        try {
	            db=new DB();
	            db.initPrepare(sql);
	            rs=db.executeSELECT();
	            while(rs.next())
	            {
	            	Entree s=new Entree();
	                s.setIdE(rs.getInt(1));
	                s.setDateE(rs.getString(2));
	                s.setQtE(rs.getDouble(3));
	                s.setPuE(rs.getInt(4));
	                IStock iserv = new ImpStock();
	                s.setStock(iserv.get(rs.getInt(5)));

	                lc.add(s);

	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	            db.closeConnexion();
	        }
	        return lc;

	}

}
