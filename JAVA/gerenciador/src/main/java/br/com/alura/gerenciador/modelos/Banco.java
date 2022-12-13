package br.com.alura.gerenciador.modelos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	//Criação de uma Array para armazenar os valores inseridos
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> ListaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencial++);
		empresa1.setNome("Alura");
		empresa1.setCnpj("12345678");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		empresa2.setCnpj("8654321");
		lista.add(empresa1);
		lista.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("flavio");
		u1.setSenha("123456");
		Usuario u2 = new Usuario();
		u2.setLogin("fernando");
		u2.setSenha("654321");
		ListaUsuarios.add(u1);
		ListaUsuarios.add(u2);
	}
	
	//Classe que recebe e armazena na array list
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	//Classe para devolver o nome dentro das listas
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {		
		Iterator<Empresa> it = lista.iterator();
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId()==id) {it.remove();}
		}
		
	}

	public Empresa buscaEmpresa(Integer id) {
		for(Empresa empresa : lista) {
			if(empresa.getId()==id) {
				return empresa;
			}
		
		}
		return null;	
	}

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario u : ListaUsuarios) {
			if(u.ehIgual(login, senha)) {
				return u;
			}
		}
		return null;
	}

}
