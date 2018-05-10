/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica.pensionado;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
//import javax.swing.JOptionPane;

import org.codehaus.jackson.map.ObjectMapper;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.pensionado.PensionadoDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.control.logica.FechaLog;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.pensionado.Pensionado;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class PensionadoLog {

	/**
	 * @param request
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public static Object newObject(HttpServletRequest request) throws ServletException, IOException {
		Mensaje mensaje= validaDatos(request);
		if(mensaje.isValido()){
			Pensionado pensionado=(Pensionado) mensaje.getResultado();
			conexion db= new PensionadoDB();
			Object parametro []= {pensionado,request.getSession().getAttribute("usuario"),0};
//			JOptionPane.showMessageDialog(null, request.getParameter("update")+"    "+pensionado.getPen_codigo());
			if(request.getParameter("update").equals("1") && pensionado.getPen_codigo()==0){

				if(db.esObject(parametro)){
					
					int resultado=Integer.parseInt(String.valueOf(db.setObject(parametro)));
					if(resultado==1){
						mensaje.setValido(true);
						mensaje.setMsm("la persona con nombre "+pensionado.getUaa_personal().getPersona().getPer_nombre()+" "+pensionado.getUaa_personal().getPersona().getPer_apellido()+" ha sido registrado con exito\n ");
					}
				}else{
					mensaje.setValido(false);
					mensaje.setMsm(" la persona con nombre "+pensionado.getUaa_personal().getPersona().getPer_nombre()+" "+pensionado.getUaa_personal().getPersona().getPer_apellido()+" ya se encuentra pensionada\n ");
				}
			}else {
				if(!db.esObject(parametro)){
					parametro[2]=1;
					int resultado=Integer.parseInt(String.valueOf(db.setObject(parametro)));
					if(resultado==1){
						mensaje.setValido(true);
						mensaje.setMsm(" el usuario con nombre "+pensionado.getUaa_personal().getPersona().getPer_nombre()+" "+pensionado.getUaa_personal().getPersona().getPer_apellido()+" ha sido actualizado con exito\n ");
					}
				}else{
					mensaje.setValido(false);
					mensaje.setMsm("La persona que va a actualizar en pensionado no esta..");
				}
			}
			
		}
//	System.out.println("mensaje ->  "+mensaje);
		return mensaje;
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	private static Mensaje validaDatos(HttpServletRequest request) throws ServletException, IOException {
		Mensaje msm = new Mensaje(true,"",null); 
		String fecha_servidor=String.valueOf(FechaLog.getFechaServidor());
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
		if(request.getParameter("update").equals("2")){
			if (pensionado.getPen_codigo() == 0) {
				msm.setMsm(msm.getMsm()+" ");
				msm.setValido(false);
			}
		}
		if(pensionado.getUaa_personal().getPersona().getPer_codigo()<=0){
			msm.setMsm(msm.getMsm()+", debe seleccionar a la persona");
			msm.setValido(false);
		}
		if(pensionado.getUaa_personal().getUap_codigo()<=0){
			msm.setMsm(msm.getMsm()+", Debe seleccionar la vinculacion con la universidad");
			msm.setValido(false);
		}
		if(pensionado.getPen_fecha()==null){
			msm.setMsm(msm.getMsm()+", la fecha no puede ser nula");
			msm.setValido(false);
		}
		if(pensionado.getPen_resolucion()==null || pensionado.getPen_resolucion().equals(" ") ){
			msm.setMsm(msm.getMsm()+", la resolución es obligatoria ");
			msm.setValido(false);
		}
		if(pensionado.getPen_tiempo_trabajo()==null || pensionado.getPen_tiempo_trabajo().equals(" ") ){
			msm.setMsm(msm.getMsm()+", el tiempo de trabajo es obligatoria ");
			msm.setValido(false);
		}
		
		if(pensionado.getTipoPension()==null || pensionado.getTipoPension().getTip_pen_codigo()==0 ){
			msm.setMsm(msm.getMsm()+", el tiempo de trabajo es obligatoria ");
			msm.setValido(false);
		}
		msm.setResultado(pensionado);
		return msm;
	}
	/**
	 * 
	 * @param object
	 * @return
	 */
	public static Object getLista(Object object) {
		conexion db= new PensionadoDB();
		return db.getAll(object);
	}
	/**
	 * 
	 * @param object
	 * @return
	 */
	public static Object getObject(Object object) {
		conexion db= new PensionadoDB();
		
		return db.getObject(object);
	}

}
