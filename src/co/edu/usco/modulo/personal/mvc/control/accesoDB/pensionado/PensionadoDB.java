/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB.pensionado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.GrupoSanguineoDB;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.pensionado.Pensionado;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PensionadoDB implements ConexionDB {

	private Logger imp ;
	/**
	 * 
	 */
	
	public static String  campos="pen.pen_codigo, pen.per_codigo, pen.uap_codigo, pen.pen_fecha, pen.pen_tiempo_trabajo, pen.tip_pen_codigo, pen.pen_resolucion, pen.pen_observacion";
	
	/**
	 * 
	 */
	public static String sqlSelect = ""+
	"SELECT "+campos+", "+TipoPensionDB.campos+","+GrupoSanguineoDB.COLUMNAS+", p.per_codigo as per_codigo, p.per_identificacion,p.tii_codigo,ti.tii_nombre,ti.tii_nombre_corto,p.per_libreta_militar,p.per_apellido1,p.per_apellido2, "+
	"p.per_nombre1,p.per_nombre2,p.per_genero ,p.per_lugar_nacimiento AS nMun_codigo,munNacimiento.mun_nombre  AS nMun_nombre,depNacimiento.dep_codigo AS nDpt_codigo,depNacimiento.dep_nombre  AS nDpt_nombre, paisNacimiento.pai_codigo  AS nPais_codigo, "+
	"paisNacimiento.pai_nombre  AS nPais_nombre , p.per_fecha_nacimiento AS fchnac,p.per_direccion_residencia,p.per_telefono_movil,p.per_telefono_fijo,p.per_estado_civil,p.per_lugar_nacimiento, "+
	"p.per_lugar_residencia,p.per_barrio  ,p.per_estado,p.eps_codigo,p.eta_codigo,p.per_numero_afiliacion_eps,p.per_familiar_direccion,p.per_familiar_nombre, "+
	"p.per_familiar_telefono,p.per_familiar_lugar_residencia,p.per_email,p.per_email_interno,p.per_pagina_personal ,p.grs_codigo,p.Expr1,p.nat_codigo,  "+
	"p.reg_codigo,p.per_razon_social,p.per_identificacion_dup,p.per_codigo_pais_hecaa,p.per_estrato,p.per_fecha_expedicion, "+
	" up.uap_fecha_inicio ,up.uap_fecha_fin,  "+
	"case when up.uap_cargo <> 0 then (select c.car_nombre from cargo c where c.car_codigo=up.uap_cargo )  "+
	"else (select c.car_nombre from uaa_cargo uc inner join cargo as c on (c.car_codigo=uc.uac_cargo) where uc.uac_codigo=up.uac_codigo ) end as car_nombre "+
	",p.per_lugar_expedicion AS eMun_codigo,munExpedicion.mun_nombre AS eMun_nombre,depExpedicion.dep_codigo AS eDpt_codigo,depExpedicion.dep_nombre AS eDpt_nombre,paisExpedicion.pai_codigo AS ePais_codigo,paisExpedicion.pai_nombre  AS ePais_nombre, "+
	"case when up.uap_cargo <> 0 then (select c.car_nombre from cargo c where c.car_codigo=up.uap_cargo )  "+
	"else (select c.car_nombre from uaa_cargo uc inner join cargo as c on (c.car_codigo=uc.uac_cargo) where uc.uac_codigo=up.uac_codigo ) end as car_nombre, "+
	"case when up.vin_codigo <> 0 then  "+
	"(select v.vin_nombre from vinculacion v where v.vin_codigo=up.vin_codigo) "+
	"else (select v.vin_nombre from uaa_cargo uc inner join vinculacion as v on (v.vin_codigo=uc.uac_vinculacion) where uc.uac_codigo=up.uac_codigo ) end as vin_nombre,  "+
	"case when up.uap_cargo <> 0 then "+
	"(select u.uaa_nombre from uaa u where u.uaa_codigo=up.uaa_codigo)  "+
	"else (select u.uaa_nombre from uaa_cargo uc inner join uaa as u on (u.uaa_codigo=uc.uac_uaa) where uc.uac_codigo=up.uac_codigo ) end as uaa_nombre  "+
	"FROM pensionado pen with(nolock)    "+
	"inner join tipo_pension tp with(nolock)  on(pen.tip_pen_codigo=tp.tip_pen_codigo) "+
	"inner join persona_usco p with(nolock)  on(pen.per_codigo=p.per_codigo)  "+
	"left join tipo_id ti with(nolock) on(ti.tii_codigo= p.tii_codigo)   "+
	"left join grupo_sanguineo gs  with(nolock) on(gs.grs_codigo=p.grs_codigo)  "+
	"left join municipio  munNacimiento with(nolock) on(munNacimiento.mun_codigo=p.per_lugar_nacimiento)   "+
	"left join departamento depNacimiento with(nolock) on(depNacimiento.dep_codigo=munNacimiento.dep_codigo)    "+
	"left join pais paisNacimiento with(nolock) on (paisNacimiento.pai_codigo=depNacimiento.pai_codigo)   "+
	"left join municipio  munExpedicion with(nolock) on(munExpedicion.mun_codigo=p.per_lugar_expedicion)   "+
	"left join departamento depExpedicion with(nolock) on(depExpedicion.dep_codigo=munExpedicion.dep_codigo)    "+
	"left join pais paisExpedicion with(nolock) on (paisExpedicion.pai_codigo=depExpedicion.pai_codigo)  "+
	"inner join uaa_personal up with(nolock) on(p.per_codigo=up.per_codigo and pen.uap_codigo=up.uap_codigo)  "+
	"inner join uaa_cargo uac with(nolock) on(uac.uac_codigo=up.uac_codigo)  ";

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		Statement sentencia=null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		 LinkedList<Pensionado> lista = new LinkedList<Pensionado>();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
//			 Persona persona= (Persona) param[0];
			 Usuario admin= (Usuario) param[1];

			conn = consegura.getconn_admin(admin);
			imp.info("getAll "+sqlSelect);
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sqlSelect);
			while(resul.next()){
				Pensionado elemento= new Pensionado();
				elemento.getUaa_personal().getPersona().setCodigo(resul.getInt("per_codigo"));
				elemento.getUaa_personal().getPersona().setIdentificacion(resul.getString("per_identificacion"));
				elemento.getUaa_personal().getPersona().getTipoId().setCodigo(resul.getInt("tii_codigo"));
				elemento.getUaa_personal().getPersona().getTipoId().setNombre(resul.getString("tii_nombre"));
				elemento.getUaa_personal().getPersona().getTipoId().setNombreCorto(resul.getString("tii_nombre_corto"));
				elemento.getUaa_personal().getPersona().setLibretaMilitar(resul.getString("per_libreta_militar"));
				elemento.getUaa_personal().getPersona().setApellido(resul.getString("per_apellido1")+" "+resul.getString("per_apellido2"));
				elemento.getUaa_personal().getPersona().setNombre(resul.getString("per_nombre1")+" "+resul.getString("per_nombre2"));
				elemento.getUaa_personal().getPersona().getGenero().setNombre(resul.getString("per_genero"));
				elemento.getUaa_personal().getPersona().getLugarNacimiento().setCodigo(resul.getInt("nMun_codigo"));
				elemento.getUaa_personal().getPersona().getLugarNacimiento().setNombre(resul.getString("nMun_nombre"));
				elemento.getUaa_personal().getPersona().getLugarNacimiento().getDepartamento().setCodigo(resul.getInt("nDpt_codigo"));
				elemento.getUaa_personal().getPersona().getLugarNacimiento().getDepartamento().setNombre(resul.getString("nDpt_nombre"));
				elemento.getUaa_personal().getPersona().getLugarNacimiento().getDepartamento().getPais().setCodigo(resul.getInt("nPais_codigo"));
				elemento.getUaa_personal().getPersona().getLugarNacimiento().getDepartamento().getPais().setNombre(resul.getString("nPais_nombre"));
				elemento.getUaa_personal().getPersona().setFechaNacimiento(resul.getDate("fchnac"));
				elemento.getUaa_personal().setCodigo(resul.getInt("uap_codigo"));
				elemento.getUaa_personal().setFechaInicio(resul.getDate("uap_fecha_inicio"));
				elemento.getUaa_personal().setFechaFin(resul.getDate("uap_fecha_fin"));
				elemento.getUaa_personal().getPersona().getLugarExpedicion().setCodigo(resul.getInt("eMun_codigo"));
				elemento.getUaa_personal().getPersona().getLugarExpedicion().setNombre(resul.getString("eMun_nombre"));
				elemento.getUaa_personal().getPersona().getLugarExpedicion().getDepartamento().setCodigo(resul.getInt("eDpt_codigo"));
				elemento.getUaa_personal().getPersona().getLugarExpedicion().getDepartamento().setNombre(resul.getString("eDpt_nombre"));
				elemento.getUaa_personal().getPersona().getLugarExpedicion().getDepartamento().getPais().setCodigo(resul.getInt("ePais_codigo"));
				elemento.getUaa_personal().getPersona().getLugarExpedicion().getDepartamento().getPais().setNombre(resul.getString("ePais_nombre"));
				elemento.getUaa_personal().getPersona().setEmail(resul.getString("per_email"));
				elemento.getUaa_personal().getPersona().setDireccionResidencia(resul.getString("per_direccion_residencia"));
				elemento.getUaa_personal().getPersona().setBarrio(resul.getString("per_barrio"));
				elemento.getUaa_personal().getPersona().setTelefonoFijo(resul.getString("per_telefono_fijo"));
				elemento.getUaa_personal().getPersona().setTelefonoMovil(resul.getString("per_telefono_movil"));
				elemento.getUaa_personal().getPersona().getGrupoSanguineo().setCodigo(resul.getInt("grs_codigo"));
				elemento.getUaa_personal().getPersona().getGrupoSanguineo().setNombre(resul.getString("grs_nombre"));
				elemento.getUaa_personal().getPersona().getGrupoSanguineo().setSippaGrsCodigo(resul.getInt("sippa_grs_codigo"));
				elemento.setPen_codigo(resul.getInt("pen_codigo"));
				elemento.setPen_fecha(resul.getDate("pen_fecha"));
				elemento.setPen_observacion(resul.getString("pen_observacion"));
				elemento.setPen_tiempo_trabajo(resul.getString("pen_tiempo_trabajo"));
				elemento.getTipoPension().setTip_pen_codigo(resul.getInt("tip_pen_codigo"));
				elemento.getTipoPension().setTip_pen_nombre(resul.getString("tip_pen_nombre"));
				elemento.setPen_resolucion( resul.getString("pen_resolucion"));
				elemento.getUaa_personal().getCargo().setNombre(resul.getString("car_nombre"));
				elemento.getUaa_personal().getVinculacion().setNombre(resul.getString("vin_nombre"));
				elemento.getUaa_personal().getUaa().setNombre(resul.getString("uaa_nombre"));
				
				
				lista.add(elemento);
			}
			consegura.cerrarconn(conn, resul, sentencia);
		 }catch (Exception e) {
			 imp.error(""+e.toString()+" "+sqlSelect );
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
		 Pensionado elemento = new Pensionado();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 Pensionado pensionado= (Pensionado) param[0];
			 Usuario admin= (Usuario) param[1];
			
			String sql=" where (up.uap_estado=0 or up.uap_estado=1 ) ";
			if(pensionado.getUaa_personal().getPersona().getCodigo()>0){
				sql= sql+" and  p.per_codigo = "+pensionado.getUaa_personal().getPersona().getCodigo()+" ";
			}
			if(pensionado.getUaa_personal().getCodigo()>0){
				sql= sql+" and  up.uap_codigo = "+pensionado.getUaa_personal().getCodigo()+" ";
			}
			if(pensionado.getPen_codigo()>0){
				sql= sql+" and  pen.pen_codigo = "+pensionado.getPen_codigo()+" ";
			}

			conn = consegura.getconn_admin(admin);
			imp.info("getObject "+sqlSelect+sql);
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sqlSelect+sql);
			while(resul.next()){
				elemento= new Pensionado();
				elemento.getUaa_personal().getPersona().setCodigo(resul.getInt("per_codigo"));
				elemento.getUaa_personal().getPersona().setIdentificacion(resul.getString("per_identificacion"));
				elemento.getUaa_personal().getPersona().getTipoId().setCodigo(resul.getInt("tii_codigo"));
				elemento.getUaa_personal().getPersona().getTipoId().setNombre(resul.getString("tii_nombre"));
				elemento.getUaa_personal().getPersona().getTipoId().setNombreCorto(resul.getString("tii_nombre_corto"));
				elemento.getUaa_personal().getPersona().setLibretaMilitar(resul.getString("per_libreta_militar"));
				elemento.getUaa_personal().getPersona().setApellido(resul.getString("per_apellido1")+" "+resul.getString("per_apellido2"));
				elemento.getUaa_personal().getPersona().setNombre(resul.getString("per_nombre1")+" "+resul.getString("per_nombre2"));
				elemento.getUaa_personal().getPersona().getGenero().setNombre(resul.getString("per_genero"));
				elemento.getUaa_personal().getPersona().getLugarNacimiento().setCodigo(resul.getInt("nMun_codigo"));
				elemento.getUaa_personal().getPersona().getLugarNacimiento().setNombre(resul.getString("nMun_nombre"));
				elemento.getUaa_personal().getPersona().getLugarNacimiento().getDepartamento().setCodigo(resul.getInt("nDpt_codigo"));
				elemento.getUaa_personal().getPersona().getLugarNacimiento().getDepartamento().setNombre(resul.getString("nDpt_nombre"));
				elemento.getUaa_personal().getPersona().getLugarNacimiento().getDepartamento().getPais().setCodigo(resul.getInt("nPais_codigo"));
				elemento.getUaa_personal().getPersona().getLugarNacimiento().getDepartamento().getPais().setNombre(resul.getString("nPais_nombre"));
				elemento.getUaa_personal().getPersona().setFechaNacimiento(resul.getDate("fchnac"));
				elemento.getUaa_personal().setCodigo(resul.getInt("uap_codigo"));
				elemento.getUaa_personal().setFechaInicio(resul.getDate("uap_fecha_inicio"));
				elemento.getUaa_personal().setFechaFin(resul.getDate("uap_fecha_fin"));
				elemento.getUaa_personal().getPersona().getLugarExpedicion().setCodigo(resul.getInt("eMun_codigo"));
				elemento.getUaa_personal().getPersona().getLugarExpedicion().setNombre(resul.getString("eMun_nombre"));
				elemento.getUaa_personal().getPersona().getLugarExpedicion().getDepartamento().setCodigo(resul.getInt("eDpt_codigo"));
				elemento.getUaa_personal().getPersona().getLugarExpedicion().getDepartamento().setNombre(resul.getString("eDpt_nombre"));
				elemento.getUaa_personal().getPersona().getLugarExpedicion().getDepartamento().getPais().setCodigo(resul.getInt("ePais_codigo"));
				elemento.getUaa_personal().getPersona().getLugarExpedicion().getDepartamento().getPais().setNombre(resul.getString("ePais_nombre"));
				elemento.getUaa_personal().getPersona().setEmail(resul.getString("per_email"));
				elemento.getUaa_personal().getPersona().setDireccionResidencia(resul.getString("per_direccion_residencia"));
				elemento.getUaa_personal().getPersona().setBarrio(resul.getString("per_barrio"));
				elemento.getUaa_personal().getPersona().setTelefonoFijo(resul.getString("per_telefono_fijo"));
				elemento.getUaa_personal().getPersona().setTelefonoMovil(resul.getString("per_telefono_movil"));
				elemento.getUaa_personal().getPersona().getGrupoSanguineo().setCodigo(resul.getInt("grs_codigo"));
				elemento.getUaa_personal().getPersona().getGrupoSanguineo().setNombre(resul.getString("grs_nombre"));
				elemento.getUaa_personal().getPersona().getGrupoSanguineo().setSippaGrsCodigo(resul.getInt("sippa_grs_codigo"));
				elemento.setPen_codigo(resul.getInt("pen_codigo"));
				elemento.setPen_fecha(resul.getDate("pen_fecha"));
				elemento.setPen_observacion(resul.getString("pen_observacion"));
				elemento.setPen_tiempo_trabajo(resul.getString("pen_tiempo_trabajo"));
				elemento.getTipoPension().setTip_pen_codigo(resul.getInt("tip_pen_codigo"));
				elemento.getTipoPension().setTip_pen_nombre(resul.getString("tip_pen_nombre"));
				elemento.setPen_resolucion( resul.getString("pen_resolucion"));
				elemento.getUaa_personal().getCargo().setNombre(resul.getString("car_nombre"));
				elemento.getUaa_personal().getVinculacion().setNombre(resul.getString("vin_nombre"));
				elemento.getUaa_personal().getUaa().setNombre(resul.getString("uaa_nombre"));
			}
			consegura.cerrarconn(conn, resul, sentencia);
		 }catch (Exception e) {
			 imp.error(""+e.toString()+" "+sqlSelect );
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
		int opt= (int) param[2];

		if(opt==0){
			return insertObject(param);
		}
		if(opt==1){
			return updateObject(param);
		}
		return null;
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	private Object updateObject(Object object) {
		Connection conn = null;
		Statement sentencia=null;
		PreparedStatement preparedStatement = null;
		int resul=0;
		imp =Logger.getLogger(getClass().getName());
			Conexion consegura = new Conexion();
			StringBuffer sql = new StringBuffer();
		 try {
			 Object param[]=(Object[]) object;
			 Pensionado pensionado= (Pensionado)param[0];
			 Usuario admin= (Usuario) param[1];
			sql.append("UPDATE pensionado  ");
			sql.append("SET per_codigo = ? ");
			sql.append(",uap_codigo =  ? ");
			sql.append(",pen_fecha =  ? ");
			sql.append(",pen_tiempo_trabajo = ? ");
			sql.append(",tip_pen_codigo = ? ");
			sql.append(",pen_resolucion = ? ");
			sql.append(",pen_observacion = ? ");
			sql.append("WHERE pen_codigo= ?");
			conn = consegura.getconn_admin(admin);
			preparedStatement = conn.prepareStatement(sql.toString());		
			preparedStatement.setInt(1, pensionado.getUaa_personal().getPersona().getCodigo());
			preparedStatement.setInt(2, pensionado.getUaa_personal().getCodigo());
			preparedStatement.setDate(3,  new java.sql.Date(pensionado.getPen_fecha().getTime()));
			preparedStatement.setString(4, pensionado.getPen_tiempo_trabajo());
			preparedStatement.setInt(5, pensionado.getTipoPension().getTip_pen_codigo());
			preparedStatement.setString(6, pensionado.getPen_resolucion());
			preparedStatement.setString(7, pensionado.getPen_observacion());	
			preparedStatement.setInt(8, pensionado.getPen_codigo());
			resul = preparedStatement.executeUpdate();
			imp.info("actualiza el usuario "+sql.toString());
			consegura.cerrarconn(conn, null, sentencia, preparedStatement); 
		 }catch (Exception e) {
			 imp.error(""+e.toString() +""+sql.toString());
			 consegura.cerrarconn(conn, null, sentencia, preparedStatement); 

	        }
		return resul;
		
	}
/**
 * 
 * @param object
 * @return
 */
	private Object insertObject(Object object){
		Connection conn = null;
		Statement sentencia=null;
		PreparedStatement preparedStatement = null;
		int resul=0;
		imp =Logger.getLogger(getClass().getName());
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) object;
			 Pensionado pensionado= (Pensionado)param[0];
			 Usuario admin= (Usuario) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO [pensionado](per_codigo,uap_codigo,pen_fecha,pen_tiempo_trabajo,tip_pen_codigo,pen_resolucion,pen_observacion)  ");
			sql.append("values(?,?,?,?,?,?,?) ");
			conn=consegura.getconn_admin(admin);
			preparedStatement = conn.prepareStatement(sql.toString());	
			preparedStatement.setInt(1, pensionado.getUaa_personal().getPersona().getCodigo());
			preparedStatement.setInt(2, pensionado.getUaa_personal().getCodigo());
			preparedStatement.setDate(3,  new java.sql.Date(pensionado.getPen_fecha().getTime()));
			preparedStatement.setString(4, pensionado.getPen_tiempo_trabajo());
			preparedStatement.setInt(5, pensionado.getTipoPension().getTip_pen_codigo());
			preparedStatement.setString(6, pensionado.getPen_resolucion());
			preparedStatement.setString(7, pensionado.getPen_observacion());	
			 resul = preparedStatement.executeUpdate();
			imp.info("inserta el usuario "+sql.toString());
			consegura.cerrarconn(conn, null, sentencia, preparedStatement); 
		 }catch (Exception e) {
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, null, sentencia);

	        }
		return resul;
	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#esObject(java.lang.Object)
	 */
	@Override
	public boolean esObject(Object object) {
		Connection conn = null;
		Statement sentencia=null;
		ResultSet resul=null;
		boolean resultado=true;
		imp =Logger.getLogger(getClass().getName());
			Conexion consegura = new Conexion();
			StringBuffer sql = new StringBuffer();
		 try {
			 Object param[]=(Object[]) object;
			 Pensionado pensionado= (Pensionado)param[0];
			 Usuario admin= (Usuario) param[1];
			
			sql.append("SELECT COUNT(*) FROM pensionado  ");
			sql.append("WHERE per_codigo= "+pensionado.getUaa_personal().getPersona().getCodigo()+" ");
			sql.append("  ");
			sql.append("  ");
			conn = consegura.getconn_admin(admin);
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				if(resul.getInt(1)>0){
					resultado = false;
				}
			}
			consegura.cerrarconn(conn, resul, sentencia);
		 }catch (Exception e) {
			 imp.error(""+e.toString() +"   "+sql.toString());
			 consegura.cerrarconn(conn, resul, sentencia);

	        }
		 imp.info("valida el usuario "+resultado);
		return resultado;
	}

}
