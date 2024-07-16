package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.crypto.Data;

import entidades.Livro;
import entidades.Usuario;
import entidades.enums.Estatus;
import gerenciamento.CadastroDeUsuarios;
import gerenciamento.Livraria;
import gerenciamento.Reservas;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Livraria livraria = new Livraria();
		CadastroDeUsuarios gerenciamentoUsuarios = new CadastroDeUsuarios();
		Reservas gerenciamentoReservas = new Reservas();


		//classes pre instanciadas para testes...
		Livro livro1 = new Livro("livro1", "nomeAutor", sdf1.parse("12/05/2020"), "genero", 1, 2);
		Livro livro2 = new Livro("livro2", "nomeAuto", sdf1.parse("12/05/2020"), "genero", 1, 3);
		Livro livro3 = new Livro("livro3", "nomeAutor", sdf1.parse("12/05/2020"), "genero", 1, 4);
		Livro livro4 = new Livro("livro4", "nomeAutor", sdf1.parse("12/05/2020"), "genero", 1, 5);
		Usuario usuario1 = new Usuario("nome1", "123", "endereço", sdf1.parse("12/05/2020"));
		Usuario usuario2 = new Usuario("nome2", "1234", "endereço", sdf1.parse("12/05/2020"));
		gerenciamentoUsuarios.cadastrarUsuario(usuario1);
		gerenciamentoUsuarios.cadastrarUsuario(usuario2);
        livraria.cadastroDeLivros(livro1);
		livraria.cadastroDeLivros(livro2);
		livraria.cadastroDeLivros(livro3);
		livraria.cadastroDeLivros(livro4);
		//classes pre instanciadas para testes...



		int reposta = 0;
		while (reposta != 8) {
			
		
		UI.cabesalho();
		 reposta = sc.nextInt();
		 sc.nextLine();

		switch (reposta) {
			case 1:
			    System.out.println("Digite os dados do livro.");
			    System.out.println("Nome: ");
				String nome = sc.nextLine();
				System.out.println("Autor: ");
				String nomeAutor = sc.nextLine();
				System.out.println("Genero: ");
				String genero = sc.nextLine();
				System.out.println("Data de publicacao seguindo o seguinte padrao: (dd/mm/aaaa): ");
				Date dataDePublicacao = sdf1.parse(sc.next());
				System.out.println("Classificacao indicativa: ");
				int classificacaoIndicativa = sc.nextInt();
				System.out.println("ID: ");
				int id = sc.nextInt();

				Livro livro = new Livro(nome, nomeAutor, dataDePublicacao, genero, classificacaoIndicativa, id);
				livraria.cadastroDeLivros(livro);

				break;
            case 2: 
			    System.out.println("Qual o ID do livro que sera removido? ");
				id = sc.nextInt();
				livraria.remocaoDeLivros(id);
				livraria.imprimirAcervo();
				System.out.println();
			    break;

			case 3:
			    System.out.println("Digite os dados do usuario.");
			    System.out.println("Nome: ");
				nome = sc.next();
				System.out.println("CPF: ");
				String cpf = sc.next();
				System.out.println("Endereço: ");
				String endereço = sc.next();
				System.out.println("Data de nascimento: ");
				Date dataDeNascimento = sdf1.parse(sc.next());

				Usuario usuario = new Usuario(nome, cpf, endereço, dataDeNascimento);
				gerenciamentoUsuarios.cadastrarUsuario(usuario);

			    break;

			case 4:
			    System.out.println("Digite o CPF do usuario que sera removido:  ");
				cpf = sc.next();
				gerenciamentoUsuarios.remocaoDeUsuario(cpf);

			    break;

			case 5:
			    System.out.println("Livros em acervo:" + "\n");
				livraria.imprimirAcervo();	

				break;

            case 6: 
			    System.out.println("Digite o ID do livro que voce deseja consultar: ");
				id = sc.nextInt();
			    livraria.imprimirLivro(id);

			    break;

            case 7:
			    System.out.println("Digite o ID do livro que sera emprestado: ");
				id = sc.nextInt();
				System.out.println("Digite o CPF do usuario: ");
				cpf = sc.next();
				gerenciamentoReservas.emprestimo(livraria.acharLivro(id), gerenciamentoUsuarios.acharUsuario(cpf));
				UI.notaDeEmpretimo(livraria.acharLivro(id), gerenciamentoUsuarios.acharUsuario(cpf));

				break;

            case 8:
			    System.out.println("Digite o ID do livro que sera devolvido: ");
			    id = sc.nextInt();
			    System.out.println("Digite o CPF do usuario: ");
			    cpf = sc.next();
				gerenciamentoReservas.devolucao(livraria.acharLivro(id),gerenciamentoUsuarios.acharUsuario(cpf));
				UI.notaDeDevolucao(livraria.acharLivro(id), gerenciamentoUsuarios.acharUsuario(cpf));

				break;

			default:
			    System.out.println("baaah");
			break;
		}
	
	}
		sc.close();
	}

}






 //System.out.println(remocaoDeLivros.toString());
 //List <Livro> remocaoDeLivros = livraria.acervoDeLivros.stream().filter(x -> x.teste(x)))).collect(Collectors.toList());
//((Stream<Livro>)livraria.acervoDeLivros.stream().filter(x -> x.getNome().equals(nomeR))).collect(Collectors.toList()).remove(remocaoDeLivros);