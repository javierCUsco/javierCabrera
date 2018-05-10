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
import co.edu.usco.modulo.personal.mvc.modelo.Institucion_educativaOb;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Institucion_educativaDB implements conexion {
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
		 LinkedList<Institucion_educativaOb> lista = new LinkedList<Institucion_educativaOb>();
			Conexion consegura = new Conexion();
//			Institucion_educativaOb ine= new Institucion_educativaOb();
//			imp.info("antes ");
			Institucion_educativaOb ine=(Institucion_educativaOb) obj;
//			imp.info("despues "+ine.getIne_nombre());
		 try {
//			 Object param[]=(Object[]) obj;
//			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("select ine.ine_codigo,ine.iet_codigo,inet.iet_nombre ,ine.ine_nombre,ine.mun_codigo,m.mun_nombre,d.dep_nombre,p.pai_nombre,ine.jor_codigo,j.jor_nombre,ine.ine_nivel,ine.inc_codigo,ine.sippa_inscodigo,ine.ine_fecha1,ine.ine_fecha2,ine.ine_codigo_hecaa   ");
			sql.append("from institucion_educativa ine with(nolock)  ");
			sql.append("left join institucion_educativa_tipo inet with(nolock)  on(inet.iet_codigo= ine.iet_codigo)  ");
			sql.append("left join  jornada j with(nolock)  on(j.jor_codigo=ine.jor_codigo) ");
			sql.append("left join  municipio m with(nolock)  on(m.mun_codigo=ine.mun_codigo)  ");
			sql.append("left join  departamento d with(nolock)  on (d.dep_codigo=m.dep_codigo)  ");
			sql.append("left join  pais p with(nolock)  on (p.pai_codigo=d.pai_codigo) ");
			sql.append(" ");
			if(ine.getIne_nombre()!= null && ine.getIne_nombre().length()>0 ){
				sql.append("where ine.ine_nombre like'%"+ine.getIne_nombre()+"%' ");	
			}
			sql.append(" ");
			sql.append(" ");
			conn = consegura.conexion_segura();
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				Institucion_educativaOb elemento= new Institucion_educativaOb();
				elemento.setIne_codigo(resul.getInt(1));
				elemento.getTipo_institucion().setIet_codigo(resul.getInt(2));
				elemento.getTipo_institucion().setIet_nombre(resul.getString(3));
				elemento.setIne_nombre(resul.getString(4));
				elemento.getMunicipio().setMun_codigo(resul.getInt(5));
				elemento.getMunicipio().setMun_nombre(resul.getString(6));
				elemento.getMunicipio().getDepartamento().setDep_nombre(resul.getString(7));
				elemento.getMunicipio().getDepartamento().getPais().setPai_nombre(resul.getString(8));
				elemento.getJornada().setJor_codigo(resul.getInt(9));
				elemento.getJornada().setJor_nombre(resul.getString(10));
				elemento.setIne_nivel(resul.getString(11));
				elemento.setInc_codigo(resul.getInt(12));
//				elemento.setTii_nombre_corto(resul.getString(3));
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
