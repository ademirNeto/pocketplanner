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
import dominio.Usuario;

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
	
	public List<Despesa> pesquisarDespesasMes(Date mes){
		ArrayList<Despesa> despesasMes = new ArrayList<Despesa> ();
		
		Query query = manager.createQuery("select d from Despesa d", Despesa.class);
		despesasMes = (ArrayList<Despesa>) query.getResultList();
		for (Despesa despesa : despesasMes) {
			System.out.println(despesa);
		}
		
		return despesasMes;
	}
}
