package modelo.dao;

import db.DB;
import modelo.dao.impl.LivrariaDaoJDBC;
import modelo.dao.impl.ReservasDaoJDBC;
import modelo.dao.impl.UsuarioDaoJDBC;

public class DaoFabrica {

	public static LivrariaDao criarLivrariaDao() {
		return new LivrariaDaoJDBC(DB.getConnection());
	}
	
	public static UsuarioDao criarUsuarioDao() {
		return new UsuarioDaoJDBC(DB.getConnection());
	}
	
	public static ReservasDao criarReservasDao() {
		return new ReservasDaoJDBC(DB.getConnection());
	}
}
