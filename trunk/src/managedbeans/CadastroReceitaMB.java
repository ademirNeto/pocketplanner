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
	
	public Date getDataReferencia(){
		Date data = null;
		try {
			data = df.parse(getMesReferencia());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}

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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}

	public String voltar() {
		return "Voltar";
	}

	public String getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(String dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public ReceitaBS getReceitaBS() {
		return receitaBS;
	}

	public void setReceitaBS(ReceitaBS receitaBS) {
		this.receitaBS = receitaBS;
	}

	public static SimpleDateFormat getDf() {
		return df;
	}

	public static void setDf(SimpleDateFormat df) {
		CadastroReceitaMB.df = df;
	}

	public String getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(String mesReferencia) {
		CadastroReceitaMB.mesReferencia = mesReferencia;
	}

	
	

}
