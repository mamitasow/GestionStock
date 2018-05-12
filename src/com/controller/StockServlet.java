package com.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class StockServlet
 */
@WebServlet(name="Stock",urlPatterns="/Stock")
public class StockServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ImpStock dao;
	@Override
	public void init() throws ServletException {
		dao=new ImpStock();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *///il permet de charger directement un servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//charger une view
		dao=new ImpStock();

		
		if (request.getParameter("page") != null)
			
		{
			
			String page = request.getParameter("page").toString();
			if(page.equals("liste")) {
				List<Stock> list_stock = dao.liste();
				request.setAttribute("stock", list_stock);
				
				request.getRequestDispatcher("view/stock/liste.jsp").forward(request, response);
			}else if(page.equals("add")) {
				
				request.getRequestDispatcher("view/stock/add.jsp").forward(request, response);
			}
		}
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *///charge directement un formulaire
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		if(request.getParameter("valider")!=null) {
			String  refp= request.getParameter("refp").toString();
			String  libp= request.getParameter("libp").toString();
			String  qtstock= request.getParameter("qtstock").toString();
			Stock entree = new Stock();
			entree.setRef(refp);
			entree.setLib(libp);
			entree.setQtStock(Double.parseDouble(qtstock));
			int ok=dao.add(entree);
			request.setAttribute("message", ok);
			List<Stock> list_stock = dao.liste();
			request.setAttribute("stock", list_stock);
			
			request.getRequestDispatcher("view/stock/liste.jsp").forward(request, response);		}
	}

}
