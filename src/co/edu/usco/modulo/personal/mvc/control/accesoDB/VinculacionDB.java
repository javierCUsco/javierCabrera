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
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.Vinculacion;

/**
 * @author ING. JAVIER CABRERA LASSO
 *
 */
public class VinculacionDB implements conexion{

	private Logger imp ;
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		Statement sentencia=null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		 LinkedList<Vinculacion> lista = new LinkedList<Vinculacion>();
			Conexion consegura = new Conexion();
		 try {
//			 Object param[]=(Object[]) obj;
//			 Persona_historia_laboralOb pha= (Persona_historia_laboralOb) param[0];
			StringBuffer sql = new StringBuffer();
			sql.append("select vin_codigo,vin_nombre,vin_horas_year,vin_clase,sippa_vincodigo,vin_contratacion  ");
			sql.append("from vinculacion  with(nolock)  ");
			
			sql.append(" ");
			sql.append(" ");
			sql.append(" ");
//			sql.append("where cert_estado=1  ");


			conn = consegura.conexion_segura();
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
//			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			
			while(resul.next()){
				Vinculacion elemento= new Vinculacion();
				elemento.setVin_codigo(resul.getInt(1));
				elemento.setVin_nombre(resul.getString(2));
				lista.add(elemento);
				}
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
		
		return null;
	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#setObject(java.lang.Object)
	 */
	@Override
	public Object setObject(Object obj) {
		Object [] param= (Object[]) obj;
		int opt= (int) param[2];
		if(opt==0){
			insertObject(param[1]);
		}
		if(opt==1){
			updateObject(param[1]);
		}
		return null;
	}
	private Object updateObject(Object obj) {
		
		return null;
	}

	private Object insertObject(Object obj){
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
