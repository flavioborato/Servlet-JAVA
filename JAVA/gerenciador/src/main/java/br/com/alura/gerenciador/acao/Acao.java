package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelos.Banco;
import br.com.alura.gerenciador.modelos.Empresa;

public interface Acao {

	String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
		
	
	
}
