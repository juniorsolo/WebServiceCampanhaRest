package br.com.junior.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Manoel Silva
 *
 */


@Entity
@Table(name="campanha")
public class CampanhaEntity implements Serializable{


	private static final long serialVersionUID = 4635838254483908061L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private Integer idTimeCoracao;
	
	@Convert(converter=LocalDateAttributeConverter.class)
	private LocalDate dataInicio;
	
	@Convert(converter=LocalDateAttributeConverter.class)
	private LocalDate dataVigencia;
	
	
	public CampanhaEntity(String nome, Integer idTimeCoracao, LocalDate dataVigencia) {
		super();
		this.nome = nome;
		this.idTimeCoracao = idTimeCoracao;
		this.dataVigencia = dataVigencia;
	}
	
	public CampanhaEntity() {
		super();
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
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Integer getIdTimeCoracao() {
		return idTimeCoracao;
	}
	public void setIdTimeCoracao(Integer idTimeCoracao) {
		this.idTimeCoracao = idTimeCoracao;
	}
	public LocalDate getDataVigencia() {
		return dataVigencia;
	}
	public void setDataVigencia(LocalDate dataVigencia) {
		this.dataVigencia = dataVigencia;
	}
	
	
}
