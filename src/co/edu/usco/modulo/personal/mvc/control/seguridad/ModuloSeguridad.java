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

import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Transformacion;
import co.edu.usco.modulo.personal.mvc.control.logica.Wep_parametroLog;
import co.edu.usco.modulo.personal.mvc.modelo.WebParametro;
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
		Statement sentencia = null;
		ResultSet resul = null;
		imp.info("pasa ");
		try {
			String usuario = "";
			StringBuffer sql = new StringBuffer();

			sql.append( "SELECT us from usuario_carrera_login ");
			sql.append(" where state = 1 and HashBytes('SHA1', us) = 0x");
			sql.append(""+ super.getUsername()+" ");
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
			 cerrarconn(conn, resul, sentencia);
			return usuario;
		} catch (Exception e) {
			cerrarconn(conn, resul, sentencia);
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
														
		Statement sentencia = null;
		ResultSet resul = null;
		imp.info("pasa  validatePassword");
		String sql = "";

		int usuario_valido = 0;
		try {

//				
//			+hex.transHexa(user.getClave().trim(), 2).replace(" ", "<br>")+
			 Transformacion hex = new Transformacion();
			sql = "SELECT dbo.validarUsuarioCarrera ( 0x" + super.getUsername()+" "
					+ ",  0x"+hex.transHexa(inputPassword, 2).replace(" ", "<br>")+")";
//			+ ",  (select HASHBYTES('SHA1', '"+inputPassword+"')) " + ")";
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
	 
			
			// imp.info("validatePassword() " + valido + "--" + inputPassword+ "==" + expectedPassword+ "--" + inputPassword2);
			cerrarconn(conn, resul, sentencia) ;
		} catch (Exception e) {
			cerrarconn(conn, resul, sentencia);
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
														
		Statement sentencia = null;
		ResultSet resul = null;
		imp.info("pasa ");
		

		String sql = "";

		HashMap setsMap = new HashMap();
		try {
			

//			String perfiles = getParametros("PERFIL_CARRERA_ADMINISTRATIVA");
			WebParametro parametro=new WebParametro();
			parametro.setWep_nombre("CARRERA_ADMINISTRATIVA_PERFIL");
			parametro= (WebParametro) Wep_parametroLog.getObject(parametro);
			imp.info("perfil  "+parametro.getWep_valor());
			sql = "select grupo.gru_id, 'Roles'";
			sql = sql + " from usuario_carrera_login, usuario_grupo, grupo";
			sql = sql + " where usuario_carrera_login.uid = usuario_grupo.usg_usuario";
			sql = sql + " and usuario_grupo.usg_grupo = grupo.gru_codigo";
			sql = sql + " and grupo.gru_codigo in (" + parametro.getWep_valor() + ")";
			sql = sql + " and usuario_carrera_login.state = 1";
			sql = sql + " and usuario_grupo.usg_estado = 1";
			sql = sql + " and usuario_carrera_login.us = '" + username + "'";

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
			cerrarconn(conn, resul, sentencia);
		} catch (Exception ex) {
			cerrarconn(conn, resul, sentencia);
			imp.error("getRoleSets(): Error: " + ex.toString());
			throw new LoginException(ex.toString());
		} 

		
		Group[] roleSets = new Group[setsMap.size()];
		setsMap.values().toArray(roleSets);

		return roleSets;
	}

	
	
//	  public String getParametros(String parametro_nombre) {
//			Connection conn = null;
//															
//			Statement sentencia = null;
//			ResultSet resul = null;
//			imp.info("pasa getParametros");
//			String parametros="";
//			try {
//				StringBuffer sql = new StringBuffer();
//				sql.append("select wep_valor from web_parametro");
//				sql.append(" where wep_nombre like '" + parametro_nombre + "'");
//				Conexion consegura = new Conexion();
//				conn = consegura.conexion_segura();
//				sentencia = conn.createStatement();
//				resul = sentencia.executeQuery(sql.toString());
//				if (resul.next()) {
//					parametros=resul.getString(1);
//				}
//				cerrarconn(conn, resul, sentencia);
//			} catch (Exception ex) {
//				imp.error("getParametros(): Error: " + ex.toString());
//				cerrarconn(conn, resul, sentencia);
//				
//			}
//		    return parametros;
//		  }
	
	protected String convertRawPassword(String password) {
		try {
			return password;
		} catch (Exception e) {
			imp.error("convertRawPassword(String) - Error: "
					+ e.toString());
		}
		return password;
	}
	
	private void cerrarconn(Connection conn,ResultSet resul,Statement sentencia ){
		try{
			if(resul!= null){
				 try{
		            	resul.close();
		                
		            }catch(Exception ex){
		            	imp.error("ha fallado la desconeccion "+ex);
		                //System.out.println("Ha fallado la desconexion "+ e.getMessage());
		            }
				 
			 }
			 if(sentencia!= null){
				 try{
		    			sentencia.close();
		                
		            }catch(Exception ex){
		            	imp.error("ha fallado la desconeccion "+ex);
		                //System.out.println("Ha fallado la desconexion "+ e.getMessage());
		            }
				 
			 }
			 if(conn!= null){
				 try{
		            conn.close();
		                
		            }catch(Exception ex){
		            	imp.error("ha fallado la desconeccion "+ex);
		                //System.out.println("Ha fallado la desconexion "+ e.getMessage());
		            }
				 
			 }
		}catch(Exception e){
			imp.error("ha fallado la desconeccion "+e);
			
		}
	}

}

	
	
	
	
