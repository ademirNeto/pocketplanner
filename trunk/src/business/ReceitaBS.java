package business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Receita;

@Stateless
public class ReceitaBS {

	@PersistenceContext(unitName = "pocketplanner")
	private EntityManager manager;
	
	private float totalMes = 0;
	
	public ReceitaBS() {
	}
	
	public void salvarReceita(Receita receita){
		manager.persist(receita);
	}
	
	public List<Receita> pesquisarReceitasMes(Date mes){
		setTotalMes(0);
		ArrayList<Receita> receitasMes = new ArrayList<Receita> ();
		
		Query query = manager.createQuery("select r from Receita r where r.data_criacao >=:comecoMes and r.data_criacao <= :finalMes", Receita.class);
		
		query.setParameter("comecoMes", Utils.getPrimeiroDiaMes(mes));
		query.setParameter("finalMes", Utils.getUltimoDiaMes(mes));
		
		receitasMes= (ArrayList<Receita>) query.getResultList();
		for (Receita receita: receitasMes) {
			setTotalMes(getTotalMes() + receita.getValor());
		}
		
		return receitasMes;
	}

	public float getTotalMes() {
		return totalMes;
	}

	public void setTotalMes(float totalMes) {
		this.totalMes = totalMes;
	}
	
	
}
