package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet Filter implementation class ControladorFilter
 */
@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	
	//obrigatorio para o uso do Jetty
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest serveltrequest, ServletResponse serveltresponse, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("ControlodarFilter");
		HttpServletRequest request = (HttpServletRequest)serveltrequest;
		HttpServletResponse response = (HttpServletResponse)serveltresponse;
		
		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		String url = null;
		
		
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

	}



}
