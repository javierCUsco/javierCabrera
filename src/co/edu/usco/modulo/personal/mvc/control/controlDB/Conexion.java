package co.edu.usco.modulo.personal.mvc.control.controlDB;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author Javier Cabrera Lasso
 *
 */
public class Conexion extends CerrarConexion {

	int error_codigo = 0;
	String error_mensaje = "";

	/**
	 * hojavidaLoginDS hojavidaConsultaDS hojavidaEjecucionDS
	 */

	//
	private Logger log = Logger.getLogger(getClass().getName());
	// private String driver1 = "net.sourceforge.jtds.jdbc.Driver";
	private String driver1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// private String driver1 = "net.sourceforge.jtds.jdbc.Driver";

	public Connection conexionLogin() {
		Connection conexion = null;
		String fuente_datos = "";// Sesion_General_Pool
		// fuente_datos ="Sesion_General_Pool"; //"java:/carrera_adtivaDS";
//		fuente_datos = "java:jboss/datasources/hojavidaLoginDS";
		 fuente_datos ="java:jboss/datasources/talento_humano_PoolDS";
		log.info("para el login ");
		try {

			error_codigo = 0;
			error_mensaje = "";

			Context ctx = new InitialContext();
			DataSource dataSource = null;
			dataSource = (DataSource) ctx.lookup(fuente_datos);
			conexion = dataSource.getConnection();
		} catch (Exception e) {
			log.error("ERROR EN AL CONECCION " + e);
			// log.info(" ->Conexion Pool - Error: " + e.toString());
		}

		return conexion;
	}

	public Connection conexionConsulta() {
		Connection conexion = null;
		String fuente_datos = "";// Sesion_General_Pool
		// fuente_datos ="Sesion_General_Pool"; //"java:/carrera_adtivaDS";
//		fuente_datos = "java:jboss/datasources/hojavidaConsultaDS";
		 fuente_datos ="java:jboss/datasources/talento_humano_ConsultaDS";
		log.info("para las consulta ");
		try {

			error_codigo = 0;
			error_mensaje = "";

			Context ctx = new InitialContext();
			DataSource dataSource = null;
			dataSource = (DataSource) ctx.lookup(fuente_datos);
			conexion = dataSource.getConnection();
		} catch (Exception e) {
			log.error("ERROR EN AL CONECCION " + e);
			// log.info(" ->Conexion Pool - Error: " + e.toString());
		}
		log.info(" ->Conexion Pool - : " + conexion);
		return conexion;
	}

	public Connection conexionEjecucion() {
		Connection conexion = null;
		String fuente_datos = "";// Sesion_General_Pool
		// fuente_datos ="Sesion_General_Pool"; //"java:/carrera_adtivaDS";
		// if(usuario.getModulo()==45) {
		//fuente_datos = "java:jboss/datasources/hojavidaEjecucionDS";
		fuente_datos = "java:jboss/datasources/talento_humano_ConsultaDS";
		// }
		// if(usuario.getModulo()==45) {
		// fuente_datos ="java:jboss/datasources/talento_humano_ConsultaDS";
		// }

		// fuente_datos ="java:jboss/datasources/talento_humano_ConsultaDS";
		log.info("para lo update e inser ");
		try {

			error_codigo = 0;
			error_mensaje = "";

			Context ctx = new InitialContext();
			DataSource dataSource = null;
			dataSource = (DataSource) ctx.lookup(fuente_datos);
			conexion = dataSource.getConnection();
		} catch (Exception e) {
			log.error("ERROR EN AL CONECCION " + e);
			// log.info(" ->Conexion Pool - Error: " + e.toString());
		}

		return conexion;
	}

	/**
	 * @return conexion
	 */
	public Connection conexion_segura() {

		Connection conexion = null;
		// carrera_adtivaDS
		// pensionado_poolDS
		String fuente_datos = "";// Sesion_General_Pool
		// fuente_datos ="Sesion_General_Pool"; //"java:/carrera_adtivaDS";
		fuente_datos = "Sesion_General_Pool";

		try {

			error_codigo = 0;
			error_mensaje = "";

			Context ctx = new InitialContext();
			DataSource dataSource = null;
			// log.info(" ->Conexion Pool: " + fuente_datos);
			dataSource = (DataSource) ctx.lookup(fuente_datos);
			conexion = dataSource.getConnection();
		} catch (Exception e) {
			System.out.println("ERROR EN AL CONECCION " + e);
			// log.info(" ->Conexion Pool - Error: " + e.toString());
		}

		// log.info(" ->la conexion : " + conexion);
		return conexion;
	}

	/**
	 * 
	 * @return {@link Conexion}
	 */

	public Connection Get_conexion_sesion() {

		Connection conexion = null;

		String fuente_datos = "";
		// fuente_datos = "Sesion_General_Pool";//"java:/carrera_adtivaDS";
		// fuente_datos ="Sesion_General_Pool"; //"java:/carrera_adtivaDS";
		fuente_datos = "Sesion_General_Pool";
		try {

			error_codigo = 0;
			error_mensaje = "";

			Context ctx = new InitialContext();
			DataSource dataSource = null;
			// log.info(" ->Conexion Pool: " + fuente_datos);
			dataSource = (DataSource) ctx.lookup(fuente_datos);
			conexion = dataSource.getConnection();
		} catch (Exception e) {
			log.info(" ->Conexion Pool - Error: " + e.toString());
		}
		return conexion;
	}

	/**
	 * 
	 * @param admin
	 * @return connection
	 */
	public Connection getconn_admin(Usuario admin) {
		System.out.println("-->USUARIO : " + admin.getUrl().getUrl());
		System.out.println("-->USUARIO getBasedato : " + admin.getUrl().getBasedato());
		System.out.println("-->USUARIO : " + admin.getSys());
		// System.out.println("-->USUARIO getClavereal : " +admin.getClavereal());
		System.out.println("-->USUARIO getClave2 : " + admin.getClave2());
		DriverManager.setLoginTimeout(960);
		Connection connection = null;
		try {
			Class.forName(driver1);
			// connection = DriverManager.getConnection(admin.getUrl().getUrl(),
			// admin.getSys(), admin.getClavereal());
			connection = DriverManager.getConnection(
					admin.getUrl().getUrl() + ";database=" + admin.getUrl().getBasedato(), admin.getSys(),
					admin.getClave2());

		} catch (Exception e) {
			// log.error("-->ok: Error al conectarse: " + e.toString());
			System.out.println("Error al conectarse " + e.toString());
		}
		// log.info("-->la conexion : " +connection);
		System.out.println(" " + connection);
		return connection;
	}

}
