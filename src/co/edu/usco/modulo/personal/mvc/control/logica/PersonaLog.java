/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.PersonaDB;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.Persona_carrera_administrativaDB;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.pensionado.Pensionado;
import co.edu.usco.seguridad.seguridad;



/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PersonaLog {
	static conexion db=null;
	public static Object newObject(HttpServletRequest request) {
			
		
		Mensaje msm= (Mensaje) getvalidaDatos(request);
		if(msm.isValido()){
			db= new PersonaDB();
			Object param[]=(Object[]) getvalidaDatos(request);
			Mensaje mensaje=(Mensaje) param[0];
			if(mensaje.isValido()){
				int resultado=(int)db.setObject(param);
				if(resultado==1){
					msm.setValido(true);
					msm.setMsm("se ha guardado el registro..");
				}else{
					msm.setValido(false);
					msm.setMsm("Error no se ha guardado el registro..");
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
		Persona persona= new Persona();
		if(request.getParameter("per_codigo")!= null || request.getParameter("per_codigo").length()>=0){
			
			Object obj[]= (Object[])seguridad.esNumero(request.getParameter("per_codigo"));
			
			if((boolean)obj[0]){
				persona.setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
				update=1;
			}else{
				mensaje.setValido(false);
				msm=msm+obj[1];	
			}
			
		}
		if(request.getParameter("tii_codigo")== null || request.getParameter("tii_codigo").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el ";
		}else{
			persona.getTii_codigo().setTii_codigo(Integer.parseInt(request.getParameter("tii_codigo")));
			
		}
		if(request.getParameter("per_identificacion")== null || request.getParameter("per_identificacion").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el ";
		}else{
			Object obj[]= (Object[])seguridad.esNumeroIdentificacion(request.getParameter("per_identificacion"), "el numer de identificacion");
			persona.setPer_identificacion(request.getParameter("per_identificacion"));
		}
		if(request.getParameter("per_lugarExp")== null || request.getParameter("per_lugarExp").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el ";
		}else{
			persona.getPer_lugar_expedicion().setMun_codigo(Integer.parseInt(request.getParameter("per_lugarExp")));
		}
		if(request.getParameter("per_nombre1")== null ||  request.getParameter("per_nombre1").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el ";
		}else{
			if(request.getParameter("per_nombre2")== null || request.getParameter("per_nombre2").length()<=2){
				mensaje.setValido(false);
				msm=msm+" debe ingresar el ";
			}else{
				persona.setPer_nombre(request.getParameter("per_nombre1").trim()+" "+request.getParameter("per_nombre2").trim());
			}
		}
		if(request.getParameter("per_apellido1")!= null || request.getParameter("per_apellido1").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el ";
		}else{
			if(request.getParameter("per_apellido2")!= null || request.getParameter("per_apellido2").length()<=2){
				mensaje.setValido(false);
				msm=msm+" debe ingresar el ";
			}else{
				
			}	
		}
		if(request.getParameter("per_rh")!= null || request.getParameter("per_rh").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el ";
		}else{
			persona.getGrs().setGrs_codigo(Integer.parseInt( request.getParameter("per_rh")));
			
		}
		if(request.getParameter("per_estrato")!= null || request.getParameter("per_estrato").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el ";
		}else{
			persona.getEstrato().setEst_codigo(Integer.parseInt( request.getParameter("per_estrato")));
		}
		if(request.getParameter("per_genero")== null || request.getParameter("per_genero").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el ";
		}else{
			persona.getGenero().setGen_codigo((char)String.valueOf(request.getParameter("per_genero")).indexOf(0));
		}
		if(request.getParameter("per_esc")== null || request.getParameter("per_esc").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el ";
		}else{
			persona.getEstado_civil().setEsc_codigo(Integer.parseInt(request.getParameter("per_esc")));
		}
		if(request.getParameter("per_fecha_nacimiento")== null || request.getParameter("per_fecha_nacimiento").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el ";
		}else{
			persona.setPer_fecha_nacimiento(Fecha.getDate(String.valueOf(request.getParameter("per_fecha_nacimiento"))));
		}
		
		if(request.getParameter("per_lugarNac")== null || request.getParameter("per_lugarNac").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el ";
		}else{
			persona.getPer_lugar_nacimiento().setMun_codigo(Integer.parseInt(request.getParameter("per_lugarNac")));
			
		}
		if(request.getParameter("per_esc")== null || request.getParameter("per_esc").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el ";
		}else{
			persona.getEstrato().setEst_codigo(Integer.parseInt(request.getParameter("per_estrato")));
		}
		if(request.getParameter("per_email")== null || request.getParameter("per_email").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar el ";
		}else{
			persona.setPer_email(request.getParameter("per_email"));
		}
		if(request.getParameter("per_emailInt")!= null && request.getParameter("per_emailInt").length()>0){
			persona.setPer_email_interno(request.getParameter("per_emailInt"));
		}
//		
		if(request.getParameter("per_barrio")!= null && request.getParameter("per_barrio").length()<=0){
			persona.setPer_barrio(request.getParameter("per_barrio"));
		}
		if(request.getParameter("per_direccion")!= null && request.getParameter("per_direccion").length()<=0){
			persona.setPer_direccion_residencia(request.getParameter("per_direccion"));
		}
		if(request.getParameter("per_telefono_movil")!= null && request.getParameter("per_telefono_movil").length()<=0){
			persona.setPer_telefono_movil(request.getParameter("per_telefono_movil"));
		}
		if(request.getParameter("per_telefono_fijo")!= null && request.getParameter("per_telefono_fijo").length()<=0){
			persona.setPer_telefono_fijo(request.getParameter("per_telefono_fijo"));
		}
		if(request.getParameter("eps_codigo")!= null && request.getParameter("eps_codigo").length()<=0){
			persona.getEps().setEps_codigo(Integer.parseInt(request.getParameter("eps_codigo")));
		}	
		if(request.getParameter("per_numero_afiliacion_eps")!= null && request.getParameter("per_numero_afiliacion_eps").length()<=0){
			persona.getEps().setPer_numero_afiliacion_eps(request.getParameter("per_numero_afiliacion_eps"));
		}
		
		if(request.getParameter("per_libretaMil")!= null && request.getParameter("per_libretaMil").length()<=0){
			persona.setPer_libreta_militar(request.getParameter("per_libretaMil"));
		}
		if(request.getParameter("per_lugarResiFami")!= null && request.getParameter("per_lugarResiFami").length()<=0){
			persona.getFamiliar_lugar_residencia().setMun_codigo(Integer.parseInt(request.getParameter("per_lugarResiFami")));
		}
		if(request.getParameter("per_familiar_nombre")!= null && request.getParameter("per_familiar_nombre").length()<=0){
			persona.setPer_familiar_nombre(request.getParameter("per_familiar_nombre"));
		}
		if(request.getParameter("per_familiar_direccion")!= null && request.getParameter("per_familiar_direccion").length()<=0){
			persona.setPer_familiar_direccion(request.getParameter("per_familiar_direccion"));
		}
		if(request.getParameter("per_familiar_telefono")!= null && request.getParameter("per_familiar_telefono").length()<=0){
			persona.setPer_familiar_telefono(request.getParameter("per_familiar_telefono"));
		}
		if(request.getParameter("nat_codigo")!= null && request.getParameter("nat_codigo").length()<=0){
			persona.getNaturaleza().setNat_codigo(Integer.parseInt(request.getParameter("nat_codigo")));
		}	
		if(request.getParameter("reg_codigo")!= null && request.getParameter("reg_codigo").length()<=0){
			persona.getRegimen().setReg_codigo(Integer.parseInt(request.getParameter("reg_codigo")));
		}	
		if(request.getParameter("per_razon_social")!= null && request.getParameter("per_razon_social").length()<=0){
			persona.setPer_razon_social(request.getParameter("per_razon_social"));
		}
		mensaje.setMsm(msm);
		Object [] retultado={mensaje,persona,update};
		return retultado;
		
	}

	public static Object getLista(Object Obj) {
		db= new PersonaDB();
		return db.getAll(Obj);
	}
	
	public static Object getObject(Object Obj) {
		 db= new PersonaDB();
		return db.getObject(Obj);
	}
	public static Object getListaCaa(Object Obj) {
		 db= new Persona_carrera_administrativaDB();
		return db.getAll(Obj);
	}
	
	/**
	 * @param Obj
	 * @return
	 */
	public static Object getObjectCaa(Object Obj) {
		 db= new Persona_carrera_administrativaDB();
		return db.getObject(Obj);
	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static Object updateObject(HttpServletRequest request) throws  IOException {
		db= new PersonaDB();
		
		
		Mensaje mensaje=  (Mensaje) getvalidaDatosUpdate(request);
		
		Object parametro []= {mensaje.getResultado(),request.getSession().getAttribute("usuario"),2};
		
		if(mensaje.isValido()){
			if(db.esObject(mensaje.getResultado())){
				int resultado=(int)db.setObject(parametro);
				Persona persona= (Persona) mensaje.getResultado();
				if(resultado>=0){
					mensaje.setValido(true);
					mensaje.setMsm("los datos de "+persona.getPer_nombre()+" "+persona.getPer_apellido()+" se ha guardado con exito..");
				}else{
					mensaje.setValido(false);
					mensaje.setMsm("Error los datos personales de "+persona.getPer_nombre()+" "+persona.getPer_apellido()+" no se han guardado ..");
				}
			}else{
				mensaje.setValido(false);
				mensaje.setMsm("no es un pensionado..");
			}
		}
		return mensaje;
		
	}
	/**
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	private static Object getvalidaDatosUpdate(HttpServletRequest request) throws IOException {

		Mensaje mensaje= new Mensaje(true,"",null);
	
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		  } catch (Exception e) {
			  e.printStackTrace();
			  
		  	}

		  ObjectMapper mapper = new ObjectMapper();
		  
		 Pensionado pensionado= mapper.readValue(jb.toString(), Pensionado.class);
		 System.out.println(pensionado);
		if(pensionado.getUaa_personal().getPersona().getPer_codigo()==0){
			mensaje.setMsm(mensaje.getMsm()+"debe seleccionar una persona ");
			mensaje.setValido(false);
		}
		if(pensionado.getUaa_personal().getPersona().getPer_barrio()==null || pensionado.getUaa_personal().getPersona().getPer_barrio().length()<=5) {
			mensaje.setMsm(mensaje.getMsm()+"debe digitar el barrio de recidencia ");
			mensaje.setValido(false);
		}
		if(pensionado.getUaa_personal().getPersona().getPer_direccion_residencia()==null || pensionado.getUaa_personal().getPersona().getPer_direccion_residencia().length()<=5) {
			mensaje.setMsm(mensaje.getMsm()+"debe digitar la dirección de recidencia ");
			mensaje.setValido(false);
		}
		if(pensionado.getUaa_personal().getPersona().getPer_telefono_fijo()==null || pensionado.getUaa_personal().getPersona().getPer_telefono_fijo().length()<=6) {
			mensaje.setMsm(mensaje.getMsm()+"debe digitar el telefono fijo o el digitado no corresponde a un numero telefonico fijo valido. ");
			mensaje.setValido(false);
		}
		if(pensionado.getUaa_personal().getPersona().getPer_telefono_movil()==null || pensionado.getUaa_personal().getPersona().getPer_telefono_movil().length()<=10) {
			mensaje.setMsm(mensaje.getMsm()+"debe digitar el teléfono celular o el digitado no corresponde a un numero telefonico celular valido. ");
			mensaje.setValido(false);
		}
//		if(pensionado.getUaa_personal().getPersona().getPer_email()==null || pensionado.getUaa_personal().getPersona().getPer_email().length()<=3) {
//			mensaje.setMsm(mensaje.getMsm()+"debe seleccionar una persona ");
//			mensaje.setValido(false);
//			
//		}else{
//			Mensaje msm=(Mensaje) seguridad.esCorreo(pensionado.getUaa_personal().getPersona().getPer_email(), "este correo "); 
//			if(!msm.isValido()){
//				mensaje.setMsm(mensaje.getMsm()+"no corresponde a un correo valido ");
//				mensaje.setValido(false);
//			}
//		}
			
		mensaje.setResultado(pensionado.getUaa_personal().getPersona());
		return mensaje;
	}
}
