/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PersonaDB implements conexion {
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
			sql.append("SELECT p.per_codigo,p.per_identificacion,p.tii_codigo,ti.tii_nombre,ti.tii_nombre_corto,p.per_libreta_militar,p.per_apellido1,p.per_apellido2,p.per_nombre1,p.per_nombre2,p.per_genero ");
			sql.append(",p.per_lugar_expedicion,munNacimiento.mun_nombre,depNacimiento.dep_codigo,depNacimiento.dep_nombre,paisNacimiento.pai_codigo,paisNacimiento.pai_nombre ");
			sql.append(",p.per_fecha_nacimiento,p.per_direccion_residencia,p.per_telefono_movil,p.per_telefono_fijo,p.per_estado_civil,p.per_lugar_nacimiento,p.per_lugar_residencia,p.per_barrio  ");
			sql.append(",coalesce(p.per_estado,0) as per_estado,p.eps_codigo,p.eta_codigo,p.per_numero_afiliacion_eps,p.per_familiar_direccion,p.per_familiar_nombre,p.per_familiar_telefono,p.per_familiar_lugar_residencia,p.per_email,p.per_email_interno,p.per_pagina_personal ");
			sql.append(",p.grs_codigo,p.Expr1,p.nat_codigo,p.reg_codigo,p.per_razon_social,p.per_identificacion_dup,p.per_codigo_pais_hecaa,p.per_estrato,p.per_fecha_expedicion  ");
			sql.append("FROM persona_usco p with(nolock) ");
			sql.append("left join tipo_id ti with(nolock) on(ti.tii_codigo= p.tii_codigo)  ");
			sql.append("left join municipio  munNacimiento with(nolock) on(munNacimiento.mun_codigo=p.per_lugar_expedicion) ");
			sql.append("left join departamento depNacimiento with(nolock) on(depNacimiento.dep_codigo=munNacimiento.dep_codigo) ");
			sql.append("left join pais paisNacimiento with(nolock) on (paisNacimiento.pai_codigo=depNacimiento.pai_codigo) ");
			sql.append("   ");
			sql.append("   ");
			sql.append("   ");
			sql.append("   ");
//			sql.append("where cert_estado=1  ");
			
			if(persona.getPer_nombre()!=null && persona.getPer_nombre().length()>0){
				sql.append("WHERE  p.per_nombre1 +' '+ p.per_nombre2+' '+p.per_apellido1+' '+p.per_apellido2  like'%"+persona.getPer_nombre()+"%' or p.per_identificacion like'%"+persona.getPer_nombre()+"%' or p.per_apellido1+' '+p.per_apellido2+' '+p.per_nombre1 +' '+ p.per_nombre2  like '%"+persona.getPer_nombre()+"%' ");
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
		 Persona elemento = new Persona();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 Persona persona= (Persona) param[0];
			 Usuario admin= (Usuario) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT p.per_codigo,p.per_identificacion,p.tii_codigo,ti.tii_nombre,ti.tii_nombre_corto,p.per_libreta_militar,p.per_apellido1,p.per_apellido2,p.per_nombre1,p.per_nombre2,p.per_genero ");
			sql.append(",p.per_lugar_expedicion,munNacimiento.mun_nombre,depNacimiento.dep_codigo,depNacimiento.dep_nombre,paisNacimiento.pai_codigo,paisNacimiento.pai_nombre ");
			sql.append(",p.per_fecha_nacimiento,p.per_direccion_residencia,p.per_telefono_movil,p.per_telefono_fijo,p.per_estado_civil,p.per_lugar_nacimiento,p.per_lugar_residencia,p.per_barrio  ");
			sql.append(",p.per_estado,p.eps_codigo,p.eta_codigo,p.per_numero_afiliacion_eps,p.per_familiar_direccion,p.per_familiar_nombre,p.per_familiar_telefono,p.per_familiar_lugar_residencia,p.per_email,p.per_email_interno,p.per_pagina_personal ");
			sql.append(",p.grs_codigo,p.Expr1,p.nat_codigo,p.reg_codigo,p.per_razon_social,p.per_identificacion_dup,p.per_codigo_pais_hecaa,p.per_estrato,p.per_fecha_expedicion  ");
			sql.append("FROM persona_usco p with(nolock) ");
			sql.append("left join tipo_id ti with(nolock) on(ti.tii_codigo= p.tii_codigo)  ");
			sql.append("left join municipio  munNacimiento with(nolock) on(munNacimiento.mun_codigo=p.per_lugar_expedicion) ");
			sql.append("left join departamento depNacimiento with(nolock) on(depNacimiento.dep_codigo=munNacimiento.dep_codigo) ");
			sql.append("left join pais paisNacimiento with(nolock) on (paisNacimiento.pai_codigo=depNacimiento.pai_codigo) ");
			sql.append("   ");
			sql.append("   ");
			sql.append("   ");
			sql.append("   ");
//			sql.append("where cert_estado=1  ");
			
			if(persona.getPer_codigo()>0){
				sql.append("WHERE  p.per_codigo = "+persona.getPer_codigo()+" ");
			}


			conn = consegura.getconn_admin(admin);
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				elemento= new Persona();
				elemento.setPer_codigo(resul.getInt(1));
				elemento.setPer_identificacion(resul.getString(2));
				elemento.getTii_codigo().setTii_codigo(resul.getInt(3));
				elemento.getTii_codigo().setTii_nombre(resul.getString(4));
				elemento.getTii_codigo().setTii_nombre_corto(resul.getString(5));
				elemento.setPer_libreta_militar(resul.getString(6));
				elemento.setPer_apellido(resul.getString(7)+" "+resul.getString(8));
				elemento.setPer_nombre(resul.getString(9)+" "+resul.getString(10));
//				elemento.setPer_estado(resul.getInt(11));
				
				
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
		if(opt==2){
			return updatepersonaPensionado(obj);
		}
		return null;
	}

	private Object updatepersonaPensionado(Object obj) {
		Connection conn = null;
		Conexion consegura = new Conexion();
		 Object param[]=(Object[]) obj;
		 Persona persona= (Persona) param[0];
		 Usuario admin= (Usuario) param[1];
		 int count=0;
		 CallableStatement cstmt =null;
		try {
			conn = consegura.getconn_admin(admin);
		      cstmt = conn.prepareCall("{call dbo.ActualizaPersonaPensionados(?, ?, ?, ?, ?, ?)}");
		      cstmt.setString(1, persona.getPer_direccion_residencia());
		      cstmt.setString(2, persona.getPer_telefono_movil());
		      cstmt.setString(3,persona.getPer_telefono_fijo());
    		  cstmt.setString(4,persona.getPer_email());
    		  cstmt.setString(5,persona.getPer_barrio());
			  cstmt.setInt(6,persona.getPer_codigo());
			  count =cstmt.executeUpdate();
//		       cstmt.getUpdateCount();
		      consegura.cerrarconn(conn, cstmt);
		      imp.info("ROWS AFFECTED: " + count);
		   }
		   catch (Exception e) {
			   consegura.cerrarconn(conn, cstmt);
			   imp.error("Error: " + e);
		      e.printStackTrace();
		   }                                                      
		return count;
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
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO persona(per_identificacion,tii_codigo,per_libreta_militar,per_apellido,per_nombre,per_genero,per_lugar_expedicion,per_fecha_nacimiento,per_direccion_residencia  ");
			sql.append(",per_telefono_movil,per_telefono_fijo,per_estado_civil,per_lugar_nacimiento,per_lugar_residencia,per_barrio,per_estrato ");
			sql.append(",eps_codigo,per_numero_afiliacion_eps,per_familiar_direccion,per_familiar_nombre,per_familiar_telefono  ");
			sql.append(",per_familiar_lugar_residencia,per_email,per_email_interno,enviar_correo,grs_codigo,nat_codigo,reg_codigo,per_razon_social  ");
			sql.append(")VALUES ");
			
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
		Connection conn = null;
		Statement sentencia=null;
		ResultSet resul=null;
		boolean esta=false;
		imp =Logger.getLogger(getClass().getName());
			Conexion consegura = new Conexion();
		 try {
			 Persona persona=(Persona) obj; 
//			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append(" select COUNT(*) As persona from persona where per_codigo="+persona.getPer_codigo()+" ");
			conn = consegura.Get_conexion_sesion();
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				if(resul.getInt("persona")>0){
					esta=true;
				}
				
			}
			consegura.cerrarconn(conn, null, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, null, sentencia);

	        }
		return esta;
	}

	

}
