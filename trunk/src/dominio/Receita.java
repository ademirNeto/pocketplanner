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
	private Date data_recebimento;
	@ManyToMany
	private List <Lembrete> lembretes;
	
	public Receita () {
		super ();
	}

	/**
	 * @return the data_recebimento
	 */
	public Date getData_recebimento() {
		return data_recebimento;
	}

	/**
	 * @param data_recebimento the data_recebimento to set
	 */
	public void setData_recebimento(Date data_recebimento) {
		this.data_recebimento = data_recebimento;
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
	
	
	
}
