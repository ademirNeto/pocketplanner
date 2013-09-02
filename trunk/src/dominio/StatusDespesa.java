package dominio;



/**
 * Enum que lista os status que as despesas podem assumir
 * @author Mariana
 *
 */
public enum StatusDespesa {
	
	PAGO (1),
	PENDENTE (0);
	
	private int status;
	
	/**
	 * Construtor
	 * @param status
	 */
	private StatusDespesa (int status) {
		this.status = status;
	}
	
	/**
	 * Retorna o valor inteiro correspondente ao status
	 * @return status
	 */
	public int toInt () {
		return status;
	}
	
	/**
	 * Retorna o valor StatusDespesa correspondente ao inteiro
	 * @param status
	 * @return StatusDespesa
	 */
	public static StatusDespesa valueOf (int status) {
		switch (status) {
			case 1: return PAGO;
			case 0: return PENDENTE;
			default: return null;
		}
	}
}
