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
	private Date dataHora;
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
	public Date getDataHora() {
		return dataHora;
	}
	/**
	 * @param dataHora the dataHora to set
	 */
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
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
