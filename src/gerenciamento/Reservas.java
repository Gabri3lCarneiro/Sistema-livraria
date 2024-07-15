package gerenciamento;

import java.util.ArrayList;
import java.util.List;

import entidades.Livro;
import entidades.Usuario;
import entidades.enums.Estatus;

public class Reservas {

	private Livro livro;
	private Usuario usuario;
	
	private Livraria livraria;
	
	List<Livro> reservado = new ArrayList();
	
	public Reservas(Livro livro, Usuario usuario) {
		this.livro = livro;
		this.usuario = usuario;
	}



	public void emprestimo(Livro livro, Usuario usuario) {
		if(livro.getEstatus() != Estatus.DISPONIVEL) {
			throw new execoesGerenciamento("Livro ja está reservado");
		}
		if(usuario.livrosReservados.size() >= 2){
			throw new execoesGerenciamento("Usuario atingil o limite de reservas "  + usuario.livrosRervados());
		}
		reservado.add(livro);
		livro.mudancaDeEstatus(livro);
		usuario.livrosReservados.add(livro);
	}
	
	public void devolucao(Livro livro, Usuario usuario) {
		reservado.remove(livro);
		usuario.livrosReservados.remove(livro);
		
	}
	
	
}
