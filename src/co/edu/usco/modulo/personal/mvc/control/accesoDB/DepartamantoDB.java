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
import co.edu.usco.modulo.personal.mvc.modelo.DepartamentoOb;
import co.edu.usco.modulo.personal.mvc.modelo.PaisOb;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class DepartamantoDB implements conexion {

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
		 LinkedList<DepartamentoOb> lista = new LinkedList<DepartamentoOb>();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 PaisOb pais= (PaisOb) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("select dep_codigo,dep_acronimo,dep_nombre,pai_codigo,sippa_dep_codigo,dane_codigo      ");
			sql.append("FROM [departamento]  with(nolock)  ");
			sql.append("where pai_codigo= "+pais.getPai_codigo()+" ");
			sql.append("order by  dep_nombre");


			conn = consegura.conexion_segura();
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				DepartamentoOb elemento= new DepartamentoOb();
				elemento.setDep_codigo(resul.getInt(1));
				elemento.setDep_id(resul.getString(2));
				elemento.setDep_nombre(resul.getString(3));
				elemento.getPais().setPai_codigo(resul.getInt(4));
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
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#insertObject(java.lang.Object)
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
