package br.com.fiap.persistencia.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.persistencia.bean.Patio;
import br.com.fiap.persistencia.dao.PatioDAO;

/**
 * Servlet implementation class CadastroPatioServlet
 */
public class CadastroPatioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroPatioServlet() {
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
		Patio patio = new Patio();
		PatioDAO dao = new PatioDAO();
		
		String pagina = "";
		
		patio.setNome(request.getParameter("nomePatio"));
		
		Integer resultado = dao.insert(patio);
		
		if(resultado != 0){
			pagina = "cadastro.jsp";
		}else{
			pagina = "cadastroPatio.jsp";
		}
		
		response.sendRedirect(pagina);
		
	}

}
