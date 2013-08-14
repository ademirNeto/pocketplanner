package managedbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dominio.Usuario;
import sessionbeans.UsuarioBSBean;

@SessionScoped
@ManagedBean
public class LoginMB {
	@EJB
	private UsuarioBSBean usuarioBSBean;
	private String login, senha; 
	
	public String logar(){
		Usuario usuarioLogado = usuarioBSBean.logar(login, senha);
		System.out.println("Usuario logado: "+usuarioLogado);
		if (usuarioLogado != null){
			return "OK";
		}
		FacesMessage msg = new FacesMessage("Usuário ou senha incorretos");
	    FacesContext.getCurrentInstance().addMessage("form", msg);
	    return "";
	}
	
	public String cadastrar(){
		return "Cadastro";
	}
		

	public UsuarioBSBean getUsuarioBSBean() {
		return usuarioBSBean;
	}

	public void setUsuarioBSBean(UsuarioBSBean usuarioBSBean) {
		this.usuarioBSBean = usuarioBSBean;
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
