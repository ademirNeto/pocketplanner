package business;

import java.util.Date;


/**
 * Classe de cadastro de usu�rios
 *
 */
@Stateless
public class CadastroUsuarioBS {

	
	
	@PersistenceContext(unitName = "pocketplanner")
	private EntityManager manager;
	
	public CadastroUsuarioBS () {}

	
	/**
	 * Fun��o de cadastrar usu�rios
	 * @param usuario
	 * @throws Exception
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cadastrarUsuario(Usuario usuario)  throws Exception  {
		usuario.setSenha(EncriptaSenha.encripta(usuario.getSenha()));
		usuario.setDataCriacao(new Date());
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
			throw new PocketPlannerException("J� existe um usu�rio registrado com esse email");
		} else {
			try{
				manager.persist(usuario);

	        }catch (Exception e) {
	        	log.error("Ops!", e);
	        	throw new PocketPlannerRuntimeException();
	        }
		}	
	}


		

}
