package managedbeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.DespesaBS;
import dominio.Despesa;

@ManagedBean
@SessionScoped
public class CadastroDespesaMB {
	@EJB
	private DespesaBS despesaBS;

	private String titulo, descricao, dataVencimento;
	private float valor; 
	
	public String pesquisarDespesasMes(){
		despesaBS.pesquisarDespesasMes(new Date());
		return "OK";
	}
	

	public String salvarDespesa() throws Exception {
		Despesa despesa = new Despesa();
		despesa.setTitulo(titulo);
		despesa.setDescricao(descricao);
		despesa.setValor(valor);
		despesa.setData_vencimento(converterData());
		

		try {
			despesaBS.salvarDespesa(despesa);
			return "CadastroOK";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

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

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
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

}
