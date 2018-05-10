/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Transformacion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.Url;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;


/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class AdminDB implements conexion {
	private Logger imp ;
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getObject(java.lang.Object)
	 */
	@Override
	public Object getObject(Object obj) {
		Conexion consegura = new Conexion();
		Url dato=null;
		Statement sentencia = null;
		ResultSet resul = null;
		imp =Logger.getLogger(getClass().getName());
		Connection conn =null;
		Usuario user= (Usuario) obj;
		 StringBuffer sql = null;
		 imp.info(" en persona user.getNombre() "+user.getNombre() );
		try{
				sql = new StringBuffer();
				Transformacion hex = new Transformacion();		
				sql.append("select ual.uid,ual.ischange, ual.us,ual.sys,ual.state, ual.uwd2    " );
				sql.append(" from  usuario_carrera_login ual with(nolock) ");
//				sql.append(" inner join persona with(nolock) on(usuario_evadoc_login.up = persona.per_codigo  ) ");
				sql.append(" where ual.state = 1 ");
				if(user.getNombre()!=null && user.getNombre().trim().length()>0){
				sql.append(" and ual.us = '" + user.getNombre().trim().replace(" ","@")+"' ");
				}else{
					sql.append(" and ual.us = @ ");
				}
//				if(user.getClave()!=null && user.getClave().trim().length()>0){
//					sql.append(" and ual.uwd2 =(select HASHBYTES('MD5','" + hex.transHexa(user.getClave().trim().replace(" ","@"),2)+"' ))");
//				
//					}else{
//						sql.append(" and ual.us = @ ");
//					}
				conn = consegura.conexion_segura();
				imp.info("valida el usuario "+sql.toString());
				sentencia = conn.createStatement();
				resul = sentencia.executeQuery(sql.toString());
				while(resul.next()){
					user.setUid(resul.getInt(1));
					user.setIsChange(resul.getInt(2));
					//user.setClavereal(resul.getString(3));
					user.setSys(resul.getString(4));
					user.setEstado(resul.getInt(5));
					user.setClavereal(resul.getString(6));
					}
	    	consegura.cerrarconn(conn, resul, sentencia);
	    	user=getClaveReal(user) ;
		}catch(Exception e){
			consegura.cerrarconn(conn, resul, sentencia);
			imp.error("Error validacion conexion: " + e);
		} 
		return user;
	}

	public Usuario getClaveReal(Usuario user) {
		imp = Logger.getLogger(getClass().getName());
		Connection conn = null;
		Statement sentencia=null;
		ResultSet resul=null;
//		usuarioOb user= (usuarioOb) obj;

		 imp.error("getObject(  "+user.getNombre() );
		 imp.error("getObject(  "+user.getClave() );
		 imp.error("getObject(  "+user.getClave2() );
		 StringBuffer sql = null;
		 Conexion consegura = new Conexion();
		 try {
			sql = new StringBuffer();
			Transformacion hex = new Transformacion();

			sql = new StringBuffer();
			sql.append("SELECT dbo.getClaveReal( ");
			sql.append(" 0x"+ user.getNombreencriptado().trim().toUpperCase() + " , ");
			sql.append(" 0x"+ hex.transHexa(user.getClave().trim(), 2).replace(" ", "<br>").toUpperCase()+ " , ");
			sql.append(" 0x"+user.getClave2().trim().replace(" ", "<br>")+ ")");

			imp.info("getClaveRealEvadoc  ( "+sql.toString());
			
			

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
