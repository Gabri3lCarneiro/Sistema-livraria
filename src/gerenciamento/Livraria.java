package gerenciamento;

import java.util.ArrayList;
import java.util.List;

import entidades.Livro;
import entidades.Usuario;

public class Livraria {

	private Livro livro;
	
	
	public static List<Livro> acervoDeLivros = new ArrayList();
	
	public void cadastroDeLivros(Livro livro) {
		acervoDeLivros.add(livro);
	}
	
	public void remocaoDeLivros(int id) {
		acervoDeLivros.remove(acharLivro(id));
			
		}
	
	
	public Livro acharLivro(int id){
		for(Livro livro : acervoDeLivros){
			if(livro.getId() == id){
				return livro;
			}
		}
		return null;//coloca as execoes em pai...
	}


	public void imprimirLivro(int id){
		System.out.println(acharLivro(id).toStringLivraria());
		
	}
	
	public  void imprimirAcervo(){
		for(Livro livro : acervoDeLivros){
			System.out.println(livro.toStringLivraria());

		}
	}
	
	
}
