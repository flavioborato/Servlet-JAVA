package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresas;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresaForm;
import br.com.alura.gerenciador.acao.RemovaEmpresas;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		String url = null;
		
//		HttpSession sessao = request.getSession();
//		
//		boolean usuarioNaoLogado = sessao.getAttribute("usuarioLogado")==null;
//		boolean acaoProtegida = !((paramAcao.equals("Login")) || (paramAcao.equals("LoginForm")));
//		
//		
//		if(usuarioNaoLogado && acaoProtegida) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}
//		
		
		try {
			Class classePadrao = Class.forName(nomeDaClasse);//classe que carrega a classe junto com ela
			Acao acao = (Acao) classePadrao.newInstance(); //metodo cast
			url = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			e.printStackTrace();
		}
		

		String[] tipoEndereco = url.split(":");
		if(tipoEndereco[0].equals("forward")) {
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/"+tipoEndereco[1]);
		rq.forward(request, response);
		}else {
		response.sendRedirect(tipoEndereco[1]);
		}
		

		
//		if(paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			url = acao.executa(request,response);
//		}else if(paramAcao.equals("RemovaEmpresas")) {
//			RemovaEmpresas acao = new RemovaEmpresas();
//			url = acao.executa(request,response);
//		}else if(paramAcao.equals("MostraEmpresas")) {
//			MostraEmpresas acao = new MostraEmpresas();
//			url = acao.executa(request,response);
//		}else if(paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresa acao = new NovaEmpresa();
//			url = acao.executa(request,response);
//		}else if(paramAcao.equals("AlteraEmpresa")) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			url = acao.executa(request,response);
//		}else if(paramAcao.equals("NovaEmpresaForm")) {
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			url = acao.executa(request,response);
//		}
		

	}

}
