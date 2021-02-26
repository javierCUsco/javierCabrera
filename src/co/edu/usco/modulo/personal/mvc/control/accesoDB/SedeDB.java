/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.SedeRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Sede;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.novedadDocente.Novedad;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class SedeDB implements ConexionDB {
	private Logger imp;
	private String SQL_SELECT="SELECT s.sed_codigo,s.sed_nombre,s.mun_codigo,s.sippa_sed_codigo,s.sed_estado,s.SedNombre_corto,\r\n" + 
			"muns.mun_codigo,muns.mun_id,muns.mun_nombre,muns.dep_codigo,muns.sippa_mun_codigo,muns.SNIES_codigo,muns.dane_codigo,\r\n" + 
			"deps.dep_codigo,deps.dep_acronimo,deps.dep_nombre,deps.pai_codigo,deps.sippa_dep_codigo,deps.dane_codigo,\r\n" + 
			"paiss.pai_codigo,paiss.pai_acronimo,paiss.pai_nombre,paiss.sippa_pai_codigo,paiss.dane_codigo,paiss.pai_codigo_hecaa\r\n" + 
			"FROM sede s with(nolock)\r\n" + 
			"left join municipio muns with(nolock) on (muns.mun_codigo=s.mun_codigo)\r\n" + 
			"left join departamento deps with(nolock) on (deps.dep_codigo=muns.dep_codigo)\r\n" + 
			"left join pais paiss with(nolock) on(paiss.pai_codigo=deps.pai_codigo) ";
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		LinkedList<Sede> lista=null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();

		try {
			Object param[] = (Object[]) obj;
			 Sede sede= (Sede) param[0];
//			 Usuario admin= (Usuario) param[1];
			
			sql = new StringBuffer();
			sql.append(SQL_SELECT);
			if(sede.getEstado()) {
				sql.append("WHERE s.sed_estado=?");
			}
			
//			conn = consegura.getconn_admin(admin);
			conn = consegura.conexionConsulta();
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			int estado=0;
			if(sede.getEstado()) {
				estado=1;
				sentencia.setInt(1, estado);
			}
			
			
			imp.info("select cargo " + sql.toString()+" ");
//			rs=sentencia.executeQuery();
			conn.commit();
			lista  =(LinkedList<Sede>) SedeRowMapper.mapRow(sentencia.executeQuery());
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
