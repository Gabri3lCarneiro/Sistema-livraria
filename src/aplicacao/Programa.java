 package aplicacao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import db.DbException;
import entidades.enums.Estatus;
import modelo.dao.DaoFabrica;
import modelo.dao.LivrariaDao;
import modelo.dao.ReservasDao;
import modelo.dao.UsuarioDao;
import modelo.entidades.Livro;
import modelo.entidades.Reservas;
import modelo.entidades.Usuario;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean encerramento = true;
		int reposta = 0;
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		LivrariaDao livrariaDao = DaoFabrica.criarLivrariaDao();
		UsuarioDao usuarioDao = DaoFabrica.criarUsuarioDao();
		ReservasDao reservasDao = DaoFabrica.criarReservasDao();
		
		
		while (encerramento) {
			
			try{
			
			UI.cabesalho();
			 reposta = sc.nextInt();
			 sc.nextLine();

			switch (reposta) {
				case 1:
				System.out.println("Quantos livros deseja cadastrar? ");
				int x = sc.nextInt();
				for(int i= 0; i < x; i ++){
					sc.nextLine();
				    System.out.println("Digite os dados do livro.");
				    System.out.println("Nome: ");
					String nome = sc.nextLine();
					System.out.println("Autor: ");
					String nomeAutor = sc.nextLine();
					System.out.println("Genero: ");
					String genero = sc.nextLine();
					System.out.println("Data de publicacao seguindo o seguinte padrao: (dd/mm/aaaa): ");
					Date dataDePublicacao = sdf1.parse(sc.next());
					System.out.println("ISBN: ");
					String ISBN = sc.next();

					Livro livro = new Livro(nome, nomeAutor, dataDePublicacao, genero, ISBN, Estatus.DISPONÍVEL);
					livrariaDao.inserir(livro);
					System.out.println("Livro cadastrado: ");
					System.out.println();
					
				}

					break;
	            case 2: 
				    System.out.println("Qual o ISBN do livro que sera removido? ");
				    String ISBN = sc.nextLine();
				    livrariaDao.excluirPorId(ISBN);
					System.out.println("Livro removido");
					System.out.println();
				    break;

				case 3:
				System.out.println("Quantos usuarios deseja cadastrar? ");
				x = sc.nextInt();
				for(int i= 0; i < x; i ++){
					sc.nextLine();
				    System.out.println("Digite os dados do usuario.");
				    System.out.println("Nome: ");
				    String nome = sc.next();
					System.out.println("CPF: ");
					String cpf = sc.next();
					System.out.println("Email: ");
					String email = sc.next();
					System.out.println("Data de nascimento: ");
					Date dataDeNascimento = sdf1.parse(sc.next());
					Usuario usuario = new Usuario(nome, cpf, email, dataDeNascimento);
					
					usuarioDao.cadastrarUsuairo(usuario);
					System.out.println("Usuario cadastrado: ");
					System.out.println();
				}

				    break;

				case 4:
				    System.out.println("Digite o CPF do usuario que sera removido:  ");
				    String cpf = sc.next();
				    usuarioDao.removerUsuario(cpf);
				    System.out.println("Usuario removido");
				    System.out.println();

				    break;

				case 5:
				    System.out.println("Livros em acervo:" + "\n");
				    List <Livro> list = livrariaDao.encontrarTodos();
				    list.forEach(System.out::println);
				    System.out.println();

					break;

	            case 6: 
				    System.out.println("Digite o ISBN do livro que voce deseja consultar: ");
				    ISBN = sc.nextLine();
				    livrariaDao.encontrarPorId(ISBN);
				    System.out.println();

				    break;

	            case 7:
				    System.out.println("Digite o ISBN do livro que sera emprestado: ");
				    ISBN = sc.nextLine();
					System.out.println("Digite o CPF do usuario: ");
					cpf = sc.next();
					Reservas reservas = new Reservas(new Date(), new Date());
					reservasDao.emprestimo(usuarioDao.encontrarUsuario(cpf), livrariaDao.encontrarPorId(ISBN), reservas);
					System.out.println("Emprestimo realizado");
					System.out.println();
					UI.notaDeEmpretimo(livrariaDao.encontrarPorId(ISBN), usuarioDao.encontrarUsuario(cpf));
					System.out.println();

					break;

	            case 8:
				    System.out.println("Digite o ISBN do livro que sera devolvido: ");
				    ISBN = sc.nextLine();
				    System.out.println("Digite o CPF do usuario: ");
				    cpf = sc.next();
				    Reservas devolucao = new Reservas(new Date(), new Date());
					reservasDao.devolucao( usuarioDao.encontrarUsuario(cpf), livrariaDao.encontrarPorId(ISBN), devolucao);
					System.out.println("Devolucao realizada");
					System.out.println();
					UI.notaDeDevolucao(livrariaDao.encontrarPorId(ISBN), usuarioDao.encontrarUsuario(cpf));
					System.out.println();
					break;

				case 9:
				    encerramento = false;
					System.out.println("Programa encerrado");	
				break;
			}
		}

	catch(ParseException e){
		System.out.println("Erro: Data invalida");
	}
	catch(InputMismatchException e){
		System.out.println("Valor invalido");
		sc.nextLine();
	}
		
		}

		
		}

	}


