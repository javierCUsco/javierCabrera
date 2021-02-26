/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.PersonaHistoriaLaboralRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.PersonaHistoriaLaboral;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PersonaHistoriaLaboralDB implements ConexionDB {

	private Logger imp ;
//	private String SQL_SELECT="select p.per_codigo,phl.phl_codigo,phl.phl_fecha_inicio,phl.phl_fecha_fin,phl.phl_empresa,phl.phl_empresa_direccion,phl.phl_empresa_telefono,\r\n" + 
//			"hlt.hlt_codigo,hlt.hlt_nombre,hlt.hlt_cap_estado,m.mun_codigo,m.mun_id,m.mun_nombre,\r\n" + 
//			"m.dep_codigo,d.dep_codigo,d.dep_acronimo,d.dep_nombre ,\r\n" + 
//			"d.pai_codigo,pai.pai_codigo,pai.pai_acronimo,pai.pai_nombre,pai.sippa_pai_codigo,pai.dane_codigo ,pai.pai_codigo_hecaa \r\n" + 
//			",d.sippa_dep_codigo,d.dane_codigo,\r\n" + 
//			"m.sippa_mun_codigo,m.SNIES_codigo,m.dane_codigo,\r\n" + 
//			"phl.phl_cargo,phl.phl_descripcion,ded.ded_codigo,ded.ded_nombre,ded.ded_orden_snies,ded.sippa_dedcodigo,ded.ded_codigo_hecaa,vin.vin_codigo,vin.vin_nombre,vin.vin_horas_year"+
//			",vin.vin_clase,vin.sippa_vincodigo,vin.vin_contratacion,phl.phl_grupo,phl.phl_Cv_Lac,phl.phl_Grup_Lac,phl.phl_puntos,phl.phl_documento,phl.phl_valido,phl.doc_codigo   \r\n" + 
//			"from persona_historia_laboral phl with(nolock) \r\n" + 
//			"left join persona p with(nolock) on (p.per_codigo=phl.per_codigo) \r\n" + 
//			"left join historia_laboral_tipo hlt with(nolock) on (hlt.hlt_codigo=phl.hlt_codigo) \r\n" + 
//			"left join municipio m with(nolock) on (m.mun_codigo=phl.mun_codigo) \r\n" + 
//			"left join departamento d with(nolock) on (d.dep_codigo= m.dep_codigo) \r\n" + 
//			"left join pais pai with(nolock) on (pai.pai_codigo=d.pai_codigo) \r\n" + 
//			"left join vinculacion vin with(nolock) on(vin.vin_codigo=phl.vin_codigo)  \r\n" + 
//			"left join dedicacion ded with(nolock) on(ded.ded_codigo=phl.ded_codigo) ";
	private String SQL_SELECT="\r\n" + 
			"select p.per_codigo,phl.phl_codigo,phl.phl_fecha_inicio,phl.phl_fecha_fin,phl.phl_empresa,phl.phl_empresa_direccion,phl.phl_empresa_telefono,\r\n" + 
			"hlt.hlt_codigo,hlt.hlt_nombre,hlt.hlt_cap_estado,m.mun_codigo,m.mun_id,m.mun_nombre,\r\n" + 
			"m.dep_codigo,d.dep_codigo,d.dep_acronimo,d.dep_nombre ,\r\n" + 
			"d.pai_codigo,pai.pai_codigo,pai.pai_acronimo,pai.pai_nombre,pai.sippa_pai_codigo,pai.dane_codigo ,pai.pai_codigo_hecaa \r\n" + 
			",d.sippa_dep_codigo,d.dane_codigo,\r\n" + 
			"m.sippa_mun_codigo,m.SNIES_codigo,m.dane_codigo,phl_fecha_registro,\r\n" + 
			"phl.phl_cargo,phl.phl_descripcion,ded.ded_codigo,ded.ded_nombre,ded.ded_orden_snies,ded.sippa_dedcodigo,ded.ded_codigo_hecaa,vin.vin_codigo,vin.vin_nombre,vin.vin_horas_year\r\n" + 
			",vin.vin_clase,vin.sippa_vincodigo,vin.vin_contratacion,phl.phl_grupo,phl.phl_Cv_Lac,phl.phl_Grup_Lac,phl.phl_puntos,phl.phl_valido,phl.doc_codigo,\r\n" + 
			"doc.doc_codigo,doc.doc_contenido,doc.uap_codigo,doc.tdoc_codigo,doc.doc_url,doc.doc_extension,doc.doc_estado,doc.doc_fecha_creado,doc.doc_cod_retencion,doc.per_codigo,doc.doc_ip,doc.doc_cliente,doc.doc_sesion,doc.doc_encriptado,doc.doc_eliminado,doc.doc_enter,doc.esta_codigo,doc.doc_clasificacion,doc.mod_codigo,doc.per_convocatoria,\r\n" + 
			"tdoc.tdoc_codigo,tdoc.tdoc_nombre,tdoc.tdoc_descripcion,tdoc.tdoc_tipo,mo.mod_codigo,mo.mod_nombre,mo.mod_orden, phl.phl_documento_valido ,doc.doc_codigo,doc.doc_nombre_archivo,doc.tdoc_codigo,tdoc.tdoc_codigo,	tdoc.tdoc_nombre,	tdoc.tdoc_descripcion,	tdoc.tdoc_tipo,	tdoc.dot_codigo_convocatoria\r\n" + 
			"from persona_historia_laboral phl with(nolock) \r\n" + 
			"LEFT JOIN persona p with(nolock) on (p.per_codigo=phl.per_codigo) \r\n" + 
			"LEFT JOIN historia_laboral_tipo hlt with(nolock) on (hlt.hlt_codigo=phl.hlt_codigo) \r\n" + 
			"LEFT JOIN municipio m with(nolock) on (m.mun_codigo=phl.mun_codigo) \r\n" + 
			"LEFT JOIN departamento d with(nolock) on (d.dep_codigo= m.dep_codigo) \r\n" + 
			"LEFT JOIN pais pai with(nolock) on (pai.pai_codigo=d.pai_codigo) \r\n" + 
			"LEFT JOIN vinculacion vin with(nolock) on(vin.vin_codigo=phl.vin_codigo)  \r\n" + 
			"LEFT JOIN dedicacion ded with(nolock) on(ded.ded_codigo=phl.ded_codigo) \r\n" + 
			"LEFT JOIN sgd.documento doc with(nolock) on (doc.doc_codigo=phl.doc_codigo)\r\n" + 
			"LEFT JOIN sgd.tipo_documento tdoc with(nolock) on(tdoc.tdoc_codigo=doc.tdoc_codigo)\r\n" + 
			"LEFT JOIN uaa_personal uap with(nolock) on(uap.uap_codigo=doc.uap_codigo)\r\n" + 
			"LEFT JOIN modulo mo with(nolock) on(mo.mod_codigo=doc.mod_codigo) " ;
//			"LEFT JOIN sgd.documento doc with(nolock) on(phl.doc_codigo=doc.doc_codigo)\r\n" + 
//			"LEFT JOIN sgd.tipo_documento tdoc with(nolock) on(tdoc.tdoc_codigo=doc.tdoc_codigo)\r\n";
	
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
		try {
			Object param[] = (Object[]) obj;
			 Persona persona= (Persona) param[0];
			 Usuario admin= (Usuario) param[1];
			sql = new StringBuffer();
			sql.append(SQL_SELECT);
			sql.append("WHERE p.per_codigo= ?");
//			conn = consegura.getconn_admin (admin);
			conn=consegura.conexionConsulta();
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			if(persona.getCodigo()>0) {
				sentencia.setInt(1, persona.getCodigo());
			}
//			System.out.println("sql  "+ sql.toString());
			imp.info("select getAll " + sql.toString()+" "+persona);
//			rs=sentencia.executeQuery();
			conn.commit();
			lista  =(LinkedList<Persona>) PersonaHistoriaLaboralRowMapper.mapRow(sentencia.executeQuery());
			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			imp.error("" + e.toString()+" "+ sql.toString());
//			System.out.println("error " + e.toString()+" "+ sql.toString());
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
		LinkedList<PersonaHistoriaLaboral> lista=null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();
		try {
			Object param[] = (Object[]) obj;
			 Persona persona= (Persona) param[0];
			 imp.info("select getObject " + " "+persona);
			 Usuario admin= (Usuario) param[1];	 
			sql = new StringBuffer();
			sql.append(SQL_SELECT);
			sql.append("WHERE  p.per_codigo= ? ");
			sql.append(" AND phl.phl_codigo = ? ");
			
			if(admin!=null) {
				conn = consegura.getconn_admin(admin);
			}else {
				conn = consegura.conexionConsulta();
			}
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			
			sentencia.setInt(1, persona.getCodigo());
			sentencia.setInt(2, persona.getHistoriaLaboral().getCodigo());
			
			imp.info("select getObject " + sql.toString()+" "+persona);
//			rs=sentencia.executeQuery();
			System.out.println(" " + sql.toString());
			conn.commit();
			lista  =(LinkedList<PersonaHistoriaLaboral>) PersonaHistoriaLaboralRowMapper.mapRow(sentencia.executeQuery());
			
			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString()+" "+ SQL_SELECT.toString());
//			System.out.println("error " + e.toString()+" "+ SQL_SELECT.toString());
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
		System.out.println("param"+param[2]);
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
			 Usuario admin= (Usuario) param[1];
			 sql.append("UPDATE persona_historia_laboral ");
			 //sql.append("SET per_codigo =  ? ");
			 sql.append("SET phl_fecha_inicio =  ? ");
			 sql.append(",phl_fecha_fin =  ? ");
			 sql.append(",phl_empresa =  ? ");
			 sql.append(",phl_empresa_direccion =  ? ");
			 sql.append(",phl_empresa_telefono =  ? ");
			 sql.append(",mun_codigo =  ? ");
			 sql.append(",hlt_codigo =  ? ");
			 sql.append(",ded_codigo =  ? ");
			 sql.append(",vin_codigo =  ? ");
			 sql.append(",phl_cargo =  ? ");
			 sql.append(",phl_descripcion =  ? ");
			 sql.append(",phl_valido = ? ");
			 sql.append(",phl_grupo =  ? ");
			 sql.append(",phl_Cv_Lac =  ? ");
			 sql.append(",phl_Grup_Lac =  ? ");
			 sql.append(",phl_puntos =  ? ");
			 sql.append(",doc_codigo =  ? ");
			 sql.append(",phl_documento_valido = ? ");
//			 sql.append(",phl_fecha_registro = <phl_fecha_registro, datetime,>
			 sql.append("WHERE phl_codigo = ? AND per_codigo = ? ");
			 
			 if(admin!=null) {
					conn = consegura.getconn_admin(admin);
				}else {
					conn = consegura.conexionEjecucion();
				}
			
			imp.info("valida el usuario "+sql.toString());
			System.out.println("valida el usuario "+sql.toString());
			sentencia = conn.prepareStatement(sql.toString());
//			sentencia.setInt(1,personaHistoriaAcademica.getPersona().getCodigo());
			System.out.println("param"+sql.toString());
			sentencia = conn.prepareStatement(sql.toString());
			
			System.out.println(persona.getCodigo());
			System.out.println(Fecha.sumarFechasDias(new java.sql.Date(persona.getHistoriaLaboral().getFechaInicio().getTime()),1));
			System.out.println(Fecha.sumarFechasDias(new java.sql.Date(persona.getHistoriaLaboral().getFechaFin().getTime()),1));
			System.out.println(persona.getHistoriaLaboral().getEmpresa());
			System.out.println(persona.getHistoriaLaboral().getEmpresaDireccion());
			System.out.println(persona.getHistoriaLaboral().getEmpresaTelefono());
			System.out.println(persona.getHistoriaLaboral().getMunicipio().getCodigo());
			System.out.println(persona.getHistoriaLaboral().getHistoriaLaboralTipo().getCodigo());
			System.out.println(persona.getHistoriaLaboral().getDedicacion().getCodigo());
			System.out.println(persona.getHistoriaLaboral().getVinculacion().getCodigo());
			System.out.println(persona.getHistoriaLaboral().getCargo());
			System.out.println(persona.getHistoriaLaboral().getDescripcion());
			int valido=0;
			if(persona.getHistoriaLaboral().getValido()) {
				valido=1;
			}
			System.out.println(valido);
			System.out.println(persona.getHistoriaLaboral().getGrupo());
			System.out.println(persona.getHistoriaLaboral().getCvLac());
			System.out.println(persona.getHistoriaLaboral().getGrupLac());
			System.out.println(persona.getHistoriaLaboral().getPuntos());
			System.out.println("documento codigo "+persona.getHistoriaLaboral().getDocumento().getCodigo());
			System.out.println(persona.getCodigo());
			//ahata aca
			
			sentencia.setDate(1,Fecha.sumarFechasDias(new java.sql.Date(persona.getHistoriaLaboral().getFechaInicio().getTime()),1));
			sentencia.setDate(2,Fecha.sumarFechasDias(new java.sql.Date(persona.getHistoriaLaboral().getFechaFin().getTime()),1));
			sentencia.setString(3,persona.getHistoriaLaboral().getEmpresa());
			sentencia.setString(4,persona.getHistoriaLaboral().getEmpresaDireccion());
			sentencia.setString(5,persona.getHistoriaLaboral().getEmpresaTelefono());
			sentencia.setInt(6,persona.getHistoriaLaboral().getMunicipio().getCodigo());
			sentencia.setInt(7,persona.getHistoriaLaboral().getHistoriaLaboralTipo().getCodigo());
			sentencia.setInt(8,persona.getHistoriaLaboral().getDedicacion().getCodigo());
			sentencia.setInt(9,persona.getHistoriaLaboral().getVinculacion().getCodigo());
			sentencia.setString(10,persona.getHistoriaLaboral().getCargo());
			sentencia.setString(11,persona.getHistoriaLaboral().getDescripcion());
			 valido=0;
			if(persona.getHistoriaLaboral().getValido()) {
				valido=1;
			}
			sentencia.setInt(12,valido);
			
			sentencia.setString(13,persona.getHistoriaLaboral().getGrupo());
			sentencia.setString(14,persona.getHistoriaLaboral().getCvLac());
			sentencia.setString(15,persona.getHistoriaLaboral().getGrupLac());

			sentencia.setFloat(16,persona.getHistoriaLaboral().getPuntos());

			sentencia.setInt(17,persona.getHistoriaLaboral().getDocumento().getCodigo());
			 int documentovalido=0;
				if(persona.getHistoriaLaboral().isDocumentoValido()) {
					documentovalido=1;
				}if(persona.getHistoriaLaboral().isDocumentoRechazado()) {
					documentovalido=2;
				}
			sentencia.setInt(18,documentovalido);
			sentencia.setInt(19,persona.getHistoriaLaboral().getCodigo());
			sentencia.setInt(20,persona.getCodigo());
			
			resul = sentencia.executeUpdate();
			consegura.cerrarconn(conn, null, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() +""+sql.toString());
			 consegura.cerrarconn(conn, null, sentencia);
			 //System.out.println("valida el usuario "+"  "+e+" "+sql.toString());
	        }
		 finally {
	        	consegura.cerrarconn(conn, null, sentencia);
	        }
		 imp.info("resultado de la actualizacion "+resul);
		// System.out.println("resultado de la actualizacion "+resul);
		return resul;
	}
