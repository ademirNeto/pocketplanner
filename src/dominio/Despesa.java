package dominio;

import javax.persistence.Entity;

@Entity
public class Despesa extends Transacao {

	private String status;
	
	public Despesa () {
		super ();
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
