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

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.GeneroRowMapper;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.GrupoSanguineoRowMapper;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.PersonaRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Genero;
import co.edu.usco.modulo.personal.mvc.modelo.GrupoSanguineo;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class GrupoSanguineoDB implements ConexionDB {
	private Logger imp ;
	/**
	 * 
	 */
	public static String  COLUMNAS =" gs.grs_codigo, gs.grs_nombre, COALESCE(gs.sippa_grs_codigo,0) sippa_grs_codigo ";
	private String SQL_SELECT = "SELECT " + COLUMNAS + " FROM grupo_sanguineo as gs  with(nolock)";
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		LinkedList<GrupoSanguineo> lista = null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();		
		try {
			sql = new StringBuffer();
			sql.append(SQL_SELECT);
			
			conn = consegura.conexionConsulta();
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());

			imp.info("select getAll " + sql.toString() + " " );
			// rs=sentencia.executeQuery();
			conn.commit();
			lista = (LinkedList<GrupoSanguineo>)GrupoSanguineoRowMapper.mapRow(sentencia.executeQuery());
			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString());
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
