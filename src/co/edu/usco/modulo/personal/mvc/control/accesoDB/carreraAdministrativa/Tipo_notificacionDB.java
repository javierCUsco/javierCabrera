/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB.carreraAdministrativa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.Tipo_comisionOb;
import co.edu.usco.modulo.personal.mvc.modelo.Tipo_notificacionOb;
import co.edu.usco.modulo.personal.mvc.modelo.publicacion_tipoOb;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Tipo_notificacionDB implements conexion {
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
		 LinkedList<Tipo_notificacionOb> lista = new LinkedList<Tipo_notificacionOb>();
			Conexion consegura = new Conexion();
			 try {
				 Object param[]=(Object[]) obj;
//				 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
//				 usuarioOb admin= (usuarioOb) param[1];
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT tin_codigo,tin_nombre,tin_estado  ");
				sql.append("FROM cadtiva.tipo_notificacion as tn  with(nolock)  ");
//				sql.append("where cert_estado=1  ");


				conn = consegura.conexion_segura();
				imp.info("valida el usuario "+sql.toString());
				sentencia = conn.createStatement();
				resul = sentencia.executeQuery(sql.toString());
				while(resul.next()){
					lista.add(new Tipo_notificacionOb(resul.getInt(1),resul.getString(2),resul.getInt(3)));
					
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
		// TODO Auto-generated method stub
		return null;
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
