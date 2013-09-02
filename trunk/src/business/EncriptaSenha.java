package business;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * Classe que criptografa as senhas
 *
 */
public class EncriptaSenha {     
	  
    /**
     * Função de criptografas senha
     * @param senha
     * @return senha encriptada
     */
    public static String encripta (String senha) {     
         try {     
              MessageDigest digest = MessageDigest.getInstance("MD5");      
              digest.update(senha.getBytes());      
              BASE64Encoder encoder = new BASE64Encoder ();      
              return encoder.encode (digest.digest ());      
         } catch (NoSuchAlgorithmException ns) {     
              ns.printStackTrace ();      
              return senha;      
         }  
         
    }
} 


