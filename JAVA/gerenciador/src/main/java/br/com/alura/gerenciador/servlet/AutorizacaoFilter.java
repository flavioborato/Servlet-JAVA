package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
@WebFilter("/entrada")
public class AutorizacaoFilter  implements Filter {
      
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
		System.out.println("AutorizacaoFilter");
		HttpServletRequest request = (HttpServletRequest)serveltrequest;
		HttpServletResponse response = (HttpServletResponse)serveltresponse;
		
		String paramAcao = request.getParameter("acao");
		HttpSession sessao = request.getSession();
		
		boolean usuarioNaoLogado = sessao.getAttribute("usuarioLogado")==null;
		boolean acaoProtegida = !((paramAcao.equals("Login")) || (paramAcao.equals("LoginForm")));
		
		
		if(usuarioNaoLogado && acaoProtegida) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		
	}



}
