package br.edu.faculdadedelta.modelo;

import java.util.Date;

public class ControleWanderson {

	private Long id;
	private String descricao;
	private String especificacao;
	private String departamento;
	private double valorBem;
	private Date dataCadastro;
	
	public ControleWanderson() {
	}

	public ControleWanderson(Long id, String descricao, String especificacao, String departamento, Double valorBem,
			Date dataCadastro) {
		this.id = id;
		this.descricao = descricao;
		this.especificacao = especificacao;
		this.departamento = departamento;
		this.valorBem = valorBem;
		this.dataCadastro = dataCadastro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Double getValorBem() {
		return valorBem;
	}

	public void setValorBem(Double valorBem) {
		this.valorBem = valorBem;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ControleWanderson other = (ControleWanderson) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
		
	
}
