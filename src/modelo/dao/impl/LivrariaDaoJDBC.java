package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import modelo.dao.LivrariaDao;
import modelo.entidades.Livro;

public class LivrariaDaoJDBC implements LivrariaDao{

	private Connection conn = null;
	
	public LivrariaDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void inserir(Livro obj) {
		PreparedStatement st =null;
		
		try {
			
			st = conn.prepareStatement("INSERT INTO livraria " 
		+ "(ISBN, Nome, Autor, Data_Publicacao, genero, Status) "
		+ "VALUES " 
		+ "(?, ?, ?, ?, ?, ?) ", 
		java.sql.Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getISBN());
			st.setString(2, obj.getNome());
			st.setString(3, obj.getAutor());
			st.setDate(4,  new java.sql.Date(obj.getDataDePubliicacao().getTime()));
			st.setString(5, obj.getGenero());
			st.setString(6, obj.getEstatus().name());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					String ISBN  = rs.getString(1);
					obj.setISBN(ISBN);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro inesperado! Nenhuma lilha afetada");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Livro encontrarPorId(String ISBN) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"SELECT * FROM livraria WHERE ISBN = ?");
			st.setString(1, ISBN); 
			rs = st.executeQuery();
			if (rs.next()) {
				Livro obj = instaciarLivro(rs);
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
		
	private Livro instaciarLivro(ResultSet rs) throws SQLException {
		Livro obj = new Livro();
		obj.setNome(rs.getString("Nome"));
		obj.setAutor(rs.getString("Autor"));
		obj.setDataDePubliicacao(rs.getDate("Data_Publicacao"));
		obj.setGenero(rs.getString("Genero"));
		obj.setISBN(rs.getString("ISBN"));
		obj.setEstatus(rs.getString("Status"));
		return obj;
	}

	
	@Override
	public void excluirPorId(String ISBN) {
		
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("DELETE FROM livraria WHERE ISBN = ?");
			
			st.setString(1, ISBN);
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
		

	@Override
	public List<Livro> encontrarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			st = conn.prepareStatement(
					"SELECT * FROM livraria ORDER BY Nome");

			rs = st.executeQuery();

			List<Livro> list = new ArrayList();
			Map<String, Livro> map = new HashMap();
			
			while (rs.next()) {

				Livro livro1 = map.get(rs.getString("ISBN"));

				if (livro1 == null) {
					livro1 = instaciarLivro(rs);
					map.put(rs.getString("ISBN"), livro1);
				}
				
				list.add(livro1);

			}

			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
		
}
