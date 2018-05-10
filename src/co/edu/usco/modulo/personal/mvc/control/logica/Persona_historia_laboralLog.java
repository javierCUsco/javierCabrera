/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.Persona_historia_laboralDB;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.herramientas.LoadFile;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.PersonaHistoriaLaboral;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.seguridad.seguridad;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Persona_historia_laboralLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new Persona_historia_laboralDB();
		return db.getAll(obj);
	}

	public static Object getElemento(Object obj) {
		// TODO Auto-generated method stub
		conexion db=new Persona_historia_laboralDB();
		return db.getObject(obj);
	}

public static Object newObject(HttpServletRequest request) {
		
		Object param[]=(Object[]) getvalidaDatos(request);
		Mensaje msm=(Mensaje) param[0];
//		JOptionPane.showMessageDialog(null, "1  "+msm.getMsm()+" : "+msm.isValido());
		if(msm.isValido()){
			conexion db= new Persona_historia_laboralDB();
			
			if(request.getParameter("update")!=null && request.getParameter("update").length()>0 ){
				if(request.getParameter("update").equals("1")){
					LoadFile file= new LoadFile();
					PersonaHistoriaLaboral  phl = (PersonaHistoriaLaboral) param[1];
				try {
					
					msm=(Mensaje) file.processRequest(request, phl.getPersona());
					phl.setPersona((Persona) msm.getResultado());
					System.out.println("en el log 1    "+phl.getPersona().getArchivo().getPh_archivo());
					System.out.println("en el log 2    "+phl.getPersona().getArchivo().getPh_archivo_md5());
					param[1]=phl;
					int resultado=Integer.parseInt(String.valueOf(db.setObject(param)));
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
			}else if(request.getParameter("update").equals("2")){
				try {
					PersonaHistoriaLaboral  phl = (PersonaHistoriaLaboral) param[1];
					LoadFile file= new LoadFile();
					if(file.gethayadjunto(request)==true){
//						if(request.getParameter("chkReemplazar") != null){
						
						msm=(Mensaje) file.processRequest(request, phl.getPersona());
						phl.setPersona((Persona) msm.getResultado());
						param[1]=phl;
						phl.getArchivo().setCambio(true);
					}else {
						phl.getArchivo().setCambio(false);
					}
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
			}else{
				msm.setValido(false);
				msm.setMsm("opcion no permitida");
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
		PersonaHistoriaLaboral persona= new PersonaHistoriaLaboral();
		if((request.getParameter("phl_codigo")!= null || request.getParameter("phl_codigo").length()>=0 ) && !request.getParameter("phl_codigo").equalsIgnoreCase("undefined")){
			
			Object obj[]= (Object[])seguridad.esNumero(request.getParameter("phl_codigo"));
			
			if((boolean)obj[0]){
				persona.setPhl_codigo(Integer.parseInt(request.getParameter("phl_codigo")));
				update=1;
			}else{
				mensaje.setValido(false);
				msm=msm+obj[1];	
			}
			
		}
		
		if(request.getParameter("per_codigo")== null || request.getParameter("per_codigo").length()<=0){//JOptionPane.showMessageDialog(null, request.getParameter("per_codigo"));
			mensaje.setValido(false);
			msm=msm+" debe ingresar la persona ";
		}else{
			persona.getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
			
		}
		if(request.getParameter("hlt_codigo")== null || request.getParameter("hlt_codigo").length()<=0){//JOptionPane.showMessageDialog(null, request.getParameter("hlt_codigo"));
			mensaje.setValido(false);
			msm=msm+" debe ingresar el tipo de historia laboral ";
		}else{
			persona.getTipo().setHlt_codigo(Integer.parseInt(request.getParameter("hlt_codigo")));
		}
		
		
		
		
		if(request.getParameter("ded_codigo")== null || request.getParameter("ded_codigo").length()<=0){//JOptionPane.showMessageDialog(null, request.getParameter("ded_codigo"));
			mensaje.setValido(false);
			msm=msm+" debe ingresar la dedicacion en su trabajo";
		}else{
			persona.getDedicacion().setDed_codigo(Integer.parseInt(request.getParameter("ded_codigo")));
		}
		
		if(request.getParameter("vin_codigo")== null || request.getParameter("vin_codigo").length()<=0){//JOptionPane.showMessageDialog(null, request.getParameter("vin_codigo"));
			mensaje.setValido(false);
			msm=msm+" debe ingresar la vinculacion que tenia";
		}else{
			persona.getVinculacion().setVin_codigo(Integer.parseInt(request.getParameter("vin_codigo")));
		}
		
		
		
		if(request.getParameter("mun_codigo")== null || request.getParameter("mun_codigo").length()<=0   ||request.getParameter("mun_codigo").equalsIgnoreCase("undefined")){//JOptionPane.showMessageDialog(null, request.getParameter("mun_codigo"));
			mensaje.setValido(false);
			msm=msm+" debe ingresar el lugar de trabajo  ";
		}else{
			persona.getMunicipio().setMun_codigo(Integer.parseInt(request.getParameter("mun_codigo")));
		}
		

		if(request.getParameter("phl_empresa")== null || request.getParameter("phl_empresa").length()<=0){//JOptionPane.showMessageDialog(null, request.getParameter("phl_empresa"));
			mensaje.setValido(false);
			msm=msm+" debe ingresar el nombre de la empresa ";
		}else{
			persona.setPhl_empresa( request.getParameter("phl_empresa"));
		}
	
		if(request.getParameter("phl_empresa_direccion")== null || request.getParameter("phl_empresa_direccion").length()<=0){//JOptionPane.showMessageDialog(null, request.getParameter("phl_empresa_direccion"));
			mensaje.setValido(false);
			msm=msm+" debe ingresar direccion de la empresa";
		}else{
			persona.setPhl_empresa_direccion(request.getParameter("phl_empresa_direccion"));
		}
		if(request.getParameter("phl_empresa_telefono")== null || request.getParameter("phl_empresa_telefono").length()<=0){//JOptionPane.showMessageDialog(null, request.getParameter("phl_empresa_telefono"));
			mensaje.setValido(false);
			msm=msm+" debe ingresar el telefono de la empresa ";
		}else{
			persona.setPhl_empresa_telefono(request.getParameter("phl_empresa_telefono"));
		}
		if(request.getParameter("phl_descripcion")== null || request.getParameter("phl_descripcion").length()<=0){//JOptionPane.showMessageDialog(null, request.getParameter("phl_descripcion"));
			mensaje.setValido(false);
			msm=msm+" debe ingresar una brebe descripcion de su cargo";
		}else{
			persona.setPhl_descripcion(request.getParameter("phl_descripcion"));
		}
		if(request.getParameter("phl_cargo")== null || request.getParameter("phl_cargo").length()<=0){//JOptionPane.showMessageDialog(null, request.getParameter("phl_cargo"));
			mensaje.setValido(false);
			msm=msm+" debe ingresar el carga que ocupaba";
		}else{
			persona.setPhl_cargo(request.getParameter("phl_cargo"));
		}
		if(request.getParameter("ocupacion_cargo")== null || request.getParameter("ocupacion_cargo").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar sus funciones";
		}else{
			persona.setOcupacion_cargo(request.getParameter("ocupacion_cargo"));
		}
		if(request.getParameter("phl_fecha_inicio")== null || request.getParameter("phl_fecha_inicio").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar la fecha que inicio ";
		}else{
			
			persona.setPhl_fecha_inicio(Fecha.getFecha_date(request.getParameter("phl_fecha_inicio")));
		}
		
		if(request.getParameter("phl_fecha_fin")== null || request.getParameter("phl_fecha_fin").length()<=0){
			mensaje.setValido(false);
			msm=msm+" debe ingresar la fecha en que termino ";
		}else{
//			persona.setPha_fecha_fin(Fecha.getFecha_date(request.getParameter("pha_fecha_fin")));
			persona.setPhl_fecha_fin(Fecha.getFecha_date(request.getParameter("phl_fecha_fin")));
		}
		
		
//		if(request.getParameter("pha_titulo")== null || request.getParameter("pha_titulo").length()<=0){
//			mensaje.setValido(false);
//			msm=msm+" debe ingresar el ";
//		}else{
//			persona.setPha_titulo(request.getParameter("pha_titulo"));
//		}
//		if(request.getParameter("pha_documento")!= null && request.getParameter("pha_documento").length()>0){
//			persona.setPha_documento(request.getParameter("pha_documento"));
//		}
//		
		mensaje.setMsm(msm);
		Object [] retultado={mensaje,persona,update};
		return retultado;
		
	}

	
}
