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
import co.edu.usco.modulo.personal.mvc.modelo.Historia_laboral_tipoOb;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Historia_laboral_tipoDB implements conexion {

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
		 LinkedList<Historia_laboral_tipoOb> lista = new LinkedList<Historia_laboral_tipoOb>();
			Conexion consegura = new Conexion();
		 try {
//			 Object param[]=(Object[]) obj;
//			 Persona_historia_laboralOb pha= (Persona_historia_laboralOb) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
//			sql.append("select top 10  pha.pha_codigo,pha.per_codigo,coalesce(CONVERT(VARCHAR(10),pha.pha_fecha_inicio,111),(SELECT CONVERT(VARCHAR(10),GETDATE(), 111))),coalesce(CONVERT(VARCHAR(10),pha.pha_fecha_fin,111),(SELECT CONVERT(VARCHAR(10),GETDATE(), 111))),pha.ine_codigo,ine.ine_nombre,pha.pha_ciudad,mun.mun_nombre,dep.dep_codigo,dep.dep_nombre,pa.pai_codigo,pa.pai_nombre,pha.pha_titulo,pha.nia_codigo,nia.nia_nombre,pha.pha_documento,pha.pha_estado,coalesce(CONVERT(VARCHAR(10),pha.pha_fecha_titulo,111),(SELECT CONVERT(VARCHAR(10),GETDATE(), 111))),pha.pha_convalidado,pha.pha_mod_codigo,mo.mod_nombre   ");
			sql.append("select hlt_codigo,hlt_nombre  ");
			sql.append("from historia_laboral_tipo  with(nolock)  ");
			
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
//				Historia_laboral_tipoLog elemento= new Historia_laboral_tipoLog();
				
				lista.add(new Historia_laboral_tipoOb(resul.getInt(1), resul.getString(2)));
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
