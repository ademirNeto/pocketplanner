package business;

import java.util.Calendar;
import java.util.Date;

/**
 * Classe de funções auxiliares
 *
 */
public class Utils {
	
	/**
	 * Função de resgatar o primeiro dia do mês
	 */
	public static Date getPrimeiroDiaMes(Date mes){
		Calendar comecoMes = Calendar.getInstance();
		comecoMes.setTime(mes);
		comecoMes.set(Calendar.DAY_OF_MONTH, 1);
		return comecoMes.getTime();
	}
	
	/**
	 * Função de resgatar o último dia do mês
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
