package modelo.dao.impl;

import java.util.List;

import db.DB;
import db.LivrariaDao;
import db.UsuarioDao;
import modelo.entidades.Livro;

public class DaoFabrica {

	public static LivrariaDao criarLivrariaDao() {
		return new LivrariaDaoJDBC(DB.getConnection());
	}
	
	public static UsuarioDao criarUsuarioDao() {
		return new UsuarioDaoJDBC(DB.getConnection());
	}
}
