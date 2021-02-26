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

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.ModalidadRowMapper;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.NivelAcademicoRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Modalidad;
import co.edu.usco.modulo.personal.mvc.modelo.NivelAcademico;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class NivelAcademicoDB implements ConexionDB {
	private Logger imp ;
	private String COLUMNAS = "nia_codigo,nia_nombre,nia_orden,for_codigo,snies_codigo,sippa_nia_codigo,sippa_nivcodigo,nia_codigo_mp_hecaa,nia_codigo_ned_hecaa,nia_codigo_ne_hecaa,nia_cap_puntos,nia_cap_puntos_adicionales, nia_cap_maximo,	nia_cap_puntos_xano, nia_cap_descripcion, nia_estado, nia_cap_estado ";
	private String SQL_SELECT = "SELECT " + COLUMNAS +", "+NivelAcademicoTipoDB.COLUMNAS+ " FROM nivel_academico na with(nolock) "
			+ "INNER JOIN nivel_academico_tipo nat with(nolock) ON(nat.nat_codigo=na.nat_codigo) ";
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		 LinkedList<NivelAcademico> lista = new LinkedList<NivelAcademico>();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
//			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append(SQL_SELECT);
			
//			sql.append("select nia_codigo,nia_nombre,nia_orden,for_codigo,snies_codigo,sippa_nia_codigo,sippa_nivcodigo,nia_codigo_mp_hecaa,nia_codigo_ned_hecaa,nia_codigo_ne_hecaa,nat_codigo,nia_cap_puntos,nia_cap_puntos_adicionales   ");
//			sql.append("from nivel_academico  with(nolock)  ");
			sql.append("order by  nia_nombre asc  ");


			conn = consegura.conexionConsulta();
			conn.setAutoCommit(false);
			imp.info("valida el nivel_academico "+sql.toString());
			sentencia = conn.prepareStatement(sql.toString());
			
//			while(resul.next()){
//				NivelAcademico elemento= new NivelAcademico();
//				elemento.setCodigo(resul.getInt(1));
//				elemento.setNombre(resul.getString(2));
//				elemento.setOrden(resul.getInt(3));
//				elemento.setForCodigo(resul.getInt(4));
//				lista.add(elemento);
//				}
			lista = (LinkedList<NivelAcademico>)NivelAcademicoRowMapper.mapRow(sentencia.executeQuery());
			consegura.cerrarconn(conn, null, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, resul, sentencia);

	        }finally {
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
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#setObject(java.lang.Object)
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
