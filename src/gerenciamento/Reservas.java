package gerenciamento;

import java.util.ArrayList;
import java.util.List;

import entidades.Livro;
import entidades.Usuario;

public class Reservas {

	private Livro livro;
	private Usuario usuario;
	
	private Livraria livraria;
	
	List<Livro> reservado = new ArrayList();
	
	public Reservas(Livro livro, Usuario usuario) {
		this.livro = livro;
		this.usuario = usuario;
	}



	private void emprestimo(Livro livro, Usuario usuario) {
		reservado.add(livro);
		livraria.remocaoDeLivros(livro);
		
	}
	
	private void devolucao(Livro livro, Usuario usuario) {
		reservado.remove(livro);
		livraria.cadastroDeLivros(livro);
		
	}
	
	
}
