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
import co.edu.usco.modulo.personal.mvc.modelo.PublicacionTipo;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa.CarreraAdministrativa;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class CarreraAdministrativaDB implements ConexionDB{
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
			StringBuffer sql = new StringBuffer();
		 try {
			 Object param[]=(Object[]) obj;
			 CarreraAdministrativa caa= (CarreraAdministrativa) param[0];
			 Usuario admin= (Usuario) param[1];
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
			sql.append("left join uaa_cargo uc with(nolock) on (uc.uac_codigo =caa.uac_codigo)  ");
			sql.append("left join vinculacion v with(nolock) on (v.vin_codigo=uc.uac_vinculacion)  ");
			sql.append("left join dedicacion d with(nolock) on(d.ded_codigo= uc.uac_dedicacion)  ");
			sql.append("left join uaa u with(nolock) on (u.uaa_codigo=uc.uac_uaa)  ");
			sql.append("left join cargo c with(nolock) on (c.car_codigo= uc.uac_cargo)  ");
			sql.append("  ");
			if(caa.getPersona().getNombre()!=null && caa.getPersona().getNombre().length()>0){
				sql.append("WHERE per_identificacion like '%"+caa.getPersona().getNombre()+"%'  or per_apellido+' '+per_nombre like'%"+caa.getPersona().getNombre()+"%' or per_nombre+' '+per_apellido like '%"+caa.getPersona().getNombre()+"%' ");
			}
			sql.append("order by p.per_nombre,p.per_apellido  ");

			conn = consegura.getconn_admin(admin);
			imp.info("getAll "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				CarreraAdministrativa elemento= new CarreraAdministrativa();
				elemento.setCodigo(resul.getInt(1));
				
				elemento.getPersona().setCodigo(resul.getInt(2));
				elemento.getPersona().setNombre(resul.getString(3));
				elemento.getPersona().setApellido(resul.getString(4));
				elemento.getPersona().setIdentificacion(resul.getString(5));
				
				elemento.getTipoProceso().setCodigo(resul.getInt(6));
				elemento.getTipoProceso().setNombre(resul.getString(7));
				elemento.getTipoProceso().setEstado(resul.getInt(8));
				
				elemento.setActoAdtivo(resul.getString(9));
				elemento.setFechaActoAdtivo(resul.getDate(10));
				
				elemento.getUaaCargo().setCodigo(resul.getInt(11));
				elemento.getUaaCargo().setCodigoPlanta(resul.getString(12));
				elemento.getUaaCargo().setGrado(resul.getInt(13));
				
				elemento.getUaaCargo().getVinculacion().setCodigo(resul.getInt(14));
				elemento.getUaaCargo().getVinculacion().setNombre(resul.getString(15));
				
				elemento.getUaaCargo().getDedicacion().setCodigo(resul.getInt(16));
				elemento.getUaaCargo().getDedicacion().setNombre(resul.getString(17));
				
				elemento.getUaaCargo().getUaa().setCodigo(resul.getInt(18));
				elemento.getUaaCargo().getUaa().setNombre(resul.getString(19));
				
				elemento.getUaaCargo().getCargo().setCodigo(resul.getInt(20));
				elemento.getUaaCargo().getCargo().setNombre(resul.getString(21));
				
				elemento.setNumeroConvocatoria(resul.getString(22));
				elemento.setFechaConvocatoria(resul.getDate(23));
				elemento.setResolucionElegibles(resul.getString(24));
				elemento.setFechaResolucionElegibles(resul.getDate(25));
				elemento.setNumeroActaPosesion(resul.getString(26));
				elemento.setFechaActaPosesion(resul.getDate(27));
				elemento.setObservacion(resul.getString(28));
				lista.add(elemento);
				}
			consegura.cerrarconn(conn, resul, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString()+" "+sql.toString() );
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
			sql.append("c.car_codigo,c.car_nombre, c.car_id, ");
			sql.append("caa_numero_convocatoria,caa_fecha_convocatoria,caa_resolucion_elegibles,caa_fecha_resolucion_elegibles,caa_numero_acta_posesion, caa_fecha_acta_posesion,caa_estado  ");
			sql.append(", m.mun_codigo,m.mun_nombre,dpto.dep_codigo,dpto.dep_nombre,coalesce(caa.caa_observacion,'') ");
			sql.append("FROM cadtiva.carrera_administrativa caa with(nolock)  ");
			sql.append("inner join persona  p with(nolock) on (p.per_codigo=caa.per_codigo)  ");
			sql.append("left join municipio m with(nolock) on (m.mun_codigo=p.per_lugar_expedicion)  ");
			sql.append("left join departamento dpto with(nolock) on (dpto.dep_codigo= m.dep_codigo)  ");
			sql.append("inner join cadtiva.tipo_proceso tp with(nolock) on(tp.tip_codigo=caa.tip_codigo)  ");
			sql.append("left join uaa_cargo uc with(nolock) on (uc.uac_codigo =caa.uac_codigo)  ");
			sql.append("left join vinculacion v with(nolock) on (v.vin_codigo=uc.uac_vinculacion)  ");
			sql.append("left join dedicacion d with(nolock) on(d.ded_codigo= uc.uac_dedicacion)  ");
			sql.append("left join uaa u with(nolock) on (u.uaa_codigo=uc.uac_uaa)  ");
			sql.append("left join cargo c with(nolock) on (c.car_codigo= uc.uac_cargo)  ");
			sql.append("WHERE (caa_estado=1 or caa_estado=0) ");
			if(caa.getPersona().getCodigo()>0){
				sql.append("and p.per_codigo= "+caa.getPersona().getCodigo()+" ");
			}
			if(caa.getCodigo()>0){
				sql.append("and caa.caa_codigo= "+caa.getCodigo()+" ");
			}


			conn = consegura.getconn_admin(admin);
			imp.info("getObject "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				elemento= new CarreraAdministrativa();
				elemento.setCodigo(resul.getInt(1));
				
				elemento.getPersona().setCodigo(resul.getInt(2));
				elemento.getPersona().setNombre(resul.getString(3));
				elemento.getPersona().setApellido(resul.getString(4));
				elemento.getPersona().setIdentificacion(resul.getString(5));
				
				elemento.getTipoProceso().setCodigo(resul.getInt(6));
				elemento.getTipoProceso().setNombre(resul.getString(7));
				elemento.getTipoProceso().setEstado(resul.getInt(8));
				
				elemento.setActoAdtivo(resul.getString(9));
				elemento.setFechaActoAdtivo(resul.getDate(10));
				
				elemento.getUaaCargo().setCodigo(resul.getInt(11));
				elemento.getUaaCargo().setCodigoPlanta(resul.getString(12));
				elemento.getUaaCargo().setGrado(resul.getInt(13));
				
				elemento.getUaaCargo().getVinculacion().setCodigo(resul.getInt(14));
				elemento.getUaaCargo().getVinculacion().setNombre(resul.getString(15));
				
				elemento.getUaaCargo().getDedicacion().setCodigo(resul.getInt(16));
				elemento.getUaaCargo().getDedicacion().setNombre(resul.getString(17));
				
				elemento.getUaaCargo().getUaa().setCodigo(resul.getInt(18));
				elemento.getUaaCargo().getUaa().setNombre(resul.getString(19));
				
				elemento.getUaaCargo().getCargo().setCodigo(resul.getInt(20));
				elemento.getUaaCargo().getCargo().setNombre(resul.getString(21));
				elemento.getUaaCargo().getCargo().setId(resul.getString(22));
				 
				elemento.setNumeroConvocatoria(resul.getString(23));
				elemento.setFechaConvocatoria(resul.getDate(24));
				elemento.setResolucionElegibles(resul.getString(25));
				elemento.setFechaResolucionElegibles(resul.getDate(26));
				elemento.setNumeroActaPosesion(resul.getString(27));
				elemento.setFechaActaPosesion(resul.getDate(28)); 
				elemento.getPersona().getLugarExpedicion().setCodigo(resul.getInt(30));
				elemento.getPersona().getLugarExpedicion().setNombre(resul.getString(31)); 
				elemento.getPersona().getLugarExpedicion().getDepartamento().setCodigo(resul.getInt(32)); 
				elemento.getPersona().getLugarExpedicion().getDepartamento().setNombre(resul.getString(33)); 
				elemento.setObservacion(resul.getString(34));
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
			sql.append("per_codigo ='"+caa.getPersona().getCodigo()+"'");
			sql.append(",tip_codigo ='"+caa.getTipoProceso().getCodigo()+"'");
			sql.append(",caa_acto_adtivo =  '"+caa.getActoAdtivo()+"'");
			sql.append(",caa_fecha_acto_adtivo = '"+Fecha.sumarFechasDias(new java.sql.Date(caa.getFechaActoAdtivo().getTime()),1)+"'");
			sql.append(",uac_codigo =  '"+caa.getUaaCargo().getCodigo()+"'");

			if(caa.getNumeroConvocatoria()!=null){
				sql.append(",caa_numero_convocatoria ='"+caa.getNumeroConvocatoria()+"'");
			}else{
				sql.append(" ,caa_numero_convocatoria =null ");
			}
			
			if(caa.getFechaConvocatoria()!=null){
				sql.append(",caa_fecha_convocatoria = '"+Fecha.sumarFechasDias(new java.sql.Date(caa.getFechaActoAdtivo().getTime()),1) +"'");
			}else{
				sql.append(" ,caa_fecha_convocatoria = null");
			}
			
			
			if(caa.getResolucionElegibles()!=null){
				sql.append(",caa_resolucion_elegibles = '"+caa.getResolucionElegibles()+"'");
			}else{
				sql.append(" ,caa_resolucion_elegibles =null ");
			}
			
			if(caa.getFechaResolucionElegibles()!=null){
				sql.append(",caa_fecha_resolucion_elegibles =  '"+Fecha.sumarFechasDias(new java.sql.Date(caa.getFechaActoAdtivo().getTime()),1)+"'");
			}else{
				sql.append(" ,caa_fecha_resolucion_elegibles =  null");
			}
			
			if(caa.getNumeroActaPosesion()!=null){
				sql.append(",caa_numero_acta_posesion =  '"+caa.getNumeroActaPosesion()+"'");
			}else{
				sql.append(" ,caa_numero_acta_posesion = null ");
			}
			
			
			if(caa.getFechaActaPosesion()!=null){
				sql.append(",caa_fecha_acta_posesion = '"+Fecha.sumarFechasDias(new java.sql.Date(caa.getFechaActoAdtivo().getTime()),1)+"'");
			}else{
				sql.append(" , caa_fecha_acta_posesion = null");
			}

			sql.append(",caa_observacion =  '"+caa.getObservacion()+"'");
			sql.append(",caa_estado = 1 ");
			sql.append(" WHERE caa_codigo= "+caa.getCodigo()+" ");
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
			sql.append("'"+caa.getPersona().getCodigo()+"'");
			sql.append(" , '"+caa.getTipoProceso().getCodigo()+"'");
			sql.append(" , '"+caa.getActoAdtivo()+"'");
			sql.append(" , '"+Fecha.sumarFechasDias(new java.sql.Date(caa.getFechaActoAdtivo().getTime()),1)+"'");
			sql.append(" , '"+caa.getUaaCargo().getCodigo()+"'");
			if(caa.getNumeroConvocatoria()!=null){
				sql.append(" , '"+caa.getNumeroConvocatoria()+"'");
			}else{
				sql.append(" ,null ");
			}
			
			if(caa.getFechaConvocatoria()!=null){
				sql.append(" , '"+Fecha.sumarFechasDias(new java.sql.Date(caa.getFechaActoAdtivo().getTime()),1)+"'");
			}else{
				sql.append(" , null");
			}
			
			
			if(caa.getResolucionElegibles()!=null){
				sql.append(" , '"+caa.getResolucionElegibles()+"'");
			}else{
				sql.append(" ,null ");
			}
			
			if(caa.getFechaResolucionElegibles()!=null){
				sql.append(" , '"+Fecha.sumarFechasDias(new java.sql.Date(caa.getFechaActoAdtivo().getTime()),1)+"'");
			}else{
				sql.append(" , null");
			}
			
			if(caa.getNumeroActaPosesion()!=null){
				sql.append(" , '"+caa.getNumeroActaPosesion()+"'");
			}else{
				sql.append(" ,null ");
			}
			
			
			if(caa.getFechaActaPosesion()!=null){
				sql.append(" , '"+Fecha.sumarFechasDias(new java.sql.Date(caa.getFechaActoAdtivo().getTime()),1)+"'");
			}else{
				sql.append(" , null");
			}
			sql.append(",  '"+caa.getObservacion()+"'");
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
		 LinkedList<PublicacionTipo> lista = new LinkedList<PublicacionTipo>();
			Conexion consegura = new Conexion();
			boolean existe= true;
		 try {
			 Object param[]=(Object[]) obj;
			 CarreraAdministrativa caa= (CarreraAdministrativa) param[0];
			 Usuario admin= (Usuario) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT count(*)FROM cadtiva.carrera_administrativa caa with(nolock) ");
			sql.append(" where per_codigo= "+caa.getPersona().getCodigo()+" ");
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
