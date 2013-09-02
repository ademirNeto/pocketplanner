package business;

import java.util.Calendar;
import java.util.Date;

/**
 * Classe de fun��es auxiliares
 *
 */
public final class Utils {
	
	private Utils(){}
	/**
	 * Fun��o de resgatar o primeiro dia do m�s
	 */
	public static Date getPrimeiroDiaMes(Date mes){
		Calendar comecoMes = Calendar.getInstance();
		comecoMes.setTime(mes);
		comecoMes.set(Calendar.DAY_OF_MONTH, 1);
		return comecoMes.getTime();
	}
	
	/**
	 * Fun��o de resgatar o �ltimo dia do m�s
	 */
	public static Date getUltimoDiaMes(Date mes){
		Calendar finalMes = Calendar.getInstance();
		finalMes.setTime(mes);
		finalMes.add(Calendar.MONTH, 1);
		finalMes.set(Calendar.DAY_OF_MONTH, 1);
		finalMes.add(Calendar.DATE, -1);
		return finalMes.getTime();
	}

}
