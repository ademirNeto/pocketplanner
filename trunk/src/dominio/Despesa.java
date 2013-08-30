package dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe que representa as despesas
 * @author Mariana
 *
 */
@Entity
public class Despesa extends Transacao {
	
	@Temporal(value=TemporalType.DATE)
	private Date data_vencimento;
	@ManyToOne
	private StatusDespesa status;
	private boolean composta;
	@ManyToOne
	private Despesa despesa_pai;
	@ManyToMany
	private List <Lembrete> lembretes;
	
	public Despesa () {
		super ();
	}

	/**
	 * @return the data_vencimento
	 */
	public Date getData_vencimento() {
		return data_vencimento;
	}

	/**
	 * @param data_vencimento the data_vencimento to set
	 */
	public void setData_vencimento(Date data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	/**
	 * @return the status
	 */
	public StatusDespesa getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusDespesa status) {
		this.status = status;
	}

	/**
	 * @return the composta
	 */
	public boolean isComposta() {
		return composta;
	}

	/**
	 * @param composta the composta to set
	 */
	public void setComposta(boolean composta) {
		this.composta = composta;
	}

	/**
	 * @return the despesa_pai
	 */
	public Despesa getDespesa_pai() {
		return despesa_pai;
	}

	/**
	 * @param despesa_pai the despesa_pai to set
	 */
	public void setDespesa_pai(Despesa despesa_pai) {
		this.despesa_pai = despesa_pai;
	}

	
}
