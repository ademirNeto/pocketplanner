package managedbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.DespesaBS;
import business.ReceitaBS;
import dominio.Despesa;
import dominio.Receita;

@SessionScoped
@ManagedBean
public class TelaPrincipalMB {
	@EJB
	private DespesaBS despesaBS;
	@EJB
	ReceitaBS receitaBS;
	
	private List<Despesa> despesasMes;
	private List<Receita> receitaMes;
	
	public String pesquisarDespesasMes(){
		despesasMes = despesaBS.pesquisarDespesasMes(new Date());
		return "OK";
	}
	
	public String pesquisarReceitasMes(){
		receitaMes = receitaBS.pesquisarReceitasMes(new Date());
		return "OK";
	}

	public DespesaBS getDespesaBS() {
		return despesaBS;
	}

	public void setDespesaBS(DespesaBS despesaBS) {
		this.despesaBS = despesaBS;
	}

	public ReceitaBS getReceitaBS() {
		return receitaBS;
	}

	public void setReceitaBS(ReceitaBS receitaBS) {
		this.receitaBS = receitaBS;
	}

	public List<Despesa> getDespesasMes() {
		return despesasMes;
	}

	public void setDespesasMes(List<Despesa> despesasMes) {
		this.despesasMes = despesasMes;
	}

	public List<Receita> getReceitaMes() {
		return receitaMes;
	}

	public void setReceitaMes(List<Receita> receitaMes) {
		this.receitaMes = receitaMes;
	}
	
	

}
