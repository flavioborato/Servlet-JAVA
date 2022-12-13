package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter{
	long num=0;
	
	//obrigatorio para o uso do Jetty
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("MonitoramentoFilter");
		long antes = System.currentTimeMillis();
		
		//executa a ação
		chain.doFilter(request, response);
		
		String acao = request.getParameter("acao");
		long depois = System.currentTimeMillis();
		num = num+1;
		System.out.println( num + ":-Tempo de execução da acao:- "+ acao +" - "+(depois - antes)+"ms");
		
	}

}
