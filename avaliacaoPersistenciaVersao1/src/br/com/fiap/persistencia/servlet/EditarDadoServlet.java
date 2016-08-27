package br.com.fiap.persistencia.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.persistencia.bean.Patio;
import br.com.fiap.persistencia.bean.Veiculo;
import br.com.fiap.persistencia.dao.PatioDAO;
import br.com.fiap.persistencia.dao.VeiculoDAO;

/**
 * Servlet implementation class EditarDadoServlet
 */
public class EditarDadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarDadoServlet() {
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
	String codigo = request.getParameter("codigo");
		
		VeiculoDAO dao = new VeiculoDAO();
		PatioDAO patioDAO = new PatioDAO();
		
		Veiculo veiculo = dao.retrieve(Integer.parseInt(codigo));
		request.setAttribute("veiculo", veiculo);
		
		List<Patio> listaPatio = patioDAO.listar();
		request.setAttribute("listaPatio", listaPatio);
		
		RequestDispatcher rd = request.getRequestDispatcher("edicaoVeiculo.jsp");
		rd.forward(request, response);
	}

}
