package br.com.fiap.persistencia.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.persistencia.bean.Veiculo;
import br.com.fiap.persistencia.dao.PatioDAO;
import br.com.fiap.persistencia.dao.VeiculoDAO;

/**
 * Servlet implementation class AlteracaoVeiculoServlet
 */
public class AlteracaoVeiculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlteracaoVeiculoServlet() {
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
		Veiculo veiculo = new Veiculo();
		VeiculoDAO dao = new VeiculoDAO();
		PatioDAO patioDAO = new PatioDAO();
		
		String pagina = "";
		
		veiculo.setPatio(patioDAO.retrieve(Integer.parseInt(request.getParameter("patios"))));
		veiculo.setMarca(request.getParameter("marca"));
		veiculo.setModelo(request.getParameter("modelo"));
		veiculo.setAnoFabricacao(Integer.parseInt(request.getParameter("anoFabricacao")));
		veiculo.setAnoModelo(Integer.parseInt(request.getParameter("anoModelo")));
		
		Boolean resultado = dao.update(veiculo);

		
		if(resultado){
			pagina = "inicio.jsp";
		}else{
			pagina = "edicaoVeiculo.jsp";
		}
		
		response.sendRedirect(pagina);
	}

}