/**
 * 
 * @param obj
 * @return
 */
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
			 System.out.println("param"+admin);
			 sql.append("INSERT INTO persona_historia_laboral(per_codigo,phl_fecha_inicio,phl_fecha_fin,phl_empresa,phl_empresa_direccion,phl_empresa_telefono ");
			 sql.append(",mun_codigo,hlt_codigo,ded_codigo,vin_codigo,phl_cargo,phl_descripcion,phl_valido,phl_grupo,phl_Cv_Lac");
			 sql.append(",phl_Grup_Lac,phl_puntos,doc_codigo,phl_fecha_registro)VALUES  ");
			sql.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, (select GETDATE()) )");
			
			 if(admin!=null) {
					conn = consegura.getconn_admin(admin);
				}else {
					conn = consegura.conexionEjecucion();
				}
			imp.info("valida el usuario "+sql.toString());
			System.out.println("param"+sql.toString());
			sentencia = conn.prepareStatement(sql.toString());
			
//			System.out.println(persona.getCodigo());
//			System.out.println(Fecha.sumarFechasDias(new java.sql.Date(persona.getHistoriaLaboral().getFechaInicio().getTime()),1));
//			System.out.println(Fecha.sumarFechasDias(new java.sql.Date(persona.getHistoriaLaboral().getFechaFin().getTime()),1));
//			System.out.println(persona.getHistoriaLaboral().getEmpresa());
//			System.out.println(persona.getHistoriaLaboral().getEmpresaDireccion());
//			System.out.println(persona.getHistoriaLaboral().getEmpresaTelefono());
//			System.out.println(persona.getHistoriaLaboral().getMunicipio().getCodigo());
//			System.out.println(persona.getHistoriaLaboral().getHistoriaLaboralTipo().getCodigo());
//			System.out.println(persona.getHistoriaLaboral().getDedicacion().getCodigo());
//			System.out.println(persona.getHistoriaLaboral().getVinculacion().getCodigo());
//			System.out.println(persona.getHistoriaLaboral().getCargo());
//			System.out.println(persona.getHistoriaLaboral().getDescripcion());
			int valido=0;
			if(persona.getHistoriaLaboral().getValido()) {
				valido=1;
			}
