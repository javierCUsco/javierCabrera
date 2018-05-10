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
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.PersonaHistoriaLaboral;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Persona_historia_laboralDB implements conexion {

	private Logger imp ;
	/* (non-Javadoc)
	 * @see co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion#getAll(java.lang.Object)
	 */
	@Override
	public Object getAll(Object obj) {
		Connection conn = null;
		Statement sentencia=null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		 LinkedList<PersonaHistoriaLaboral> lista = new LinkedList<PersonaHistoriaLaboral>();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 PersonaHistoriaLaboral pha= (PersonaHistoriaLaboral) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
//			sql.append("select top 10  pha.pha_codigo,pha.per_codigo,coalesce(CONVERT(VARCHAR(10),pha.pha_fecha_inicio,111),(SELECT CONVERT(VARCHAR(10),GETDATE(), 111))),coalesce(CONVERT(VARCHAR(10),pha.pha_fecha_fin,111),(SELECT CONVERT(VARCHAR(10),GETDATE(), 111))),pha.ine_codigo,ine.ine_nombre,pha.pha_ciudad,mun.mun_nombre,dep.dep_codigo,dep.dep_nombre,pa.pai_codigo,pa.pai_nombre,pha.pha_titulo,pha.nia_codigo,nia.nia_nombre,pha.pha_documento,pha.pha_estado,coalesce(CONVERT(VARCHAR(10),pha.pha_fecha_titulo,111),(SELECT CONVERT(VARCHAR(10),GETDATE(), 111))),pha.pha_convalidado,pha.pha_mod_codigo,mo.mod_nombre   ");
			sql.append("select top 10 p.per_codigo,phl.phl_codigo,phl.phl_fecha_inicio,phl.phl_fecha_fin,phl.phl_empresa,phl.phl_empresa_direccion,phl.phl_empresa_telefono,m.mun_codigo,m.mun_nombre,d.dep_codigo,d.dep_nombre,pai.pai_codigo,pai.pai_nombre,phl.ocupacion_cargo,phl.phl_cargo,phl.phl_descripcion,ded.ded_codigo,ded.ded_nombre,vin.vin_codigo,vin.vin_nombre,phl.phl_archivo,phl.phl_archivo_md5,phl.phl_content_type    ");
			sql.append("from persona_historia_laboral phl with(nolock) ");
			sql.append("left join persona p with(nolock) on (p.per_codigo=phl.per_codigo) ");
			sql.append("left join historia_laboral_tipo hlt with(nolock) on (hlt.hlt_codigo=phl.hlt_codigo) ");
			sql.append("left join municipio m with(nolock) on (m.mun_codigo=phl.mun_codigo) ");
			sql.append("left join departamento d with(nolock) on (d.dep_codigo= m.dep_codigo) ");
			sql.append("left join pais pai with(nolock) on (pai.pai_codigo=d.pai_codigo) ");
			sql.append("left join vinculacion vin with(nolock) on(vin.vin_codigo=phl.vin_codigo)  ");
			sql.append("left join dedicacion ded with(nolock) on(ded.ded_codigo=phl.ded_codigo) ");
			sql.append(" ");
			sql.append(" ");
			if(pha.getPersona().getPer_codigo()>0){
				sql.append("where phl.per_codigo= "+pha.getPersona().getPer_codigo());
				sql.append(" ");
			}
			sql.append(" ");
			sql.append(" ");
			sql.append(" ");
			conn = consegura.conexion_segura();
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
	
			while(resul.next()){
				PersonaHistoriaLaboral elemento= new PersonaHistoriaLaboral();
				elemento.getPersona().setPer_codigo(resul.getInt(1));
				elemento.setPhl_codigo(resul.getInt(2));
				elemento.setPhl_fecha_inicio(resul.getDate(3));
				elemento.setPhl_fecha_fin(resul.getDate(4));
				elemento.setPhl_empresa(resul.getString(5));
				elemento.setPhl_empresa_direccion(resul.getString(6));
				elemento.setPhl_empresa_telefono(resul.getString(7));
				elemento.getMunicipio().setMun_codigo(resul.getInt(8));
				elemento.getMunicipio().setMun_nombre(resul.getString(9));
				elemento.getMunicipio().getDepartamento().setDep_codigo(resul.getInt(10));
				elemento.getMunicipio().getDepartamento().setDep_nombre(resul.getString(11));
				elemento.getMunicipio().getDepartamento().getPais().setPai_codigo(resul.getInt(12));
				elemento.getMunicipio().getDepartamento().getPais().setPai_nombre(resul.getString(13));
				elemento.setOcupacion_cargo(resul.getString(14));
				elemento.setPhl_cargo(resul.getString(15));
				elemento.setPhl_descripcion(resul.getString(16));
				elemento.getDedicacion().setDed_codigo(resul.getInt(17));
				elemento.getDedicacion().setDed_nombre(resul.getString(18));
				elemento.getVinculacion().setVin_codigo(resul.getInt(19));
				elemento.getVinculacion().setVin_nombre(resul.getString(20));
				
				elemento.getArchivo().setPh_archivo(resul.getString(21));
				elemento.getArchivo().setPh_archivo_md5(resul.getString(22));
//				elemento.getArchivo().setPh_content_type(resul.getDate(18));
//				elemento.setPha_convalidado(resul.getInt(19));
//				elemento.getModalidad().setMod_codigo(resul.getInt(20));
//				elemento.getModalidad().setMod_nombre(resul.getString(21));
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
		PersonaHistoriaLaboral elemento= new PersonaHistoriaLaboral();
			Conexion consegura = new Conexion();
		 try {
			 Object param[]=(Object[]) obj;
			 PersonaHistoriaLaboral pha= (PersonaHistoriaLaboral) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
//			sql.append("select top 10  pha.pha_codigo,pha.per_codigo,coalesce(CONVERT(VARCHAR(10),pha.pha_fecha_inicio,111),(SELECT CONVERT(VARCHAR(10),GETDATE(), 111))),coalesce(CONVERT(VARCHAR(10),pha.pha_fecha_fin,111),(SELECT CONVERT(VARCHAR(10),GETDATE(), 111))),pha.ine_codigo,ine.ine_nombre,pha.pha_ciudad,mun.mun_nombre,dep.dep_codigo,dep.dep_nombre,pa.pai_codigo,pa.pai_nombre,pha.pha_titulo,pha.nia_codigo,nia.nia_nombre,pha.pha_documento,pha.pha_estado,coalesce(CONVERT(VARCHAR(10),pha.pha_fecha_titulo,111),(SELECT CONVERT(VARCHAR(10),GETDATE(), 111))),pha.pha_convalidado,pha.pha_mod_codigo,mo.mod_nombre   ");
			sql.append("select  p.per_codigo,phl.phl_codigo,phl.phl_fecha_inicio,phl.phl_fecha_fin,phl.phl_empresa,phl.phl_empresa_direccion,phl.phl_empresa_telefono,m.mun_codigo,m.mun_nombre,d.dep_codigo,d.dep_nombre,pai.pai_codigo,pai.pai_nombre,phl.ocupacion_cargo,phl.phl_cargo,phl.phl_descripcion,ded.ded_codigo,ded.ded_nombre,ded.ded_orden_snies,ded.sippa_dedcodigo,ded.ded_codigo_hecaa,vin.vin_codigo,vin.vin_nombre,vin.vin_horas_year,vin.vin_contratacion,vin.vin_clase,vin.sippa_vincodigo,phl.phl_archivo,phl.phl_archivo_md5,phl.phl_content_type,hlt.hlt_codigo,hlt.hlt_nombre ");
			sql.append("from persona_historia_laboral phl with(nolock) ");
			sql.append("left join persona p with(nolock) on (p.per_codigo=phl.per_codigo) ");
			sql.append("left join historia_laboral_tipo hlt with(nolock) on (hlt.hlt_codigo=phl.hlt_codigo) ");
			sql.append("left join municipio m with(nolock) on (m.mun_codigo=phl.mun_codigo) ");
			sql.append("left join departamento d with(nolock) on (d.dep_codigo= m.dep_codigo) ");
			sql.append("left join pais pai with(nolock) on (pai.pai_codigo=d.pai_codigo) ");
			sql.append("left join vinculacion vin with(nolock) on(vin.vin_codigo=phl.vin_codigo)  ");
			sql.append("left join dedicacion ded with(nolock) on(ded.ded_codigo=phl.ded_codigo) ");
			sql.append(" ");
			sql.append(" ");
			if(pha.getPersona().getPer_codigo()>0){
				sql.append("where phl.per_codigo= "+pha.getPersona().getPer_codigo()+" ");
				sql.append("and phl.phl_codigo= "+pha.getPhl_codigo());
			}
			sql.append(" ");
			sql.append(" ");
			sql.append(" ");
//			sql.append("where cert_estado=1  ");


			conn = consegura.conexion_segura();
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
//			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			
			while(resul.next()){
				elemento= new PersonaHistoriaLaboral();
				
				elemento.getPersona().setPer_codigo(resul.getInt(1));
				elemento.setPhl_codigo(resul.getInt(2));
				elemento.setPhl_fecha_inicio(resul.getTimestamp(3));
				elemento.setPhl_fecha_fin(resul.getTimestamp(4));
				elemento.setPhl_empresa(resul.getString(5));
				elemento.setPhl_empresa_direccion(resul.getString(6));
				elemento.setPhl_empresa_telefono(resul.getString(7));
				elemento.getMunicipio().setMun_codigo(resul.getInt(8));
				elemento.getMunicipio().setMun_nombre(resul.getString(9));
				elemento.getMunicipio().getDepartamento().setDep_codigo(resul.getInt(10));
				elemento.getMunicipio().getDepartamento().setDep_nombre(resul.getString(11));
				elemento.getMunicipio().getDepartamento().getPais().setPai_codigo(resul.getInt(12));
				elemento.getMunicipio().getDepartamento().getPais().setPai_nombre(resul.getString(13));
				elemento.setOcupacion_cargo(resul.getString(14));
				elemento.setPhl_cargo(resul.getString(15));
				elemento.setPhl_descripcion(resul.getString(16));
				
				elemento.getDedicacion().setDed_codigo(resul.getInt(17));
				elemento.getDedicacion().setDed_nombre(resul.getString(18));
				elemento.getDedicacion().setDed_orden_snies(resul.getInt(19));
				elemento.getDedicacion().setSippa_dedcodigo(resul.getString(20));
				elemento.getDedicacion().setDed_codigo_hecaa(resul.getString(21));
				elemento.getVinculacion().setVin_codigo(resul.getInt(22));
				elemento.getVinculacion().setVin_nombre(resul.getString(23));
				elemento.getVinculacion().setVin_horas_year(resul.getInt(24));
				elemento.getVinculacion().setVin_contratacion(resul.getString(25));
				elemento.getVinculacion().setVin_clase(resul.getInt(26));
				elemento.getVinculacion().setSippa_vincodigo(resul.getInt(27));
				
				elemento.getPersona().getArchivo().setPh_archivo(resul.getString(28));
				elemento.getPersona().getArchivo().setPh_archivo_md5(resul.getString(29));
				elemento.getPersona().getArchivo().setPh_content_type(resul.getString(30));
				
				elemento.getTipo().setHlt_codigo(resul.getInt(31));
				elemento.getTipo().setHlt_nombre(resul.getString(32));
				
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
		if(opt==0){
			resultado=insertObject(param[1]);
		}
		if(opt==1){
			resultado=updateObject(param[1]);
		}
		return resultado;
	}
	private Object updateObject(Object obj) {
		Connection conn = null;
		Statement sentencia=null;
		int resul=0;
		imp =Logger.getLogger(getClass().getName());
			Conexion consegura = new Conexion();
		 try {
			 PersonaHistoriaLaboral persona=(PersonaHistoriaLaboral) obj; 
//			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE persona_historia_laboral ");
			sql.append("SET  ");

//			sql.append("'"+persona.getPersona().getPer_identificacion()+"'");
			sql.append(" phl_fecha_inicio= '"+Fecha.getFecha_format(persona.getPhl_fecha_inicio())+"' ");
			sql.append(" ,phl_fecha_fin ='"+Fecha.getFecha_format(persona.getPhl_fecha_fin())+"' ");
			sql.append(" ,phl_empresa= '"+persona.getPhl_empresa()+"' ");
			sql.append(" ,phl_empresa_direccion =  '"+persona.getPhl_empresa_direccion()+"' ");
			sql.append(" ,phl_empresa_telefono =  '"+persona.getPhl_empresa_telefono()+"' ");
			sql.append(" ,mun_codigo ='"+persona.getMunicipio().getMun_codigo()+"' ");
			sql.append(" ,ocupacion_cargo ='"+persona.getOcupacion_cargo()+"' ");
			sql.append(" ,hlt_codigo ='"+persona.getTipo().getHlt_codigo()+"' ");
			sql.append(" ,ded_codigo =  '"+persona.getDedicacion().getDed_codigo()+"' ");
			sql.append(" ,vin_codigo = "+persona.getVinculacion().getVin_codigo());
			sql.append(" ,phl_cargo =  '"+persona.getPhl_cargo()+"' ");
			sql.append(" ,phl_descripcion =  '"+persona.getPhl_descripcion()+"' ");
			sql.append(" ,phl_archivo =  '"+persona.getPersona().getArchivo().getPh_archivo()+"' ");
			sql.append(" ,phl_archivo_md5 =  '"+persona.getPersona().getArchivo().getPh_archivo_md5()+"' ");
			sql.append(" ,phl_content_type =  '"+persona.getPersona().getArchivo().getPh_content_type()+"' ");

			sql.append("WHERE phl_codigo=  "+persona.getPhl_codigo()+" ");
			sql.append(" and per_codigo= "+persona.getPersona().getPer_codigo()+" " );
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");


			conn = consegura.conexion_segura();
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeUpdate(sql.toString());
//			while(resul.next()){
//				publicacion_tipoOb elemento= new publicacion_tipoOb();
//				elemento.setPut_codigo(resul.getInt(1));
//				elemento.setPut_nombre(resul.getString(2));
//				elemento.setSippa_tipcodigo(resul.getString(3));
//				lista.add(elemento);
//				}
			consegura.cerrarconn(conn, null, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, null, sentencia);

	        }
		return resul;
	}

	private Object insertObject(Object obj){
		Connection conn = null;
		Statement sentencia=null;
		int resul=0;
		imp =Logger.getLogger(getClass().getName());
			Conexion consegura = new Conexion();
		 try {
			 PersonaHistoriaLaboral persona=(PersonaHistoriaLaboral) obj; 
//			 publicacion_tipoOb pu= (publicacion_tipoOb) param[0];
//			 usuarioOb admin= (usuarioOb) param[1];
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO persona_historia_laboral(per_codigo,phl_fecha_inicio,phl_fecha_fin,phl_empresa,phl_empresa_direccion,phl_empresa_telefono,mun_codigo,ocupacion_cargo,hlt_codigo,ded_codigo,vin_codigo,phl_cargo,phl_descripcion,phl_archivo,phl_archivo_md5,phl_content_type ");
			sql.append(")VALUES ");

			sql.append("('"+persona.getPersona().getPer_codigo()+"' ");
			sql.append(" , '"+Fecha.getFecha_format(persona.getPhl_fecha_inicio())+"' ");
			sql.append(" , '"+Fecha.getFecha_format(persona.getPhl_fecha_fin())+"' ");
			sql.append(" , '"+persona.getPhl_empresa() +"'");
			sql.append(" , '"+persona.getPhl_empresa_direccion() +"'");
			sql.append(" , '"+persona.getPhl_empresa_telefono() +"'");
			sql.append(" , "+persona.getMunicipio().getMun_codigo());
			sql.append(" , '"+persona.getPhl_cargo()+"'");
			sql.append(" , '"+persona.getTipo().getHlt_codigo()+"'");
			sql.append(" ,  "+persona.getDedicacion().getDed_codigo()+" ");
			sql.append(" ,  "+persona.getVinculacion().getVin_codigo()+" ");
			sql.append(" , '"+persona.getPhl_cargo()+"'");
			sql.append(" , '"+persona.getPhl_descripcion()+"'");
			sql.append(" , '"+persona.getPersona().getArchivo().getPh_archivo()+"'");
			sql.append(" , '"+persona.getPersona().getArchivo().getPh_archivo_md5()+"'");
			sql.append(" , '"+persona.getPersona().getArchivo().getPh_content_type()+"'");
			sql.append(" ) ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");


			conn = consegura.conexion_segura();
			imp.info("valida el usuario "+sql.toString());
			sentencia = conn.createStatement();
			resul = sentencia.executeUpdate(sql.toString());
//			while(resul.next()){
//				publicacion_tipoOb elemento= new publicacion_tipoOb();
//				elemento.setPut_codigo(resul.getInt(1));
//				elemento.setPut_nombre(resul.getString(2));
//				elemento.setSippa_tipcodigo(resul.getString(3));
//				lista.add(elemento);
//				}
			consegura.cerrarconn(conn, null, sentencia);
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			 imp.error(""+e.toString() );
			 consegura.cerrarconn(conn, null, sentencia);

	        }
		return resul;
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
