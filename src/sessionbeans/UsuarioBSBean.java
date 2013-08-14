package sessionbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Usuario;

@Stateless
public class UsuarioBSBean {

	private Usuario usuarioLogado;
	@PersistenceContext(unitName = "pocketplanner")
	private EntityManager manager;
	private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cadastrarUsuario(Usuario usuario)  throws Exception  {
		
		Usuario antigo = null;//pesquisaPorLogin (usuario.getLogin());
		
		if (antigo != null){
			throw new Exception("Já existe um usuário registrado com esse email");
		} else {
			
			try{
				//manager.getTransaction().begin(); - EJB
				manager.persist(usuario);
				//manager.getTransaction().commit();

	        }catch (Exception e) {
	        	e.printStackTrace();
	        	//manager.getTransaction().rollback();
	        	throw new RuntimeException();

	        }
			
		}	
		
	}

	public Usuario logar(String login, String senha) {
		
		Usuario usuario = pesquisaPorLogin(login);

		if (usuario != null) {
			if (usuario.getSenha().equals(senha)) {
				
				this.usuarioLogado = usuario;
				} else {
					this.usuarioLogado = null;
					
				}
		} else {
			this.usuarioLogado = null;
		}
		
		return usuarioLogado;

	}
		
	public Usuario pesquisaPorLogin(String login) {
		Usuario usuario = null;
        try {
        	Query query = manager.createQuery("select u from usuario as u where u.login = :login");
        	query.setParameter("login", login);
        	List <Usuario> usuarios = query.getResultList();
        	for (Usuario encontrado : usuarios) {
        		usuario = encontrado;
        		}
        	} finally {
        		manager.close();
        		
        	}
        
        return usuario;
        
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
