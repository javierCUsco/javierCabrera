/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.novedadDocente.rowMapper.NovedadRowMapper;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.WebParametroRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.WebParametro;
import co.edu.usco.modulo.personal.mvc.modelo.novedadDocente.Novedad;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class WebParametroDB implements ConexionDB {
	private Logger imp ;

	
	private String SQL_SELECT="select wep_codigo, wep_nombre, wep_valor, wep_descripcion from web_parametro  ";
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		LinkedList<Novedad> lista=null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();

		try {
			Object param[] = (Object[]) obj;
			 WebParametro wParametro= (WebParametro) param[0];
			 Usuario admin= (Usuario) param[1];
			 
			sql = new StringBuffer();
			sql.append(SQL_SELECT);
			
//			sql.append("WHERE  wep_nombre = ? ");
			conn = consegura.getconn_admin(admin);
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			
			imp.info("select Novedades " + sql.toString());
//			rs=sentencia.executeQuery();
			conn.commit();
			lista  =(LinkedList<Novedad>) NovedadRowMapper.mapRow(sentencia.executeQuery());
			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, null, sentencia);

		}
		return lista;
	}

	@Override
	public Object getObject(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		LinkedList<Novedad> lista=null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();

		try {
		
			 
			 WebParametro webParametro= (WebParametro) obj;
			 
//			 imp.info("select webparametro " + webParametro);
			 
			sql = new StringBuffer();
			sql.append(SQL_SELECT);
			sql.append("WHERE  wep_nombre = ? ");
			conn = consegura.conexionLogin();
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			sentencia.setString(1, webParametro.getNombre());
//			imp.info("select webparametro " + sql.toString());
//			rs=sentencia.executeQuery();
			conn.commit();
			lista  =(LinkedList<Novedad>) WebParametroRowMapper.mapRow(sentencia.executeQuery());
			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString()+" select webparametro " + sql.toString());
			consegura.cerrarconn(conn, null, sentencia);

		}
		return lista.get(0);
	}
	
//	public Object getAll(Object obj) {
//		Connection conn = null;
//		Statement sentencia=null;
//		ResultSet resul=null;
//		imp =Logger.getLogger(getClass().getName());
//		 LinkedList<PublicacionTipo> lista = new LinkedList<PublicacionTipo>();
//			Conexion consegura = new Conexion();
//		 try {
//			 Object param[]=(Object[]) obj;
////			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
////			 usuarioOb admin= (usuarioOb) param[1];
//			StringBuffer sql = new StringBuffer();
//			sql.append("select pt.put_codigo,pt.put_nombre,pt.sippa_tipcodigo  ");
//			sql.append("from publicacion_tipo as pt  with(nolock)  ");
////			sql.append("where cert_estado=1  ");
//
//
//			conn = consegura.conexion_segura();
//			imp.info("valida el usuario "+sql.toString());
//			sentencia = conn.createStatement();
//			resul = sentencia.executeQuery(sql.toString());
//			while(resul.next()){
//				PublicacionTipo elemento= new PublicacionTipo();
//				elemento.setPut_codigo(resul.getInt(1));
//				elemento.setPut_nombre(resul.getString(2));
//				elemento.setSippa_tipcodigo(resul.getString(3));
//				lista.add(elemento);
//				}
//			consegura.cerrarconn(conn, resul, sentencia);
//		 }catch (Exception e) {
//			// TODO Auto-generated catch block
//			 imp.error(""+e.toString() );
//			 consegura.cerrarconn(conn, resul, sentencia);
//
//	        }
//		return lista;
//	}
//
//	/* (non-Javadoc)
//	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getObject(java.lang.Object)
//	 */
//	@Override
//	public Object getObject(Object obj) {
//		Connection conn = null;
//		Statement sentencia=null;
//		ResultSet resul=null;
//		imp =Logger.getLogger(getClass().getName());
//		 WebParametro elemento = null;
//			Conexion consegura = new Conexion();
//		 try {
////			 Object param[]=(Object[]) obj;
//			 WebParametro pu= (WebParametro) obj;
////			 usuarioOb admin= (usuarioOb) param[1];
//			StringBuffer sql = new StringBuffer();
//			sql.append("select wep_codigo,wep_nombre,wep_valor,wep_descripcion ");
//			sql.append("from web_parametro  with(nolock)  ");
//			sql.append("where wep_nombre='"+pu.getNombre()+"'  ");
//
//
//			conn = consegura.conexion_segura();
//			imp.info("valida el usuario "+sql.toString());
//			sentencia = conn.createStatement();
//			resul = sentencia.executeQuery(sql.toString());
//			while(resul.next()){
//				elemento= new WebParametro(resul.getInt(1),resul.getString(2),resul.getString(3),resul.getString(4));
//				
//				}
//			consegura.cerrarconn(conn, resul, sentencia);
//		 }catch (Exception e) {
//			// TODO Auto-generated catch block
//			 imp.error(""+e.toString() );
//			 consegura.cerrarconn(conn, resul, sentencia);
//
//	        }
//		return elemento;
//	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#insertObject(java.lang.Object)
	 */
	@Override
	public Object setObject(Object obj){
		Object [] param= (Object[]) obj;
		Object resultado=null;
		int opt= (int) param[2];
		if(opt==1){
//			resultado=  insertObject(obj);
		}
		if(opt==2){
			resultado=upDateParametroNovedadDocente(obj);
		}
		return resultado;
	}

	
	private Object upDateParametroNovedadDocente(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia=null;
		int resul=0;
		imp =Logger.getLogger(getClass().getName());
			Conexion consegura = new Conexion();
			StringBuffer sql = new StringBuffer();
		 try {
			 Object param[]=(Object[]) obj;
			 WebParametro webParametro= (WebParametro)param[0];
//			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
			 imp.info("actualiza el web parametro "+webParametro);
			 Usuario admin= (Usuario) param[1];
			 
			sql.append("UPDATE web_parametro  ");
			sql.append(" SET wep_valor = ? ");
			sql.append(" WHERE wep_nombre = ?  ");
			
			conn = consegura.getconn_admin(admin);
			imp.info("actualiza el web parametro "+sql.toString());
//			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			
			sentencia.setString(1,webParametro.getValor());
			sentencia.setString(2,webParametro.getNombre());
//			sentencia.setInt(3,webParametro.getCodigo());
//			conn.commit();
			resul = sentencia.executeUpdate();
			consegura.cerrarconn(conn, null, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() +""+sql.toString());
			 consegura.cerrarconn(conn, null, sentencia);

	        }
		return resul;
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
