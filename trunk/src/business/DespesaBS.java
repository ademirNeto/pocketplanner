package business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Despesa;

@Stateless
public class DespesaBS {

	@PersistenceContext(unitName = "pocketplanner")
	private EntityManager manager;
	
	private float totalMes = 0;
	
	public DespesaBS() {
	}
	
	public void salvarDespesa(Despesa despesa){
			manager.persist(despesa);
	}
	
	public List<Despesa> pesquisarDespesasMes(Date mes){
		setTotalMes(0);
		ArrayList<Despesa> despesasMes = new ArrayList<Despesa> ();
		
		Query query = manager.createQuery("select d from Despesa d where d.data_criacao >=:comecoMes and d.data_criacao <= :finalMes", Despesa.class);
		
		query.setParameter("comecoMes", Utils.getPrimeiroDiaMes(mes));
		query.setParameter("finalMes", Utils.getUltimoDiaMes(mes));
		
		despesasMes = (ArrayList<Despesa>) query.getResultList();
		for (Despesa despesa : despesasMes) {
			setTotalMes(getTotalMes() + despesa.getValor());
		}
		
		return despesasMes;
	}

	public float getTotalMes() {
		return totalMes;
	}

	public void setTotalMes(float totalMes) {
		this.totalMes = totalMes;
	}

	
}
