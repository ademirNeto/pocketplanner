package dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe que representa um lembrete
 * @author Mariana
 *
 */
@Entity
public class Lembrete {
	
	@Id
	private Integer id;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date data_hora;
	@ManyToOne
	private TipoLembrete tipo;
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
	 * @return the data_hora
	 */
	public Date getData_hora() {
		return data_hora;
	}
	/**
	 * @param data_hora the data_hora to set
	 */
	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
	}
	/**
	 * @return the tipo
	 */
	public TipoLembrete getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoLembrete tipo) {
		this.tipo = tipo;
	}
	
	

}
