/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.EstadoCivilRowMapper;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.ModalidadRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.EstadoCivil;
import co.edu.usco.modulo.personal.mvc.modelo.Modalidad;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class ModalidadDB implements ConexionDB {
	private Logger imp ;
	private String COLUMNAS = "mod_codigo,mod_nombre, coalesce(sippa_mod_codigo,'') as sippa_mod_codigo,hecaa_codigo ";
	private String SQL_SELECT = "SELECT " + COLUMNAS + " FROM modalidad  with(nolock)";
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		 LinkedList<Modalidad> lista = new LinkedList<Modalidad>();
			Conexion consegura = new Conexion();
		 try {
			
			 Object param[]=(Object[]) obj;
			StringBuffer sql = new StringBuffer();
			sql.append(SQL_SELECT);

			conn = consegura.conexionConsulta();
			conn.setAutoCommit(false);
			imp.info("MODALIDAD "+sql.toString());
			sentencia = conn.prepareStatement(sql.toString());
			conn.commit();
			lista = (LinkedList<Modalidad>)ModalidadRowMapper.mapRow(sentencia.executeQuery());
			consegura.cerrarconn(conn, null, sentencia);
		 }catch (Exception e) {
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
