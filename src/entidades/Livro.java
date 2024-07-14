package entidades;

import java.util.Date;

import entidades.enums.Estatus;

public class Livro {

	private String nome;
	private String autor;
	private Date dataDePubliicacao;
	private String genero;
	private int classificacaoIndicativa;
	public Estatus estatus;
	
	
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


	public Estatus setEstatus(String estatus) {
		return this.estatus = Estatus.valueOf(estatus);
	}
	
	
	@SuppressWarnings("unlikely-arg-type")
	public void mudancaDeEstatus(Livro livro, Estatus estatus){
		if(livro.estatus.equals("RESERVADO")) {
		livro.setEstatus("DISPONIVEL") ;
		}
		else{
			livro.setEstatus("RESERVADO");
		}
	}


	@Override
	public String toString() {
		return "Nome:" + nome + "\n"
		+ "Autor: " + autor + "\n" 
		+ "Data de publiicacao: " + dataDePubliicacao  + "\n" 
		+ "Genero:"+ genero + "\n" 
		+ "Classificacao indicativa: " + classificacaoIndicativa + "\n"
		+ "Estatus: " + estatus + "\n";
	}
	

	


	
}
