package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa um usuário.
 * @author Mariana
 *
 */
@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String login;
	private String senha;
	
	/**
	 * @return
	 */
	public Integer  getId() {
		return id;
	}
	/**
	 * Retorna o ID
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Usuario: "+this.nome ;
	}
	
	
	

}
