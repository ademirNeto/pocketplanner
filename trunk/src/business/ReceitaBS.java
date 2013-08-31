package business;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
