package dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Superclasse Transacao
 * @author Mariana
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) 
public abstract class Transacao {
	
	@Id
	private Integer id;
	private String titulo;
	private float valor;
	private String descricao;
	private int repeticao;
	@Temporal(value=TemporalType.DATE)
	private Date data_criacao;
	@ManyToOne
	private Usuario usuario;
	
	public Transacao () {
		
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the repeticao
	 */
	public int getRepeticao() {
		return repeticao;
	}

	/**
	 * @param repeticao the repeticao to set
	 */
	public void setRepeticao(int repeticao) {
		this.repeticao = repeticao;
	}

	/**
	 * @return the data_criacao
	 */
	public Date getData_criacao() {
		return data_criacao;
	}

	/**
	 * @param data_criacao the data_criacao to set
	 */
	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	

}
