package managedbeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	private List<Receita> receitasMes;
	private float totalDespesasMes = 0;
	private float totalReceitasMes = 0;
	
	
	private SimpleDateFormat df = new SimpleDateFormat("MMM/yyyy");
	private String mesReferencia = df.format(new Date());
	
	public void pesquisarReceitasEDespesasMes(){
		
		despesasMes = despesaBS.pesquisarDespesasMes(getDataReferencia());
		setTotalDespesasMes(despesaBS.getTotalMes());

		receitasMes = receitaBS.pesquisarReceitasMes(getDataReferencia());
		setTotalReceitasMes(receitaBS.getTotalMes());
		
	}
	
	public Date getDataReferencia(){
		Date data = null;
		try {
			data = df.parse(getMesReferencia());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public String cadastrarDespesa(){
		CadastroDespesaMB.mesReferencia = getMesReferencia();
		return "cadastrarDespesa";
	}

	public String cadastrarReceita(){
		CadastroReceitaMB.mesReferencia = getMesReferencia();
		return "cadastrarReceita";
	}
	
	public String verMesAnterior(){
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(df.parse(mesReferencia));
			c.add(Calendar.MONTH, -1);
			setMesReferencia(df.format(c.getTime()));
			
			pesquisarReceitasEDespesasMes();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "OK";
	}
	
	public String verMesPosterior(){
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(df.parse(mesReferencia));
			c.add(Calendar.MONTH, 1);
			setMesReferencia(df.format(c.getTime()));
			pesquisarReceitasEDespesasMes();
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
		return receitasMes;
	}

	public void setReceitaMes(List<Receita> receitaMes) {
		this.receitasMes = receitaMes;
	}

	public String getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public List<Receita> getReceitasMes() {
		return receitasMes;
	}

	public void setReceitasMes(List<Receita> receitasMes) {
		this.receitasMes = receitasMes;
	}

	public float getTotalDespesasMes() {
		return totalDespesasMes;
	}

	public void setTotalDespesasMes(float totalDespesasMes) {
		this.totalDespesasMes = totalDespesasMes;
	}

	public float getTotalReceitasMes() {
		return totalReceitasMes;
	}

	public void setTotalReceitasMes(float totalReceitasMes) {
		this.totalReceitasMes = totalReceitasMes;
	}

	public SimpleDateFormat getDf() {
		return df;
	}

	public void setDf(SimpleDateFormat df) {
		this.df = df;
	}
	
	public float getSaldo(){
		return getTotalReceitasMes() - getTotalDespesasMes();
	}
	
	
	
	

}
