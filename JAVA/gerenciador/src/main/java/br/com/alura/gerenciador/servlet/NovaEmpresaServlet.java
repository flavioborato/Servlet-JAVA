package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelos.Banco;
import br.com.alura.gerenciador.modelos.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
//@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa =  request.getParameter("nome");
		String cnpjEmpresa =  request.getParameter("CNPJ");
		String paraDataAbertura =  request.getParameter("data");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAbertura = null;
			try {
				dataAbertura = sdf.parse(paraDataAbertura);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				throw new ServletException(e);
			}
		
		Empresa empresa = new Empresa();
		
			empresa.setNome(nomeEmpresa);
			empresa.setCnpj(cnpjEmpresa);
			empresa.setDataAbertura(dataAbertura);
			
			Banco banco = new Banco();
			banco.adiciona(empresa);
	
			//chamar o JSP 
			RequestDispatcher rd =  request.getRequestDispatcher("/novaEmpresaCriada.jsp");
			request.setAttribute("empresanome", empresa.getNome());
			request.setAttribute("empresacnpj", empresa.getCnpj());
			request.setAttribute("empresadata", empresa.getDataAbertura());
			rd.forward(request, response);
		  
	}

}
