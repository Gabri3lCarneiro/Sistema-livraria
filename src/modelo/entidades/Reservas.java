package modelo.entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Reservas {

	private Date dataReserva;
	private Date dataDevolucaoPrevista;
	private Date dataDevolucaoReal;
	
	private Livro livro;
	private Usuario usuario;

	
	
	List<Livro> reservado = new ArrayList();
	
	
	public Reservas(Date dataReserva, Date dataDevolucaoPrevista) {
		this.dataReserva = dataReserva;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataDevolucaoPrevista);
		calendar.add(Calendar.DAY_OF_MONTH, 10);
		this.dataDevolucaoPrevista = calendar.getTime();
		
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


	
}
