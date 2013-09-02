package managedbeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import business.LoginBean;
import business.ReceitaBS;
import dominio.Receita;

/**
 * Classe que interage com a tela de cadastro de receitas e com o gerenciamento de receitas do negocio
 *
 */
@ManagedBean
@RequestScoped
public class CadastroReceitaMB {
	@EJB
	ReceitaBS receitaBS;
	@EJB
	private LoginBean loginBS;

	private String titulo, descricao, dataRecebimento;
	private float valor; 
	
	private static SimpleDateFormat df = new SimpleDateFormat("MMM/yyyy");
	static String mesReferencia = null;
	
	/**
	 * recupea data de referência
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
	 * Salvar
	 * @throws Exception
	 */
	public String salvarReceita() throws Exception {
		Receita receita = new Receita();
		receita.setTitulo(titulo);
		receita.setDescricao(descricao);
		receita.setValor(valor);
		receita.setData_recebimento(converterData());
		receita.setData_criacao(getDataReferencia());
		receita.setUsuario(loginBS.getUsuarioLogado());

		try {
			receitaBS.salvarReceita(receita);
			return "CadastroOK";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Converter data
	 */
	private Date converterData() {
		SimpleDateFormat dateFormat = null;
		Date data = null;
		if (dataRecebimento.length() > 8){ 
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		}
		else{
			dateFormat = new SimpleDateFormat("dd/MM/yy");
		}
		try {
			data =  dateFormat.parse(getDataRecebimento());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return data;
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
	 * @return the loginBS
	 */
	public LoginBean getLoginBS() {
		return loginBS;
	}

	/**
	 * @param loginBS the loginBS to set
	 */
	public void setLoginBS(LoginBean loginBS) {
		this.loginBS = loginBS;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the dataRecebimento
	 */
	public String getDataRecebimento() {
		return dataRecebimento;
	}

	/**
	 * @param dataRecebimento the dataRecebimento to set
	 */
	public void setDataRecebimento(String dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	/**
	 * @return the valor
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}

	/**
	 * @return the df
	 */
	public static SimpleDateFormat getDf() {
		return df;
	}

	/**
	 * @param df the df to set
	 */
	public static void setDf(SimpleDateFormat df) {
		CadastroReceitaMB.df = df;
	}

	/**
	 * @return the mesReferencia
	 */
	public static String getMesReferencia() {
		return mesReferencia;
	}

	/**
	 * @param mesReferencia the mesReferencia to set
	 */
	public static void setMesReferencia(String mesReferencia) {
		CadastroReceitaMB.mesReferencia = mesReferencia;
	}

	
	/**
	 * voltar para tela principal
	 */
	public String voltar() {
		return "Voltar";
	}

	
	
	

}
