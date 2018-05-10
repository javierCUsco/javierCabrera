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
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.UaaPersonal;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Persona_carrera_administrativaDB implements conexion {
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
		 LinkedList<Persona> lista = new LinkedList<Persona>();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 Persona persona= (Persona) param[0];
			 Usuario admin= (Usuario) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT distinct p.per_codigo,p.per_identificacion,p.tii_codigo,ti.tii_nombre,ti.tii_nombre_corto,p.per_libreta_militar,p.per_apellido1,p.per_apellido2,p.per_nombre1,p.per_nombre2,p.per_genero ,p.per_lugar_expedicion,munNacimiento.mun_nombre,depNacimiento.dep_codigo,depNacimiento.dep_nombre,paisNacimiento.pai_codigo,paisNacimiento.pai_nombre ,p.per_fecha_nacimiento,p.per_direccion_residencia,p.per_telefono_movil,p.per_telefono_fijo,p.per_estado_civil,p.per_lugar_nacimiento,p.per_lugar_residencia,p.per_barrio  ,coalesce(p.per_estado,0) as per_estado,p.eps_codigo,p.eta_codigo,p.per_numero_afiliacion_eps,p.per_familiar_direccion,p.per_familiar_nombre,p.per_familiar_telefono,p.per_familiar_lugar_residencia,p.per_email,p.per_email_interno,p.per_pagina_personal ,p.grs_codigo,p.Expr1,p.nat_codigo,p.reg_codigo,p.per_razon_social,p.per_identificacion_dup,p.per_codigo_pais_hecaa,p.per_estrato,p.per_fecha_expedicion  ");
			sql.append("FROM persona_usco p with(nolock)  ");
			sql.append("left join tipo_id ti with(nolock) on(ti.tii_codigo= p.tii_codigo)  ");
			sql.append("left join municipio  munNacimiento with(nolock) on(munNacimiento.mun_codigo=p.per_lugar_expedicion)  ");
			sql.append("left join departamento depNacimiento with(nolock) on(depNacimiento.dep_codigo=munNacimiento.dep_codigo)  ");
			sql.append("left join pais paisNacimiento with(nolock) on (paisNacimiento.pai_codigo=depNacimiento.pai_codigo)  ");
			sql.append("inner join uaa_personal uap with(nolock) on(p.per_codigo=uap.per_codigo) ");
			sql.append("inner join uaa_cargo uac with(nolock) on(uac.uac_codigo=uap.uac_codigo)  ");
			sql.append("WHERE uac.uac_vinculacion=5 ");
			sql.append(" ");
			sql.append(" ");
			sql.append(" ");
//			sql.append("where cert_estado=1  ");
			
			if(persona.getPer_nombre()!=null && persona.getPer_nombre().length()>0){
				sql.append(" and p.per_nombre1 +' '+ p.per_nombre2+' '+p.per_apellido1+' '+p.per_apellido2  like'%"+persona.getPer_nombre()+"%' or p.per_identificacion like'%"+persona.getPer_nombre()+"%' or p.per_apellido1+' '+p.per_apellido2+' '+p.per_nombre1 +' '+ p.per_nombre2  like '%"+persona.getPer_nombre()+"%' ");
			}


			conn = consegura.getconn_admin(admin);
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				Persona elemento= new Persona();
				elemento.setPer_codigo(resul.getInt(1));
				elemento.setPer_identificacion(resul.getString(2));
				elemento.getTii_codigo().setTii_codigo(resul.getInt(3));
				elemento.getTii_codigo().setTii_nombre(resul.getString(4));
				elemento.getTii_codigo().setTii_nombre_corto(resul.getString(5));
				elemento.setPer_libreta_militar(resul.getString(6));
				elemento.setPer_apellido(resul.getString(7)+" "+resul.getString(8));
				elemento.setPer_nombre(resul.getString(9)+" "+resul.getString(10));
				elemento.setPer_estado(resul.getInt(26));
				
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
		 UaaPersonal elemento = new UaaPersonal();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 Persona persona= (Persona) param[0];
			 Usuario admin= (Usuario) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT top 1 p.per_codigo,p.per_identificacion,p.tii_codigo,ti.tii_nombre,ti.tii_nombre_corto,p.per_libreta_militar,p.per_apellido1,p.per_apellido2, ");
			sql.append("p.per_nombre1,p.per_nombre2,p.per_genero ,p.per_lugar_nacimiento,munNacimiento.mun_nombre,depNacimiento.dep_codigo,depNacimiento.dep_nombre,paisNacimiento.pai_codigo, ");
			sql.append("paisNacimiento.pai_nombre ,CONVERT(VARCHAR , p.per_fecha_nacimiento,101),p.per_direccion_residencia,p.per_telefono_movil,p.per_telefono_fijo,p.per_estado_civil,p.per_lugar_nacimiento, ");
			sql.append("p.per_lugar_residencia,p.per_barrio  ,p.per_estado,p.eps_codigo,p.eta_codigo,p.per_numero_afiliacion_eps,p.per_familiar_direccion,p.per_familiar_nombre, ");
			sql.append("p.per_familiar_telefono,p.per_familiar_lugar_residencia,p.per_email,p.per_email_interno,p.per_pagina_personal ,p.grs_codigo,p.Expr1,p.nat_codigo,  ");
			sql.append("p.reg_codigo,p.per_razon_social,p.per_identificacion_dup,p.per_codigo_pais_hecaa,p.per_estrato,p.per_fecha_expedicion, ");
			sql.append("CONVERT(VARCHAR , up.uap_fecha_inicio,101),CONVERT(VARCHAR ,up.uap_fecha_fin,101),  ");
			sql.append("case when up.uap_cargo <> 0 then (select c.car_nombre from cargo c where c.car_codigo=up.uap_cargo )  ");
			sql.append("else (select c.car_nombre from uaa_cargo uc inner join cargo as c on (c.car_codigo=uc.uac_cargo) where uc.uac_codigo=up.uac_codigo ) end as car_nombre ");
			sql.append(",p.per_lugar_expedicion,munExpedicion.mun_nombre,depExpedicion.dep_codigo,depExpedicion.dep_nombre,paisExpedicion.pai_codigo,paisExpedicion.pai_nombre  ");
			sql.append("FROM persona_usco p with(nolock)  ");
			sql.append("left join tipo_id ti with(nolock) on(ti.tii_codigo= p.tii_codigo)   ");
			sql.append("left join municipio  munNacimiento with(nolock) on(munNacimiento.mun_codigo=p.per_lugar_nacimiento)   ");
			sql.append("left join departamento depNacimiento with(nolock) on(depNacimiento.dep_codigo=munNacimiento.dep_codigo)    ");
			sql.append("left join pais paisNacimiento with(nolock) on (paisNacimiento.pai_codigo=depNacimiento.pai_codigo)   ");
			sql.append("left join municipio  munExpedicion with(nolock) on(munExpedicion.mun_codigo=p.per_lugar_expedicion)   ");
			sql.append("left join departamento depExpedicion with(nolock) on(depExpedicion.dep_codigo=munExpedicion.dep_codigo)    ");
			sql.append("left join pais paisExpedicion with(nolock) on (paisExpedicion.pai_codigo=depExpedicion.pai_codigo)  ");
			sql.append("inner join uaa_personal up with(nolock) on(p.per_codigo=up.per_codigo)  ");
			sql.append("inner join uaa_cargo uac with(nolock) on(uac.uac_codigo=up.uac_codigo)  ");
//			sql.append("where cert_estado=1  ");
			
			if(persona.getPer_codigo()>0){
				sql.append("WHERE  p.per_codigo = "+persona.getPer_codigo()+" ");
			}
			sql.append("order by up.uap_fecha_inicio ");

			conn = consegura.getconn_admin(admin);
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				elemento= new UaaPersonal();
				elemento.getPersona().setPer_codigo(resul.getInt(1));
				elemento.getPersona().setPer_identificacion(resul.getString(2));
				elemento.getPersona().getTii_codigo().setTii_codigo(resul.getInt(3));
				elemento.getPersona().getTii_codigo().setTii_nombre(resul.getString(4));
				elemento.getPersona().getTii_codigo().setTii_nombre_corto(resul.getString(5));
				elemento.getPersona().setPer_libreta_militar(resul.getString(6));
				elemento.getPersona().setPer_apellido(resul.getString(7)+" "+resul.getString(8));
				elemento.getPersona().setPer_nombre(resul.getString(9)+" "+resul.getString(10));
				elemento.getPersona().getGenero().setGen_nombre(resul.getString(11));
				elemento.getPersona().getPer_lugar_nacimiento().setMun_codigo(resul.getInt(12));
				elemento.getPersona().getPer_lugar_nacimiento().setMun_nombre(resul.getString(13));
				elemento.getPersona().getPer_lugar_nacimiento().getDepartamento().setDep_codigo(resul.getInt(14));
				elemento.getPersona().getPer_lugar_nacimiento().getDepartamento().setDep_nombre(resul.getString(15));
				elemento.getPersona().getPer_lugar_nacimiento().getDepartamento().getPais().setPai_codigo(resul.getInt(16));
				elemento.getPersona().getPer_lugar_nacimiento().getDepartamento().getPais().setPai_nombre(resul.getString(17));
				elemento.getPersona().setPer_fecha_nacimiento(resul.getDate(18));
				elemento.setUap_fecha_inicio(resul.getDate(46));
				elemento.setUap_fecha_fin(resul.getDate(47));
				elemento.getPersona().getPer_lugar_expedicion().setMun_codigo(resul.getInt(49));
				elemento.getPersona().getPer_lugar_expedicion().setMun_nombre(resul.getString(50));
				elemento.getPersona().getPer_lugar_expedicion().getDepartamento().setDep_codigo(resul.getInt(51));
				elemento.getPersona().getPer_lugar_expedicion().getDepartamento().setDep_nombre(resul.getString(52));
				elemento.getPersona().getPer_lugar_expedicion().getDepartamento().getPais().setPai_codigo(resul.getInt(53));
				elemento.getPersona().getPer_lugar_expedicion().getDepartamento().getPais().setPai_nombre(resul.getString(54));
						
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
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#insertObject(java.lang.Object)
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

	private void updateObject(Object object) {
		// TODO Auto-generated method stub
		
	}

	private Object insertObject(Object obj){
		Connection conn = null;
		Statement sentencia=null;
		int resul=0;
		imp =Logger.getLogger(getClass().getName());
			Conexion consegura = new Conexion();
		 try {
			 Persona persona=(Persona) obj; 
//			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO persona(per_identificacion,tii_codigo,per_libreta_militar,per_apellido,per_nombre,per_genero,per_lugar_expedicion,per_fecha_nacimiento,per_direccion_residencia  ");
			sql.append(",per_telefono_movil,per_telefono_fijo,per_estado_civil,per_lugar_nacimiento,per_lugar_residencia,per_barrio,per_estrato ");
			sql.append(",eps_codigo,per_numero_afiliacion_eps,per_familiar_direccion,per_familiar_nombre,per_familiar_telefono  ");
			sql.append(",per_familiar_lugar_residencia,per_email,per_email_interno,enviar_correo,grs_codigo,nat_codigo,reg_codigo,per_razon_social  ");
			sql.append(")VALUES ");
//			sql.append("eps_codigo,per_estado_civil,nat_codigo,reg_codigo,grs_codigo,per_estrato,per_genero) values(  ");
			
			
//			sql.append("per_identificacion,per_nombre,per_apellido,per_email,per_email_interno,  ");
//			sql.append("per_libreta_militar,per_direccion_residencia,per_barrio,per_telefono_movil, ");
//			sql.append("per_telefono_fijo,per_familiar_nombre,per_familiar_direccion,per_familiar_telefono,  ");
//			sql.append("per_razon_social,per_numero_afiliacion_eps,per_lugar_expedicion,per_lugar_nacimiento,  ");
//			sql.append("per_familiar_lugar_residencia,per_lugar_residencia,per_fecha_nacimiento,tii_codigo,  ");
//			sql.append("eps_codigo,per_estado_civil,nat_codigo,reg_codigo,grs_codigo,per_estrato,per_genero) values(  ");
			sql.append("'"+persona.getPer_identificacion()+"'");
			sql.append(" , '"+persona.getTii_codigo().getTii_codigo());
			sql.append(" , '"+persona.getPer_libreta_militar()+"'");
			sql.append(" , '"+persona.getPer_apellido()+"'");
			sql.append(" , '"+persona.getPer_nombre()+"'");
			sql.append(" , "+persona.getGenero().getGen_codigo());
			sql.append(" , "+persona.getPer_lugar_expedicion().getMun_codigo());
			sql.append(" , '"+persona.getPer_fecha_nacimiento()+"'");
			sql.append(" , '"+persona.getPer_direccion_residencia()+"'");
			sql.append(" , '"+persona.getPer_telefono_movil()+"'");
			sql.append(" , '"+persona.getPer_telefono_fijo()+"'");
			sql.append(" , "+persona.getEstado_civil().getEsc_codigo());
			sql.append(" , "+persona.getPer_lugar_nacimiento().getMun_codigo());
			sql.append(" , "+persona.getPer_lugar_residencia().getMun_codigo());
			sql.append(" , '"+persona.getPer_barrio()+"'");
			sql.append(" , "+persona.getEstrato().getEst_codigo());
			sql.append(" , "+persona.getEps().getEps_codigo());
			sql.append(" , '"+persona.getEps().getPer_numero_afiliacion_eps()+"'");
			sql.append(" , '"+persona.getPer_familiar_direccion()+"'");
			sql.append(" , '"+persona.getPer_familiar_nombre()+"'");
			sql.append(" , '"+persona.getPer_familiar_telefono()+"'");
			sql.append(" , "+persona.getFamiliar_lugar_residencia().getMun_codigo());
			sql.append(" , '"+persona.getPer_email()+"'");
			sql.append(" , '"+persona.getPer_email_interno()+"'");
			sql.append(" , "+persona.getGrs().getGrs_codigo());
			sql.append(" , "+persona.getNaturaleza().getNat_codigo());
			sql.append(" , "+persona.getRegimen().getReg_codigo());
			sql.append(" , '"+persona.getPer_razon_social()+"'");
			sql.append(" ) ");


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
