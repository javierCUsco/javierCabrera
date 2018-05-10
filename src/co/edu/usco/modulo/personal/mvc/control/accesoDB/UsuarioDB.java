/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Transformacion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.publicacion_tipoOb;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class UsuarioDB implements conexion {
	private Logger imp;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.
	 * lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		Statement sentencia = null;
		ResultSet resul = null;
		imp = Logger.getLogger(getClass().getName());
		LinkedList<publicacion_tipoOb> lista = new LinkedList<publicacion_tipoOb>();
		Conexion consegura = new Conexion();
		try {
			Object param[] = (Object[]) obj;
			// publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
			// usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("select pt.put_codigo,pt.put_nombre,pt.sippa_tipcodigo  ");
			sql.append("from publicacion_tipo as pt  with(nolock)  ");
			// sql.append("where cert_estado=1 ");

			conn = consegura.conexion_segura();
			imp.info("valida el usuario " + sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while (resul.next()) {
				publicacion_tipoOb elemento = new publicacion_tipoOb();
				elemento.setPut_codigo(resul.getInt(1));
				elemento.setPut_nombre(resul.getString(2));
				elemento.setSippa_tipcodigo(resul.getString(3));
				lista.add(elemento);
			}
			consegura.cerrarconn(conn, resul, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, resul, sentencia);

		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getObject(
	 * java.lang.Object)
	 */
	@Override
	public Object getObject(Object obj) {
		Connection conn = null;
		Statement sentencia = null;
		ResultSet resul = null;
		imp = Logger.getLogger(getClass().getName());
		Usuario elemento= null;
		Conexion consegura = new Conexion();
		try {
			Object param[] = (Object[]) obj;
			// publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
			 Usuario user= (Usuario) param[0];
			StringBuffer sql = new StringBuffer();
			sql.append("select per_codigo,	per_identificacion,per_apellido,per_nombre,per_genero,per_lugar_expedicion,per_fecha_expedicion,per_fecha_nacimiento,per_direccion_residencia,per_telefono_movil,per_telefono_fijo,per_estado_civil,per_lugar_nacimiento,per_lugar_residencia,per_codigo,per_identificacion,tii_codigo	   ");
			sql.append("from persona  p with(nolock)   ");
			sql.append("inner join usuario_carrera_login ucl with(nolock) on (p.per_codigo=ucl.up)  ");
			if(user.getNombre()!=null && user.getNombre().length()>0){
				sql.append("where ucl.us='"+user.getNombre()+"' ");	
			}
			// sql.append("where cert_estado=1 ");

			conn = consegura.conexion_segura();
			imp.info("valida el usuario " + sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while (resul.next()) {
				 elemento = new Usuario();
				elemento.getPersona().setPer_codigo(resul.getInt(1));
				elemento.getPersona().setPer_identificacion(resul.getString(2));
				elemento.getPersona().setPer_apellido(resul.getString(3));
				elemento.getPersona().setPer_nombre(resul.getString(4));
				
				
			}
			consegura.cerrarconn(conn, resul, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, resul, sentencia);

		}
		return elemento;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#insertObject
	 * (java.lang.Object)
	 */
	@Override
	public Object setObject(Object obj) {
		imp = Logger.getLogger(getClass().getName());
		Connection conn = null;
		Statement sentencia=null;
		ResultSet resul=null;
		Usuario user= (Usuario) obj;

		 imp.error("getObject(  "+user.getNombre() );
		 imp.error("getObject(  "+user.getClave() );
		 imp.error("getObject(  "+user.getClave2() );
		 StringBuffer sql = null;
		 Conexion consegura = new Conexion();
		 try {
			sql = new StringBuffer();
			Transformacion hex = new Transformacion();

			sql = new StringBuffer();
			sql.append("SELECT dbo.getClaveRealEvadoc( ");
			sql.append(" 0x"+ user.getNombreencriptado().trim() + " , ");
			sql.append(" 0x"+ hex.transHexa(user.getClave().trim(), 2).replace(" ", "<br>")+ " , ");
			sql.append(" 0x"+user.getClave2().trim().replace(" ", "<br>")+ ")");

//			imp.info("getClaveRealEvadoc  ( "+sql.toString());
			
			

			 conn = consegura.conexion_segura();
			 sentencia = conn.createStatement();
			 resul = sentencia.executeQuery(sql.toString());
			 if(resul.next()){
				user.setClavereal(resul.getString(1));
//				System.out.println("si tiene"+user.getClavereal());
			 }
			 consegura.cerrarconn(conn, resul, sentencia);
			
		 }catch (Exception e) {
			 imp.error("getObject(  "+e.toString() );
			 consegura.cerrarconn(conn, resul, sentencia);
		
	
	}
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#esObject(
	 * java.lang.Object)
	 */
	@Override
	public boolean esObject(Object obj) {
		imp = Logger.getLogger(getClass().getName());
		Connection conn = null;
		Statement sentencia = null;
		ResultSet resul = null;
		boolean elemento = false;
		imp.error("esObject(  " );
		Object param[] = (Object[]) obj;
		Usuario user = (Usuario) param[0];
//		 imp.error("esObject(  "+user.getNombre() );
//		 imp.error("esObject(  "+user.getClave() );
//		 imp.error("esObject(  "+user.getClave2() );
		StringBuffer sql = null;
		Conexion consegura = new Conexion();
		try {
			sql = new StringBuffer();
			Transformacion hex = new Transformacion();


			sql.append("SELECT dbo.validarUsuarioCarrera (0x" + user.getNombreencriptado() + ", 0x"
					+ hex.transHexa(user.getClave().trim(), 2).replace(" ", "<br>") + ") ");

			imp.info("esObject( " + sql.toString());
		
			conn = consegura.conexion_segura();
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while (resul.next()) {
				if (resul.getInt(1) >= 1) {
					elemento = true;
				}
			}
			consegura.cerrarconn(conn, resul, sentencia);
		} catch (Exception e) {
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, resul, sentencia);

		}

		return elemento;
	}

}
