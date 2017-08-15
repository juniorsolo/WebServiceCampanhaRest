package br.com.junior.http;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Campanha {
	
	 private Integer id;
	 private String nome;
	 private LocalDate dataVigencia;
	
	 
	 
	public Campanha() {
		super();
	}
	
	public Campanha(Integer id, String nome, LocalDate dataVigencia) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataVigencia = dataVigencia;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataVigencia() {
		return dataVigencia;
	}
	public void setDataVigencia(LocalDate dataVigencia) {
		this.dataVigencia = dataVigencia;
	}
	 
	 
}
