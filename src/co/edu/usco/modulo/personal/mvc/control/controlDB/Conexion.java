package co.edu.usco.modulo.personal.mvc.control.controlDB;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.herramientas.Transformacion;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author Maritza
 *
 */
public class Conexion extends CerrarConexion { 
	
	
	int error_codigo = 0;
    String error_mensaje = "";
    
	 
	
	// 
	private Logger log = Logger.getLogger(getClass().getName());
	private String driver1 = "net.sourceforge.jtds.jdbc.Driver";

	/**
	 * @return conexion
	 */
	public Connection conexion_segura(){
        
        Connection conexion = null;
       
        String fuente_datos = "";//Sesion_General_Pool
        fuente_datos = "java:/carrera_adtivaDS";
       
        try{
	       
	       error_codigo = 0;
	       error_mensaje = "";
	       
	       Context ctx = new InitialContext();
	       DataSource dataSource = null;
	       log.info("certifusco ->Conexion Pool: " + fuente_datos);
	       dataSource = (DataSource)ctx.lookup(fuente_datos);
	       conexion = dataSource.getConnection();
	   }catch(Exception e){
		   log.info("certifusco ->Conexion Pool - Error: " + e.toString()); 
	   }
	   return conexion;
   }

	
	/**
	 * 	
	 * @return {@link conexion}
	 */
	
public Connection Get_conexion_sesion(){
        
        Connection conexion = null;
       
        String fuente_datos = "";
        fuente_datos = "java:/carrera_adtivaDS";
       
        try{
	       
	       error_codigo = 0;
	       error_mensaje = "";
	       
	       Context ctx = new InitialContext();
	       DataSource dataSource = null;
	       log.info("certifusco ->Conexion Pool: " + fuente_datos);
	       dataSource = (DataSource)ctx.lookup(fuente_datos);
	       conexion = dataSource.getConnection();
	   }catch(Exception e){
		   log.info("certifusco ->Conexion Pool - Error: " + e.toString());
	   }
	   return conexion;
   }


/**
 * 
 * @param admin
 * @return connection
 */
public Connection getconn_admin(Usuario admin) {
	
	DriverManager.setLoginTimeout(960);
	Connection connection = null;
	try{ 
		
			Class.forName(driver1);
			Transformacion hex = new Transformacion();
				
				log.info("usuario conectado "+admin.getSys());
				log.info("url --> "+admin.getClavereal());
				log.info("url --> "+admin.getUrl().getUrl());
				String clave=admin.getClavereal().trim();
				//admin.setClavereal("Javier.89:");
				//admin.setClavereal(hex.transHexa(admin.getClavereal().trim(), 1));
//				log.info("clave   "+hex.transHexa(admin.getClavereal().trim(), 2));
				connection = DriverManager.getConnection(admin.getUrl().getUrl(), admin.getSys(), admin.getClavereal());
//				connection = DriverManager.getConnection(admin.getUrl().getUrl(), admin.getSys(), "");
				
		
	}catch(Exception e){
		log.info("-->ok: Error al conectarse: " +  e.toString());
		System.out.println("-->ok: Error al conectarse: "+e.toString() );
	} 
	return connection;
}

/**
 * 
 * @param conn
 * @param resul
 * @param sentencia
 */
public void cerrarconn(Connection conn,ResultSet resul,Statement sentencia ){
	try{
		if(resul!= null){
			 try{
	            	resul.close();
	                
	            }catch(Exception ex){
	            	log.error("ha fallado la desconeccion "+ex);
	                //System.out.println("Ha fallado la desconexion "+ e.getMessage());
	            }
			 
		 }
		 if(sentencia!= null){
			 try{
	    			sentencia.close();
	                
	            }catch(Exception ex){
	            	log.error("ha fallado la desconeccion "+ex);
	                //System.out.println("Ha fallado la desconexion "+ e.getMessage());
	            }
			 
		 }
		 if(conn!= null){
			 try{
	            conn.close();
	                
	            }catch(Exception ex){
	            	log.error("ha fallado la desconeccion "+ex);
	                //System.out.println("Ha fallado la desconexion "+ e.getMessage());
	            }
			 
		 }
	}catch(Exception e){
		log.error("ha fallado la desconeccion "+e);
		
	}
}


/**
 * @param conn
 * @param cstmt
 */
public void cerrarconn(Connection conn, CallableStatement cstmt) {
	try{
		
		 if(cstmt!= null){
			 try{
				 cstmt.close();
	                
	            }catch(Exception ex){
	            	log.error("ha fallado la desconeccion "+ex);
	                //System.out.println("Ha fallado la desconexion "+ e.getMessage());
	            }
			 
		 }
		 if(conn!= null){
			 try{
	            conn.close();
	                
	            }catch(Exception ex){
	            	log.error("ha fallado la desconeccion "+ex);
	                //System.out.println("Ha fallado la desconexion "+ e.getMessage());
	            }
			 
		 }
	}catch(Exception e){
		log.error("ha fallado la desconeccion "+e);
		
	}
}
	
}
