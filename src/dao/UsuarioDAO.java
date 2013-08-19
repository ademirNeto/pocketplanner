package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Usuario;

public class UsuarioDAO {
	
	@PersistenceContext(unitName = "pocketplanner")
	private EntityManager manager;
	
	public void cadastrarUsuario (Usuario usuario) {
		System.out.println(manager);
		manager.persist(usuario);
	}
	

	public Usuario pesquisaPorLogin(String login) {
		Query query = manager.createQuery("select u from Usuario u where u.login = :login", Usuario.class);
    	query.setParameter("login", login);
    	return (Usuario) query.getSingleResult();
        
	}
}
