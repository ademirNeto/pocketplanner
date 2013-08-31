package managedbeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.ReceitaBS;
import dominio.Receita;

@ManagedBean
@SessionScoped
public class CadastroReceitaMB {
	@EJB
	ReceitaBS receitaBS;

	private String titulo, descricao, dataRecebimento;
	private float valor; 

	public String salvarReceita() throws Exception {
		Receita receita = new Receita();
		receita.setTitulo(titulo);
		receita.setDescricao(descricao);
		receita.setValor(valor);
		receita.setData_recebimento(converterData());

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
	
	

}
