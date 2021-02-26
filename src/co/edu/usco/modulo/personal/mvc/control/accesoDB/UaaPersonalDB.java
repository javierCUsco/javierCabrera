package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.UaaPersonalDB;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.UaaPersonalRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionUscoDB;
import co.edu.usco.modulo.personal.mvc.control.logica.WebParametroLog;
import co.edu.usco.modulo.personal.mvc.modelo.Escalafon;
import co.edu.usco.modulo.personal.mvc.modelo.Periodo;
import co.edu.usco.modulo.personal.mvc.modelo.UaaPersonal;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.WebParametro;
import co.edu.usco.modulo.personal.mvc.modelo.pensionado.Pensionado;




import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import org.apache.log4j.Logger;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class UaaPersonalDB implements ConexionUscoDB {
  private Logger imp;
  
  public String SQL_SELECT = "select top 1000  up.uap_codigo, p.per_codigo,p.per_codigo,p.per_nombre1,p.per_apellido1 ,p.per_nombre2,p.per_apellido2, p.per_fecha_nacimiento ,p.per_identificacion, p.per_fecha_expedicion,p.per_email,p.per_email_interno,p.per_telefono_fijo,p.per_telefono_movil, ti.tii_codigo, ti.tii_nombre, ti.tii_nombre_corto,ti.tii_codigo_hecaa, ec.esc_codigo,ec.esc_nombre,ec.esc_codigo_hecaa, gs.grs_codigo,gs.grs_nombre, se.ses_codigo,coalesce(se.ses_descripcion,'') as ses_descripcion,se.snies_codigo,      mun_exp.mun_codigo AS mexp_codigo ,mun_exp.mun_nombre AS mexp_nombre ,dep_exp.dep_codigo AS dexp_codigo ,dep_exp.dep_nombre AS dexp_nombre, pai_exp.pai_codigo AS pexp_codigo, pai_exp.pai_nombre AS pexp_nombre, mun_nac.mun_codigo AS mnac_codigo, mun_nac.mun_nombre AS mnac_nombre, dep_nac.dep_codigo AS dnac_codigo, dep_nac.dep_nombre AS dnac_nombre, pai_nac.pai_codigo As pnac_codigo, pai_nac.pai_nombre AS pnac_nombre, per_genero, u.uaa_codigo, u.uaa_nombre, u.uaa_nombre_corto, up.uap_fecha_inicio, up.uap_fecha_fin, (select  top 1 case when uap.uap_cargo<> 0 then c.car_nombre else car.car_nombre end    from uaa_personal uap with(nolock) left join cargo c with(nolock) on car_codigo=uap.uap_cargo left join uaa_cargo uac with(nolock) on uac.uac_codigo=uap.uac_codigo left join cargo car with(nolock) on car.car_codigo=uac.uac_cargo where uap.uap_codigo=up.uap_codigo) as cargo, (select  top 1 case when uap.ded_codigo<> 0 then d.ded_nombre else ded.ded_nombre end    \r\n from uaa_personal uap  with(nolock)\r\n left join dedicacion d with(nolock) on d.ded_codigo=uap.ded_codigo \r\n left join uaa_cargo uac with(nolock) on uac.uac_codigo=uap.uac_codigo \r\n left join dedicacion ded with(nolock) on ded.ded_codigo=uac.uac_dedicacion \r\n where uap.uap_codigo=up.uap_codigo) as dedicacion, \r\n \r\n (select  top 1 case when uap.uap_cargo<> 0 then v.vin_nombre else vin.vin_nombre end    \r\n from uaa_personal uap  with(nolock)\r\n left join vinculacion v with(nolock) on v.vin_codigo=uap.vin_codigo\r\n left join uaa_cargo uac with(nolock) on uac.uac_codigo=uap.uac_codigo \r\n left join vinculacion vin with(nolock) on vin.vin_codigo=uac.uac_vinculacion \r\n where uap.uap_codigo=up.uap_codigo) as vinculacion,   (select  top 1 case when uap.uap_cargo<> 0 then c.car_codigo else car.car_codigo end    \r\n from uaa_personal uap with(nolock) \r\n left join cargo c with(nolock) on car_codigo=uap.uap_cargo \r\n left join uaa_cargo uac with(nolock) on uac.uac_codigo=uap.uac_codigo \r\n left join cargo car with(nolock) on car.car_codigo=uac.uac_cargo \r\n where uap.uap_codigo=up.uap_codigo) as car_codigo, \r\n\r\n (select  top 1 case when uap.ded_codigo<> 0 then d.ded_codigo else ded.ded_codigo end    \r\n from uaa_personal uap  with(nolock)\r\n left join dedicacion d with(nolock) on d.ded_codigo=uap.ded_codigo \r\n left join uaa_cargo uac with(nolock) on uac.uac_codigo=uap.uac_codigo \r\n left join dedicacion ded with(nolock) on ded.ded_codigo=uac.uac_dedicacion \r\n where uap.uap_codigo=up.uap_codigo) as ded_codigo, \r\n \r\n (select  top 1 case when uap.uap_cargo<> 0 then v.vin_codigo else vin.vin_codigo end    \r\n from uaa_personal uap  with(nolock)\r\n left join vinculacion v with(nolock) on v.vin_codigo=uap.vin_codigo\r\n left join uaa_cargo uac with(nolock) on uac.uac_codigo=uap.uac_codigo \r\n left join vinculacion vin with(nolock) on vin.vin_codigo=uac.uac_vinculacion \r\n where uap.uap_codigo=up.uap_codigo) as vin_codigo, s.sed_codigo,s.sed_nombre,up.sed_codigo ,es.esc_codigo,es.esc_nombre,es.esc_cap_puntos,es.sippa_esccodigo from persona_usco p with(nolock) left join tipo_id ti on(ti.tii_codigo=p.tii_codigo) left join grupo_sanguineo gs on(gs.grs_codigo=p.grs_codigo)\t\r\n left join estado_civil ec on (ec.esc_codigo=p.per_estado_civil)\r\n left join snies_estrato se on(se.ses_codigo=p.per_estrato) left join uaa_personal up with(nolock) on(up.per_codigo=p.per_codigo) left join uaa as u with(nolock) on(up.uaa_codigo=u.uaa_codigo)  left join escalafon as es with(nolock) on(es.esc_codigo=up.esv_codigo)  left join municipio mun_nac with(nolock) on (mun_nac.mun_codigo=p.per_lugar_nacimiento) left join departamento dep_nac with(nolock) on (dep_nac.dep_codigo=mun_nac.dep_codigo) left join pais pai_nac with(nolock) on(pai_nac.pai_codigo=dep_nac.pai_codigo) left join municipio mun_exp with(nolock) on (mun_exp.mun_codigo=p.per_lugar_nacimiento) left join departamento dep_exp with(nolock) on (dep_exp.dep_codigo=mun_exp.dep_codigo) left join pais pai_exp with(nolock) on(pai_exp.pai_codigo=dep_exp.pai_codigo) left join municipio mun_res with(nolock) on (mun_res.mun_codigo=p.per_lugar_residencia) \r\n left join departamento dep_res with(nolock) on (dep_res.dep_codigo=mun_res.dep_codigo) \r\n left join pais pai_res with(nolock) on(pai_res.pai_codigo=dep_res.pai_codigo) inner join sede s with(nolock) on(s.sed_codigo=u.sed_codigo) ";
  
  public String SQL_SELECT_DOCENTE = "select  up.uap_codigo, p.per_codigo,p.per_nombre,p.per_apellido, p.per_fecha_nacimiento ,p.per_identificacion, mun_exp.mun_codigo AS mexp_codigo ,mun_exp.mun_nombre AS mexp_nombre ,dep_exp.dep_codigo AS dexp_codigo ,dep_exp.dep_nombre AS dexp_nombre, pai_exp.pai_codigo AS pexp_codigo, pai_exp.pai_nombre AS pexp_nombre, mun_nac.mun_codigo AS mnac_codigo, mun_nac.mun_nombre AS mnac_nombre, dep_nac.dep_codigo AS dnac_codigo, dep_nac.dep_nombre AS dnac_nombre, pai_nac.pai_codigo As pnac_codigo, pai_nac.pai_nombre AS pnac_nombre, per_genero, u.uaa_codigo, u.uaa_nombre, u.uaa_nombre_corto, up.uap_fecha_inicio,  up.uap_fecha_fin, (select  top 1 case when uap.uap_cargo<> 0 then c.car_nombre else car.car_nombre end    from uaa_personal uap left join cargo c on car_codigo=uap.uap_cargo left join uaa_cargo uac on uac.uac_codigo=uap.uac_codigo left join cargo car on car.car_codigo=uac.uac_cargo where uap.uap_codigo=up.uap_codigo) as cargo, s.sed_codigo,s.sed_nombre,up.sed_codigo,es.esc_codigo,\tes.esc_nombre,es.esc_cap_puntos,es.sippa_esccodigo from persona p with(nolock) left join uaa_personal up with(nolock) on(up.per_codigo=p.per_codigo) left join uaa as u with(nolock) on(up.uaa_codigo=u.uaa_codigo)  left join escalafon as es with(nolock) on(es.esc_codigo=up.esv_codigo)  left join municipio mun_nac with(nolock) on (mun_nac.mun_codigo=p.per_lugar_nacimiento) left join departamento dep_nac with(nolock) on (dep_nac.dep_codigo=mun_nac.dep_codigo) left join pais pai_nac with(nolock) on(pai_nac.pai_codigo=dep_nac.pai_codigo) left join municipio mun_exp with(nolock) on (mun_exp.mun_codigo=p.per_lugar_nacimiento) left join departamento dep_exp with(nolock) on (dep_exp.dep_codigo=mun_exp.dep_codigo) left join pais pai_exp with(nolock) on(pai_exp.pai_codigo=dep_exp.pai_codigo) inner join sede s on(s.sed_codigo=u.sed_codigo) ";
  public String SQL_SELECT_PERSONA = "select \r\n up.uap_codigo, up.uaa_codigo, up.per_codigo,\tup.uap_fecha_inicio,\tup.uap_fecha_fin,\tup.uap_cargo,\tup.vin_codigo,\tup.ded_codigo,\tup.uap_resolucion,\tup.uap_estado,\tup.esv_codigo,\tup.esc_valor,\tup.sippa_puntos,\tup.sippa_doccedula, up.sippa_vincodigo,\tup.sippa_calcodigo,\tup.sippa_dedcodigo,\tup.uap_codigo_anterior,\tup.uac_codigo,\tup.uap_plantaencargo,\tup.uap_uacocupado,\tup.uap_dependencia_ejerce,\tup.codRegistro,\tup.uap_id_carnet,\tup.sed_codigo,\tup.uap_observacion,\r\n p.per_codigo,p.per_identificacion,p.tii_codigo,\r\n cd.car_codigo as cdc, cd.car_nombre as cdn, cd.car_id as cdi, cd.car_tmp as cdt,\r\n dd.ded_codigo as ddc, dd.ded_nombre as ddn, dd.ded_orden_snies as ddos, dd.sippa_dedcodigo as dds, dd.ded_codigo_hecaa as ddh,\r\n vd.vin_codigo as vdc, vd.vin_nombre as vdn, vd.vin_horas_year as vdhy, vd.vin_clase as vdc, vd.sippa_vincodigo as vds, vd.vin_contratacion as vdcn, vd.vin_externa as vde,\r\n ud.uaa_codigo as udc, ud.uat_codigo as udt, ud.uaa_nombre as udn, ud.uaa_dependencia as udd, ud.uaa_nombre_corto as udnc, ud.uaa_nombre_impresion as udni, ud.uaa_email as ude, ud.uaa_email_pqr as udep, ud.uaa_pagina as udp, ud.uaa_jefe as udj, ud.mun_codigo as udm, ud.uaa_telefono as udt, ud.uaa_fax as udf, ud.uaa_direccion as uddr, ud.sippa_uaa_codigo as uds, ud.sed_codigo as uds, ud.uaa_centro_costos as udcc, ud.uaa_acronimo as uda, ud.uaa_estado as ude, ud.uaa_ventanilla as udv, ud.uaa_codigo_retencion as udr, ud.uaa_propietario_codigo as udp,\r\n\r\n ca.car_codigo as cac , ca.car_nombre as can, ca.car_id as cai, ca.car_tmp as cat,"
  		+ "\r\n da.ded_codigo as dac, da.ded_nombre as dan, da.ded_orden_snies as daos, da.sippa_dedcodigo as das, da.ded_codigo_hecaa as dah,\r\n va.vin_codigo as vac, va.vin_nombre as van, va.vin_horas_year as vahy, va.vin_clase as vac, va.sippa_vincodigo as vacs, va.vin_contratacion as vacn, va.vin_externa as vae,\r\n ua.uaa_codigo as uac, ua.uat_codigo as uat, ua.uaa_nombre as uan, ua.uaa_dependencia as uad, ua.uaa_nombre_corto as uanc, ua.uaa_nombre_impresion as uani, ua.uaa_email as uae, ua.uaa_email_pqr as uaep, ua.uaa_pagina as uap, ua.uaa_jefe as uaj, ua.mun_codigo as uam, ua.uaa_telefono as uat, ua.uaa_fax as uaf, ua.uaa_direccion as uad, ua.sippa_uaa_codigo as uasu, ua.sed_codigo as uasc, ua.uaa_centro_costos as uacc, ua.uaa_acronimo as uaa, ua.uaa_estado as uae, ua.uaa_ventanilla as uav, ua.uaa_codigo_retencion as uacr, ua.uaa_propietario_codigo as uap,\r\nti.tii_codigo,ti.tii_nombre,ti.tii_nombre_corto,ti.snies_codigo,ti.spadies_codigo,ti.observatorio_laboral,ti.linix_codigo,ti.tii_estado,ti.tii_num_caracteres,ti.tii_codigo_hecaa,\r\np.per_libreta_militar,"
  		+ "p.per_apellido1 ,COALESCE(p.per_apellido2,'') AS per_apellido2,p.per_nombre1 ,COALESCE(p.per_nombre2,'') AS per_nombre2 ,coalesce(p.per_genero,'') as per_genero,coalesce(p.per_familiar_lugar_residencia ,0) as per_familiar_lugar_residencia "
  		+ "\r\n,p.per_lugar_expedicion,ec.esc_codigo as esccodigo,ec.esc_nombre as escnombre ,ec.sippa_esc_codigo,ec.SNIES_codigo,ec.esc_codigo_hecaa,\r\ncoalesce(mn.mun_codigo,0) AS mnc,mn.mun_id AS mni,coalesce(mn.mun_nombre,'') AS mnn,mn.dep_codigo AS mnd,mn.sippa_mun_codigo AS smnc,mn.SNIES_codigo AS mnsc,mn.dane_codigo AS mndc,\r\ncoalesce(dn.dep_codigo,0) AS dnc,dn.dep_acronimo AS dna,coalesce(dn.dep_nombre,'') AS dnn,dn.pai_codigo AS dnpc,dn.sippa_dep_codigo AS sdnc,dn.dane_codigo AS dndc,\r\ncoalesce(pn.pai_codigo,0) AS pnc,pn.pai_acronimo AS pna,coalesce(pn.pai_nombre,'') AS pnn,pn.sippa_pai_codigo AS spnc,pn.dane_codigo AS pndc,pn.pai_codigo_hecaa AS pnch,\r\ncoalesce (me.mun_codigo,0) AS mec,me.mun_id AS mei,coalesce(me.mun_nombre,'') AS men,me.dep_codigo AS med,me.sippa_mun_codigo AS smec,me.SNIES_codigo AS mesc,me.dane_codigo AS medc,\r\ncoalesce(de.dep_codigo,0) AS dec,de.dep_acronimo AS dea,coalesce(de.dep_nombre,'') AS den,de.pai_codigo AS depc,de.sippa_dep_codigo AS sdec,de.dane_codigo AS dedc,\r\ncoalesce(pex.pai_codigo,0) AS pec,pex.pai_acronimo AS pea,coalesce(pex.pai_nombre,'') AS pen,pex.sippa_pai_codigo AS spec,pex.dane_codigo AS pedc,pex.pai_codigo_hecaa AS pech,\r\nmr.mun_codigo AS mrc,mr.mun_id AS mri,mr.mun_nombre AS mrn,mr.dep_codigo AS mrd,mr.sippa_mun_codigo AS smrc,mr.SNIES_codigo AS mrsc,mr.dane_codigo AS mrdc,\r\ndr.dep_codigo AS drc,dr.dep_acronimo AS dra,dr.dep_nombre AS drn,dr.pai_codigo AS drpc,dr.sippa_dep_codigo AS sdrc,dr.dane_codigo AS drdc,\r\npr.pai_codigo AS prc,pr.pai_acronimo AS pra,pr.pai_nombre AS prn,pr.sippa_pai_codigo AS sprc,pr.dane_codigo AS prdc,pr.pai_codigo_hecaa AS prch,\r\nmfr.mun_codigo AS mfrc,mr.mun_id AS mfri,coalesce(mfr.mun_nombre,'') AS mfrn,mfr.dep_codigo AS mfrd,mfr.sippa_mun_codigo AS smfrc,mfr.SNIES_codigo AS mfrsc,mfr.dane_codigo AS mfrdc,\r\ndfr.dep_codigo AS dfrc,dfr.dep_acronimo AS dfra,coalesce(dfr.dep_nombre,'')  AS dfrn,dfr.pai_codigo AS dfrpc,dfr.sippa_dep_codigo AS sdfrc,dfr.dane_codigo AS dfrdc,\r\npfr.pai_codigo AS pfrc,pfr.pai_acronimo AS pfra,coalesce(pfr.pai_nombre,'')  AS pfrn,pfr.sippa_pai_codigo AS spfrc,pfr.dane_codigo AS pfrdc,pfr.pai_codigo_hecaa AS pfrch\r\n,p.per_fecha_nacimiento,p.per_direccion_residencia,p.per_telefono_movil,p.per_telefono_fijo,p.per_estado_civil,p.per_lugar_nacimiento,p.per_lugar_residencia,p.per_barrio  \r\n,coalesce(p.per_estado,0) as per_estado,p.eps_codigo,p.eta_codigo,p.per_numero_afiliacion_eps,p.per_familiar_direccion,p.per_familiar_nombre,p.per_familiar_telefono,p.per_familiar_lugar_residencia,p.per_email,p.per_email_interno,p.per_pagina_personal \r\n,p.grs_codigo,gs.grs_codigo,gs.grs_nombre,COALESCE(gs.sippa_grs_codigo,0) AS sippa_grs_codigo,"
  		+ "ec.esc_codigo as codigoesc,ec.esc_nombre as nombreesc,COALESCE(ec.sippa_esc_codigo,0) AS sippa_esc_codigo,ec.SNIES_codigo,COALESCE(ec.esc_codigo_hecaa,0) AS esc_codigo_hecaa ,\r\np.Expr1,p.nat_codigo,p.reg_codigo,p.per_razon_social,p.per_identificacion_dup,p.per_codigo_pais_hecaa,COALESCE(p.per_estrato,'0') AS per_estrato,p.per_fecha_expedicion,  se.ses_codigo,\tcoalesce(se.ses_descripcion,'') as ses_descripcion,\tse.snies_codigo,\tse.snies_estado,\r\ns.sed_codigo, s.sed_nombre, s.mun_codigo as msc, s.sippa_sed_codigo, s.sed_estado, s.SedNombre_corto, uc.uac_codigo, uc.uac_codigoplanta, uc.uac_grado, " + 
		    
    EscalafonDB.COLUMNAS + ",coalesce( cc.codRegistro,0) as codRegistro,coalesce(cc.imagen,'') as imagen \r\n" + 
    ",coalesce(sud.sed_codigo,0) as sudc,coalesce(sud.sed_nombre,'') as sudn,coalesce(sua.sed_codigo,0) as suac,coalesce(sua.sed_nombre,'') as suan  \r\n"+
    " from uaa_personal up with(nolock) \r\n" + 
    "inner join persona_usco p on(up.per_codigo=p.per_codigo)\r\n" + 
    "left join uaa ud with(nolock) on(ud.uaa_codigo=up.uaa_codigo)\r\n" +
    "left join sede sud with(nolock) on(sud.sed_codigo=ud.sed_codigo)\r\n"+
    "left join vinculacion vd with(nolock) on(vd.vin_codigo=up.vin_codigo)\r\n" + 
    "left join dedicacion dd with(nolock) on(dd.ded_codigo=up.ded_codigo)\r\n" + 
    "left join cargo cd with(nolock) on(cd.car_codigo=up.uap_cargo)\r\n" + 
    "left join escalafon es with(nolock) on(es.esc_codigo=up.esv_codigo) " + 
    "left join uaa_cargo uc with(nolock) on(uc.uac_codigo=up.uac_codigo)\r\n" + 
    "left join uaa ua with(nolock) on(ua.uaa_codigo=uc.uac_uaa)\r\n" +
    "left join sede sua with(nolock) on(sua.sed_codigo=ua.sed_codigo)\r\n"+
    "left join vinculacion va with(nolock) on(va.vin_codigo=uc.uac_vinculacion)\r\n" + 
    "left join dedicacion da with(nolock) on(da.ded_codigo=uc.uac_dedicacion)\r\n" + 
    "left join cargo ca with(nolock) on(ca.car_codigo=uc.uac_cargo)\r\n" + 
    "left join sede s with(nolock) on(s.sed_codigo=up.sed_codigo)\r\n" + 
    "left join tipo_id ti with(nolock) on(ti.tii_codigo=p.tii_codigo) \r\n" + 
    "left join grupo_sanguineo gs with(nolock) on(gs.grs_codigo=p.grs_codigo)\t\r\n" + 
    "left join estado_civil ec with(nolock) on (ec.esc_codigo=p.per_estado_civil)\r\n" + 
    "left join snies_estrato se with(nolock) on(se.ses_codigo=p.per_estrato) \r\n" + 
    "left join municipio mn with(nolock) on (mn.mun_codigo=p.per_lugar_nacimiento) \r\n" + 
    "left join departamento dn with(nolock) on (dn.dep_codigo=mn.dep_codigo) \r\n" + 
    "left join pais pn with(nolock) on(pn.pai_codigo=dn.pai_codigo) \r\n" + 
    "left join municipio me with(nolock) on (me.mun_codigo=p.per_lugar_nacimiento) \r\n" + 
    "left join departamento de with(nolock) on (de.dep_codigo=me.dep_codigo) \r\n" + 
    "left join pais pex with(nolock) on(pex.pai_codigo=de.pai_codigo) \r\n" + 
    "left join municipio mr with(nolock) on (mr.mun_codigo=p.per_lugar_residencia) \r\n" + 
    "left join departamento dr with(nolock) on (dr.dep_codigo=mr.dep_codigo) \r\n" + 
    "left join municipio  mfr with(nolock) on(mfr.mun_codigo=p.per_familiar_lugar_residencia) \r\n" + 
    "left join departamento dfr with(nolock) on(dfr.dep_codigo=mfr.dep_codigo) \r\n" + 
    "left join pais pfr with(nolock) on (pfr.pai_codigo=dfr.pai_codigo)\r\n"
    + "left join pais pr with(nolock) on(pr.pai_codigo=dr.pai_codigo)\r\n" 
    +"left join contrato.contrato cc with(nolock) on (cc.codRegistro=up.codRegistro)";
  
  
  
  public Object getObject(Object obj) {
	  Connection conn = null;
	    PreparedStatement sentencia = null;
	    LinkedList<UaaPersonal> lista = null;
	    this.imp = Logger.getLogger(getClass().getName());
	    Conexion consegura = new Conexion();
	    StringBuffer sql = new StringBuffer();
	    try {
	      Object[] param = (Object[])obj;
	      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
	      Usuario admin = (Usuario)param[1];
	      sql = new StringBuffer();
	      sql.append(this.SQL_SELECT_PERSONA);
	      sql.append("where p.per_codigo  = ? and up.uap_codigo= ? ");
//	      this.imp.info("getObject " + sql.toString());
	      if (admin != null) {
	        conn = consegura.getconn_admin(admin);
	      } else {
	        conn = consegura.conexionConsulta();
	      } 
	      conn.setAutoCommit(false);
	      sentencia = conn.prepareStatement(sql.toString());
	      sentencia.setInt(1, uaaPersonal.getPersona().getCodigo());
	      sentencia.setInt(2, uaaPersonal.getCodigo());
	      this.imp.info("getObject " + sql.toString());
//	      System.out.println("select Docentes " + sql.toString());
	      conn.commit();
	      lista = (LinkedList<UaaPersonal>)UaaPersonalRowMapper.mapRow(sentencia.executeQuery(),imp);
	      consegura.cerrarconn(conn, null, sentencia);
	    } catch (Exception e) {
	      this.imp.error(e.toString());
//	      System.out.println(e.toString());
	      consegura.cerrarconn(conn, null, sentencia);
	    } finally {
	    	consegura.cerrarconn(conn, null, sentencia);
	    }
	    return lista.get(0);
    /**Connection conn = null;
    PreparedStatement sentencia = null;
    LinkedList<UaaPersonal> lista = null;
    this.imp = Logger.getLogger(getClass().getName());
    Conexion consegura = new Conexion();
    StringBuffer sql = new StringBuffer();
    try {
      Object[] param = (Object[])obj;
      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
      Usuario admin = (Usuario)param[1];
      sql = new StringBuffer();
      sql.append(this.SQL_SELECT_PERSONA);
      sql.append("where p.per_codigo  = ? and up.uap_codigo= ? ");
      this.imp.info("select Docentes " + sql.toString());
      conn = consegura.getconn_admin(admin);
      conn.setAutoCommit(false);
      sentencia = conn.prepareStatement(sql.toString());
      sentencia.setInt(1, uaaPersonal.getPersona().getCodigo());
      sentencia.setInt(2, uaaPersonal.getCodigo());
      this.imp.info("select Docentes " + sql.toString());
      conn.commit();
      lista = (LinkedList<UaaPersonal>)UaaPersonalRowMapper.mapRow(sentencia.executeQuery());
      consegura.cerrarconn(conn, null, sentencia);
    } catch (Exception e) {
      this.imp.error(e.toString());
      consegura.cerrarconn(conn, null, sentencia);
    }finally {
    	consegura.cerrarconn(conn, null, sentencia);
    }
    return lista.get(0);***/
  }
  
  public Object getAll(Object obj) {
    Connection conn = null;
    Statement sentencia = null;
    ResultSet resul = null;
    this.imp = Logger.getLogger(getClass().getName());
    LinkedList<UaaPersonal> lista = new LinkedList<>();
    Conexion consegura = new Conexion();
    StringBuffer sql = new StringBuffer();
    try {
      Object[] param = (Object[])obj;
      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
      Usuario admin = (Usuario)param[1];
      sql = new StringBuffer();
      sql.append(this.SQL_SELECT);
      sql.append("where  (up.uap_plantaencargo='p' or up.vin_codigo=12)");
      if (uaaPersonal.getPersona().getNombre() != null && uaaPersonal.getPersona().getNombre().length() > 0) {
        sql.append(" and (p.per_apellido +' '+p.per_nombre like '%" + uaaPersonal.getPersona().getNombre() + 
            "%' or p.per_nombre+' '+p.per_apellido like '%" + uaaPersonal.getPersona().getNombre() + 
            "%' or p.per_identificacion like'" + uaaPersonal.getPersona().getNombre() + "')");
      } else {
        sql.append("(p.per_apellido +' '+per_nombre like '0000000') ");
      } 
      sql.append(" ");
      sql.append(" ");
      sql.append(" ");
      sql.append(" ");
      conn = consegura.conexion_segura();
      sentencia = conn.createStatement();
      resul = sentencia.executeQuery(sql.toString());
      this.imp.info("valida el usuario " + sql.toString());
      while (resul.next()) {
        UaaPersonal uaaPersonal2 = new UaaPersonal();
        uaaPersonal2.setCodigo(resul.getInt("uap_codigo"));
        uaaPersonal2.getPersona().setCodigo(resul.getInt("per_codigo"));
        uaaPersonal2.getPersona().setNombre(resul.getString("per_nombre"));
        uaaPersonal2.getPersona().setApellido(resul.getString("per_apellido"));
        uaaPersonal2.getPersona().setFechaNacimiento(resul.getDate("per_fecha_nacimiento"));
        uaaPersonal2.getPersona().setIdentificacion(resul.getString("per_identificacion"));
        uaaPersonal2.getPersona().getLugarExpedicion().setCodigo(resul.getInt("mexp_codigo"));
        uaaPersonal2.getPersona().getLugarExpedicion().setNombre(resul.getString("mexp_nombre"));
        uaaPersonal2.getPersona().getLugarExpedicion().getDepartamento().setCodigo(resul.getInt("dexp_codigo"));
        uaaPersonal2.getPersona().getLugarExpedicion().getDepartamento()
          .setNombre(resul.getString("dexp_nombre"));
        uaaPersonal2.getPersona().getLugarExpedicion().getDepartamento().getPais()
          .setCodigo(resul.getInt("pexp_codigo"));
        uaaPersonal2.getPersona().getLugarExpedicion().getDepartamento().getPais()
          .setNombre(resul.getString("pexp_nombre"));
        uaaPersonal2.getPersona().getLugarNacimiento().setCodigo(resul.getInt("mnac_codigo"));
        uaaPersonal2.getPersona().getLugarNacimiento().setNombre(resul.getString("mnac_nombre"));
        uaaPersonal2.getPersona().getLugarNacimiento().getDepartamento().setCodigo(resul.getInt("dnac_codigo"));
        uaaPersonal2.getPersona().getLugarNacimiento().getDepartamento()
          .setNombre(resul.getString("dnac_nombre"));
        uaaPersonal2.getPersona().getLugarNacimiento().getDepartamento().getPais()
          .setCodigo(resul.getInt("pnac_codigo"));
        uaaPersonal2.getPersona().getLugarNacimiento().getDepartamento().getPais()
          .setNombre(resul.getString("pnac_nombre"));
        uaaPersonal2.getUaa().setCodigo(resul.getInt("uaa_codigo"));
        uaaPersonal2.getUaa().setNombre(resul.getString("uaa_nombre"));
        uaaPersonal2.getUaa().setNombreCorto(resul.getString("uaa_nombre_corto"));
        uaaPersonal2.setFechaInicio(resul.getDate("uap_fecha_inicio"));
        lista.add(uaaPersonal2);
      } 
      consegura.cerrarconn(conn, resul, sentencia);
    } catch (Exception e) {
      this.imp.error(e.toString());
      consegura.cerrarconn(conn, resul, sentencia);
    } finally {
    	 consegura.cerrarconn(conn, resul, sentencia);
    }
    return lista;
  }
  
  public Object setObject(Object obj) {
    Object[] param = (Object[])obj;
    int opt = ((Integer)param[2]).intValue();
    if (opt == 1) {
        return InsertDocente(obj); 
      }
    if (opt == 2) {
      return updateDocente(obj); 
    }
    if (opt == 3) {
        return InsertAdministrativo(obj); 
      }
    if (opt == 4) {
      return updateAdministrativo(obj); 
    }
    return null;
  }
  private Object InsertDocente(Object object) {
	    Connection conn = null;
	    Statement sentencia = null;
	    PreparedStatement preparedStatement = null;
	    int resul = 0;
	    this.imp = Logger.getLogger(getClass().getName());
	    Conexion consegura = new Conexion();
	    StringBuffer sql = new StringBuffer();
	    try {
	      Object[] param = (Object[])object;
	      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
	      Usuario admin = (Usuario)param[1];
	      sql.append("INSERT INTO uaa_personal(uaa_codigo,per_codigo,uap_fecha_inicio,uap_fecha_fin,uap_cargo,vin_codigo,"
	      		+ "ded_codigo,uap_resolucion,uap_estado,esv_codigo,esc_valor,sed_codigo,uap_observacion) VALUES ");
	      sql.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
	      if(admin!=null) {
				conn = consegura.getconn_admin(admin);
			}else {
			conn = consegura.conexionEjecucion();
			}
//	      conn=consegura.conexionEjecucion();
	      preparedStatement = conn.prepareStatement(sql.toString());
	      preparedStatement.setInt(1, uaaPersonal.getUaa().getCodigo());
	      preparedStatement.setInt(2, uaaPersonal.getPersona().getCodigo());
	      preparedStatement.setDate(3, new Date(uaaPersonal.getFechaInicio().getTime()));
	      if(uaaPersonal.getFechaFin()!=null) {
		      preparedStatement.setDate(4, new Date(uaaPersonal.getFechaFin().getTime()));
		      }else {
		    	  preparedStatement.setDate(4, null);
		      }
	      preparedStatement.setInt(5, uaaPersonal.getCargo().getCodigo());
	      preparedStatement.setInt(6, uaaPersonal.getVinculacion().getCodigo());
	      preparedStatement.setInt(7, uaaPersonal.getDedicacion().getCodigo());
	      preparedStatement.setString(8, uaaPersonal.getResolucion());
	      if(uaaPersonal.getEstado()) {
	    	  preparedStatement.setInt(9, 1);
	      }else {
	    	  preparedStatement.setInt(9, 0);
	      }
	      if(uaaPersonal.getEscalafon().getCodigo()>0) {
	      preparedStatement.setInt(10, uaaPersonal.getEscalafon().getCodigo());
	    }else {
	    	preparedStatement.setInt(10,0);
	    }
	    	
	      preparedStatement.setDouble(11, uaaPersonal.getEscValor());
//	      preparedStatement.setInt(11, uaaPersonal.getUaaCargo().getCodigo());
	      preparedStatement.setInt(12, uaaPersonal.getSede().getCodigo());
	      preparedStatement.setString(13, uaaPersonal.getObservacion());
//	      preparedStatement.setInt(13, uaaPersonal.getPersona().getCodigo());
//	      preparedStatement.setInt(14, uaaPersonal.getCodigo());
	      resul = preparedStatement.executeUpdate();
	      this.imp.info("inserta el vinculacion " + sql.toString());
	      consegura.cerrarconn(conn, null, sentencia, preparedStatement);
	    } catch (Exception e) {
	      this.imp.error("error en la insercion de la vinculacion " +e +" " + sql.toString());
	      consegura.cerrarconn(conn, null, sentencia, preparedStatement);
	    }finally {
	   	 consegura.cerrarconn(conn,null, sentencia, preparedStatement);
	   } 
	    return Integer.valueOf(resul);
	  }
  private Object InsertAdministrativo(Object object) {
	    Connection conn = null;
	    Statement sentencia = null;
	    PreparedStatement preparedStatement = null;
	    int resul = 0;
	    this.imp = Logger.getLogger(getClass().getName());
	    Conexion consegura = new Conexion();
	    StringBuffer sql = new StringBuffer();
	    try {
	      Object[] param = (Object[])object;
	      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
	      Usuario admin = (Usuario)param[1];
	      sql.append("INSERT INTO uaa_personal(uaa_codigo,per_codigo,uap_fecha_inicio,uap_fecha_fin,"
	      		+ "uap_resolucion,uap_estado,esv_codigo,esc_valor,uac_codigo,uap_plantaencargo,uap_dependencia_ejerce,uap_uacocupado,sed_codigo,uap_observacion,uap_cargo,vin_codigo) VALUES ");
	      sql.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
	      if(admin!=null) {
				conn = consegura.getconn_admin(admin);
			}else {
			conn = consegura.conexionEjecucion();
			}
//	      conn=consegura.conexionEjecucion();
	      preparedStatement = conn.prepareStatement(sql.toString());
	      preparedStatement.setInt(1, uaaPersonal.getUaa().getCodigo());
	      preparedStatement.setInt(2, uaaPersonal.getPersona().getCodigo());
	      preparedStatement.setDate(3, new Date(uaaPersonal.getFechaInicio().getTime()));
	      if(uaaPersonal.getFechaFin()!=null) {
		      preparedStatement.setDate(4, new Date(uaaPersonal.getFechaFin().getTime()));
	      }else {
	    	  preparedStatement.setDate(4, null);
	      }
	      //preparedStatement.setInt(5, uaaPersonal.getCargo().getCodigo());
//	      preparedStatement.setInt(6, uaaPersonal.getVinculacion().getCodigo());
//	      preparedStatement.setInt(7, uaaPersonal.getDedicacion().getCodigo());
	      preparedStatement.setString(5, uaaPersonal.getResolucion());
	      if(uaaPersonal.getEstado()) {
	    	  preparedStatement.setInt(6, 1);
	      }else {
	    	  preparedStatement.setInt(6, 0);
	      }
	      if(uaaPersonal.getEscalafon().getCodigo()>0) {
	      preparedStatement.setInt(7, uaaPersonal.getEscalafon().getCodigo());
	    }else {
	    	preparedStatement.setInt(7,0);
	    }
	    	
	      preparedStatement.setDouble(8, uaaPersonal.getEscValor());
	      preparedStatement.setInt(9, uaaPersonal.getUaaCargo().getCodigo());
	      preparedStatement.setString(10, uaaPersonal.getPlantaEncargo());
	      preparedStatement.setInt(11, uaaPersonal.getDependenciaEjerce());
	      preparedStatement.setInt(12, uaaPersonal.getUacOcupado());
	      preparedStatement.setInt(13, uaaPersonal.getSede().getCodigo());
	      preparedStatement.setString(14, uaaPersonal.getObservacion());
	      preparedStatement.setInt(15, 0);
	      preparedStatement.setInt(16, 0);
	      resul = preparedStatement.executeUpdate();
	      this.imp.info("inserta el vinculacion " + sql.toString()+""+uaaPersonal.getUaa());
	      consegura.cerrarconn(conn, null, sentencia, preparedStatement);
	    } catch (Exception e) {
	      this.imp.error("error en la insercion de la vinculacion " +e +" " + sql.toString());
	      consegura.cerrarconn(conn, null, sentencia, preparedStatement);
	    }finally {
	   	 consegura.cerrarconn(conn,null, sentencia, preparedStatement);
	   } 
	    return Integer.valueOf(resul);
	  }
  private Object updateDocente(Object object) {
	    Connection conn = null;
	    Statement sentencia = null;
	    PreparedStatement preparedStatement = null;
	    int resul = 0;
	    this.imp = Logger.getLogger(getClass().getName());
	    Conexion consegura = new Conexion();
	    StringBuffer sql = new StringBuffer();
	    this.imp.info("entra a actualiza el vinculacion " );
	    try {
	      Object[] param = (Object[])object;
	      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
	      Usuario admin = (Usuario)param[1];
	      sql.append("UPDATE uaa_personal  ");
	      sql.append("SET uaa_codigo  = ? ");
	      sql.append(",uap_fecha_inicio = ? ");
	      sql.append(",uap_fecha_fin  = ? ");
	      sql.append(",uap_cargo  = ? ");
	      sql.append(",vin_codigo  = ? ");
	      sql.append(",ded_codigo  = ? ");
	      sql.append(",uap_resolucion  = ? ");
	      sql.append(",uap_estado  = ? ");
	      sql.append(",esv_codigo  = ? ");
	      sql.append(",esc_valor  = ? ");
//	      sql.append(",uac_codigo  = ? ");
//	      sql.append(",uap_plantaencargo  = ? ");
//	      sql.append(",uap_uacocupado  = ? ");
//	      sql.append(",codRegistro =  ? ");
	      //sql.append(",uap_id_carnet =  ? ");
	      sql.append(",sed_codigo =  ? ");
	      sql.append(",uap_observacion =  ? ");
	      sql.append("WHERE per_codigo = ? and uap_codigo = ? ");
	      if(admin!=null) {
				conn = consegura.getconn_admin(admin);
			}else {
			conn = consegura.conexionEjecucion();
			}
//	      conn=consegura.conexionEjecucion();
	      preparedStatement = conn.prepareStatement(sql.toString());
	      preparedStatement.setInt(1, uaaPersonal.getUaa().getCodigo());
	      preparedStatement.setDate(2, new Date(uaaPersonal.getFechaInicio().getTime()));
	      if(uaaPersonal.getFechaFin()!=null) {
	      preparedStatement.setDate(3, new Date(uaaPersonal.getFechaFin().getTime()));
	      }else {
	    	  preparedStatement.setDate(3, null);
	      }
	      preparedStatement.setInt(4, uaaPersonal.getCargo().getCodigo());
	      preparedStatement.setInt(5, uaaPersonal.getVinculacion().getCodigo());
	      preparedStatement.setInt(6, uaaPersonal.getDedicacion().getCodigo());
	      preparedStatement.setString(7, uaaPersonal.getResolucion());
	      if(uaaPersonal.getEstado()) {
	    	  preparedStatement.setInt(8, 1);
	      }else {
	    	  preparedStatement.setInt(8, 0);
	      }
	      preparedStatement.setInt(9, uaaPersonal.getEscalafon().getCodigo());
	      
	      preparedStatement.setDouble(10, uaaPersonal.getEscValor());
	      preparedStatement.setInt(11,uaaPersonal.getSede().getCodigo() );
	      preparedStatement.setString(12, uaaPersonal.getObservacion());
	      preparedStatement.setInt(13, uaaPersonal.getPersona().getCodigo());
	      preparedStatement.setInt(14, uaaPersonal.getCodigo());
	      resul = preparedStatement.executeUpdate();
	      this.imp.info("actualiza el vinculacion " + sql.toString());
	      consegura.cerrarconn(conn, null, sentencia, preparedStatement);
	    } catch (Exception e) {
	      this.imp.error("error en la actualiza de la vinculacion " +e.toString() + sql.toString());
	      consegura.cerrarconn(conn, null, sentencia, preparedStatement);
	    }finally {
	   	 consegura.cerrarconn(conn,null, sentencia, preparedStatement);
	   } 
	    return Integer.valueOf(resul);
	  }
  
  
  private Object updateAdministrativo(Object object) {
	    Connection conn = null;
	    Statement sentencia = null;
	    PreparedStatement preparedStatement = null;
	    int resul = 0;
	    this.imp = Logger.getLogger(getClass().getName());
	    Conexion consegura = new Conexion();
	    StringBuffer sql = new StringBuffer();
	    this.imp.info("entra a actualiza el vinculacion administrativa " );
	    try {
	      Object[] param = (Object[])object;
	      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
	      Usuario admin = (Usuario)param[1];
	      sql.append("UPDATE uaa_personal  ");
	      sql.append("SET uaa_codigo  = ? ");
	      sql.append(",uap_fecha_inicio = ? ");
	      sql.append(",uap_fecha_fin  = ? ");
//	      sql.append(",uap_cargo  = ? ");
//	      sql.append(",vin_codigo  = ? ");
//	      sql.append(",ded_codigo  = ? ");
	      sql.append(",uap_resolucion  = ? ");
	      sql.append(",uap_estado  = ? ");
	      sql.append(",esv_codigo  = ? ");
	      sql.append(",esc_valor  = ? ");
	      sql.append(",uac_codigo  = ? ");
	      sql.append(",uap_plantaencargo  = ? ");
	      sql.append(",uap_dependencia_ejerce = ? ");
	      sql.append(",uap_uacocupado  = ? ");
//	      sql.append(",codRegistro =  ? ");
	      //sql.append(",uap_id_carnet =  ? ");
	      sql.append(",sed_codigo =  ? ");
	      sql.append(",uap_observacion =  ? ");
	      sql.append("WHERE per_codigo = ? and uap_codigo = ? ");
	      if(admin!=null) {
				conn = consegura.getconn_admin(admin);
			}else {
			conn = consegura.conexionEjecucion();
			}
//	      conn=consegura.conexionEjecucion();
	      preparedStatement = conn.prepareStatement(sql.toString());
	      preparedStatement.setInt(1, uaaPersonal.getUaa().getCodigo());
	      preparedStatement.setDate(2, new Date(uaaPersonal.getFechaInicio().getTime()));
	      if(uaaPersonal.getFechaFin()!=null) {
	      preparedStatement.setDate(3, new Date(uaaPersonal.getFechaFin().getTime()));
	      }else {
	    	  preparedStatement.setDate(3, null);
	      }
//	      preparedStatement.setInt(4, uaaPersonal.getCargo().getCodigo());
//	      preparedStatement.setInt(5, uaaPersonal.getVinculacion().getCodigo());
//	      preparedStatement.setInt(6, uaaPersonal.getDedicacion().getCodigo());
	      preparedStatement.setString(4, uaaPersonal.getResolucion());
	      if(uaaPersonal.getEstado()) {
	    	  preparedStatement.setInt(5, 1);
	      }else {
	    	  preparedStatement.setInt(5, 0);
	      }
	      preparedStatement.setInt(6, uaaPersonal.getEscalafon().getCodigo());
	      
	      preparedStatement.setDouble(7, uaaPersonal.getEscValor());
	      preparedStatement.setInt(8, uaaPersonal.getUaaCargo().getCodigo());
	      preparedStatement.setString(9, uaaPersonal.getPlantaEncargo());
	      preparedStatement.setInt(10, uaaPersonal.getDependenciaEjerce());
	      preparedStatement.setInt(11, uaaPersonal.getUacOcupado());
//	      preparedStatement.setInt(11, uaaPersonal.getCodRegistro());
	      preparedStatement.setInt(12,uaaPersonal.getSede().getCodigo() );
	      preparedStatement.setString(13, uaaPersonal.getObservacion());
	      preparedStatement.setInt(14, uaaPersonal.getPersona().getCodigo());
	      preparedStatement.setInt(15, uaaPersonal.getCodigo());
	      resul = preparedStatement.executeUpdate();
	      this.imp.info("actualiza el vinculacion " + sql.toString());
	      consegura.cerrarconn(conn, null, sentencia, preparedStatement);
	    } catch (Exception e) {
	      this.imp.error("error en la actualiza de la vinculacion " +e.toString() + sql.toString());
	      consegura.cerrarconn(conn, null, sentencia, preparedStatement);
	    }finally {
	   	 consegura.cerrarconn(conn,null, sentencia, preparedStatement);
	   } 
	    return Integer.valueOf(resul);
	  }
  
  private Object updateEstadoPensionado(Object object) {
    Connection conn = null;
    Statement sentencia = null;
    PreparedStatement preparedStatement = null;
    int resul = 0;
    this.imp = Logger.getLogger(getClass().getName());
    Conexion consegura = new Conexion();
    StringBuffer sql = new StringBuffer();
    this.imp.info("entra a actualiza el vinculacion " );
    try {
      Object[] param = (Object[])object;
      Pensionado pensionado = (Pensionado)param[0];
      Usuario admin = (Usuario)param[1];
      sql.append("UPDATE uaa_personal  ");
      sql.append("SET uap_fecha_fin = ? ");
      sql.append(",uap_estado =  ? ");
      sql.append("WHERE per_codigo = ? and uap_codigo = ? ");
      conn = consegura.getconn_admin(admin);
      preparedStatement = conn.prepareStatement(sql.toString());
      preparedStatement.setDate(1, new Date(pensionado.getPen_fecha().getTime()));
      preparedStatement.setInt(2, 0);
      preparedStatement.setInt(3, pensionado.getUaa_personal().getPersona().getCodigo());
      preparedStatement.setInt(4, pensionado.getUaa_personal().getCodigo());
      resul = preparedStatement.executeUpdate();
      this.imp.info("actualiza el vinculacion " + sql.toString());
      consegura.cerrarconn(conn, null, sentencia, preparedStatement);
    } catch (Exception e) {
      this.imp.error("error en la actualiza de la vinculacion " +e.toString() + sql.toString());
      consegura.cerrarconn(conn, null, sentencia, preparedStatement);
    }finally {
   	 consegura.cerrarconn(conn,null, sentencia, preparedStatement);
   } 
    return Integer.valueOf(resul);
  }
  
  public boolean esObject(Object obj) {
	  Connection conn = null;
	    PreparedStatement sentencia = null;
	    LinkedList<UaaPersonal> lista = new LinkedList<>();
	    ResultSet rs = null;
	    Conexion consegura = new Conexion();
	    StringBuffer sql = new StringBuffer();
	    this.imp = Logger.getLogger(getClass().getName());
	    this.imp.info("llega " );
	    try {
	      Object[] param = (Object[])obj;
	      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
//	      Usuario admin = (Usuario)param[1];
	      sql = new StringBuffer();
	      this.imp.info("llega " + uaaPersonal);
	      sql.append(this.SQL_SELECT);
	      sql.append(" where  (up.uap_estado=1 or up.uap_estado is null ) " );
	      if(uaaPersonal.getFechaFin()!=null) {
	      sql.append(" and  (CAST(up.uap_fecha_inicio AS DATE ) between CAST('" + 
	      (new Date(uaaPersonal.getFechaInicio().getTime())).toString().replace("-", "") + "' AS DATE ) and CAST('" +
	    		  Fecha.sumarFechasDias(new Date(uaaPersonal.getFechaFin().getTime()), 3).toString().replace("-", "") + "' AS DATE )    and  CAST(up.uap_fecha_fin AS DATE )between CAST('" + (new Date(uaaPersonal.getFechaInicio().getTime())).toString().replace("-", "") + "' AS DATE ) and CAST('" + 
	    		  Fecha.sumarFechasDias(new Date(uaaPersonal.getFechaFin().getTime()), 3).toString().replace("-", "") + "' AS DATE )    or uap_fecha_fin is null )  ");
	      }
	      sql.append(" and  up.uap_cargo=? ");
	      sql.append(" and  up.vin_codigo=? ");
	      sql.append(" and  up.per_codigo=? ");
	       
	      sql.append("  order by p.per_nombre1, p.per_nombre2,up.uap_fecha_fin desc ");
	      conn = consegura.conexionConsulta();
	      conn.setAutoCommit(false);
	      sentencia = conn.prepareStatement(sql.toString());
	      sentencia.setInt(1, 3);
	      sentencia.setInt(2, uaaPersonal.getVinculacion().getCodigo());
	      sentencia.setInt(3, uaaPersonal.getPersona().getCodigo());
	      this.imp.info("sql " + sql.toString() + " <--> " + uaaPersonal.getPersona().getNombre());
	      conn.commit();
	      lista = (LinkedList<UaaPersonal>) UaaPersonalRowMapper.mapRow(sentencia.executeQuery(),imp);
	      consegura.cerrarconn(conn, rs, sentencia);
	    } catch (Exception e) {
	    	this.imp.error("Error " + e);
	      consegura.cerrarconn(conn, rs, sentencia);
	    } finally {
	   	 consegura.cerrarconn(conn, rs, sentencia);
	   }
	   // return lista;
	    if(lista!=null && lista.size()>0) {
	    	return false;
	    }else {
	  
	    	return true;
	    }
  }
  
  public Object getDocentes(Object obj) {
    Connection conn = null;
    PreparedStatement sentencia = null;
    Object lista = null;
    ResultSet rs = null;
    Conexion consegura = new Conexion();
    StringBuffer sql = new StringBuffer();
    try {
      Object[] param = (Object[])obj;
      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
      Usuario admin = (Usuario)param[1];
      sql = new StringBuffer();
      System.out.println("llega " + uaaPersonal.getPersona());
      sql.append(this.SQL_SELECT);
      sql.append(" where  (CAST(up.uap_fecha_inicio AS DATE ) between CAST('" + 
      (new Date(uaaPersonal.getFechaInicio().getTime())).toString().replace("-", "") + "' AS DATE ) and CAST('" +
    		  Fecha.sumarFechasDias(new Date(uaaPersonal.getFechaFin().getTime()), 3).toString().replace("-", "") + "' AS DATE )    and  CAST(up.uap_fecha_fin AS DATE )between CAST('" + (new Date(uaaPersonal.getFechaInicio().getTime())).toString().replace("-", "") + "' AS DATE ) and CAST('" + 
    		  Fecha.sumarFechasDias(new Date(uaaPersonal.getFechaFin().getTime()), 3).toString().replace("-", "") + "' AS DATE )    or uap_fecha_fin is null )  ");
      sql.append(" and  up.uap_cargo=? ");
      if (uaaPersonal.getPersona().getApellido() != null && uaaPersonal.getPersona().getApellido().length() > 0)
        sql.append(" and (p.per_apellido1 like '%" + uaaPersonal.getPersona().getApellido() + "%' or p.per_apellido2  like '%" + uaaPersonal.getPersona().getApellido() + "%' ) "); 
      if (uaaPersonal.getPersona().getNombre() != null && uaaPersonal.getPersona().getNombre().length() > 0)
        sql.append(" and  (p.per_nombre1 like '%" + uaaPersonal.getPersona().getNombre() + "%' or p.per_nombre2 like '%" + uaaPersonal.getPersona().getNombre() + "%' )"); 
      if (uaaPersonal.getPersona().getIdentificacion() != null && uaaPersonal.getPersona().getIdentificacion().length() > 0)
        sql.append(" and  p.per_identificacion like '" + uaaPersonal.getPersona().getIdentificacion() + "' "); 
      sql.append("  order by p.per_nombre1, p.per_nombre2,up.uap_fecha_fin desc ");
      conn = consegura.getconn_admin(admin);
      conn.setAutoCommit(false);
      sentencia = conn.prepareStatement(sql.toString());
      sentencia.setInt(1, 3);
      imp.info("sql " + sql.toString() + " <--> " + uaaPersonal.getPersona().getNombre());
      conn.commit();
      lista = UaaPersonalRowMapper.mapRow(sentencia.executeQuery(),imp);
      consegura.cerrarconn(conn, rs, sentencia);
    } catch (Exception e) {
    	imp.error("Error " + e.getMessage());
      consegura.cerrarconn(conn, rs, sentencia);
    } finally {
   	 consegura.cerrarconn(conn, rs, sentencia);
   }
    return lista;
  }
  
  public Object getTotal(Object obj) {
    return null;
  }
  
  public Object getVinculacion(Object obj) {
    Connection conn = null;
    PreparedStatement sentencia = null;
    this.imp = Logger.getLogger(getClass().getName());
    Object lista = null;
    ResultSet rs = null;
    Conexion consegura = new Conexion();
    StringBuffer sql = new StringBuffer();
    this.imp.info("valida el usuario--> ");
    try {
      WebParametro webParametro = new WebParametro("AGENDA_NOVEDAD_PERIODO");
      webParametro = (WebParametro)WebParametroLog.getObject(webParametro);
      Object[] param = (Object[])obj;
      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
      Usuario admin = (Usuario)param[1];
      sql = new StringBuffer();
      sql.append(this.SQL_SELECT);
      sql.append(" where up.uap_cargo=? ");
      sql.append(" and p.per_codigo  = ?  ");
      conn = consegura.getconn_admin(admin);
      conn.setAutoCommit(false);
      sentencia = conn.prepareStatement(sql.toString());
      sentencia.setInt(1, 3);
      sentencia.setInt(2, uaaPersonal.getPersona().getCodigo());
      this.imp.info("select Docentes " + uaaPersonal.getPersona().getCodigo());
      this.imp.info("select Docentes " + sql.toString());
      rs = sentencia.executeQuery();
      conn.commit();
      lista = UaaPersonalRowMapper.mapRow(sentencia.executeQuery(),imp);
      consegura.cerrarconn(conn, rs, sentencia);
    } catch (Exception e) {
      this.imp.error(e.toString());
      consegura.cerrarconn(conn, rs, sentencia);
    } finally {
   	 consegura.cerrarconn(conn, rs, sentencia);
   }
    return lista;
  }
  
  public Object getDocente(Object obj) {
    Connection conn = null;
    PreparedStatement sentencia = null;
    this.imp = Logger.getLogger(getClass().getName());
    LinkedList<UaaPersonal> lista = null;
    ResultSet rs = null;
    Conexion consegura = new Conexion();
    StringBuffer sql = new StringBuffer();
    this.imp.info("valida el usuario--> ");
    try {
      WebParametro webParametro = new WebParametro("AGENDA_NOVEDAD_PERIODO");
      webParametro = (WebParametro)WebParametroLog.getObject(webParametro);
      Object[] param = (Object[])obj;
      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
      Usuario admin = (Usuario)param[1];
      sql = new StringBuffer();
      sql.append(this.SQL_SELECT);
      sql.append("WHERE up.uap_codigo = ? ");
      conn = consegura.getconn_admin(admin);
      conn.setAutoCommit(false);
      sentencia = conn.prepareStatement(sql.toString());
      sentencia.setInt(1, uaaPersonal.getCodigo());
      this.imp.info("select Docentes " + sql.toString());
      rs = sentencia.executeQuery();
      conn.commit();
      lista = (LinkedList<UaaPersonal>)UaaPersonalRowMapper.mapRow(sentencia.executeQuery(),imp);
      consegura.cerrarconn(conn, rs, sentencia);
    } catch (Exception e) {
      this.imp.error(e.toString());
      consegura.cerrarconn(conn, rs, sentencia);
    } finally {
   	 consegura.cerrarconn(conn, rs, sentencia);
   }
    return lista.get(0);
  }
  /**
   * la dos n(2) la estoy usando para saber si la persona ala que se le va aponer el escalafon es docente 
   */
  public Object getReporte(Object obj) {
    Object[] param = (Object[])obj;
    int opt = ((Integer)param[2]).intValue();
    Object resultado = null;
    //System.out.println("llega --> "+opt);
    if (opt == 0) {
      resultado = getpersonalvinculado(obj); 
    }
    if (opt == 1) {
        resultado = getPersonaVinculacion(obj); 
      }
    if (opt == 2) {
        resultado = getEsDocente(obj); 
      }
    
    return resultado;
  }
  
  /**
   * utilizo -1 y -2 por que son vinculaciones que son parecidad
   * -1 catedra
   * -2asignacion de funciones
   * @param obj
   * @return
   */
  private Object getPersonaVinculacion(Object obj) {
	    Connection conn = null;
	    PreparedStatement sentencia = null;
	    this.imp = Logger.getLogger(getClass().getName());
	    LinkedList<UaaPersonal> lista = new LinkedList<>();
	    ResultSet rs = null;
	    Conexion consegura = new Conexion();
	    StringBuffer sql = new StringBuffer();
	    Usuario admin = null;
	    //System.out.println("valida el usuario--> " );
	    try {
	      Object[] param = (Object[])obj;
	      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
	      admin = (Usuario)param[1];
	      sql = new StringBuffer();
	      imp.info("valida el usuario--> " + uaaPersonal);
//	      sql.append(this.SQL_SELECT);
	      sql.append(this.SQL_SELECT_PERSONA);
	      sql.append(" where  ");
	      if (uaaPersonal.getPersona().getIdentificacion() != null && !uaaPersonal.getPersona().getIdentificacion().equals(""))
	        sql.append("   p.per_identificacion like '%" + uaaPersonal.getPersona().getIdentificacion().trim() + "%'  "); 
	      if (uaaPersonal.getPersona().getCodigo() > 0) {
	        sql.append("   p.per_codigo = " + uaaPersonal.getPersona().getCodigo() + "  ");
	        if(uaaPersonal.getCargo().getCodigo()>=0) {
	        	sql.append("   and   up.uap_cargo = " + uaaPersonal.getCargo().getCodigo() + "  ");
	        }
	        if(uaaPersonal.getVinculacion()!=null && uaaPersonal.getVinculacion().getCodigo()>0) {
	        	sql.append("   and   up.vin_codigo = " + uaaPersonal.getVinculacion().getCodigo() + "  ");
	        }
	        if(uaaPersonal.getVinculacion()!=null && uaaPersonal.getVinculacion().getCodigo()==-1) {
	        	sql.append("   and   up.vin_codigo  in(14,17,24,25 ) ");
	        }
	        if(uaaPersonal.getVinculacion()!=null && uaaPersonal.getVinculacion().getCodigo()==-2) {
	        	sql.append("   and   up.vin_codigo  in(46,47,48 ) ");
	        }
	        
	      } 
	     
	      sql.append(" order by   up.uap_fecha_inicio  desc,up.uap_fecha_fin asc ");
//	      imp.info("valida el usuario--> " + sql.toString());
	      
	      if (admin != null) {
	        conn = consegura.getconn_admin(admin);
	      } else {
	        conn = consegura.conexionConsulta();
	      } 
	      conn.setAutoCommit(false);
	      sentencia = conn.prepareStatement(sql.toString());
	      this.imp.info("select Docentes " + sql.toString());
//	      System.out.println("select Docentes " + sql.toString());
	      rs = sentencia.executeQuery();
	      conn.commit();
	      lista = (LinkedList<UaaPersonal>)UaaPersonalRowMapper.mapRow(sentencia.executeQuery(),imp);
	      consegura.cerrarconn(conn, rs, sentencia);
	    } catch (Exception e) {
	      this.imp.error(e.toString());
//	    	System.out.println(e.toString());
	      consegura.cerrarconn(conn, rs, sentencia);
	      
	    }finally {
	    	 consegura.cerrarconn(conn, rs, sentencia);	
	    }
	    return lista;
	  }
  
  private Object getEsDocente(Object obj) {
	    Connection conn = null;
	    PreparedStatement sentencia = null;
	    this.imp = Logger.getLogger(getClass().getName());
	    LinkedList<UaaPersonal> lista = new LinkedList<>();
	    ResultSet rs = null;
	    Conexion consegura = new Conexion();
	    StringBuffer sql = new StringBuffer();
	    Usuario admin = null;
	    try {
	      Object[] param = (Object[])obj;
	      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
	      admin = (Usuario)param[1];
	      sql = new StringBuffer();
	      sql.append(this.SQL_SELECT_PERSONA);
	      sql.append(" where  ");	      
	        sql.append("   p.per_codigo = " + uaaPersonal.getPersona().getCodigo() + "  ");
	        sql.append("   and  up.uap_cargo = " + uaaPersonal.getCargo().getCodigo() + "  ");
	      sql.append(" order by   up.uap_fecha_inicio  desc,up.uap_fecha_fin asc ");
//	      imp.info("valida el usuario--> " + sql.toString());
	      if (admin != null) {
	        conn = consegura.getconn_admin(admin);
	      } else {
	        conn = consegura.conexionConsulta();
	      } 
	      conn.setAutoCommit(false);
	      sentencia = conn.prepareStatement(sql.toString());
	      this.imp.info("select es docente " + sql.toString());
//	      System.out.println("select Docentes " + sql.toString());
	      rs = sentencia.executeQuery();
	      conn.commit();
	      lista = (LinkedList<UaaPersonal>)UaaPersonalRowMapper.mapRow(sentencia.executeQuery(),imp);
	      consegura.cerrarconn(conn, rs, sentencia);
	    } catch (Exception e) {
	      this.imp.error(e.toString());
//	    	System.out.println(e.toString());
	      consegura.cerrarconn(conn, rs, sentencia);
	      
	    }finally {
	    	 consegura.cerrarconn(conn, rs, sentencia);	
	    }
	    if(lista!=null && lista.size()>0) {
	    	 return true;
	    }
	    
	    return false ;
	  }
  private Object getpersonalvinculado(Object obj) {
    Connection conn = null;
    PreparedStatement sentencia = null;
    this.imp = Logger.getLogger(getClass().getName());
    LinkedList<UaaPersonal> lista = new LinkedList<>();
    ResultSet rs = null;
    Conexion consegura = new Conexion();
    StringBuffer sql = new StringBuffer();
    this.imp.info("valida el usuario--> ");
    Usuario admin = null;
    try {
      Object[] param = (Object[])obj;
      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
    
      admin = (Usuario)param[1];
      sql = new StringBuffer();
      sql.append(this.SQL_SELECT);
      sql.append(
          " inner join periodo pe with(nolock)  on ( CAST(up.uap_fecha_inicio AS DATE )between CAST(pe.per_fecha_inicio AS DATE ) and CAST(pe.per_fecha_fin AS DATE )  OR  CAST(up.uap_fecha_fin AS DATE )between CAST(pe.per_fecha_inicio AS DATE ) and CAST(pe.per_fecha_fin AS DATE ) ) or uap_fecha_fin is null   ");
      sql.append(" where  ");
      sql.append("  p.per_apellido1  like '%" + uaaPersonal.getPersona().getApellido().trim() + "%'  ");
      sql.append("  and p.per_nombre1 like  '%" + uaaPersonal.getPersona().getNombre().trim() + "%'");
      sql.append("  and p.per_apellido2  like '%" + uaaPersonal.getPersona().getApellido2().trim() + "%'  ");
      sql.append("  and p.per_nombre2 like  '%" + uaaPersonal.getPersona().getNombre2().trim() + "%'");
      sql.append("  and p.per_identificacion like '%" + uaaPersonal.getPersona().getIdentificacion().trim() + "%'   order by up.uap_fecha_fin desc");
      //this.imp.info("valida el usuario--> " + sql.toString());
      if (admin != null) {
        conn = consegura.getconn_admin(admin);
      } else {
        conn = consegura.conexionConsulta();
      } 
      
      conn = consegura.conexion_segura();
      conn.setAutoCommit(false);
      sentencia = conn.prepareStatement(sql.toString());
      this.imp.info("select Docentes " + sql.toString());
      rs = sentencia.executeQuery();
      conn.commit();
      lista = (LinkedList<UaaPersonal>)UaaPersonalRowMapper.mapRow(sentencia.executeQuery(),imp);
      consegura.cerrarconn(conn, rs, sentencia);
    } catch (Exception e) {
      this.imp.error(e.toString());
      consegura.cerrarconn(conn, rs, sentencia);
    } finally {
   	 consegura.cerrarconn(conn, rs, sentencia);
   }
    return lista;
  }
  private Object isDocente(Object obj) {
	    Connection conn = null;
	    PreparedStatement sentencia = null;
	    this.imp = Logger.getLogger(getClass().getName());
	    LinkedList<UaaPersonal> lista = new LinkedList<>();
	    ResultSet rs = null;
	    Conexion consegura = new Conexion();
	    StringBuffer sql = new StringBuffer();
	    Usuario admin = null;
	    try {
	      Object[] param = (Object[])obj;
	      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
	    
	      admin = (Usuario)param[1];
	      sql = new StringBuffer();
	      sql.append(this.SQL_SELECT_PERSONA);
	      sql.append(
	          " inner join periodo pe with(nolock)  on ( CAST(up.uap_fecha_inicio AS DATE )between CAST(pe.per_fecha_inicio AS DATE ) and CAST(pe.per_fecha_fin AS DATE )  OR  CAST(up.uap_fecha_fin AS DATE )between CAST(pe.per_fecha_inicio AS DATE ) and CAST(pe.per_fecha_fin AS DATE ) ) or uap_fecha_fin is null   ");
	      sql.append(" where  ");
	      sql.append("  p.per_apellido1  like '%" + uaaPersonal.getPersona().getApellido().trim() + "%'  ");
	     
	      sql.append("  and p.per_nombre1 like  '%" + uaaPersonal.getPersona().getNombre().trim() + "%'");
	      sql.append("  and p.per_apellido2  like '%" + uaaPersonal.getPersona().getApellido2().trim() + "%'  ");
	      sql.append("  and p.per_nombre2 like  '%" + uaaPersonal.getPersona().getNombre2().trim() + "%'");
	      sql.append("  and p.per_identificacion like '%" + uaaPersonal.getPersona().getIdentificacion().trim() + "%'   order by up.uap_fecha_fin desc");
	      this.imp.info("isDocente --> " + sql.toString());
	      if (admin != null) {
	        conn = consegura.getconn_admin(admin);
	      } else {
	        conn = consegura.conexionConsulta();
	      } 
	      
	      conn = consegura.conexion_segura();
	      conn.setAutoCommit(false);
	      sentencia = conn.prepareStatement(sql.toString());
	      rs = sentencia.executeQuery();
	      conn.commit();
	      lista = (LinkedList<UaaPersonal>)UaaPersonalRowMapper.mapRow(sentencia.executeQuery(),this.imp);
	      consegura.cerrarconn(conn, rs, sentencia);
	    } catch (Exception e) {
	      this.imp.error(e.toString());
	      consegura.cerrarconn(conn, rs, sentencia);
	    } finally {
	   	 consegura.cerrarconn(conn, rs, sentencia);
	   }
	    return lista;
	  }
  
  public Object ocupaCargoAdmin(Object obj) {
	    Connection conn = null;
	    PreparedStatement sentencia = null;
	    this.imp = Logger.getLogger(getClass().getName());
	    LinkedList<UaaPersonal> lista = new LinkedList<>();
	    ResultSet rs = null;
	    Conexion consegura = new Conexion();
	    StringBuffer sql = new StringBuffer();
	    Usuario admin = null;
	    boolean dato=false;
	    try {
	      Object[] param = (Object[])obj;
	      UaaPersonal uaaPersonal = (UaaPersonal)param[0];
	    
	      admin = (Usuario)param[1];
	      sql = new StringBuffer();
	      sql.append("SELECT coalesce(count(*),0)  as dato FROM uaa_personal up ");
		  sql.append("inner join uaa_cargo uc on(up.uac_codigo=uc.uac_codigo) ");
		  sql.append("inner join vinculacion v on(v.vin_codigo=uc.uac_vinculacion) ");
		  sql.append("where up.uap_cargo =0 and  ");
		  sql.append("(up.uap_fecha_fin is null or up.uap_uacocupado=1) and   ");
		  sql.append("up.per_codigo="+uaaPersonal.getPersona().getCodigo()+" and v.vin_codigo !=5 ");
	      
	      
	      this.imp.info("ocupaCargoAdmin --> " + sql.toString());
	      if (admin != null) {
	        conn = consegura.getconn_admin(admin);
	      } else {
	        conn = consegura.conexionConsulta();
	      } 
	      
	      conn = consegura.conexion_segura();
	      conn.setAutoCommit(false);
	      sentencia = conn.prepareStatement(sql.toString());
	      rs = sentencia.executeQuery();
	      conn.commit();
	    
		      while (rs.next()) {
		    	  if(rs.getInt("dato")>0) {
		    		  dato=true;
		    	  }
		      }
		      
	      //lista = (LinkedList<UaaPersonal>)UaaPersonalRowMapper.mapRow(sentencia.executeQuery());
	      consegura.cerrarconn(conn, rs, sentencia);
	    } catch (Exception e) {
	      this.imp.error(e.toString());
	      consegura.cerrarconn(conn, rs, sentencia);
	    } finally {
	   	 consegura.cerrarconn(conn, rs, sentencia);
	   }
	    return dato;
	  }

/**
 * @return the sQL_SELECT_PERSONA
 */
public String getSQL_SELECT_PERSONA() {
	return SQL_SELECT_PERSONA;
}


/**
 * metodo e consulta para generar el reporte de los docentes de la universidad. este reporte es el que se utilisa para generar el reporte que se le entrega a manuel y que el lo envie a el esnies
 * @param obj
 * @return
 */
public Object getAllSnies(Object obj) {

	Connection conn = null;
							
	Statement sentencia = null;
	ResultSet resul = null;
	//LinkedList<uaa_personalOb> lista = null;
	 this.imp = Logger.getLogger(getClass().getName());
	LinkedList<UaaPersonal> lista = null;
	StringBuffer sql = null;
	Conexion consegura = new Conexion();
	Object datos[] = (Object[]) obj;
	int periodo = (int) datos[0];
	int vin_codigo = (int) datos[1];
	int sede_codigo = (int) datos[2];

	String vinculacion="";

		if(vin_codigo==12) {
			vinculacion="and uap.vin_codigo in("+vin_codigo+") and uap.ded_codigo in(4,5) ";	
		}
		else if(vin_codigo==24) {
			vinculacion="and uap.vin_codigo in("+vin_codigo+") and uap.ded_codigo in(4,5,6) ";	
		}
		else if(vin_codigo==0) {
			vinculacion="and uap.vin_codigo in(12,13,14,16,19,23,24,25) ";
		}else {
			vinculacion="and uap.vin_codigo in("+vin_codigo+") ";
		}
		

	
	try {
		//String uaa = "";
		
		sql = new StringBuffer();
		sql.append("DECLARE @tempotalb TABLE (uap_codigo int,per_codigo int,tii_codigo_hecaa varchar(3),tid_codigo int,tid_nombre varchar(50),per_identificacion varchar(20),nac_mun_codigo int,exp_mun_codigo int,vin_codigo int,vin_nombre varchar(100),ded_codigo int,ded_nombre varchar(100),ded_codigo_hecaa int,genero varchar(2),per_nombre varchar(100),per_apellido varchar(100),per_email_interno varchar(100),per_email varchar(100),  per_telefono_fijo varchar(100),per_telefono_movil varchar(100),fechaNac  date, uap_fecha_inicio  date ,nia_codigo int,nia_nombre varchar(100),nia_codigo_ned_hecaa int,pha_codigo int,  pha_convalidado int, pha_titulo varchar(500), pha_fecha_titulo date,ine_codigo_hecaa int, ine_nombre varchar(100), mo_mod_codigo int,  mo_hecaa_codigo int,mo_mod_nombre varchar(100) , ie_mun_codigo int ,pa_pai_codigo_hecaa int	,uaa_nombre_corto varchar(100),facultad varchar(100),escalafon varchar(100),sede varchar(100), academica int, INSTITUCIONAL int, INVESTIGACION int, PROYECCION int, ADMINISTRATIVAS int, ACTINVESTIGACION int, ACTIPROYECCION int,DOCENCIA int, fechaInicio Date, fechaFin date ,salario decimal(20,2), esc_codigo int, "
				+ "dp_categoria decimal(7,2),dp_pregrado decimal(7,2),dp_especializacion decimal(7,2),dp_especializacion_medica decimal(7,2),dp_maestria decimal(7,2),dp_doctorado decimal(7,2),dp_exp_calificada decimal(7,2) "
				+ ",dp_exp_adtiva decimal(7,2),dp_articulos_revista decimal(7,2),dp_libros decimal(7,2),dp_cap_libro decimal(7,2),dp_obra_artistica decimal(7,2),dp_premios decimal(7,2),dp_patentes decimal(7,2),dp_produccion_tecnica decimal(7,2),dp_software decimal(7,2),dp_traducciones decimal(7,2),dp_videos decimal(7,2),dp_otras_salariales decimal(7,2),dp_total_salariales decimal(7,2)"
				+ ",dp_bonific_x_produccion decimal(7,2),dp_bonific_x_exp decimal(7,2),dp_total_bonificacion decimal(7,2),dp_salario decimal(11,2) , dp_periodo int )  ");
		sql.append("insert into @tempotalb(  per_codigo, tii_codigo_hecaa,tid_codigo ,tid_nombre ,per_identificacion,nac_mun_codigo ,exp_mun_codigo ,vin_codigo ,vin_nombre ,ded_codigo ,ded_nombre,ded_codigo_hecaa, genero ,per_nombre ,per_apellido,per_email_interno, per_email , per_telefono_fijo, per_telefono_movil, fechaNac, uap_fecha_inicio, uaa_nombre_corto, facultad, sede,pha_codigo ,academica,INSTITUCIONAL,INVESTIGACION, PROYECCION,ADMINISTRATIVAS,ACTINVESTIGACION,ACTIPROYECCION,DOCENCIA,fechaInicio,fechaFin)      ");
		sql.append("select distinct p.per_codigo,ti.tii_codigo_hecaa, ti.tii_codigo,ti.tii_nombre, per_identificacion,per_lugar_nacimiento,per_lugar_expedicion,v.vin_codigo,v.vin_nombre,d.ded_codigo,d.ded_nombre,d.ded_codigo_hecaa, p.per_genero, p.per_nombre, p.per_apellido,p.per_email_interno, p.per_email , p.per_telefono_fijo, p.per_telefono_movil,CONVERT(varchar,p.per_fecha_nacimiento, 103) as per_fecha_nacimiento, CONVERT(varchar,uap.uap_fecha_inicio, 103) as uap_fecha_inicio, uaa.uaa_nombre_corto,(select u.uaa_nombre_corto from uaa u where u.uaa_codigo=uaa.uaa_dependencia  ) as facultad,s.sed_nombre,   (select top 1 pha_codigo   from persona_historia_academica pha    inner join nivel_academico na on(na.nia_codigo=pha.nia_codigo )    inner join institucion_educativa ie on(ie.ine_codigo=pha.ine_codigo )    left join  modalidad mo on(mo.mod_codigo=pha.pha_mod_codigo)    left join  municipio mun on( ie.mun_codigo=mun.mun_codigo )    left join  departamento dpto on(mun.dep_codigo=dpto.dep_codigo )    left join  pais pa on(dpto.pai_codigo=pa.pai_codigo)  ");
		//sql.append("inner join periodo pe on(( cast(pha.pha_fecha_titulo as DATE) <= cast(pe.per_fecha_fin as DATE) or cast(pha.pha_fecha_titulo as DATE) is null) )      ");
		sql.append("inner join periodo pe on(pe.per_codigo ="+periodo+")     ");
		sql.append("where pha.per_codigo =p.per_codigo  and (( cast(pha.pha_fecha_titulo as DATE) <= cast(pe.per_fecha_fin as DATE) or cast(pha.pha_fecha_titulo as DATE) is null) ) "
				+ " and pe.per_codigo ="+periodo+"  order by na.nia_orden desc  ) as pha,   ");
			
//		sql.append("(case when (uap.vin_codigo =12 or uap.vin_codigo=23) and (uap.ded_codigo=5 or uap.ded_codigo=4)  then (select coalesce(sum(ag.factor),0) from  curso cur with(nolock), periodo per with(nolock), agenda_periodo ag with(nolock), calendario cal with(nolock), asignatura asi with(nolock)   where cur.cur_codigo=ag.cur_codigo and cal.per_codigo=per.per_codigo and asi.asi_codigo=cur.asi_codigo and ag.uap_codigo=uap.uap_codigo  and cal.cal_codigo=cur.cal_codigo and cal.per_codigo ="+periodo+"  and ag.per_codigo=uap.per_codigo  )");
//		sql.append("(case when (uap.vin_codigo =12 or uap.vin_codigo=24 or uap.vin_codigo=23) and (uap.ded_codigo=5 or uap.ded_codigo=4)  then  (select total_docencia from carga_academica where uap_codigo=uap.uap_codigo and per_codigo="+periodo+") ");
//		sql.append("else  (select coalesce(sum(ag.numero_total_hora),0) from  curso cur with(nolock), periodo per with(nolock), agenda_periodo ag with(nolock), calendario cal with(nolock), asignatura asi with(nolock)   where cur.cur_codigo=ag.cur_codigo and cal.per_codigo=per.per_codigo and asi.asi_codigo=cur.asi_codigo and ag.uap_codigo=uap.uap_codigo  and cal.cal_codigo=cur.cal_codigo and cal.per_codigo ="+periodo+"  and ag.per_codigo=uap.per_codigo) end) as academica, ");
		
		
		sql.append("\r\n"); 
		sql.append("( select SUM( agp.factor ) as carga_academica "); 
		sql.append("from agenda_periodo agp  "); 
//		--saca todos los cursos y subgrupos en donde un profe da clase//
		sql.append("inner join (select eso.eso_actividad, eso.eso_subgrupo,uap.per_codigo  "); 
//		--saca cursos del periodo 
		sql.append("from ( select cur.cur_codigo "); 
		sql.append("from curso cur  ");
		sql.append("inner join calendario cl on(cl.cal_codigo=cur.cal_codigo) "); 
		sql.append("where  cl.per_codigo= "+periodo+" and cl.cal_nombre not like'%B' "); 
		sql.append(") as cur "); 
//		--saca todas las horas de clase--de los cursos del 
		sql.append("inner join ( select * from espacio_ocupacion "); 
		sql.append("union all ");
		sql.append("select * from espacio_ocupacion_historico ");
		sql.append(")as eso on eso.eso_actividad = cur.cur_codigo ");
		sql.append("inner join uaa_personal uap on (uap.uap_codigo=eso.uap_codigo) "); 
		sql.append("where p.per_codigo = uap.per_codigo  and uap.vin_codigo<>17 ");
		//--despues de haber sacado todo los cursos y subgrupos donde dicta clase,-- hace la union de cada curso t subgrupo con agenda_periodo para saber la carga
		sql.append("group by eso.eso_actividad, eso.eso_subgrupo,uap.per_codigo "); 
		sql.append(")as a on agp.sub_grupo=a.eso_subgrupo and a.eso_actividad=agp.cur_codigo and agp.per_codigo=a.per_codigo) as academia,");
		
		sql.append("(select  coalesce(sum(pep_hora_semana*pep_semanas),0) from proyecto with(nolock),proyecto_tipo with(nolock),persona_proyecto with(nolock),periodo  with(nolock)  where proyecto.pry_codigo = persona_proyecto.pry_codigo and   proyecto_tipo.prt_codigo = proyecto.prt_codigo and   periodo.per_codigo = persona_proyecto.per_codigo and pep_persona= uap.per_codigo and periodo.per_codigo like "+periodo+" and proyecto.prt_codigo=2 ) as INSTITUCIONAL,  ");
		sql.append("(select  coalesce(sum(dpp_horas_semana*dpp_numero_semanas) ,0) from periodo pd with(nolock), proyectos.proyecto_proyeccion_social p with(nolock)  inner join proyectos.docentexproyecto_proyeccion_social dxp with(nolock) on p.pps_codigo = dxp.pps_codigo   left join proyectos.mc_proyecto_area pa with(nolock) on p.pra_codigo = pa.pra_codigo  inner join uaa_personal up with(nolock) on up.uap_codigo=dxp.uap_codigo  where up.per_codigo= uap.per_codigo and dpp_periodo=pd.per_codigo and pd.per_codigo="+periodo+"  and pa.pra_codigo in( 3) ) as INVESTIGACION,  ");
		sql.append("(select  coalesce(sum(dpp_horas_semana*dpp_numero_semanas) ,0) from periodo pd with(nolock), proyectos.proyecto_proyeccion_social p with(nolock)  inner join proyectos.docentexproyecto_proyeccion_social dxp with(nolock) on p.pps_codigo = dxp.pps_codigo   left join proyectos.mc_proyecto_area pa with(nolock) on p.pra_codigo = pa.pra_codigo  inner join uaa_personal up with(nolock) on up.uap_codigo=dxp.uap_codigo  where up.per_codigo= uap.per_codigo and dpp_periodo=pd.per_codigo and pd.per_codigo="+periodo+" and pa.pra_codigo in( 4) ) as PROYECCION,  ");
		sql.append("(select  coalesce(sum(persona_novedad.pen_descarga_semestral ),0) from persona_novedad with(nolock) , novedad  with(nolock),periodo with(nolock)  where persona_novedad.nov_codigo = novedad.nov_codigo and periodo.per_codigo = persona_novedad.per_codigo and  persona_novedad.pen_persona = uap.per_codigo and persona_novedad.uap_codigo=uap.uap_codigo  and  periodo.per_codigo like "+periodo+" and novedad.not_codigo in (9) and persona_novedad.pen_estado=1 ) as ADMINISTRATIVAS,  ");
		sql.append("(select  coalesce(sum(persona_novedad.pen_descarga_semestral ),0) from persona_novedad with(nolock) , novedad  with(nolock),periodo with(nolock)  where persona_novedad.nov_codigo = novedad.nov_codigo and periodo.per_codigo = persona_novedad.per_codigo and  persona_novedad.pen_persona = uap.per_codigo and persona_novedad.uap_codigo=uap.uap_codigo  and  periodo.per_codigo like "+periodo+" and novedad.not_codigo in (7) and persona_novedad.pen_estado=1 ) as ACTINVESTIGACION,  ");
		
		sql.append("(select  coalesce(sum(persona_novedad.pen_descarga_semestral ),0) from persona_novedad with(nolock) , novedad  with(nolock),periodo with(nolock)  where persona_novedad.nov_codigo = novedad.nov_codigo and periodo.per_codigo = persona_novedad.per_codigo and  persona_novedad.pen_persona = uap.per_codigo and persona_novedad.uap_codigo=uap.uap_codigo  and  periodo.per_codigo like "+periodo+" and novedad.not_codigo in (8) and persona_novedad.pen_estado=1 ) as ACTIPROYECCION, ");
		sql.append("(select  coalesce(sum(persona_novedad.pen_descarga_semestral ),0) from persona_novedad with(nolock) , novedad  with(nolock),periodo with(nolock)     where persona_novedad.nov_codigo = novedad.nov_codigo and periodo.per_codigo = persona_novedad.per_codigo and  persona_novedad.pen_persona = uap.per_codigo and persona_novedad.uap_codigo=uap.uap_codigo  and  periodo.per_codigo like "+periodo+" and novedad.not_codigo in (11) and persona_novedad.pen_estado=1 ) as DOCENCIA,   ");
//		sql.append("(select  coalesce(sum(persona_novedad.pen_descarga_semestral ),0)   from   persona_novedad with(nolock) , novedad  with(nolock),periodo with(nolock)  where persona_novedad.nov_codigo = novedad.nov_codigo and periodo.per_codigo = persona_novedad.per_codigo and  persona_novedad.pen_persona = uap.per_codigo and persona_novedad.uap_codigo=uap.uap_codigo  and  periodo.per_codigo like 116 and novedad.not_codigo in (7) and persona_novedad.pen_estado=1 ) as ACTINVESTIGACION,  ");
		
		sql.append("uap.uap_fecha_inicio,coalesce(uap.uap_fecha_fin,(select getdate())) ");
		sql.append("from uaa_personal uap with(nolock)    ");
		sql.append("inner join persona p with(nolock) on uap.per_codigo = p.per_codigo  ");
		sql.append("inner join tipo_id ti with(nolock) on ti.tii_codigo=p.tii_codigo  ");
		sql.append("inner join periodo pe with(nolock)  on ( pe.per_codigo="+periodo+" )  inner join periodo pe2 with(nolock)  on ( pe2.per_codigo=("+periodo+"+1) )    left join vinculacion v on v.vin_codigo = uap.vin_codigo    inner join dedicacion d on d.ded_codigo=uap.ded_codigo    left join uaa with(nolock) on (uaa.uaa_codigo= uap.uaa_codigo)  left join sede s with(nolock) on (s.sed_codigo=uaa.sed_codigo)    "
		//sql.append("inner join periodo pe with(nolock)  on ( per_fecha_inicio <= per_fecha_fin and uap_fecha_inicio <= uap_fecha_fin ) or uap_fecha_fin is null      left join vinculacion v on v.vin_codigo = uap.vin_codigo    inner join dedicacion d on d.ded_codigo=uap.ded_codigo    left join uaa with(nolock) on (uaa.uaa_codigo= uap.uaa_codigo)  left join sede s with(nolock) on (s.sed_codigo=uaa.sed_codigo)    "
				//+ "where(  (per_fecha_inicio <= uap_fecha_inicio and per_fecha_fin >= uap_fecha_fin)  or (per_fecha_inicio >= uap_fecha_inicio and per_fecha_fin <= uap_fecha_fin)  or (per_fecha_inicio >= uap_fecha_inicio and per_fecha_inicio <= uap_fecha_fin )  or (per_fecha_fin >= uap_fecha_inicio and per_fecha_fin <= uap_fecha_fin )    or (per_fecha_fin >= uap_fecha_inicio and uap_fecha_fin is null ) )  "
//				+" where (uap_fecha_inicio between pe.per_fecha_inicio and pe.per_fecha_fin  and uap_fecha_fin between pe.per_fecha_inicio and pe2.per_fecha_inicio or uap_fecha_fin is null)  "
				+" where ((uap_fecha_inicio between pe.per_fecha_inicio and pe.per_fecha_fin  or uap_fecha_fin between pe.per_fecha_inicio and pe.per_fecha_inicio)  "
				+ "or  uap_fecha_fin between pe.per_fecha_inicio and pe.per_fecha_inicio or ( uap_fecha_inicio <= pe.per_fecha_fin and uap_fecha_fin is null))"
				+ "and  pe.per_codigo ="+periodo+"   and (p.per_apellido not like '%NN CATE%' and p.per_apellido not like '%NNPROYE%')  "+vinculacion +" ");
		sql.append("UPDATE @tempotalb set nia_codigo= na.nia_codigo,nia_nombre=na.nia_nombre,nia_codigo_ned_hecaa=na.nia_codigo_ne_hecaa , pha_convalidado=pha.pha_convalidado , pha_titulo = pha.pha_titulo, pha_fecha_titulo =  CONVERT(VARCHAR ,pha.pha_fecha_titulo,103),ine_codigo_hecaa =ie.ine_codigo_hecaa, ine_nombre =ie.ine_nombre , mo_hecaa_codigo = mo.hecaa_codigo,mo_mod_nombre = mo.mod_nombre,ie_mun_codigo =ie.mun_codigo ,pa_pai_codigo_hecaa =pa.pai_codigo_hecaa	  from @tempotalb as t,persona_historia_academica pha  inner join nivel_academico na on(na.nia_codigo=pha.nia_codigo )  inner join institucion_educativa ie on(ie.ine_codigo=pha.ine_codigo )  left join  modalidad mo on(mo.mod_codigo=pha.pha_mod_codigo)  left join  municipio mun on( ie.mun_codigo=mun.mun_codigo )  left join  departamento dpto on(mun.dep_codigo=dpto.dep_codigo )  left join  pais pa on(dpto.pai_codigo=pa.pai_codigo)  where pha.per_codigo =t.per_codigo and pha.pha_codigo=t.pha_codigo ");
		sql.append("UPDATE @tempotalb set escalafon= e.esc_nombre, esc_codigo=e.esc_codigo  from @tempotalb as t,docente_escalafon de ,escalafon e,periodo pe   where de.esc_codigo = e.esc_codigo and de.per_codigo =t.per_codigo and cast(de.doe_fecha_fin as DATE)  is null      ");
		sql.append("UPDATE @tempotalb set salario = dp.dp_salario, "
				+ "dp_categoria=dp.dp_categoria,dp_pregrado=dp.dp_pregrado,dp_especializacion=dp.dp_especializacion,dp_especializacion_medica=dp.dp_especializacion_medica,dp_maestria=dp.dp_maestria,dp_doctorado=dp.dp_doctorado,dp_exp_calificada=dp.dp_exp_calificada, "
				+ "dp_exp_adtiva=dp.dp_exp_adtiva,dp_articulos_revista=dp.dp_articulos_revista,dp_libros=dp.dp_libros,dp_cap_libro=dp.dp_cap_libro,dp_obra_artistica=dp.dp_obra_artistica,dp_premios=dp.dp_premios,dp_patentes=dp.dp_patentes,dp_produccion_tecnica=dp.dp_produccion_tecnica,dp_software=dp.dp_software,dp_traducciones=dp.dp_traducciones,dp_videos=dp.dp_videos,dp_otras_salariales=dp.dp_otras_salariales,dp_total_salariales=dp.dp_total_salariales, "
				+ "dp_bonific_x_produccion=dp.dp_bonific_x_produccion,dp_bonific_x_exp=dp.dp_bonific_x_exp,dp_total_bonificacion=dp.dp_total_bonificacion ,dp_periodo=dp.dp_periodo    "
				+ ""
				+ ""
				+ ""
				+ ""
				+ "from @tempotalb as t, docente_puntos dp where dp.dp_per_codigo=t.per_codigo and dp.dp_periodo="+periodo+" ");
		sql.append("select distinct per_codigo,tii_codigo_hecaa,tid_codigo,tid_nombre,per_identificacion,nac_mun_codigo,exp_mun_codigo,vin_codigo,vin_nombre,ded_codigo,ded_nombre,ded_codigo_hecaa,genero,per_nombre,per_apellido,per_email_interno, per_email , per_telefono_fijo, per_telefono_movil,fechaNac,uap_fecha_inicio,nia_codigo,nia_nombre,nia_codigo_ned_hecaa,pha_codigo,pha_convalidado,pha_titulo,pha_fecha_titulo,ine_codigo_hecaa,ine_nombre,mo_hecaa_codigo,mo_mod_codigo,mo_mod_nombre,ie_mun_codigo,pa_pai_codigo_hecaa,uaa_nombre_corto,facultad,escalafon,sede,  coalesce(m.mun_codigo,0) as cmnac, m.mun_nombre as nmnac, m.sippa_mun_codigo as smnac, m.SNIES_codigo as snmnac, coalesce(d.dep_codigo,0) as cdnac, d.dep_acronimo as adnac,d. dep_nombre as ndnac, d.sippa_dep_codigo as sdnac, d.dane_codigo as ddnac, pa.pai_codigo as cpnac, pa.pai_acronimo as apnac, pa.pai_nombre as npnac,pa.sippa_pai_codigo as spnac, pa.pai_codigo_hecaa as hpnac,  me.mun_codigo cmexp, me.mun_nombre nmexp, me.sippa_mun_codigo smexp, me.SNIES_codigo snmexp, de.dep_codigo cdexp, de.dep_acronimo adexp, de.dep_nombre ndexp, de.sippa_dep_codigo sdexp, de.dane_codigo ddexp, pae.pai_codigo cpexp, pae.pai_acronimo apexp, pae.pai_nombre npexp, pae.sippa_pai_codigo spexp, pae.pai_codigo_hecaa hpexp,coalesce(academica,0) as academica,INSTITUCIONAL,INVESTIGACION, PROYECCION,ADMINISTRATIVAS,ACTINVESTIGACION,ACTIPROYECCION,DOCENCIA,fechaInicio,fechaFin,(SELECT DATEDIFF(month, fechaInicio, fechaFin)) AS DateDiff, salario, esc_codigo,"
				+ "dp_categoria,dp_pregrado,dp_especializacion,dp_especializacion_medica,dp_maestria,dp_doctorado,dp_exp_calificada"
				+ " ,dp_exp_adtiva,dp_articulos_revista,dp_libros,dp_cap_libro,dp_obra_artistica,dp_premios,dp_patentes,dp_produccion_tecnica,dp_software,dp_traducciones,dp_videos,dp_otras_salariales,dp_total_salariales"
				+ ",dp_bonific_x_produccion,dp_bonific_x_exp,dp_total_bonificacion, dp_periodo ");

		sql.append("from @tempotalb  t  LEFT JOIN municipio m ON(m.mun_codigo=t.nac_mun_codigo)  LEFT JOIN departamento d ON(d.dep_codigo=m.dep_codigo)  LEFT JOIN pais pa ON(pa.pai_codigo=d.pai_codigo)  LEFT JOIN municipio me ON(me.mun_codigo=t.exp_mun_codigo)  LEFT JOIN departamento de ON(de.dep_codigo=me.dep_codigo)  LEFT JOIN pais pae ON(pae.pai_codigo=de.pai_codigo) ");
		sql.append(" where fechaInicio < fechaFin  order by per_identificacion, vin_codigo");
		sql.append(" ");
		sql.append(" ");
		sql.append(" ");
		sql.append(" ");
		sql.append(" ");
		sql.append(" ");
		sql.append(" "); 
		Usuario admin= new Usuario();
//		admin.setSys("jcabrera");
//		 admin.getUrl().setUrl("jdbc:sqlserver://172.16.1.83:1433");
//		 admin.getUrl().setBasedato("academia3000");
//		 admin.setClave2("Javier.89:");
//		conn=consegura.getconn_admin(admin);
		conn=consegura.conexionConsulta();
		sentencia = conn.createStatement();
		resul = sentencia.executeQuery(sql.toString());
		imp.info("consulta --->" + sql.toString());
//		System.out.println("kkkkkk db1"+sql.toString());
		lista = new LinkedList<UaaPersonal>();
//		lista = new LinkedList<uaa_personalOb>();
		while (resul.next()) {
			UaaPersonal elemento = new UaaPersonal();				
//			uaa_personalOb elemento = new uaa_personalOb();
			elemento.getPersona().setCodigo(resul.getInt("per_codigo"));
			elemento.getPersona().setIdentificacion(resul.getString("per_identificacion"));
			elemento.getPersona().getTipoId().setCodigo(resul.getInt("tid_codigo"));
			elemento.getPersona().getTipoId().setCodigoHecaa(resul.getString("tii_codigo_hecaa"));
			elemento.getPersona().getTipoId().setNombre(resul.getString("tid_nombre"));
			elemento.getPersona().getTipoId().setSniesCodigo(resul.getString("snmnac"));
//			uaa_personal.getPersona().getMun_nacimiento().setDane_codigo(resul.getString("dmnac"));
			elemento.getPersona().getLugarNacimiento().setNombre(resul.getString("nmnac"));
			elemento.getPersona().getLugarNacimiento().setCodigo(resul.getInt("cmnac"));
			elemento.getPersona().getLugarNacimiento().setSNIESCodigo(resul.getString("snmnac"));
			elemento.getPersona().getLugarNacimiento().getDepartamento().setCodigo(resul.getInt("cdnac"));
			elemento.getPersona().getLugarNacimiento().getDepartamento().setNombre(resul.getString("ndnac"));
			elemento.getPersona().getLugarNacimiento().getDepartamento().setDaneCodigo(resul.getString("ddnac"));
			elemento.getPersona().getLugarNacimiento().getDepartamento().getPais().setCodigo(resul.getInt("cpnac"));
			elemento.getPersona().getLugarNacimiento().getDepartamento().getPais().setNombre(resul.getString("npnac"));
			elemento.getPersona().getLugarNacimiento().getDepartamento().getPais().setCodigoHecaa(resul.getInt("hpnac"));
		
			elemento.getPersona().getLugarExpedicion().setCodigo(resul.getInt("cmexp"));
			elemento.getPersona().getLugarExpedicion().setNombre(resul.getString("nmexp"));
			elemento.getPersona().getLugarExpedicion().setSNIESCodigo(resul.getString("snmexp"));
//			uaa_personal.getPersona().getMun_nacimiento().setDane_codigo(resul.getString("dmexp"));;
			elemento.getPersona().getLugarExpedicion().getDepartamento().setCodigo(resul.getInt("cdexp"));
			elemento.getPersona().getLugarExpedicion().getDepartamento().setNombre(resul.getString("ndexp"));
			elemento.getPersona().getLugarExpedicion().getDepartamento().setDaneCodigo(resul.getString("ddexp"));
			elemento.getPersona().getLugarExpedicion().getDepartamento().getPais().setCodigo(resul.getInt("cpexp"));
			elemento.getPersona().getLugarExpedicion().getDepartamento().getPais().setNombre(resul.getString("npexp"));
			elemento.getPersona().getLugarExpedicion().getDepartamento().getPais().setCodigoHecaa(resul.getInt("hpexp"));
			
			elemento.getPersona().setNombre(resul.getString("per_nombre"));
			elemento.getPersona().setApellido(resul.getString("per_apellido"));
			elemento.getPersona().getGenero().setNombre(resul.getString("genero"));
			elemento.getPersona().setFechaNacimiento(resul.getDate("fechaNac"));
			elemento.getPersona().setEmailInterno(resul.getString("per_email_interno"));
			elemento.getPersona().setEmail(resul.getString("per_email"));
			elemento.getPersona().setTelefonoFijo(resul.getString("per_telefono_fijo"));
			elemento.getPersona().setTelefonoMovil(resul.getString("per_telefono_movil"));
			elemento.setFechaInicio(resul.getDate("uap_fecha_inicio"));
			elemento.setFechaFin(resul.getDate("fechaFin"));
//			elemento.getPersona().getEps().setEps_nombre(resul.getString(""));
			elemento.getVinculacion().setCodigo(resul.getInt("vin_codigo"));
			elemento.getVinculacion().setNombre(resul.getString("vin_nombre"));
			elemento.getDedicacion().setNombre(resul.getString("ded_nombre"));
			elemento.getDedicacion().setCodigo(resul.getInt("ded_codigo"));
			elemento.getDedicacion().setCodigoHecaa(resul.getString("ded_codigo_hecaa"));
			elemento.getDocenteEscalafon().setEscalafon(new Escalafon());
			elemento.getDocenteEscalafon().getEscalafon().setNombre(resul.getString("escalafon"));
			elemento.getDocenteEscalafon().getEscalafon().setCodigo(resul.getInt("esc_codigo"));
			elemento.getUaa().setNombre(resul.getString("facultad"));
			elemento.getUaa().setNombreCorto(resul.getString("uaa_nombre_corto"));
			elemento.getPersona().getHistoriaAcademica().getModalidad().setHecaaCodigo(resul.getInt("mo_hecaa_codigo"));
//			elemento.getPersona().getHistoria_academica().getModalidad().setMod_codigo(resul.getInt("mo_mod_codigo"));
			elemento.getPersona().getHistoriaAcademica().getModalidad().setNombre(resul.getString("mo_mod_nombre"));
			elemento.getPersona().getHistoriaAcademica().getInstitucionEducativa().setCodigo(resul.getInt("ine_codigo_hecaa"));
			elemento.getPersona().getHistoriaAcademica().getInstitucionEducativa().setNombre(resul.getString("ine_nombre"));
			elemento.getPersona().getHistoriaAcademica().getNivelAcademico().setCodigo(resul.getInt("nia_codigo"));
			elemento.getPersona().getHistoriaAcademica().getNivelAcademico().setNombre(resul.getString("nia_nombre"));
			elemento.getPersona().getHistoriaAcademica().getNivelAcademico().setCodigoNedHecaa(resul.getInt("nia_codigo_ned_hecaa"));
			
			elemento.getPersona().getHistoriaAcademica().setFechaTitulo(resul.getDate("pha_fecha_titulo"));
			elemento.getPersona().getHistoriaAcademica().setTitulo(resul.getString("pha_titulo"));
			boolean convalidado=false;
			if(resul.getInt("pha_convalidado")==1) {
				convalidado=true;
			}
			elemento.getPersona().getHistoriaAcademica().setConvalidado(convalidado);
			elemento.getPersona().getHistoriaAcademica().getModalidad().setNombre(resul.getString("pha_convalidado"));
//			elemento.getPersona().getHistoria_academica().getMunicipio().setMun_nombre(resul.getString(""));
//			elemento.getPersona().getHistoria_academica().getMunicipio().setSNIES_codigo(resul.getString(""));
			elemento.getPersona().getHistoriaAcademica().getMunicipio().setCodigo(resul.getInt("ie_mun_codigo"));
			elemento.getPersona().getHistoriaAcademica().getMunicipio().getDepartamento().getPais().setCodigoHecaa(resul.getInt("pa_pai_codigo_hecaa"));
			elemento.getPersona().getHistoriaAcademica().getInstitucionEducativa().setCodigoHecaa(resul.getString("ine_codigo_hecaa"));
			elemento.getPersona().getDocentePuntos().setCategoria(resul.getDouble("dp_categoria"));
			elemento.getPersona().getDocentePuntos().setPregrado(resul.getDouble("dp_pregrado"));
			elemento.getPersona().getDocentePuntos().setEspecializacion(resul.getDouble("dp_especializacion"));
			elemento.getPersona().getDocentePuntos().setEspecializacionMedica(resul.getDouble("dp_especializacion_medica"));
			elemento.getPersona().getDocentePuntos().setMaestria(resul.getDouble("dp_maestria"));
			elemento.getPersona().getDocentePuntos().setDoctorado(resul.getDouble("dp_doctorado"));
			elemento.getPersona().getDocentePuntos().setExperienciaCalificada(resul.getDouble("dp_exp_calificada"));
			elemento.getPersona().getDocentePuntos().setExperienciaAdministrativa(resul.getDouble("dp_exp_adtiva"));
			elemento.getPersona().getDocentePuntos().setArticulosRevista(resul.getDouble("dp_articulos_revista"));
			elemento.getPersona().getDocentePuntos().setLibros(resul.getDouble("dp_libros"));
			elemento.getPersona().getDocentePuntos().setCapLibro(resul.getDouble("dp_cap_libro"));
			elemento.getPersona().getDocentePuntos().setObraArtistica(resul.getDouble("dp_obra_artistica"));
			elemento.getPersona().getDocentePuntos().setPremios(resul.getDouble("dp_premios"));
			elemento.getPersona().getDocentePuntos().setPatentes(resul.getDouble("dp_patentes"));
			elemento.getPersona().getDocentePuntos().setProduccionTecnica(resul.getDouble("dp_produccion_tecnica"));
			elemento.getPersona().getDocentePuntos().setSoftware(resul.getDouble("dp_software"));
			elemento.getPersona().getDocentePuntos().setTraducciones(resul.getDouble("dp_traducciones"));
			elemento.getPersona().getDocentePuntos().setVideos(resul.getDouble("dp_videos"));
			elemento.getPersona().getDocentePuntos().setOtrasSalariales(resul.getDouble("dp_otras_salariales"));
			elemento.getPersona().getDocentePuntos().setTotalSalariales(resul.getDouble("dp_total_salariales"));
			elemento.getPersona().getDocentePuntos().setBonificionesXProduccion(resul.getDouble("dp_bonific_x_produccion"));
			elemento.getPersona().getDocentePuntos().setBonificionesXExperiencia(resul.getDouble("dp_bonific_x_exp"));
			elemento.getPersona().getDocentePuntos().setTotalBonificacion(resul.getDouble("dp_total_bonificacion"));
			elemento.getPersona().getDocentePuntos().setSalario(resul.getDouble("salario"));
			elemento.getPersona().getDocentePuntos().setPeriodo(new Periodo(resul.getInt("dp_periodo")));
			/**elemento.getUaa().setUaa_nombre_corto(resul.getString("uaa_nombre_corto"));
			elemento.getFacultad().setUaa_nombre_corto(resul.getString("facultad"));
			elemento.getDedicacion().setDed_nombre(resul.getString("ded_codigo"));
			elemento.getDedicacion().setDed_codigo(resul.getInt("ded_nombre"));
//			elemento.getSede().setSed_codigo(resul.getInt(""));
			elemento.getSede().setSed_nombre(resul.getString("sede"));
			****/
			//elemento.getPeriodo().setNombre(String.valueOf(periodo));
			elemento.getAgenda().setAdministraticas(resul.getInt("ADMINISTRATIVAS"));
			elemento.getAgenda().setOtrasActividades(resul.getInt("INSTITUCIONAL"));
		
			elemento.getAgenda().setDocencia(resul.getInt("academica"));
			elemento.getAgenda().setActDocencia(resul.getInt("DOCENCIA"));
		
			elemento.getAgenda().setInvestigacion(resul.getInt("INVESTIGACION"));
			elemento.getAgenda().setActInvestigacion(resul.getInt("ACTINVESTIGACION"));
			
			elemento.getAgenda().setProyeccion(resul.getInt("PROYECCION"));
			elemento.getAgenda().setActProyeccion(resul.getInt("ACTIPROYECCION"));
			
			//imp.info(elemento);
			lista.add(elemento);
		}
		consegura.cerrarconn(conn, resul, sentencia);

	} catch (SQLException e) {
		imp.error("en la conexion " + e + " " + sql.toString());
		consegura.cerrarconn(conn, resul, sentencia);
	}

	imp.info(lista.size());
	return lista;
}

}
