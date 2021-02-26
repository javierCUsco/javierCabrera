/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.carreraAdministrativa.CarreraAdministrativaDB;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.control.logica.FechaLog;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa.CarreraAdministrativa;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class CarreraAdministrativaLog {
	/**
	 * @param obj
	 * @return {@link Object}
	 */
	public static Object getLista(Object obj) {
		ConexionDB db = new CarreraAdministrativaDB();
		return db.getAll(obj);
	}

	/**
	 * @param request
	 * @return {@link Object}
	 */
	public static Object newObject(HttpServletRequest request)throws ServletException, IOException {

		Mensaje msm= new Mensaje();
		msm=validaDatos(request);
		if(msm.isValido()){
			ConexionDB db= new CarreraAdministrativaDB();
			Usuario usuadmin = (Usuario) request.getSession().getAttribute("usuario");
			CarreraAdministrativa caa=(CarreraAdministrativa) msm.getResultado();
			Object [] param= {msm.getResultado(),usuadmin,0};
			
			if(request.getParameter("update").equals("1")){
				if(db.esObject(param)){
//					JOptionPane.showMessageDialog(null, caa.getPersona().getPer_codigo());
					param[2]=1;
					param[0]=caa;
					int resultado=Integer.parseInt(String.valueOf(db.setObject(param)));
					if(resultado==1){
						msm.setValido(false);
						msm.setMsm(" El servidor(a) p&uacute;blico(a) "+caa.getPersona().getNombre()+" "+caa.getPersona().getApellido()+" se ha inscrito exitosamente \n ");
					}
				}else{
					msm.setValido(false);
					msm.setMsm("Error el servidor(a) p&uacute;blico(a) "+caa.getPersona().getNombre()+" "+caa.getPersona().getApellido()+" ya se encuentra inscrito \n");
				}
			}
			if(request.getParameter("update").equals("2")){
				if(!db.esObject(param)){
					param[2]=2;
//					db.setObject(param);
//					
//					param[2]=1;
					param[0]=caa;
					int resultado=Integer.parseInt(String.valueOf(db.setObject(param)));
					System.out.println(resultado);
					if(resultado==1){
						msm.setValido(false);
						msm.setMsm(" El servidor(a) p&uacute;blico(a) "+caa.getPersona().getNombre()+" "+caa.getPersona().getApellido()+" ha sido actualizado inscripción exitosamente \n");
					}
				}
				else{
					msm.setValido(false);
					msm.setMsm("Error el servidor(a) p&uacute;blico(a) "+caa.getPersona().getNombre()+" "+caa.getPersona().getApellido()+" no encuentra inscrito \n");
				}
			}
		}
			return msm;
	}


	private static Mensaje validaDatos(HttpServletRequest request) throws ServletException, IOException  {
		Mensaje msm = new Mensaje(true,"",null,null); 
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
		  
		  CarreraAdministrativa caa= mapper.readValue(jb.toString(), CarreraAdministrativa.class);
		  
		  System.out.println(" --> "+caa);
		  
		  if(request.getParameter("update").equals("2")){
				if (caa.getCodigo() == 0) {
					msm.setMsm(msm.getMsm()+"* Para modificar un registro primero debe seleccionarlo \n ");
					msm.setValido(false);
				}
			}
		  
		  if (caa.getPersona() == null || caa.getPersona().getCodigo()==0 ) {
				msm.setMsm(msm.getMsm()+"* Debe seleccionar la persona \n");
				msm.setValido(false);
			}
		  if (caa.getTipoProceso() == null || caa.getTipoProceso().getCodigo()==0) {
				msm.setMsm(msm.getMsm()+"* Debe seleccionar el tipo de proceso \n");
				msm.setValido(false);
			}
		  if (caa.getActoAdtivo() == null) {
				msm.setMsm(msm.getMsm()+"* Debe ingresar el acto administrativo \n");
				msm.setValido(false);
			}
		 
		  if (caa.getFechaActoAdtivo() == null) {
				msm.setMsm(msm.getMsm()+"* Debe agregar la fecha del acto administrativo \n");
				msm.setValido(false);
			}else{
				Mensaje tem=Fecha.getValidaFechas(caa.getFechaActoAdtivo(),new Date("1968/12/17"), "* La fecha del acto administrativo no puede ser inferior a la fecha de la creaci&oacute;n el Instituto T&eacute;cnico Universitario Surcolombiano \n");
				if(!tem.isValido()){
					msm.setMsm(msm.getMsm()+tem.getMsm());
					msm.setValido(tem.isValido());
				}else {
				 tem=Fecha.getValidaFechas(new Date(fecha_servidor),caa.getFechaActoAdtivo(), "* La fecha del acto administrativo no puede ser superior a la fecha actual \n");
					if(!tem.isValido()){
						msm.setMsm(msm.getMsm()+tem.getMsm());
						msm.setValido(tem.isValido());
					}
				}
			}
		  
		  if (caa.getUaaCargo() == null) {
				msm.setMsm(msm.getMsm()+"* Debe seleccionar el cargo \n");
				msm.setValido(false);
			}
		 
		  if(caa.getTipoProceso().getCodigo()==1){ //si es Proceso Selección adelantado por la Universidad Surcolombiana se solicita todo
				if (caa.getFechaConvocatoria() == null ) {
					msm.setMsm(msm.getMsm()+"* Debe agregar la fecha de la convocatoria \n");
					msm.setValido(false);
				}else{	
					Mensaje tem=Fecha.getValidaFechas(caa.getFechaConvocatoria(),new Date("1968/12/17"), "* La fecha del convocatoria no puede ser inferior a la fecha de la creaci&oacute;n el Instituto T&eacute;cnico Universitario Surcolombiano \n");
					if(!tem.isValido()){
						msm.setMsm(msm.getMsm()+tem.getMsm());
						msm.setValido(tem.isValido());
					}else {
					 tem=Fecha.isValido( request.getParameter("caa_fecha_convocatoria"), fecha_servidor, "* La fecha de la convocatoria no puede ser superior a la fecha actual \n");
					if(!tem.isValido()){
						msm.setMsm(msm.getMsm()+tem.getMsm());
						msm.setValido(tem.isValido());
					}
				}
				}
				//fecha de caa_fecha_resolucion_elegibles
				if (caa.getFechaResolucionElegibles()== null) {
					msm.setMsm(msm.getMsm()+"* Debe agregar la fecha de la resoluci&oacute;n de elegibles \n");
					msm.setValido(false);
				}else{
					
					Mensaje tem=Fecha.isValido( request.getParameter("caa_fecha_resolucion_elegibles"),fecha_servidor, "* La fecha del resoluci&oacute;n elegibles no puede ser superior a la fecha actual \n");
					if(tem.isValido()){
						tem=Fecha.isValido( request.getParameter("caa_fecha_convocatoria"),request.getParameter("caa_fecha_resolucion_elegibles"), "* La fecha del resoluci&oacute;n elegibles no puede ser superior a la fecha de la convocatoria \n");
						if(!tem.isValido()){
							msm.setMsm(msm.getMsm()+tem.getMsm());
							msm.setValido(tem.isValido());
						}				
					}else{
						msm.setMsm(msm.getMsm()+tem.getMsm());
						msm.setValido(tem.isValido());
					}
				}
				//caa_fecha_acta_posesion
				if (caa.getFechaActaPosesion()== null) {
					msm.setMsm(msm.getMsm()+"* Debe agregar la fecha del acta de posesi&oacute;n \n");
					msm.setValido(false);
				}else{
					Mensaje tem=Fecha.isValido(request.getParameter("caa_fecha_acta_posesion"),fecha_servidor, "* La fecha del acta de posesi&oacute;n no puede ser superior a la fecha actual \n");
					if(tem.isValido()){
							tem=Fecha.isValido(request.getParameter("caa_fecha_convocatoria"),request.getParameter("caa_fecha_acta_posesion"), "* La fecha del acta de posesi&oacute;n no puede ser superior a la fecha actual \n");
							if(tem.isValido()){
								tem=Fecha.isValido(request.getParameter("caa_fecha_resolucion_elegibles"),request.getParameter("caa_fecha_acta_posesion"), "* La fecha del acta de posesi&oacute;n no puede ser superior a la fecha actual \n");
								if(tem.isValido()){
									msm.setMsm(msm.getMsm()+tem.getMsm());
									msm.setValido(tem.isValido());
								}
							}else{
								msm.setMsm(msm.getMsm()+tem.getMsm());
								msm.setValido(tem.isValido());
							}
//						}else{
//							msm.setMsm(msm.getMsm()+tem.getMsm());
//							msm.setValido(tem.isValido());
//						}
					}else{
						
						msm.setMsm(msm.getMsm()+tem.getMsm());
						msm.setValido(tem.isValido());
					}

				}
				if (request.getParameter("caa_fecha_acto_adtivo") == null) {
					
					System.out.println(request.getParameter("caa_fecha_acto_adtivo"));
					msm.setMsm(msm.getMsm()+"* Debe agregar la fecha del acto administrativo \n");
					msm.setValido(false);
				
				}
				else{
					Mensaje tem=Fecha.isValido( request.getParameter("caa_fecha_acto_adtivo"),fecha_servidor, "* La fecha del acto administrativo no puede ser superior a la fecha actual \n");
					if(tem.isValido()){
						
						
						tem=Fecha.isValido(request.getParameter("caa_fecha_convocatoria"),request.getParameter("caa_fecha_acto_adtivo"), "* La fecha del acta de posesi&oacute;n no puede ser superior a la fecha actual \n");
						if(tem.isValido()){
							tem=Fecha.isValido(request.getParameter("caa_fecha_resolucion_elegibles"),request.getParameter("caa_fecha_acto_adtivo"), "La fecha del acta de posesi&oacute;n no puede ser superior a la fecha actual \n");
							if(tem.isValido()){
								msm.setMsm(msm.getMsm()+tem.getMsm());
								msm.setValido(tem.isValido());
							}
						}else{
							msm.setMsm(msm.getMsm()+tem.getMsm());
							msm.setValido(tem.isValido());
						}
						
						
						
						
					}else{
						msm.setMsm(msm.getMsm()+tem.getMsm());
						msm.setValido(tem.isValido());
					}
				}
				
				
				
				
				if (caa.getResolucionElegibles() == null) {
					msm.setMsm(msm.getMsm()+"* Debe agregar la resoluci&oacute;n de elegibles \n");
					msm.setValido(false);
				}

			
				
				if (caa.getNumeroConvocatoria()== null) {
					msm.setMsm(msm.getMsm()+"* Debe agregar el n&uacute;mero de la convocatoria \n");
					msm.setValido(false);
				}

				
				if (caa.getNumeroActaPosesion() == null) {
					msm.setMsm(msm.getMsm()+"* Debe agregar el acta de posesi&oacute;n \n");
					msm.setValido(false);
				}
				if (caa.getFechaActaPosesion() == null) {
					msm.setMsm(msm.getMsm()+"* Debe agregar la fecha del acta de posesi&oacute;n \n");
					msm.setValido(false);
				}else{
					Mensaje tem=Fecha.isValido(request.getParameter("caa_fecha_acta_posesion."),fecha_servidor, "* La fecha del acta de posesi&oacute;n no puede ser superior a la fecha actual \n");
					if(tem.isValido()){
						msm.setMsm(msm.getMsm()+tem.getMsm());
						msm.setValido(tem.isValido());
					}

				}
				}
		  
		  
		  
		  
		  
		 
		msm.setMsm(msm.getMsm());
		msm.setResultado(caa);	
		return msm;
	}

	public static Object getObject(Object param) {
		ConexionDB db = new CarreraAdministrativaDB();
		return db.getObject(param);
	}
}
