package dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Classe tipo de lembrete
 * @author Mariana
 *
 */
@Entity
public class TipoLembrete {
	
	@Id
	private Integer id;
	private String tipo;
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
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
