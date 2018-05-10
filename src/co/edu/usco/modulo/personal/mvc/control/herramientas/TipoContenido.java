/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.herramientas;

import java.io.UnsupportedEncodingException;

/**
 * @author Maritza
 *
 */
public class TipoContenido {
	
	
	public static String string(String str) throws UnsupportedEncodingException{
		String dato="";
		dato =str;
//			dato = new  String(str.getBytes("ISO-8859-1"), "UTF-8");
//			dato = new  String(str.getBytes("UTF-8"), "ISO-8859-1");
		return dato;
	}

	public static String nuevaString(String str) throws UnsupportedEncodingException{
		String dato="";
		dato =str;
			dato = new  String(str.getBytes("ISO-8859-1"), "UTF-8");
//			dato = new  String(str.getBytes("UTF-8"), "ISO-8859-1");
		return dato;
	}
}
