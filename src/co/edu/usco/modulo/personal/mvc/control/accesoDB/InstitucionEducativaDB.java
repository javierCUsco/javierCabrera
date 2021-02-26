/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.InstitucionEducativaRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.InstitucionEducativa;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class InstitucionEducativaDB implements ConexionDB {
	private Logger imp;

	private String SQL_SELECT = "select top 1000 ine.ine_codigo,ine.iet_codigo,inet.iet_nombre ,ine.ine_nombre,ine.mun_codigo,\r\n" + 
			"m.mun_codigo,m.mun_id,m.mun_nombre,m.dep_codigo,m.sippa_mun_codigo,m.SNIES_codigo,COALESCE(m.dane_codigo,'') AS Mdane_codigo,\r\n" + 
			"d.dep_codigo,d.dep_acronimo,d.dep_nombre,d.pai_codigo,COALESCE(d.sippa_dep_codigo,'0') AS sippa_dep_codigo ,COALESCE(d.dane_codigo,'') AS Ddane_codigo,\r\n" + 
			"p.pai_codigo,p.pai_acronimo,p.pai_nombre,p.sippa_pai_codigo,COALESCE(p.dane_codigo,'') AS Pdane_codigo,p.pai_codigo_hecaa,\r\n" + 
			"ine.jor_codigo,j.jor_nombre,COALESCE(j.sippa_jor_codigo,0) AS sippa_jor_codigo,ine.ine_nivel,ine.inc_codigo,COALESCE(ine.sippa_inscodigo,'') AS sippa_inscodigo,ine.ine_fecha1,ine.ine_fecha2,COALESCE(ine.ine_codigo_hecaa,'0') AS ine_codigo_hecaa   \r\n" + 
			"from institucion_educativa ine with(nolock)  \r\n" + 
			"left join institucion_educativa_tipo inet with(nolock)  on(inet.iet_codigo= ine.iet_codigo)  \r\n" + 
			"left join  jornada j with(nolock)  on(j.jor_codigo=ine.jor_codigo) \r\n" + 
			"left join  municipio m with(nolock)  on(m.mun_codigo=ine.mun_codigo)  \r\n" + 
			"left join  departamento d with(nolock)  on (d.dep_codigo=m.dep_codigo)  \r\n" + 
			"left join  pais p with(nolock)  on (p.pai_codigo=d.pai_codigo)  ";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang
	 * .Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		imp = Logger.getLogger(getClass().getName());
		LinkedList<InstitucionEducativa> lista = new LinkedList<InstitucionEducativa>();
		Conexion consegura = new Conexion();
		InstitucionEducativa ine = (InstitucionEducativa) obj;
//		 imp.info("despues "+ine.getNombre());
		try {
			String codigo="";
			StringBuffer sql = new StringBuffer();
			if((ine.getNivel().equals("1"))|| (ine.getNivel().equals("2")) ||(ine.getNivel().equals("4"))
					||(ine.getNivel().equals("8"))||(ine.getNivel().equals("9"))|| (ine.getNivel().equals("10")) ||(ine.getNivel().equals("11"))
					||(ine.getNivel().equals("12"))|| (ine.getNivel().equals("13")) ||(ine.getNivel().equals("14"))
					||(ine.getNivel().equals("15"))|| (ine.getNivel().equals("19")) ||(ine.getNivel().equals("20")) ||(ine.getNivel().equals("22")) ||(ine.getNivel().equals("23"))) {
			
				codigo="6,8,10";
			}
			if((ine.getNivel().equals("3"))|| (ine.getNivel().equals("6")) ||(ine.getNivel().equals("18"))  ||(ine.getNivel().equals("24")) ||(ine.getNivel().equals("25"))) {
				codigo="2,4,5";
			}
			sql.append(SQL_SELECT);
//			sql.append("WHERE  inet.inet_codigo = ? ");
			if (ine.getNombre() != null && ine.getNombre().length() > 0) {
				sql.append("WHERE ( ine.ine_nombre like '%"+ine.getNombre().trim()+"%' ");
				sql.append(" and inet.iet_codigo in("+codigo+")  ) or (ine.ine_nombre like '%otro%')");
			}

			conn = consegura.conexionConsulta();
			imp.info("institucion educativa " + sql.toString());
			sentencia = conn.prepareStatement(sql.toString());
//			sentencia.setInt(1,  ine.getTipoInstitucion().getCodigo());
//			if (ine.getNombre() != null && ine.getNombre().length() > 0) {
//				sentencia.setString(1, "%" + ine.getNombre() + " % ");
//			}
			lista = (LinkedList<InstitucionEducativa>) InstitucionEducativaRowMapper.mapRow(sentencia.executeQuery());

			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, null, sentencia);

		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getObject(java.
	 * lang.Object)
	 */
	@Override
	public Object getObject(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		ResultSet resul = null;
		imp = Logger.getLogger(getClass().getName());
		LinkedList<InstitucionEducativa> lista = new LinkedList<InstitucionEducativa>();
		Conexion consegura = new Conexion();
		// Institucion_educativaOb ine= new Institucion_educativaOb();
		// imp.info("antes ");
		InstitucionEducativa ine = (InstitucionEducativa) obj;
		// imp.info("despues "+ine.getIne_nombre());
		try {
			// Object param[]=(Object[]) obj;
			// publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
			// usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();

			sql.append(SQL_SELECT);
			if (ine.getNombre() != null && ine.getNombre().length() > 0) {
				sql.append("WHERE  ine.ine_nombre like= ?");
			}

			conn = consegura.conexion_segura();
			imp.info("valida el usuario " + sql.toString());
			sentencia = conn.prepareStatement(sql.toString());
			if (ine.getNombre() != null && ine.getNombre().length() > 0) {

				sentencia.setString(1, "%" + ine.getNombre() + "%");
			}
			lista = (LinkedList<InstitucionEducativa>) InstitucionEducativaRowMapper.mapRow(sentencia.executeQuery());

			consegura.cerrarconn(conn, resul, sentencia);
			consegura.cerrarconn(conn, resul, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, resul, sentencia);

		}
		return lista.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#setObject(java.
	 * lang.Object)
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
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#esObject(java.
	 * lang.Object)
	 */
	@Override
	public boolean esObject(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
