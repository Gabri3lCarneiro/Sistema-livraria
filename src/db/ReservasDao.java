package db;

import modelo.entidades.Livro;
import modelo.entidades.Usuario;

public interface ReservasDao {

	void emprestimo(String CPF, String ISBN);
	void devolucao(String CPF, String ISBN);

}