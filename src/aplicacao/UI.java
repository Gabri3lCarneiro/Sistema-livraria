package aplicacao;

import entidades.Livro;
import entidades.Usuario;

public class UI {


public static void cabesalho(){

    System.out.println("======================Seja bem vindo======================");
    System.out.println();
	System.out.println("  Digite o numero da opcao desejada para continuar: ");
    System.out.println();
    System.out.println("  1- Cadatro de livros ");
    System.out.println("  2- Remocao de livros");
    System.out.println("  3- Cadatro de usuario");
    System.out.println("  4- Remocao de usuario");
    System.out.println("  5- Acervo de livros");
    System.out.println("  6- Consulta de livros");
    System.out.println("  7- Realizar emprestimo");
    System.out.println("  8- Realizar devolucao");
    System.out.println("  9- Finalizar o programa");
}


public static void notaDeEmpretimo(Livro livro, Usuario usuario){
    System.out.println("Usuario:" + "\n" + usuario.toString());
    System.out.println("Livro a ser emprestado: " + "\n" + livro.toStringUsuario());
    System.out.println("Devoluçao devera ser efetuada em no maximo 10 dias apos a aquisiçao.");
}

public static void notaDeDevolucao(Livro livro, Usuario usuario){
    System.out.println("Usuario:" + "\n" + usuario.toString());
    System.out.println("Livro a ser devolvido: " + "\n" + livro.toStringUsuario());
}


public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
} 


}
