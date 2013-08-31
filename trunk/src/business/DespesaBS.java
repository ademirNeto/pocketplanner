package business;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dominio.Despesa;

@Stateless
public class DespesaBS {

	@PersistenceContext(unitName = "pocketplanner")
	private EntityManager manager;
	
	@EJB
	private LoginBean loginBean;
	
	public DespesaBS() {
	}
	
	public void salvarDespesa(Despesa despesa){
		despesa.setData_criacao(new Date());
		despesa.setUsuario(loginBean.getUsuarioLogado());
		
		manager.persist(despesa);
	}
}
