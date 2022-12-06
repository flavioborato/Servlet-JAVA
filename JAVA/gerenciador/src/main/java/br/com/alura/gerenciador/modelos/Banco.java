package br.com.alura.gerenciador.modelos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	//Criação de uma Array para armazenar os valores inseridos
	private static List<Empresa> lista = new ArrayList<>();
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

}
