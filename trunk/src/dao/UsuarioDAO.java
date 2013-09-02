package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Usuario;

@Stateless
public class UsuarioDAO  {
	
	@PersistenceContext(unitName = "pocketplanner")
	private EntityManager manager;
	
	public UsuarioDAO () {
		
	}
	
	/**
	 * @param Usuario usuario
	 */
	public void cadastrarUsuario (Usuario usuario) {
		manager.persist(usuario);
	}
	
	/**
	 * @param String login
	 */
	public Usuario pesquisaPorLogin(String login) {
		Query query = manager.createQuery("select u from Usuario u where u.login = :login", Usuario.class);
    	query.setParameter("login", login);
    	return (Usuario) query.getSingleResult();
        
	}
}
