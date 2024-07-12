package gerenciamento;

import java.util.ArrayList;
import java.util.List;

import entidades.Usuario;

public class CadastroDeUsuarios {

	private Usuario usuaio;
	
	
	List<Usuario> usuarios = new ArrayList();
	
	
	
	public void cadastroDeUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public void remocaoDeUsuario(Usuario usuario) {
		usuarios.remove(usuario);
	}
}
