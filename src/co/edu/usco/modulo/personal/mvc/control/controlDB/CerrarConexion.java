package co.edu.usco.modulo.personal.mvc.control.controlDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class CerrarConexion  {

	private Logger log = Logger.getLogger(getClass().getName());
	
	
	public  void cerrarconn(Connection conn,ResultSet resul,Statement sentencia, PreparedStatement pS  ){
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
			 if(pS!= null){
				 try{
		    			pS.close();
		                
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

	public  void cerrarconn(Connection conn,ResultSet resul,Statement sentencia){
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
}
