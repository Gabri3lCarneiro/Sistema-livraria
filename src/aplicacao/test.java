package aplicacao;

import java.util.Date;
import java.util.List;

import db.LivrariaDao;
import entidades.enums.Estatus;
import modelo.dao.impl.DaoFabrica;
import modelo.entidades.Livro;

public class test {

	public static void main(String[] args) {
		
		
		LivrariaDao livrariaDao = DaoFabrica.criarLivrariaDao();
		Livro livro = livrariaDao.encontrarPorId("9788586039041");
		System.out.println(livro);

		System.out.println();
		
		List <Livro> list = livrariaDao.encontrarTodos();
		list.forEach(System.out::println);
		System.out.println();
		
		Livro livro2 = new Livro("hh", "m", new Date(), "terr", "123", Estatus.DISPONÍVEL);
		//livrariaDao.inserir(livro2);
		
		livrariaDao.excluirPorId("123");
		
	}

}
