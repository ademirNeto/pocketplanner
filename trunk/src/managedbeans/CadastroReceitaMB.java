package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dominio.Despesa;
import dominio.Receita;

@ManagedBean
@SessionScoped
public class CadastroReceitaMB {

	private String titulo, descricao, dataRecebimento;
	private float valor; 

	public String salvarReceita() throws Exception {
		Receita receita = new Receita();
		receita.setTitulo(titulo);
		receita.setDescricao(descricao);
		receita.setValor(valor);

		try {
			System.out.println(receita);
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
