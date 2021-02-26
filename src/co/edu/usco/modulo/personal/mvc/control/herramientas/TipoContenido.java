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
	public static String DecodeString(String str) {
		str = str.replace("á", "&aacute;");
        str = str.replace("é", "&eacute;");
        str = str.replace("®", "&reg;");
        str = str.replace("í", "&iacute;");
        str = str.replace("�", "&iacute;");
        str = str.replace("ó", "&oacute;");
        str = str.replace("ú", "&uacute;");
        str = str.replace("n~", "&ntilde;");
        str = str.replace("º", "&ordm;");
        str = str.replace("ª", "&ordf;");
        str = str.replace("Ã¡", "&aacute;");
        str = str.replace("ñ", "&ntilde;");
        str = str.replace("Ñ", "&Ntilde;");
        str = str.replace("Ã±", "&ntilde;");
        str = str.replace("n~", "&ntilde;");
        str = str.replace("Ú", "&Uacute;");
        str = str.replace("�", "&Acirc;");
        return str;
	}
}
