/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.TipoIdRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.TipoId;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class TipoIdDB implements ConexionDB {
	private Logger imp;
	private String COLUMNAS = "tii_codigo,tii_nombre,tii_nombre_corto,snies_codigo,spadies_codigo,observatorio_laboral,linix_codigo,tii_estado,tii_num_caracteres,tii_codigo_hecaa ";
	private String SQL_SELECT = "SELECT " + COLUMNAS + " FROM tipo_id  with(nolock)";

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
		LinkedList<TipoId> lista = null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();

		
		
		try {
//			Object param[] = (Object[]) obj;
//			Novedad novedad = (Novedad) param[0];
//			Usuario admin = (Usuario) param[1];
//			int opt = Integer.parseInt(String.valueOf(param[2]));
//			System.out.println("-------->    "+opt);
			
			sql = new StringBuffer();
			sql.append(SQL_SELECT);
			
			conn = consegura.conexionConsulta();
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());

			imp.info("select getAll " + sql.toString() + " " );
			// rs=sentencia.executeQuery();
			conn.commit();
			lista = (LinkedList<TipoId>)TipoIdRowMapper.mapRow(sentencia.executeQuery());
			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString());
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
