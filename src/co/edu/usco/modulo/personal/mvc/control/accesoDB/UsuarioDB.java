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

import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.herramientas.HexStringConverter;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Transformacion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionUscoDB;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.PublicacionTipo;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.novedadDocente.PersonaNovedad;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class UsuarioDB implements ConexionUscoDB {
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
		LinkedList<PublicacionTipo> lista = new LinkedList<PublicacionTipo>();
		Conexion consegura = new Conexion();
		try {
			Object param[] = (Object[]) obj;
			// publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
			// usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("select pt.put_codigo,pt.put_nombre,pt.sippa_tipcodigo  ");
			sql.append("from publicacion_tipo as pt  with(nolock)  ");
			// sql.append("where cert_estado=1 ");

			conn = consegura.conexionConsulta();
			imp.info("valida el usuario " + sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while (resul.next()) {
				PublicacionTipo elemento = new PublicacionTipo();
				elemento.setPut_codigo(resul.getInt(1));
				elemento.setPut_nombre(resul.getString(2));
				elemento.setSippa_tipcodigo(resul.getString(3));
				lista.add(elemento);
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
		Usuario elemento= null;
		Conexion consegura = new Conexion();
		Transformacion hex = new Transformacion();
		try {
			Object param[] = (Object[]) obj;
			// publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
			 Usuario user= (Usuario) param[0];
			StringBuffer sql = new StringBuffer();
			sql.append("select distinct usg_usuario, gru_nombre,	usg_grupo,	gru_id,	usg_uaa,	usg_estado,	gru_codigo,	usg_codigo,	up,	us,	istipo,	ischange,	uwd	uwd2,	state,	sys,	uid,	us_encriptado	   ");
//			sql.append("from  usuario_talento_humano_login ucl  with(nolock)   ");
			sql.append("from  usuario_hojavida_web_login ucl  with(nolock)   ");
			
//			sql.append("inner join usuario_pensionado_login ucl with(nolock) on (p.per_codigo=ucl.up)  ");
//			sql.append("inner join usuario_carrera_login ucl with(nolock) on (p.per_codigo=ucl.up)  ");
			
//			sql.append("inner join usuario_programacion_login ucl with(nolock) on (p.per_codigo=ucl.up)  ");
			
			if(user.getNombre()!=null && user.getNombre().length()>0){
				sql.append("where ucl.us='"+user.getNombre()+"' ");	
			}
			sql.append(" and  ucl.uwd2=(select HASHBYTES('MD5',HASHBYTES('SHA','"+ hex.transHexa(user.getClave(),2)+"')))");
			// sql.append("where cert_estado=1 ");

			conn = consegura.conexionLogin();
			imp.info("valida el usuario " + sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while (resul.next()) {
				 elemento = new Usuario();
				 elemento.setUid(resul.getInt("uid"));
				elemento.getPersona().setCodigo(resul.getInt("up"));
				//elemento.getPersona().setIdentificacion(resul.getString("per_identificacion"));
				//elemento.getPersona().setApellido(resul.getString("per_apellido"));
				//elemento.getPersona().setNombre(resul.getString("per_nombre"));
				
				
				
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
	 * co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#insertObject
	 * (java.lang.Object)
	 */
	@Override
	public Object setObject(Object obj) {
		imp = Logger.getLogger(getClass().getName());
		Connection conn = null;
		Statement sentencia=null;
		ResultSet resul=null;
		Usuario user= (Usuario) obj;

		 StringBuffer sql = null;
		 Conexion consegura = new Conexion();
		 try {
			sql = new StringBuffer();
			Transformacion hex = new Transformacion();

			sql = new StringBuffer();
			sql.append("SELECT dbo.getClaveReal( ");
			sql.append(" 0x"+ user.getNombreencriptado().trim() + " , ");
			sql.append(" 0x"+ hex.transHexa(user.getClave().trim(), 2).replace(" ", "<br>")+ " , ");
			sql.append(" 0x"+user.getClave2().trim().replace(" ", "<br>")+ ")");

//			imp.info("getClaveRealEvadoc  ( "+sql.toString());
			
			

			 conn = consegura.conexionConsulta();
			 sentencia = conn.createStatement();
			 resul = sentencia.executeQuery(sql.toString());
			 if(resul.next()){
				user.setClavereal(resul.getString(1));
//				System.out.println("si tiene"+user.getClavereal());
			 }
			 consegura.cerrarconn(conn, resul, sentencia);
			
		 }catch (Exception e) {
			 imp.error("getObject(  "+e.toString() );
			 consegura.cerrarconn(conn, resul, sentencia);
		
	
	}
		return user;
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
		imp = Logger.getLogger(getClass().getName());
		Transformacion hex = new Transformacion();
		Connection conn = null;
		Statement sentencia = null;
		ResultSet resul = null;
		boolean elemento = false;
		Object param[] = (Object[]) obj;
		Usuario usuario = (Usuario) param[0];
		 imp.info("esObject(  "+usuario.getNombre()+" ");
		 imp.info("esObject(  "+usuario.getClave() +" "+hex.transHexa(usuario.getClave().trim(), 2));
		 imp.info("esObject(  "+usuario.getClave2() );
		StringBuffer sql = null;
		Conexion consegura = new Conexion();
		try {
			sql = new StringBuffer();
			

//			sql.append("SELECT dbo.validarUsuarioCarrera (0x" + user.getNombreencriptado() + ", 0x"
		//	sql.append("SELECT dbo.validarUsuarioProgramacion (0x" + user.getNombreencriptado() + ", 0x"
//			sql.append("SELECT dbo.validarUsuarioPensionado (0x" + user.getNombreencriptado() + ", 0x"
				//	+ hex.transHexa(user.getClave().trim(), 2).replace(" ", "<br>") + ") ");
			
			
			 sql.append( "select COUNT(*)  as total " +
//				"from usuario_talento_humano_login s " +
				"from usuario_hojavida_web_login s " +
				"where  state = 1  " +
				" and HASHBYTES('SHA1',s.us) = HASHBYTES('SHA1', '" + hex.transHexa(usuario.getNombreencriptado().trim(), 2).replace(" ", "<br>") + "') "+
				"  and s.uwd2 = (select HASHBYTES('MD5',HASHBYTES('SHA', '" + hex.transHexa(usuario.getClave().trim(), 2).replace(" ", "<br>") + "'))) ");
				//+ " and HASHBYTES('SHA1',s.uwd)= HASHBYTES('SHA1',"+hex.transHexa(usuario.getClave().trim(), 2).replace(" ", "<br>") + ") ");
			 imp.info("inicio crear_sesion>>>>sesion:"+sql.toString());
			conn = consegura.conexionConsulta();
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while (resul.next()) {
				if (resul.getInt(1) >= 1) {
					elemento = true;
				}
			}
			consegura.cerrarconn(conn, resul, sentencia);
		} catch (Exception e) {
			imp.error("-->" + e.toString()+" - "+sql.toString());
			consegura.cerrarconn(conn, resul, sentencia);

		}

		return elemento;
	}

	@Override
	public Object getDocentes(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getTotal(Object obj) {
		Object param[] = (Object[]) obj;
		imp = Logger.getLogger(getClass().getName());
		imp.info("select antes " + String.valueOf(param[2]));
		int opt= Integer.parseInt(String.valueOf(param[2]));
		imp.info("select despues " );
		int resultado=0;
		if(opt==1) {
			resultado=getJefes(obj);
			resultado=resultado+getAsignacioFunciones(obj);
		}
		imp.info("select sale " +resultado);
		return resultado;
	}
	
	protected int getJefes(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		ResultSet rs=null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();
		int total=0;
		try {
			Object param[] = (Object[]) obj;
			PersonaNovedad personaNovedad = (PersonaNovedad) param[0];
			Usuario admin = (Usuario) param[1];
			sql = new StringBuffer();
			sql.append("select count(*) as total FROM uaa_personal up with(nolock) ");
			sql.append("INNER JOIN persona p with(nolock) ON(p.per_codigo=up.per_codigo) ");
			sql.append("INNER JOIN uaa_cargo uc with(nolock) ON(uc.uac_codigo=up.uac_codigo) ");
			sql.append("INNER JOIN cargo c with(nolock) ON(c.car_codigo=uc.uac_cargo) ");
			sql.append("INNER JOIN vinculacion v with(nolock) ON(v.vin_codigo=uc.uac_vinculacion) ");
			sql.append("INNER JOIN uaa u with(nolock) ON(u.uaa_codigo=uc.uac_uaa) ");
			sql.append("INNER JOIN periodo pe with(nolock) ON(up.uap_fecha_fin BETWEEN  pe.per_fecha_inicio AND pe.per_fecha_fin OR up.uap_fecha_fin is null) ");
			sql.append("WHERE up.uap_uacocupado= ? ");
			sql.append("AND pe.per_codigo= ? ");
			sql.append("AND p.per_codigo= ? ");
			sql.append("");
			sql.append("");
			
			conn = consegura.getconn_admin(admin);
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			sentencia.setInt(1, 1);
			 sentencia.setInt(2, personaNovedad.getPeriodo().getCodigo());
			 sentencia.setInt(3, personaNovedad.getUaaPersonal().getPersona().getCodigo());
			imp.info("getJefes " + sql.toString() + " " + personaNovedad);
			rs=sentencia.executeQuery();
			conn.commit();
			while (rs.next()) {
				total=rs.getInt("total");		
			}
			consegura.cerrarconn(conn, rs, sentencia);
		} catch (Exception e) {
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, rs, sentencia);

		}
		return total;
	}
	protected int getAsignacioFunciones(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		ResultSet rs=null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();
		int total=0;
		try {
			Object param[] = (Object[]) obj;
			PersonaNovedad personaNovedad = (PersonaNovedad) param[0];
			Usuario admin = (Usuario) param[1];
			sql = new StringBuffer();
			sql.append("select count(*) as total FROM uaa_personal up with(nolock)  ");
			sql.append("INNER JOIN persona p with(nolock) ON(p.per_codigo=up.per_codigo)  ");
			sql.append("INNER JOIN cargo c with(nolock) ON(up.uap_cargo=c.car_codigo)  ");
			sql.append("INNER JOIN vinculacion v with(nolock) ON(v.vin_codigo=up.vin_codigo) ");
			sql.append("INNER JOIN uaa u with(nolock) ON(u.uaa_codigo=up.uaa_codigo)  ");
			sql.append("INNER JOIN periodo pe with(nolock) ON(up.uap_fecha_fin BETWEEN  pe.per_fecha_inicio AND pe.per_fecha_fin OR up.uap_fecha_fin is null) ");
			sql.append("WHERE up.vin_codigo=? ");
			sql.append("AND pe.per_codigo= ? ");
			sql.append("AND p.per_codigo= ? ");
			sql.append("");
			sql.append("");
			
			conn = consegura.getconn_admin(admin);
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			sentencia.setInt(1, 46);
			 sentencia.setInt(2, personaNovedad.getPeriodo().getCodigo());
			 sentencia.setInt(3, personaNovedad.getUaaPersonal().getPersona().getCodigo());
			imp.info("getJefes " + sql.toString() );
			imp.info("getJefes " + personaNovedad);
			rs=sentencia.executeQuery();
			conn.commit();
			while (rs.next()) {
				total=rs.getInt("total");		
			}
			consegura.cerrarconn(conn, rs, sentencia);
		} catch (Exception e) {
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, rs, sentencia);

		}
		return total;
	}
	
	protected Object getVicerrctorias(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		ResultSet rs=null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();
		int total=0;
		try {
			Object param[] = (Object[]) obj;
			Persona persona = (Persona) param[0];
			Usuario admin = (Usuario) param[1];
			sql = new StringBuffer();

			sql.append("select count(*)  from uaa_personal up with(nolock)  \r\n" );
			sql.append("inner join uaa u with(nolock) on(u.uaa_codigo=up.uaa_codigo)\r\n" ); 
			sql.append("inner join persona p with(nolock) on(p.per_codigo=up.per_codigo)\r\n" );
			sql.append("INNER JOIN persona p with(nolock) ON(p.per_codigo=u.usu_persona)\r\n");
			sql.append("INNER JOIN uaa_personal up with(nolock) ON(up.per_codigo=p.per_codigo)\r\n" ); 
			sql.append("WHERE g.gru_codigo in(66,67,69,14,34) and p.per_codigo=? and\r\n" );
			sql.append("(((CAST(GETDATE() AS DATE )   between  CAST(up.uap_fecha_inicio AS DATE ) and CAST(up.uap_fecha_fin AS DATE )) \r\n" );
			sql.append("and (CAST(GETDATE() AS DATE )   between  CAST(up.uap_fecha_inicio AS DATE ) \r\n" );
			sql.append("and CAST(up.uap_fecha_fin AS DATE ))) or (((CAST(up.uap_fecha_inicio AS DATE )   <=  CAST(GETDATE() AS DATE ) and up.uap_fecha_fin is null ))))\r\n" );

			conn = consegura.getconn_admin(admin);
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			 sentencia.setInt(1, persona.getCodigo());
			imp.info("select persona " + sql.toString() + " " + persona);
			rs=sentencia.executeQuery();
			conn.commit();
			while (rs.next()) {
				total=rs.getInt("total");		
			}
			consegura.cerrarconn(conn, rs, sentencia);
		} catch (Exception e) {
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, rs, sentencia);

		}
		return total;
	}

	@Override
	public Object getVinculacion(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDocente(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getReporte(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
