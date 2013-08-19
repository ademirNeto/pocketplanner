package sessionbeans;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.UsuarioDAO;
import dominio.Usuario;

@Stateless
public class UsuarioBSBean {

	private Usuario usuarioLogado;
	private UsuarioDAO dao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cadastrarUsuario(Usuario usuario)  throws Exception  {
		
		dao = new UsuarioDAO ();
		Usuario antigo = null;//dao.pesquisaPorLogin (usuario.getLogin());
		
		if (antigo != null){
			throw new Exception("Já existe um usuário registrado com esse email");
		} else {
			
			try{
				dao.cadastrarUsuario(usuario);

	        }catch (Exception e) {
	        	e.printStackTrace();
	        	throw new RuntimeException();

	        }
			
		}	
		
	}

	public Usuario logar(String login, String senha) {
		
		Usuario usuario = dao.pesquisaPorLogin(login);

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
		

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
