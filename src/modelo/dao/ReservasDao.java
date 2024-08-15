package modelo.dao;

import modelo.entidades.Livro;
import modelo.entidades.Reservas;
import modelo.entidades.Usuario;

public interface ReservasDao {

	void emprestimo(Usuario usuario, Livro livro, Reservas reservas);
	void devolucao(Usuario usuario, Livro livro, Reservas reservas);
	

}