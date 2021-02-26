/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.EpsRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Eps;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class EpsDB implements ConexionDB {
	private Logger imp;//,eps_estado
	private String COLUMNAS = "eps_codigo,eps_nombre,eps_prestador ";
	private String SQL_SELECT = "SELECT " + COLUMNAS + " FROM eps  with(nolock)";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang
	 * .Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		// ResultSet resul=null;
		imp = Logger.getLogger(getClass().getName());
		LinkedList<Eps> lista = new LinkedList<Eps>();
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();
		try {
			Object param[] = (Object[]) obj;
			sql.append(SQL_SELECT);
			conn = consegura.conexionConsulta();
			imp.info("getAll " + sql.toString());
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			// while(resul.next()){
			// Eps elemento= new Eps();
			// elemento.setCodigo(resul.getInt(1));
			// elemento.setNombre(resul.getString(2));
			//// elemento.setTii_nombre_corto(resul.getString(3));
			// lista.add(elemento);
			// }
			lista = (LinkedList<Eps>) EpsRowMapper.mapRow(sentencia.executeQuery());
			conn.commit();
			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			imp.error("getAll " + e.getMessage() + "" + sql.toString());
			consegura.cerrarconn(conn, null, sentencia);

		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getObject(java.
	 * lang.Object)
	 */
	@Override
	public Object getObject(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#insertObject(
	 * java.lang.Object)
	 */
	@Override
	public Object setObject(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#esObject(java.
	 * lang.Object)
	 */
	@Override
	public boolean esObject(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
