package br.com.alura.gerenciador.modelos;

import java.util.Date;

public class Empresa {

	private Integer id;
	private String nome;
	private String cnpj;
	private Date dataAbertura = new Date();
	
	
	//Getters and Setters
	
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date data) {
		this.dataAbertura = data;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	
}
