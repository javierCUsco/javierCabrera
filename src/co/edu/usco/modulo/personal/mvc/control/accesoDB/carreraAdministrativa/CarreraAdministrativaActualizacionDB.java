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
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa.CarreraAdministrativaActualizacion;
/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class CarreraAdministrativaActualizacionDB implements conexion {
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
		 LinkedList<CarreraAdministrativaActualizacion> lista = new LinkedList<CarreraAdministrativaActualizacion>();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 CarreraAdministrativaActualizacion carrera_administrativa_actualizacion=null;
			 Usuario admin=null;
			 if(param[0]!=null){
				 carrera_administrativa_actualizacion = (CarreraAdministrativaActualizacion) param[0];
			 }
			 if(param[1]!=null){
				 admin= (Usuario) param[1];
			 }
			StringBuffer sql = new StringBuffer();
			sql.append("select caaa.caaa_codigo,caa.caa_codigo, ");
			sql.append("p.per_codigo,p.per_nombre,p.per_apellido,p.per_identificacion, ");
			sql.append("tip.tip_codigo,tip.tip_nombre,tip.tip_estado, ");
			sql.append("caa.caa_acto_adtivo,caa.caa_fecha_acto_adtivo, ");
			sql.append("uccaa.uac_codigo,uccaa.uac_codigoplanta,uccaa.uac_grado, ");
			sql.append("vcaa.vin_codigo,vcaa.vin_nombre,vcaa.vin_clase, ");
			sql.append("dcaa.ded_codigo,dcaa.ded_nombre, ");
			sql.append("ucaa.uaa_codigo,ucaa.uaa_nombre,ucaa.uaa_nombre_corto, ");
			sql.append("ccaa.car_codigo,ccaa.car_nombre,ccaa.car_id, ");
			sql.append("tia.tia_codigo,tia.tia_nombre,tia.tia_estado, ");
			sql.append("caa.caa_numero_convocatoria,caa.caa_fecha_convocatoria,caa.caa_resolucion_elegibles,caa.caa_fecha_resolucion_elegibles,caa.caa_numero_acta_posesion,caa.caa_fecha_acta_posesion, ");
			sql.append("caaa.caaa_acto_administrativo,caaa.caaa_fecha_acto_administrativo, ");
			sql.append("uccaaa.uac_codigo,uccaaa.uac_codigoplanta,uccaaa.uac_grado, ");
			sql.append("vcaaa.vin_codigo,vcaaa.vin_nombre,vcaaa.vin_clase, ");
			sql.append("dcaaa.ded_codigo,dcaaa.ded_nombre, ");
			sql.append("ucaaa.uaa_codigo,ucaaa.uaa_nombre,ucaaa.uaa_nombre_corto, ");
			sql.append("ccaaa.car_codigo,ccaaa.car_nombre,ccaaa.car_id,coalesce(caa.caa_observacion,''),coalesce(caaa.caaa_observacion,'') ");
			sql.append("from cadtiva.carrera_administrativa_actualizacion caaa with(nolock) ");
			sql.append("inner join cadtiva.tipo_actualizacion tia with(nolock)  on(tia.tia_codigo=caaa.tia_codigo) ");
			sql.append("inner join cadtiva.carrera_administrativa caa with(nolock) on(caa.caa_codigo=caaa.caa_codigo) ");
			sql.append("inner join cadtiva.tipo_proceso tip with (nolock) on(tip.tip_codigo=caa.tip_codigo) ");
			sql.append("inner join persona p with(nolock) on(p.per_codigo=caa.per_codigo) ");
			sql.append("inner join uaa_cargo uccaa with(nolock) on(uccaa.uac_codigo=caa.uac_codigo) ");
			sql.append("inner join vinculacion vcaa with(nolock) on (vcaa.vin_codigo=uccaa.uac_vinculacion)   ");
			sql.append("inner join dedicacion dcaa with(nolock) on(dcaa.ded_codigo= uccaa.uac_dedicacion)  ");
			sql.append("inner join uaa ucaa with(nolock) on (ucaa.uaa_codigo=uccaa.uac_uaa)   ");
			sql.append("inner join cargo ccaa with(nolock) on (ccaa.car_codigo= uccaa.uac_cargo)   ");
			sql.append("inner join uaa_cargo uccaaa with(nolock) on(uccaaa.uac_codigo=caaa.uac_codigo) ");
			sql.append("inner join vinculacion vcaaa with(nolock) on (vcaaa.vin_codigo=uccaaa.uac_vinculacion)   ");
			sql.append("inner join dedicacion dcaaa with(nolock) on(dcaaa.ded_codigo= uccaaa.uac_dedicacion)  ");
			sql.append("inner join uaa ucaaa with(nolock) on (ucaaa.uaa_codigo=uccaaa.uac_uaa)   ");
			sql.append("inner join cargo ccaaa with(nolock) on (ccaaa.car_codigo= uccaaa.uac_cargo)   ");
			if(carrera_administrativa_actualizacion!=null && carrera_administrativa_actualizacion.getCaa().getPersona().getPer_codigo()>0){
				sql.append("WHERE  p.per_codigo=  "+carrera_administrativa_actualizacion.getCaa().getPersona().getPer_codigo()+" ");
			}
			
			sql.append(" ");
			sql.append(" ");
			sql.append(" ");
			sql.append(" ");
			sql.append(" ");
			sql.append(" ");
			if(admin!=null){
				conn = consegura.getconn_admin(admin);	
			}else{
				conn = consegura.Get_conexion_sesion();
			}
			
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				CarreraAdministrativaActualizacion elemento= new CarreraAdministrativaActualizacion();
				elemento.setCaaa_codigo(resul.getInt(1));
				elemento.getCaa().setCaa_codigo(resul.getInt(2));
				elemento.getCaa().getPersona().setPer_codigo(resul.getInt(3));
				elemento.getCaa().getPersona().setPer_nombre(resul.getString(4));
				elemento.getCaa().getPersona().setPer_apellido(resul.getString(5));
				elemento.getCaa().getPersona().setPer_identificacion(resul.getString(6));
				
				elemento.getCaa().getTipoPorceso().setTip_codigo(resul.getInt(7));
				elemento.getCaa().getTipoPorceso().setTip_nombre(resul.getString(8));
				elemento.getCaa().getTipoPorceso().setTip_estado(resul.getInt(9));
				
				elemento.getCaa().setCaa_acto_adtivo(resul.getString(10));
				elemento.getCaa().setCaa_fecha_acto_adtivo(resul.getDate(11));
				
				elemento.getCaa().getUaa_cargo().setUac_codigo(resul.getInt(12));
				elemento.getCaa().getUaa_cargo().setUac_codigoplanta(resul.getString(13));
				elemento.getCaa().getUaa_cargo().setUac_grado(resul.getInt(14));
				
				elemento.getCaa().getUaa_cargo().getVinculacion().setVin_codigo(resul.getInt(15));
				elemento.getCaa().getUaa_cargo().getVinculacion().setVin_nombre(resul.getString(16));
				elemento.getCaa().getUaa_cargo().getVinculacion().setVin_clase(resul.getInt(17));
				
				elemento.getCaa().getUaa_cargo().getDedicacion().setDed_codigo(resul.getInt(18));
				elemento.getCaa().getUaa_cargo().getDedicacion().setDed_nombre(resul.getString(19));
				
				elemento.getCaa().getUaa_cargo().getUaa().setUaa_codigo(resul.getInt(20));
				elemento.getCaa().getUaa_cargo().getUaa().setUaa_nombre(resul.getString(21));
				elemento.getCaa().getUaa_cargo().getUaa().setUaa_nombre_corto(resul.getString(22));
				
				elemento.getCaa().getUaa_cargo().getCargo().setCar_codigo(resul.getInt(23));
				elemento.getCaa().getUaa_cargo().getCargo().setCar_nombre(resul.getString(24));
				elemento.getCaa().getUaa_cargo().getCargo().setCar_id(resul.getString(25));
				
				elemento.getTipoActualizacion().setTia_codigo(resul.getInt(26));
				elemento.getTipoActualizacion().setTia_nombre(resul.getString(27));
				elemento.getTipoActualizacion().setTia_estado(resul.getInt(28));
				
				elemento.getCaa().setCaa_numero_convocatoria(resul.getString(29));
				elemento.getCaa().setCaa_fecha_convocatoria(resul.getDate(30));
				elemento.getCaa().setCaa_resolucion_elegibles(resul.getString(31));
				elemento.getCaa().setCaa_fecha_resolucion_elegibles(resul.getDate(32));
				elemento.getCaa().setCaa_numero_acta_posesion(resul.getString(33));
				elemento.getCaa().setCaa_fecha_acta_posesion(resul.getDate(34));
				
				elemento.setCaaa_acto_administrativo(resul.getString(35));
				elemento.setCaaa_fecha_acto_administrativo(resul.getDate(36));
				
				elemento.getUaa_cargo().setUac_codigo(resul.getInt(37));
				elemento.getUaa_cargo().setUac_codigoplanta(resul.getString(38));
				elemento.getUaa_cargo().setUac_grado(resul.getInt(39));
				
				elemento.getUaa_cargo().getVinculacion().setVin_codigo(resul.getInt(40));
				elemento.getUaa_cargo().getVinculacion().setVin_nombre(resul.getString(41));
				elemento.getUaa_cargo().getVinculacion().setVin_clase(resul.getInt(42));
				
				elemento.getUaa_cargo().getDedicacion().setDed_codigo(resul.getInt(43));
				elemento.getUaa_cargo().getDedicacion().setDed_nombre(resul.getString(44));
				
				elemento.getUaa_cargo().getUaa().setUaa_codigo(resul.getInt(45));
				elemento.getUaa_cargo().getUaa().setUaa_nombre(resul.getString(46));
				elemento.getUaa_cargo().getUaa().setUaa_nombre_corto(resul.getString(47));
				
				elemento.getUaa_cargo().getCargo().setCar_codigo(resul.getInt(48));
				elemento.getUaa_cargo().getCargo().setCar_nombre(resul.getString(49));
				elemento.getUaa_cargo().getCargo().setCar_id(resul.getString(50));
				elemento.getCaa().setCaa_observacion(resul.getString(51));
				elemento.setCaaa_observacion(resul.getString(52));
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
		 CarreraAdministrativaActualizacion elemento = null;
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 CarreraAdministrativaActualizacion caaa= (CarreraAdministrativaActualizacion) param[0];
			 Usuario admin= (Usuario) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("select caaa.caaa_codigo,caa.caa_codigo, ");
			sql.append("p.per_codigo,p.per_nombre,p.per_apellido,p.per_identificacion, ");
			sql.append("tip.tip_codigo,tip.tip_nombre,tip.tip_estado, ");
			sql.append("caa.caa_acto_adtivo,caa.caa_fecha_acto_adtivo, ");
			sql.append("uccaa.uac_codigo,uccaa.uac_codigoplanta,uccaa.uac_grado, ");
			sql.append("vcaa.vin_codigo,vcaa.vin_nombre,vcaa.vin_clase, ");
			sql.append("dcaa.ded_codigo,dcaa.ded_nombre, ");
			sql.append("ucaa.uaa_codigo,ucaa.uaa_nombre,ucaa.uaa_nombre_corto, ");
			sql.append("ccaa.car_codigo,ccaa.car_nombre,ccaa.car_id, ");
			sql.append("tia.tia_codigo,tia.tia_nombre,tia.tia_estado, ");
			sql.append("caa.caa_numero_convocatoria,caa.caa_fecha_convocatoria,caa.caa_resolucion_elegibles,caa.caa_fecha_resolucion_elegibles,caa.caa_numero_acta_posesion,caa.caa_fecha_acta_posesion, ");
			sql.append("caaa.caaa_acto_administrativo,caaa.caaa_fecha_acto_administrativo, ");
			sql.append("uccaaa.uac_codigo,uccaaa.uac_codigoplanta,uccaaa.uac_grado, ");
			sql.append("vcaaa.vin_codigo,vcaaa.vin_nombre,vcaaa.vin_clase, ");
			sql.append("dcaaa.ded_codigo,dcaaa.ded_nombre, ");
			sql.append("ucaaa.uaa_codigo,ucaaa.uaa_nombre,ucaaa.uaa_nombre_corto, ");
			sql.append("ccaaa.car_codigo,ccaaa.car_nombre,ccaaa.car_id,coalesce(caa.caa_observacion,''),coalesce(caaa.caaa_observacion,'') ");
			sql.append("from cadtiva.carrera_administrativa_actualizacion caaa with(nolock) ");
			sql.append("inner join cadtiva.tipo_actualizacion tia with(nolock)  on(tia.tia_codigo=caaa.tia_codigo) ");
			sql.append("inner join cadtiva.carrera_administrativa caa with(nolock) on(caa.caa_codigo=caaa.caa_codigo) ");
			sql.append("inner join cadtiva.tipo_proceso tip with (nolock) on(tip.tip_codigo=caa.tip_codigo) ");
			sql.append("inner join persona p with(nolock) on(p.per_codigo=caa.per_codigo) ");
			sql.append("inner join uaa_cargo uccaa with(nolock) on(uccaa.uac_codigo=caa.uac_codigo) ");
			sql.append("inner join vinculacion vcaa with(nolock) on (vcaa.vin_codigo=uccaa.uac_vinculacion)   ");
			sql.append("inner join dedicacion dcaa with(nolock) on(dcaa.ded_codigo= uccaa.uac_dedicacion)  ");
			sql.append("inner join uaa ucaa with(nolock) on (ucaa.uaa_codigo=uccaa.uac_uaa)   ");
			sql.append("inner join cargo ccaa with(nolock) on (ccaa.car_codigo= uccaa.uac_cargo)   ");
			sql.append("inner join uaa_cargo uccaaa with(nolock) on(uccaaa.uac_codigo=caaa.uac_codigo) ");
			sql.append("inner join vinculacion vcaaa with(nolock) on (vcaaa.vin_codigo=uccaaa.uac_vinculacion)   ");
			sql.append("inner join dedicacion dcaaa with(nolock) on(dcaaa.ded_codigo= uccaaa.uac_dedicacion)  ");
			sql.append("inner join uaa ucaaa with(nolock) on (ucaaa.uaa_codigo=uccaaa.uac_uaa)   ");
			sql.append("inner join cargo ccaaa with(nolock) on (ccaaa.car_codigo= uccaaa.uac_cargo)   ");
			sql.append("WHERE  ");
			if(caaa.getCaa().getPersona().getPer_codigo()>0){
				sql.append("p.per_codigo= "+caaa.getCaa().getPersona().getPer_codigo()+" ");
			}
			if(caaa.getCaa().getCaa_codigo()>0){
				sql.append("and caa.caa_codigo= "+caaa.getCaa().getCaa_codigo()+" ");
			}
			if(caaa.getCaaa_codigo()>0){
				sql.append("and caaa.caaa_codigo= "+caaa.getCaaa_codigo()+" ");
			}
			sql.append(" ");
			sql.append(" ");
			sql.append(" ");
			sql.append(" ");
			sql.append(" ");

			conn = consegura.getconn_admin(admin);
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				elemento= new CarreraAdministrativaActualizacion();
				elemento.setCaaa_codigo(resul.getInt(1));
				elemento.getCaa().setCaa_codigo(resul.getInt(2));
				elemento.getCaa().getPersona().setPer_codigo(resul.getInt(3));
				elemento.getCaa().getPersona().setPer_nombre(resul.getString(4));
				elemento.getCaa().getPersona().setPer_apellido(resul.getString(5));
				elemento.getCaa().getPersona().setPer_identificacion(resul.getString(6));
				
				elemento.getCaa().getTipoPorceso().setTip_codigo(resul.getInt(7));
				elemento.getCaa().getTipoPorceso().setTip_nombre(resul.getString(8));
				elemento.getCaa().getTipoPorceso().setTip_estado(resul.getInt(9));
				
				elemento.getCaa().setCaa_acto_adtivo(resul.getString(10));
				elemento.getCaa().setCaa_fecha_acto_adtivo(resul.getDate(11));
				
				elemento.getCaa().getUaa_cargo().setUac_codigo(resul.getInt(12));
				elemento.getCaa().getUaa_cargo().setUac_codigoplanta(resul.getString(13));
				elemento.getCaa().getUaa_cargo().setUac_grado(resul.getInt(14));
				
				elemento.getCaa().getUaa_cargo().getVinculacion().setVin_codigo(resul.getInt(15));
				elemento.getCaa().getUaa_cargo().getVinculacion().setVin_nombre(resul.getString(16));
				elemento.getCaa().getUaa_cargo().getVinculacion().setVin_clase(resul.getInt(17));
				
				elemento.getCaa().getUaa_cargo().getDedicacion().setDed_codigo(resul.getInt(18));
				elemento.getCaa().getUaa_cargo().getDedicacion().setDed_nombre(resul.getString(19));
				
				elemento.getCaa().getUaa_cargo().getUaa().setUaa_codigo(resul.getInt(20));
				elemento.getCaa().getUaa_cargo().getUaa().setUaa_nombre(resul.getString(21));
				elemento.getCaa().getUaa_cargo().getUaa().setUaa_nombre_corto(resul.getString(22));
				
				elemento.getCaa().getUaa_cargo().getCargo().setCar_codigo(resul.getInt(23));
				elemento.getCaa().getUaa_cargo().getCargo().setCar_nombre(resul.getString(24));
				elemento.getCaa().getUaa_cargo().getCargo().setCar_id(resul.getString(25));
				
				elemento.getTipoActualizacion().setTia_codigo(resul.getInt(26));
				elemento.getTipoActualizacion().setTia_nombre(resul.getString(27));
				elemento.getTipoActualizacion().setTia_estado(resul.getInt(28));
				
				elemento.getCaa().setCaa_numero_convocatoria(resul.getString(29));
				elemento.getCaa().setCaa_fecha_convocatoria(resul.getDate(30));
				elemento.getCaa().setCaa_resolucion_elegibles(resul.getString(31));
				elemento.getCaa().setCaa_fecha_resolucion_elegibles(resul.getDate(32));
				elemento.getCaa().setCaa_numero_acta_posesion(resul.getString(33));
				elemento.getCaa().setCaa_fecha_acta_posesion(resul.getDate(34));
				
				elemento.setCaaa_acto_administrativo(resul.getString(35));
				elemento.setCaaa_fecha_acto_administrativo(resul.getDate(36));
				
				elemento.getUaa_cargo().setUac_codigo(resul.getInt(37));
				elemento.getUaa_cargo().setUac_codigoplanta(resul.getString(38));
				elemento.getUaa_cargo().setUac_grado(resul.getInt(39));
				
				elemento.getUaa_cargo().getVinculacion().setVin_codigo(resul.getInt(40));
				elemento.getUaa_cargo().getVinculacion().setVin_nombre(resul.getString(41));
				elemento.getUaa_cargo().getVinculacion().setVin_clase(resul.getInt(42));
				
				elemento.getUaa_cargo().getDedicacion().setDed_codigo(resul.getInt(43));
				elemento.getUaa_cargo().getDedicacion().setDed_nombre(resul.getString(44));
				
				elemento.getUaa_cargo().getUaa().setUaa_codigo(resul.getInt(45));
				elemento.getUaa_cargo().getUaa().setUaa_nombre(resul.getString(46));
				elemento.getUaa_cargo().getUaa().setUaa_nombre_corto(resul.getString(47));
				
				elemento.getUaa_cargo().getCargo().setCar_codigo(resul.getInt(48));
				elemento.getUaa_cargo().getCargo().setCar_nombre(resul.getString(49));
				elemento.getUaa_cargo().getCargo().setCar_id(resul.getString(50));
				
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
			 CarreraAdministrativaActualizacion caaa= (CarreraAdministrativaActualizacion)obj;
//			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			 Usuario admin=(Usuario) obj1;
			sql.append("UPDATE cadtiva.carrera_administrativa_actualizacion  ");
//			sql.append("caaa_fecha_acto_administrativo,uac_codigo) VALUES ( ");
			sql.append("SET caa_codigo = '"+caaa.getCaa().getCaa_codigo()+"'");
			sql.append(",tia_codigo =  '"+caaa.getTipoActualizacion().getTia_codigo()+"'");
			sql.append(",caaa_acto_administrativo =  '"+caaa.getCaaa_acto_administrativo()+"'");
			sql.append(" ,caaa_fecha_acto_administrativo =  '"+new java.sql.Date(caaa.getCaaa_fecha_acto_administrativo().getTime())+"'");
			sql.append(" ,uac_codigo =  '"+caaa.getCaa().getUaa_cargo().getUac_codigo()+"'");
			sql.append(" ,caaa_observacion =  '"+caaa.getCaaa_observacion()+"'");
			sql.append("WHERE caaa_codigo= "+caaa.getCaaa_codigo()+" and caa_codigo="+caaa.getCaa().getCaa_codigo());
			sql.append("  ");
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
			 CarreraAdministrativaActualizacion caa= (CarreraAdministrativaActualizacion)obj;
			 Usuario admin=(Usuario) obj1;
			sql.append("INSERT INTO cadtiva.carrera_administrativa_actualizacion (caa_codigo,tia_codigo,caaa_acto_administrativo,  ");
			sql.append("caaa_fecha_acto_administrativo,uac_codigo,caaa_observacion) VALUES ( ");
			sql.append("'"+caa.getCaa().getCaa_codigo()+"'");
			sql.append(" , '"+caa.getTipoActualizacion().getTia_codigo()+"'");
			sql.append(" , '"+caa.getCaaa_acto_administrativo()+"'");
			sql.append(" , '"+new java.sql.Date(caa.getCaaa_fecha_acto_administrativo().getTime())+"'");
			sql.append(" , '"+caa.getCaa().getUaa_cargo().getUac_codigo()+"'");
			sql.append(" , '"+caa.getCaaa_observacion()+"'");
			sql.append(" ) ");
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
			Conexion consegura = new Conexion();
			boolean existe= true;
		 try {
			 Object param[]=(Object[]) obj;
			 CarreraAdministrativaActualizacion caa= (CarreraAdministrativaActualizacion) param[0];
			 Usuario admin= (Usuario) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT count(*)FROM cadtiva.carrera_administrativa_actualizacion caaa with(nolock) ");
			sql.append("inner join cadtiva.carrera_administrativa caa with(nolock)  on(caa.caa_codigo=caaa.caa_codigo)");
			sql.append(" where caa.per_codigo= "+caa.getCaa().getPersona().getPer_codigo()+"  and caa.caa_codigo= "+caa.getCaa().getCaa_codigo()+ " and caaa.caaa_codigo=" +caa.getCaaa_codigo()+ " ");
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
