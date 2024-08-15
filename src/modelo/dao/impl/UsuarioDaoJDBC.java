package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.xdevapi.Statement;

import db.DB;
import db.DbException;
import modelo.dao.UsuarioDao;
import modelo.entidades.Livro;
import modelo.entidades.Usuario;

public class UsuarioDaoJDBC implements UsuarioDao {

	private Connection conn = null;

	public UsuarioDaoJDBC(Connection conn) {
		this.conn = conn;

	}

	@Override
	public void cadastrarUsuairo(Usuario obj) {

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO usuarios (Cpf, Name, Email, Aniversario) " 
		            + "VALUES "
					+ "(?, ?, ?, ?) " ,
					 java.sql.Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getCpf());
			st.setString(2, obj.getNome());
			st.setString(3, obj.getEmail());
			st.setDate(4, new java.sql.Date(obj.getDataDeNascimento().getTime()));

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					String cpf = rs.getString(1);
					obj.setCpf(cpf);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Erro inesperado! Nenhuma lilha afetada");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void removerUsuario(String CPF) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("DELETE FROM usuarios WHERE Cpf = ?");

			st.setString(1, CPF);

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Usuario encontrarUsuario(String CPF) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM usuarios WHERE Cpf = ?");
			st.setString(1, CPF);
			rs = st.executeQuery();
			if (rs.next()) {
				Usuario obj = instanciarUsuario(rs);
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

	private Usuario instanciarUsuario(ResultSet rs) throws SQLException {
		Usuario obj = new Usuario();
		obj.setNome(rs.getString("Name"));
		obj.setCpf(rs.getString("Cpf"));
		obj.setDataDeNascimento(rs.getDate("Aniversario"));
		obj.setEmail(rs.getString("Email"));
		return obj;
	}

	@Override
	public List<Usuario> encontrarTodos() {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			st = conn.prepareStatement("SELECT * FROM usuarios ORDER BY Name");

			rs = st.executeQuery();

			List<Usuario> list = new ArrayList();
			Map<String, Usuario> map = new HashMap();

			while (rs.next()) {

				Usuario usuario = map.get(rs.getString("Cpf"));

				if (usuario == null) {
					usuario = instanciarUsuario(rs);
					map.put(rs.getString("Cpf"), usuario);
				}

				list.add(usuario);
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
