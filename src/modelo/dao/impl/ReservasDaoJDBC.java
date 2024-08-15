package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.ReservasDao;
import modelo.entidades.Livro;
import modelo.entidades.Usuario;

public class ReservasDaoJDBC implements ReservasDao {

	private Connection conn;

	public ReservasDaoJDBC(Connection conn) {
		super();
		this.conn = conn;
	}
	



	@Override
	public void emprestimo(String CPF, String ISBN) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM livraria WHERE ISBN = ?" + 
					"SELECT * FROM usuarios WHERE Cpf = ?");
			
			st.setString(1, ISBN);
			st.setString(2, CPF);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	@Override
	public void devolucao(String CPF, String ISBN) {
		// TODO Auto-generated method stub
		
	}

	
}
