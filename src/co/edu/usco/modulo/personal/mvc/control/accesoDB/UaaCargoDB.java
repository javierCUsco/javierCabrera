/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.UaaCargoRowMapper;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.UaaRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Cargo;
import co.edu.usco.modulo.personal.mvc.modelo.Dedicacion;
import co.edu.usco.modulo.personal.mvc.modelo.Municipio;
import co.edu.usco.modulo.personal.mvc.modelo.UaaCargo;
import co.edu.usco.modulo.personal.mvc.modelo.UaaPersonal;
import co.edu.usco.modulo.personal.mvc.modelo.Vinculacion;
import co.edu.usco.modulo.personal.mvc.modelo.Sede;
import co.edu.usco.modulo.personal.mvc.modelo.Uaa;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class UaaCargoDB implements ConexionDB {
	private Logger imp ;
	private String SQL_SELECT="	SELECT uac_codigo,uac_uaa,u.uaa_nombre,u.uaa_nombre_corto,s.sed_codigo,s.sed_nombre,s.mun_codigo,uac_cargo,c.car_nombre,c.car_id,c.car_tmp, \r\n" + 
			"uac_vinculacion,vin_nombre,vin_horas_year,vin_clase,sippa_vincodigo,vin_contratacion,  \r\n" + 
			"uac_dedicacion,ded_nombre,ded_orden_snies,sippa_dedcodigo,ded_codigo_hecaa, \r\n" + 
			"uac_codigoplanta,uac_grado,car_codigo,car_nombre,car_id,car_tmp \r\n" + 
			"FROM  uaa_cargo uc with(nolock)  \r\n" + 
			"inner join vinculacion v with(nolock) on (v.vin_codigo=uc.uac_vinculacion)  \r\n" + 
			"inner join dedicacion d with(nolock) on(d.ded_codigo= uc.uac_dedicacion) \r\n" + 
			"inner join uaa u with(nolock) on (u.uaa_codigo=uc.uac_uaa)  \r\n" + 
			"left join sede s with(nolock) on (s.sed_codigo=u.sed_codigo)  \r\n" + 
			"inner join cargo c with(nolock) on (c.car_codigo= uc.uac_cargo)  ";

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
		PreparedStatement sentencia=null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		 LinkedList<Uaa> lista = new LinkedList<Uaa>();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 UaaCargo uaaCargo= (UaaCargo) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append(SQL_SELECT);
			sql.append("WHERE u.uaa_estado=?  ");
			sql.append("AND u.uaa_nombre like ?  ");
			
			System.out.println(""+sql.toString()+" "+uaaCargo);

			conn = consegura.conexionConsulta();
			sentencia = conn.prepareStatement(sql.toString());
			conn.setAutoCommit(false);
			sentencia.setInt(1, 1);
			sentencia.setString(2, "%" +uaaCargo.getUaa().getNombre()+ "%");
			
			conn.commit();

			lista  =(LinkedList<Uaa>) UaaCargoRowMapper.mapRow(sentencia.executeQuery());

			consegura.cerrarconn(conn, resul, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
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
			if(uaa_cargo.getCodigo()>0){
				 sql.append("where  ");
				 sql.append("uC.uac_codigo ='"+uaa_cargo.getCodigo()+"'");
				}
			// sql.append("where cert_estado=1 ");

			conn = consegura.conexionConsulta();
			imp.info("valida el usuario " + sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while (resul.next()) {
				elemento= new UaaCargo(resul.getInt(1),
						new Uaa(resul.getInt(2), resul.getString(3), resul.getString(4),
								new Sede(resul.getInt(5), resul.getString(6), new Municipio(resul.getInt(7),""), 0, true)),
						new Cargo(resul.getInt(8), resul.getString(9), resul.getString(10), resul.getInt(11)),
						new Vinculacion(resul.getInt(12), resul.getString(13), resul.getInt(14), resul.getInt(15),resul.getString(16), 0,resul.getString(17)),
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
