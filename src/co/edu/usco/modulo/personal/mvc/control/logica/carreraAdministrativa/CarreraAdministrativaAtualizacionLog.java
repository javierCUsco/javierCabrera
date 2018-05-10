/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa;

import javax.servlet.http.HttpServletRequest;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.carreraAdministrativa.CarreraAdministrativaActualizacionDB;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.control.logica.FechaLog;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa.CarreraAdministrativaActualizacion;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class CarreraAdministrativaAtualizacionLog {
	public static Object getLista(Object obj) {
		// TODO Auto-generated method stub
		conexion db = new CarreraAdministrativaActualizacionDB();
		return db.getAll(obj);
	}

	public static Object newObject(HttpServletRequest request) {

		Mensaje msm= new Mensaje();
		msm=validaDatos(request);
		if(msm.isValido()){
			conexion db= new CarreraAdministrativaActualizacionDB();
			CarreraAdministrativaActualizacion caa=(CarreraAdministrativaActualizacion) msm.getResultado();
			Usuario usuadmin = (Usuario) request.getSession().getAttribute("usuario");
			Object [] param= {msm.getResultado(),usuadmin,0};
			
			if(request.getParameter("update").equals("1")){
				if(db.esObject(param)){
//					JOptionPane.showMessageDialog(null, caa.getPersona().getPer_codigo());
					param[2]=1;
					param[0]=caa;
					int resultado=Integer.parseInt(String.valueOf(db.setObject(param)));
					if(resultado==1){
						msm.setValido(true);
						msm.setMsm(" el usuario con nombre "+caa.getCaa().getPersona().getPer_nombre()+" "+caa.getCaa().getPersona().getPer_apellido()+" ha sido registrado con exito ");
					}
				}else{
					msm.setValido(false);
					msm.setMsm("Error el usuario con nombre "+caa.getCaa().getPersona().getPer_nombre()+" "+caa.getCaa().getPersona().getPer_apellido()+" ya se encuentra registrado");
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
					if(resultado==1){
						msm.setValido(true);
						msm.setMsm(" el usuario con nombre "+caa.getCaa().getPersona().getPer_nombre()+" "+caa.getCaa().getPersona().getPer_apellido()+" ha sido actualizado con exito ");
					}
				}
				else{
					msm.setValido(false);
					msm.setMsm("Error el usuario con nombre "+caa.getCaa().getPersona().getPer_nombre()+" "+caa.getCaa().getPersona().getPer_apellido()+" no encuentra registrado");
				}
			}
		}
			return msm;
	}

	private static Mensaje validaDatos(HttpServletRequest request) {
		Mensaje msm = new Mensaje(true,"",null); 
		String fecha_servidor=String.valueOf(FechaLog.getFechaServidor());
		CarreraAdministrativaActualizacion caaa = new CarreraAdministrativaActualizacion();
		if(request.getParameter("update").equals("2")){
			if (request.getParameter("caaa_codigo") == null) {
				msm.setMsm(msm.getMsm()+" ");
				msm.setValido(false);
			}else{
				caaa.setCaaa_codigo(Integer.parseInt(request.getParameter("caaa_codigo")));
			}
		}

			if (request.getParameter("caa_codigo") == null) {
				msm.setMsm(msm.getMsm()+" ");
				msm.setValido(false);
			}else{
				caaa.getCaa().setCaa_codigo(Integer.parseInt(request.getParameter("caa_codigo")));
			}

		if (request.getParameter("per_codigo") == null) {
			msm.setMsm(msm.getMsm()+" debe seleccionar la persona");
			msm.setValido(false);
		}else{
			caaa.getCaa().getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
			caaa.getCaa().getPersona().setPer_apellido(request.getParameter("per_apellido"));
			caaa.getCaa().getPersona().setPer_nombre(request.getParameter("per_nombre"));
		}
		if (request.getParameter("tia_codigo") == null) {
			msm.setMsm(msm.getMsm()+" debe seleccionar el tipo de proceso ");
			msm.setValido(false);
		}else{
			caaa.getTipoActualizacion().setTia_codigo(Integer.parseInt(request.getParameter("tia_codigo")));
		}
		if (request.getParameter("caaa_acto_administrativo") == null) {
			msm.setMsm(msm.getMsm()+" debe ingresar el acto administrativo ");
			msm.setValido(false);
		}else{
			caaa.setCaaa_acto_administrativo(request.getParameter("caaa_acto_administrativo"));

		}
		if (request.getParameter("caaa_fecha_acto_administrativo") == null) {
			msm.setMsm(msm.getMsm()+" debe agrregar la fecha del acto administrativo ");
			msm.setValido(false);
		}else{
			
			Mensaje tem=Fecha.isValido( request.getParameter("caaa_fecha_acto_administrativo"), fecha_servidor,"La fecha del acto administrativa no puede ser superior a la fecha atual");
			if(tem.isValido()){
				caaa.setCaaa_fecha_acto_administrativo(Fecha.getDate(request.getParameter("caaa_fecha_acto_administrativo")));
			}else{
				msm.setMsm(msm.getMsm()+tem.getMsm());
				msm.setValido(tem.isValido());
			}
		}
		if (request.getParameter("uac_codigo") == null) {
			msm.setMsm(msm.getMsm()+" debe seleccionar el cargo ");
			msm.setValido(false);
		}else{
			caaa.getCaa().getUaa_cargo().setUac_codigo(Integer.parseInt(request.getParameter("uac_codigo")));

		}
		caaa.setCaaa_observacion(request.getParameter("caaa_observacion"));
//		
//		if (request.getParameter("caa_resolucion_elegibles") == null) {
//			msm.setMsm(msm.getMsm()+"debe agregar la resolucion de elegibles ");
//			msm.setValido(false);
//		}else{
//			caa.setCaa_resolucion_elegibles(request.getParameter("caa_resolucion_elegibles"));
//
//		}
//
//		if (request.getParameter("caa_fecha_resolucion_elegibles") == null) {
//			msm.setMsm(msm.getMsm()+" debe agregar la fecha de la resolucion de elegibles ");
//			msm.setValido(false);
//		}else{
//			caa.setCaa_fecha_resolucion_elegibles(request.getParameter("caa_fecha_resolucion_elegibles"));
//
//		}
//		
//		if (request.getParameter("caa_numero_convocatoria") == null) {
//			msm.setMsm(msm.getMsm()+" debe agregar el numero de la convocatoria ");
//			msm.setValido(false);
//		}else{
//			caa.setCaa_numero_convocatoria(request.getParameter("caa_numero_convocatoria"));
//
//		}
//
//		if (request.getParameter("caa_fecha_convocatoria") == null) {
//			msm.setMsm(msm.getMsm()+" debe agregar la fecha de la convocatoria ");
//			msm.setValido(false);
//		}else{
//			caa.setCaa_fecha_convocatoria(request.getParameter("caa_fecha_convocatoria"));
//
//		}
//		if (request.getParameter("caa_numero_acta_posesion") == null) {
//			msm.setMsm(msm.getMsm()+" debe agregar el acta de posecion ");
//			msm.setValido(false);
//		}else{
//			caa.setCaa_numero_acta_posesion(request.getParameter("caa_numero_acta_posesion"));
//
//		}
//		if (request.getParameter("caa_fecha_acta_posesion") == null) {
//			msm.setMsm(msm.getMsm()+" debe agregar la fecha del acta de posecion ");
//			msm.setValido(false);
//		}else{
//			caa.setCaa_fecha_acta_posesion(request.getParameter("caa_fecha_acta_posesion"));
//
//		}

		msm.setResultado(caaa);	
		return msm;
	}

	public static Object getObject(Object param) {
		conexion db = new CarreraAdministrativaActualizacionDB();
		return db.getObject(param);
	}
}
