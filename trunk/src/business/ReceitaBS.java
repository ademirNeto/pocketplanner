package business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Receita;

/**
 * Classe de cadastro e gerenciamento de receitas
 *
 */
@Stateless
public class ReceitaBS {

	@PersistenceContext(unitName = "pocketplanner")
	private EntityManager manager;
	
	private float totalMes = 0;
	
	public ReceitaBS() {
	}
	
	/**
	 * Função de salvar receitas
	 * @param receita
	 */
	public void salvarReceita(Receita receita){
		manager.persist(receita);
	}
	
	
	/**
	 * Função de pesquisar receitas por mês
	 * @param mes
	 * @return
	 */
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

	/**
	 * Função de recuperar o valor total de receitas no mês
	 * @return totalMes
	 */
	public float getTotalMes() {
		return totalMes;
	}

	/**
	 * Função de setar o total de receitas no mês
	 * @param totalMes
	 */
	public void setTotalMes(float totalMes) {
		this.totalMes = totalMes;
	}
	
	
}
