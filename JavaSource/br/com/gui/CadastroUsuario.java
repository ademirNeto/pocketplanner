package br.com.gui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.controller.UserController;
import br.com.model.User;

@ManagedBean
@RequestScoped
public class CadastroUsuario {

	private User user;
	private UserController uc;
	
	public CadastroUsuario () {
		user = new User ();
	}
	
	public String insert () throws Exception {
		uc = new UserController ();
		uc.insert(user);
		return "CadastroOK";
		
	}
	
	public String voltar (){
		return "Voltar";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
