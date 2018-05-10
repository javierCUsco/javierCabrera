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
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.PersonaHistoriaAcademica;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Persona_historia_academicaDB implements conexion {

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
		 LinkedList<PersonaHistoriaAcademica> lista = new LinkedList<PersonaHistoriaAcademica>();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 PersonaHistoriaAcademica pha= (PersonaHistoriaAcademica) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
//			sql.append("select top 10  pha.pha_codigo,pha.per_codigo,coalesce(CONVERT(VARCHAR(10),pha.pha_fecha_inicio,111),(SELECT CONVERT(VARCHAR(10),GETDATE(), 111))),coalesce(CONVERT(VARCHAR(10),pha.pha_fecha_fin,111),(SELECT CONVERT(VARCHAR(10),GETDATE(), 111))),pha.ine_codigo,ine.ine_nombre,pha.pha_ciudad,mun.mun_nombre,dep.dep_codigo,dep.dep_nombre,pa.pai_codigo,pa.pai_nombre,pha.pha_titulo,pha.nia_codigo,nia.nia_nombre,pha.pha_documento,pha.pha_estado,coalesce(CONVERT(VARCHAR(10),pha.pha_fecha_titulo,111),(SELECT CONVERT(VARCHAR(10),GETDATE(), 111))),pha.pha_convalidado,pha.pha_mod_codigo,mo.mod_nombre   ");
			sql.append("select  pha.pha_codigo,pha.per_codigo,coalesce(pha.pha_fecha_inicio,(SELECT GETDATE())),coalesce(pha.pha_fecha_fin,(SELECT GETDATE())),pha.ine_codigo,ine.ine_nombre,pha.pha_ciudad,mun.mun_nombre,dep.dep_codigo,dep.dep_nombre,pa.pai_codigo,pa.pai_nombre,pha.pha_titulo,pha.nia_codigo,nia.nia_nombre,pha.pha_documento,pha.pha_estado,coalesce(pha.pha_fecha_titulo,(SELECT GETDATE())),pha.pha_convalidado,pha.pha_mod_codigo,mo.mod_nombre  ");
			sql.append("from persona_historia_academica pha with(nolock) ");
			sql.append("left join institucion_educativa ine with(nolock) on(ine.ine_codigo=pha.ine_codigo) ");
			sql.append("left join nivel_academico nia with(nolock) on(nia.nia_codigo= pha.nia_codigo) ");
			sql.append("left join municipio mun on (mun.mun_codigo=pha.pha_ciudad) ");
			sql.append("left join departamento dep on (dep.dep_codigo= mun.dep_codigo) ");
			sql.append("left join pais pa on (pa.pai_codigo=dep.pai_codigo) ");
			sql.append("left join modalidad mo with(nolock) on(mo.mod_codigo=pha.pha_mod_codigo) ");
			sql.append(" ");
			if(pha.getPersona().getPer_codigo()>0){
				sql.append("where pha.per_codigo= "+pha.getPersona().getPer_codigo());
				sql.append(" ");
			}
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
				PersonaHistoriaAcademica elemento= new PersonaHistoriaAcademica();
				elemento.setPha_codigo(resul.getInt(1));
				elemento.getPersona().setPer_codigo(resul.getInt(2));
				imp.info("valida el Pha_fecha_Inicio "+resul.getDate(3));
				elemento.setPha_fecha_inicio(resul.getDate(3));
				elemento.setPha_fecha_fin(resul.getDate(4));
				elemento.getInstitucion().setIne_codigo(resul.getInt(5));
				elemento.getInstitucion().setIne_nombre(resul.getString(6));
				elemento.getMunicipio().setMun_codigo(resul.getInt(7));
				elemento.getMunicipio().setMun_nombre(resul.getString(8));
				elemento.getMunicipio().getDepartamento().setDep_codigo(resul.getInt(9));
				elemento.getMunicipio().getDepartamento().setDep_nombre(resul.getString(10));
				elemento.getMunicipio().getDepartamento().getPais().setPai_codigo(resul.getInt(11));
				elemento.getMunicipio().getDepartamento().getPais().setPai_nombre(resul.getString(12));
				elemento.setPha_titulo(resul.getString(13));
				elemento.getNivel_academico().setNia_codigo(resul.getInt(14));
				elemento.getNivel_academico().setNia_nombre(resul.getString(15));
				elemento.setPha_documento(resul.getString(16));
				elemento.setPha_estado(resul.getInt(17));
				elemento.setPha_fecha_titulo(resul.getDate(18));
				elemento.setPha_convalidado(resul.getInt(19));
				elemento.getModalidad().setMod_codigo(resul.getInt(20));
				elemento.getModalidad().setMod_nombre(resul.getString(21));
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
		Connection conn = null;
		Statement sentencia=null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		 PersonaHistoriaAcademica elemento = new PersonaHistoriaAcademica();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 PersonaHistoriaAcademica pha= (PersonaHistoriaAcademica) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
//			sql.append("select  pha.pha_codigo,pha.per_codigo,coalesce(CONVERT(VARCHAR(10),pha.pha_fecha_inicio,111),(SELECT CONVERT(VARCHAR(10),GETDATE(), 111))),coalesce(CONVERT(VARCHAR(10),pha.pha_fecha_fin,111),(SELECT CONVERT(VARCHAR(10),GETDATE(), 111))),pha.ine_codigo,ine.ine_nombre,pha.pha_ciudad,mun.mun_nombre,dep.dep_codigo,dep.dep_nombre,pa.pai_codigo,pa.pai_nombre,pha.pha_titulo,pha.nia_codigo,nia.nia_nombre,pha.pha_documento,pha.pha_estado,coalesce(CONVERT(VARCHAR(10),pha.pha_fecha_titulo,111),(SELECT CONVERT(VARCHAR(10),GETDATE(), 111))),pha.pha_convalidado,pha.pha_mod_codigo,mo.mod_nombre   ");
			sql.append("select top 10  pha.pha_codigo,pha.per_codigo,coalesce(pha.pha_fecha_inicio,(SELECT GETDATE())),coalesce(pha.pha_fecha_fin,(SELECT GETDATE())),pha.ine_codigo,ine.ine_nombre,pha.pha_ciudad,mun.mun_nombre,dep.dep_codigo,dep.dep_nombre,pa.pai_codigo,pa.pai_nombre,pha.pha_titulo,pha.nia_codigo,nia.nia_nombre,pha.pha_documento,pha.pha_estado,coalesce(pha.pha_fecha_titulo,(SELECT GETDATE())),pha.pha_convalidado,pha.pha_mod_codigo,mo.mod_nombre,pha.pha_archivo,pha.pha_archivo_md5,pha.pha_content_type  ");
			sql.append("from persona_historia_academica pha with(nolock) ");
			sql.append("left join institucion_educativa ine with(nolock) on(ine.ine_codigo=pha.ine_codigo) ");
			sql.append("left join nivel_academico nia with(nolock) on(nia.nia_codigo= pha.nia_codigo) ");
			sql.append("left join municipio mun on (mun.mun_codigo=pha.pha_ciudad) ");
			sql.append("left join departamento dep on (dep.dep_codigo= mun.dep_codigo) ");
			sql.append("left join pais pa on (pa.pai_codigo=dep.pai_codigo) ");
			sql.append("left join modalidad mo with(nolock) on(mo.mod_codigo=pha.pha_mod_codigo) ");
			sql.append("where ( pha.pha_estado=1 or pha.pha_estado=0)");
			if(pha.getPersona().getPer_codigo()>0){
				sql.append("and pha.per_codigo= "+pha.getPersona().getPer_codigo());
				sql.append(" ");
			}
			if(pha.getPha_codigo()>0){
				sql.append("and pha.pha_codigo= "+pha.getPha_codigo());
				sql.append(" ");
			}
			if(pha.getInstitucion().getIne_codigo()>0){
				sql.append("and pha.ine_codigo= "+pha.getInstitucion().getIne_codigo());
				sql.append(" ");
			}
			sql.append(" ");
			sql.append(" ");
			sql.append(" ");
//			sql.append("where cert_estado=1  ");

			conn = consegura.conexion_segura();
			imp.info("valida el persona_historia_academica "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				elemento= new PersonaHistoriaAcademica();
				elemento.setPha_codigo(resul.getInt(1));
				elemento.getPersona().setPer_codigo(resul.getInt(2));
				elemento.setPha_fecha_inicio(resul.getTimestamp(3));
				elemento.setPha_fecha_fin(resul.getTimestamp(4));
				elemento.getInstitucion().setIne_codigo(resul.getInt(5));
				elemento.getInstitucion().setIne_nombre(resul.getString(6));
				elemento.getMunicipio().setMun_codigo(resul.getInt(7));
				elemento.getMunicipio().setMun_nombre(resul.getString(8));
				elemento.getMunicipio().getDepartamento().setDep_codigo(resul.getInt(9));
				elemento.getMunicipio().getDepartamento().setDep_nombre(resul.getString(10));
				elemento.getMunicipio().getDepartamento().getPais().setPai_codigo(resul.getInt(11));
				elemento.getMunicipio().getDepartamento().getPais().setPai_nombre(resul.getString(12));
				elemento.setPha_titulo(resul.getString(13));
				elemento.getNivel_academico().setNia_codigo(resul.getInt(14));
				elemento.getNivel_academico().setNia_nombre(resul.getString(15));
				elemento.setPha_documento(resul.getString(16));
				elemento.setPha_estado(resul.getInt(17));
				elemento.setPha_fecha_titulo(resul.getTimestamp(18));
				elemento.setPha_convalidado(resul.getInt(19));
				elemento.getModalidad().setMod_codigo(resul.getInt(20));
				elemento.getModalidad().setMod_nombre(resul.getString(21));
				elemento.getPersona().getArchivo().setPh_archivo(resul.getString(22));
				elemento.getPersona().getArchivo().setPh_archivo_md5(resul.getString(23));
				elemento.getPersona().getArchivo().setPh_content_type(resul.getString(24));
				
				}
			consegura.cerrarconn(conn, resul, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, resul, sentencia);

	        }
		return elemento;
	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#setObject(java.lang.Object)
	 */
	@Override
	public Object setObject(Object obj) {
		Object [] param= (Object[]) obj;
		Object resultado=null;
		int opt= (int) param[2];
		if(opt==0){
			resultado=  insertObject(param[1]);
		}
		if(opt==1){
			resultado=updateObject(param[1]);
		}
		return resultado;
	}
	private Object updateObject(Object obj) {
		Connection conn = null;
		Statement sentencia=null;
		int resul=0;
		imp =Logger.getLogger(getClass().getName());
			Conexion consegura = new Conexion();
		 try {
			 PersonaHistoriaAcademica persona=(PersonaHistoriaAcademica) obj; 
//			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE persona_historia_academica ");
			sql.append("SET  ");

//			sql.append("'"+persona.getPersona().getPer_identificacion()+"'");
			sql.append(" pha_fecha_inicio= '"+Fecha.getFecha_format(persona.getPha_fecha_inicio())+"'");
			sql.append(" ,pha_fecha_fin = '"+Fecha.getFecha_format(persona.getPha_fecha_fin())+"'");
			sql.append(" ,ine_codigo= '"+persona.getInstitucion().getIne_codigo()+"'");
			sql.append(" ,pha_ciudad =  "+persona.getMunicipio().getMun_codigo());
			sql.append(" ,pha_titulo =  '"+persona.getPha_titulo()+"'");
			sql.append(" ,nia_codigo = '"+persona.getNivel_academico().getNia_codigo()+"'");
			sql.append(" ,pha_documento =  '"+persona.getPha_documento()+"'");
			sql.append(" ,pha_estado ='"+1+"'");
			sql.append(" ,pha_fecha_titulo =  '"+Fecha.getFecha_format(persona.getPha_fecha_titulo())+"'");
			sql.append(" ,pha_convalidado = "+persona.getPha_convalidado());
			sql.append(" ,pha_mod_codigo =  "+persona.getModalidad().getMod_codigo()+" ");
			sql.append(" ,pha_archivo = '"+persona.getPersona().getArchivo().getPh_archivo()+"' ");
			sql.append(" ,pha_archivo_md5 = '"+persona.getPersona().getArchivo().getPh_archivo_md5()+"' ");
			sql.append(" ,pha_content_type = '"+persona.getPersona().getArchivo().getPh_content_type()+"' ");
			
			sql.append("WHERE pha_codigo=  "+persona.getPha_codigo()+" ");
			sql.append(" and per_codigo= "+persona.getPersona().getPer_codigo()+" " );
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");


			conn = consegura.conexion_segura();
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeUpdate(sql.toString());
//			while(resul.next()){
//				publicacion_tipoOb elemento= new publicacion_tipoOb();
//				elemento.setPut_codigo(resul.getInt(1));
//				elemento.setPut_nombre(resul.getString(2));
//				elemento.setSippa_tipcodigo(resul.getString(3));
//				lista.add(elemento);
//				}
			consegura.cerrarconn(conn, null, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, null, sentencia);

	        }
		return resul;
	}

	private Object insertObject(Object obj){
		Connection conn = null;
		Statement sentencia=null;
		int resul=0;
		imp =Logger.getLogger(getClass().getName());
			Conexion consegura = new Conexion();
		 try {
			 PersonaHistoriaAcademica persona=(PersonaHistoriaAcademica) obj; 
//			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO persona_historia_academica(per_codigo,pha_fecha_inicio,pha_fecha_fin,ine_codigo,pha_ciudad,pha_titulo,nia_codigo,pha_puntos,pha_documento,pha_estado,pha_puntos_fecha,pha_puntos_descripcion,pha_duracion_anos,pha_fecha_titulo,pha_convalidado,pha_mod_codigo,pha_archivo,pha_archivo_md5,pha_content_type,pha_valido ");
			sql.append(")VALUES( ");
			sql.append(" "+persona.getPersona().getPer_codigo()+" ");
			sql.append(" , '"+Fecha.getFecha_format(persona.getPha_fecha_inicio())+"'");
			sql.append(" , '"+Fecha.getFecha_format(persona.getPha_fecha_fin())+"'");
			sql.append(" , '"+persona.getInstitucion().getIne_codigo()+"'");
			sql.append(" , "+persona.getMunicipio().getMun_codigo());
			sql.append(" , '"+persona.getPha_titulo()+"'");
			sql.append(" , "+persona.getNivel_academico().getNia_codigo()+"");
			sql.append(" , '"+persona.getPha_documento()+"'");
			sql.append(" , '"+1+"'");
			sql.append(" , '"+Fecha.getFecha_format(persona.getPha_fecha_titulo())+"'");
			sql.append(" , "+persona.getPha_convalidado()+" ");
			sql.append(" , "+persona.getModalidad().getMod_codigo()+" ");
			sql.append(" , '"+persona.getPersona().getArchivo().getPh_archivo()+"'");
			sql.append(" , '"+persona.getPersona().getArchivo().getPh_archivo_md5()+"'");
			sql.append(" , '"+persona.getPersona().getArchivo().getPh_content_type()+"'");
			sql.append(" ) ");
			sql.append("  ");
			sql.append("  ");


			conn = consegura.conexion_segura();
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeUpdate(sql.toString());
//			while(resul.next()){
//				publicacion_tipoOb elemento= new publicacion_tipoOb();
//				elemento.setPut_codigo(resul.getInt(1));
//				elemento.setPut_nombre(resul.getString(2));
//				elemento.setSippa_tipcodigo(resul.getString(3));
//				lista.add(elemento);
//				}
			consegura.cerrarconn(conn, null, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, null, sentencia);

	        }
		return resul;
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
