package gerenciamento;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Livro;
import modelo.entidades.Usuario;

public class Livraria {

	private Livro livro;
	
	
	public static List<Livro> acervoDeLivros = new ArrayList();
	
	public void cadastroDeLivros(Livro livro) {
		if (livro.getId().equals(acharLivroID((livro.getId())))) {
			throw new ExecoesGerenciamento("ID ja existe");
		}
		acervoDeLivros.add(livro);
		
	}
	

	public void remocaoDeLivros(String id) {
		if(acharLivro(id) == null){
			throw new ExecoesGerenciamento("ID invalido, livro nao encontrado");
		}
		acervoDeLivros.remove(acharLivro(id));
	}


	public String acharLivroID(String id){
		for(Livro livro : acervoDeLivros){
			if(livro.getId().equals(id)){
				return id;
			}
		}
		return null;
	}


	public Livro acharLivro(String id){
		for(Livro livro : acervoDeLivros){
			if(livro.getId().equals(id)){
				return livro;
			}
		}
		return null;
	}


	public void imprimirLivro(String id){
		if (acharLivro(id) == null) {
			throw new ExecoesGerenciamento("ID invalido, livro nao encontrado");
		}
		System.out.println(acharLivro(id).toStringLivraria());
		
	}
	
	
	public  void imprimirAcervo(){
		if (acervoDeLivros.size() == 0) {
			throw new ExecoesGerenciamento("Nenhum livro cadastrado");
		}
		for(Livro livro : acervoDeLivros){
			System.out.println(Livro.toStringLivraria);
		}
	}
	
	
}
