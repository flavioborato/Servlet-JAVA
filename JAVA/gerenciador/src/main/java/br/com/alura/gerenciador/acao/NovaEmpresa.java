package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelos.Banco;
import br.com.alura.gerenciador.modelos.Empresa;

public class NovaEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			RequestDispatcher rq = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
			request.setAttribute("empresanome", empresa.getNome());
			request.setAttribute("empresacnpj", empresa.getCnpj());
			request.setAttribute("empresadata", empresa.getDataAbertura());
			rq.forward(request, response);
			//response.sendRedirect("entrada?acao=ListaEmpresas"); //quando necessita redirecionar 
			
			
			
			

	}
}
