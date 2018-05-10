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
import co.edu.usco.modulo.personal.mvc.modelo.Cargo;
import co.edu.usco.modulo.personal.mvc.modelo.Dedicacion;
import co.edu.usco.modulo.personal.mvc.modelo.UaaCargo;
import co.edu.usco.modulo.personal.mvc.modelo.UaaPersonal;
import co.edu.usco.modulo.personal.mvc.modelo.Vinculacion;
import co.edu.usco.modulo.personal.mvc.modelo.sedeOb;
import co.edu.usco.modulo.personal.mvc.modelo.Uaa;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class UaaPersonalDB implements conexion {
	private Logger imp;
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getObject(Object obj) {
		Connection conn = null;
		Statement sentencia = null;
		ResultSet resul = null;
		imp = Logger.getLogger(getClass().getName());
		UaaPersonal uaaPersonal2= null;
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();

		imp.info("valida el usuario--> " );
		try {
			Object param[] = (Object[]) obj;
			 UaaPersonal uaaPersonal= (UaaPersonal) param[0];
			 Usuario admin= (Usuario) param[1];
		
			sql = new StringBuffer();
			imp.info("valida el uaaPersonal" + uaaPersonal);
			imp.info("valida el admin" + admin);
			imp.info("valida el usuario antes" + sql.toString());
			sql.append("select  up.uap_codigo, p.per_codigo,p.per_nombre,p.per_apellido, p.per_fecha_nacimiento ,p.per_identificacion, ");
			sql.append("mun_exp.mun_codigo AS mexp_codigo ,mun_exp.mun_nombre AS mexp_nombre ,dep_exp.dep_codigo AS dexp_codigo ,dep_exp.dep_nombre AS dexp_nombre, pai_exp.pai_codigo AS pexp_codigo, pai_exp.pai_nombre AS pexp_nombre");
			sql.append(", mun_nac.mun_codigo AS mnac_codigo, mun_nac.mun_nombre AS mnac_nombre, dep_nac.dep_codigo AS dnac_codigo, dep_nac.dep_nombre AS dnac_nombre, pai_nac.pai_codigo As pnac_codigo, pai_nac.pai_nombre AS pnac_nombre, ");
			sql.append("per_genero, u.uaa_codigo, u.uaa_nombre, ");
			sql.append("u.uaa_nombre_corto, up.uap_fecha_inicio, ");
			sql.append(" up.uap_fecha_fin, ");
			sql.append("(select  top 1 case when uap.uap_cargo<> 0 then c.car_nombre else car.car_nombre end    ");
			sql.append("from uaa_personal uap ");
			sql.append("left join cargo c on car_codigo=uap.uap_cargo ");
			sql.append("left join uaa_cargo uac on uac.uac_codigo=uap.uac_codigo ");
			sql.append("left join cargo car on car.car_codigo=uac.uac_cargo ");
			sql.append("where uap.uap_codigo=up.uap_codigo) as cargo ");
			sql.append("from persona p with(nolock) ");
			sql.append("left join uaa_personal up with(nolock) on(up.per_codigo=p.per_codigo) ");
			sql.append("left join uaa as u with(nolock) on(up.uaa_codigo=u.uaa_codigo)  ");
			sql.append("left join municipio mun_nac with(nolock) on (mun_nac.mun_codigo=p.per_lugar_nacimiento) ");
			sql.append("left join departamento dep_nac with(nolock) on (dep_nac.dep_codigo=mun_nac.dep_codigo) ");
			sql.append("left join pais pai_nac with(nolock) on(pai_nac.pai_codigo=dep_nac.pai_codigo) ");
			sql.append("left join municipio mun_exp with(nolock) on (mun_exp.mun_codigo=p.per_lugar_nacimiento) ");
			sql.append("left join departamento dep_exp with(nolock) on (dep_exp.dep_codigo=mun_exp.dep_codigo) ");
			sql.append("left join pais pai_exp with(nolock) on(pai_exp.pai_codigo=dep_exp.pai_codigo) ");
			sql.append("where ");
			if (uaaPersonal.getPersona().getPer_codigo() > 0) {
				sql.append(" p.per_codigo  =" + uaaPersonal.getPersona().getPer_codigo()+ " ");
			} else {
				sql.append("(p.per_apellido +' '+per_nombre like '0000000') ");
			}
			if (uaaPersonal.getUap_codigo() > 0) {
				sql.append("and up.uap_codigo  =" + uaaPersonal.getUap_codigo()+ " ");
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
			imp.info("valida el usuario " + sql.toString());
			while (resul.next()) {
				uaaPersonal2= new UaaPersonal();
				uaaPersonal2.setUap_codigo(resul.getInt("uap_codigo"));
				uaaPersonal2.getPersona().setPer_codigo(resul.getInt("per_codigo"));
				uaaPersonal2.getPersona().setPer_nombre(resul.getString("per_nombre"));
				uaaPersonal2.getPersona().setPer_apellido(resul.getString("per_apellido"));
				uaaPersonal2.getPersona().setPer_fecha_nacimiento(resul.getDate("per_fecha_nacimiento"));
				uaaPersonal2.getPersona().setPer_identificacion(resul.getString("per_identificacion"));
				uaaPersonal2.getPersona().getPer_lugar_expedicion().setMun_codigo(resul.getInt("mexp_codigo"));
				uaaPersonal2.getPersona().getPer_lugar_expedicion().setMun_nombre(resul.getString("mexp_nombre"));
				uaaPersonal2.getPersona().getPer_lugar_expedicion().getDepartamento().setDep_codigo(resul.getInt("dexp_codigo"));
				uaaPersonal2.getPersona().getPer_lugar_expedicion().getDepartamento().setDep_nombre(resul.getString("dexp_nombre"));
				uaaPersonal2.getPersona().getPer_lugar_expedicion().getDepartamento().getPais().setPai_codigo(resul.getInt("pexp_codigo"));
				uaaPersonal2.getPersona().getPer_lugar_expedicion().getDepartamento().getPais().setPai_nombre(resul.getString("pexp_nombre"));
				uaaPersonal2.getPersona().getPer_lugar_nacimiento().setMun_codigo(resul.getInt("mnac_codigo"));
				uaaPersonal2.getPersona().getPer_lugar_nacimiento().setMun_nombre(resul.getString("mnac_nombre"));
				uaaPersonal2.getPersona().getPer_lugar_nacimiento().getDepartamento().setDep_codigo(resul.getInt("dnac_codigo"));
				uaaPersonal2.getPersona().getPer_lugar_nacimiento().getDepartamento().setDep_nombre(resul.getString("dnac_nombre"));
				uaaPersonal2.getPersona().getPer_lugar_nacimiento().getDepartamento().getPais().setPai_codigo(resul.getInt("pnac_codigo"));
				uaaPersonal2.getPersona().getPer_lugar_nacimiento().getDepartamento().getPais().setPai_nombre(resul.getString("pnac_nombre"));
				uaaPersonal2.getUaa().setUaa_codigo(resul.getInt("uaa_codigo"));
				uaaPersonal2.getUaa().setUaa_nombre(resul.getString("uaa_nombre"));
				uaaPersonal2.getUaa().setUaa_nombre_corto(resul.getString("uaa_nombre_corto"));
				uaaPersonal2.setUap_fecha_inicio(resul.getDate("uap_fecha_inicio"));
				uaaPersonal2.getCargo().setCar_nombre(resul.getString("cargo"));
				

			}
			consegura.cerrarconn(conn, resul, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, resul, sentencia);

		}
		return uaaPersonal2;
	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getObject(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {

		Connection conn = null;
		Statement sentencia = null;
		ResultSet resul = null;
		imp = Logger.getLogger(getClass().getName());
		LinkedList<UaaPersonal> lista = new LinkedList<UaaPersonal>();
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();

		imp.info("valida el usuario--> " );
		try {
			Object param[] = (Object[]) obj;
			 UaaPersonal uaaPersonal= (UaaPersonal) param[0];
			 Usuario admin= (Usuario) param[1];
		
			sql = new StringBuffer();
	
			sql.append("select  up.uap_codigo, p.per_codigo,p.per_nombre,p.per_apellido, p.per_fecha_nacimiento ,p.per_identificacion, ");
			sql.append("mun_exp.mun_codigo AS mexp_codigo ,mun_exp.mun_nombre AS mexp_nombre ,dep_exp.dep_codigo AS dexp_codigo ,dep_exp.dep_nombre AS dexp_nombre, pai_exp.pai_codigo AS pexp_codigo, pai_exp.pai_nombre AS pexp_nombre");
			sql.append(", mun_nac.mun_codigo AS mnac_codigo, mun_nac.mun_nombre AS mnac_nombre, dep_nac.dep_codigo AS dnac_codigo, dep_nac.dep_nombre AS dnac_nombre, pai_nac.pai_codigo As pnac_codigo, pai_nac.pai_nombre AS pnac_nombre, ");
			sql.append("per_genero, u.uaa_codigo, u.uaa_nombre, ");
			sql.append("u.uaa_nombre_corto, up.uap_fecha_inicio, ");
			sql.append(" up.uap_fecha_fin, ");
			sql.append("(select  top 1 case when uap.uap_cargo<> 0 then c.car_nombre else car.car_nombre end    ");
			sql.append("from uaa_personal uap ");
			sql.append("left join cargo c on car_codigo=uap.uap_cargo ");
			sql.append("left join uaa_cargo uac on uac.uac_codigo=uap.uac_codigo ");
			sql.append("left join cargo car on car.car_codigo=uac.uac_cargo ");
			sql.append("where uap.uap_codigo=up.uap_codigo) as cargo ");
			sql.append("from persona p with(nolock) ");
			sql.append("left join uaa_personal up with(nolock) on(up.per_codigo=p.per_codigo) ");
			sql.append("left join uaa as u with(nolock) on(up.uaa_codigo=u.uaa_codigo)  ");
			sql.append("left join municipio mun_nac with(nolock) on (mun_nac.mun_codigo=p.per_lugar_nacimiento) ");
			sql.append("left join departamento dep_nac with(nolock) on (dep_nac.dep_codigo=mun_nac.dep_codigo) ");
			sql.append("left join pais pai_nac with(nolock) on(pai_nac.pai_codigo=dep_nac.pai_codigo) ");
			sql.append("left join municipio mun_exp with(nolock) on (mun_exp.mun_codigo=p.per_lugar_nacimiento) ");
			sql.append("left join departamento dep_exp with(nolock) on (dep_exp.dep_codigo=mun_exp.dep_codigo) ");
			sql.append("left join pais pai_exp with(nolock) on(pai_exp.pai_codigo=dep_exp.pai_codigo) ");
			sql.append("where  (up.uap_plantaencargo='p' or up.vin_codigo=12)");
//			sql.append("where  ");
			if (uaaPersonal.getPersona().getPer_nombre() != null && uaaPersonal.getPersona().getPer_nombre().length() > 0) {
				sql.append(" and (p.per_apellido +' '+p.per_nombre like '%" + uaaPersonal.getPersona().getPer_nombre()
						+ "%' or p.per_nombre+' '+p.per_apellido like '%" + uaaPersonal.getPersona().getPer_nombre()
						+ "%' or p.per_identificacion like'" + uaaPersonal.getPersona().getPer_nombre()
						+ "')");
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
			imp.info("valida el usuario " + sql.toString());
			while (resul.next()) {
				UaaPersonal uaaPersonal2= new UaaPersonal();
				uaaPersonal2.setUap_codigo(resul.getInt("uap_codigo"));
				uaaPersonal2.getPersona().setPer_codigo(resul.getInt("per_codigo"));
				uaaPersonal2.getPersona().setPer_nombre(resul.getString("per_nombre"));
				uaaPersonal2.getPersona().setPer_apellido(resul.getString("per_apellido"));
				uaaPersonal2.getPersona().setPer_fecha_nacimiento(resul.getDate("per_fecha_nacimiento"));
				uaaPersonal2.getPersona().setPer_identificacion(resul.getString("per_identificacion"));
				uaaPersonal2.getPersona().getPer_lugar_expedicion().setMun_codigo(resul.getInt("mexp_codigo"));
				uaaPersonal2.getPersona().getPer_lugar_expedicion().setMun_nombre(resul.getString("mexp_nombre"));
				uaaPersonal2.getPersona().getPer_lugar_expedicion().getDepartamento().setDep_codigo(resul.getInt("dexp_codigo"));
				uaaPersonal2.getPersona().getPer_lugar_expedicion().getDepartamento().setDep_nombre(resul.getString("dexp_nombre"));
				uaaPersonal2.getPersona().getPer_lugar_expedicion().getDepartamento().getPais().setPai_codigo(resul.getInt("pexp_codigo"));
				uaaPersonal2.getPersona().getPer_lugar_expedicion().getDepartamento().getPais().setPai_nombre(resul.getString("pexp_nombre"));
				uaaPersonal2.getPersona().getPer_lugar_nacimiento().setMun_codigo(resul.getInt("mnac_codigo"));
				uaaPersonal2.getPersona().getPer_lugar_nacimiento().setMun_nombre(resul.getString("mnac_nombre"));
				uaaPersonal2.getPersona().getPer_lugar_nacimiento().getDepartamento().setDep_codigo(resul.getInt("dnac_codigo"));
				uaaPersonal2.getPersona().getPer_lugar_nacimiento().getDepartamento().setDep_nombre(resul.getString("dnac_nombre"));
				uaaPersonal2.getPersona().getPer_lugar_nacimiento().getDepartamento().getPais().setPai_codigo(resul.getInt("pnac_codigo"));
				uaaPersonal2.getPersona().getPer_lugar_nacimiento().getDepartamento().getPais().setPai_nombre(resul.getString("pnac_nombre"));
				uaaPersonal2.getUaa().setUaa_codigo(resul.getInt("uaa_codigo"));
				uaaPersonal2.getUaa().setUaa_nombre(resul.getString("uaa_nombre"));
				uaaPersonal2.getUaa().setUaa_nombre_corto(resul.getString("uaa_nombre_corto"));
				uaaPersonal2.setUap_fecha_inicio(resul.getDate("uap_fecha_inicio"));
				
				lista.add(uaaPersonal2);
			}
			consegura.cerrarconn(conn, resul, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, resul, sentencia);

		}
		return lista;
	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#setObject(java.lang.Object)
	 */
	@Override
	public Object setObject(Object obj) {
		// TODO Auto-generated method stub
		return null;
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
