package dominio;


/**
 * Classe de status das despesas
 * @author Mariana
 *
 */

public enum StatusDespesa {
	
	PAGO (1),
	PENDENTE (0);
	
	private int status;
	
	private StatusDespesa (int status) {
		this.status = status;
	}
	
	public int toInt () {
		return status;
	}
	
	public static StatusDespesa valueOf (int status) {
		switch (status) {
			case 1: return PAGO;
			case 0: return PENDENTE;
			default: return null;
		}
	}
}
