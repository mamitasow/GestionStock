package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.ImpEntree;
import com.dao.ImpStock;
import com.entite.Entree;
import com.entite.Stock;



/**
 * Servlet implementation class EntreeServlet
 */
@WebServlet(name="Entree",urlPatterns="/Entree")
public class EntreeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImpEntree dao;
	private ImpStock daoS;
	@Override
	public void init() throws ServletException {
		dao=new ImpEntree();
		daoS =new ImpStock();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntreeServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dao=new ImpEntree();

		if (request.getParameter("page") != null)
		
		{
			
			String page = request.getParameter("page").toString();
			if(page.equals("liste")) {
				List<Entree> list_entree = dao.liste();
				request.setAttribute("entree", list_entree);
				
				request.getRequestDispatcher("view/entree/liste.jsp").forward(request, response);
			}else if(page.equals("add")) {
				daoS =new ImpStock();
					List<Stock> stocks = daoS.liste();
					request.setAttribute("stocks", stocks);
				request.getRequestDispatcher("view/entree/add.jsp").forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dao=new ImpEntree();

		doGet(request, response);
		if(request.getParameter("valider")!=null) {
			String  date= request.getParameter("date").toString();
			String qte= request.getParameter("qte").toString();
			String  pu= request.getParameter("pu").toString();
			Integer  ids= Integer.parseInt(request.getParameter("stock").toString());
			Entree entree = new Entree();
			Stock stocks =daoS.get(ids);
			entree.setDateE(date);
			entree.setQtE(Double.parseDouble(qte));
			entree.setPuE(Integer.parseInt(pu));
			entree.setStock(stocks);
			int ok=dao.add(entree);
			request.setAttribute("message", ok);
			request.getRequestDispatcher("view/entree/add.jsp").forward(request, response);
		}
	}

}
