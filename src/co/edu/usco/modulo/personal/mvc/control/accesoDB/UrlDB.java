/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.publicacion_tipoOb;
import co.edu.usco.modulo.personal.mvc.modelo.Url;
/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class UrlDB implements conexion {
	private Logger imp ;
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		Statement sentencia=null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		 LinkedList<publicacion_tipoOb> lista = new LinkedList<publicacion_tipoOb>();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
//			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("select pt.put_codigo,pt.put_nombre,pt.sippa_tipcodigo  ");
			sql.append("from publicacion_tipo as pt  with(nolock)  ");
//			sql.append("where cert_estado=1  ");


			conn = consegura.conexion_segura();
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				publicacion_tipoOb elemento= new publicacion_tipoOb();
				elemento.setPut_codigo(resul.getInt(1));
				elemento.setPut_nombre(resul.getString(2));
				elemento.setSippa_tipcodigo(resul.getString(3));
				lista.add(elemento);
				}
			consegura.cerrarconn(conn, resul, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, resul, sentencia);

	        }
		return lista;
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
			conn = consegura.conexion_segura();
			DatabaseMetaData md= conn.getMetaData();
	    	dato.setUrl(md.getURL());
	    	dato.setBasedato(getDBName(dato.getUrl()));
	    		imp.info("---->"+dato.getUrl());
	    	consegura.cerrarconn(conn, resul, sentencia);
	    	
		}catch(Exception e){
			consegura.cerrarconn(conn, resul, sentencia);
			imp.error("Error validacion conexion: " + e);
		} 
		return dato;
	}

private String getDBName(String cadena) {
	StringTokenizer str=new StringTokenizer(cadena,"/,;");
	String DBN="";
	
	while (str.hasMoreElements()) {
		String dato=(String) str.nextElement();
		if(dato.substring(0, 8).equalsIgnoreCase("academia")){
			DBN=dato;
			break;
		}
		 System.out.println(DBN);
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
