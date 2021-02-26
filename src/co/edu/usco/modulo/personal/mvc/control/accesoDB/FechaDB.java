/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Url;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class FechaDB implements ConexionDB {
	private Logger imp ;
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Object param[]=(Object[])obj;
		int dato=Integer.parseInt(String.valueOf(param[1]));
		Object resultado=null;
		if(dato==1) {
			resultado= getValidaEntradaNovedadDocente(param[0]);
		}
		return resultado;
	}
	
	private Object getValidaEntradaNovedadDocente(Object obj) {
		Connection conn = null;
		Statement sentencia=null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		Date fecha=null;
			Conexion consegura = new Conexion();
		 try {
			StringBuffer sql = new StringBuffer();
			sql.append("select GETDATE() as fecha  ");

			conn = consegura.conexionConsulta();
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
//				fecha= new Date();
				fecha=resul.getDate("fecha");
			}
			consegura.cerrarconn(conn, resul, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, resul, sentencia);

	        }
			imp.info("FECHA "+	fecha);
		return fecha;
	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getObject(java.lang.Object)
	 */
	@Override
	public Object getObject(Object obj) {
		Connection conn = null;
		Statement sentencia=null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		StringBuffer elemento=null;
			Conexion consegura = new Conexion();
		 try {
			StringBuffer sql = new StringBuffer();
			sql.append("select CONVERT(VARCHAR , (select GETDATE()),111) as fecha  ");

			Usuario admin= new Usuario();
			admin.setClave("");
//			Url url= new Url();
//			url.setUrl("jdbc:sqlserver://172.16.1.85:1433");
//			url.setBasedato("academia3000_javier");
//			admin.setUrl(url);
//			admin.setSys("jcabrera");
//			admin.setClave2("0x188CFD35F823633186068FF8E038C4CA4EC19B70");
//			System.out.println("valida el antes "+sql.toString());
//			conn = consegura.getconn_admin(admin);
			conn = consegura.conexionConsulta();
			System.out.println("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				elemento= new StringBuffer();
				elemento.append(resul.getString(1));
			}
			consegura.cerrarconn(conn, resul, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, resul, sentencia);

	        }
		return elemento;
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
