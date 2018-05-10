/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa;

import javax.servlet.http.HttpServletRequest;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.carreraAdministrativa.Carrera_administrativaDB;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
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
		conexion db = new Carrera_administrativaDB();
		return db.getAll(obj);
	}

	/**
	 * @param request
	 * @return {@link Object}
	 */
	public static Object newObject(HttpServletRequest request) {

		Mensaje msm= new Mensaje();
		msm=validaDatos(request);
		if(msm.isValido()){
			conexion db= new Carrera_administrativaDB();
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
						msm.setMsm(" el usuario con nombre "+caa.getPersona().getPer_nombre()+" "+caa.getPersona().getPer_apellido()+" ha sido registrado con exito\n ");
					}
				}else{
					msm.setValido(false);
					msm.setMsm("Error el usuario con nombre "+caa.getPersona().getPer_nombre()+" "+caa.getPersona().getPer_apellido()+" ya se encuentra registrado\n");
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
						msm.setValido(false);
						msm.setMsm(" el usuario con nombre "+caa.getPersona().getPer_nombre()+" "+caa.getPersona().getPer_apellido()+" ha sido actualizado con exito \n");
					}
				}
				else{
					msm.setValido(false);
					msm.setMsm("Error el usuario con nombre "+caa.getPersona().getPer_nombre()+" "+caa.getPersona().getPer_apellido()+" no encuentra registrado\n");
				}
			}
		}
			return msm;
	}

	private static Mensaje validaDatos(HttpServletRequest request) {
		Mensaje msm = new Mensaje(true,"",null); 
		String fecha_servidor=String.valueOf(FechaLog.getFechaServidor());
		CarreraAdministrativa caa = new CarreraAdministrativa();
		if(request.getParameter("update").equals("2")){
			if (request.getParameter("caa_codigo") == null) {
				msm.setMsm(msm.getMsm()+" ");
				msm.setValido(false);
			}else{
				caa.setCaa_codigo(Integer.parseInt(request.getParameter("caa_codigo")));
			}
		}
		if (request.getParameter("per_codigo") == null) {
			msm.setMsm(msm.getMsm()+" debe seleccionar la persona");
			msm.setValido(false);
		}else{
			caa.getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
			caa.getPersona().setPer_apellido(request.getParameter("per_apellido"));
			caa.getPersona().setPer_nombre(request.getParameter("per_nombre"));
		}
		if (request.getParameter("tip_codigo") == null) {
			msm.setMsm(msm.getMsm()+" debe seleccionar el tipo de proceso ");
			msm.setValido(false);
		}else{
			caa.getTipoPorceso().setTip_codigo(Integer.parseInt(request.getParameter("tip_codigo")));
		}
		if (request.getParameter("caa_acto_adtivo") == null) {
			msm.setMsm(msm.getMsm()+" debe ingresar el acto administrativo ");
			msm.setValido(false);
		}else{
			caa.setCaa_acto_adtivo(request.getParameter("caa_acto_adtivo"));

		}
		
		if (request.getParameter("caa_fecha_acto_adtivo") == null) {
			msm.setMsm(msm.getMsm()+" debe agrregar la fecha del acto administrativo ");
			msm.setValido(false);
		}else{
			Mensaje tem=Fecha.isValido( request.getParameter("caa_fecha_acto_adtivo"),fecha_servidor, "la fecha del acto administrativo no puede ser superior a la fecha actual\n");
			if(tem.isValido()){
				caa.setCaa_fecha_acto_adtivo(Fecha.getDate(String.valueOf(request.getParameter("caa_fecha_acto_adtivo"))));
			}else{
				msm.setMsm(msm.getMsm()+tem.getMsm());
				msm.setValido(tem.isValido());
			}
		}
		
		if (request.getParameter("caa_fecha_convocatoria") == null) {
			msm.setMsm(msm.getMsm()+" debe agregar la fecha de la convocatoria ");
			msm.setValido(false);
		}else{			
			Mensaje tem=Fecha.isValido( request.getParameter("caa_fecha_convocatoria"), fecha_servidor, "la fecha de la convocatoria no puede ser superior a la fecha actual\n");
			if(tem.isValido()){
				 tem=Fecha.isValido(request.getParameter("caa_fecha_acto_adtivo"), request.getParameter("caa_fecha_convocatoria"),  "la fecha del convocatoria no puede ser superior a la fecha del acto adminstrativo\n");
//				JOptionPane.showMessageDialog(null, tem.isValido()+" "+tem.getMsm());
				if(tem.isValido()){
				caa.setCaa_fecha_convocatoria(Fecha.getDate(String.valueOf(request.getParameter("caa_fecha_convocatoria"))));
				}else{
					msm.setMsm(msm.getMsm()+tem.getMsm());
					msm.setValido(tem.isValido());
				}
			}else{
				msm.setMsm(msm.getMsm()+tem.getMsm());
				msm.setValido(tem.isValido());
			}
		}
		//fecha de caa_fecha_resolucion_elegibles
		if (request.getParameter("caa_fecha_resolucion_elegibles") == null) {
			msm.setMsm(msm.getMsm()+" debe agregar la fecha de la resolucion de elegibles ");
			msm.setValido(false);
		}else{
			Mensaje tem=Fecha.isValido( request.getParameter("caa_fecha_resolucion_elegibles"),fecha_servidor, "la fecha del resolucion elegibles no puede ser superior a la fecha actual\n");
			if(tem.isValido()){
				tem=Fecha.isValido(request.getParameter("caa_fecha_acto_adtivo"), request.getParameter("caa_fecha_resolucion_elegibles"), "la fecha del resolucion elegibles no puede ser superior a la fecha de la convocatoria\n");
				if(tem.isValido()){
				
				tem=Fecha.isValido( request.getParameter("caa_fecha_convocatoria"),request.getParameter("caa_fecha_resolucion_elegibles"), "la fecha del resolucion elegibles no puede ser superior a la fecha de la convocatoria\n");
				if(tem.isValido()){
					caa.setCaa_fecha_resolucion_elegibles(Fecha.getDate(String.valueOf(request.getParameter("caa_fecha_resolucion_elegibles"))));
				}else{
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
		//caa_fecha_acta_posesion
		if (request.getParameter("caa_fecha_acta_posesion") == null) {
			msm.setMsm(msm.getMsm()+" debe agregar la fecha del acta de posecion \n");
			msm.setValido(false);
		}else{
			Mensaje tem=Fecha.isValido(request.getParameter("caa_fecha_acta_posesion"),fecha_servidor, "la fecha del acta de posesion no puede ser superior a la fecha actual\n");
			if(tem.isValido()){
				 tem=Fecha.isValido(request.getParameter("caa_fecha_acto_adtivo"), request.getParameter("caa_fecha_acta_posesion"),"la fecha del acta de posesion no puede ser superior a la fecha actual\n");
				if(tem.isValido()){
					tem=Fecha.isValido(request.getParameter("caa_fecha_convocatoria"),request.getParameter("caa_fecha_acta_posesion"), "la fecha del acta de posesion no puede ser superior a la fecha actual\n");
					if(tem.isValido()){
						tem=Fecha.isValido(request.getParameter("caa_fecha_resolucion_elegibles"),request.getParameter("caa_fecha_acta_posesion"), "la fecha del acta de posesion no puede ser superior a la fecha actual\n");
						if(tem.isValido()){
							caa.setCaa_fecha_acta_posesion(Fecha.getDate(String.valueOf(request.getParameter("caa_fecha_acta_posesion"))));
							System.out.println("  caa.setCaa_fecha_acta_posesion(   "+caa.getCaa_fecha_acta_posesion());
						}else{
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
			}else{
				
				msm.setMsm(msm.getMsm()+tem.getMsm());
				msm.setValido(tem.isValido());
			}

		}
		
		
		if (request.getParameter("uac_codigo") == null) {
			msm.setMsm(msm.getMsm()+" debe seleccionar el cargo ");
			msm.setValido(false);
		}else{
			caa.getUaa_cargo().setUac_codigo(Integer.parseInt(request.getParameter("uac_codigo")));
			

		}
		
		if (request.getParameter("caa_resolucion_elegibles") == null) {
			msm.setMsm(msm.getMsm()+"debe agregar la resolucion de elegibles ");
			msm.setValido(false);
		}else{
			caa.setCaa_resolucion_elegibles(request.getParameter("caa_resolucion_elegibles"));

		}

	
		
		if (request.getParameter("caa_numero_convocatoria") == null) {
			msm.setMsm(msm.getMsm()+" debe agregar el numero de la convocatoria ");
			msm.setValido(false);
		}else{
			caa.setCaa_numero_convocatoria(request.getParameter("caa_numero_convocatoria"));

		}

		
		if (request.getParameter("caa_numero_acta_posesion") == null) {
			msm.setMsm(msm.getMsm()+" debe agregar el acta de posecion ");
			msm.setValido(false);
		}else{
			caa.setCaa_numero_acta_posesion(request.getParameter("caa_numero_acta_posesion"));

		}
		if (request.getParameter("caa_fecha_acta_posesion") == null) {
			msm.setMsm(msm.getMsm()+" debe agregar la fecha del acta de posecion \n");
			msm.setValido(false);
		}else{
			Mensaje tem=Fecha.isValido(request.getParameter("caa_fecha_acta_posesion"),fecha_servidor, "la fecha del acta de posesion no puede ser superior a la fecha actual\n");
			if(tem.isValido()){
				caa.setCaa_fecha_acta_posesion(Fecha.getDate(String.valueOf(request.getParameter("caa_fecha_acta_posesion"))));

			}else{
				
				msm.setMsm(msm.getMsm()+tem.getMsm());
				msm.setValido(tem.isValido());
			}

		}
		caa.setCaa_observacion(request.getParameter("caa_observacion"));
//		if (request.getParameter("") != null) {
//			caa.setCaa_numero_convocatoria(request.getParameter(""));
//
//		}
//		if (request.getParameter("") != null) {
//			caa.setCaa_numero_convocatoria(request.getParameter(""));
//
//		}
		msm.setResultado(caa);	
		return msm;
	}

	public static Object getObject(Object param) {
		conexion db = new Carrera_administrativaDB();
		return db.getObject(param);
	}
}
