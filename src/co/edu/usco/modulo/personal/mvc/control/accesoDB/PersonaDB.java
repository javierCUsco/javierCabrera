/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.PersonaRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.control.logica.FechaLog;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PersonaDB implements ConexionDB {
	private Logger imp;
	private String SQL_SELECT = "\r\n" + "SELECT  p.per_codigo,p.per_identificacion,p.tii_codigo,\r\n"
			+ "ti.tii_codigo,ti.tii_nombre,ti.tii_nombre_corto,ti.snies_codigo,ti.spadies_codigo,ti.observatorio_laboral,ti.linix_codigo,ti.tii_estado,ti.tii_num_caracteres,ti.tii_codigo_hecaa,\r\n"
			+ "p.per_libreta_militar,p.per_apellido1 ,COALESCE(p.per_apellido2,'') AS per_apellido2,p.per_nombre1 ,COALESCE(p.per_nombre2,'') AS per_nombre2 ,coalesce(p.per_genero,'') as per_genero \r\n"
			+ ",p.per_lugar_expedicion,COALESCE(ec.esc_codigo, 0) as esc_codigo,COALESCE(ec.esc_nombre,'') as esc_nombre,COALESCE(ec.sippa_esc_codigo,0) as sippa_esc_codigo ,COALESCE(ec.SNIES_codigo,'') as SNIES_codigo,COALESCE(ec.esc_codigo_hecaa,0) as esc_codigo_hecaa,\r\n"
			+ "mn.mun_codigo AS mnc,mn.mun_id AS mni,COALESCE(mn.mun_nombre,'Municipio Nacimiento') AS mnn,mn.dep_codigo AS mnd,mn.sippa_mun_codigo AS smnc,mn.SNIES_codigo AS mnsc,mn.dane_codigo AS mndc,\r\n"
			+ "dn.dep_codigo AS dnc,dn.dep_acronimo AS dna,COALESCE(dn.dep_nombre,'') AS dnn,dn.pai_codigo AS dnpc,dn.sippa_dep_codigo AS sdnc,dn.dane_codigo AS dndc,\r\n"
			+ "pn.pai_codigo AS pnc,pn.pai_acronimo AS pna,COALESCE(pn.pai_nombre,'') AS pnn,pn.sippa_pai_codigo AS spnc,pn.dane_codigo AS pndc,pn.pai_codigo_hecaa AS pnch,\r\n"
			+ "me.mun_codigo AS mec,me.mun_id AS mei,COALESCE(me.mun_nombre,'Lugar expedicion') AS men,me.dep_codigo AS med,me.sippa_mun_codigo AS smec,me.SNIES_codigo AS mesc,me.dane_codigo AS medc,\r\n"
			+ "de.dep_codigo AS dec,de.dep_acronimo AS dea,COALESCE(de.dep_nombre,'') AS den,de.pai_codigo AS depc,de.sippa_dep_codigo AS sdec,de.dane_codigo AS dedc,\r\n"
			+ "pe.pai_codigo AS pec,pe.pai_acronimo AS pea,COALESCE(pe.pai_nombre,'') AS pen,pe.sippa_pai_codigo AS spec,pe.dane_codigo AS pedc,pe.pai_codigo_hecaa AS pech,\r\n"
			+ "mr.mun_codigo AS mrc,mr.mun_id AS mri,COALESCE(mr.mun_nombre,'Lugar recidencia') AS mrn,mr.dep_codigo AS mrd,mr.sippa_mun_codigo AS smrc,mr.SNIES_codigo AS mrsc,mr.dane_codigo AS mrdc,\r\n"
			+ "dr.dep_codigo AS drc,dr.dep_acronimo AS dra,COALESCE(dr.dep_nombre,'') AS drn,dr.pai_codigo AS drpc,dr.sippa_dep_codigo AS sdrc,dr.dane_codigo AS drdc,\r\n"
			+ "pr.pai_codigo AS prc,pr.pai_acronimo AS pra,COALESCE(pr.pai_nombre,'') AS prn,pr.sippa_pai_codigo AS sprc,pr.dane_codigo AS prdc,pr.pai_codigo_hecaa AS prch,\r\n"
			+ "mfr.mun_codigo AS mfrc,mr.mun_id AS mfri,coalesce(mfr.mun_nombre,'') AS mfrn,mfr.dep_codigo AS mfrd,mfr.sippa_mun_codigo AS smfrc,mfr.SNIES_codigo AS mfrsc,mfr.dane_codigo AS mfrdc,\r\n"  
			+ "dfr.dep_codigo AS dfrc,dfr.dep_acronimo AS dfra,coalesce(dfr.dep_nombre,'')  AS dfrn,dfr.pai_codigo AS dfrpc,dfr.sippa_dep_codigo AS sdfrc,dfr.dane_codigo AS dfrdc,\r\n" 
			+ "pfr.pai_codigo AS pfrc,pfr.pai_acronimo AS pfra,coalesce(pfr.pai_nombre,'')  AS pfrn,pfr.sippa_pai_codigo AS spfrc,pfr.dane_codigo AS pfrdc,pfr.pai_codigo_hecaa AS pfrch\r\n"  
			
			+ ",p.per_fecha_nacimiento,p.per_direccion_residencia,p.per_telefono_movil,p.per_telefono_fijo,p.per_estado_civil,p.per_lugar_nacimiento,p.per_lugar_residencia,p.per_barrio  \r\n"
			+ ",coalesce(p.per_estado,0) as per_estado,p.eps_codigo,p.eta_codigo,p.per_numero_afiliacion_eps, coalesce(p.per_familiar_direccion,'') as per_familiar_direccion,coalesce(p.per_familiar_nombre,'') as per_familiar_nombre,coalesce(p.per_familiar_telefono,'') as per_familiar_telefono, coalesce(p.per_familiar_lugar_residencia ,0) as per_familiar_lugar_residencia ,p.per_email,p.per_email_interno,p.per_pagina_personal \r\n"
			+ ",p.grs_codigo,gs.grs_codigo,gs.grs_nombre,COALESCE(gs.sippa_grs_codigo,0) AS sippa_grs_codigo,COALESCE(ec.esc_codigo, 0) as esc_codigo,COALESCE(ec.esc_nombre,'') as esc_nombre,COALESCE(ec.sippa_esc_codigo,0) as sippa_esc_codigo ,COALESCE(ec.SNIES_codigo,'') as SNIES_codigo,COALESCE(ec.esc_codigo_hecaa,0) as esc_codigo_hecaa,\r\n"
			+ "p.Expr1,p.nat_codigo,p.reg_codigo,p.per_razon_social,p.per_identificacion_dup,p.per_codigo_pais_hecaa,COALESCE(p.per_estrato,'0') AS per_estrato,p.per_fecha_expedicion, "+EstratoDB.COLUMNAS+"  \r\n"
			+ " , docente=0,  docente_vinculacion='', administrativo=0, administrativo_vinculacion='',estudiante =0, e.eps_codigo,e.eps_nombre,e.eps_prestador \n"
			+ "FROM persona_usco p with(nolock) \r\n"
			+ "left join tipo_id ti with(nolock) on(ti.tii_codigo= p.tii_codigo)  \r\n" + "\r\n"
			+ "left join municipio  me with(nolock) on(me .mun_codigo=p.per_lugar_expedicion) \r\n"
			+ "left join departamento de  with(nolock) on(de .dep_codigo=me .dep_codigo) \r\n"
			+ "left join pais pe (nolock) on (pe .pai_codigo=de .pai_codigo)\r\n" + "\r\n"
			+ "left join estado_civil ec with(nolock) ON(p.per_estado_civil=ec.esc_codigo)\r\n" + "\r\n"
			+ "left join municipio  mn with(nolock) on(mn.mun_codigo=p.per_lugar_nacimiento) \r\n"
			+ "left join departamento dn with(nolock) on(dn.dep_codigo=mn.dep_codigo) \r\n"
			+ "left join pais pn with(nolock) on (pn.pai_codigo=dn.pai_codigo)\r\n" + "\r\n"
			+ "left join municipio  mr with(nolock) on(mr.mun_codigo=p.per_lugar_residencia) \r\n"
			+ "left join departamento dr with(nolock) on(dr.dep_codigo=mr.dep_codigo) \r\n"
			+ "left join pais pr with(nolock) on (pr.pai_codigo=dr.pai_codigo)\r\n" + "\r\n"
			+ "left join municipio  mfr with(nolock) on(mfr.mun_codigo=p.per_familiar_lugar_residencia) \r\n" 
			+ "left join departamento dfr with(nolock) on(dfr.dep_codigo=mfr.dep_codigo) \r\n" 
			+ "left join pais pfr with(nolock) on (pfr.pai_codigo=dfr.pai_codigo)"
			+ "inner join grupo_sanguineo gs with(nolock) ON(p.grs_codigo =gs.grs_codigo )\r\n"
			+ "left join snies_estrato se on(se.ses_codigo=p.per_estrato) \r\n" 
			
			+ "left join eps e  with(nolock) on(e.eps_codigo=p.eps_codigo) ";
	
	private String SQL_SELECT_TEMP = "DECLARE @tempotalb TABLE (per_codigo int,docente int, docente_vinculacion nvarchar(50), administrativo int, administrativo_vinculacion nvarchar(50), estudiante  nvarchar(50))\r\n" + 
			"insert into @tempotalb (per_codigo )\r\n" + 
			"select p.per_codigo from persona_usco p \r\n " ;
			//"inner join uaa_personal up on(up.per_codigo=p.per_codigo)\r\n" ;
			
	private String SQL_SELECT_USCO ="UPDATE @tempotalb SET estudiante=e.est_codigo \r\n" + 
			" from @tempotalb tem , estudiante e \r\n" + 
			" where e.per_codigo=tem.per_codigo\r\n" + 
			"  UPDATE @tempotalb SET docente=vdocente.uap_codigo,docente_vinculacion=vdocente.vin_nombre\r\n" + 
			" from @tempotalb tem, (select top 1  up.uap_codigo, up.per_codigo,v.vin_nombre from @tempotalb tem2\r\n" + 
			" inner join uaa_personal up on (tem2.per_codigo=up.per_codigo)\r\n" + 
			" inner join vinculacion v on(v.vin_codigo=up.vin_codigo)\r\n" + 
			" where tem2.per_codigo=up.per_codigo  and up.uap_cargo=3 order by v.vin_codigo) vdocente where tem.per_codigo=vdocente.per_codigo\r\n" + 
			"UPDATE @tempotalb SET administrativo=vdocente.uap_codigo,administrativo_vinculacion=vdocente.vin_nombre\r\n" + 
			" from @tempotalb tem, (select top 1  up.uap_codigo, up.per_codigo,v.vin_nombre from @tempotalb tem2\r\n" + 
			" inner join uaa_personal up on (tem2.per_codigo=up.per_codigo)\r\n" + 
			" inner join uaa_cargo uc on(uc.uac_codigo=up.uac_codigo)\r\n" + 
			" inner join vinculacion v on(v.vin_codigo=uc.uac_vinculacion)\r\n" + 
			" where tem2.per_codigo=up.per_codigo order by v.vin_codigo) vdocente where tem.per_codigo=vdocente.per_codigo "; 
			
private String SQL_SELECT_PERSONA ="select p.per_codigo,p.per_identificacion,p.tii_codigo,\r\n" 
			+ "ti.tii_codigo,ti.tii_nombre,ti.tii_nombre_corto,ti.snies_codigo,ti.spadies_codigo,ti.observatorio_laboral,ti.linix_codigo,ti.tii_estado,ti.tii_num_caracteres,ti.tii_codigo_hecaa,\n" 
			+ "p.per_libreta_militar,p.per_apellido1 ,COALESCE(p.per_apellido2,'') AS per_apellido2,p.per_nombre1 ,COALESCE(p.per_nombre2,'') AS per_nombre2 ,coalesce(p.per_genero,'') as per_genero,coalesce(p.per_familiar_lugar_residencia ,0) as per_familiar_lugar_residencia \n"  
			+ ",p.per_lugar_expedicion,COALESCE(ec.esc_codigo, 0) as esc_codigo,COALESCE(ec.esc_nombre,'') as esc_nombre,COALESCE(ec.sippa_esc_codigo,0) as sippa_esc_codigo ,COALESCE(ec.SNIES_codigo,'') as SNIES_codigo,COALESCE(ec.esc_codigo_hecaa,0) as esc_codigo_hecaa,\n" 
			+ "mn.mun_codigo AS mnc,mn.mun_id AS mni,mn.mun_nombre AS mnn,mn.dep_codigo AS mnd,mn.sippa_mun_codigo AS smnc,mn.SNIES_codigo AS mnsc,mn.dane_codigo AS mndc,\n" 
			+ "dn.dep_codigo AS dnc,dn.dep_acronimo AS dna,dn.dep_nombre AS dnn,dn.pai_codigo AS dnpc,dn.sippa_dep_codigo AS sdnc,dn.dane_codigo AS dndc,\n" 
			+ "pn.pai_codigo AS pnc,pn.pai_acronimo AS pna,pn.pai_nombre AS pnn,pn.sippa_pai_codigo AS spnc,pn.dane_codigo AS pndc,pn.pai_codigo_hecaa AS pnch,\r\n" 
			+ "me.mun_codigo AS mec,me.mun_id AS mei,me.mun_nombre AS men,me.dep_codigo AS med,me.sippa_mun_codigo AS smec,me.SNIES_codigo AS mesc,me.dane_codigo AS medc,\n" 
			+ "de.dep_codigo AS dec,de.dep_acronimo AS dea,de.dep_nombre AS den,de.pai_codigo AS depc,de.sippa_dep_codigo AS sdec,de.dane_codigo AS dedc,\n"
			+ "pex.pai_codigo AS pec,pex.pai_acronimo AS pea,pex.pai_nombre AS pen,pex.sippa_pai_codigo AS spec,pex.dane_codigo AS pedc,pex.pai_codigo_hecaa AS pech,\n" 
			+ "mr.mun_codigo AS mrc,mr.mun_id AS mri,mr.mun_nombre AS mrn,mr.dep_codigo AS mrd,mr.sippa_mun_codigo AS smrc,mr.SNIES_codigo AS mrsc,mr.dane_codigo AS mrdc,\n" 
			+ "dr.dep_codigo AS drc,dr.dep_acronimo AS dra,dr.dep_nombre AS drn,dr.pai_codigo AS drpc,dr.sippa_dep_codigo AS sdrc,dr.dane_codigo AS drdc,\n"
			+ "pr.pai_codigo AS prc,pr.pai_acronimo AS pra,pr.pai_nombre AS prn,pr.sippa_pai_codigo AS sprc,pr.dane_codigo AS prdc,pr.pai_codigo_hecaa AS prch,\n"
			+ "mfr.mun_codigo AS mfrc,mr.mun_id AS mfri,coalesce(mfr.mun_nombre,'') AS mfrn,mfr.dep_codigo AS mfrd,mfr.sippa_mun_codigo AS smfrc,mfr.SNIES_codigo AS mfrsc,mfr.dane_codigo AS mfrdc,\r\n"  
			+ "dfr.dep_codigo AS dfrc,dfr.dep_acronimo AS dfra,coalesce(dfr.dep_nombre,'')  AS dfrn,dfr.pai_codigo AS dfrpc,dfr.sippa_dep_codigo AS sdfrc,dfr.dane_codigo AS dfrdc,\r\n" 
			+ "pfr.pai_codigo AS pfrc,pfr.pai_acronimo AS pfra,coalesce(pfr.pai_nombre,'')  AS pfrn,pfr.sippa_pai_codigo AS spfrc,pfr.dane_codigo AS pfrdc,pfr.pai_codigo_hecaa AS pfrch\r\n"
			+ ",p.per_fecha_nacimiento,p.per_direccion_residencia,p.per_telefono_movil,p.per_telefono_fijo,p.per_estado_civil,p.per_lugar_nacimiento,p.per_lugar_residencia,p.per_barrio  \n" 
			+ ",coalesce(p.per_estado,0) as per_estado,p.eps_codigo,p.eta_codigo,p.per_numero_afiliacion_eps,coalesce(p.per_familiar_direccion,'') as per_familiar_direccion,coalesce(p.per_familiar_nombre,'') as per_familiar_nombre,coalesce(p.per_familiar_telefono,'') as per_familiar_telefono, p.per_familiar_lugar_residencia,p.per_email,p.per_email_interno,p.per_pagina_personal \n" 
			+ ",p.grs_codigo,gs.grs_codigo,gs.grs_nombre,COALESCE(gs.sippa_grs_codigo,0) AS sippa_grs_codigo,COALESCE(ec.esc_codigo, 0) as esc_codigo,COALESCE(ec.esc_nombre,'') as esc_nombre,COALESCE(ec.sippa_esc_codigo,0) as sippa_esc_codigo ,COALESCE(ec.SNIES_codigo,'') as SNIES_codigo,COALESCE(ec.esc_codigo_hecaa,0) as esc_codigo_hecaa,\n"
			+ "p.Expr1,p.nat_codigo,p.reg_codigo,p.per_razon_social,p.per_identificacion_dup,p.per_codigo_pais_hecaa,COALESCE(p.per_estrato,'0') AS per_estrato,p.per_fecha_expedicion, "+EstratoDB.COLUMNAS+"  "
			+ " ,COALESCE(tem.docente,0) AS docente, COALESCE(tem.docente_vinculacion,'') AS docente_vinculacion, COALESCE(tem.administrativo,0) AS administrativo, COALESCE(tem.administrativo_vinculacion,'') AS administrativo_vinculacion, COALESCE(tem.estudiante,'') AS estudiante, e.eps_codigo,e.eps_nombre,e.eps_prestador \n"
			+ " from @tempotalb tem\n" 
			+ "inner join persona_usco p on(tem.per_codigo=p.per_codigo)\n" 
			+ "left join tipo_id ti on(ti.tii_codigo=p.tii_codigo) \n" 
			+ "left join grupo_sanguineo gs on(gs.grs_codigo=p.grs_codigo)	\n" 
			+ "left join estado_civil ec on (ec.esc_codigo=p.per_estado_civil)\n" 
			+ "left join snies_estrato se on(se.ses_codigo=p.per_estrato) \n"
			+ "left join municipio mn with(nolock) on (mn.mun_codigo=p.per_lugar_nacimiento) \n" 
			+ "left join departamento dn with(nolock) on (dn.dep_codigo=mn.dep_codigo) \n" 
			+ "left join pais pn with(nolock) on(pn.pai_codigo=dn.pai_codigo) \n" 
			+ "left join municipio me with(nolock) on (me.mun_codigo=p.per_lugar_nacimiento) \n" 
			+ "left join departamento de with(nolock) on (de.dep_codigo=me.dep_codigo) \n"
			+ "left join pais pex with(nolock) on(pex.pai_codigo=de.pai_codigo) \n"
			+ "left join municipio mr with(nolock) on (mr.mun_codigo=p.per_lugar_residencia) \n" 
			+ "left join departamento dr with(nolock) on (dr.dep_codigo=mr.dep_codigo) \n"
			+ "left join municipio  mfr with(nolock) on(mfr.mun_codigo=p.per_familiar_lugar_residencia) \r\n" 
			+ "left join departamento dfr with(nolock) on(dfr.dep_codigo=mfr.dep_codigo) \r\n" 
			+ "left join pais pfr with(nolock) on (pfr.pai_codigo=dfr.pai_codigo)"
			+ "left join pais pr with(nolock) on(pr.pai_codigo=dr.pai_codigo) "
			+ "left join eps e  with(nolock) on(e.eps_codigo=p.eps_codigo) \n" 
			+ "order by per_apellido1"
		//	+ "group by\r\n" + 
			//" p.per_codigo,p.per_codigo,p.per_nombre1,p.per_apellido1 ,p.per_nombre2,p.per_apellido2, p.per_fecha_nacimiento ,p.per_identificacion, p.per_fecha_expedicion,p.per_email,p.per_email_interno,p.per_telefono_fijo,p.per_telefono_movil, ti.tii_codigo, ti.tii_nombre, ti.tii_nombre_corto,ti.tii_codigo_hecaa, ec.esc_codigo,ec.esc_nombre,ec.esc_codigo_hecaa, gs.grs_codigo,gs.grs_nombre, se.ses_codigo,se.ses_descripcion,se.snies_codigo,      me.mun_codigo ,mun_exp.mun_nombre,dep_exp.dep_codigo  ,dep_exp.dep_nombre  , pai_exp.pai_codigo  , pai_exp.pai_nombre  , mun_nac.mun_codigo  , mn.mun_nombre  , dep_nac.dep_codigo  , dep_nac.dep_nombre  , pai_nac.pai_codigo  , pai_nac.pai_nombre , per_genero\r\n" + 
			+"";
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang
	 * .Object)
	 */

	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		LinkedList<Persona> lista = null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();
		try {
			Usuario admin= null;
			Object param[] = (Object[]) obj;
			Persona persona = (Persona) param[0];
			 if(param[1]!=null) {
			 admin = (Usuario) param[1];
			 }
			 imp.info(persona);
			int opt=0;
			sql = new StringBuffer();
			if(param.length>0 && param[2]!=null) {
				if(String.valueOf(param[2]).equals("1")) {
					//opt=Integer.parseInt(String.valueOf(param[2]));
					sql.append(SQL_SELECT_TEMP);
					//sql.append("WHERE p.per_nombre1  like ? AND  p.per_apellido1 like ? AND  p.per_nombre2  like ? AND  p.per_apellido2 like ? AND  p.per_identificacion like ? \r\n" );
					sql.append("WHERE p.per_nombre1  like '%" + persona.getNombre().toUpperCase() + "%' ");
					sql.append("AND  p.per_apellido1 like  '%" + persona.getApellido().toUpperCase() + "%' ");
					sql.append("AND  p.per_nombre2  like '%" + persona.getNombre2().toUpperCase() + "%' ");
					sql.append("AND  p.per_apellido2 like  '%" + persona.getApellido2().toUpperCase() + "%' ");
					sql.append("AND  p.per_identificacion like  '%" + persona.getIdentificacion() + "%' ");
					sql.append("group by p.per_codigo\r\n" );
					sql.append(SQL_SELECT_USCO);
					sql.append(SQL_SELECT_PERSONA);
					
				}
			}else {
			sql.append(SQL_SELECT);
			sql.append("WHERE p.per_nombre1  like '%" + persona.getNombre().toUpperCase() + "%' ");
			sql.append("AND  p.per_apellido1 like  '%" + persona.getApellido().toUpperCase() + "%' ");
			sql.append("AND  p.per_nombre2  like '%" + persona.getNombre2().toUpperCase() + "%' ");
			sql.append("AND  p.per_apellido2 like  '%" + persona.getApellido2().toUpperCase() + "%' ");
			sql.append("AND  p.per_identificacion like  '%" + persona.getIdentificacion() + "%' ");
			sql.append("group by p.per_codigo\r\n" );
			}
			imp.info("getAll "+sql.toString());
			if(admin!=null) {
				conn = consegura.getconn_admin(admin);
			}else {
				conn = consegura.conexionConsulta();
			}
			sentencia = conn.prepareStatement(sql.toString());
//			System.out.println(persona);
//			System.out.println(sql.toString());
//			conn= consegura.conexion_segura();
			conn.setAutoCommit(false);
			//sentencia = conn.prepareStatement(sql.toString());
			
			// sentencia.setString(1, "%" +persona.getNombre().toUpperCase()+ "%");
			// sentencia.setString(2, "%" +persona.getApellido().toUpperCase()+ "%");
			// sentencia.setString(3, persona.getIdentificacion());
			//imp.info("select persona " + sql.toString() + " " + persona);
			// rs=sentencia.executeQuery();
			conn.commit();
			lista = (LinkedList<Persona>) PersonaRowMapper.mapRow(sentencia.executeQuery());
			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("error en getAll" + e.toString());
//			System.out.println("error  "+e.toString());
			consegura.cerrarconn(conn, null, sentencia);

		}finally {
        	consegura.cerrarconn(conn, null, sentencia);
        }
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getObject(java.
	 * lang.Object)
	 */
	@Override
	public Object getObject(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		LinkedList<Persona> lista = null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();

		try {
			Usuario admin= null;
			Object param[] = (Object[]) obj;
			Persona persona = (Persona) param[0];
			if(param[1]!=null) {
				 admin = (Usuario) param[1];
			}
			sql = new StringBuffer();
			sql.append(SQL_SELECT);
			if(persona.getCodigo()>0) {
				sql.append("WHERE p.per_codigo = ? ");
			}
			if(persona.getIdentificacion()!=null && !persona.getIdentificacion().trim().equals("")) {
				sql.append("WHERE p.per_identificacion = ? ");
			}
//			System.out.println("getObject "+sql.toString());
			if(admin!=null) {
					conn = consegura.getconn_admin(admin);
			}else {
			conn = consegura.conexionConsulta();
			}
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			
			if(persona.getCodigo()>0) {
				sentencia.setInt(1, persona.getCodigo());
			}
			if(persona.getIdentificacion()!=null && !persona.getIdentificacion().trim().equals("")) {
				sentencia.setString(1, persona.getIdentificacion());
			}
			imp.info("select persona " + sql.toString() + " " + persona);
			conn.commit();
			lista = (LinkedList<Persona>) PersonaRowMapper.mapRow(sentencia.executeQuery());
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#insertObject(
	 * java.lang.Object)
	 */
	@Override
	public Object setObject(Object obj) {
		Object[] param = (Object[]) obj;
		int opt = (int) param[2];
		if (opt == 0) {
			return insertObject(obj);
		}
		if (opt == 1) {
			return updateObject(obj);
		}
//		if (opt == 2) {
//			return updateObject(obj);
//		}
		return null;
	}

	private Object updateObject(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		int resul = 0;
		imp = Logger.getLogger(getClass().getName());
		
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();
		try {
			Object param[] = (Object[]) obj;
			Persona persona = (Persona) param[0];
			Usuario admin = (Usuario) param[1];
			Date fechaServidor = (Date) Fecha.getDate(FechaLog.getFechaServidor().toString());
			imp.info("update el persona " + persona);
//			imp.info("update el persona " + admin);
			sql.append("UPDATE persona ");
			sql.append("SET ");
			//sql.append(" per_identificacion = ? ");
			sql.append("tii_codigo = ? ");
			sql.append(",per_libreta_militar = ? ");
			sql.append(",per_apellido = ? ");
			sql.append(",per_nombre = ? ");
			sql.append(",per_genero = ? ");
			sql.append(",per_lugar_expedicion = ? ");
			sql.append(",per_fecha_expedicion = ? ");
			sql.append(",per_fecha_nacimiento = ? ");
			sql.append(",per_direccion_residencia = ? ");
			sql.append(",per_telefono_movil = ? ");
			sql.append(",per_telefono_fijo = ? ");
			sql.append(",per_estado_civil = ? ");
			sql.append(",per_lugar_nacimiento = ? ");
			sql.append(",per_lugar_residencia = ? ");
			sql.append(",per_departamento_residencia = ? ");
			sql.append(",per_pais_residencia = ? ");
			sql.append(",per_barrio = ? ");
			sql.append(",per_estrato = ? ");
			sql.append(",eps_codigo = ? ");
//			sql.append(",eta_codigo = ? ");
//			sql.append(",per_numero_afiliacion_eps = ? ");
//			sql.append(",per_ips_sisben = ? ");
//			sql.append(",per_id_cotizante = ? ");
//			sql.append(",per_beneficiario_ley1081 = ? ");
			sql.append(",per_familiar_direccion = ? ");
			sql.append(",per_familiar_nombre = ? ");
			sql.append(",per_familiar_telefono = ? ");
			sql.append(",per_familiar_lugar_residencia = ? ");
			sql.append(",per_email = ? ");
			sql.append(",per_email_interno = ? ");
			sql.append(",enviar_correo = ? ");
//			sql.append(",per_pagina_personal = ? ");
			sql.append(",grs_codigo = ? ");
			sql.append(",per_estado = ? ");
//			sql.append(",nat_codigo = ? ");
//			sql.append(",reg_codigo = ? ");
//			sql.append(",per_razon_social = ? ");
//			sql.append(",per_identificacion_dup = ? ");
//			sql.append(",per_cedula = ? ");
//			sql.append(",per_tarjeta = ? ");
//			sql.append(",per_codigo_postal = ? ");
//			sql.append(",per_pasaporte = ? ");
//			sql.append(",per_huella = ? ");
//			sql.append(",per_fecha_registro = ? ");
			sql.append(",per_codigo_pais_hecaa = ? ");
//			sql.append(",per_fecha_actualizacion = ? ");
//			sql.append(",lenguaNativa = ? ");
//			sql.append(",eps_par_codigo = ? ");
//			sql.append(",era_codigo = ? ");
//			sql.append(",evt_codigo = ? ");
			sql.append("WHERE per_codigo = ? ");
			if(admin!=null) {
				conn = consegura.getconn_admin(admin);
			}else {
			conn = consegura.conexionEjecucion();
			}
			
			imp.info("update el persona " + sql.toString());
			sentencia = conn.prepareStatement(sql.toString());

			sentencia.setInt(1, persona.getTipoId().getCodigo());
			sentencia.setString(2, persona.getLibretaMilitar());
			if(persona.getApellido2() != null) {
				sentencia.setString(3, persona.getApellido().trim() + " " + persona.getApellido2().trim());
			}else {
				sentencia.setString(3, persona.getApellido().trim() );
			}
			
			sentencia.setString(4, persona.getNombre().trim() + " " + persona.getNombre2().trim());
			
			sentencia.setString(5,""+persona.getGenero().getCodigo());
			sentencia.setInt(6, persona.getLugarExpedicion().getCodigo());
			sentencia.setDate(7, Fecha.sumarFechasDias(new java.sql.Date(persona.getFechaExpedicion().getTime()), 0));
			sentencia.setDate(8, Fecha.sumarFechasDias(new java.sql.Date(persona.getFechaNacimiento().getTime()), 0));
			sentencia.setString(9, persona.getDireccionResidencia());
			sentencia.setString(10, persona.getTelefonoMovil());
			sentencia.setString(11, persona.getTelefonoFijo());
			sentencia.setInt(12, persona.getEstadoCivil().getCodigo());
			sentencia.setInt(13, persona.getLugarNacimiento().getCodigo());
			sentencia.setInt(14, persona.getLugarResidencia().getCodigo());
			sentencia.setInt(15, persona.getLugarResidencia().getDepartamento().getCodigo());
			sentencia.setInt(16, persona.getLugarResidencia().getDepartamento().getPais().getCodigo());
			sentencia.setString(17, persona.getBarrio());
			sentencia.setString(18, persona.getEstrato().getCodigo());
			sentencia.setInt(19, persona.getEps().getCodigo());
			sentencia.setString(20, persona.getFamiliarDireccion());
			sentencia.setString(21, persona.getFamiliarNombre());
			sentencia.setString(22, persona.getFamiliarTelefono());
			sentencia.setInt(23, persona.getFamiliarLugarResidencia().getCodigo());
			sentencia.setString(24, persona.getEmail());
			sentencia.setString(25, persona.getEmailInterno());
			sentencia.setInt(26, 1);
			sentencia.setInt(27, persona.getGrupoSanguineo().getCodigo());
			sentencia.setInt(28, 1);
			sentencia.setInt(29, persona.getLugarNacimiento().getDepartamento().getPais().getCodigoHecaa());

			sentencia.setInt(30, persona.getCodigo());

			resul = sentencia.executeUpdate();
			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString() + "" + sql.toString());
			consegura.cerrarconn(conn, null, sentencia);

		}finally {
        	consegura.cerrarconn(conn, null, sentencia);
        }
		return resul;
	}

	private Object insertObject(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		int resul = 0;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();
		Persona persona =null;
		try {
			Object param[] = (Object[]) obj;
			 persona = (Persona) param[0];
			String fechaServidor = String.valueOf(FechaLog.getFechaServidor());
			Usuario admin = (Usuario) param[1];
			sql.append("INSERT INTO persona ");
			// sql.append("(per_identificacion,tii_codigo,per_libreta_militar,per_apellido,per_nombre,per_genero,per_lugar_expedicion,per_fecha_expedicion,per_fecha_nacimiento
			// ");
			// sql.append(",per_direccion_residencia,per_telefono_movil,per_telefono_fijo,per_estado_civil,per_lugar_nacimiento,per_lugar_residencia,per_departamento_residencia
			// ");
			// sql.append(",per_pais_residencia,per_barrio,per_estrato,eps_codigo,eta_codigo,per_numero_afiliacion_eps,per_ips_sisben,per_id_cotizante,per_beneficiario_ley1081
			// ");
			// sql.append(",per_familiar_direccion,per_familiar_nombre,per_familiar_telefono,per_familiar_lugar_residencia,per_email,per_email_interno,enviar_correo
			// ");
			// sql.append(",per_pagina_personal,grs_codigo,per_estado,nat_codigo,reg_codigo,per_razon_social,per_identificacion_dup,per_cedula,per_tarjeta,per_codigo_postal
			// ");
			// sql.append(",per_pasaporte,per_huella,per_fecha_registro,per_codigo_pais_hecaa,per_fecha_actualizacion,lenguaNativa,eps_par_codigo,era_codigo,evt_codigo)
			// ");
			sql.append("(per_identificacion,tii_codigo,per_libreta_militar,per_apellido,per_nombre,per_genero,per_lugar_expedicion,per_fecha_expedicion,per_fecha_nacimiento ");
			sql.append(
					",per_direccion_residencia,per_telefono_movil,per_telefono_fijo,per_estado_civil,per_lugar_nacimiento,per_lugar_residencia,per_departamento_residencia ");
			sql.append(
					",per_pais_residencia,per_barrio,per_estrato,per_email,per_email_interno,enviar_correo,grs_codigo,per_estado,per_codigo_pais_hecaa ");
			sql.append(") VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");

			if(admin!=null) {
				conn = consegura.getconn_admin(admin);
			}else {
			conn = consegura.conexionEjecucion();
			}
//			conn=consegura.conexionConsulta();
			imp.info("valida el usuario " + sql.toString());
			sentencia = conn.prepareStatement(sql.toString());
			sentencia.setString(1, persona.getIdentificacion());
			sentencia.setInt(2, persona.getTipoId().getCodigo());
			sentencia.setString(3, persona.getLibretaMilitar());
			
			if(persona.getApellido2() != null) {
				sentencia.setString(4, persona.getApellido() + " " + persona.getApellido2());
			}else {
				sentencia.setString(4, persona.getApellido() );
			}
			
			sentencia.setString(5, persona.getNombre() + " " + persona.getNombre2());
			sentencia.setString(6,""+persona.getGenero().getCodigo());
			sentencia.setInt(7, persona.getLugarExpedicion().getCodigo());
			sentencia.setDate(8, Fecha.sumarFechasDias(new java.sql.Date(persona.getFechaExpedicion().getTime()), 0));
			sentencia.setDate(9, Fecha.sumarFechasDias(new java.sql.Date(persona.getFechaNacimiento().getTime()), 0));
			sentencia.setString(10, persona.getDireccionResidencia());
			sentencia.setString(11, persona.getTelefonoMovil());
			sentencia.setString(12, persona.getTelefonoFijo());
			sentencia.setInt(13, persona.getEstadoCivil().getCodigo());
			sentencia.setInt(14, persona.getLugarNacimiento().getCodigo());
			if(persona.getLugarResidencia()!=null) {
			sentencia.setInt(15, persona.getLugarResidencia().getCodigo());
			sentencia.setInt(16, persona.getLugarResidencia().getDepartamento().getCodigo());
			sentencia.setInt(17, persona.getLugarResidencia().getDepartamento().getPais().getCodigo());
			}else {
				sentencia.setInt(15, 0);
				sentencia.setInt(16, 0);
				sentencia.setInt(17, 0);
			}
			sentencia.setString(18, persona.getBarrio());
			sentencia.setString(19, persona.getEstrato().getCodigo());
			sentencia.setString(20, persona.getEmail());
			sentencia.setString(21, persona.getEmailInterno());
			sentencia.setInt(22, 1);
			sentencia.setInt(23, persona.getGrupoSanguineo().getCodigo());
			sentencia.setInt(24, 1);
			//sentencia.setString(25, fechaServidor );
			sentencia.setInt(25, persona.getLugarNacimiento().getDepartamento().getPais().getCodigoHecaa());

			resul = sentencia.executeUpdate();
			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error(" error  " + e + "" + sql.toString());
			imp.error(" error  " + e + "" +persona);
			consegura.cerrarconn(conn, null, sentencia);

		}finally {
        	consegura.cerrarconn(conn, null, sentencia);
        }
		return resul;
	}

	@Override
	public boolean esObject(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();
		LinkedList<Persona> lista = null;
		imp.info("esObject llega " );
		try {
			Object param[] = (Object[]) obj;
			Persona persona = (Persona) param[0];
			Usuario admin = (Usuario) param[1];
			sql = new StringBuffer();
			sql.append(SQL_SELECT);
//			if (persona.getCodigo() > 0) {
				sql.append("WHERE p.per_codigo = ? ");
//			}
			if(persona.getIdentificacion()!=null && persona.getIdentificacion().length()>0) {
				sql.append("AND  p.per_identificacion = ? ");
			}

			if(admin!=null) {
//				conn = consegura.getconn_admin(admin);
				conn = consegura.conexionConsulta();
			}else {
				conn = consegura.conexionConsulta();
			}
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			
//			if (persona.getCodigo() > 0) {
				sentencia.setInt(1, persona.getCodigo());
//			}
			 if(persona.getIdentificacion()!=null && persona.getIdentificacion().length()>0) {
				 sentencia.setString(2,persona.getIdentificacion());
			}
			// sentencia.setString(1,novedad.getNombre());

			imp.info("es persona " + sql.toString());
			// rs=sentencia.executeQuery();
			conn.commit();

			lista = (LinkedList<Persona>) PersonaRowMapper.mapRow(sentencia.executeQuery());
			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, null, sentencia);

		}finally {
        	consegura.cerrarconn(conn, null, sentencia);
        }
		if (lista != null && lista.size() > 0) {
			return false;
		}
		return true;
	}

}
