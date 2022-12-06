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

public class AlteraEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresa =  request.getParameter("nome");
		String cnpjEmpresa =  request.getParameter("CNPJ");
		String paraDataAbertura =  request.getParameter("data");
		String idEmpresa =  request.getParameter("id");
		Integer id = Integer.valueOf(idEmpresa);
		
		Date dataAbertura = null;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				dataAbertura = sdf.parse(paraDataAbertura);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				throw new ServletException(e);
			}
		

			Banco banco = new Banco();
			Empresa empresa = banco.buscaEmpresa(id);
			empresa.setNome(nomeEmpresa);
			empresa.setCnpj(cnpjEmpresa);
			empresa.setDataAbertura(dataAbertura);
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
