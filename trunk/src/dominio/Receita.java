package dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Receita extends Transacao {
	
	@Temporal(value=TemporalType.DATE)
	private Date data_recebimento;
	@ManyToMany
	private List <Lembrete> lembretes;
	
	public Receita () {
		super ();
	}
	
}
