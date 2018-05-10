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
public class Uaa_cargoDB implements conexion {
	private Logger imp;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.
	 * lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {

		Connection conn = null;
		Statement sentencia = null;
		ResultSet resul = null;
		imp = Logger.getLogger(getClass().getName());
		LinkedList<UaaCargo> lista = new LinkedList<UaaCargo>();
		Conexion consegura = new Conexion();
		try {
			Object param[] = (Object[]) obj;
			 UaaCargo uaa_cargo= (UaaCargo) param[0];
			 Usuario admin= (Usuario) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT uac_codigo,uac_uaa,u.uaa_nombre,u.uaa_nombre_corto,s.sed_codigo,s.sed_nombre,s.mun_codigo,uac_cargo,c.car_nombre,c.car_id,c.car_tmp, ");
			sql.append("uac_vinculacion,vin_nombre,vin_horas_year,vin_clase,sippa_vincodigo,vin_contratacion,  ");
			sql.append("uac_dedicacion,ded_nombre,ded_orden_snies,sippa_dedcodigo,ded_codigo_hecaa, ");
			sql.append("uac_codigoplanta,uac_grado,car_codigo,car_nombre,car_id,car_tmp ");
			sql.append("FROM  uaa_cargo uc with(nolock)  ");
			sql.append("inner join vinculacion v with(nolock) on (v.vin_codigo=uc.uac_vinculacion)  ");
			sql.append("inner join dedicacion d with(nolock) on(d.ded_codigo= uc.uac_dedicacion) ");
			sql.append("inner join uaa u with(nolock) on (u.uaa_codigo=uc.uac_uaa)  ");
			sql.append("left join sede s with(nolock) on (s.sed_codigo=u.sed_codigo)  ");
			sql.append("inner join cargo c with(nolock) on (c.car_codigo= uc.uac_cargo)  ");
			sql.append("  ");
	
			if(uaa_cargo.getUaa().getUaa_nombre()!=null && uaa_cargo.getUaa().getUaa_nombre().length()>0){
			 sql.append("where  ");
			 sql.append("u.uaa_nombre like'%"+uaa_cargo.getUaa().getUaa_nombre()+"%'");
			}
			conn = consegura.conexion_segura();
			imp.info("valida el usuario " + sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while (resul.next()) {
				lista.add(new UaaCargo(resul.getInt(1),
						new Uaa(resul.getInt(2), resul.getString(3), resul.getString(4),
								new sedeOb(resul.getInt(5), resul.getString(6), resul.getInt(7), 0, 0)),
						new Cargo(resul.getInt(8), resul.getString(9), resul.getString(10), resul.getInt(11)),
						new Vinculacion(resul.getInt(12), resul.getString(13), resul.getInt(14), resul.getInt(15),resul.getInt(16), resul.getString(17)),
						new Dedicacion(resul.getInt(18), resul.getString(19), resul.getInt(20), resul.getString(21),resul.getString(22)),
						resul.getString(23), resul.getInt(24)));
			}
			consegura.cerrarconn(conn, resul, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, resul, sentencia);

		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getObject(
	 * java.lang.Object)
	 */
	@Override
	public Object getObject(Object obj) {
		Connection conn = null;
		Statement sentencia = null;
		ResultSet resul = null;
		imp = Logger.getLogger(getClass().getName());
		UaaCargo elemento= new UaaCargo();
		Conexion consegura = new Conexion();
		try {
			Object param[] = (Object[]) obj;
			 UaaCargo uaa_cargo= (UaaCargo) param[0];
			 Usuario admin= (Usuario) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT uac_codigo,uac_uaa,u.uaa_nombre,u.uaa_nombre_corto,s.sed_codigo,s.sed_nombre,s.mun_codigo,uac_cargo,c.car_nombre,c.car_id,c.car_tmp, ");
			sql.append("uac_vinculacion,vin_nombre,vin_horas_year,vin_clase,sippa_vincodigo,vin_contratacion,  ");
			sql.append("uac_dedicacion,ded_nombre,ded_orden_snies,sippa_dedcodigo,ded_codigo_hecaa, ");
			sql.append("uac_codigoplanta,uac_grado,car_codigo,car_nombre,car_id,car_tmp ");
			sql.append("FROM  uaa_cargo uc with(nolock)  ");
			sql.append("inner join vinculacion v with(nolock) on (v.vin_codigo=uc.uac_vinculacion)  ");
			sql.append("inner join dedicacion d with(nolock) on(d.ded_codigo= uc.uac_dedicacion) ");
			sql.append("inner join uaa u with(nolock) on (u.uaa_codigo=uc.uac_uaa)  ");
			sql.append("left join sede s with(nolock) on (s.sed_codigo=u.sed_codigo)  ");
			sql.append("inner join cargo c with(nolock) on (c.car_codigo= uc.uac_cargo)  ");
			sql.append("  ");
			if(uaa_cargo.getUac_codigo()>0){
				 sql.append("where  ");
				 sql.append("uC.uac_codigo ='"+uaa_cargo.getUac_codigo()+"'");
				}
			// sql.append("where cert_estado=1 ");

			conn = consegura.getconn_admin(admin);
			imp.info("valida el usuario " + sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while (resul.next()) {
				elemento= new UaaCargo(resul.getInt(1),
						new Uaa(resul.getInt(2), resul.getString(3), resul.getString(4),
								new sedeOb(resul.getInt(5), resul.getString(6), resul.getInt(7), 0, 0)),
						new Cargo(resul.getInt(8), resul.getString(9), resul.getString(10), resul.getInt(11)),
						new Vinculacion(resul.getInt(12), resul.getString(13), resul.getInt(14), resul.getInt(15),resul.getInt(16), resul.getString(17)),
						new Dedicacion(resul.getInt(18), resul.getString(19), resul.getInt(20), resul.getString(21),resul.getString(22)),
						resul.getString(23), resul.getInt(24));
			}
			consegura.cerrarconn(conn, resul, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, resul, sentencia);

		}
		return elemento;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#setObject(
	 * java.lang.Object)
	 */
	@Override
	public Object setObject(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#esObject(
	 * java.lang.Object)
	 */
	@Override
	public boolean esObject(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
