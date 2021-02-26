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

import co.edu.usco.modulo.personal.mvc.control.accesoDB.rowMapper.MunicipioRowMapper;
import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Municipio;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class MunicipioDB implements ConexionDB {
	private Logger imp ;
	private String SQL_SELECT="select m.mun_codigo,m.mun_id,m.mun_nombre,m.dep_codigo,m.sippa_mun_codigo,m.SNIES_codigo,m.dane_codigo,\r\n" + 
			"d.dep_codigo,d.dep_acronimo,d.dep_nombre,d.pai_codigo,d.sippa_dep_codigo,d.dane_codigo,p.pai_codigo,p.pai_acronimo,p.pai_nombre,p.sippa_pai_codigo,p.dane_codigo,p.pai_codigo_hecaa\r\n" + 
			" from municipio m\r\n" + 
			"inner join departamento d on(m.dep_codigo=d.dep_codigo)\r\n" + 
			"inner join pais p on (d.pai_codigo=p.pai_codigo)";
	
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		PreparedStatement sentencia = null;
		LinkedList<Municipio> lista=null;
		imp = Logger.getLogger(getClass().getName());
		Conexion consegura = new Conexion();
		StringBuffer sql = new StringBuffer();

		try {
			Object param[] = (Object[]) obj;
			Municipio municipio= (Municipio) param[0];
			if(param[1]!=null) {
				Usuario admin= (Usuario) param[1];
			}
		
			sql = new StringBuffer();
			sql.append(SQL_SELECT);
			//if(municipio.getNombre()!=null && !municipio.getNombre().equals("") && municipio.getNombre().length()>0) {
				sql.append("WHERE mun_nombre like '%" +municipio.getNombre()+"%'");
			//}
			conn = consegura.conexionConsulta();//consegura.getconn_admin (admin);
			conn.setAutoCommit(false);
			sentencia = conn.prepareStatement(sql.toString());
			//if(municipio.getNombre()!=null && !municipio.getNombre().equals("") && municipio.getNombre().length()>0) {
				//sentencia.setString(1,"'%" +municipio.getNombre()+"%'");
			//}
			
			
			imp.info("select Municipio " + sql.toString()+" "+municipio);
//			rs=sentencia.executeQuery();
			conn.commit();
			lista  =(LinkedList<Municipio>) MunicipioRowMapper.mapRow(sentencia.executeQuery());
			consegura.cerrarconn(conn, null, sentencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			imp.error("" + e.toString());
			consegura.cerrarconn(conn, null, sentencia);

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
		 Municipio objeto = new Municipio();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 Municipio municipio= (Municipio) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("select mun_codigo,mun_id,mun_nombre,dep_codigo,sippa_mun_codigo,SNIES_codigo,dane_codigo  ");
			sql.append("FROM [municipio]  with(nolock)  ");
			sql.append("where  ");
			if(municipio.getDepartamento().getCodigo()>0){
				sql.append(" dep_codigo= "+municipio.getDepartamento().getCodigo()+" ");
			}
			if(municipio.getNombre()!=null && municipio.getNombre().length()>0){
				sql.append(" mun_nombre like '"+municipio.getNombre()+"%' ");
			}
			
			sql.append("order by mun_nombre");


			conn = consegura.conexionConsulta();
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while(resul.next()){
				objeto= new Municipio();
				objeto.setCodigo(resul.getInt(1));
				objeto.setId(resul.getString(2));
				objeto.setNombre(resul.getString(3));
				objeto.getDepartamento().setCodigo(resul.getInt(4));
				
				}
			consegura.cerrarconn(conn, resul, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, resul, sentencia);

	        }
		return objeto;
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
