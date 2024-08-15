package modelo.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enums.Estatus;
import gerenciamento.ExecoesGerenciamento;
import gerenciamento.Livraria;

public class Reservas {

	private Date dataReserva;
	private Date dataDevolucaoPrevista;
	private Date dataDevolucaoReal;
	
	private Livro livro;
	private Usuario usuario;
	private Livraria livraria;
	
	
	List<Livro> reservado = new ArrayList();
	
	
	public Reservas(Date dataReserva, Date dataDevolucaoPrevista) {
		this.dataReserva = dataReserva;
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
		
	}

	public Reservas(){
		
	}
	

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Date getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}

	public void setDataDevolucaoPrevista(Date dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}

	public Date getDataDevolucaoReal() {
		return dataDevolucaoReal;
	}

	public void setDataDevolucaoReal(Date dataDevolucaoReal) {
		this.dataDevolucaoReal = dataDevolucaoReal;
	}

	public void emprestimo(Livro livro, Usuario usuario) {
		
		if(livro.getEstatus() != Estatus.DISPONÍVEL) {
			throw new ExecoesGerenciamento("Livro ja está reservado ");
		}
		if(usuario.livrosReservados.size() >= 2){
			throw new ExecoesGerenciamento("Usuario atingiu o limite de reservas ");
		}
		reservado.add(livro);
		livro.mudancaDeEstatus(livro);
		usuario.livrosReservados.add(livro);
	}
	
	public void devolucao(Livro livro, Usuario usuario) {
		reservado.remove(livro);
		usuario.livrosReservados.remove(livro);
		
	}
	
	
}
