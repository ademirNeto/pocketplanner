package br.com.gui;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.controller.UserController;
import br.com.model.User;

@ManagedBean
@RequestScoped
public class Login {

	private User usuario;
	private UserController uc;
	
	public Login (){
		usuario = new User ();
	}
	
	public String logar (){
		uc = new UserController ();
		String email = usuario.getEmail();
		String senha = usuario.getPassword();
		if(uc.login(email, senha) != null) {
            return "OK";
        }
		FacesMessage msg = new FacesMessage("Usuário ou senha incorretos");
	    FacesContext.getCurrentInstance().addMessage("form", msg);
	    return "";
	}
	
	public String cadastrar (){
		return "Cadastro";
	}
		
	

	public User getUsuario() {
		return this.usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	
}
