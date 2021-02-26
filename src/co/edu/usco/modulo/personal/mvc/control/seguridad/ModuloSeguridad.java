package co.edu.usco.modulo.personal.mvc.control.seguridad;


import java.security.acl.Group;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

import org.apache.log4j.Logger;
import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.auth.spi.DatabaseServerLoginModule;

import co.edu.usco.modulo.personal.mvc.control.controlDB.CerrarConexion;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Transformacion;
import co.edu.usco.modulo.personal.mvc.control.logica.WebParametroLog;
import co.edu.usco.modulo.personal.mvc.modelo.WebParametro;
/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class ModuloSeguridad extends DatabaseServerLoginModule {
	
	Logger imp = Logger.getLogger(getClass().getName());
	/**
	 * 
	 */
	public ModuloSeguridad() {
		// TODO Auto-generated constructor stub
	}
	

	protected String getUsername() {
		Connection conn = null;
		CerrarConexion cerrarConexion=new CerrarConexion();
		Statement sentencia = null;
		ResultSet resul = null;
		imp.info("pasa ");
		try {
			String usuario = "";
			StringBuffer sql = new StringBuffer();

//			sql.append( "SELECT us from usuario_pensionado_login ");
			sql.append( "SELECT us from usuario_carrera_login ");
			sql.append(" where state = 1 and HashBytes('SHA1', us) = 0x");
//			sql.append(""+ super.getUsername()+" ");
			
//			sql.append("SELECT        dbo.usuario_grupo.usg_usuario, dbo.grupo.gru_nombre, dbo.usuario_grupo.usg_grupo, dbo.grupo.gru_id, dbo.usuario_grupo.usg_uaa, dbo.usuario_grupo.usg_estado, dbo.grupo.gru_codigo, dbo.usuario_grupo.usg_codigo, \r\n" + 
//					"                         dbo.usuario_administrativos.up, dbo.usuario_administrativos.us, dbo.usuario_administrativos.istipo, dbo.usuario_administrativos.ischange, dbo.usuario_administrativos.uwd, dbo.usuario_administrativos.uwd2, \r\n" + 
//					"                         dbo.usuario_administrativos.state, dbo.usuario_administrativos.sys, dbo.usuario_administrativos.uid\r\n" + 
//					"FROM            dbo.usuario_grupo INNER JOIN\r\n" + 
//					"                         dbo.grupo ON dbo.usuario_grupo.usg_grupo = dbo.grupo.gru_codigo INNER JOIN\r\n" + 
//					"                         dbo.usuario_administrativos ON dbo.usuario_grupo.usg_usuario = dbo.usuario_administrativos.uid\r\n" + 
//					"WHERE        (dbo.grupo.gru_id LIKE 'CARRERA_ADTIVA%') AND (dbo.usuario_grupo.usg_estado = 1)");
//			sql.append(" and  state = 1 and HashBytes('SHA1', us) = (HashBytes('SHA1','");
			sql.append(""+ super.getUsername()+"')) ");
			 imp.info("getUsername(): " + sql.toString());
			 Conexion consegura = new Conexion();
			conn = consegura.conexion_segura();
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			if (resul.next()) {
				usuario = resul.getString(1);
			}
			 imp.info("getUsername(): " + super.getUsername() + ","
					+ usuario);
			 cerrarConexion.cerrarconn(conn, resul, sentencia);
			return usuario;
		} catch (Exception e) {
			cerrarConexion.cerrarconn(conn, resul, sentencia);
			imp.error("getUsername() - error: " + e.toString());
		}

		return super.getUsername();
	}

	protected String getUsersPassword() throws LoginException {
		return super.getUsersPassword();
	}

	protected String[] getUsernameAndPassword() throws LoginException {
		return super.getUsernameAndPassword();
	}

	protected boolean validatePassword(String inputPassword,String expectedPassword) {
		boolean valido = false;

		Connection conn = null;
		CerrarConexion cerrarConexion=new CerrarConexion();												
		Statement sentencia = null;
		ResultSet resul = null;
		imp.info("pasa  validatePassword");
		String sql = "";

		int usuario_valido = 0;
		try {

//				
//			+hex.transHexa(user.getClave().trim(), 2).replace(" ", "<br>")+
			 Transformacion hex = new Transformacion();
//			sql = "SELECT dbo.validarUsuarioPensionado ( 0x" + super.getUsername()+" "


					sql = "SELECT dbo.validarUsuarioCarrera ( HashBytes('SHA1','" + super.getUsername()
					+ "'), HashBytes('SHA1','" + inputPassword + "') ) ";
					
					
					
			 imp.info("validatePassword(): " + sql);
			 Conexion consegura = new Conexion();
				conn = consegura.conexion_segura();
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			if (resul.next()) {
				usuario_valido = resul.getInt(1);
			}

			 imp.info("validatePassword() usuario_valido: "+ usuario_valido);

			if (usuario_valido == 1) {
				valido = true;
			} else {
				valido = false;
			}
			cerrarConexion.cerrarconn(conn, resul, sentencia) ;
		} catch (Exception e) {
			cerrarConexion.cerrarconn(conn, resul, sentencia);
			imp.error("validatePassword(String, String) - Error: "+ e.toString());
		}

		return valido;
	}

	public boolean login() throws LoginException {
		return super.login();
	}

	public boolean commit() throws LoginException {
		return super.commit();
	}

	protected Group[] getRoleSets() throws LoginException {
		String username = getUsername();
		Connection conn = null;
		CerrarConexion cerrarConexion=new CerrarConexion();											
		Statement sentencia = null;
		ResultSet resul = null;
		imp.info("pasa ");
		String sql = "";
		HashMap setsMap = new HashMap();
		try {
		

//			String perfiles = getParametros("PERFIL_CARRERA_ADMINISTRATIVA");
			WebParametro parametro=new WebParametro();
			parametro.setNombre("CARRERA_ADMINISTRATIVA_PERFIL");
			parametro= (WebParametro) WebParametroLog.getObject(parametro);
			imp.info("perfil  "+parametro.getValor());
			sql = "select grupo.gru_id, 'Roles'";
//			sql = sql + " from usuario_pensionado_login, usuario_grupo, grupo";
			sql = sql + " from usuario_carrera_login, usuario_grupo, grupo";
			sql = sql + " where usuario_carrera_login.uid = usuario_grupo.usg_usuario";
			sql = sql + " and usuario_grupo.usg_grupo = grupo.gru_codigo";
			sql = sql + " and grupo.gru_codigo in (" + parametro.getValor() + ")";
			sql = sql + " and usuario_carrera_login.state = 1";
			sql = sql + " and usuario_grupo.usg_estado = 1";
			sql = sql + " and usuario_carrera_login.us = '" + username + "'";
//			sql = sql + " and usuario_carrera_login.us = '" + username + "'";

			 imp.info("getRoleSets() - " + sql);
			 Conexion consegura = new Conexion();
				conn = consegura.conexion_segura();
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql);

			if (!resul.next()) {
				if (getUnauthenticatedIdentity() == null) {
					 imp.info("getRoleSets() - error null" );
					throw new FailedLoginException(
							"No matching username found in Roles");
				}

				Group[] roleSets = { new SimpleGroup("Roles") };
				Group[] arrayOfGroup1 = roleSets;
				return arrayOfGroup1;
			}
			do {
				String name = resul.getString(1);
				String groupName = resul.getString(2);

				 imp.info("getRoleSets(): " + name + "--" + groupName);

				if ((groupName == null) || (groupName.length() == 0)) {
					groupName = "Roles";
				}
				Group group = (Group) setsMap.get(groupName);

				if (group == null) {
					group = new SimpleGroup(groupName);
					setsMap.put(groupName, group);
				}

				group.addMember(new SimplePrincipal(name));
			} while (resul.next());
			cerrarConexion.cerrarconn(conn, resul, sentencia);
		} catch (Exception ex) {
			cerrarConexion.cerrarconn(conn, resul, sentencia);
			imp.error("getRoleSets(): Error: " + ex.toString());
			throw new LoginException(ex.toString());
		} 

		
		Group[] roleSets = new Group[setsMap.size()];
		setsMap.values().toArray(roleSets);

		return roleSets;
	}

	
	protected String convertRawPassword(String password) {
		try {
			return password;
		} catch (Exception e) {
			imp.error("convertRawPassword(String) - Error: "
					+ e.toString());
		}
		return password;
	}
}

	
	
