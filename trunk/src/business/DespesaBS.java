package business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Despesa;

/**
 * Classe cadastro e de gerenciamento de despesas
 *
 */
@Stateless
public class DespesaBS {

	@PersistenceContext(unitName = "pocketplanner")
	private EntityManager manager;
	
	@EJB
	private LoginBean loginBS;
	
	
	private float totalMes = 0;
	
	public DespesaBS() {
	}
	
	/**
	 * Função para cadastrar despesas
	 * @param despesa
	 */
	public void salvarDespesa(Despesa despesa){
		if (despesa.getRepeticao() > 0){
			Calendar c = Calendar.getInstance();
			do {
				manager.persist(despesa);
				Date data = despesa.getData_criacao();
				c.setTime(data);
				c.add(Calendar.MONTH, 1);
				despesa = despesa.clone(despesa);
				despesa.setData_criacao(c.getTime());
				despesa.setRepeticao(despesa.getRepeticao() - 1);
			} while (despesa.getRepeticao() >= 0);
			
		}else{
			manager.persist(despesa);
		}
	}
	
	
	/**
	 * Função para pesquisar despesas por mês
	 * @param mes
	 * @return
	 */
	public List<Despesa> pesquisarDespesasMes(Date mes){
		setTotalMes(0);
		ArrayList<Despesa> despesasMes = new ArrayList<Despesa> ();
		
		Query query = manager.createQuery("select d from Despesa d where d.data_criacao >=:comecoMes and d.data_criacao <= :finalMes and d.usuario = :usuario", Despesa.class);
		
		query.setParameter("comecoMes", Utils.getPrimeiroDiaMes(mes));
		query.setParameter("finalMes", Utils.getUltimoDiaMes(mes));
		query.setParameter("usuario", loginBS.getUsuarioLogado());
		
		despesasMes = (ArrayList<Despesa>) query.getResultList();
		for (Despesa despesa : despesasMes) {
			setTotalMes(getTotalMes() + despesa.getValor());
		}
		
		return despesasMes;
	}

	/**
	 * Função para recuperar o total de despesas do mês
	 * @return totalMes
	 */
	public float getTotalMes() {
		return totalMes;
	}

	/**
	 * Alterar o total de despesas do mês
	 * @param totalMes
	 */
	public void setTotalMes(float totalMes) {
		this.totalMes = totalMes;
	}

	
}
