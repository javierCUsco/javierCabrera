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

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.DedicacionRowMapper;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.HistoriaLaboralTipoRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Dedicacion;
import co.edu.usco.modulo.personal.mvc.modelo.HistoriaLaboralTipo;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author ING. JAVIER CABRERA LASSO
 *
 */
public class DedicacionDB implements ConexionDB{
	private String COLUMNAS=" de.ded_codigo, de.ded_nombre, de.ded_orden_snies, de.sippa_dedcodigo, de.ded_codigo_hecaa ";
	private String SQL_SELECT="select "+COLUMNAS+" from dedicacion de with(nolock)  ";
	private Logger imp ;
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		LinkedList<Dedicacion> lista=null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();
		imp.info("select getAll  " );
		try {
			Object param[] = (Object[]) obj;
//			 Usuario admin= (Usuario) param[1];	 
			sql = new StringBuffer();
			sql.append(SQL_SELECT);
			
//			conn = consegura.getconn_admin (admin);
			conn=consegura.conexionConsulta();
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
//			
			imp.info("select getAll " + sql.toString());
//			rs=sentencia.executeQuery();
			conn.commit();
			lista  =(LinkedList<Dedicacion>) DedicacionRowMapper.mapRow(sentencia.executeQuery());
			
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
		
		return null;
	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#setObject(java.lang.Object)
	 */
	@Override
	public Object setObject(Object obj) {
		Object [] param= (Object[]) obj;
		int opt= (int) param[2];
		if(opt==0){
			insertObject(param[1]);
		}
		if(opt==1){
			updateObject(param[1]);
		}
		return null;
	}
	private Object updateObject(Object obj) {
		
		return null;
	}

	private Object insertObject(Object obj){
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
