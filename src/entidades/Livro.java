package entidades;

import java.util.Date;

import entidades.enums.Estatus;

public class Livro {

	public static final char[] toStringLivraria = null;
    private String nome;
	private String autor;
	private Date dataDePubliicacao;
	private String genero;
	private int classificacaoIndicativa;
	private final int id;
	public Estatus estatus;
	
	
	public Livro(String nome, String autor, Date dataDePubliicacao, String genero, int classificacaoIndicativa, int id) {
		
		this.nome = nome;
		this.autor = autor;
		this.dataDePubliicacao = dataDePubliicacao;
		this.genero = genero;
		this.classificacaoIndicativa = classificacaoIndicativa;
		this.id =id;
		this.estatus = estatus.DISPONIVEL;
		
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

	public int getId() {
		return id;
	}

	public Estatus setEstatus(String estatus) {
		return this.estatus = Estatus.valueOf(estatus);
	}
	
	public Livro teste(Livro livro){
		return livro;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void mudancaDeEstatus(Livro livro){
		if(livro.estatus.equals("RESERVADO")) {
		livro.setEstatus("DISPONIVEL") ;
		}
		else{
			livro.setEstatus("RESERVADO");
		}
	}


	
	public String toStringLivraria() {
		return "Nome:" + nome + "\n"
		+ "Autor: " + autor + "\n" 
		+ "Data de publiicacao: " + dataDePubliicacao  + "\n" 
		+ "Genero:"+ genero + "\n" 
		+ "Classificacao indicativa: " + classificacaoIndicativa + "\n"
		+ "Estatus: " + estatus + "\n";
	}

	
	public String toStringUsuario() {
		return "Nome:" + nome + "\n"
		+ "Autor: " + autor + "\n" 
		+ "Data de publiicacao: " + dataDePubliicacao  + "\n" 
		+ "Genero:"+ genero + "\n" 
		+ "Classificacao indicativa: " + classificacaoIndicativa + "\n";
		
	}
	

	


	
}
