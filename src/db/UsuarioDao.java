package db;

import java.util.List;

import modelo.entidades.Usuario;

public interface UsuarioDao {

	void cadastrarUsuairo(Usuario obj);
	void removerUsuario(String CPF);
	Usuario encontrarUsuario(String CPF);
	List<Usuario> encontrarTodos();
	
}
