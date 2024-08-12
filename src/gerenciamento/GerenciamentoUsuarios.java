package gerenciamento;

import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Livro;
import modelo.entidades.Usuario;

public class GerenciamentoUsuarios {

	private Usuario usuaio;
	
	
	public List<Usuario> usuarios = new ArrayList();
	


	public Usuario acharUsuario(String cpf){
		for(Usuario usuario : usuarios){
			if(usuario.getCpf().equals(cpf)){
				return usuario;
			}
		}
		return null;
	}

	public String acharUsuarioCPF(String cpf){
		for(Usuario usuario : usuarios){
			if(usuario.getCpf().equals(cpf)){
				return usuario.getCpf();
			}
		}
		return null;
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		if(usuario.getCpf().equals(acharUsuarioCPF(usuario.getCpf()))){
			throw new ExecoesGerenciamento("CPF ja cadastrado");
		}
		usuarios.add(usuario);
	}
	
	public void remocaoDeUsuario(String cpf) {
		if(acharUsuario(cpf) == null){
			throw new ExecoesGerenciamento("CPF nao encontrado");
		}
		acharUsuario(cpf);
		usuarios.remove(acharUsuario(cpf));
	}	

	public  void imprimirUsuario(){
		for(Usuario usuario : usuarios){
			System.out.println(usuario.toString());

		}
	}

}

