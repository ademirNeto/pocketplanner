package managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dominio.Usuario;
import sessionbeans.UsuarioBSBean;

@ManagedBean
@SessionScoped
public class CadastroMB {
	@EJB
	private UsuarioBSBean usuarioBSBean;
	private String nome, login, senha; 
	

	public String salvarUsuario() throws Exception{
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		try {
			usuarioBSBean.cadastrarUsuario(usuario);
		return "CadastroOK";} catch (Exception e) {
			e.printStackTrace();
			return "";
		} }
	
	public String voltar (){
		return "Voltar";
	}
	
	public UsuarioBSBean getUsuarioBSBean() {
		return usuarioBSBean;
	}


	public void setUsuarioBSBean(UsuarioBSBean usuarioBSBean) {
		this.usuarioBSBean = usuarioBSBean;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
