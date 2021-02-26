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

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.PeriodoRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Periodo;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.novedadDocente.PersonaNovedad;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PeriodoDB implements ConexionDB {
	private Logger imp ;
	private String SQL_SELECT_PAGINA="select distinct p.per_codigo,p.pet_codigo,p.per_nombre,p.per_año,p.per_periodo,CONVERT(DATE, p.per_fecha_inicio) AS per_fecha_inicio ,CONVERT(DATE,p.per_fecha_fin) AS per_fecha_fin ,p.sippa_per_codigo\r\n" + 
			"from persona_novedad  with(nolock)\r\n" + 
			"inner join periodo  p  with(nolock) on(p.per_codigo= persona_novedad.per_codigo) ";
	private String SQL_SELECT="select per_codigo,pet_codigo,per_nombre,per_año,per_periodo,CONVERT(DATE, per_fecha_inicio) AS per_fecha_inicio ,CONVERT(DATE,per_fecha_fin) AS per_fecha_fin ,sippa_per_codigo  from periodo with(nolock) ";
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia=null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		 LinkedList<Periodo> lista = new LinkedList<Periodo>();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 int opt =Integer.parseInt(String.valueOf(param[2]));
			
			StringBuffer sql = new StringBuffer();
			if(opt==1) {
				sql.append(SQL_SELECT);
				sql.append(" order by per_codigo desc");
			}
			if(opt==2) {
				 PersonaNovedad personaNovedad= (PersonaNovedad) param[0];
				sql.append(SQL_SELECT_PAGINA);
				sql.append("where pen_persona="+personaNovedad.getUaaPersonal().getPersona().getCodigo()+" ");
				sql.append("order by p.per_nombre asc ");
			}
			conn = consegura.conexionConsulta();
			imp.info("getAll priodos  "+sql.toString());
			sentencia = conn.prepareStatement(sql.toString());
//			resul = sentencia.executeQuery(sql.toString());

			lista=(LinkedList<Periodo>) PeriodoRowMapper.mapRow(sentencia.executeQuery());
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
		PreparedStatement sentencia=null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		 LinkedList<Periodo> lista = new LinkedList<Periodo>();
			Conexion consegura = new Conexion();
		 try {
//			 Object param[]=(Object[]) obj;
			 Periodo periodo= (Periodo) obj;
			StringBuffer sql = new StringBuffer();
			imp.info("valida el periodo "+periodo);
			sql.append(SQL_SELECT);
			sql.append("WHERE per_codigo=? ");

			conn = consegura.conexion_segura();
			conn.setAutoCommit(false);
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.prepareStatement(sql.toString());
			sentencia.setInt(1, periodo.getCodigo());
			conn.commit();			
			lista=(LinkedList<Periodo>) PeriodoRowMapper.mapRow(sentencia.executeQuery());
			consegura.cerrarconn(conn, resul, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, resul, sentencia);

	        }
		return lista.get(0);
	}

	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#insertObject(java.lang.Object)
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
