/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.UaaRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Uaa;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class UaaDB implements ConexionDB {
	private Logger imp ;
	private String SQL_SELECT="SELECT u.uaa_codigo\r\n" + 
			",u.uat_codigo,ut.uat_nombre,u.uaa_nombre,u.uaa_dependencia,u.uaa_nombre_corto,u.uaa_nombre_impresion,u.uaa_email,u.uaa_email_pqr\r\n" + 
			",u.uaa_pagina,u.uaa_jefe,u.mun_codigo,u.uaa_telefono,u.uaa_fax,u.uaa_direccion,u.sippa_uaa_codigo,u.sed_codigo,u.uaa_centro_costos\r\n" + 
			",u.uaa_acronimo,u.uaa_estado,u.uaa_ventanilla,u.uaa_codigo_retencion,u.uaa_propietario_codigo,\r\n" + 
			"ut.uat_codigo,ut.uat_nombre,ut.uat_tmp,ut.uat_codigo_hecaa,\r\n" + 
			"s.sed_codigo,s.sed_nombre,s.mun_codigo,s.sippa_sed_codigo,s.sed_estado,s.SedNombre_corto,\r\n" + 
			"muns.mun_codigo AS mnac_codigo, muns.mun_nombre AS mnac_nombre, deps.dep_codigo AS dnac_codigo, deps.dep_nombre AS dnac_nombre, paiss.pai_codigo As pnac_codigo, paiss.pai_nombre AS pnac_nombre \r\n" + 
			"FROM dbo.uaa u with(nolock) \r\n" + 
			"INNER JOIN uaa_tipo ut ON(ut.uat_codigo=u.uat_codigo)\r\n" + 
			"LEFT JOIN sede s with(nolock)  ON(s.sed_codigo=u.sed_codigo)\r\n" + 
			"LEFT JOIN municipio muns with(nolock) ON (muns.mun_codigo=s.mun_codigo)\r\n" + 
			"LEFT JOIN departamento deps with(nolock) ON (deps.dep_codigo=muns.dep_codigo)\r\n" + 
			"LEFT JOIN pais paiss with(nolock) ON(paiss.pai_codigo=deps.pai_codigo)\r\n" + 
			"	";
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia=null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		 LinkedList<Uaa> lista = new LinkedList<Uaa>();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 Uaa uaa= (Uaa) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append(SQL_SELECT);
			sql.append("WHERE u.uaa_estado=?  ");
			sql.append("AND u.uaa_nombre like ?  ");
			if(uaa.getUaaTipo().getCodigo()!=-1 && uaa.getUaaTipo().getCodigo()!=0) {
				sql.append("AND ut.uat_codigo in ("+uaa.getUaaTipo().getCodigo()+")  ");
			}else if(uaa.getUaaTipo().getCodigo()==-1) {
				sql.append("AND ut.uat_codigo in (2)  ");
//				sql.append("AND ut.uat_codigo in (2,3)  ");
			}
			
			if(uaa.getDependencia()>0) {
				sql.append("AND u.uaa_dependencia = ?  ");
			}
//			System.out.println("error "+sql.toString());
			imp.info("uaa "+sql.toString());
			conn = consegura.conexionConsulta();
			sentencia = conn.prepareStatement(sql.toString());
			conn.setAutoCommit(false);
//			sentencia = conn.prepareStatement(sql.toString());
			sentencia.setInt(1, 1);
			sentencia.setString(2, "%" +uaa.getNombre()+ "%");
			if(uaa.getDependencia()>0) {
				sentencia.setInt(3, uaa.getDependencia());
			}
			conn.commit();

			lista  =(LinkedList<Uaa>) UaaRowMapper.mapRow(sentencia.executeQuery());

			consegura.cerrarconn(conn, resul, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, resul, sentencia);

	        }
		return lista;
	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getObject(java.lang.Object)
	 */
	@Override
	public Object getObject(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia=null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		 LinkedList<Uaa> lista = new LinkedList<Uaa>();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 Uaa uaa= (Uaa) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append(SQL_SELECT);
			sql.append("WHERE u.uaa_estado=?  ");
			sql.append("AND  u.uaa_codigo = ?  ");


			conn = consegura.conexionConsulta();
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.prepareStatement(sql.toString());
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			sentencia.setInt(1, 1);
			sentencia.setInt(2, uaa.getCodigo());
			conn.commit();

			lista  =(LinkedList<Uaa>) UaaRowMapper.mapRow(sentencia.executeQuery());

			consegura.cerrarconn(conn, resul, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, resul, sentencia);

	        }
		return lista.get(0);
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
