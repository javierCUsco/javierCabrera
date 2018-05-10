/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.Persona_historia_academicaDB;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.herramientas.LoadFile;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.PersonaHistoriaAcademica;
import co.edu.usco.seguridad.seguridad;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
@WebServlet(name = "Persona_hitoria_academicaLog", urlPatterns = {"/upload"})
@MultipartConfig
public class Persona_historia_academicaLog   extends HttpServlet{
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new Persona_historia_academicaDB();
		return db.getAll(obj);
	}

	public static Object getElemento(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new Persona_historia_academicaDB();
		return db.getObject(obj);
	}

	public static Object newObject(HttpServletRequest request) {
		
		Object param[]=(Object[]) getvalidaDatos(request);
		Mensaje msm=(Mensaje) param[0];
		
		if(msm.isValido()){
			conexion db= new Persona_historia_academicaDB();
			if(msm.isValido()){
//				JOptionPane.showMessageDialog(null, "3 "+msm.isValido());
				LoadFile file= new LoadFile();
				PersonaHistoriaAcademica  pha = (PersonaHistoriaAcademica) param[1];
//				JOptionPane.showMessageDialog(null, "4");
				try {
					msm=(Mensaje) file.processRequest(request, pha.getPersona());
					pha.setPersona((Persona) msm.getResultado());
					int resultado=(int)db.setObject(param);
					if(resultado==1){
						msm.setValido(true);
//						JOptionPane.showMessageDialog(null, "5 ");
						msm.setMsm("se ha guardado el registro..");
					}else{
						msm.setValido(false);
						msm.setMsm("Error no se ha guardado el registro..");
					}
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
//			System.out.println("resultado   "+resultado);
			
		}
		return msm;
		
	}

	private static Object getvalidaDatos(HttpServletRequest request) {

		Mensaje mensaje= new Mensaje();
		mensaje.setValido(true);
		String msm="";
		int update=0;
		PersonaHistoriaAcademica persona= new PersonaHistoriaAcademica();
	
		if((request.getParameter("pha_codigo")!= null || request.getParameter("pha_codigo").length()>=0) && !request.getParameter("pha_codigo").equalsIgnoreCase("undefined")){
			
			Object obj[]= (Object[])seguridad.esNumero(request.getParameter("pha_codigo"));
			
			if((boolean)obj[0]){
				persona.setPha_codigo(Integer.parseInt(request.getParameter("pha_codigo")));
				update=1;
			}else{
				mensaje.setValido(false);
				msm=msm+obj[1];	
			}
			
		}
		
		if(request.getParameter("per_codigo")== null || request.getParameter("per_codigo").length()<=0 || request.getParameter("per_codigo").equalsIgnoreCase("undefined")){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el codigo de la persona";
		}else{
			persona.getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
			
		}
		if(request.getParameter("nia_codigo")== null || request.getParameter("nia_codigo").length()<=0 || request.getParameter("nia_codigo").equalsIgnoreCase("undefined")){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el nivel academico";
		}else{
//			Object obj[]= (Object[])seguridad.esNumeroIdentificacion(request.getParameter("nia_codigo"), "el numer de identificacion");
			persona.getNivel_academico().setNia_codigo(Integer.parseInt(request.getParameter("nia_codigo")));
		}
		if(request.getParameter("mun_codigo")== null || request.getParameter("mun_codigo").length()<=0 || request.getParameter("mun_codigo").equalsIgnoreCase("undefined")){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el municipio";
		}else{
			persona.getMunicipio().setMun_codigo(Integer.parseInt(request.getParameter("mun_codigo")));
		}
		
		
		if(request.getParameter("ine_codigo")== null || request.getParameter("ine_codigo").length()<=0 || request.getParameter("ine_codigo").equalsIgnoreCase("undefined")){
			mensaje.setValido(false);
			msm=msm+" debe ingresar la institucion academica ";
		}else{
			persona.getInstitucion().setIne_codigo(Integer.parseInt( request.getParameter("ine_codigo")));
		}
	
		if(request.getParameter("mod_codigo")== null || request.getParameter("mod_codigo").length()<=0 || request.getParameter("mod_codigo").equalsIgnoreCase("undefined")){
			mensaje.setValido(false);
			msm=msm+" debe ingresar la modalidad de estudio ";
		}else{
			persona.getModalidad().setMod_codigo(Integer.parseInt(request.getParameter("mod_codigo")));
		}
		if(request.getParameter("pha_fecha_inicio")== null || request.getParameter("pha_fecha_inicio").length()<=0 || request.getParameter("pha_fecha_inicio").equalsIgnoreCase("undefined")){
			mensaje.setValido(false);
			msm=msm+" debe ingresar fecha en que inicio ";
		}else{
			
			persona.setPha_fecha_inicio(Fecha.getFecha_date(request.getParameter("pha_fecha_inicio")));
		}
//		if(request.getParameter("pha_fecha_titulo")== null || request.getParameter("pha_fecha_titulo").length()<=0){
//			mensaje.setValido(false);
//			msm=msm+" debe ingresar la fecha en finalizo ";
//		}else{
//			
//			persona.setPha_fecha_inicio(DeStringADate(request.getParameter("pha_fecha_titulo")));
//		}
		if(request.getParameter("pha_fecha_fin")== null || request.getParameter("pha_fecha_fin").length()<=0 || request.getParameter("pha_fecha_fin").equalsIgnoreCase("undefined")){
			mensaje.setValido(false);
			msm=msm+" debe ingresar la fecha en que finalizo ";
		}else{
			
			persona.setPha_fecha_fin(Fecha.getFecha_date(request.getParameter("pha_fecha_fin")));
		}
		
		if(request.getParameter("pha_fecha_titulo")== null || request.getParameter("pha_fecha_titulo").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar la fecha del grado ";
		}else{
			
			persona.setPha_fecha_titulo(Fecha.getFecha_date(request.getParameter("pha_fecha_titulo")));
		}
		if(request.getParameter("pha_duracion_anos")!= null || request.getParameter("pha_duracion_anos").length()>0){

			Object obj[]= (Object[])seguridad.esNumero(request.getParameter("pha_duracion_anos"));
			
			if((boolean)obj[0]){
				persona.setPha_duracion_anos(Integer.parseInt(request.getParameter("pha_duracion_anos")));

			}else{
				mensaje.setValido(false);
				msm=msm+obj[1];	
			}
		}
		
		if(request.getParameter("pha_puntos")!= null || request.getParameter("pha_puntos").length()>0){

			Object obj[]= (Object[])seguridad.esNumero(request.getParameter("pha_puntos"));
			
			if((boolean)obj[0]){
				persona.setPha_puntos(Integer.parseInt(request.getParameter("pha_puntos")));

			}else{
				mensaje.setValido(false);
				msm=msm+obj[1];	
			}
		}
		
		if(request.getParameter("pha_titulo")== null || request.getParameter("pha_titulo").length()<=0 || request.getParameter("pha_titulo").equalsIgnoreCase("undefined")){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el titulo optenido";
		}else{
			persona.setPha_titulo(request.getParameter("pha_titulo"));
		}
		if(request.getParameter("pha_documento")!= null && request.getParameter("pha_documento").length()>0){
			persona.setPha_documento(request.getParameter("pha_documento"));
		}
		if(request.getParameter("pha_archivo")!= null && request.getParameter("pha_archivo").length()>0){
			persona.getPersona().getArchivo().setPh_archivo(request.getParameter("pha_archivo"));
		}
//		
		mensaje.setMsm(msm);
		Object [] retultado={mensaje,persona,update};
//		JOptionPane.showMessageDialog(null, "validando"+mensaje.isValido()+" "+mensaje.getMsm());
		return retultado;
		
	}
	
	
	
//	public static Date DeStringADate(String fecha){
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        String strFecha = fecha;
//        Date fechaDate =  new Date(Long.parseLong(fecha));
//		            System.out.println(fechaDate.toString());
//		return fechaDate;
//    }
	
}
