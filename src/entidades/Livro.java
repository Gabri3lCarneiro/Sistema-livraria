package entidades;

import java.util.Date;

import entidades.enums.Estatus;

public class Livro {

	private String nome;
	private String autor;
	private Date dataDePubliicacao;
	private String genero;
	private int classificacaoIndicativa;
	private Estatus estatus;
	
	
	public Livro(String nome, String autor, Date dataDePubliicacao, String genero, int classificacaoIndicativa,Estatus estatus) {
		
		this.nome = nome;
		this.autor = autor;
		this.dataDePubliicacao = dataDePubliicacao;
		this.genero = genero;
		this.classificacaoIndicativa = classificacaoIndicativa;
		this.estatus = estatus;
		
	}


	public String getNome() {
		return nome;
	}

	public String getAutor() {
		return autor;
	}

	public Date getDataDePubliicacao() {
		return dataDePubliicacao;
	}

	public String getGenero() {
		return genero;
	}

	public int getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public Estatus getEstatus() {
		return estatus;
	}


	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}
	
	
	
	
}
