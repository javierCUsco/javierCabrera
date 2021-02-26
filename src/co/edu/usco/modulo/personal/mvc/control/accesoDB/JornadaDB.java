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

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.InstitucionEducativaRowMapper;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.JornadaRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.InstitucionEducativa;
import co.edu.usco.modulo.personal.mvc.modelo.Jornada;
import co.edu.usco.modulo.personal.mvc.modelo.PublicacionTipo;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class JornadaDB implements ConexionDB {
	private Logger imp ;
	private String COLUMNAS = "jor_codigo,	jor_nombre,	coalesce(sippa_jor_codigo,0) as sippa_jor_codigo ";
	private String SQL_SELECT = "SELECT " + COLUMNAS + " FROM jornada  with(nolock)";
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {

		 
		 Connection conn = null;
			PreparedStatement sentencia = null;
			imp = Logger.getLogger(getClass().getName());
			LinkedList<Jornada> lista = new LinkedList<Jornada>();
			Conexion consegura = new Conexion();
			try {
				StringBuffer sql = new StringBuffer();

				sql.append(SQL_SELECT);
				
				conn = consegura.conexionConsulta();
				imp.info("jornadas " + sql.toString());
				sentencia = conn.prepareStatement(sql.toString());
				
				lista = (LinkedList<Jornada>) JornadaRowMapper.mapRow(sentencia.executeQuery());

				consegura.cerrarconn(conn, null, sentencia);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				imp.error("" + e.toString());
				consegura.cerrarconn(conn, null, sentencia);

			}finally {
	        	consegura.cerrarconn(conn, null, sentencia);
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
