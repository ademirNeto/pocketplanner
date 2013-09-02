package dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe que representa uma receita
 * @author Mariana
 *
 */
@Entity
public class Receita extends Transacao {
	
	@Temporal(value=TemporalType.DATE)
	private Date dataRecebimento;
	@ManyToMany
	private List <Lembrete> lembretes;
	
	public Receita () {
		super ();
	}

	/**
	 * @return the data_recebimento
	 */
	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	/**
	 * @param dataRecebimento the dataRecebimento to set
	 */
	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	/**
	 * @return the lembretes
	 */
	public List<Lembrete> getLembretes() {
		return lembretes;
	}

	/**
	 * @param lembretes the lembretes to set
	 */
	public void setLembretes(List<Lembrete> lembretes) {
		this.lembretes = lembretes;
	}
	
	@Override
	public String toString() {
		return String.format("Receita: titulo - %s; descri��o - %s; valor - %s; data de Recebimento - %s", getTitulo(), getDescricao(), getValor(), getDataRecebimento());
	}
	
	
	
}
