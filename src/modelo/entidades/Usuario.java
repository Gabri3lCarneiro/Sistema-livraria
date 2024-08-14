package modelo.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {

	
	private String nome;
	private String cpf;
	private String email;
	private Date dataDeNascimento;
	
	 public List<Livro> livrosReservados = new ArrayList();
	
	
	public Usuario(String nome, String cpf, String email, Date dataDeNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email; 
		this.dataDeNascimento = dataDeNascimento;
		
	}

	public Usuario() {
		
	}
	
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String endereco) {
		this.email = endereco;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void livrosEmRerva(Livro livro) {
		livrosReservados.add(livro);
	}


	public void imprimitLivrosEmRerva() {
		for(Livro livro: livrosReservados ){
			System.out.println(livro.toStringUsuario());
		}
		
	}

	public String toString(){
		return "Nome: " + this.nome + "\n"
		+ "CPF: " + this.cpf + "\n"
		+ "Email: " + this.email + "\n"
		 + "Data de Nascimento: " + this.dataDeNascimento + "\n";
		
	}

}
