/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.nivel_academicoOb;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class NivelAcademicoDB implements conexion {
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
		 LinkedList<nivel_academicoOb> lista = new LinkedList<nivel_academicoOb>();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
//			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("select nia_codigo,nia_nombre,nia_orden,for_codigo,snies_codigo,sippa_nia_codigo,sippa_nivcodigo,nia_codigo_mp_hecaa,nia_codigo_ned_hecaa,nia_codigo_ne_hecaa,nat_codigo,nia_cap_puntos,nia_cap_puntos_adicionales   ");
			sql.append("from nivel_academico  with(nolock)  ");
			sql.append("order by  nia_nombre asc  ");


			conn = consegura.conexion_segura();
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				nivel_academicoOb elemento= new nivel_academicoOb();
				elemento.setNia_codigo(resul.getInt(1));
				elemento.setNia_nombre(resul.getString(2));
				elemento.setNia_orden(resul.getInt(3));
				elemento.setFor_codigo(resul.getInt(4));
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
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#setObject(java.lang.Object)
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
