package br.com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer Id;
	private String email;
	private String name;
	private String password;

	public User(String email, String passwd, String name) {
		this.email = email;
		this.password = passwd;
		this.setName(name);
	}

	public User() {

	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
