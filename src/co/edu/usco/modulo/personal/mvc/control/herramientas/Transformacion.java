/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.herramientas;

import java.io.UnsupportedEncodingException;


/**
 * @author ING_JAVIER
 *
 */
public class Transformacion {

	  //private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
	  /**
	   * 
	   * @param cadena
	   * @param opc
	   * @return
	   */
	    public String  transHexa(String cadena, int opc){
	    	String retorno="";
	        try{
	        	if(opc==1){
	        		retorno = HexStringConverter.getHexStringConverterInstance().stringToHex(cadena);	
	        	}
	        	if(opc==2){
	        		retorno= HexStringConverter.getHexStringConverterInstance().HexTostring(cadena);
	        	}
	                
	        }catch (UnsupportedEncodingException ex){
	           
	        }
	        return retorno;
	    }
	    
	    

}
