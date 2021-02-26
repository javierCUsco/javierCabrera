/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.EstratoRowMapper;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.GrupoSanguineoRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.TipoId;
import co.edu.usco.modulo.personal.mvc.modelo.Estrato;
import co.edu.usco.modulo.personal.mvc.modelo.GrupoSanguineo;
import co.edu.usco.modulo.personal.mvc.modelo.PublicacionTipo;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class EstratoDB implements ConexionDB {
	
	public static String  COLUMNAS =" se.ses_codigo,	se.ses_descripcion,	se.snies_codigo,	se.snies_estado ";
	private String SQL_SELECT = "SELECT " + COLUMNAS + " FROM snies_estrato  se  with(nolock)";
	private Logger imp ;
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
//		Connection conn = null;
//		Statement sentencia=null;
//		ResultSet resul=null;
//		imp =Logger.getLogger(getClass().getName());
//		 LinkedList<Estrato> lista = new LinkedList<Estrato>();
//			Conexion consegura = new Conexion();
//		 try {
			 Connection conn = null;
				PreparedStatement sentencia = null;
				LinkedList<Estrato> lista = null;
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
					lista = (LinkedList<Estrato>)EstratoRowMapper.mapRow(sentencia.executeQuery());
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
