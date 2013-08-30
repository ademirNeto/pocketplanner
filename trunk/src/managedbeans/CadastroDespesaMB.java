package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dominio.Despesa;

@ManagedBean
@SessionScoped
public class CadastroDespesaMB {

	private String titulo, descricao, dataVencimento;
	private float valor; 

	public String salvarDespesa() throws Exception {
		Despesa despesa = new Despesa();
		despesa.setTitulo(titulo);
		despesa.setDescricao(descricao);
		despesa.setValor(valor);

		try {
			System.out.println(despesa);
			return "CadastroOK";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
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
