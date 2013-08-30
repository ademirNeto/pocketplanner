package business;

import java.util.Date;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Usuario;
import exception.PocketPlannerException;
import exception.PocketPlannerRuntimeException;
//import dao.UsuarioDAO;


@Stateless
public class CadastroBean {

	
	//private UsuarioDAO dao;
	
	@PersistenceContext(unitName = "pocketplanner")
	private EntityManager manager;
	
	public CadastroBean () {}

	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cadastrarUsuario(Usuario usuario)  throws Exception  {
		usuario.setSenha(EncriptaSenha.encripta(usuario.getSenha()));
		usuario.setData_criacao(new Date());
		//Query para o DAO
		Query query = manager.createQuery("select u from Usuario u where u.email = :email", Usuario.class);
    	query.setParameter("email", usuario.getEmail());
    	Usuario existe;
    	
    	
    	try {
    		existe = (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			existe = null; 
		}
		
		if (existe != null){
			throw new PocketPlannerException("Já existe um usuário registrado com esse email");
		} else {
			try{
				manager.persist(usuario);

	        }catch (Exception e) {
	        	e.printStackTrace();
	        	throw new PocketPlannerRuntimeException();
	        }
		}	
	}


		

}
