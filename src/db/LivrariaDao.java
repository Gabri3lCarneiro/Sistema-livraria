package db;

import java.util.List;

import modelo.entidades.Livro;

public interface LivrariaDao {

	void inserir(Livro obj);
	Livro encontrarPorId(String ISBN);
	void excluirPorId(String ISBN);
	List<Livro> encontrarTodos();
}
