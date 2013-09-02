package managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.CadastroUsuarioBS;
import dominio.Usuario;

/**
 * Classe que interage com a tela de cadastro de usuário e com a classe de negócio de gerenciamento de usuário
 *
 */
@ManagedBean
@SessionScoped
public class CadastroUsuarioMB {
	@EJB
	private CadastroUsuarioBS cadastroUsuarioBS;
	private String nome, email, senha, confirmarSenha;

	/**
	 * Salva usuário
	 * @throws Exception
	 */
	public String salvarUsuario() throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);

		try {
			cadastroUsuarioBS.cadastrarUsuario(usuario);
			return "CadastroOK";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * Voltar para a tela de login
	 */
	public String voltar() {
		return "Voltar";
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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

	/**
	 * @return the confirmarSenha
	 */
	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	/**
	 * @param confirmarSenha the confirmarSenha to set
	 */
	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	
}
