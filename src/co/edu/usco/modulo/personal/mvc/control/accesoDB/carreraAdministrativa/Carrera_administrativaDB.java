/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB.carreraAdministrativa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;


import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.publicacion_tipoOb;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa.CarreraAdministrativa;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Carrera_administrativaDB implements conexion {
	private Logger imp; 
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		Statement sentencia=null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		 LinkedList<CarreraAdministrativa> lista = new LinkedList<CarreraAdministrativa>();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 CarreraAdministrativa caa= (CarreraAdministrativa) param[0];
			 Usuario admin= (Usuario) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT caa_codigo,caa.per_codigo,p.per_nombre,p.per_apellido,p.per_identificacion, ");
			sql.append("tp.tip_codigo,tp.tip_nombre,tp.tip_estado,caa_acto_adtivo,caa_fecha_acto_adtivo, ");
			sql.append("uc.uac_codigo,uc.uac_codigoplanta,uc.uac_grado, ");
			sql.append("v.vin_codigo,v.vin_nombre, ");
			sql.append("d.ded_codigo,d.ded_nombre, ");
			sql.append("u.uaa_codigo,u.uaa_nombre, ");
			sql.append("c.car_codigo,c.car_nombre, ");
			sql.append("caa_numero_convocatoria,caa_fecha_convocatoria,caa_resolucion_elegibles,caa_fecha_resolucion_elegibles,caa_numero_acta_posesion,caa_fecha_acta_posesion,caa_estado ,coalesce(caa.caa_observacion,'')  ");
			sql.append("FROM cadtiva.carrera_administrativa caa with(nolock)  ");
			sql.append("inner join persona  p with(nolock) on (p.per_codigo=caa.per_codigo)  ");
			sql.append("inner join cadtiva.tipo_proceso tp with(nolock) on(tp.tip_codigo=caa.tip_codigo)  ");
			sql.append("inner join uaa_cargo uc with(nolock) on (uc.uac_codigo =caa.uac_codigo)  ");
			sql.append("inner join vinculacion v with(nolock) on (v.vin_codigo=uc.uac_vinculacion)  ");
			sql.append("inner join dedicacion d with(nolock) on(d.ded_codigo= uc.uac_dedicacion)  ");
			sql.append("inner join uaa u with(nolock) on (u.uaa_codigo=uc.uac_uaa)  ");
			sql.append("inner join cargo c with(nolock) on (c.car_codigo= uc.uac_cargo)  ");
			sql.append("  ");
			if(caa.getPersona().getPer_nombre()!=null && caa.getPersona().getPer_nombre().length()>0){
				sql.append("WHERE per_identificacion like '%"+caa.getPersona().getPer_nombre()+"%'  or per_apellido+' '+per_nombre like'%"+caa.getPersona().getPer_nombre()+"%' or per_nombre+' '+per_apellido like '%"+caa.getPersona().getPer_nombre()+"%' ");
			}


			conn = consegura.getconn_admin(admin);
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				CarreraAdministrativa elemento= new CarreraAdministrativa();
				elemento.setCaa_codigo(resul.getInt(1));
				
				elemento.getPersona().setPer_codigo(resul.getInt(2));
				elemento.getPersona().setPer_nombre(resul.getString(3));
				elemento.getPersona().setPer_apellido(resul.getString(4));
				elemento.getPersona().setPer_identificacion(resul.getString(5));
				
				elemento.getTipoPorceso().setTip_codigo(resul.getInt(6));
				elemento.getTipoPorceso().setTip_nombre(resul.getString(7));
				elemento.getTipoPorceso().setTip_estado(resul.getInt(8));
				
				elemento.setCaa_acto_adtivo(resul.getString(9));
				elemento.setCaa_fecha_acto_adtivo(resul.getDate(10));
				
				elemento.getUaa_cargo().setUac_codigo(resul.getInt(11));
				elemento.getUaa_cargo().setUac_codigoplanta(resul.getString(12));
				elemento.getUaa_cargo().setUac_grado(resul.getInt(13));
				
				elemento.getUaa_cargo().getVinculacion().setVin_codigo(resul.getInt(14));
				elemento.getUaa_cargo().getVinculacion().setVin_nombre(resul.getString(15));
				
				elemento.getUaa_cargo().getDedicacion().setDed_codigo(resul.getInt(16));
				elemento.getUaa_cargo().getDedicacion().setDed_nombre(resul.getString(17));
				
				elemento.getUaa_cargo().getUaa().setUaa_codigo(resul.getInt(18));
				elemento.getUaa_cargo().getUaa().setUaa_nombre(resul.getString(19));
				
				elemento.getUaa_cargo().getCargo().setCar_codigo(resul.getInt(20));
				elemento.getUaa_cargo().getCargo().setCar_nombre(resul.getString(21));
				
				elemento.setCaa_numero_convocatoria(resul.getString(22));
				elemento.setCaa_fecha_convocatoria(resul.getDate(23));
				elemento.setCaa_resolucion_elegibles(resul.getString(24));
				elemento.setCaa_fecha_resolucion_elegibles(resul.getDate(25));
				elemento.setCaa_numero_acta_posesion(resul.getString(26));
				elemento.setCaa_fecha_acta_posesion(resul.getDate(27));
				elemento.setCaa_observacion(resul.getString(28));
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
		 CarreraAdministrativa elemento= new CarreraAdministrativa();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 CarreraAdministrativa caa= (CarreraAdministrativa) param[0];
			 Usuario admin= (Usuario) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT caa_codigo,caa.per_codigo,p.per_nombre,p.per_apellido,p.per_identificacion, ");
			sql.append("tp.tip_codigo,tp.tip_nombre,tp.tip_estado,caa_acto_adtivo,caa_fecha_acto_adtivo, ");
			sql.append("uc.uac_codigo,uc.uac_codigoplanta,uc.uac_grado, ");
			sql.append("v.vin_codigo,v.vin_nombre, ");
			sql.append("d.ded_codigo,d.ded_nombre, ");
			sql.append("u.uaa_codigo,u.uaa_nombre, ");
			sql.append("c.car_codigo,c.car_nombre, ");
			sql.append("caa_numero_convocatoria,caa_fecha_convocatoria,caa_resolucion_elegibles,caa_fecha_resolucion_elegibles,caa_numero_acta_posesion, caa_fecha_acta_posesion,caa_estado  ");
			sql.append(", m.mun_codigo,m.mun_nombre,dpto.pai_codigo,dpto.dep_nombre,coalesce(caa.caa_observacion,'') ");
			sql.append("FROM cadtiva.carrera_administrativa caa with(nolock)  ");
			sql.append("inner join persona  p with(nolock) on (p.per_codigo=caa.per_codigo)  ");
			sql.append("inner join municipio m with(nolock) on (m.mun_codigo=p.per_lugar_expedicion)  ");
			sql.append("inner join departamento dpto with(nolock) on (dpto.dep_codigo= m.dep_codigo)  ");
			sql.append("inner join cadtiva.tipo_proceso tp with(nolock) on(tp.tip_codigo=caa.tip_codigo)  ");
			sql.append("inner join uaa_cargo uc with(nolock) on (uc.uac_codigo =caa.uac_codigo)  ");
			sql.append("inner join vinculacion v with(nolock) on (v.vin_codigo=uc.uac_vinculacion)  ");
			sql.append("inner join dedicacion d with(nolock) on(d.ded_codigo= uc.uac_dedicacion)  ");
			sql.append("inner join uaa u with(nolock) on (u.uaa_codigo=uc.uac_uaa)  ");
			sql.append("inner join cargo c with(nolock) on (c.car_codigo= uc.uac_cargo)  ");
			sql.append("WHERE (caa_estado=1 or caa_estado=0) ");
			if(caa.getPersona().getPer_codigo()>0){
				sql.append("and p.per_codigo= "+caa.getPersona().getPer_codigo()+" ");
			}
			if(caa.getCaa_codigo()>0){
				sql.append("and caa.caa_codigo= "+caa.getCaa_codigo()+" ");
			}


			conn = consegura.getconn_admin(admin);
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				elemento= new CarreraAdministrativa();
				elemento.setCaa_codigo(resul.getInt(1));
				
				elemento.getPersona().setPer_codigo(resul.getInt(2));
				elemento.getPersona().setPer_nombre(resul.getString(3));
				elemento.getPersona().setPer_apellido(resul.getString(4));
				elemento.getPersona().setPer_identificacion(resul.getString(5));
				
				elemento.getTipoPorceso().setTip_codigo(resul.getInt(6));
				elemento.getTipoPorceso().setTip_nombre(resul.getString(7));
				elemento.getTipoPorceso().setTip_estado(resul.getInt(8));
				
				elemento.setCaa_acto_adtivo(resul.getString(9));
				elemento.setCaa_fecha_acto_adtivo(resul.getDate(10));
				
				elemento.getUaa_cargo().setUac_codigo(resul.getInt(11));
				elemento.getUaa_cargo().setUac_codigoplanta(resul.getString(12));
				elemento.getUaa_cargo().setUac_grado(resul.getInt(13));
				
				elemento.getUaa_cargo().getVinculacion().setVin_codigo(resul.getInt(14));
				elemento.getUaa_cargo().getVinculacion().setVin_nombre(resul.getString(15));
				
				elemento.getUaa_cargo().getDedicacion().setDed_codigo(resul.getInt(16));
				elemento.getUaa_cargo().getDedicacion().setDed_nombre(resul.getString(17));
				
				elemento.getUaa_cargo().getUaa().setUaa_codigo(resul.getInt(18));
				elemento.getUaa_cargo().getUaa().setUaa_nombre(resul.getString(19));
				
				elemento.getUaa_cargo().getCargo().setCar_codigo(resul.getInt(20));
				elemento.getUaa_cargo().getCargo().setCar_nombre(resul.getString(21));
				
				elemento.setCaa_numero_convocatoria(resul.getString(22));
				elemento.setCaa_fecha_convocatoria(resul.getDate(23));
				elemento.setCaa_resolucion_elegibles(resul.getString(24));
				elemento.setCaa_fecha_resolucion_elegibles(resul.getDate(25));
				elemento.setCaa_numero_acta_posesion(resul.getString(26));
				elemento.setCaa_fecha_acta_posesion(resul.getDate(27));
				elemento.getPersona().getPer_lugar_expedicion().setMun_codigo(resul.getInt(29));
				elemento.getPersona().getPer_lugar_expedicion().setMun_nombre(resul.getString(30));
				elemento.getPersona().getPer_lugar_expedicion().getDepartamento().setDep_codigo(resul.getInt(31));
				elemento.getPersona().getPer_lugar_expedicion().getDepartamento().setDep_nombre(resul.getString(32));
				elemento.setCaa_observacion(resul.getString(33));
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
		if(opt==1){
			resultado=  insertObject(param[0],param[1]);
		}
		if(opt==2){
			resultado=updateObject(param[0],param[1]);
		}
		return resultado;
	}

	private Object updateObject(Object obj,Object obj1){
		Connection conn = null;
		Statement sentencia=null;
		int resul=0;
		imp =Logger.getLogger(getClass().getName());
			Conexion consegura = new Conexion();
			StringBuffer sql = new StringBuffer();
		 try {
//			 Object param[]=(Object[]) obj;
			 CarreraAdministrativa caa= (CarreraAdministrativa)obj;
//			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
			Usuario admin=(Usuario) obj1;
			
			sql.append("UPDATE cadtiva.carrera_administrativa ");
			sql.append("SET ");
			sql.append("per_codigo ='"+caa.getPersona().getPer_codigo()+"'");
			sql.append(",tip_codigo ='"+caa.getTipoPorceso().getTip_codigo()+"'");
			sql.append(",caa_acto_adtivo =  '"+caa.getCaa_acto_adtivo()+"'");
			sql.append(",caa_fecha_acto_adtivo = '"+new java.sql.Date(caa.getCaa_fecha_acto_adtivo().getTime())+"'");
			sql.append(",uac_codigo =  '"+caa.getUaa_cargo().getUac_codigo()+"'");
			sql.append(",caa_numero_convocatoria ='"+caa.getCaa_numero_convocatoria()+"'");
			sql.append(",caa_fecha_convocatoria = '"+new java.sql.Date(caa.getCaa_fecha_convocatoria().getTime()) +"'");
			sql.append(",caa_resolucion_elegibles = '"+caa.getCaa_resolucion_elegibles()+"'");
			sql.append(",caa_fecha_resolucion_elegibles =  '"+new java.sql.Date(caa.getCaa_fecha_resolucion_elegibles().getTime())+"'");
			sql.append(",caa_numero_acta_posesion =  '"+caa.getCaa_numero_acta_posesion()+"'");
			sql.append(",caa_fecha_acta_posesion = '"+new java.sql.Date(caa.getCaa_fecha_acta_posesion().getTime())+"'");
			sql.append(",caa_observacion =  '"+caa.getCaa_observacion()+"'");
			sql.append(",caa_estado = 1 ");
			sql.append(" WHERE caa_codigo= "+caa.getCaa_codigo()+" ");
			sql.append("  ");
			sql.append("  ");
	

			conn = consegura.getconn_admin(admin);
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeUpdate(sql.toString());
			consegura.cerrarconn(conn, null, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() +""+sql.toString());
			 consegura.cerrarconn(conn, null, sentencia);

	        }
		return resul;
	}

	private Object insertObject(Object obj,Object obj1){
		Connection conn = null;
		Statement sentencia=null;
		int resul=0;
		imp =Logger.getLogger(getClass().getName());
			Conexion consegura = new Conexion();
			StringBuffer sql = new StringBuffer();
		 try {
//			 Object param[]=(Object[]) obj;
			 CarreraAdministrativa caa= (CarreraAdministrativa)obj;
//			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
			Usuario admin=(Usuario) obj1;
			
			sql.append("INSERT INTO cadtiva.carrera_administrativa(per_codigo,tip_codigo,caa_acto_adtivo,caa_fecha_acto_adtivo,uac_codigo,  ");
			sql.append("caa_numero_convocatoria,caa_fecha_convocatoria,caa_resolucion_elegibles,caa_fecha_resolucion_elegibles,caa_numero_acta_posesion, ");
			sql.append("caa_fecha_acta_posesion,caa_observacion, caa_estado ");
			sql.append(")VALUES ( ");
			sql.append("'"+caa.getPersona().getPer_codigo()+"'");
			sql.append(" , '"+caa.getTipoPorceso().getTip_codigo()+"'");
			sql.append(" , '"+caa.getCaa_acto_adtivo()+"'");
			sql.append(" , '"+new java.sql.Date(caa.getCaa_fecha_acto_adtivo().getTime())+"'");
			sql.append(" , '"+caa.getUaa_cargo().getUac_codigo()+"'");
			sql.append(" , '"+caa.getCaa_numero_convocatoria()+"'");
			sql.append(" , '"+new java.sql.Date(caa.getCaa_fecha_convocatoria().getTime()) +"'");
			sql.append(" , '"+caa.getCaa_resolucion_elegibles()+"'");
			sql.append(" , '"+new java.sql.Date(caa.getCaa_fecha_resolucion_elegibles().getTime())+"'");
			sql.append(" , '"+caa.getCaa_numero_acta_posesion()+"'");
			sql.append(" , '"+new java.sql.Date(caa.getCaa_fecha_acta_posesion().getTime())+"'");
			sql.append(",  '"+caa.getCaa_observacion()+"'");
			sql.append(" ,1) ");
			sql.append("  ");
			sql.append("  ");

			conn = consegura.getconn_admin(admin);
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeUpdate(sql.toString());
			consegura.cerrarconn(conn, null, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() +""+sql.toString());
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
		imp =Logger.getLogger(getClass().getName());
		 LinkedList<publicacion_tipoOb> lista = new LinkedList<publicacion_tipoOb>();
			Conexion consegura = new Conexion();
			boolean existe= true;
		 try {
			 Object param[]=(Object[]) obj;
			 CarreraAdministrativa caa= (CarreraAdministrativa) param[0];
			 Usuario admin= (Usuario) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT count(*)FROM cadtiva.carrera_administrativa caa with(nolock) ");
			sql.append(" where per_codigo= "+caa.getPersona().getPer_codigo()+" ");
			sql.append("  ");
			sql.append("  ");
			conn = consegura.getconn_admin(admin);
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				if(resul.getInt(1)>0){
					 existe=false;
				}
				
				}
			consegura.cerrarconn(conn, resul, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, resul, sentencia);

	        }
		 
		return existe;
	}

}
