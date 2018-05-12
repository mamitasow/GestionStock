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
import com.dao.ImpSortie;
import com.dao.ImpStock;
import com.entite.Entree;
import com.entite.Sortie;
import com.entite.Stock;

/**
 * Servlet implementation class SortieServlet
 */
@WebServlet(name="Sortie",urlPatterns="/Sortie")
public class SortieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ImpSortie daosortie;
	private ImpStock daoStok;
	@Override
	public void init() throws ServletException {
		daosortie=new ImpSortie();
		daoStok=new ImpStock();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		daosortie=new ImpSortie();
		daoStok=new ImpStock();
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		daosortie=new ImpSortie();
		daoStok=new ImpStock();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (request.getParameter("page") != null)
			
		{
			
			String page = request.getParameter("page").toString();
			if(page.equals("liste")) {
				List<Sortie> list_entree = daosortie.liste();
				request.setAttribute("sortie", list_entree);
				
				request.getRequestDispatcher("view/sortie/liste.jsp").forward(request, response);
			}else if(page.equals("add")) {
					List<Stock> stocks = daoStok.liste();
					request.setAttribute("stocks", stocks);
				request.getRequestDispatcher("view/sortie/add.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		daosortie=new ImpSortie();
		daoStok=new ImpStock();
		doGet(request, response);
		if(request.getParameter("valider")!=null) {
			String  date= request.getParameter("date").toString();
			String qte= request.getParameter("qte").toString();
			String  pu= request.getParameter("pu").toString();
			Integer  ids= Integer.parseInt(request.getParameter("qtstock").toString());
			Sortie entree = new Sortie();
			Stock stocks =daoStok.get(ids);
			entree.setDateS(date);
			entree.setQtS(Double.parseDouble(qte));
			entree.setPuS(Integer.parseInt(pu));
			entree.setStock(stocks);
			int ok=daosortie.add(entree);
			request.setAttribute("message", ok);
			request.getRequestDispatcher("view/sortie/add.jsp").forward(request, response);
		}
	}

}
