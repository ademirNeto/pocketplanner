package business;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Usuario;

/**
 * Classe que gerencia o login do usu�rio
 *
 */
@Stateful
public class LoginBean {
	
	@PersistenceContext(unitName = "pocketplanner")
	private EntityManager manager;
	private static Usuario usuarioLogado;
	
	public LoginBean() {
	}
	
	
	/**
	 * Fun��o de logar
	 * @param login
	 * @param senha
	 * @return usuario logado
	 */
	public Usuario logar(String login, String senha) {
		
		Query query = manager.createQuery("select u from Usuario u where u.email = :email", Usuario.class);
    	query.setParameter("email", login);
    	Usuario usuario;
    	try {
    		usuario = (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			usuario = null; 
		}
    	
    	

		if (usuario != null) {
			if (usuario.getSenha().equals(EncriptaSenha.encripta(senha)))
				{
				usuarioLogado = usuario;
				} else {
					usuarioLogado= usuario;
					
				}
		} else {
			usuarioLogado = usuario;
		}
		
		return usuarioLogado;
	}
	
	/**
	 * @return the usuarioLogado
	 */
	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}


	/**
	 * @param usuarioLogado the usuarioLogado to set
	 */
	public static void setUsuarioLogado(Usuario usuarioLogado) {
		LoginBean.usuarioLogado = usuarioLogado;
	}


}
