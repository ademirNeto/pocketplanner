package managedbeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import business.DespesaBS;
import business.LoginBean;
import dominio.Despesa;

/**
 * Classe que interage com a tela de cadastro de despesas e com o genenciamento de despesas na camada de negócios
 *
 */
@ManagedBean
@RequestScoped
public class CadastroDespesaMB {
	@EJB
	private DespesaBS despesaBS;
	
	@EJB
	private LoginBean loginBS;

	private String titulo, descricao, dataVencimento;
	private float valor; 
	private int repetir;
	
	private static SimpleDateFormat df = new SimpleDateFormat("MMM/yyyy");
	static String mesReferencia = null;
	
	/**
	 * Recuperar data de referência
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
	 * Voltar para tela principal
	 */
	public String voltar() {
		return "Voltar";
	}

	/**
	 * Salvar
	 * @throws Exception
	 */
	public String salvarDespesa() throws Exception {
		Despesa despesa = new Despesa();
		despesa.setTitulo(titulo);
		despesa.setDescricao(descricao);
		despesa.setValor(valor);
		despesa.setData_vencimento(converterData());
		despesa.setData_criacao(getDataReferencia());
		despesa.setUsuario(loginBS.getUsuarioLogado());
		despesa.setRepeticao(getRepetir());

		try {
			despesaBS.salvarDespesa(despesa);
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
		if (dataVencimento.length() > 8){ 
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		}
		else{
			dateFormat = new SimpleDateFormat("dd/MM/yy");
		}
		try {
			data =  dateFormat.parse(getDataVencimento());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return data;
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
	 * @return the dataVencimento
	 */
	public String getDataVencimento() {
		return dataVencimento;
	}

	/**
	 * @param dataVencimento the dataVencimento to set
	 */
	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
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
	 * @return the repetir
	 */
	public int getRepetir() {
		return repetir;
	}

	/**
	 * @param repetir the repetir to set
	 */
	public void setRepetir(int repetir) {
		this.repetir = repetir;
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
		CadastroDespesaMB.df = df;
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
		CadastroDespesaMB.mesReferencia = mesReferencia;
	}


	
	

}
