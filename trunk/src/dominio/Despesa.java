package dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	private Date dataVencimento;

	@Enumerated(EnumType.STRING)
	private StatusDespesa status;
	
	private boolean composta;
	@ManyToOne
	private Despesa despesaPai;
	@ManyToMany
	public List <Lembrete> lembretes;
	
	public Despesa() {
	}

	/**
	 * @return the data_vencimento
	 */
	public Date getDataVencimento() {
		return dataVencimento;
	}

	/**
	 * @param dataVencimento the dataVencimento to set
	 */
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
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
	public Despesa getDespesaPai() {
		return despesaPai;
	}

	/**
	 * @param despesaPai the despesaPai to set
	 */
	public void setDespesaPai(Despesa despesaPai) {
		this.despesaPai = despesaPai;
	}
	
	/**
	 * @return the String
	 */
	@Override
	public String toString() {
		return String.format("Despesa: titulo - %s; descri��o - %s; valor - %s; data de vencimento - %s", getTitulo(), getDescricao(), getValor(), getDataVencimento());
	}
	

	
}
