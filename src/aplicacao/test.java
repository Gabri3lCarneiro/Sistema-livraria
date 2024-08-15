package aplicacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import entidades.enums.Estatus;
import modelo.dao.DaoFabrica;
import modelo.dao.LivrariaDao;
import modelo.dao.ReservasDao;
import modelo.dao.UsuarioDao;
import modelo.dao.impl.ReservasDaoJDBC;
import modelo.entidades.Livro;
import modelo.entidades.Reservas;
import modelo.entidades.Usuario;

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
		
		System.out.println("==================================");
		
		UsuarioDao usuarioDao = DaoFabrica.criarUsuarioDao();
		Usuario usuario = usuarioDao.encontrarUsuario("1");
		System.out.println(usuario);
		System.out.println();
		
		Usuario usuario1 = new Usuario("fag", "123456", "lasidjghGgamail", new Date() );
		//usuarioDao.cadastrarUsuairo(usuario1);
		System.out.println("Deu certo");
		System.out.println();
		
		//usuarioDao.removerUsuario(usuario1.getCpf());
		//System.out.println("Deu certo");
		System.out.println();
		
		List<Usuario> list2 = usuarioDao.encontrarTodos();
		list2.forEach(System.out::println);
		

		ReservasDao reservasDao = DaoFabrica.criarReservasDao();
		Reservas rev = new Reservas(new Date(),new Date());
		reservasDao.emprestimo(usuarioDao.encontrarUsuario("1"), livrariaDao.encontrarPorId("9788542221060"), rev);
	}

}
