package exception;

/**
 * Class Runtime Exception
 */

public class PocketPlannerRuntimeException extends RuntimeException {

	public class PockerPlannerRuntimeException extends Exception {  
		  
	    /** 
	     * Construtor default 
	     */  
	    public PockerPlannerRuntimeException() {  
	    }  
	  
	    /** 
	     * Construtor 
	     * @param message 
	     */  
	    public PockerPlannerRuntimeException(String message) {  
	        super(message);  
	    }  
	  
	    /** 
	     * Construtor 
	     * @param cause 
	     */  
	    public PockerPlannerRuntimeException(Throwable cause) {  
	        super(cause);  
	    }  
	  
	    /** 
	     * Construtor 
	     * @param message 
	     * @param cause 
	     */  
	    public PockerPlannerRuntimeException(String message, Throwable cause) {  
	        super(message, cause);  
	    }  
	  
	}  
}
