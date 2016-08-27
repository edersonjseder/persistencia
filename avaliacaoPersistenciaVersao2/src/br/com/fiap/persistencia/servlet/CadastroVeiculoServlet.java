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
 * Servlet implementation class CadastroVeiculoServlet
 */
public class CadastroVeiculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroVeiculoServlet() {
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
		Veiculo veiculo = new Veiculo();
		VeiculoDAO dao = new VeiculoDAO();
		PatioDAO patioDAO = new PatioDAO();
		
		String pagina = "";
		
		veiculo.setPatio(patioDAO.retrieve(Integer.parseInt(request.getParameter("patios"))));
		veiculo.setMarca(request.getParameter("marca"));
		veiculo.setModelo(request.getParameter("modelo"));
		veiculo.setAnoFabricacao(Integer.parseInt(request.getParameter("anoFabricacao")));
		veiculo.setAnoModelo(Integer.parseInt(request.getParameter("anoModelo")));
		
		Integer resultado = dao.insert(veiculo);

		
		if(resultado != 0){
			pagina = "cadastro.jsp";
		}else{
			pagina = "cadastroVeiculo.jsp";
		}
		
		response.sendRedirect(pagina);
	}

}
