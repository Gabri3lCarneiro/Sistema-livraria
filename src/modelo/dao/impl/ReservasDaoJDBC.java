package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import db.DB;
import db.DbException;
import entidades.enums.Estatus;
import modelo.dao.ReservasDao;
import modelo.entidades.Livro;
import modelo.entidades.Reservas;
import modelo.entidades.Usuario;

public class ReservasDaoJDBC implements ReservasDao {

	private Connection conn;

	public ReservasDaoJDBC(Connection conn) {
		super();
		this.conn = conn;
	}
	



	@Override
	public void emprestimo(Usuario usuario, Livro livro, Reservas reservas) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("UPDATE livraria SET status = 'reservado' WHERE ISBN = ? ");
			
			st.setString(1, livro.getISBN());
			st.executeUpdate();
			usuario.livrosReservados.add(livro);
			livro.setEstatus(Estatus.RESERVADO);
			
			
			st = conn.prepareStatement("INSERT INTO reservas (Cpf_usuarios, ISBN_livraria, data_reserva, data_devolucao_prevista, data_devolucao_real, status)"
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?) ",
					java.sql.Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, usuario.getCpf());
			st.setString(2, livro.getISBN());
			st.setDate(3, new java.sql.Date(reservas.getDataReserva().getTime()));
			st.setDate(4, new java.sql.Date(reservas.getDataDevolucaoPrevista().getTime()));
			st.setDate(5, new java.sql.Date(reservas.getDataDevolucaoPrevista().getTime()));
			st.setString(6, livro.getEstatus().name());
			
			st.executeUpdate();	
			
		} catch (SQLException e) {
			throw new DbException("Erro !" + e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}


	@Override
	public void devolucao(Usuario usuario, Livro livro, Reservas reservas) {
		// TODO Auto-generated method stub
		
	}

	
}
