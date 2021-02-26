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
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa.CarreraAdministrativaActualizacion;
/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class CarreraAdministrativaActualizacionDB implements ConexionDB {
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
			sql.append("left join uaa_cargo uccaa with(nolock) on(uccaa.uac_codigo=caa.uac_codigo) ");
			sql.append("left join vinculacion vcaa with(nolock) on (vcaa.vin_codigo=uccaa.uac_vinculacion)   ");
			sql.append("left join dedicacion dcaa with(nolock) on(dcaa.ded_codigo= uccaa.uac_dedicacion)  ");
			sql.append("left join uaa ucaa with(nolock) on (ucaa.uaa_codigo=uccaa.uac_uaa)   ");
			sql.append("left join cargo ccaa with(nolock) on (ccaa.car_codigo= uccaa.uac_cargo)   ");
			sql.append("left join uaa_cargo uccaaa with(nolock) on(uccaaa.uac_codigo=caaa.uac_codigo) ");
			sql.append("left join vinculacion vcaaa with(nolock) on (vcaaa.vin_codigo=uccaaa.uac_vinculacion)   ");
			sql.append("left join dedicacion dcaaa with(nolock) on(dcaaa.ded_codigo= uccaaa.uac_dedicacion)  ");
			sql.append("left join uaa ucaaa with(nolock) on (ucaaa.uaa_codigo=uccaaa.uac_uaa)   ");
			sql.append("left join cargo ccaaa with(nolock) on (ccaaa.car_codigo= uccaaa.uac_cargo)   ");
			if(carrera_administrativa_actualizacion!=null && carrera_administrativa_actualizacion.getCaa().getPersona().getCodigo()>0){
				sql.append("WHERE  p.per_codigo=  "+carrera_administrativa_actualizacion.getCaa().getPersona().getCodigo()+" ");
			}
			
			sql.append("order by p.per_nombre,p.per_apellido asc ");
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
				elemento.setCodigo(resul.getInt(1));
				elemento.getCaa().setCodigo(resul.getInt(2));
				elemento.getCaa().getPersona().setCodigo(resul.getInt(3));
				elemento.getCaa().getPersona().setNombre(resul.getString(4));
				elemento.getCaa().getPersona().setApellido(resul.getString(5));
				elemento.getCaa().getPersona().setIdentificacion(resul.getString(6));
				
				elemento.getCaa().getTipoProceso().setCodigo(resul.getInt(7));
				elemento.getCaa().getTipoProceso().setNombre(resul.getString(8));
				elemento.getCaa().getTipoProceso().setEstado(resul.getInt(9));
				
				elemento.getCaa().setActoAdtivo(resul.getString(10));
				elemento.getCaa().setFechaActoAdtivo(resul.getDate(11));
				
				elemento.getCaa().getUaaCargo().setCodigo(resul.getInt(12));
				elemento.getCaa().getUaaCargo().setCodigoPlanta(resul.getString(13));
				elemento.getCaa().getUaaCargo().setGrado(resul.getInt(14));
				
				elemento.getCaa().getUaaCargo().getVinculacion().setCodigo(resul.getInt(15));
				elemento.getCaa().getUaaCargo().getVinculacion().setNombre(resul.getString(16));
				elemento.getCaa().getUaaCargo().getVinculacion().setClase(resul.getInt(17));
				
				elemento.getCaa().getUaaCargo().getDedicacion().setCodigo(resul.getInt(18));
				elemento.getCaa().getUaaCargo().getDedicacion().setNombre(resul.getString(19));
				
				elemento.getCaa().getUaaCargo().getUaa().setCodigo(resul.getInt(20));
				elemento.getCaa().getUaaCargo().getUaa().setNombre(resul.getString(21));
				elemento.getCaa().getUaaCargo().getUaa().setNombreCorto(resul.getString(22));
				
				elemento.getCaa().getUaaCargo().getCargo().setCodigo(resul.getInt(23));
				elemento.getCaa().getUaaCargo().getCargo().setNombre(resul.getString(24));
				elemento.getCaa().getUaaCargo().getCargo().setId(resul.getString(25));
				
				elemento.getTipoActualizacion().setCodigo(resul.getInt(26));
				elemento.getTipoActualizacion().setNombre(resul.getString(27));
				elemento.getTipoActualizacion().setEstado(resul.getInt(28));
				
				elemento.getCaa().setNumeroConvocatoria(resul.getString(29));
				elemento.getCaa().setFechaConvocatoria(resul.getDate(30));
				elemento.getCaa().setResolucionElegibles(resul.getString(31));
				elemento.getCaa().setFechaResolucionElegibles(resul.getDate(32));
				elemento.getCaa().setNumeroActaPosesion(resul.getString(33));
				elemento.getCaa().setFechaActaPosesion(resul.getDate(34));
				
				elemento.setActoAdministrativo(resul.getString(35));
				elemento.setFechaActoAdministrativo(resul.getDate(36));
				
				elemento.getUaaCargo().setCodigo(resul.getInt(37));
				elemento.getUaaCargo().setCodigoPlanta(resul.getString(38));
				elemento.getUaaCargo().setGrado(resul.getInt(39));
				
				elemento.getUaaCargo().getVinculacion().setCodigo(resul.getInt(40));
				elemento.getUaaCargo().getVinculacion().setNombre(resul.getString(41));
				elemento.getUaaCargo().getVinculacion().setClase(resul.getInt(42));
				
				elemento.getUaaCargo().getDedicacion().setCodigo(resul.getInt(43));
				elemento.getUaaCargo().getDedicacion().setNombre(resul.getString(44));
				
				elemento.getUaaCargo().getUaa().setCodigo(resul.getInt(45));
				elemento.getUaaCargo().getUaa().setNombre(resul.getString(46));
				elemento.getUaaCargo().getUaa().setNombreCorto(resul.getString(47));
				
				elemento.getUaaCargo().getCargo().setCodigo(resul.getInt(48));
				elemento.getUaaCargo().getCargo().setNombre(resul.getString(49));
				elemento.getUaaCargo().getCargo().setId(resul.getString(50));
				elemento.getCaa().setObservacion(resul.getString(51));
				elemento.setObservacion(resul.getString(52));
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
			sql.append("left join uaa_cargo uccaa with(nolock) on(uccaa.uac_codigo=caa.uac_codigo) ");
			sql.append("left join vinculacion vcaa with(nolock) on (vcaa.vin_codigo=uccaa.uac_vinculacion)   ");
			sql.append("left join dedicacion dcaa with(nolock) on(dcaa.ded_codigo= uccaa.uac_dedicacion)  ");
			sql.append("left join uaa ucaa with(nolock) on (ucaa.uaa_codigo=uccaa.uac_uaa)   ");
			sql.append("left join cargo ccaa with(nolock) on (ccaa.car_codigo= uccaa.uac_cargo)   ");
			sql.append("left join uaa_cargo uccaaa with(nolock) on(uccaaa.uac_codigo=caaa.uac_codigo) ");
			sql.append("left join vinculacion vcaaa with(nolock) on (vcaaa.vin_codigo=uccaaa.uac_vinculacion)   ");
			sql.append("left join dedicacion dcaaa with(nolock) on(dcaaa.ded_codigo= uccaaa.uac_dedicacion)  ");
			sql.append("left join uaa ucaaa with(nolock) on (ucaaa.uaa_codigo=uccaaa.uac_uaa)   ");
			sql.append("left join cargo ccaaa with(nolock) on (ccaaa.car_codigo= uccaaa.uac_cargo)   ");
			sql.append("WHERE  ");
			if(caaa.getCaa().getPersona().getCodigo()>0){
				sql.append("p.per_codigo= "+caaa.getCaa().getPersona().getCodigo()+" ");
			}
			if(caaa.getCaa().getCodigo()>0){
				sql.append("and caa.caa_codigo= "+caaa.getCaa().getCodigo()+" ");
			}
			if(caaa.getCodigo()>0){
				sql.append("and caaa.caaa_codigo= "+caaa.getCodigo()+" ");
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
				elemento.setCodigo(resul.getInt(1));
				elemento.getCaa().setCodigo(resul.getInt(2));
				elemento.getCaa().getPersona().setCodigo(resul.getInt(3));
				elemento.getCaa().getPersona().setNombre(resul.getString(4));
				elemento.getCaa().getPersona().setApellido(resul.getString(5));
				elemento.getCaa().getPersona().setIdentificacion(resul.getString(6));
				
				elemento.getCaa().getTipoProceso().setCodigo(resul.getInt(7));
				elemento.getCaa().getTipoProceso().setNombre(resul.getString(8));
				elemento.getCaa().getTipoProceso().setEstado(resul.getInt(9));
				
				elemento.getCaa().setActoAdtivo(resul.getString(10));
				elemento.getCaa().setFechaActoAdtivo(resul.getDate(11));
				
				elemento.getCaa().getUaaCargo().setCodigo(resul.getInt(12));
				elemento.getCaa().getUaaCargo().setCodigoPlanta(resul.getString(13));
				elemento.getCaa().getUaaCargo().setGrado(resul.getInt(14));
				
				elemento.getCaa().getUaaCargo().getVinculacion().setCodigo(resul.getInt(15));
				elemento.getCaa().getUaaCargo().getVinculacion().setNombre(resul.getString(16));
				elemento.getCaa().getUaaCargo().getVinculacion().setClase(resul.getInt(17));
				
				elemento.getCaa().getUaaCargo().getDedicacion().setCodigo(resul.getInt(18));
				elemento.getCaa().getUaaCargo().getDedicacion().setNombre(resul.getString(19));
				
				elemento.getCaa().getUaaCargo().getUaa().setCodigo(resul.getInt(20));
				elemento.getCaa().getUaaCargo().getUaa().setNombre(resul.getString(21));
				elemento.getCaa().getUaaCargo().getUaa().setNombreCorto(resul.getString(22));
				
				elemento.getCaa().getUaaCargo().getCargo().setCodigo(resul.getInt(23));
				elemento.getCaa().getUaaCargo().getCargo().setNombre(resul.getString(24));
				elemento.getCaa().getUaaCargo().getCargo().setId(resul.getString(25));
				
				elemento.getTipoActualizacion().setCodigo(resul.getInt(26));
				elemento.getTipoActualizacion().setNombre(resul.getString(27));
				elemento.getTipoActualizacion().setEstado(resul.getInt(28));
				
				elemento.getCaa().setNumeroConvocatoria(resul.getString(29));
				elemento.getCaa().setFechaConvocatoria(resul.getDate(30));
				elemento.getCaa().setResolucionElegibles(resul.getString(31));
				elemento.getCaa().setFechaResolucionElegibles(resul.getDate(32));
				elemento.getCaa().setNumeroActaPosesion(resul.getString(33));
				elemento.getCaa().setFechaActaPosesion(resul.getDate(34));
				
				elemento.setActoAdministrativo(resul.getString(35));
				elemento.setFechaActoAdministrativo(resul.getDate(36));
				
				elemento.getUaaCargo().setCodigo(resul.getInt(37));
				elemento.getUaaCargo().setCodigoPlanta(resul.getString(38));
				elemento.getUaaCargo().setGrado(resul.getInt(39));
				
				elemento.getUaaCargo().getVinculacion().setCodigo(resul.getInt(40));
				elemento.getUaaCargo().getVinculacion().setNombre(resul.getString(41));
				elemento.getUaaCargo().getVinculacion().setClase(resul.getInt(42));
				
				elemento.getUaaCargo().getDedicacion().setCodigo(resul.getInt(43));
				elemento.getUaaCargo().getDedicacion().setNombre(resul.getString(44));
				
				elemento.getUaaCargo().getUaa().setCodigo(resul.getInt(45));
				elemento.getUaaCargo().getUaa().setNombre(resul.getString(46));
				elemento.getUaaCargo().getUaa().setNombreCorto(resul.getString(47));
				
				elemento.getUaaCargo().getCargo().setCodigo(resul.getInt(48));
				elemento.getUaaCargo().getCargo().setNombre(resul.getString(49));
				elemento.getUaaCargo().getCargo().setId(resul.getString(50));
				elemento.getCaa().setObservacion(resul.getString(51));
				elemento.setObservacion(resul.getString(52));
				
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
			sql.append("SET caa_codigo = '"+caaa.getCaa().getCodigo()+"'");
			sql.append(",tia_codigo =  '"+caaa.getTipoActualizacion().getCodigo()+"'");
			sql.append(",caaa_acto_administrativo =  '"+caaa.getActoAdministrativo()+"'");
			sql.append(" ,caaa_fecha_acto_administrativo =  '"+Fecha.sumarFechasDias(new java.sql.Date(caaa.getFechaActoAdministrativo().getTime()),1)+"'");
			sql.append(" ,uac_codigo =  '"+caaa.getUaaCargo().getCodigo()+"'");
			sql.append(" ,caaa_observacion =  '"+caaa.getObservacion()+"'");
			sql.append("WHERE caaa_codigo= "+caaa.getCodigo()+" and caa_codigo="+caaa.getCaa().getCodigo());
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
			sql.append("'"+caa.getCaa().getCodigo()+"'");
			sql.append(" , '"+caa.getTipoActualizacion().getCodigo()+"'");
			sql.append(" , '"+caa.getActoAdministrativo()+"'");
			sql.append(" , '"+Fecha.sumarFechasDias(new java.sql.Date(caa.getFechaActoAdministrativo().getTime()),1)+"'");
			sql.append(" , '"+caa.getUaaCargo().getCodigo()+"'");
			sql.append(" , '"+caa.getObservacion()+"'");
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
			sql.append(" where caa.per_codigo= "+caa.getCaa().getPersona().getCodigo()+"  and caa.caa_codigo= "+caa.getCaa().getCodigo()+ " and caaa.caaa_codigo=" +caa.getCodigo()+ " ");
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
