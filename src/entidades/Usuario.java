package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {

	private String nome;
	private String cpf;
	private String endereco;
	private Date dataDeNascimento;
	
	public List<Livro> livrosReservados = new ArrayList();
	
	
	public Usuario(String nome, String cpf, String endereco, Date dataDeNascimento) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.dataDeNascimento = dataDeNascimento;
		
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void livrosEmRerva(Livro livro) {
		livrosReservados.add(livro);
	}


	public String livrosRervados() {
		for(Livro livro: livrosReservados ){
			return livro.toStringUsuario();
		}
		return null;
	}


	public String toString(){
		return "Nome: " + this.nome + "\n"
		+ "CPF: " + this.cpf + "\n"
		+ "Endereco: " + this.endereco + "\n"
		+ "Data de Nascimento: " + this.dataDeNascimento + "\n"
		+ "Livros reservados: " + livrosRervados() + "\n";

	}

}
