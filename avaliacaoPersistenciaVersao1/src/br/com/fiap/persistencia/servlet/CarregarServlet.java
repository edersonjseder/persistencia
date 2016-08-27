package br.com.fiap.persistencia.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.persistencia.bean.Patio;
import br.com.fiap.persistencia.dao.PatioDAO;

/**
 * Servlet implementation class CarregarServlet
 */
public class CarregarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarregarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatioDAO dao = new PatioDAO();
		
		List<Patio> listaPatio = new ArrayList<Patio>();
		
		listaPatio = dao.listar();
		
		request.setAttribute("listaPatio", listaPatio);
		
		RequestDispatcher rd = request.getRequestDispatcher("cadastroVeiculo.jsp");
		rd.forward(request, response);
		
	}

}
