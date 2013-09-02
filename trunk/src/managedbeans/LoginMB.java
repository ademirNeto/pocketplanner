package managedbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import business.LoginBean;
import dominio.Usuario;

/**
 * Classe que interage com a tela de login e com a classe de negocio de login
 *
 */
@SessionScoped
@ManagedBean
public class LoginMB {
	@EJB
	private LoginBean loginBean;
	private String login, senha; 
	
	/**
	 * Fun��o logar
	 */
	public String logar(){
		Usuario usuarioLogado = loginBean.logar(login, senha);
		if (usuarioLogado != null){
			return "OK";
		}
		FacesMessage msg = new FacesMessage("Usu�rio ou senha incorretos");
	    FacesContext.getCurrentInstance().addMessage("form", msg);
	    return "";
	}
	
	/**
	 * Cadastrar
	 */
	public String cadastrar(){
		return "Cadastro";
	}

	/**
	 * @return the loginBean
	 */
	public LoginBean getLoginBean() {
		return loginBean;
	}

	/**
	 * @param loginBean the loginBean to set
	 */
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
		



	

}
