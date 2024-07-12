package gerenciamento;

import java.util.ArrayList;
import java.util.List;

import entidades.Livro;

public class Livraria {

	private Livro livro;
	
	
	List<Livro> livros = new ArrayList();
	
	public void cadastroDeLivros(Livro livro) {
		livros.add(livro);
	}
	
	public void remocaoDeLivros(Livro livro) {
		livros.remove(livro);
	}
	
	
	
}
