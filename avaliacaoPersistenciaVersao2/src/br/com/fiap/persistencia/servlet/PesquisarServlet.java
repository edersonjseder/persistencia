package br.com.fiap.persistencia.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.persistencia.bean.Patio;
import br.com.fiap.persistencia.dao.PatioDAO;

/**
 * Servlet implementation class PesquisarServlet
 */
public class PesquisarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesquisarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatioDAO patioDAO = new PatioDAO();
		Patio patio = new Patio();
		patio = patioDAO.retrieve(Integer.parseInt(request.getParameter("patios")));
		request.setAttribute("listaVeiculos", patio.getVeiculos());
		
		RequestDispatcher rd = request.getRequestDispatcher("listaVeiculos.jsp");
		rd.forward(request, response);
		
	}

}
