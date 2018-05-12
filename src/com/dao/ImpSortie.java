package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entite.Entree;
import com.entite.Sortie;

public class ImpSortie implements ISortie {
	 private DB db;
	    private int ok;
	    private ResultSet rs;
	    public ImpSortie() {
			 db= new DB();
	    }

	@Override
	public int add(Sortie sortie) {
		
		String sql= "INSERT INTO sortie VALUES(null,?,?,?,?)";
        try {
            db.initPrepare(sql);
            db.getPstm().setString(1, sortie.getDateS());
            db.getPstm().setDouble(2, sortie.getQtS());
            db.getPstm().setInt(3, sortie.getPuS());
            db.getPstm().setInt(4, sortie.getStock().getId());

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
		String sql="DELETE FROM sortie WHERE idE=?";
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
	public int update(Sortie entree) {
		 String sql="UPDATE sortie SET dateE = ?,qteE = ?,puE = ? ,idstock = ? WHERE idE=?";
	        try {
	            db.initPrepare(sql);
	            db.getPstm().setString(1, entree.getDateS());
	            db.getPstm().setDouble(2, entree.getQtS());
	            db.getPstm().setInt(3, entree.getPuS());
	            db.getPstm().setInt(3, entree.getStock().getId());
	            db.getPstm().setInt(4, entree.getIdS());

	            ok= db.executeMAJ();

	            db.closeConnexion();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return ok;
	}

	@Override
	public int get(int ref) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Sortie> liste() {
		List<Sortie> lc =new ArrayList<Sortie>();
        String sql="SELECT * FROM entree";

        try {
            db=new DB();
            db.initPrepare(sql);
            rs=db.executeSELECT();
            while(rs.next())
            {
            	Sortie s=new Sortie();
                s.setIdS(rs.getInt(1));
                s.setDateS(rs.getString(2));
                s.setQtS(rs.getDouble(3));
                s.setPuS(rs.getInt(4));
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
