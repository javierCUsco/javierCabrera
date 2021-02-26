/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Url;
/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class UrlDB implements ConexionDB {
	private Logger imp ;
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
	
	
		return null;
	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getObject(java.lang.Object)
	 */
	@Override
	public Object getObject(Object obj) {
		Conexion consegura = new Conexion();
		Url dato=null;
		Statement sentencia = null;
		ResultSet resul = null;
		imp =Logger.getLogger(getClass().getName());
		Connection conn =null;
	
		try{
			dato=new Url();
			conn = consegura.conexionConsulta();
			DatabaseMetaData md= conn.getMetaData();
			 String url= md.getURL();
			 imp.info("url: " );
			String[] result = url.split(";");
	    	dato.setUrl(String.valueOf(result[0]));
	    	dato.setBasedato(getDBName(url));
	    	consegura.cerrarconn(conn, resul, sentencia);
//	    	imp.info("url: " + dato);
		}catch(Exception e){
			consegura.cerrarconn(conn, resul, sentencia);
			imp.error("Error validacion conexion: " + e);
		} finally {
        	consegura.cerrarconn(conn, resul, sentencia);
        }
		return dato;
	}

private String getDBName(String cadena) {

	String DBN="";
	
	String[] result = cadena.split("=");
    for (int x=0; x<result.length; x++) {
 	
    	if(result[x].substring(0, 8).equalsIgnoreCase("academia")){
    		String[] result2 = String.valueOf(result[x]).split(";");
			DBN=result2[0];
			break;
		}
    }

	return DBN;
}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#insertObject(java.lang.Object)
	 */
	@Override
	public Object setObject(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#esObject(java.lang.Object)
	 */
	@Override
	public boolean esObject(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
