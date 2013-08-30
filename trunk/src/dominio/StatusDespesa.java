package dominio;

import javax.persistence.Id;
import javax.persistence.Entity;

/**
 * Classe de status das despesas
 * @author Mariana
 *
 */
@Entity
public class StatusDespesa {
	
	@Id
	private Integer id;
	private String status;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
