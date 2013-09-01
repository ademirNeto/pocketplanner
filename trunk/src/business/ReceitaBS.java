package business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Despesa;
import dominio.Receita;

@Stateless
public class ReceitaBS {

	@PersistenceContext(unitName = "pocketplanner")
	private EntityManager manager;
	
	public ReceitaBS() {
	}
	
	public void salvarReceita(Receita receita){
		receita.setData_criacao(new Date());
		
		manager.persist(receita);
	}
	
	public List<Receita> pesquisarReceitasMes(Date mes){
		ArrayList<Receita> receitasMes = new ArrayList<Receita> ();
		
		Query query = manager.createQuery("select r from Receita r", Receita.class);
		receitasMes= (ArrayList<Receita>) query.getResultList();
		for (Receita receita: receitasMes) {
			System.out.println(receita);
		}
		
		return receitasMes;
	}
}
