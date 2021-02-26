/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.PersonaHistoriaAcademicaRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.PersonaHistoriaAcademica;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.novedadDocente.Novedad;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PersonaHistoriaAcademicaDB implements ConexionDB {

	private Logger imp ;
	private String SQL_SELECT="SELECT pha.pha_codigo\r\n" + 
			",pha.per_codigo,pha.pha_fecha_inicio,pha.pha_fecha_fin\r\n" + 
			",pha.ine_codigo,ie.ine_codigo,ie.iet_codigo,iet.iet_codigo,iet.iet_nombre,ie.ine_nombre,\r\n" + 
			"ie.mun_codigo, mie.mun_codigo AS miec,mie.mun_id AS miei,mie.mun_nombre AS mien,\r\n" + 
			"mie.dep_codigo AS miedc,die.dep_codigo AS diec,die.dep_acronimo AS diea,die.dep_nombre AS dien,\r\n" + 
			"die.pai_codigo AS diepc,pie.pai_codigo AS piec,pie.pai_acronimo AS piea,pie.pai_nombre AS pien,pie.sippa_pai_codigo AS spiec,pie.dane_codigo AS dpiec,pie.pai_codigo_hecaa AS piech\r\n" + 
			",die.sippa_dep_codigo AS sdiec,die.dane_codigo AS ddie,\r\n" + 
			"mie.sippa_mun_codigo AS smiec,mie.SNIES_codigo AS emiec,mie.dane_codigo AS dmiec,\r\n" + 
			"ie.jor_codigo,j.jor_codigo,j.jor_nombre,j.sippa_jor_codigo\r\n" + 
			",ie.ine_nivel,ie.inc_codigo,ie.sippa_inscodigo,ie.ine_codigo_hecaa\r\n" + 
			",pha.pha_ciudad,\r\n" + 
			"\r\n" + 
			"pham.mun_codigo AS phamc,pham.mun_id AS phami,pham.mun_nombre AS phamn,\r\n" + 
			"pham.dep_codigo AS miedc,phad.dep_codigo AS phadc,phad.dep_acronimo AS phada,phad.dep_nombre AS phadn,\r\n" + 
			"phad.pai_codigo AS diepc,phap.pai_codigo AS phapc,phap.pai_acronimo AS phapa,phap.pai_nombre AS phapn,phap.sippa_pai_codigo AS sphapc,phap.dane_codigo AS dphapc,phap.pai_codigo_hecaa AS phapch\r\n" + 
			",phad.sippa_dep_codigo AS sphadc,phad.dane_codigo AS dphad,\r\n" + 
			"pham.sippa_mun_codigo AS sphamc,pham.SNIES_codigo AS ephamc,pham.dane_codigo AS dphamc,\r\n" + 
			"\r\n" + 
			"pha.pha_titulo\r\n" + 
			",pha.nia_codigo\r\n" + 
			",na.nia_codigo\r\n" +
			",pha.pha_valido\r\n" + 
			",pha.doc_codigo\r\n" + 
			",na.nia_nombre,na.nia_orden,na.for_codigo,na.snies_codigo,na.sippa_nia_codigo,na.sippa_nivcodigo,na.nia_codigo_mp_hecaa,na.nia_codigo_ned_hecaa\r\n" + 
			",na.nia_codigo_ne_hecaa,na.nat_codigo, nat.nat_codigo,nat.nat_nombre,nat.nat_estado, na.nia_cap_estado ,na.nia_cap_puntos,na.nia_cap_puntos_adicionales,na.nia_cap_maximo,na.nia_cap_puntos_xano,na.nia_cap_descripcion,na.nia_estado\r\n" + 
			",pha.pha_horas,pha.pha_puntos,pha.pha_documento,pha.pha_estado,pha.sippa_doccedula,pha.sippa_nivcodigo,pha.sippa_arecodigo,pha.sippa_titfecha,pha.pha_marca_migracion,doc.doc_codigo,doc.doc_nombre_archivo,doc.tdoc_codigo,tdoc.tdoc_codigo,	tdoc.tdoc_nombre,	tdoc.tdoc_descripcion,	tdoc.tdoc_tipo,	tdoc.dot_codigo_convocatoria\r\n" + 
			",pha.pha_duracion_anos,pha.pha_fecha_titulo,pha.pha_convalidado,pha.pha_mod_codigo "+
			",mo.mod_codigo,mo.mod_nombre,mo.sippa_mod_codigo,mo.hecaa_codigo ,pha.pha_valido,pha.pha_documento_valido,doc.doc_codigo,doc.doc_nombre_archivo,doc.tdoc_codigo,tdoc.tdoc_codigo,	tdoc.tdoc_nombre,	tdoc.tdoc_descripcion,	tdoc.tdoc_tipo,	tdoc.dot_codigo_convocatoria \r\n" + 
			"FROM persona_historia_academica pha with(nolock)\r\n" + 
			"INNER JOIN persona p with(nolock) ON(p.per_codigo=pha.per_codigo)\r\n" + 
			"LEFT JOIN institucion_educativa ie with(nolock) ON(ie.ine_codigo=pha.ine_codigo)\r\n" +
			"LEFT JOIN institucion_educativa_tipo iet ON(iet.iet_codigo=ie.iet_codigo)"+
			"LEFT JOIN municipio mie with(nolock) ON(mie.mun_codigo=ie.mun_codigo)\r\n" + 
			"LEFT JOIN departamento die with(nolock) ON(die.dep_codigo=mie.mun_codigo)\r\n" + 
			"LEFT JOIN pais pie with(nolock) ON(pie.pai_codigo=die.pai_codigo)\r\n" + 
			"LEFT JOIN jornada j with(nolock) ON(j.jor_codigo=ie.jor_codigo)\r\n" + 
			"LEFT JOIN municipio pham with(nolock) ON(pham.mun_codigo=pha.pha_ciudad)\r\n" + 
			"LEFT JOIN departamento phad with(nolock) ON(phad.dep_codigo=pham.dep_codigo)\r\n" + 
			"LEFT JOIN pais phap with(nolock) ON(phap.pai_codigo=phad.pai_codigo)\r\n" + 
			"LEFT JOIN nivel_academico na with(nolock) ON(na.nia_codigo=pha.nia_codigo)\r\n" + 
			"LEFT JOIN nivel_academico_tipo nat with(nolock) ON(nat.nat_codigo=na.nat_codigo)\r\n"+
			"LEFT JOIN modalidad mo with(nolock) ON(mo.mod_codigo=pha.pha_mod_codigo)\r\n" + 
			"LEFT JOIN sgd.documento doc with(nolock) on(pha.doc_codigo=doc.doc_codigo)\r\n" + 
			"LEFT JOIN sgd.tipo_documento tdoc with(nolock) on(tdoc.tdoc_codigo=doc.tdoc_codigo)\r\n";
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		LinkedList<Persona> lista=null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();
		System.out.println("llega");
		try {
			Object param[] = (Object[]) obj;
			 Persona persona= (Persona) param[0];
//			 persona.getHistoriaAcademica().getPersona().setCodigo(40107);
			 Usuario admin= (Usuario) param[1];
			 
			sql = new StringBuffer();
			sql.append(SQL_SELECT);
			sql.append("WHERE  p.per_codigo= ?");
			
//			conn = consegura.getconn_admin (admin);
			conn = consegura.conexionConsulta();
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			if(persona.getCodigo()>0) {
				sentencia.setInt(1, persona.getCodigo());
			}
			imp.info(sql.toString()+" "+persona);
//			imp.info("select getAll " + sql.toString()+" "+persona.getHistoriaAcademica());
//			rs=sentencia.executeQuery();
			conn.commit();
			lista  =(LinkedList<Persona>) PersonaHistoriaAcademicaRowMapper.mapRow(sentencia.executeQuery());
			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			System.out.println(" " + e.toString());
			imp.error("error "+e+ ""+SQL_SELECT.toString());
			consegura.cerrarconn(conn, null, sentencia);

		}finally {
	    	 consegura.cerrarconn(conn, null, sentencia);
	    }
		return lista;
	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getObject(java.lang.Object)
	 */
	@Override
	public Object getObject(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		LinkedList<Persona> lista=null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();

		try {
			Object param[] = (Object[]) obj;
			 Persona persona = (Persona) param[0];
//			 Usuario admin= (Usuario) param[1];	 
			sql = new StringBuffer();
			sql.append(SQL_SELECT);
			sql.append("WHERE  p.per_codigo= ? ");
			sql.append(" AND pha.pha_codigo = ? ");
			
//			conn = consegura.getconn_admin (admin);
			conn = consegura.conexionConsulta();
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			
			sentencia.setInt(1, persona.getCodigo());
			sentencia.setInt(2, persona.getHistoriaAcademica().getCodigo());
			
			imp.info("select getAll " + sql.toString()+" "+persona);
//			rs=sentencia.executeQuery();
			conn.commit();
			lista  =(LinkedList<Persona>) PersonaHistoriaAcademicaRowMapper.mapRow(sentencia.executeQuery());
			
			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, null, sentencia);

		}finally {
	    	 consegura.cerrarconn(conn, null, sentencia);
	    }
		return lista.get(0);
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
			resultado=  insertObject(obj);
		}
		if(opt==1){
			resultado=updateObject(obj);
		}
		return resultado;
	}
	
	
	private Object updateObject(Object obj){
		Connection conn = null;
		PreparedStatement sentencia=null;
		int resul=0;
		imp =Logger.getLogger(getClass().getName());
			Conexion consegura = new Conexion();
			StringBuffer sql = new StringBuffer();
		 try {
			 Object param[]=(Object[]) obj;
			 Persona persona= (Persona)param[0];
//			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
			 Usuario admin= (Usuario) param[1];
			 
			 sql.append("UPDATE persona_historia_academica ");
			 sql.append("SET ");
			 sql.append(" pha_fecha_inicio = ? ");
			 sql.append(",pha_fecha_fin = ? ");
			 sql.append(",ine_codigo = ? ");
			 sql.append(",pha_ciudad = ? ");
			 sql.append(",pha_titulo = ? ");
			 sql.append(",nia_codigo = ? ");
			 sql.append(",pha_horas = ? ");
			 sql.append(",pha_puntos = ? ");
			 sql.append(",pha_documento = ? ");
			 sql.append(",pha_estado = ? ");
//			 sql.append(",pha_marca_migracion = ? ");pha_mod_codigo,pha_valido,doc_codigo
			 sql.append(",pha_duracion_anos = ? ");
			 sql.append(",pha_fecha_titulo = ? ");
			 sql.append(",pha_convalidado = ? ");
			 sql.append(",pha_mod_codigo = ? ");
			 sql.append(",pha_valido = ? ");
			 sql.append(",doc_codigo = ? ");
			 sql.append(",pha_documento_valido = ? ");
			 sql.append("WHERE pha_codigo = ? ");
			 if(admin!=null) {
					conn = consegura.getconn_admin(admin);
				}else {
					conn = consegura.conexionEjecucion();
				}
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.prepareStatement(sql.toString());

			sentencia.setDate(1,Fecha.sumarFechasDias(new java.sql.Date(persona.getHistoriaAcademica().getFechaInicio().getTime()),0));
			sentencia.setDate(2,Fecha.sumarFechasDias(new java.sql.Date(persona.getHistoriaAcademica().getFechaFin().getTime()),0));
			
			sentencia.setInt(3,persona.getHistoriaAcademica().getInstitucionEducativa().getCodigo());
			sentencia.setInt(4,persona.getHistoriaAcademica().getMunicipio().getCodigo());
			
			sentencia.setString(5,persona.getHistoriaAcademica().getTitulo());
			sentencia.setInt(6,persona.getHistoriaAcademica().getNivelAcademico().getCodigo());
			sentencia.setString(7,persona.getHistoriaAcademica().getHoras());
			sentencia.setFloat(8,persona.getHistoriaAcademica().getPuntos());
			System.out.println(persona.getHistoriaAcademica().getPuntos());
			sentencia.setString(9,persona.getHistoriaAcademica().getDocumento());
			int estado=0;
			if(persona.getHistoriaAcademica().isEstado()) {
				estado=1;
			}
			sentencia.setInt(10,estado);
			sentencia.setInt(11,persona.getHistoriaAcademica().getDuracionAnos());
			sentencia.setDate(12,Fecha.sumarFechasDias(new java.sql.Date(persona.getHistoriaAcademica().getFechaTitulo().getTime()),0));
			if(persona.getHistoriaAcademica().isConvalidado()) {
			sentencia.setInt(13,1);
			}else {
				sentencia.setInt(13,0);
			}
			sentencia.setInt(14,persona.getHistoriaAcademica().getModalidad().getCodigo());
			if(persona.getHistoriaAcademica().isValido()) {
				sentencia.setInt(15,1);
				}else {
					sentencia.setInt(15,0);
				}
			sentencia.setInt(16,persona.getHistoriaAcademica().getDocumentosgd().getCodigo());
			 int documentovalido=0;
				if(persona.getHistoriaAcademica().isDocumentoValido()) {
					documentovalido=1;
				}
				if(persona.getHistoriaAcademica().isDocumentoRechazado()) {
					documentovalido=2;
				}
			sentencia.setInt(17,documentovalido);
			sentencia.setInt(18,persona.getHistoriaAcademica().getCodigo());
			
			resul = sentencia.executeUpdate();
			consegura.cerrarconn(conn, null, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() +""+sql.toString());
			 consegura.cerrarconn(conn, null, sentencia);

	        }finally {
	       	 consegura.cerrarconn(conn, null, sentencia);
	        }
		return resul;
	}

	private Object insertObject(Object obj){
		Connection conn = null;
		PreparedStatement sentencia=null;
		int resul=0;
		imp =Logger.getLogger(getClass().getName());
			Conexion consegura = new Conexion();
			StringBuffer sql = new StringBuffer();
		 try {
			 Object param[]=(Object[]) obj;
			 Persona persona= (Persona)param[0];
			 Usuario admin= (Usuario) param[1];
			 sql.append("INSERT INTO persona_historia_academica ");
			 sql.append("(per_codigo ,pha_fecha_inicio ,pha_fecha_fin ,ine_codigo ,pha_ciudad ,pha_titulo ,nia_codigo ");
			 sql.append(",pha_horas ,pha_puntos ,pha_documento ,pha_estado ");
//			 sql.append(",sippa_doccedula ");
//			 sql.append(",sippa_nivcodigo ");
//			 sql.append(",sippa_arecodigo ");
//			 sql.append(",sippa_titfecha ");
//			 sql.append(",pha_marca_migracion ");
			 sql.append(",pha_duracion_anos ,pha_fecha_titulo ,pha_convalidado ,pha_mod_codigo,pha_valido,doc_codigo)");
			// sql.append(",pha_archivo_md5 ,pha_content_type ) ");
			 sql.append("VALUES ");
			sql.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
			
			if(admin!=null) {
				conn = consegura.getconn_admin(admin);
			}else {
				conn = consegura.conexionEjecucion();
			}
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.prepareStatement(sql.toString());
			
			sentencia.setInt(1,persona.getCodigo());
			sentencia.setDate(2,Fecha.sumarFechasDias(new java.sql.Date(persona.getHistoriaAcademica().getFechaInicio().getTime()),0));
			sentencia.setDate(3,Fecha.sumarFechasDias(new java.sql.Date(persona.getHistoriaAcademica().getFechaFin().getTime()),0));
			sentencia.setInt(4,persona.getHistoriaAcademica().getInstitucionEducativa().getCodigo());
			sentencia.setInt(5,persona.getHistoriaAcademica().getMunicipio().getCodigo());
			sentencia.setString(6,persona.getHistoriaAcademica().getTitulo());
			sentencia.setInt(7,persona.getHistoriaAcademica().getNivelAcademico().getCodigo());
			sentencia.setString(8,persona.getHistoriaAcademica().getHoras());
			sentencia.setFloat(9,persona.getHistoriaAcademica().getPuntos());
			sentencia.setString(10,persona.getHistoriaAcademica().getDocumento());
			int estado=0;
			if(persona.getHistoriaAcademica().isEstado()) {
				estado=1;
			}
			sentencia.setInt(11,estado);
			sentencia.setInt(12,persona.getHistoriaAcademica().getDuracionAnos());
			sentencia.setDate(13,Fecha.sumarFechasDias(new java.sql.Date(persona.getHistoriaAcademica().getFechaTitulo().getTime()),0));
			if(persona.getHistoriaAcademica().isConvalidado()) {
				sentencia.setInt(14,1);
				}else {
					sentencia.setInt(14,0);
				}
			sentencia.setInt(15,persona.getHistoriaAcademica().getModalidad().getCodigo());
			
			if(persona.getHistoriaAcademica().isValido()) {
				sentencia.setInt(16,1);
				}else {
					sentencia.setInt(16,0);
				}
			sentencia.setInt(17,persona.getHistoriaAcademica().getDocumentosgd().getCodigo());
			
			resul = sentencia.executeUpdate();
			consegura.cerrarconn(conn, null, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() +""+sql.toString());
			 consegura.cerrarconn(conn, null, sentencia);

	        }finally {
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