//	
//	
//	Logger imp = Logger.getLogger(getClass().getName());
//	private String usuario="";
//	protected String getUsername() {
//		transformacion hex = new transformacion();
//		 Conexion consegura=null;
//		Statement sentencia = null;
//		ResultSet resul = null;
//		StringBuffer sql = new StringBuffer();
//		Connection conn = null;
//		try {
//			sql.append("select distinct us from usuario_administrativo  ");
//			sql.append(" where HashBytes('SHA1', us) =(select HASHBYTES('sha1', '"+hex.transHexa(super.getUsername().trim().replace(" ", "<br>").toLowerCase(),2)+"')) ");
//			consegura = new Conexion();
//			 conn = consegura.conexion_segura();
//			sentencia = conn.createStatement();
//			resul = sentencia.executeQuery(sql.toString());
//			String usertem="";
//			imp.info("getUsername(): 1" + sql.toString());
//			if (resul.next()) {
//				 usertem= resul.getString(1);
//			}
//			 consegura.cerrarconn(conn, resul, sentencia);
////			this.usuario
//		
//				this.usuario=usertem;
//			
////			 imp.info("getUsername(): " + super.getUsername() + ","
////					+ this.usuario);
//			 consegura.cerrarconn(conn, resul, sentencia);
//
//			imp.info("getUsername(): " + super.getUsername() + "," + this.usuario+","+usertem);
//
//			return super.getUsername().trim().replace(" ", "<br>");
//		} 
//		catch (Exception e) {
//			 consegura.cerrarconn(conn, resul, sentencia);
//			 imp.error("getUsername() - error: " + e.toString()+" "+sql.toString());
//		}
//		
//		return super.getUsername().trim().replace(" ", "<br>");
//	}
////
////	protected String getUsersPassword() throws LoginException {
////		return super.getUsersPassword();
////	}
////
////	protected String[] getUsernameAndPassword() throws LoginException {
////		return super.getUsernameAndPassword();
////	}
//
//	protected boolean validatePassword(String inputPassword, String expectedPassword) {
//		boolean valido = true;
//		int resultado = -1;
//		String username = super.getUsername();//getUsername();
//		Connection conn = null;
//		Statement sentencia = null;
//		ResultSet resul = null;
//		StringBuffer sql = new StringBuffer();
//		transformacion hex = new transformacion();
//		imp.info(" antes validatePassword():  "+username +"  "+ hex.transHexa(inputPassword,2));
//		Conexion consegura = new Conexion();
//		try {
//			
////			System.out.println(hex.transHexa(super.getUsername().trim().replace(" ", "<br>"), 2) );
//		//sql = "SELECT academia3000.dbo.validarUsuarioGeneral (0x" + super.getUsername() + ", 0x" + inputPassword + ")";
//		sql.append("select  dbo.validarUsuarioAdministrativo  ( (select HASHBYTES('sha1', '"+username.trim().replace(" ", "<br>").toLowerCase()+"')), 0x" + hex.transHexa(inputPassword,2) + ")");
//		imp.info(" antes validatePassword():" + sql);
//		
//		
//	
//		 imp.info(" despues validatePassword(): "+sql.toString() );
//		 conn = consegura.conexion_segura();
//		sentencia = conn.createStatement();
//		resul = sentencia.executeQuery(sql.toString());
//		//int valido2 = 0;
//	
//			if (resul.next()) {
//				resultado= resul.getInt(1);
//			}
//		consegura.cerrarconn(conn, resul, sentencia);
//		imp.info("validatePassword() valido2:" + resultado);
//
//		if (resultado == 1) {
//			valido = true;
//		} 
//		else {
//			valido = false;
//		}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			consegura.cerrarconn(conn, resul, sentencia);
//			imp.error("getRoleSets(): Error: " + e.toString()+" SQL : "+sql.toString());
////			e.printStackTrace();
//		}
//		imp.info("validatePassword() " + valido + "--" + inputPassword + "==" + expectedPassword);
//
//		return valido;
//	}
//
//	public boolean login() throws LoginException {
//		return super.login();
//	}
//
//	public boolean commit() throws LoginException {
//		return super.commit();
//	}
//
//	protected Group[] getRoleSets() throws LoginException {
//		String username = super.getUsername();
////		System.out.println("username "+username);
//		Connection conn = null;
//		Statement sentencia = null;
//		ResultSet resul = null;
//		StringBuffer sql = new StringBuffer();
//		Conexion consegura = new Conexion();
//		imp.info("EVALUACION_DOCENTE_PERFILES "+username);
//		HashMap setsMap = new HashMap();
//		try {
//		
//			Web_parametroOb parametro = new Web_parametroOb();
//			parametro.setWep_nombre("EVALUACION_DOCENTE_PERFILES");
//			parametro=(Web_parametroOb)Wep_parametroLog.getObject(parametro);
//			imp.info("EVALUACION_DOCENTE_PERFILES "+parametro.getWep_valor());
////			sql.append("select grupo.gru_id, 'Roles' ");
////			sql.append(" from usuario_academia, usuario_grupo, grupo ");
////			sql.append(" where usuario_academia.uid = usuario_grupo.usg_usuario ");
////			sql.append(" and usuario_grupo.usg_grupo = grupo.gru_codigo ");
////			sql.append(" and grupo.gru_codigo in (" + parametro.getWep_valor()+ ") ");
////			sql.append(" and usuario_academia.state = 1 ");
////			sql.append(" and usuario_grupo.usg_estado = 1 ");
////			
////			sql.append(" and  HashBytes('SHA1', usuario_academia.us) = (select HASHBYTES('sha1', '"+username.trim().replace(" ", "<br>").toLowerCase()+"')) ");
//			 sql.append("select grupo.gru_id, 'Roles'  ");
//			 sql.append("from usuario_academia with(nolock) ");
//			 sql.append("inner join usuario_grupo with(nolock)  on(usuario_academia.uid = usuario_grupo.usg_usuario  ) ");
//			 sql.append("inner join grupo with(nolock)  on(usuario_grupo.usg_grupo = grupo.gru_codigo ) ");
//			 sql.append("where  grupo.gru_codigo in (" + parametro.getWep_valor()+ ") ");
//			 sql.append("and usuario_academia.state = 1  ");
//			 sql.append("and  HashBytes('SHA1', usuario_academia.us) = (select HASHBYTES('sha1', '"+username.trim().replace(" ", "<br>").toLowerCase()+"'))  ");
//			 
//
//			imp.info("EVALUACION_DOCENTE_PERFILES "+sql.toString());
//			int tipousu=0;
////			imp.info("user.getNombre() "+this.usuario );
//			 if((this.usuario.substring(0, 2).toLowerCase().equals("u1"))||(this.usuario.substring(0, 2).toLowerCase().equals("u2"))){
//				 tipousu=1;
//			 }
//			 conn = consegura.conexion_segura();
//			sentencia = conn.createStatement();
//			resul = sentencia.executeQuery(sql.toString());
////			imp.info("getRoleSets()1: "+ sql);
//			if (!resul.next()) {
//				if (getUnauthenticatedIdentity() == null) {
//					throw new FailedLoginException(
//							"No matching username found in Roles");
//				}
//				imp.info("getRoleSets() valido: "+ resul.getString(1));
//				Group[] roleSets = { new SimpleGroup("Roles") };
//				Group[] arrayOfGroup1 = roleSets;
//				return arrayOfGroup1;
//			}
//			imp.info("getRoleSets() valido: antes del do ");
//			do {
//				String name = resul.getString(1);
//				String groupName = resul.getString(2);
//
//				imp.info("getRoleSets()1: " + name + "--" + groupName);
//
//				if ((groupName == null) || (groupName.length() == 0)) {
//					groupName = "Roles";
//				}
//				Group group = (Group) setsMap.get(groupName);
//
//				if (group == null) {
//					group = new SimpleGroup(groupName);
//					setsMap.put(groupName, group);
//				}
//
//				group.addMember(new SimplePrincipal(name));
//			} while (resul.next());
////			imp.info("getRoleSets() valido: despues del do ");
//			consegura.cerrarconn(conn, resul, sentencia);
//		} 
//		catch (Exception ex) {
//			consegura.cerrarconn(conn, resul, sentencia);
//			imp.error("getRoleSets(): Error: " + ex.toString()+" SQL : "+sql.toString());
////			throw new LoginException("getRoleSets "+ex.toString());
//		} 
//		
//		
//		Group[] roleSets = new Group[setsMap.size()];
//		setsMap.values().toArray(roleSets);
//
//		return roleSets;
//	}
//
//	protected String convertRawPassword(String password) {
//		try {
//			return password;
//		} catch (Exception e) {
//			imp.error("convertRawPassword(String) - Error: "
//					+ e.toString());
//		}
//		return password;
//	}
//}