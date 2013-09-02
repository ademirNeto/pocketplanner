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

/**
 * Classe que se comunica com a tela principal da aplicação e com as classes de negócio
 *
 */
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
	
	/**
	 * Pesquisar receitas e despesas por mês
	 */
	public void pesquisarReceitasEDespesasMes(){
		
		despesasMes = despesaBS.pesquisarDespesasMes(getDataReferencia());
		setTotalDespesasMes(despesaBS.getTotalMes());

		receitasMes = receitaBS.pesquisarReceitasMes(getDataReferencia());
		setTotalReceitasMes(receitaBS.getTotalMes());
		
	}
	
	/**
	 * Recupera a data de referência
	 * @return data
	 */
	public Date getDataReferencia(){
		Date data = null;
		try {
			data = df.parse(getMesReferencia());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * Cadastra despesa
	 */
	public String cadastrarDespesa(){
		CadastroDespesaMB.mesReferencia = getMesReferencia();
		return "cadastrarDespesa";
	}

	/**
	 * Cadastra receita
	 */
	public String cadastrarReceita(){
		CadastroReceitaMB.mesReferencia = getMesReferencia();
		return "cadastrarReceita";
	}
	
	/**
	 * Ver mes anterior
	 */
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
	
	/**
	 * Ver mes posterior
	 */
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


	
	
	/**
	 * @return the despesaBS
	 */
	public DespesaBS getDespesaBS() {
		return despesaBS;
	}

	/**
	 * @param despesaBS the despesaBS to set
	 */
	public void setDespesaBS(DespesaBS despesaBS) {
		this.despesaBS = despesaBS;
	}

	/**
	 * @return the receitaBS
	 */
	public ReceitaBS getReceitaBS() {
		return receitaBS;
	}

	/**
	 * @param receitaBS the receitaBS to set
	 */
	public void setReceitaBS(ReceitaBS receitaBS) {
		this.receitaBS = receitaBS;
	}

	/**
	 * @return the despesasMes
	 */
	public List<Despesa> getDespesasMes() {
		return despesasMes;
	}

	/**
	 * @param despesasMes the despesasMes to set
	 */
	public void setDespesasMes(List<Despesa> despesasMes) {
		this.despesasMes = despesasMes;
	}

	/**
	 * @return the receitasMes
	 */
	public List<Receita> getReceitasMes() {
		return receitasMes;
	}

	/**
	 * @param receitasMes the receitasMes to set
	 */
	public void setReceitasMes(List<Receita> receitasMes) {
		this.receitasMes = receitasMes;
	}

	/**
	 * @return the totalDespesasMes
	 */
	public float getTotalDespesasMes() {
		return totalDespesasMes;
	}

	/**
	 * @param totalDespesasMes the totalDespesasMes to set
	 */
	public void setTotalDespesasMes(float totalDespesasMes) {
		this.totalDespesasMes = totalDespesasMes;
	}

	/**
	 * @return the totalReceitasMes
	 */
	public float getTotalReceitasMes() {
		return totalReceitasMes;
	}

	/**
	 * @param totalReceitasMes the totalReceitasMes to set
	 */
	public void setTotalReceitasMes(float totalReceitasMes) {
		this.totalReceitasMes = totalReceitasMes;
	}

	/**
	 * @return the df
	 */
	public SimpleDateFormat getDf() {
		return df;
	}

	/**
	 * @param df the df to set
	 */
	public void setDf(SimpleDateFormat df) {
		this.df = df;
	}

	/**
	 * @return the mesReferencia
	 */
	public String getMesReferencia() {
		return mesReferencia;
	}

	/**
	 * @param mesReferencia the mesReferencia to set
	 */
	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public float getSaldo(){
		return getTotalReceitasMes() - getTotalDespesasMes();
	}
	
	
	
	

}
