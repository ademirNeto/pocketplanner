package br.com.controller;


import br.com.controller.ControllerInterface;
import br.com.dao.UserDAO;
import br.com.model.User;

public class UserController implements ControllerInterface {

	@Resource
	private UserDAO dao;
	private User userLogged;

	public UserController() {
	}

	@Override
	public Object insert(Object object) throws Exception {
		User newUser = (User) object;
		
		//Busca se j� existe um usuario no banco com o email do usuario a ser cadastrado.
		//Caso sim: Lan�a uma exce��o
		/**User oldUser = dao.searchByEmail(newUser.getEmail());
		if (oldUser != null){
			throw new Exception("J� existe um usu�rio registrado com esse email");
		}**/
		
		//Insere o usuario no Banco de dados.
		//Caso retorno seja != nulo >> Usuario foi cadastrado
		User confirmedUser = (User) dao.insert(newUser);
		if (confirmedUser != null){
			return confirmedUser;
		}
		return null;
		
	}

	@Override
	public Object update(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object search(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean remove(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User login(String email, String password) {
		
		/**User user = this.dao.searchByEmail(email);

			//Verifica se o usuario foi encontrado 
			if (user != null) {
				//Verifica se o password � igual
				if (user.getPassword().equals(password)) {
					
					//set userLogged (usuario da sess�o) com o usuario encontrado
					this.userLogged = user;
					
					//Caso campo staySigned seja marcado, salva o usuario logado no banco 
					//para ao carregar a aplica��o o usuario n�o precise se logar todas as vezes 
					
			} else {
				this.userLogged = null;
			}
			return userLogged;

		}**/
		
		this.userLogged = new User ();
		userLogged.setEmail(email);
		userLogged.setPassword(password);
		
		return userLogged;
	}


	/**public boolean logout() {
		userLogged = null;
		return this.dao.setStaySigned(userLogged);
	}**/

	public User getUserLogged() {
		return userLogged;
	}

	//Verifica se o ultimo usuario logado marcou a op��o "Mantenha-me conectado"
	//Caso positivo, coloca o respectivo usuario na sess�o
	/**public boolean getStaySigned() {
		String email = this.dao.getStaySigned();
		
		if (email != null){
			userLogged = this.dao.searchByEmail(email);
			return true;
		}
		
		return false;
	}**/

}
