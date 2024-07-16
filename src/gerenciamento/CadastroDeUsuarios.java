package gerenciamento;

import java.util.ArrayList;
import java.util.List;

import entidades.Livro;
import entidades.Usuario;

public class CadastroDeUsuarios {

	private Usuario usuaio;
	
	
	public List<Usuario> usuarios = new ArrayList();
	


	public Usuario acharUsuario(String cpf){
		for(Usuario usuario : usuarios){
			if(usuario.getCpf().equals(cpf)){
				return usuario;
			}
		}
		return null;//coloca as execoes em pai...
	}



	
	public void cadastrarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public void remocaoDeUsuario(String cpf) {
		acharUsuario(cpf);
		usuarios.remove(acharUsuario(cpf));
	}	

	public  void imprimirUsuario(){
		for(Usuario usuario : usuarios){
			System.out.println(usuario.toString());

		}
	}




}

