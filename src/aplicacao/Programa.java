package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import gerenciamento.GerenciamentoUsuarios;
import gerenciamento.Livraria;
import gerenciamento.Reservas;
import gerenciamento.ExecoesGerenciamento;
import modelo.entidades.Livro;
import modelo.entidades.Usuario;

public class Programa {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Livraria livraria = new Livraria();
		GerenciamentoUsuarios gerenciamentoUsuarios = new GerenciamentoUsuarios();
		Reservas gerenciamentoReservas = new Reservas();

		String nome;
		String nomeAutor;
		String id;
		String cpf;
		boolean encerramento = true;
		int reposta = 0;

		
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
				nome = sc.nextLine();
				System.out.println("Autor: ");
				nomeAutor = sc.nextLine();
				System.out.println("Genero: ");
				String genero = sc.nextLine();
				System.out.println("Data de publicacao seguindo o seguinte padrao: (dd/mm/aaaa): ");
				Date dataDePublicacao = sdf1.parse(sc.next());
				System.out.println("Classificacao indicativa: ");
				int classificacaoIndicativa = sc.nextInt();
				System.out.println("ID: ");
				id = sc.next();

				Livro livro = new Livro(nome, nomeAutor, dataDePublicacao, genero, classificacaoIndicativa, id);
				livraria.cadastroDeLivros(livro);
			}

				break;
            case 2: 
			    System.out.println("Qual o ID do livro que sera removido? ");
				id = sc.nextLine();
				livraria.remocaoDeLivros(id);
				livraria.imprimirAcervo();
				System.out.println();
			    break;

			case 3:
			System.out.println("Quantos usuarios deseja cadastrar? ");
			x = sc.nextInt();
			for(int i= 0; i < x; i ++){
				sc.nextLine();
			    System.out.println("Digite os dados do usuario.");
			    System.out.println("Nome: ");
				nome = sc.next();
				System.out.println("CPF: ");
				cpf = sc.next();
				System.out.println("Endereço: ");
				String endereço = sc.next();
				System.out.println("Data de nascimento: ");
				Date dataDeNascimento = sdf1.parse(sc.next());

				Usuario usuario = new Usuario(nome, cpf, endereço, dataDeNascimento);
				gerenciamentoUsuarios.cadastrarUsuario(usuario);
			}

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
				id = sc.nextLine();
			    livraria.imprimirLivro(id);

			    break;

            case 7:
			    System.out.println("Digite o ID do livro que sera emprestado: ");
				id = sc.nextLine();
				System.out.println("Digite o CPF do usuario: ");
				cpf = sc.next();
				gerenciamentoReservas.emprestimo(livraria.acharLivro(id), gerenciamentoUsuarios.acharUsuario(cpf));
				UI.notaDeEmpretimo(livraria.acharLivro(id), gerenciamentoUsuarios.acharUsuario(cpf));

				break;

            case 8:
			    System.out.println("Digite o ID do livro que sera devolvido: ");
			    id = sc.nextLine();
			    System.out.println("Digite o CPF do usuario: ");
			    cpf = sc.next();
				gerenciamentoReservas.devolucao(livraria.acharLivro(id),gerenciamentoUsuarios.acharUsuario(cpf));
				UI.notaDeDevolucao(livraria.acharLivro(id), gerenciamentoUsuarios.acharUsuario(cpf));

				break;

			case 9:
			    encerramento = false;
				System.out.println("Programa encerrado");	
			break;
		}
	}

catch(ExecoesGerenciamento e){
	System.out.println("Erro: " + e.getMessage());
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






