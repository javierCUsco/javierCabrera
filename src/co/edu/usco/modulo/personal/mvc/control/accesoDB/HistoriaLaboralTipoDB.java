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

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.HistoriaLaboralTipoRowMapper;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.PersonaHistoriaAcademicaRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.HistoriaLaboralTipo;
import co.edu.usco.modulo.personal.mvc.modelo.PersonaHistoriaAcademica;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class HistoriaLaboralTipoDB implements ConexionDB {

	private Logger imp ;
	private String COLUMNAS=" htl.hlt_codigo, htl.hlt_nombre, htl.hlt_cap_estado ";
	private String SQL_SELECT="select "+COLUMNAS+" from historia_laboral_tipo htl with(nolock)  ";
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		LinkedList<HistoriaLaboralTipo> lista=null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();
//		imp.info("select getAll  " );
		try {
			Object param[] = (Object[]) obj;
//			 Usuario admin= (Usuario) param[1];	 
			sql = new StringBuffer();
			sql.append(SQL_SELECT);
//			
//			conn = consegura.getconn_admin (admin);
			conn=consegura.conexionConsulta();
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			System.out.println("error "+" "+sql.toString());
//			sentencia.setInt(1, personaHistoriaAcademica.getPersona().getCodigo());
//			sentencia.setInt(2, personaHistoriaAcademica.getCodigo());
//			
//			imp.info("select getAll " + sql.toString());
//			rs=sentencia.executeQuery();
			conn.commit();
			lista  =(LinkedList<HistoriaLaboralTipo>) HistoriaLaboralTipoRowMapper.mapRow(sentencia.executeQuery());
			
			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			imp.error("" + e.toString());
			System.out.println("error "+e+""+sql.toString());
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
