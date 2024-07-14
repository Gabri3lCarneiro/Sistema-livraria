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



	private void emprestimo(Livro livro, Usuario usuario, Estatus estatus) {
		if(livro.getEstatus().RESERVADO != null) {
			throw new execoesDeReservas("Livro ja está reservado");
		}
		if(usuario.livrosReservados.size() >= 2){
			throw new execoesDeReservas("Usuario atingil o limite de reservas "  + usuario.livrosRervados());
		}
		reservado.add(livro);
		livro.mudancaDeEstatus(livro, estatus);
	}
	
	private void devolucao(Livro livro, Usuario usuario) {
		reservado.remove(livro);
		livraria.cadastroDeLivros(livro);
		
	}
	
	
}
