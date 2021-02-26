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

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.UaaPersonalRowMapper;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.VinculacionRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.UaaPersonal;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.Vinculacion;

/**
 * @author ING. JAVIER CABRERA LASSO
 *
 */
public class VinculacionDB implements ConexionDB {

	private Logger imp;
	private String COLUMNAS = " vin.vin_codigo,vin.vin_nombre,vin.vin_horas_year,vin.vin_clase,vin.sippa_vincodigo,vin.vin_contratacion,vin.vin_externa ";
	private String SQL_SELECT = "select " + COLUMNAS + " from vinculacion vin with(nolock)  ";

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
		ResultSet resul = null;
		imp = Logger.getLogger(getClass().getName());
		LinkedList<Vinculacion> lista = new LinkedList<Vinculacion>();
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();
		try {
			Object param[] = (Object[]) obj;
			Vinculacion vinculacion = (Vinculacion) param[0];
			// Usuario admin= (Usuario) param[1];
			int opt=(int) param[2];
			sql.append(SQL_SELECT);
			if (vinculacion != null) {
				if (vinculacion.getClase() > 0) {
					sql.append("WHERE vin.vin_clase=? ");
					if(opt ==1) {
						sql.append("AND vin.vin_codigo in(46,47,48) ");
					}
				}
			}
			conn = consegura.conexionConsulta();
			// conn=consegura.getconn_admin(admin);
			imp.info("valida el usuario " + sql.toString()+" "+vinculacion);
			sentencia = conn.prepareStatement(sql.toString());
			if (vinculacion != null && vinculacion.getClase() > 0) {
				sentencia.setInt(1, vinculacion.getClase());
			}
			System.out.println("" + sql.toString());
			lista = (LinkedList<Vinculacion>) VinculacionRowMapper.mapRow(sentencia.executeQuery());
			consegura.cerrarconn(conn, resul, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString()+" " + sql.toString());
			consegura.cerrarconn(conn, resul, sentencia);

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

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#setObject(java.
	 * lang.Object)
	 */
	@Override
	public Object setObject(Object obj) {
		Object[] param = (Object[]) obj;
		int opt = (int) param[2];
		if (opt == 0) {
			insertObject(param[1]);
		}
		if (opt == 1) {
			updateObject(param[1]);
		}
		return null;
	}

	private Object updateObject(Object obj) {

		return null;
	}

	private Object insertObject(Object obj) {
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
