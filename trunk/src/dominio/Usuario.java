package dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe que representa um usuário.
 * @author Mariana
 *
 */
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	@Temporal(value=TemporalType.DATE)
	private Date data_criacao;
	

	public Usuario () {
		
	}
	
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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



	@Override
	public String toString() {
		return "Usuario: "+this.nome ;
	}
	
	
	

}
