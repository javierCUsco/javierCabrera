/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.carreraAdministrativa.CarreraAdministrativaActualizacionDB;
import co.edu.usco.modulo.personal.mvc.control.herramientas.ControlIso;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.control.logica.FechaLog;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa.CarreraAdministrativaActualizacion;
import co.edu.usco.modulo.personal.mvc.modelo.pensionado.Pensionado;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class CarreraAdministrativaAtualizacionLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		ConexionDB db = new CarreraAdministrativaActualizacionDB();
		return db.getAll(obj);
	}

	public static Object newObject(HttpServletRequest request)throws ServletException, IOException {

		Mensaje msm= new Mensaje();
		msm=validaDatos(request);
		if(msm.isValido()){
			ConexionDB db= new CarreraAdministrativaActualizacionDB();
			CarreraAdministrativaActualizacion caa=(CarreraAdministrativaActualizacion) msm.getResultado();
			Usuario usuadmin = (Usuario) request.getSession().getAttribute("usuario");
//			System.out.println(msm);
			Object [] param= {msm.getResultado(),usuadmin,0};
			System.out.println(request.getParameter("update"));
			if(request.getParameter("update").equals("1")){
				if(db.esObject(param)){
//					JOptionPane.showMessageDialog(null, caa.getPersona().getPer_codigo());
					param[2]=1;
					param[0]=caa;
					int resultado=Integer.parseInt(String.valueOf(db.setObject(param)));
					if(resultado==1){
						msm.setValido(true);
						msm.setMsm(" A el servidor(a) publico(a) con nombre "+caa.getCaa().getPersona().getNombre()+" "+caa.getCaa().getPersona().getApellido()+" se le ha realizaco una actualizacion en carrera administrativa con exito ");
					}
				}else{
					msm.setValido(false);
					msm.setMsm("Error el servidor(a) publico(a) con nombre "+caa.getCaa().getPersona().getNombre()+" "+caa.getCaa().getPersona().getApellido()+" ya se encuentra registrado");
				}
			}
			if(request.getParameter("update").equals("2")){
				System.out.println(db.esObject(param));
				if(!db.esObject(param)){
					param[2]=2;
//					db.setObject(param);
//					
//					param[2]=1;
					param[0]=caa;
					int resultado=Integer.parseInt(String.valueOf(db.setObject(param)));
					System.out.println(resultado);
					if(resultado==1){
						msm.setValido(true);
						msm.setMsm(" El servidor(a) publico(a) con nombre "+caa.getCaa().getPersona().getNombre()+" "+caa.getCaa().getPersona().getApellido()+" ha sido actualizado con exito ");
					}
				}
				else{
					msm.setValido(false);
					msm.setMsm("Error el servidor(a) publico(a) con nombre "+caa.getCaa().getPersona().getNombre()+" "+caa.getCaa().getPersona().getApellido()+" no encuentra registrado");
				}
			}
		}
			return msm;
	}

	private static Mensaje validaDatos(HttpServletRequest request)throws ServletException, IOException {
		Mensaje msm = new Mensaje(true,"",null,null); 
		String fecha_servidor=String.valueOf(FechaLog.getFechaServidor());
//		CarreraAdministrativaActualizacion caaa = new CarreraAdministrativaActualizacion();
		
		
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
		  
		 CarreraAdministrativaActualizacion caaa= mapper.readValue(jb.toString(), CarreraAdministrativaActualizacion.class);
		 
		 if(request.getParameter("update").equals("2")){
			 if (caaa.getCodigo() == 0) {
					msm.setMsm(msm.getMsm()+"* Para actualizar un dato debe haber seleccionado el registro \n");
					msm.setValido(false);
				}
		 }
		 if (caaa.getCaa().getCodigo() == 0) {
				msm.setMsm(msm.getMsm()+"* Debe estar relacionada a una incripcion  \n");
				msm.setValido(false);
			}
		 if (caaa.getCaa().getPersona() == null) {
				msm.setMsm(msm.getMsm()+"* Debe seleccionar la persona \n");
				msm.setValido(false);
			}
		 if (caaa.getTipoActualizacion() == null) {
				msm.setMsm(msm.getMsm()+"* Debe seleccionar el tipo de proceso  \n");
				msm.setValido(false);
			}
		 
		 if (caaa.getActoAdministrativo() == null) {
				msm.setMsm(msm.getMsm()+"* Debe ingresar el acto administrativo  \n");
				msm.setValido(false);
			}
		 if (caaa.getFechaActoAdministrativo() == null) {
				msm.setMsm(msm.getMsm()+"* Debe agrregar la fecha del acto administrativo  \n");
				msm.setValido(false);
			}else{
//				Mensaje tem=Fecha.isValido( request.getParameter("caaa_fecha_acto_administrativo"), fecha_servidor,"La fecha del acto administrativa no puede ser superior a la fecha atual");
				Mensaje tem=Fecha.getValidaFechas( caaa.getCaa().getFechaActaPosesion(),  caaa.getFechaActoAdministrativo(),"* La fecha del acto administrativa no puede ser superior a la del acta de posesi&oacute;n. \n");
				if(!tem.isValido()) {
					msm.setMsm(msm.getMsm()+tem.getMsm());
					msm.setValido(tem.isValido());
				}else {
				tem=Fecha.getValidaFechas( new Date(fecha_servidor),  caaa.getFechaActoAdministrativo(),"* La fecha del acto administrativa no puede ser superior a la fecha atual. \n");
					if(!tem.isValido()){
						msm.setMsm(msm.getMsm()+tem.getMsm());
						msm.setValido(tem.isValido());
					}
				}
			}
		 if (caaa.getUaaCargo()== null) {
			 	msm.setMsm(msm.getMsm()+"* Debe seleccionar el cargo. \n");
				msm.setValido(false);
			}else if(caaa.getUaaCargo().getCodigo()==0){
				msm.setMsm(msm.getMsm()+"* Debe seleccionar el cargo. \n");
				msm.setValido(false);
			 }
		 

		msm.setResultado(caaa);	
		return msm;
	}

	public static Object getObject(Object param) {
		ConexionDB db = new CarreraAdministrativaActualizacionDB();
		return db.getObject(param);
	}
}
