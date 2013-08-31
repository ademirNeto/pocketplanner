package business;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Usuario;

@Stateful
public class LoginBean {
	
	@PersistenceContext(unitName = "pocketplanner")
	private EntityManager manager;
	private Usuario usuarioLogado;
	
	public LoginBean() {
	}
	
	public Usuario logar(String login, String senha) {
		
		Query query = manager.createQuery("select u from Usuario u where u.email = :email", Usuario.class);
    	query.setParameter("email", login);
    	Usuario usuario;
    	try {
    		usuario = (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			usuario = null; 
		}
    	
    	
    	System.out.println(usuario);

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
	

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}


}