//			System.out.println(valido);
//			
//			System.out.println(persona.getHistoriaLaboral().getGrupo());
//			System.out.println(persona.getHistoriaLaboral().getCvLac());
//			System.out.println(persona.getHistoriaLaboral().getGrupLac());
//
//			System.out.println(persona.getHistoriaLaboral().getPuntos());
//
//			System.out.println(persona.getHistoriaLaboral().getDocumento().getCodigo());
			//ahata aca
			
			sentencia.setInt(1,persona.getCodigo());
			sentencia.setDate(2,Fecha.sumarFechasDias(new java.sql.Date(persona.getHistoriaLaboral().getFechaInicio().getTime()),1));
			sentencia.setDate(3,Fecha.sumarFechasDias(new java.sql.Date(persona.getHistoriaLaboral().getFechaFin().getTime()),1));
			sentencia.setString(4,persona.getHistoriaLaboral().getEmpresa());
			sentencia.setString(5,persona.getHistoriaLaboral().getEmpresaDireccion());
			sentencia.setString(6,persona.getHistoriaLaboral().getEmpresaTelefono());
			sentencia.setInt(7,persona.getHistoriaLaboral().getMunicipio().getCodigo());
			sentencia.setInt(8,persona.getHistoriaLaboral().getHistoriaLaboralTipo().getCodigo());
			sentencia.setInt(9,persona.getHistoriaLaboral().getDedicacion().getCodigo());
			sentencia.setInt(10,persona.getHistoriaLaboral().getVinculacion().getCodigo());
			sentencia.setString(11,persona.getHistoriaLaboral().getCargo());
			sentencia.setString(12,persona.getHistoriaLaboral().getDescripcion());
			 valido=0;
			if(persona.getHistoriaLaboral().getValido()) {
				valido=1;
			}
			sentencia.setInt(13,valido);
			
			sentencia.setString(14,persona.getHistoriaLaboral().getGrupo());
			sentencia.setString(15,persona.getHistoriaLaboral().getCvLac());
			sentencia.setString(16,persona.getHistoriaLaboral().getGrupLac());

			sentencia.setFloat(17,persona.getHistoriaLaboral().getPuntos());

			sentencia.setInt(18,persona.getHistoriaLaboral().getDocumento().getCodigo());
//			sentencia.setString(19,personaHistoriaLaboral.getGrupLac());
			
		
			
			
			resul = sentencia.executeUpdate();
			
			consegura.cerrarconn(conn, null, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() +""+sql.toString());
			 consegura.cerrarconn(conn, null, sentencia);
			 
	        }finally {
	        	consegura.cerrarconn(conn, null, sentencia);
	        }
		 imp.info("resultado de la insertar "+resul);
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
