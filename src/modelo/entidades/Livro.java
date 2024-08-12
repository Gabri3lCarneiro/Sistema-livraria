package modelo.entidades;

import java.util.Date;
import java.util.Objects;

import entidades.enums.Estatus;

public class Livro {

    private String nome;
	private String autor;
	private Date dataDePubliicacao;
	private String genero;
	private Integer id;
	public Estatus estatus;
	
	
	public Livro(String nome, String autor, Date dataDePubliicacao, String genero, Integer id) {
		
		this.nome = nome;
		this.autor = autor;
		this.dataDePubliicacao = dataDePubliicacao;
		this.genero = genero;
		this.id =id;
		this.estatus = estatus.DISPONIVEL;
		
	}

	public Livro() {
		
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

	public Estatus getEstatus() {
		return estatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Estatus setEstatus(String estatus) {
		return this.estatus = Estatus.valueOf(estatus);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setDataDePubliicacao(Date dataDePubliicacao) {
		this.dataDePubliicacao = dataDePubliicacao;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
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
		+ "Estatus: " + estatus + "\n";
	}

	
	public String toStringUsuario() {
		return "Nome:" + nome + "\n"
		+ "Autor: " + autor + "\n" 
		+ "Data de publiicacao: " + dataDePubliicacao  + "\n" 
		+ "Genero:"+ genero + "\n";
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}
	

	


	
}
